package cl;

import ik.j0;
import ik.l1;
import ik.p0;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import jq.h0;
import kn.l0;
import kn.n0;
import lm.d0;
import lm.f0;
import os.l;
import wj.h2;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final HttpRequest f1648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final ChannelHandlerContext f1649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final d0 f1650c;

    /* JADX INFO: renamed from: cl.a$a, reason: collision with other inner class name */
    public static final class C0069a extends n0 implements jn.a<String> {
        public C0069a() {
            super(0);
        }

        @Override // jn.a
        @l
        public final String invoke() {
            return a.this.f1649b.pipeline().context("ssl") == null ? "http" : h2.f18719h;
        }
    }

    public a(@l HttpRequest httpRequest, @l ChannelHandlerContext channelHandlerContext) {
        l0.p(httpRequest, "request");
        l0.p(channelHandlerContext, "context");
        this.f1648a = httpRequest;
        this.f1649b = channelHandlerContext;
        this.f1650c = f0.b(new C0069a());
    }

    @Override // ik.l1
    public int a() {
        SocketAddress socketAddressLocalAddress = this.f1649b.channel().localAddress();
        InetSocketAddress inetSocketAddress = socketAddressLocalAddress instanceof InetSocketAddress ? (InetSocketAddress) socketAddressLocalAddress : null;
        if (inetSocketAddress == null) {
            return 80;
        }
        return inetSocketAddress.getPort();
    }

    @Override // ik.l1
    @l
    public String b() {
        HttpHeaders httpHeadersHeaders = this.f1648a.headers();
        j0.f8048a.getClass();
        String str = httpHeadersHeaders.get(j0.F);
        String strV5 = str == null ? null : h0.v5(str, ":", null, 2, null);
        if (strV5 != null) {
            return strV5;
        }
        SocketAddress socketAddressLocalAddress = this.f1649b.channel().localAddress();
        InetSocketAddress inetSocketAddress = socketAddressLocalAddress instanceof InetSocketAddress ? (InetSocketAddress) socketAddressLocalAddress : null;
        if (inetSocketAddress == null) {
            return "localhost";
        }
        String hostName = inetSocketAddress.getHostName();
        if (hostName == null) {
            hostName = inetSocketAddress.getAddress().getHostAddress();
        }
        return hostName == null ? "localhost" : hostName;
    }

    @Override // ik.l1
    @l
    public String c() {
        SocketAddress socketAddressRemoteAddress = this.f1649b.channel().remoteAddress();
        InetSocketAddress inetSocketAddress = socketAddressRemoteAddress instanceof InetSocketAddress ? (InetSocketAddress) socketAddressRemoteAddress : null;
        if (inetSocketAddress == null) {
            return "unknown";
        }
        String hostName = inetSocketAddress.getHostName();
        if (hostName == null) {
            hostName = inetSocketAddress.getAddress().getHostAddress();
        }
        return hostName == null ? "unknown" : hostName;
    }

    @Override // ik.l1
    @l
    public String d() {
        return (String) this.f1650c.getValue();
    }

    @l
    public final ChannelHandlerContext e() {
        return this.f1649b;
    }

    @l
    public final HttpRequest f() {
        return this.f1648a;
    }

    @Override // ik.l1
    @l
    public p0 getMethod() {
        p0.a aVar = p0.f8135b;
        String strName = this.f1648a.method().name();
        l0.o(strName, "request.method().name()");
        return aVar.i(strName);
    }

    @Override // ik.l1
    @l
    public String getUri() {
        String strUri = this.f1648a.uri();
        l0.o(strUri, "request.uri()");
        return strUri;
    }

    @Override // ik.l1
    @l
    public String getVersion() {
        String strText = this.f1648a.protocolVersion().text();
        l0.o(strText, "request.protocolVersion().text()");
        return strText;
    }
}
