package cl;

import al.j;
import androidx.core.app.NotificationCompat;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.concurrent.EventExecutorGroup;
import java.io.IOException;
import kn.l0;
import nq.l2;
import nq.s0;
import nq.y;
import os.l;
import pl.k;
import um.g;
import yk.a0;

/* JADX INFO: loaded from: classes2.dex */
@ChannelHandler.Sharable
public final class e extends ChannelInboundHandlerAdapter implements s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final a0 f1661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final yk.b f1662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final EventExecutorGroup f1663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final g f1664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public final g f1665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public final bl.a f1666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public final y f1667g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1668i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1669n;

    public e(@l a0 a0Var, @l yk.b bVar, @l EventExecutorGroup eventExecutorGroup, @l g gVar, @l g gVar2, @l bl.a aVar) {
        l0.p(a0Var, "enginePipeline");
        l0.p(bVar, "environment");
        l0.p(eventExecutorGroup, "callEventGroup");
        l0.p(gVar, "engineContext");
        l0.p(gVar2, "userContext");
        l0.p(aVar, "requestQueue");
        this.f1661a = a0Var;
        this.f1662b = bVar;
        this.f1663c = eventExecutorGroup;
        this.f1664d = gVar;
        this.f1665e = gVar2;
        this.f1666f = aVar;
        this.f1667g = nq.a0.c(null, 1, null);
    }

    public final k b(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest) {
        if (!(httpRequest instanceof HttpContent)) {
            return ((bl.d) channelHandlerContext.pipeline().get(bl.d.class)).e0();
        }
        bl.d dVar = (bl.d) channelHandlerContext.pipeline().get(bl.d.class);
        k kVarE0 = dVar.e0();
        dVar.channelRead(channelHandlerContext, httpRequest);
        return kVarE0;
    }

    public final void c(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest) {
        k kVarB;
        channelHandlerContext.channel().config().setAutoRead(false);
        if ((httpRequest instanceof LastHttpContent) && !((LastHttpContent) httpRequest).content().isReadable()) {
            kVarB = k.f13204a.a();
        } else if (httpRequest.method() != HttpMethod.GET || HttpUtil.isContentLengthSet(httpRequest) || HttpUtil.isTransferEncodingChunked(httpRequest)) {
            kVarB = b(channelHandlerContext, httpRequest);
        } else {
            this.f1669n = true;
            kVarB = k.f13204a.a();
        }
        this.f1666f.g(new b(this.f1662b.a(), channelHandlerContext, httpRequest, kVarB, this.f1664d, this.f1665e));
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(@l ChannelHandlerContext channelHandlerContext) throws Exception {
        l0.p(channelHandlerContext, "ctx");
        if (!this.f1668i) {
            this.f1668i = true;
            bl.d dVar = new bl.d(channelHandlerContext, this.f1666f);
            bl.b bVar = new bl.b(channelHandlerContext, bl.e.a.f963a, this.f1666f, this.f1667g);
            ChannelPipeline channelPipelinePipeline = channelHandlerContext.pipeline();
            channelPipelinePipeline.addLast(dVar);
            channelPipelinePipeline.addLast(this.f1663c, new j(this.f1665e, this.f1661a, this.f1662b.i()));
            bVar.m();
        }
        super.channelActive(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(@l ChannelHandlerContext channelHandlerContext) throws Exception {
        l0.p(channelHandlerContext, "ctx");
        if (this.f1668i) {
            this.f1668i = false;
            channelHandlerContext.pipeline().remove(j.class);
            this.f1666f.b();
        }
        super.channelInactive(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(@l ChannelHandlerContext channelHandlerContext, @l Object obj) {
        l0.p(channelHandlerContext, "ctx");
        l0.p(obj, NotificationCompat.CATEGORY_MESSAGE);
        if (obj instanceof HttpRequest) {
            c(channelHandlerContext, (HttpRequest) obj);
            return;
        }
        if (obj instanceof LastHttpContent) {
            LastHttpContent lastHttpContent = (LastHttpContent) obj;
            if (!lastHttpContent.content().isReadable() && this.f1669n) {
                this.f1669n = false;
                lastHttpContent.release();
                return;
            }
        }
        channelHandlerContext.fireChannelRead(obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(@l ChannelHandlerContext channelHandlerContext, @l Throwable th2) {
        l0.p(channelHandlerContext, "ctx");
        l0.p(th2, "cause");
        if ((th2 instanceof IOException) || (th2 instanceof gl.c)) {
            dk.j.a(this.f1662b.a()).debug("I/O operation failed", th2);
            l2.a.b(this.f1667g, null, 1, null);
        } else {
            this.f1667g.k(th2);
        }
        this.f1666f.b();
        channelHandlerContext.close();
    }

    @Override // nq.s0
    @l
    public g getCoroutineContext() {
        return this.f1667g;
    }
}
