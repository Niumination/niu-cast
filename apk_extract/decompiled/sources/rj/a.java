package rj;

import java.io.EOFException;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import qj.f;
import qj.p;
import qj.u;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f9440a;

    static {
        Intrinsics.checkNotNullParameter("0123456789abcdef", "<this>");
        byte[] bytes = "0123456789abcdef".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        f9440a = bytes;
    }

    public static final String a(f fVar, long j8) throws EOFException {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        if (j8 > 0) {
            long j10 = j8 - 1;
            if (fVar.k(j10) == 13) {
                String strT = fVar.t(j10, Charsets.UTF_8);
                fVar.A(2L);
                return strT;
            }
        }
        fVar.getClass();
        String strT2 = fVar.t(j8, Charsets.UTF_8);
        fVar.A(1L);
        return strT2;
    }

    public static final int b(f fVar, p options, boolean z2) {
        int i8;
        byte[] bArr;
        int i9;
        int i10;
        u uVar;
        byte[] bArr2;
        int i11;
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        u uVar2 = fVar.f9194a;
        if (uVar2 == null) {
            return z2 ? -2 : -1;
        }
        int i12 = uVar2.f9225b;
        int i13 = uVar2.f9226c;
        int[] iArr = options.f9210b;
        byte[] bArr3 = uVar2.f9224a;
        u uVar3 = uVar2;
        int i14 = -1;
        int i15 = 0;
        loop0: while (true) {
            int i16 = i15 + 1;
            int i17 = iArr[i15];
            int i18 = i15 + 2;
            int i19 = iArr[i16];
            if (i19 != -1) {
                i14 = i19;
            }
            if (uVar3 == null) {
                break;
            }
            if (i17 >= 0) {
                int i20 = i12 + 1;
                int i21 = bArr3[i12] & UByte.MAX_VALUE;
                int i22 = i18 + i17;
                while (i18 != i22) {
                    if (i21 == iArr[i18]) {
                        i8 = iArr[i18 + i17];
                        if (i20 == i13) {
                            uVar3 = uVar3.f;
                            Intrinsics.checkNotNull(uVar3);
                            i10 = uVar3.f9225b;
                            i9 = uVar3.f9226c;
                            bArr = uVar3.f9224a;
                            if (uVar3 == uVar2) {
                                uVar3 = null;
                            }
                        } else {
                            bArr = bArr3;
                            i9 = i13;
                            i10 = i20;
                        }
                    } else {
                        i18++;
                    }
                }
                return i14;
            }
            int i23 = (i17 * (-1)) + i18;
            while (true) {
                int i24 = i12 + 1;
                int i25 = i18 + 1;
                if ((bArr3[i12] & UByte.MAX_VALUE) != iArr[i18]) {
                    return i14;
                }
                boolean z3 = i25 == i23;
                if (i24 == i13) {
                    Intrinsics.checkNotNull(uVar3);
                    u uVar4 = uVar3.f;
                    Intrinsics.checkNotNull(uVar4);
                    i11 = uVar4.f9225b;
                    int i26 = uVar4.f9226c;
                    bArr2 = uVar4.f9224a;
                    if (uVar4 != uVar2) {
                        uVar = uVar4;
                        i13 = i26;
                    } else {
                        if (!z3) {
                            break loop0;
                        }
                        i13 = i26;
                        uVar = null;
                    }
                } else {
                    uVar = uVar3;
                    bArr2 = bArr3;
                    i11 = i24;
                }
                if (z3) {
                    i8 = iArr[i25];
                    int i27 = i11;
                    i9 = i13;
                    i10 = i27;
                    byte[] bArr4 = bArr2;
                    uVar3 = uVar;
                    bArr = bArr4;
                    break;
                }
                i12 = i11;
                bArr3 = bArr2;
                uVar3 = uVar;
                i18 = i25;
            }
            if (i8 >= 0) {
                return i8;
            }
            byte[] bArr5 = bArr;
            i15 = -i8;
            i12 = i10;
            i13 = i9;
            bArr3 = bArr5;
        }
        if (z2) {
            return -2;
        }
        return i14;
    }
}
