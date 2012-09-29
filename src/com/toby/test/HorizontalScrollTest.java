package com.toby.test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HorizontalScrollTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.horizontal_scroll);
		
		// ---- 時序 (start) ----
		LinearLayout timerContainer = (LinearLayout) findViewById(R.id.time_container);
		String[] times = getResources().getStringArray(R.array.times);
		TextView tv;
		ViewGroup.LayoutParams timeParams = new ViewGroup.LayoutParams(convertDipToPixel(this, 100),ViewGroup.LayoutParams.WRAP_CONTENT);
		for(int i=0; i<times.length; i++){
			tv = new TextView(this);
			tv.setText(times[i]);
			tv.setTextSize(18);
			
			timerContainer.addView(tv, timeParams);
		}
		
		// ---- 時序 (end) ----
		
		// ---- 節目 (start) ----
		LinearLayout programContainer = (LinearLayout) findViewById(R.id.program_container);
		String[] programs = getResources().getStringArray(R.array.programs);
		Button btn;
		LinearLayout.LayoutParams programParams = new LinearLayout.LayoutParams(convertDipToPixel(this, 100),LinearLayout.LayoutParams.WRAP_CONTENT);
		programParams.setMargins(1, 0, 1, 0);
		for(int i=0; i<programs.length; i++){
			btn = new Button(this);
			btn.setBackgroundResource(R.drawable.darkknight_1);
			btn.setText(programs[i]);
			btn.setTextSize(24);
			btn.setSingleLine();
			btn.setEllipsize(TextUtils.TruncateAt.END);
			
			programContainer.addView(btn, programParams);
		}
		
		// ---- 節目 (end) ----
	}
	
	public static int convertDipToPixel(Context c, int dp) {
		float scale = c.getResources().getDisplayMetrics().density;
		return (int) (dp * scale + 0.5f);
	}
}
