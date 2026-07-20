package x9;

import android.view.Display;
import dc.e;
import yc.k;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f20129c = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f20130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g7.c f20131b;

    public Display a(int i10) {
        return b(fc.b.a.f6001u).a(i10);
    }

    public rf.c b(String str) {
        if (fc.b.b(str)) {
            e.f(f20129c, "TranThubDisplayManagerGlobalAdapter");
            k kVar = this.f20130a;
            if (kVar != null) {
                return kVar;
            }
            k kVar2 = new k();
            this.f20130a = kVar2;
            return kVar2;
        }
        e.f(f20129c, "TranAospDisplayManagerGlobalAdapter");
        g7.c cVar = this.f20131b;
        if (cVar != null) {
            return cVar;
        }
        g7.c cVar2 = new g7.c();
        this.f20131b = cVar2;
        return cVar2;
    }
}
