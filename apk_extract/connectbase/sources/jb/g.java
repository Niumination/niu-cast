package jb;

import je.t;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8651c = "g";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f8652d = t8.f.f15534g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f8653e = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f8654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t8.f f8655b;

    @yb.a(level = 0)
    public boolean a() {
        return i(fc.b.a.f5981a).p();
    }

    public String b() {
        return i(fc.b.a.f5986f).v();
    }

    @yb.a(level = 2)
    public String c() {
        return i(fc.b.a.f5989i).k();
    }

    public String d(int i10) {
        return i(fc.b.a.f5998r).l(i10);
    }

    public String e() {
        return i(fc.b.a.f5987g).i();
    }

    public String f(int i10) {
        return i(fc.b.a.f5987g).j(i10);
    }

    @yb.a(level = 2)
    public int g(int i10) {
        return i(fc.b.a.f5998r).d(i10);
    }

    @yb.a(level = 0)
    public int h() {
        return i(fc.b.a.f5982b).n();
    }

    public dh.f i(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f8651c, "TranThubTelephonyManager");
            t tVar = this.f8654a;
            if (tVar != null) {
                return tVar;
            }
            t tVar2 = new t();
            this.f8654a = tVar2;
            return tVar2;
        }
        dc.e.f(f8651c, "TranAospTelephonyManager");
        t8.f fVar = this.f8655b;
        if (fVar != null) {
            return fVar;
        }
        t8.f fVar2 = new t8.f();
        this.f8655b = fVar2;
        return fVar2;
    }

    public d j() {
        return i(fc.b.a.f5981a).m();
    }

    public String k() {
        return i(fc.b.a.f5987g).h();
    }

    @yb.a(level = 1)
    public String l() {
        return i(fc.b.a.f5989i).u();
    }

    public String m(int i10) {
        return i(fc.b.a.f5998r).a(i10);
    }

    public String n(int i10) {
        return i(fc.b.a.f6001u).o(i10);
    }

    public int o() {
        return i(fc.b.a.f5989i).s();
    }

    public int p(int i10) {
        return i(fc.b.a.f5998r).b(i10);
    }

    public int q() {
        return i(fc.b.a.f5998r).f();
    }

    public String r() {
        return i(fc.b.a.f5986f).t();
    }

    public boolean s(int i10) {
        return i(fc.b.a.f5998r).r(i10);
    }

    public boolean t(String str) {
        return i(fc.b.a.f5986f).g(str);
    }

    public boolean u(int i10, String str) {
        return i(fc.b.a.f5985e).e(i10, str);
    }

    @yb.a(level = 2)
    public void v(boolean z10) {
        i(fc.b.a.f5986f).c(z10);
    }

    public void w(int i10, boolean z10) {
        i(fc.b.a.f5985e).q(i10, z10);
    }
}
