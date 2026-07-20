package h9;

import android.content.res.Configuration;
import android.graphics.Rect;
import ic.s1;

/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7077c = "w";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7078d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f7079e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f7080f = 6;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f7081g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f7082h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f7083i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f7084j = 16;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f7085k = 8192;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f7086l = 8;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f7087m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f7088n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f7089o = 32;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f7090p = 9;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f7091q = 13;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f7092r = 2;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f7093s = 11;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f7094t = 12;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s1 f7095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p6.w f7096b;

    public Rect a(Configuration configuration) {
        return b(fc.b.a.f5984d).b(configuration);
    }

    public bf.s b(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f7077c, "TranThubWindowConfiguration");
            s1 s1Var = this.f7095a;
            if (s1Var != null) {
                return s1Var;
            }
            s1 s1Var2 = new s1();
            this.f7095a = s1Var2;
            return s1Var2;
        }
        dc.e.f(f7077c, "TranAospWindowConfiguration");
        p6.w wVar = this.f7096b;
        if (wVar != null) {
            return wVar;
        }
        p6.w wVar2 = new p6.w();
        this.f7096b = wVar2;
        return wVar2;
    }

    public boolean c(int i10) {
        return b(fc.b.a.f5988h).a(i10);
    }

    public boolean d(Configuration configuration) {
        if (configuration != null) {
            return b(fc.b.a.f5987g).c(configuration);
        }
        throw new IllegalArgumentException("configuration cannot null");
    }
}
