package io.netty.handler.codec.http;

import c1.c;
import io.netty.util.AsciiString;

/* JADX INFO: loaded from: classes3.dex */
public class HttpRequestDecoder extends HttpObjectDecoder {
    private static final long CONNECTION_AS_LONG_0 = 7598807758576447299L;
    private static final short CONNECTION_AS_SHORT_1 = 28271;
    private static final long CONTENT_AS_LONG = 3275364211029339971L;
    private static final int GET_AS_INT = 5522759;
    private static final int HOST_AS_INT = 1953722184;
    private static final long HTTP_1_0_AS_LONG = 3471766442030158920L;
    private static final long HTTP_1_1_AS_LONG = 3543824036068086856L;
    private static final long LENGTH_AS_LONG = 114849160783180L;
    private static final int POST_AS_INT = 1414745936;
    private static final int TYPE_AS_INT = 1701869908;
    private static final AsciiString Host = AsciiString.cached("Host");
    private static final AsciiString Connection = AsciiString.cached("Connection");
    private static final AsciiString ContentType = AsciiString.cached("Content-Type");
    private static final AsciiString ContentLength = AsciiString.cached("Content-Length");

    public HttpRequestDecoder() {
    }

    private static boolean isConnection(byte[] bArr, int i10) {
        if ((((long) (bArr[i10] | (bArr[i10 + 1] << 8) | (bArr[i10 + 2] << c.f1124r) | (bArr[i10 + 3] << c.B))) | (((long) bArr[i10 + 4]) << 32) | (((long) bArr[i10 + 5]) << 40) | (((long) bArr[i10 + 6]) << 48) | (((long) bArr[i10 + 7]) << 56)) != CONNECTION_AS_LONG_0) {
            return false;
        }
        return ((short) ((bArr[i10 + 9] << 8) | bArr[i10 + 8])) == 28271;
    }

    private static boolean isContentLength(byte[] bArr, int i10) {
        if ((((long) (bArr[i10] | (bArr[i10 + 1] << 8) | (bArr[i10 + 2] << c.f1124r) | (bArr[i10 + 3] << c.B))) | (((long) bArr[i10 + 4]) << 32) | (((long) bArr[i10 + 5]) << 40) | (((long) bArr[i10 + 6]) << 48) | (((long) bArr[i10 + 7]) << 56)) != CONTENT_AS_LONG) {
            return false;
        }
        return ((((long) bArr[i10 + 13]) << 40) | (((long) (((bArr[i10 + 8] | (bArr[i10 + 9] << 8)) | (bArr[i10 + 10] << c.f1124r)) | (bArr[i10 + 11] << c.B))) | (((long) bArr[i10 + 12]) << 32))) == LENGTH_AS_LONG;
    }

    private static boolean isContentType(byte[] bArr, int i10) {
        if ((((long) (bArr[i10] | (bArr[i10 + 1] << 8) | (bArr[i10 + 2] << c.f1124r) | (bArr[i10 + 3] << c.B))) | (((long) bArr[i10 + 4]) << 32) | (((long) bArr[i10 + 5]) << 40) | (((long) bArr[i10 + 6]) << 48) | (((long) bArr[i10 + 7]) << 56)) != CONTENT_AS_LONG) {
            return false;
        }
        return ((bArr[i10 + 11] << c.B) | ((bArr[i10 + 8] | (bArr[i10 + 9] << 8)) | (bArr[i10 + 10] << c.f1124r))) == TYPE_AS_INT;
    }

    private static boolean isGetMethod(byte[] bArr, int i10) {
        return ((bArr[i10 + 2] << c.f1124r) | (bArr[i10] | (bArr[i10 + 1] << 8))) == GET_AS_INT;
    }

    private static boolean isHost(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] << c.B) | ((bArr[i10] | (bArr[i10 + 1] << 8)) | (bArr[i10 + 2] << c.f1124r))) == HOST_AS_INT;
    }

    private static boolean isPostMethod(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] << c.B) | ((bArr[i10] | (bArr[i10 + 1] << 8)) | (bArr[i10 + 2] << c.f1124r))) == POST_AS_INT;
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public HttpMessage createInvalidMessage() {
        return new DefaultFullHttpRequest(HttpVersion.HTTP_1_0, HttpMethod.GET, "/bad-request", this.validateHeaders);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public HttpMessage createMessage(String[] strArr) throws Exception {
        return new DefaultHttpRequest(HttpVersion.valueOf(strArr[2]), HttpMethod.valueOf(strArr[0]), strArr[1], this.validateHeaders);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
        if (httpMessage.getClass() == DefaultHttpRequest.class) {
            return false;
        }
        return super.isContentAlwaysEmpty(httpMessage);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public boolean isDecodingRequest() {
        return true;
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public String splitFirstWordInitialLine(byte[] bArr, int i10, int i11) {
        if (i11 == 3) {
            if (isGetMethod(bArr, i10)) {
                return HttpMethod.GET.name();
            }
        } else if (i11 == 4 && isPostMethod(bArr, i10)) {
            return HttpMethod.POST.name();
        }
        return super.splitFirstWordInitialLine(bArr, i10, i11);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public AsciiString splitHeaderName(byte[] bArr, int i10, int i11) {
        byte b10 = bArr[i10];
        if (b10 == 72 && i11 == 4) {
            if (isHost(bArr, i10)) {
                return Host;
            }
        } else if (b10 == 67) {
            if (i11 == 10) {
                if (isConnection(bArr, i10)) {
                    return Connection;
                }
            } else if (i11 == 12) {
                if (isContentType(bArr, i10)) {
                    return ContentType;
                }
            } else if (i11 == 14 && isContentLength(bArr, i10)) {
                return ContentLength;
            }
        }
        return super.splitHeaderName(bArr, i10, i11);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public String splitThirdWordInitialLine(byte[] bArr, int i10, int i11) {
        if (i11 == 8) {
            long j10 = ((long) ((bArr[i10 + 1] << 8) | bArr[i10] | (bArr[i10 + 2] << c.f1124r) | (bArr[i10 + 3] << c.B))) | (((long) bArr[i10 + 4]) << 32) | (((long) bArr[i10 + 5]) << 40) | (((long) bArr[i10 + 6]) << 48) | (((long) bArr[i10 + 7]) << 56);
            if (j10 == HTTP_1_1_AS_LONG) {
                return "HTTP/1.1";
            }
            if (j10 == HTTP_1_0_AS_LONG) {
                return "HTTP/1.0";
            }
        }
        return super.splitThirdWordInitialLine(bArr, i10, i11);
    }

    public HttpRequestDecoder(int i10, int i11, int i12) {
        super(i10, i11, i12, true);
    }

    public HttpRequestDecoder(int i10, int i11, int i12, boolean z10) {
        super(i10, i11, i12, true, z10);
    }

    public HttpRequestDecoder(int i10, int i11, int i12, boolean z10, int i13) {
        super(i10, i11, i12, true, z10, i13);
    }

    public HttpRequestDecoder(int i10, int i11, int i12, boolean z10, int i13, boolean z11) {
        super(i10, i11, i12, true, z10, i13, z11);
    }

    public HttpRequestDecoder(int i10, int i11, int i12, boolean z10, int i13, boolean z11, boolean z12) {
        super(i10, i11, i12, true, z10, i13, z11, z12);
    }
}
