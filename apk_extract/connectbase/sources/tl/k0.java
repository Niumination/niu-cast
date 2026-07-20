package tl;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15834a;

        static {
            int[] iArr = new int[q.values().length];
            iArr[q.BIG_ENDIAN.ordinal()] = 1;
            f15834a = iArr;
        }
    }

    public static final int A(@os.l e eVar, @os.l long[] jArr, int i10, int i11) {
        kn.l0.p(eVar, "$this$readAvailableLittleEndian");
        kn.l0.p(jArr, "dst");
        return d(eVar, jArr, i10, i11);
    }

    public static final short A0(@os.l g0 g0Var, @os.l q qVar) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(qVar, "byteOrder");
        return a.f15834a[qVar.ordinal()] == 1 ? m0.k(g0Var) : Short.reverseBytes(m0.k(g0Var));
    }

    public static int B(e eVar, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        return A(eVar, jArr, i10, i11);
    }

    public static final short B0(@os.l e eVar) {
        kn.l0.p(eVar, "<this>");
        return Short.reverseBytes(l.g0(eVar));
    }

    public static final int C(@os.l g0 g0Var, @os.l long[] jArr, int i10, int i11) {
        kn.l0.p(g0Var, "$this$readAvailableLittleEndian");
        kn.l0.p(jArr, "dst");
        return i(g0Var, jArr, i10, i11);
    }

    public static final short C0(@os.l g0 g0Var) {
        kn.l0.p(g0Var, "<this>");
        return Short.reverseBytes(m0.k(g0Var));
    }

    public static int D(g0 g0Var, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        return C(g0Var, jArr, i10, i11);
    }

    public static final int E(@os.l e eVar, @os.l int[] iArr, int i10, int i11) {
        kn.l0.p(eVar, "$this$readAvailableLittleEndian");
        kn.l0.p(iArr, "dst");
        return c(eVar, iArr, i10, i11);
    }

    public static int F(e eVar, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        return E(eVar, iArr, i10, i11);
    }

    public static final double G(@os.l g0 g0Var, @os.l q qVar) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(qVar, "byteOrder");
        return a.f15834a[qVar.ordinal()] == 1 ? m0.a(g0Var) : Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(m0.a(g0Var))));
    }

    public static final double H(@os.l e eVar) {
        kn.l0.p(eVar, "<this>");
        return Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(l.z(eVar))));
    }

    public static final double I(@os.l g0 g0Var) {
        kn.l0.p(g0Var, "<this>");
        return Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(m0.a(g0Var))));
    }

    public static final float J(@os.l g0 g0Var, @os.l q qVar) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(qVar, "byteOrder");
        return a.f15834a[qVar.ordinal()] == 1 ? m0.c(g0Var) : Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(m0.c(g0Var))));
    }

    public static final float K(@os.l e eVar) {
        kn.l0.p(eVar, "<this>");
        return Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(l.C(eVar))));
    }

    public static final float L(@os.l g0 g0Var) {
        kn.l0.p(g0Var, "<this>");
        return Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(m0.c(g0Var))));
    }

    public static final void M(@os.l e eVar, @os.l double[] dArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(dArr, "dst");
        l.G(eVar, dArr, i10, i11);
        int i12 = (i11 + i10) - 1;
        if (i10 > i12) {
            return;
        }
        while (true) {
            int i13 = i10 + 1;
            dArr[i10] = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(dArr[i10])));
            if (i10 == i12) {
                return;
            } else {
                i10 = i13;
            }
        }
    }

    public static final void N(@os.l e eVar, @os.l float[] fArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(fArr, "dst");
        l.H(eVar, fArr, i10, i11);
        int i12 = (i11 + i10) - 1;
        if (i10 > i12) {
            return;
        }
        while (true) {
            int i13 = i10 + 1;
            fArr[i10] = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(fArr[i10])));
            if (i10 == i12) {
                return;
            } else {
                i10 = i13;
            }
        }
    }

    public static final void O(@os.l e eVar, @os.l int[] iArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(iArr, "dst");
        l.I(eVar, iArr, i10, i11);
        int i12 = (i11 + i10) - 1;
        if (i10 > i12) {
            return;
        }
        while (true) {
            int i13 = i10 + 1;
            iArr[i10] = Integer.reverseBytes(iArr[i10]);
            if (i10 == i12) {
                return;
            } else {
                i10 = i13;
            }
        }
    }

    public static final void P(@os.l e eVar, @os.l long[] jArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(jArr, "dst");
        l.J(eVar, jArr, i10, i11);
        int i12 = (i11 + i10) - 1;
        if (i10 > i12) {
            return;
        }
        while (true) {
            int i13 = i10 + 1;
            jArr[i10] = Long.reverseBytes(jArr[i10]);
            if (i10 == i12) {
                return;
            } else {
                i10 = i13;
            }
        }
    }

    public static final void Q(@os.l e eVar, @os.l short[] sArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(sArr, "dst");
        l.K(eVar, sArr, i10, i11);
        int i12 = (i11 + i10) - 1;
        if (i10 > i12) {
            return;
        }
        while (true) {
            int i13 = i10 + 1;
            sArr[i10] = Short.reverseBytes(sArr[i10]);
            if (i10 == i12) {
                return;
            } else {
                i10 = i13;
            }
        }
    }

    public static final void R(@os.l g0 g0Var, @os.l double[] dArr, int i10, int i11) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(dArr, "dst");
        i0.s(g0Var, dArr, i10, i11);
        int i12 = (i11 + i10) - 1;
        if (i10 > i12) {
            return;
        }
        while (true) {
            int i13 = i10 + 1;
            dArr[i10] = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(dArr[i10])));
            if (i10 == i12) {
                return;
            } else {
                i10 = i13;
            }
        }
    }

    public static final void S(@os.l g0 g0Var, @os.l float[] fArr, int i10, int i11) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(fArr, "dst");
        i0.t(g0Var, fArr, i10, i11);
        int i12 = (i11 + i10) - 1;
        if (i10 > i12) {
            return;
        }
        while (true) {
            int i13 = i10 + 1;
            fArr[i10] = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(fArr[i10])));
            if (i10 == i12) {
                return;
            } else {
                i10 = i13;
            }
        }
    }

    public static final void T(@os.l g0 g0Var, @os.l int[] iArr, int i10, int i11) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(iArr, "dst");
        i0.u(g0Var, iArr, i10, i11);
        int i12 = (i11 + i10) - 1;
        if (i10 > i12) {
            return;
        }
        while (true) {
            int i13 = i10 + 1;
            iArr[i10] = Integer.reverseBytes(iArr[i10]);
            if (i10 == i12) {
                return;
            } else {
                i10 = i13;
            }
        }
    }

    public static final void U(@os.l g0 g0Var, @os.l long[] jArr, int i10, int i11) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(jArr, "dst");
        i0.v(g0Var, jArr, i10, i11);
        int i12 = (i11 + i10) - 1;
        if (i10 > i12) {
            return;
        }
        while (true) {
            int i13 = i10 + 1;
            jArr[i10] = Long.reverseBytes(jArr[i10]);
            if (i10 == i12) {
                return;
            } else {
                i10 = i13;
            }
        }
    }

    public static final void V(@os.l g0 g0Var, @os.l short[] sArr, int i10, int i11) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(sArr, "dst");
        i0.w(g0Var, sArr, i10, i11);
        int i12 = (i11 + i10) - 1;
        if (i10 > i12) {
            return;
        }
        while (true) {
            int i13 = i10 + 1;
            sArr[i10] = Short.reverseBytes(sArr[i10]);
            if (i10 == i12) {
                return;
            } else {
                i10 = i13;
            }
        }
    }

    public static /* synthetic */ void W(e eVar, double[] dArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = dArr.length - i10;
        }
        M(eVar, dArr, i10, i11);
    }

    public static /* synthetic */ void X(e eVar, float[] fArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = fArr.length - i10;
        }
        N(eVar, fArr, i10, i11);
    }

    public static /* synthetic */ void Y(e eVar, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        O(eVar, iArr, i10, i11);
    }

    public static /* synthetic */ void Z(e eVar, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        P(eVar, jArr, i10, i11);
    }

    public static final int a(@os.l e eVar, @os.l double[] dArr, int i10, int i11) {
        int i12;
        kn.l0.p(eVar, "<this>");
        kn.l0.p(dArr, "dst");
        int iD = l.d(eVar, dArr, i10, i11);
        if (iD > 0 && i10 <= (i12 = (i10 + iD) - 1)) {
            while (true) {
                int i13 = i10 + 1;
                dArr[i10] = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(dArr[i10])));
                if (i10 == i12) {
                    break;
                }
                i10 = i13;
            }
        }
        return iD;
    }

    public static /* synthetic */ void a0(e eVar, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        Q(eVar, sArr, i10, i11);
    }

    public static final int b(@os.l e eVar, @os.l float[] fArr, int i10, int i11) {
        int i12;
        kn.l0.p(eVar, "<this>");
        kn.l0.p(fArr, "dst");
        int iE = l.e(eVar, fArr, i10, i11);
        if (iE > 0 && i10 <= (i12 = (i10 + iE) - 1)) {
            while (true) {
                int i13 = i10 + 1;
                fArr[i10] = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(fArr[i10])));
                if (i10 == i12) {
                    break;
                }
                i10 = i13;
            }
        }
        return iE;
    }

    public static /* synthetic */ void b0(g0 g0Var, double[] dArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = dArr.length - i10;
        }
        R(g0Var, dArr, i10, i11);
    }

    public static final int c(@os.l e eVar, @os.l int[] iArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(iArr, "dst");
        int iF = l.f(eVar, iArr, i10, i11);
        int i12 = (i10 + iF) - 1;
        if (i10 <= i12) {
            while (true) {
                int i13 = i10 + 1;
                iArr[i10] = Integer.reverseBytes(iArr[i10]);
                if (i10 == i12) {
                    break;
                }
                i10 = i13;
            }
        }
        return iF;
    }

    public static /* synthetic */ void c0(g0 g0Var, float[] fArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = fArr.length - i10;
        }
        S(g0Var, fArr, i10, i11);
    }

    public static final int d(@os.l e eVar, @os.l long[] jArr, int i10, int i11) {
        int i12;
        kn.l0.p(eVar, "<this>");
        kn.l0.p(jArr, "dst");
        int iG = l.g(eVar, jArr, i10, i11);
        if (iG > 0 && i10 <= (i12 = (i10 + iG) - 1)) {
            while (true) {
                int i13 = i10 + 1;
                jArr[i10] = Long.reverseBytes(jArr[i10]);
                if (i10 == i12) {
                    break;
                }
                i10 = i13;
            }
        }
        return iG;
    }

    public static /* synthetic */ void d0(g0 g0Var, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        T(g0Var, iArr, i10, i11);
    }

    public static final int e(@os.l e eVar, @os.l short[] sArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(sArr, "dst");
        int iH = l.h(eVar, sArr, i10, i11);
        int i12 = (i10 + iH) - 1;
        if (i10 <= i12) {
            while (true) {
                int i13 = i10 + 1;
                sArr[i10] = Short.reverseBytes(sArr[i10]);
                if (i10 == i12) {
                    break;
                }
                i10 = i13;
            }
        }
        return iH;
    }

    public static /* synthetic */ void e0(g0 g0Var, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        U(g0Var, jArr, i10, i11);
    }

    public static final int f(@os.l g0 g0Var, @os.l double[] dArr, int i10, int i11) throws Throwable {
        int i12;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(dArr, "dst");
        int iC = i0.c(g0Var, dArr, i10, i11);
        if (iC > 0 && i10 <= (i12 = (i10 + iC) - 1)) {
            while (true) {
                int i13 = i10 + 1;
                dArr[i10] = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(dArr[i10])));
                if (i10 == i12) {
                    break;
                }
                i10 = i13;
            }
        }
        return iC;
    }

    public static /* synthetic */ void f0(g0 g0Var, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        V(g0Var, sArr, i10, i11);
    }

    public static final int g(@os.l g0 g0Var, @os.l float[] fArr, int i10, int i11) throws Throwable {
        int i12;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(fArr, "dst");
        int iD = i0.d(g0Var, fArr, i10, i11);
        if (iD > 0 && i10 <= (i12 = (i10 + iD) - 1)) {
            while (true) {
                int i13 = i10 + 1;
                fArr[i10] = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(fArr[i10])));
                if (i10 == i12) {
                    break;
                }
                i10 = i13;
            }
        }
        return iD;
    }

    public static final void g0(@os.l g0 g0Var, @os.l short[] sArr, int i10, int i11) {
        kn.l0.p(g0Var, "$this$readFullyLittleEndian");
        kn.l0.p(sArr, "dst");
        V(g0Var, sArr, i10, i11);
    }

    public static final int h(@os.l g0 g0Var, @os.l int[] iArr, int i10, int i11) throws Throwable {
        int i12;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(iArr, "dst");
        int iE = i0.e(g0Var, iArr, i10, i11);
        if (iE > 0 && i10 <= (i12 = (i10 + iE) - 1)) {
            while (true) {
                int i13 = i10 + 1;
                iArr[i10] = Integer.reverseBytes(iArr[i10]);
                if (i10 == i12) {
                    break;
                }
                i10 = i13;
            }
        }
        return iE;
    }

    public static void h0(g0 g0Var, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        g0(g0Var, sArr, i10, i11);
    }

    public static final int i(@os.l g0 g0Var, @os.l long[] jArr, int i10, int i11) throws Throwable {
        int i12;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(jArr, "dst");
        int iF = i0.f(g0Var, jArr, i10, i11);
        if (iF > 0 && i10 <= (i12 = (i10 + iF) - 1)) {
            while (true) {
                int i13 = i10 + 1;
                jArr[i10] = Long.reverseBytes(jArr[i10]);
                if (i10 == i12) {
                    break;
                }
                i10 = i13;
            }
        }
        return iF;
    }

    public static final void i0(@os.l g0 g0Var, @os.l int[] iArr, int i10, int i11) {
        kn.l0.p(g0Var, "$this$readFullyLittleEndian");
        kn.l0.p(iArr, "dst");
        T(g0Var, iArr, i10, i11);
    }

    public static final int j(@os.l g0 g0Var, @os.l short[] sArr, int i10, int i11) throws Throwable {
        int i12;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(sArr, "dst");
        int iG = i0.g(g0Var, sArr, i10, i11);
        if (iG > 0 && i10 <= (i12 = (i10 + iG) - 1)) {
            while (true) {
                int i13 = i10 + 1;
                sArr[i10] = Short.reverseBytes(sArr[i10]);
                if (i10 == i12) {
                    break;
                }
                i10 = i13;
            }
        }
        return iG;
    }

    public static void j0(g0 g0Var, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        i0(g0Var, iArr, i10, i11);
    }

    public static /* synthetic */ int k(e eVar, double[] dArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = dArr.length - i10;
        }
        return a(eVar, dArr, i10, i11);
    }

    public static final void k0(@os.l e eVar, @os.l short[] sArr, int i10, int i11) {
        kn.l0.p(eVar, "$this$readFullyLittleEndian");
        kn.l0.p(sArr, "dst");
        Q(eVar, sArr, i10, i11);
    }

    public static /* synthetic */ int l(e eVar, float[] fArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = fArr.length - i10;
        }
        return b(eVar, fArr, i10, i11);
    }

    public static void l0(e eVar, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        k0(eVar, sArr, i10, i11);
    }

    public static /* synthetic */ int m(e eVar, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        return c(eVar, iArr, i10, i11);
    }

    public static final void m0(@os.l e eVar, @os.l long[] jArr, int i10, int i11) {
        kn.l0.p(eVar, "$this$readFullyLittleEndian");
        kn.l0.p(jArr, "dst");
        P(eVar, jArr, i10, i11);
    }

    public static /* synthetic */ int n(e eVar, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        return d(eVar, jArr, i10, i11);
    }

    public static void n0(e eVar, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        m0(eVar, jArr, i10, i11);
    }

    public static /* synthetic */ int o(e eVar, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        return e(eVar, sArr, i10, i11);
    }

    public static final void o0(@os.l g0 g0Var, @os.l long[] jArr, int i10, int i11) {
        kn.l0.p(g0Var, "$this$readFullyLittleEndian");
        kn.l0.p(jArr, "dst");
        U(g0Var, jArr, i10, i11);
    }

    public static /* synthetic */ int p(g0 g0Var, double[] dArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = dArr.length - i10;
        }
        return f(g0Var, dArr, i10, i11);
    }

    public static void p0(g0 g0Var, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        o0(g0Var, jArr, i10, i11);
    }

    public static /* synthetic */ int q(g0 g0Var, float[] fArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = fArr.length - i10;
        }
        return g(g0Var, fArr, i10, i11);
    }

    public static final void q0(@os.l e eVar, @os.l int[] iArr, int i10, int i11) {
        kn.l0.p(eVar, "$this$readFullyLittleEndian");
        kn.l0.p(iArr, "dst");
        O(eVar, iArr, i10, i11);
    }

    public static /* synthetic */ int r(g0 g0Var, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        return h(g0Var, iArr, i10, i11);
    }

    public static void r0(e eVar, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        q0(eVar, iArr, i10, i11);
    }

    public static /* synthetic */ int s(g0 g0Var, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        return i(g0Var, jArr, i10, i11);
    }

    public static final int s0(@os.l g0 g0Var, @os.l q qVar) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(qVar, "byteOrder");
        return a.f15834a[qVar.ordinal()] == 1 ? m0.e(g0Var) : Integer.reverseBytes(m0.e(g0Var));
    }

    public static /* synthetic */ int t(g0 g0Var, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        return j(g0Var, sArr, i10, i11);
    }

    public static final int t0(@os.l e eVar) {
        kn.l0.p(eVar, "<this>");
        return Integer.reverseBytes(l.c0(eVar));
    }

    public static final int u(@os.l g0 g0Var, @os.l short[] sArr, int i10, int i11) {
        kn.l0.p(g0Var, "$this$readAvailableLittleEndian");
        kn.l0.p(sArr, "dst");
        return j(g0Var, sArr, i10, i11);
    }

    public static final int u0(@os.l g0 g0Var) {
        kn.l0.p(g0Var, "<this>");
        return Integer.reverseBytes(m0.e(g0Var));
    }

    public static int v(g0 g0Var, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        return u(g0Var, sArr, i10, i11);
    }

    public static final long v0(@os.l g0 g0Var, @os.l q qVar) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(qVar, "byteOrder");
        return a.f15834a[qVar.ordinal()] == 1 ? m0.g(g0Var) : Long.reverseBytes(m0.g(g0Var));
    }

    public static final int w(@os.l g0 g0Var, @os.l int[] iArr, int i10, int i11) {
        kn.l0.p(g0Var, "$this$readAvailableLittleEndian");
        kn.l0.p(iArr, "dst");
        return h(g0Var, iArr, i10, i11);
    }

    public static final long w0(@os.l e eVar) {
        kn.l0.p(eVar, "<this>");
        return Long.reverseBytes(l.e0(eVar));
    }

    public static int x(g0 g0Var, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        return w(g0Var, iArr, i10, i11);
    }

    public static final long x0(@os.l g0 g0Var) {
        kn.l0.p(g0Var, "<this>");
        return Long.reverseBytes(m0.g(g0Var));
    }

    public static final int y(@os.l e eVar, @os.l short[] sArr, int i10, int i11) {
        kn.l0.p(eVar, "$this$readAvailableLittleEndian");
        kn.l0.p(sArr, "dst");
        return e(eVar, sArr, i10, i11);
    }

    public static final <T> T y0(jn.a<? extends T> aVar, jn.l<? super T, ? extends T> lVar) {
        return lVar.invoke(aVar.invoke());
    }

    public static int z(e eVar, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        return y(eVar, sArr, i10, i11);
    }

    public static final <T> T z0(q qVar, jn.a<? extends T> aVar, jn.l<? super T, ? extends T> lVar) {
        return a.f15834a[qVar.ordinal()] == 1 ? aVar.invoke() : lVar.invoke(aVar.invoke());
    }
}
