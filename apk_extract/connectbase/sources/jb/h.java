package jb;

import je.u;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8656c = "h";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f8657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t8.g f8658b;

    @yb.a(level = 1)
    public void a() {
        d(fc.b.a.f5989i).a();
    }

    @yb.a(level = 1)
    public void b(int i10) {
        d(fc.b.a.f5989i).d(i10);
    }

    public String c(String str) {
        return !fc.a.h() ? "" : d(fc.b.a.G).e(str);
    }

    public dh.g d(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f8656c, "TranThubTelephonyManagerExtManager");
            u uVar = this.f8657a;
            if (uVar != null) {
                return uVar;
            }
            u uVar2 = new u();
            this.f8657a = uVar2;
            return uVar2;
        }
        dc.e.f(f8656c, "TranAospTelephonyManagerExtManager");
        t8.g gVar = this.f8658b;
        if (gVar != null) {
            return gVar;
        }
        t8.g gVar2 = new t8.g();
        this.f8658b = gVar2;
        return gVar2;
    }

    public int e() {
        return d(fc.b.a.f5989i).c();
    }

    public int f(int i10, String str) {
        if (str != null) {
            return d(fc.b.a.f6001u).b(i10, str);
        }
        throw new IllegalArgumentException("Password is null");
    }
}
