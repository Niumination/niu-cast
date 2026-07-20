package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public class HttpPostStandardRequestDecoder implements InterfaceHttpPostRequestDecoder {
    private final List<InterfaceHttpData> bodyListHttpData;
    private int bodyListHttpDataRank;
    private final Map<String, List<InterfaceHttpData>> bodyMapHttpData;
    private final Charset charset;
    private Attribute currentAttribute;
    private HttpPostRequestDecoder.MultiPartStatus currentStatus;
    private boolean destroyed;
    private int discardThreshold;
    private final HttpDataFactory factory;
    private boolean isLastChunk;
    private final HttpRequest request;
    private ByteBuf undecodedChunk;

    /* JADX INFO: renamed from: io.netty.handler.codec.http.multipart.HttpPostStandardRequestDecoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus;

        static {
            int[] iArr = new int[HttpPostRequestDecoder.MultiPartStatus.values().length];
            $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus = iArr;
            try {
                iArr[HttpPostRequestDecoder.MultiPartStatus.DISPOSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.FIELD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static final class UrlDecoder implements ByteProcessor {
        private byte hiByte;
        private int nextEscapedIdx;
        private final ByteBuf output;

        public UrlDecoder(ByteBuf byteBuf) {
            this.output = byteBuf;
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b10) {
            int i10 = this.nextEscapedIdx;
            if (i10 != 0) {
                if (i10 == 1) {
                    this.hiByte = b10;
                    this.nextEscapedIdx = i10 + 1;
                } else {
                    int iDecodeHexNibble = StringUtil.decodeHexNibble((char) this.hiByte);
                    int iDecodeHexNibble2 = StringUtil.decodeHexNibble((char) b10);
                    if (iDecodeHexNibble == -1 || iDecodeHexNibble2 == -1) {
                        this.nextEscapedIdx++;
                        return false;
                    }
                    this.output.writeByte((iDecodeHexNibble << 4) + iDecodeHexNibble2);
                    this.nextEscapedIdx = 0;
                }
            } else if (b10 == 37) {
                this.nextEscapedIdx = 1;
            } else if (b10 == 43) {
                this.output.writeByte(32);
            } else {
                this.output.writeByte(b10);
            }
            return true;
        }
    }

    public static final class UrlEncodedDetector implements ByteProcessor {
        private UrlEncodedDetector() {
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b10) throws Exception {
            return (b10 == 37 || b10 == 43) ? false : true;
        }

        public /* synthetic */ UrlEncodedDetector(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public HttpPostStandardRequestDecoder(HttpRequest httpRequest) {
        this(new DefaultHttpDataFactory(16384L), httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    private void checkDestroyed() {
        if (this.destroyed) {
            throw new IllegalStateException("HttpPostStandardRequestDecoder was destroyed already");
        }
    }

    private static String decodeAttribute(String str, Charset charset) {
        try {
            return QueryStringDecoder.decodeComponent(str, charset);
        } catch (IllegalArgumentException e10) {
            throw new HttpPostRequestDecoder.ErrorDataDecoderException("Bad string: '" + str + '\'', e10);
        }
    }

    private void parseBody() {
        HttpPostRequestDecoder.MultiPartStatus multiPartStatus = this.currentStatus;
        if (multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE && multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.EPILOGUE) {
            parseBodyAttributes();
        } else if (this.isLastChunk) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
        }
    }

    private void parseBodyAttributes() {
        Attribute attribute;
        Attribute attribute2;
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf == null) {
            return;
        }
        if (!byteBuf.hasArray()) {
            parseBodyAttributesStandard();
            return;
        }
        HttpPostBodyUtil.SeekAheadOptimize seekAheadOptimize = new HttpPostBodyUtil.SeekAheadOptimize(this.undecodedChunk);
        int i10 = this.undecodedChunk.readerIndex();
        if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
        }
        while (true) {
            int i11 = i10;
            while (true) {
                try {
                    int i12 = seekAheadOptimize.pos;
                    boolean z10 = true;
                    if (i12 < seekAheadOptimize.limit) {
                        byte[] bArr = seekAheadOptimize.bytes;
                        seekAheadOptimize.pos = i12 + 1;
                        char c10 = (char) (bArr[i12] & 255);
                        int i13 = i10 + 1;
                        int i14 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[this.currentStatus.ordinal()];
                        if (i14 != 1) {
                            if (i14 != 2) {
                                seekAheadOptimize.setReadPosition(0);
                                i10 = i13;
                            } else if (c10 == '&') {
                                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                                setFinalBuffer(this.undecodedChunk.retainedSlice(i11, i10 - i11));
                                i10 = i13;
                            } else if (c10 == '\r') {
                                int i15 = seekAheadOptimize.pos;
                                int i16 = seekAheadOptimize.limit;
                                if (i15 < i16) {
                                    byte[] bArr2 = seekAheadOptimize.bytes;
                                    seekAheadOptimize.pos = i15 + 1;
                                    char c11 = (char) (bArr2[i15] & 255);
                                    i13 = i10 + 2;
                                    if (c11 != '\n') {
                                        seekAheadOptimize.setReadPosition(0);
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException("Bad end of line");
                                    }
                                    this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                                    seekAheadOptimize.setReadPosition(0);
                                    setFinalBuffer(this.undecodedChunk.retainedSlice(i11, i10 - i11));
                                    i10 = i13;
                                    i11 = i10;
                                } else if (i16 <= 0) {
                                    i10 = i13;
                                }
                            } else {
                                if (c10 == '\n') {
                                    this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                                    seekAheadOptimize.setReadPosition(0);
                                    setFinalBuffer(this.undecodedChunk.retainedSlice(i11, i10 - i11));
                                    i10 = i13;
                                    i11 = i10;
                                }
                                i10 = i13;
                            }
                            z10 = false;
                        } else {
                            if (c10 == '=') {
                                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.FIELD;
                                this.currentAttribute = this.factory.createAttribute(this.request, decodeAttribute(this.undecodedChunk.toString(i11, i10 - i11, this.charset), this.charset));
                            } else {
                                if (c10 == '&') {
                                    this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                                    String strDecodeAttribute = decodeAttribute(this.undecodedChunk.toString(i11, i10 - i11, this.charset), this.charset);
                                    if (!strDecodeAttribute.isEmpty()) {
                                        Attribute attributeCreateAttribute = this.factory.createAttribute(this.request, strDecodeAttribute);
                                        this.currentAttribute = attributeCreateAttribute;
                                        attributeCreateAttribute.setValue("");
                                        addHttpData(this.currentAttribute);
                                    }
                                    this.currentAttribute = null;
                                }
                                i10 = i13;
                            }
                            i10 = i13;
                        }
                    }
                    if (!this.isLastChunk || (attribute2 = this.currentAttribute) == null) {
                        if (z10 && (attribute = this.currentAttribute) != null && this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.FIELD) {
                            attribute.addContent(this.undecodedChunk.retainedSlice(i11, i10 - i11), false);
                        }
                        this.undecodedChunk.readerIndex(i11);
                        return;
                    }
                    if (i10 > i11) {
                        setFinalBuffer(this.undecodedChunk.retainedSlice(i11, i10 - i11));
                    } else if (!attribute2.isCompleted()) {
                        setFinalBuffer(Unpooled.EMPTY_BUFFER);
                    }
                    try {
                        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
                    } catch (HttpPostRequestDecoder.ErrorDataDecoderException e10) {
                        e = e10;
                        i11 = i10;
                        this.undecodedChunk.readerIndex(i11);
                        throw e;
                    } catch (IOException e11) {
                        e = e11;
                        i11 = i10;
                        this.undecodedChunk.readerIndex(i11);
                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e);
                    } catch (IllegalArgumentException e12) {
                        e = e12;
                        i11 = i10;
                        this.undecodedChunk.readerIndex(i11);
                        throw new HttpPostRequestDecoder.ErrorDataDecoderException(e);
                    }
                    i11 = i10;
                    this.undecodedChunk.readerIndex(i11);
                    return;
                } catch (HttpPostRequestDecoder.ErrorDataDecoderException e13) {
                    e = e13;
                } catch (IOException e14) {
                    e = e14;
                } catch (IllegalArgumentException e15) {
                    e = e15;
                }
            }
        }
    }

    private void parseBodyAttributesStandard() {
        Attribute attribute;
        Attribute attribute2;
        int i10 = this.undecodedChunk.readerIndex();
        if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
        }
        int i11 = i10;
        boolean z10 = true;
        while (this.undecodedChunk.isReadable() && z10) {
            try {
                char unsignedByte = (char) this.undecodedChunk.readUnsignedByte();
                int i12 = i10 + 1;
                int i13 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[this.currentStatus.ordinal()];
                if (i13 != 1) {
                    if (i13 != 2) {
                        z10 = false;
                    } else if (unsignedByte == '&') {
                        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                        setFinalBuffer(this.undecodedChunk.retainedSlice(i11, i10 - i11));
                        z10 = true;
                        i10 = i12;
                        i11 = i10;
                    } else if (unsignedByte == '\r') {
                        if (this.undecodedChunk.isReadable()) {
                            int i14 = i10 + 2;
                            if (((char) this.undecodedChunk.readUnsignedByte()) != '\n') {
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException("Bad end of line");
                            }
                            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                            setFinalBuffer(this.undecodedChunk.retainedSlice(i11, i10 - i11));
                            i10 = i14;
                            i11 = i10;
                            z10 = false;
                        } else {
                            continue;
                        }
                    } else if (unsignedByte == '\n') {
                        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                        setFinalBuffer(this.undecodedChunk.retainedSlice(i11, i10 - i11));
                        z10 = false;
                        i10 = i12;
                        i11 = i10;
                    }
                    i10 = i12;
                } else {
                    if (unsignedByte == '=') {
                        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.FIELD;
                        this.currentAttribute = this.factory.createAttribute(this.request, decodeAttribute(this.undecodedChunk.toString(i11, i10 - i11, this.charset), this.charset));
                    } else if (unsignedByte == '&') {
                        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                        String strDecodeAttribute = decodeAttribute(this.undecodedChunk.toString(i11, i10 - i11, this.charset), this.charset);
                        if (!strDecodeAttribute.isEmpty()) {
                            Attribute attributeCreateAttribute = this.factory.createAttribute(this.request, strDecodeAttribute);
                            this.currentAttribute = attributeCreateAttribute;
                            attributeCreateAttribute.setValue("");
                            addHttpData(this.currentAttribute);
                        }
                        this.currentAttribute = null;
                        z10 = true;
                    } else {
                        i10 = i12;
                    }
                    i10 = i12;
                    i11 = i10;
                }
            } catch (HttpPostRequestDecoder.ErrorDataDecoderException e10) {
                e = e10;
            } catch (IOException e11) {
                e = e11;
            } catch (IllegalArgumentException e12) {
                e = e12;
            }
        }
        if (this.isLastChunk && (attribute2 = this.currentAttribute) != null) {
            if (i10 > i11) {
                setFinalBuffer(this.undecodedChunk.retainedSlice(i11, i10 - i11));
            } else if (!attribute2.isCompleted()) {
                setFinalBuffer(Unpooled.EMPTY_BUFFER);
            }
            try {
                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
            } catch (HttpPostRequestDecoder.ErrorDataDecoderException e13) {
                i11 = i10;
                e = e13;
                this.undecodedChunk.readerIndex(i11);
                throw e;
            } catch (IOException e14) {
                i11 = i10;
                e = e14;
                this.undecodedChunk.readerIndex(i11);
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e);
            } catch (IllegalArgumentException e15) {
                i11 = i10;
                e = e15;
                this.undecodedChunk.readerIndex(i11);
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e);
            }
        } else if (z10 && (attribute = this.currentAttribute) != null && this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.FIELD) {
            attribute.addContent(this.undecodedChunk.retainedSlice(i11, i10 - i11), false);
        } else {
            i10 = i11;
        }
        this.undecodedChunk.readerIndex(i10);
    }

    private void setFinalBuffer(ByteBuf byteBuf) throws IOException {
        this.currentAttribute.addContent(byteBuf, true);
        ByteBuf byteBufDecodeAttribute = decodeAttribute(this.currentAttribute.getByteBuf(), this.charset);
        if (byteBufDecodeAttribute != null) {
            this.currentAttribute.setContent(byteBufDecodeAttribute);
        }
        addHttpData(this.currentAttribute);
        this.currentAttribute = null;
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
        return this.currentAttribute;
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

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public int getDiscardThreshold() {
        return this.discardThreshold;
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
        return false;
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

    public HttpPostStandardRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest) {
        this(httpDataFactory, httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public HttpPostStandardRequestDecoder offer(HttpContent httpContent) {
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

    public HttpPostStandardRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest, Charset charset) throws Throwable {
        this.bodyListHttpData = new ArrayList();
        this.bodyMapHttpData = new TreeMap(CaseIgnoringComparator.INSTANCE);
        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED;
        this.discardThreshold = 10485760;
        this.request = (HttpRequest) ObjectUtil.checkNotNull(httpRequest, "request");
        this.charset = (Charset) ObjectUtil.checkNotNull(charset, "charset");
        this.factory = (HttpDataFactory) ObjectUtil.checkNotNull(httpDataFactory, "factory");
        try {
            if (httpRequest instanceof HttpContent) {
                offer((HttpContent) httpRequest);
            } else {
                parseBody();
            }
        } catch (Throwable th2) {
            destroy();
            PlatformDependent.throwException(th2);
        }
    }

    private static ByteBuf decodeAttribute(ByteBuf byteBuf, Charset charset) {
        if (byteBuf.forEachByte(new UrlEncodedDetector(null)) == -1) {
            return null;
        }
        ByteBuf byteBufBuffer = byteBuf.alloc().buffer(byteBuf.readableBytes());
        UrlDecoder urlDecoder = new UrlDecoder(byteBufBuffer);
        int iForEachByte = byteBuf.forEachByte(urlDecoder);
        if (urlDecoder.nextEscapedIdx == 0) {
            return byteBufBuffer;
        }
        if (iForEachByte == -1) {
            iForEachByte = byteBuf.readableBytes() - 1;
        }
        int i10 = iForEachByte - (urlDecoder.nextEscapedIdx - 1);
        byteBufBuffer.release();
        throw new HttpPostRequestDecoder.ErrorDataDecoderException(String.format("Invalid hex byte at index '%d' in string: '%s'", Integer.valueOf(i10), byteBuf.toString(charset)));
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
