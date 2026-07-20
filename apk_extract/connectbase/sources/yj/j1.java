package yj;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.net.SocketAddress;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import vj.a3;
import vj.y2;

/* JADX INFO: loaded from: classes2.dex */
public final class j1 extends ChannelDuplexHandler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f21057f = Logger.getLogger(j1.class.getName());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ boolean f21058g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue<c> f21059a = new ArrayDeque();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChannelHandler f21060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f21061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f21062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Throwable f21063e;

    public final class a implements ChannelFutureListener {
        public a() {
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void operationComplete(ChannelFuture channelFuture) {
            if (channelFuture.isSuccess()) {
                return;
            }
            j1.this.k(channelFuture.cause());
        }
    }

    public final class b implements ChannelFutureListener {
        public b() {
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void operationComplete(ChannelFuture channelFuture) {
            if (channelFuture.isSuccess()) {
                return;
            }
            j1.f21057f.log(Level.FINE, "Failed closing channel", channelFuture.cause());
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f21066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ChannelPromise f21067b;

        public c(Object obj, ChannelPromise channelPromise) {
            this.f21066a = obj;
            this.f21067b = channelPromise;
        }
    }

    public j1(ChannelHandler channelHandler) {
        this.f21060b = (ChannelHandler) c1.h0.F(channelHandler, ik.y0.b.f8223h);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        y2 y2VarU = y2.f17563t.u("Connection closed while performing protocol negotiation for " + channelHandlerContext.pipeline().names());
        y2VarU.getClass();
        k(new a3(y2VarU));
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        try {
            Logger logger = f21057f;
            Level level = Level.FINE;
            if (logger.isLoggable(level)) {
                logger.log(level, "Unexpected channelRead()->{0} reached end of pipeline {1}", new Object[]{obj instanceof ByteBuf ? ByteBufUtil.hexDump((ByteBuf) obj) : obj, channelHandlerContext.pipeline().names()});
            }
            y2 y2VarU = y2.f17562s.u("channelRead() missed by ProtocolNegotiator handler: " + obj);
            y2VarU.getClass();
            exceptionCaught(channelHandlerContext, new a3(y2VarU));
        } finally {
            ReferenceCountUtil.safeRelease(obj);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        y2 y2VarU = y2.f17563t.u("Connection closing while performing protocol negotiation for " + channelHandlerContext.pipeline().names());
        y2VarU.getClass();
        k(new a3(y2VarU));
        super.close(channelHandlerContext, channelPromise);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        super.connect(channelHandlerContext, socketAddress, socketAddress2, channelPromise);
        channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new a());
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th2) {
        Throwable th3 = this.f21063e;
        y2 y2VarG = i1.w(th2).g("Channel Pipeline: " + channelHandlerContext.pipeline().names());
        y2VarG.getClass();
        k(new a3(y2VarG));
        if (channelHandlerContext.channel().isActive() && th3 == null) {
            channelHandlerContext.close().addListener((GenericFutureListener<? extends Future<? super Void>>) new b());
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) {
        this.f21062d = true;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.pipeline().addBefore(channelHandlerContext.name(), null, this.f21060b);
        super.handlerAdded(channelHandlerContext);
        channelHandlerContext.pipeline().fireUserEventTriggered((Object) x0.f21301c);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!this.f21059a.isEmpty()) {
            y2 y2VarU = y2.f17562s.u("Buffer removed before draining writes");
            y2VarU.getClass();
            k(new a3(y2VarU));
        }
        super.handlerRemoved(channelHandlerContext);
    }

    public final void k(Throwable th2) {
        if (this.f21063e == null) {
            this.f21063e = th2;
        } else {
            f21057f.log(Level.FINE, "Ignoring duplicate failure", th2);
        }
        while (!this.f21059a.isEmpty()) {
            c cVarPoll = this.f21059a.poll();
            cVarPoll.f21067b.setFailure(th2);
            ReferenceCountUtil.release(cVarPoll.f21066a);
        }
    }

    public final void n(ChannelHandlerContext channelHandlerContext) {
        if (!channelHandlerContext.channel().isActive() || this.f21061c) {
            return;
        }
        this.f21061c = true;
        while (!this.f21059a.isEmpty()) {
            c cVarPoll = this.f21059a.poll();
            channelHandlerContext.write(cVarPoll.f21066a, cVarPoll.f21067b);
        }
        if (this.f21062d) {
            channelHandlerContext.flush();
        }
        channelHandlerContext.pipeline().remove(this);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        Throwable th2 = this.f21063e;
        if (th2 != null) {
            channelPromise.setFailure(th2);
            ReferenceCountUtil.release(obj);
        } else {
            if ((obj instanceof j) || (obj instanceof i)) {
                channelHandlerContext.close();
            }
            this.f21059a.add(new c(obj, channelPromise));
        }
    }
}
