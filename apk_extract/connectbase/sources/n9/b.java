package n9;

import android.net.Uri;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11426a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static oc.b f11427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static v6.b f11428c;

    public static hf.b a(String str) {
        if (fc.b.b(str)) {
            e.f(f11426a, "TranThubContentProvider");
            oc.b bVar = f11427b;
            if (bVar != null) {
                return bVar;
            }
            oc.b bVar2 = new oc.b();
            f11427b = bVar2;
            return bVar2;
        }
        e.f(f11426a, "TranAospContentProvider");
        v6.b bVar3 = f11428c;
        if (bVar3 != null) {
            return bVar3;
        }
        v6.b bVar4 = new v6.b();
        f11428c = bVar4;
        return bVar4;
    }

    public static Uri b(Uri uri, int i10) {
        return a(fc.b.a.f5991k).a(uri, i10);
    }
}
