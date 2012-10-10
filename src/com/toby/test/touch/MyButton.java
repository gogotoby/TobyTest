package com.toby.test.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

public class MyButton extends Button {

	public MyButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		Log.e("TobyTest", "----- MyButton # dispatchTouchEvent() start -----");
		Log.e("TobyTest", "MyButton/ dispatchTouchEvent() " + Utils.getTouchStatus(event));
		boolean superReturn = super.dispatchTouchEvent(event);
		Log.e("TobyTest", "MyButton/ dispatchTouchEvent() super return: " + superReturn);
		Log.e("TobyTest", "----- MyButton # dispatchTouchEvent() end -----");
		return superReturn;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.e("TobyTest", "MyButton/ onTouchEvent() " + Utils.getTouchStatus(event));
		boolean superReturn = super.onTouchEvent(event);
		Log.e("TobyTest", "MyButton/ onTouchEvent() super return: " + superReturn);
		return superReturn;
	}

}
