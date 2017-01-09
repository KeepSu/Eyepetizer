package com.tzs.eyepetizer.util;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

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
        appearAnimation.setFillAfter(true);
        view.startAnimation(appearAnimation);
    }

    /**
     * 缩放动画
     */
    public static void scale(long during, View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 1.1f, 1f, 1.1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(during);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        view.startAnimation(scaleAnimation);
    }

}




