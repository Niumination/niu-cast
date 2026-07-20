package m3;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class n6 {
    public static final int a(ByteBuffer byteBuffer, ByteBuffer destination, int i8) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        int iMin = Math.min(i8, Math.min(byteBuffer.remaining(), destination.remaining()));
        if (iMin == byteBuffer.remaining()) {
            destination.put(byteBuffer);
        } else {
            int iLimit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + iMin);
            destination.put(byteBuffer);
            byteBuffer.limit(iLimit);
        }
        return iMin;
    }
}
