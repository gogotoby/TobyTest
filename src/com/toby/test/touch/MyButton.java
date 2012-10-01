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
	public boolean onTouchEvent(MotionEvent event) {
		Log.e("TobyTest", "MyButton/ onTouchEvent() " + Utils.getTouchStatus(event));
		boolean superReturn = super.onTouchEvent(event);
		Log.e("TobyTest", "MyButton/ onTouchEvent() super return: " + superReturn);
		return superReturn;
	}

}
