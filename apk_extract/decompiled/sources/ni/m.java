package ni;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlin.time.DurationKt;
import li.l0;
import li.s2;

/* JADX INFO: loaded from: classes3.dex */
public class m implements q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f8295d = AtomicLongFieldUpdater.newUpdater(m.class, "sendersAndCloseStatus$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(m.class, "receivers$volatile");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f8296h = AtomicLongFieldUpdater.newUpdater(m.class, "bufferEnd$volatile");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f8297i = AtomicLongFieldUpdater.newUpdater(m.class, "completedExpandBuffersAndPauseFlag$volatile");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8298j = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "sendSegment$volatile");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8299k = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "receiveSegment$volatile");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8300l = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "bufferEndSegment$volatile");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8301m = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_closeCause$volatile");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8302n = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1 f8304b;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final li.k f8305c;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    public m(int i8, Function1 function1) {
        this.f8303a = i8;
        this.f8304b = function1;
        if (i8 < 0) {
            throw new IllegalArgumentException(h0.a.h(i8, "Invalid channel capacity: ", ", should be >=0").toString());
        }
        v vVar = o.f8306a;
        this.bufferEnd$volatile = i8 != 0 ? i8 != Integer.MAX_VALUE ? i8 : Long.MAX_VALUE : 0L;
        this.completedExpandBuffersAndPauseFlag$volatile = f8296h.get(this);
        v vVar2 = new v(0L, null, this, 3);
        this.sendSegment$volatile = vVar2;
        this.receiveSegment$volatile = vVar2;
        if (z()) {
            vVar2 = o.f8306a;
            Intrinsics.checkNotNull(vVar2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment$volatile = vVar2;
        this.f8305c = function1 != null ? new li.k(this, 1) : null;
        this._closeCause$volatile = o.f8320s;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public static Object C(m mVar, ContinuationImpl continuationImpl) {
        k kVar;
        Object objD;
        if (continuationImpl instanceof k) {
            kVar = (k) continuationImpl;
            int i8 = kVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                kVar.label = i8 - Integer.MIN_VALUE;
            } else {
                kVar = new k(mVar, continuationImpl);
            }
        } else {
            kVar = new k(mVar, continuationImpl);
        }
        k kVar2 = kVar;
        Object obj = kVar2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = kVar2.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            v vVar = (v) f8299k.get(mVar);
            while (!mVar.w()) {
                long andIncrement = e.getAndIncrement(mVar);
                long j8 = o.f8307b;
                long j10 = andIncrement / j8;
                int i10 = (int) (andIncrement % j8);
                if (vVar.f9170c != j10) {
                    v vVarM = mVar.m(j10, vVar);
                    if (vVarM == null) {
                        continue;
                    } else {
                        vVar = vVarM;
                    }
                }
                Object objI = mVar.I(vVar, i10, andIncrement, null);
                if (objI == o.f8316m) {
                    throw new IllegalStateException("unexpected");
                }
                if (objI == o.f8318o) {
                    if (andIncrement < mVar.t()) {
                        vVar.b();
                    }
                } else {
                    if (objI != o.f8317n) {
                        vVar.b();
                        return objI;
                    }
                    kVar2.label = 1;
                    objD = mVar.D(vVar, i10, andIncrement, kVar2);
                    if (objD == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return new s(mVar.o());
        }
        if (i9 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        objD = ((u) obj).f8326a;
        return objD;
    }

    public static final v a(m mVar, long j8, v vVar) {
        Object objA;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j10;
        long j11;
        mVar.getClass();
        v vVar2 = o.f8306a;
        n nVar = n.INSTANCE;
        loop0: while (true) {
            objA = qi.a.a(vVar, j8, nVar);
            if (!qi.g.f(objA)) {
                qi.w wVarD = qi.g.d(objA);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8298j;
                    qi.w wVar = (qi.w) atomicReferenceFieldUpdater.get(mVar);
                    if (wVar.f9170c >= wVarD.f9170c) {
                        break loop0;
                    }
                    if (!wVarD.j()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(mVar, wVar, wVarD)) {
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
        boolean zF = qi.g.f(objA);
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = e;
        if (zF) {
            mVar.x();
            if (vVar.f9170c * ((long) o.f8307b) >= atomicLongFieldUpdater2.get(mVar)) {
                return null;
            }
            vVar.b();
            return null;
        }
        v vVar3 = (v) qi.g.d(objA);
        long j12 = vVar3.f9170c;
        if (j12 <= j8) {
            return vVar3;
        }
        long j13 = ((long) o.f8307b) * j12;
        do {
            atomicLongFieldUpdater = f8295d;
            j10 = atomicLongFieldUpdater.get(mVar);
            j11 = 1152921504606846975L & j10;
            if (j11 >= j13) {
                break;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(mVar, j10, j11 + (((long) ((int) (j10 >> 60))) << 60)));
        if (j12 * ((long) o.f8307b) >= atomicLongFieldUpdater2.get(mVar)) {
            return null;
        }
        vVar3.b();
        return null;
    }

    public static final void b(m mVar, Object obj, li.l lVar) {
        Function1 function1 = mVar.f8304b;
        if (function1 != null) {
            qi.g.a(function1, obj, lVar.e);
        }
        Throwable thS = mVar.s();
        Result.Companion companion = Result.INSTANCE;
        lVar.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(thS)));
    }

    public static final int c(m mVar, v vVar, int i8, Object obj, long j8, Object obj2, boolean z2) {
        mVar.getClass();
        vVar.n(i8, obj);
        if (z2) {
            return mVar.J(vVar, i8, obj, j8, obj2, z2);
        }
        Object objL = vVar.l(i8);
        if (objL == null) {
            if (mVar.d(j8)) {
                if (vVar.k(i8, null, o.f8309d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (vVar.k(i8, null, obj2)) {
                    return 2;
                }
            }
        } else if (objL instanceof s2) {
            vVar.n(i8, null);
            if (mVar.G(objL, obj)) {
                vVar.o(i8, o.f8312i);
                return 0;
            }
            a8.a aVar = o.f8314k;
            if (vVar.f8327h.getAndSet((i8 * 2) + 1, aVar) != aVar) {
                vVar.m(i8, true);
            }
            return 5;
        }
        return mVar.J(vVar, i8, obj, j8, obj2, z2);
    }

    public static void u(m mVar) {
        mVar.getClass();
        AtomicLongFieldUpdater atomicLongFieldUpdater = f8297i;
        if ((atomicLongFieldUpdater.addAndGet(mVar, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(mVar) & 4611686018427387904L) != 0) {
            }
        }
    }

    public final void A(long j8, v vVar) {
        v vVar2;
        v vVar3;
        while (vVar.f9170c < j8 && (vVar3 = (v) vVar.c()) != null) {
            vVar = vVar3;
        }
        while (true) {
            if (!vVar.d() || (vVar2 = (v) vVar.c()) == null) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8300l;
                    qi.w wVar = (qi.w) atomicReferenceFieldUpdater.get(this);
                    if (wVar.f9170c >= vVar.f9170c) {
                        return;
                    }
                    if (!vVar.j()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, wVar, vVar)) {
                        if (wVar.f()) {
                            wVar.e();
                            return;
                        }
                        return;
                    } else if (vVar.f()) {
                        vVar.e();
                    }
                }
            } else {
                vVar = vVar2;
            }
        }
    }

    public final Object B(Object obj, Continuation continuation) {
        qi.c0 c0VarB;
        li.l lVar = new li.l(1, IntrinsicsKt.intercepted(continuation));
        lVar.s();
        Function1 function1 = this.f8304b;
        if (function1 == null || (c0VarB = qi.g.b(function1, obj, null)) == null) {
            Throwable thS = s();
            Result.Companion companion = Result.INSTANCE;
            lVar.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(thS)));
        } else {
            ExceptionsKt.addSuppressed(c0VarB, s());
            Result.Companion companion2 = Result.INSTANCE;
            lVar.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(c0VarB)));
        }
        Object objR = lVar.r();
        if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objR == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objR : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    public final Object D(v vVar, int i8, long j8, ContinuationImpl continuationImpl) {
        l lVar;
        u uVar;
        h hVar;
        v vVar2;
        if (continuationImpl instanceof l) {
            lVar = (l) continuationImpl;
            int i9 = lVar.label;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                lVar.label = i9 - Integer.MIN_VALUE;
            } else {
                lVar = new l(this, continuationImpl);
            }
        } else {
            lVar = new l(this, continuationImpl);
        }
        l lVar2 = lVar;
        Object objR = lVar2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = lVar2.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(objR);
            lVar2.L$0 = this;
            lVar2.L$1 = vVar;
            lVar2.I$0 = i8;
            lVar2.J$0 = j8;
            lVar2.label = 1;
            li.l lVarL = l0.l(IntrinsicsKt.intercepted(lVar2));
            try {
                Intrinsics.checkNotNull(lVarL, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$38>>");
                e0 e0Var = new e0(lVarL);
                Object objI = I(vVar, i8, j8, e0Var);
                if (objI != o.f8316m) {
                    Object obj = o.f8318o;
                    Function1 function1 = this.f8304b;
                    if (objI == obj) {
                        if (j8 < t()) {
                            vVar.b();
                        }
                        v vVar3 = (v) f8299k.get(this);
                        while (true) {
                            if (w()) {
                                Result.Companion companion = Result.INSTANCE;
                                lVarL.resumeWith(Result.m159constructorimpl(new u(new s(o()))));
                                break;
                            }
                            long andIncrement = e.getAndIncrement(this);
                            long j10 = o.f8307b;
                            long j11 = andIncrement / j10;
                            int i11 = (int) (andIncrement % j10);
                            if (vVar3.f9170c != j11) {
                                v vVarM = m(j11, vVar3);
                                if (vVarM != null) {
                                    vVar2 = vVarM;
                                }
                            } else {
                                vVar2 = vVar3;
                            }
                            v vVar4 = vVar2;
                            Object objI2 = I(vVar2, i11, andIncrement, e0Var);
                            if (objI2 == o.f8316m) {
                                e0Var.c(vVar4, i11);
                                break;
                            }
                            if (objI2 == o.f8318o) {
                                if (andIncrement < t()) {
                                    vVar4.b();
                                }
                                vVar3 = vVar4;
                            } else {
                                if (objI2 == o.f8317n) {
                                    throw new IllegalStateException("unexpected");
                                }
                                vVar4.b();
                                uVar = new u(objI2);
                                hVar = function1 != null ? new h(this) : null;
                            }
                        }
                    } else {
                        vVar.b();
                        uVar = new u(objI);
                        hVar = function1 != null ? new h(this) : null;
                    }
                    lVarL.p(uVar, hVar);
                    break;
                }
                e0Var.c(vVar, i8);
                objR = lVarL.r();
                if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(lVar2);
                }
                if (objR == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Throwable th2) {
                lVarL.A();
                throw th2;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objR);
        }
        return ((u) objR).f8326a;
    }

    public final void E(s2 s2Var, boolean z2) {
        if (s2Var instanceof li.j) {
            Continuation continuation = (Continuation) s2Var;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(z2 ? p() : s())));
            return;
        }
        if (s2Var instanceof e0) {
            li.l lVar = ((e0) s2Var).f8290a;
            Result.Companion companion2 = Result.INSTANCE;
            lVar.resumeWith(Result.m159constructorimpl(new u(new s(o()))));
            return;
        }
        if (!(s2Var instanceof f)) {
            if (s2Var instanceof ti.f) {
                ((ti.e) ((ti.f) s2Var)).g(this, o.f8315l);
                return;
            } else {
                throw new IllegalStateException(("Unexpected waiter: " + s2Var).toString());
            }
        }
        f fVar = (f) s2Var;
        li.l lVar2 = fVar.f8292b;
        Intrinsics.checkNotNull(lVar2);
        fVar.f8292b = null;
        fVar.f8291a = o.f8315l;
        Throwable thO = fVar.f8293c.o();
        if (thO == null) {
            Result.Companion companion3 = Result.INSTANCE;
            lVar2.resumeWith(Result.m159constructorimpl(Boolean.FALSE));
        } else {
            Result.Companion companion4 = Result.INSTANCE;
            lVar2.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(thO)));
        }
    }

    public final Object F() {
        v vVar;
        AtomicLongFieldUpdater atomicLongFieldUpdater = e;
        long j8 = atomicLongFieldUpdater.get(this);
        long j10 = f8295d.get(this);
        if (v(j10, true)) {
            return new s(o());
        }
        long j11 = j10 & 1152921504606846975L;
        Object obj = u.f8325b;
        if (j8 >= j11) {
            return obj;
        }
        Object obj2 = o.f8314k;
        v vVar2 = (v) f8299k.get(this);
        while (!w()) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j12 = o.f8307b;
            long j13 = andIncrement / j12;
            int i8 = (int) (andIncrement % j12);
            if (vVar2.f9170c != j13) {
                v vVarM = m(j13, vVar2);
                if (vVarM == null) {
                    continue;
                } else {
                    vVar = vVarM;
                }
            } else {
                vVar = vVar2;
            }
            Object objI = I(vVar, i8, andIncrement, obj2);
            if (objI == o.f8316m) {
                s2 s2Var = obj2 instanceof s2 ? (s2) obj2 : null;
                if (s2Var != null) {
                    s2Var.c(vVar, i8);
                }
                K(andIncrement);
                vVar.i();
            } else if (objI == o.f8318o) {
                if (andIncrement < t()) {
                    vVar.b();
                }
                vVar2 = vVar;
            } else {
                if (objI == o.f8317n) {
                    throw new IllegalStateException("unexpected");
                }
                vVar.b();
                obj = objI;
            }
            return obj;
        }
        return new s(o());
    }

    public final boolean G(Object obj, Object obj2) {
        if (obj instanceof ti.f) {
            return ((ti.e) ((ti.f) obj)).g(this, obj2) == 0;
        }
        boolean z2 = obj instanceof e0;
        Function1 function1 = this.f8304b;
        if (z2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            return o.a(((e0) obj).f8290a, new u(obj2), function1 != null ? new h(this) : null);
        }
        if (!(obj instanceof f)) {
            if (obj instanceof li.j) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
                return o.a((li.j) obj, obj2, function1 != null ? new g(this) : null);
            }
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
        f fVar = (f) obj;
        li.l lVar = fVar.f8292b;
        Intrinsics.checkNotNull(lVar);
        fVar.f8292b = null;
        fVar.f8291a = obj2;
        Boolean bool = Boolean.TRUE;
        Function1 function2 = fVar.f8293c.f8304b;
        return o.a(lVar, bool, function2 != null ? new d(0, function2, obj2) : null);
    }

    public final boolean H(Object obj, v vVar, int i8) {
        ti.i iVar;
        if (obj instanceof li.j) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return o.a((li.j) obj, Unit.INSTANCE, null);
        }
        if (!(obj instanceof ti.f)) {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        int iG = ((ti.e) obj).g(this, Unit.INSTANCE);
        if (iG == 0) {
            iVar = ti.i.SUCCESSFUL;
        } else if (iG == 1) {
            iVar = ti.i.REREGISTER;
        } else if (iG == 2) {
            iVar = ti.i.CANCELLED;
        } else {
            if (iG != 3) {
                throw new IllegalStateException(("Unexpected internal result: " + iG).toString());
            }
            iVar = ti.i.ALREADY_SELECTED;
        }
        if (iVar == ti.i.REREGISTER) {
            vVar.n(i8, null);
        }
        return iVar == ti.i.SUCCESSFUL;
    }

    public final Object I(v vVar, int i8, long j8, Object obj) {
        Object objL = vVar.l(i8);
        AtomicReferenceArray atomicReferenceArray = vVar.f8327h;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f8295d;
        if (objL == null) {
            if (j8 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return o.f8317n;
                }
                if (vVar.k(i8, objL, obj)) {
                    l();
                    return o.f8316m;
                }
            }
        } else if (objL == o.f8309d && vVar.k(i8, objL, o.f8312i)) {
            l();
            Object obj2 = atomicReferenceArray.get(i8 * 2);
            vVar.n(i8, null);
            return obj2;
        }
        while (true) {
            Object objL2 = vVar.l(i8);
            if (objL2 == null || objL2 == o.e) {
                if (j8 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (vVar.k(i8, objL2, o.f8311h)) {
                        l();
                        return o.f8318o;
                    }
                } else {
                    if (obj == null) {
                        return o.f8317n;
                    }
                    if (vVar.k(i8, objL2, obj)) {
                        l();
                        return o.f8316m;
                    }
                }
            } else {
                if (objL2 != o.f8309d) {
                    a8.a aVar = o.f8313j;
                    if (objL2 != aVar && objL2 != o.f8311h) {
                        if (objL2 == o.f8315l) {
                            l();
                            return o.f8318o;
                        }
                        if (objL2 != o.f8310g && vVar.k(i8, objL2, o.f)) {
                            boolean z2 = objL2 instanceof h0;
                            if (z2) {
                                objL2 = ((h0) objL2).f8294a;
                            }
                            if (H(objL2, vVar, i8)) {
                                vVar.o(i8, o.f8312i);
                                l();
                                Object obj3 = atomicReferenceArray.get(i8 * 2);
                                vVar.n(i8, null);
                                return obj3;
                            }
                            vVar.o(i8, aVar);
                            vVar.i();
                            if (z2) {
                                l();
                            }
                            return o.f8318o;
                        }
                    }
                    return o.f8318o;
                }
                if (vVar.k(i8, objL2, o.f8312i)) {
                    l();
                    Object obj4 = atomicReferenceArray.get(i8 * 2);
                    vVar.n(i8, null);
                    return obj4;
                }
            }
        }
    }

    public final int J(v vVar, int i8, Object obj, long j8, Object obj2, boolean z2) {
        while (true) {
            Object objL = vVar.l(i8);
            if (objL == null) {
                if (!d(j8) || z2) {
                    if (z2) {
                        if (vVar.k(i8, null, o.f8313j)) {
                            vVar.i();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (vVar.k(i8, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (vVar.k(i8, null, o.f8309d)) {
                    return 1;
                }
            } else {
                if (objL != o.e) {
                    a8.a aVar = o.f8314k;
                    if (objL == aVar) {
                        vVar.n(i8, null);
                        return 5;
                    }
                    if (objL == o.f8311h) {
                        vVar.n(i8, null);
                        return 5;
                    }
                    if (objL == o.f8315l) {
                        vVar.n(i8, null);
                        x();
                        return 4;
                    }
                    vVar.n(i8, null);
                    if (objL instanceof h0) {
                        objL = ((h0) objL).f8294a;
                    }
                    if (G(objL, obj)) {
                        vVar.o(i8, o.f8312i);
                        return 0;
                    }
                    if (vVar.f8327h.getAndSet((i8 * 2) + 1, aVar) == aVar) {
                        return 5;
                    }
                    vVar.m(i8, true);
                    return 5;
                }
                if (vVar.k(i8, objL, o.f8309d)) {
                    return 1;
                }
            }
        }
    }

    public final void K(long j8) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j10;
        long j11;
        if (z()) {
            return;
        }
        do {
            atomicLongFieldUpdater = f8296h;
        } while (atomicLongFieldUpdater.get(this) <= j8);
        int i8 = o.f8308c;
        int i9 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f8297i;
            if (i9 >= i8) {
                do {
                    j10 = atomicLongFieldUpdater2.get(this);
                } while (!atomicLongFieldUpdater2.compareAndSet(this, j10, 4611686018427387904L + (j10 & DurationKt.MAX_MILLIS)));
                while (true) {
                    long j12 = atomicLongFieldUpdater.get(this);
                    long j13 = atomicLongFieldUpdater2.get(this);
                    long j14 = j13 & DurationKt.MAX_MILLIS;
                    boolean z2 = (j13 & 4611686018427387904L) != 0;
                    if (j12 == j14 && j12 == atomicLongFieldUpdater.get(this)) {
                        break;
                    } else if (!z2) {
                        atomicLongFieldUpdater2.compareAndSet(this, j13, j14 + 4611686018427387904L);
                    }
                }
                do {
                    j11 = atomicLongFieldUpdater2.get(this);
                } while (!atomicLongFieldUpdater2.compareAndSet(this, j11, j11 & DurationKt.MAX_MILLIS));
                return;
            }
            long j15 = atomicLongFieldUpdater.get(this);
            if (j15 == (atomicLongFieldUpdater2.get(this) & DurationKt.MAX_MILLIS) && j15 == atomicLongFieldUpdater.get(this)) {
                return;
            } else {
                i9++;
            }
        }
    }

    public final boolean d(long j8) {
        return j8 < f8296h.get(this) || j8 < e.get(this) + ((long) this.f8303a);
    }

    @Override // ni.f0
    public final Object e(ContinuationImpl continuationImpl) {
        return C(this, continuationImpl);
    }

    @Override // ni.g0
    public Object f(Object obj) {
        v vVar;
        v vVar2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f8295d;
        long j8 = atomicLongFieldUpdater.get(this);
        boolean z2 = v(j8, false) ? false : !d(j8 & 1152921504606846975L);
        t tVar = u.f8325b;
        if (z2) {
            return tVar;
        }
        jd.f fVar = o.f8313j;
        v vVar3 = (v) f8298j.get(this);
        while (true) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j10 = andIncrement & 1152921504606846975L;
            boolean zV = v(andIncrement, false);
            int i8 = o.f8307b;
            long j11 = i8;
            long j12 = j10 / j11;
            int i9 = (int) (j10 % j11);
            if (vVar3.f9170c != j12) {
                v vVarA = a(this, j12, vVar3);
                if (vVarA != null) {
                    vVar = vVarA;
                } else if (zV) {
                    return new s(s());
                }
            } else {
                vVar = vVar3;
            }
            v vVar4 = vVar;
            int iC = c(this, vVar, i9, obj, j10, fVar, zV);
            if (iC == 0) {
                vVar4.b();
            } else if (iC != 1) {
                if (iC == 2) {
                    if (zV) {
                        vVar4.i();
                        return new s(s());
                    }
                    s2 s2Var = fVar instanceof s2 ? (s2) fVar : null;
                    if (s2Var != null) {
                        vVar2 = vVar4;
                        s2Var.c(vVar2, i9 + i8);
                    } else {
                        vVar2 = vVar4;
                    }
                    vVar2.i();
                    return tVar;
                }
                if (iC == 3) {
                    throw new IllegalStateException("unexpected");
                }
                if (iC == 4) {
                    if (j10 < e.get(this)) {
                        vVar4.b();
                    }
                    return new s(s());
                }
                if (iC == 5) {
                    vVar4.b();
                }
                vVar3 = vVar4;
            }
            return Unit.INSTANCE;
        }
    }

    public final boolean g(boolean z2, Throwable th2) {
        long j8;
        long j10;
        long j11;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        long j12;
        long j13;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f8295d;
        if (z2) {
            do {
                j13 = atomicLongFieldUpdater.get(this);
                if (((int) (j13 >> 60)) != 0) {
                    break;
                }
                v vVar = o.f8306a;
            } while (!atomicLongFieldUpdater.compareAndSet(this, j13, (((long) 1) << 60) + (j13 & 1152921504606846975L)));
        }
        boolean zCompareAndSet = f8301m.compareAndSet(this, o.f8320s, th2);
        if (z2) {
            do {
                j12 = atomicLongFieldUpdater.get(this);
            } while (!atomicLongFieldUpdater.compareAndSet(this, j12, (((long) 3) << 60) + (j12 & 1152921504606846975L)));
        } else {
            do {
                j8 = atomicLongFieldUpdater.get(this);
                int i8 = (int) (j8 >> 60);
                if (i8 == 0) {
                    j10 = j8 & 1152921504606846975L;
                    j11 = 2;
                } else {
                    if (i8 != 1) {
                        break;
                    }
                    j10 = j8 & 1152921504606846975L;
                    j11 = 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(this, j8, (j11 << 60) + j10));
        }
        x();
        if (zCompareAndSet) {
            do {
                atomicReferenceFieldUpdater = f8302n;
                obj = atomicReferenceFieldUpdater.get(this);
            } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, obj == null ? o.q : o.f8319r));
            if (obj != null) {
                ((Function1) obj).invoke(o());
            }
        }
        return zCompareAndSet;
    }

    @Override // ni.f0
    public final void h(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        g(true, cancellationException);
    }

    public final v i(long j8) {
        Object objG;
        long j10;
        Object obj = f8300l.get(this);
        v vVar = (v) f8298j.get(this);
        if (vVar.f9170c > ((v) obj).f9170c) {
            obj = vVar;
        }
        v vVar2 = (v) f8299k.get(this);
        if (vVar2.f9170c > ((v) obj).f9170c) {
            obj = vVar2;
        }
        qi.b bVar = (qi.b) obj;
        while (true) {
            bVar.getClass();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = qi.b.f9131a;
            Object obj2 = atomicReferenceFieldUpdater.get(bVar);
            a8.a aVar = qi.a.f9128a;
            objG = null;
            if (obj2 == aVar) {
                break;
            }
            qi.b bVar2 = (qi.b) obj2;
            if (bVar2 == null) {
                if (atomicReferenceFieldUpdater.compareAndSet(bVar, null, aVar)) {
                    break;
                }
            } else {
                bVar = bVar2;
            }
        }
        v vVar3 = (v) bVar;
        if (y()) {
            v vVar4 = vVar3;
            loop1: while (true) {
                int i8 = o.f8307b - 1;
                while (true) {
                    if (-1 < i8) {
                        j10 = (vVar4.f9170c * ((long) o.f8307b)) + ((long) i8);
                        if (j10 >= e.get(this)) {
                            while (true) {
                                Object objL = vVar4.l(i8);
                                if (objL != null && objL != o.e) {
                                    if (objL != o.f8309d) {
                                        break;
                                    }
                                    break loop1;
                                }
                                if (vVar4.k(i8, objL, o.f8315l)) {
                                    vVar4.i();
                                    break;
                                }
                            }
                            i8--;
                        }
                    } else {
                        vVar4 = (v) ((qi.b) qi.b.f9132b.get(vVar4));
                        if (vVar4 == null) {
                        }
                    }
                    j10 = -1;
                    break;
                }
            }
            if (j10 != -1) {
                k(j10);
            }
        }
        loop4: for (v vVar5 = vVar3; vVar5 != null; vVar5 = (v) ((qi.b) qi.b.f9132b.get(vVar5))) {
            for (int i9 = o.f8307b - 1; -1 < i9; i9--) {
                if ((vVar5.f9170c * ((long) o.f8307b)) + ((long) i9) < j8) {
                    break loop4;
                }
                while (true) {
                    Object objL2 = vVar5.l(i9);
                    if (objL2 != null && objL2 != o.e) {
                        if (!(objL2 instanceof h0)) {
                            if (!(objL2 instanceof s2)) {
                                break;
                            }
                            if (vVar5.k(i9, objL2, o.f8315l)) {
                                objG = qi.g.g(objG, objL2);
                                vVar5.m(i9, true);
                                break;
                            }
                        } else {
                            if (vVar5.k(i9, objL2, o.f8315l)) {
                                objG = qi.g.g(objG, ((h0) objL2).f8294a);
                                vVar5.m(i9, true);
                                break;
                            }
                        }
                    } else {
                        if (vVar5.k(i9, objL2, o.f8315l)) {
                            vVar5.i();
                            break;
                        }
                    }
                }
            }
        }
        if (objG != null) {
            if (objG instanceof ArrayList) {
                Intrinsics.checkNotNull(objG, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
                ArrayList arrayList = (ArrayList) objG;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    E((s2) arrayList.get(size), true);
                }
            } else {
                E((s2) objG, true);
            }
        }
        return vVar3;
    }

    @Override // ni.f0
    public final f iterator() {
        return new f(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [li.l] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.lang.Object, ni.m] */
    @Override // ni.f0
    public final Object j(ContinuationImpl continuationImpl) throws Throwable {
        v vVar;
        ?? r13;
        li.l lVar;
        v vVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8299k;
        v vVar3 = (v) atomicReferenceFieldUpdater.get(this);
        while (!w()) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = e;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j8 = o.f8307b;
            long j10 = andIncrement / j8;
            int i8 = (int) (andIncrement % j8);
            if (vVar3.f9170c != j10) {
                v vVarM = m(j10, vVar3);
                if (vVarM == null) {
                    continue;
                } else {
                    vVar = vVarM;
                }
            } else {
                vVar = vVar3;
            }
            Object objI = I(vVar, i8, andIncrement, null);
            a8.a aVar = o.f8316m;
            if (objI == aVar) {
                throw new IllegalStateException("unexpected");
            }
            a8.a aVar2 = o.f8318o;
            if (objI != aVar2) {
                if (objI == o.f8317n) {
                    li.l lVarL = l0.l(IntrinsicsKt.intercepted(continuationImpl));
                    try {
                        Object objI2 = I(vVar, i8, andIncrement, lVarL);
                        try {
                            if (objI2 != aVar) {
                                lVar = lVarL;
                                g gVar = null;
                                Function1 function1 = this.f8304b;
                                if (objI2 == aVar2) {
                                    if (andIncrement < t()) {
                                        vVar.b();
                                    }
                                    v vVar4 = (v) atomicReferenceFieldUpdater.get(this);
                                    while (true) {
                                        if (w()) {
                                            Result.Companion companion = Result.INSTANCE;
                                            lVar.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(p())));
                                            break;
                                        }
                                        long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(this);
                                        long j11 = o.f8307b;
                                        long j12 = andIncrement2 / j11;
                                        int i9 = (int) (andIncrement2 % j11);
                                        if (vVar4.f9170c != j12) {
                                            v vVarM2 = m(j12, vVar4);
                                            if (vVarM2 != null) {
                                                vVar2 = vVarM2;
                                            }
                                        } else {
                                            vVar2 = vVar4;
                                        }
                                        Function1 function2 = function1;
                                        objI2 = I(vVar2, i9, andIncrement2, lVar);
                                        if (objI2 == o.f8316m) {
                                            lVar.c(vVar2, i9);
                                            break;
                                        }
                                        if (objI2 == o.f8318o) {
                                            if (andIncrement2 < t()) {
                                                vVar2.b();
                                            }
                                            vVar4 = vVar2;
                                            function1 = function2;
                                        } else {
                                            if (objI2 == o.f8317n) {
                                                throw new IllegalStateException("unexpected");
                                            }
                                            vVar2.b();
                                            if (function2 != null) {
                                                gVar = new g(this);
                                            }
                                        }
                                    }
                                } else {
                                    vVar.b();
                                    if (function1 != null) {
                                        gVar = new g(this);
                                    }
                                }
                                lVar.p(objI2, gVar);
                                break;
                            }
                            lVar = lVarL;
                            lVar.c(vVar, i8);
                            objI = lVar.r();
                            if (objI == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                DebugProbesKt.probeCoroutineSuspended(continuationImpl);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            r13 = aVar;
                            r13.A();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        r13 = lVarL;
                    }
                } else {
                    vVar.b();
                }
                return objI;
            }
            if (andIncrement < t()) {
                vVar.b();
            }
            vVar3 = vVar;
        }
        Throwable thP = p();
        int i10 = qi.x.f9171a;
        throw thP;
    }

    public final void k(long j8) {
        qi.c0 c0VarB;
        v vVar = (v) f8299k.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = e;
            long j10 = atomicLongFieldUpdater.get(this);
            if (j8 < Math.max(((long) this.f8303a) + j10, f8296h.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j10, j10 + 1)) {
                long j11 = o.f8307b;
                long j12 = j10 / j11;
                int i8 = (int) (j10 % j11);
                if (vVar.f9170c != j12) {
                    v vVarM = m(j12, vVar);
                    if (vVarM == null) {
                        continue;
                    } else {
                        vVar = vVarM;
                    }
                }
                Object objI = I(vVar, i8, j10, null);
                if (objI != o.f8318o) {
                    vVar.b();
                    Function1 function1 = this.f8304b;
                    if (function1 != null && (c0VarB = qi.g.b(function1, objI, null)) != null) {
                        throw c0VarB;
                    }
                } else if (j10 < t()) {
                    vVar.b();
                }
            }
        }
    }

    public final void l() {
        Object objA;
        if (z()) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8300l;
        v vVar = (v) atomicReferenceFieldUpdater.get(this);
        while (true) {
            long andIncrement = f8296h.getAndIncrement(this);
            long j8 = andIncrement / ((long) o.f8307b);
            if (t() <= andIncrement) {
                if (vVar.f9170c < j8 && vVar.c() != null) {
                    A(j8, vVar);
                }
                u(this);
                return;
            }
            if (vVar.f9170c != j8) {
                n nVar = n.INSTANCE;
                while (true) {
                    objA = qi.a.a(vVar, j8, nVar);
                    if (!qi.g.f(objA)) {
                        qi.w wVarD = qi.g.d(objA);
                        while (true) {
                            qi.w wVar = (qi.w) atomicReferenceFieldUpdater.get(this);
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
                v vVar2 = null;
                if (qi.g.f(objA)) {
                    x();
                    A(j8, vVar);
                    u(this);
                } else {
                    v vVar3 = (v) qi.g.d(objA);
                    long j10 = vVar3.f9170c;
                    if (j10 > j8) {
                        long j11 = o.f8307b;
                        if (f8296h.compareAndSet(this, andIncrement + 1, j10 * j11)) {
                            AtomicLongFieldUpdater atomicLongFieldUpdater = f8297i;
                            if ((atomicLongFieldUpdater.addAndGet(this, (j10 * j11) - andIncrement) & 4611686018427387904L) != 0) {
                                while ((atomicLongFieldUpdater.get(this) & 4611686018427387904L) != 0) {
                                }
                            }
                        } else {
                            u(this);
                        }
                    } else {
                        vVar2 = vVar3;
                    }
                }
                if (vVar2 == null) {
                    continue;
                } else {
                    vVar = vVar2;
                }
            }
            int i8 = (int) (andIncrement % ((long) o.f8307b));
            Object objL = vVar.l(i8);
            boolean z2 = objL instanceof s2;
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = e;
            if (!z2 || andIncrement < atomicLongFieldUpdater2.get(this) || !vVar.k(i8, objL, o.f8310g)) {
                while (true) {
                    Object objL2 = vVar.l(i8);
                    if (objL2 instanceof s2) {
                        if (andIncrement < atomicLongFieldUpdater2.get(this)) {
                            if (vVar.k(i8, objL2, new h0((s2) objL2))) {
                                u(this);
                                return;
                            }
                        } else if (vVar.k(i8, objL2, o.f8310g)) {
                            if (!H(objL2, vVar, i8)) {
                                vVar.o(i8, o.f8313j);
                                vVar.i();
                                break;
                            } else {
                                vVar.o(i8, o.f8309d);
                                u(this);
                                return;
                            }
                        }
                    } else {
                        if (objL2 == o.f8313j) {
                            break;
                        }
                        if (objL2 == null) {
                            if (vVar.k(i8, objL2, o.e)) {
                                u(this);
                                return;
                            }
                        } else if (objL2 == o.f8309d || objL2 == o.f8311h || objL2 == o.f8312i || objL2 == o.f8314k || objL2 == o.f8315l) {
                            u(this);
                            return;
                        } else if (objL2 != o.f) {
                            throw new IllegalStateException(("Unexpected cell state: " + objL2).toString());
                        }
                    }
                }
                u(this);
            } else if (H(objL, vVar, i8)) {
                vVar.o(i8, o.f8309d);
                u(this);
                return;
            } else {
                vVar.o(i8, o.f8313j);
                vVar.i();
                u(this);
            }
        }
    }

    public final v m(long j8, v vVar) {
        Object objA;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j10;
        v vVar2 = o.f8306a;
        n nVar = n.INSTANCE;
        loop0: while (true) {
            objA = qi.a.a(vVar, j8, nVar);
            if (!qi.g.f(objA)) {
                qi.w wVarD = qi.g.d(objA);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8299k;
                    qi.w wVar = (qi.w) atomicReferenceFieldUpdater.get(this);
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
        if (qi.g.f(objA)) {
            x();
            if (vVar.f9170c * ((long) o.f8307b) >= t()) {
                return null;
            }
            vVar.b();
            return null;
        }
        v vVar3 = (v) qi.g.d(objA);
        boolean z2 = z();
        long j11 = vVar3.f9170c;
        if (!z2 && j8 <= f8296h.get(this) / ((long) o.f8307b)) {
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f8300l;
                qi.w wVar2 = (qi.w) atomicReferenceFieldUpdater2.get(this);
                if (wVar2.f9170c >= j11 || !vVar3.j()) {
                    break;
                }
                if (atomicReferenceFieldUpdater2.compareAndSet(this, wVar2, vVar3)) {
                    if (!wVar2.f()) {
                        break;
                    }
                    wVar2.e();
                    break;
                }
                if (vVar3.f()) {
                    vVar3.e();
                }
            }
        }
        if (j11 <= j8) {
            return vVar3;
        }
        long j12 = ((long) o.f8307b) * j11;
        do {
            atomicLongFieldUpdater = e;
            j10 = atomicLongFieldUpdater.get(this);
            if (j10 >= j12) {
                break;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, j12));
        if (j11 * ((long) o.f8307b) >= t()) {
            return null;
        }
        vVar3.b();
        return null;
    }

    @Override // ni.f0
    public final dj.m n() {
        i iVar = i.INSTANCE;
        Intrinsics.checkNotNull(iVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(iVar, 3);
        j jVar = j.INSTANCE;
        Intrinsics.checkNotNull(jVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new dj.m(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(jVar, 3), this.f8305c);
    }

    public final Throwable o() {
        return (Throwable) f8301m.get(this);
    }

    public final Throwable p() {
        Throwable thO = o();
        return thO == null ? new w("Channel was closed") : thO;
    }

    @Override // ni.g0
    public final boolean q(Throwable th2) {
        return g(false, th2);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:105:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [li.l] */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // ni.g0
    public Object r(Object obj, Continuation continuation) throws Throwable {
        v vVar;
        ?? r7;
        li.l lVar;
        Object objM159constructorimpl;
        Object objR;
        v vVar2;
        li.l lVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8298j;
        v vVar3 = (v) atomicReferenceFieldUpdater.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f8295d;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j8 = andIncrement & 1152921504606846975L;
            boolean zV = v(andIncrement, false);
            int i8 = o.f8307b;
            long j10 = i8;
            long j11 = j8 / j10;
            int i9 = (int) (j8 % j10);
            if (vVar3.f9170c != j11) {
                v vVarA = a(this, j11, vVar3);
                if (vVarA != null) {
                    vVar = vVarA;
                } else if (zV) {
                    Object objB = B(obj, continuation);
                    if (objB != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        break;
                    }
                    return objB;
                }
            } else {
                vVar = vVar3;
            }
            v vVar4 = vVar;
            int iC = c(this, vVar, i9, obj, j8, null, zV);
            if (iC == 0) {
                vVar4.b();
                break;
            }
            if (iC != 1) {
                if (iC == 2) {
                    if (!zV) {
                        break;
                    }
                    vVar4.i();
                    Object objB2 = B(obj, continuation);
                    if (objB2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        break;
                    }
                    return objB2;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater2 = e;
                if (iC == 3) {
                    li.l lVarL = l0.l(IntrinsicsKt.intercepted(continuation));
                    try {
                        int iC2 = c(this, vVar4, i9, obj, j8, lVarL, false);
                        try {
                            if (iC2 == 0) {
                                lVar = lVarL;
                                vVar4.b();
                                Result.Companion companion = Result.INSTANCE;
                                objM159constructorimpl = Result.m159constructorimpl(Unit.INSTANCE);
                            } else {
                                if (iC2 != 1) {
                                    if (iC2 != 2) {
                                        if (iC2 != 4) {
                                            if (iC2 != 5) {
                                                throw new IllegalStateException("unexpected");
                                            }
                                            vVar4.b();
                                            v vVar5 = (v) atomicReferenceFieldUpdater.get(this);
                                            while (true) {
                                                long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(this);
                                                long j12 = andIncrement2 & 1152921504606846975L;
                                                boolean zV2 = v(andIncrement2, false);
                                                int i10 = o.f8307b;
                                                long j13 = i10;
                                                long j14 = j12 / j13;
                                                int i11 = (int) (j12 % j13);
                                                if (vVar5.f9170c != j14) {
                                                    try {
                                                        v vVarA2 = a(this, j14, vVar5);
                                                        if (vVarA2 != null) {
                                                            vVar2 = vVarA2;
                                                        } else if (zV2) {
                                                            lVar2 = lVarL;
                                                            try {
                                                                b(this, obj, lVar2);
                                                                lVar = lVar2;
                                                                break;
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                                r7 = lVar2;
                                                                r7.A();
                                                                throw th;
                                                            }
                                                        }
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        lVar2 = lVarL;
                                                    }
                                                } else {
                                                    vVar2 = vVar5;
                                                }
                                                lVarL = lVarL;
                                                v vVar6 = vVar2;
                                                int iC3 = c(this, vVar2, i11, obj, j12, lVarL, zV2);
                                                if (iC3 == 0) {
                                                    lVar = lVarL;
                                                    vVar6.b();
                                                    Result.Companion companion2 = Result.INSTANCE;
                                                    objM159constructorimpl = Result.m159constructorimpl(Unit.INSTANCE);
                                                } else if (iC3 == 1) {
                                                    lVar = lVarL;
                                                    Result.Companion companion3 = Result.INSTANCE;
                                                    objM159constructorimpl = Result.m159constructorimpl(Unit.INSTANCE);
                                                } else if (iC3 == 2) {
                                                    lVar = lVarL;
                                                    if (!zV2) {
                                                        lVar.c(vVar6, i11 + i10);
                                                        break;
                                                    }
                                                    vVar6.i();
                                                } else {
                                                    if (iC3 == 3) {
                                                        throw new IllegalStateException("unexpected");
                                                    }
                                                    if (iC3 != 4) {
                                                        if (iC3 == 5) {
                                                            vVar6.b();
                                                        }
                                                        vVar5 = vVar6;
                                                    } else {
                                                        if (j12 < atomicLongFieldUpdater2.get(this)) {
                                                            vVar6.b();
                                                        }
                                                        lVar = lVarL;
                                                    }
                                                }
                                            }
                                            r7.A();
                                            throw th;
                                        }
                                        lVar = lVarL;
                                        if (j8 < atomicLongFieldUpdater2.get(this)) {
                                            vVar4.b();
                                        }
                                        b(this, obj, lVar);
                                        break;
                                    } else {
                                        lVar = lVarL;
                                        lVar.c(vVar4, i9 + i8);
                                    }
                                    objR = lVar.r();
                                    if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                        DebugProbesKt.probeCoroutineSuspended(continuation);
                                    }
                                    if (objR != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                        objR = Unit.INSTANCE;
                                    }
                                    if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                        break;
                                    }
                                    return objR;
                                }
                                lVar = lVarL;
                                Result.Companion companion4 = Result.INSTANCE;
                                objM159constructorimpl = Result.m159constructorimpl(Unit.INSTANCE);
                            }
                            lVar.resumeWith(objM159constructorimpl);
                            objR = lVar.r();
                            if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                DebugProbesKt.probeCoroutineSuspended(continuation);
                            }
                            if (objR != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                objR = Unit.INSTANCE;
                            }
                            if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                break;
                            }
                            return objR;
                        } catch (Throwable th4) {
                            th = th4;
                            r7 = iC2;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        r7 = lVarL;
                    }
                } else {
                    if (iC == 4) {
                        if (j8 < atomicLongFieldUpdater2.get(this)) {
                            vVar4.b();
                        }
                        Object objB3 = B(obj, continuation);
                        if (objB3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            break;
                        }
                        return objB3;
                    }
                    if (iC == 5) {
                        vVar4.b();
                    }
                    vVar3 = vVar4;
                }
            } else {
                break;
            }
        }
        return Unit.INSTANCE;
    }

    public final Throwable s() {
        Throwable thO = o();
        return thO == null ? new x("Channel was closed") : thO;
    }

    public final long t() {
        return f8295d.get(this) & 1152921504606846975L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        String string;
        StringBuilder sb2 = new StringBuilder();
        int i8 = (int) (f8295d.get(this) >> 60);
        if (i8 == 2) {
            sb2.append("closed,");
        } else if (i8 == 3) {
            sb2.append("cancelled,");
        }
        sb2.append("capacity=" + this.f8303a + ',');
        sb2.append("data=[");
        int i9 = 0;
        List listListOf = CollectionsKt.listOf((Object[]) new v[]{f8299k.get(this), f8298j.get(this), f8300l.get(this)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (((v) obj) != o.f8306a) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j8 = ((v) next).f9170c;
            do {
                Object next2 = it.next();
                long j10 = ((v) next2).f9170c;
                if (j8 > j10) {
                    next = next2;
                    j8 = j10;
                }
            } while (it.hasNext());
        }
        v vVar = (v) next;
        long j11 = e.get(this);
        long jT = t();
        loop2: while (true) {
            int i10 = o.f8307b;
            for (int i11 = i9; i11 < i10; i11++) {
                long j12 = (vVar.f9170c * ((long) o.f8307b)) + ((long) i11);
                if (j12 >= jT && j12 >= j11) {
                    break loop2;
                }
                Object objL = vVar.l(i11);
                Object obj2 = vVar.f8327h.get(i11 * 2);
                if (objL instanceof li.j) {
                    string = (j12 >= j11 || j12 < jT) ? (j12 >= jT || j12 < j11) ? "cont" : "send" : "receive";
                } else if (objL instanceof ti.f) {
                    string = (j12 >= j11 || j12 < jT) ? (j12 >= jT || j12 < j11) ? "select" : "onSend" : "onReceive";
                } else if (objL instanceof e0) {
                    string = "receiveCatching";
                } else if (objL instanceof h0) {
                    string = "EB(" + objL + ')';
                } else if (Intrinsics.areEqual(objL, o.f) || Intrinsics.areEqual(objL, o.f8310g)) {
                    string = "resuming_sender";
                } else {
                    if (objL != null && !Intrinsics.areEqual(objL, o.e) && !Intrinsics.areEqual(objL, o.f8312i) && !Intrinsics.areEqual(objL, o.f8311h) && !Intrinsics.areEqual(objL, o.f8314k) && !Intrinsics.areEqual(objL, o.f8313j) && !Intrinsics.areEqual(objL, o.f8315l)) {
                        string = objL.toString();
                    }
                }
                if (obj2 != null) {
                    sb2.append("(" + string + ',' + obj2 + "),");
                } else {
                    sb2.append(string + ',');
                }
            }
            vVar = (v) vVar.c();
            if (vVar == null) {
                break;
            }
            i9 = 0;
        }
        if (StringsKt.last(sb2) == ',') {
            Intrinsics.checkNotNullExpressionValue(sb2.deleteCharAt(sb2.length() - 1), "deleteCharAt(...)");
        }
        sb2.append("]");
        return sb2.toString();
    }

    public final boolean v(long j8, boolean z2) {
        int i8 = (int) (j8 >> 60);
        if (i8 == 0 || i8 == 1) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = e;
        if (i8 == 2) {
            i(j8 & 1152921504606846975L);
            if (z2) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8299k;
                    v vVarM = (v) atomicReferenceFieldUpdater.get(this);
                    long j10 = atomicLongFieldUpdater.get(this);
                    if (t() <= j10) {
                        break;
                    }
                    long j11 = o.f8307b;
                    long j12 = j10 / j11;
                    if (vVarM.f9170c != j12 && (vVarM = m(j12, vVarM)) == null) {
                        if (((v) atomicReferenceFieldUpdater.get(this)).f9170c < j12) {
                            break;
                        }
                    } else {
                        vVarM.b();
                        int i9 = (int) (j10 % j11);
                        while (true) {
                            Object objL = vVarM.l(i9);
                            if (objL != null && objL != o.e) {
                                if (objL != o.f8309d) {
                                    if (objL != o.f8313j && objL != o.f8315l && objL != o.f8312i && objL != o.f8311h) {
                                        if (objL != o.f8310g) {
                                            if (objL == o.f || j10 != atomicLongFieldUpdater.get(this)) {
                                                break;
                                                break;
                                            }
                                            return false;
                                        }
                                        return false;
                                    }
                                    break;
                                    break;
                                    break;
                                    break;
                                }
                                return false;
                            }
                            if (vVarM.k(i9, objL, o.f8311h)) {
                                l();
                                break;
                            }
                        }
                        e.compareAndSet(this, j10, j10 + 1);
                    }
                }
            }
        } else {
            if (i8 != 3) {
                throw new IllegalStateException(a1.a.o(i8, "unexpected close status: ").toString());
            }
            v vVarI = i(j8 & 1152921504606846975L);
            qi.c0 c0VarB = null;
            Object objG = null;
            loop0: do {
                for (int i10 = o.f8307b - 1; -1 < i10; i10--) {
                    long j13 = (vVarI.f9170c * ((long) o.f8307b)) + ((long) i10);
                    while (true) {
                        Object objL2 = vVarI.l(i10);
                        if (objL2 == o.f8312i) {
                            break loop0;
                        }
                        a8.a aVar = o.f8309d;
                        AtomicReferenceArray atomicReferenceArray = vVarI.f8327h;
                        Function1 function1 = this.f8304b;
                        if (objL2 != aVar) {
                            if (objL2 != o.e && objL2 != null) {
                                if (!(objL2 instanceof s2) && !(objL2 instanceof h0)) {
                                    a8.a aVar2 = o.f8310g;
                                    if (objL2 == aVar2 || objL2 == o.f) {
                                        break loop0;
                                    }
                                    if (objL2 != aVar2) {
                                        break;
                                    }
                                } else {
                                    if (j13 < atomicLongFieldUpdater.get(this)) {
                                        break loop0;
                                    }
                                    s2 s2Var = objL2 instanceof h0 ? ((h0) objL2).f8294a : (s2) objL2;
                                    if (vVarI.k(i10, objL2, o.f8315l)) {
                                        if (function1 != null) {
                                            c0VarB = qi.g.b(function1, atomicReferenceArray.get(i10 * 2), c0VarB);
                                        }
                                        objG = qi.g.g(objG, s2Var);
                                        vVarI.n(i10, null);
                                        vVarI.i();
                                        break;
                                    }
                                }
                            } else if (vVarI.k(i10, objL2, o.f8315l)) {
                                vVarI.i();
                                break;
                            }
                        } else {
                            if (j13 < atomicLongFieldUpdater.get(this)) {
                                break loop0;
                            }
                            if (vVarI.k(i10, objL2, o.f8315l)) {
                                if (function1 != null) {
                                    c0VarB = qi.g.b(function1, atomicReferenceArray.get(i10 * 2), c0VarB);
                                }
                                vVarI.n(i10, null);
                                vVarI.i();
                                break;
                            }
                        }
                    }
                }
                vVarI = (v) ((qi.b) qi.b.f9132b.get(vVarI));
            } while (vVarI != null);
            if (objG != null) {
                if (objG instanceof ArrayList) {
                    Intrinsics.checkNotNull(objG, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
                    ArrayList arrayList = (ArrayList) objG;
                    for (int size = arrayList.size() - 1; -1 < size; size--) {
                        E((s2) arrayList.get(size), false);
                    }
                } else {
                    E((s2) objG, false);
                }
            }
            if (c0VarB != null) {
                throw c0VarB;
            }
        }
        return true;
    }

    public final boolean w() {
        return v(f8295d.get(this), true);
    }

    public final boolean x() {
        return v(f8295d.get(this), false);
    }

    public boolean y() {
        return false;
    }

    public final boolean z() {
        long j8 = f8296h.get(this);
        return j8 == 0 || j8 == Long.MAX_VALUE;
    }
}
