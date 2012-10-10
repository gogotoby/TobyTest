package com.toby.test.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class MyFrameLayout extends FrameLayout {

	public MyFrameLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		Log.d("TobyTest", "----- MyFrameLayout # dispatchTouchEvent() start -----");
		Log.d("TobyTest", "MyFrameLayout/ dispatchTouchEvent() " + Utils.getTouchStatus(ev));
		boolean superReturn = super.dispatchTouchEvent(ev);
		Log.d("TobyTest", "MyFrameLayout/ dispatchTouchEvent() super return: " + superReturn);
		Log.d("TobyTest", "----- MyFrameLayout # dispatchTouchEvent() end -----");
		return superReturn;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		Log.d("TobyTest", "MyFrameLayout/ onInterceptTouchEvent() " + Utils.getTouchStatus(ev));
		boolean superReturn = super.onInterceptTouchEvent(ev);
		Log.d("TobyTest", "MyFrameLayout/ onInterceptTouchEvent() super return: " + superReturn);
		return superReturn;
	}

	// onInterceptTouchEvent 返回 true 或使用者 touch MyLayout 的區域沒有子view 時就會調用
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.d("TobyTest", "MyFrameLayout/ onTouchEvent() " + Utils.getTouchStatus(event));
		boolean superReturn = super.onTouchEvent(event);
		Log.d("TobyTest", "MyFrameLayout/ onTouchEvent() super return: " + superReturn);
		return superReturn;
	}

}
