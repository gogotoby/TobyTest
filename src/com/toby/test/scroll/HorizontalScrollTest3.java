/**
 * 
 * 兩個 HorizontalScrollView 同步滾動
 * 參考 http://blog.csdn.net/fengkuanghun/article/details/6771795
 * 
 */
package com.toby.test.scroll;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.toby.test.R;

public class HorizontalScrollTest3 extends Activity {

	private SyncHorizontalScrollView mSyncHsv1;
	private SyncHorizontalScrollView mSyncHsv2;
	private LinearLayout mHsvChild1;
	private LinearLayout mHsvChild2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.horizontal_scroll_3);

		mSyncHsv1 = (SyncHorizontalScrollView) findViewById(R.id.hsv3_1);
		mHsvChild1 = (LinearLayout) findViewById(R.id.hsv3_1_child);

		String[] hours = getResources().getStringArray(R.array.hours);
		TextView tv;
		for (int i = 0; i < hours.length; i++) {
			tv = new TextView(this);
			tv.setText(hours[i]);
			mHsvChild1.addView(tv);
		}

		mSyncHsv2 = (SyncHorizontalScrollView) findViewById(R.id.hsv3_2);
		mHsvChild2 = (LinearLayout) findViewById(R.id.hsv3_2_child);

		for (int i = 0; i < hours.length; i++) {
			tv = new TextView(this);
			tv.setText(hours[i]);
			mHsvChild2.addView(tv);
		}

		mSyncHsv1.setSlaveView(mSyncHsv2);
		mSyncHsv2.setSlaveView(mSyncHsv1);
	}
}
