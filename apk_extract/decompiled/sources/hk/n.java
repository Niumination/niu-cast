package hk;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements ck.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future f5512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f5513b;

    public n(q qVar, Future future) {
        this.f5513b = qVar;
        this.f5512a = future;
    }

    @Override // ck.j
    public final boolean isUnsubscribed() {
        return this.f5512a.isCancelled();
    }

    @Override // ck.j
    public final void unsubscribe() {
        Object obj = this.f5513b.get();
        Thread threadCurrentThread = Thread.currentThread();
        Future future = this.f5512a;
        if (obj != threadCurrentThread) {
            future.cancel(true);
        } else {
            future.cancel(false);
        }
    }
}
