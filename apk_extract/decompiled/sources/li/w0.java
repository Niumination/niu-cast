package li;

import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class w0 implements x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledFuture f7504a;

    public w0(ScheduledFuture scheduledFuture) {
        this.f7504a = scheduledFuture;
    }

    @Override // li.x0
    public final void dispose() {
        this.f7504a.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.f7504a + ']';
    }
}
