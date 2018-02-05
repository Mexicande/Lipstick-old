package com.deerlive.lipstick.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by apple on 2018/1/9.
 */

public class ForbidMoveLinearLayout extends LinearLayout {
    public ForbidMoveLinearLayout(Context context) {
        super(context);
    }

    public ForbidMoveLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ForbidMoveLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_MOVE){
            return true;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
