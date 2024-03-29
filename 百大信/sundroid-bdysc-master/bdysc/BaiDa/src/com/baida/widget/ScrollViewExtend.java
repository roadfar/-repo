package com.baida.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * 能够兼容ViewPager的ScrollView
 * 
 * @Description: 解决了ViewPager在ScrollView中的滑动反弹问题
 */
public class ScrollViewExtend extends ScrollView {
	// 滑动距离及坐标
	private float xDistance, yDistance, xLast, yLast;
    
	
	public ScrollViewExtend(Context context, AttributeSet attrs) {
		super(context, attrs);
		
	}

	public ScrollViewExtend(Context context) {
		super(context);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			xDistance = yDistance = 0f;
			xLast = ev.getX();
			yLast = ev.getY();
			break;
		case MotionEvent.ACTION_MOVE:
			final float curX = ev.getX();
			final float curY = ev.getY();
			
//			int off= view.getMeasuredHeight()-extend.getHeight();
//			Log.i("OFF", off+"");

			xDistance += Math.abs(curX - xLast);
			yDistance += Math.abs(curY - yLast);
			xLast = curX;
			yLast = curY;
			

				if (xDistance > yDistance) {

					return false;
				}
		}

		return super.onInterceptTouchEvent(ev);
	}
}