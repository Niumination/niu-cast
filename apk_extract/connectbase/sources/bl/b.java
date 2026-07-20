package bl;

import al.q;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.transsion.connectx.mirror.source.pad.FloatingWindow;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http2.Http2HeadersFrame;
import io.netty.util.concurrent.EventExecutor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.CancellationException;
import jn.p;
import kn.k1;
import kn.l0;
import lm.d1;
import nq.l2;
import nq.s0;
import nq.u0;
import nq.y1;
import os.l;
import os.m;
import pl.d0;
import pl.k;
import pq.f0;
import pq.t;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final ChannelHandlerContext f945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final bl.a f946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final um.g f947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public final f0<bl.a.C0029a> f950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public final ArrayDeque<bl.a.C0029a> f951g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public final ArrayDeque<bl.a.C0029a> f952i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @l
    public final l2 f953n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @l
    public bl.e f954p;

    @xm.f(c = "io.ktor.server.netty.cio.NettyResponsePipeline", f = "NettyResponsePipeline.kt", i = {0}, l = {da.b.f3634e}, m = "fillSuspend", n = {"this"}, s = {"L$0"})
    public static final class a extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.this.o(this);
        }
    }

    /* JADX INFO: renamed from: bl.b$b, reason: collision with other inner class name */
    @xm.f(c = "io.ktor.server.netty.cio.NettyResponsePipeline", f = "NettyResponsePipeline.kt", i = {0, 0, 0, 0, 1, 1, 1, 2}, l = {303, TypedValues.CycleType.TYPE_PATH_ROTATE, TypedValues.CycleType.TYPE_EASING}, m = "processBodyFlusher", n = {"this", NotificationCompat.CATEGORY_CALL, "encapsulation", "lastFuture", "this_$iv", "lastFuture$iv", "prepareForClose$iv", "this_$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "I$0", "L$0"})
    public static final class C0030b extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C0030b(um.d<? super C0030b> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.this.v(null, null, null, this);
        }
    }

    @xm.f(c = "io.ktor.server.netty.cio.NettyResponsePipeline$processBodyFlusher$2", f = "NettyResponsePipeline.kt", i = {0, 1}, l = {307, 326}, m = "invokeSuspend", n = {"$this$lookAheadSuspend", "$this$lookAheadSuspend"}, s = {"L$0", "L$0"})
    public static final class c extends o implements p<d0, um.d<? super lm.l2>, Object> {
        final /* synthetic */ k $channel;
        final /* synthetic */ bl.e $encapsulation;
        final /* synthetic */ k1.h<ChannelFuture> $lastFuture;
        final /* synthetic */ k1.f $unflushedBytes;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(k1.f fVar, bl.e eVar, k kVar, k1.h<ChannelFuture> hVar, um.d<? super c> dVar) {
            super(2, dVar);
            this.$unflushedBytes = fVar;
            this.$encapsulation = eVar;
            this.$channel = kVar;
            this.$lastFuture = hVar;
        }

        @Override // xm.a
        @l
        public final um.d<lm.l2> create(@m Object obj, @l um.d<?> dVar) {
            c cVar = b.this.new c(this.$unflushedBytes, this.$encapsulation, this.$channel, this.$lastFuture, dVar);
            cVar.L$0 = obj;
            return cVar;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x003e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:18:0x0047  */
        /* JADX WARN: Code duplicated, block: B:20:0x004a  */
        /* JADX WARN: Code duplicated, block: B:22:0x0082  */
        /* JADX WARN: Code duplicated, block: B:28:0x00bd A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:30:0x009d A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:32:0x0034 A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r9v11, types: [T, io.netty.channel.ChannelFuture, io.netty.util.concurrent.Future, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v13, types: [T, io.netty.channel.ChannelFuture, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0045 -> B:11:0x002e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00bb -> B:29:0x00be). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:18:0x0047
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r9) {
            /*
                r8 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r8.label
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L26
                if (r1 == r4) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r1 = r8.L$0
                pl.d0 r1 = (pl.d0) r1
                lm.d1.n(r9)
                goto Lbe
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L1e:
                java.lang.Object r1 = r8.L$0
                pl.d0 r1 = (pl.d0) r1
                lm.d1.n(r9)
                goto L3f
            L26:
                lm.d1.n(r9)
                java.lang.Object r9 = r8.L$0
                pl.d0 r9 = (pl.d0) r9
                r1 = r9
            L2e:
                java.nio.ByteBuffer r9 = r1.b(r3, r4)
                if (r9 != 0) goto L4a
                r8.L$0 = r1
                r8.label = r4
                java.lang.Object r9 = r1.w(r4, r8)
                if (r9 != r0) goto L3f
                return r0
            L3f:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 != 0) goto L2e
                lm.l2 r8 = lm.l2.f10208a
                return r8
            L4a:
                int r5 = r9.remaining()
                bl.b r6 = bl.b.this
                io.netty.channel.ChannelHandlerContext r6 = r6.f945a
                io.netty.buffer.ByteBufAllocator r6 = r6.alloc()
                io.netty.buffer.ByteBuf r6 = r6.buffer(r5)
                int r7 = r6.writerIndex()
                r6.setBytes(r7, r9)
                int r7 = r7 + r5
                r6.writerIndex(r7)
                r1.b0(r5)
                kn.k1$f r9 = r8.$unflushedBytes
                int r7 = r9.element
                int r7 = r7 + r5
                r9.element = r7
                bl.e r9 = r8.$encapsulation
                java.lang.String r5 = "buf"
                kn.l0.o(r6, r5)
                java.lang.Object r9 = r9.c(r6, r3)
                kn.k1$f r5 = r8.$unflushedBytes
                int r5 = r5.element
                r6 = 65536(0x10000, float:9.1835E-41)
                if (r5 >= r6) goto L9d
                pl.k r5 = r8.$channel
                int r5 = r5.d()
                if (r5 != 0) goto L8b
                goto L9d
            L8b:
                kn.k1$h<io.netty.channel.ChannelFuture> r5 = r8.$lastFuture
                bl.b r6 = bl.b.this
                io.netty.channel.ChannelHandlerContext r6 = r6.f945a
                io.netty.channel.ChannelFuture r9 = r6.write(r9)
                java.lang.String r6 = "dst.write(message)"
                kn.l0.o(r9, r6)
                r5.element = r9
                goto L2e
            L9d:
                bl.b r5 = bl.b.this
                r5.G()
                bl.b r5 = bl.b.this
                io.netty.channel.ChannelHandlerContext r5 = r5.f945a
                io.netty.channel.ChannelFuture r9 = r5.writeAndFlush(r9)
                kn.k1$h<io.netty.channel.ChannelFuture> r5 = r8.$lastFuture
                java.lang.String r6 = "future"
                kn.l0.o(r9, r6)
                r5.element = r9
                r8.L$0 = r1
                r8.label = r2
                java.lang.Object r9 = al.a.e(r9, r8)
                if (r9 != r0) goto Lbe
                return r0
            Lbe:
                kn.k1$f r9 = r8.$unflushedBytes
                r9.element = r3
                goto L2e
            */
            throw new UnsupportedOperationException("Method not decompiled: bl.b.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @m
        public final Object invoke(@l d0 d0Var, @m um.d<? super lm.l2> dVar) {
            return ((c) create(d0Var, dVar)).invokeSuspend(lm.l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.server.netty.cio.NettyResponsePipeline", f = "NettyResponsePipeline.kt", i = {0, 0, 0, 0, 1, 1, 1, 2}, l = {257, TypedValues.CycleType.TYPE_PATH_ROTATE, TypedValues.CycleType.TYPE_EASING}, m = "processBodyGeneral", n = {"this", NotificationCompat.CATEGORY_CALL, "encapsulation", "lastFuture", "this_$iv", "lastFuture$iv", "prepareForClose$iv", "this_$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "I$0", "L$0"})
    public static final class d extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public d(um.d<? super d> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.this.w(null, null, null, this);
        }
    }

    @xm.f(c = "io.ktor.server.netty.cio.NettyResponsePipeline$processBodyGeneral$2", f = "NettyResponsePipeline.kt", i = {0, 1}, l = {261, 280}, m = "invokeSuspend", n = {"$this$lookAheadSuspend", "$this$lookAheadSuspend"}, s = {"L$0", "L$0"})
    public static final class e extends o implements p<d0, um.d<? super lm.l2>, Object> {
        final /* synthetic */ bl.e $encapsulation;
        final /* synthetic */ k1.h<ChannelFuture> $lastFuture;
        final /* synthetic */ k1.f $unflushedBytes;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(k1.f fVar, bl.e eVar, k1.h<ChannelFuture> hVar, um.d<? super e> dVar) {
            super(2, dVar);
            this.$unflushedBytes = fVar;
            this.$encapsulation = eVar;
            this.$lastFuture = hVar;
        }

        @Override // xm.a
        @l
        public final um.d<lm.l2> create(@m Object obj, @l um.d<?> dVar) {
            e eVar = b.this.new e(this.$unflushedBytes, this.$encapsulation, this.$lastFuture, dVar);
            eVar.L$0 = obj;
            return eVar;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x003e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:18:0x0047  */
        /* JADX WARN: Code duplicated, block: B:20:0x004a  */
        /* JADX WARN: Code duplicated, block: B:24:0x00a2 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:26:0x00a8 A[LOOP:0: B:11:0x002e->B:26:0x00a8, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:27:0x0082 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:28:0x0034 A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r9v11, types: [T, io.netty.channel.ChannelFuture, io.netty.util.concurrent.Future, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v13, types: [T, io.netty.channel.ChannelFuture, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0045 -> B:11:0x002e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a0 -> B:25:0x00a3). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:24:0x00a2
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r9) {
            /*
                r8 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r8.label
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L26
                if (r1 == r4) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r1 = r8.L$0
                pl.d0 r1 = (pl.d0) r1
                lm.d1.n(r9)
                goto La3
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L1e:
                java.lang.Object r1 = r8.L$0
                pl.d0 r1 = (pl.d0) r1
                lm.d1.n(r9)
                goto L3f
            L26:
                lm.d1.n(r9)
                java.lang.Object r9 = r8.L$0
                pl.d0 r9 = (pl.d0) r9
                r1 = r9
            L2e:
                java.nio.ByteBuffer r9 = r1.b(r3, r4)
                if (r9 != 0) goto L4a
                r8.L$0 = r1
                r8.label = r4
                java.lang.Object r9 = r1.w(r4, r8)
                if (r9 != r0) goto L3f
                return r0
            L3f:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 != 0) goto L2e
                lm.l2 r8 = lm.l2.f10208a
                return r8
            L4a:
                int r5 = r9.remaining()
                bl.b r6 = bl.b.this
                io.netty.channel.ChannelHandlerContext r6 = r6.f945a
                io.netty.buffer.ByteBufAllocator r6 = r6.alloc()
                io.netty.buffer.ByteBuf r6 = r6.buffer(r5)
                int r7 = r6.writerIndex()
                r6.setBytes(r7, r9)
                int r7 = r7 + r5
                r6.writerIndex(r7)
                r1.b0(r5)
                kn.k1$f r9 = r8.$unflushedBytes
                int r7 = r9.element
                int r7 = r7 + r5
                r9.element = r7
                bl.e r9 = r8.$encapsulation
                java.lang.String r5 = "buf"
                kn.l0.o(r6, r5)
                java.lang.Object r9 = r9.c(r6, r3)
                kn.k1$f r5 = r8.$unflushedBytes
                int r5 = r5.element
                r6 = 65536(0x10000, float:9.1835E-41)
                if (r5 < r6) goto La8
                bl.b r5 = bl.b.this
                r5.G()
                bl.b r5 = bl.b.this
                io.netty.channel.ChannelHandlerContext r5 = r5.f945a
                io.netty.channel.ChannelFuture r9 = r5.writeAndFlush(r9)
                kn.k1$h<io.netty.channel.ChannelFuture> r5 = r8.$lastFuture
                java.lang.String r6 = "future"
                kn.l0.o(r9, r6)
                r5.element = r9
                r8.L$0 = r1
                r8.label = r2
                java.lang.Object r9 = al.a.e(r9, r8)
                if (r9 != r0) goto La3
                return r0
            La3:
                kn.k1$f r9 = r8.$unflushedBytes
                r9.element = r3
                goto L2e
            La8:
                kn.k1$h<io.netty.channel.ChannelFuture> r5 = r8.$lastFuture
                bl.b r6 = bl.b.this
                io.netty.channel.ChannelHandlerContext r6 = r6.f945a
                io.netty.channel.ChannelFuture r9 = r6.write(r9)
                java.lang.String r6 = "dst.write(message)"
                kn.l0.o(r9, r6)
                r5.element = r9
                goto L2e
            */
            throw new UnsupportedOperationException("Method not decompiled: bl.b.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @m
        public final Object invoke(@l d0 d0Var, @m um.d<? super lm.l2> dVar) {
            return ((e) create(d0Var, dVar)).invokeSuspend(lm.l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.server.netty.cio.NettyResponsePipeline", f = "NettyResponsePipeline.kt", i = {0, 0, 0, 1}, l = {TypedValues.CycleType.TYPE_PATH_ROTATE, TypedValues.CycleType.TYPE_EASING}, m = "processEmpty", n = {"lastFuture", "this_$iv", "prepareForClose$iv", "this_$iv"}, s = {"L$0", "L$1", "I$0", "L$0"})
    public static final class f extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public f(um.d<? super f> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.this.B(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.server.netty.cio.NettyResponsePipeline", f = "NettyResponsePipeline.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9}, l = {63, 404, 433, 437, 459, 463, 476, 477, 478, 479}, m = "processJobs", n = {"this", "this", "this_$iv", "call$iv", "this_$iv$iv", "this", "this_$iv", "call$iv", "this_$iv$iv$iv", "lastFuture$iv$iv$iv", "prepareForClose$iv$iv$iv", "this", "this_$iv", "call$iv", "this_$iv$iv$iv", "this", "this_$iv", "call$iv", "this_$iv$iv$iv", "lastFuture$iv$iv$iv", "prepareForClose$iv$iv$iv", "this", "this_$iv", "call$iv", "this_$iv$iv$iv", "this", "this_$iv", "call$iv", "this", "this_$iv", "call$iv", "this", "this_$iv", "call$iv", "this", "this_$iv", "call$iv"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    public static final class g extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public g(um.d<? super g> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.this.C(this);
        }
    }

    @xm.f(c = "io.ktor.server.netty.cio.NettyResponsePipeline", f = "NettyResponsePipeline.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 2}, l = {237, TypedValues.CycleType.TYPE_PATH_ROTATE, TypedValues.CycleType.TYPE_EASING}, m = "processSmallContent", n = {"this", NotificationCompat.CATEGORY_CALL, "buffer", ik.f.b.f7973h, FloatingWindow.f2048b0, "this_$iv", "lastFuture$iv", "prepareForClose$iv", "this_$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "I$0", "L$0"})
    public static final class h extends xm.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public h(um.d<? super h> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.this.D(null, null, 0, this);
        }
    }

    @xm.f(c = "io.ktor.server.netty.cio.NettyResponsePipeline$responses$1", f = "NettyResponsePipeline.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
    public static final class i extends o implements p<s0, um.d<? super lm.l2>, Object> {
        int label;

        public i(um.d<? super i> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @l
        public final um.d<lm.l2> create(@m Object obj, @l um.d<?> dVar) {
            return b.this.new i(dVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v9 */
        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    d1.n(obj);
                    b bVar = b.this;
                    this.label = 1;
                    Object objC = bVar.C(this);
                    this = objC;
                    if (objC == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                    this = this;
                }
            } catch (Throwable th2) {
                if (!(th2 instanceof CancellationException)) {
                    b.this.f945a.fireExceptionCaught(th2);
                }
                b.this.f945a.close();
            }
            return lm.l2.f10208a;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super lm.l2> dVar) {
            return ((i) create(s0Var, dVar)).invokeSuspend(lm.l2.f10208a);
        }
    }

    public b(@l ChannelHandlerContext channelHandlerContext, @l bl.e eVar, @l bl.a aVar, @l um.g gVar) {
        l0.p(channelHandlerContext, "dst");
        l0.p(eVar, "initialEncapsulation");
        l0.p(aVar, "requestQueue");
        l0.p(gVar, "coroutineContext");
        this.f945a = channelHandlerContext;
        this.f946b = aVar;
        this.f947c = gVar;
        int i10 = aVar.f938a;
        this.f948d = i10;
        int i11 = aVar.f939b;
        this.f949e = i11;
        this.f950f = aVar.f941d;
        this.f951g = new ArrayDeque<>(i10);
        this.f952i = new ArrayDeque<>(i11);
        EventExecutor eventExecutorExecutor = channelHandlerContext.executor();
        l0.o(eventExecutorExecutor, "dst.executor()");
        this.f953n = nq.k.e(this, new y1(eventExecutorExecutor).plus(bl.c.f956b), u0.UNDISPATCHED, new i(null));
        this.f954p = eVar;
    }

    public static /* synthetic */ void r() {
    }

    public final Object A(bl.a.C0029a c0029a, um.d<? super lm.l2> dVar) {
        l2 l2Var;
        al.i iVar = c0029a.f943d;
        try {
            Object objO0 = iVar.p().f385k.O0(dVar);
            q qVarP = iVar.p();
            ChannelFuture channelFutureF = bl.c.c(qVarP) ? F(objO0) : this.f945a.write(objO0);
            G();
            int i10 = 0;
            if (objO0 instanceof FullHttpResponse) {
                l0.o(channelFutureF, "requestMessageFuture");
                i10 = (!iVar.o().f370g || bl.c.c(iVar.p())) ? 1 : 0;
                if (!s() || i10 != 0) {
                    this.f945a.flush();
                }
                if (i10 != 0) {
                    this.f945a.flush();
                    al.a.f(channelFutureF, dVar);
                    this.f946b.b();
                }
            } else if ((objO0 instanceof Http2HeadersFrame) && ((Http2HeadersFrame) objO0).isEndStream()) {
                l0.o(channelFutureF, "requestMessageFuture");
                i10 = (!iVar.o().f370g || bl.c.c(iVar.p())) ? 1 : 0;
                if (!s() || i10 != 0) {
                    this.f945a.flush();
                }
                if (i10 != 0) {
                    this.f945a.flush();
                    al.a.f(channelFutureF, dVar);
                    this.f946b.b();
                }
            } else {
                if (qVarP.f386l != k.f13204a.a()) {
                    if (objO0 instanceof HttpResponse) {
                        i10 = ((HttpResponse) objO0).headers().getInt("Content-Length", -1);
                    } else {
                        i10 = objO0 instanceof Http2HeadersFrame ? ((Http2HeadersFrame) objO0).headers().getInt("content-length", -1) : -1;
                    }
                }
                if (i10 == 0) {
                    l0.o(channelFutureF, "requestMessageFuture");
                    B(iVar, channelFutureF, dVar);
                } else if (1 <= i10 && i10 < 65537) {
                    D(iVar, qVarP, i10, dVar);
                } else if (i10 == -1) {
                    l0.o(channelFutureF, "requestMessageFuture");
                    v(iVar, qVarP, channelFutureF, dVar);
                } else {
                    l0.o(channelFutureF, "requestMessageFuture");
                    w(iVar, qVarP, channelFutureF, dVar);
                }
            }
            l2Var = iVar.f342e;
        } catch (Throwable th2) {
            try {
                y(iVar, th2);
                l2Var = iVar.f342e;
            } catch (Throwable th3) {
                l2.a.b(iVar.f342e, null, 1, null);
                throw th3;
            }
        }
        l2.a.b(l2Var, null, 1, null);
        return lm.l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object B(al.i iVar, ChannelFuture channelFuture, um.d<? super lm.l2> dVar) {
        f fVar;
        int i10;
        ChannelFuture channelFutureWriteAndFlush;
        if (dVar instanceof f) {
            fVar = (f) dVar;
            int i11 = fVar.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                fVar.label = i11 - Integer.MIN_VALUE;
            } else {
                fVar = new f(dVar);
            }
        } else {
            fVar = new f(dVar);
        }
        Object objF = fVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i12 = fVar.label;
        if (i12 != 0) {
            if (i12 == 1) {
                int i13 = fVar.I$0;
                b bVar = (b) fVar.L$1;
                channelFuture = (ChannelFuture) fVar.L$0;
                d1.n(objF);
                i10 = i13;
                this = bVar;
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this = (b) fVar.L$0;
                d1.n(objF);
            }
            this.f946b.b();
            return lm.l2.f10208a;
        }
        d1.n(objF);
        boolean z10 = false;
        Object objA = this.f954p.a(false);
        i10 = (!iVar.o().f370g || bl.c.c(iVar.p())) ? 1 : 0;
        if (s() && i10 == 0) {
            z10 = true;
        }
        if (objA == null && z10) {
            channelFutureWriteAndFlush = null;
        } else {
            if (objA == null) {
                this.f945a.flush();
            } else if (z10) {
                this.f945a.write(objA);
            } else {
                channelFutureWriteAndFlush = this.f945a.writeAndFlush(objA);
            }
            channelFutureWriteAndFlush = null;
        }
        if (channelFutureWriteAndFlush != null) {
            fVar.L$0 = channelFuture;
            fVar.L$1 = this;
            fVar.I$0 = i10;
            fVar.label = 1;
            objF = al.a.f(channelFutureWriteAndFlush, fVar);
            if (objF == aVar) {
                return aVar;
            }
        } else if (i10 != 0) {
            this.f945a.flush();
            fVar.L$0 = this;
            fVar.L$1 = null;
            fVar.label = 2;
            if (al.a.f(channelFuture, fVar) == aVar) {
                return aVar;
            }
            this.f946b.b();
        }
        return lm.l2.f10208a;
        if (i10 != 0) {
            this.f945a.flush();
            fVar.L$0 = this;
            fVar.L$1 = null;
            fVar.label = 2;
            if (al.a.f(channelFuture, fVar) == aVar) {
                return aVar;
            }
            this.f946b.b();
        }
        return lm.l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x023c  */
    /* JADX WARN: Code duplicated, block: B:112:0x023d A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:58:0x0163, B:60:0x016d, B:64:0x017b, B:67:0x0185, B:69:0x0190, B:72:0x019b, B:76:0x01a4, B:87:0x01d9, B:89:0x01dd, B:91:0x01e6, B:93:0x01f1, B:96:0x01fc, B:100:0x0205, B:109:0x0231, B:120:0x0262, B:128:0x0282, B:132:0x0297, B:135:0x02ad, B:112:0x023d, B:114:0x0241, B:115:0x024e, B:117:0x0252, B:63:0x0175), top: B:148:0x0163 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0241 A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:58:0x0163, B:60:0x016d, B:64:0x017b, B:67:0x0185, B:69:0x0190, B:72:0x019b, B:76:0x01a4, B:87:0x01d9, B:89:0x01dd, B:91:0x01e6, B:93:0x01f1, B:96:0x01fc, B:100:0x0205, B:109:0x0231, B:120:0x0262, B:128:0x0282, B:132:0x0297, B:135:0x02ad, B:112:0x023d, B:114:0x0241, B:115:0x024e, B:117:0x0252, B:63:0x0175), top: B:148:0x0163 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x024e A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:58:0x0163, B:60:0x016d, B:64:0x017b, B:67:0x0185, B:69:0x0190, B:72:0x019b, B:76:0x01a4, B:87:0x01d9, B:89:0x01dd, B:91:0x01e6, B:93:0x01f1, B:96:0x01fc, B:100:0x0205, B:109:0x0231, B:120:0x0262, B:128:0x0282, B:132:0x0297, B:135:0x02ad, B:112:0x023d, B:114:0x0241, B:115:0x024e, B:117:0x0252, B:63:0x0175), top: B:148:0x0163 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x0252 A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:58:0x0163, B:60:0x016d, B:64:0x017b, B:67:0x0185, B:69:0x0190, B:72:0x019b, B:76:0x01a4, B:87:0x01d9, B:89:0x01dd, B:91:0x01e6, B:93:0x01f1, B:96:0x01fc, B:100:0x0205, B:109:0x0231, B:120:0x0262, B:128:0x0282, B:132:0x0297, B:135:0x02ad, B:112:0x023d, B:114:0x0241, B:115:0x024e, B:117:0x0252, B:63:0x0175), top: B:148:0x0163 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x025f  */
    /* JADX WARN: Code duplicated, block: B:120:0x0262 A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:58:0x0163, B:60:0x016d, B:64:0x017b, B:67:0x0185, B:69:0x0190, B:72:0x019b, B:76:0x01a4, B:87:0x01d9, B:89:0x01dd, B:91:0x01e6, B:93:0x01f1, B:96:0x01fc, B:100:0x0205, B:109:0x0231, B:120:0x0262, B:128:0x0282, B:132:0x0297, B:135:0x02ad, B:112:0x023d, B:114:0x0241, B:115:0x024e, B:117:0x0252, B:63:0x0175), top: B:148:0x0163 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0276 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:125:0x027b  */
    /* JADX WARN: Code duplicated, block: B:126:0x027d  */
    /* JADX WARN: Code duplicated, block: B:131:0x0295 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:132:0x0297 A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:58:0x0163, B:60:0x016d, B:64:0x017b, B:67:0x0185, B:69:0x0190, B:72:0x019b, B:76:0x01a4, B:87:0x01d9, B:89:0x01dd, B:91:0x01e6, B:93:0x01f1, B:96:0x01fc, B:100:0x0205, B:109:0x0231, B:120:0x0262, B:128:0x0282, B:132:0x0297, B:135:0x02ad, B:112:0x023d, B:114:0x0241, B:115:0x024e, B:117:0x0252, B:63:0x0175), top: B:148:0x0163 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x02ac A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:135:0x02ad A[Catch: all -> 0x0172, TRY_LEAVE, TryCatch #1 {all -> 0x0172, blocks: (B:58:0x0163, B:60:0x016d, B:64:0x017b, B:67:0x0185, B:69:0x0190, B:72:0x019b, B:76:0x01a4, B:87:0x01d9, B:89:0x01dd, B:91:0x01e6, B:93:0x01f1, B:96:0x01fc, B:100:0x0205, B:109:0x0231, B:120:0x0262, B:128:0x0282, B:132:0x0297, B:135:0x02ad, B:112:0x023d, B:114:0x0241, B:115:0x024e, B:117:0x0252, B:63:0x0175), top: B:148:0x0163 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x02c2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:152:0x01ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x0121 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x012a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0132  */
    /* JADX WARN: Code duplicated, block: B:53:0x013a  */
    /* JADX WARN: Code duplicated, block: B:56:0x0160 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x0161  */
    /* JADX WARN: Code duplicated, block: B:60:0x016d A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:58:0x0163, B:60:0x016d, B:64:0x017b, B:67:0x0185, B:69:0x0190, B:72:0x019b, B:76:0x01a4, B:87:0x01d9, B:89:0x01dd, B:91:0x01e6, B:93:0x01f1, B:96:0x01fc, B:100:0x0205, B:109:0x0231, B:120:0x0262, B:128:0x0282, B:132:0x0297, B:135:0x02ad, B:112:0x023d, B:114:0x0241, B:115:0x024e, B:117:0x0252, B:63:0x0175), top: B:148:0x0163 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0175 A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:58:0x0163, B:60:0x016d, B:64:0x017b, B:67:0x0185, B:69:0x0190, B:72:0x019b, B:76:0x01a4, B:87:0x01d9, B:89:0x01dd, B:91:0x01e6, B:93:0x01f1, B:96:0x01fc, B:100:0x0205, B:109:0x0231, B:120:0x0262, B:128:0x0282, B:132:0x0297, B:135:0x02ad, B:112:0x023d, B:114:0x0241, B:115:0x024e, B:117:0x0252, B:63:0x0175), top: B:148:0x0163 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0185 A[Catch: all -> 0x0172, TRY_ENTER, TryCatch #1 {all -> 0x0172, blocks: (B:58:0x0163, B:60:0x016d, B:64:0x017b, B:67:0x0185, B:69:0x0190, B:72:0x019b, B:76:0x01a4, B:87:0x01d9, B:89:0x01dd, B:91:0x01e6, B:93:0x01f1, B:96:0x01fc, B:100:0x0205, B:109:0x0231, B:120:0x0262, B:128:0x0282, B:132:0x0297, B:135:0x02ad, B:112:0x023d, B:114:0x0241, B:115:0x024e, B:117:0x0252, B:63:0x0175), top: B:148:0x0163 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0190 A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:58:0x0163, B:60:0x016d, B:64:0x017b, B:67:0x0185, B:69:0x0190, B:72:0x019b, B:76:0x01a4, B:87:0x01d9, B:89:0x01dd, B:91:0x01e6, B:93:0x01f1, B:96:0x01fc, B:100:0x0205, B:109:0x0231, B:120:0x0262, B:128:0x0282, B:132:0x0297, B:135:0x02ad, B:112:0x023d, B:114:0x0241, B:115:0x024e, B:117:0x0252, B:63:0x0175), top: B:148:0x0163 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x019a  */
    /* JADX WARN: Code duplicated, block: B:74:0x01a1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:76:0x01a4 A[Catch: all -> 0x0172, TRY_LEAVE, TryCatch #1 {all -> 0x0172, blocks: (B:58:0x0163, B:60:0x016d, B:64:0x017b, B:67:0x0185, B:69:0x0190, B:72:0x019b, B:76:0x01a4, B:87:0x01d9, B:89:0x01dd, B:91:0x01e6, B:93:0x01f1, B:96:0x01fc, B:100:0x0205, B:109:0x0231, B:120:0x0262, B:128:0x0282, B:132:0x0297, B:135:0x02ad, B:112:0x023d, B:114:0x0241, B:115:0x024e, B:117:0x0252, B:63:0x0175), top: B:148:0x0163 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:81:0x01c6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:82:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:87:0x01d9 A[Catch: all -> 0x0172, TRY_ENTER, TryCatch #1 {all -> 0x0172, blocks: (B:58:0x0163, B:60:0x016d, B:64:0x017b, B:67:0x0185, B:69:0x0190, B:72:0x019b, B:76:0x01a4, B:87:0x01d9, B:89:0x01dd, B:91:0x01e6, B:93:0x01f1, B:96:0x01fc, B:100:0x0205, B:109:0x0231, B:120:0x0262, B:128:0x0282, B:132:0x0297, B:135:0x02ad, B:112:0x023d, B:114:0x0241, B:115:0x024e, B:117:0x0252, B:63:0x0175), top: B:148:0x0163 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x01dd A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:58:0x0163, B:60:0x016d, B:64:0x017b, B:67:0x0185, B:69:0x0190, B:72:0x019b, B:76:0x01a4, B:87:0x01d9, B:89:0x01dd, B:91:0x01e6, B:93:0x01f1, B:96:0x01fc, B:100:0x0205, B:109:0x0231, B:120:0x0262, B:128:0x0282, B:132:0x0297, B:135:0x02ad, B:112:0x023d, B:114:0x0241, B:115:0x024e, B:117:0x0252, B:63:0x0175), top: B:148:0x0163 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x00ae: MOVE (r7 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:30:0x00ac */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00ac: MOVE (r2 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]), block:B:30:0x00ac */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00ad: MOVE (r4 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:30:0x00ac */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v17, types: [al.i, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18, types: [bl.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v5, types: [bl.b] */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v6, types: [al.i] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [bl.b] */
    /* JADX WARN: Type inference failed for: r2v9, types: [al.i, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [bl.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r4v5, types: [bl.b] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [bl.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v35 */
    /* JADX WARN: Type inference failed for: r7v36 */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v38 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v40 */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v42 */
    /* JADX WARN: Type inference failed for: r7v43 */
    /* JADX WARN: Type inference failed for: r7v44 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13, types: [al.i] */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v18, types: [al.i] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v22, types: [al.i] */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:123:0x0277 -> B:124:0x0278). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:142:0x02d0 -> B:43:0x010f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object C(um.d<? super lm.l2> r18) {
        /*
            Method dump skipped, instruction units count: 762
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bl.b.C(um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:50:0x010f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0122 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object D(al.i iVar, q qVar, int i10, um.d<? super lm.l2> dVar) {
        h hVar;
        al.i iVar2;
        ByteBuf byteBuf;
        b bVar;
        int i11;
        ChannelFuture channelFutureWrite;
        int i12;
        ChannelFuture channelFutureWriteAndFlush;
        int i13;
        b bVar2;
        b bVar3;
        if (dVar instanceof h) {
            hVar = (h) dVar;
            int i14 = hVar.label;
            if ((i14 & Integer.MIN_VALUE) != 0) {
                hVar.label = i14 - Integer.MIN_VALUE;
            } else {
                hVar = new h(dVar);
            }
        } else {
            hVar = new h(dVar);
        }
        Object objF = hVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i15 = hVar.label;
        if (i15 != 0) {
            if (i15 == 1) {
                i11 = hVar.I$1;
                i10 = hVar.I$0;
                byteBuf = (ByteBuf) hVar.L$2;
                iVar2 = (al.i) hVar.L$1;
                bVar = (b) hVar.L$0;
                d1.n(objF);
            } else {
                if (i15 == 2) {
                    i13 = hVar.I$0;
                    channelFutureWrite = (ChannelFuture) hVar.L$1;
                    bVar2 = (b) hVar.L$0;
                    d1.n(objF);
                    b bVar4 = bVar2;
                    i12 = i13;
                    bVar3 = bVar4;
                    if (i12 != 0) {
                        bVar3.f945a.flush();
                        hVar.L$0 = bVar3;
                        hVar.L$1 = null;
                        hVar.L$2 = null;
                        hVar.label = 3;
                        if (al.a.f(channelFutureWrite, hVar) == aVar) {
                            return aVar;
                        }
                    }
                    return lm.l2.f10208a;
                }
                if (i15 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bVar3 = (b) hVar.L$0;
                d1.n(objF);
            }
            bVar3.f946b.b();
            return lm.l2.f10208a;
        }
        d1.n(objF);
        ByteBuf byteBufBuffer = this.f945a.alloc().buffer(i10);
        k kVar = qVar.f386l;
        int iWriterIndex = byteBufBuffer.writerIndex();
        ByteBuffer byteBufferNioBuffer = byteBufBuffer.nioBuffer(iWriterIndex, byteBufBuffer.writableBytes());
        l0.o(byteBufferNioBuffer, "buffer.nioBuffer(start, buffer.writableBytes())");
        hVar.L$0 = this;
        hVar.L$1 = iVar;
        hVar.L$2 = byteBufBuffer;
        hVar.I$0 = i10;
        hVar.I$1 = iWriterIndex;
        hVar.label = 1;
        if (kVar.K(byteBufferNioBuffer, hVar) == aVar) {
            return aVar;
        }
        iVar2 = iVar;
        byteBuf = byteBufBuffer;
        bVar = this;
        i11 = iWriterIndex;
        byteBuf.writerIndex(i11 + i10);
        bl.e eVar = bVar.f954p;
        ChannelHandlerContext channelHandlerContext = bVar.f945a;
        l0.o(byteBuf, "buffer");
        channelFutureWrite = channelHandlerContext.write(eVar.c(byteBuf, true));
        Object objA = eVar.a(true);
        l0.o(channelFutureWrite, "future");
        i12 = (!iVar2.o().f370g || bl.c.c(iVar2.p())) ? 1 : 0;
        boolean z10 = bVar.s() && i12 == 0;
        if (objA == null && z10) {
            channelFutureWriteAndFlush = null;
        } else {
            if (objA == null) {
                bVar.f945a.flush();
            } else if (z10) {
                bVar.f945a.write(objA);
            } else {
                channelFutureWriteAndFlush = bVar.f945a.writeAndFlush(objA);
            }
            channelFutureWriteAndFlush = null;
        }
        if (channelFutureWriteAndFlush == null) {
            bVar3 = bVar;
        } else {
            hVar.L$0 = bVar;
            hVar.L$1 = channelFutureWrite;
            hVar.L$2 = null;
            hVar.I$0 = i12;
            hVar.label = 2;
            objF = al.a.f(channelFutureWriteAndFlush, hVar);
            if (objF == aVar) {
                return aVar;
            }
            i13 = i12;
            bVar2 = bVar;
            b bVar5 = bVar2;
            i12 = i13;
            bVar3 = bVar5;
        }
        if (i12 != 0) {
            bVar3.f945a.flush();
            hVar.L$0 = bVar3;
            hVar.L$1 = null;
            hVar.L$2 = null;
            hVar.label = 3;
            if (al.a.f(channelFutureWrite, hVar) == aVar) {
                return aVar;
            }
            bVar3.f946b.b();
        }
        return lm.l2.f10208a;
    }

    public final ChannelFuture F(Object obj) {
        ChannelFuture channelFutureWrite = this.f945a.write(obj);
        this.f954p.d(this.f945a);
        this.f954p = bl.e.c.f965a;
        this.f945a.flush();
        l0.o(channelFutureWrite, "future");
        return channelFutureWrite;
    }

    public final void G() {
        while (t()) {
            if (!u()) {
                H();
                this.f945a.read();
                return;
            }
            H();
        }
    }

    public final void H() {
        while (!this.f951g.isEmpty() && this.f952i.size() < this.f949e) {
            bl.a.C0029a c0029aRemoveFirst = this.f951g.removeFirst();
            if (!c0029aRemoveFirst.N()) {
                return;
            } else {
                this.f952i.addLast(c0029aRemoveFirst);
            }
        }
    }

    @Override // nq.s0
    @l
    public um.g getCoroutineContext() {
        return this.f947c;
    }

    public final void m() {
        this.f953n.start();
    }

    public final Object n(um.d<? super lm.l2> dVar) {
        Object objO;
        G();
        return (this.f952i.isEmpty() && (objO = o(dVar)) == wm.a.COROUTINE_SUSPENDED) ? objO : lm.l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object o(um.d<? super lm.l2> dVar) {
        a aVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object objI = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        if (i11 == 0) {
            d1.n(objI);
            if (this.f952i.isEmpty()) {
                f0<bl.a.C0029a> f0Var = this.f950f;
                aVar.L$0 = this;
                aVar.label = 1;
                objI = t.i(f0Var, aVar);
                if (objI == aVar2) {
                    return aVar2;
                }
            }
            return lm.l2.f10208a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this = (b) aVar.L$0;
        d1.n(objI);
        bl.a.C0029a c0029a = (bl.a.C0029a) objI;
        if (c0029a != null && c0029a.N()) {
            this.f952i.addLast(c0029a);
            this.G();
        }
        return lm.l2.f10208a;
    }

    public final Object p(al.i iVar, Object obj, ChannelFuture channelFuture, um.d<? super lm.l2> dVar) {
        boolean z10 = !iVar.o().f370g || bl.c.c(iVar.p());
        boolean z11 = s() && !z10;
        ChannelFuture channelFutureWriteAndFlush = null;
        if (obj != null || !z11) {
            if (obj == null) {
                this.f945a.flush();
            } else if (z11) {
                this.f945a.write(obj);
            } else {
                channelFutureWriteAndFlush = this.f945a.writeAndFlush(obj);
            }
        }
        if (channelFutureWriteAndFlush != null) {
        }
        if (z10) {
            this.f945a.flush();
            al.a.f(channelFuture, dVar);
            this.f946b.b();
        }
        return lm.l2.f10208a;
    }

    public final boolean s() {
        G();
        bl.a.C0029a c0029aPeekFirst = this.f952i.peekFirst();
        return c0029aPeekFirst != null && c0029aPeekFirst.f944e.isCompleted();
    }

    public final boolean t() {
        return this.f951g.size() < this.f948d || this.f952i.size() < this.f949e;
    }

    public final boolean u() {
        int size = this.f948d - this.f951g.size();
        if (1 <= size) {
            int i10 = 1;
            while (true) {
                int i11 = i10 + 1;
                bl.a.C0029a c0029aPoll = this.f950f.poll();
                if (c0029aPoll == null) {
                    return false;
                }
                this.f951g.addLast(c0029aPoll);
                if (i10 != size) {
                    i10 = i11;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x010e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0124 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object v(al.i iVar, q qVar, ChannelFuture channelFuture, um.d<? super lm.l2> dVar) {
        C0030b c0030b;
        al.i iVar2;
        b bVar;
        k1.h hVar;
        bl.e eVar;
        int i10;
        ChannelFuture channelFutureWriteAndFlush;
        b bVar2;
        int i11;
        ChannelFuture channelFuture2;
        b bVar3;
        if (dVar instanceof C0030b) {
            c0030b = (C0030b) dVar;
            int i12 = c0030b.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                c0030b.label = i12 - Integer.MIN_VALUE;
            } else {
                c0030b = new C0030b(dVar);
            }
        } else {
            c0030b = new C0030b(dVar);
        }
        C0030b c0030b2 = c0030b;
        Object obj = c0030b2.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i13 = c0030b2.label;
        if (i13 != 0) {
            if (i13 == 1) {
                hVar = (k1.h) c0030b2.L$3;
                eVar = (bl.e) c0030b2.L$2;
                al.i iVar3 = (al.i) c0030b2.L$1;
                bVar = (b) c0030b2.L$0;
                d1.n(obj);
                iVar2 = iVar3;
            } else {
                if (i13 == 2) {
                    i11 = c0030b2.I$0;
                    channelFuture2 = (ChannelFuture) c0030b2.L$1;
                    bVar2 = (b) c0030b2.L$0;
                    d1.n(obj);
                    i10 = i11;
                    bVar3 = bVar2;
                    if (i10 != 0) {
                        bVar3.f945a.flush();
                        c0030b2.L$0 = bVar3;
                        c0030b2.L$1 = null;
                        c0030b2.L$2 = null;
                        c0030b2.L$3 = null;
                        c0030b2.label = 3;
                        if (al.a.f(channelFuture2, c0030b2) == aVar) {
                            return aVar;
                        }
                    }
                    return lm.l2.f10208a;
                }
                if (i13 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bVar3 = (b) c0030b2.L$0;
                d1.n(obj);
            }
            bVar3.f946b.b();
            return lm.l2.f10208a;
        }
        d1.n(obj);
        k kVar = qVar.f386l;
        bl.e eVar2 = this.f954p;
        k1.f fVar = new k1.f();
        k1.h hVar2 = new k1.h();
        hVar2.element = channelFuture;
        c cVar = new c(fVar, eVar2, kVar, hVar2, null);
        c0030b2.L$0 = this;
        iVar2 = iVar;
        c0030b2.L$1 = iVar2;
        c0030b2.L$2 = eVar2;
        c0030b2.L$3 = hVar2;
        c0030b2.label = 1;
        if (kVar.G(cVar, c0030b2) == aVar) {
            return aVar;
        }
        bVar = this;
        hVar = hVar2;
        eVar = eVar2;
        Object objA = eVar.a(false);
        ChannelFuture channelFuture3 = (ChannelFuture) hVar.element;
        i10 = (!iVar2.o().f370g || bl.c.c(iVar2.p())) ? 1 : 0;
        boolean z10 = bVar.s() && i10 == 0;
        if (objA == null && z10) {
            channelFutureWriteAndFlush = null;
        } else {
            if (objA == null) {
                bVar.f945a.flush();
            } else if (z10) {
                bVar.f945a.write(objA);
            } else {
                channelFutureWriteAndFlush = bVar.f945a.writeAndFlush(objA);
            }
            channelFutureWriteAndFlush = null;
        }
        if (channelFutureWriteAndFlush == null) {
            channelFuture2 = channelFuture3;
            bVar3 = bVar;
        } else {
            c0030b2.L$0 = bVar;
            c0030b2.L$1 = channelFuture3;
            c0030b2.L$2 = null;
            c0030b2.L$3 = null;
            c0030b2.I$0 = i10;
            c0030b2.label = 2;
            Object objF = al.a.f(channelFutureWriteAndFlush, c0030b2);
            if (objF == aVar) {
                return aVar;
            }
            bVar2 = bVar;
            i11 = i10;
            obj = objF;
            channelFuture2 = channelFuture3;
            i10 = i11;
            bVar3 = bVar2;
        }
        if (i10 != 0) {
            bVar3.f945a.flush();
            c0030b2.L$0 = bVar3;
            c0030b2.L$1 = null;
            c0030b2.L$2 = null;
            c0030b2.L$3 = null;
            c0030b2.label = 3;
            if (al.a.f(channelFuture2, c0030b2) == aVar) {
                return aVar;
            }
            bVar3.f946b.b();
        }
        return lm.l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x010b  */
    /* JADX WARN: Code duplicated, block: B:53:0x0121 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object w(al.i iVar, q qVar, ChannelFuture channelFuture, um.d<? super lm.l2> dVar) {
        d dVar2;
        al.i iVar2;
        b bVar;
        bl.e eVar;
        k1.h hVar;
        int i10;
        ChannelFuture channelFutureWriteAndFlush;
        b bVar2;
        int i11;
        ChannelFuture channelFuture2;
        b bVar3;
        if (dVar instanceof d) {
            dVar2 = (d) dVar;
            int i12 = dVar2.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                dVar2.label = i12 - Integer.MIN_VALUE;
            } else {
                dVar2 = new d(dVar);
            }
        } else {
            dVar2 = new d(dVar);
        }
        d dVar3 = dVar2;
        Object obj = dVar3.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i13 = dVar3.label;
        if (i13 != 0) {
            if (i13 == 1) {
                hVar = (k1.h) dVar3.L$3;
                eVar = (bl.e) dVar3.L$2;
                al.i iVar3 = (al.i) dVar3.L$1;
                bVar = (b) dVar3.L$0;
                d1.n(obj);
                iVar2 = iVar3;
            } else {
                if (i13 == 2) {
                    i11 = dVar3.I$0;
                    channelFuture2 = (ChannelFuture) dVar3.L$1;
                    bVar2 = (b) dVar3.L$0;
                    d1.n(obj);
                    i10 = i11;
                    bVar3 = bVar2;
                    if (i10 != 0) {
                        bVar3.f945a.flush();
                        dVar3.L$0 = bVar3;
                        dVar3.L$1 = null;
                        dVar3.L$2 = null;
                        dVar3.L$3 = null;
                        dVar3.label = 3;
                        if (al.a.f(channelFuture2, dVar3) == aVar) {
                            return aVar;
                        }
                    }
                    return lm.l2.f10208a;
                }
                if (i13 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bVar3 = (b) dVar3.L$0;
                d1.n(obj);
            }
            bVar3.f946b.b();
            return lm.l2.f10208a;
        }
        d1.n(obj);
        k kVar = qVar.f386l;
        bl.e eVar2 = this.f954p;
        k1.f fVar = new k1.f();
        k1.h hVar2 = new k1.h();
        hVar2.element = channelFuture;
        e eVar3 = new e(fVar, eVar2, hVar2, null);
        dVar3.L$0 = this;
        iVar2 = iVar;
        dVar3.L$1 = iVar2;
        dVar3.L$2 = eVar2;
        dVar3.L$3 = hVar2;
        dVar3.label = 1;
        if (kVar.G(eVar3, dVar3) == aVar) {
            return aVar;
        }
        bVar = this;
        eVar = eVar2;
        hVar = hVar2;
        Object objA = eVar.a(false);
        ChannelFuture channelFuture3 = (ChannelFuture) hVar.element;
        i10 = (!iVar2.o().f370g || bl.c.c(iVar2.p())) ? 1 : 0;
        boolean z10 = bVar.s() && i10 == 0;
        if (objA == null && z10) {
            channelFutureWriteAndFlush = null;
        } else {
            if (objA == null) {
                bVar.f945a.flush();
            } else if (z10) {
                bVar.f945a.write(objA);
            } else {
                channelFutureWriteAndFlush = bVar.f945a.writeAndFlush(objA);
            }
            channelFutureWriteAndFlush = null;
        }
        if (channelFutureWriteAndFlush == null) {
            channelFuture2 = channelFuture3;
            bVar3 = bVar;
        } else {
            dVar3.L$0 = bVar;
            dVar3.L$1 = channelFuture3;
            dVar3.L$2 = null;
            dVar3.L$3 = null;
            dVar3.I$0 = i10;
            dVar3.label = 2;
            Object objF = al.a.f(channelFutureWriteAndFlush, dVar3);
            if (objF == aVar) {
                return aVar;
            }
            bVar2 = bVar;
            i11 = i10;
            obj = objF;
            channelFuture2 = channelFuture3;
            i10 = i11;
            bVar3 = bVar2;
        }
        if (i10 != 0) {
            bVar3.f945a.flush();
            dVar3.L$0 = bVar3;
            dVar3.L$1 = null;
            dVar3.L$2 = null;
            dVar3.L$3 = null;
            dVar3.label = 3;
            if (al.a.f(channelFuture2, dVar3) == aVar) {
                return aVar;
            }
            bVar3.f946b.b();
        }
        return lm.l2.f10208a;
    }

    public final Object x(al.i iVar, um.d<? super lm.l2> dVar) {
        Object objO0 = iVar.p().f385k.O0(dVar);
        q qVarP = iVar.p();
        ChannelFuture channelFutureF = bl.c.c(qVarP) ? F(objO0) : this.f945a.write(objO0);
        G();
        boolean z10 = true;
        int i10 = 0;
        if (objO0 instanceof FullHttpResponse) {
            l0.o(channelFutureF, "requestMessageFuture");
            if (iVar.o().f370g && !bl.c.c(iVar.p())) {
                z10 = false;
            }
            if (!s() || z10) {
                this.f945a.flush();
            }
            if (z10) {
                this.f945a.flush();
                al.a.f(channelFutureF, dVar);
                this.f946b.b();
            }
            return lm.l2.f10208a;
        }
        boolean z11 = objO0 instanceof Http2HeadersFrame;
        if (z11 && ((Http2HeadersFrame) objO0).isEndStream()) {
            l0.o(channelFutureF, "requestMessageFuture");
            if (iVar.o().f370g && !bl.c.c(iVar.p())) {
                z10 = false;
            }
            if (!s() || z10) {
                this.f945a.flush();
            }
            if (z10) {
                this.f945a.flush();
                al.a.f(channelFutureF, dVar);
                this.f946b.b();
            }
            return lm.l2.f10208a;
        }
        if (qVarP.f386l != k.f13204a.a()) {
            if (objO0 instanceof HttpResponse) {
                i10 = ((HttpResponse) objO0).headers().getInt("Content-Length", -1);
            } else {
                i10 = z11 ? ((Http2HeadersFrame) objO0).headers().getInt("content-length", -1) : -1;
            }
        }
        if (i10 == 0) {
            l0.o(channelFutureF, "requestMessageFuture");
            B(iVar, channelFutureF, dVar);
            return lm.l2.f10208a;
        }
        if (1 <= i10 && i10 < 65537) {
            D(iVar, qVarP, i10, dVar);
            return lm.l2.f10208a;
        }
        if (i10 == -1) {
            l0.o(channelFutureF, "requestMessageFuture");
            v(iVar, qVarP, channelFutureF, dVar);
            return lm.l2.f10208a;
        }
        l0.o(channelFutureF, "requestMessageFuture");
        w(iVar, qVarP, channelFutureF, dVar);
        return lm.l2.f10208a;
    }

    public final void y(al.i iVar, Throwable th2) {
        if ((th2 instanceof IOException) && !(th2 instanceof gl.c)) {
            th2 = new gl.e(null, th2, 1, null);
        }
        iVar.p().f386l.c(th2);
        l2.a.b(iVar.f342e, null, 1, null);
        iVar.p().z();
        iVar.j();
        l2.a.b(this.f953n, null, 1, null);
        this.f946b.b();
    }
}
