package ql;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.nio.ByteBuffer;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public static final double a(@os.l ByteBuffer byteBuffer, long j10) {
        l0.p(byteBuffer, "$this$loadDoubleAt");
        if (j10 < 2147483647L) {
            return byteBuffer.getDouble((int) j10);
        }
        throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
    }

    public static final double b(@os.l ByteBuffer byteBuffer, int i10) {
        l0.p(byteBuffer, "$this$loadDoubleAt");
        return byteBuffer.getDouble(i10);
    }

    public static final float c(@os.l ByteBuffer byteBuffer, long j10) {
        l0.p(byteBuffer, "$this$loadFloatAt");
        if (j10 < 2147483647L) {
            return byteBuffer.getFloat((int) j10);
        }
        throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
    }

    public static final float d(@os.l ByteBuffer byteBuffer, int i10) {
        l0.p(byteBuffer, "$this$loadFloatAt");
        return byteBuffer.getFloat(i10);
    }

    public static final int e(@os.l ByteBuffer byteBuffer, long j10) {
        l0.p(byteBuffer, "$this$loadIntAt");
        if (j10 < 2147483647L) {
            return byteBuffer.getInt((int) j10);
        }
        throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
    }

    public static final int f(@os.l ByteBuffer byteBuffer, int i10) {
        l0.p(byteBuffer, "$this$loadIntAt");
        return byteBuffer.getInt(i10);
    }

    public static final long g(@os.l ByteBuffer byteBuffer, long j10) {
        l0.p(byteBuffer, "$this$loadLongAt");
        if (j10 < 2147483647L) {
            return byteBuffer.getLong((int) j10);
        }
        throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
    }

    public static final long h(@os.l ByteBuffer byteBuffer, int i10) {
        l0.p(byteBuffer, "$this$loadLongAt");
        return byteBuffer.getLong(i10);
    }

    public static final short i(@os.l ByteBuffer byteBuffer, long j10) {
        l0.p(byteBuffer, "$this$loadShortAt");
        if (j10 < 2147483647L) {
            return byteBuffer.getShort((int) j10);
        }
        throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
    }

    public static final short j(@os.l ByteBuffer byteBuffer, int i10) {
        l0.p(byteBuffer, "$this$loadShortAt");
        return byteBuffer.getShort(i10);
    }

    public static final void k(@os.l ByteBuffer byteBuffer, long j10, double d10) {
        l0.p(byteBuffer, "$this$storeDoubleAt");
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        byteBuffer.putDouble((int) j10, d10);
    }

    public static final void l(@os.l ByteBuffer byteBuffer, int i10, double d10) {
        l0.p(byteBuffer, "$this$storeDoubleAt");
        byteBuffer.putDouble(i10, d10);
    }

    public static final void m(@os.l ByteBuffer byteBuffer, int i10, float f10) {
        l0.p(byteBuffer, "$this$storeFloatAt");
        byteBuffer.putFloat(i10, f10);
    }

    public static final void n(@os.l ByteBuffer byteBuffer, long j10, float f10) {
        l0.p(byteBuffer, "$this$storeFloatAt");
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        byteBuffer.putFloat((int) j10, f10);
    }

    public static final void o(@os.l ByteBuffer byteBuffer, int i10, int i11) {
        l0.p(byteBuffer, "$this$storeIntAt");
        byteBuffer.putInt(i10, i11);
    }

    public static final void p(@os.l ByteBuffer byteBuffer, long j10, int i10) {
        l0.p(byteBuffer, "$this$storeIntAt");
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        byteBuffer.putInt((int) j10, i10);
    }

    public static final void q(@os.l ByteBuffer byteBuffer, long j10, long j11) {
        l0.p(byteBuffer, "$this$storeLongAt");
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        byteBuffer.putLong((int) j10, j11);
    }

    public static final void r(@os.l ByteBuffer byteBuffer, int i10, long j10) {
        l0.p(byteBuffer, "$this$storeLongAt");
        byteBuffer.putLong(i10, j10);
    }

    public static final void s(@os.l ByteBuffer byteBuffer, int i10, short s10) {
        l0.p(byteBuffer, "$this$storeShortAt");
        byteBuffer.putShort(i10, s10);
    }

    public static final void t(@os.l ByteBuffer byteBuffer, long j10, short s10) {
        l0.p(byteBuffer, "$this$storeShortAt");
        if (j10 >= 2147483647L) {
            throw d.a(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        byteBuffer.putShort((int) j10, s10);
    }
}
