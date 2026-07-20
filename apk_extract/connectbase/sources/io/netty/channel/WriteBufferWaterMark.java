package io.netty.channel;

import c.a;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes2.dex */
public final class WriteBufferWaterMark {
    public static final WriteBufferWaterMark DEFAULT = new WriteBufferWaterMark(32768, 65536, false);
    private static final int DEFAULT_HIGH_WATER_MARK = 65536;
    private static final int DEFAULT_LOW_WATER_MARK = 32768;
    private final int high;
    private final int low;

    public WriteBufferWaterMark(int i10, int i11) {
        this(i10, i11, true);
    }

    public int high() {
        return this.high;
    }

    public int low() {
        return this.low;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("WriteBufferWaterMark(low: ");
        sb2.append(this.low);
        sb2.append(", high: ");
        return a.a(sb2, this.high, ")");
    }

    public WriteBufferWaterMark(int i10, int i11, boolean z10) {
        if (z10) {
            ObjectUtil.checkPositiveOrZero(i10, "low");
            if (i11 < i10) {
                throw new IllegalArgumentException(e0.a.a("write buffer's high water mark cannot be less than  low water mark (", i10, "): ", i11));
            }
        }
        this.low = i10;
        this.high = i11;
    }
}
