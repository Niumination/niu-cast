package sa;

import dc.e;
import sd.c;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f15035c = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f15036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b8.b f15037b;

    public boolean a() {
        return c(fc.b.a.f5989i).a();
    }

    public boolean b() {
        return c(fc.b.a.f5989i).b();
    }

    public mg.b c(String str) {
        if (fc.b.b(str)) {
            e.f(f15035c, "TranThubNfcManager");
            c cVar = this.f15036a;
            if (cVar != null) {
                return cVar;
            }
            c cVar2 = new c();
            this.f15036a = cVar2;
            return cVar2;
        }
        e.f(f15035c, "TranAospNfcManager");
        b8.b bVar = this.f15037b;
        if (bVar != null) {
            return bVar;
        }
        b8.b bVar2 = new b8.b();
        this.f15037b = bVar2;
        return bVar2;
    }
}
