package rb;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14416c = "n";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public re.m f14417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b9.l f14418b;

    public int a() {
        return c(fc.b.a.f6001u).a();
    }

    public int b() {
        return c(fc.b.a.f6001u).b();
    }

    public lh.l c(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f14416c, "TranThubViewConfiguration");
            re.m mVar = this.f14417a;
            if (mVar != null) {
                return mVar;
            }
            re.m mVar2 = new re.m();
            this.f14417a = mVar2;
            return mVar2;
        }
        dc.e.f(f14416c, "TranAospViewConfiguration");
        b9.l lVar = this.f14418b;
        if (lVar != null) {
            return lVar;
        }
        b9.l lVar2 = new b9.l();
        this.f14418b = lVar2;
        return lVar2;
    }
}
