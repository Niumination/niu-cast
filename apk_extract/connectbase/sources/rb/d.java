package rb;

import android.view.Display;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14376c = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public re.c f14377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b9.b f14378b;

    public long a(Display display) {
        if (display != null) {
            return b(fc.b.a.f6001u).a(display);
        }
        throw new IllegalArgumentException("display is null");
    }

    public lh.b b(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f14376c, "TranThubDisplayAddress");
            re.c cVar = this.f14377a;
            if (cVar != null) {
                return cVar;
            }
            re.c cVar2 = new re.c();
            this.f14377a = cVar2;
            return cVar2;
        }
        dc.e.f(f14376c, "TranAospDisplayAddress");
        b9.b bVar = this.f14378b;
        if (bVar != null) {
            return bVar;
        }
        b9.b bVar2 = new b9.b();
        this.f14378b = bVar2;
        return bVar2;
    }
}
