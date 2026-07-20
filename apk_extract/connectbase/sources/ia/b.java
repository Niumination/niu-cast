package ia;

import android.content.Context;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7758a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static jd.b f7759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static r7.b f7760c;

    public static cg.b a(String str) {
        if (fc.b.b(str)) {
            e.f(f7758a, "TranThubSystemBarUtils");
            jd.b bVar = f7759b;
            if (bVar != null) {
                return bVar;
            }
            jd.b bVar2 = new jd.b();
            f7759b = bVar2;
            return bVar2;
        }
        e.f(f7758a, "TranAospSystemBarUtils");
        r7.b bVar3 = f7760c;
        if (bVar3 != null) {
            return bVar3;
        }
        r7.b bVar4 = new r7.b();
        f7760c = bVar4;
        return bVar4;
    }

    public static int b(Context context) {
        return a(fc.b.a.f5992l).a(context);
    }
}
