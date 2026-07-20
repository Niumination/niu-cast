package wi;

import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n {
    public static final int a(k kVar, ByteBuffer sink) throws EOFException {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        int iMin = -1;
        if (kVar.getBuffer().f10764c == 0) {
            kVar.request(8192L);
            if (kVar.getBuffer().f10764c == 0) {
                return -1;
            }
        }
        a buffer = kVar.getBuffer();
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!buffer.T()) {
            if (buffer.T()) {
                throw new IllegalArgumentException("Buffer is empty");
            }
            h hVar = buffer.f10762a;
            Intrinsics.checkNotNull(hVar);
            byte[] bArr = hVar.f10776a;
            int i8 = hVar.f10777b;
            iMin = Math.min(sink.remaining(), hVar.f10778c - i8);
            sink.put(bArr, i8, iMin);
            if (iMin != 0) {
                if (iMin < 0) {
                    throw new IllegalStateException("Returned negative read bytes count");
                }
                if (iMin > hVar.b()) {
                    throw new IllegalStateException("Returned too many bytes");
                }
                buffer.h(iMin);
            }
        }
        return iMin;
    }
}
