package io.netty.handler.codec.http2;

import c1.c;
import fl.h;
import h.a;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpHeaderValidationUtil;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import o1.t;

/* JADX INFO: loaded from: classes3.dex */
final class HpackDecoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Http2Exception DECODE_ILLEGAL_INDEX_VALUE;
    private static final Http2Exception DECODE_ULE_128_DECOMPRESSION_EXCEPTION;
    private static final Http2Exception DECODE_ULE_128_TO_INT_DECOMPRESSION_EXCEPTION;
    private static final Http2Exception DECODE_ULE_128_TO_LONG_DECOMPRESSION_EXCEPTION;
    private static final Http2Exception INDEX_HEADER_ILLEGAL_INDEX_VALUE;
    private static final Http2Exception INVALID_MAX_DYNAMIC_TABLE_SIZE;
    private static final Http2Exception MAX_DYNAMIC_TABLE_SIZE_CHANGE_REQUIRED;
    private static final byte READ_HEADER_REPRESENTATION = 0;
    private static final byte READ_INDEXED_HEADER = 1;
    private static final byte READ_INDEXED_HEADER_NAME = 2;
    private static final byte READ_LITERAL_HEADER_NAME = 5;
    private static final byte READ_LITERAL_HEADER_NAME_LENGTH = 4;
    private static final byte READ_LITERAL_HEADER_NAME_LENGTH_PREFIX = 3;
    private static final byte READ_LITERAL_HEADER_VALUE = 8;
    private static final byte READ_LITERAL_HEADER_VALUE_LENGTH = 7;
    private static final byte READ_LITERAL_HEADER_VALUE_LENGTH_PREFIX = 6;
    private static final Http2Exception READ_NAME_ILLEGAL_INDEX_VALUE;
    private long encoderMaxDynamicTableSize;
    private final HpackDynamicTable hpackDynamicTable;
    private final HpackHuffmanDecoder huffmanDecoder;
    private long maxDynamicTableSize;
    private boolean maxDynamicTableSizeChangeRequired;
    private long maxHeaderListSize;

    /* JADX INFO: renamed from: io.netty.handler.codec.http2.HpackDecoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType;

        static {
            int[] iArr = new int[HpackUtil.IndexType.values().length];
            $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType = iArr;
            try {
                iArr[HpackUtil.IndexType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[HpackUtil.IndexType.NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[HpackUtil.IndexType.INCREMENTAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum HeaderType {
        REGULAR_HEADER,
        REQUEST_PSEUDO_HEADER,
        RESPONSE_PSEUDO_HEADER
    }

    public static final class Http2HeadersSink {
        private boolean exceededMaxLength;
        private final Http2Headers headers;
        private long headersLength;
        private final long maxHeaderListSize;
        private HeaderType previousType;
        private final int streamId;
        private final boolean validateHeaders;
        private Http2Exception validationException;

        public Http2HeadersSink(int i10, Http2Headers http2Headers, long j10, boolean z10) {
            this.headers = http2Headers;
            this.maxHeaderListSize = j10;
            this.streamId = i10;
            this.validateHeaders = z10;
        }

        public void appendToHeaderList(AsciiString asciiString, AsciiString asciiString2) {
            long jSizeOf = this.headersLength + HpackHeaderField.sizeOf(asciiString, asciiString2);
            this.headersLength = jSizeOf;
            boolean z10 = (jSizeOf > this.maxHeaderListSize) | this.exceededMaxLength;
            this.exceededMaxLength = z10;
            if (z10 || this.validationException != null) {
                return;
            }
            try {
                this.headers.add(asciiString, asciiString2);
                if (this.validateHeaders) {
                    this.previousType = HpackDecoder.validateHeader(this.streamId, asciiString, asciiString2, this.previousType);
                }
            } catch (Http2Exception e10) {
                this.validationException = Http2Exception.streamError(this.streamId, Http2Error.PROTOCOL_ERROR, e10, e10.getMessage(), new Object[0]);
            } catch (IllegalArgumentException e11) {
                this.validationException = Http2Exception.streamError(this.streamId, Http2Error.PROTOCOL_ERROR, e11, "Validation failed for header '%s': %s", asciiString, e11.getMessage());
            }
        }

        public void finish() throws Http2Exception {
            if (this.exceededMaxLength) {
                Http2CodecUtil.headerListSizeExceeded(this.streamId, this.maxHeaderListSize, true);
                return;
            }
            Http2Exception http2Exception = this.validationException;
            if (http2Exception != null) {
                throw http2Exception;
            }
        }
    }

    static {
        Http2Error http2Error = Http2Error.COMPRESSION_ERROR;
        Http2Exception.ShutdownHint shutdownHint = Http2Exception.ShutdownHint.HARD_SHUTDOWN;
        DECODE_ULE_128_DECOMPRESSION_EXCEPTION = Http2Exception.newStatic(http2Error, "HPACK - decompression failure", shutdownHint, HpackDecoder.class, "decodeULE128(..)");
        DECODE_ULE_128_TO_LONG_DECOMPRESSION_EXCEPTION = Http2Exception.newStatic(http2Error, "HPACK - long overflow", shutdownHint, HpackDecoder.class, "decodeULE128(..)");
        DECODE_ULE_128_TO_INT_DECOMPRESSION_EXCEPTION = Http2Exception.newStatic(http2Error, "HPACK - int overflow", shutdownHint, HpackDecoder.class, "decodeULE128ToInt(..)");
        DECODE_ILLEGAL_INDEX_VALUE = Http2Exception.newStatic(http2Error, "HPACK - illegal index value", shutdownHint, HpackDecoder.class, "decode(..)");
        INDEX_HEADER_ILLEGAL_INDEX_VALUE = Http2Exception.newStatic(http2Error, "HPACK - illegal index value", shutdownHint, HpackDecoder.class, "indexHeader(..)");
        READ_NAME_ILLEGAL_INDEX_VALUE = Http2Exception.newStatic(http2Error, "HPACK - illegal index value", shutdownHint, HpackDecoder.class, "readName(..)");
        INVALID_MAX_DYNAMIC_TABLE_SIZE = Http2Exception.newStatic(http2Error, "HPACK - invalid max dynamic table size", shutdownHint, HpackDecoder.class, "setDynamicTableSize(..)");
        MAX_DYNAMIC_TABLE_SIZE_CHANGE_REQUIRED = Http2Exception.newStatic(http2Error, "HPACK - max dynamic table size change required", shutdownHint, HpackDecoder.class, "decode(..)");
    }

    public HpackDecoder(long j10) {
        this(j10, 4096);
    }

    private void decodeDynamicTableSizeUpdates(ByteBuf byteBuf) throws Http2Exception {
        while (byteBuf.isReadable()) {
            byte b10 = byteBuf.getByte(byteBuf.readerIndex());
            if ((b10 & 32) != 32 || (b10 & 192) != 0) {
                return;
            }
            byteBuf.readByte();
            int i10 = b10 & c.I;
            if (i10 == 31) {
                setDynamicTableSize(decodeULE128(byteBuf, i10));
            } else {
                setDynamicTableSize(i10);
            }
        }
    }

    public static int decodeULE128(ByteBuf byteBuf, int i10) throws Http2Exception {
        int i11 = byteBuf.readerIndex();
        long jDecodeULE128 = decodeULE128(byteBuf, i10);
        if (jDecodeULE128 <= 2147483647L) {
            return (int) jDecodeULE128;
        }
        byteBuf.readerIndex(i11);
        throw DECODE_ULE_128_TO_INT_DECOMPRESSION_EXCEPTION;
    }

    private HpackHeaderField getIndexedHeader(int i10) throws Http2Exception {
        int i11 = HpackStaticTable.length;
        if (i10 <= i11) {
            return HpackStaticTable.getEntry(i10);
        }
        if (i10 - i11 <= this.hpackDynamicTable.length()) {
            return this.hpackDynamicTable.getEntry(i10 - i11);
        }
        throw INDEX_HEADER_ILLEGAL_INDEX_VALUE;
    }

    private void insertHeader(Http2HeadersSink http2HeadersSink, AsciiString asciiString, AsciiString asciiString2, HpackUtil.IndexType indexType) {
        http2HeadersSink.appendToHeaderList(asciiString, asciiString2);
        int i10 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[indexType.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return;
        }
        if (i10 != 3) {
            throw new Error("should not reach here");
        }
        this.hpackDynamicTable.add(new HpackHeaderField(asciiString, asciiString2));
    }

    private static IllegalArgumentException notEnoughDataException(ByteBuf byteBuf) {
        return new IllegalArgumentException("decode only works with an entire header block! " + byteBuf);
    }

    private AsciiString readName(int i10) throws Http2Exception {
        int i11 = HpackStaticTable.length;
        if (i10 <= i11) {
            return (AsciiString) HpackStaticTable.getEntry(i10).name;
        }
        if (i10 - i11 <= this.hpackDynamicTable.length()) {
            return (AsciiString) this.hpackDynamicTable.getEntry(i10 - i11).name;
        }
        throw READ_NAME_ILLEGAL_INDEX_VALUE;
    }

    private AsciiString readStringLiteral(ByteBuf byteBuf, int i10, boolean z10) throws Http2Exception {
        if (z10) {
            return this.huffmanDecoder.decode(byteBuf, i10);
        }
        byte[] bArr = new byte[i10];
        byteBuf.readBytes(bArr);
        return new AsciiString(bArr, false);
    }

    private void setDynamicTableSize(long j10) throws Http2Exception {
        if (j10 > this.maxDynamicTableSize) {
            throw INVALID_MAX_DYNAMIC_TABLE_SIZE;
        }
        this.encoderMaxDynamicTableSize = j10;
        this.maxDynamicTableSizeChangeRequired = false;
        this.hpackDynamicTable.setCapacity(j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HeaderType validateHeader(int i10, AsciiString asciiString, CharSequence charSequence, HeaderType headerType) throws Http2Exception {
        if (!Http2Headers.PseudoHeaderName.hasPseudoHeaderFormat(asciiString)) {
            if (HttpHeaderValidationUtil.isConnectionHeader(asciiString, true)) {
                throw Http2Exception.streamError(i10, Http2Error.PROTOCOL_ERROR, "Illegal connection-specific header '%s' encountered.", asciiString);
            }
            if (HttpHeaderValidationUtil.isTeNotTrailers(asciiString, charSequence)) {
                throw Http2Exception.streamError(i10, Http2Error.PROTOCOL_ERROR, "Illegal value specified for the 'TE' header (only 'trailers' is allowed).", new Object[0]);
            }
            return HeaderType.REGULAR_HEADER;
        }
        if (headerType == HeaderType.REGULAR_HEADER) {
            throw Http2Exception.streamError(i10, Http2Error.PROTOCOL_ERROR, "Pseudo-header field '%s' found after regular header.", asciiString);
        }
        HeaderType headerType2 = Http2Headers.PseudoHeaderName.getPseudoHeader(asciiString).isRequestOnly() ? HeaderType.REQUEST_PSEUDO_HEADER : HeaderType.RESPONSE_PSEUDO_HEADER;
        if (headerType == null || headerType2 == headerType) {
            return headerType2;
        }
        throw Http2Exception.streamError(i10, Http2Error.PROTOCOL_ERROR, "Mix of request and response pseudo-headers.", new Object[0]);
    }

    public void decode(int i10, ByteBuf byteBuf, Http2Headers http2Headers, boolean z10) throws Http2Exception {
        Http2HeadersSink http2HeadersSink = new Http2HeadersSink(i10, http2Headers, this.maxHeaderListSize, z10);
        decodeDynamicTableSizeUpdates(byteBuf);
        decode(byteBuf, http2HeadersSink);
        http2HeadersSink.finish();
    }

    public HpackHeaderField getHeaderField(int i10) {
        return this.hpackDynamicTable.getEntry(i10 + 1);
    }

    public long getMaxHeaderListSize() {
        return this.maxHeaderListSize;
    }

    public long getMaxHeaderTableSize() {
        return this.hpackDynamicTable.capacity();
    }

    public int length() {
        return this.hpackDynamicTable.length();
    }

    public void setMaxHeaderListSize(long j10) throws Http2Exception {
        if (j10 < 0 || j10 > 4294967295L) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header List Size must be >= %d and <= %d but was %d", 0L, 4294967295L, Long.valueOf(j10));
        }
        this.maxHeaderListSize = j10;
    }

    public void setMaxHeaderTableSize(long j10) throws Http2Exception {
        if (j10 < 0 || j10 > 4294967295L) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header Table Size must be >= %d and <= %d but was %d", 0L, 4294967295L, Long.valueOf(j10));
        }
        this.maxDynamicTableSize = j10;
        if (j10 < this.encoderMaxDynamicTableSize) {
            this.maxDynamicTableSizeChangeRequired = true;
            this.hpackDynamicTable.setCapacity(j10);
        }
    }

    public long size() {
        return this.hpackDynamicTable.size();
    }

    public HpackDecoder(long j10, int i10) {
        this.huffmanDecoder = new HpackHuffmanDecoder();
        this.maxHeaderListSize = ObjectUtil.checkPositive(j10, "maxHeaderListSize");
        long j11 = i10;
        this.encoderMaxDynamicTableSize = j11;
        this.maxDynamicTableSize = j11;
        this.maxDynamicTableSizeChangeRequired = false;
        this.hpackDynamicTable = new HpackDynamicTable(j11);
    }

    private void decode(ByteBuf byteBuf, Http2HeadersSink http2HeadersSink) throws Http2Exception {
        HpackUtil.IndexType indexType = HpackUtil.IndexType.NONE;
        AsciiString name = null;
        int i10 = 0;
        int i11 = 0;
        int length = 0;
        int iDecodeULE128 = 0;
        boolean z10 = false;
        while (byteBuf.isReadable()) {
            switch (i10) {
                case 0:
                    byte b10 = byteBuf.readByte();
                    if (this.maxDynamicTableSizeChangeRequired && (b10 & 224) != 32) {
                        throw MAX_DYNAMIC_TABLE_SIZE_CHANGE_REQUIRED;
                    }
                    if (b10 < 0) {
                        i11 = b10 & 127;
                        if (i11 == 0) {
                            throw DECODE_ILLEGAL_INDEX_VALUE;
                        }
                        if (i11 != 127) {
                            HpackHeaderField indexedHeader = getIndexedHeader(i11);
                            http2HeadersSink.appendToHeaderList((AsciiString) indexedHeader.name, (AsciiString) indexedHeader.value);
                        } else {
                            i10 = 1;
                        }
                    } else {
                        i10 = 3;
                        if ((b10 & t.f12049a) == 64) {
                            indexType = HpackUtil.IndexType.INCREMENTAL;
                            i11 = b10 & h.f6042b;
                            if (i11 != 0) {
                                if (i11 != 63) {
                                    name = readName(i11);
                                    length = name.length();
                                    i10 = 6;
                                } else {
                                    i10 = 2;
                                }
                            }
                        } else if ((b10 & 32) != 32) {
                            indexType = (b10 & c.f1124r) == 16 ? HpackUtil.IndexType.NEVER : HpackUtil.IndexType.NONE;
                            i11 = b10 & c.f1123q;
                            if (i11 != 0) {
                                if (i11 != 15) {
                                    name = readName(i11);
                                    length = name.length();
                                    i10 = 6;
                                } else {
                                    i10 = 2;
                                }
                            }
                        } else {
                            throw Http2Exception.connectionError(Http2Error.COMPRESSION_ERROR, "Dynamic table size update must happen at the beginning of the header block", new Object[0]);
                        }
                    }
                    break;
                    break;
                case 1:
                    HpackHeaderField indexedHeader2 = getIndexedHeader(decodeULE128(byteBuf, i11));
                    http2HeadersSink.appendToHeaderList((AsciiString) indexedHeader2.name, (AsciiString) indexedHeader2.value);
                    i10 = 0;
                    break;
                case 2:
                    name = readName(decodeULE128(byteBuf, i11));
                    length = name.length();
                    i10 = 6;
                    break;
                case 3:
                    byte b11 = byteBuf.readByte();
                    z10 = (b11 & 128) == 128;
                    i11 = b11 & 127;
                    if (i11 == 127) {
                        i10 = 4;
                    } else {
                        length = i11;
                        i10 = 5;
                    }
                    break;
                case 4:
                    length = decodeULE128(byteBuf, i11);
                    i10 = 5;
                    break;
                case 5:
                    if (byteBuf.readableBytes() >= length) {
                        name = readStringLiteral(byteBuf, length, z10);
                        i10 = 6;
                    } else {
                        throw notEnoughDataException(byteBuf);
                    }
                    break;
                case 6:
                    byte b12 = byteBuf.readByte();
                    z10 = (b12 & 128) == 128;
                    i11 = b12 & 127;
                    if (i11 == 0) {
                        insertHeader(http2HeadersSink, name, AsciiString.EMPTY_STRING, indexType);
                        i10 = 0;
                    } else if (i11 != 127) {
                        iDecodeULE128 = i11;
                        i10 = 8;
                    } else {
                        i10 = 7;
                    }
                    break;
                case 7:
                    iDecodeULE128 = decodeULE128(byteBuf, i11);
                    i10 = 8;
                    break;
                case 8:
                    if (byteBuf.readableBytes() >= iDecodeULE128) {
                        insertHeader(http2HeadersSink, name, readStringLiteral(byteBuf, iDecodeULE128, z10), indexType);
                        i10 = 0;
                    } else {
                        throw notEnoughDataException(byteBuf);
                    }
                    break;
                default:
                    throw new Error(a.a("should not reach here state: ", i10));
            }
        }
        if (i10 != 0) {
            throw Http2Exception.connectionError(Http2Error.COMPRESSION_ERROR, "Incomplete header block fragment.", new Object[0]);
        }
    }

    public static long decodeULE128(ByteBuf byteBuf, long j10) throws Http2Exception {
        int i10 = 0;
        boolean z10 = j10 == 0;
        int iWriterIndex = byteBuf.writerIndex();
        int i11 = byteBuf.readerIndex();
        while (i11 < iWriterIndex) {
            byte b10 = byteBuf.getByte(i11);
            if (i10 == 56 && ((b10 & 128) != 0 || (b10 == 127 && !z10))) {
                throw DECODE_ULE_128_TO_LONG_DECOMPRESSION_EXCEPTION;
            }
            if ((b10 & 128) == 0) {
                byteBuf.readerIndex(i11 + 1);
                return j10 + ((((long) b10) & 127) << i10);
            }
            j10 += (((long) b10) & 127) << i10;
            i11++;
            i10 += 7;
        }
        throw DECODE_ULE_128_DECOMPRESSION_EXCEPTION;
    }
}
