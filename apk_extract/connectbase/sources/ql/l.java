package ql;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.nio.ByteBuffer;
import kn.l0;
import lm.a2;
import lm.g2;
import lm.w1;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    public static final int a(@os.l ByteBuffer byteBuffer, long j10) {
        l0.p(byteBuffer, "$this$loadUIntAt");
        if (j10 < 2147483647L) {
            return w1.m(byteBuffer.getInt((int) j10));
        }
        throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
    }

    public static final int b(@os.l ByteBuffer byteBuffer, int i10) {
        l0.p(byteBuffer, "$this$loadUIntAt");
        return w1.m(byteBuffer.getInt(i10));
    }

    public static final long c(@os.l ByteBuffer byteBuffer, long j10) {
        l0.p(byteBuffer, "$this$loadULongAt");
        if (j10 < 2147483647L) {
            return a2.m(byteBuffer.getLong((int) j10));
        }
        throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
    }

    public static final long d(@os.l ByteBuffer byteBuffer, int i10) {
        l0.p(byteBuffer, "$this$loadULongAt");
        return a2.m(byteBuffer.getLong(i10));
    }

    public static final short e(@os.l ByteBuffer byteBuffer, long j10) {
        l0.p(byteBuffer, "$this$loadUShortAt");
        if (j10 < 2147483647L) {
            return g2.m(byteBuffer.getShort((int) j10));
        }
        throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
    }

    public static final short f(@os.l ByteBuffer byteBuffer, int i10) {
        l0.p(byteBuffer, "$this$loadUShortAt");
        return g2.m(byteBuffer.getShort(i10));
    }

    public static final void g(@os.l ByteBuffer byteBuffer, long j10, int i10) {
        l0.p(byteBuffer, "$this$storeUIntAt");
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        byteBuffer.putInt((int) j10, i10);
    }

    public static final void h(@os.l ByteBuffer byteBuffer, int i10, int i11) {
        l0.p(byteBuffer, "$this$storeUIntAt");
        byteBuffer.putInt(i10, i11);
    }

    public static final void i(@os.l ByteBuffer byteBuffer, int i10, long j10) {
        l0.p(byteBuffer, "$this$storeULongAt");
        byteBuffer.putLong(i10, j10);
    }

    public static final void j(@os.l ByteBuffer byteBuffer, long j10, long j11) {
        l0.p(byteBuffer, "$this$storeULongAt");
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        byteBuffer.putLong((int) j10, j11);
    }

    public static final void k(@os.l ByteBuffer byteBuffer, int i10, short s10) {
        l0.p(byteBuffer, "$this$storeUShortAt");
        byteBuffer.putShort(i10, s10);
    }

    public static final void l(@os.l ByteBuffer byteBuffer, long j10, short s10) {
        l0.p(byteBuffer, "$this$storeUShortAt");
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        byteBuffer.putShort((int) j10, s10);
    }
}
