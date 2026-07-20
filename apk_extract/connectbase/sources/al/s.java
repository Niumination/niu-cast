package al;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpServerExpectContinueHandler;
import io.netty.handler.codec.http2.Http2MultiplexCodecBuilder;
import io.netty.handler.codec.http2.Http2SecurityUtil;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.handler.ssl.ApplicationProtocolNames;
import io.netty.handler.ssl.ApplicationProtocolNegotiationHandler;
import io.netty.handler.ssl.OpenSsl;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.SslProvider;
import io.netty.handler.ssl.SupportedCipherSuiteFilter;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.nio.channels.ClosedChannelException;
import java.security.Key;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import kn.l0;
import kn.n0;
import lm.d0;
import lm.f0;
import nm.h0;
import nq.t0;
import yk.a0;
import yk.c0;
import yk.x;

/* JADX INFO: loaded from: classes2.dex */
@yk.v
public final class s extends ChannelInitializer<SocketChannel> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public static final b f388x = new b();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @os.l
    public static final d0<SslProvider> f389y = f0.b(a.INSTANCE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final a0 f390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final yk.b f391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final EventExecutorGroup f392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final um.g f393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final um.g f394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final x f395f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f396g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f397i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f398n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f399p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public final jn.a<HttpServerCodec> f400v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.m
    public SslContext f401w;

    public static final class a extends n0 implements jn.a<SslProvider> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.m
        public final SslProvider invoke() {
            return s.f388x.b();
        }
    }

    @yk.v
    public static final class b {
        public b() {
        }

        public final SslProvider b() {
            try {
                try {
                    Class.forName("sun.security.ssl.ALPNExtension", true, null);
                    return SslProvider.JDK;
                } catch (Throwable unused) {
                    return null;
                }
            } catch (Throwable unused2) {
                if (OpenSsl.isAlpnSupported()) {
                    return SslProvider.OPENSSL;
                }
                return null;
            }
        }

        @os.m
        public final SslProvider c() {
            return (SslProvider) s.f389y.getValue();
        }

        public b(kn.w wVar) {
        }
    }

    public final class c extends ApplicationProtocolNegotiationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f402a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(s sVar) {
            super(ApplicationProtocolNames.HTTP_1_1);
            l0.p(sVar, "this$0");
            this.f402a = sVar;
        }

        @Override // io.netty.handler.ssl.ApplicationProtocolNegotiationHandler
        public void configurePipeline(@os.l ChannelHandlerContext channelHandlerContext, @os.l String str) {
            l0.p(channelHandlerContext, "ctx");
            l0.p(str, "protocol");
            s sVar = this.f402a;
            ChannelPipeline channelPipelinePipeline = channelHandlerContext.pipeline();
            l0.o(channelPipelinePipeline, "ctx.pipeline()");
            sVar.n(channelPipelinePipeline, str);
        }

        @Override // io.netty.handler.ssl.ApplicationProtocolNegotiationHandler
        public void handshakeFailure(@os.l ChannelHandlerContext channelHandlerContext, @os.m Throwable th2) throws Exception {
            l0.p(channelHandlerContext, "ctx");
            if (th2 instanceof ClosedChannelException) {
                channelHandlerContext.close();
            } else {
                super.handshakeFailure(channelHandlerContext, th2);
            }
        }
    }

    public s(@os.l a0 a0Var, @os.l yk.b bVar, @os.l EventExecutorGroup eventExecutorGroup, @os.l um.g gVar, @os.l um.g gVar2, @os.l x xVar, int i10, int i11, int i12, int i13, @os.l jn.a<HttpServerCodec> aVar) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException {
        l0.p(a0Var, "enginePipeline");
        l0.p(bVar, "environment");
        l0.p(eventExecutorGroup, "callEventGroup");
        l0.p(gVar, "engineContext");
        l0.p(gVar2, "userContext");
        l0.p(xVar, "connector");
        l0.p(aVar, "httpServerCodec");
        this.f390a = a0Var;
        this.f391b = bVar;
        this.f392c = eventExecutorGroup;
        this.f393d = gVar;
        this.f394e = gVar2;
        this.f395f = xVar;
        this.f396g = i10;
        this.f397i = i11;
        this.f398n = i12;
        this.f399p = i13;
        this.f400v = aVar;
        if (xVar instanceof c0) {
            Certificate[] certificateChain = ((c0) xVar).e().getCertificateChain(((c0) xVar).c());
            l0.o(certificateChain, "connector.keyStore.getCe…Chain(connector.keyAlias)");
            Object[] array = h0.V5(nm.r.Ky(certificateChain)).toArray(new X509Certificate[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            X509Certificate[] x509CertificateArr = (X509Certificate[]) array;
            char[] cArrInvoke = ((c0) xVar).g().invoke();
            Key key = ((c0) xVar).e().getKey(((c0) xVar).c(), cArrInvoke);
            if (key == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.security.PrivateKey");
            }
            nm.p.Q1(cArrInvoke, (char) 0, 0, 0, 6, null);
            SslContextBuilder sslContextBuilderForServer = SslContextBuilder.forServer((PrivateKey) key, (X509Certificate[]) Arrays.copyOf(x509CertificateArr, x509CertificateArr.length));
            b bVar2 = f388x;
            if (bVar2.c() != null) {
                sslContextBuilderForServer.sslProvider(bVar2.c());
                sslContextBuilderForServer.ciphers(Http2SecurityUtil.CIPHERS, SupportedCipherSuiteFilter.INSTANCE);
                sslContextBuilderForServer.applicationProtocolConfig(new ApplicationProtocolConfig(ApplicationProtocolConfig.Protocol.ALPN, ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE, ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT, "h2", ApplicationProtocolNames.HTTP_1_1));
            }
            this.f401w = sslContextBuilderForServer.build();
        }
    }

    public static final void o(dl.h hVar, Future future) {
        l0.p(hVar, "$handler");
        t0.f(hVar, null, 1, null);
    }

    public final void n(ChannelPipeline channelPipeline, String str) {
        if (l0.g(str, "h2")) {
            final dl.h hVar = new dl.h(this.f390a, this.f391b.a(), this.f392c, this.f394e);
            channelPipeline.addLast(Http2MultiplexCodecBuilder.forServer(hVar).build());
            channelPipeline.channel().closeFuture().addListener(new GenericFutureListener() { // from class: al.r
                @Override // io.netty.util.concurrent.GenericFutureListener
                public final void operationComplete(Future future) {
                    s.o(hVar, future);
                }
            });
        } else {
            if (!l0.g(str, ApplicationProtocolNames.HTTP_1_1)) {
                this.f391b.i().error(l0.C("Unsupported protocol ", str));
                channelPipeline.close();
                return;
            }
            cl.e eVar = new cl.e(this.f390a, this.f391b, this.f392c, this.f393d, this.f394e, new bl.a(this.f396g, this.f397i));
            if (this.f399p > 0) {
                channelPipeline.addLast("readTimeout", new ReadTimeoutHandler(this.f399p));
            }
            channelPipeline.addLast("codec", this.f400v.invoke());
            channelPipeline.addLast("continue", new HttpServerExpectContinueHandler());
            channelPipeline.addLast(RtspHeaders.Values.TIMEOUT, new WriteTimeoutHandler(this.f398n));
            channelPipeline.addLast("http1", eVar);
            channelPipeline.context("codec").fireChannelActive();
        }
    }

    @Override // io.netty.channel.ChannelInitializer
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void initChannel(@os.l SocketChannel socketChannel) {
        l0.p(socketChannel, "ch");
        ChannelPipeline channelPipelinePipeline = socketChannel.pipeline();
        if (!(this.f395f instanceof c0)) {
            l0.o(channelPipelinePipeline, "this");
            n(channelPipelinePipeline, ApplicationProtocolNames.HTTP_1_1);
            return;
        }
        SslContext sslContext = this.f401w;
        l0.m(sslContext);
        channelPipelinePipeline.addLast("ssl", sslContext.newHandler(socketChannel.alloc()));
        if (f388x.c() != null) {
            channelPipelinePipeline.addLast(new c(this));
        } else {
            l0.o(channelPipelinePipeline, "this");
            n(channelPipelinePipeline, ApplicationProtocolNames.HTTP_1_1);
        }
    }
}
