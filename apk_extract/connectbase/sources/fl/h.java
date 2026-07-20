package fl;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final String f6041a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte f6042b = 63;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char f6043c = '=';

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final int[] f6044d;

    static {
        int[] iArr = new int[256];
        for (int i10 = 0; i10 < 256; i10++) {
            iArr[i10] = jq.h0.o3(f6041a, (char) i10, 0, false, 6, null);
        }
        f6044d = iArr;
    }

    public static final void a(@os.l byte[] bArr, int i10) {
        kn.l0.p(bArr, "<this>");
        Iterator<Integer> it = tn.u.W1(i10, bArr.length).iterator();
        while (it.hasNext()) {
            bArr[((nm.v0) it).nextInt()] = 0;
        }
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ String b(String str) {
        kn.l0.p(str, "<this>");
        return f(str);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ String c(tl.v vVar) {
        kn.l0.p(vVar, "<this>");
        return tl.d1.t(d(vVar), null, 0, 3, null);
    }

    @t0
    @os.l
    public static final tl.g0 d(@os.l tl.v vVar) {
        kn.l0.p(vVar, "<this>");
        tl.s sVarA = tl.w0.a(0);
        try {
            byte[] bArr = new byte[4];
            while (vVar.S0() > 0) {
                int i10 = tl.i0.i(vVar, bArr, 0, 0, 6, null);
                int i11 = 0;
                int iJ = 0;
                int i12 = 0;
                while (i11 < 4) {
                    byte b10 = bArr[i11];
                    i11++;
                    iJ |= j(b10) << ((3 - i12) * 6);
                    i12++;
                }
                int i13 = 4 - i10;
                int i14 = 2;
                if (i13 <= 2) {
                    while (true) {
                        int i15 = i14 - 1;
                        sVarA.d1((byte) ((iJ >> (i14 * 8)) & 255));
                        if (i14 == i13) {
                            break;
                        }
                        i14 = i15;
                    }
                }
            }
            return sVarA.z2();
        } catch (Throwable th2) {
            sVarA.close();
            throw th2;
        }
    }

    @t0
    @os.l
    public static final byte[] e(@os.l String str) {
        String strSubstring;
        kn.l0.p(str, "<this>");
        tl.s sVarA = tl.w0.a(0);
        try {
            int iG3 = jq.h0.g3(str);
            if (iG3 < 0) {
                strSubstring = "";
                break;
            }
            while (true) {
                int i10 = iG3 - 1;
                if (str.charAt(iG3) != '=') {
                    strSubstring = str.substring(0, iG3 + 1);
                    kn.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    break;
                }
                if (i10 < 0) {
                    strSubstring = "";
                    break;
                }
                iG3 = i10;
            }
            tl.d1.Y(sVarA, strSubstring, 0, 0, null, 14, null);
            return tl.d1.g(d(sVarA.z2()));
        } catch (Throwable th2) {
            sVarA.close();
            throw th2;
        }
    }

    @t0
    @os.l
    public static final String f(@os.l String str) {
        kn.l0.p(str, "<this>");
        byte[] bArrE = e(str);
        return new String(bArrE, 0, bArrE.length, jq.f.f8800b);
    }

    @t0
    @os.l
    public static final String g(@os.l String str) {
        kn.l0.p(str, "<this>");
        tl.s sVarA = tl.w0.a(0);
        try {
            tl.d1.Y(sVarA, str, 0, 0, null, 14, null);
            return h(sVarA.z2());
        } catch (Throwable th2) {
            sVarA.close();
            throw th2;
        }
    }

    @t0
    @os.l
    public static final String h(@os.l tl.v vVar) {
        kn.l0.p(vVar, "<this>");
        StringBuilder sb2 = new StringBuilder();
        byte[] bArr = new byte[3];
        while (vVar.S0() > 0) {
            int i10 = tl.i0.i(vVar, bArr, 0, 0, 6, null);
            a(bArr, i10);
            int i11 = ((3 - i10) * 8) / 6;
            int i12 = 0;
            int i13 = ((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[2] & 255);
            if (i11 <= 3) {
                int i14 = 3;
                while (true) {
                    int i15 = i14 - 1;
                    sb2.append(f6041a.charAt((i13 >> (i14 * 6)) & 63));
                    if (i14 == i11) {
                        break;
                    }
                    i14 = i15;
                }
            }
            while (i12 < i11) {
                i12++;
                sb2.append(f6043c);
            }
        }
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @t0
    @os.l
    public static final String i(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        tl.s sVarA = tl.w0.a(0);
        try {
            tl.s0.r(sVarA, bArr, 0, 0, 6, null);
            return h(sVarA.z2());
        } catch (Throwable th2) {
            sVarA.close();
            throw th2;
        }
    }

    public static final byte j(byte b10) {
        return (byte) (((byte) f6044d[b10 & 255]) & f6042b);
    }

    public static /* synthetic */ void k() {
    }

    public static final char l(int i10) {
        return f6041a.charAt(i10);
    }
}
