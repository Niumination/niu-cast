package zg;

import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    static {
        int[] iArr = new int[256];
        for (int i8 = 0; i8 < 256; i8++) {
            iArr[i8] = StringsKt__StringsKt.indexOf$default("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", (char) i8, 0, false, 6, (Object) null);
        }
    }

    public static final String a(byte[] bArr) {
        int i8;
        int i9;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int i10 = 3;
        char[] cArr = new char[((bArr.length * 8) / 6) + 3];
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = i11 + 3;
            if (i13 > bArr.length) {
                break;
            }
            byte b9 = bArr[i11];
            byte b10 = bArr[i11 + 1];
            int i14 = (bArr[i11 + 2] & UByte.MAX_VALUE) | ((b9 & UByte.MAX_VALUE) << 16) | ((b10 & UByte.MAX_VALUE) << 8);
            int i15 = 3;
            while (-1 < i15) {
                cArr[i12] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i14 >> (i15 * 6)) & 63);
                i15--;
                i12++;
            }
            i11 = i13;
        }
        int length = bArr.length - i11;
        if (length == 0) {
            return StringsKt.concatToString(cArr, 0, i12);
        }
        if (length == 1) {
            i8 = (bArr[i11] & UByte.MAX_VALUE) << 16;
        } else {
            i8 = ((bArr[i11 + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i11] & UByte.MAX_VALUE) << 16);
        }
        int i16 = ((3 - length) * 8) / 6;
        if (i16 <= 3) {
            while (true) {
                i9 = i12 + 1;
                cArr[i12] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i8 >> (i10 * 6)) & 63);
                if (i10 == i16) {
                    break;
                }
                i10--;
                i12 = i9;
            }
            i12 = i9;
        }
        int i17 = 0;
        while (i17 < i16) {
            cArr[i12] = '=';
            i17++;
            i12++;
        }
        return StringsKt.concatToString(cArr, 0, i12);
    }
}
