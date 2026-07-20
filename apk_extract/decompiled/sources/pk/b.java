package pk;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final mk.b f8919c;

    public b(a aVar) {
        super(new o5.c(aVar));
        this.f8919c = new mk.b(aVar);
    }

    @Override // ck.d
    public final void onCompleted() {
        this.f8919c.onCompleted();
    }

    @Override // ck.d
    public final void onError(Throwable th2) {
        this.f8919c.onError(th2);
    }

    @Override // ck.d
    public final void onNext(Object obj) {
        this.f8919c.onNext(obj);
    }
}
