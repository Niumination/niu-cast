package io.netty.handler.codec.http;

/* JADX INFO: loaded from: classes3.dex */
public class HttpResponseDecoder extends HttpObjectDecoder {
    private static final HttpResponseStatus UNKNOWN_STATUS = new HttpResponseStatus(999, "Unknown");

    public HttpResponseDecoder() {
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public HttpMessage createInvalidMessage() {
        return new DefaultFullHttpResponse(HttpVersion.HTTP_1_0, UNKNOWN_STATUS, this.validateHeaders);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public HttpMessage createMessage(String[] strArr) {
        return new DefaultHttpResponse(HttpVersion.valueOf(strArr[0]), HttpResponseStatus.valueOf(Integer.parseInt(strArr[1]), strArr[2]), this.validateHeaders);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public boolean isDecodingRequest() {
        return false;
    }

    public HttpResponseDecoder(int i10, int i11, int i12) {
        super(i10, i11, i12, true);
    }

    public HttpResponseDecoder(int i10, int i11, int i12, boolean z10) {
        super(i10, i11, i12, true, z10);
    }

    public HttpResponseDecoder(int i10, int i11, int i12, boolean z10, int i13) {
        super(i10, i11, i12, true, z10, i13);
    }

    public HttpResponseDecoder(int i10, int i11, int i12, boolean z10, int i13, boolean z11) {
        super(i10, i11, i12, true, z10, i13, z11);
    }

    public HttpResponseDecoder(int i10, int i11, int i12, boolean z10, int i13, boolean z11, boolean z12) {
        super(i10, i11, i12, true, z10, i13, z11, z12);
    }
}
