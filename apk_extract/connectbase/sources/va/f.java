package va;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16771a = "f";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static pg.e f16772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static pg.e f16773c;

    public static File[] a(String str) {
        return d(fc.b.a.f5987g).c(str);
    }

    public static File b(int i10) {
        return d(fc.b.a.E).b(i10);
    }

    public static File c() {
        return d(fc.b.a.f5999s).a();
    }

    public static pg.e d(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f16771a, "TranThubEnvironment");
            pg.e eVar = f16772b;
            if (eVar != null) {
                return eVar;
            }
            vd.f fVar = new vd.f();
            f16772b = fVar;
            return fVar;
        }
        dc.e.f(f16771a, "TranAospEnvironment");
        pg.e eVar2 = f16773c;
        if (eVar2 != null) {
            return eVar2;
        }
        e8.e eVar3 = new e8.e();
        f16773c = eVar3;
        return eVar3;
    }
}
