package fa;

import dc.e;
import fc.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5954c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gd.a f5955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o7.a f5956b;

    public zf.a a(String str) {
        if (b.b(str)) {
            e.f(f5954c, "TranThubDrawable");
            gd.a aVar = this.f5955a;
            if (aVar != null) {
                return aVar;
            }
            gd.a aVar2 = new gd.a();
            this.f5955a = aVar2;
            return aVar2;
        }
        e.f(f5954c, "TranAospDrawable");
        o7.a aVar3 = this.f5956b;
        if (aVar3 != null) {
            return aVar3;
        }
        o7.a aVar4 = new o7.a();
        this.f5956b = aVar4;
        return aVar4;
    }

    public void b(Object obj, float f10) {
        if (obj == null) {
            throw new IllegalArgumentException("drawable is null");
        }
        a(b.a.f6001u).a(obj, f10);
    }
}
