package bl;

import androidx.core.app.NotificationCompat;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.EventExecutor;
import java.nio.ByteBuffer;
import jn.p;
import kn.l0;
import lm.d1;
import nq.a0;
import nq.k;
import nq.l2;
import nq.s0;
import nq.u0;
import nq.w1;
import nq.y;
import nq.y1;
import os.l;
import os.m;
import pl.n;
import pq.g0;
import pq.w;
import um.g;
import xm.f;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends ChannelInboundHandlerAdapter implements s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final ChannelHandlerContext f957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final bl.a f958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final y f959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final pq.l<Object> f960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public final l2 f961e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public static final a f962a = new a();
    }

    @f(c = "io.ktor.server.netty.cio.RequestBodyHandler$job$1", f = "RequestBodyHandler.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {37, 42, 50}, m = "invokeSuspend", n = {"$this$launch", "current", "upgraded", "$this$launch", "current", NotificationCompat.CATEGORY_EVENT, "upgraded", "$this$launch", "current", "upgraded"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0"})
    public static final class b extends o implements p<s0, um.d<? super lm.l2>, Object> {
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public b(um.d<? super b> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @l
        public final um.d<lm.l2> create(@m Object obj, @l um.d<?> dVar) {
            b bVar = d.this.new b(dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0069 A[Catch: all -> 0x001e, TryCatch #3 {all -> 0x001e, blocks: (B:8:0x001a, B:23:0x005f, B:25:0x0069, B:29:0x0075, B:28:0x0072, B:20:0x004a), top: B:99:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:27:0x0071  */
        /* JADX WARN: Code duplicated, block: B:28:0x0072 A[Catch: all -> 0x001e, TryCatch #3 {all -> 0x001e, blocks: (B:8:0x001a, B:23:0x005f, B:25:0x0069, B:29:0x0075, B:28:0x0072, B:20:0x004a), top: B:99:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:31:0x0087 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:33:0x008a  */
        /* JADX WARN: Code duplicated, block: B:36:0x0091  */
        /* JADX WARN: Code duplicated, block: B:39:0x00a9 A[PHI: r1 r6 r7 r13
          0x00a9: PHI (r1v5 int) = (r1v7 int), (r1v8 int) binds: [B:32:0x0088, B:24:0x0067] A[DONT_GENERATE, DONT_INLINE]
          0x00a9: PHI (r6v9 kn.k1$h) = (r6v16 kn.k1$h), (r6v17 kn.k1$h) binds: [B:32:0x0088, B:24:0x0067] A[DONT_GENERATE, DONT_INLINE]
          0x00a9: PHI (r7v3 nq.s0) = (r7v4 nq.s0), (r7v5 nq.s0) binds: [B:32:0x0088, B:24:0x0067] A[DONT_GENERATE, DONT_INLINE]
          0x00a9: PHI (r13v13 java.lang.Object) = (r13v16 java.lang.Object), (r13v24 java.lang.Object) binds: [B:32:0x0088, B:24:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:43:0x00b2 A[Catch: all -> 0x00de, TRY_ENTER, TryCatch #2 {all -> 0x00de, blocks: (B:40:0x00ac, B:43:0x00b2, B:45:0x00b8, B:49:0x00d0, B:51:0x00d4, B:55:0x00e5, B:56:0x00ea, B:57:0x00eb, B:59:0x00ef, B:61:0x00f5, B:64:0x010a, B:65:0x010f, B:66:0x0110, B:68:0x0114, B:72:0x011e, B:71:0x011b, B:73:0x0121), top: B:98:0x00ac }] */
        /* JADX WARN: Code duplicated, block: B:45:0x00b8 A[Catch: all -> 0x00de, TryCatch #2 {all -> 0x00de, blocks: (B:40:0x00ac, B:43:0x00b2, B:45:0x00b8, B:49:0x00d0, B:51:0x00d4, B:55:0x00e5, B:56:0x00ea, B:57:0x00eb, B:59:0x00ef, B:61:0x00f5, B:64:0x010a, B:65:0x010f, B:66:0x0110, B:68:0x0114, B:72:0x011e, B:71:0x011b, B:73:0x0121), top: B:98:0x00ac }] */
        /* JADX WARN: Code duplicated, block: B:47:0x00cd A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:49:0x00d0 A[Catch: all -> 0x00de, TryCatch #2 {all -> 0x00de, blocks: (B:40:0x00ac, B:43:0x00b2, B:45:0x00b8, B:49:0x00d0, B:51:0x00d4, B:55:0x00e5, B:56:0x00ea, B:57:0x00eb, B:59:0x00ef, B:61:0x00f5, B:64:0x010a, B:65:0x010f, B:66:0x0110, B:68:0x0114, B:72:0x011e, B:71:0x011b, B:73:0x0121), top: B:98:0x00ac }] */
        /* JADX WARN: Code duplicated, block: B:55:0x00e5 A[Catch: all -> 0x00de, TryCatch #2 {all -> 0x00de, blocks: (B:40:0x00ac, B:43:0x00b2, B:45:0x00b8, B:49:0x00d0, B:51:0x00d4, B:55:0x00e5, B:56:0x00ea, B:57:0x00eb, B:59:0x00ef, B:61:0x00f5, B:64:0x010a, B:65:0x010f, B:66:0x0110, B:68:0x0114, B:72:0x011e, B:71:0x011b, B:73:0x0121), top: B:98:0x00ac }] */
        /* JADX WARN: Code duplicated, block: B:57:0x00eb A[Catch: all -> 0x00de, TryCatch #2 {all -> 0x00de, blocks: (B:40:0x00ac, B:43:0x00b2, B:45:0x00b8, B:49:0x00d0, B:51:0x00d4, B:55:0x00e5, B:56:0x00ea, B:57:0x00eb, B:59:0x00ef, B:61:0x00f5, B:64:0x010a, B:65:0x010f, B:66:0x0110, B:68:0x0114, B:72:0x011e, B:71:0x011b, B:73:0x0121), top: B:98:0x00ac }] */
        /* JADX WARN: Code duplicated, block: B:59:0x00ef A[Catch: all -> 0x00de, TryCatch #2 {all -> 0x00de, blocks: (B:40:0x00ac, B:43:0x00b2, B:45:0x00b8, B:49:0x00d0, B:51:0x00d4, B:55:0x00e5, B:56:0x00ea, B:57:0x00eb, B:59:0x00ef, B:61:0x00f5, B:64:0x010a, B:65:0x010f, B:66:0x0110, B:68:0x0114, B:72:0x011e, B:71:0x011b, B:73:0x0121), top: B:98:0x00ac }] */
        /* JADX WARN: Code duplicated, block: B:61:0x00f5 A[Catch: all -> 0x00de, TryCatch #2 {all -> 0x00de, blocks: (B:40:0x00ac, B:43:0x00b2, B:45:0x00b8, B:49:0x00d0, B:51:0x00d4, B:55:0x00e5, B:56:0x00ea, B:57:0x00eb, B:59:0x00ef, B:61:0x00f5, B:64:0x010a, B:65:0x010f, B:66:0x0110, B:68:0x0114, B:72:0x011e, B:71:0x011b, B:73:0x0121), top: B:98:0x00ac }] */
        /* JADX WARN: Code duplicated, block: B:63:0x0109 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:64:0x010a A[Catch: all -> 0x00de, TryCatch #2 {all -> 0x00de, blocks: (B:40:0x00ac, B:43:0x00b2, B:45:0x00b8, B:49:0x00d0, B:51:0x00d4, B:55:0x00e5, B:56:0x00ea, B:57:0x00eb, B:59:0x00ef, B:61:0x00f5, B:64:0x010a, B:65:0x010f, B:66:0x0110, B:68:0x0114, B:72:0x011e, B:71:0x011b, B:73:0x0121), top: B:98:0x00ac }] */
        /* JADX WARN: Code duplicated, block: B:66:0x0110 A[Catch: all -> 0x00de, TryCatch #2 {all -> 0x00de, blocks: (B:40:0x00ac, B:43:0x00b2, B:45:0x00b8, B:49:0x00d0, B:51:0x00d4, B:55:0x00e5, B:56:0x00ea, B:57:0x00eb, B:59:0x00ef, B:61:0x00f5, B:64:0x010a, B:65:0x010f, B:66:0x0110, B:68:0x0114, B:72:0x011e, B:71:0x011b, B:73:0x0121), top: B:98:0x00ac }] */
        /* JADX WARN: Code duplicated, block: B:68:0x0114 A[Catch: all -> 0x00de, TryCatch #2 {all -> 0x00de, blocks: (B:40:0x00ac, B:43:0x00b2, B:45:0x00b8, B:49:0x00d0, B:51:0x00d4, B:55:0x00e5, B:56:0x00ea, B:57:0x00eb, B:59:0x00ef, B:61:0x00f5, B:64:0x010a, B:65:0x010f, B:66:0x0110, B:68:0x0114, B:72:0x011e, B:71:0x011b, B:73:0x0121), top: B:98:0x00ac }] */
        /* JADX WARN: Code duplicated, block: B:70:0x011a  */
        /* JADX WARN: Code duplicated, block: B:71:0x011b A[Catch: all -> 0x00de, TryCatch #2 {all -> 0x00de, blocks: (B:40:0x00ac, B:43:0x00b2, B:45:0x00b8, B:49:0x00d0, B:51:0x00d4, B:55:0x00e5, B:56:0x00ea, B:57:0x00eb, B:59:0x00ef, B:61:0x00f5, B:64:0x010a, B:65:0x010f, B:66:0x0110, B:68:0x0114, B:72:0x011e, B:71:0x011b, B:73:0x0121), top: B:98:0x00ac }] */
        /* JADX WARN: Code duplicated, block: B:73:0x0121 A[Catch: all -> 0x00de, TRY_LEAVE, TryCatch #2 {all -> 0x00de, blocks: (B:40:0x00ac, B:43:0x00b2, B:45:0x00b8, B:49:0x00d0, B:51:0x00d4, B:55:0x00e5, B:56:0x00ea, B:57:0x00eb, B:59:0x00ef, B:61:0x00f5, B:64:0x010a, B:65:0x010f, B:66:0x0110, B:68:0x0114, B:72:0x011e, B:71:0x011b, B:73:0x0121), top: B:98:0x00ac }] */
        /* JADX WARN: Code duplicated, block: B:75:0x0125  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00e2 -> B:23:0x005f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0125 -> B:23:0x005f). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:45:0x00b8
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 374
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: bl.d.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super lm.l2> dVar) {
            return ((b) create(s0Var, dVar)).invokeSuspend(lm.l2.f10208a);
        }
    }

    @f(c = "io.ktor.server.netty.cio.RequestBodyHandler", f = "RequestBodyHandler.kt", i = {0}, l = {110}, m = "processContent", n = {NotificationCompat.CATEGORY_EVENT}, s = {"L$0"})
    public static final class c extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public c(um.d<? super c> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return d.this.k0(null, null, this);
        }
    }

    /* JADX INFO: renamed from: bl.d$d, reason: collision with other inner class name */
    @f(c = "io.ktor.server.netty.cio.RequestBodyHandler", f = "RequestBodyHandler.kt", i = {0}, l = {y5.a.f20730l0}, m = "processContent", n = {"buf"}, s = {"L$0"})
    public static final class C0031d extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C0031d(um.d<? super C0031d> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return d.this.g0(null, null, this);
        }
    }

    public d(@l ChannelHandlerContext channelHandlerContext, @l bl.a aVar) {
        l0.p(channelHandlerContext, "context");
        l0.p(aVar, "requestQueue");
        this.f957a = channelHandlerContext;
        this.f958b = aVar;
        this.f959c = a0.c(null, 1, null);
        this.f960d = pq.o.d(Integer.MAX_VALUE, null, null, 6, null);
        EventExecutor eventExecutorExecutor = channelHandlerContext.executor();
        l0.o(eventExecutorExecutor, "context.executor()");
        this.f961e = k.e(this, new y1(eventExecutorExecutor), u0.LAZY, new b(null));
    }

    @l
    public final ChannelHandlerContext A() {
        return this.f957a;
    }

    public final void O(ReferenceCounted referenceCounted) {
        if (this.f960d.offer(referenceCounted)) {
            return;
        }
        referenceCounted.release();
        throw new IllegalStateException("Unable to process received buffer: queue offer failed");
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(@l ChannelHandlerContext channelHandlerContext, @m Object obj) {
        l0.p(channelHandlerContext, "ctx");
        if (obj instanceof ByteBufHolder) {
            O((ReferenceCounted) obj);
        } else if (obj instanceof ByteBuf) {
            O((ReferenceCounted) obj);
        } else {
            channelHandlerContext.fireChannelRead(obj);
        }
    }

    public final void close() {
        g0.a.a(this.f960d, null, 1, null);
    }

    @l
    public final pl.k e0() {
        pl.c cVarC = pl.e.c(false, 1, null);
        q0(cVarC);
        return cVarC;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(@m ChannelHandlerContext channelHandlerContext, @l Throwable th2) {
        l0.p(th2, "cause");
        this.f959c.k(th2);
        this.f960d.f(th2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object g0(n nVar, ByteBuf byteBuf, um.d<? super lm.l2> dVar) {
        C0031d c0031d;
        if (dVar instanceof C0031d) {
            c0031d = (C0031d) dVar;
            int i10 = c0031d.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c0031d.label = i10 - Integer.MIN_VALUE;
            } else {
                c0031d = new C0031d(dVar);
            }
        } else {
            c0031d = new C0031d(dVar);
        }
        Object obj = c0031d.result;
        Object obj2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = c0031d.label;
        try {
            if (i11 == 0) {
                d1.n(obj);
                l0();
                c0031d.L$0 = byteBuf;
                c0031d.label = 1;
                if (y(byteBuf, nVar, c0031d) == obj2) {
                    return obj2;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                byteBuf = (ByteBuf) c0031d.L$0;
                d1.n(obj);
            }
            byteBuf.release();
            return lm.l2.f10208a;
        } catch (Throwable th2) {
            byteBuf.release();
            throw th2;
        }
    }

    @Override // nq.s0
    @l
    public g getCoroutineContext() {
        return this.f959c;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(@m ChannelHandlerContext channelHandlerContext) {
        this.f961e.start();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(@m ChannelHandlerContext channelHandlerContext) {
        if (g0.a.a(this.f960d, null, 1, null) && this.f961e.isCompleted()) {
            t();
            l2.a.b(this.f959c, null, 1, null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object k0(n nVar, ByteBufHolder byteBufHolder, um.d<? super lm.l2> dVar) {
        c cVar;
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
        Object obj2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = cVar.label;
        try {
            if (i11 == 0) {
                d1.n(obj);
                l0();
                ByteBuf byteBufContent = byteBufHolder.content();
                l0.o(byteBufContent, "buf");
                cVar.L$0 = byteBufHolder;
                cVar.label = 1;
                if (y(byteBufContent, nVar, cVar) == obj2) {
                    return obj2;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                byteBufHolder = (ByteBufHolder) cVar.L$0;
                d1.n(obj);
            }
            byteBufHolder.release();
            return lm.l2.f10208a;
        } catch (Throwable th2) {
            byteBufHolder.release();
            throw th2;
        }
    }

    public final void l0() {
        if (this.f958b.f940c.isEmpty()) {
            this.f957a.read();
        }
    }

    public final void q0(Object obj) {
        try {
            if (this.f960d.offer(obj)) {
                return;
            }
            throw new IllegalStateException("Unable to start request processing: failed to offer " + obj + " to the HTTP pipeline queue");
        } catch (w e10) {
            throw w1.a("HTTP pipeline has been terminated.", e10);
        }
    }

    public final void t() {
        Object objPoll;
        while (!this.f960d.isEmpty()) {
            try {
                objPoll = this.f960d.poll();
            } catch (Throwable unused) {
                objPoll = null;
            }
            if (objPoll == null) {
                return;
            }
            if (objPoll instanceof pl.c) {
                pl.o.a((n) objPoll);
            } else if (objPoll instanceof ReferenceCounted) {
                ((ReferenceCounted) objPoll).release();
            }
        }
    }

    @l
    public final pl.k u0() {
        q0(a.f962a);
        return e0();
    }

    public final Object y(ByteBuf byteBuf, n nVar, um.d<? super lm.l2> dVar) {
        int i10 = byteBuf.readableBytes();
        if (i10 <= 0) {
            return lm.l2.f10208a;
        }
        ByteBuffer byteBufferInternalNioBuffer = byteBuf.internalNioBuffer(byteBuf.readerIndex(), i10);
        l0.o(byteBufferInternalNioBuffer, "buffer");
        Object objM = nVar.M(byteBufferInternalNioBuffer, dVar);
        return objM == wm.a.COROUTINE_SUSPENDED ? objM : lm.l2.f10208a;
    }
}
