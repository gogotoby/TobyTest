package com.toby.test.scroll;

import com.toby.test.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HorizontalScrollTest2 extends Activity {

	private HorizontalScrollView mHsv;
	private LinearLayout mHsvChild;

	private int mCurrentX;
//	private int mCurrentY;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.horizontal_scroll_2);

		mHsv = (HorizontalScrollView) findViewById(R.id.hsv2);
		mHsvChild = (LinearLayout) findViewById(R.id.hsv2_child);

		String[] hours = getResources().getStringArray(R.array.hours);
		TextView tv;
		for (int i = 0; i < hours.length; i++) {
			tv = new TextView(this);
			tv.setText(hours[i]);
			mHsvChild.addView(tv);
		}
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		onTouchEvent(ev);
		// return super.dispatchTouchEvent(ev);
		return true; // 這樣才能真正看到 mHsv.scrollBy(mCurrentX - x2, 0); 效果
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN: {
			mCurrentX = (int) event.getRawX();
//			mCurrentY = (int) event.getRawY();
			break;
		}
		case MotionEvent.ACTION_MOVE: {
			int x2 = (int) event.getRawX();
//			int y2 = (int) event.getRawY();

			mHsv.scrollBy(mCurrentX - x2, 0);
//			mHsv.smoothScrollBy(mCurrentX - x2, 0);
			Log.d("TobyTest", "HorizontalScrollTest2/ mHsv.scrollBy: " + (mCurrentX - x2));

			mCurrentX = x2;
//			mCurrentY = y2;
			break;
		}
		case MotionEvent.ACTION_UP: {
			break;
		}
		}
		return true;
	}
}
