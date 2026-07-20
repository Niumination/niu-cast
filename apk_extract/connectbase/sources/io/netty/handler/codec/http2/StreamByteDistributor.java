package io.netty.handler.codec.http2;

/* JADX INFO: loaded from: classes3.dex */
public interface StreamByteDistributor {

    public interface StreamState {
        boolean hasFrame();

        long pendingBytes();

        Http2Stream stream();

        int windowSize();
    }

    public interface Writer {
        void write(Http2Stream http2Stream, int i10);
    }

    boolean distribute(int i10, Writer writer) throws Http2Exception;

    void updateDependencyTree(int i10, int i11, short s10, boolean z10);

    void updateStreamableBytes(StreamState streamState);
}
