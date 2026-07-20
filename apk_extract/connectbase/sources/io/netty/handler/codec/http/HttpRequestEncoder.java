package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.CharsetUtil;

/* JADX INFO: loaded from: classes3.dex */
public class HttpRequestEncoder extends HttpObjectEncoder<HttpRequest> {
    private static final char QUESTION_MARK = '?';
    private static final char SLASH = '/';
    private static final int SLASH_AND_SPACE_SHORT = 12064;
    private static final int SPACE_SLASH_AND_SPACE_MEDIUM = 2109216;

    @Override // io.netty.handler.codec.http.HttpObjectEncoder, io.netty.handler.codec.MessageToMessageEncoder
    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return super.acceptOutboundMessage(obj) && !(obj instanceof HttpResponse);
    }

    @Override // io.netty.handler.codec.http.HttpObjectEncoder
    public void encodeInitialLine(ByteBuf byteBuf, HttpRequest httpRequest) throws Exception {
        CharSequence charSequenceInsert;
        ByteBufUtil.copy(httpRequest.method().asciiName(), byteBuf);
        String strUri = httpRequest.uri();
        if (strUri.isEmpty()) {
            ByteBufUtil.writeMediumBE(byteBuf, SPACE_SLASH_AND_SPACE_MEDIUM);
        } else {
            int iIndexOf = strUri.indexOf("://");
            boolean z10 = false;
            if (iIndexOf != -1 && strUri.charAt(0) != '/') {
                int i10 = iIndexOf + 3;
                int iIndexOf2 = strUri.indexOf(63, i10);
                if (iIndexOf2 == -1) {
                    if (strUri.lastIndexOf(47) < i10) {
                        charSequenceInsert = strUri;
                        charSequenceInsert = strUri;
                        charSequenceInsert = strUri;
                        z10 = true;
                        charSequenceInsert = strUri;
                    }
                } else if (strUri.lastIndexOf(47, iIndexOf2) < i10) {
                    charSequenceInsert = strUri;
                    charSequenceInsert = strUri;
                    charSequenceInsert = strUri;
                    charSequenceInsert = new StringBuilder(strUri).insert(iIndexOf2, '/');
                }
            }
            charSequenceInsert = strUri;
            charSequenceInsert = strUri;
            charSequenceInsert = strUri;
            charSequenceInsert = strUri;
            charSequenceInsert = strUri;
            charSequenceInsert = strUri;
            charSequenceInsert = strUri;
            charSequenceInsert = strUri;
            charSequenceInsert = strUri;
            byteBuf.writeByte(32).writeCharSequence(charSequenceInsert, CharsetUtil.UTF_8);
            if (z10) {
                ByteBufUtil.writeShortBE(byteBuf, SLASH_AND_SPACE_SHORT);
            } else {
                byteBuf.writeByte(32);
            }
        }
        httpRequest.protocolVersion().encode(byteBuf);
        ByteBufUtil.writeShortBE(byteBuf, 3338);
    }
}
