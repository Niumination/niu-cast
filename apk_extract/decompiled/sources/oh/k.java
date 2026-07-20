package oh;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k3.bc;
import k3.h2;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import li.o1;
import li.p1;
import li.p2;
import li.r1;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements d, s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s0 f8500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final li.r f8501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ni.m f8502c;
    private volatile /* synthetic */ int closed;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ni.m f8503d;
    public final r1 e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f8504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CoroutineContext f8505i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f8506j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f8507k;
    volatile /* synthetic */ Object pinger;
    private volatile /* synthetic */ int started;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final q f8499o = new q(new byte[0], z.f8533a);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8496l = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "pinger");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f8497m = AtomicIntegerFieldUpdater.newUpdater(k.class, "closed");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f8498n = AtomicIntegerFieldUpdater.newUpdater(k.class, "started");

    public k(s0 raw, long j8, long j10) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        this.f8500a = raw;
        this.pinger = null;
        this.f8501b = li.l0.b();
        this.f8502c = bc.a(8, 6, null);
        String property = System.getProperty("io.ktor.websocket.outgoingChannelCapacity");
        this.f8503d = bc.a(property != null ? Integer.parseInt(property) : 8, 6, null);
        this.closed = 0;
        r1 r1Var = new r1((p1) raw.getCoroutineContext().get(o1.f7483a));
        this.e = r1Var;
        this.f8504h = new ArrayList();
        this.started = 0;
        this.f8505i = raw.getCoroutineContext().plus(r1Var).plus(new li.f0("ws-default"));
        this.f8506j = j8;
        this.f8507k = j10;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object a(k kVar, wi.j jVar, s sVar, ContinuationImpl continuationImpl) throws w {
        e eVar;
        int i8;
        kVar.getClass();
        if (continuationImpl instanceof e) {
            eVar = (e) continuationImpl;
            int i9 = eVar.label;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                eVar.label = i9 - Integer.MIN_VALUE;
            } else {
                eVar = new e(kVar, continuationImpl);
            }
        } else {
            eVar = new e(kVar, continuationImpl);
        }
        Object obj = eVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = eVar.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            int iF = (jVar != null ? lh.a.f(jVar) : 0) + sVar.f8520c.length;
            long j8 = iF;
            s0 s0Var = kVar.f8500a;
            if (j8 <= s0Var.N()) {
                return Unit.INSTANCE;
            }
            b bVar = b.TOO_BIG;
            StringBuilder sbU = a1.a.u(iF, "Frame is too big: ", ". Max size is ");
            sbU.append(s0Var.N());
            c cVar = new c(bVar, sbU.toString());
            eVar.I$0 = iF;
            eVar.label = 1;
            if (u0.b(kVar, cVar, eVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i8 = iF;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i8 = eVar.I$0;
            ResultKt.throwOnFailure(obj);
        }
        throw new w(i8);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0071  */
    /* JADX WARN: Code duplicated, block: B:26:0x007c  */
    /* JADX WARN: Code duplicated, block: B:28:0x008a  */
    /* JADX WARN: Code duplicated, block: B:34:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:36:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00df -> B:14:0x0039). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object b(oh.k r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: oh.k.b(oh.k, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // oh.s0
    public final Object E(s sVar, ContinuationImpl continuationImpl) {
        Object objR = w().r(sVar, continuationImpl);
        if (objR != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            objR = Unit.INSTANCE;
        }
        return objR == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objR : Unit.INSTANCE;
    }

    @Override // oh.s0
    public final void I(long j8) {
        this.f8500a.I(j8);
    }

    @Override // oh.s0
    public final long N() {
        return this.f8500a.N();
    }

    @Override // oh.d
    public final void b0(List negotiatedExtensions) {
        Intrinsics.checkNotNullParameter(negotiatedExtensions, "negotiatedExtensions");
        if (!f8498n.compareAndSet(this, 0, 1)) {
            throw new IllegalStateException(("WebSocket session " + this + " is already started.").toString());
        }
        vj.b bVar = l.f8508a;
        if (h2.a(bVar)) {
            bVar.trace("Starting default WebSocketSession(" + this + ") with negotiated extensions: " + CollectionsKt___CollectionsKt.joinToString$default(negotiatedExtensions, null, null, null, 0, null, null, 63, null));
        }
        this.f8504h.addAll(negotiatedExtensions);
        d();
        li.f0 f0Var = e0.f8483a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        ni.m outgoing = this.f8503d;
        Intrinsics.checkNotNullParameter(outgoing, "outgoing");
        ni.m mVarA = bc.a(5, 6, null);
        li.l0.p(this, e0.f8483a, null, new d0(mVarA, outgoing, null), 2);
        li.f0 f0Var2 = l.f8509b;
        p2 p2Var = li.v0.f7500c;
        li.l0.p(this, f0Var2.plus(p2Var), null, new g(this, mVarA, null), 2);
        li.l0.o(this, l.f8510c.plus(p2Var), li.j0.UNDISPATCHED, new i(this, null));
    }

    public final void d() {
        ni.m mVarA;
        long j8 = this.f8506j;
        if (this.closed == 0 && j8 > 0) {
            ni.g0 outgoing = this.f8500a.w();
            long j10 = this.f8507k;
            h onTimeout = new h(this, null);
            li.f0 f0Var = e0.f8483a;
            Intrinsics.checkNotNullParameter(this, "<this>");
            Intrinsics.checkNotNullParameter(outgoing, "outgoing");
            Intrinsics.checkNotNullParameter(onTimeout, "onTimeout");
            r1 r1VarC = li.l0.c();
            mVarA = bc.a(Integer.MAX_VALUE, 6, null);
            li.l0.p(this, CoroutineContext.Element.DefaultImpls.plus(r1VarC, e0.f8484b), null, new c0(j8, j10, onTimeout, mVarA, outgoing, null), 2);
            CoroutineContext.Element element = this.f8505i.get(o1.f7483a);
            Intrinsics.checkNotNull(element);
            ((p1) element).A(new ag.d0(r1VarC, 21));
        } else {
            mVarA = null;
        }
        ni.g0 g0Var = (ni.g0) f8496l.getAndSet(this, mVarA);
        if (g0Var != null) {
            g0Var.q(null);
        }
        if (mVarA != null) {
            boolean z2 = mVarA.f(f8499o) instanceof ni.t;
        }
        if (this.closed == 0 || mVarA == null) {
            return;
        }
        d();
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object e(c cVar, Throwable th2, ContinuationImpl continuationImpl) throws Throwable {
        j jVar;
        if (continuationImpl instanceof j) {
            jVar = (j) continuationImpl;
            int i8 = jVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                jVar.label = i8 - Integer.MIN_VALUE;
            } else {
                jVar = new j(this, continuationImpl);
            }
        } else {
            jVar = new j(this, continuationImpl);
        }
        Object obj = jVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = jVar.label;
        if (i9 != 0) {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c cVar2 = (c) jVar.L$2;
            th2 = (Throwable) jVar.L$1;
            k kVar = (k) jVar.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                cVar = cVar2;
                this = kVar;
                this.f8501b.d0(cVar);
                if (th2 != null) {
                    this.f8503d.g(false, th2);
                    this.f8502c.g(false, th2);
                }
                return Unit.INSTANCE;
            } catch (Throwable th3) {
                th = th3;
                cVar = cVar2;
                this = kVar;
                this.f8501b.d0(cVar);
                if (th2 != null) {
                    this.f8503d.g(false, th2);
                    this.f8502c.g(false, th2);
                }
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        if (!f8497m.compareAndSet(this, 0, 1)) {
            return Unit.INSTANCE;
        }
        vj.b bVar = l.f8508a;
        if (h2.a(bVar)) {
            bVar.trace("Sending Close Sequence for session " + this + " with reason " + cVar + " and exception " + th2);
        }
        this.e.r0();
        if (cVar == null) {
            cVar = new c(b.NORMAL, "");
        }
        try {
            d();
            if (cVar.f8481a != b.CLOSED_ABNORMALLY.getCode()) {
                ni.g0 g0VarW = this.f8500a.w();
                n nVar = new n(cVar);
                jVar.L$0 = this;
                jVar.L$1 = th2;
                jVar.L$2 = cVar;
                jVar.label = 1;
                if (g0VarW.r(nVar, jVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            this.f8501b.d0(cVar);
            if (th2 != null) {
                this.f8503d.g(false, th2);
                this.f8502c.g(false, th2);
            }
            return Unit.INSTANCE;
        } catch (Throwable th4) {
            th = th4;
            this.f8501b.d0(cVar);
            if (th2 != null) {
                this.f8503d.g(false, th2);
                this.f8502c.g(false, th2);
            }
            throw th;
        }
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f8505i;
    }

    @Override // oh.s0
    public final Object l(ContinuationImpl continuationImpl) {
        Object objL = this.f8500a.l(continuationImpl);
        return objL == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objL : Unit.INSTANCE;
    }

    @Override // oh.s0
    public final ni.f0 o() {
        return this.f8502c;
    }

    @Override // oh.s0
    public final ni.g0 w() {
        return this.f8503d;
    }
}
