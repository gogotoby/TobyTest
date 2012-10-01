/**
 * 
 * http://www.linuxidc.com/Linux/2011-09/43135.htm
 * 
 */
package com.toby.test.scroll;

import com.toby.test.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class TwoDimScrollTest extends Activity {

	private RelativeLayout container;
	private int currentX;
	private int currentY;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_dim_scroll);

		container = (RelativeLayout) findViewById(R.id.container);

		int top = 0;
		int left = 0;

		ImageView image1 = new ImageView(this);
		image1.setImageResource(R.drawable.joker);
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(left, top, 0, 0);
		container.addView(image1, layoutParams);

		ImageView image2 = new ImageView(this);
		image2.setImageResource(R.drawable.joker);
		left += 100;
		layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(left, top, 0, 0);
		container.addView(image2, layoutParams);

		ImageView image3 = new ImageView(this);
		image3.setImageResource(R.drawable.joker);
		left = 0;
		top += 100;
		layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(left, top, 0, 0);
		container.addView(image3, layoutParams);

		ImageView image4 = new ImageView(this);
		image4.setImageResource(R.drawable.joker);
		left += 100;
		layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(left, top, 0, 0);
		container.addView(image4, layoutParams);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN: {
			currentX = (int) event.getRawX();
			currentY = (int) event.getRawY();
			break;
		}

		case MotionEvent.ACTION_MOVE: {
			int x2 = (int) event.getRawX();
			int y2 = (int) event.getRawY();
			container.scrollBy(currentX - x2, currentY - y2);
			currentX = x2;
			currentY = y2;
			break;
		}
		case MotionEvent.ACTION_UP: {
			break;
		}
		}
		return true;
	}

}
