package mk;

import java.nio.ByteBuffer;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class s {
    public static final void a(@os.l ByteBuffer byteBuffer, @os.l ByteBuffer byteBuffer2) {
        l0.p(byteBuffer, "<this>");
        l0.p(byteBuffer2, "other");
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        ByteBuffer byteBufferSlice2 = byteBuffer2.slice();
        int iRemaining = byteBufferSlice2.remaining();
        int iRemaining2 = byteBufferSlice.remaining();
        for (int i10 = 0; i10 < iRemaining2; i10++) {
            byteBufferSlice.put(i10, (byte) (byteBufferSlice.get(i10) ^ byteBufferSlice2.get(i10 % iRemaining)));
        }
    }
}
