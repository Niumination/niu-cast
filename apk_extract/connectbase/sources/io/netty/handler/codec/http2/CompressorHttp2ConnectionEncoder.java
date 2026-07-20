package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.compression.Brotli;
import io.netty.handler.codec.compression.BrotliEncoder;
import io.netty.handler.codec.compression.BrotliOptions;
import io.netty.handler.codec.compression.CompressionOptions;
import io.netty.handler.codec.compression.DeflateOptions;
import io.netty.handler.codec.compression.GzipOptions;
import io.netty.handler.codec.compression.SnappyFrameEncoder;
import io.netty.handler.codec.compression.SnappyOptions;
import io.netty.handler.codec.compression.StandardCompressionOptions;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;
import io.netty.handler.codec.compression.ZstdEncoder;
import io.netty.handler.codec.compression.ZstdOptions;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.util.AsciiString;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.PromiseCombiner;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes3.dex */
public class CompressorHttp2ConnectionEncoder extends DecoratingHttp2ConnectionEncoder {
    public static final int DEFAULT_COMPRESSION_LEVEL = 6;
    public static final int DEFAULT_MEM_LEVEL = 8;
    public static final int DEFAULT_WINDOW_BITS = 15;
    private BrotliOptions brotliOptions;
    private int compressionLevel;
    private DeflateOptions deflateOptions;
    private GzipOptions gzipCompressionOptions;
    private int memLevel;
    private final Http2Connection.PropertyKey propertyKey;
    private SnappyOptions snappyOptions;
    private final boolean supportsCompressionOptions;
    private int windowBits;
    private ZstdOptions zstdOptions;

    public CompressorHttp2ConnectionEncoder(Http2ConnectionEncoder http2ConnectionEncoder) {
        this(http2ConnectionEncoder, defaultCompressionOptions());
    }

    private void bindCompressorToStream(EmbeddedChannel embeddedChannel, int i10) {
        Http2Stream http2StreamStream;
        if (embeddedChannel == null || (http2StreamStream = connection().stream(i10)) == null) {
            return;
        }
        http2StreamStream.setProperty(this.propertyKey, embeddedChannel);
    }

    private static CompressionOptions[] defaultCompressionOptions() {
        return Brotli.isAvailable() ? new CompressionOptions[]{StandardCompressionOptions.brotli(), StandardCompressionOptions.snappy(), StandardCompressionOptions.gzip(), StandardCompressionOptions.deflate()} : new CompressionOptions[]{StandardCompressionOptions.snappy(), StandardCompressionOptions.gzip(), StandardCompressionOptions.deflate()};
    }

    private EmbeddedChannel newCompressionChannel(ChannelHandlerContext channelHandlerContext, ZlibWrapper zlibWrapper) {
        if (!this.supportsCompressionOptions) {
            return new EmbeddedChannel(channelHandlerContext.channel().id(), channelHandlerContext.channel().metadata().hasDisconnect(), channelHandlerContext.channel().config(), ZlibCodecFactory.newZlibEncoder(zlibWrapper, this.compressionLevel, this.windowBits, this.memLevel));
        }
        if (zlibWrapper == ZlibWrapper.GZIP && this.gzipCompressionOptions != null) {
            return new EmbeddedChannel(channelHandlerContext.channel().id(), channelHandlerContext.channel().metadata().hasDisconnect(), channelHandlerContext.channel().config(), ZlibCodecFactory.newZlibEncoder(zlibWrapper, this.gzipCompressionOptions.compressionLevel(), this.gzipCompressionOptions.windowBits(), this.gzipCompressionOptions.memLevel()));
        }
        if (zlibWrapper == ZlibWrapper.ZLIB && this.deflateOptions != null) {
            return new EmbeddedChannel(channelHandlerContext.channel().id(), channelHandlerContext.channel().metadata().hasDisconnect(), channelHandlerContext.channel().config(), ZlibCodecFactory.newZlibEncoder(zlibWrapper, this.deflateOptions.compressionLevel(), this.deflateOptions.windowBits(), this.deflateOptions.memLevel()));
        }
        throw new IllegalArgumentException("Unsupported ZlibWrapper: " + zlibWrapper);
    }

    private EmbeddedChannel newCompressor(ChannelHandlerContext channelHandlerContext, Http2Headers http2Headers, boolean z10) throws Http2Exception {
        if (z10) {
            return null;
        }
        AsciiString asciiString = HttpHeaderNames.CONTENT_ENCODING;
        CharSequence charSequence = http2Headers.get(asciiString);
        if (charSequence == null) {
            charSequence = HttpHeaderValues.IDENTITY;
        }
        EmbeddedChannel embeddedChannelNewContentCompressor = newContentCompressor(channelHandlerContext, charSequence);
        if (embeddedChannelNewContentCompressor != null) {
            CharSequence targetContentEncoding = getTargetContentEncoding(charSequence);
            if (HttpHeaderValues.IDENTITY.contentEqualsIgnoreCase(targetContentEncoding)) {
                http2Headers.remove(asciiString);
            } else {
                http2Headers.set(asciiString, targetContentEncoding);
            }
            http2Headers.remove(HttpHeaderNames.CONTENT_LENGTH);
        }
        return embeddedChannelNewContentCompressor;
    }

