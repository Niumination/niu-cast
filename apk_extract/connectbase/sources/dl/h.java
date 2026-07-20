package dl;

import ik.c1;
import ik.n1;
import ik.t0;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http2.DefaultHttp2Headers;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2DataFrame;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2FrameCodec;
import io.netty.handler.codec.http2.Http2FrameStream;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.handler.codec.http2.Http2HeadersFrame;
import io.netty.handler.codec.http2.Http2MultiplexCodec;
import io.netty.handler.codec.http2.Http2ResetFrame;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.handler.codec.http2.Http2StreamChannel;
import io.netty.handler.codec.http2.Http2StreamChannelBootstrap;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.ExecutionException;
import kn.n0;
import kn.w;
import lm.d0;
import lm.f0;
import n1.i;
import nq.b0;
import nq.k1;
import nq.l0;
import nq.l2;
import nq.l3;
import nq.s0;
import os.l;
import os.m;
import pq.g0;
import vk.j;
import yk.a0;

/* JADX INFO: loaded from: classes2.dex */
@ChannelHandler.Sharable
public final class h extends ChannelInboundHandlerAdapter implements s0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public static final a f3743g = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AttributeKey<dl.c> f3744i = AttributeKey.newInstance("ktor.ApplicationCall");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final a0 f3745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final dk.a f3746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final EventExecutorGroup f3747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final um.g f3748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public final b0 f3749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public final d0 f3750f;

    public static final class a {
        public a() {
        }

        public final dl.c c(ChannelHandlerContext channelHandlerContext) {
            return (dl.c) channelHandlerContext.channel().attr(h.f3744i).get();
        }

        public final void d(ChannelHandlerContext channelHandlerContext, dl.c cVar) {
            channelHandlerContext.channel().attr(h.f3744i).set(cVar);
        }

        public a(w wVar) {
        }
    }

    public static final class b extends ClosedChannelException implements l0<b> {
        private final long errorCode;

        public b(long j10) {
            this.errorCode = j10;
        }

        public final long getErrorCode() {
            return this.errorCode;
        }

        @Override // java.lang.Throwable
        @l
        public String getMessage() {
            return kn.l0.C("Got close frame with code ", Long.valueOf(this.errorCode));
        }

        @Override // nq.l0
        @m
        public b createCopy() {
            b bVar = new b(this.errorCode);
            bVar.initCause(this);
            return bVar;
        }
    }

    public static final class c extends n0 implements jn.a<Field> {
        public static final c INSTANCE = new c();

        public c() {
            super(0);
        }

        @Override // jn.a
        @m
        public final Field invoke() {
            try {
                Field declaredField = Http2FrameCodec.class.getDeclaredField("streamKey");
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public h(@l a0 a0Var, @l dk.a aVar, @l EventExecutorGroup eventExecutorGroup, @l um.g gVar) {
        kn.l0.p(a0Var, "enginePipeline");
        kn.l0.p(aVar, i.f11236l);
        kn.l0.p(eventExecutorGroup, "callEventGroup");
        kn.l0.p(gVar, "userCoroutineContext");
        this.f3745a = a0Var;
        this.f3746b = aVar;
        this.f3747c = eventExecutorGroup;
        this.f3748d = gVar;
        this.f3749e = new l3((l2) gVar.get(l2.f11882k));
        this.f3750f = f0.b(c.INSTANCE);
    }

    public static final void O(h hVar, Http2StreamChannel http2StreamChannel, DefaultHttp2Headers defaultHttp2Headers, Future future) throws ExecutionException, InterruptedException {
        kn.l0.p(hVar, "this$0");
        kn.l0.p(defaultHttp2Headers, "$headers");
        future.get();
        ChannelHandlerContext channelHandlerContextFirstContext = http2StreamChannel.pipeline().firstContext();
        kn.l0.o(channelHandlerContextFirstContext, "child.pipeline().firstContext()");
        hVar.y(channelHandlerContextFirstContext, defaultHttp2Headers);
    }

    @j
    public final void A(@l ChannelHandlerContext channelHandlerContext, @l vk.h hVar) throws ExecutionException, IllegalAccessException, InterruptedException, Http2Exception {
        String string;
        kn.l0.p(channelHandlerContext, "context");
        kn.l0.p(hVar, "builder");
        Channel channel = channelHandlerContext.channel();
        if (channel == null) {
            throw new NullPointerException("null cannot be cast to non-null type io.netty.handler.codec.http2.Http2StreamChannel");
        }
        Http2StreamChannel http2StreamChannel = (Http2StreamChannel) channel;
        int iId = http2StreamChannel.stream().id();
        ChannelHandler channelHandler = http2StreamChannel.parent().pipeline().get((Class<ChannelHandler>) Http2MultiplexCodec.class);
        kn.l0.m(channelHandler);
        Http2FrameCodec http2FrameCodec = (Http2MultiplexCodec) channelHandler;
        Http2Connection http2ConnectionConnection = http2FrameCodec.connection();
        if (http2ConnectionConnection.remote().allowPushTo()) {
            ChannelHandlerContext channelHandlerContextLastContext = http2StreamChannel.parent().pipeline().lastContext();
            int iIncrementAndGetNextStreamId = http2ConnectionConnection.local().incrementAndGetNextStreamId();
            final DefaultHttp2Headers defaultHttp2Headers = new DefaultHttp2Headers();
            n1 n1VarA = hVar.a();
            c1 c1Var = n1VarA.f8127g;
            if (c1Var.f6088b.isEmpty()) {
                string = n1VarA.f8126f;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(n1VarA.f8126f);
                sb2.append('?');
                t0.e(c1Var.f(), sb2);
                string = sb2.toString();
                kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
            }
            defaultHttp2Headers.method(hVar.getMethod().f8144a);
            defaultHttp2Headers.authority(hVar.a().f8122b + n1.e.f11184d + hVar.a().f8123c);
            defaultHttp2Headers.scheme(hVar.a().f8121a.f8196a);
            defaultHttp2Headers.path(string);
            final Http2StreamChannel http2StreamChannel2 = new Http2StreamChannelBootstrap(http2StreamChannel.parent()).handler(this).open().get();
            kn.l0.o(http2StreamChannel2, "child");
            p(http2StreamChannel2, iIncrementAndGetNextStreamId);
            ChannelPromise channelPromiseNewPromise = channelHandlerContextLastContext.newPromise();
            Http2Stream http2StreamCreateStream = http2ConnectionConnection.local().createStream(iIncrementAndGetNextStreamId, false);
            Http2FrameStream http2FrameStreamStream = http2StreamChannel2.stream();
            kn.l0.o(http2FrameStreamStream, "child.stream()");
            kn.l0.o(http2StreamCreateStream, "childStream");
            if (!t(http2FrameStreamStream, http2FrameCodec, http2StreamCreateStream)) {
                http2StreamCreateStream.close();
                http2StreamChannel2.close();
                return;
            }
            http2FrameCodec.encoder().frameWriter().writePushPromise(channelHandlerContextLastContext, iId, iIncrementAndGetNextStreamId, defaultHttp2Headers, 0, channelPromiseNewPromise);
            if (!channelPromiseNewPromise.isSuccess()) {
                channelPromiseNewPromise.addListener(new GenericFutureListener() { // from class: dl.g
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public final void operationComplete(Future future) throws ExecutionException, InterruptedException {
                        h.O(this.f3740a, http2StreamChannel2, defaultHttp2Headers, future);
                    }
                });
                return;
            }
            ChannelHandlerContext channelHandlerContextFirstContext = http2StreamChannel2.pipeline().firstContext();
            kn.l0.o(channelHandlerContextFirstContext, "child.pipeline().firstContext()");
            y(channelHandlerContextFirstContext, defaultHttp2Headers);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(@l ChannelHandlerContext channelHandlerContext, @m Object obj) {
        d dVar;
        d dVar2;
        kn.l0.p(channelHandlerContext, "context");
        if (obj instanceof Http2HeadersFrame) {
            Http2Headers http2HeadersHeaders = ((Http2HeadersFrame) obj).headers();
            kn.l0.o(http2HeadersHeaders, "message.headers()");
            y(channelHandlerContext, http2HeadersHeaders);
            return;
        }
        dVar = null;
        d dVar3 = null;
        if (!(obj instanceof Http2DataFrame)) {
            if (!(obj instanceof Http2ResetFrame)) {
                channelHandlerContext.fireChannelRead(obj);
                return;
            }
            dl.c cVarC = f3743g.c(channelHandlerContext);
            if (cVarC == null || (dVar = cVarC.f3727h) == null) {
                return;
            }
            Http2ResetFrame http2ResetFrame = (Http2ResetFrame) obj;
            dVar.f3732y.f(http2ResetFrame.errorCode() != 0 ? new b(http2ResetFrame.errorCode()) : null);
            return;
        }
        dl.c cVarC2 = f3743g.c(channelHandlerContext);
        if (cVarC2 != null && (dVar2 = cVarC2.f3727h) != null) {
            boolean zIsEndStream = ((Http2DataFrame) obj).isEndStream();
            dVar2.f3732y.offer(obj);
            if (zIsEndStream) {
                g0.a.a(dVar2.f3732y, null, 1, null);
            }
            dVar3 = dVar2;
        }
        if (dVar3 == null) {
            ((Http2DataFrame) obj).release();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRegistered(@m ChannelHandlerContext channelHandlerContext) throws Exception {
        ChannelPipeline channelPipelinePipeline;
        super.channelRegistered(channelHandlerContext);
        if (channelHandlerContext == null || (channelPipelinePipeline = channelHandlerContext.pipeline()) == null) {
            return;
        }
        channelPipelinePipeline.addLast(this.f3747c, new al.j(this.f3748d, this.f3745a, dk.j.a(this.f3746b)));
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(@l ChannelHandlerContext channelHandlerContext, @l Throwable th2) {
        kn.l0.p(channelHandlerContext, "ctx");
        kn.l0.p(th2, "cause");
        channelHandlerContext.close();
    }

    @Override // nq.s0
    @l
    public um.g getCoroutineContext() {
        return this.f3749e;
    }

    public final Field k(Class<?> cls) throws NoSuchFieldException {
        Field declaredField;
        do {
            try {
                declaredField = cls.getDeclaredField(dc.d.f3692w);
            } catch (NoSuchFieldException unused) {
                declaredField = null;
            }
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return declaredField;
            }
            cls = cls.getSuperclass();
        } while (cls != null);
        throw new NoSuchFieldException("id field not found");
    }

    public final Field n(Http2FrameStream http2FrameStream) {
        return k(http2FrameStream.getClass());
    }

    public final Field o() {
        return (Field) this.f3750f.getValue();
    }

    public final void p(Http2StreamChannel http2StreamChannel, int i10) throws IllegalAccessException {
        Http2FrameStream http2FrameStreamStream = http2StreamChannel.stream();
        kn.l0.m(http2FrameStreamStream);
        n(http2FrameStreamStream).setInt(http2FrameStreamStream, i10);
    }

    public final boolean t(Http2FrameStream http2FrameStream, Http2FrameCodec http2FrameCodec, Http2Stream http2Stream) {
        Method method;
        Field fieldO = o();
        Method method2 = null;
        Object obj = fieldO == null ? null : fieldO.get(http2FrameCodec);
        Http2Connection.PropertyKey propertyKey = obj instanceof Http2Connection.PropertyKey ? (Http2Connection.PropertyKey) obj : null;
        if (propertyKey == null) {
            return false;
        }
        Method[] declaredMethods = http2FrameStream.getClass().getDeclaredMethods();
        kn.l0.o(declaredMethods, "javaClass.declaredMethods");
        int length = declaredMethods.length;
        int i10 = 0;
        do {
            if (i10 >= length) {
                method = null;
                break;
            }
            method = declaredMethods[i10];
            i10++;
        } while (!kn.l0.g(method.getName(), "setStreamAndProperty"));
        if (method != null) {
            method.setAccessible(true);
            method2 = method;
        }
        if (method2 == null) {
            return false;
        }
        try {
            method2.invoke(http2FrameStream, propertyKey, http2Stream);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void y(ChannelHandlerContext channelHandlerContext, Http2Headers http2Headers) {
        bl.a aVar = new bl.a(1, 1);
        bl.b bVar = new bl.b(channelHandlerContext, bl.e.b.f964a, aVar, this.f3749e);
        dl.c cVar = new dl.c(this.f3746b, channelHandlerContext, http2Headers, this, this.f3749e.plus(k1.g()), this.f3748d);
        f3743g.d(channelHandlerContext, cVar);
        aVar.g(cVar);
        aVar.c();
        bVar.m();
    }
}
