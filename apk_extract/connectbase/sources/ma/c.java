package ma;

import dc.e;
import v7.d;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10622c = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public md.c f10623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f10624b;

    public gg.b a(String str) {
        if (fc.b.b(str)) {
            e.f(f10622c, "TranThubNotificationExpandButton");
            md.c cVar = this.f10623a;
            if (cVar != null) {
                return cVar;
            }
            md.c cVar2 = new md.c();
            this.f10623a = cVar2;
            return cVar2;
        }
        e.f(f10622c, "TranAospNotificationExpandButton");
        d dVar = this.f10624b;
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d();
        this.f10624b = dVar2;
        return dVar2;
    }

    public void b(Object obj, boolean z10) {
        if (obj == null) {
            throw new IllegalArgumentException("button is null");
        }
        a(fc.b.a.f6001u).a(obj, z10);
    }
}
