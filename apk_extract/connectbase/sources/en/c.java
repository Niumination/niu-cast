package en;

import kk.k;
import kn.r1;
import lm.f1;
import nm.p;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nBase64.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Base64.kt\nkotlin/io/encoding/Base64Kt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,643:1\n13384#2,3:644\n13384#2,3:647\n*S KotlinDebug\n*F\n+ 1 Base64.kt\nkotlin/io/encoding/Base64Kt\n*L\n580#1:644,3\n597#1:647,3\n*E\n"})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final byte[] f4570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final int[] f4571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final byte[] f4572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final int[] f4573d;

    static {
        byte[] bArr = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        f4570a = bArr;
        int[] iArr = new int[256];
        int i10 = 0;
        p.T1(iArr, -1, 0, 0, 6, null);
        iArr[61] = -2;
        int length = bArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            iArr[bArr[i11]] = i12;
            i11++;
            i12++;
        }
        f4571b = iArr;
        byte[] bArr2 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, k.f9234c, 95};
        f4572c = bArr2;
        int[] iArr2 = new int[256];
        p.T1(iArr2, -1, 0, 0, 6, null);
        iArr2[61] = -2;
        int length2 = bArr2.length;
        int i13 = 0;
        while (i10 < length2) {
            iArr2[bArr2[i10]] = i13;
            i10++;
            i13++;
        }
        f4573d = iArr2;
    }

    @f
    public static /* synthetic */ void e() {
    }

    @f
    public static /* synthetic */ void f() {
    }

    @f
    @f1(version = "1.8")
    public static final boolean g(int i10) {
        if (i10 >= 0) {
            int[] iArr = f4571b;
            if (i10 < iArr.length && iArr[i10] != -1) {
                return true;
            }
        }
        return false;
    }
}
