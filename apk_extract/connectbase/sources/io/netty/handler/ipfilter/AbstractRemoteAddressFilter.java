package io.netty.handler.ipfilter;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.net.SocketAddress;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractRemoteAddressFilter<T extends SocketAddress> extends ChannelInboundHandlerAdapter {
    private boolean handleNewChannel(ChannelHandlerContext channelHandlerContext) throws Exception {
        SocketAddress socketAddressRemoteAddress = channelHandlerContext.channel().remoteAddress();
        if (socketAddressRemoteAddress == null) {
            return false;
        }
        channelHandlerContext.pipeline().remove(this);
        if (accept(channelHandlerContext, socketAddressRemoteAddress)) {
            channelAccepted(channelHandlerContext, socketAddressRemoteAddress);
            return true;
        }
        ChannelFuture channelFutureChannelRejected = channelRejected(channelHandlerContext, socketAddressRemoteAddress);
        if (channelFutureChannelRejected != null) {
            channelFutureChannelRejected.addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
            return true;
        }
        channelHandlerContext.close();
        return true;
    }

    public abstract boolean accept(ChannelHandlerContext channelHandlerContext, T t10) throws Exception;

    public void channelAccepted(ChannelHandlerContext channelHandlerContext, T t10) {
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (handleNewChannel(channelHandlerContext)) {
            channelHandlerContext.fireChannelActive();
        } else {
            throw new IllegalStateException("cannot determine to accept or reject a channel: " + channelHandlerContext.channel());
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        handleNewChannel(channelHandlerContext);
        channelHandlerContext.fireChannelRegistered();
    }

    public ChannelFuture channelRejected(ChannelHandlerContext channelHandlerContext, T t10) {
        return null;
    }
}
