package com.toby.test.touch;

import android.view.MotionEvent;

public class Utils {
	public static String getTouchStatus(MotionEvent ev) {
		String actionString;
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			actionString = "DOWN";
			break;
		case MotionEvent.ACTION_UP:
			actionString = "UP";
			break;
		case MotionEvent.ACTION_POINTER_DOWN:
			actionString = "PNTR DOWN";
			break;
		case MotionEvent.ACTION_POINTER_UP:
			actionString = "PNTR UP";
			break;
		case MotionEvent.ACTION_MOVE:
			actionString = "MOVE";
			break;
		case MotionEvent.ACTION_CANCEL:
			actionString = "CANCEL";
			break;
		default:
			actionString = "";
		}

		return actionString;
	}
}
