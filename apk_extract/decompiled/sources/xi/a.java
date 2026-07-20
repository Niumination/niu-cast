package xi;

import java.util.Arrays;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Comparable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f11006c = new a(new byte[0]);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char[] f11007d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f11008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11009b;

    static {
        char[] charArray = "0123456789abcdef".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        f11007d = charArray;
    }

    public a(byte[] bArr) {
        this.f11008a = bArr;
    }

    public final byte a(int i8) {
        byte[] bArr = this.f11008a;
        if (i8 < 0 || i8 >= bArr.length) {
            throw new IndexOutOfBoundsException(a1.a.r(a1.a.u(i8, "index (", ") is out of byte string bounds: [0.."), bArr.length, ')'));
        }
        return bArr[i8];
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        a other = (a) obj;
        Intrinsics.checkNotNullParameter(other, "other");
        if (other == this) {
            return 0;
        }
        byte[] bArr = other.f11008a;
        byte[] bArr2 = this.f11008a;
        int iMin = Math.min(bArr2.length, bArr.length);
        for (int i8 = 0; i8 < iMin; i8++) {
            int iCompare = Intrinsics.compare(UByte.m177constructorimpl(bArr2[i8]) & UByte.MAX_VALUE, UByte.m177constructorimpl(bArr[i8]) & UByte.MAX_VALUE);
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Intrinsics.compare(bArr2.length, other.f11008a.length);
    }

    public final boolean equals(Object obj) {
        int i8;
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        byte[] bArr = aVar.f11008a;
        int length = bArr.length;
        byte[] bArr2 = this.f11008a;
        if (length != bArr2.length) {
            return false;
        }
        int i9 = aVar.f11009b;
        if (i9 == 0 || (i8 = this.f11009b) == 0 || i9 == i8) {
            return Arrays.equals(bArr2, bArr);
        }
        return false;
    }

    public final int hashCode() {
        int i8 = this.f11009b;
        if (i8 != 0) {
            return i8;
        }
        int iHashCode = Arrays.hashCode(this.f11008a);
        this.f11009b = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        byte[] bArr = this.f11008a;
        if (bArr.length == 0) {
            return "ByteString(size=0)";
        }
        String strValueOf = String.valueOf(bArr.length);
        StringBuilder sb2 = new StringBuilder((bArr.length * 2) + strValueOf.length() + 22);
        sb2.append("ByteString(size=");
        sb2.append(strValueOf);
        sb2.append(" hex=");
        for (byte b9 : bArr) {
            char[] cArr = f11007d;
            sb2.append(cArr[(b9 >>> 4) & 15]);
            sb2.append(cArr[b9 & 15]);
        }
        return a1.a.q(sb2, ')', "toString(...)");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(byte[] data, int i8, int i9) {
        this(ArraysKt.copyOfRange(data, i8, i9));
        Intrinsics.checkNotNullParameter(data, "data");
    }
}
