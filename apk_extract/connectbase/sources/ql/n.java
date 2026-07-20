package ql;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.nio.ByteBuffer;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class n {
    public static final void A(@os.l ByteBuffer byteBuffer, long j10, @os.l float[] fArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$storeFloatArray");
        l0.p(fArr, "source");
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        y(byteBuffer, (int) j10, fArr, i10, i11);
    }

    public static /* synthetic */ void B(ByteBuffer byteBuffer, long j10, float[] fArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = fArr.length - i13;
        }
        A(byteBuffer, j10, fArr, i13, i11);
    }

    public static final void C(@os.l ByteBuffer byteBuffer, int i10, @os.l int[] iArr, int i11, int i12) {
        l0.p(byteBuffer, "$this$storeIntArray");
        l0.p(iArr, "source");
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        l0.m(byteBufferDuplicate);
        byteBufferDuplicate.position(i10);
        byteBufferDuplicate.asIntBuffer().put(iArr, i11, i12);
    }

    public static /* synthetic */ void D(ByteBuffer byteBuffer, int i10, int[] iArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = iArr.length - i11;
        }
        C(byteBuffer, i10, iArr, i11, i12);
    }

    public static final void E(@os.l ByteBuffer byteBuffer, long j10, @os.l int[] iArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$storeIntArray");
        l0.p(iArr, "source");
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        C(byteBuffer, (int) j10, iArr, i10, i11);
    }

    public static /* synthetic */ void F(ByteBuffer byteBuffer, long j10, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = iArr.length - i13;
        }
        E(byteBuffer, j10, iArr, i13, i11);
    }

    public static final void G(@os.l ByteBuffer byteBuffer, long j10, @os.l long[] jArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$storeLongArray");
        l0.p(jArr, "source");
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        I(byteBuffer, (int) j10, jArr, i10, i11);
    }

    public static /* synthetic */ void H(ByteBuffer byteBuffer, long j10, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = jArr.length - i13;
        }
        G(byteBuffer, j10, jArr, i13, i11);
    }

    public static final void I(@os.l ByteBuffer byteBuffer, int i10, @os.l long[] jArr, int i11, int i12) {
        l0.p(byteBuffer, "$this$storeLongArray");
        l0.p(jArr, "source");
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        l0.m(byteBufferDuplicate);
        byteBufferDuplicate.position(i10);
        byteBufferDuplicate.asLongBuffer().put(jArr, i11, i12);
    }

    public static /* synthetic */ void J(ByteBuffer byteBuffer, int i10, long[] jArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = jArr.length - i11;
        }
        I(byteBuffer, i10, jArr, i11, i12);
    }

    public static final void K(@os.l ByteBuffer byteBuffer, int i10, @os.l short[] sArr, int i11, int i12) {
        l0.p(byteBuffer, "$this$storeShortArray");
        l0.p(sArr, "source");
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        l0.m(byteBufferDuplicate);
        byteBufferDuplicate.position(i10);
        byteBufferDuplicate.asShortBuffer().put(sArr, i11, i12);
    }

    public static /* synthetic */ void L(ByteBuffer byteBuffer, int i10, short[] sArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = sArr.length - i11;
        }
        K(byteBuffer, i10, sArr, i11, i12);
    }

    public static final void M(@os.l ByteBuffer byteBuffer, long j10, @os.l short[] sArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$storeShortArray");
        l0.p(sArr, "source");
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        K(byteBuffer, (int) j10, sArr, i10, i11);
    }

    public static /* synthetic */ void N(ByteBuffer byteBuffer, long j10, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = sArr.length - i13;
        }
        M(byteBuffer, j10, sArr, i13, i11);
    }

    public static final ByteBuffer O(ByteBuffer byteBuffer, int i10) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        l0.m(byteBufferDuplicate);
        byteBufferDuplicate.position(i10);
        return byteBufferDuplicate;
    }

    public static final void a(@os.l ByteBuffer byteBuffer, int i10, @os.l double[] dArr, int i11, int i12) {
        l0.p(byteBuffer, "$this$loadDoubleArray");
        l0.p(dArr, RtspHeaders.Values.DESTINATION);
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        l0.m(byteBufferDuplicate);
        byteBufferDuplicate.position(i10);
        byteBufferDuplicate.asDoubleBuffer().get(dArr, i11, i12);
    }

    public static /* synthetic */ void b(ByteBuffer byteBuffer, int i10, double[] dArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = dArr.length - i11;
        }
        a(byteBuffer, i10, dArr, i11, i12);
    }

    public static final void c(@os.l ByteBuffer byteBuffer, long j10, @os.l double[] dArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$loadDoubleArray");
        l0.p(dArr, RtspHeaders.Values.DESTINATION);
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        a(byteBuffer, (int) j10, dArr, i10, i11);
    }

    public static /* synthetic */ void d(ByteBuffer byteBuffer, long j10, double[] dArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = dArr.length - i13;
        }
        c(byteBuffer, j10, dArr, i13, i11);
    }

    public static final void e(@os.l ByteBuffer byteBuffer, int i10, @os.l float[] fArr, int i11, int i12) {
        l0.p(byteBuffer, "$this$loadFloatArray");
        l0.p(fArr, RtspHeaders.Values.DESTINATION);
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        l0.m(byteBufferDuplicate);
        byteBufferDuplicate.position(i10);
        byteBufferDuplicate.asFloatBuffer().get(fArr, i11, i12);
    }

    public static /* synthetic */ void f(ByteBuffer byteBuffer, int i10, float[] fArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = fArr.length - i11;
        }
        e(byteBuffer, i10, fArr, i11, i12);
    }

    public static final void g(@os.l ByteBuffer byteBuffer, long j10, @os.l float[] fArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$loadFloatArray");
        l0.p(fArr, RtspHeaders.Values.DESTINATION);
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        e(byteBuffer, (int) j10, fArr, i10, i11);
    }

    public static /* synthetic */ void h(ByteBuffer byteBuffer, long j10, float[] fArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = fArr.length - i13;
        }
        g(byteBuffer, j10, fArr, i13, i11);
    }

    public static final void i(@os.l ByteBuffer byteBuffer, int i10, @os.l int[] iArr, int i11, int i12) {
        l0.p(byteBuffer, "$this$loadIntArray");
        l0.p(iArr, RtspHeaders.Values.DESTINATION);
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        l0.m(byteBufferDuplicate);
        byteBufferDuplicate.position(i10);
        byteBufferDuplicate.asIntBuffer().get(iArr, i11, i12);
    }

    public static /* synthetic */ void j(ByteBuffer byteBuffer, int i10, int[] iArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = iArr.length - i11;
        }
        i(byteBuffer, i10, iArr, i11, i12);
    }

    public static final void k(@os.l ByteBuffer byteBuffer, long j10, @os.l int[] iArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$loadIntArray");
        l0.p(iArr, RtspHeaders.Values.DESTINATION);
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        i(byteBuffer, (int) j10, iArr, i10, i11);
    }

    public static /* synthetic */ void l(ByteBuffer byteBuffer, long j10, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = iArr.length - i13;
        }
        k(byteBuffer, j10, iArr, i13, i11);
    }

    public static final void m(@os.l ByteBuffer byteBuffer, long j10, @os.l long[] jArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$loadLongArray");
        l0.p(jArr, RtspHeaders.Values.DESTINATION);
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        o(byteBuffer, (int) j10, jArr, i10, i11);
    }

    public static /* synthetic */ void n(ByteBuffer byteBuffer, long j10, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = jArr.length - i13;
        }
        m(byteBuffer, j10, jArr, i13, i11);
    }

    public static final void o(@os.l ByteBuffer byteBuffer, int i10, @os.l long[] jArr, int i11, int i12) {
        l0.p(byteBuffer, "$this$loadLongArray");
        l0.p(jArr, RtspHeaders.Values.DESTINATION);
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        l0.m(byteBufferDuplicate);
        byteBufferDuplicate.position(i10);
        byteBufferDuplicate.asLongBuffer().get(jArr, i11, i12);
    }

    public static /* synthetic */ void p(ByteBuffer byteBuffer, int i10, long[] jArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = jArr.length - i11;
        }
        o(byteBuffer, i10, jArr, i11, i12);
    }

    public static final void q(@os.l ByteBuffer byteBuffer, int i10, @os.l short[] sArr, int i11, int i12) {
        l0.p(byteBuffer, "$this$loadShortArray");
        l0.p(sArr, RtspHeaders.Values.DESTINATION);
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        l0.m(byteBufferDuplicate);
        byteBufferDuplicate.position(i10);
        byteBufferDuplicate.asShortBuffer().get(sArr, i11, i12);
    }

    public static /* synthetic */ void r(ByteBuffer byteBuffer, int i10, short[] sArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = sArr.length - i11;
        }
        q(byteBuffer, i10, sArr, i11, i12);
    }

    public static final void s(@os.l ByteBuffer byteBuffer, long j10, @os.l short[] sArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$loadShortArray");
        l0.p(sArr, RtspHeaders.Values.DESTINATION);
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        q(byteBuffer, (int) j10, sArr, i10, i11);
    }

    public static /* synthetic */ void t(ByteBuffer byteBuffer, long j10, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = sArr.length - i13;
        }
        s(byteBuffer, j10, sArr, i13, i11);
    }

    public static final void u(@os.l ByteBuffer byteBuffer, int i10, @os.l double[] dArr, int i11, int i12) {
        l0.p(byteBuffer, "$this$storeDoubleArray");
        l0.p(dArr, "source");
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        l0.m(byteBufferDuplicate);
        byteBufferDuplicate.position(i10);
        byteBufferDuplicate.asDoubleBuffer().put(dArr, i11, i12);
    }

    public static /* synthetic */ void v(ByteBuffer byteBuffer, int i10, double[] dArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = dArr.length - i11;
        }
        u(byteBuffer, i10, dArr, i11, i12);
    }

    public static final void w(@os.l ByteBuffer byteBuffer, long j10, @os.l double[] dArr, int i10, int i11) {
        l0.p(byteBuffer, "$this$storeDoubleArray");
        l0.p(dArr, "source");
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        u(byteBuffer, (int) j10, dArr, i10, i11);
    }

    public static /* synthetic */ void x(ByteBuffer byteBuffer, long j10, double[] dArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = dArr.length - i13;
        }
        w(byteBuffer, j10, dArr, i13, i11);
    }

    public static final void y(@os.l ByteBuffer byteBuffer, int i10, @os.l float[] fArr, int i11, int i12) {
        l0.p(byteBuffer, "$this$storeFloatArray");
        l0.p(fArr, "source");
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        l0.m(byteBufferDuplicate);
        byteBufferDuplicate.position(i10);
        byteBufferDuplicate.asFloatBuffer().put(fArr, i11, i12);
    }

    public static /* synthetic */ void z(ByteBuffer byteBuffer, int i10, float[] fArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = fArr.length - i11;
        }
        y(byteBuffer, i10, fArr, i11, i12);
    }
}
