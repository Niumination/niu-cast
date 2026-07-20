package com.transsion.core;

import android.content.Context;
import androidx.annotation.NonNull;
import com.transsion.core.deviceinfo.DeviceInfo;
import com.transsion.core.utils.SharedPreferencesUtil;

/* JADX INFO: loaded from: classes2.dex */
public class CoreUtil {
    private static Context context = null;
    private static boolean isDebug = false;
    private static boolean isInit = false;
    private static boolean logForceOpen = false;

    private CoreUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Context getContext() {
        Context context2 = context;
        if (context2 != null) {
            return context2;
        }
        throw new NullPointerException("u should init first");
    }

    public static void init(@NonNull Context context2) {
        if (isInit()) {
            return;
        }
        isInit = true;
        context = context2.getApplicationContext();
        DeviceInfo.getGAId();
        SharedPreferencesUtil.bindApplication(getContext());
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static boolean isInit() {
        return isInit && context != null;
    }

    public static boolean isLogForceOpen() {
        return logForceOpen;
    }

    public static void setContext(Context context2) {
        context = context2.getApplicationContext();
    }

    public static void setDebug(boolean z2) {
        isDebug = z2;
    }

    public static void setLogForceOpen(boolean z2) {
        logForceOpen = z2;
    }
}
