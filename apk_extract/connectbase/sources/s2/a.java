package s2;

import io.netty.buffer.ByteBuf;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    @l
    public static final byte[] a(@l ByteBuf byteBuf) {
        l0.p(byteBuf, "<this>");
        byte[] bArr = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bArr);
        return bArr;
    }
}
