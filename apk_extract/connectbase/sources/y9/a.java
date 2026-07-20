package y9;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zc.a f20770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h7.a f20771b;

    public sf.a a(String str) {
        if (fc.b.b(str)) {
            zc.a aVar = this.f20770a;
            if (aVar != null) {
                return aVar;
            }
            zc.a aVar2 = new zc.a();
            this.f20770a = aVar2;
            return aVar2;
        }
        h7.a aVar3 = this.f20771b;
        if (aVar3 != null) {
            return aVar3;
        }
        h7.a aVar4 = new h7.a();
        this.f20771b = aVar4;
        return aVar4;
    }

    public boolean b() {
        return a(fc.b.a.f5988h).b();
    }

    public void c(int i10, int i11, int i12) {
        a(fc.b.a.E).a(i10, i11, i12);
    }
}
