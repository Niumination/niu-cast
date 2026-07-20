package io.netty.handler.codec.compression;

import e0.a;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import k.b;

/* JADX INFO: loaded from: classes3.dex */
public class JdkZlibDecoder extends ZlibDecoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int FCOMMENT = 16;
    private static final int FEXTRA = 4;
    private static final int FHCRC = 2;
    private static final int FNAME = 8;
    private static final int FRESERVED = 224;
    private final ByteBufChecksum crc;
    private boolean decideZlibOrNone;
    private final boolean decompressConcatenated;
    private final byte[] dictionary;
    private volatile boolean finished;
    private int flags;
    private GzipState gzipState;
    private Inflater inflater;
    private int xlen;

    /* JADX INFO: renamed from: io.netty.handler.codec.compression.JdkZlibDecoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper;

        static {
            int[] iArr = new int[GzipState.values().length];
            $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState = iArr;
            try {
                iArr[GzipState.HEADER_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.FLG_READ.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.XLEN_READ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.SKIP_FNAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.SKIP_COMMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.PROCESS_FHCRC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.HEADER_END.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[ZlibWrapper.values().length];
            $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper = iArr2;
            try {
                iArr2[ZlibWrapper.GZIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.ZLIB.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.ZLIB_OR_NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public enum GzipState {
        HEADER_START,
        HEADER_END,
        FLG_READ,
        XLEN_READ,
        SKIP_FNAME,
        SKIP_COMMENT,
        PROCESS_FHCRC,
        FOOTER_START
    }

    public JdkZlibDecoder() {
        this(ZlibWrapper.ZLIB, null, false, 0);
    }

    private boolean handleGzipFooter(ByteBuf byteBuf) {
        if (!readGZIPFooter(byteBuf)) {
            return false;
        }
        this.finished = !this.decompressConcatenated;
        if (this.finished) {
            return false;
        }
        this.inflater.reset();
        this.crc.reset();
        this.gzipState = GzipState.HEADER_START;
        return true;
    }

    private static boolean looksLikeZlib(short s10) {
        return (s10 & 30720) == 30720 && s10 % 31 == 0;
    }

    private boolean readGZIPFooter(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() < 8) {
            return false;
        }
        verifyCrc(byteBuf);
        int unsignedByte = 0;
        for (int i10 = 0; i10 < 4; i10++) {
            unsignedByte |= byteBuf.readUnsignedByte() << (i10 * 8);
        }
        int totalOut = this.inflater.getTotalOut();
        if (unsignedByte == totalOut) {
            return true;
        }
        throw new DecompressionException(a.a("Number of bytes mismatch. Expected: ", unsignedByte, ", Got: ", totalOut));
    }

    private boolean readGZIPHeader(ByteBuf byteBuf) {
        switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[this.gzipState.ordinal()]) {
            case 1:
                if (byteBuf.readableBytes() < 10) {
                    return false;
                }
                byte b10 = byteBuf.readByte();
                byte b11 = byteBuf.readByte();
                if (b10 != 31) {
                    throw new DecompressionException("Input is not in the GZIP format");
                }
                this.crc.update(b10);
                this.crc.update(b11);
                short unsignedByte = byteBuf.readUnsignedByte();
                if (unsignedByte != 8) {
                    throw new DecompressionException(b.a("Unsupported compression method ", unsignedByte, " in the GZIP header"));
                }
                this.crc.update(unsignedByte);
                short unsignedByte2 = byteBuf.readUnsignedByte();
                this.flags = unsignedByte2;
                this.crc.update(unsignedByte2);
                if ((this.flags & FRESERVED) != 0) {
                    throw new DecompressionException("Reserved flags are set in the GZIP header");
                }
                this.crc.update(byteBuf, byteBuf.readerIndex(), 4);
                byteBuf.skipBytes(4);
                this.crc.update(byteBuf.readUnsignedByte());
                this.crc.update(byteBuf.readUnsignedByte());
                this.gzipState = GzipState.FLG_READ;
                break;
            case 2:
                if ((this.flags & 4) != 0) {
                    if (byteBuf.readableBytes() < 2) {
                        return false;
                    }
                    short unsignedByte3 = byteBuf.readUnsignedByte();
                    short unsignedByte4 = byteBuf.readUnsignedByte();
                    this.crc.update(unsignedByte3);
                    this.crc.update(unsignedByte4);
                    this.xlen = (unsignedByte3 << 8) | unsignedByte4 | this.xlen;
                }
                this.gzipState = GzipState.XLEN_READ;
            case 3:
                if (this.xlen != -1) {
                    if (byteBuf.readableBytes() < this.xlen) {
                        return false;
                    }
                    this.crc.update(byteBuf, byteBuf.readerIndex(), this.xlen);
                    byteBuf.skipBytes(this.xlen);
                }
                this.gzipState = GzipState.SKIP_FNAME;
            case 4:
                if (!skipIfNeeded(byteBuf, 8)) {
                    return false;
                }
                this.gzipState = GzipState.SKIP_COMMENT;
                break;
            case 5:
                if (!skipIfNeeded(byteBuf, 16)) {
                    return false;
                }
                this.gzipState = GzipState.PROCESS_FHCRC;
                break;
            case 6:
                if ((this.flags & 2) != 0 && !verifyCrc16(byteBuf)) {
                    return false;
                }
                this.crc.reset();
                this.gzipState = GzipState.HEADER_END;
                return true;
            case 7:
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    private boolean skipIfNeeded(ByteBuf byteBuf, int i10) {
        if ((i10 & this.flags) == 0) {
            return true;
        }
        while (byteBuf.isReadable()) {
            short unsignedByte = byteBuf.readUnsignedByte();
            this.crc.update(unsignedByte);
            if (unsignedByte == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean verifyCrc(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() < 4) {
            return false;
        }
        long unsignedByte = 0;
        for (int i10 = 0; i10 < 4; i10++) {
            unsignedByte |= ((long) byteBuf.readUnsignedByte()) << (i10 * 8);
        }
        long value = this.crc.getValue();
        if (unsignedByte == value) {
            return true;
        }
        StringBuilder sbA = j.b.a("CRC value mismatch. Expected: ", unsignedByte, ", Got: ");
        sbA.append(value);
        throw new DecompressionException(sbA.toString());
    }

    private boolean verifyCrc16(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() < 2) {
            return false;
        }
        long value = this.crc.getValue();
        long unsignedByte = 0;
        long j10 = 0;
        for (int i10 = 0; i10 < 2; i10++) {
            int i11 = i10 * 8;
            unsignedByte |= ((long) byteBuf.readUnsignedByte()) << i11;
            j10 |= ((value >> i11) & 255) << i11;
        }
        if (unsignedByte == j10) {
            return true;
        }
        StringBuilder sbA = j.b.a("CRC16 value mismatch. Expected: ", unsignedByte, ", Got: ");
        sbA.append(j10);
        throw new DecompressionException(sbA.toString());
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        GzipState gzipState;
        if (this.finished) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        int i10 = byteBuf.readableBytes();
        if (i10 == 0) {
            return;
        }
        boolean z10 = false;
        if (this.decideZlibOrNone) {
            if (i10 < 2) {
                return;
            }
            this.inflater = new Inflater(!looksLikeZlib(byteBuf.getShort(byteBuf.readerIndex())));
            this.decideZlibOrNone = false;
        }
        if (this.crc == null || (gzipState = this.gzipState) == GzipState.HEADER_END || ((gzipState != GzipState.FOOTER_START || handleGzipFooter(byteBuf)) && readGZIPHeader(byteBuf) && (i10 = byteBuf.readableBytes()) != 0)) {
            if (this.inflater.needsInput()) {
                if (byteBuf.hasArray()) {
                    this.inflater.setInput(byteBuf.array(), byteBuf.readerIndex() + byteBuf.arrayOffset(), i10);
                } else {
                    byte[] bArr = new byte[i10];
                    byteBuf.getBytes(byteBuf.readerIndex(), bArr);
                    this.inflater.setInput(bArr);
                }
            }
            ByteBuf byteBufPrepareDecompressBuffer = prepareDecompressBuffer(channelHandlerContext, null, this.inflater.getRemaining() << 1);
            while (!this.inflater.needsInput()) {
                try {
                    try {
                        byte[] bArrArray = byteBufPrepareDecompressBuffer.array();
                        int iWriterIndex = byteBufPrepareDecompressBuffer.writerIndex();
                        int iArrayOffset = byteBufPrepareDecompressBuffer.arrayOffset() + iWriterIndex;
                        int iInflate = this.inflater.inflate(bArrArray, iArrayOffset, byteBufPrepareDecompressBuffer.writableBytes());
                        if (iInflate > 0) {
                            byteBufPrepareDecompressBuffer.writerIndex(iWriterIndex + iInflate);
                            ByteBufChecksum byteBufChecksum = this.crc;
                            if (byteBufChecksum != null) {
                                byteBufChecksum.update(bArrArray, iArrayOffset, iInflate);
                            }
                        } else if (this.inflater.needsDictionary()) {
                            byte[] bArr2 = this.dictionary;
                            if (bArr2 == null) {
                                throw new DecompressionException("decompression failure, unable to set dictionary as non was specified");
                            }
                            this.inflater.setDictionary(bArr2);
                        }
                        if (this.inflater.finished()) {
                            if (this.crc != null) {
                                z10 = true;
                                break;
                            } else {
                                this.finished = true;
                                break;
                            }
                        }
                        byteBufPrepareDecompressBuffer = prepareDecompressBuffer(channelHandlerContext, byteBufPrepareDecompressBuffer, this.inflater.getRemaining() << 1);
                    } catch (DataFormatException e10) {
                        throw new DecompressionException("decompression failure", e10);
                    }
                } catch (Throwable th2) {
                    if (byteBufPrepareDecompressBuffer.isReadable()) {
                        list.add(byteBufPrepareDecompressBuffer);
                    } else {
                        byteBufPrepareDecompressBuffer.release();
                    }
                    throw th2;
                }
            }
            byteBuf.skipBytes(i10 - this.inflater.getRemaining());
            if (z10) {
                this.gzipState = GzipState.FOOTER_START;
                handleGzipFooter(byteBuf);
            }
            if (byteBufPrepareDecompressBuffer.isReadable()) {
                list.add(byteBufPrepareDecompressBuffer);
            } else {
                byteBufPrepareDecompressBuffer.release();
            }
        }
    }

    @Override // io.netty.handler.codec.compression.ZlibDecoder
    public void decompressionBufferExhausted(ByteBuf byteBuf) {
        this.finished = true;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.handlerRemoved0(channelHandlerContext);
        Inflater inflater = this.inflater;
        if (inflater != null) {
            inflater.end();
        }
    }

    @Override // io.netty.handler.codec.compression.ZlibDecoder
    public boolean isClosed() {
        return this.finished;
    }

    public JdkZlibDecoder(int i10) {
        this(ZlibWrapper.ZLIB, null, false, i10);
    }

    public JdkZlibDecoder(byte[] bArr) {
        this(ZlibWrapper.ZLIB, bArr, false, 0);
    }

    public JdkZlibDecoder(byte[] bArr, int i10) {
        this(ZlibWrapper.ZLIB, bArr, false, i10);
    }

    public JdkZlibDecoder(ZlibWrapper zlibWrapper) {
        this(zlibWrapper, null, false, 0);
    }

    public JdkZlibDecoder(ZlibWrapper zlibWrapper, int i10) {
        this(zlibWrapper, null, false, i10);
    }

    public JdkZlibDecoder(ZlibWrapper zlibWrapper, boolean z10) {
        this(zlibWrapper, null, z10, 0);
    }

    public JdkZlibDecoder(ZlibWrapper zlibWrapper, boolean z10, int i10) {
        this(zlibWrapper, null, z10, i10);
    }

    public JdkZlibDecoder(boolean z10) {
        this(ZlibWrapper.GZIP, null, z10, 0);
    }

    public JdkZlibDecoder(boolean z10, int i10) {
        this(ZlibWrapper.GZIP, null, z10, i10);
    }

    private JdkZlibDecoder(ZlibWrapper zlibWrapper, byte[] bArr, boolean z10, int i10) {
        super(i10);
        this.gzipState = GzipState.HEADER_START;
        this.flags = -1;
        this.xlen = -1;
        ObjectUtil.checkNotNull(zlibWrapper, "wrapper");
        this.decompressConcatenated = z10;
        int i11 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[zlibWrapper.ordinal()];
        if (i11 == 1) {
            this.inflater = new Inflater(true);
            this.crc = ByteBufChecksum.wrapChecksum(new CRC32());
        } else if (i11 == 2) {
            this.inflater = new Inflater(true);
            this.crc = null;
        } else if (i11 == 3) {
            this.inflater = new Inflater();
            this.crc = null;
        } else if (i11 == 4) {
            this.decideZlibOrNone = true;
            this.crc = null;
        } else {
            throw new IllegalArgumentException("Only GZIP or ZLIB is supported, but you used " + zlibWrapper);
        }
        this.dictionary = bArr;
    }
}
