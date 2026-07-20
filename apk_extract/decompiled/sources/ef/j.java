package ef;

import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f4933a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f4934b = new String[64];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f4935c = new String[256];

    static {
        int i8 = 0;
        int i9 = 0;
        while (true) {
            String[] strArr = f4935c;
            if (i9 >= strArr.length) {
                break;
            }
            strArr[i9] = String.format("%8s", Integer.toBinaryString(i9)).replace(' ', '0');
            i9++;
        }
        String[] strArr2 = f4934b;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i10 = iArr[0];
        strArr2[i10 | 8] = h0.a.n(new StringBuilder(), strArr2[i10], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i11 = 0; i11 < 3; i11++) {
            int i12 = iArr2[i11];
            int i13 = iArr[0];
            String[] strArr3 = f4934b;
            int i14 = i13 | i12;
            strArr3[i14] = strArr3[i13] + '|' + strArr3[i12];
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strArr3[i13]);
            sb2.append('|');
            strArr3[i14 | 8] = h0.a.n(sb2, strArr3[i12], "|PADDED");
        }
        while (true) {
            String[] strArr4 = f4934b;
            if (i8 >= strArr4.length) {
                return;
            }
            if (strArr4[i8] == null) {
                strArr4[i8] = f4935c[i8];
            }
            i8++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0066  */
    public static String a(boolean z2, int i8, int i9, byte b9, byte b10) {
        String strReplace;
        String str = b9 < 10 ? f4933a[b9] : String.format("0x%02x", Byte.valueOf(b9));
        if (b10 == 0) {
            strReplace = "";
        } else {
            String[] strArr = f4935c;
            if (b9 == 2 || b9 == 3) {
                strReplace = strArr[b10];
            } else if (b9 == 4 || b9 == 6) {
                strReplace = b10 == 1 ? "ACK" : strArr[b10];
            } else if (b9 == 7 || b9 == 8) {
                strReplace = strArr[b10];
            } else {
                String str2 = b10 < 64 ? f4934b[b10] : strArr[b10];
                if (b9 != 5 || (b10 & 4) == 0) {
                    strReplace = (b9 != 0 || (b10 & 32) == 0) ? str2 : str2.replace("PRIORITY", "COMPRESSED");
                } else {
                    strReplace = str2.replace("HEADERS", "PUSH_PROMISE");
                }
            }
        }
        return String.format(Locale.US, "%s 0x%08x %5d %-13s %s", z2 ? "<<" : ">>", Integer.valueOf(i8), Integer.valueOf(i9), str, strReplace);
    }
}
