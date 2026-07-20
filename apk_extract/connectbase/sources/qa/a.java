package qa;

import gm.i;
import qd.f;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13872c = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13873d = "callback should not be null";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f13874e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f13875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z7.a f13876b;

    /* JADX INFO: renamed from: qa.a$a, reason: collision with other inner class name */
    public interface InterfaceC0341a {
        void a();

        void b();
    }

    public kg.a a(String str) {
        if (fc.b.b(str)) {
            f fVar = this.f13875a;
            if (fVar != null) {
                return fVar;
            }
            f fVar2 = new f();
            this.f13875a = fVar2;
            return fVar2;
        }
        z7.a aVar = this.f13876b;
        if (aVar != null) {
            return aVar;
        }
        z7.a aVar2 = new z7.a();
        this.f13876b = aVar2;
        return aVar2;
    }

    public String[] b() {
        return a(fc.b.a.f5991k).n();
    }

    public String[] c() {
        return a(fc.b.a.f5988h).g();
    }

    public boolean d(int i10) {
        return a(fc.b.a.f5985e).o(i10);
    }

    public boolean e() {
        return a(fc.b.a.f5988h).m();
    }

    public boolean f(int i10, int i11) {
        return a(fc.b.a.f5987g).l(i10, i11);
    }

    public void g(boolean z10) {
        a(fc.b.a.f5986f).i(z10);
    }

    @yb.a(level = 1)
    public void h(boolean z10) {
        a(fc.b.a.f5987g).j(z10);
    }

    @yb.a(level = 1)
    @Deprecated
    public void i(int i10, boolean z10, @i InterfaceC0341a interfaceC0341a) {
        if (interfaceC0341a == null) {
            throw new NullPointerException(f13873d);
        }
        j(i10, z10, interfaceC0341a);
    }

    @yb.a(level = 1)
    public void j(int i10, boolean z10, @i InterfaceC0341a interfaceC0341a) {
        if (interfaceC0341a == null) {
            throw new NullPointerException(f13873d);
        }
        a(fc.b.a.f5988h).h(i10, z10, interfaceC0341a);
    }

    @yb.a(level = 1)
    public void k(int i10) {
        a(fc.b.a.f5982b).f(i10);
    }
}
