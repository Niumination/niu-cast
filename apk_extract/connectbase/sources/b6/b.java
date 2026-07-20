package b6;

import android.content.Context;
import androidx.annotation.NonNull;
import f6.h;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @b.a({"StaticFieldLeak"})
    public static Context f749a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f750b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f751c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f752d = false;

    public b() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Context a() {
        Context context = f749a;
        if (context != null) {
            return context;
        }
        throw new NullPointerException("u should init first");
    }

    public static void b(@NonNull Context context) {
        if (d()) {
            return;
        }
        f752d = true;
        f749a = context.getApplicationContext();
        c6.b.h();
        h.a(a());
    }

    public static boolean c() {
        return f750b;
    }

    public static boolean d() {
        return f752d && f749a != null;
    }

    public static boolean e() {
        return f751c;
    }

    public static void f(Context context) {
        f749a = context.getApplicationContext();
    }

    public static void g(boolean z10) {
        f750b = z10;
    }

    public static void h(boolean z10) {
        f751c = z10;
    }
}
