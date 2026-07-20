package qb;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13896c = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qe.d f13897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a9.d f13898b;

    public long a() {
        return c(fc.b.a.f5982b).c();
    }

    public long b() {
        return c(fc.b.a.f5982b).b();
    }

    public kh.d c(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f13896c, "TranThubMemInfoReaderManager");
            qe.d dVar = this.f13897a;
            if (dVar != null) {
                return dVar;
            }
            qe.d dVar2 = new qe.d();
            this.f13897a = dVar2;
            return dVar2;
        }
        dc.e.f(f13896c, "TranAospMemInfoReaderManager");
        a9.d dVar3 = this.f13898b;
        if (dVar3 != null) {
            return dVar3;
        }
        a9.d dVar4 = new a9.d();
        this.f13898b = dVar4;
        return dVar4;
    }

    public void d() {
        c(fc.b.a.f5982b).a();
    }
}
