package w4;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.WindowManager;
import com.transsion.connectx.mirror.source.SourceApplication;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SharedPreferences f17966a = SourceApplication.b().getSharedPreferences("config", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f17967b = 0.1f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f17968c = 60;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f17969d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f17970e = 720;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f17971f = 1568;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f17972g = 1920;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f17973h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f17974i = "TestInjection";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f17975j = 60;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f17976k = 10;

    public static int a(Context context, float f10) {
        float f11 = context.getResources().getDisplayMetrics().density;
        k4.m.e(f17974i, "densi:" + f11 + ",val:" + f10);
        return (int) ((f10 * f11) + 0.5f);
    }

    public static int b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }

    public static int c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int d(r4.d dVar) {
        return (dVar.i() == 1 || dVar.i() == 3) ? dVar.j() : dVar.f();
    }

    public static Size e(Size size) {
        if (Build.HARDWARE.equals("qcom")) {
            return new Size(f17970e, f17971f);
        }
        if (size.getHeight() <= 1920) {
            return size;
        }
        return new Size((int) (((double) size.getWidth()) * (1920.0d / ((double) size.getHeight()))), 1920);
    }

    public static int f(Context context) {
        try {
            return Settings.Secure.getInt(context.getApplicationContext().getContentResolver(), "navigation_mode", 0);
        } catch (Exception e10) {
            k4.m.d(f17974i, e10);
            return 0;
        }
    }

    public static int g(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", dc.d.f3680k, "android"));
    }

    public static int h(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    public static int i(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", dc.d.f3680k, "android"));
    }

    public static int j(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int k(r4.d dVar) {
        return (dVar.i() == 0 || dVar.i() == 2) ? dVar.j() : dVar.f();
    }

    public static r4.d l(Context context) {
        return r(context);
    }

    public static r4.d m(Context context) {
        int iG = g(context);
        int i10 = i(context);
        k4.m.b(f17974i, "provideDefaultAppVirtualDisplayConfig: navigationBarHeight in px:" + iG + "statusBarHeight in px:" + i10);
        Size size = new Size(j(context), (c(context) - iG) - i10);
        int i11 = context.getResources().getConfiguration().orientation;
        m2.b.a("provideDefaultAppVirtualDisplayConfig :orientation:", i11, f17974i);
        if (i11 == 2) {
            size = new Size(c(context), j(context));
        }
        Size sizeE = e(size);
        int width = sizeE.getWidth();
        int height = sizeE.getHeight();
        SharedPreferences sharedPreferences = f17966a;
        return new r4.d("phone_mirror_pad", width, height, sharedPreferences.getInt("dpi", b(context)), (int) (sizeE.getHeight() * sizeE.getWidth() * 0.1f * 60.0f), 60, sharedPreferences.getInt("frame_interval", 5), sharedPreferences.getInt("encodeType", 0) == 0 ? "video/hevc" : "video/avc", 0);
    }

    public static n2.s n() {
        return new n2.s(1280, 800, 1, 10, 60);
    }

    public static n2.l o(Context context) {
        return new n2.l("android", null, null, c(context), j(context), c(context), j(context), 1, 1, 0L, 0, 0.0f, null);
    }

    public static r4.d p(Context context, String str) {
        Size size = new Size(j(context), c(context));
        int iH = h(context);
        k4.m.e(f17974i, "provideLauncherDisplayConfig :orientation:" + iH + "size:" + size);
        if (iH == 2) {
            size = new Size(c(context), j(context));
        }
        DisplayManager displayManager = (DisplayManager) context.getSystemService(DisplayManager.class);
        int rotation = displayManager != null ? displayManager.getDisplay(0).getRotation() : 0;
        Size sizeE = e(size);
        k4.m.e(f17974i, "provideLauncherDisplayConfig 2 :orientation:" + iH + "size:" + sizeE);
        int width = sizeE.getWidth();
        int height = sizeE.getHeight();
        SharedPreferences sharedPreferences = f17966a;
        return new r4.d(str, width, height, sharedPreferences.getInt("dpi", b(context)), (int) (sizeE.getHeight() * sizeE.getWidth() * 0.1f * 60.0f), 60, sharedPreferences.getInt("frame_interval", 5), sharedPreferences.getInt("encodeType", 0) == 0 ? "video/hevc" : "video/avc", rotation);
    }

    public static q4.a q() {
        return new q4.a(44100, 12, 2, "audio/mp4a-latm");
    }

    public static r4.d r(Context context) {
        SharedPreferences sharedPreferences = f17966a;
        int i10 = sharedPreferences.getInt("phoneMainW", 1440);
        int i11 = sharedPreferences.getInt("phoneMainH", 1440);
        StringBuilder sbA = i0.a.a("provideLauncherVirtualDisplayConfig: width:", i10, ",height:", i11, "bitrateRate=");
        sbA.append(sharedPreferences.getFloat("bitrateRate", 1.0f));
        k4.m.e("Injection", sbA.toString());
        return new r4.d("mirror-app-virtual-launcher", i10, i11, 320, (int) (i10 * i11 * 60 * 0.1f), 60, sharedPreferences.getInt("frame_interval", 5), sharedPreferences.getInt("encodeType", 0) == 0 ? "video/hevc" : "video/avc", 0);
    }

    public static int s(Context context, float f10) {
        return (int) ((f10 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
