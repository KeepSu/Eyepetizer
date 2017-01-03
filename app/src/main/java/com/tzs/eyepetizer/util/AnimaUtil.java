package com.tzs.eyepetizer.util;

import android.view.View;
import android.view.animation.AlphaAnimation;

/**
 * Created by h on 2016/12/30.
 */

public class AnimaUtil {

    /**
     * 逐渐消失的动画(只执行一次)
     */
    public static void disappear(long during, View view) {
        AlphaAnimation disappearAnimation = new AlphaAnimation(1, 0);
        disappearAnimation.setDuration(during);
        disappearAnimation.setFillAfter(true);
        view.startAnimation(disappearAnimation);

    }

    /**
     * 逐渐出现的动画(只执行一次)
     */
    public static void appear(long during, View view) {
        AlphaAnimation appearAnimation = new AlphaAnimation(0, 1);
        appearAnimation.setDuration(during);
        view.startAnimation(appearAnimation);
    }
}
