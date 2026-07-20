package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public class BitEncoding {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean FORCE_8TO7_ENCODING;

    private static /* synthetic */ void $$$reportNull$$$0(int i8) {
        String str = (i8 == 1 || i8 == 3 || i8 == 6 || i8 == 8 || i8 == 10 || i8 == 12 || i8 == 14) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i8 == 1 || i8 == 3 || i8 == 6 || i8 == 8 || i8 == 10 || i8 == 12 || i8 == 14) ? 2 : 3];
        if (i8 == 1 || i8 == 3 || i8 == 6 || i8 == 8 || i8 == 10 || i8 == 12 || i8 == 14) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
        } else {
            objArr[0] = "data";
        }
        if (i8 == 1) {
            objArr[1] = "encodeBytes";
        } else if (i8 == 3) {
            objArr[1] = "encode8to7";
        } else if (i8 == 6) {
            objArr[1] = "splitBytesToStringArray";
        } else if (i8 == 8) {
            objArr[1] = "decodeBytes";
        } else if (i8 == 10) {
            objArr[1] = "dropMarker";
        } else if (i8 == 12) {
            objArr[1] = "combineStringArrayIntoBytes";
        } else if (i8 != 14) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
        } else {
            objArr[1] = "decode7to8";
        }
        switch (i8) {
            case 1:
            case 3:
            case 6:
            case 8:
            case 10:
            case 12:
            case 14:
                break;
            case 2:
                objArr[2] = "encode8to7";
                break;
            case 4:
                objArr[2] = "addModuloByte";
                break;
            case 5:
                objArr[2] = "splitBytesToStringArray";
                break;
            case 7:
                objArr[2] = "decodeBytes";
                break;
            case 9:
                objArr[2] = "dropMarker";
                break;
            case 11:
                objArr[2] = "combineStringArrayIntoBytes";
                break;
            case 13:
                objArr[2] = "decode7to8";
                break;
            default:
                objArr[2] = "encodeBytes";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i8 != 1 && i8 != 3 && i8 != 6 && i8 != 8 && i8 != 10 && i8 != 12 && i8 != 14) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    static {
        String property;
        try {
            property = System.getProperty("kotlin.jvm.serialization.use8to7");
        } catch (SecurityException unused) {
            property = null;
        }
        FORCE_8TO7_ENCODING = "true".equals(property);
    }

    private BitEncoding() {
    }

    private static void addModuloByte(byte[] bArr, int i8) {
        if (bArr == null) {
            $$$reportNull$$$0(4);
        }
        int length = bArr.length;
        for (int i9 = 0; i9 < length; i9++) {
            bArr[i9] = (byte) ((bArr[i9] + i8) & 127);
        }
    }

    private static byte[] combineStringArrayIntoBytes(String[] strArr) {
        if (strArr == null) {
            $$$reportNull$$$0(11);
        }
        int length = 0;
        for (String str : strArr) {
            length += str.length();
        }
        byte[] bArr = new byte[length];
        int i8 = 0;
        for (String str2 : strArr) {
            int length2 = str2.length();
            int i9 = 0;
            while (i9 < length2) {
                bArr[i8] = (byte) str2.charAt(i9);
                i9++;
                i8++;
            }
        }
        return bArr;
    }

    private static byte[] decode7to8(byte[] bArr) {
        if (bArr == null) {
            $$$reportNull$$$0(13);
        }
        int length = (bArr.length * 7) / 8;
        byte[] bArr2 = new byte[length];
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i8 + 1;
            int i12 = i9 + 1;
            bArr2[i10] = (byte) (((bArr[i8] & UByte.MAX_VALUE) >>> i9) + ((bArr[i11] & ((1 << i12) - 1)) << (7 - i9)));
            if (i9 == 6) {
                i8 += 2;
                i9 = 0;
            } else {
                i8 = i11;
                i9 = i12;
            }
        }
        return bArr2;
    }

    public static byte[] decodeBytes(String[] strArr) {
        if (strArr == null) {
            $$$reportNull$$$0(7);
        }
        if (strArr.length > 0 && !strArr[0].isEmpty()) {
            char cCharAt = strArr[0].charAt(0);
            if (cCharAt == 0) {
                byte[] bArrStringsToBytes = UtfEncodingKt.stringsToBytes(dropMarker(strArr));
                if (bArrStringsToBytes == null) {
                    $$$reportNull$$$0(8);
                }
                return bArrStringsToBytes;
            }
            if (cCharAt == 65535) {
                strArr = dropMarker(strArr);
            }
        }
        byte[] bArrCombineStringArrayIntoBytes = combineStringArrayIntoBytes(strArr);
        addModuloByte(bArrCombineStringArrayIntoBytes, 127);
        return decode7to8(bArrCombineStringArrayIntoBytes);
    }

    private static String[] dropMarker(String[] strArr) {
        if (strArr == null) {
            $$$reportNull$$$0(9);
        }
        String[] strArr2 = (String[]) strArr.clone();
        strArr2[0] = strArr2[0].substring(1);
        return strArr2;
    }
}
