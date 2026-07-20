package zj;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f11639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f11640b;

    public k(Executor executor, c cVar) {
        this.f11639a = executor;
        this.f11640b = cVar;
    }

    @Override // zj.c
    public final void cancel() {
        this.f11640b.cancel();
    }

    @Override // zj.c
    public final o0 execute() {
        return this.f11640b.execute();
    }

    @Override // zj.c
    public final void g(f fVar) {
        this.f11640b.g(new ad.b(this, fVar));
    }

    @Override // zj.c
    public final boolean isCanceled() {
        return this.f11640b.isCanceled();
    }

    @Override // zj.c
    public final dj.e0 request() {
        return this.f11640b.request();
    }

    @Override // zj.c
    public final c clone() {
        return new k(this.f11639a, this.f11640b.clone());
    }
}
