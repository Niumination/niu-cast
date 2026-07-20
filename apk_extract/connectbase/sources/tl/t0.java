package tl;

import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class t0 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15883a;

        static {
            int[] iArr = new int[q.values().length];
            iArr[q.BIG_ENDIAN.ordinal()] = 1;
            f15883a = iArr;
        }
    }

    public static /* synthetic */ void A(q0 q0Var, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        q(q0Var, jArr, i10, i11);
    }

    public static /* synthetic */ void B(q0 q0Var, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        r(q0Var, sArr, i10, i11);
    }

    public static final void C(@os.l q0 q0Var, @os.l long[] jArr, int i10, int i11) {
        kn.l0.p(q0Var, "$this$writeFullyLittleEndian");
        kn.l0.p(jArr, "source");
        q(q0Var, jArr, i10, i11);
    }

    public static void D(q0 q0Var, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        C(q0Var, jArr, i10, i11);
    }

    public static final void E(@os.l q0 q0Var, @os.l short[] sArr, int i10, int i11) {
        kn.l0.p(q0Var, "$this$writeFullyLittleEndian");
        kn.l0.p(sArr, "source");
        r(q0Var, sArr, i10, i11);
    }

    public static void F(q0 q0Var, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        E(q0Var, sArr, i10, i11);
    }

    public static final void G(@os.l e eVar, @os.l short[] sArr, int i10, int i11) {
        kn.l0.p(eVar, "$this$writeFullyLittleEndian");
        kn.l0.p(sArr, "source");
        m(eVar, sArr, i10, i11);
    }

    public static void H(e eVar, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        G(eVar, sArr, i10, i11);
    }

    public static final void I(@os.l e eVar, @os.l long[] jArr, int i10, int i11) {
        kn.l0.p(eVar, "$this$writeFullyLittleEndian");
        kn.l0.p(jArr, "source");
        l(eVar, jArr, i10, i11);
    }

    public static void J(e eVar, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        I(eVar, jArr, i10, i11);
    }

    public static final void K(@os.l q0 q0Var, @os.l int[] iArr, int i10, int i11) {
        kn.l0.p(q0Var, "$this$writeFullyLittleEndian");
        kn.l0.p(iArr, "source");
        p(q0Var, iArr, i10, i11);
    }

    public static void L(q0 q0Var, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        K(q0Var, iArr, i10, i11);
    }

    public static final void M(@os.l e eVar, @os.l int[] iArr, int i10, int i11) {
        kn.l0.p(eVar, "$this$writeFullyLittleEndian");
        kn.l0.p(iArr, "source");
        k(eVar, iArr, i10, i11);
    }

    public static void N(e eVar, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        M(eVar, iArr, i10, i11);
    }

    public static final void O(@os.l q0 q0Var, int i10, @os.l q qVar) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(qVar, "byteOrder");
        if (a.f15883a[qVar.ordinal()] != 1) {
            i10 = Integer.reverseBytes(i10);
        }
        u0.c(q0Var, i10);
    }

    public static final void P(@os.l e eVar, int i10) {
        kn.l0.p(eVar, "<this>");
        l.T0(eVar, Integer.reverseBytes(i10));
    }

    public static final void Q(@os.l q0 q0Var, int i10) {
        kn.l0.p(q0Var, "<this>");
        u0.c(q0Var, Integer.reverseBytes(i10));
    }

    public static final void R(@os.l q0 q0Var, long j10, @os.l q qVar) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(qVar, "byteOrder");
        if (a.f15883a[qVar.ordinal()] != 1) {
            j10 = Long.reverseBytes(j10);
        }
        u0.f(q0Var, j10);
    }

    public static final void S(@os.l e eVar, long j10) {
        kn.l0.p(eVar, "<this>");
        l.V0(eVar, Long.reverseBytes(j10));
    }

    public static final void T(@os.l q0 q0Var, long j10) {
        kn.l0.p(q0Var, "<this>");
        u0.f(q0Var, Long.reverseBytes(j10));
    }

    public static final <T> void U(T t10, jn.l<? super T, l2> lVar, jn.l<? super T, ? extends T> lVar2) {
        lVar.invoke(lVar2.invoke(t10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public static final <T> void V(T t10, q qVar, jn.l<? super T, l2> lVar, jn.l<? super T, ? extends T> lVar2) {
        ?? Invoke = t10;
        if (a.f15883a[qVar.ordinal()] != 1) {
            Invoke = lVar2.invoke(t10);
        }
        lVar.invoke((Object) Invoke);
    }

    public static final void W(@os.l q0 q0Var, short s10, @os.l q qVar) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(qVar, "byteOrder");
        if (a.f15883a[qVar.ordinal()] != 1) {
            s10 = Short.reverseBytes(s10);
        }
        u0.j(q0Var, s10);
    }

    public static final void X(@os.l e eVar, short s10) {
        kn.l0.p(eVar, "<this>");
        l.X0(eVar, Short.reverseBytes(s10));
    }

    public static final void Y(@os.l q0 q0Var, short s10) {
        kn.l0.p(q0Var, "<this>");
        u0.j(q0Var, Short.reverseBytes(s10));
    }

    public static final void a(e eVar, int i10, int i11, int i12, jn.p<? super e, ? super Integer, l2> pVar) {
        m mVar = eVar.f15821b;
        int iMin = (Math.min((mVar.f15872a - mVar.f15874c) / i12, (i11 + i10) - i10) + i10) - 1;
        if (i10 > iMin) {
            return;
        }
        while (true) {
            int i13 = i10 + 1;
            pVar.invoke(eVar, Integer.valueOf(i10));
            if (i10 == iMin) {
                return;
            } else {
                i10 = i13;
            }
        }
    }

    public static final void b(q0 q0Var, int i10, int i11, int i12, jn.p<? super e, ? super Integer, l2> pVar) {
        int i13 = i11 + i10;
        ul.b bVarO = ul.k.o(q0Var, i12, null);
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int iMin = Math.min((mVar.f15872a - mVar.f15874c) / i12, i13 - i10) + i10;
                int i14 = iMin - 1;
                if (i10 <= i14) {
                    while (true) {
                        int i15 = i10 + 1;
                        pVar.invoke(bVarO, Integer.valueOf(i10));
                        if (i10 == i14) {
                            break;
                        } else {
                            i10 = i15;
                        }
                    }
                }
                int i16 = iMin < i13 ? i12 : 0;
                if (i16 <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return;
                } else {
                    bVarO = ul.k.o(q0Var, i16, bVarO);
                    i10 = iMin;
                }
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    public static final void c(@os.l q0 q0Var, double d10, @os.l q qVar) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(qVar, "byteOrder");
        if (a.f15883a[qVar.ordinal()] != 1) {
            d10 = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d10)));
        }
        u0.a(q0Var, d10);
    }

    public static final void d(@os.l e eVar, double d10) {
        kn.l0.p(eVar, "<this>");
        l.q0(eVar, Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d10))));
    }

    public static final void e(@os.l q0 q0Var, double d10) {
        kn.l0.p(q0Var, "<this>");
        u0.a(q0Var, Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d10))));
    }

    public static final void f(@os.l q0 q0Var, float f10, @os.l q qVar) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(qVar, "byteOrder");
        if (a.f15883a[qVar.ordinal()] != 1) {
            f10 = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f10)));
        }
        u0.b(q0Var, f10);
    }

    public static final void g(@os.l e eVar, float f10) {
        kn.l0.p(eVar, "<this>");
        l.t0(eVar, Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f10))));
    }

    public static final void h(@os.l q0 q0Var, float f10) {
        kn.l0.p(q0Var, "<this>");
        u0.b(q0Var, Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f10))));
    }

    public static final void i(@os.l e eVar, @os.l double[] dArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(dArr, "source");
        m mVar = eVar.f15821b;
        int iMin = (Math.min((mVar.f15872a - mVar.f15874c) / 8, (i11 + i10) - i10) + i10) - 1;
        if (i10 > iMin) {
            return;
        }
        while (true) {
            int i12 = i10 + 1;
            l.q0(eVar, Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(dArr[i10]))));
            if (i10 == iMin) {
                return;
            } else {
                i10 = i12;
            }
        }
    }

    public static final void j(@os.l e eVar, @os.l float[] fArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(fArr, "source");
        m mVar = eVar.f15821b;
        int iMin = (Math.min((mVar.f15872a - mVar.f15874c) / 4, (i11 + i10) - i10) + i10) - 1;
        if (i10 > iMin) {
            return;
        }
        while (true) {
            int i12 = i10 + 1;
            l.t0(eVar, Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(fArr[i10]))));
            if (i10 == iMin) {
                return;
            } else {
                i10 = i12;
            }
        }
    }

    public static final void k(@os.l e eVar, @os.l int[] iArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(iArr, "source");
        m mVar = eVar.f15821b;
        int iMin = (Math.min((mVar.f15872a - mVar.f15874c) / 4, (i11 + i10) - i10) + i10) - 1;
        if (i10 > iMin) {
            return;
        }
        while (true) {
            int i12 = i10 + 1;
            l.T0(eVar, Integer.reverseBytes(iArr[i10]));
            if (i10 == iMin) {
                return;
            } else {
                i10 = i12;
            }
        }
    }

    public static final void l(@os.l e eVar, @os.l long[] jArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(jArr, "source");
        m mVar = eVar.f15821b;
        int iMin = (Math.min((mVar.f15872a - mVar.f15874c) / 8, (i11 + i10) - i10) + i10) - 1;
        if (i10 > iMin) {
            return;
        }
        while (true) {
            int i12 = i10 + 1;
            l.V0(eVar, Long.reverseBytes(jArr[i10]));
            if (i10 == iMin) {
                return;
            } else {
                i10 = i12;
            }
        }
    }

    public static final void m(@os.l e eVar, @os.l short[] sArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(sArr, "source");
        m mVar = eVar.f15821b;
        int iMin = (Math.min((mVar.f15872a - mVar.f15874c) / 2, (i11 + i10) - i10) + i10) - 1;
        if (i10 > iMin) {
            return;
        }
        while (true) {
            int i12 = i10 + 1;
            l.X0(eVar, Short.reverseBytes(sArr[i10]));
            if (i10 == iMin) {
                return;
            } else {
                i10 = i12;
            }
        }
    }

    public static final void n(@os.l q0 q0Var, @os.l double[] dArr, int i10, int i11) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(dArr, "source");
        int i12 = i11 + i10;
        ul.b bVarO = ul.k.o(q0Var, 8, null);
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int iMin = Math.min((mVar.f15872a - mVar.f15874c) / 8, i12 - i10) + i10;
                int i13 = iMin - 1;
                if (i10 <= i13) {
                    while (true) {
                        int i14 = i10 + 1;
                        l.q0(bVarO, Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(dArr[i10]))));
                        if (i10 == i13) {
                            break;
                        } else {
                            i10 = i14;
                        }
                    }
                }
                int i15 = iMin < i12 ? 8 : 0;
                if (i15 <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return;
                } else {
                    bVarO = ul.k.o(q0Var, i15, bVarO);
                    i10 = iMin;
                }
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    public static final void o(@os.l q0 q0Var, @os.l float[] fArr, int i10, int i11) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(fArr, "source");
        int i12 = i11 + i10;
        ul.b bVarO = ul.k.o(q0Var, 4, null);
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int iMin = Math.min((mVar.f15872a - mVar.f15874c) / 4, i12 - i10) + i10;
                int i13 = iMin - 1;
                if (i10 <= i13) {
                    while (true) {
                        int i14 = i10 + 1;
                        l.t0(bVarO, Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(fArr[i10]))));
                        if (i10 == i13) {
                            break;
                        } else {
                            i10 = i14;
                        }
                    }
                }
                int i15 = iMin < i12 ? 4 : 0;
                if (i15 <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return;
                } else {
                    bVarO = ul.k.o(q0Var, i15, bVarO);
                    i10 = iMin;
                }
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    public static final void p(@os.l q0 q0Var, @os.l int[] iArr, int i10, int i11) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(iArr, "source");
        int i12 = i11 + i10;
        ul.b bVarO = ul.k.o(q0Var, 4, null);
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int iMin = Math.min((mVar.f15872a - mVar.f15874c) / 4, i12 - i10) + i10;
                int i13 = iMin - 1;
                if (i10 <= i13) {
                    while (true) {
                        int i14 = i10 + 1;
                        l.T0(bVarO, Integer.reverseBytes(iArr[i10]));
                        if (i10 == i13) {
                            break;
                        } else {
                            i10 = i14;
                        }
                    }
                }
                int i15 = iMin < i12 ? 4 : 0;
                if (i15 <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return;
                } else {
                    bVarO = ul.k.o(q0Var, i15, bVarO);
                    i10 = iMin;
                }
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    public static final void q(@os.l q0 q0Var, @os.l long[] jArr, int i10, int i11) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(jArr, "source");
        int i12 = i11 + i10;
        ul.b bVarO = ul.k.o(q0Var, 8, null);
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int iMin = Math.min((mVar.f15872a - mVar.f15874c) / 8, i12 - i10) + i10;
                int i13 = iMin - 1;
                if (i10 <= i13) {
                    while (true) {
                        int i14 = i10 + 1;
                        l.V0(bVarO, Long.reverseBytes(jArr[i10]));
                        if (i10 == i13) {
                            break;
                        } else {
                            i10 = i14;
                        }
                    }
                }
                int i15 = iMin < i12 ? 8 : 0;
                if (i15 <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return;
                } else {
                    bVarO = ul.k.o(q0Var, i15, bVarO);
                    i10 = iMin;
                }
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    public static final void r(@os.l q0 q0Var, @os.l short[] sArr, int i10, int i11) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(sArr, "source");
        int i12 = i11 + i10;
        ul.b bVarO = ul.k.o(q0Var, 2, null);
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int iMin = Math.min((mVar.f15872a - mVar.f15874c) / 2, i12 - i10) + i10;
                int i13 = iMin - 1;
                if (i10 <= i13) {
                    while (true) {
                        int i14 = i10 + 1;
                        l.X0(bVarO, Short.reverseBytes(sArr[i10]));
                        if (i10 == i13) {
                            break;
                        } else {
                            i10 = i14;
                        }
                    }
                }
                int i15 = iMin < i12 ? 2 : 0;
                if (i15 <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return;
                } else {
                    bVarO = ul.k.o(q0Var, i15, bVarO);
                    i10 = iMin;
                }
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    public static /* synthetic */ void s(e eVar, double[] dArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = dArr.length - i10;
        }
        i(eVar, dArr, i10, i11);
    }

    public static /* synthetic */ void t(e eVar, float[] fArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = fArr.length - i10;
        }
        j(eVar, fArr, i10, i11);
    }

    public static /* synthetic */ void u(e eVar, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        k(eVar, iArr, i10, i11);
    }

    public static /* synthetic */ void v(e eVar, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        l(eVar, jArr, i10, i11);
    }

    public static /* synthetic */ void w(e eVar, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        m(eVar, sArr, i10, i11);
    }

    public static /* synthetic */ void x(q0 q0Var, double[] dArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = dArr.length - i10;
        }
        n(q0Var, dArr, i10, i11);
    }

    public static /* synthetic */ void y(q0 q0Var, float[] fArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = fArr.length - i10;
        }
        o(q0Var, fArr, i10, i11);
    }

    public static /* synthetic */ void z(q0 q0Var, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        p(q0Var, iArr, i10, i11);
    }
}
