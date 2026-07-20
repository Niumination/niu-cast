package qa;

import qd.g;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13879c = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f13880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z7.c f13881b;

    public b a(String str) {
        return b(fc.b.a.f5984d).a(str);
    }

    public kg.b b(String str) {
        if (fc.b.b(str)) {
            g gVar = this.f13880a;
            if (gVar != null) {
                return gVar;
            }
            g gVar2 = new g();
            this.f13880a = gVar2;
            return gVar2;
        }
        z7.c cVar = this.f13881b;
        if (cVar != null) {
            return cVar;
        }
        z7.c cVar2 = new z7.c();
        this.f13881b = cVar2;
        return cVar2;
    }

    public boolean c(String str) {
        return b(fc.b.a.f5987g).d(str);
    }

    public boolean d() {
        return b(fc.b.a.f5988h).f();
    }

    public boolean e() {
        return b(fc.b.a.f5987g).b();
    }

    public String[] f() {
        return b(fc.b.a.f5987g).c();
    }

    @yb.a(level = 2)
    public String[] g() {
        return b(fc.b.a.f5987g).h();
    }

    @yb.a(level = 1)
    public void h(String str, String str2) {
        b(fc.b.a.f5987g).g(str, str2);
    }

    @yb.a(level = 1)
    public void i(String str, String str2) {
        b(fc.b.a.f5987g).e(str, str2);
    }
}
