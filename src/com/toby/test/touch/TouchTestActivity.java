/**
 * 
 * 參考 http://blog.csdn.net/android_tutor/article/details/7193090
 * 
 */
package com.toby.test.touch;

import com.toby.test.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class TouchTestActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.touch_test);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		Log.i("TobyTest", "----- Activity # dispatchTouchEvent() start -----");
		Log.i("TobyTest", "TouchTestActivity/ dispatchTouchEvent() " + Utils.getTouchStatus(ev));
		boolean superReturn = super.dispatchTouchEvent(ev);
		Log.i("TobyTest", "TouchTestActivity/ dispatchTouchEvent() super return: " + superReturn);
		Log.i("TobyTest", "----- Activity # dispatchTouchEvent() end -----");
		Log.i("TobyTest", " ");
		return superReturn;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.i("TobyTest", "TouchTestActivity/ onTouchEvent() " + Utils.getTouchStatus(event));
		boolean superReturn = super.onTouchEvent(event);
		Log.i("TobyTest", "TouchTestActivity/ onTouchEvent() super return: " + superReturn);
		return superReturn;
	}

}