    private static ByteBuf nextReadableBuf(EmbeddedChannel embeddedChannel) {
        while (true) {
            ByteBuf byteBuf = (ByteBuf) embeddedChannel.readOutbound();
            if (byteBuf == null) {
                return null;
            }
            if (byteBuf.isReadable()) {
                return byteBuf;
            }
            byteBuf.release();
        }
    }

    public void cleanup(Http2Stream http2Stream, EmbeddedChannel embeddedChannel) {
        embeddedChannel.finishAndReleaseAll();
        http2Stream.removeProperty(this.propertyKey);
    }

    public CharSequence getTargetContentEncoding(CharSequence charSequence) throws Http2Exception {
        return charSequence;
    }

    public EmbeddedChannel newContentCompressor(ChannelHandlerContext channelHandlerContext, CharSequence charSequence) throws Http2Exception {
        if (HttpHeaderValues.GZIP.contentEqualsIgnoreCase(charSequence) || HttpHeaderValues.X_GZIP.contentEqualsIgnoreCase(charSequence)) {
            return newCompressionChannel(channelHandlerContext, ZlibWrapper.GZIP);
        }
        if (HttpHeaderValues.DEFLATE.contentEqualsIgnoreCase(charSequence) || HttpHeaderValues.X_DEFLATE.contentEqualsIgnoreCase(charSequence)) {
            return newCompressionChannel(channelHandlerContext, ZlibWrapper.ZLIB);
        }
        if (Brotli.isAvailable() && this.brotliOptions != null && HttpHeaderValues.BR.contentEqualsIgnoreCase(charSequence)) {
            return new EmbeddedChannel(channelHandlerContext.channel().id(), channelHandlerContext.channel().metadata().hasDisconnect(), channelHandlerContext.channel().config(), new BrotliEncoder(this.brotliOptions.parameters()));
        }
        if (this.zstdOptions != null && HttpHeaderValues.ZSTD.contentEqualsIgnoreCase(charSequence)) {
            return new EmbeddedChannel(channelHandlerContext.channel().id(), channelHandlerContext.channel().metadata().hasDisconnect(), channelHandlerContext.channel().config(), new ZstdEncoder(this.zstdOptions.compressionLevel(), this.zstdOptions.blockSize(), this.zstdOptions.maxEncodeSize()));
        }
        if (this.snappyOptions == null || !HttpHeaderValues.SNAPPY.contentEqualsIgnoreCase(charSequence)) {
            return null;
        }
        return new EmbeddedChannel(channelHandlerContext.channel().id(), channelHandlerContext.channel().metadata().hasDisconnect(), channelHandlerContext.channel().config(), new SnappyFrameEncoder());
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2DataWriter
    public ChannelFuture writeData(ChannelHandlerContext channelHandlerContext, int i10, ByteBuf byteBuf, int i11, boolean z10, ChannelPromise channelPromise) {
        boolean z11;
        Http2Stream http2StreamStream = connection().stream(i10);
        EmbeddedChannel embeddedChannel = http2StreamStream == null ? null : (EmbeddedChannel) http2StreamStream.getProperty(this.propertyKey);
        if (embeddedChannel == null) {
            return super.writeData(channelHandlerContext, i10, byteBuf, i11, z10, channelPromise);
        }
        try {
            embeddedChannel.writeOutbound(byteBuf);
            ByteBuf byteBufNextReadableBuf = nextReadableBuf(embeddedChannel);
            if (byteBufNextReadableBuf == null) {
                if (!z10) {
                    channelPromise.setSuccess();
                    if (z10) {
                        cleanup(http2StreamStream, embeddedChannel);
                    }
                    return channelPromise;
                }
                if (embeddedChannel.finish()) {
                    byteBufNextReadableBuf = nextReadableBuf(embeddedChannel);
                }
                if (byteBufNextReadableBuf == null) {
                    byteBufNextReadableBuf = Unpooled.EMPTY_BUFFER;
                }
                ChannelFuture channelFutureWriteData = super.writeData(channelHandlerContext, i10, byteBufNextReadableBuf, i11, true, channelPromise);
                if (z10) {
                    cleanup(http2StreamStream, embeddedChannel);
                }
                return channelFutureWriteData;
            }
            PromiseCombiner promiseCombiner = new PromiseCombiner(channelHandlerContext.executor());
            int i12 = i11;
            ByteBuf byteBuf2 = byteBufNextReadableBuf;
            while (true) {
                ByteBuf byteBufNextReadableBuf2 = nextReadableBuf(embeddedChannel);
                boolean z12 = true;
                boolean z13 = byteBufNextReadableBuf2 == null && z10;
                if (z13 && embeddedChannel.finish()) {
                    byteBufNextReadableBuf2 = nextReadableBuf(embeddedChannel);
                    if (byteBufNextReadableBuf2 != null) {
                        z12 = false;
                    }
                    z11 = z12;
                } else {
                    z11 = z13;
                }
                ChannelPromise channelPromiseNewPromise = channelHandlerContext.newPromise();
                promiseCombiner.add((Promise) channelPromiseNewPromise);
                super.writeData(channelHandlerContext, i10, byteBuf2, i12, z11, channelPromiseNewPromise);
                if (byteBufNextReadableBuf2 == null) {
                    break;
                }
                byteBuf2 = byteBufNextReadableBuf2;
                i12 = 0;
            }
            promiseCombiner.finish(channelPromise);
            if (z10) {
            }
            return channelPromise;
        } catch (Throwable th2) {
            try {
                channelPromise.tryFailure(th2);
            } finally {
                if (z10) {
                    cleanup(http2StreamStream, embeddedChannel);
                }
            }
        }
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, boolean z10, ChannelPromise channelPromise) {
        try {
            EmbeddedChannel embeddedChannelNewCompressor = newCompressor(channelHandlerContext, http2Headers, z10);
            ChannelFuture channelFutureWriteHeaders = super.writeHeaders(channelHandlerContext, i10, http2Headers, i11, z10, channelPromise);
            bindCompressorToStream(embeddedChannelNewCompressor, i10);
            return channelFutureWriteHeaders;
        } catch (Throwable th2) {
            channelPromise.tryFailure(th2);
            return channelPromise;
        }
    }

    @Deprecated
    public CompressorHttp2ConnectionEncoder(Http2ConnectionEncoder http2ConnectionEncoder, int i10, int i11, int i12) {
        super(http2ConnectionEncoder);
        this.compressionLevel = ObjectUtil.checkInRange(i10, 0, 9, "compressionLevel");
        this.windowBits = ObjectUtil.checkInRange(i11, 9, 15, "windowBits");
        this.memLevel = ObjectUtil.checkInRange(i12, 1, 9, "memLevel");
        this.propertyKey = connection().newKey();
        connection().addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.CompressorHttp2ConnectionEncoder.1
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamRemoved(Http2Stream http2Stream) {
                EmbeddedChannel embeddedChannel = (EmbeddedChannel) http2Stream.getProperty(CompressorHttp2ConnectionEncoder.this.propertyKey);
                if (embeddedChannel != null) {
                    CompressorHttp2ConnectionEncoder.this.cleanup(http2Stream, embeddedChannel);
                }
            }
        });
        this.supportsCompressionOptions = false;
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, short s10, boolean z10, int i12, boolean z11, ChannelPromise channelPromise) {
        try {
            EmbeddedChannel embeddedChannelNewCompressor = newCompressor(channelHandlerContext, http2Headers, z11);
            ChannelFuture channelFutureWriteHeaders = super.writeHeaders(channelHandlerContext, i10, http2Headers, i11, s10, z10, i12, z11, channelPromise);
            bindCompressorToStream(embeddedChannelNewCompressor, i10);
            return channelFutureWriteHeaders;
        } catch (Throwable th2) {
            channelPromise.tryFailure(th2);
            return channelPromise;
        }
    }

    public CompressorHttp2ConnectionEncoder(Http2ConnectionEncoder http2ConnectionEncoder, CompressionOptions... compressionOptionsArr) {
        super(http2ConnectionEncoder);
        ObjectUtil.checkNotNull(compressionOptionsArr, "CompressionOptions");
        ObjectUtil.deepCheckNotNull("CompressionOptions", compressionOptionsArr);
        for (CompressionOptions compressionOptions : compressionOptionsArr) {
            if (Brotli.isAvailable() && (compressionOptions instanceof BrotliOptions)) {
                this.brotliOptions = (BrotliOptions) compressionOptions;
            } else if (compressionOptions instanceof GzipOptions) {
                this.gzipCompressionOptions = (GzipOptions) compressionOptions;
            } else if (compressionOptions instanceof DeflateOptions) {
                this.deflateOptions = (DeflateOptions) compressionOptions;
            } else if (compressionOptions instanceof ZstdOptions) {
                this.zstdOptions = (ZstdOptions) compressionOptions;
            } else if (compressionOptions instanceof SnappyOptions) {
                this.snappyOptions = (SnappyOptions) compressionOptions;
            } else {
                throw new IllegalArgumentException("Unsupported CompressionOptions: " + compressionOptions);
            }
        }
        this.supportsCompressionOptions = true;
        this.propertyKey = connection().newKey();
        connection().addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.CompressorHttp2ConnectionEncoder.2
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamRemoved(Http2Stream http2Stream) {
                EmbeddedChannel embeddedChannel = (EmbeddedChannel) http2Stream.getProperty(CompressorHttp2ConnectionEncoder.this.propertyKey);
                if (embeddedChannel != null) {
                    CompressorHttp2ConnectionEncoder.this.cleanup(http2Stream, embeddedChannel);
                }
            }
        });
    }
}
