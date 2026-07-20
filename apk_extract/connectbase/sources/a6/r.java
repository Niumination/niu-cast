package a6;

import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.util.DisplayMetrics;
import com.transsion.connectx.mirror.source.SourceApplication;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f129a = "WallpaperHelper";

    public static String a() {
        WallpaperInfo wallpaperInfo = WallpaperManager.getInstance(SourceApplication.b()).getWallpaperInfo();
        if (wallpaperInfo == null) {
            return "";
        }
        String packageName = wallpaperInfo.getPackageName();
        String serviceName = wallpaperInfo.getServiceName();
        k4.m.b(f129a, "getWallpaperPackage: " + packageName + "-serviceName==" + serviceName);
        return serviceName;
    }

    public static boolean b() {
        return "1".equals(m4.a.C0275a.f10375a.E("ro.tr_project.foldable_screen.support", "ro.os_foldable_screen_support", hi.b.f7118g));
    }

    public static boolean c() {
        if (!b()) {
            return false;
        }
        DisplayMetrics displayMetrics = SourceApplication.b().getResources().getDisplayMetrics();
        return ((float) Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels)) / (((float) displayMetrics.densityDpi) / 160.0f) >= 600.0f;
    }
}
