package tl;

import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public final class r {
    public static final q b(ByteOrder byteOrder) {
        return byteOrder == ByteOrder.BIG_ENDIAN ? q.BIG_ENDIAN : q.LITTLE_ENDIAN;
    }
}
