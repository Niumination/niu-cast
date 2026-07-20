package sq;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.r1;
import lm.c1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowSlot\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,428:1\n1#2:429\n314#3,11:430\n*S KotlinDebug\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowSlot\n*L\n298#1:430,11\n*E\n"})
public final class x0 extends tq.d<v0<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f15393a = AtomicReferenceFieldUpdater.newUpdater(x0.class, Object.class, "_state");

    @os.m
    @in.x
    private volatile Object _state;

    @Override // tq.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@os.l v0<?> v0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15393a;
        if (atomicReferenceFieldUpdater.get(this) != null) {
            return false;
        }
        atomicReferenceFieldUpdater.set(this, w0.f15391a);
        return true;
    }

    @os.m
    public final Object e(@os.l um.d<? super l2> dVar) {
        nq.q qVar = new nq.q(wm.c.e(dVar), 1);
        qVar.F();
        if (!j.d.a(f15393a, this, w0.f15391a, qVar)) {
            c1.a aVar = c1.Companion;
            qVar.resumeWith(c1.m59constructorimpl(l2.f10208a));
        }
        Object objZ = qVar.z();
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        if (objZ == aVar2) {
            xm.h.c(dVar);
        }
        return objZ == aVar2 ? objZ : l2.f10208a;
    }

    @Override // tq.d
    @os.l
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public um.d<l2>[] b(@os.l v0<?> v0Var) {
        f15393a.set(this, null);
        return tq.c.f16028a;
    }

    public final void g(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, jn.l<Object, l2> lVar, Object obj) {
        while (true) {
            lVar.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public final void h() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15393a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null || obj == w0.f15392b) {
                return;
            }
            vq.u0 u0Var = w0.f15391a;
            if (obj == u0Var) {
                if (j.d.a(f15393a, this, obj, w0.f15392b)) {
                    return;
                }
            } else if (j.d.a(f15393a, this, obj, u0Var)) {
                c1.a aVar = c1.Companion;
                ((nq.q) obj).resumeWith(c1.m59constructorimpl(l2.f10208a));
                return;
            }
        }
    }

    public final boolean i() {
        Object andSet = f15393a.getAndSet(this, w0.f15391a);
        kn.l0.m(andSet);
        return andSet == w0.f15392b;
    }
}
