package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.PrematureChannelClosureException;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import k.b;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HttpObjectDecoder extends ByteToMessageDecoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final boolean DEFAULT_ALLOW_DUPLICATE_CONTENT_LENGTHS = false;
    public static final boolean DEFAULT_ALLOW_PARTIAL_CHUNKS = true;
    public static final boolean DEFAULT_CHUNKED_SUPPORTED = true;
    public static final int DEFAULT_INITIAL_BUFFER_SIZE = 128;
    public static final int DEFAULT_MAX_CHUNK_SIZE = 8192;
    public static final int DEFAULT_MAX_HEADER_SIZE = 8192;
    public static final int DEFAULT_MAX_INITIAL_LINE_LENGTH = 4096;
    public static final boolean DEFAULT_VALIDATE_HEADERS = true;
    private static final boolean[] ISO_CONTROL_OR_WHITESPACE;
    private static final boolean[] LATIN_WHITESPACE;
    private static final ByteProcessor SKIP_CONTROL_CHARS_BYTES;
    private static final boolean[] SP_LENIENT_BYTES;
    private final boolean allowDuplicateContentLengths;
    private final boolean allowPartialChunks;
    private long chunkSize;
    private final boolean chunkedSupported;
    private long contentLength;
    private State currentState;
    private final HeaderParser headerParser;
    private final LineParser lineParser;
    private final int maxChunkSize;
    private HttpMessage message;
    private AsciiString name;
    private final ByteBuf parserScratchBuffer;
    private final AtomicBoolean resetRequested;
    private LastHttpContent trailer;
    protected final boolean validateHeaders;
    private String value;

    /* JADX INFO: renamed from: io.netty.handler.codec.http.HttpObjectDecoder$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State = iArr;
            try {
                iArr[State.SKIP_CONTROL_CHARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_SIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_INITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_HEADER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_VARIABLE_LENGTH_CONTENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_FIXED_LENGTH_CONTENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNKED_CONTENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_DELIMITER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_FOOTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.BAD_MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.UPGRADED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public static class HeaderParser {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        protected final int maxLength;
        protected final ByteBuf seq;
        int size;

        public HeaderParser(ByteBuf byteBuf, int i10) {
            this.seq = byteBuf;
            this.maxLength = i10;
        }

        public TooLongFrameException newException(int i10) {
            return new TooLongHttpHeaderException(b.a("HTTP header is larger than ", i10, " bytes."));
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0039  */
        public ByteBuf parse(ByteBuf byteBuf) {
            int i10;
            int i11 = byteBuf.readableBytes();
            int i12 = byteBuf.readerIndex();
            int i13 = this.maxLength - this.size;
            int iIndexOf = byteBuf.indexOf(i12, ((int) Math.min(((long) i13) + 2, i11)) + i12, (byte) 10);
            if (iIndexOf == -1) {
                if (i11 <= i13) {
                    return null;
                }
                throw newException(this.maxLength);
            }
            if (iIndexOf > i12) {
                i10 = iIndexOf - 1;
                if (byteBuf.getByte(i10) != 13) {
                    i10 = iIndexOf;
                }
            } else {
                i10 = iIndexOf;
            }
            int i14 = i10 - i12;
            if (i14 == 0) {
                this.seq.clear();
                byteBuf.readerIndex(iIndexOf + 1);
                return this.seq;
            }
            int i15 = this.size + i14;
            int i16 = this.maxLength;
            if (i15 > i16) {
                throw newException(i16);
            }
            this.size = i15;
            this.seq.clear();
            this.seq.writeBytes(byteBuf, i12, i14);
            byteBuf.readerIndex(iIndexOf + 1);
            return this.seq;
        }

        public void reset() {
            this.size = 0;
        }
    }

    public final class LineParser extends HeaderParser {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public LineParser(ByteBuf byteBuf, int i10) {
            super(byteBuf, i10);
        }

        private boolean skipControlChars(ByteBuf byteBuf, int i10, int i11) {
            int iMin = Math.min(this.maxLength, i10);
            int iForEachByte = byteBuf.forEachByte(i11, iMin, HttpObjectDecoder.SKIP_CONTROL_CHARS_BYTES);
            if (iForEachByte != -1) {
                byteBuf.readerIndex(iForEachByte);
                HttpObjectDecoder.this.currentState = State.READ_INITIAL;
                return false;
            }
            byteBuf.skipBytes(iMin);
            int i12 = this.maxLength;
            if (i10 <= i12) {
                return true;
            }
            throw newException(i12);
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder.HeaderParser
        public TooLongFrameException newException(int i10) {
            return new TooLongHttpLineException(b.a("An HTTP line is larger than ", i10, " bytes."));
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder.HeaderParser
        public ByteBuf parse(ByteBuf byteBuf) {
            reset();
            int i10 = byteBuf.readableBytes();
            if (i10 == 0) {
                return null;
            }
            int i11 = byteBuf.readerIndex();
            if (HttpObjectDecoder.this.currentState == State.SKIP_CONTROL_CHARS && skipControlChars(byteBuf, i10, i11)) {
                return null;
            }
            return super.parse(byteBuf);
        }
    }

    public enum State {
        SKIP_CONTROL_CHARS,
        READ_INITIAL,
        READ_HEADER,
        READ_VARIABLE_LENGTH_CONTENT,
        READ_FIXED_LENGTH_CONTENT,
        READ_CHUNK_SIZE,
        READ_CHUNKED_CONTENT,
        READ_CHUNK_DELIMITER,
        READ_CHUNK_FOOTER,
        BAD_MESSAGE,
        UPGRADED
    }

    static {
        boolean[] zArr = new boolean[256];
        SP_LENIENT_BYTES = zArr;
        zArr[160] = true;
        zArr[137] = true;
        zArr[139] = true;
        zArr[140] = true;
        zArr[141] = true;
        LATIN_WHITESPACE = new boolean[256];
        for (byte b10 = -128; b10 < 127; b10 = (byte) (b10 + 1)) {
            LATIN_WHITESPACE[b10 + 128] = Character.isWhitespace(b10);
        }
        ISO_CONTROL_OR_WHITESPACE = new boolean[256];
        for (byte b11 = -128; b11 < 127; b11 = (byte) (b11 + 1)) {
            ISO_CONTROL_OR_WHITESPACE[b11 + 128] = Character.isISOControl(b11) || isWhitespace(b11);
        }
        SKIP_CONTROL_CHARS_BYTES = new ByteProcessor() { // from class: io.netty.handler.codec.http.HttpObjectDecoder.1
            @Override // io.netty.util.ByteProcessor
            public boolean process(byte b12) {
                return HttpObjectDecoder.ISO_CONTROL_OR_WHITESPACE[b12 + 128];
            }
        };
    }

    public HttpObjectDecoder() {
        this(4096, 8192, 8192, true);
    }

    private long contentLength() {
        if (this.contentLength == Long.MIN_VALUE) {
            this.contentLength = HttpUtil.getContentLength(this.message, -1L);
        }
        return this.contentLength;
    }

    private static int findEndOfString(byte[] bArr, int i10, int i11) {
        for (int i12 = i11 - 1; i12 > i10; i12--) {
            if (!isWhitespace(bArr[i12])) {
                return i12 + 1;
            }
        }
        return 0;
    }

    private static int findNonSPLenient(byte[] bArr, int i10, int i11) {
        while (i10 < i11) {
            byte b10 = bArr[i10];
            if (!isSPLenient(b10)) {
                if (isWhitespace(b10)) {
                    throw new IllegalArgumentException("Invalid separator");
                }
                return i10;
            }
            i10++;
        }
        return i11;
    }

    private static int findNonWhitespace(byte[] bArr, int i10, int i11) {
        while (i10 < i11) {
            byte b10 = bArr[i10];
            if (!isWhitespace(b10)) {
                return i10;
            }
            if (!isOWS(b10)) {
                StringBuilder sbA = h.b.a("Invalid separator, only a single space or horizontal tab allowed, but received a '", b10, "' (0x");
                sbA.append(Integer.toHexString(b10));
                sbA.append(")");
                throw new IllegalArgumentException(sbA.toString());
            }
            i10++;
        }
        return i11;
    }

    private static int findSPLenient(byte[] bArr, int i10, int i11) {
        while (i10 < i11) {
            if (isSPLenient(bArr[i10])) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    private static int getChunkSize(byte[] bArr, int i10, int i11) {
        int iSkipWhiteSpaces = skipWhiteSpaces(bArr, i10, i11);
        if (iSkipWhiteSpaces == i11) {
            throw new NumberFormatException();
        }
        int i12 = i10 + iSkipWhiteSpaces;
        int i13 = i11 - iSkipWhiteSpaces;
        int i14 = 0;
        for (int i15 = 0; i15 < i13; i15++) {
            int i16 = i12 + i15;
            int iDecodeHexNibble = StringUtil.decodeHexNibble(bArr[i16]);
            if (iDecodeHexNibble == -1) {
                byte b10 = bArr[i16];
                if (b10 != 59 && !isControlOrWhitespaceAsciiChar(b10)) {
                    throw new NumberFormatException();
                }
                if (i15 != 0) {
                    return i14;
                }
                throw new NumberFormatException();
            }
            i14 = (i14 * 16) + iDecodeHexNibble;
        }
        return i14;
    }

    private HttpContent invalidChunk(ByteBuf byteBuf, Exception exc) {
        this.currentState = State.BAD_MESSAGE;
        byteBuf.skipBytes(byteBuf.readableBytes());
        DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER);
        defaultLastHttpContent.setDecoderResult(DecoderResult.failure(exc));
        this.message = null;
        this.trailer = null;
        return defaultLastHttpContent;
    }

    private HttpMessage invalidMessage(ByteBuf byteBuf, Exception exc) {
        this.currentState = State.BAD_MESSAGE;
        byteBuf.skipBytes(byteBuf.readableBytes());
        if (this.message == null) {
            this.message = createInvalidMessage();
        }
        this.message.setDecoderResult(DecoderResult.failure(exc));
        HttpMessage httpMessage = this.message;
        this.message = null;
        return httpMessage;
    }

    private static boolean isControlOrWhitespaceAsciiChar(byte b10) {
        return ISO_CONTROL_OR_WHITESPACE[b10 + 128];
    }

    private static boolean isOWS(byte b10) {
        return b10 == 32 || b10 == 9;
    }

    private static boolean isSPLenient(byte b10) {
        return SP_LENIENT_BYTES[b10 + 128];
    }

    private static boolean isWhitespace(byte b10) {
        return LATIN_WHITESPACE[b10 + 128];
    }

    private static String langAsciiString(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return "";
        }
        if (i10 == 0) {
            return i11 == bArr.length ? new String(bArr, 0, 0, bArr.length) : new String(bArr, 0, 0, i11);
        }
        return new String(bArr, 0, i10, i11);
    }

    private State readHeaders(ByteBuf byteBuf) {
        HttpMessage httpMessage = this.message;
        HttpHeaders httpHeadersHeaders = httpMessage.headers();
        HeaderParser headerParser = this.headerParser;
        ByteBuf byteBuf2 = headerParser.parse(byteBuf);
        if (byteBuf2 == null) {
            return null;
        }
        int i10 = byteBuf2.readableBytes();
        while (i10 > 0) {
            byte[] bArrArray = byteBuf2.array();
            int iArrayOffset = byteBuf2.readerIndex() + byteBuf2.arrayOffset();
            byte b10 = bArrArray[iArrayOffset];
            AsciiString asciiString = this.name;
            if (asciiString == null || !(b10 == 32 || b10 == 9)) {
                if (asciiString != null) {
                    httpHeadersHeaders.add(asciiString, this.value);
                }
                splitHeader(bArrArray, iArrayOffset, i10);
            } else {
                String strTrim = langAsciiString(bArrArray, iArrayOffset, i10).trim();
                this.value = this.value + ' ' + strTrim;
            }
            byteBuf2 = headerParser.parse(byteBuf);
            if (byteBuf2 == null) {
                return null;
            }
            i10 = byteBuf2.readableBytes();
        }
        AsciiString asciiString2 = this.name;
        if (asciiString2 != null) {
            httpHeadersHeaders.add(asciiString2, this.value);
        }
        this.name = null;
        this.value = null;
        httpMessage.setDecoderResult(new HttpMessageDecoderResult(this.lineParser.size, headerParser.size));
        AsciiString asciiString3 = HttpHeaderNames.CONTENT_LENGTH;
        List<String> all = httpHeadersHeaders.getAll(asciiString3);
        if (!all.isEmpty()) {
            HttpVersion httpVersionProtocolVersion = httpMessage.protocolVersion();
            long jNormalizeAndGetContentLength = HttpUtil.normalizeAndGetContentLength(all, httpVersionProtocolVersion.majorVersion() < 1 || (httpVersionProtocolVersion.majorVersion() == 1 && httpVersionProtocolVersion.minorVersion() == 0), this.allowDuplicateContentLengths);
            this.contentLength = jNormalizeAndGetContentLength;
            if (jNormalizeAndGetContentLength != -1) {
                String strTrim2 = all.get(0).trim();
                if (all.size() > 1 || !strTrim2.equals(Long.toString(this.contentLength))) {
                    httpHeadersHeaders.set(asciiString3, Long.valueOf(this.contentLength));
                }
            }
        }
        if (isContentAlwaysEmpty(httpMessage)) {
            HttpUtil.setTransferEncodingChunked(httpMessage, false);
            return State.SKIP_CONTROL_CHARS;
        }
        if (!HttpUtil.isTransferEncodingChunked(httpMessage)) {
            return contentLength() >= 0 ? State.READ_FIXED_LENGTH_CONTENT : State.READ_VARIABLE_LENGTH_CONTENT;
        }
        if (!all.isEmpty() && httpMessage.protocolVersion() == HttpVersion.HTTP_1_1) {
            handleTransferEncodingChunkedWithContentLength(httpMessage);
        }
        return State.READ_CHUNK_SIZE;
    }

    private LastHttpContent readTrailingHeaders(ByteBuf byteBuf) {
        HeaderParser headerParser = this.headerParser;
        ByteBuf byteBuf2 = headerParser.parse(byteBuf);
        if (byteBuf2 == null) {
            return null;
        }
        LastHttpContent defaultLastHttpContent = this.trailer;
        int i10 = byteBuf2.readableBytes();
        if (i10 == 0 && defaultLastHttpContent == null) {
            return LastHttpContent.EMPTY_LAST_CONTENT;
        }
        if (defaultLastHttpContent == null) {
            defaultLastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER, this.validateHeaders);
            this.trailer = defaultLastHttpContent;
        }
        AsciiString asciiString = null;
        while (i10 > 0) {
            byte[] bArrArray = byteBuf2.array();
            int iArrayOffset = byteBuf2.readerIndex() + byteBuf2.arrayOffset();
            byte b10 = bArrArray[iArrayOffset];
            if (asciiString == null || !(b10 == 32 || b10 == 9)) {
                splitHeader(bArrArray, iArrayOffset, i10);
                AsciiString asciiString2 = this.name;
                if (!HttpHeaderNames.CONTENT_LENGTH.contentEqualsIgnoreCase(asciiString2) && !HttpHeaderNames.TRANSFER_ENCODING.contentEqualsIgnoreCase(asciiString2) && !HttpHeaderNames.TRAILER.contentEqualsIgnoreCase(asciiString2)) {
                    defaultLastHttpContent.trailingHeaders().add(asciiString2, this.value);
                }
                asciiString = this.name;
                this.name = null;
                this.value = null;
            } else {
                List<String> all = defaultLastHttpContent.trailingHeaders().getAll(asciiString);
                if (!all.isEmpty()) {
                    int size = all.size() - 1;
                    String strTrim = langAsciiString(bArrArray, iArrayOffset, byteBuf2.readableBytes()).trim();
                    all.set(size, all.get(size) + strTrim);
                }
            }
            byteBuf2 = headerParser.parse(byteBuf);
            if (byteBuf2 == null) {
                return null;
            }
            i10 = byteBuf2.readableBytes();
        }
        this.trailer = null;
        return defaultLastHttpContent;
    }

    private void resetNow() {
        HttpResponse httpResponse;
        HttpMessage httpMessage = this.message;
        this.message = null;
        this.name = null;
        this.value = null;
        this.contentLength = Long.MIN_VALUE;
        this.lineParser.reset();
        this.headerParser.reset();
        this.trailer = null;
        if (!isDecodingRequest() && (httpResponse = (HttpResponse) httpMessage) != null && isSwitchingToNonHttp1Protocol(httpResponse)) {
            this.currentState = State.UPGRADED;
        } else {
            this.resetRequested.lazySet(false);
            this.currentState = State.SKIP_CONTROL_CHARS;
        }
    }

    private static int skipWhiteSpaces(byte[] bArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (!isWhitespace(bArr[i10 + i12])) {
                return i12;
            }
        }
        return i11;
    }

    private void splitHeader(byte[] bArr, int i10, int i11) {
        byte b10;
        int i12 = i11 + i10;
        int iFindNonWhitespace = findNonWhitespace(bArr, i10, i12);
        boolean zIsDecodingRequest = isDecodingRequest();
        int i13 = iFindNonWhitespace;
        while (i13 < i12 && (b10 = bArr[i13]) != 58 && (zIsDecodingRequest || !isOWS(b10))) {
            i13++;
        }
        if (i13 == i12) {
            throw new IllegalArgumentException("No colon found");
        }
        int i14 = i13;
        while (i14 < i12) {
            if (bArr[i14] == 58) {
                i14++;
                break;
            }
            i14++;
        }
        this.name = splitHeaderName(bArr, iFindNonWhitespace, i13 - iFindNonWhitespace);
        int iFindNonWhitespace2 = findNonWhitespace(bArr, i14, i12);
        if (iFindNonWhitespace2 == i12) {
            this.value = "";
        } else {
            this.value = langAsciiString(bArr, iFindNonWhitespace2, findEndOfString(bArr, i10, i12) - iFindNonWhitespace2);
        }
    }

    private String[] splitInitialLine(ByteBuf byteBuf) {
        byte[] bArrArray = byteBuf.array();
        int iArrayOffset = byteBuf.readerIndex() + byteBuf.arrayOffset();
        int i10 = byteBuf.readableBytes() + iArrayOffset;
        int iFindNonSPLenient = findNonSPLenient(bArrArray, iArrayOffset, i10);
        int iFindSPLenient = findSPLenient(bArrArray, iFindNonSPLenient, i10);
        int iFindNonSPLenient2 = findNonSPLenient(bArrArray, iFindSPLenient, i10);
        int iFindSPLenient2 = findSPLenient(bArrArray, iFindNonSPLenient2, i10);
        int iFindNonSPLenient3 = findNonSPLenient(bArrArray, iFindSPLenient2, i10);
        int iFindEndOfString = findEndOfString(bArrArray, Math.max(iFindNonSPLenient3 - 1, iArrayOffset), i10);
        return new String[]{splitFirstWordInitialLine(bArrArray, iFindNonSPLenient, iFindSPLenient - iFindNonSPLenient), splitSecondWordInitialLine(bArrArray, iFindNonSPLenient2, iFindSPLenient2 - iFindNonSPLenient2), iFindNonSPLenient3 < iFindEndOfString ? splitThirdWordInitialLine(bArrArray, iFindNonSPLenient3, iFindEndOfString - iFindNonSPLenient3) : ""};
    }

    public abstract HttpMessage createInvalidMessage();

    public abstract HttpMessage createMessage(String[] strArr) throws Exception;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x019c A[Catch: Exception -> 0x016e, TRY_LEAVE, TryCatch #1 {Exception -> 0x016e, blocks: (B:72:0x0144, B:75:0x014b, B:79:0x0159, B:83:0x0167, B:88:0x0170, B:90:0x0179, B:92:0x017c, B:94:0x018a, B:96:0x018e, B:98:0x0194, B:99:0x019b, B:100:0x019c), top: B:109:0x0144 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0119 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0100 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x0101  */
    /* JADX WARN: Code duplicated, block: B:60:0x010f  */
    /* JADX WARN: Code duplicated, block: B:63:0x011f A[LOOP:0: B:59:0x010d->B:63:0x011f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:74:0x014a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:75:0x014b A[Catch: Exception -> 0x016e, TryCatch #1 {Exception -> 0x016e, blocks: (B:72:0x0144, B:75:0x014b, B:79:0x0159, B:83:0x0167, B:88:0x0170, B:90:0x0179, B:92:0x017c, B:94:0x018a, B:96:0x018e, B:98:0x0194, B:99:0x019b, B:100:0x019c), top: B:109:0x0144 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0156  */
    /* JADX WARN: Code duplicated, block: B:79:0x0159 A[Catch: Exception -> 0x016e, TryCatch #1 {Exception -> 0x016e, blocks: (B:72:0x0144, B:75:0x014b, B:79:0x0159, B:83:0x0167, B:88:0x0170, B:90:0x0179, B:92:0x017c, B:94:0x018a, B:96:0x018e, B:98:0x0194, B:99:0x019b, B:100:0x019c), top: B:109:0x0144 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0179 A[Catch: Exception -> 0x016e, TryCatch #1 {Exception -> 0x016e, blocks: (B:72:0x0144, B:75:0x014b, B:79:0x0159, B:83:0x0167, B:88:0x0170, B:90:0x0179, B:92:0x017c, B:94:0x018a, B:96:0x018e, B:98:0x0194, B:99:0x019b, B:100:0x019c), top: B:109:0x0144 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x018a A[Catch: Exception -> 0x016e, TryCatch #1 {Exception -> 0x016e, blocks: (B:72:0x0144, B:75:0x014b, B:79:0x0159, B:83:0x0167, B:88:0x0170, B:90:0x0179, B:92:0x017c, B:94:0x018a, B:96:0x018e, B:98:0x0194, B:99:0x019b, B:100:0x019c), top: B:109:0x0144 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x018e A[Catch: Exception -> 0x016e, TryCatch #1 {Exception -> 0x016e, blocks: (B:72:0x0144, B:75:0x014b, B:79:0x0159, B:83:0x0167, B:88:0x0170, B:90:0x0179, B:92:0x017c, B:94:0x018a, B:96:0x018e, B:98:0x0194, B:99:0x019b, B:100:0x019c), top: B:109:0x0144 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0194 A[Catch: Exception -> 0x016e, TryCatch #1 {Exception -> 0x016e, blocks: (B:72:0x0144, B:75:0x014b, B:79:0x0159, B:83:0x0167, B:88:0x0170, B:90:0x0179, B:92:0x017c, B:94:0x018a, B:96:0x018e, B:98:0x0194, B:99:0x019b, B:100:0x019c), top: B:109:0x0144 }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        State headers;
        int i10;
        long jContentLength;
        int iWriterIndex;
        int i11;
        int i12;
        int iMin;
        if (this.resetRequested.get()) {
            resetNow();
        }
        int[] iArr = AnonymousClass2.$SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State;
        switch (iArr[this.currentState.ordinal()]) {
            case 1:
            case 3:
                try {
                    ByteBuf byteBuf2 = this.lineParser.parse(byteBuf);
                    if (byteBuf2 == null) {
                        return;
                    }
                    this.message = createMessage(splitInitialLine(byteBuf2));
                    this.currentState = State.READ_HEADER;
                    try {
                        headers = readHeaders(byteBuf);
                        if (headers == null) {
                            return;
                        }
                        this.currentState = headers;
                        i10 = iArr[headers.ordinal()];
                        if (i10 != 1) {
                            list.add(this.message);
                            list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                            resetNow();
                            return;
                        }
                        if (i10 != 2) {
                            if (this.chunkedSupported) {
                                throw new IllegalArgumentException("Chunked messages not supported");
                            }
                            list.add(this.message);
                            return;
                        }
                        jContentLength = contentLength();
                        if (jContentLength != 0 && (jContentLength != -1 || !isDecodingRequest())) {
                            list.add(this.message);
                            if (headers == State.READ_FIXED_LENGTH_CONTENT) {
                                this.chunkSize = jContentLength;
                                return;
                            }
                            return;
                        }
                        list.add(this.message);
                        list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                        resetNow();
                        return;
                    } catch (Exception e10) {
                        list.add(invalidMessage(byteBuf, e10));
                        return;
                    }
                } catch (Exception e11) {
                    list.add(invalidMessage(byteBuf, e11));
                    return;
                }
            case 2:
                try {
                    ByteBuf byteBuf3 = this.lineParser.parse(byteBuf);
                    if (byteBuf3 == null) {
                        return;
                    }
                    int chunkSize = getChunkSize(byteBuf3.array(), byteBuf3.arrayOffset() + byteBuf3.readerIndex(), byteBuf3.readableBytes());
                    this.chunkSize = chunkSize;
                    if (chunkSize == 0) {
                        this.currentState = State.READ_CHUNK_FOOTER;
                        return;
                    }
                    this.currentState = State.READ_CHUNKED_CONTENT;
                    int iMin2 = Math.min((int) this.chunkSize, this.maxChunkSize);
                    if ((!this.allowPartialChunks || byteBuf.readableBytes() >= iMin2) && (iMin = Math.min(iMin2, byteBuf.readableBytes())) != 0) {
                        DefaultHttpContent defaultHttpContent = new DefaultHttpContent(byteBuf.readRetainedSlice(iMin));
                        this.chunkSize -= (long) iMin;
                        list.add(defaultHttpContent);
                        if (this.chunkSize != 0) {
                            return;
                        }
                        this.currentState = State.READ_CHUNK_DELIMITER;
                        iWriterIndex = byteBuf.writerIndex();
                        i11 = byteBuf.readerIndex();
                        while (iWriterIndex > i11) {
                            i12 = i11 + 1;
                            if (byteBuf.getByte(i11) == 10) {
                                this.currentState = State.READ_CHUNK_SIZE;
                                i11 = i12;
                                byteBuf.readerIndex(i11);
                                return;
                            }
                            i11 = i12;
                        }
                        byteBuf.readerIndex(i11);
                        return;
                    }
                    return;
                } catch (Exception e12) {
                    list.add(invalidChunk(byteBuf, e12));
                    return;
                }
            case 4:
                headers = readHeaders(byteBuf);
                if (headers == null) {
                    return;
                }
                this.currentState = headers;
                i10 = iArr[headers.ordinal()];
                if (i10 != 1) {
                    list.add(this.message);
                    list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                    resetNow();
                    return;
                }
                if (i10 != 2) {
                    if (this.chunkedSupported) {
                        throw new IllegalArgumentException("Chunked messages not supported");
                    }
                    list.add(this.message);
                    return;
                }
                jContentLength = contentLength();
                if (jContentLength != 0) {
                    list.add(this.message);
                    if (headers == State.READ_FIXED_LENGTH_CONTENT) {
                        this.chunkSize = jContentLength;
                        return;
                    }
                    return;
                }
                list.add(this.message);
                list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                resetNow();
                return;
            case 5:
                int iMin3 = Math.min(byteBuf.readableBytes(), this.maxChunkSize);
                if (iMin3 > 0) {
                    list.add(new DefaultHttpContent(byteBuf.readRetainedSlice(iMin3)));
                    return;
                }
                return;
            case 6:
                int i13 = byteBuf.readableBytes();
                if (i13 == 0) {
                    return;
                }
                int iMin4 = Math.min(i13, this.maxChunkSize);
                long j10 = iMin4;
                long j11 = this.chunkSize;
                if (j10 > j11) {
                    iMin4 = (int) j11;
                }
                ByteBuf retainedSlice = byteBuf.readRetainedSlice(iMin4);
                long j12 = this.chunkSize - ((long) iMin4);
                this.chunkSize = j12;
                if (j12 != 0) {
                    list.add(new DefaultHttpContent(retainedSlice));
                    return;
                } else {
                    list.add(new DefaultLastHttpContent(retainedSlice, this.validateHeaders));
                    resetNow();
                    return;
                }
            case 7:
                int iMin5 = Math.min((int) this.chunkSize, this.maxChunkSize);
                if (this.allowPartialChunks) {
                    break;
                }
                DefaultHttpContent defaultHttpContent2 = new DefaultHttpContent(byteBuf.readRetainedSlice(iMin));
                this.chunkSize -= (long) iMin;
                list.add(defaultHttpContent2);
                if (this.chunkSize != 0) {
                    return;
                }
                this.currentState = State.READ_CHUNK_DELIMITER;
                iWriterIndex = byteBuf.writerIndex();
                i11 = byteBuf.readerIndex();
                while (iWriterIndex > i11) {
                    i12 = i11 + 1;
                    if (byteBuf.getByte(i11) == 10) {
                        this.currentState = State.READ_CHUNK_SIZE;
                        i11 = i12;
                        byteBuf.readerIndex(i11);
                        return;
                    }
                    i11 = i12;
                }
                byteBuf.readerIndex(i11);
                return;
            case 8:
                iWriterIndex = byteBuf.writerIndex();
                i11 = byteBuf.readerIndex();
                while (iWriterIndex > i11) {
                    i12 = i11 + 1;
                    if (byteBuf.getByte(i11) == 10) {
                        this.currentState = State.READ_CHUNK_SIZE;
                        i11 = i12;
                        byteBuf.readerIndex(i11);
                        return;
                    }
                    i11 = i12;
                }
                byteBuf.readerIndex(i11);
                return;
            case 9:
                try {
                    LastHttpContent trailingHeaders = readTrailingHeaders(byteBuf);
                    if (trailingHeaders == null) {
                        return;
                    }
                    list.add(trailingHeaders);
                    resetNow();
                    return;
                } catch (Exception e13) {
                    list.add(invalidChunk(byteBuf, e13));
                    return;
                }
            case 10:
                byteBuf.skipBytes(byteBuf.readableBytes());
                return;
            case 11:
                int i14 = byteBuf.readableBytes();
                if (i14 > 0) {
                    list.add(byteBuf.readBytes(i14));
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        super.decodeLast(channelHandlerContext, byteBuf, list);
        if (this.resetRequested.get()) {
            resetNow();
        }
        HttpMessage httpMessage = this.message;
        if (httpMessage != null) {
            boolean zIsTransferEncodingChunked = HttpUtil.isTransferEncodingChunked(httpMessage);
            if (this.currentState == State.READ_VARIABLE_LENGTH_CONTENT && !byteBuf.isReadable() && !zIsTransferEncodingChunked) {
                list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                resetNow();
            } else {
                if (this.currentState == State.READ_HEADER) {
                    list.add(invalidMessage(Unpooled.EMPTY_BUFFER, new PrematureChannelClosureException("Connection closed before received headers")));
                    resetNow();
                    return;
                }
                if (!isDecodingRequest() && !zIsTransferEncodingChunked && contentLength() <= 0) {
                    list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                }
                resetNow();
            }
        }
    }

    public void handleTransferEncodingChunkedWithContentLength(HttpMessage httpMessage) {
        httpMessage.headers().remove(HttpHeaderNames.CONTENT_LENGTH);
        this.contentLength = Long.MIN_VALUE;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            this.parserScratchBuffer.release();
        } finally {
            super.handlerRemoved0(channelHandlerContext);
        }
    }

    public boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
        if (!(httpMessage instanceof HttpResponse)) {
            return false;
        }
        HttpResponse httpResponse = (HttpResponse) httpMessage;
        HttpResponseStatus httpResponseStatusStatus = httpResponse.status();
        int iCode = httpResponseStatusStatus.code();
        if (httpResponseStatusStatus.codeClass() == HttpStatusClass.INFORMATIONAL) {
            return (iCode == 101 && !httpResponse.headers().contains(HttpHeaderNames.SEC_WEBSOCKET_ACCEPT) && httpResponse.headers().contains((CharSequence) HttpHeaderNames.UPGRADE, (CharSequence) HttpHeaderValues.WEBSOCKET, true)) ? false : true;
        }
        return iCode == 204 || iCode == 304;
    }

    public abstract boolean isDecodingRequest();

    public boolean isSwitchingToNonHttp1Protocol(HttpResponse httpResponse) {
        if (httpResponse.status().code() != HttpResponseStatus.SWITCHING_PROTOCOLS.code()) {
            return false;
        }
        String str = httpResponse.headers().get(HttpHeaderNames.UPGRADE);
        return str == null || !(str.contains(HttpVersion.HTTP_1_0.text()) || str.contains(HttpVersion.HTTP_1_1.text()));
    }

    public void reset() {
        this.resetRequested.lazySet(true);
    }

    public String splitFirstWordInitialLine(byte[] bArr, int i10, int i11) {
        return langAsciiString(bArr, i10, i11);
    }

    public AsciiString splitHeaderName(byte[] bArr, int i10, int i11) {
        return new AsciiString(bArr, i10, i11, true);
    }

    public String splitSecondWordInitialLine(byte[] bArr, int i10, int i11) {
        return langAsciiString(bArr, i10, i11);
    }

    public String splitThirdWordInitialLine(byte[] bArr, int i10, int i11) {
        return langAsciiString(bArr, i10, i11);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        int i10;
        if ((obj instanceof HttpExpectationFailedEvent) && ((i10 = AnonymousClass2.$SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[this.currentState.ordinal()]) == 2 || i10 == 5 || i10 == 6)) {
            reset();
        }
        super.userEventTriggered(channelHandlerContext, obj);
    }

    public HttpObjectDecoder(int i10, int i11, int i12, boolean z10) {
        this(i10, i11, i12, z10, true);
    }

    public HttpObjectDecoder(int i10, int i11, int i12, boolean z10, boolean z11) {
        this(i10, i11, i12, z10, z11, 128);
    }

    public HttpObjectDecoder(int i10, int i11, int i12, boolean z10, boolean z11, int i13) {
        this(i10, i11, i12, z10, z11, i13, false);
    }

    public HttpObjectDecoder(int i10, int i11, int i12, boolean z10, boolean z11, int i13, boolean z12) {
        this(i10, i11, i12, z10, z11, i13, z12, true);
    }

    public HttpObjectDecoder(int i10, int i11, int i12, boolean z10, boolean z11, int i13, boolean z12, boolean z13) {
        this.contentLength = Long.MIN_VALUE;
        this.resetRequested = new AtomicBoolean();
        this.currentState = State.SKIP_CONTROL_CHARS;
        ObjectUtil.checkPositive(i10, "maxInitialLineLength");
        ObjectUtil.checkPositive(i11, "maxHeaderSize");
        ObjectUtil.checkPositive(i12, "maxChunkSize");
        ByteBuf byteBufBuffer = Unpooled.buffer(i13);
        this.parserScratchBuffer = byteBufBuffer;
        this.lineParser = new LineParser(byteBufBuffer, i10);
        this.headerParser = new HeaderParser(byteBufBuffer, i11);
        this.maxChunkSize = i12;
        this.chunkedSupported = z10;
        this.validateHeaders = z11;
        this.allowDuplicateContentLengths = z12;
        this.allowPartialChunks = z13;
    }
}
