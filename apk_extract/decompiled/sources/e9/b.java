package e9;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f4739c = c.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v9.b f4740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q8.b f4741b;

    public final ga.b a() {
        boolean zA = l9.b.a(l9.a.f7348i);
        String str = f4739c;
        if (zA) {
            j9.a.c(str, "TranThubView");
            v9.b bVar = this.f4740a;
            if (bVar != null) {
                return bVar;
            }
            v9.b bVar2 = new v9.b();
            this.f4740a = bVar2;
            return bVar2;
        }
        j9.a.c(str, "TranAospView");
        q8.b bVar3 = this.f4741b;
        if (bVar3 != null) {
            return bVar3;
        }
        q8.b bVar4 = new q8.b();
        this.f4741b = bVar4;
        return bVar4;
    }
}
