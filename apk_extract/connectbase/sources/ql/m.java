package ql;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    public static final void A(@os.l ByteBuffer byteBuffer, long j10, @os.l byte[] bArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$storeUByteArray");
        l0.p(bArr, "source");
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr, i10, i11).slice().order(ByteOrder.BIG_ENDIAN);
        l0.o(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        f.e(f.c(byteBufferOrder), byteBuffer, 0L, i11, j10);
    }

    public static void B(ByteBuffer byteBuffer, long j10, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = bArr.length - i10;
        }
        l0.p(byteBuffer, "$this$storeUByteArray");
        l0.p(bArr, "source");
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr, i10, i11).slice().order(ByteOrder.BIG_ENDIAN);
        l0.o(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        f.e(f.c(byteBufferOrder), byteBuffer, 0L, i11, j10);
    }

    public static final void C(@os.l ByteBuffer byteBuffer, long j10, @os.l int[] iArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$storeUIntArray");
        l0.p(iArr, "source");
        n.E(byteBuffer, j10, iArr, i10, i11);
    }

    public static void D(ByteBuffer byteBuffer, long j10, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = iArr.length - i13;
        }
        l0.p(byteBuffer, "$this$storeUIntArray");
        l0.p(iArr, "source");
        n.E(byteBuffer, j10, iArr, i13, i11);
    }

    public static final void E(@os.l ByteBuffer byteBuffer, int i10, @os.l int[] iArr, int i11, int i12) {
        l0.p(byteBuffer, "$this$storeUIntArray");
        l0.p(iArr, "source");
        n.C(byteBuffer, i10, iArr, i11, i12);
    }

    public static void F(ByteBuffer byteBuffer, int i10, int[] iArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = iArr.length - i11;
        }
        l0.p(byteBuffer, "$this$storeUIntArray");
        l0.p(iArr, "source");
        n.C(byteBuffer, i10, iArr, i11, i12);
    }

    public static final void G(@os.l ByteBuffer byteBuffer, int i10, @os.l long[] jArr, int i11, int i12) {
        l0.p(byteBuffer, "$this$storeULongArray");
        l0.p(jArr, "source");
        n.I(byteBuffer, i10, jArr, i11, i12);
    }

    public static void H(ByteBuffer byteBuffer, int i10, long[] jArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = jArr.length - i11;
        }
        l0.p(byteBuffer, "$this$storeULongArray");
        l0.p(jArr, "source");
        n.I(byteBuffer, i10, jArr, i11, i12);
    }

    public static final void I(@os.l ByteBuffer byteBuffer, long j10, @os.l long[] jArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$storeULongArray");
        l0.p(jArr, "source");
        n.G(byteBuffer, j10, jArr, i10, i11);
    }

    public static void J(ByteBuffer byteBuffer, long j10, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = jArr.length - i13;
        }
        l0.p(byteBuffer, "$this$storeULongArray");
        l0.p(jArr, "source");
        n.G(byteBuffer, j10, jArr, i13, i11);
    }

    public static final void K(@os.l ByteBuffer byteBuffer, int i10, @os.l short[] sArr, int i11, int i12) {
        l0.p(byteBuffer, "$this$storeUShortArray");
        l0.p(sArr, "source");
        n.K(byteBuffer, i10, sArr, i11, i12);
    }

    public static void L(ByteBuffer byteBuffer, int i10, short[] sArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = sArr.length - i11;
        }
        l0.p(byteBuffer, "$this$storeUShortArray");
        l0.p(sArr, "source");
        n.K(byteBuffer, i10, sArr, i11, i12);
    }

    public static final void M(@os.l ByteBuffer byteBuffer, long j10, @os.l short[] sArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$storeUShortArray");
        l0.p(sArr, "source");
        n.M(byteBuffer, j10, sArr, i10, i11);
    }

    public static void N(ByteBuffer byteBuffer, long j10, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = sArr.length - i13;
        }
        l0.p(byteBuffer, "$this$storeUShortArray");
        l0.p(sArr, "source");
        n.M(byteBuffer, j10, sArr, i13, i11);
    }

    public static final void a(@os.l ByteBuffer byteBuffer, int i10, @os.l byte[] bArr, int i11, int i12) {
        l0.p(byteBuffer, "$this$loadByteArray");
        l0.p(bArr, RtspHeaders.Values.DESTINATION);
        i.a(byteBuffer, bArr, i10, i12, i11);
    }

    public static /* synthetic */ void b(ByteBuffer byteBuffer, int i10, byte[] bArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = bArr.length - i11;
        }
        l0.p(byteBuffer, "$this$loadByteArray");
        l0.p(bArr, RtspHeaders.Values.DESTINATION);
        i.a(byteBuffer, bArr, i10, i12, i11);
    }

    public static final void c(@os.l ByteBuffer byteBuffer, long j10, @os.l byte[] bArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$loadByteArray");
        l0.p(bArr, RtspHeaders.Values.DESTINATION);
        i.c(byteBuffer, bArr, j10, i11, i10);
    }

    public static /* synthetic */ void d(ByteBuffer byteBuffer, long j10, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = bArr.length - i13;
        }
        l0.p(byteBuffer, "$this$loadByteArray");
        l0.p(bArr, RtspHeaders.Values.DESTINATION);
        i.c(byteBuffer, bArr, j10, i11, i13);
    }

    public static final void e(@os.l ByteBuffer byteBuffer, int i10, @os.l byte[] bArr, int i11, int i12) {
        l0.p(byteBuffer, "$this$loadUByteArray");
        l0.p(bArr, RtspHeaders.Values.DESTINATION);
        i.a(byteBuffer, bArr, i10, i12, i11);
    }

    public static void f(ByteBuffer byteBuffer, int i10, byte[] bArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = bArr.length - i11;
        }
        l0.p(byteBuffer, "$this$loadUByteArray");
        l0.p(bArr, RtspHeaders.Values.DESTINATION);
        i.a(byteBuffer, bArr, i10, i12, i11);
    }

    public static final void g(@os.l ByteBuffer byteBuffer, long j10, @os.l byte[] bArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$loadUByteArray");
        l0.p(bArr, RtspHeaders.Values.DESTINATION);
        i.c(byteBuffer, bArr, j10, i11, i10);
    }

    public static void h(ByteBuffer byteBuffer, long j10, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = bArr.length - i13;
        }
        l0.p(byteBuffer, "$this$loadUByteArray");
        l0.p(bArr, RtspHeaders.Values.DESTINATION);
        i.c(byteBuffer, bArr, j10, i11, i13);
    }

    public static final void i(@os.l ByteBuffer byteBuffer, long j10, @os.l int[] iArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$loadUIntArray");
        l0.p(iArr, RtspHeaders.Values.DESTINATION);
        n.k(byteBuffer, j10, iArr, i10, i11);
    }

    public static void j(ByteBuffer byteBuffer, long j10, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = iArr.length - i13;
        }
        l0.p(byteBuffer, "$this$loadUIntArray");
        l0.p(iArr, RtspHeaders.Values.DESTINATION);
        n.k(byteBuffer, j10, iArr, i13, i11);
    }

    public static final void k(@os.l ByteBuffer byteBuffer, int i10, @os.l int[] iArr, int i11, int i12) {
        l0.p(byteBuffer, "$this$loadUIntArray");
        l0.p(iArr, RtspHeaders.Values.DESTINATION);
        n.i(byteBuffer, i10, iArr, i11, i12);
    }

    public static void l(ByteBuffer byteBuffer, int i10, int[] iArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = iArr.length - i11;
        }
        l0.p(byteBuffer, "$this$loadUIntArray");
        l0.p(iArr, RtspHeaders.Values.DESTINATION);
        n.i(byteBuffer, i10, iArr, i11, i12);
    }

    public static final void m(@os.l ByteBuffer byteBuffer, int i10, @os.l long[] jArr, int i11, int i12) {
        l0.p(byteBuffer, "$this$loadULongArray");
        l0.p(jArr, RtspHeaders.Values.DESTINATION);
        n.o(byteBuffer, i10, jArr, i11, i12);
    }

    public static void n(ByteBuffer byteBuffer, int i10, long[] jArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = jArr.length - i11;
        }
        l0.p(byteBuffer, "$this$loadULongArray");
        l0.p(jArr, RtspHeaders.Values.DESTINATION);
        n.o(byteBuffer, i10, jArr, i11, i12);
    }

    public static final void o(@os.l ByteBuffer byteBuffer, long j10, @os.l long[] jArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$loadULongArray");
        l0.p(jArr, RtspHeaders.Values.DESTINATION);
        n.m(byteBuffer, j10, jArr, i10, i11);
    }

    public static void p(ByteBuffer byteBuffer, long j10, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = jArr.length - i13;
        }
        l0.p(byteBuffer, "$this$loadULongArray");
        l0.p(jArr, RtspHeaders.Values.DESTINATION);
        n.m(byteBuffer, j10, jArr, i13, i11);
    }

    public static final void q(@os.l ByteBuffer byteBuffer, int i10, @os.l short[] sArr, int i11, int i12) {
        l0.p(byteBuffer, "$this$loadUShortArray");
        l0.p(sArr, RtspHeaders.Values.DESTINATION);
        n.q(byteBuffer, i10, sArr, i11, i12);
    }

    public static void r(ByteBuffer byteBuffer, int i10, short[] sArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = sArr.length - i11;
        }
        l0.p(byteBuffer, "$this$loadUShortArray");
        l0.p(sArr, RtspHeaders.Values.DESTINATION);
        n.q(byteBuffer, i10, sArr, i11, i12);
    }

    public static final void s(@os.l ByteBuffer byteBuffer, long j10, @os.l short[] sArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$loadUShortArray");
        l0.p(sArr, RtspHeaders.Values.DESTINATION);
        n.s(byteBuffer, j10, sArr, i10, i11);
    }

    public static void t(ByteBuffer byteBuffer, long j10, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = sArr.length - i13;
        }
        l0.p(byteBuffer, "$this$loadUShortArray");
        l0.p(sArr, RtspHeaders.Values.DESTINATION);
        n.s(byteBuffer, j10, sArr, i13, i11);
    }

    public static final void u(@os.l ByteBuffer byteBuffer, int i10, @os.l byte[] bArr, int i11, int i12) {
        l0.p(byteBuffer, "$this$storeByteArray");
        l0.p(bArr, "source");
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr, i11, i12).slice().order(ByteOrder.BIG_ENDIAN);
        l0.o(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        f.d(f.c(byteBufferOrder), byteBuffer, 0, i12, i10);
    }

    public static /* synthetic */ void v(ByteBuffer byteBuffer, int i10, byte[] bArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = bArr.length - i11;
        }
        l0.p(byteBuffer, "$this$storeByteArray");
        l0.p(bArr, "source");
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr, i11, i12).slice().order(ByteOrder.BIG_ENDIAN);
        l0.o(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        f.d(f.c(byteBufferOrder), byteBuffer, 0, i12, i10);
    }

    public static final void w(@os.l ByteBuffer byteBuffer, long j10, @os.l byte[] bArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$storeByteArray");
        l0.p(bArr, "source");
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr, i10, i11).slice().order(ByteOrder.BIG_ENDIAN);
        l0.o(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        f.e(f.c(byteBufferOrder), byteBuffer, 0L, i11, j10);
    }

    public static /* synthetic */ void x(ByteBuffer byteBuffer, long j10, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = bArr.length - i10;
        }
        l0.p(byteBuffer, "$this$storeByteArray");
        l0.p(bArr, "source");
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr, i10, i11).slice().order(ByteOrder.BIG_ENDIAN);
        l0.o(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        f.e(f.c(byteBufferOrder), byteBuffer, 0L, i11, j10);
    }

    public static final void y(@os.l ByteBuffer byteBuffer, int i10, @os.l byte[] bArr, int i11, int i12) {
        l0.p(byteBuffer, "$this$storeUByteArray");
        l0.p(bArr, "source");
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr, i11, i12).slice().order(ByteOrder.BIG_ENDIAN);
        l0.o(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        f.d(f.c(byteBufferOrder), byteBuffer, 0, i12, i10);
    }

    public static void z(ByteBuffer byteBuffer, int i10, byte[] bArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = bArr.length - i11;
        }
        l0.p(byteBuffer, "$this$storeUByteArray");
        l0.p(bArr, "source");
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr, i11, i12).slice().order(ByteOrder.BIG_ENDIAN);
        l0.o(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        f.d(f.c(byteBufferOrder), byteBuffer, 0, i12, i10);
    }
}
