package jb;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8634c = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public je.e f8635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t8.b f8636b;

    public int[] a(int i10) throws ac.a {
        return c(fc.b.a.f6001u).c(i10);
    }

    public String b(int i10) throws ac.a {
        return c(fc.b.a.f6001u).b(i10);
    }

    public dh.b c(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f8634c, "TranThubMtkTelephonyExManager");
            je.e eVar = this.f8635a;
            if (eVar != null) {
                return eVar;
            }
            je.e eVar2 = new je.e();
            this.f8635a = eVar2;
            return eVar2;
        }
        dc.e.f(f8634c, "TranAospMtkTelephonyExManager");
        t8.b bVar = this.f8636b;
        if (bVar != null) {
            return bVar;
        }
        t8.b bVar2 = new t8.b();
        this.f8636b = bVar2;
        return bVar2;
    }

    public boolean d(int i10) throws ac.a {
        return c(fc.b.a.f6001u).a(i10);
    }
}
