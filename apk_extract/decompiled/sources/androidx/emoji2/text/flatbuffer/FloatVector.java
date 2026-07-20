package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class FloatVector extends BaseVector {
    public FloatVector __assign(int i8, ByteBuffer byteBuffer) {
        __reset(i8, 4, byteBuffer);
        return this;
    }

    public float get(int i8) {
        return this.f1135bb.getFloat(__element(i8));
    }
}
