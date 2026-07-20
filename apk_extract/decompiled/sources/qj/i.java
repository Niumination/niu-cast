package qj;

import java.io.EOFException;
import java.io.InputStream;
import k3.qc;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public static j a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 * 2;
            bArr[i8] = (byte) (rj.b.a(str.charAt(i9 + 1)) + (rj.b.a(str.charAt(i9)) << 4));
        }
        return new j(bArr);
    }

    public static j b(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        j jVar = new j(bytes);
        jVar.setUtf8$okio(str);
        return jVar;
    }

    public static j c(byte[] bArr, int i8, int i9) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i9 == -1234567890) {
            i9 = bArr.length;
        }
        qc.b(bArr.length, i8, i9);
        return new j(ArraysKt.copyOfRange(bArr, i8, i9 + i8));
    }

    public static j d(InputStream inputStream, int i8) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        if (i8 < 0) {
            throw new IllegalArgumentException(a1.a.o(i8, "byteCount < 0: ").toString());
        }
        byte[] bArr = new byte[i8];
        int i9 = 0;
        while (i9 < i8) {
            int i10 = inputStream.read(bArr, i9, i8 - i9);
            if (i10 == -1) {
                throw new EOFException();
            }
            i9 += i10;
        }
        return new j(bArr);
    }
}
