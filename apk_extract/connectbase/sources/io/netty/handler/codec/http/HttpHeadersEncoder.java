package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;

/* JADX INFO: loaded from: classes3.dex */
final class HttpHeadersEncoder {
    private static final int COLON_AND_SPACE_SHORT = 14880;

    private HttpHeadersEncoder() {
    }

    public static void encoderHeader(CharSequence charSequence, CharSequence charSequence2, ByteBuf byteBuf) {
        int length = charSequence.length();
        int length2 = charSequence2.length();
        byteBuf.ensureWritable(length + length2 + 4);
        int iWriterIndex = byteBuf.writerIndex();
        writeAscii(byteBuf, iWriterIndex, charSequence);
        int i10 = iWriterIndex + length;
        ByteBufUtil.setShortBE(byteBuf, i10, COLON_AND_SPACE_SHORT);
        int i11 = i10 + 2;
        writeAscii(byteBuf, i11, charSequence2);
        int i12 = i11 + length2;
        ByteBufUtil.setShortBE(byteBuf, i12, 3338);
        byteBuf.writerIndex(i12 + 2);
    }

    private static void writeAscii(ByteBuf byteBuf, int i10, CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            ByteBufUtil.copy((AsciiString) charSequence, 0, byteBuf, i10, charSequence.length());
        } else {
            byteBuf.setCharSequence(i10, charSequence, CharsetUtil.US_ASCII);
        }
    }
}
