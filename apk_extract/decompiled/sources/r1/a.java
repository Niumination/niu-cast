package r1;

/* JADX INFO: loaded from: classes.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q1.e f9245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q1.a f9246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9247d;
    public final boolean e;

    public a(String str, q1.e eVar, q1.a aVar, boolean z2, boolean z3) {
        this.f9244a = str;
        this.f9245b = eVar;
        this.f9246c = aVar;
        this.f9247d = z2;
        this.e = z3;
    }

    @Override // r1.b
    public final l1.d a(j1.x xVar, j1.j jVar, s1.c cVar) {
        return new l1.g(xVar, cVar, this);
    }
}
