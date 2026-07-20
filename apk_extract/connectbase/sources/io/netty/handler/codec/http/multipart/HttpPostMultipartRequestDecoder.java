package io.netty.handler.codec.http.multipart;

import fl.h;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kl.f;
import ks.g;
import m.a;

/* JADX INFO: loaded from: classes3.dex */
public class HttpPostMultipartRequestDecoder implements InterfaceHttpPostRequestDecoder {
    private static final String FILENAME_ENCODED = HttpHeaderValues.FILENAME.toString() + f.f9277j;
    private final List<InterfaceHttpData> bodyListHttpData;
    private int bodyListHttpDataRank;
    private final Map<String, List<InterfaceHttpData>> bodyMapHttpData;
    private Charset charset;
    private Attribute currentAttribute;
    private Map<CharSequence, Attribute> currentFieldAttributes;
    private FileUpload currentFileUpload;
    private HttpPostRequestDecoder.MultiPartStatus currentStatus;
    private boolean destroyed;
    private int discardThreshold;
    private final HttpDataFactory factory;
    private boolean isLastChunk;
    private final String multipartDataBoundary;
    private String multipartMixedBoundary;
    private final HttpRequest request;
    private ByteBuf undecodedChunk;

    /* JADX INFO: renamed from: io.netty.handler.codec.http.multipart.HttpPostMultipartRequestDecoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus;

        static {
            int[] iArr = new int[HttpPostRequestDecoder.MultiPartStatus.values().length];
            $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus = iArr;
            try {
                iArr[HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.PREAMBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.DISPOSITION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.FIELD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.FILEUPLOAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.MIXEDDELIMITER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.MIXEDDISPOSITION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.MIXEDFILEUPLOAD.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.EPILOGUE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public HttpPostMultipartRequestDecoder(HttpRequest httpRequest) {
        this(new DefaultHttpDataFactory(16384L), httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    private void checkDestroyed() {
        if (this.destroyed) {
            throw new IllegalStateException("HttpPostMultipartRequestDecoder was destroyed already");
        }
    }

    private void cleanMixedAttributes() {
        this.currentFieldAttributes.remove(HttpHeaderValues.CHARSET);
        this.currentFieldAttributes.remove(HttpHeaderNames.CONTENT_LENGTH);
        this.currentFieldAttributes.remove(HttpHeaderNames.CONTENT_TRANSFER_ENCODING);
        this.currentFieldAttributes.remove(HttpHeaderNames.CONTENT_TYPE);
        this.currentFieldAttributes.remove(HttpHeaderValues.FILENAME);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002c  */
    private static String cleanString(String str) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(length);
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\t') {
                sb2.append(' ');
            } else if (cCharAt != '\"') {
                if (cCharAt == ',' || cCharAt == '=' || cCharAt == ':' || cCharAt == ';') {
                    sb2.append(' ');
                } else {
                    sb2.append(cCharAt);
                }
            }
        }
        return sb2.toString().trim();
    }

    private InterfaceHttpData decodeMultipart(HttpPostRequestDecoder.MultiPartStatus multiPartStatus) {
        Charset charsetForName;
        long j10;
        switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[multiPartStatus.ordinal()]) {
            case 1:
                throw new HttpPostRequestDecoder.ErrorDataDecoderException("Should not be called with the current getStatus");
            case 2:
                throw new HttpPostRequestDecoder.ErrorDataDecoderException("Should not be called with the current getStatus");
            case 3:
                return findMultipartDelimiter(this.multipartDataBoundary, HttpPostRequestDecoder.MultiPartStatus.DISPOSITION, HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE);
            case 4:
                return findMultipartDisposition();
            case 5:
                Attribute attribute = this.currentFieldAttributes.get(HttpHeaderValues.CHARSET);
                if (attribute != null) {
                    try {
                        charsetForName = Charset.forName(attribute.getValue());
                    } catch (IOException e10) {
                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e10);
                    } catch (UnsupportedCharsetException e11) {
                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e11);
                    }
                    break;
                } else {
                    charsetForName = null;
                }
                Attribute attribute2 = this.currentFieldAttributes.get(HttpHeaderValues.NAME);
                if (this.currentAttribute == null) {
                    Attribute attribute3 = this.currentFieldAttributes.get(HttpHeaderNames.CONTENT_LENGTH);
                    if (attribute3 != null) {
                        try {
                            j10 = Long.parseLong(attribute3.getValue());
                        } catch (IOException e12) {
                            throw new HttpPostRequestDecoder.ErrorDataDecoderException(e12);
                        } catch (NumberFormatException unused) {
                            j10 = 0;
                        }
                    } else {
                        j10 = 0;
                    }
                    try {
                        if (j10 > 0) {
                            this.currentAttribute = this.factory.createAttribute(this.request, cleanString(attribute2.getValue()), j10);
                        } else {
                            this.currentAttribute = this.factory.createAttribute(this.request, cleanString(attribute2.getValue()));
                        }
                        if (charsetForName != null) {
                            this.currentAttribute.setCharset(charsetForName);
                        }
                    } catch (IOException e13) {
                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e13);
                    } catch (IllegalArgumentException e14) {
                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e14);
                    } catch (NullPointerException e15) {
                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e15);
                    }
                    break;
                }
                if (!loadDataMultipartOptimized(this.undecodedChunk, this.multipartDataBoundary, this.currentAttribute)) {
                    return null;
                }
                Attribute attribute4 = this.currentAttribute;
                this.currentAttribute = null;
                this.currentFieldAttributes = null;
                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER;
                return attribute4;
            case 6:
                return getFileUpload(this.multipartDataBoundary);
            case 7:
                return findMultipartDelimiter(this.multipartMixedBoundary, HttpPostRequestDecoder.MultiPartStatus.MIXEDDISPOSITION, HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER);
            case 8:
                return findMultipartDisposition();
            case 9:
                return getFileUpload(this.multipartMixedBoundary);
            case 10:
            case 11:
                return null;
            default:
                throw new HttpPostRequestDecoder.ErrorDataDecoderException("Shouldn't reach here.");
        }
    }

    private InterfaceHttpData findMultipartDelimiter(String str, HttpPostRequestDecoder.MultiPartStatus multiPartStatus, HttpPostRequestDecoder.MultiPartStatus multiPartStatus2) {
        int i10 = this.undecodedChunk.readerIndex();
        try {
            skipControlCharacters(this.undecodedChunk);
            skipOneLine();
            try {
                String delimiterOptimized = readDelimiterOptimized(this.undecodedChunk, str, this.charset);
                if (delimiterOptimized.equals(str)) {
                    this.currentStatus = multiPartStatus;
                    return decodeMultipart(multiPartStatus);
                }
                if (!delimiterOptimized.equals(str + "--")) {
                    this.undecodedChunk.readerIndex(i10);
                    throw new HttpPostRequestDecoder.ErrorDataDecoderException("No Multipart delimiter found");
                }
                this.currentStatus = multiPartStatus2;
                HttpPostRequestDecoder.MultiPartStatus multiPartStatus3 = HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER;
                if (multiPartStatus2 != multiPartStatus3) {
                    return null;
                }
                this.currentFieldAttributes = null;
                return decodeMultipart(multiPartStatus3);
            } catch (HttpPostRequestDecoder.NotEnoughDataDecoderException unused) {
                this.undecodedChunk.readerIndex(i10);
                return null;
            }
        } catch (HttpPostRequestDecoder.NotEnoughDataDecoderException unused2) {
            this.undecodedChunk.readerIndex(i10);
            return null;
        }
    }

    private InterfaceHttpData findMultipartDisposition() {
        int i10 = this.undecodedChunk.readerIndex();
        if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.DISPOSITION) {
            this.currentFieldAttributes = new TreeMap(CaseIgnoringComparator.INSTANCE);
        }
        while (!skipOneLine()) {
            try {
                skipControlCharacters(this.undecodedChunk);
                String[] strArrSplitMultipartHeader = splitMultipartHeader(readLineOptimized(this.undecodedChunk, this.charset));
                if (HttpHeaderNames.CONTENT_DISPOSITION.contentEqualsIgnoreCase(strArrSplitMultipartHeader[0])) {
                    if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.DISPOSITION ? HttpHeaderValues.FORM_DATA.contentEqualsIgnoreCase(strArrSplitMultipartHeader[1]) : HttpHeaderValues.ATTACHMENT.contentEqualsIgnoreCase(strArrSplitMultipartHeader[1]) || HttpHeaderValues.FILE.contentEqualsIgnoreCase(strArrSplitMultipartHeader[1])) {
                        for (int i11 = 2; i11 < strArrSplitMultipartHeader.length; i11++) {
                            try {
                                Attribute contentDispositionAttribute = getContentDispositionAttribute(strArrSplitMultipartHeader[i11].split("=", 2));
                                this.currentFieldAttributes.put(contentDispositionAttribute.getName(), contentDispositionAttribute);
                            } catch (IllegalArgumentException e10) {
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e10);
                            } catch (NullPointerException e11) {
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e11);
                            }
                        }
                    } else {
                        continue;
                    }
                } else {
                    AsciiString asciiString = HttpHeaderNames.CONTENT_TRANSFER_ENCODING;
                    if (asciiString.contentEqualsIgnoreCase(strArrSplitMultipartHeader[0])) {
                        try {
                            this.currentFieldAttributes.put(asciiString, this.factory.createAttribute(this.request, asciiString.toString(), cleanString(strArrSplitMultipartHeader[1])));
                        } catch (IllegalArgumentException e12) {
                            throw new HttpPostRequestDecoder.ErrorDataDecoderException(e12);
                        } catch (NullPointerException e13) {
                            throw new HttpPostRequestDecoder.ErrorDataDecoderException(e13);
                        }
                    } else {
                        AsciiString asciiString2 = HttpHeaderNames.CONTENT_LENGTH;
                        if (asciiString2.contentEqualsIgnoreCase(strArrSplitMultipartHeader[0])) {
                            try {
                                this.currentFieldAttributes.put(asciiString2, this.factory.createAttribute(this.request, asciiString2.toString(), cleanString(strArrSplitMultipartHeader[1])));
                            } catch (IllegalArgumentException e14) {
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e14);
                            } catch (NullPointerException e15) {
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e15);
                            }
                        } else if (!HttpHeaderNames.CONTENT_TYPE.contentEqualsIgnoreCase(strArrSplitMultipartHeader[0])) {
                            continue;
                        } else {
                            if (HttpHeaderValues.MULTIPART_MIXED.contentEqualsIgnoreCase(strArrSplitMultipartHeader[1])) {
                                if (this.currentStatus != HttpPostRequestDecoder.MultiPartStatus.DISPOSITION) {
                                    throw new HttpPostRequestDecoder.ErrorDataDecoderException("Mixed Multipart found in a previous Mixed Multipart");
                                }
                                this.multipartMixedBoundary = a.a("--", StringUtil.substringAfter(strArrSplitMultipartHeader[2], h.f6043c));
                                HttpPostRequestDecoder.MultiPartStatus multiPartStatus = HttpPostRequestDecoder.MultiPartStatus.MIXEDDELIMITER;
                                this.currentStatus = multiPartStatus;
                                return decodeMultipart(multiPartStatus);
                            }
                            for (int i12 = 1; i12 < strArrSplitMultipartHeader.length; i12++) {
                                AsciiString asciiString3 = HttpHeaderValues.CHARSET;
                                String string = asciiString3.toString();
                                if (strArrSplitMultipartHeader[i12].regionMatches(true, 0, string, 0, string.length())) {
                                    try {
                                        this.currentFieldAttributes.put(asciiString3, this.factory.createAttribute(this.request, string, cleanString(StringUtil.substringAfter(strArrSplitMultipartHeader[i12], h.f6043c))));
                                    } catch (IllegalArgumentException e16) {
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e16);
                                    } catch (NullPointerException e17) {
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e17);
                                    }
                                } else if (strArrSplitMultipartHeader[i12].contains("=")) {
                                    String strSubstringBefore = StringUtil.substringBefore(strArrSplitMultipartHeader[i12], h.f6043c);
                                    try {
                                        this.currentFieldAttributes.put(strSubstringBefore, this.factory.createAttribute(this.request, cleanString(strSubstringBefore), StringUtil.substringAfter(strArrSplitMultipartHeader[i12], h.f6043c)));
                                    } catch (IllegalArgumentException e18) {
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e18);
                                    } catch (NullPointerException e19) {
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e19);
                                    }
                                } else {
                                    try {
                                        Attribute attributeCreateAttribute = this.factory.createAttribute(this.request, cleanString(strArrSplitMultipartHeader[0]), strArrSplitMultipartHeader[i12]);
                                        this.currentFieldAttributes.put(attributeCreateAttribute.getName(), attributeCreateAttribute);
                                    } catch (IllegalArgumentException e20) {
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e20);
                                    } catch (NullPointerException e21) {
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e21);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (HttpPostRequestDecoder.NotEnoughDataDecoderException unused) {
                this.undecodedChunk.readerIndex(i10);
                return null;
            }
        }
        Attribute attribute = this.currentFieldAttributes.get(HttpHeaderValues.FILENAME);
        if (this.currentStatus != HttpPostRequestDecoder.MultiPartStatus.DISPOSITION) {
            if (attribute == null) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException("Filename not found");
            }
            HttpPostRequestDecoder.MultiPartStatus multiPartStatus2 = HttpPostRequestDecoder.MultiPartStatus.MIXEDFILEUPLOAD;
            this.currentStatus = multiPartStatus2;
            return decodeMultipart(multiPartStatus2);
        }
        if (attribute != null) {
            HttpPostRequestDecoder.MultiPartStatus multiPartStatus3 = HttpPostRequestDecoder.MultiPartStatus.FILEUPLOAD;
            this.currentStatus = multiPartStatus3;
            return decodeMultipart(multiPartStatus3);
        }
        HttpPostRequestDecoder.MultiPartStatus multiPartStatus4 = HttpPostRequestDecoder.MultiPartStatus.FIELD;
        this.currentStatus = multiPartStatus4;
        return decodeMultipart(multiPartStatus4);
    }

    private Attribute getContentDispositionAttribute(String... strArr) {
        String strCleanString = cleanString(strArr[0]);
        String strDecodeComponent = strArr[1];
        AsciiString asciiString = HttpHeaderValues.FILENAME;
        if (asciiString.contentEquals(strCleanString)) {
            int length = strDecodeComponent.length() - 1;
            if (length > 0 && strDecodeComponent.charAt(0) == '\"' && strDecodeComponent.charAt(length) == '\"') {
                strDecodeComponent = strDecodeComponent.substring(1, length);
            }
        } else if (FILENAME_ENCODED.equals(strCleanString)) {
            try {
                strCleanString = asciiString.toString();
                String[] strArrSplit = cleanString(strDecodeComponent).split("'", 3);
                strDecodeComponent = QueryStringDecoder.decodeComponent(strArrSplit[2], Charset.forName(strArrSplit[0]));
            } catch (ArrayIndexOutOfBoundsException e10) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e10);
            } catch (UnsupportedCharsetException e11) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e11);
            }
        } else {
            strDecodeComponent = cleanString(strDecodeComponent);
        }
        return this.factory.createAttribute(this.request, strCleanString, strDecodeComponent);
    }

    private static boolean loadDataMultipartOptimized(ByteBuf byteBuf, String str, HttpData httpData) {
        if (!byteBuf.isReadable()) {
            return false;
        }
        int i10 = byteBuf.readerIndex();
        byte[] bytes = str.getBytes(httpData.getCharset());
        int iFindDelimiter = HttpPostBodyUtil.findDelimiter(byteBuf, i10, bytes, true);
        if (iFindDelimiter >= 0) {
            try {
                httpData.addContent(byteBuf.copy(i10, iFindDelimiter), true);
                rewriteCurrentBuffer(byteBuf, iFindDelimiter);
                return true;
            } catch (IOException e10) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e10);
            }
        }
        int i11 = byteBuf.readableBytes();
        int length = (i11 - bytes.length) - 1;
        if (length < 0) {
            length = 0;
        }
        int iFindLastLineBreak = HttpPostBodyUtil.findLastLineBreak(byteBuf, i10 + length);
        if (iFindLastLineBreak < 0 && httpData.definedLength() == (httpData.length() + ((long) i11)) - 1 && byteBuf.getByte((i11 + i10) - 1) == 13) {
            iFindLastLineBreak = i11 - 1;
            length = 0;
        }
        if (iFindLastLineBreak < 0) {
            try {
                httpData.addContent(byteBuf.copy(), false);
                byteBuf.readerIndex(i10);
                byteBuf.writerIndex(i10);
                return false;
            } catch (IOException e11) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e11);
            }
        }
        int i12 = iFindLastLineBreak + length;
        if (i12 == 0) {
            return false;
        }
        try {
            httpData.addContent(byteBuf.copy(i10, i12), false);
            rewriteCurrentBuffer(byteBuf, i12);
            return false;
        } catch (IOException e12) {
            throw new HttpPostRequestDecoder.ErrorDataDecoderException(e12);
        }
    }

    private void parseBody() {
        HttpPostRequestDecoder.MultiPartStatus multiPartStatus = this.currentStatus;
        if (multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE && multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.EPILOGUE) {
            parseBodyMultipart();
        } else if (this.isLastChunk) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
        }
    }

    private void parseBodyMultipart() {
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf == null || byteBuf.readableBytes() == 0) {
            return;
        }
        InterfaceHttpData interfaceHttpDataDecodeMultipart = decodeMultipart(this.currentStatus);
        while (interfaceHttpDataDecodeMultipart != null) {
            addHttpData(interfaceHttpDataDecodeMultipart);
            HttpPostRequestDecoder.MultiPartStatus multiPartStatus = this.currentStatus;
            if (multiPartStatus == HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE || multiPartStatus == HttpPostRequestDecoder.MultiPartStatus.EPILOGUE) {
                return;
            } else {
                interfaceHttpDataDecodeMultipart = decodeMultipart(multiPartStatus);
            }
        }
    }

    private static String readDelimiterOptimized(ByteBuf byteBuf, String str, Charset charset) {
        int i10 = byteBuf.readerIndex();
        byte[] bytes = str.getBytes(charset);
        int length = bytes.length;
        try {
            int iFindDelimiter = HttpPostBodyUtil.findDelimiter(byteBuf, i10, bytes, false);
            if (iFindDelimiter < 0) {
                byteBuf.readerIndex(i10);
                throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
            }
            StringBuilder sb2 = new StringBuilder(str);
            byteBuf.readerIndex(iFindDelimiter + i10 + length);
            if (byteBuf.isReadable()) {
                byte b10 = byteBuf.readByte();
                if (b10 == 13) {
                    if (byteBuf.readByte() == 10) {
                        return sb2.toString();
                    }
                    byteBuf.readerIndex(i10);
                    throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                }
                if (b10 == 10) {
                    return sb2.toString();
                }
                if (b10 == 45) {
                    sb2.append("--");
                    if (byteBuf.readByte() == 45) {
                        if (!byteBuf.isReadable()) {
                            return sb2.toString();
                        }
                        byte b11 = byteBuf.readByte();
                        if (b11 == 13) {
                            if (byteBuf.readByte() == 10) {
                                return sb2.toString();
                            }
                            byteBuf.readerIndex(i10);
                            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                        }
                        if (b11 == 10) {
                            return sb2.toString();
                        }
                        byteBuf.readerIndex(byteBuf.readerIndex() - 1);
                        return sb2.toString();
                    }
                }
            }
            byteBuf.readerIndex(i10);
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
        } catch (IndexOutOfBoundsException e10) {
            byteBuf.readerIndex(i10);
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException(e10);
        }
    }

    private static String readLineOptimized(ByteBuf byteBuf, Charset charset) {
        int i10 = byteBuf.readerIndex();
        try {
            if (!byteBuf.isReadable()) {
                byteBuf.readerIndex(i10);
                throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
            }
            int iFindLineBreak = HttpPostBodyUtil.findLineBreak(byteBuf, byteBuf.readerIndex());
            if (iFindLineBreak <= 0) {
                throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
            }
            ByteBuf byteBufHeapBuffer = null;
            try {
                byteBufHeapBuffer = byteBuf.alloc().heapBuffer(iFindLineBreak);
                byteBufHeapBuffer.writeBytes(byteBuf, iFindLineBreak);
                if (byteBuf.readByte() == 13) {
                    byteBuf.readByte();
                }
                return byteBufHeapBuffer.toString(charset);
            } finally {
                byteBufHeapBuffer.release();
            }
        } catch (IndexOutOfBoundsException e10) {
            byteBuf.readerIndex(i10);
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException(e10);
        }
    }

    private static void rewriteCurrentBuffer(ByteBuf byteBuf, int i10) {
        if (i10 == 0) {
            return;
        }
        int i11 = byteBuf.readerIndex();
        int i12 = byteBuf.readableBytes();
        if (i12 == i10) {
            byteBuf.readerIndex(i11);
            byteBuf.writerIndex(i11);
        } else {
            byteBuf.setBytes(i11, byteBuf, i11 + i10, i12 - i10);
            byteBuf.readerIndex(i11);
            byteBuf.writerIndex((i11 + i12) - i10);
        }
    }

    private static void skipControlCharacters(ByteBuf byteBuf) {
        if (!byteBuf.hasArray()) {
            try {
                skipControlCharactersStandard(byteBuf);
                return;
            } catch (IndexOutOfBoundsException e10) {
                throw new HttpPostRequestDecoder.NotEnoughDataDecoderException(e10);
            }
        }
        HttpPostBodyUtil.SeekAheadOptimize seekAheadOptimize = new HttpPostBodyUtil.SeekAheadOptimize(byteBuf);
        while (true) {
            int i10 = seekAheadOptimize.pos;
            if (i10 >= seekAheadOptimize.limit) {
                throw new HttpPostRequestDecoder.NotEnoughDataDecoderException("Access out of bounds");
            }
            byte[] bArr = seekAheadOptimize.bytes;
            seekAheadOptimize.pos = i10 + 1;
            char c10 = (char) (bArr[i10] & 255);
            if (!Character.isISOControl(c10) && !Character.isWhitespace(c10)) {
                seekAheadOptimize.setReadPosition(1);
                return;
            }
        }
    }

    private static void skipControlCharactersStandard(ByteBuf byteBuf) {
        while (true) {
            char unsignedByte = (char) byteBuf.readUnsignedByte();
            if (!Character.isISOControl(unsignedByte) && !Character.isWhitespace(unsignedByte)) {
                byteBuf.readerIndex(byteBuf.readerIndex() - 1);
                return;
            }
        }
    }

    private boolean skipOneLine() {
        if (!this.undecodedChunk.isReadable()) {
            return false;
        }
        byte b10 = this.undecodedChunk.readByte();
        if (b10 != 13) {
            if (b10 == 10) {
                return true;
            }
            ByteBuf byteBuf = this.undecodedChunk;
            byteBuf.readerIndex(byteBuf.readerIndex() - 1);
            return false;
        }
        if (!this.undecodedChunk.isReadable()) {
            ByteBuf byteBuf2 = this.undecodedChunk;
            byteBuf2.readerIndex(byteBuf2.readerIndex() - 1);
            return false;
        }
        if (this.undecodedChunk.readByte() == 10) {
            return true;
        }
        ByteBuf byteBuf3 = this.undecodedChunk;
        byteBuf3.readerIndex(byteBuf3.readerIndex() - 2);
        return false;
    }

    private static String[] splitMultipartHeader(String str) {
        char cCharAt;
        ArrayList arrayList = new ArrayList(1);
        int iFindNonWhitespace = HttpPostBodyUtil.findNonWhitespace(str, 0);
        int i10 = iFindNonWhitespace;
        while (i10 < str.length() && (cCharAt = str.charAt(i10)) != ':' && !Character.isWhitespace(cCharAt)) {
            i10++;
        }
        int i11 = i10;
        while (i11 < str.length()) {
            if (str.charAt(i11) == ':') {
                i11++;
                break;
            }
            i11++;
        }
        int iFindNonWhitespace2 = HttpPostBodyUtil.findNonWhitespace(str, i11);
        int iFindEndOfString = HttpPostBodyUtil.findEndOfString(str);
        arrayList.add(str.substring(iFindNonWhitespace, i10));
        String strSubstring = iFindNonWhitespace2 >= iFindEndOfString ? "" : str.substring(iFindNonWhitespace2, iFindEndOfString);
        for (String str2 : strSubstring.indexOf(59) >= 0 ? splitMultipartHeaderValues(strSubstring) : strSubstring.split(g.f9491d)) {
            arrayList.add(str2.trim());
        }
        String[] strArr = new String[arrayList.size()];
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            strArr[i12] = (String) arrayList.get(i12);
        }
        return strArr;
    }

    private static String[] splitMultipartHeaderValues(String str) {
        ArrayList arrayList = InternalThreadLocalMap.get().arrayList(1);
        int i10 = 0;
        boolean z10 = false;
        boolean z11 = false;
        for (int i11 = 0; i11 < str.length(); i11++) {
            char cCharAt = str.charAt(i11);
            if (z10) {
                if (z11) {
                    z11 = false;
                } else if (cCharAt == '\\') {
                    z11 = true;
                } else if (cCharAt == '\"') {
                    z10 = false;
                }
            } else if (cCharAt == '\"') {
                z10 = true;
            } else if (cCharAt == ';') {
                arrayList.add(str.substring(i10, i11));
                i10 = i11 + 1;
            }
        }
        arrayList.add(str.substring(i10));
        return (String[]) arrayList.toArray(EmptyArrays.EMPTY_STRINGS);
    }

    public void addHttpData(InterfaceHttpData interfaceHttpData) {
        if (interfaceHttpData == null) {
            return;
        }
        List<InterfaceHttpData> arrayList = this.bodyMapHttpData.get(interfaceHttpData.getName());
        if (arrayList == null) {
            arrayList = new ArrayList<>(1);
            this.bodyMapHttpData.put(interfaceHttpData.getName(), arrayList);
        }
        arrayList.add(interfaceHttpData);
        this.bodyListHttpData.add(interfaceHttpData);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void cleanFiles() {
        checkDestroyed();
        this.factory.cleanRequestHttpData(this.request);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData currentPartialHttpData() {
        FileUpload fileUpload = this.currentFileUpload;
        return fileUpload != null ? fileUpload : this.currentAttribute;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void destroy() {
        cleanFiles();
        for (InterfaceHttpData interfaceHttpData : this.bodyListHttpData) {
            if (interfaceHttpData.refCnt() > 0) {
                interfaceHttpData.release();
            }
        }
        this.destroyed = true;
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf == null || byteBuf.refCnt() <= 0) {
            return;
        }
        this.undecodedChunk.release();
        this.undecodedChunk = null;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData getBodyHttpData(String str) {
        checkDestroyed();
        if (!this.isLastChunk) {
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
        }
        List<InterfaceHttpData> list = this.bodyMapHttpData.get(str);
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public List<InterfaceHttpData> getBodyHttpDatas() {
        checkDestroyed();
        if (this.isLastChunk) {
            return this.bodyListHttpData;
        }
        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }

    public int getCurrentAllocatedCapacity() {
        return this.undecodedChunk.capacity();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public int getDiscardThreshold() {
        return this.discardThreshold;
    }

    public InterfaceHttpData getFileUpload(String str) {
        String value;
        Attribute attribute = this.currentFieldAttributes.get(HttpHeaderNames.CONTENT_TRANSFER_ENCODING);
        Charset charsetForName = this.charset;
        HttpPostBodyUtil.TransferEncodingMechanism transferEncodingMechanism = HttpPostBodyUtil.TransferEncodingMechanism.BIT7;
        if (attribute != null) {
            try {
                String lowerCase = attribute.getValue().toLowerCase();
                if (lowerCase.equals(transferEncodingMechanism.value())) {
                    charsetForName = CharsetUtil.US_ASCII;
                } else {
                    transferEncodingMechanism = HttpPostBodyUtil.TransferEncodingMechanism.BIT8;
                    if (lowerCase.equals(transferEncodingMechanism.value())) {
                        charsetForName = CharsetUtil.ISO_8859_1;
                    } else {
                        transferEncodingMechanism = HttpPostBodyUtil.TransferEncodingMechanism.BINARY;
                        if (!lowerCase.equals(transferEncodingMechanism.value())) {
                            throw new HttpPostRequestDecoder.ErrorDataDecoderException("TransferEncoding Unknown: ".concat(lowerCase));
                        }
                    }
                }
            } catch (IOException e10) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e10);
            }
        }
        Attribute attribute2 = this.currentFieldAttributes.get(HttpHeaderValues.CHARSET);
        if (attribute2 != null) {
            try {
                charsetForName = Charset.forName(attribute2.getValue());
            } catch (IOException e11) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e11);
            } catch (UnsupportedCharsetException e12) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e12);
            }
        }
        Charset charset = charsetForName;
        if (this.currentFileUpload == null) {
            Attribute attribute3 = this.currentFieldAttributes.get(HttpHeaderValues.FILENAME);
            Attribute attribute4 = this.currentFieldAttributes.get(HttpHeaderValues.NAME);
            Attribute attribute5 = this.currentFieldAttributes.get(HttpHeaderNames.CONTENT_TYPE);
            Attribute attribute6 = this.currentFieldAttributes.get(HttpHeaderNames.CONTENT_LENGTH);
            long j10 = 0;
            if (attribute6 != null) {
                try {
                    j10 = Long.parseLong(attribute6.getValue());
                } catch (IOException e13) {
                    throw new HttpPostRequestDecoder.ErrorDataDecoderException(e13);
                } catch (NumberFormatException unused) {
                }
            }
            if (attribute5 != null) {
                try {
                    value = attribute5.getValue();
                } catch (IOException e14) {
                    throw new HttpPostRequestDecoder.ErrorDataDecoderException(e14);
                } catch (IllegalArgumentException e15) {
                    throw new HttpPostRequestDecoder.ErrorDataDecoderException(e15);
                } catch (NullPointerException e16) {
                    throw new HttpPostRequestDecoder.ErrorDataDecoderException(e16);
                }
            } else {
                value = HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE;
            }
            this.currentFileUpload = this.factory.createFileUpload(this.request, cleanString(attribute4.getValue()), cleanString(attribute3.getValue()), value, transferEncodingMechanism.value(), charset, j10);
        }
        if (!loadDataMultipartOptimized(this.undecodedChunk, str, this.currentFileUpload) || !this.currentFileUpload.isCompleted()) {
            return null;
        }
        if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.FILEUPLOAD) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER;
            this.currentFieldAttributes = null;
        } else {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.MIXEDDELIMITER;
            cleanMixedAttributes();
        }
        FileUpload fileUpload = this.currentFileUpload;
        this.currentFileUpload = null;
        return fileUpload;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public boolean hasNext() {
        checkDestroyed();
        if (this.currentStatus != HttpPostRequestDecoder.MultiPartStatus.EPILOGUE || this.bodyListHttpDataRank < this.bodyListHttpData.size()) {
            return !this.bodyListHttpData.isEmpty() && this.bodyListHttpDataRank < this.bodyListHttpData.size();
        }
        throw new HttpPostRequestDecoder.EndOfDataDecoderException();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public boolean isMultipart() {
        checkDestroyed();
        return true;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData next() {
        checkDestroyed();
        if (!hasNext()) {
            return null;
        }
        List<InterfaceHttpData> list = this.bodyListHttpData;
        int i10 = this.bodyListHttpDataRank;
        this.bodyListHttpDataRank = i10 + 1;
        return list.get(i10);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void removeHttpDataFromClean(InterfaceHttpData interfaceHttpData) {
        checkDestroyed();
        this.factory.removeHttpDataFromClean(this.request, interfaceHttpData);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void setDiscardThreshold(int i10) {
        this.discardThreshold = ObjectUtil.checkPositiveOrZero(i10, "discardThreshold");
    }

    public HttpPostMultipartRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest) {
        this(httpDataFactory, httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public HttpPostMultipartRequestDecoder offer(HttpContent httpContent) {
        checkDestroyed();
        if (httpContent instanceof LastHttpContent) {
            this.isLastChunk = true;
        }
        ByteBuf byteBufContent = httpContent.content();
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf == null) {
            this.undecodedChunk = byteBufContent.alloc().buffer(byteBufContent.readableBytes()).writeBytes(byteBufContent);
        } else {
            byteBuf.writeBytes(byteBufContent);
        }
        parseBody();
        ByteBuf byteBuf2 = this.undecodedChunk;
        if (byteBuf2 != null && byteBuf2.writerIndex() > this.discardThreshold) {
            if (this.undecodedChunk.refCnt() == 1) {
                this.undecodedChunk.discardReadBytes();
            } else {
                ByteBuf byteBufBuffer = this.undecodedChunk.alloc().buffer(this.undecodedChunk.readableBytes());
                byteBufBuffer.writeBytes(this.undecodedChunk);
                this.undecodedChunk.release();
                this.undecodedChunk = byteBufBuffer;
            }
        }
        return this;
    }

    public HttpPostMultipartRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest, Charset charset) throws Throwable {
        String str;
        this.bodyListHttpData = new ArrayList();
        this.bodyMapHttpData = new TreeMap(CaseIgnoringComparator.INSTANCE);
        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED;
        this.discardThreshold = 10485760;
        HttpRequest httpRequest2 = (HttpRequest) ObjectUtil.checkNotNull(httpRequest, "request");
        this.request = httpRequest2;
        this.charset = (Charset) ObjectUtil.checkNotNull(charset, "charset");
        this.factory = (HttpDataFactory) ObjectUtil.checkNotNull(httpDataFactory, "factory");
        HttpHeaders httpHeadersHeaders = httpRequest2.headers();
        AsciiString asciiString = HttpHeaderNames.CONTENT_TYPE;
        String str2 = httpHeadersHeaders.get(asciiString);
        if (str2 != null) {
            String[] multipartDataBoundary = HttpPostRequestDecoder.getMultipartDataBoundary(str2);
            if (multipartDataBoundary != null) {
                this.multipartDataBoundary = multipartDataBoundary[0];
                if (multipartDataBoundary.length > 1 && (str = multipartDataBoundary[1]) != null) {
                    try {
                        this.charset = Charset.forName(str);
                    } catch (IllegalCharsetNameException e10) {
                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e10);
                    }
                }
            } else {
                this.multipartDataBoundary = null;
            }
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER;
            try {
                if (httpRequest instanceof HttpContent) {
                    offer((HttpContent) httpRequest);
                } else {
                    parseBody();
                }
                return;
            } catch (Throwable th2) {
                destroy();
                PlatformDependent.throwException(th2);
                return;
            }
        }
        throw new HttpPostRequestDecoder.ErrorDataDecoderException("No '" + ((Object) asciiString) + "' header present.");
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public List<InterfaceHttpData> getBodyHttpDatas(String str) {
        checkDestroyed();
        if (this.isLastChunk) {
            return this.bodyMapHttpData.get(str);
        }
        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }
}
