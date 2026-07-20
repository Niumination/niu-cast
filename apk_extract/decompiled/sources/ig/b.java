package ig;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f5864a;

    static {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(0);
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
        f5864a = byteBufferAllocate;
    }

    public static final void a(long j8, byte[] bArr, int i8) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        for (int i9 = 0; i9 < 8; i9++) {
            bArr[i9 + i8] = (byte) (j8 >>> ((7 - i9) * 8));
        }
    }

    public static final void b(byte[] bArr, short s2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        for (int i8 = 0; i8 < 2; i8++) {
            bArr[i8 + 11] = (byte) (s2 >>> ((1 - i8) * 8));
        }
    }
}
