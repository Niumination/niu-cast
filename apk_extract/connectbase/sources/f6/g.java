package f6;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static int a(float f10) {
        return (int) ((b() * f10) + 0.5f);
    }

    public static float b() {
        DisplayMetrics displayMetricsE = e();
        if (displayMetricsE == null) {
            return -1.0f;
        }
        return displayMetricsE.density;
    }

    public static int c() {
        DisplayMetrics displayMetricsE = e();
        if (displayMetricsE == null) {
            return -1;
        }
        return displayMetricsE.densityDpi;
    }

    public static float d() {
        DisplayMetrics displayMetricsE = e();
        if (displayMetricsE == null) {
            return -1.0f;
        }
        return displayMetricsE.scaledDensity;
    }

    public static DisplayMetrics e() {
        if (b6.b.a() == null) {
            return null;
        }
        Display defaultDisplay = ((WindowManager) b6.b.a().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static int f() {
        if (b6.b.a() == null && b6.b.a().getResources() == null) {
            return 0;
        }
        return b6.b.a().getResources().getConfiguration().orientation;
    }

    public static int g() {
        if (b6.b.a() == null) {
            return -1;
        }
        return e().heightPixels;
    }

    public static int h() {
        if (b6.b.a() == null) {
            return -1;
        }
        return e().widthPixels;
    }

    public static int i(float f10) {
        return (int) ((f10 / b()) + 0.5f);
    }

    public static int j(float f10) {
        return (int) ((f10 / d()) + 0.5f);
    }

    public static int k(float f10) {
        return (int) ((d() * f10) + 0.5f);
    }
}
