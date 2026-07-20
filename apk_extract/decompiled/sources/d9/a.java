package d9;

import l9.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u9.a f4393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p8.a f4394b;

    public final fa.a a() {
        if (b.a(l9.a.f7347h)) {
            u9.a aVar = this.f4393a;
            if (aVar != null) {
                return aVar;
            }
            u9.a aVar2 = new u9.a();
            this.f4393a = aVar2;
            return aVar2;
        }
        j9.a.c("a", "TranAospAppProperties");
        p8.a aVar3 = this.f4394b;
        if (aVar3 != null) {
            return aVar3;
        }
        p8.a aVar4 = new p8.a();
        this.f4394b = aVar4;
        return aVar4;
    }
}
