package z4;

import java.nio.ByteBuffer;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    @os.l
    public static final byte[] a(@os.l byte[] bArr, short s10, short s11) {
        l0.p(bArr, "<this>");
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 8);
        byteBufferAllocate.putShort(s11);
        byteBufferAllocate.putShort(s10);
        byteBufferAllocate.putInt(bArr.length);
        byteBufferAllocate.put(bArr);
        byte[] bArrArray = byteBufferAllocate.array();
        l0.o(bArrArray, "array(...)");
        return bArrArray;
    }
}
