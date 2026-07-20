package com.transsion.sdk.oneid.data;

import ad.c;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.transsion.atomiccore.support.host.AtomicIntentType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceInfo extends OneBaseInfo implements Serializable {
    public String battery;
    public String brand;
    public String model;
    public String plat;
    public String ram;
    public String rom;
    public String screen_dpi;
    public String screen_h;
    public String screen_w;

    public DeviceInfo(Context context) {
        String strA;
        double dDoubleValue;
        long totalSpace;
        long j8;
        long j10;
        long j11;
        String strA2 = "0";
        this.brand = "";
        this.model = "";
        this.plat = "";
        this.rom = "";
        this.ram = "";
        this.battery = "";
        this.screen_h = "";
        this.screen_w = "";
        this.screen_dpi = "";
        this.brand = Build.BRAND;
        this.model = Build.MODEL;
        try {
            try {
                this.plat = c.c(context, "ro.board.platform");
                while (true) {
                    j11 = j8 * j10;
                    if (j11 >= totalSpace) {
                        break;
                    }
                    j8 <<= 1;
                    if (j8 > 512) {
                        j10 *= 1000;
                        j8 = 1;
                    }
                }
            } catch (Exception unused) {
                this.plat = Build.HARDWARE;
            }
            totalSpace = Environment.getDataDirectory().getTotalSpace() + Environment.getRootDirectory().getTotalSpace();
            j8 = 1;
            j10 = 1;
            strA = c.a(j11);
        } catch (Exception e) {
            e.printStackTrace();
            strA = "0";
        }
        this.rom = strA;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(AtomicIntentType.ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            strA2 = c.a(memoryInfo.totalMem);
        } catch (Throwable unused2) {
        }
        this.ram = strA2;
        try {
            dDoubleValue = ((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getBatteryCapacity", null).invoke(Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context), null)).doubleValue();
        } catch (Throwable unused3) {
            dDoubleValue = 0.0d;
        }
        this.battery = String.valueOf(dDoubleValue);
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            this.screen_w = "" + Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            this.screen_h = "" + Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            this.screen_dpi = "" + displayMetrics.densityDpi;
        } catch (Exception unused4) {
        }
    }
}
