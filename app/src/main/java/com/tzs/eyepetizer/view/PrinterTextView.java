package com.tzs.eyepetizer.view;

import android.content.Context;
import android.util.AttributeSet;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 打印机效果的TextView
 */
public class PrinterTextView extends CustomFontTextView {

    private Timer mTimer;//计时器
    private String mPrintStr;//需要打字的文字
    private int printProgress = 0;//打字进度


    public PrinterTextView(Context context) {
        super(context);
    }

    public PrinterTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PrinterTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 设置要打印的文字
     */
    public void setPrintText(String str) {
        if (str == null || str.equals("")) {
            return;
        }
        this.mPrintStr = str;
        setText("");
        mTimer = new Timer();
        mTimer.schedule(new PrinterTimeTask(), 500, 15);
    }

    /**
     * 打字计时器任务
     */
    private class PrinterTimeTask extends TimerTask {

        @Override
        public void run() {
            post(new Runnable() {
                @Override
                public void run() {
                    if (printProgress < mPrintStr.length()) {
                        printProgress++;
                        setText(mPrintStr.substring(0, printProgress));
                    } else {
                        setText(mPrintStr);
                        if (mTimer != null) {
                            mTimer.cancel();
                            mTimer = null;
                        }
                    }
                }
            });
        }
    }
}