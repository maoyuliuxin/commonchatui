package com.iflytek.chatdetails.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iflytek.chatdetails.R;

/**
 * description:
 * data: 2018/8/24
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
public class SizeUtils {

    public static void setLeftVoiceWith(Context context, TextView textView, long voiceTime) {
        float density = context.getResources().getDisplayMetrics().density;
        int width = (int) (-0.04 * voiceTime * voiceTime + 4.526 * voiceTime);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.leftMargin = (int) (width * density);
        textView.requestLayout();
        String s = voiceTime + context.getString(R.string.time_sign);
        textView.setText(s);
    }

    public static void setRightVoiceWith(Context context, TextView textView, long voiceTime) {
        float density = context.getResources().getDisplayMetrics().density;
        int width = (int) (-0.04 * voiceTime * voiceTime + 4.526 * voiceTime);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.rightMargin = (int) (width * density);
        textView.requestLayout();
        String s = voiceTime + context.getString(R.string.time_sign);
        textView.setText(s);
    }
}
