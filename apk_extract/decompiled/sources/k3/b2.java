package k3;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class b2 {
    /* JADX WARN: Code duplicated, block: B:35:0x0061  */
    /* JADX WARN: Code duplicated, block: B:50:0x008c A[LOOP:2: B:25:0x004b->B:50:0x008c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00af A[LOOP:1: B:56:0x00a2->B:60:0x00af, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:83:0x00b5 A[EDGE_INSN: B:83:0x00b5->B:61:0x00b5 BREAK  A[LOOP:1: B:56:0x00a2->B:60:0x00af], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x009f A[SYNTHETIC] */
    public static final InetAddress a(int i8, int i9, String str) {
        int i10;
        int i11;
        int i12;
        char cCharAt;
        int i13;
        int i14;
        int iR;
        int i15 = 16;
        byte[] bArr = new byte[16];
        int i16 = 0;
        int i17 = i8;
        int i18 = -1;
        int i19 = -1;
        while (true) {
            if (i17 >= i9) {
                i10 = i15;
                break;
            }
            if (i16 == i15) {
                return null;
            }
            int i20 = i17 + 2;
            if (i20 <= i9 && StringsKt__StringsJVMKt.startsWith$default(str, "::", i17, false, 4, null)) {
                if (i18 != -1) {
                    return null;
                }
                i16 += 2;
                if (i20 == i9) {
                    i10 = i15;
                    i18 = i16;
                    break;
                }
                i18 = i16;
                i19 = i20;
                i17 = i19;
                i13 = 0;
                while (i17 < i9) {
                    iR = ej.b.r(str.charAt(i17));
                    if (iR == -1) {
                        break;
                        break;
                    }
                    i13 = (i13 << 4) + iR;
                    i17++;
                }
                i14 = i17 - i19;
                if (i14 != 0) {
                }
                return null;
            }
            if (i16 != 0) {
                if (!StringsKt__StringsJVMKt.startsWith$default(str, ":", i17, false, 4, null)) {
                    if (StringsKt__StringsJVMKt.startsWith$default(str, ".", i17, false, 4, null)) {
                        int i21 = i16 - 2;
                        int i22 = i21;
                        while (i19 < i9) {
                            if (i22 != i15) {
                                if (i22 == i21) {
                                    i11 = i19;
                                    i12 = 0;
                                    while (i11 < i9) {
                                        cCharAt = str.charAt(i11);
                                        if (Intrinsics.compare((int) cCharAt, 48) < 0 || Intrinsics.compare((int) cCharAt, 57) > 0) {
                                            break;
                                        }
                                        if ((i12 != 0 || i19 == i11) && (i12 = ((i12 * 10) + cCharAt) - 48) <= 255) {
                                            i11++;
                                        }
                                    }
                                    if (i11 - i19 == 0) {
                                        bArr[i22] = (byte) i12;
                                        i22++;
                                        i19 = i11;
                                        i15 = 16;
                                    }
                                } else if (str.charAt(i19) == '.') {
                                    i19++;
                                    i11 = i19;
                                    i12 = 0;
                                    while (i11 < i9) {
                                        cCharAt = str.charAt(i11);
                                        if (Intrinsics.compare((int) cCharAt, 48) < 0) {
                                            break;
                                        }
                                        break;
                                        break;
                                    }
                                    if (i11 - i19 == 0) {
                                        bArr[i22] = (byte) i12;
                                        i22++;
                                        i19 = i11;
                                        i15 = 16;
                                    }
                                }
                            }
                        }
                        if (i22 == i16 + 2) {
                            i16 += 2;
                            i10 = 16;
                            break;
                        }
                    }
                    return null;
                }
                i17++;
            }
            i19 = i17;
            i17 = i19;
            i13 = 0;
            while (i17 < i9) {
                iR = ej.b.r(str.charAt(i17));
                if (iR == -1) {
                    break;
                }
                i13 = (i13 << 4) + iR;
                i17++;
            }
            i14 = i17 - i19;
            if (i14 != 0 || i14 > 4) {
                return null;
            }
            int i23 = i16 + 1;
            bArr[i16] = (byte) ((i13 >>> 8) & 255);
            i16 += 2;
            bArr[i23] = (byte) (i13 & 255);
            i15 = 16;
        }
        if (i16 != i10) {
            if (i18 == -1) {
                return null;
            }
            int i24 = i16 - i18;
            System.arraycopy(bArr, i18, bArr, 16 - i24, i24);
            Arrays.fill(bArr, i18, (16 - i16) + i18, (byte) 0);
        }
        return InetAddress.getByAddress(bArr);
    }

    public static final String b(String toCanonicalHost) {
        int i8;
        Intrinsics.checkNotNullParameter(toCanonicalHost, "$this$toCanonicalHost");
        int i9 = 0;
        int i10 = -1;
        if (!StringsKt__StringsKt.contains$default(toCanonicalHost, ":", false, 2, (Object) null)) {
            try {
                String ascii = IDN.toASCII(toCanonicalHost);
                Intrinsics.checkNotNullExpressionValue(ascii, "IDN.toASCII(host)");
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
                if (ascii == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = ascii.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() == 0) {
                    return null;
                }
                int length = lowerCase.length();
                for (0; i8 < length; i8 + 1) {
                    char cCharAt = lowerCase.charAt(i8);
                    i8 = (Intrinsics.compare((int) cCharAt, 31) > 0 && Intrinsics.compare((int) cCharAt, 127) < 0 && StringsKt__StringsKt.indexOf$default(" #%/:?@[\\]", cCharAt, 0, false, 6, (Object) null) == -1) ? i8 + 1 : 0;
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressA = (StringsKt__StringsJVMKt.startsWith$default(toCanonicalHost, "[", false, 2, null) && StringsKt__StringsJVMKt.endsWith$default(toCanonicalHost, "]", false, 2, null)) ? a(1, toCanonicalHost.length() - 1, toCanonicalHost) : a(0, toCanonicalHost.length(), toCanonicalHost);
        if (inetAddressA == null) {
            return null;
        }
        byte[] address = inetAddressA.getAddress();
        if (address.length != 16) {
            if (address.length == 4) {
                return inetAddressA.getHostAddress();
            }
            throw new AssertionError("Invalid IPv6 address: '" + toCanonicalHost + '\'');
        }
        Intrinsics.checkNotNullExpressionValue(address, "address");
        int i11 = 0;
        int i12 = 0;
        while (i11 < address.length) {
            int i13 = i11;
            while (i13 < 16 && address[i13] == 0 && address[i13 + 1] == 0) {
                i13 += 2;
            }
            int i14 = i13 - i11;
            if (i14 > i12 && i14 >= 4) {
                i10 = i11;
                i12 = i14;
            }
            i11 = i13 + 2;
        }
        qj.f fVar = new qj.f();
        while (i9 < address.length) {
            if (i9 == i10) {
                fVar.S(58);
                i9 += i12;
                if (i9 == 16) {
                    fVar.S(58);
                }
            } else {
                if (i9 > 0) {
                    fVar.S(58);
                }
                byte b9 = address[i9];
                byte[] bArr = ej.b.f4964a;
                fVar.a0(((b9 & UByte.MAX_VALUE) << 8) | (address[i9 + 1] & UByte.MAX_VALUE));
                i9 += 2;
            }
        }
        return fVar.w();
    }
}
