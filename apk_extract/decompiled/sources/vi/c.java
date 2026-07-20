package vi;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import li.l;
import li.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends h implements a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f10595h = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "owner$volatile");
    private volatile /* synthetic */ Object owner$volatile;

    public c(boolean z2) {
        super(1, z2 ? 1 : 0);
        this.owner$volatile = z2 ? null : d.f10596a;
    }

    public final Object d(Object obj, ContinuationImpl continuationImpl) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i8;
        int i9;
        char c9;
        while (true) {
            atomicIntegerFieldUpdater = h.f10599g;
            int i10 = atomicIntegerFieldUpdater.get(this);
            i8 = this.f10600a;
            if (i10 > i8) {
                do {
                    i9 = atomicIntegerFieldUpdater.get(this);
                    if (i9 <= i8) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i9, i8));
            } else {
                c9 = 0;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10595h;
                if (i10 <= 0) {
                    if (obj != null) {
                        while (Math.max(atomicIntegerFieldUpdater.get(this), 0) == 0) {
                            Object obj2 = atomicReferenceFieldUpdater.get(this);
                            if (obj2 != d.f10596a) {
                                if (obj2 != obj) {
                                    c9 = 2;
                                    break;
                                }
                                c9 = 1;
                                break;
                            }
                        }
                        if (c9 == 1) {
                            c9 = 2;
                            break;
                        }
                        if (c9 != 2) {
                        }
                    }
                    c9 = 1;
                    break;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 - 1)) {
                    atomicReferenceFieldUpdater.set(this, obj);
                    break;
                }
            }
        }
        if (c9 == 0) {
            return Unit.INSTANCE;
        }
        if (c9 != 1) {
            if (c9 != 2) {
                throw new IllegalStateException("unexpected");
            }
            throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
        }
        l lVarL = l0.l(IntrinsicsKt.intercepted(continuationImpl));
        try {
            b bVar = new b(this, lVarL, obj);
            while (true) {
                int andDecrement = atomicIntegerFieldUpdater.getAndDecrement(this);
                if (andDecrement <= i8) {
                    if (andDecrement > 0) {
                        bVar.p(Unit.INSTANCE, this.f10601b);
                        break;
                    }
                    Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
                    if (b(bVar)) {
                        break;
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

    public final void e(Object obj) {
        while (Math.max(h.f10599g.get(this), 0) == 0) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10595h;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            a8.a aVar = d.f10596a;
            if (obj2 != aVar) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, aVar)) {
                    c();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Mutex@");
        sb2.append(l0.j(this));
        sb2.append("[isLocked=");
        sb2.append(Math.max(h.f10599g.get(this), 0) == 0);
        sb2.append(",owner=");
        sb2.append(f10595h.get(this));
        sb2.append(']');
        return sb2.toString();
    }
}
