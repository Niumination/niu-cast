package q9;

import fc.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public rc.a f13870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y6.a f13871b;

    public void a() {
        b(b.a.f5985e).a();
    }

    public kf.a b(String str) {
        if (b.b(str)) {
            rc.a aVar = this.f13870a;
            if (aVar != null) {
                return aVar;
            }
            rc.a aVar2 = new rc.a();
            this.f13870a = aVar2;
            return aVar2;
        }
        y6.a aVar3 = this.f13871b;
        if (aVar3 != null) {
            return aVar3;
        }
        y6.a aVar4 = new y6.a();
        this.f13871b = aVar4;
        return aVar4;
    }
}
