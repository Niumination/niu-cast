package com.transsion.core.utils;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.transsion.core.CoreUtil;

/* JADX INFO: loaded from: classes2.dex */
public class ScreenUtil {
    public static int dip2px(float f) {
        return (int) ((getDensity() * f) + 0.5f);
    }

    public static float getDensity() {
        DisplayMetrics displayMetrics = getDisplayMetrics();
        if (displayMetrics == null) {
            return -1.0f;
        }
        return displayMetrics.density;
    }

    public static int getDensityDpi() {
        DisplayMetrics displayMetrics = getDisplayMetrics();
        if (displayMetrics == null) {
            return -1;
        }
        return displayMetrics.densityDpi;
    }

    public static float getDensityScale() {
        DisplayMetrics displayMetrics = getDisplayMetrics();
        if (displayMetrics == null) {
            return -1.0f;
        }
        return displayMetrics.scaledDensity;
    }

    private static DisplayMetrics getDisplayMetrics() {
        if (CoreUtil.getContext() == null) {
            return null;
        }
        Display defaultDisplay = ((WindowManager) CoreUtil.getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getScreenOrientation() {
        if (CoreUtil.getContext() == null && CoreUtil.getContext().getResources() == null) {
            return 0;
        }
        return CoreUtil.getContext().getResources().getConfiguration().orientation;
    }

    public static int getWinHeight() {
        if (CoreUtil.getContext() == null) {
            return -1;
        }
        return getDisplayMetrics().heightPixels;
    }

    public static int getWinWidth() {
        if (CoreUtil.getContext() == null) {
            return -1;
        }
        return getDisplayMetrics().widthPixels;
    }

    public static int px2dip(float f) {
        return (int) ((f / getDensity()) + 0.5f);
    }

    public static int px2sp(float f) {
        return (int) ((f / getDensityScale()) + 0.5f);
    }

    public static int sp2px(float f) {
        return (int) ((getDensityScale() * f) + 0.5f);
    }
}
