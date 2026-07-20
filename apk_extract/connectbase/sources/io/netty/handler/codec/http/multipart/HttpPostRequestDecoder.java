package io.netty.handler.codec.http.multipart;

import fl.h;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.nio.charset.Charset;
import java.util.List;
import m.a;

/* JADX INFO: loaded from: classes3.dex */
public class HttpPostRequestDecoder implements InterfaceHttpPostRequestDecoder {
    static final int DEFAULT_DISCARD_THRESHOLD = 10485760;
    private final InterfaceHttpPostRequestDecoder decoder;

    public static class EndOfDataDecoderException extends DecoderException {
        private static final long serialVersionUID = 1336267941020800769L;
    }

    public static class ErrorDataDecoderException extends DecoderException {
        private static final long serialVersionUID = 5020247425493164465L;

        public ErrorDataDecoderException() {
        }

        public ErrorDataDecoderException(String str) {
            super(str);
        }

        public ErrorDataDecoderException(Throwable th2) {
            super(th2);
        }

        public ErrorDataDecoderException(String str, Throwable th2) {
            super(str, th2);
        }
    }

    public enum MultiPartStatus {
        NOTSTARTED,
        PREAMBLE,
        HEADERDELIMITER,
        DISPOSITION,
        FIELD,
        FILEUPLOAD,
        MIXEDPREAMBLE,
        MIXEDDELIMITER,
        MIXEDDISPOSITION,
        MIXEDFILEUPLOAD,
        MIXEDCLOSEDELIMITER,
        CLOSEDELIMITER,
        PREEPILOGUE,
        EPILOGUE
    }

    public static class NotEnoughDataDecoderException extends DecoderException {
        private static final long serialVersionUID = -7846841864603865638L;

        public NotEnoughDataDecoderException() {
        }

        public NotEnoughDataDecoderException(String str) {
            super(str);
        }

        public NotEnoughDataDecoderException(Throwable th2) {
            super(th2);
        }

        public NotEnoughDataDecoderException(String str, Throwable th2) {
            super(str, th2);
        }
    }

    public HttpPostRequestDecoder(HttpRequest httpRequest) {
        this(new DefaultHttpDataFactory(16384L), httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    public static String[] getMultipartDataBoundary(String str) {
        char c10;
        String strSubstringAfter;
        String[] strArrSplitHeaderContentType = splitHeaderContentType(str);
        String string = HttpHeaderValues.MULTIPART_FORM_DATA.toString();
        if (strArrSplitHeaderContentType[0].regionMatches(true, 0, string, 0, string.length())) {
            String string2 = HttpHeaderValues.BOUNDARY.toString();
            char c11 = 2;
            if (strArrSplitHeaderContentType[1].regionMatches(true, 0, string2, 0, string2.length())) {
                c10 = 2;
                c11 = 1;
            } else if (strArrSplitHeaderContentType[2].regionMatches(true, 0, string2, 0, string2.length())) {
                c10 = 1;
            }
            String strSubstringAfter2 = StringUtil.substringAfter(strArrSplitHeaderContentType[c11], h.f6043c);
            if (strSubstringAfter2 == null) {
                throw new ErrorDataDecoderException("Needs a boundary value");
            }
            if (strSubstringAfter2.charAt(0) == '\"') {
                String strTrim = strSubstringAfter2.trim();
                int length = strTrim.length() - 1;
                if (strTrim.charAt(length) == '\"') {
                    strSubstringAfter2 = strTrim.substring(1, length);
                }
            }
            String string3 = HttpHeaderValues.CHARSET.toString();
            return (!strArrSplitHeaderContentType[c10].regionMatches(true, 0, string3, 0, string3.length()) || (strSubstringAfter = StringUtil.substringAfter(strArrSplitHeaderContentType[c10], h.f6043c)) == null) ? new String[]{a.a("--", strSubstringAfter2)} : new String[]{a.a("--", strSubstringAfter2), strSubstringAfter};
        }
        return null;
    }

    public static boolean isMultipart(HttpRequest httpRequest) {
        String str = httpRequest.headers().get(HttpHeaderNames.CONTENT_TYPE);
        return (str == null || !str.startsWith(HttpHeaderValues.MULTIPART_FORM_DATA.toString()) || getMultipartDataBoundary(str) == null) ? false : true;
    }

    private static String[] splitHeaderContentType(String str) {
        int iFindNonWhitespace = HttpPostBodyUtil.findNonWhitespace(str, 0);
        int iIndexOf = str.indexOf(59);
        if (iIndexOf == -1) {
            return new String[]{str, "", ""};
        }
        int iFindNonWhitespace2 = HttpPostBodyUtil.findNonWhitespace(str, iIndexOf + 1);
        if (str.charAt(iIndexOf - 1) == ' ') {
            iIndexOf--;
        }
        int iIndexOf2 = str.indexOf(59, iFindNonWhitespace2);
        if (iIndexOf2 == -1) {
            return new String[]{str.substring(iFindNonWhitespace, iIndexOf), str.substring(iFindNonWhitespace2, HttpPostBodyUtil.findEndOfString(str)), ""};
        }
        int iFindNonWhitespace3 = HttpPostBodyUtil.findNonWhitespace(str, iIndexOf2 + 1);
        if (str.charAt(iIndexOf2 - 1) == ' ') {
            iIndexOf2--;
        }
        return new String[]{str.substring(iFindNonWhitespace, iIndexOf), str.substring(iFindNonWhitespace2, iIndexOf2), str.substring(iFindNonWhitespace3, HttpPostBodyUtil.findEndOfString(str))};
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void cleanFiles() {
        this.decoder.cleanFiles();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData currentPartialHttpData() {
        return this.decoder.currentPartialHttpData();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void destroy() {
        this.decoder.destroy();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData getBodyHttpData(String str) {
        return this.decoder.getBodyHttpData(str);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public List<InterfaceHttpData> getBodyHttpDatas() {
        return this.decoder.getBodyHttpDatas();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public int getDiscardThreshold() {
        return this.decoder.getDiscardThreshold();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public boolean hasNext() {
        return this.decoder.hasNext();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData next() {
        return this.decoder.next();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpPostRequestDecoder offer(HttpContent httpContent) {
        return this.decoder.offer(httpContent);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void removeHttpDataFromClean(InterfaceHttpData interfaceHttpData) {
        this.decoder.removeHttpDataFromClean(interfaceHttpData);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void setDiscardThreshold(int i10) {
        this.decoder.setDiscardThreshold(i10);
    }

    public HttpPostRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest) {
        this(httpDataFactory, httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public List<InterfaceHttpData> getBodyHttpDatas(String str) {
        return this.decoder.getBodyHttpDatas(str);
    }

    public HttpPostRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest, Charset charset) {
        ObjectUtil.checkNotNull(httpDataFactory, "factory");
        ObjectUtil.checkNotNull(httpRequest, "request");
        ObjectUtil.checkNotNull(charset, "charset");
        if (isMultipart(httpRequest)) {
            this.decoder = new HttpPostMultipartRequestDecoder(httpDataFactory, httpRequest, charset);
        } else {
            this.decoder = new HttpPostStandardRequestDecoder(httpDataFactory, httpRequest, charset);
        }
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public boolean isMultipart() {
        return this.decoder.isMultipart();
    }
}
