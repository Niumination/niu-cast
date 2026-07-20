package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class LongVector extends BaseVector {
    public LongVector __assign(int i8, ByteBuffer byteBuffer) {
        __reset(i8, 8, byteBuffer);
        return this;
    }

    public long get(int i8) {
        return this.f1135bb.getLong(__element(i8));
    }
}
