package qj;

import kotlin.UByte;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f9177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f9178b;

    static {
        j.Companion.getClass();
        f9177a = i.b("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        f9178b = i.b("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    public static final String a(byte[] bArr, byte[] map) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i8 = 0;
        int i9 = 0;
        while (i8 < length) {
            byte b9 = bArr[i8];
            int i10 = i8 + 2;
            byte b10 = bArr[i8 + 1];
            i8 += 3;
            byte b11 = bArr[i10];
            bArr2[i9] = map[(b9 & UByte.MAX_VALUE) >> 2];
            bArr2[i9 + 1] = map[((b9 & 3) << 4) | ((b10 & UByte.MAX_VALUE) >> 4)];
            int i11 = i9 + 3;
            bArr2[i9 + 2] = map[((b10 & 15) << 2) | ((b11 & UByte.MAX_VALUE) >> 6)];
            i9 += 4;
            bArr2[i11] = map[b11 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b12 = bArr[i8];
            bArr2[i9] = map[(b12 & UByte.MAX_VALUE) >> 2];
            bArr2[i9 + 1] = map[(b12 & 3) << 4];
            bArr2[i9 + 2] = Base64.padSymbol;
            bArr2[i9 + 3] = Base64.padSymbol;
        } else if (length2 == 2) {
            int i12 = i8 + 1;
            byte b13 = bArr[i8];
            byte b14 = bArr[i12];
            bArr2[i9] = map[(b13 & UByte.MAX_VALUE) >> 2];
            bArr2[i9 + 1] = map[((b13 & 3) << 4) | ((b14 & UByte.MAX_VALUE) >> 4)];
            bArr2[i9 + 2] = map[(b14 & 15) << 2];
            bArr2[i9 + 3] = Base64.padSymbol;
        }
        Intrinsics.checkNotNullParameter(bArr2, "<this>");
        return new String(bArr2, Charsets.UTF_8);
    }
}
