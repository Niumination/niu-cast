package nq;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends s2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final Future<?> f11884e;

    public m(@os.l Future<?> future) {
        this.f11884e = future;
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ lm.l2 invoke(Throwable th2) {
        invoke2(th2);
        return lm.l2.f10208a;
    }

    @Override // nq.f0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(@os.m Throwable th2) {
        if (th2 != null) {
            this.f11884e.cancel(false);
        }
    }
}
