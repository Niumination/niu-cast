package com.transsion.sdk.oneid.data;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.io.Serializable;
import ki.d;

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
            this.plat = d.e(context, "ro.board.platform");
        } catch (Exception unused) {
            this.plat = Build.HARDWARE;
        }
        this.rom = d.j();
        this.ram = d.n(context);
        this.battery = d.c(context);
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            this.screen_w = "" + Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            this.screen_h = "" + Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            this.screen_dpi = "" + displayMetrics.densityDpi;
        } catch (Exception unused2) {
        }
    }
}
