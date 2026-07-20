package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import lm.g2;

/* JADX INFO: loaded from: classes.dex */
public final class ShortVector extends BaseVector {
    public ShortVector __assign(int i10, ByteBuffer byteBuffer) {
        __reset(i10, 2, byteBuffer);
        return this;
    }

    public short get(int i10) {
        return this.f505bb.getShort(__element(i10));
    }

    public int getAsUnsigned(int i10) {
        return get(i10) & g2.f10190d;
    }
}
