package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.MessageToByteEncoder;
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
import io.netty.handler.codec.compression.Zstd;
import io.netty.handler.codec.compression.ZstdEncoder;
import io.netty.handler.codec.compression.ZstdOptions;
import io.netty.util.internal.ObjectUtil;
import java.util.HashMap;
import java.util.Map;
import ks.g;

/* JADX INFO: loaded from: classes3.dex */
public class HttpContentCompressor extends HttpContentEncoder {
    private final BrotliOptions brotliOptions;
    private final int compressionLevel;
    private final int contentSizeThreshold;
    private ChannelHandlerContext ctx;
    private final DeflateOptions deflateOptions;
    private final Map<String, CompressionEncoderFactory> factories;
    private final GzipOptions gzipOptions;
    private final int memLevel;
    private final SnappyOptions snappyOptions;
    private final boolean supportsCompressionOptions;
    private final int windowBits;
    private final ZstdOptions zstdOptions;

    /* JADX INFO: renamed from: io.netty.handler.codec.http.HttpContentCompressor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper;

        static {
            int[] iArr = new int[ZlibWrapper.values().length];
            $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper = iArr;
            try {
                iArr[ZlibWrapper.GZIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.ZLIB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public final class BrEncoderFactory implements CompressionEncoderFactory {
        private BrEncoderFactory() {
        }

        @Override // io.netty.handler.codec.http.CompressionEncoderFactory
        public MessageToByteEncoder<ByteBuf> createEncoder() {
            return new BrotliEncoder(HttpContentCompressor.this.brotliOptions.parameters());
        }

        public /* synthetic */ BrEncoderFactory(HttpContentCompressor httpContentCompressor, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public final class DeflateEncoderFactory implements CompressionEncoderFactory {
        private DeflateEncoderFactory() {
        }

        @Override // io.netty.handler.codec.http.CompressionEncoderFactory
        public MessageToByteEncoder<ByteBuf> createEncoder() {
            return ZlibCodecFactory.newZlibEncoder(ZlibWrapper.ZLIB, HttpContentCompressor.this.deflateOptions.compressionLevel(), HttpContentCompressor.this.deflateOptions.windowBits(), HttpContentCompressor.this.deflateOptions.memLevel());
        }

        public /* synthetic */ DeflateEncoderFactory(HttpContentCompressor httpContentCompressor, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public final class GzipEncoderFactory implements CompressionEncoderFactory {
        private GzipEncoderFactory() {
        }

        @Override // io.netty.handler.codec.http.CompressionEncoderFactory
        public MessageToByteEncoder<ByteBuf> createEncoder() {
            return ZlibCodecFactory.newZlibEncoder(ZlibWrapper.GZIP, HttpContentCompressor.this.gzipOptions.compressionLevel(), HttpContentCompressor.this.gzipOptions.windowBits(), HttpContentCompressor.this.gzipOptions.memLevel());
        }

        public /* synthetic */ GzipEncoderFactory(HttpContentCompressor httpContentCompressor, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static final class SnappyEncoderFactory implements CompressionEncoderFactory {
        private SnappyEncoderFactory() {
        }

        @Override // io.netty.handler.codec.http.CompressionEncoderFactory
        public MessageToByteEncoder<ByteBuf> createEncoder() {
            return new SnappyFrameEncoder();
        }

        public /* synthetic */ SnappyEncoderFactory(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public final class ZstdEncoderFactory implements CompressionEncoderFactory {
        private ZstdEncoderFactory() {
        }

        @Override // io.netty.handler.codec.http.CompressionEncoderFactory
        public MessageToByteEncoder<ByteBuf> createEncoder() {
            return new ZstdEncoder(HttpContentCompressor.this.zstdOptions.compressionLevel(), HttpContentCompressor.this.zstdOptions.blockSize(), HttpContentCompressor.this.zstdOptions.maxEncodeSize());
        }

        public /* synthetic */ ZstdEncoderFactory(HttpContentCompressor httpContentCompressor, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public HttpContentCompressor() {
        this(6);
    }

    @Override // io.netty.handler.codec.http.HttpContentEncoder
    public HttpContentEncoder.Result beginEncode(HttpResponse httpResponse, String str) throws Exception {
        String str2;
        if ((this.contentSizeThreshold > 0 && (httpResponse instanceof HttpContent) && ((HttpContent) httpResponse).content().readableBytes() < this.contentSizeThreshold) || httpResponse.headers().get(HttpHeaderNames.CONTENT_ENCODING) != null) {
            return null;
        }
        if (this.supportsCompressionOptions) {
            String strDetermineEncoding = determineEncoding(str);
            if (strDetermineEncoding == null) {
                return null;
            }
            CompressionEncoderFactory compressionEncoderFactory = this.factories.get(strDetermineEncoding);
            if (compressionEncoderFactory != null) {
                return new HttpContentEncoder.Result(strDetermineEncoding, new EmbeddedChannel(this.ctx.channel().id(), this.ctx.channel().metadata().hasDisconnect(), this.ctx.channel().config(), compressionEncoderFactory.createEncoder()));
            }
            throw new Error();
        }
        ZlibWrapper zlibWrapperDetermineWrapper = determineWrapper(str);
        if (zlibWrapperDetermineWrapper == null) {
            return null;
        }
        int i10 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[zlibWrapperDetermineWrapper.ordinal()];
        if (i10 == 1) {
            str2 = "gzip";
        } else {
            if (i10 != 2) {
                throw new Error();
            }
            str2 = "deflate";
        }
        return new HttpContentEncoder.Result(str2, new EmbeddedChannel(this.ctx.channel().id(), this.ctx.channel().metadata().hasDisconnect(), this.ctx.channel().config(), ZlibCodecFactory.newZlibEncoder(zlibWrapperDetermineWrapper, this.compressionLevel, this.windowBits, this.memLevel)));
    }

    public String determineEncoding(String str) {
        float f10;
        String[] strArrSplit = str.split(g.f9491d);
        int length = strArrSplit.length;
        int i10 = 0;
        float f11 = -1.0f;
        float f12 = -1.0f;
        float f13 = -1.0f;
        float f14 = -1.0f;
        float f15 = -1.0f;
        float f16 = -1.0f;
        while (true) {
            float f17 = 0.0f;
            if (i10 >= length) {
                break;
            }
            String str2 = strArrSplit[i10];
            String[] strArr = strArrSplit;
            int iIndexOf = str2.indexOf(61);
            int i11 = length;
            if (iIndexOf != -1) {
                try {
                    f17 = Float.parseFloat(str2.substring(iIndexOf + 1));
                } catch (NumberFormatException unused) {
                }
            } else {
                f17 = 1.0f;
            }
            if (str2.contains("*")) {
                f16 = f17;
            } else if (str2.contains("br") && f17 > f11) {
                f11 = f17;
            } else if (str2.contains("zstd") && f17 > f12) {
                f12 = f17;
            } else if (str2.contains("snappy") && f17 > f13) {
                f13 = f17;
            } else if (str2.contains("gzip") && f17 > f14) {
                f14 = f17;
            } else if (str2.contains("deflate") && f17 > f15) {
                f15 = f17;
            }
            i10++;
            strArrSplit = strArr;
            length = i11;
        }
        if (f11 > 0.0f || f12 > 0.0f || f13 > 0.0f || f14 > 0.0f || f15 > 0.0f) {
            f10 = -1.0f;
            if (f11 != -1.0f && f11 >= f12 && this.brotliOptions != null) {
                return "br";
            }
            if (f12 != -1.0f && f12 >= f13 && this.zstdOptions != null) {
                return "zstd";
            }
            if (f13 != -1.0f && f13 >= f14 && this.snappyOptions != null) {
                return "snappy";
            }
            if (f14 != -1.0f && f14 >= f15 && this.gzipOptions != null) {
                return "gzip";
            }
            if (f15 != -1.0f && this.deflateOptions != null) {
                return "deflate";
            }
        } else {
            f10 = -1.0f;
        }
        if (f16 <= 0.0f) {
            return null;
        }
        if (f11 == f10 && this.brotliOptions != null) {
            return "br";
        }
        if (f12 == f10 && this.zstdOptions != null) {
            return "zstd";
        }
        if (f13 == f10 && this.snappyOptions != null) {
            return "snappy";
        }
        if (f14 == f10 && this.gzipOptions != null) {
            return "gzip";
        }
        if (f15 != f10 || this.deflateOptions == null) {
            return null;
        }
        return "deflate";
    }

    @Deprecated
    public ZlibWrapper determineWrapper(String str) {
        String[] strArrSplit = str.split(g.f9491d);
        int length = strArrSplit.length;
        int i10 = 0;
        float f10 = -1.0f;
        float f11 = -1.0f;
        float f12 = -1.0f;
        while (true) {
            float f13 = 0.0f;
            if (i10 >= length) {
                break;
            }
            String str2 = strArrSplit[i10];
            int iIndexOf = str2.indexOf(61);
            if (iIndexOf != -1) {
                try {
                    f13 = Float.parseFloat(str2.substring(iIndexOf + 1));
                } catch (NumberFormatException unused) {
                }
            } else {
                f13 = 1.0f;
            }
            if (str2.contains("*")) {
                f12 = f13;
            } else if (str2.contains("gzip") && f13 > f10) {
                f10 = f13;
            } else if (str2.contains("deflate") && f13 > f11) {
                f11 = f13;
            }
            i10++;
        }
        if (f10 > 0.0f || f11 > 0.0f) {
            return f10 >= f11 ? ZlibWrapper.GZIP : ZlibWrapper.ZLIB;
        }
        if (f12 <= 0.0f) {
            return null;
        }
        if (f10 == -1.0f) {
            return ZlibWrapper.GZIP;
        }
        if (f11 == -1.0f) {
            return ZlibWrapper.ZLIB;
        }
        return null;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
    }

    @Deprecated
    public HttpContentCompressor(int i10) {
        this(i10, 15, 8, 0);
    }

    @Deprecated
    public HttpContentCompressor(int i10, int i11, int i12) {
        this(i10, i11, i12, 0);
    }

    @Deprecated
    public HttpContentCompressor(int i10, int i11, int i12, int i13) {
        this.compressionLevel = ObjectUtil.checkInRange(i10, 0, 9, "compressionLevel");
        this.windowBits = ObjectUtil.checkInRange(i11, 9, 15, "windowBits");
        this.memLevel = ObjectUtil.checkInRange(i12, 1, 9, "memLevel");
        this.contentSizeThreshold = ObjectUtil.checkPositiveOrZero(i13, "contentSizeThreshold");
        this.brotliOptions = null;
        this.gzipOptions = null;
        this.deflateOptions = null;
        this.zstdOptions = null;
        this.snappyOptions = null;
        this.factories = null;
        this.supportsCompressionOptions = false;
    }

    public HttpContentCompressor(CompressionOptions... compressionOptionsArr) {
        this(0, compressionOptionsArr);
    }

    public HttpContentCompressor(int i10, CompressionOptions... compressionOptionsArr) {
        BrotliOptions brotliOptionsBrotli;
        GzipOptions gzipOptionsGzip;
        DeflateOptions deflateOptionsDeflate;
        ZstdOptions zstdOptionsZstd;
        SnappyOptions snappyOptionsSnappy;
        this.contentSizeThreshold = ObjectUtil.checkPositiveOrZero(i10, "contentSizeThreshold");
        AnonymousClass1 anonymousClass1 = null;
        if (compressionOptionsArr != null && compressionOptionsArr.length != 0) {
            ObjectUtil.deepCheckNotNull("compressionOptions", compressionOptionsArr);
            brotliOptionsBrotli = null;
            gzipOptionsGzip = null;
            deflateOptionsDeflate = null;
            zstdOptionsZstd = null;
            snappyOptionsSnappy = null;
            for (CompressionOptions compressionOptions : compressionOptionsArr) {
                if (Brotli.isAvailable() && (compressionOptions instanceof BrotliOptions)) {
                    brotliOptionsBrotli = (BrotliOptions) compressionOptions;
                } else if (compressionOptions instanceof GzipOptions) {
                    gzipOptionsGzip = (GzipOptions) compressionOptions;
                } else if (compressionOptions instanceof DeflateOptions) {
                    deflateOptionsDeflate = (DeflateOptions) compressionOptions;
                } else if (compressionOptions instanceof ZstdOptions) {
                    zstdOptionsZstd = (ZstdOptions) compressionOptions;
                } else if (compressionOptions instanceof SnappyOptions) {
                    snappyOptionsSnappy = (SnappyOptions) compressionOptions;
                } else {
                    throw new IllegalArgumentException("Unsupported CompressionOptions: " + compressionOptions);
                }
            }
        } else {
            brotliOptionsBrotli = Brotli.isAvailable() ? StandardCompressionOptions.brotli() : null;
            gzipOptionsGzip = StandardCompressionOptions.gzip();
            deflateOptionsDeflate = StandardCompressionOptions.deflate();
            zstdOptionsZstd = Zstd.isAvailable() ? StandardCompressionOptions.zstd() : null;
            snappyOptionsSnappy = StandardCompressionOptions.snappy();
        }
        this.gzipOptions = gzipOptionsGzip;
        this.deflateOptions = deflateOptionsDeflate;
        this.brotliOptions = brotliOptionsBrotli;
        this.zstdOptions = zstdOptionsZstd;
        this.snappyOptions = snappyOptionsSnappy;
        HashMap map = new HashMap();
        this.factories = map;
        if (gzipOptionsGzip != null) {
            map.put("gzip", new GzipEncoderFactory(this, anonymousClass1));
        }
        if (deflateOptionsDeflate != null) {
            map.put("deflate", new DeflateEncoderFactory(this, anonymousClass1));
        }
        if (Brotli.isAvailable() && brotliOptionsBrotli != null) {
            map.put("br", new BrEncoderFactory(this, anonymousClass1));
        }
        if (zstdOptionsZstd != null) {
            map.put("zstd", new ZstdEncoderFactory(this, anonymousClass1));
        }
        if (snappyOptionsSnappy != null) {
            map.put("snappy", new SnappyEncoderFactory(anonymousClass1));
        }
        this.compressionLevel = -1;
        this.windowBits = -1;
        this.memLevel = -1;
        this.supportsCompressionOptions = true;
    }
}
