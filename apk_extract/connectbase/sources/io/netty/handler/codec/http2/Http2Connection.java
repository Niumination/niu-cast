package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;

/* JADX INFO: loaded from: classes3.dex */
public interface Http2Connection {

    public interface Endpoint<F extends Http2FlowController> {
        void allowPushTo(boolean z10);

        boolean allowPushTo();

        boolean canOpenStream();

        Http2Stream createStream(int i10, boolean z10) throws Http2Exception;

        boolean created(Http2Stream http2Stream);

        F flowController();

        void flowController(F f10);

        int incrementAndGetNextStreamId();

        boolean isServer();

        boolean isValidStreamId(int i10);

        int lastStreamCreated();

        int lastStreamKnownByPeer();

        int maxActiveStreams();

        void maxActiveStreams(int i10);

        boolean mayHaveCreatedStream(int i10);

        int numActiveStreams();

        Endpoint<? extends Http2FlowController> opposite();

        Http2Stream reservePushStream(int i10, Http2Stream http2Stream) throws Http2Exception;
    }

    public interface Listener {
        void onGoAwayReceived(int i10, long j10, ByteBuf byteBuf);

        void onGoAwaySent(int i10, long j10, ByteBuf byteBuf);

        void onStreamActive(Http2Stream http2Stream);

        void onStreamAdded(Http2Stream http2Stream);

        void onStreamClosed(Http2Stream http2Stream);

        void onStreamHalfClosed(Http2Stream http2Stream);

        void onStreamRemoved(Http2Stream http2Stream);
    }

    public interface PropertyKey {
    }

    void addListener(Listener listener);

    Future<Void> close(Promise<Void> promise);

    Http2Stream connectionStream();

    Http2Stream forEachActiveStream(Http2StreamVisitor http2StreamVisitor) throws Http2Exception;

    void goAwayReceived(int i10, long j10, ByteBuf byteBuf) throws Http2Exception;

    boolean goAwayReceived();

    boolean goAwaySent();

    boolean goAwaySent(int i10, long j10, ByteBuf byteBuf) throws Http2Exception;

    boolean isServer();

    Endpoint<Http2LocalFlowController> local();

    PropertyKey newKey();

    int numActiveStreams();

    Endpoint<Http2RemoteFlowController> remote();

    void removeListener(Listener listener);

    Http2Stream stream(int i10);

    boolean streamMayHaveExisted(int i10);
}
