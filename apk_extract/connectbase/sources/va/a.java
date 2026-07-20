package va;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16692c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vd.a f16693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e8.a f16694b;

    public long a() {
        return b(fc.b.a.f5985e).a();
    }

    public pg.a b(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f16692c, "TranThubBatteryStats");
            vd.a aVar = this.f16693a;
            if (aVar != null) {
                return aVar;
            }
            vd.a aVar2 = new vd.a();
            this.f16693a = aVar2;
            return aVar2;
        }
        dc.e.f(f16692c, "TranAospBatteryStats");
        e8.a aVar3 = this.f16694b;
        if (aVar3 != null) {
            return aVar3;
        }
        e8.a aVar4 = new e8.a();
        this.f16694b = aVar4;
        return aVar4;
    }
}
