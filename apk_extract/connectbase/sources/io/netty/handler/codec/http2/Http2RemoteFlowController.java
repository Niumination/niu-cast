package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandlerContext;

/* JADX INFO: loaded from: classes3.dex */
public interface Http2RemoteFlowController extends Http2FlowController {

    public interface FlowControlled {
        void error(ChannelHandlerContext channelHandlerContext, Throwable th2);

        boolean merge(ChannelHandlerContext channelHandlerContext, FlowControlled flowControlled);

        int size();

        void write(ChannelHandlerContext channelHandlerContext, int i10);

        void writeComplete();
    }

    public interface Listener {
        void writabilityChanged(Http2Stream http2Stream);
    }

    void addFlowControlled(Http2Stream http2Stream, FlowControlled flowControlled);

    ChannelHandlerContext channelHandlerContext();

    void channelWritabilityChanged() throws Http2Exception;

    boolean hasFlowControlled(Http2Stream http2Stream);

    boolean isWritable(Http2Stream http2Stream);

    void listener(Listener listener);

    void updateDependencyTree(int i10, int i11, short s10, boolean z10);

    void writePendingBytes() throws Http2Exception;
}
