package mk;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import io.netty.handler.traffic.AbstractTrafficShapingHandler;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.l0;
import lm.d1;
import lm.l2;
import nq.a1;
import nq.k1;
import nq.o2;
import nq.r0;
import nq.s0;
import nq.t0;
import nq.u0;
import nq.w1;

/* JADX INFO: loaded from: classes2.dex */
@c0
public final class c implements mk.b, e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final e0 f10742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f10743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final bm.h<ByteBuffer> f10744c;

    @os.l
    private volatile /* synthetic */ int closed;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final nq.y<mk.a> f10745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final pq.l<g> f10746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final pq.l<g> f10747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final nq.b0 f10748g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final List<w<?>> f10749i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public final um.g f10750n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public final a1<mk.a> f10751p;

    @os.l
    volatile /* synthetic */ Object pinger;

    @os.l
    private volatile /* synthetic */ int started;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f10752v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.l
    public static final a f10738w = new a();

    @os.l
    public static final g.e H = new g.e(new byte[0], l.f10801a);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f10739x = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "pinger");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10740y = AtomicIntegerFieldUpdater.newUpdater(c.class, "closed");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10741z = AtomicIntegerFieldUpdater.newUpdater(c.class, "started");

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    @xm.f(c = "io.ktor.http.cio.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSessionImpl.kt", i = {0}, l = {250}, m = "checkMaxFrameSize", n = {ik.f.b.f7973h}, s = {"I$0"})
    public static final class b extends xm.d {
        int I$0;
        int label;
        /* synthetic */ Object result;

        public b(um.d<? super b> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.k(null, null, this);
        }
    }

    /* JADX INFO: renamed from: mk.c$c, reason: collision with other inner class name */
    @xm.f(c = "io.ktor.http.cio.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSessionImpl.kt", i = {0, 2}, l = {189, 192, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION}, m = "outgoingProcessorLoop", n = {"this", "this"}, s = {"L$0", "L$0"})
    public static final class C0282c extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C0282c(um.d<? super C0282c> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.p(this);
        }
    }

    @xm.f(c = "io.ktor.http.cio.websocket.DefaultWebSocketSessionImpl$runIncomingProcessor$1", f = "DefaultWebSocketSessionImpl.kt", i = {0, 0, 0, 1, 1, 1, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6}, l = {287, y5.a.f20722h0, 162, 120, 121, 123, 147, 162, 162, 162, 162}, m = "invokeSuspend", n = {"last", "closeFramePresented", "$this$consume$iv$iv", "last", "closeFramePresented", "$this$consume$iv$iv", "last", "closeFramePresented", "$this$consume$iv$iv", "last", "closeFramePresented", "$this$consume$iv$iv", "last", "closeFramePresented", "$this$consume$iv$iv", TypedValues.AttributesType.S_FRAME, "last", "closeFramePresented", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$4", "L$0", "L$1", "L$2", "L$0", "L$1", "L$4", "L$0", "L$1", "L$4", "L$0", "L$1", "L$4", "L$6", "L$0", "L$1", "L$4"})
    public static final class d extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ pq.g0<g.d> $ponger;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(pq.g0<? super g.d> g0Var, um.d<? super d> dVar) {
            super(2, dVar);
            this.$ponger = g0Var;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return c.this.new d(this.$ponger, dVar);
        }

        /* JADX WARN: Code duplicated, block: B:37:0x0122 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:38:0x0123  */
        /* JADX WARN: Code duplicated, block: B:41:0x0130 A[Catch: all -> 0x0045, TryCatch #2 {all -> 0x0045, blocks: (B:9:0x003b, B:35:0x010c, B:39:0x0128, B:41:0x0130, B:43:0x013a, B:45:0x0142, B:47:0x014e, B:48:0x0152, B:51:0x016b, B:63:0x01ae, B:65:0x01b2, B:68:0x01bf, B:71:0x01d5, B:72:0x01d8, B:74:0x01dc, B:77:0x01f2, B:20:0x0090, B:23:0x00ad, B:27:0x00ca, B:30:0x00e7, B:34:0x0108), top: B:153:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:63:0x01ae A[Catch: all -> 0x0045, TRY_ENTER, TryCatch #2 {all -> 0x0045, blocks: (B:9:0x003b, B:35:0x010c, B:39:0x0128, B:41:0x0130, B:43:0x013a, B:45:0x0142, B:47:0x014e, B:48:0x0152, B:51:0x016b, B:63:0x01ae, B:65:0x01b2, B:68:0x01bf, B:71:0x01d5, B:72:0x01d8, B:74:0x01dc, B:77:0x01f2, B:20:0x0090, B:23:0x00ad, B:27:0x00ca, B:30:0x00e7, B:34:0x0108), top: B:153:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:72:0x01d8 A[Catch: all -> 0x0045, TryCatch #2 {all -> 0x0045, blocks: (B:9:0x003b, B:35:0x010c, B:39:0x0128, B:41:0x0130, B:43:0x013a, B:45:0x0142, B:47:0x014e, B:48:0x0152, B:51:0x016b, B:63:0x01ae, B:65:0x01b2, B:68:0x01bf, B:71:0x01d5, B:72:0x01d8, B:74:0x01dc, B:77:0x01f2, B:20:0x0090, B:23:0x00ad, B:27:0x00ca, B:30:0x00e7, B:34:0x0108), top: B:153:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:74:0x01dc A[Catch: all -> 0x0045, TryCatch #2 {all -> 0x0045, blocks: (B:9:0x003b, B:35:0x010c, B:39:0x0128, B:41:0x0130, B:43:0x013a, B:45:0x0142, B:47:0x014e, B:48:0x0152, B:51:0x016b, B:63:0x01ae, B:65:0x01b2, B:68:0x01bf, B:71:0x01d5, B:72:0x01d8, B:74:0x01dc, B:77:0x01f2, B:20:0x0090, B:23:0x00ad, B:27:0x00ca, B:30:0x00e7, B:34:0x0108), top: B:153:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:76:0x01f1 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:77:0x01f2 A[Catch: all -> 0x0045, TRY_LEAVE, TryCatch #2 {all -> 0x0045, blocks: (B:9:0x003b, B:35:0x010c, B:39:0x0128, B:41:0x0130, B:43:0x013a, B:45:0x0142, B:47:0x014e, B:48:0x0152, B:51:0x016b, B:63:0x01ae, B:65:0x01b2, B:68:0x01bf, B:71:0x01d5, B:72:0x01d8, B:74:0x01dc, B:77:0x01f2, B:20:0x0090, B:23:0x00ad, B:27:0x00ca, B:30:0x00e7, B:34:0x0108), top: B:153:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:79:0x020d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:80:0x020e  */
        /* JADX WARN: Code duplicated, block: B:83:0x021a A[Catch: all -> 0x0225, TryCatch #1 {all -> 0x0225, blocks: (B:81:0x0215, B:83:0x021a, B:85:0x021e, B:88:0x0229, B:89:0x023b, B:96:0x026b, B:92:0x0242), top: B:151:0x0215 }] */
        /* JADX WARN: Code duplicated, block: B:85:0x021e A[Catch: all -> 0x0225, TryCatch #1 {all -> 0x0225, blocks: (B:81:0x0215, B:83:0x021a, B:85:0x021e, B:88:0x0229, B:89:0x023b, B:96:0x026b, B:92:0x0242), top: B:151:0x0215 }] */
        /* JADX WARN: Code duplicated, block: B:88:0x0229 A[Catch: all -> 0x0225, TryCatch #1 {all -> 0x0225, blocks: (B:81:0x0215, B:83:0x021a, B:85:0x021e, B:88:0x0229, B:89:0x023b, B:96:0x026b, B:92:0x0242), top: B:151:0x0215 }] */
        /* JADX WARN: Code duplicated, block: B:89:0x023b A[Catch: all -> 0x0225, TryCatch #1 {all -> 0x0225, blocks: (B:81:0x0215, B:83:0x021a, B:85:0x021e, B:88:0x0229, B:89:0x023b, B:96:0x026b, B:92:0x0242), top: B:151:0x0215 }] */
        /* JADX WARN: Code duplicated, block: B:91:0x0241  */
        /* JADX WARN: Code duplicated, block: B:92:0x0242 A[Catch: all -> 0x0225, TryCatch #1 {all -> 0x0225, blocks: (B:81:0x0215, B:83:0x021a, B:85:0x021e, B:88:0x0229, B:89:0x023b, B:96:0x026b, B:92:0x0242), top: B:151:0x0215 }] */
        /* JADX WARN: Code duplicated, block: B:94:0x0269  */
        /* JADX WARN: Code duplicated, block: B:95:0x026a  */
        /* JADX WARN: Code duplicated, block: B:98:0x028c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:99:0x028d  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v9, types: [T, tl.s] */
        /* JADX WARN: Type inference failed for: r4v27, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r4v36 */
        /* JADX WARN: Type inference failed for: r4v44 */
        /* JADX WARN: Type inference failed for: r4v45 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x01b8 -> B:35:0x010c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x028d -> B:100:0x0291). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r24) {
            /*
                Method dump skipped, instruction units count: 976
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: mk.c.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((d) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.http.cio.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1", f = "DefaultWebSocketSessionImpl.kt", i = {}, l = {173, 183, 183, 183, 183, 183, 180, 183, 183}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        Object L$0;
        int label;

        public e(um.d<? super e> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return c.this.new e(dVar);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x004f A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v16, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v21 */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) throws Throwable {
            ?? r10;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            try {
                try {
                    switch (this.label) {
                        case 0:
                            d1.n(obj);
                            c cVar = c.this;
                            this.label = 1;
                            if (cVar.p(this) == aVar) {
                                return aVar;
                            }
                            pq.f0.a.b(c.this.f10747f, null, 1, null);
                            e0 e0Var = c.this.f10742a;
                            this.label = 2;
                            this = f0.c(e0Var, null, this, 1, null);
                            if (this == aVar) {
                                return aVar;
                            }
                            return l2.f10208a;
                        case 1:
                            d1.n(obj);
                            pq.f0.a.b(c.this.f10747f, null, 1, null);
                            e0 e0Var2 = c.this.f10742a;
                            this.label = 2;
                            this = f0.c(e0Var2, null, this, 1, null);
                            if (this == aVar) {
                                return aVar;
                            }
                            return l2.f10208a;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 8:
                            d1.n(obj);
                            return l2.f10208a;
                        case 7:
                            d1.n(obj);
                            this = this;
                            pq.f0.a.b(c.this.f10747f, null, 1, null);
                            e0 e0Var3 = c.this.f10742a;
                            r10.label = 8;
                            if (f0.c(e0Var3, null, r10, 1, null) == aVar) {
                                return aVar;
                            }
                            return l2.f10208a;
                        case 9:
                            Throwable th2 = (Throwable) this.L$0;
                            d1.n(obj);
                            throw th2;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (gl.c unused) {
                    pq.f0.a.b(c.this.f10747f, null, 1, null);
                    e0 e0Var4 = c.this.f10742a;
                    this.label = 6;
                    if (f0.c(e0Var4, null, this, 1, null) == aVar) {
                        return aVar;
                    }
                } catch (CancellationException unused2) {
                    pq.f0.a.b(c.this.f10747f, null, 1, null);
                    e0 e0Var5 = c.this.f10742a;
                    this.label = 5;
                    if (f0.c(e0Var5, null, this, 1, null) == aVar) {
                        return aVar;
                    }
                } catch (pq.v unused3) {
                    pq.f0.a.b(c.this.f10747f, null, 1, null);
                    e0 e0Var6 = c.this.f10742a;
                    this.label = 4;
                    if (f0.c(e0Var6, null, this, 1, null) == aVar) {
                        return aVar;
                    }
                } catch (pq.w unused4) {
                    pq.f0.a.b(c.this.f10747f, null, 1, null);
                    e0 e0Var7 = c.this.f10742a;
                    this.label = 3;
                    if (f0.c(e0Var7, null, this, 1, null) == aVar) {
                        return aVar;
                    }
                } catch (Throwable th3) {
                    c.this.f10747f.b(w1.a("Failed to send frame", th3));
                    e0 e0Var8 = c.this.f10742a;
                    this.label = 7;
                    Object objD = f0.d(e0Var8, th3, this);
                    r10 = this;
                    if (objD == aVar) {
                        return aVar;
                    }
                }
            } catch (Throwable th4) {
                pq.f0.a.b(c.this.f10747f, null, 1, null);
                e0 e0Var9 = c.this.f10742a;
                this.L$0 = th4;
                this.label = 9;
                if (f0.c(e0Var9, null, this, 1, null) == aVar) {
                    return aVar;
                }
                throw th4;
            }
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((e) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.http.cio.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSessionImpl.kt", i = {0, 0}, l = {213}, m = "sendCloseSequence", n = {"this", "reasonToSend"}, s = {"L$0", "L$1"})
    public static final class f extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public f(um.d<? super f> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.w(null, this);
        }
    }

    public c(@os.l e0 e0Var, long j10, long j11, @os.l bm.h<ByteBuffer> hVar) {
        l0.p(e0Var, "raw");
        l0.p(hVar, "pool");
        this.f10742a = e0Var;
        this.f10743b = j11;
        this.f10744c = hVar;
        this.pinger = null;
        nq.y<mk.a> yVarC = nq.a0.c(null, 1, null);
        this.f10745d = yVarC;
        this.f10746e = pq.o.d(8, null, null, 6, null);
        this.f10747f = pq.o.d(8, null, null, 6, null);
        this.closed = 0;
        o2 o2Var = new o2((nq.l2) e0Var.getCoroutineContext().get(nq.l2.f11882k));
        this.f10748g = o2Var;
        this.f10749i = new ArrayList();
        this.started = 0;
        this.f10750n = e0Var.getCoroutineContext().plus(o2Var).plus(new r0("ws-default"));
        this.f10751p = yVarC;
        this.f10752v = j10;
    }

    @mk.f
    public static /* synthetic */ void l() {
    }

    @mk.f
    public static /* synthetic */ void m() {
    }

    public static /* synthetic */ Object o(c cVar, String str, um.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "Server is going down";
        }
        return cVar.n(str, dVar);
    }

    @Override // mk.b
    public void B1(long j10) {
        this.f10752v = j10;
        u();
    }

    @Override // mk.e0
    public long F0() {
        return this.f10742a.F0();
    }

    @Override // mk.b
    public void I1(@os.l List<? extends w<?>> list) {
        l0.p(list, "negotiatedExtensions");
        if (!f10741z.compareAndSet(this, 0, 1)) {
            throw new IllegalStateException("WebSocket session is already started.");
        }
        this.f10749i.addAll(list);
        u();
        t(m.e(this, this.f10747f, this.f10744c));
        v();
    }

    @Override // mk.b
    @os.l
    public a1<mk.a> Q0() {
        return this.f10751p;
    }

    @Override // mk.e0
    public void T0(boolean z10) {
        this.f10742a.T0(z10);
    }

    @Override // mk.e0
    @os.m
    public Object U0(@os.l g gVar, @os.l um.d<? super l2> dVar) {
        return mk.b.a.a(this, gVar, dVar);
    }

    @Override // mk.b
    public long b0() {
        return this.f10752v;
    }

    @Override // mk.e0
    public boolean b2() {
        return this.f10742a.b2();
    }

    @Override // mk.b
    public void c1(long j10) {
        this.f10743b = j10;
    }

    @Override // mk.e0
    @os.l
    public pq.f0<g> d() {
        return this.f10746e;
    }

    @Override // mk.e0
    @os.l
    public List<w<?>> f0() {
        return this.f10749i;
    }

    @Override // nq.s0
    @os.l
    public um.g getCoroutineContext() {
        return this.f10750n;
    }

    @Override // mk.e0
    @os.l
    public pq.g0<g> h() {
        return this.f10747f;
    }

    @Override // mk.b
    public long j0() {
        return this.f10743b;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object k(tl.s sVar, g gVar, um.d<? super l2> dVar) throws d0.a {
        b bVar;
        int i10;
        if (dVar instanceof b) {
            bVar = (b) dVar;
            int i11 = bVar.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                bVar.label = i11 - Integer.MIN_VALUE;
            } else {
                bVar = new b(dVar);
            }
        } else {
            bVar = new b(dVar);
        }
        Object obj = bVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i12 = bVar.label;
        if (i12 == 0) {
            d1.n(obj);
            int iRemaining = gVar.f10775h.remaining() + (sVar == null ? 0 : sVar.P0());
            if (iRemaining <= this.f10742a.F0()) {
                return l2.f10208a;
            }
            if (sVar != null) {
                sVar.close();
            }
            mk.a.EnumC0280a enumC0280a = mk.a.EnumC0280a.TOO_BIG;
            StringBuilder sbA = h.b.a("Frame is too big: ", iRemaining, ". Max size is ");
            sbA.append(this.f10742a.F0());
            mk.a aVar2 = new mk.a(enumC0280a, sbA.toString());
            bVar.I$0 = iRemaining;
            bVar.label = 1;
            if (f0.b(this, aVar2, bVar) == aVar) {
                return aVar;
            }
            i10 = iRemaining;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i10 = bVar.I$0;
            d1.n(obj);
        }
        throw new d0.a(i10);
    }

    @os.m
    public final Object n(@os.l String str, @os.l um.d<? super l2> dVar) throws Throwable {
        Object objW = w(new mk.a(mk.a.EnumC0280a.GOING_AWAY, str), dVar);
        return objW == wm.a.COROUTINE_SUSPENDED ? objW : l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0065 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0066  */
    /* JADX WARN: Code duplicated, block: B:26:0x0072  */
    /* JADX WARN: Code duplicated, block: B:31:0x0090  */
    /* JADX WARN: Code duplicated, block: B:33:0x0094  */
    /* JADX WARN: Code duplicated, block: B:34:0x0096  */
    /* JADX WARN: Code duplicated, block: B:36:0x009a  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00ae -> B:14:0x0034). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object p(um.d<? super lm.l2> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof mk.c.C0282c
            if (r0 == 0) goto L13
            r0 = r9
            mk.c$c r0 = (mk.c.C0282c) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            mk.c$c r0 = new mk.c$c
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L50
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r8 = r0.L$1
            pq.n r8 = (pq.n) r8
            java.lang.Object r2 = r0.L$0
            mk.c r2 = (mk.c) r2
            lm.d1.n(r9)
        L34:
            r9 = r8
            r8 = r2
            goto L59
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            lm.d1.n(r9)
            goto Lb1
        L44:
            java.lang.Object r8 = r0.L$1
            pq.n r8 = (pq.n) r8
            java.lang.Object r2 = r0.L$0
            mk.c r2 = (mk.c) r2
            lm.d1.n(r9)
            goto L6a
        L50:
            lm.d1.n(r9)
            pq.l<mk.g> r9 = r8.f10747f
            pq.n r9 = r9.iterator()
        L59:
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r5
            java.lang.Object r2 = r9.b(r0)
            if (r2 != r1) goto L66
            return r1
        L66:
            r7 = r2
            r2 = r8
            r8 = r9
            r9 = r7
        L6a:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto Lb1
            java.lang.Object r9 = r8.next()
            mk.g r9 = (mk.g) r9
            boolean r6 = r9 instanceof mk.g.b
            if (r6 == 0) goto L90
            mk.g$b r9 = (mk.g.b) r9
            mk.a r8 = mk.h.b(r9)
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r8 = r2.w(r8, r0)
            if (r8 != r1) goto Lb1
            return r1
        L90:
            boolean r6 = r9 instanceof mk.g.f
            if (r6 == 0) goto L96
            r6 = r5
            goto L98
        L96:
            boolean r6 = r9 instanceof mk.g.a
        L98:
            if (r6 == 0) goto L9e
            mk.g r9 = r2.s(r9)
        L9e:
            mk.e0 r6 = r2.f10742a
            pq.g0 r6 = r6.h()
            r0.L$0 = r2
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = r6.L(r9, r0)
            if (r9 != r1) goto L34
            return r1
        Lb1:
            lm.l2 r8 = lm.l2.f10208a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: mk.c.p(um.d):java.lang.Object");
    }

    @Override // mk.e0
    @os.m
    public Object p0(@os.l um.d<? super l2> dVar) {
        Object objP0 = this.f10742a.p0(dVar);
        return objP0 == wm.a.COROUTINE_SUSPENDED ? objP0 : l2.f10208a;
    }

    @Override // mk.e0
    @lm.k(message = "Use cancel() instead.", replaceWith = @lm.a1(expression = "cancel()", imports = {"kotlinx.coroutines.cancel"}))
    public void q() {
        nq.l2.a.b(this.f10748g, null, 1, null);
        t0.f(this.f10742a, null, 1, null);
    }

    @mk.f
    public final g r(g gVar) {
        Iterator<T> it = this.f10749i.iterator();
        while (it.hasNext()) {
            gVar = ((w) it.next()).b(gVar);
        }
        return gVar;
    }

    @mk.f
    public final g s(g gVar) {
        Iterator<T> it = this.f10749i.iterator();
        while (it.hasNext()) {
            gVar = ((w) it.next()).c(gVar);
        }
        return gVar;
    }

    public final nq.l2 t(pq.g0<? super g.d> g0Var) {
        return nq.k.f(this, mk.d.f10753a.plus(k1.g()), null, new d(g0Var, null), 2, null);
    }

    public final void u() {
        long j10 = this.f10752v;
        pq.g0<g.e> g0VarC = (this.closed == 0 && j10 >= 0) ? m.c(this, this.f10742a.h(), j10, this.f10743b, this.f10744c) : null;
        pq.g0 g0Var = (pq.g0) f10739x.getAndSet(this, g0VarC);
        if (g0Var != null) {
            pq.g0.a.a(g0Var, null, 1, null);
        }
        if (g0VarC != null) {
            g0VarC.offer(H);
        }
        if (this.closed == 0 || g0VarC == null) {
            return;
        }
        u();
    }

    public final nq.l2 v() {
        return nq.k.e(this, mk.d.f10754b.plus(k1.g()), u0.UNDISPATCHED, new e(null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object w(mk.a aVar, um.d<? super l2> dVar) throws Throwable {
        f fVar;
        if (dVar instanceof f) {
            fVar = (f) dVar;
            int i10 = fVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                fVar.label = i10 - Integer.MIN_VALUE;
            } else {
                fVar = new f(dVar);
            }
        } else {
            fVar = new f(dVar);
        }
        Object obj = fVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = fVar.label;
        if (i11 != 0) {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mk.a aVar3 = (mk.a) fVar.L$1;
            c cVar = (c) fVar.L$0;
            try {
                d1.n(obj);
                aVar = aVar3;
                this = cVar;
                this.f10745d.l0(aVar);
                return l2.f10208a;
            } catch (Throwable th2) {
                th = th2;
                aVar = aVar3;
                this = cVar;
                this.f10745d.l0(aVar);
                throw th;
            }
        }
        d1.n(obj);
        if (!x()) {
            return l2.f10208a;
        }
        this.f10748g.complete();
        if (aVar == null) {
            aVar = new mk.a(mk.a.EnumC0280a.NORMAL, "");
        }
        try {
            u();
            if (aVar.f10732a != mk.a.EnumC0280a.CLOSED_ABNORMALLY.getCode()) {
                pq.g0<g> g0VarH = this.f10742a.h();
                g.b bVar = new g.b(aVar);
                fVar.L$0 = this;
                fVar.L$1 = aVar;
                fVar.label = 1;
                if (g0VarH.L(bVar, fVar) == aVar2) {
                    return aVar2;
                }
            }
            this.f10745d.l0(aVar);
            return l2.f10208a;
        } catch (Throwable th3) {
            th = th3;
            this.f10745d.l0(aVar);
            throw th;
        }
    }

    @Override // mk.e0
    public void w0(long j10) {
        this.f10742a.w0(j10);
    }

    public final boolean x() {
        return f10740y.compareAndSet(this, 0, 1);
    }

    public /* synthetic */ c(e0 e0Var, long j10, long j11, bm.h hVar, int i10, kn.w wVar) {
        this(e0Var, (i10 & 2) != 0 ? -1L : j10, (i10 & 4) != 0 ? AbstractTrafficShapingHandler.DEFAULT_MAX_TIME : j11, (i10 & 8) != 0 ? gl.b.a() : hVar);
    }
}
