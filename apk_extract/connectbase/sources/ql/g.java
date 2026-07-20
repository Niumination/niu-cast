package ql;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    @os.l
    public static final ByteBuffer a(@os.l f.a aVar, @os.l ByteBuffer byteBuffer) {
        l0.p(aVar, "<this>");
        l0.p(byteBuffer, "buffer");
        ByteBuffer byteBufferOrder = byteBuffer.slice().order(ByteOrder.BIG_ENDIAN);
        l0.o(byteBufferOrder, "buffer.slice().order(ByteOrder.BIG_ENDIAN)");
        return f.c(byteBufferOrder);
    }

    @os.l
    public static final ByteBuffer b(@os.l f.a aVar, @os.l byte[] bArr, int i10, int i11) {
        l0.p(aVar, "<this>");
        l0.p(bArr, dc.d.f3685p);
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr, i10, i11).slice().order(ByteOrder.BIG_ENDIAN);
        l0.o(byteBufferOrder, "wrap(array, offset, leng…der(ByteOrder.BIG_ENDIAN)");
        return f.c(byteBufferOrder);
    }

    public static /* synthetic */ ByteBuffer c(f.a aVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        l0.p(aVar, "<this>");
        l0.p(bArr, dc.d.f3685p);
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr, i10, i11).slice().order(ByteOrder.BIG_ENDIAN);
        l0.o(byteBufferOrder, "wrap(array, offset, leng…der(ByteOrder.BIG_ENDIAN)");
        return f.c(byteBufferOrder);
    }

    public static final <R> R d(@os.l byte[] bArr, int i10, int i11, @os.l jn.l<? super f, ? extends R> lVar) {
        l0.p(bArr, "<this>");
        l0.p(lVar, "block");
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr, i10, i11).slice().order(ByteOrder.BIG_ENDIAN);
        l0.o(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        return lVar.invoke(new f(f.c(byteBufferOrder)));
    }

    public static /* synthetic */ Object e(byte[] bArr, int i10, int i11, jn.l lVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        l0.p(bArr, "<this>");
        l0.p(lVar, "block");
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr, i10, i11).slice().order(ByteOrder.BIG_ENDIAN);
        l0.o(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        return lVar.invoke(new f(f.c(byteBufferOrder)));
    }
}
