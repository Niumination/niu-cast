package rl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g {
    public static long a(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13) {
        byteBuffer.position(i10 - byteBuffer.arrayOffset());
        return h.j(i11 - i12, i13);
    }
}
