package com.toby.test.scroll;

import com.toby.test.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class VerticalScrollTest extends Activity {

	private ScrollView mVsv;
	private LinearLayout mVsvChild;

//	private int mCurrentX;
	private int mCurrentY;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.vertical_scroll);

		mVsv = (ScrollView) findViewById(R.id.vsv);
		mVsvChild = (LinearLayout) findViewById(R.id.vsv_child);

		String[] hours = getResources().getStringArray(R.array.hours);
		TextView tv;
		for (int i = 0; i < hours.length; i++) {
			tv = new TextView(this);
			tv.setText(hours[i]);
			mVsvChild.addView(tv);
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
//			mCurrentX = (int) event.getRawX();
			mCurrentY = (int) event.getRawY();
			break;
		}
		case MotionEvent.ACTION_MOVE: {
//			int x2 = (int) event.getRawX();
			int y2 = (int) event.getRawY();

//			mHsv.scrollBy(mCurrentX - x2, 0);
//			mHsv.smoothScrollBy(mCurrentX - x2, 0);
			mVsv.scrollBy(0, mCurrentY - y2);
//			mVsv.scrollTo(0, y2);
//			Log.d("TobyTest", "VerticalScrollTest/ mVsv.scrollBy: " + (mCurrentY - y2));

//			mCurrentX = x2;
			mCurrentY = y2;
			break;
		}
		case MotionEvent.ACTION_UP: {
			break;
		}
		}
		return true;
	}
}
