package com.toby.test.scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

public class SyncHorizontalScrollView extends HorizontalScrollView {

	private View mSlaveView;

	public SyncHorizontalScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);

		if (mSlaveView != null) {
			mSlaveView.scrollTo(l, t);
		}
	}

	public void setSlaveView(View view) {
		mSlaveView = view;
	}
}
