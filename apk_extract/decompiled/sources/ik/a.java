package ik;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends ck.i {
    public final c.a e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ek.b f5884h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ek.d f5885i;

    public a(c.a aVar, ek.b bVar) {
        ek.d dVar = ek.e.f4970a;
        this.e = aVar;
        this.f5884h = bVar;
        this.f5885i = dVar;
    }

    @Override // ck.d
    public final void onCompleted() {
        this.f5885i.getClass();
    }

    @Override // ck.d
    public final void onError(Throwable th2) {
        this.f5884h.mo0call(th2);
    }

    @Override // ck.d
    public final void onNext(Object obj) {
        this.e.mo0call(obj);
    }
}
