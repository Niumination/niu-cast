package kj;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qj.j f6919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f6920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f6921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f6922d;

    static {
        qj.j.Companion.getClass();
        f6919a = qj.i.b("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        f6920b = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        f6921c = new String[64];
        String[] strArr = new String[256];
        for (int i8 = 0; i8 < 256; i8++) {
            String binaryString = Integer.toBinaryString(i8);
            Intrinsics.checkNotNullExpressionValue(binaryString, "Integer.toBinaryString(it)");
            strArr[i8] = StringsKt__StringsJVMKt.replace$default(ej.b.i("%8s", binaryString), ' ', '0', false, 4, (Object) null);
        }
        f6922d = strArr;
        String[] strArr2 = f6921c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i9 = iArr[0];
        strArr2[i9 | 8] = Intrinsics.stringPlus(strArr2[i9], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i10 = 0; i10 < 3; i10++) {
            int i11 = iArr2[i10];
            int i12 = iArr[0];
            String[] strArr3 = f6921c;
            int i13 = i12 | i11;
            strArr3[i13] = strArr3[i12] + "|" + strArr3[i11];
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strArr3[i12]);
            sb2.append("|");
            strArr3[i13 | 8] = h0.a.n(sb2, strArr3[i11], "|PADDED");
        }
        int length = f6921c.length;
        for (int i14 = 0; i14 < length; i14++) {
            String[] strArr4 = f6921c;
            if (strArr4[i14] == null) {
                strArr4[i14] = f6922d[i14];
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0067  */
    public static String a(boolean z2, int i8, int i9, int i10, int i11) {
        String strReplace$default;
        String str;
        String[] strArr = f6920b;
        String strI = i10 < strArr.length ? strArr[i10] : ej.b.i("0x%02x", Integer.valueOf(i10));
        if (i11 == 0) {
            strReplace$default = "";
        } else {
            String[] strArr2 = f6922d;
            if (i10 == 2 || i10 == 3) {
                strReplace$default = strArr2[i11];
            } else if (i10 == 4 || i10 == 6) {
                strReplace$default = i11 == 1 ? "ACK" : strArr2[i11];
            } else if (i10 == 7 || i10 == 8) {
                strReplace$default = strArr2[i11];
            } else {
                String[] strArr3 = f6921c;
                if (i11 < strArr3.length) {
                    str = strArr3[i11];
                    Intrinsics.checkNotNull(str);
                } else {
                    str = strArr2[i11];
                }
                if (i10 != 5 || (i11 & 4) == 0) {
                    strReplace$default = (i10 != 0 || (i11 & 32) == 0) ? str : StringsKt__StringsJVMKt.replace$default(str, "PRIORITY", "COMPRESSED", false, 4, (Object) null);
                } else {
                    strReplace$default = StringsKt__StringsJVMKt.replace$default(str, "HEADERS", "PUSH_PROMISE", false, 4, (Object) null);
                }
            }
        }
        return ej.b.i("%s 0x%08x %5d %-13s %s", z2 ? "<<" : ">>", Integer.valueOf(i8), Integer.valueOf(i9), strI, strReplace$default);
    }
}
