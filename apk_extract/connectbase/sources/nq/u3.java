package nq;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class u3 implements jn.l<Throwable, lm.l2> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final AtomicIntegerFieldUpdater f11959d = AtomicIntegerFieldUpdater.newUpdater(u3.class, "_state");

    @in.x
    private volatile int _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final l2 f11960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Thread f11961b = Thread.currentThread();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public n1 f11962c;

    public u3(@os.l l2 l2Var) {
        this.f11960a = l2Var;
    }

    public final void a() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f11959d;
        while (true) {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        b(i10);
                        throw new lm.y();
                    }
                }
            } else if (f11959d.compareAndSet(this, i10, 1)) {
                n1 n1Var = this.f11962c;
                if (n1Var != null) {
                    n1Var.dispose();
                    return;
                }
                return;
            }
        }
    }

    public final Void b(int i10) {
        throw new IllegalStateException(("Illegal state " + i10).toString());
    }

    public final void c(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, jn.l<? super Integer, lm.l2> lVar, Object obj) {
        while (true) {
            lVar.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    public final void d() {
        int i10;
        this.f11962c = this.f11960a.S1(true, true, this);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f11959d;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 2 || i10 == 3) {
                    return;
                }
                b(i10);
                throw new lm.y();
            }
        } while (!f11959d.compareAndSet(this, i10, 0));
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ lm.l2 invoke(Throwable th2) {
        invoke2(th2);
        return lm.l2.f10208a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(@os.m Throwable th2) {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = f11959d;
        do {
            i10 = atomicIntegerFieldUpdater2.get(this);
            if (i10 != 0) {
                if (i10 == 1 || i10 == 2 || i10 == 3) {
                    return;
                }
                b(i10);
                throw new lm.y();
            }
            atomicIntegerFieldUpdater = f11959d;
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 2));
        this.f11961b.interrupt();
        atomicIntegerFieldUpdater.set(this, 3);
    }
}
