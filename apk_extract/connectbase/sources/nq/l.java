package nq;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Future<?> f11880a;

    public l(@os.l Future<?> future) {
        this.f11880a = future;
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ lm.l2 invoke(Throwable th2) {
        invoke2(th2);
        return lm.l2.f10208a;
    }

    @os.l
    public String toString() {
        return "CancelFutureOnCancel[" + this.f11880a + ']';
    }

    @Override // nq.o
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(@os.m Throwable th2) {
        if (th2 != null) {
            this.f11880a.cancel(false);
        }
    }
}
