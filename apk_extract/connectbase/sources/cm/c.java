package cm;

import bm.h;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kn.l0;
import kn.w;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends tl.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public final InputStream f1672e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@l InputStream inputStream, @l h<ul.b> hVar) {
        super((ul.b) null, 0L, hVar, 3, (w) null);
        l0.p(inputStream, "stream");
        l0.p(hVar, "pool");
        this.f1672e = inputStream;
    }

    @Override // tl.a
    public int f0(@l ByteBuffer byteBuffer, int i10, int i11) throws IOException {
        l0.p(byteBuffer, RtspHeaders.Values.DESTINATION);
        if (byteBuffer.hasArray() && !byteBuffer.isReadOnly()) {
            int i12 = this.f1672e.read(byteBuffer.array(), byteBuffer.arrayOffset() + i10, i11);
            if (i12 < 0) {
                return 0;
            }
            return i12;
        }
        byte[] bArrW0 = a.a().W0();
        try {
            int i13 = this.f1672e.read(bArrW0, 0, Math.min(bArrW0.length, i11));
            if (i13 == -1) {
                return 0;
            }
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArrW0, 0, i13).slice().order(ByteOrder.BIG_ENDIAN);
            l0.o(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
            ql.f.d(ql.f.c(byteBufferOrder), byteBuffer, 0, i13, i10);
            return i13;
        } finally {
            a.f1671b.recycle(bArrW0);
        }
    }

    @Override // tl.a
    public void n() throws IOException {
        this.f1672e.close();
    }
}
