package va;

import android.os.UserHandle;
import vd.l0;

/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16841a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f16842b = -2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static UserHandle f16843c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16844d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16845e = -10000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static UserHandle f16846f;

    static {
        if (fc.b.b(fc.b.a.f5984d)) {
            f16843c = l0.c();
        } else {
            f16843c = e8.w.c();
        }
        if (fc.b.b(fc.b.a.f5989i)) {
            f16846f = l0.a();
        } else {
            f16846f = e8.w.a();
        }
    }

    public static int a(int i10) {
        return fc.b.b(fc.b.a.f6004x) ? l0.b(i10) : e8.w.b(i10);
    }

    @yb.a(level = 1)
    public static int b(int i10) {
        return fc.b.b(fc.b.a.f5982b) ? l0.d(i10) : e8.w.d(i10);
    }

    public static boolean c() {
        return fc.b.b(fc.b.a.f5988h) ? l0.e() : e8.w.e();
    }

    @yb.a(level = 1)
    public static int d() {
        return fc.b.b(fc.b.a.f5982b) ? l0.f() : e8.w.f();
    }

    public static UserHandle e(int i10) {
        return fc.b.b(fc.b.a.f5985e) ? l0.g(i10) : e8.w.g(i10);
    }
}
