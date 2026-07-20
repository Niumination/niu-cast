package mk;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import kn.l0;
import kn.n0;
import lm.d1;
import lm.l2;
import nq.n1;
import nq.r0;
import nq.r2;
import nq.s0;
import nq.u0;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final r0 f10802a = new r0("ws-ponger");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final r0 f10803b = new r0("ws-pinger");

    public static final class a extends n0 implements jn.l<Throwable, l2> {
        final /* synthetic */ nq.b0 $actorJob;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(nq.b0 b0Var) {
            super(1);
            this.$actorJob = b0Var;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
            invoke2(th2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.m Throwable th2) {
            nq.l2.a.b(this.$actorJob, null, 1, null);
        }
    }

    @xm.f(c = "io.ktor.http.cio.websocket.PingPongKt$pinger$result$1", f = "PingPong.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2}, l = {79, 88, 104}, m = "invokeSuspend", n = {"$this$actor", "buffer", "encoder", "random", "pingIdBytes", "$this$actor", "buffer", "encoder", "random", "pingIdBytes", "buffer"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0"})
    public static final class b extends xm.o implements jn.p<pq.c<g.e>, um.d<? super l2>, Object> {
        final /* synthetic */ pq.g0<g> $outgoing;
        final /* synthetic */ long $periodMillis;
        final /* synthetic */ bm.h<ByteBuffer> $pool;
        final /* synthetic */ long $timeoutMillis;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        @xm.f(c = "io.ktor.http.cio.websocket.PingPongKt$pinger$result$1$1", f = "PingPong.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
            final /* synthetic */ pq.c<g.e> $$this$actor;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(pq.c<g.e> cVar, um.d<? super a> dVar) {
                super(2, dVar);
                this.$$this$actor = cVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new a(this.$$this$actor, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                pq.c<g.e> cVar;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 != 0 && i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                do {
                    cVar = this.$$this$actor;
                    this.label = 1;
                } while (cVar.n(this) != aVar);
                return aVar;
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
                return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX INFO: renamed from: mk.m$b$b, reason: collision with other inner class name */
        @xm.f(c = "io.ktor.http.cio.websocket.PingPongKt$pinger$result$1$rc$1", f = "PingPong.kt", i = {}, l = {89, ms.a.U}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0283b extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
            final /* synthetic */ pq.c<g.e> $$this$actor;
            final /* synthetic */ ByteBuffer $buffer;
            final /* synthetic */ CharsetEncoder $encoder;
            final /* synthetic */ pq.g0<g> $outgoing;
            final /* synthetic */ String $pingMessage;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0283b(pq.g0<? super g> g0Var, ByteBuffer byteBuffer, CharsetEncoder charsetEncoder, String str, pq.c<g.e> cVar, um.d<? super C0283b> dVar) {
                super(2, dVar);
                this.$outgoing = g0Var;
                this.$buffer = byteBuffer;
                this.$encoder = charsetEncoder;
                this.$pingMessage = str;
                this.$$this$actor = cVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new C0283b(this.$outgoing, this.$buffer, this.$encoder, this.$pingMessage, this.$$this$actor, dVar);
            }

            /* JADX WARN: Code duplicated, block: B:15:0x003f A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:18:0x0052  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003d -> B:16:0x0040). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:18:0x0052
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // xm.a
            @os.m
            public final java.lang.Object invokeSuspend(@os.l java.lang.Object r7) {
                /*
                    r6 = this;
                    wm.a r0 = wm.a.COROUTINE_SUSPENDED
                    int r1 = r6.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L1c
                    if (r1 == r3) goto L18
                    if (r1 != r2) goto L10
                    lm.d1.n(r7)
                    goto L40
                L10:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L18:
                    lm.d1.n(r7)
                    goto L35
                L1c:
                    lm.d1.n(r7)
                    pq.g0<mk.g> r7 = r6.$outgoing
                    java.nio.ByteBuffer r1 = r6.$buffer
                    java.nio.charset.CharsetEncoder r4 = r6.$encoder
                    java.lang.String r5 = "encoder"
                    kn.l0.o(r4, r5)
                    java.lang.String r5 = r6.$pingMessage
                    r6.label = r3
                    java.lang.Object r7 = mk.m.a(r7, r1, r4, r5, r6)
                    if (r7 != r0) goto L35
                    return r0
                L35:
                    pq.c<mk.g$e> r7 = r6.$$this$actor
                    r6.label = r2
                    java.lang.Object r7 = r7.n(r6)
                    if (r7 != r0) goto L40
                    return r0
                L40:
                    mk.g$e r7 = (mk.g.e) r7
                    java.nio.ByteBuffer r7 = r7.f10775h
                    java.nio.charset.Charset r1 = jq.f.f8805g
                    java.lang.String r7 = fl.a1.e(r7, r1)
                    java.lang.String r1 = r6.$pingMessage
                    boolean r7 = kn.l0.g(r7, r1)
                    if (r7 == 0) goto L35
                    lm.l2 r6 = lm.l2.f10208a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: mk.m.b.C0283b.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
                return ((C0283b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(bm.h<ByteBuffer> hVar, long j10, long j11, pq.g0<? super g> g0Var, um.d<? super b> dVar) {
            super(2, dVar);
            this.$pool = hVar;
            this.$periodMillis = j10;
            this.$timeoutMillis = j11;
            this.$outgoing = g0Var;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            b bVar = new b(this.$pool, this.$periodMillis, this.$timeoutMillis, this.$outgoing, dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        /* JADX WARN: Code duplicated, block: B:26:0x00a9 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:27:0x00aa  */
        /* JADX WARN: Code duplicated, block: B:30:0x00ff A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:31:0x0100  */
        /* JADX WARN: Code duplicated, block: B:34:0x010c A[Catch: CancellationException | v | w -> 0x0130, CancellationException | v | w -> 0x0130, CancellationException | v | w -> 0x0130, all -> 0x0137, TRY_LEAVE, TryCatch #0 {all -> 0x0137, blocks: (B:32:0x0108, B:34:0x010c, B:24:0x0090), top: B:51:0x0108 }] */
        /* JADX WARN: Code duplicated, block: B:36:0x012f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:41:0x013a  */
        /* JADX WARN: Not initialized variable reg: 9, insn: 0x004d: MOVE (r2 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:18:0x004d */
        /* JADX WARN: Not initialized variable reg: 9, insn: 0x0050: MOVE (r2 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:19:0x0050 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x013a -> B:24:0x0090). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r23) {
            /*
                Method dump skipped, instruction units count: 332
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: mk.m.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pq.c<g.e> cVar, @os.m um.d<? super l2> dVar) {
            return ((b) create(cVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.http.cio.websocket.PingPongKt$ponger$1", f = "PingPong.kt", i = {0, 1}, l = {150, 36}, m = "invokeSuspend", n = {"$this$consume$iv$iv", "$this$consume$iv$iv"}, s = {"L$2", "L$2"})
    public static final class c extends xm.o implements jn.p<pq.c<g.d>, um.d<? super l2>, Object> {
        final /* synthetic */ pq.g0<g.e> $outgoing;
        final /* synthetic */ bm.h<ByteBuffer> $pool;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        public static final class a implements n1 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ bm.h<ByteBuffer> f10804a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ByteBuffer f10805b;

            public a(bm.h<ByteBuffer> hVar, ByteBuffer byteBuffer) {
                this.f10804a = hVar;
                this.f10805b = byteBuffer;
            }

            @Override // nq.n1
            public void dispose() {
                this.f10804a.recycle(this.f10805b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(bm.h<ByteBuffer> hVar, pq.g0<? super g.e> g0Var, um.d<? super c> dVar) {
            super(2, dVar);
            this.$pool = hVar;
            this.$outgoing = g0Var;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            c cVar = new c(this.$pool, this.$outgoing, dVar);
            cVar.L$0 = obj;
            return cVar;
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0063 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:22:0x0064  */
        /* JADX WARN: Code duplicated, block: B:25:0x0073 A[Catch: all -> 0x0024, TRY_LEAVE, TryCatch #2 {all -> 0x0024, blocks: (B:7:0x001c, B:19:0x0053, B:23:0x006a, B:25:0x0073, B:14:0x003f, B:18:0x004f), top: B:39:0x0006, outer: #1 }] */
        /* JADX WARN: Code duplicated, block: B:27:0x009a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:28:0x009b A[Catch: w -> 0x00a5, TRY_ENTER, TRY_LEAVE, TryCatch #1 {w -> 0x00a5, blocks: (B:28:0x009b, B:32:0x00a1, B:33:0x00a4, B:17:0x004b, B:30:0x009f, B:7:0x001c, B:19:0x0053, B:23:0x006a, B:25:0x0073, B:14:0x003f, B:18:0x004f), top: B:39:0x0006, inners: #0, #2 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0098 -> B:8:0x001f). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r12) {
            /*
                r11 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r11.label
                r2 = 1
                r3 = 2
                if (r1 == 0) goto L43
                if (r1 == r2) goto L2f
                if (r1 != r3) goto L27
                java.lang.Object r1 = r11.L$3
                pq.n r1 = (pq.n) r1
                java.lang.Object r4 = r11.L$2
                pq.f0 r4 = (pq.f0) r4
                java.lang.Object r5 = r11.L$1
                pq.g0 r5 = (pq.g0) r5
                java.lang.Object r6 = r11.L$0
                bm.h r6 = (bm.h) r6
                lm.d1.n(r12)     // Catch: java.lang.Throwable -> L24
            L1f:
                r12 = r6
                r9 = r5
                r5 = r1
                r1 = r9
                goto L53
            L24:
                r11 = move-exception
                goto L9f
            L27:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L2f:
                java.lang.Object r1 = r11.L$3
                pq.n r1 = (pq.n) r1
                java.lang.Object r4 = r11.L$2
                pq.f0 r4 = (pq.f0) r4
                java.lang.Object r5 = r11.L$1
                pq.g0 r5 = (pq.g0) r5
                java.lang.Object r6 = r11.L$0
                bm.h r6 = (bm.h) r6
                lm.d1.n(r12)     // Catch: java.lang.Throwable -> L24
                goto L6a
            L43:
                lm.d1.n(r12)
                java.lang.Object r12 = r11.L$0
                r4 = r12
                pq.c r4 = (pq.c) r4
                bm.h<java.nio.ByteBuffer> r12 = r11.$pool     // Catch: pq.w -> La5
                pq.g0<mk.g$e> r1 = r11.$outgoing     // Catch: pq.w -> La5
                pq.n r5 = r4.iterator()     // Catch: java.lang.Throwable -> L24
            L53:
                r11.L$0 = r12     // Catch: java.lang.Throwable -> L24
                r11.L$1 = r1     // Catch: java.lang.Throwable -> L24
                r11.L$2 = r4     // Catch: java.lang.Throwable -> L24
                r11.L$3 = r5     // Catch: java.lang.Throwable -> L24
                r11.label = r2     // Catch: java.lang.Throwable -> L24
                java.lang.Object r6 = r5.b(r11)     // Catch: java.lang.Throwable -> L24
                if (r6 != r0) goto L64
                return r0
            L64:
                r9 = r6
                r6 = r12
                r12 = r9
                r10 = r5
                r5 = r1
                r1 = r10
            L6a:
                java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch: java.lang.Throwable -> L24
                boolean r12 = r12.booleanValue()     // Catch: java.lang.Throwable -> L24
                r7 = 0
                if (r12 == 0) goto L9b
                java.lang.Object r12 = r1.next()     // Catch: java.lang.Throwable -> L24
                mk.g$d r12 = (mk.g.d) r12     // Catch: java.lang.Throwable -> L24
                java.nio.ByteBuffer r12 = r12.f10775h     // Catch: java.lang.Throwable -> L24
                r8 = 0
                java.nio.ByteBuffer r12 = fl.a1.d(r12, r6, r8, r3, r7)     // Catch: java.lang.Throwable -> L24
                mk.g$e r7 = new mk.g$e     // Catch: java.lang.Throwable -> L24
                mk.m$c$a r8 = new mk.m$c$a     // Catch: java.lang.Throwable -> L24
                r8.<init>(r6, r12)     // Catch: java.lang.Throwable -> L24
                r7.<init>(r12, r8)     // Catch: java.lang.Throwable -> L24
                r11.L$0 = r6     // Catch: java.lang.Throwable -> L24
                r11.L$1 = r5     // Catch: java.lang.Throwable -> L24
                r11.L$2 = r4     // Catch: java.lang.Throwable -> L24
                r11.L$3 = r1     // Catch: java.lang.Throwable -> L24
                r11.label = r3     // Catch: java.lang.Throwable -> L24
                java.lang.Object r12 = r5.L(r7, r11)     // Catch: java.lang.Throwable -> L24
                if (r12 != r0) goto L1f
                return r0
            L9b:
                pq.t.a(r4, r7)     // Catch: pq.w -> La5
                goto La5
            L9f:
                throw r11     // Catch: java.lang.Throwable -> La0
            La0:
                r12 = move-exception
                pq.t.a(r4, r11)     // Catch: pq.w -> La5
                throw r12     // Catch: pq.w -> La5
            La5:
                lm.l2 r11 = lm.l2.f10208a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: mk.m.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pq.c<g.d> cVar, @os.m um.d<? super l2> dVar) {
            return ((c) create(cVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public static final void b(CharsetEncoder charsetEncoder, ByteBuffer byteBuffer, String str) throws CharacterCodingException {
        CoderResult coderResultEncode = charsetEncoder.encode(CharBuffer.wrap(str), byteBuffer, true);
        if (coderResultEncode.isError()) {
            coderResultEncode.throwException();
        } else if (coderResultEncode.isOverflow()) {
            coderResultEncode.throwException();
        }
    }

    @os.l
    public static final pq.g0<g.e> c(@os.l s0 s0Var, @os.l pq.g0<? super g> g0Var, long j10, long j11, @os.l bm.h<ByteBuffer> hVar) {
        l0.p(s0Var, "<this>");
        l0.p(g0Var, "outgoing");
        l0.p(hVar, "pool");
        nq.b0 b0VarC = r2.c(null, 1, null);
        pq.g0<g.e> g0VarB = pq.b.b(s0Var, b0VarC.plus(f10803b), Integer.MAX_VALUE, u0.LAZY, null, new b(hVar, j10, j11, g0Var, null), 8, null);
        um.g.b bVar = s0Var.getCoroutineContext().get(nq.l2.f11882k);
        l0.m(bVar);
        ((nq.l2) bVar).k0(new a(b0VarC));
        return g0VarB;
    }

    public static /* synthetic */ pq.g0 d(s0 s0Var, pq.g0 g0Var, long j10, long j11, bm.h hVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            hVar = gl.b.a();
        }
        return c(s0Var, g0Var, j10, j11, hVar);
    }

    @os.l
    public static final pq.g0<g.d> e(@os.l s0 s0Var, @os.l pq.g0<? super g.e> g0Var, @os.l bm.h<ByteBuffer> hVar) {
        l0.p(s0Var, "<this>");
        l0.p(g0Var, "outgoing");
        l0.p(hVar, "pool");
        return pq.b.b(s0Var, f10802a, 5, u0.LAZY, null, new c(hVar, g0Var, null), 8, null);
    }

    public static /* synthetic */ pq.g0 f(s0 s0Var, pq.g0 g0Var, bm.h hVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            hVar = gl.b.a();
        }
        return e(s0Var, g0Var, hVar);
    }

    public static final Object g(pq.g0<? super g.d> g0Var, ByteBuffer byteBuffer, CharsetEncoder charsetEncoder, String str, um.d<? super l2> dVar) throws CharacterCodingException {
        byteBuffer.clear();
        charsetEncoder.reset();
        b(charsetEncoder, byteBuffer, str);
        byteBuffer.flip();
        Object objL = g0Var.L(new g.d(byteBuffer), dVar);
        return objL == wm.a.COROUTINE_SUSPENDED ? objL : l2.f10208a;
    }
}
