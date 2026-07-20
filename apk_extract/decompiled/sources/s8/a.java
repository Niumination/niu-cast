package s8;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m9.a f9573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h8.a f9574b;

    public final x9.a a(String str) {
        if (l9.b.a(str)) {
            j9.a.c("a", "TranThubActivityTaskManager");
            m9.a aVar = this.f9573a;
            if (aVar != null) {
                return aVar;
            }
            m9.a aVar2 = new m9.a();
            this.f9573a = aVar2;
            return aVar2;
        }
        j9.a.c("a", "TranAospActivityTaskManager");
        h8.a aVar3 = this.f9574b;
        if (aVar3 != null) {
            return aVar3;
        }
        h8.a aVar4 = new h8.a();
        this.f9574b = aVar4;
        return aVar4;
    }
}
