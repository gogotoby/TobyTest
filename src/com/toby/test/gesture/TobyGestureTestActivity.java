package com.toby.test.gesture;

import com.toby.test.R;
import com.toby.test.gesture.TobyGestureFilter.TobyGestureListener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

public class TobyGestureTestActivity extends Activity implements TobyGestureListener {

	private TobyGestureFilter mDetector;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_gesture);

		mDetector = new TobyGestureFilter(this, this);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		mDetector.onTouchEvent(ev);
		return super.dispatchTouchEvent(ev);
	}

	@Override
	public void onSwipe(int direction) {
		String str = "";

		switch (direction) {
		case SimpleGestureFilter.SWIPE_RIGHT:
			str = "Swipe Right";
			break;
		case SimpleGestureFilter.SWIPE_LEFT:
			str = "Swipe Left";
			break;
		case SimpleGestureFilter.SWIPE_DOWN:
			str = "Swipe Down";
			break;
		case SimpleGestureFilter.SWIPE_UP:
			str = "Swipe Up";
			break;

		}
		
//		Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
		Log.i("TobyTest", "TobyGestureTestActivity/ onSwipe(): " + str);
	}

	@Override
	public void onDoubleTap() {
//		Toast.makeText(this, "Double Tap", Toast.LENGTH_SHORT).show();
		Log.i("TobyTest", "TobyGestureTestActivity/ onDoubleTap()");
	}
}
