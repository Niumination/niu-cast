package va;

import vd.z;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16791a = "k";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static pg.i f16792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static pg.i f16793c;

    public static String a() {
        return c(fc.b.a.f5999s).a();
    }

    public static double b() {
        return c(fc.b.a.f5999s).b();
    }

    public static pg.i c(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f16791a, "TranThubProcess");
            pg.i iVar = f16792b;
            if (iVar != null) {
                return iVar;
            }
            z zVar = new z();
            f16792b = zVar;
            return zVar;
        }
        dc.e.f(f16791a, "TranAospProcess");
        pg.i iVar2 = f16793c;
        if (iVar2 != null) {
            return iVar2;
        }
        e8.k kVar = new e8.k();
        f16793c = kVar;
        return kVar;
    }
}
