package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class DoubleVector extends BaseVector {
    public DoubleVector __assign(int i8, ByteBuffer byteBuffer) {
        __reset(i8, 8, byteBuffer);
        return this;
    }

    public double get(int i8) {
        return this.f1135bb.getDouble(__element(i8));
    }
}
