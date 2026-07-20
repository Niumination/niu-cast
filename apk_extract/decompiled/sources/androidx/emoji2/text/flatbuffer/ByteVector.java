package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class ByteVector extends BaseVector {
    public ByteVector __assign(int i8, ByteBuffer byteBuffer) {
        __reset(i8, 1, byteBuffer);
        return this;
    }

    public byte get(int i8) {
        return this.f1135bb.get(__element(i8));
    }

    public int getAsUnsigned(int i8) {
        return get(i8) & UByte.MAX_VALUE;
    }
}
