package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.PlatformDependent;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultHttp2FrameReader implements Http2FrameReader, Http2FrameSizePolicy, Http2FrameReader.Configuration {
    private Http2Flags flags;
    private byte frameType;
    private HeadersContinuation headersContinuation;
    private final Http2HeadersDecoder headersDecoder;
    private int maxFrameSize;
    private int payloadLength;
    private boolean readError;
    private boolean readingHeaders;
    private int streamId;

    public class HeadersBlockBuilder {
        private ByteBuf headerBlock;

        public HeadersBlockBuilder() {
        }

        private void headerSizeExceeded() throws Http2Exception {
            close();
            Http2CodecUtil.headerListSizeExceeded(DefaultHttp2FrameReader.this.headersDecoder.configuration().maxHeaderListSizeGoAway());
        }

        public final void addFragment(ByteBuf byteBuf, int i10, ByteBufAllocator byteBufAllocator, boolean z10) throws Http2Exception {
            if (this.headerBlock == null) {
                if (i10 > DefaultHttp2FrameReader.this.headersDecoder.configuration().maxHeaderListSizeGoAway()) {
                    headerSizeExceeded();
                }
                if (z10) {
                    this.headerBlock = byteBuf.readRetainedSlice(i10);
                    return;
                } else {
                    this.headerBlock = byteBufAllocator.buffer(i10).writeBytes(byteBuf, i10);
                    return;
                }
            }
            if (DefaultHttp2FrameReader.this.headersDecoder.configuration().maxHeaderListSizeGoAway() - ((long) i10) < this.headerBlock.readableBytes()) {
                headerSizeExceeded();
            }
            if (this.headerBlock.isWritable(i10)) {
                this.headerBlock.writeBytes(byteBuf, i10);
                return;
            }
            ByteBuf byteBufBuffer = byteBufAllocator.buffer(this.headerBlock.readableBytes() + i10);
            byteBufBuffer.writeBytes(this.headerBlock).writeBytes(byteBuf, i10);
            this.headerBlock.release();
            this.headerBlock = byteBufBuffer;
        }

        public void close() {
            ByteBuf byteBuf = this.headerBlock;
            if (byteBuf != null) {
                byteBuf.release();
                this.headerBlock = null;
            }
            DefaultHttp2FrameReader.this.headersContinuation = null;
        }

        public Http2Headers headers() throws Http2Exception {
            try {
                return DefaultHttp2FrameReader.this.headersDecoder.decodeHeaders(DefaultHttp2FrameReader.this.streamId, this.headerBlock);
            } finally {
                close();
            }
        }
    }

    public abstract class HeadersContinuation {
        private final HeadersBlockBuilder builder;

        private HeadersContinuation() {
            this.builder = DefaultHttp2FrameReader.this.new HeadersBlockBuilder();
        }

        public final void close() {
            this.builder.close();
        }

        public abstract int getStreamId();

        public final HeadersBlockBuilder headersBlockBuilder() {
            return this.builder;
        }

        public abstract void processFragment(boolean z10, ByteBuf byteBuf, int i10, Http2FrameListener http2FrameListener) throws Http2Exception;
    }

    public DefaultHttp2FrameReader() {
        this(true);
    }

    private void closeHeadersContinuation() {
        HeadersContinuation headersContinuation = this.headersContinuation;
        if (headersContinuation != null) {
            headersContinuation.close();
            this.headersContinuation = null;
        }
    }

    private static int lengthWithoutTrailingPadding(int i10, int i11) {
        return i11 == 0 ? i10 : i10 - (i11 - 1);
    }

    private void processHeaderState(ByteBuf byteBuf) throws Http2Exception {
        if (byteBuf.readableBytes() < 9) {
            return;
        }
        int unsignedMedium = byteBuf.readUnsignedMedium();
        this.payloadLength = unsignedMedium;
        if (unsignedMedium > this.maxFrameSize) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length: %d exceeds maximum: %d", Integer.valueOf(unsignedMedium), Integer.valueOf(this.maxFrameSize));
        }
        this.frameType = byteBuf.readByte();
        this.flags = new Http2Flags(byteBuf.readUnsignedByte());
        this.streamId = Http2CodecUtil.readUnsignedInt(byteBuf);
        this.readingHeaders = false;
        switch (this.frameType) {
            case 0:
                verifyDataFrame();
                return;
            case 1:
                verifyHeadersFrame();
                return;
            case 2:
                verifyPriorityFrame();
                return;
            case 3:
                verifyRstStreamFrame();
                return;
            case 4:
                verifySettingsFrame();
                return;
            case 5:
                verifyPushPromiseFrame();
                return;
            case 6:
                verifyPingFrame();
                return;
            case 7:
                verifyGoAwayFrame();
                return;
            case 8:
                verifyWindowUpdateFrame();
                return;
            case 9:
                verifyContinuationFrame();
                return;
            default:
                verifyUnknownFrame();
                return;
        }
    }

    private void processPayloadState(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        if (byteBuf.readableBytes() < this.payloadLength) {
            return;
        }
        int i10 = byteBuf.readerIndex() + this.payloadLength;
        this.readingHeaders = true;
        switch (this.frameType) {
            case 0:
                readDataFrame(channelHandlerContext, byteBuf, i10, http2FrameListener);
                break;
            case 1:
                readHeadersFrame(channelHandlerContext, byteBuf, i10, http2FrameListener);
                break;
            case 2:
                readPriorityFrame(channelHandlerContext, byteBuf, http2FrameListener);
                break;
            case 3:
                readRstStreamFrame(channelHandlerContext, byteBuf, http2FrameListener);
                break;
            case 4:
                readSettingsFrame(channelHandlerContext, byteBuf, http2FrameListener);
                break;
            case 5:
                readPushPromiseFrame(channelHandlerContext, byteBuf, i10, http2FrameListener);
                break;
            case 6:
                readPingFrame(channelHandlerContext, byteBuf.readLong(), http2FrameListener);
                break;
            case 7:
                readGoAwayFrame(channelHandlerContext, byteBuf, i10, http2FrameListener);
                break;
            case 8:
                readWindowUpdateFrame(channelHandlerContext, byteBuf, http2FrameListener);
                break;
            case 9:
                readContinuationFrame(byteBuf, i10, http2FrameListener);
                break;
            default:
                readUnknownFrame(channelHandlerContext, byteBuf, i10, http2FrameListener);
                break;
        }
        byteBuf.readerIndex(i10);
    }

    private void readContinuationFrame(ByteBuf byteBuf, int i10, Http2FrameListener http2FrameListener) throws Http2Exception {
        this.headersContinuation.processFragment(this.flags.endOfHeaders(), byteBuf, i10 - byteBuf.readerIndex(), http2FrameListener);
        resetHeadersContinuationIfEnd(this.flags.endOfHeaders());
    }

    private void readDataFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i10, Http2FrameListener http2FrameListener) throws Http2Exception {
        int padding = readPadding(byteBuf);
        verifyPadding(padding);
        http2FrameListener.onDataRead(channelHandlerContext, this.streamId, byteBuf.readSlice(lengthWithoutTrailingPadding(i10 - byteBuf.readerIndex(), padding)), padding, this.flags.endOfStream());
    }

    private static void readGoAwayFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i10, Http2FrameListener http2FrameListener) throws Http2Exception {
        http2FrameListener.onGoAwayRead(channelHandlerContext, Http2CodecUtil.readUnsignedInt(byteBuf), byteBuf.readUnsignedInt(), byteBuf.readSlice(i10 - byteBuf.readerIndex()));
    }

    private void readHeadersFrame(final ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i10, Http2FrameListener http2FrameListener) throws Http2Exception {
        final int i11 = this.streamId;
        final Http2Flags http2Flags = this.flags;
        final int padding = readPadding(byteBuf);
        verifyPadding(padding);
        if (!this.flags.priorityPresent()) {
            this.headersContinuation = new HeadersContinuation() { // from class: io.netty.handler.codec.http2.DefaultHttp2FrameReader.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
                public int getStreamId() {
                    return i11;
                }

                @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
                public void processFragment(boolean z10, ByteBuf byteBuf2, int i12, Http2FrameListener http2FrameListener2) throws Http2Exception {
                    HeadersBlockBuilder headersBlockBuilder = headersBlockBuilder();
                    headersBlockBuilder.addFragment(byteBuf2, i12, channelHandlerContext.alloc(), z10);
                    if (z10) {
                        http2FrameListener2.onHeadersRead(channelHandlerContext, i11, headersBlockBuilder.headers(), padding, http2Flags.endOfStream());
                    }
                }
            };
            this.headersContinuation.processFragment(this.flags.endOfHeaders(), byteBuf, lengthWithoutTrailingPadding(i10 - byteBuf.readerIndex(), padding), http2FrameListener);
            resetHeadersContinuationIfEnd(this.flags.endOfHeaders());
            return;
        }
        long unsignedInt = byteBuf.readUnsignedInt();
        final boolean z10 = (2147483648L & unsignedInt) != 0;
        final int i12 = (int) (unsignedInt & 2147483647L);
        int i13 = this.streamId;
        if (i12 == i13) {
            throw Http2Exception.streamError(i13, Http2Error.PROTOCOL_ERROR, "A stream cannot depend on itself.", new Object[0]);
        }
        final short unsignedByte = (short) (byteBuf.readUnsignedByte() + 1);
        int iLengthWithoutTrailingPadding = lengthWithoutTrailingPadding(i10 - byteBuf.readerIndex(), padding);
        HeadersContinuation headersContinuation = new HeadersContinuation() { // from class: io.netty.handler.codec.http2.DefaultHttp2FrameReader.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
            public int getStreamId() {
                return i11;
            }

            @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
            public void processFragment(boolean z11, ByteBuf byteBuf2, int i14, Http2FrameListener http2FrameListener2) throws Http2Exception {
                HeadersBlockBuilder headersBlockBuilder = headersBlockBuilder();
                headersBlockBuilder.addFragment(byteBuf2, i14, channelHandlerContext.alloc(), z11);
                if (z11) {
                    http2FrameListener2.onHeadersRead(channelHandlerContext, i11, headersBlockBuilder.headers(), i12, unsignedByte, z10, padding, http2Flags.endOfStream());
                }
            }
        };
        this.headersContinuation = headersContinuation;
        headersContinuation.processFragment(this.flags.endOfHeaders(), byteBuf, iLengthWithoutTrailingPadding, http2FrameListener);
        resetHeadersContinuationIfEnd(this.flags.endOfHeaders());
    }

    private int readPadding(ByteBuf byteBuf) {
        if (this.flags.paddingPresent()) {
            return byteBuf.readUnsignedByte() + 1;
        }
        return 0;
    }

    private void readPingFrame(ChannelHandlerContext channelHandlerContext, long j10, Http2FrameListener http2FrameListener) throws Http2Exception {
        if (this.flags.ack()) {
            http2FrameListener.onPingAckRead(channelHandlerContext, j10);
        } else {
            http2FrameListener.onPingRead(channelHandlerContext, j10);
        }
    }

    private void readPriorityFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        long unsignedInt = byteBuf.readUnsignedInt();
        boolean z10 = (2147483648L & unsignedInt) != 0;
        int i10 = (int) (unsignedInt & 2147483647L);
        int i11 = this.streamId;
        if (i10 == i11) {
            throw Http2Exception.streamError(i11, Http2Error.PROTOCOL_ERROR, "A stream cannot depend on itself.", new Object[0]);
        }
        http2FrameListener.onPriorityRead(channelHandlerContext, this.streamId, i10, (short) (byteBuf.readUnsignedByte() + 1), z10);
    }

    private void readPushPromiseFrame(final ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i10, Http2FrameListener http2FrameListener) throws Http2Exception {
        final int i11 = this.streamId;
        final int padding = readPadding(byteBuf);
        verifyPadding(padding);
        final int unsignedInt = Http2CodecUtil.readUnsignedInt(byteBuf);
        this.headersContinuation = new HeadersContinuation() { // from class: io.netty.handler.codec.http2.DefaultHttp2FrameReader.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
            public int getStreamId() {
                return i11;
            }

            @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
            public void processFragment(boolean z10, ByteBuf byteBuf2, int i12, Http2FrameListener http2FrameListener2) throws Http2Exception {
                headersBlockBuilder().addFragment(byteBuf2, i12, channelHandlerContext.alloc(), z10);
                if (z10) {
                    http2FrameListener2.onPushPromiseRead(channelHandlerContext, i11, unsignedInt, headersBlockBuilder().headers(), padding);
                }
            }
        };
        this.headersContinuation.processFragment(this.flags.endOfHeaders(), byteBuf, lengthWithoutTrailingPadding(i10 - byteBuf.readerIndex(), padding), http2FrameListener);
        resetHeadersContinuationIfEnd(this.flags.endOfHeaders());
    }

    private void readRstStreamFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        http2FrameListener.onRstStreamRead(channelHandlerContext, this.streamId, byteBuf.readUnsignedInt());
    }

    private void readSettingsFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        if (this.flags.ack()) {
            http2FrameListener.onSettingsAckRead(channelHandlerContext);
            return;
        }
        int i10 = this.payloadLength / 6;
        Http2Settings http2Settings = new Http2Settings();
        for (int i11 = 0; i11 < i10; i11++) {
            char unsignedShort = (char) byteBuf.readUnsignedShort();
            try {
                http2Settings.put(unsignedShort, Long.valueOf(byteBuf.readUnsignedInt()));
            } catch (IllegalArgumentException e10) {
                if (unsignedShort != 4) {
                    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, e10, "Protocol error: %s", e10.getMessage());
                }
                throw Http2Exception.connectionError(Http2Error.FLOW_CONTROL_ERROR, e10, "Failed setting initial window size: %s", e10.getMessage());
            }
        }
        http2FrameListener.onSettingsRead(channelHandlerContext, http2Settings);
    }

    private void readUnknownFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i10, Http2FrameListener http2FrameListener) throws Http2Exception {
        http2FrameListener.onUnknownFrame(channelHandlerContext, this.frameType, this.streamId, this.flags, byteBuf.readSlice(i10 - byteBuf.readerIndex()));
    }

    private void readWindowUpdateFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        int unsignedInt = Http2CodecUtil.readUnsignedInt(byteBuf);
        if (unsignedInt != 0) {
            http2FrameListener.onWindowUpdateRead(channelHandlerContext, this.streamId, unsignedInt);
        } else {
            int i10 = this.streamId;
            throw Http2Exception.streamError(i10, Http2Error.PROTOCOL_ERROR, "Received WINDOW_UPDATE with delta 0 for stream: %d", Integer.valueOf(i10));
        }
    }

    private void resetHeadersContinuationIfEnd(boolean z10) {
        if (z10) {
            closeHeadersContinuation();
        }
    }

    private void verifyAssociatedWithAStream() throws Http2Exception {
        if (this.streamId == 0) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Frame of type %s must be associated with a stream.", Byte.valueOf(this.frameType));
        }
    }

    private void verifyContinuationFrame() throws Http2Exception {
        verifyAssociatedWithAStream();
        HeadersContinuation headersContinuation = this.headersContinuation;
        if (headersContinuation == null) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Received %s frame but not currently processing headers.", Byte.valueOf(this.frameType));
        }
        if (this.streamId != headersContinuation.getStreamId()) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Continuation stream ID does not match pending headers. Expected %d, but received %d.", Integer.valueOf(this.headersContinuation.getStreamId()), Integer.valueOf(this.streamId));
        }
        if (this.payloadLength < this.flags.getPaddingPresenceFieldLength()) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small for padding.", Integer.valueOf(this.payloadLength));
        }
    }

    private void verifyDataFrame() throws Http2Exception {
        verifyAssociatedWithAStream();
        verifyNotProcessingHeaders();
        if (this.payloadLength < this.flags.getPaddingPresenceFieldLength()) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small.", Integer.valueOf(this.payloadLength));
        }
    }

    private void verifyGoAwayFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        if (this.streamId != 0) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A stream ID must be zero.", new Object[0]);
        }
        int i10 = this.payloadLength;
        if (i10 < 8) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small.", Integer.valueOf(i10));
        }
    }

    private void verifyHeadersFrame() throws Http2Exception {
        verifyAssociatedWithAStream();
        verifyNotProcessingHeaders();
        if (this.payloadLength >= this.flags.getNumPriorityBytes() + this.flags.getPaddingPresenceFieldLength()) {
            return;
        }
        throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length too small." + this.payloadLength, new Object[0]);
    }

    private void verifyNotProcessingHeaders() throws Http2Exception {
        if (this.headersContinuation != null) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Received frame of type %s while processing headers on stream %d.", Byte.valueOf(this.frameType), Integer.valueOf(this.headersContinuation.getStreamId()));
        }
    }

    private void verifyPadding(int i10) throws Http2Exception {
        if (lengthWithoutTrailingPadding(this.payloadLength, i10) < 0) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Frame payload too small for padding.", new Object[0]);
        }
    }

    private void verifyPingFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        if (this.streamId != 0) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A stream ID must be zero.", new Object[0]);
        }
        int i10 = this.payloadLength;
        if (i10 != 8) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length %d incorrect size for ping.", Integer.valueOf(i10));
        }
    }

    private void verifyPriorityFrame() throws Http2Exception {
        verifyAssociatedWithAStream();
        verifyNotProcessingHeaders();
        int i10 = this.payloadLength;
        if (i10 != 5) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Invalid frame length %d.", Integer.valueOf(i10));
        }
    }

    private void verifyPushPromiseFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        int paddingPresenceFieldLength = this.flags.getPaddingPresenceFieldLength() + 4;
        int i10 = this.payloadLength;
        if (i10 < paddingPresenceFieldLength) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small.", Integer.valueOf(i10));
        }
    }

    private void verifyRstStreamFrame() throws Http2Exception {
        verifyAssociatedWithAStream();
        verifyNotProcessingHeaders();
        int i10 = this.payloadLength;
        if (i10 != 4) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Invalid frame length %d.", Integer.valueOf(i10));
        }
    }

    private void verifySettingsFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        if (this.streamId != 0) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A stream ID must be zero.", new Object[0]);
        }
        if (this.flags.ack() && this.payloadLength > 0) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Ack settings frame must have an empty payload.", new Object[0]);
        }
        int i10 = this.payloadLength;
        if (i10 % 6 > 0) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length %d invalid.", Integer.valueOf(i10));
        }
    }

    private static void verifyStreamOrConnectionId(int i10, String str) throws Http2Exception {
        if (i10 < 0) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "%s must be >= 0", str);
        }
    }

    private void verifyUnknownFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
    }

    private void verifyWindowUpdateFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        verifyStreamOrConnectionId(this.streamId, "Stream ID");
        int i10 = this.payloadLength;
        if (i10 != 4) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Invalid frame length %d.", Integer.valueOf(i10));
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        closeHeadersContinuation();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader
    public Http2FrameReader.Configuration configuration() {
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader.Configuration
    public Http2FrameSizePolicy frameSizePolicy() {
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader.Configuration
    public Http2HeadersDecoder.Configuration headersConfiguration() {
        return this.headersDecoder.configuration();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameSizePolicy
    public void maxFrameSize(int i10) throws Http2Exception {
        if (!Http2CodecUtil.isMaxFrameSizeValid(i10)) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Invalid MAX_FRAME_SIZE specified in sent settings: %d", Integer.valueOf(i10));
        }
        this.maxFrameSize = i10;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader
    public void readFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Throwable {
        if (this.readError) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        do {
            try {
                if (this.readingHeaders) {
                    processHeaderState(byteBuf);
                    if (this.readingHeaders) {
                        return;
                    }
                }
                processPayloadState(channelHandlerContext, byteBuf, http2FrameListener);
                if (!this.readingHeaders) {
                    return;
                }
            } catch (Http2Exception e10) {
                this.readError = !Http2Exception.isStreamError(e10);
                throw e10;
            } catch (RuntimeException e11) {
                this.readError = true;
                throw e11;
            } catch (Throwable th2) {
                this.readError = true;
                PlatformDependent.throwException(th2);
                return;
            }
        } while (byteBuf.isReadable());
    }

    public DefaultHttp2FrameReader(boolean z10) {
        this(new DefaultHttp2HeadersDecoder(z10));
    }

    public DefaultHttp2FrameReader(Http2HeadersDecoder http2HeadersDecoder) {
        this.readingHeaders = true;
        this.headersDecoder = http2HeadersDecoder;
        this.maxFrameSize = 16384;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameSizePolicy
    public int maxFrameSize() {
        return this.maxFrameSize;
    }
}
