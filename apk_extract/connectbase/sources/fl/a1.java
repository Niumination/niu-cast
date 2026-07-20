package fl;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class a1 {
    @t0
    @os.l
    public static final ByteBuffer a(@os.l ByteBuffer byteBuffer, int i10) {
        kn.l0.p(byteBuffer, "<this>");
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i10);
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        kn.l0.o(byteBufferSlice, "this@copy.slice()");
        kn.l0.o(byteBufferAllocate, "this@apply");
        h(byteBufferSlice, byteBufferAllocate, 0, 2, null);
        byteBufferAllocate.clear();
        kn.l0.o(byteBufferAllocate, "allocate(size).apply {\n …ly)\n        clear()\n    }");
        return byteBufferAllocate;
    }

    @t0
    @os.l
    public static final ByteBuffer b(@os.l ByteBuffer byteBuffer, @os.l bm.h<ByteBuffer> hVar, int i10) {
        kn.l0.p(byteBuffer, "<this>");
        kn.l0.p(hVar, "pool");
        ByteBuffer byteBufferW0 = hVar.W0();
        byteBufferW0.limit(i10);
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        kn.l0.o(byteBufferSlice, "this@copy.slice()");
        h(byteBufferSlice, byteBufferW0, 0, 2, null);
        byteBufferW0.flip();
        return byteBufferW0;
    }

    public static /* synthetic */ ByteBuffer c(ByteBuffer byteBuffer, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = byteBuffer.remaining();
        }
        return a(byteBuffer, i10);
    }

    public static /* synthetic */ ByteBuffer d(ByteBuffer byteBuffer, bm.h hVar, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = byteBuffer.remaining();
        }
        return b(byteBuffer, hVar, i10);
    }

    @t0
    @os.l
    public static final String e(@os.l ByteBuffer byteBuffer, @os.l Charset charset) {
        kn.l0.p(byteBuffer, "<this>");
        kn.l0.p(charset, "charset");
        String string = charset.decode(byteBuffer).toString();
        kn.l0.o(string, "charset.decode(this).toString()");
        return string;
    }

    public static /* synthetic */ String f(ByteBuffer byteBuffer, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        return e(byteBuffer, charset);
    }

    @t0
    public static final int g(@os.l ByteBuffer byteBuffer, @os.l ByteBuffer byteBuffer2, int i10) {
        kn.l0.p(byteBuffer, "<this>");
        kn.l0.p(byteBuffer2, RtspHeaders.Values.DESTINATION);
        int iMin = Math.min(i10, Math.min(byteBuffer.remaining(), byteBuffer2.remaining()));
        if (iMin == byteBuffer.remaining()) {
            byteBuffer2.put(byteBuffer);
        } else {
            int iLimit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + iMin);
            byteBuffer2.put(byteBuffer);
            byteBuffer.limit(iLimit);
        }
        return iMin;
    }

    public static /* synthetic */ int h(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return g(byteBuffer, byteBuffer2, i10);
    }

    @t0
    @os.l
    public static final byte[] i(@os.l ByteBuffer byteBuffer) {
        kn.l0.p(byteBuffer, "<this>");
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }
}
