package en;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.nio.charset.Charset;
import kn.l0;
import kn.w;
import lm.f1;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
@f
@f1(version = "1.8")
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4558d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f4559e = 6;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f4560f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f4561g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte f4562h = 61;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f4563i = 76;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f4564j = 19;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final C0105a f4557c = new C0105a(false, false);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @l
    public static final byte[] f4565k = {13, 10};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @l
    public static final a f4566l = new a(true, false);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @l
    public static final a f4567m = new a(false, true);

    /* JADX INFO: renamed from: en.a$a, reason: collision with other inner class name */
    public static final class C0105a extends a {
        public C0105a() {
            super(false, false);
        }

        @l
        public final a G() {
            return a.f4567m;
        }

        @l
        public final byte[] H() {
            return a.f4565k;
        }

        @l
        public final a I() {
            return a.f4566l;
        }

        public C0105a(w wVar) {
            super(false, false);
        }
    }

    public /* synthetic */ a(boolean z10, boolean z11, w wVar) {
        this(z10, z11);
    }

    public static /* synthetic */ byte[] A(a aVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToByteArray");
        }
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        return aVar.z(bArr, i10, i11);
    }

    public static /* synthetic */ byte[] j(a aVar, CharSequence charSequence, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = charSequence.length();
        }
        return aVar.h(charSequence, i10, i11);
    }

    public static /* synthetic */ byte[] k(a aVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        return aVar.i(bArr, i10, i11);
    }

    public static /* synthetic */ int o(a aVar, CharSequence charSequence, byte[] bArr, int i10, int i11, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
        }
        int i14 = (i13 & 4) != 0 ? 0 : i10;
        int i15 = (i13 & 8) != 0 ? 0 : i11;
        if ((i13 & 16) != 0) {
            i12 = charSequence.length();
        }
        return aVar.m(charSequence, bArr, i14, i15, i12);
    }

    public static /* synthetic */ int p(a aVar, byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
        }
        int i14 = (i13 & 4) != 0 ? 0 : i10;
        int i15 = (i13 & 8) != 0 ? 0 : i11;
        if ((i13 & 16) != 0) {
            i12 = bArr.length;
        }
        return aVar.n(bArr, bArr2, i14, i15, i12);
    }

    public static /* synthetic */ String s(a aVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
        }
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        return aVar.r(bArr, i10, i11);
    }

    public static /* synthetic */ int u(a aVar, byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeIntoByteArray");
        }
        int i14 = (i13 & 4) != 0 ? 0 : i10;
        int i15 = (i13 & 8) != 0 ? 0 : i11;
        if ((i13 & 16) != 0) {
            i12 = bArr.length;
        }
        return aVar.t(bArr, bArr2, i14, i15, i12);
    }

    public static /* synthetic */ Appendable y(a aVar, byte[] bArr, Appendable appendable, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToAppendable");
        }
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = bArr.length;
        }
        return aVar.x(bArr, appendable, i10, i11);
    }

    @l
    public final byte[] B(@l byte[] bArr, int i10, int i11) {
        l0.p(bArr, "source");
        g(bArr.length, i10, i11);
        byte[] bArr2 = new byte[w(i11 - i10)];
        v(bArr, bArr2, 0, i10, i11);
        return bArr2;
    }

    public final int C(byte[] bArr, int i10, int i11, int i12) {
        if (i12 == -8) {
            throw new IllegalArgumentException(h.a.a("Redundant pad character at index ", i10));
        }
        if (i12 != -6) {
            if (i12 == -4) {
                int iF = F(bArr, i10 + 1, i11);
                if (iF == i11 || bArr[iF] != 61) {
                    throw new IllegalArgumentException(h.a.a("Missing one pad character at index ", iF));
                }
                return iF + 1;
            }
            if (i12 != -2) {
                throw new IllegalStateException("Unreachable");
            }
        }
        return i10 + 1;
    }

    public final boolean D() {
        return this.f4569b;
    }

    public final boolean E() {
        return this.f4568a;
    }

    public final int F(byte[] bArr, int i10, int i11) {
        if (!this.f4569b) {
            return i10;
        }
        while (i10 < i11) {
            if (c.f4571b[bArr[i10] & 255] != -1) {
                return i10;
            }
            i10++;
        }
        return i10;
    }

    @l
    public final String d(@l byte[] bArr) {
        l0.p(bArr, "source");
        StringBuilder sb2 = new StringBuilder(bArr.length);
        for (byte b10 : bArr) {
            sb2.append((char) b10);
        }
        String string = sb2.toString();
        l0.o(string, "toString(...)");
        return string;
    }

    @l
    public final byte[] e(@l CharSequence charSequence, int i10, int i11) {
        l0.p(charSequence, "source");
        g(charSequence.length(), i10, i11);
        byte[] bArr = new byte[i11 - i10];
        int i12 = 0;
        while (i10 < i11) {
            char cCharAt = charSequence.charAt(i10);
            if (cCharAt <= 255) {
                bArr[i12] = (byte) cCharAt;
                i12++;
            } else {
                bArr[i12] = fl.h.f6042b;
                i12++;
            }
            i10++;
        }
        return bArr;
    }

    public final void f(int i10, int i11, int i12) {
        if (i11 < 0 || i11 > i10) {
            throw new IndexOutOfBoundsException(e0.a.a("destination offset: ", i11, ", destination size: ", i10));
        }
        int i13 = i11 + i12;
        if (i13 < 0 || i13 > i10) {
            StringBuilder sbA = i0.a.a("The destination array does not have enough capacity, destination offset: ", i11, ", destination size: ", i10, ", capacity needed: ");
            sbA.append(i12);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
    }

    public final void g(int i10, int i11, int i12) {
        nm.c.Companion.a(i11, i12, i10);
    }

    @l
    public final byte[] h(@l CharSequence charSequence, int i10, int i11) {
        byte[] bArrE;
        l0.p(charSequence, "source");
        if (charSequence instanceof String) {
            g(((String) charSequence).length(), i10, i11);
            String strSubstring = ((String) charSequence).substring(i10, i11);
            l0.o(strSubstring, "substring(...)");
            Charset charset = jq.f.f8805g;
            l0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
            bArrE = strSubstring.getBytes(charset);
            l0.o(bArrE, "getBytes(...)");
        } else {
            bArrE = e(charSequence, i10, i11);
        }
        return k(this, bArrE, 0, 0, 6, null);
    }

    @l
    public final byte[] i(@l byte[] bArr, int i10, int i11) {
        l0.p(bArr, "source");
        g(bArr.length, i10, i11);
        int iQ = q(bArr, i10, i11);
        byte[] bArr2 = new byte[iQ];
        if (l(bArr, bArr2, 0, i10, i11) == iQ) {
            return bArr2;
        }
        throw new IllegalStateException("Check failed.");
    }

    /* JADX WARN: Code duplicated, block: B:16:0x006c  */
    /* JADX WARN: Code duplicated, block: B:18:0x0074 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x007b  */
    /* JADX WARN: Code duplicated, block: B:22:0x007f  */
    /* JADX WARN: Code duplicated, block: B:25:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:27:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:28:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:39:0x0076 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0082 A[SYNTHETIC] */
    public final int l(byte[] bArr, byte[] bArr2, int i10, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int[] iArr = this.f4568a ? c.f4573d : c.f4571b;
        int i16 = -8;
        int i17 = i10;
        int i18 = -8;
        int i19 = 0;
        int iC = i11;
        while (iC < i12) {
            if (i18 != i16 || iC + 3 >= i12) {
                i13 = bArr[iC] & 255;
                i14 = iArr[i13];
                if (i14 < 0) {
                    iC++;
                    i19 = (i19 << 6) | i14;
                    i15 = i18 + 6;
                    if (i15 >= 0) {
                        bArr2[i17] = (byte) (i19 >>> i15);
                        i19 &= (1 << i15) - 1;
                        i18 -= 2;
                        i17++;
                    } else {
                        i18 = i15;
                    }
                } else {
                    if (i14 == -2) {
                        iC = C(bArr, iC, i12, i18);
                        break;
                    }
                    if (this.f4569b) {
                        StringBuilder sb2 = new StringBuilder("Invalid symbol '");
                        sb2.append((char) i13);
                        sb2.append("'(");
                        String string = Integer.toString(i13, jq.d.a(8));
                        l0.o(string, "toString(...)");
                        sb2.append(string);
                        sb2.append(") at index ");
                        sb2.append(iC);
                        throw new IllegalArgumentException(sb2.toString());
                    }
                    iC++;
                }
            } else {
                int i20 = iC + 4;
                int i21 = (iArr[bArr[iC] & 255] << 18) | (iArr[bArr[iC + 1] & 255] << 12) | (iArr[bArr[iC + 2] & 255] << 6) | iArr[bArr[iC + 3] & 255];
                if (i21 >= 0) {
                    bArr2[i17] = (byte) (i21 >> 16);
                    int i22 = i17 + 2;
                    bArr2[i17 + 1] = (byte) (i21 >> 8);
                    i17 += 3;
                    bArr2[i22] = (byte) i21;
                    iC = i20;
                } else {
                    i13 = bArr[iC] & 255;
                    i14 = iArr[i13];
                    if (i14 < 0) {
                        iC++;
                        i19 = (i19 << 6) | i14;
                        i15 = i18 + 6;
                        if (i15 >= 0) {
                            bArr2[i17] = (byte) (i19 >>> i15);
                            i19 &= (1 << i15) - 1;
                            i18 -= 2;
                            i17++;
                        } else {
                            i18 = i15;
                        }
                    } else {
                        if (i14 == -2) {
                            iC = C(bArr, iC, i12, i18);
                            break;
                        }
                        if (this.f4569b) {
                            StringBuilder sb3 = new StringBuilder("Invalid symbol '");
                            sb3.append((char) i13);
                            sb3.append("'(");
                            String string2 = Integer.toString(i13, jq.d.a(8));
                            l0.o(string2, "toString(...)");
                            sb3.append(string2);
                            sb3.append(") at index ");
                            sb3.append(iC);
                            throw new IllegalArgumentException(sb3.toString());
                        }
                        iC++;
                    }
                }
            }
            i16 = -8;
        }
        if (i18 == -2) {
            throw new IllegalArgumentException("The last unit of input does not have enough bits");
        }
        int iF = F(bArr, iC, i12);
        if (iF >= i12) {
            return i17 - i10;
        }
        int i23 = bArr[iF] & 255;
        StringBuilder sb4 = new StringBuilder("Symbol '");
        sb4.append((char) i23);
        sb4.append("'(");
        String string3 = Integer.toString(i23, jq.d.a(8));
        l0.o(string3, "toString(...)");
        sb4.append(string3);
        sb4.append(") at index ");
        throw new IllegalArgumentException(c.a.a(sb4, iF - 1, " is prohibited after the pad character"));
    }

    public final int m(@l CharSequence charSequence, @l byte[] bArr, int i10, int i11, int i12) {
        byte[] bArrE;
        l0.p(charSequence, "source");
        l0.p(bArr, RtspHeaders.Values.DESTINATION);
        if (charSequence instanceof String) {
            g(((String) charSequence).length(), i11, i12);
            String strSubstring = ((String) charSequence).substring(i11, i12);
            l0.o(strSubstring, "substring(...)");
            Charset charset = jq.f.f8805g;
            l0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
            bArrE = strSubstring.getBytes(charset);
            l0.o(bArrE, "getBytes(...)");
        } else {
            bArrE = e(charSequence, i11, i12);
        }
        return p(this, bArrE, bArr, i10, 0, 0, 24, null);
    }

    public final int n(@l byte[] bArr, @l byte[] bArr2, int i10, int i11, int i12) {
        l0.p(bArr, "source");
        l0.p(bArr2, RtspHeaders.Values.DESTINATION);
        g(bArr.length, i11, i12);
        f(bArr2.length, i10, q(bArr, i11, i12));
        return l(bArr, bArr2, i10, i11, i12);
    }

    public final int q(byte[] bArr, int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 == 0) {
            return 0;
        }
        if (i12 == 1) {
            throw new IllegalArgumentException(e0.a.a("Input should have at list 2 symbols for Base64 decoding, startIndex: ", i10, ", endIndex: ", i11));
        }
        if (this.f4569b) {
            while (i10 < i11) {
                int i13 = c.f4571b[bArr[i10] & 255];
                if (i13 < 0) {
                    if (i13 == -2) {
                        i12 -= i11 - i10;
                        break;
                    }
                    i12--;
                }
                i10++;
            }
        } else if (bArr[i11 - 1] == 61) {
            i12 = bArr[i11 + (-2)] == 61 ? i12 - 2 : i12 - 1;
        }
        return (int) ((((long) i12) * ((long) 6)) / ((long) 8));
    }

    @l
    public final String r(@l byte[] bArr, int i10, int i11) {
        l0.p(bArr, "source");
        return new String(B(bArr, i10, i11), jq.f.f8805g);
    }

    public final int t(@l byte[] bArr, @l byte[] bArr2, int i10, int i11, int i12) {
        l0.p(bArr, "source");
        l0.p(bArr2, RtspHeaders.Values.DESTINATION);
        return v(bArr, bArr2, i10, i11, i12);
    }

    public final int v(@l byte[] bArr, @l byte[] bArr2, int i10, int i11, int i12) {
        l0.p(bArr, "source");
        l0.p(bArr2, RtspHeaders.Values.DESTINATION);
        g(bArr.length, i11, i12);
        f(bArr2.length, i10, w(i12 - i11));
        byte[] bArr3 = this.f4568a ? c.f4572c : c.f4570a;
        int i13 = this.f4569b ? 19 : Integer.MAX_VALUE;
        int i14 = i10;
        while (i11 + 2 < i12) {
            int iMin = Math.min((i12 - i11) / 3, i13);
            for (int i15 = 0; i15 < iMin; i15++) {
                int i16 = bArr[i11] & 255;
                int i17 = i11 + 2;
                int i18 = bArr[i11 + 1] & 255;
                i11 += 3;
                int i19 = (i18 << 8) | (i16 << 16) | (bArr[i17] & 255);
                bArr2[i14] = bArr3[i19 >>> 18];
                bArr2[i14 + 1] = bArr3[(i19 >>> 12) & 63];
                int i20 = i14 + 3;
                bArr2[i14 + 2] = bArr3[(i19 >>> 6) & 63];
                i14 += 4;
                bArr2[i20] = bArr3[i19 & 63];
            }
            if (iMin == i13 && i11 != i12) {
                int i21 = i14 + 1;
                byte[] bArr4 = f4565k;
                bArr2[i14] = bArr4[0];
                i14 += 2;
                bArr2[i21] = bArr4[1];
            }
        }
        int i22 = i12 - i11;
        if (i22 == 1) {
            int i23 = (bArr[i11] & 255) << 4;
            bArr2[i14] = bArr3[i23 >>> 6];
            bArr2[i14 + 1] = bArr3[i23 & 63];
            int i24 = i14 + 3;
            bArr2[i14 + 2] = 61;
            i14 += 4;
            bArr2[i24] = 61;
            i11++;
        } else if (i22 == 2) {
            int i25 = i11 + 1;
            int i26 = bArr[i11] & 255;
            i11 += 2;
            int i27 = ((bArr[i25] & 255) << 2) | (i26 << 10);
            bArr2[i14] = bArr3[i27 >>> 12];
            bArr2[i14 + 1] = bArr3[(i27 >>> 6) & 63];
            int i28 = i14 + 3;
            bArr2[i14 + 2] = bArr3[i27 & 63];
            i14 += 4;
            bArr2[i28] = 61;
        }
        if (i11 == i12) {
            return i14 - i10;
        }
        throw new IllegalStateException("Check failed.");
    }

    public final int w(int i10) {
        int i11 = (i10 + 2) / 3;
        int i12 = ((this.f4569b ? (i11 - 1) / 19 : 0) * 2) + (i11 * 4);
        if (i12 >= 0) {
            return i12;
        }
        throw new IllegalArgumentException("Input is too big");
    }

    @l
    public final <A extends Appendable> A x(@l byte[] bArr, @l A a10, int i10, int i11) throws IOException {
        l0.p(bArr, "source");
        l0.p(a10, RtspHeaders.Values.DESTINATION);
        a10.append(new String(B(bArr, i10, i11), jq.f.f8805g));
        return a10;
    }

    @l
    public final byte[] z(@l byte[] bArr, int i10, int i11) {
        l0.p(bArr, "source");
        return B(bArr, i10, i11);
    }

    public a(boolean z10, boolean z11) {
        this.f4568a = z10;
        this.f4569b = z11;
        if (z10 && z11) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }
}
