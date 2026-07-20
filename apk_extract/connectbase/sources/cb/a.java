package cb;

import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1390a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ce.a f1391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static m8.a f1392c;

    public static boolean a(String str, String str2, boolean z10) {
        return c(fc.b.a.f5991k).b(str, str2, z10);
    }

    public static int b(String str, String str2, int i10) {
        return c(fc.b.a.f5991k).a(str, str2, i10);
    }

    public static wg.a c(String str) {
        if (fc.b.b(str)) {
            e.f(f1390a, "TranThubDeviceConfig");
            ce.a aVar = f1391b;
            if (aVar != null) {
                return aVar;
            }
            ce.a aVar2 = new ce.a();
            f1391b = aVar2;
            return aVar2;
        }
        e.f(f1390a, "TranAospDeviceConfig");
        m8.a aVar3 = f1392c;
        if (aVar3 != null) {
            return aVar3;
        }
        m8.a aVar4 = new m8.a();
        f1392c = aVar4;
        return aVar4;
    }
}
