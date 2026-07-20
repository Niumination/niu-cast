package k3;

import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class qb {
    public static final int a(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int iM177constructorimpl = 0;
        if (bArr.length <= 4) {
            for (int length = bArr.length - 1; length >= 0; length--) {
                iM177constructorimpl |= (UByte.m177constructorimpl(bArr[length]) & UByte.MAX_VALUE) << (((bArr.length - 1) - length) * 8);
            }
        }
        return iM177constructorimpl;
    }
}
