package nq;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
public final class m1 implements n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Future<?> f11886a;

    public m1(@os.l Future<?> future) {
        this.f11886a = future;
    }

    @Override // nq.n1
    public void dispose() {
        this.f11886a.cancel(false);
    }

    @os.l
    public String toString() {
        return "DisposableFutureHandle[" + this.f11886a + ']';
    }
}
