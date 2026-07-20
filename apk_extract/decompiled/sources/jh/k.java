package jh;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements o, j0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6288g = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "suspensionSlot");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6289h = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_closedCause");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6290b;
    private volatile int flushBufferSize;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wi.a f6291c = new wi.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f6292d = new Object();
    volatile /* synthetic */ Object suspensionSlot = c.f6284b;
    public final wi.a e = new wi.a();
    public final wi.a f = new wi.a();
    volatile /* synthetic */ Object _closedCause = null;

    public k(boolean z2) {
        this.f6290b = z2;
    }

    public final void a() {
        j();
        if (f6289h.compareAndSet(this, null, s0.f6302a)) {
            g(null);
        }
    }

    @Override // jh.o
    public final void b(Throwable th2) {
        if (this._closedCause != null) {
            return;
        }
        r0 r0Var = new r0(th2);
        f6289h.compareAndSet(this, null, r0Var);
        g(r0Var.a());
    }

    @Override // jh.o
    public final Throwable c() {
        r0 r0Var = (r0) this._closedCause;
        if (r0Var != null) {
            return r0Var.a();
        }
        return null;
    }

    @Override // jh.o
    public final wi.k d() throws Throwable {
        Throwable thC = c();
        if (thC != null) {
            throw thC;
        }
        wi.a aVar = this.e;
        if (aVar.T()) {
            m();
        }
        return aVar;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0103  */
    /* JADX WARN: Code duplicated, block: B:54:0x0106 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x0108 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:61:0x011d  */
    /* JADX WARN: Code duplicated, block: B:64:0x0128  */
    /* JADX WARN: Code duplicated, block: B:65:0x012a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0109, code lost:
    
        if (r5 != r3) goto L56;
     */
    @Override // jh.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(int r16, kotlin.coroutines.jvm.internal.ContinuationImpl r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jh.k.e(int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // jh.o
    public final boolean f() {
        return c() != null || (l() && this.flushBufferSize == 0 && this.e.T());
    }

    public final void g(Throwable th2) {
        a aVar;
        if (th2 != null) {
            aVar = new a(th2);
        } else {
            g.f6287a.getClass();
            aVar = b.f6282b;
        }
        g gVar = (g) f6288g.getAndSet(this, aVar);
        if (gVar instanceof e) {
            ((e) gVar).a(th2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object h(Continuation continuation) throws Throwable {
        i iVar;
        k kVar;
        if (continuation instanceof i) {
            iVar = (i) continuation;
            int i8 = iVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                iVar.label = i8 - Integer.MIN_VALUE;
            } else {
                iVar = new i(this, continuation);
            }
        } else {
            iVar = new i(this, continuation);
        }
        Object obj = iVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = iVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            Intrinsics.checkNotNullParameter(this, "<this>");
            Throwable thC = c();
            if (thC != null) {
                throw thC;
            }
            j();
            if (this.flushBufferSize < 1048576) {
                return Unit.INSTANCE;
            }
            kVar = this;
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k kVar2 = (k) iVar.L$1;
            k kVar3 = (k) iVar.L$0;
            ResultKt.throwOnFailure(obj);
            kVar = kVar2;
            this = kVar3;
        }
        while (this.flushBufferSize >= 1048576 && this._closedCause == null) {
            iVar.L$0 = this;
            iVar.L$1 = kVar;
            iVar.label = 1;
            li.l lVar = new li.l(1, IntrinsicsKt.intercepted(iVar));
            lVar.s();
            f fVar = new f(lVar);
            g gVar = (g) kVar.suspensionSlot;
            boolean z2 = gVar instanceof a;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6288g;
            if (z2 || atomicReferenceFieldUpdater.compareAndSet(kVar, gVar, fVar)) {
                boolean z3 = gVar instanceof f;
                c cVar = c.f6284b;
                if (z3) {
                    ((e) gVar).a(new t0("write"));
                } else if (gVar instanceof e) {
                    ((e) gVar).resume();
                } else if (z2) {
                    fVar.a(((a) gVar).f6280b);
                } else if (!Intrinsics.areEqual(gVar, cVar)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (this.flushBufferSize < 1048576 || this._closedCause != null) {
                    g gVar2 = (g) kVar.suspensionSlot;
                    if ((gVar2 instanceof f) && atomicReferenceFieldUpdater.compareAndSet(kVar, gVar2, cVar)) {
                        ((e) gVar2).resume();
                    }
                }
            } else {
                fVar.resume();
            }
            Object objR = lVar.r();
            if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(iVar);
            }
            if (objR == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object i(Continuation continuation) {
        j jVar;
        if (continuation instanceof j) {
            jVar = (j) continuation;
            int i8 = jVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                jVar.label = i8 - Integer.MIN_VALUE;
            } else {
                jVar = new j(this, continuation);
            }
        } else {
            jVar = new j(this, continuation);
        }
        Object obj = jVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = jVar.label;
        try {
            if (i9 == 0) {
                ResultKt.throwOnFailure(obj);
                Result.Companion companion = Result.INSTANCE;
                jVar.L$0 = this;
                jVar.label = 1;
                if (h(jVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this = (k) jVar.L$0;
                ResultKt.throwOnFailure(obj);
            }
            Result.m159constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m159constructorimpl(ResultKt.createFailure(th2));
        }
        if (!f6289h.compareAndSet(this, null, s0.f6302a)) {
            return Unit.INSTANCE;
        }
        this.g(null);
        return Unit.INSTANCE;
    }

    public final void j() {
        if (this.f.T()) {
            return;
        }
        synchronized (this.f6292d) {
            wi.a aVar = this.f;
            int i8 = (int) aVar.f10764c;
            this.f6291c.k(aVar);
            this.flushBufferSize += i8;
            Unit unit = Unit.INSTANCE;
        }
        g gVar = (g) this.suspensionSlot;
        if ((gVar instanceof d) && f6288g.compareAndSet(this, gVar, c.f6284b)) {
            ((e) gVar).resume();
        }
    }

    public final wi.a k() throws Throwable {
        Throwable thC = c();
        if (thC != null) {
            throw thC;
        }
        if (l()) {
            throw new IOException("Channel is closed for write");
        }
        return this.f;
    }

    public final boolean l() {
        return this._closedCause != null;
    }

    public final void m() {
        synchronized (this.f6292d) {
            this.f6291c.D(this.e);
            this.flushBufferSize = 0;
            Unit unit = Unit.INSTANCE;
        }
        g gVar = (g) this.suspensionSlot;
        if ((gVar instanceof f) && f6288g.compareAndSet(this, gVar, c.f6284b)) {
            ((e) gVar).resume();
        }
    }

    public final String toString() {
        return "ByteChannel[" + hashCode() + ']';
    }
}
