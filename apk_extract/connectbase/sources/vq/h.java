package vq;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements nq.s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final um.g f17848a;

    public h(@os.l um.g gVar) {
        this.f17848a = gVar;
    }

    @Override // nq.s0
    @os.l
    public um.g getCoroutineContext() {
        return this.f17848a;
    }

    @os.l
    public String toString() {
        return "CoroutineScope(coroutineContext=" + this.f17848a + ')';
    }
}
