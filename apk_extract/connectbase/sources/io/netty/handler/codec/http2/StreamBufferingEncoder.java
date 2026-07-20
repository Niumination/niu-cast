package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public class StreamBufferingEncoder extends DecoratingHttp2ConnectionEncoder {
    private boolean closed;
    private GoAwayDetail goAwayDetail;
    private int maxConcurrentStreams;
    private final TreeMap<Integer, PendingStream> pendingStreams;

    public final class DataFrame extends Frame {
        final ByteBuf data;
        final boolean endOfStream;
        final int padding;

        public DataFrame(ByteBuf byteBuf, int i10, boolean z10, ChannelPromise channelPromise) {
            super(channelPromise);
            this.data = byteBuf;
            this.padding = i10;
            this.endOfStream = z10;
        }

        @Override // io.netty.handler.codec.http2.StreamBufferingEncoder.Frame
        public void release(Throwable th2) {
            super.release(th2);
            ReferenceCountUtil.safeRelease(this.data);
        }

        @Override // io.netty.handler.codec.http2.StreamBufferingEncoder.Frame
        public void send(ChannelHandlerContext channelHandlerContext, int i10) {
            StreamBufferingEncoder.this.writeData(channelHandlerContext, i10, this.data, this.padding, this.endOfStream, this.promise);
        }
    }

    public static abstract class Frame {
        final ChannelPromise promise;

        public Frame(ChannelPromise channelPromise) {
            this.promise = channelPromise;
        }

        public void release(Throwable th2) {
            if (th2 == null) {
                this.promise.setSuccess();
            } else {
                this.promise.setFailure(th2);
            }
        }

        public abstract void send(ChannelHandlerContext channelHandlerContext, int i10);
    }

    public static final class GoAwayDetail {
        private final byte[] debugData;
        private final long errorCode;
        private final int lastStreamId;

        public GoAwayDetail(int i10, long j10, byte[] bArr) {
            this.lastStreamId = i10;
            this.errorCode = j10;
            this.debugData = (byte[]) bArr.clone();
        }
    }

    public final class HeadersFrame extends Frame {
        final boolean endOfStream;
        final boolean exclusive;
        final Http2Headers headers;
        final int padding;
        final int streamDependency;
        final short weight;

        public HeadersFrame(Http2Headers http2Headers, int i10, short s10, boolean z10, int i11, boolean z11, ChannelPromise channelPromise) {
            super(channelPromise);
            this.headers = http2Headers;
            this.streamDependency = i10;
            this.weight = s10;
            this.exclusive = z10;
            this.padding = i11;
            this.endOfStream = z11;
        }

        @Override // io.netty.handler.codec.http2.StreamBufferingEncoder.Frame
        public void send(ChannelHandlerContext channelHandlerContext, int i10) {
            StreamBufferingEncoder.this.writeHeaders(channelHandlerContext, i10, this.headers, this.streamDependency, this.weight, this.exclusive, this.padding, this.endOfStream, this.promise);
        }
    }

    public static final class Http2ChannelClosedException extends Http2Exception {
        private static final long serialVersionUID = 4768543442094476971L;

        public Http2ChannelClosedException() {
            super(Http2Error.REFUSED_STREAM, "Connection closed");
        }
    }

    public static final class Http2GoAwayException extends Http2Exception {
        private static final long serialVersionUID = 1326785622777291198L;
        private final GoAwayDetail goAwayDetail;

        public Http2GoAwayException(int i10, long j10, byte[] bArr) {
            this(new GoAwayDetail(i10, j10, bArr));
        }

        public byte[] debugData() {
            return (byte[]) this.goAwayDetail.debugData.clone();
        }

        public long errorCode() {
            return this.goAwayDetail.errorCode;
        }

        public int lastStreamId() {
            return this.goAwayDetail.lastStreamId;
        }

        public Http2GoAwayException(GoAwayDetail goAwayDetail) {
            super(Http2Error.STREAM_CLOSED);
            this.goAwayDetail = goAwayDetail;
        }
    }

    public static final class PendingStream {
        final ChannelHandlerContext ctx;
        final Queue<Frame> frames = new ArrayDeque(2);
        final int streamId;

        public PendingStream(ChannelHandlerContext channelHandlerContext, int i10) {
            this.ctx = channelHandlerContext;
            this.streamId = i10;
        }

        public void close(Throwable th2) {
            Iterator<Frame> it = this.frames.iterator();
            while (it.hasNext()) {
                it.next().release(th2);
            }
        }

        public void sendFrames() {
            Iterator<Frame> it = this.frames.iterator();
            while (it.hasNext()) {
                it.next().send(this.ctx, this.streamId);
            }
        }
    }

    public StreamBufferingEncoder(Http2ConnectionEncoder http2ConnectionEncoder) {
        this(http2ConnectionEncoder, 100);
    }

    private boolean canCreateStream() {
        return connection().local().numActiveStreams() < this.maxConcurrentStreams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelGoAwayStreams(GoAwayDetail goAwayDetail) {
        Iterator<PendingStream> it = this.pendingStreams.values().iterator();
        Http2GoAwayException http2GoAwayException = new Http2GoAwayException(goAwayDetail);
        while (it.hasNext()) {
            PendingStream next = it.next();
            if (next.streamId > goAwayDetail.lastStreamId) {
                it.remove();
                next.close(http2GoAwayException);
            }
        }
    }

    private boolean isExistingStream(int i10) {
        return i10 <= connection().local().lastStreamCreated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryCreatePendingStreams() {
        while (!this.pendingStreams.isEmpty() && canCreateStream()) {
            PendingStream value = this.pendingStreams.pollFirstEntry().getValue();
            try {
                value.sendFrames();
            } catch (Throwable th2) {
                value.close(th2);
            }
        }
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (!this.closed) {
                this.closed = true;
                Http2ChannelClosedException http2ChannelClosedException = new Http2ChannelClosedException();
                while (!this.pendingStreams.isEmpty()) {
                    this.pendingStreams.pollFirstEntry().getValue().close(http2ChannelClosedException);
                }
            }
        } finally {
            super.close();
        }
    }

    public int numBufferedStreams() {
        return this.pendingStreams.size();
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2ConnectionEncoder, io.netty.handler.codec.http2.Http2ConnectionEncoder
    public void remoteSettings(Http2Settings http2Settings) throws Http2Exception {
        super.remoteSettings(http2Settings);
        this.maxConcurrentStreams = connection().local().maxActiveStreams();
        tryCreatePendingStreams();
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2DataWriter
    public ChannelFuture writeData(ChannelHandlerContext channelHandlerContext, int i10, ByteBuf byteBuf, int i11, boolean z10, ChannelPromise channelPromise) {
        if (isExistingStream(i10)) {
            return super.writeData(channelHandlerContext, i10, byteBuf, i11, z10, channelPromise);
        }
        PendingStream pendingStream = this.pendingStreams.get(Integer.valueOf(i10));
        if (pendingStream != null) {
            pendingStream.frames.add(new DataFrame(byteBuf, i11, z10, channelPromise));
        } else {
            ReferenceCountUtil.safeRelease(byteBuf);
            channelPromise.setFailure((Throwable) Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream does not exist %d", Integer.valueOf(i10)));
        }
        return channelPromise;
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, boolean z10, ChannelPromise channelPromise) {
        return writeHeaders(channelHandlerContext, i10, http2Headers, 0, (short) 16, false, i11, z10, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i10, long j10, ChannelPromise channelPromise) {
        if (isExistingStream(i10)) {
            return super.writeRstStream(channelHandlerContext, i10, j10, channelPromise);
        }
        PendingStream pendingStreamRemove = this.pendingStreams.remove(Integer.valueOf(i10));
        if (pendingStreamRemove != null) {
            pendingStreamRemove.close(null);
            channelPromise.setSuccess();
        } else {
            channelPromise.setFailure((Throwable) Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream does not exist %d", Integer.valueOf(i10)));
        }
        return channelPromise;
    }

    public StreamBufferingEncoder(Http2ConnectionEncoder http2ConnectionEncoder, int i10) {
        super(http2ConnectionEncoder);
        this.pendingStreams = new TreeMap<>();
        this.maxConcurrentStreams = i10;
        connection().addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.StreamBufferingEncoder.1
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onGoAwayReceived(int i11, long j10, ByteBuf byteBuf) {
                StreamBufferingEncoder.this.goAwayDetail = new GoAwayDetail(i11, j10, ByteBufUtil.getBytes(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), false));
                StreamBufferingEncoder streamBufferingEncoder = StreamBufferingEncoder.this;
                streamBufferingEncoder.cancelGoAwayStreams(streamBufferingEncoder.goAwayDetail);
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamClosed(Http2Stream http2Stream) {
                StreamBufferingEncoder.this.tryCreatePendingStreams();
            }
        });
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, short s10, boolean z10, int i12, boolean z11, ChannelPromise channelPromise) {
        if (this.closed) {
            return channelPromise.setFailure((Throwable) new Http2ChannelClosedException());
        }
        if (isExistingStream(i10) || canCreateStream()) {
            return super.writeHeaders(channelHandlerContext, i10, http2Headers, i11, s10, z10, i12, z11, channelPromise);
        }
        if (this.goAwayDetail != null) {
            return channelPromise.setFailure((Throwable) new Http2GoAwayException(this.goAwayDetail));
        }
        PendingStream pendingStream = this.pendingStreams.get(Integer.valueOf(i10));
        if (pendingStream == null) {
            pendingStream = new PendingStream(channelHandlerContext, i10);
            this.pendingStreams.put(Integer.valueOf(i10), pendingStream);
        }
        pendingStream.frames.add(new HeadersFrame(http2Headers, i11, s10, z10, i12, z11, channelPromise));
        return channelPromise;
    }
}
