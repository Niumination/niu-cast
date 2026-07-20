package a6;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import com.transsion.connectx.mirror.source.SourceApplication;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f120a = "com.transsion.smartpanel.show_by_nav";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f121b = "com.transsion.smartpanel";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f122c = "navigation_mode";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f123d = 2;

    public static boolean a(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "navigation_mode", 0) == 2;
    }

    public static boolean b() {
        return ("tablet".equalsIgnoreCase(m4.a.C0275a.f10375a.t("ro.tr_device.type", ks.c.f9460f)) || "tablet".equalsIgnoreCase(m4.a.C0275a.f10375a.t("ro.build.characteristics", ks.c.f9460f))) ? false : true;
    }

    public static void c() {
        m4.a.C0275a.f10375a.m();
    }

    public static void d() {
        m4.a.C0275a.f10375a.e();
    }

    public static void e() {
        Intent intent = new Intent(f120a);
        intent.setPackage(f121b);
        SourceApplication.b().sendBroadcast(intent);
    }
}
