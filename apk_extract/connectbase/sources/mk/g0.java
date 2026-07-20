package mk;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import kn.l0;
import lm.d1;
import nq.l2;
import nq.o2;
import nq.r0;
import nq.s0;
import nq.u0;

/* JADX INFO: loaded from: classes2.dex */
@c0
public final class g0 implements s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final pl.n f10777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final um.g f10778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final bm.h<ByteBuffer> f10780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final pq.l<Object> f10781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final p f10782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final l2 f10783g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final nq.b0 f10784a;

        public a(@os.m l2 l2Var) {
            this.f10784a = new o2(l2Var);
        }

        @os.m
        public final Object a(@os.l um.d<? super lm.l2> dVar) {
            Object objT = this.f10784a.t(dVar);
            return objT == wm.a.COROUTINE_SUSPENDED ? objT : lm.l2.f10208a;
        }

        public final boolean b() {
            return this.f10784a.complete();
        }
    }

    @xm.f(c = "io.ktor.http.cio.websocket.WebSocketWriter", f = "WebSocketWriter.kt", i = {0, 0, 0, 0}, l = {y5.a.f20736o0}, m = "drainQueueAndSerialize", n = {"this", "buffer", "flush", "closeSent"}, s = {"L$0", "L$1", "L$2", "I$0"})
    public static final class b extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
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
            return g0.this.g(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.http.cio.websocket.WebSocketWriter", f = "WebSocketWriter.kt", i = {0, 0}, l = {156, 159, 164}, m = "flush", n = {"this", "it"}, s = {"L$0", "L$2"})
    public static final class c extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public c(um.d<? super c> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return g0.this.p0(this);
        }
    }

    @xm.f(c = "io.ktor.http.cio.websocket.WebSocketWriter", f = "WebSocketWriter.kt", i = {0, 0, 1, 1}, l = {47, ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX}, m = "writeLoop", n = {"this", "buffer", "this", "buffer"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class d extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public d(um.d<? super d> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return g0.this.k(null, this);
        }
    }

    @xm.f(c = "io.ktor.http.cio.websocket.WebSocketWriter$writeLoopJob$1", f = "WebSocketWriter.kt", i = {0, 0}, l = {41}, m = "invokeSuspend", n = {"$this$useInstance$iv", "instance$iv"}, s = {"L$0", "L$1"})
    public static final class e extends xm.o implements jn.p<s0, um.d<? super lm.l2>, Object> {
        Object L$0;
        Object L$1;
        int label;

        public e(um.d<? super e> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @os.l
        public final um.d<lm.l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return g0.this.new e(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) throws Throwable {
            bm.h hVar;
            Object obj2;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                g0 g0Var = g0.this;
                bm.h<ByteBuffer> hVar2 = g0Var.f10780d;
                ByteBuffer byteBufferW0 = hVar2.W0();
                try {
                    this.L$0 = hVar2;
                    this.L$1 = byteBufferW0;
                    this.label = 1;
                    if (g0Var.k(byteBufferW0, this) == aVar) {
                        return aVar;
                    }
                    hVar = hVar2;
                    obj2 = byteBufferW0;
                } catch (Throwable th2) {
                    th = th2;
                    hVar = hVar2;
                    obj2 = byteBufferW0;
                    hVar.recycle(obj2);
                    throw th;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj2 = this.L$1;
                hVar = (bm.h) this.L$0;
                try {
                    d1.n(obj);
                } catch (Throwable th3) {
                    th = th3;
                    hVar.recycle(obj2);
                    throw th;
                }
            }
            lm.l2 l2Var = lm.l2.f10208a;
            hVar.recycle(obj2);
            return l2Var;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super lm.l2> dVar) {
            return ((e) create(s0Var, dVar)).invokeSuspend(lm.l2.f10208a);
        }
    }

    public g0(@os.l pl.n nVar, @os.l um.g gVar, boolean z10, @os.l bm.h<ByteBuffer> hVar) {
        l0.p(nVar, "writeChannel");
        l0.p(gVar, "coroutineContext");
        l0.p(hVar, "pool");
        this.f10777a = nVar;
        this.f10778b = gVar;
        this.f10779c = z10;
        this.f10780d = hVar;
        this.f10781e = pq.o.d(8, null, null, 6, null);
        this.f10782f = new p();
        this.f10783g = nq.k.e(this, new r0("ws-writer"), u0.ATOMIC, new e(null));
    }

    public static /* synthetic */ void j() {
    }

    public final void T0(boolean z10) {
        this.f10779c = z10;
    }

    @os.m
    public final Object U0(@os.l g gVar, @os.l um.d<? super lm.l2> dVar) {
        Object objL = this.f10781e.L(gVar, dVar);
        return objL == wm.a.COROUTINE_SUSPENDED ? objL : lm.l2.f10208a;
    }

    public final boolean b2() {
        return this.f10779c;
    }

    @lm.k(message = "Will be removed")
    public final void e() {
        pq.g0.a.a(this.f10781e, null, 1, null);
    }

    public final void f() {
        pq.g0.a.a(this.f10781e, null, 1, null);
        while (true) {
            try {
                Object objPoll = this.f10781e.poll();
                if (objPoll == null) {
                    return;
                }
                if (!(objPoll instanceof g.b)) {
                    if (!(objPoll instanceof g.d ? true : objPoll instanceof g.e)) {
                        if (objPoll instanceof a) {
                            ((a) objPoll).b();
                        } else {
                            if (!(objPoll instanceof g.f ? true : objPoll instanceof g.a)) {
                                throw new IllegalArgumentException(l0.C("unknown message ", objPoll));
                            }
                        }
                    }
                }
            } catch (CancellationException unused) {
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v14, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00e1 -> B:53:0x00e4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:16:0x0053
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final java.lang.Object g(mk.g r7, java.nio.ByteBuffer r8, um.d<? super java.lang.Boolean> r9) {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mk.g0.g(mk.g, java.nio.ByteBuffer, um.d):java.lang.Object");
    }

    @Override // nq.s0
    @os.l
    public um.g getCoroutineContext() {
        return this.f10778b;
    }

    @os.l
    public final pq.g0<g> h() {
        return this.f10781e;
    }

    @os.l
    public final bm.h<ByteBuffer> i() {
        return this.f10780d;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0079 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x007a  */
    /* JADX WARN: Code duplicated, block: B:33:0x0086 A[Catch: all -> 0x00ab, e -> 0x00af, TryCatch #5 {e -> 0x00af, all -> 0x00ab, blocks: (B:38:0x009f, B:27:0x006b, B:31:0x007e, B:33:0x0086, B:35:0x008e, B:46:0x00b3, B:48:0x00b7, B:49:0x00bd, B:50:0x00c8, B:26:0x0065), top: B:64:0x0065 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x008e A[Catch: all -> 0x00ab, e -> 0x00af, TryCatch #5 {e -> 0x00af, all -> 0x00ab, blocks: (B:38:0x009f, B:27:0x006b, B:31:0x007e, B:33:0x0086, B:35:0x008e, B:46:0x00b3, B:48:0x00b7, B:49:0x00bd, B:50:0x00c8, B:26:0x0065), top: B:64:0x0065 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x009e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b3 A[Catch: all -> 0x00ab, e -> 0x00af, TryCatch #5 {e -> 0x00af, all -> 0x00ab, blocks: (B:38:0x009f, B:27:0x006b, B:31:0x007e, B:33:0x0086, B:35:0x008e, B:46:0x00b3, B:48:0x00b7, B:49:0x00bd, B:50:0x00c8, B:26:0x0065), top: B:64:0x0065 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00b7 A[Catch: all -> 0x00ab, e -> 0x00af, TryCatch #5 {e -> 0x00af, all -> 0x00ab, blocks: (B:38:0x009f, B:27:0x006b, B:31:0x007e, B:33:0x0086, B:35:0x008e, B:46:0x00b3, B:48:0x00b7, B:49:0x00bd, B:50:0x00c8, B:26:0x0065), top: B:64:0x0065 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00bd A[Catch: all -> 0x00ab, e -> 0x00af, TryCatch #5 {e -> 0x00af, all -> 0x00ab, blocks: (B:38:0x009f, B:27:0x006b, B:31:0x007e, B:33:0x0086, B:35:0x008e, B:46:0x00b3, B:48:0x00b7, B:49:0x00bd, B:50:0x00c8, B:26:0x0065), top: B:64:0x0065 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [mk.g0] */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object k(java.nio.ByteBuffer r10, um.d<? super lm.l2> r11) {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mk.g0.k(java.nio.ByteBuffer, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0097 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0098  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public final Object p0(@os.l um.d<? super lm.l2> dVar) throws Throwable {
        c cVar;
        a aVar;
        Throwable th2;
        a aVar2;
        g0 g0Var;
        a aVar3;
        l2 l2Var;
        a aVar4;
        if (dVar instanceof c) {
            cVar = (c) dVar;
            int i10 = cVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                cVar.label = i10 - Integer.MIN_VALUE;
            } else {
                cVar = new c(dVar);
            }
        } else {
            cVar = new c(dVar);
        }
        Object obj = cVar.result;
        wm.a aVar5 = wm.a.COROUTINE_SUSPENDED;
        int i11 = cVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                aVar2 = (a) cVar.L$2;
                aVar3 = (a) cVar.L$1;
                g0Var = (g0) cVar.L$0;
                try {
                    d1.n(obj);
                } catch (pq.w unused) {
                    aVar = aVar3;
                    aVar2.b();
                    l2Var = g0Var.f10783g;
                    cVar.L$0 = aVar;
                    cVar.L$1 = null;
                    cVar.L$2 = null;
                    cVar.label = 2;
                    if (l2Var.t(cVar) == aVar5) {
                        return aVar5;
                    }
                    aVar4 = aVar;
                    aVar3 = aVar4;
                } catch (Throwable th3) {
                    th2 = th3;
                    aVar2.b();
                    throw th2;
                }
            } else if (i11 == 2) {
                aVar4 = (a) cVar.L$0;
                d1.n(obj);
                aVar3 = aVar4;
            } else {
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return lm.l2.f10208a;
        }
        d1.n(obj);
        aVar = new a((l2) this.f10778b.get(l2.f11882k));
        try {
            pq.l<Object> lVar = this.f10781e;
            cVar.L$0 = this;
            cVar.L$1 = aVar;
            cVar.L$2 = aVar;
            cVar.label = 1;
            if (lVar.L(aVar, cVar) == aVar5) {
                return aVar5;
            }
            aVar3 = aVar;
        } catch (pq.w unused2) {
            g0Var = this;
            aVar2 = aVar;
            aVar2.b();
            l2Var = g0Var.f10783g;
            cVar.L$0 = aVar;
            cVar.L$1 = null;
            cVar.L$2 = null;
            cVar.label = 2;
            if (l2Var.t(cVar) == aVar5) {
                return aVar5;
            }
            aVar4 = aVar;
            aVar3 = aVar4;
        } catch (Throwable th4) {
            th2 = th4;
            aVar2 = aVar;
            aVar2.b();
            throw th2;
        }
        cVar.L$0 = null;
        cVar.L$1 = null;
        cVar.L$2 = null;
        cVar.label = 3;
        if (aVar3.a(cVar) == aVar5) {
            return aVar5;
        }
        return lm.l2.f10208a;
    }

    public /* synthetic */ g0(pl.n nVar, um.g gVar, boolean z10, bm.h hVar, int i10, kn.w wVar) {
        this(nVar, gVar, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? gl.b.a() : hVar);
    }
}
