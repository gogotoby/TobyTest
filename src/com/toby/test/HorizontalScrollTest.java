package com.toby.test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HorizontalScrollTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.horizontal_scroll);

//		final LinearLayout mainContainer = (LinearLayout) findViewById(R.id.main_container);
		// Supply parameters to its parent
//		mainContainer.setLayoutParams(new FrameLayout.LayoutParams(100, 200));

		// ---- 時序 (start) ----
		final LinearLayout timeContainer = (LinearLayout) findViewById(R.id.time_container);
		ViewTreeObserver vto = timeContainer.getViewTreeObserver();
		vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

			public void onGlobalLayout() { // Get notifications when global
											// events, like layout, happen.
				Log.d("TobyTest", String.valueOf(timeContainer.getWidth()));
				timeContainer.getViewTreeObserver().removeGlobalOnLayoutListener(this);
			}

		});

		String[] hours = getResources().getStringArray(R.array.hours);
		TextView tv;
		ViewGroup.LayoutParams timeParams = new ViewGroup.LayoutParams(
				convertDipToPixel(this, 100), ViewGroup.LayoutParams.WRAP_CONTENT);
		for (int i = 0; i < hours.length; i++) {
			tv = new TextView(this);
			tv.setText(hours[i]);
			tv.setTextSize(18);

			timeContainer.addView(tv, timeParams);
		}

		// ---- 時序 (end) ----

		// ---- 節目 (start) ----
		LinearLayout programContainer = (LinearLayout) findViewById(R.id.program_container);
		String[] program_title = getResources().getStringArray(R.array.program_titles);
		String[] program_time_spans = getResources().getStringArray(R.array.program_time_spans);

		Button btn;
		LinearLayout.LayoutParams programParams;
		for (int i = 0; i < program_title.length; i++) {
			btn = new Button(this);
			btn.setBackgroundResource(R.drawable.bkg_channel);
			btn.setText(program_title[i]);
			btn.setTextSize(24);
			btn.setSingleLine();
			btn.setEllipsize(TextUtils.TruncateAt.MIDDLE);

			float length = Float.parseFloat(program_time_spans[i]);
			programParams = new LinearLayout.LayoutParams(convertDipToPixel(this,
					(int) (length * 100)), LinearLayout.LayoutParams.WRAP_CONTENT);
			programParams.setMargins(1, 0, 1, 0);
			programContainer.addView(btn, programParams);
		}
	}

	public static int convertDipToPixel(Context c, int dp) {
		float scale = c.getResources().getDisplayMetrics().density;
		return (int) (dp * scale + 0.5f);
	}
}
