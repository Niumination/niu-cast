package pb;

import dc.e;
import fc.b;
import pe.g;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13070c = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f13071d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f13072e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f13073f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f13074g = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f13075h = g.f13101g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f13076i = g.f13102h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f13077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z8.a f13078b;

    public boolean a(int i10) {
        if (i10 > Integer.MAX_VALUE || i10 < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("pid invalid");
        }
        return b(b.a.f5998r).c(i10);
    }

    public jh.a b(String str) {
        if (b.b(str)) {
            e.f(f13070c, "TranThubSchedManager");
            g gVar = this.f13077a;
            if (gVar != null) {
                return gVar;
            }
            g gVar2 = new g();
            this.f13077a = gVar2;
            return gVar2;
        }
        e.f(f13070c, "TranAospSchedManager");
        z8.a aVar = this.f13078b;
        if (aVar != null) {
            return aVar;
        }
        z8.a aVar2 = new z8.a();
        this.f13078b = aVar2;
        return aVar2;
    }

    public int c() {
        return b(b.a.f5998r).a();
    }

    public int d() {
        return b(b.a.f5998r).e();
    }

    public long e(int i10) {
        if (i10 > Integer.MAX_VALUE || i10 < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("pid invalid");
        }
        return b(b.a.f5998r).d(i10);
    }

    public boolean f(int i10) {
        return b(b.a.f5998r).b(i10);
    }

    public boolean g(int i10, String str) {
        if (i10 > Integer.MAX_VALUE || i10 < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("pid invalid");
        }
        if (str != null) {
            return b(b.a.f5998r).f(i10, str);
        }
        throw new NullPointerException("mainThread cannot be null");
    }
}
