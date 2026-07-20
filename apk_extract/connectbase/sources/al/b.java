package al;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import kn.l0;
import lm.c1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class b<T, F extends Future<T>> implements GenericFutureListener<F>, jn.l<Throwable, l2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final F f327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final nq.p<T> f328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final jn.p<Throwable, um.d<? super T>, l2> f329c;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@os.l F f10, @os.l nq.p<? super T> pVar, @os.l jn.p<? super Throwable, ? super um.d<? super T>, l2> pVar2) {
        l0.p(f10, "future");
        l0.p(pVar, "continuation");
        l0.p(pVar2, "exception");
        this.f327a = f10;
        this.f328b = pVar;
        this.f329c = pVar2;
        pVar.H(this);
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
        invoke2(th2);
        return l2.f10208a;
    }

    @Override // io.netty.util.concurrent.GenericFutureListener
    public void operationComplete(@os.l F f10) {
        l0.p(f10, "future");
        try {
            Object obj = f10.get();
            nq.p<T> pVar = this.f328b;
            c1.a aVar = c1.Companion;
            pVar.resumeWith(c1.m59constructorimpl(obj));
        } catch (Throwable th2) {
            this.f329c.invoke(a.g(th2), this.f328b);
        }
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(@os.m Throwable th2) {
        this.f327a.removeListener(this);
        if (this.f328b.isCancelled()) {
            this.f327a.cancel(false);
        }
    }
}
