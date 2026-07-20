package k9;

import dc.e;
import lc.j;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9161c = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f9162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s6.a f9163b;

    public String a(String str) {
        return c(fc.b.a.f5981a).g(str);
    }

    public float b(int i10) {
        return c(fc.b.a.f6004x).k(i10);
    }

    public ef.a c(String str) {
        if (fc.b.b(str)) {
            e.f(f9161c, "TranThubAppmServiceManager");
            j jVar = this.f9162a;
            if (jVar != null) {
                return jVar;
            }
            j jVar2 = new j();
            this.f9162a = jVar2;
            return jVar2;
        }
        e.f(f9161c, "TranAospAppmServiceManager");
        s6.a aVar = this.f9163b;
        if (aVar != null) {
            return aVar;
        }
        s6.a aVar2 = new s6.a();
        this.f9163b = aVar2;
        return aVar2;
    }

    public void d(String str, String str2) {
        c(fc.b.a.f5981a).e(str, str2);
    }

    public void e(a aVar) {
        c(fc.b.a.f5981a).j(aVar);
    }

    public void f(String str, String str2) {
        c(fc.b.a.f5981a).b(str, str2);
    }

    public boolean g(int i10, boolean z10, String str) {
        return c(fc.b.a.f6004x).i(i10, z10, str);
    }

    public void h(a aVar) {
        c(fc.b.a.f5981a).h(aVar);
    }
}
