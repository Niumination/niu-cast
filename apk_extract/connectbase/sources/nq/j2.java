package nq;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class j2 extends n2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final AtomicIntegerFieldUpdater f11870f = AtomicIntegerFieldUpdater.newUpdater(j2.class, "_invoked");

    @in.x
    private volatile int _invoked;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final jn.l<Throwable, lm.l2> f11871e;

    /* JADX WARN: Multi-variable type inference failed */
    public j2(@os.l jn.l<? super Throwable, lm.l2> lVar) {
        this.f11871e = lVar;
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ lm.l2 invoke(Throwable th2) {
        invoke2(th2);
        return lm.l2.f10208a;
    }

    @Override // nq.f0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(@os.m Throwable th2) {
        if (f11870f.compareAndSet(this, 0, 1)) {
            this.f11871e.invoke(th2);
        }
    }
}
