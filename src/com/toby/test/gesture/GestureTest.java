/**
 * 
 * http://android-journey.blogspot.tw/2010/01/android-gestures.html
 * 
 */
package com.toby.test.gesture;

import com.toby.test.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

public class GestureTest extends Activity implements OnGestureListener, OnDoubleTapListener {

	private GestureDetector mDetector;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gesture);

		mDetector = new GestureDetector(this, this);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
//		 分析 motion event 並觸發適當的 callbacks on the
//		GestureDetector.OnGestureListener supplied.
		mDetector.onTouchEvent(event);
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onDown(MotionEvent e) { // Simply when there is an ACTION_DOWN event.
//		Log.i("TobyTest", "GestureTest/ OnGestureListener # onDown() " + e.toString());
		Log.i("TobyTest", "GestureTest/ OnGestureListener # onDown()");
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		// Fling gesture occurs when there is an ACTION_DOWN then some
		// ACTION_MOVE events and finally an ACTION_UP, but they must take place
		// with a specified movement and velocity pattern to be considered as a
		// fling gesture. For example if you put your finger on the screen and
		// start moving it slowly and then remove your finger gently it won’t be
		// count as a fling gesture.
//		Log.i("TobyTest", "GestureTest/ OnGestureListener # onFling() " + e1.toString() + e2.toString());
		Log.i("TobyTest", "GestureTest/ OnGestureListener # onFling()");
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// if we touch the screen and don’t remove our finger for a specified
		// amount of time onLongPress() method is called and in most cases there
		// will be no further event callback regardless of whatever we do after
		// that, moving or removing our finger.
//		Log.i("TobyTest", "GestureTest/ OnGestureListener # onLongPress() " + e.toString());
		Log.i("TobyTest", "GestureTest/ OnGestureListener # onLongPress()");
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
		// Called when there is a ACTION_MOVE event
//		Log.i("TobyTest", "GestureTest/ OnGestureListener # onScroll() " + e1.toString() + e2.toString());
		Log.i("TobyTest", "GestureTest/ OnGestureListener # onScroll()");
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// Called after onDown() and before any other callback method, I found
		// out it sometimes might not get called for example
		// when you tap on the screen so fast, but it's actually what this method all about,
		// to make a distinction between a possible unintentional touch and an
		// intentional one.
//		Log.i("TobyTest", "GestureTest/ OnGestureListener # onShowPress() " + e.toString());
		Log.i("TobyTest", "GestureTest/ OnGestureListener # onShowPress()");
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// Called when there is a Tap Gesture. Tap Gesture happens when an
		// ACTION_DOWN event followed by an ACTION_UP event(like a Single-Click).
//		Log.i("TobyTest", "GestureTest/ OnGestureListener # onSingleTapUp() " + e.toString());
		Log.i("TobyTest", "GestureTest/ OnGestureListener # onSingleTapUp()");
		return false;
	}

	@Override
	public boolean onDoubleTap(MotionEvent e) {
		// Called when there is two consecutive Tap gesture(like a Double-Click).
//		Log.i("TobyTest", "GestureTest/ OnGestureListener # onDoubleTap() " + e.toString());
		Log.i("TobyTest", "GestureTest/ OnGestureListener # onDoubleTap()");
		return false;
	}

	@Override
	public boolean onDoubleTapEvent(MotionEvent e) {
		// If there is an ACTION_MOVE event between first tap and second tap of
		// a doubleTap gesture it will be handled by calling onDoubleTapEvent()
		// instead of onScroll() method. onDoubleTapEvent() receives all
		// ACTION_UP events of a doubleTap gesture as well.
//		Log.i("TobyTest", "GestureTest/ OnGestureListener # onDoubleTapEvent() " + e.toString());
		Log.i("TobyTest", "GestureTest/ OnGestureListener # onDoubleTapEvent()");
		return false;
	}

	@Override
	public boolean onSingleTapConfirmed(MotionEvent e) {
		// Similar to onSingleTapUp() but it is only get called when the
		// detected tap gesture is definitely a single Tap and not part of a
		// double tap gesture.
//		Log.i("TobyTest", "GestureTest/ OnGestureListener # onSingleTapConfirmed() " + e.toString());
		Log.i("TobyTest", "GestureTest/ OnGestureListener # onSingleTapConfirmed()");
		return false;
	}
}
