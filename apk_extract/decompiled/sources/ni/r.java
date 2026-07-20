package ni;

import eb.t0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import li.q1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class r extends li.a implements q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f8323d;

    public r(CoroutineContext coroutineContext, m mVar, boolean z2, boolean z3) {
        super(coroutineContext, z2, z3);
        this.f8323d = mVar;
    }

    @Override // li.x1
    public final void C(CancellationException cancellationException) {
        this.f8323d.g(true, cancellationException);
        z(cancellationException);
    }

    @Override // ni.f0
    public final Object e(ContinuationImpl continuationImpl) {
        m mVar = this.f8323d;
        mVar.getClass();
        Object objC = m.C(mVar, continuationImpl);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return objC;
    }

    @Override // ni.g0
    public Object f(Object obj) {
        return this.f8323d.f(obj);
    }

    @Override // li.x1, li.p1
    public final void h(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new q1(F(), null, this);
        }
        C(cancellationException);
    }

    @Override // ni.f0
    public final f iterator() {
        m mVar = this.f8323d;
        mVar.getClass();
        return new f(mVar);
    }

    @Override // ni.f0
    public final Object j(ContinuationImpl continuationImpl) {
        return this.f8323d.j(continuationImpl);
    }

    @Override // ni.f0
    public final dj.m n() {
        return this.f8323d.n();
    }

    @Override // ni.g0
    public boolean q(Throwable th2) {
        return this.f8323d.g(false, th2);
    }

    @Override // ni.g0
    public Object r(Object obj, Continuation continuation) {
        return this.f8323d.r(obj, continuation);
    }

    public final void t0(t0 t0Var) {
        a8.a aVar;
        m mVar = this.f8323d;
        mVar.getClass();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m.f8302n;
        if (atomicReferenceFieldUpdater.compareAndSet(mVar, null, t0Var)) {
            return;
        }
        do {
            Object obj = atomicReferenceFieldUpdater.get(mVar);
            aVar = o.q;
            if (obj != aVar) {
                if (obj == o.f8319r) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked");
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(mVar, aVar, o.f8319r));
        t0Var.invoke(mVar.o());
    }
}
