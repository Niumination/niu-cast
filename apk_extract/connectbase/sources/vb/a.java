package vb;

import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16877c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ve.b f16878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f9.a f16879b;

    public ph.a a(String str) {
        if (fc.b.b(str)) {
            e.f(f16877c, "TranThubDisplayRotationManager");
            ve.b bVar = this.f16878a;
            if (bVar != null) {
                return bVar;
            }
            ve.b bVar2 = new ve.b();
            this.f16878a = bVar2;
            return bVar2;
        }
        e.f(f16877c, "TranAospDisplayRotationManager");
        f9.a aVar = this.f16879b;
        if (aVar != null) {
            return aVar;
        }
        f9.a aVar2 = new f9.a();
        this.f16879b = aVar2;
        return aVar2;
    }

    public void b(int i10) {
        a(fc.b.a.f6000t).a(i10);
    }
}
