package com.example.administrator.festival;

/**
 * Created by Administrator on 2015-10-30.
 */

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;

public class CloseAnimation extends TranslateAnimation implements
        TranslateAnimation.AnimationListener {

    private LinearLayout slidingLayout;
    int panelWidth;

    public CloseAnimation(LinearLayout layout, int width, int fromXType,
                          float fromXValue, int toXType, float toXValue, int fromYType,
                          float fromYValue, int toYType, float toYValue) {

        super(fromXType, fromXValue, toXType, toXValue, fromYType, fromYValue,
                toYType, toYValue);

        // Initialize
        slidingLayout = layout;
        panelWidth = width;
        setDuration(400);
        setFillAfter(false);
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(this);

        // Clear left and right margins
        LayoutParams params = (LayoutParams) slidingLayout.getLayoutParams();

        params.leftMargin = 0;
        slidingLayout.setLayoutParams(params);
        slidingLayout.requestLayout();
        slidingLayout.startAnimation(this);

    }

    public void onAnimationEnd(Animation animation) {

    }

    public void onAnimationRepeat(Animation animation) {

    }

    public void onAnimationStart(Animation animation) {

    }

}
