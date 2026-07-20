package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import m.a;

/* JADX INFO: loaded from: classes3.dex */
final class PseudoRandomFunction {
    private PseudoRandomFunction() {
    }

    private static byte[] concat(byte[] bArr, byte[] bArr2) {
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length + bArr2.length);
        System.arraycopy(bArr2, 0, bArrCopyOf, bArr.length, bArr2.length);
        return bArrCopyOf;
    }

    public static byte[] hash(byte[] bArr, byte[] bArr2, byte[] bArr3, int i10, String str) {
        ObjectUtil.checkPositiveOrZero(i10, "length");
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(bArr, str));
            int iCeil = (int) Math.ceil(((double) i10) / ((double) mac.getMacLength()));
            byte[] bArrConcat = EmptyArrays.EMPTY_BYTES;
            byte[] bArrConcat2 = concat(bArr2, bArr3);
            byte[] bArrDoFinal = bArrConcat2;
            for (int i11 = 0; i11 < iCeil; i11++) {
                bArrDoFinal = mac.doFinal(bArrDoFinal);
                bArrConcat = concat(bArrConcat, mac.doFinal(concat(bArrDoFinal, bArrConcat2)));
            }
            return Arrays.copyOf(bArrConcat, i10);
        } catch (GeneralSecurityException e10) {
            throw new IllegalArgumentException(a.a("Could not find algo: ", str), e10);
        }
    }
}
