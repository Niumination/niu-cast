package fc;

import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5972a = 32;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5973b = 33;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5974c = 34;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5975d = 28;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5976e = 36;

    public static boolean a() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 == 31 || i10 == 32;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT == 33;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT == 34;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT < 33;
    }

    public static boolean e() {
        return true;
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT > 33;
    }

    public static boolean g() {
        return Build.VERSION.SDK_INT > 34;
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT >= 36;
    }
}
