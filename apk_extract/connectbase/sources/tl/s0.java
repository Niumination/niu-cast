package tl;

import java.io.IOException;
import java.nio.ByteBuffer;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class s0 {
    public static final void A(q0 q0Var, long j10, long j11, jn.r<? super ql.f, ? super Long, ? super Long, ? super Long, l2> rVar) {
        ul.b bVarO = ul.k.o(q0Var, 1, null);
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                long jMin = Math.min(j11, mVar.f15872a - mVar.f15874c);
                rVar.invoke(ql.f.b(bVarO.f15820a), Long.valueOf(bVarO.f15821b.f15874c), Long.valueOf(j10), Long.valueOf(jMin));
                bVarO.b((int) jMin);
                j10 += jMin;
                j11 -= jMin;
                if (j11 <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return;
                }
                bVarO = ul.k.o(q0Var, 1, bVarO);
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    public static final void B(q0 q0Var, int i10, int i11, int i12, jn.q<? super e, ? super Integer, ? super Integer, l2> qVar) {
        ul.b bVarO = ul.k.o(q0Var, i10, null);
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int iMin = Math.min(i12, mVar.f15872a - mVar.f15874c);
                qVar.invoke(bVarO, Integer.valueOf(i11), Integer.valueOf(iMin));
                i11 += iMin;
                i12 -= iMin;
                int i13 = i12 * i10;
                if (i13 <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return;
                }
                bVarO = ul.k.o(q0Var, i13, bVarO);
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    public static final void C(@os.l q0 q0Var, @os.l v vVar) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(vVar, "packet");
        if (q0Var instanceof t) {
            ((t) q0Var).l2(vVar);
            return;
        }
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(vVar, 1);
        if (bVarJ == null) {
            return;
        }
        do {
            try {
                p(q0Var, bVarJ, 0, 2, null);
                try {
                    bVarJ = ul.k.m(vVar, bVarJ);
                } catch (Throwable th2) {
                    th = th2;
                    z10 = false;
                    if (z10) {
                        ul.k.e(vVar, bVarJ);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } while (bVarJ != null);
    }

    @ul.d
    public static final void D(@os.l q0 q0Var, @os.l jn.l<? super e, Boolean> lVar) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(lVar, "block");
        ul.b bVarO = ul.k.o(q0Var, 1, null);
        while (lVar.invoke(bVarO).booleanValue()) {
            try {
                bVarO = ul.k.o(q0Var, 1, bVarO);
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
        ul.k.b(q0Var, bVarO);
    }

    @ul.d
    public static final void E(@os.l q0 q0Var, int i10, @os.l jn.l<? super e, Integer> lVar) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(lVar, "block");
        ul.b bVarO = ul.k.o(q0Var, i10, null);
        while (true) {
            try {
                int iIntValue = lVar.invoke(bVarO).intValue();
                if (iIntValue <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return;
                }
                bVarO = ul.k.o(q0Var, iIntValue, bVarO);
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    public static void F(q0 q0Var, int i10, jn.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(lVar, "block");
        ul.b bVarO = ul.k.o(q0Var, i10, null);
        while (true) {
            try {
                int iIntValue = ((Number) lVar.invoke(bVarO)).intValue();
                if (iIntValue <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return;
                }
                bVarO = ul.k.o(q0Var, iIntValue, bVarO);
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    @os.l
    public static final Appendable a(@os.l q0 q0Var, @os.l CharSequence charSequence, int i10, int i11) throws IOException {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(charSequence, "csq");
        Appendable appendableAppend = q0Var.append(charSequence, i10, i11);
        kn.l0.o(appendableAppend, "append(csq, start, end)");
        return appendableAppend;
    }

    @os.l
    public static final Appendable b(@os.l q0 q0Var, @os.l char[] cArr, int i10, int i11) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(cArr, "csq");
        return q0Var.f1(cArr, i10, i11);
    }

    public static /* synthetic */ Appendable c(q0 q0Var, CharSequence charSequence, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = charSequence.length();
        }
        return a(q0Var, charSequence, i10, i11);
    }

    public static /* synthetic */ Appendable d(q0 q0Var, char[] cArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = cArr.length;
        }
        return b(q0Var, cArr, i10, i11);
    }

    public static final void e(@os.l q0 q0Var, long j10, byte b10) {
        kn.l0.p(q0Var, "<this>");
        if (!(q0Var instanceof c)) {
            g(q0Var, j10, b10);
            return;
        }
        ul.b bVarO = ul.k.o(q0Var, 1, null);
        long j11 = 0;
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int iMin = (int) Math.min(mVar.f15872a - mVar.f15874c, j10 - j11);
                g.h(bVarO, iMin, b10);
                j11 += (long) iMin;
                if (j11 >= j10) {
                    ul.k.b(q0Var, bVarO);
                    return;
                }
                bVarO = ul.k.o(q0Var, 1, bVarO);
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    public static /* synthetic */ void f(q0 q0Var, long j10, byte b10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            b10 = 0;
        }
        e(q0Var, j10, b10);
    }

    public static final void g(q0 q0Var, long j10, byte b10) {
        long j11 = 0;
        while (j11 < j10) {
            j11++;
            q0Var.d1(b10);
        }
    }

    public static final void h(@os.l q0 q0Var, @os.l e eVar, int i10) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(eVar, "src");
        ul.b bVarO = ul.k.o(q0Var, 1, null);
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int iMin = Math.min(i10, mVar.f15872a - mVar.f15874c);
                l.w0(bVarO, eVar, iMin);
                i10 -= iMin;
                if (i10 <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return;
                }
                bVarO = ul.k.o(q0Var, 1, bVarO);
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void i(q0 q0Var, o0 o0Var, int i10) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(o0Var, "src");
        h(q0Var, o0Var, i10);
    }

    public static final void j(@os.l q0 q0Var, @os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(bArr, "src");
        ul.b bVarO = ul.k.o(q0Var, 1, null);
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int iMin = Math.min(i11, mVar.f15872a - mVar.f15874c);
                l.x0(bVarO, bArr, i10, iMin);
                i10 += iMin;
                i11 -= iMin;
                if (i11 <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return;
                }
                bVarO = ul.k.o(q0Var, 1, bVarO);
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    public static final void k(@os.l q0 q0Var, @os.l double[] dArr, int i10, int i11) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(dArr, "src");
        ul.b bVarO = ul.k.o(q0Var, 8, null);
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int iMin = Math.min(i11, mVar.f15872a - mVar.f15874c);
                l.y0(bVarO, dArr, i10, iMin);
                i10 += iMin;
                i11 -= iMin;
                int i12 = i11 * 8;
                if (i12 <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return;
                }
                bVarO = ul.k.o(q0Var, i12, bVarO);
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    public static final void l(@os.l q0 q0Var, @os.l float[] fArr, int i10, int i11) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(fArr, "src");
        ul.b bVarO = ul.k.o(q0Var, 4, null);
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int iMin = Math.min(i11, mVar.f15872a - mVar.f15874c);
                l.z0(bVarO, fArr, i10, iMin);
                i10 += iMin;
                i11 -= iMin;
                int i12 = i11 * 4;
                if (i12 <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return;
                }
                bVarO = ul.k.o(q0Var, i12, bVarO);
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    public static final void m(@os.l q0 q0Var, @os.l int[] iArr, int i10, int i11) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(iArr, "src");
        ul.b bVarO = ul.k.o(q0Var, 4, null);
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int iMin = Math.min(i11, mVar.f15872a - mVar.f15874c);
                l.A0(bVarO, iArr, i10, iMin);
                i10 += iMin;
                i11 -= iMin;
                int i12 = i11 * 4;
                if (i12 <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return;
                }
                bVarO = ul.k.o(q0Var, i12, bVarO);
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    public static final void n(@os.l q0 q0Var, @os.l long[] jArr, int i10, int i11) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(jArr, "src");
        ul.b bVarO = ul.k.o(q0Var, 8, null);
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int iMin = Math.min(i11, mVar.f15872a - mVar.f15874c);
                l.B0(bVarO, jArr, i10, iMin);
                i10 += iMin;
                i11 -= iMin;
                int i12 = i11 * 8;
                if (i12 <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return;
                }
                bVarO = ul.k.o(q0Var, i12, bVarO);
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    public static final void o(@os.l q0 q0Var, @os.l short[] sArr, int i10, int i11) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(sArr, "src");
        ul.b bVarO = ul.k.o(q0Var, 2, null);
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int iMin = Math.min(i11, mVar.f15872a - mVar.f15874c);
                l.C0(bVarO, sArr, i10, iMin);
                i10 += iMin;
                i11 -= iMin;
                int i12 = i11 * 2;
                if (i12 <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return;
                }
                bVarO = ul.k.o(q0Var, i12, bVarO);
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    public static void p(q0 q0Var, e eVar, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            m mVar = eVar.f15821b;
            i10 = mVar.f15874c - mVar.f15873b;
        }
        h(q0Var, eVar, i10);
    }

    public static void q(q0 q0Var, o0 o0Var, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            m mVar = o0Var.f15821b;
            i10 = mVar.f15874c - mVar.f15873b;
        }
        i(q0Var, o0Var, i10);
    }

    public static /* synthetic */ void r(q0 q0Var, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        j(q0Var, bArr, i10, i11);
    }

    public static /* synthetic */ void s(q0 q0Var, double[] dArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = dArr.length - i10;
        }
        k(q0Var, dArr, i10, i11);
    }

    public static /* synthetic */ void t(q0 q0Var, float[] fArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = fArr.length - i10;
        }
        l(q0Var, fArr, i10, i11);
    }

    public static /* synthetic */ void u(q0 q0Var, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        m(q0Var, iArr, i10, i11);
    }

    public static /* synthetic */ void v(q0 q0Var, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        n(q0Var, jArr, i10, i11);
    }

    public static /* synthetic */ void w(q0 q0Var, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        o(q0Var, sArr, i10, i11);
    }

    public static final void x(@os.l q0 q0Var, @os.l ByteBuffer byteBuffer, int i10, int i11) throws Throwable {
        kn.l0.p(q0Var, "$this$writeFully");
        kn.l0.p(byteBuffer, "src");
        y(q0Var, byteBuffer, i10, i11);
    }

    public static final void y(@os.l q0 q0Var, @os.l ByteBuffer byteBuffer, long j10, long j11) throws Throwable {
        ul.b bVar;
        kn.l0.p(q0Var, "$this$writeFully");
        kn.l0.p(byteBuffer, "src");
        long j12 = j10;
        long j13 = j11;
        ul.b bVarO = ul.k.o(q0Var, 1, null);
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                long jMin = Math.min(j13, mVar.f15872a - mVar.f15874c);
                bVar = bVarO;
                try {
                    ql.f.e(byteBuffer, bVarO.f15820a, j12, jMin, bVarO.f15821b.f15874c);
                    bVar.b((int) jMin);
                    j12 += jMin;
                    j13 -= jMin;
                    if (j13 <= 0) {
                        ul.k.b(q0Var, bVar);
                        return;
                    }
                    bVarO = ul.k.o(q0Var, 1, bVar);
                } catch (Throwable th2) {
                    th = th2;
                    ul.k.b(q0Var, bVar);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bVar = bVarO;
            }
        }
    }

    public static final void z(q0 q0Var, int i10, int i11, jn.q<? super e, ? super Integer, ? super Integer, l2> qVar) {
        ul.b bVarO = ul.k.o(q0Var, 1, null);
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int iMin = Math.min(i11, mVar.f15872a - mVar.f15874c);
                qVar.invoke(bVarO, Integer.valueOf(i10), Integer.valueOf(iMin));
                i10 += iMin;
                i11 -= iMin;
                if (i11 <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return;
                }
                bVarO = ul.k.o(q0Var, 1, bVarO);
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }
}
