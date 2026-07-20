package dl;

import al.n;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import ik.b0;
import ik.c0;
import ik.l1;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.multipart.HttpPostMultipartRequestDecoder;
import io.netty.handler.codec.http2.Http2DataFrame;
import io.netty.handler.codec.http2.Http2Headers;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Map;
import jn.p;
import kn.l0;
import kn.n0;
import kn.w;
import lm.d0;
import lm.d1;
import lm.f0;
import lm.l2;
import nq.k1;
import os.l;
import os.m;
import pq.g0;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends n {

    @l
    public final uk.h H;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @l
    public final Http2Headers f3729v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @l
    public final pl.c f3730w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @l
    public final d0 f3731x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @l
    public final g0<Http2DataFrame> f3732y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @l
    public final dl.a f3733z;

    @xm.f(c = "io.ktor.server.netty.http2.NettyHttp2ApplicationRequest$contentActor$1", f = "NettyHttp2ApplicationRequest.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends o implements p<pq.c<Http2DataFrame>, um.d<? super l2>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public a(um.d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            a aVar = d.this.new a(dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                pq.c cVar = (pq.c) this.L$0;
                pl.c cVar2 = d.this.f3730w;
                this.label = 1;
                if (dl.b.a(cVar, cVar2, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l pq.c<Http2DataFrame> cVar, @m um.d<? super l2> dVar) {
            return ((a) create(cVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public static final class b extends n0 implements jn.a<b0> {
        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @l
        public final b0 invoke() {
            b0.a aVar = b0.f7939b;
            d dVar = d.this;
            c0 c0Var = new c0(0, 1, null);
            for (Map.Entry entry : dVar.f3729v) {
                l0.o(entry, "(name, value)");
                CharSequence charSequence = (CharSequence) entry.getKey();
                CharSequence charSequence2 = (CharSequence) entry.getValue();
                l0.o(charSequence, "name");
                if (charSequence.length() > 0 && charSequence.charAt(0) != ':') {
                    c0Var.a(charSequence.toString(), charSequence2.toString());
                }
            }
            return c0Var.f();
        }
    }

    public /* synthetic */ d(dk.b bVar, um.g gVar, ChannelHandlerContext channelHandlerContext, Http2Headers http2Headers, pl.c cVar, int i10, w wVar) {
        this(bVar, gVar, channelHandlerContext, http2Headers, (i10 & 16) != 0 ? pl.e.c(false, 1, null) : cVar);
    }

    public static /* synthetic */ void s() {
    }

    @Override // uk.d
    @l
    public b0 b() {
        return (b0) this.f3731x.getValue();
    }

    @Override // al.n, uk.d
    @l
    public uk.h e() {
        return this.H;
    }

    @Override // uk.d
    public l1 g() {
        return this.f3733z;
    }

    @Override // al.n
    @l
    public HttpPostMultipartRequestDecoder p() {
        DefaultHttpHeaders defaultHttpHeaders = new DefaultHttpHeaders(false);
        for (Map.Entry<CharSequence, CharSequence> entry : this.f3729v) {
            l0.o(entry, "nettyHeaders");
            defaultHttpHeaders.add(entry.getKey(), entry.getValue());
        }
        return new HttpPostMultipartRequestDecoder(new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, this.f369f, defaultHttpHeaders));
    }

    @l
    public final g0<Http2DataFrame> r() {
        return this.f3732y;
    }

    @l
    public final pl.c t() {
        return this.f3730w;
    }

    @l
    public dl.a u() {
        return this.f3733z;
    }

    @l
    public final Http2Headers v() {
        return this.f3729v;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public d(@l dk.b bVar, @l um.g gVar, @l ChannelHandlerContext channelHandlerContext, @l Http2Headers http2Headers, @l pl.c cVar) {
        String string;
        l0.p(bVar, NotificationCompat.CATEGORY_CALL);
        l0.p(gVar, "coroutineContext");
        l0.p(channelHandlerContext, "context");
        l0.p(http2Headers, "nettyHeaders");
        l0.p(cVar, "contentByteChannel");
        CharSequence charSequence = http2Headers.get(":path");
        super(bVar, gVar, channelHandlerContext, cVar, (charSequence == null || (string = charSequence.toString()) == null) ? "/" : string, true);
        this.f3729v = http2Headers;
        this.f3730w = cVar;
        this.f3731x = f0.b(new b());
        this.f3732y = pq.b.b(this, k1.g(), Integer.MAX_VALUE, null, null, new a(null), 12, null);
        SocketAddress socketAddressLocalAddress = channelHandlerContext.channel().localAddress();
        InetSocketAddress inetSocketAddress = socketAddressLocalAddress instanceof InetSocketAddress ? (InetSocketAddress) socketAddressLocalAddress : null;
        SocketAddress socketAddressRemoteAddress = channelHandlerContext.channel().remoteAddress();
        this.f3733z = new dl.a(http2Headers, inetSocketAddress, socketAddressRemoteAddress instanceof InetSocketAddress ? (InetSocketAddress) socketAddressRemoteAddress : null);
        this.H = new al.o(this);
    }
}
