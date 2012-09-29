/**
 * 
 * http://www.linuxidc.com/Linux/2011-09/43135.htm
 * 
 */
package com.toby.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

public class TwoDimScrollTest extends Activity implements OnTouchListener {

	private ScrollView mVsv;
	private HorizontalScrollView mHsv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 進入此 activity 才設成全螢幕
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
//		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.two_dim_scroll);

		mVsv = (ScrollView) findViewById(R.id.vsv);
		mHsv = (HorizontalScrollView) findViewById(R.id.hsv);

		mVsv.setOnTouchListener(this);
		mHsv.setOnTouchListener(this);
	}

	public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_MOVE) {
			int x = (int) event.getX();
			int y = (int) event.getY();

			Log.d("TobyTest", "Coordinates = (" + x + ", " + y + ")");
		}
		return false;
	}

}
