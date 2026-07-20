package va;

import android.os.Bundle;
import e8.z;
import vd.b1;

/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16860c = "y";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16861d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16862e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f16863f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f16864g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f16865h = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f16866i = 5;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f16867j = 6;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f16868k = 7;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f16869l = 8;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f16870m = 9;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f16871n = 10;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f16872o = 11;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f16873p = 12;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f16874q = 13;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b1 f16875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f16876b;

    public interface a {
        int a();
    }

    public pg.r a(String str) {
        if (fc.b.b(str)) {
            b1 b1Var = this.f16875a;
            if (b1Var != null) {
                return b1Var;
            }
            b1 b1Var2 = new b1();
            this.f16875a = b1Var2;
            return b1Var2;
        }
        dc.e.f(f16860c, "TranAospVibratorManager");
        z zVar = this.f16876b;
        if (zVar != null) {
            return zVar;
        }
        z zVar2 = new z();
        this.f16876b = zVar2;
        return zVar2;
    }

    public void b() throws ac.a {
        if (fc.a.g()) {
            a(fc.b.a.f6004x).stop();
        }
    }

    public void c(int i10) throws ac.a {
        if (fc.a.g()) {
            if (i10 > Integer.MAX_VALUE || i10 < Integer.MIN_VALUE) {
                throw new IllegalArgumentException("type could not out of range!");
            }
            a(fc.b.a.f6004x).e(i10);
        }
    }

    public void d(String str) throws ac.a {
        if (fc.a.g()) {
            a(fc.b.a.f6004x).b(str);
        }
    }

    public void e(String str, Bundle bundle) throws ac.a {
        if (fc.a.g()) {
            a(fc.b.a.f6006z).c(str, bundle);
        }
    }

    public void f(String str, a aVar) throws ac.a {
        if (fc.a.g()) {
            if (str == null) {
                throw new IllegalArgumentException("param file could not be null!");
            }
            a(fc.b.a.f6004x).a(str, aVar);
        }
    }

    public void g(String str, a aVar, Bundle bundle) throws ac.a {
        if (fc.a.g()) {
            if (str == null) {
                throw new IllegalArgumentException("param file could not be null!");
            }
            a(fc.b.a.f6006z).d(str, aVar, bundle);
        }
    }
}
