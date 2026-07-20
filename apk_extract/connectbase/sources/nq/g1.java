package nq;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
@lm.z0
public final class g1<T> extends vq.q0<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final AtomicIntegerFieldUpdater f11853e = AtomicIntegerFieldUpdater.newUpdater(g1.class, "_decision");

    @in.f
    @in.x
    private volatile int _decision;

    public g1(@os.l um.g gVar, @os.l um.d<? super T> dVar) {
        super(gVar, dVar);
    }

    @os.l
    public static final AtomicIntegerFieldUpdater W1() {
        return f11853e;
    }

    private final void X1(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, jn.l<? super Integer, lm.l2> lVar, Object obj) {
        while (true) {
            lVar.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    @Override // vq.q0, nq.a
    public void O1(@os.m Object obj) {
        if (Z1()) {
            return;
        }
        vq.n.e(wm.c.e(this.f17874d), j0.a(obj, this.f17874d), null, 2, null);
    }

    @os.m
    public final Object V1() {
        if (a2()) {
            return wm.a.COROUTINE_SUSPENDED;
        }
        Object objH = u2.h(V0());
        if (objH instanceof d0) {
            throw ((d0) objH).f11836a;
        }
        return objH;
    }

    @Override // vq.q0, nq.t2
    public void X(@os.m Object obj) {
        O1(obj);
    }

    public final boolean Z1() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f11853e;
        do {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f11853e.compareAndSet(this, 0, 2));
        return true;
    }

    public final boolean a2() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f11853e;
        do {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f11853e.compareAndSet(this, 0, 1));
        return true;
    }
}
