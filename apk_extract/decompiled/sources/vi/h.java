package vi;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import li.l;
import li.l0;
import li.s2;
import qi.w;

/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f10597c = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "head$volatile");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f10598d = AtomicLongFieldUpdater.newUpdater(h.class, "deqIdx$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "tail$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(h.class, "enqIdx$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10599g = AtomicIntegerFieldUpdater.newUpdater(h.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final li.k f10601b;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    public h(int i8, int i9) {
        this.f10600a = i8;
        if (i8 <= 0) {
            throw new IllegalArgumentException(a1.a.o(i8, "Semaphore should have at least 1 permit, but had ").toString());
        }
        if (i9 < 0 || i9 > i8) {
            throw new IllegalArgumentException(a1.a.o(i8, "The number of acquired permits should be in 0..").toString());
        }
        k kVar = new k(0L, null, 2);
        this.head$volatile = kVar;
        this.tail$volatile = kVar;
        this._availablePermits$volatile = i8 - i9;
        this.f10601b = new li.k(this, 2);
    }

    public final Object a(ContinuationImpl continuationImpl) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int andDecrement;
        int i8;
        do {
            atomicIntegerFieldUpdater = f10599g;
            andDecrement = atomicIntegerFieldUpdater.getAndDecrement(this);
            i8 = this.f10600a;
        } while (andDecrement > i8);
        if (andDecrement > 0) {
            return Unit.INSTANCE;
        }
        l lVarL = l0.l(IntrinsicsKt.intercepted(continuationImpl));
        try {
            if (!b(lVarL)) {
                while (true) {
                    int andDecrement2 = atomicIntegerFieldUpdater.getAndDecrement(this);
                    if (andDecrement2 <= i8) {
                        if (andDecrement2 > 0) {
                            lVarL.p(Unit.INSTANCE, this.f10601b);
                            break;
                        }
                        Intrinsics.checkNotNull(lVarL, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
                        if (b(lVarL)) {
                            break;
                        }
                    }
                }
            }
            Object objR = lVarL.r();
            if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuationImpl);
            }
            if (objR != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                objR = Unit.INSTANCE;
            }
            return objR == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objR : Unit.INSTANCE;
        } catch (Throwable th2) {
            lVarL.A();
            throw th2;
        }
    }

    public final boolean b(s2 s2Var) {
        Object objA;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        k kVar = (k) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f.getAndIncrement(this);
        f fVar = f.INSTANCE;
        long j8 = andIncrement / ((long) j.f);
        loop0: while (true) {
            objA = qi.a.a(kVar, j8, fVar);
            if (!qi.g.f(objA)) {
                w wVarD = qi.g.d(objA);
                while (true) {
                    w wVar = (w) atomicReferenceFieldUpdater.get(this);
                    if (wVar.f9170c >= wVarD.f9170c) {
                        break loop0;
                    }
                    if (!wVarD.j()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, wVar, wVarD)) {
                        if (!wVar.f()) {
                            break loop0;
                        }
                        wVar.e();
                        break loop0;
                    }
                    if (wVarD.f()) {
                        wVarD.e();
                    }
                }
            } else {
                break;
            }
        }
        k kVar2 = (k) qi.g.d(objA);
        int i8 = (int) (andIncrement % ((long) j.f));
        AtomicReferenceArray atomicReferenceArray = kVar2.e;
        if (atomicReferenceArray.compareAndSet(i8, null, s2Var)) {
            s2Var.c(kVar2, i8);
            return true;
        }
        if (!atomicReferenceArray.compareAndSet(i8, j.f10603b, j.f10604c)) {
            return false;
        }
        if (s2Var instanceof li.j) {
            Intrinsics.checkNotNull(s2Var, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((li.j) s2Var).p(Unit.INSTANCE, this.f10601b);
        } else {
            if (!(s2Var instanceof ti.f)) {
                throw new IllegalStateException(("unexpected: " + s2Var).toString());
            }
            ((ti.e) ((ti.f) s2Var)).e = Unit.INSTANCE;
        }
        return true;
    }

    public final void c() {
        int i8;
        Object objA;
        int i9;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f10599g;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            int i10 = this.f10600a;
            if (andIncrement >= i10) {
                do {
                    i8 = atomicIntegerFieldUpdater.get(this);
                    if (i8 <= i10) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i8, i10));
                throw new IllegalStateException(("The number of released permits cannot be greater than " + i10).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10597c;
            k kVar = (k) atomicReferenceFieldUpdater.get(this);
            long andIncrement2 = f10598d.getAndIncrement(this);
            long j8 = andIncrement2 / ((long) j.f);
            g gVar = g.INSTANCE;
            while (true) {
                objA = qi.a.a(kVar, j8, gVar);
                if (!qi.g.f(objA)) {
                    w wVarD = qi.g.d(objA);
                    while (true) {
                        w wVar = (w) atomicReferenceFieldUpdater.get(this);
                        if (wVar.f9170c >= wVarD.f9170c) {
                            break;
                        }
                        if (!wVarD.j()) {
                            break;
                        }
                        if (atomicReferenceFieldUpdater.compareAndSet(this, wVar, wVarD)) {
                            if (!wVar.f()) {
                                break;
                            }
                            wVar.e();
                            break;
                        } else if (wVarD.f()) {
                            wVarD.e();
                        }
                    }
                } else {
                    break;
                }
            }
            k kVar2 = (k) qi.g.d(objA);
            kVar2.b();
            i9 = 0;
            if (kVar2.f9170c <= j8) {
                int i11 = (int) (andIncrement2 % ((long) j.f));
                a8.a aVar = j.f10603b;
                AtomicReferenceArray atomicReferenceArray = kVar2.e;
                Object andSet = atomicReferenceArray.getAndSet(i11, aVar);
                if (andSet == null) {
                    int i12 = j.f10602a;
                    while (true) {
                        if (i9 >= i12) {
                            i9 = !atomicReferenceArray.compareAndSet(i11, j.f10603b, j.f10605d) ? 1 : 0;
                            break;
                        } else {
                            if (atomicReferenceArray.get(i11) == j.f10604c) {
                                i9 = 1;
                                break;
                            }
                            i9++;
                        }
                    }
                } else if (andSet != j.e) {
                    if (andSet instanceof li.j) {
                        Intrinsics.checkNotNull(andSet, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
                        li.j jVar = (li.j) andSet;
                        a8.a aVarD = jVar.d(Unit.INSTANCE, this.f10601b);
                        if (aVarD != null) {
                            jVar.u(aVarD);
                            i9 = 1;
                            break;
                            break;
                        }
                    } else {
                        if (!(andSet instanceof ti.f)) {
                            throw new IllegalStateException(("unexpected: " + andSet).toString());
                        }
                        if (((ti.e) ((ti.f) andSet)).g(this, Unit.INSTANCE) == 0) {
                            i9 = 1;
                            break;
                            break;
                        }
                    }
                }
            }
        } while (i9 == 0);
    }
}
