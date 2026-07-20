package m3;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import k3.lb;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class q {
    public static String a(int i8, String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(input, "<this>");
        byte[] bytes = input.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        if (bytes.length <= i8) {
            return input;
        }
        int i9 = (i8 - 3) >> 1;
        StringBuilder sb2 = new StringBuilder();
        int length = input.length();
        int length2 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = input.charAt(i10);
            byte[] bytes2 = String.valueOf(cCharAt).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            if (bytes2.length + length2 > i9) {
                break;
            }
            sb2.append(cCharAt);
            length2 += bytes2.length;
        }
        int i11 = i9 - length2;
        for (int i12 = 0; i12 < i11; i12++) {
            sb2.append('.');
        }
        StringBuilder sb3 = new StringBuilder();
        String string = StringsKt___StringsKt.reversed((CharSequence) input).toString();
        int length3 = string.length();
        int length4 = 0;
        for (int i13 = 0; i13 < length3; i13++) {
            char cCharAt2 = string.charAt(i13);
            byte[] bytes3 = String.valueOf(cCharAt2).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
            if (bytes3.length + length4 > i9) {
                break;
            }
            sb3.append(cCharAt2);
            length4 += bytes3.length;
        }
        int i14 = i9 - length4;
        for (int i15 = 0; i15 < i14; i15++) {
            sb3.append('.');
        }
        String string2 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        return ((Object) sb2) + "..." + StringsKt___StringsKt.reversed((CharSequence) string2).toString();
    }

    public static byte[] b(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() % 2 != 0) {
            throw new IllegalStateException("Must have an even length");
        }
        List listChunked = StringsKt___StringsKt.chunked(str, 2);
        ArrayList arrayList = new ArrayList(CollectionsKt.i(listChunked));
        Iterator it = listChunked.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf((byte) Integer.parseInt((String) it.next(), CharsKt.checkRadix(16))));
        }
        return CollectionsKt.toByteArray(arrayList);
    }

    public static String c(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length != 6) {
            throw new IllegalStateException("Must have 6 octets");
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        return o.d.q(new Object[]{Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3]), Byte.valueOf(bArr[4]), Byte.valueOf(bArr[5])}, 6, "%02x:%02x:%02x:%02x:%02x:%02x", "format(...)");
    }

    public static byte[] d(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArrG = g(StringsKt__StringsJVMKt.replace(str, ":", "", false));
        if (bArrG.length == 6) {
            return bArrG;
        }
        Intrinsics.checkNotNullParameter("mac address is illegal! now use default mac 00:00:00:00:00:00", "mes");
        if (lb.f6529c >= 1) {
            Log.e("welinkBLE", "mac address is illegal! now use default mac 00:00:00:00:00:00", null);
        }
        return new byte[]{0, 0, 0, 0, 0, 0};
    }

    public static String e(String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        String lowerCase = new Regex("[:\\-]").replace(mac, "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (lowerCase.length() != 12) {
            throw new IllegalArgumentException("Invalid MAC address format");
        }
        List listChunked = StringsKt___StringsKt.chunked(lowerCase, 2);
        ArrayList arrayList = new ArrayList(CollectionsKt.i(listChunked));
        Iterator it = listChunked.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(Integer.parseInt((String) it.next(), CharsKt.checkRadix(16))));
        }
        String string = Integer.toString(((Number) arrayList.get(0)).intValue() ^ 2, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String strPadStart = StringsKt__StringsKt.padStart(string, 2, '0');
        String strSubstring = lowerCase.substring(2, 4);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String strSubstring2 = lowerCase.substring(4, 6);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        String strSubstring3 = lowerCase.substring(6, 8);
        Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
        String strSubstring4 = lowerCase.substring(8, 10);
        Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
        String strSubstring5 = lowerCase.substring(10, 12);
        Intrinsics.checkNotNullExpressionValue(strSubstring5, "substring(...)");
        return h0.a.i("fe80::", new Regex("(:0)+").replace(CollectionsKt___CollectionsKt.joinToString$default(StringsKt___StringsKt.chunked(CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new String[]{strPadStart, strSubstring, strSubstring2, "ff", "fe", strSubstring3, strSubstring4, strSubstring5}), "", null, null, 0, null, null, 62, null), 4), ":", null, null, 0, null, new qg.y0(15), 30, null), "::"));
    }

    public static void f(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        String strB = "";
        for (byte b9 : bArr) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            strB = h0.a.B(strB, o.d.q(new Object[]{Byte.valueOf(b9)}, 1, "%02x ", "format(...)"));
        }
        we.h.g(strB);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0053 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0055 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:27:0x005a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x005c A[ADDED_TO_REGION] */
    public static byte[] g(String str) {
        int i8;
        byte b9;
        int i9;
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        ArrayList arrayList = new ArrayList();
        int length = bytes.length;
        int iA = 0;
        byte b10 = 0;
        byte b11 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            byte b12 = bytes[i10];
            if (i10 == iA && i10 < bytes.length - 1) {
                if (48 <= b12 && b12 < 58) {
                    i8 = b12 - 48;
                } else if (97 > b12 || b12 >= 103) {
                    if (65 <= b12 && b12 < 71) {
                        i8 = b12 - 55;
                    }
                    b9 = bytes[i10 + 1];
                    if (48 > b9 && b9 < 58) {
                        i9 = b9 - 48;
                    } else if (97 <= b9 || b9 >= 103) {
                        if (65 <= b9 && b9 < 71) {
                            i9 = b9 - 55;
                        }
                        iA = h0.a.a((byte) ((b10 * 16) + b11), arrayList, iA, 2);
                    } else {
                        i9 = b9 - 87;
                    }
                    b11 = (byte) i9;
                    iA = h0.a.a((byte) ((b10 * 16) + b11), arrayList, iA, 2);
                } else {
                    i8 = b12 - 87;
                }
                b10 = (byte) i8;
                b9 = bytes[i10 + 1];
                if (48 > b9) {
                    if (97 <= b9) {
                        if (65 <= b9) {
                            i9 = b9 - 55;
                            b11 = (byte) i9;
                        }
                    } else if (65 <= b9) {
                        i9 = b9 - 55;
                        b11 = (byte) i9;
                    }
                } else if (97 <= b9) {
                    if (65 <= b9) {
                        i9 = b9 - 55;
                        b11 = (byte) i9;
                    }
                } else if (65 <= b9) {
                    i9 = b9 - 55;
                    b11 = (byte) i9;
                }
                iA = h0.a.a((byte) ((b10 * 16) + b11), arrayList, iA, 2);
            }
        }
        return CollectionsKt.toByteArray(arrayList);
    }

    public static String h(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        StringBuilder sb2 = new StringBuilder();
        for (byte b9 : bArr) {
            sb2.append(String.valueOf((char) b9));
        }
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static byte[] i(int i8) {
        ArrayList arrayList = new ArrayList();
        int iA = 1;
        while (iA >= 0) {
            iA = h0.a.a((byte) (i8 >> (iA * 8)), arrayList, iA, -1);
        }
        return CollectionsKt.toByteArray(arrayList);
    }

    public static String j(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        StringBuilder sb2 = new StringBuilder();
        int length = bArr.length;
        int iE = 0;
        while (iE < length) {
            byte b9 = bArr[iE];
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            iE = h0.a.e(new Object[]{Byte.valueOf(b9)}, 1, "%02x ", "format(...)", sb2, iE, 1);
        }
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
