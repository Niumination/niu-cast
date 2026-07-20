package va;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16695c = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vd.c f16696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e8.b f16697b;

    public int a() {
        return c(fc.b.a.f5999s).a();
    }

    public c b() {
        return c(fc.b.a.f5985e).b();
    }

    public pg.b c(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f16695c, "TranThubBatteryStatsManager");
            vd.c cVar = this.f16696a;
            if (cVar != null) {
                return cVar;
            }
            vd.c cVar2 = new vd.c();
            this.f16696a = cVar2;
            return cVar2;
        }
        dc.e.f(f16695c, "TranAospBatteryStatsManager");
        e8.b bVar = this.f16697b;
        if (bVar != null) {
            return bVar;
        }
        e8.b bVar2 = new e8.b();
        this.f16697b = bVar2;
        return bVar2;
    }
}
