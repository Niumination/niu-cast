package yj;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpClientUpgradeHandler;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http2.Http2ClientUpgradeCodec;
import io.netty.handler.proxy.HttpProxyHandler;
import io.netty.handler.proxy.ProxyConnectionEvent;
import io.netty.handler.ssl.ClientAuth;
import io.netty.handler.ssl.OpenSsl;
import io.netty.handler.ssl.OpenSslEngine;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.ssl.SslHandshakeCompletionEvent;
import io.netty.handler.ssl.SslProvider;
import io.netty.util.AsciiString;
import java.io.ByteArrayInputStream;
import java.net.SocketAddress;
import java.net.URI;
import java.nio.channels.ClosedChannelException;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import vj.a3;
import vj.e3;
import vj.f3;
import vj.h2;
import vj.n2;
import vj.y2;
import wj.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f21309a = Logger.getLogger(z0.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumSet<e3.c> f21310b = EnumSet.of(e3.c.MTLS, e3.c.CUSTOM_MANAGERS);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumSet<f3.d> f21311c = EnumSet.of(f3.d.MTLS, f3.d.CUSTOM_MANAGERS);

    public class a implements y0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SslContext f21312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ z1 f21313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Executor f21314c;

        public a(SslContext sslContext, z1 z1Var, Executor executor) {
            this.f21312a = sslContext;
            this.f21313b = z1Var;
            this.f21314c = executor;
        }

        @Override // yj.y0
        public ChannelHandler a(yj.l lVar) {
            return new v(new s(new i(lVar), this.f21312a, this.f21313b), lVar.k());
        }

        @Override // yj.y0
        public void close() {
            Executor executor;
            z1 z1Var = this.f21313b;
            if (z1Var == null || (executor = this.f21314c) == null) {
                return;
            }
            z1Var.b(executor);
        }

        @Override // yj.y0
        public AsciiString scheme() {
            return i1.f20992e;
        }
    }

    public class b implements y0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y0 f21315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SocketAddress f21316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f21317c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f21318d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AsciiString f21319e;

        public b(y0 y0Var, SocketAddress socketAddress, String str, String str2, AsciiString asciiString) {
            this.f21315a = y0Var;
            this.f21316b = socketAddress;
            this.f21317c = str;
            this.f21318d = str2;
            this.f21319e = asciiString;
        }

        @Override // yj.y0
        public ChannelHandler a(yj.l lVar) {
            return new r(this.f21316b, this.f21317c, this.f21318d, this.f21315a.a(lVar), lVar.k());
        }

        @Override // yj.y0
        public void close() {
            this.f21315a.close();
        }

        @Override // yj.y0
        public AsciiString scheme() {
            return this.f21319e;
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21320a;

        static {
            int[] iArr = new int[f3.c.values().length];
            f21320a = iArr;
            try {
                iArr[f3.c.OPTIONAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21320a[f3.c.REQUIRE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21320a[f3.c.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class d extends q {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final SslContext f21321e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f21322f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f21323g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Executor f21324i;

        public d(ChannelHandler channelHandler, SslContext sslContext, String str, Executor executor, vj.h hVar) {
            super(channelHandler, hVar);
            this.f21321e = (SslContext) c1.h0.F(sslContext, "sslContext");
            j jVarG = z0.g(str);
            this.f21322f = jVarG.f21335a;
            this.f21323g = jVarG.f21336b;
            this.f21324i = executor;
        }

        @Override // yj.z0.q
        public void handlerAdded0(ChannelHandlerContext channelHandlerContext) {
            SSLEngine sSLEngineNewEngine = this.f21321e.newEngine(channelHandlerContext.alloc(), this.f21322f, this.f21323g);
            SSLParameters sSLParameters = sSLEngineNewEngine.getSSLParameters();
            sSLParameters.setEndpointIdentificationAlgorithm("HTTPS");
            sSLEngineNewEngine.setSSLParameters(sSLParameters);
            channelHandlerContext.pipeline().addBefore(channelHandlerContext.name(), null, this.f21324i != null ? new SslHandler(sSLEngineNewEngine, false, this.f21324i) : new SslHandler(sSLEngineNewEngine, false));
        }

        @Override // yj.z0.q
        public void o(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
            if (!(obj instanceof SslHandshakeCompletionEvent)) {
                super.o(channelHandlerContext, obj);
                return;
            }
            SslHandshakeCompletionEvent sslHandshakeCompletionEvent = (SslHandshakeCompletionEvent) obj;
            if (!sslHandshakeCompletionEvent.isSuccess()) {
                Throwable thCause = sslHandshakeCompletionEvent.cause();
                if (thCause instanceof ClosedChannelException) {
                    y2 y2VarT = y2.f17563t.u("Connection closed while performing TLS negotiation").t(thCause);
                    y2VarT.getClass();
                    thCause = new a3(y2VarT);
                }
                channelHandlerContext.fireExceptionCaught(thCause);
                return;
            }
            SslHandler sslHandler = (SslHandler) channelHandlerContext.pipeline().get(SslHandler.class);
            if (this.f21321e.applicationProtocolNegotiator().protocols().contains(sslHandler.applicationProtocol())) {
                z0.f(Level.FINER, channelHandlerContext, "TLS negotiation succeeded.", null);
                p(channelHandlerContext, sslHandler.engine().getSession());
            } else {
                RuntimeException runtimeExceptionT = z0.t("Failed ALPN negotiation: Unable to find compatible protocol");
                z0.f(Level.FINE, channelHandlerContext, "TLS negotiation failed.", runtimeExceptionT);
                channelHandlerContext.fireExceptionCaught((Throwable) runtimeExceptionT);
            }
        }

        public final void p(ChannelHandlerContext channelHandlerContext, SSLSession sSLSession) {
            vj.v0.f fVar = new vj.v0.f(new vj.v0.n(sSLSession));
            x0 x0VarC = c();
            vj.a aVar = x0VarC.f21302a;
            aVar.getClass();
            n(x0VarC.c(new vj.a.b(aVar).d(wj.u0.f19305a, h2.PRIVACY_AND_INTEGRITY).d(vj.n0.f17195c, sSLSession).a()).d(fVar));
            b(channelHandlerContext);
        }
    }

    public static final class e implements y0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SslContext f21325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z1<? extends Executor> f21326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Executor f21327c;

        public e(SslContext sslContext, z1<? extends Executor> z1Var) {
            this.f21325a = (SslContext) c1.h0.F(sslContext, "sslContext");
            this.f21326b = z1Var;
            if (z1Var != null) {
                this.f21327c = z1Var.a();
            }
        }

        @Override // yj.y0
        public ChannelHandler a(yj.l lVar) {
            i iVar = new i(lVar);
            vj.h hVarK = lVar.k();
            return new v(new d(iVar, this.f21325a, lVar.b(), this.f21327c, hVarK), hVarK);
        }

        @Override // yj.y0
        public void close() {
            Executor executor;
            z1<? extends Executor> z1Var = this.f21326b;
            if (z1Var == null || (executor = this.f21327c) == null) {
                return;
            }
            z1Var.b(executor);
        }

        @Override // yj.y0
        public AsciiString scheme() {
            return i1.f20992e;
        }
    }

    public static final class f implements y0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y0 f21328a;

        public f(y0 y0Var) {
            this.f21328a = (y0) c1.h0.F(y0Var, "protocolNegotiator");
        }

        @Override // yj.y0.b
        public y0 a(z1<? extends Executor> z1Var) {
            return this.f21328a;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y0.a f21329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vj.d f21330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f21331c;

        public g(y0.a aVar, vj.d dVar, String str) {
            this.f21329a = aVar;
            this.f21330b = dVar;
            this.f21331c = str;
        }

        public static g a(String str) {
            return new g(null, null, (String) c1.h0.F(str, "error"));
        }

        public static g b(y0.a aVar) {
            return new g((y0.a) c1.h0.F(aVar, "factory"), null, null);
        }

        public g c(vj.d dVar) {
            c1.h0.F(dVar, "callCreds");
            if (this.f21331c != null) {
                return this;
            }
            vj.d dVar2 = this.f21330b;
            if (dVar2 != null) {
                dVar = new vj.q(dVar2, dVar);
            }
            return new g(this.f21329a, dVar, null);
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y0.b f21332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f21333b;

        public h(y0.b bVar, String str) {
            this.f21332a = bVar;
            this.f21333b = str;
        }

        public static h a(String str) {
            return new h(null, (String) c1.h0.F(str, "error"));
        }

        public static h b(y0.b bVar) {
            return new h((y0.b) c1.h0.F(bVar, "factory"), null);
        }
    }

    public static final class i extends ChannelInboundHandlerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final yj.l f21334a;

        public i(yj.l lVar) {
            this.f21334a = (yj.l) c1.h0.F(lVar, ik.y0.b.f8223h);
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
            if (!(obj instanceof x0)) {
                super.userEventTriggered(channelHandlerContext, obj);
                return;
            }
            x0 x0Var = (x0) obj;
            channelHandlerContext.pipeline().replace(channelHandlerContext.name(), (String) null, this.f21334a);
            this.f21334a.o(x0Var.f21302a, x0Var.f21303b);
        }
    }

    @b1.e
    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f21335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21336b;

        public j(String str, int i10) {
            this.f21335a = str;
            this.f21336b = i10;
        }
    }

    public static final class k extends ChannelInboundHandlerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f21337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final yj.l f21338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final vj.h f21339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public x0 f21340d;

        public k(String str, yj.l lVar) {
            this.f21337a = (String) c1.h0.F(str, "authority");
            this.f21338b = (yj.l) c1.h0.F(lVar, ik.y0.b.f8223h);
            this.f21339c = lVar.k();
        }

        @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
        public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
            this.f21339c.a(vj.h.a.INFO, "Http2Upgrade started");
            HttpClientCodec httpClientCodec = new HttpClientCodec();
            channelHandlerContext.pipeline().addBefore(channelHandlerContext.name(), null, httpClientCodec);
            channelHandlerContext.pipeline().addBefore(channelHandlerContext.name(), null, new HttpClientUpgradeHandler(httpClientCodec, new Http2ClientUpgradeCodec(this.f21338b), 1000));
            DefaultHttpRequest defaultHttpRequest = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");
            defaultHttpRequest.headers().add(HttpHeaderNames.HOST, this.f21337a);
            channelHandlerContext.writeAndFlush(defaultHttpRequest).addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
            super.handlerAdded(channelHandlerContext);
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
            if (obj instanceof x0) {
                c1.h0.h0(this.f21340d == null, "negotiation already started");
                this.f21340d = (x0) obj;
                return;
            }
            if (obj != HttpClientUpgradeHandler.UpgradeEvent.UPGRADE_SUCCESSFUL) {
                if (obj == HttpClientUpgradeHandler.UpgradeEvent.UPGRADE_REJECTED) {
                    channelHandlerContext.fireExceptionCaught((Throwable) z0.t("HTTP/2 upgrade rejected"));
                    return;
                } else {
                    super.userEventTriggered(channelHandlerContext, obj);
                    return;
                }
            }
            c1.h0.h0(this.f21340d != null, "negotiation not yet complete");
            this.f21339c.a(vj.h.a.INFO, "Http2Upgrade finished");
            channelHandlerContext.pipeline().remove(channelHandlerContext.name());
            yj.l lVar = this.f21338b;
            x0 x0Var = this.f21340d;
            lVar.o(x0Var.f21302a, x0Var.f21303b);
        }
    }

    public static final class l implements y0 {
        @Override // yj.y0
        public ChannelHandler a(yj.l lVar) {
            return new v(new i(lVar), lVar.k());
        }

        @Override // yj.y0
        public void close() {
        }

        @Override // yj.y0
        public AsciiString scheme() {
            return i1.f20993f;
        }
    }

    @b1.e
    public static final class m implements y0.a {
        @Override // yj.y0.a
        public y0 a() {
            return z0.h();
        }

        @Override // yj.y0.a
        public int b() {
            return 80;
        }
    }

    @b1.e
    public static final class n implements y0.b {
        @Override // yj.y0.b
        public y0 a(z1<? extends Executor> z1Var) {
            return z0.l();
        }
    }

    public static final class o implements y0 {
        @Override // yj.y0
        public ChannelHandler a(yj.l lVar) {
            return new v(new k(lVar.b(), lVar), lVar.k());
        }

        @Override // yj.y0
        public void close() {
        }

        @Override // yj.y0
        public AsciiString scheme() {
            return i1.f20993f;
        }
    }

    public static final class p implements y0.a {
        public p() {
        }

        @Override // yj.y0.a
        public y0 a() {
            return z0.j();
        }

        @Override // yj.y0.a
        public int b() {
            return 80;
        }

        public p(a aVar) {
        }
    }

    public static final class r extends q {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final SocketAddress f21345e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @gm.j
        public final String f21346f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @gm.j
        public final String f21347g;

        public r(SocketAddress socketAddress, @gm.j String str, @gm.j String str2, ChannelHandler channelHandler, vj.h hVar) {
            super(channelHandler, hVar);
            this.f21345e = (SocketAddress) c1.h0.F(socketAddress, "address");
            this.f21346f = str;
            this.f21347g = str2;
        }

        @Override // yj.z0.q
        public void k(ChannelHandlerContext channelHandlerContext) {
            channelHandlerContext.pipeline().addBefore(channelHandlerContext.name(), null, (this.f21346f == null || this.f21347g == null) ? new HttpProxyHandler(this.f21345e) : new HttpProxyHandler(this.f21345e, this.f21346f, this.f21347g));
        }

        @Override // yj.z0.q
        public void o(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
            if (obj instanceof ProxyConnectionEvent) {
                b(channelHandlerContext);
            } else {
                userEventTriggered(channelHandlerContext, obj);
            }
        }
    }

    public static final class s extends ChannelInboundHandlerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Executor f21348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ChannelHandler f21349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SslContext f21350c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public x0 f21351d = x0.f21301c;

        public s(ChannelHandler channelHandler, SslContext sslContext, z1<? extends Executor> z1Var) {
            this.f21350c = (SslContext) c1.h0.F(sslContext, "sslContext");
            this.f21349b = (ChannelHandler) c1.h0.F(channelHandler, ik.y0.b.f8223h);
            if (z1Var != null) {
                this.f21348a = z1Var.a();
            }
        }

        public final void b(ChannelHandlerContext channelHandlerContext, SSLSession sSLSession) {
            vj.v0.f fVar = new vj.v0.f(new vj.v0.n(sSLSession));
            vj.a aVar = this.f21351d.f21302a;
            aVar.getClass();
            channelHandlerContext.fireUserEventTriggered((Object) this.f21351d.c(new vj.a.b(aVar).d(wj.u0.f19305a, h2.PRIVACY_AND_INTEGRITY).d(vj.n0.f17195c, sSLSession).a()).d(fVar));
        }

        @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
        public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
            super.handlerAdded(channelHandlerContext);
            SSLEngine sSLEngineNewEngine = this.f21350c.newEngine(channelHandlerContext.alloc());
            channelHandlerContext.pipeline().addBefore(channelHandlerContext.name(), null, this.f21348a != null ? new SslHandler(sSLEngineNewEngine, false, this.f21348a) : new SslHandler(sSLEngineNewEngine, false));
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
            if (obj instanceof x0) {
                this.f21351d = (x0) obj;
                return;
            }
            if (!(obj instanceof SslHandshakeCompletionEvent)) {
                super.userEventTriggered(channelHandlerContext, obj);
                return;
            }
            SslHandshakeCompletionEvent sslHandshakeCompletionEvent = (SslHandshakeCompletionEvent) obj;
            if (!sslHandshakeCompletionEvent.isSuccess()) {
                z0.f(Level.FINE, channelHandlerContext, "TLS negotiation failed for new client.", null);
                channelHandlerContext.fireExceptionCaught(sslHandshakeCompletionEvent.cause());
                return;
            }
            SslHandler sslHandler = (SslHandler) channelHandlerContext.pipeline().get(SslHandler.class);
            if (this.f21350c.applicationProtocolNegotiator().protocols().contains(sslHandler.applicationProtocol())) {
                channelHandlerContext.pipeline().replace(channelHandlerContext.name(), (String) null, this.f21349b);
                b(channelHandlerContext, sslHandler.engine().getSession());
            } else {
                z0.f(Level.FINE, channelHandlerContext, "TLS negotiation failed for new client.", null);
                channelHandlerContext.fireExceptionCaught((Throwable) z0.t("Failed protocol negotiation: Unable to find compatible protocol"));
            }
        }
    }

    @b1.e
    public static final class t implements y0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SslContext f21352a;

        public t(SslContext sslContext) {
            this.f21352a = (SslContext) c1.h0.F(sslContext, "sslContext");
        }

        @Override // yj.y0.a
        public y0 a() {
            return z0.q(this.f21352a);
        }

        @Override // yj.y0.a
        public int b() {
            return wj.v0.f19368n;
        }
    }

    @b1.e
    public static final class u implements y0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SslContext f21353a;

        public u(SslContext sslContext) {
            this.f21353a = (SslContext) c1.h0.F(sslContext, "sslContext");
        }

        @Override // yj.y0.b
        public y0 a(z1<? extends Executor> z1Var) {
            return z0.o(this.f21353a, z1Var);
        }
    }

    public static final class v extends q {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f21354e;

        public v(ChannelHandler channelHandler, vj.h hVar) {
            super(channelHandler, hVar);
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
            if (this.f21354e) {
                p(channelHandlerContext);
                b(channelHandlerContext);
            }
            super.channelActive(channelHandlerContext);
        }

        @Override // yj.z0.q
        public void k(ChannelHandlerContext channelHandlerContext) {
            this.f21354e = true;
            if (channelHandlerContext.channel().isActive()) {
                p(channelHandlerContext);
                b(channelHandlerContext);
            }
        }

        public final void p(ChannelHandlerContext channelHandlerContext) {
            x0 x0VarC = c();
            vj.a aVar = x0VarC.f21302a;
            aVar.getClass();
            n(x0VarC.c(new vj.a.b(aVar).d(vj.n0.f17194b, channelHandlerContext.channel().localAddress()).d(vj.n0.f17193a, channelHandlerContext.channel().remoteAddress()).d(wj.u0.f19305a, h2.NONE).a()));
        }
    }

    public static y0.b b(y0 y0Var) {
        return new f(y0Var);
    }

    public static g c(vj.g gVar) {
        if (!(gVar instanceof e3)) {
            if (gVar instanceof vj.r0) {
                return g.b(new m());
            }
            if (gVar instanceof vj.r) {
                vj.r rVar = (vj.r) gVar;
                return c(rVar.f17254a).c(rVar.f17255b);
            }
            if (gVar instanceof f0) {
                return g.b(((f0) gVar).f20946a);
            }
            if (!(gVar instanceof vj.i)) {
                return g.a("Unsupported credential type: ".concat(gVar.getClass().getName()));
            }
            StringBuilder sb2 = new StringBuilder();
            Iterator<vj.g> it = ((vj.i) gVar).f17161a.iterator();
            while (it.hasNext()) {
                g gVarC = c(it.next());
                if (gVarC.f21331c == null) {
                    return gVarC;
                }
                sb2.append(", ");
                sb2.append(gVarC.f21331c);
            }
            return g.a(sb2.substring(2));
        }
        e3 e3Var = (e3) gVar;
        Set<e3.c> setI = e3Var.i(f21310b);
        if (!setI.isEmpty()) {
            return g.a("TLS features not understood: " + setI);
        }
        SslContextBuilder sslContextBuilderG = yj.o.g();
        if (e3Var.f17125e != null) {
            sslContextBuilderG.keyManager(new yj.g(e3Var.f17125e));
        } else if (e3Var.e() != null) {
            sslContextBuilderG.keyManager(new ByteArrayInputStream(e3Var.c()), new ByteArrayInputStream(e3Var.e()), e3Var.f17124d);
        }
        if (e3Var.f17127g != null) {
            sslContextBuilderG.trustManager(new yj.h(e3Var.f17127g));
        } else if (e3Var.g() != null) {
            sslContextBuilderG.trustManager(new ByteArrayInputStream(e3Var.g()));
        }
        try {
            return g.b(new t(sslContextBuilderG.build()));
        } catch (SSLException e10) {
            f21309a.log(Level.FINE, "Exception building SslContext", (Throwable) e10);
            return g.a("Unable to create SslContext: " + e10.getMessage());
        }
    }

    public static h d(n2 n2Var) {
        SslContextBuilder sslContextBuilderK;
        if (!(n2Var instanceof f3)) {
            if (n2Var instanceof vj.s0) {
                return h.b(new n());
            }
            if (n2Var instanceof n0) {
                return h.b(((n0) n2Var).f21176a);
            }
            if (!(n2Var instanceof vj.j)) {
                return h.a("Unsupported credential type: ".concat(n2Var.getClass().getName()));
            }
            StringBuilder sb2 = new StringBuilder();
            Iterator<n2> it = ((vj.j) n2Var).f17164a.iterator();
            while (it.hasNext()) {
                h hVarD = d(it.next());
                if (hVarD.f21333b == null) {
                    return hVarD;
                }
                sb2.append(", ");
                sb2.append(hVarD.f21333b);
            }
            return h.a(sb2.substring(2));
        }
        f3 f3Var = (f3) n2Var;
        Set<f3.d> setJ = f3Var.j(f21311c);
        if (!setJ.isEmpty()) {
            return h.a("TLS features not understood: " + setJ);
        }
        if (f3Var.f17142e != null) {
            sslContextBuilderK = yj.o.a(SslContextBuilder.forServer(new yj.g(f3Var.f17142e)));
        } else {
            if (f3Var.f() == null) {
                throw new AssertionError("BUG! No key");
            }
            sslContextBuilderK = yj.o.k(new ByteArrayInputStream(f3Var.c()), new ByteArrayInputStream(f3Var.f()), f3Var.f17141d);
        }
        if (f3Var.f17145h != null) {
            sslContextBuilderK.trustManager(new yj.h(f3Var.f17145h));
        } else if (f3Var.h() != null) {
            sslContextBuilderK.trustManager(new ByteArrayInputStream(f3Var.h()));
        }
        int i10 = c.f21320a[f3Var.f17143f.ordinal()];
        if (i10 == 1) {
            sslContextBuilderK.clientAuth(ClientAuth.OPTIONAL);
        } else if (i10 == 2) {
            sslContextBuilderK.clientAuth(ClientAuth.REQUIRE);
        } else {
            if (i10 != 3) {
                return h.a("Unknown TlsServerCredentials.ClientAuth value: " + f3Var.f17143f);
            }
            sslContextBuilderK.clientAuth(ClientAuth.NONE);
        }
        try {
            return h.b(new u(sslContextBuilderK.build()));
        } catch (SSLException e10) {
            throw new IllegalArgumentException("Unexpected error converting ServerCredentials to Netty SslContext", e10);
        }
    }

    public static y0 e(SocketAddress socketAddress, @gm.j String str, @gm.j String str2, y0 y0Var) {
        c1.h0.F(y0Var, "negotiator");
        c1.h0.F(socketAddress, "proxyAddress");
        return new b(y0Var, socketAddress, str, str2, y0Var.scheme());
    }

    @b1.e
    public static void f(Level level, ChannelHandlerContext channelHandlerContext, String str, @gm.j Throwable th2) {
        Logger logger = f21309a;
        if (logger.isLoggable(level)) {
            SslHandler sslHandler = (SslHandler) channelHandlerContext.pipeline().get(SslHandler.class);
            SSLEngine sSLEngineEngine = sslHandler.engine();
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append("\nSSLEngine Details: [\n");
            if (sSLEngineEngine instanceof OpenSslEngine) {
                sb2.append("    OpenSSL, Version: 0x");
                sb2.append(Integer.toHexString(OpenSsl.version()));
                sb2.append(" (");
                sb2.append(OpenSsl.versionString());
                sb2.append("), ALPN supported: ");
                sb2.append(SslProvider.isAlpnSupported(SslProvider.OPENSSL));
            } else if (b0.e()) {
                sb2.append("    Jetty ALPN");
            } else if (b0.f()) {
                sb2.append("    Jetty NPN");
            } else if (b0.d()) {
                sb2.append("    JDK9 ALPN");
            }
            sb2.append("\n    TLS Protocol: ");
            sb2.append(sSLEngineEngine.getSession().getProtocol());
            sb2.append("\n    Application Protocol: ");
            sb2.append(sslHandler.applicationProtocol());
            sb2.append("\n    Need Client Auth: ");
            sb2.append(sSLEngineEngine.getNeedClientAuth());
            sb2.append("\n    Want Client Auth: ");
            sb2.append(sSLEngineEngine.getWantClientAuth());
            sb2.append("\n    Supported protocols=");
            sb2.append(Arrays.toString(sSLEngineEngine.getSupportedProtocols()));
            sb2.append("\n    Enabled protocols=");
            sb2.append(Arrays.toString(sSLEngineEngine.getEnabledProtocols()));
            sb2.append("\n    Supported ciphers=");
            sb2.append(Arrays.toString(sSLEngineEngine.getSupportedCipherSuites()));
            sb2.append("\n    Enabled ciphers=");
            sb2.append(Arrays.toString(sSLEngineEngine.getEnabledCipherSuites()));
            sb2.append("\n]");
            logger.log(level, sb2.toString(), th2);
        }
    }

    @b1.e
    public static j g(String str) {
        int port;
        URI uriC = wj.v0.c((String) c1.h0.F(str, "authority"));
        if (uriC.getHost() != null) {
            str = uriC.getHost();
            port = uriC.getPort();
        } else {
            port = -1;
        }
        return new j(str, port);
    }

    public static y0 h() {
        return new l();
    }

    public static y0.a i() {
        return new m();
    }

    public static y0 j() {
        return new o();
    }

    public static y0.a k() {
        return new p();
    }

    public static y0 l() {
        return new l();
    }

    public static y0.b m() {
        return new n();
    }

    public static y0 n(SslContext sslContext) {
        return o(sslContext, null);
    }

    public static y0 o(SslContext sslContext, z1<? extends Executor> z1Var) {
        c1.h0.F(sslContext, "sslContext");
        return new a(sslContext, z1Var, z1Var != null ? z1Var.a() : null);
    }

    public static y0.b p(SslContext sslContext) {
        return new u(sslContext);
    }

    public static y0 q(SslContext sslContext) {
        return new e(sslContext, null);
    }

    public static y0 r(SslContext sslContext, z1<? extends Executor> z1Var) {
        return new e(sslContext, z1Var);
    }

    public static y0.a s(SslContext sslContext) {
        return new t(sslContext);
    }

    public static RuntimeException t(String str) {
        y2 y2VarU = y2.f17563t.u(str);
        y2VarU.getClass();
        return new a3(y2VarU);
    }

    public static class q extends ChannelDuplexHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ChannelHandler f21341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f21342b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public x0 f21343c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final vj.h f21344d;

        public q(ChannelHandler channelHandler, String str, vj.h hVar) {
            this.f21341a = (ChannelHandler) c1.h0.F(channelHandler, ik.y0.b.f8223h);
            this.f21342b = str;
            this.f21344d = (vj.h) c1.h0.F(hVar, "negotiationLogger");
        }

        public final void b(ChannelHandlerContext channelHandlerContext) {
            c1.h0.h0(this.f21343c != null, "previous protocol negotiation event hasn't triggered");
            this.f21344d.b(vj.h.a.INFO, "{0} completed", this.f21342b);
            channelHandlerContext.pipeline().replace(channelHandlerContext.name(), (String) null, this.f21341a);
            channelHandlerContext.fireUserEventTriggered((Object) this.f21343c);
        }

        public final x0 c() {
            c1.h0.h0(this.f21343c != null, "previous protocol negotiation event hasn't triggered");
            return this.f21343c;
        }

        @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
        public final void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
            this.f21344d.b(vj.h.a.DEBUG, "{0} started", this.f21342b);
            handlerAdded0(channelHandlerContext);
        }

        @t1.g
        public void handlerAdded0(ChannelHandlerContext channelHandlerContext) throws Exception {
            super.handlerAdded(channelHandlerContext);
        }

        @t1.g
        public void k(ChannelHandlerContext channelHandlerContext) {
        }

        public final void n(x0 x0Var) {
            c1.h0.h0(this.f21343c != null, "previous protocol negotiation event hasn't triggered");
            x0Var.getClass();
            this.f21343c = x0Var;
        }

        public void o(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
            super.userEventTriggered(channelHandlerContext, obj);
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public final void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
            if (!(obj instanceof x0)) {
                o(channelHandlerContext, obj);
                return;
            }
            x0 x0Var = this.f21343c;
            c1.h0.B0(x0Var == null, "pre-existing negotiation: %s < %s", x0Var, obj);
            this.f21343c = (x0) obj;
            k(channelHandlerContext);
        }

        public q(ChannelHandler channelHandler, vj.h hVar) {
            this.f21341a = (ChannelHandler) c1.h0.F(channelHandler, ik.y0.b.f8223h);
            this.f21342b = getClass().getSimpleName().replace("Handler", "");
            this.f21344d = (vj.h) c1.h0.F(hVar, "negotiationLogger");
        }
    }
}
