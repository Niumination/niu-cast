package io.netty.handler.codec.http2;

import com.transsion.hubsdk.api.provider.TranSearchIndexablesProvider;
import h.a;
import h0.b;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.collection.CharObjectMap;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultHttp2FrameWriter implements Http2FrameWriter, Http2FrameSizePolicy, Http2FrameWriter.Configuration {
    private static final String STREAM_DEPENDENCY = "Stream Dependency";
    private static final String STREAM_ID = "Stream ID";
    private static final ByteBuf ZERO_BUFFER = Unpooled.unreleasableBuffer(Unpooled.directBuffer(255).writeZero(255)).asReadOnly();
    private final Http2HeadersEncoder headersEncoder;
    private int maxFrameSize;

    public DefaultHttp2FrameWriter() {
        this(new DefaultHttp2HeadersEncoder());
    }

    private static int paddingBytes(int i10) {
        return i10 - 1;
    }

    private static void verifyErrorCode(long j10) {
        if (j10 < 0 || j10 > 4294967295L) {
            throw new IllegalArgumentException(b.a("Invalid errorCode: ", j10));
        }
    }

    private static void verifyStreamId(int i10, String str) {
        ObjectUtil.checkPositive(i10, str);
    }

    private static void verifyStreamOrConnectionId(int i10, String str) {
        ObjectUtil.checkPositiveOrZero(i10, str);
    }

    private static void verifyWeight(short s10) {
        if (s10 < 1 || s10 > 256) {
            throw new IllegalArgumentException(a.a("Invalid weight: ", s10));
        }
    }

    private static void verifyWindowSizeIncrement(int i10) {
        ObjectUtil.checkPositiveOrZero(i10, "windowSizeIncrement");
    }

    private ChannelFuture writeContinuationFrames(ChannelHandlerContext channelHandlerContext, int i10, ByteBuf byteBuf, Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator) {
        Http2Flags http2Flags = new Http2Flags();
        if (byteBuf.isReadable()) {
            int iMin = Math.min(byteBuf.readableBytes(), this.maxFrameSize);
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(10);
            Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, iMin, (byte) 9, http2Flags, i10);
            do {
                int iMin2 = Math.min(byteBuf.readableBytes(), this.maxFrameSize);
                ByteBuf retainedSlice = byteBuf.readRetainedSlice(iMin2);
                if (byteBuf.isReadable()) {
                    channelHandlerContext.write(byteBufBuffer.retain(), simpleChannelPromiseAggregator.newPromise());
                } else {
                    http2Flags = http2Flags.endOfHeaders(true);
                    byteBufBuffer.release();
                    byteBufBuffer = channelHandlerContext.alloc().buffer(10);
                    Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, iMin2, (byte) 9, http2Flags, i10);
                    channelHandlerContext.write(byteBufBuffer, simpleChannelPromiseAggregator.newPromise());
                }
                channelHandlerContext.write(retainedSlice, simpleChannelPromiseAggregator.newPromise());
            } while (byteBuf.isReadable());
        }
        return simpleChannelPromiseAggregator;
    }

    private ChannelFuture writeHeadersInternal(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, boolean z10, boolean z11, int i12, short s10, boolean z12, ChannelPromise channelPromise) {
        int i13 = i12;
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        ByteBuf byteBufBuffer = null;
        try {
            try {
                try {
                    verifyStreamId(i10, STREAM_ID);
                    if (z11) {
                        verifyStreamOrConnectionId(i13, STREAM_DEPENDENCY);
                        Http2CodecUtil.verifyPadding(i11);
                        verifyWeight(s10);
                    }
                    byteBufBuffer = channelHandlerContext.alloc().buffer();
                    this.headersEncoder.encodeHeaders(i10, http2Headers, byteBufBuffer);
                    Http2Flags http2FlagsPaddingPresent = new Http2Flags().endOfStream(z10).priorityPresent(z11).paddingPresent(i11 > 0);
                    int numPriorityBytes = http2FlagsPaddingPresent.getNumPriorityBytes() + i11;
                    ByteBuf retainedSlice = byteBufBuffer.readRetainedSlice(Math.min(byteBufBuffer.readableBytes(), this.maxFrameSize - numPriorityBytes));
                    http2FlagsPaddingPresent.endOfHeaders(!byteBufBuffer.isReadable());
                    int i14 = retainedSlice.readableBytes() + numPriorityBytes;
                    ByteBuf byteBufBuffer2 = channelHandlerContext.alloc().buffer(15);
                    Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer2, i14, (byte) 1, http2FlagsPaddingPresent, i10);
                    writePaddingLength(byteBufBuffer2, i11);
                    if (z11) {
                        if (z12) {
                            i13 = (int) (((long) i13) | 2147483648L);
                        }
                        byteBufBuffer2.writeInt(i13);
                        byteBufBuffer2.writeByte(s10 - 1);
                    }
                    channelHandlerContext.write(byteBufBuffer2, simpleChannelPromiseAggregator.newPromise());
                    channelHandlerContext.write(retainedSlice, simpleChannelPromiseAggregator.newPromise());
                    if (paddingBytes(i11) > 0) {
                        channelHandlerContext.write(ZERO_BUFFER.slice(0, paddingBytes(i11)), simpleChannelPromiseAggregator.newPromise());
                    }
                    if (!http2FlagsPaddingPresent.endOfHeaders()) {
                        writeContinuationFrames(channelHandlerContext, i10, byteBufBuffer, simpleChannelPromiseAggregator);
                    }
                } catch (Http2Exception e10) {
                    simpleChannelPromiseAggregator.setFailure((Throwable) e10);
                    if (byteBufBuffer != null) {
                    }
                    return simpleChannelPromiseAggregator.doneAllocatingPromises();
                }
            } catch (Throwable th2) {
                simpleChannelPromiseAggregator.setFailure(th2);
                simpleChannelPromiseAggregator.doneAllocatingPromises();
                PlatformDependent.throwException(th2);
                if (byteBufBuffer != null) {
                }
                return simpleChannelPromiseAggregator.doneAllocatingPromises();
            }
            byteBufBuffer.release();
            return simpleChannelPromiseAggregator.doneAllocatingPromises();
        } catch (Throwable th3) {
            if (byteBufBuffer != null) {
                byteBufBuffer.release();
            }
            throw th3;
        }
    }

    private static void writePaddingLength(ByteBuf byteBuf, int i10) {
        if (i10 > 0) {
            byteBuf.writeByte(i10 - 1);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public Http2FrameWriter.Configuration configuration() {
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter.Configuration
    public Http2FrameSizePolicy frameSizePolicy() {
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter.Configuration
    public Http2HeadersEncoder.Configuration headersConfiguration() {
        return this.headersEncoder.configuration();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameSizePolicy
    public void maxFrameSize(int i10) throws Http2Exception {
        if (!Http2CodecUtil.isMaxFrameSizeValid(i10)) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Invalid MAX_FRAME_SIZE specified in sent settings: %d", Integer.valueOf(i10));
        }
        this.maxFrameSize = i10;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0108  */
    /* JADX WARN: Code duplicated, block: B:48:0x010e  */
    /* JADX WARN: Code duplicated, block: B:49:0x010f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0124 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x0126 A[Catch: all -> 0x0138, TRY_LEAVE, TryCatch #5 {all -> 0x0138, blocks: (B:40:0x00e1, B:46:0x0109, B:50:0x0110, B:53:0x0126, B:60:0x013c, B:61:0x0147, B:63:0x014d), top: B:86:0x00e1 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x013c A[Catch: all -> 0x0138, TRY_ENTER, TryCatch #5 {all -> 0x0138, blocks: (B:40:0x00e1, B:46:0x0109, B:50:0x0110, B:53:0x0126, B:60:0x013c, B:61:0x0147, B:63:0x014d), top: B:86:0x00e1 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x014d A[Catch: all -> 0x0138, TRY_LEAVE, TryCatch #5 {all -> 0x0138, blocks: (B:40:0x00e1, B:46:0x0109, B:50:0x0110, B:53:0x0126, B:60:0x013c, B:61:0x0147, B:63:0x014d), top: B:86:0x00e1 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0169  */
    /* JADX WARN: Code duplicated, block: B:78:0x016e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // io.netty.handler.codec.http2.Http2DataWriter
    public ChannelFuture writeData(ChannelHandlerContext channelHandlerContext, int i10, ByteBuf byteBuf, int i11, boolean z10, ChannelPromise channelPromise) {
        Throwable th2;
        ByteBuf byteBuf2;
        ByteBuf byteBufBuffer;
        ByteBuf byteBufSlice;
        ByteBuf byteBuf3;
        int i12;
        int i13;
        int iMin;
        boolean z11;
        int iMin2;
        boolean z12;
        int i14;
        ByteBuf slice = byteBuf;
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        try {
            verifyStreamId(i10, STREAM_ID);
            Http2CodecUtil.verifyPadding(i11);
            int i15 = byteBuf.readableBytes();
            Http2Flags http2Flags = new Http2Flags();
            http2Flags.endOfStream(false);
            http2Flags.paddingPresent(false);
            if (i15 > this.maxFrameSize) {
                byteBufBuffer = channelHandlerContext.alloc().buffer(9);
                try {
                    Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, this.maxFrameSize, (byte) 0, http2Flags, i10);
                    do {
                        channelHandlerContext.write(byteBufBuffer.retainedSlice(), simpleChannelPromiseAggregator.newPromise());
                        channelHandlerContext.write(slice.readRetainedSlice(this.maxFrameSize), simpleChannelPromiseAggregator.newPromise());
                        i14 = this.maxFrameSize;
                        i15 -= i14;
                    } while (i15 > i14);
                } catch (Throwable th3) {
                    th2 = th3;
                    byteBuf2 = byteBufBuffer;
                    if (byteBuf2 != null) {
                        byteBuf2.release();
                    }
                    if (slice != null) {
                        try {
                            slice.release();
                        } finally {
                            simpleChannelPromiseAggregator.setFailure(th2);
                            simpleChannelPromiseAggregator.doneAllocatingPromises();
                        }
                    }
                    return simpleChannelPromiseAggregator;
                }
            } else {
                byteBufBuffer = null;
            }
            try {
                if (i11 == 0) {
                    if (byteBufBuffer != null) {
                        byteBufBuffer.release();
                    }
                    ByteBuf byteBufBuffer2 = channelHandlerContext.alloc().buffer(9);
                    http2Flags.endOfStream(z10);
                    Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer2, i15, (byte) 0, http2Flags, i10);
                    channelHandlerContext.write(byteBufBuffer2, simpleChannelPromiseAggregator.newPromise());
                    channelHandlerContext.write(slice.readSlice(i15), simpleChannelPromiseAggregator.newPromise());
                } else {
                    int i16 = this.maxFrameSize;
                    if (i15 != i16) {
                        if (byteBufBuffer != null) {
                            byteBufBuffer.release();
                            i12 = i15;
                            byteBuf3 = null;
                        } else {
                            byteBuf3 = byteBufBuffer;
                        }
                        i13 = i11;
                        while (true) {
                            try {
                                iMin = Math.min(i12, this.maxFrameSize);
                                z11 = true;
                                iMin2 = Math.min(i13, Math.max(0, (this.maxFrameSize - 1) - iMin));
                                i13 -= iMin2;
                                i12 -= iMin;
                                ByteBuf byteBufBuffer3 = channelHandlerContext.alloc().buffer(10);
                                if (!z10 && i12 == 0 && i13 == 0) {
                                    z12 = true;
                                } else {
                                    z12 = false;
                                }
                                http2Flags.endOfStream(z12);
                                if (iMin2 > 0) {
                                    z11 = false;
                                }
                                http2Flags.paddingPresent(z11);
                                Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer3, iMin2 + iMin, (byte) 0, http2Flags, i10);
                                writePaddingLength(byteBufBuffer3, iMin2);
                                channelHandlerContext.write(byteBufBuffer3, simpleChannelPromiseAggregator.newPromise());
                                if (slice != null) {
                                    if (i12 == 0) {
                                        try {
                                            channelHandlerContext.write(slice.readSlice(iMin), simpleChannelPromiseAggregator.newPromise());
                                            slice = null;
                                        } catch (Throwable th4) {
                                            th2 = th4;
                                            byteBuf2 = byteBuf3;
                                            slice = null;
                                            if (byteBuf2 != null) {
                                                byteBuf2.release();
                                            }
                                            if (slice != null) {
                                                slice.release();
                                            }
                                            return simpleChannelPromiseAggregator;
                                        }
                                    } else {
                                        channelHandlerContext.write(slice.readRetainedSlice(iMin), simpleChannelPromiseAggregator.newPromise());
                                    }
                                }
                                if (paddingBytes(iMin2) > 0) {
                                    channelHandlerContext.write(ZERO_BUFFER.slice(0, paddingBytes(iMin2)), simpleChannelPromiseAggregator.newPromise());
                                }
                                if (i12 != 0 && i13 == 0) {
                                    break;
                                }
                            } catch (Throwable th5) {
                                th2 = th5;
                                byteBuf2 = byteBuf3;
                                if (byteBuf2 != null) {
                                    byteBuf2.release();
                                }
                                if (slice != null) {
                                    slice.release();
                                }
                                return simpleChannelPromiseAggregator;
                            }
                        }
                    } else {
                        i15 -= i16;
                        if (byteBufBuffer == null) {
                            byteBufSlice = channelHandlerContext.alloc().buffer(9);
                            Http2CodecUtil.writeFrameHeaderInternal(byteBufSlice, this.maxFrameSize, (byte) 0, http2Flags, i10);
                        } else {
                            byteBufSlice = byteBufBuffer.slice();
                            byteBufBuffer = null;
                        }
                        channelHandlerContext.write(byteBufSlice, simpleChannelPromiseAggregator.newPromise());
                        int i17 = byteBuf.readableBytes();
                        int i18 = this.maxFrameSize;
                        if (i17 != i18) {
                            slice = slice.readSlice(i18);
                        }
                        channelHandlerContext.write(slice, simpleChannelPromiseAggregator.newPromise());
                        byteBuf3 = byteBufBuffer;
                        slice = null;
                    }
                    i12 = i15;
                    i13 = i11;
                    while (true) {
                        iMin = Math.min(i12, this.maxFrameSize);
                        z11 = true;
                        iMin2 = Math.min(i13, Math.max(0, (this.maxFrameSize - 1) - iMin));
                        i13 -= iMin2;
                        i12 -= iMin;
                        ByteBuf byteBufBuffer4 = channelHandlerContext.alloc().buffer(10);
                        if (!z10) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        http2Flags.endOfStream(z12);
                        if (iMin2 > 0) {
                            z11 = false;
                        }
                        http2Flags.paddingPresent(z11);
                        Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer4, iMin2 + iMin, (byte) 0, http2Flags, i10);
                        writePaddingLength(byteBufBuffer4, iMin2);
                        channelHandlerContext.write(byteBufBuffer4, simpleChannelPromiseAggregator.newPromise());
                        if (slice != null) {
                            if (i12 == 0) {
                                channelHandlerContext.write(slice.readSlice(iMin), simpleChannelPromiseAggregator.newPromise());
                                slice = null;
                            } else {
                                channelHandlerContext.write(slice.readRetainedSlice(iMin), simpleChannelPromiseAggregator.newPromise());
                            }
                        }
                        if (paddingBytes(iMin2) > 0) {
                            channelHandlerContext.write(ZERO_BUFFER.slice(0, paddingBytes(iMin2)), simpleChannelPromiseAggregator.newPromise());
                        }
                        if (i12 != 0) {
                        }
                    }
                }
                return simpleChannelPromiseAggregator.doneAllocatingPromises();
            } catch (Throwable th6) {
                th2 = th6;
                byteBuf2 = byteBufBuffer;
            }
        } catch (Throwable th7) {
            th2 = th7;
            byteBuf2 = null;
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeFrame(ChannelHandlerContext channelHandlerContext, byte b10, int i10, Http2Flags http2Flags, ByteBuf byteBuf, ChannelPromise channelPromise) {
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        try {
            verifyStreamOrConnectionId(i10, STREAM_ID);
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(9);
            Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, byteBuf.readableBytes(), b10, http2Flags, i10);
            channelHandlerContext.write(byteBufBuffer, simpleChannelPromiseAggregator.newPromise());
            try {
                channelHandlerContext.write(byteBuf, simpleChannelPromiseAggregator.newPromise());
            } catch (Throwable th2) {
                simpleChannelPromiseAggregator.setFailure(th2);
            }
            return simpleChannelPromiseAggregator.doneAllocatingPromises();
        } catch (Throwable th3) {
            try {
                byteBuf.release();
                return simpleChannelPromiseAggregator;
            } finally {
                simpleChannelPromiseAggregator.setFailure(th3);
                simpleChannelPromiseAggregator.doneAllocatingPromises();
            }
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeGoAway(ChannelHandlerContext channelHandlerContext, int i10, long j10, ByteBuf byteBuf, ChannelPromise channelPromise) {
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        try {
            verifyStreamOrConnectionId(i10, "Last Stream ID");
            verifyErrorCode(j10);
            int i11 = byteBuf.readableBytes() + 8;
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(17);
            Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, i11, (byte) 7, new Http2Flags(), 0);
            byteBufBuffer.writeInt(i10);
            byteBufBuffer.writeInt((int) j10);
            channelHandlerContext.write(byteBufBuffer, simpleChannelPromiseAggregator.newPromise());
            try {
                channelHandlerContext.write(byteBuf, simpleChannelPromiseAggregator.newPromise());
            } catch (Throwable th2) {
                simpleChannelPromiseAggregator.setFailure(th2);
            }
            return simpleChannelPromiseAggregator.doneAllocatingPromises();
        } catch (Throwable th3) {
            try {
                byteBuf.release();
                return simpleChannelPromiseAggregator;
            } finally {
                simpleChannelPromiseAggregator.setFailure(th3);
                simpleChannelPromiseAggregator.doneAllocatingPromises();
            }
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, boolean z10, ChannelPromise channelPromise) {
        return writeHeadersInternal(channelHandlerContext, i10, http2Headers, i11, z10, false, 0, (short) 0, false, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePing(ChannelHandlerContext channelHandlerContext, boolean z10, long j10, ChannelPromise channelPromise) {
        Http2Flags http2FlagsAck;
        if (z10) {
            http2FlagsAck = new Http2Flags();
            http2FlagsAck = http2FlagsAck.ack(true);
        } else {
            http2FlagsAck = new Http2Flags();
        }
        ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(17);
        Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, 8, (byte) 6, http2FlagsAck, 0);
        byteBufBuffer.writeLong(j10);
        return channelHandlerContext.write(byteBufBuffer, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePriority(ChannelHandlerContext channelHandlerContext, int i10, int i11, short s10, boolean z10, ChannelPromise channelPromise) {
        try {
            verifyStreamId(i10, STREAM_ID);
            verifyStreamOrConnectionId(i11, STREAM_DEPENDENCY);
            verifyWeight(s10);
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(14);
            Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, 5, (byte) 2, new Http2Flags(), i10);
            if (z10) {
                i11 = (int) (((long) i11) | 2147483648L);
            }
            byteBufBuffer.writeInt(i11);
            byteBufBuffer.writeByte(s10 - 1);
            return channelHandlerContext.write(byteBufBuffer, channelPromise);
        } catch (Throwable th2) {
            return channelPromise.setFailure(th2);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePushPromise(ChannelHandlerContext channelHandlerContext, int i10, int i11, Http2Headers http2Headers, int i12, ChannelPromise channelPromise) {
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        ByteBuf byteBufBuffer = null;
        try {
            try {
                verifyStreamId(i10, STREAM_ID);
                verifyStreamId(i11, "Promised Stream ID");
                Http2CodecUtil.verifyPadding(i12);
                byteBufBuffer = channelHandlerContext.alloc().buffer();
                this.headersEncoder.encodeHeaders(i10, http2Headers, byteBufBuffer);
                Http2Flags http2FlagsPaddingPresent = new Http2Flags().paddingPresent(i12 > 0);
                int i13 = i12 + 4;
                ByteBuf retainedSlice = byteBufBuffer.readRetainedSlice(Math.min(byteBufBuffer.readableBytes(), this.maxFrameSize - i13));
                http2FlagsPaddingPresent.endOfHeaders(true ^ byteBufBuffer.isReadable());
                int i14 = retainedSlice.readableBytes() + i13;
                ByteBuf byteBufBuffer2 = channelHandlerContext.alloc().buffer(14);
                Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer2, i14, (byte) 5, http2FlagsPaddingPresent, i10);
                writePaddingLength(byteBufBuffer2, i12);
                byteBufBuffer2.writeInt(i11);
                channelHandlerContext.write(byteBufBuffer2, simpleChannelPromiseAggregator.newPromise());
                channelHandlerContext.write(retainedSlice, simpleChannelPromiseAggregator.newPromise());
                if (paddingBytes(i12) > 0) {
                    channelHandlerContext.write(ZERO_BUFFER.slice(0, paddingBytes(i12)), simpleChannelPromiseAggregator.newPromise());
                }
                if (!http2FlagsPaddingPresent.endOfHeaders()) {
                    writeContinuationFrames(channelHandlerContext, i10, byteBufBuffer, simpleChannelPromiseAggregator);
                }
            } catch (Throwable th2) {
                if (byteBufBuffer != null) {
                    byteBufBuffer.release();
                }
                throw th2;
            }
        } catch (Http2Exception e10) {
            simpleChannelPromiseAggregator.setFailure((Throwable) e10);
            if (byteBufBuffer != null) {
            }
            return simpleChannelPromiseAggregator.doneAllocatingPromises();
        } catch (Throwable th3) {
            simpleChannelPromiseAggregator.setFailure(th3);
            simpleChannelPromiseAggregator.doneAllocatingPromises();
            PlatformDependent.throwException(th3);
            if (byteBufBuffer != null) {
            }
            return simpleChannelPromiseAggregator.doneAllocatingPromises();
        }
        byteBufBuffer.release();
        return simpleChannelPromiseAggregator.doneAllocatingPromises();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i10, long j10, ChannelPromise channelPromise) {
        try {
            verifyStreamId(i10, STREAM_ID);
            verifyErrorCode(j10);
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(13);
            Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, 4, (byte) 3, new Http2Flags(), i10);
            byteBufBuffer.writeInt((int) j10);
            return channelHandlerContext.write(byteBufBuffer, channelPromise);
        } catch (Throwable th2) {
            return channelPromise.setFailure(th2);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettings(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings, ChannelPromise channelPromise) {
        try {
            ObjectUtil.checkNotNull(http2Settings, TranSearchIndexablesProvider.f2243v);
            int size = http2Settings.size() * 6;
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(size + 9);
            Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, size, (byte) 4, new Http2Flags(), 0);
            for (CharObjectMap.PrimitiveEntry<Long> primitiveEntry : http2Settings.entries()) {
                byteBufBuffer.writeChar(primitiveEntry.key());
                byteBufBuffer.writeInt(primitiveEntry.value().intValue());
            }
            return channelHandlerContext.write(byteBufBuffer, channelPromise);
        } catch (Throwable th2) {
            return channelPromise.setFailure(th2);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettingsAck(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        try {
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(9);
            Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, 0, (byte) 4, new Http2Flags().ack(true), 0);
            return channelHandlerContext.write(byteBufBuffer, channelPromise);
        } catch (Throwable th2) {
            return channelPromise.setFailure(th2);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeWindowUpdate(ChannelHandlerContext channelHandlerContext, int i10, int i11, ChannelPromise channelPromise) {
        try {
            verifyStreamOrConnectionId(i10, STREAM_ID);
            verifyWindowSizeIncrement(i11);
            ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer(13);
            Http2CodecUtil.writeFrameHeaderInternal(byteBufBuffer, 4, (byte) 8, new Http2Flags(), i10);
            byteBufBuffer.writeInt(i11);
            return channelHandlerContext.write(byteBufBuffer, channelPromise);
        } catch (Throwable th2) {
            return channelPromise.setFailure(th2);
        }
    }

    public DefaultHttp2FrameWriter(Http2HeadersEncoder.SensitivityDetector sensitivityDetector) {
        this(new DefaultHttp2HeadersEncoder(sensitivityDetector));
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, short s10, boolean z10, int i12, boolean z11, ChannelPromise channelPromise) {
        return writeHeadersInternal(channelHandlerContext, i10, http2Headers, i12, z11, true, i11, s10, z10, channelPromise);
    }

    public DefaultHttp2FrameWriter(Http2HeadersEncoder.SensitivityDetector sensitivityDetector, boolean z10) {
        this(new DefaultHttp2HeadersEncoder(sensitivityDetector, z10));
    }

    public DefaultHttp2FrameWriter(Http2HeadersEncoder http2HeadersEncoder) {
        this.headersEncoder = http2HeadersEncoder;
        this.maxFrameSize = 16384;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameSizePolicy
    public int maxFrameSize() {
        return this.maxFrameSize;
    }
}
