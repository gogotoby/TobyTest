package com.toby.test.gesture;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class SimpleGestureFilter extends SimpleOnGestureListener {
	
	public final static int SWIPE_UP = 1;
	public final static int SWIPE_DOWN = 2;
	public final static int SWIPE_LEFT = 3;
	public final static int SWIPE_RIGHT = 4;

	public final static int MODE_TRANSPARENT = 0; // Like when we have a GestureOverlayView as parent: all views will receive Touch events;
	public final static int MODE_SOLID = 1; // Like when we put a GestureOverlayView as a child view: no one will receive TouchEvent, it is not as efficient as GestureOverlayView is, since we actually let all events get passed but what we do is we literally kill them when they are passing through our filter.
	public final static int MODE_DYNAMIC = 2; // Distinguish between a swipe/double tap gesture and a movement which is neither of them. so if you have a view full of buttons and other interactive stuff and user does a swipe or double tap gesture, it is guaranteed (although i believe there is no such thing as guarantee in life ;) ) that no other event callback will be called but only onSwipe() or onDoubleTap().

	private final static int ACTION_FAKE = -13; // Just an unlikely number
	private int swipe_Min_Distance = 100;
	private int swipe_Max_Distance = 350;
	private int swipe_Min_Velocity = 100;

	private int mMode = MODE_DYNAMIC;
	private boolean mRunning = true;
	private boolean tapIndicator = false;

	private Activity mContext;
	private GestureDetector mDetector;
	private SimpleGestureListener mListener;

	public SimpleGestureFilter(Activity context, SimpleGestureListener sgl) {
		mContext = context;
		mDetector = new GestureDetector(context, this);
		mListener = sgl;
	}

	// 自訂的 onTouchEvent()
	public void onTouchEvent(MotionEvent event) {
		if (!mRunning) {
			return;
		}

		boolean result = mDetector.onTouchEvent(event);

		if (mMode == MODE_SOLID) {
			event.setAction(MotionEvent.ACTION_CANCEL);
		} else if (mMode == MODE_DYNAMIC) {
			if (event.getAction() == ACTION_FAKE) {
				event.setAction(MotionEvent.ACTION_UP);
			} else if (result) {
				event.setAction(MotionEvent.ACTION_CANCEL);
			} else if (this.tapIndicator) {
				event.setAction(MotionEvent.ACTION_DOWN);
				this.tapIndicator = false;
			}

		}
		// else just do nothing, it's Transparent
	}

	public void setMode(int m) {
		mMode = m;
	}

	public int getMode() {
		return mMode;
	}

	public void setEnabled(boolean status) {
		mRunning = status;
	}

	public void setSwipeMaxDistance(int distance) {
		swipe_Max_Distance = distance;
	}

	public void setSwipeMinDistance(int distance) {
		swipe_Min_Distance = distance;
	}

	public void setSwipeMinVelocity(int distance) {
		swipe_Min_Velocity = distance;
	}

	public int getSwipeMaxDistance() {
		return swipe_Max_Distance;
	}

	public int getSwipeMinDistance() {
		return swipe_Min_Distance;
	}

	public int getSwipeMinVelocity() {
		return swipe_Min_Velocity;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		// Don't accept the fling if it's too short as it may conflict with a
		// button push ?

		final float xDistance = Math.abs(e1.getX() - e2.getX());
		final float yDistance = Math.abs(e1.getY() - e2.getY());

		if (xDistance > swipe_Max_Distance || yDistance > swipe_Max_Distance) {
			return false;
		}

		velocityX = Math.abs(velocityX);
		velocityY = Math.abs(velocityY);
		boolean result = false;

		if (velocityX > swipe_Min_Velocity && xDistance > swipe_Min_Distance) {
			if (e1.getX() > e2.getX()) { // Right to Left
				mListener.onSwipe(SWIPE_LEFT);
			} else {
				mListener.onSwipe(SWIPE_RIGHT);
			}
			result = true;
		} else if (velocityY > swipe_Min_Velocity && yDistance > swipe_Min_Distance) {
			if (e1.getY() > e2.getY()) { // Bottom to Up
				mListener.onSwipe(SWIPE_UP);
			} else {
				mListener.onSwipe(SWIPE_DOWN);
			}
			result = true;
		}

		return result;
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		this.tapIndicator = true;
		return false;
	}

	@Override
	public boolean onDoubleTap(MotionEvent e) {
		mListener.onDoubleTap();
		return true;
	}

	@Override
	public boolean onDoubleTapEvent(MotionEvent e) {
		return true;
	}

	@Override
	public boolean onSingleTapConfirmed(MotionEvent e) {
		if (mMode == MODE_DYNAMIC) { // We owe an ACTION_UP, so we fake an
			e.setAction(ACTION_FAKE); // action which will be converted to an ACTION_UP later.
			mContext.dispatchTouchEvent(e);
		}

		return false;
	}

	static interface SimpleGestureListener {
		void onSwipe(int direction);
		void onDoubleTap();
	}
}
