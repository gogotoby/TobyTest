/**
 * 
 * 兩個 ScrollView 同步滾動
 * 參考 http://www.cnblogs.com/devinzhang/archive/2012/07/13/2590222.html
 * 
 */
package com.toby.test.scroll;

import com.toby.test.R;
import com.toby.test.scroll.ObservableScrollView.OnScrollListener;

import android.app.Activity;
import android.os.Bundle;

public class VerticalScrollTest3 extends Activity implements OnScrollListener {
	private ObservableScrollView scrollView1 = null;
	private ObservableScrollView scrollView2 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vertical_scroll_3);
		scrollView1 = (ObservableScrollView) findViewById(R.id.scrollview1);
		scrollView1.setOnScrollListener(this);
		scrollView2 = (ObservableScrollView) findViewById(R.id.scrollview2);
		scrollView2.setOnScrollListener(this);
	}

	public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
		if (scrollView == scrollView1) {
//			scrollView2.smoothScrollTo(x, y); // 反而比較頓
			scrollView2.scrollTo(x, y); // cause a call to View # onScrollChanged(int, int, int, int)
		} else if (scrollView == scrollView2) {
//			scrollView1.smoothScrollTo(x, y); // 反而比較頓
			scrollView1.scrollTo(x, y); // cause a call to View # onScrollChanged(int, int, int, int)
		}
	}
}