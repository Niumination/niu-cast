package tn;

import java.util.NoSuchElementException;
import kn.l0;
import kn.r1;
import lm.f1;
import lm.p2;
import n2.k0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\n_Ranges.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Ranges.kt\nkotlin/ranges/RangesKt___RangesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1537:1\n1#2:1538\n*E\n"})
public class u extends t {
    public static final float A(float f10, float f11) {
        return f10 > f11 ? f11 : f10;
    }

    @os.m
    @f1(version = "1.7")
    public static final Integer A0(@os.l j jVar) {
        l0.p(jVar, "<this>");
        if (jVar.isEmpty()) {
            return null;
        }
        return Integer.valueOf(jVar.f15911a);
    }

    @os.l
    public static final a A1(@os.l a aVar, int i10) {
        l0.p(aVar, "<this>");
        t.a(i10 > 0, Integer.valueOf(i10));
        a.C0410a c0410a = a.f15890d;
        char c10 = aVar.f15891a;
        char c11 = aVar.f15892b;
        if (aVar.f15893c <= 0) {
            i10 = -i10;
        }
        c0410a.getClass();
        return new a(c10, c11, i10);
    }

    public static int B(int i10, int i11) {
        return i10 > i11 ? i11 : i10;
    }

    @os.m
    @f1(version = "1.7")
    public static final Long B0(@os.l m mVar) {
        l0.p(mVar, "<this>");
        if (mVar.isEmpty()) {
            return null;
        }
        return Long.valueOf(mVar.f15921a);
    }

    @os.l
    public static j B1(@os.l j jVar, int i10) {
        l0.p(jVar, "<this>");
        t.a(i10 > 0, Integer.valueOf(i10));
        j.a aVar = j.f15910d;
        int i11 = jVar.f15911a;
        int i12 = jVar.f15912b;
        if (jVar.f15913c <= 0) {
            i10 = -i10;
        }
        aVar.getClass();
        return new j(i11, i12, i10);
    }

    public static long C(long j10, long j11) {
        return j10 > j11 ? j11 : j10;
    }

    @lm.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @in.i(name = "floatRangeContains")
    @lm.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean C0(g gVar, byte b10) {
        l0.p(gVar, "<this>");
        return gVar.contains(Float.valueOf(b10));
    }

    @os.l
    public static final m C1(@os.l m mVar, long j10) {
        l0.p(mVar, "<this>");
        t.a(j10 > 0, Long.valueOf(j10));
        m.a aVar = m.f15920d;
        long j11 = mVar.f15921a;
        long j12 = mVar.f15922b;
        if (mVar.f15923c <= 0) {
            j10 = -j10;
        }
        long j13 = j10;
        aVar.getClass();
        return new m(j11, j12, j13);
    }

    @os.l
    public static final <T extends Comparable<? super T>> T D(@os.l T t10, @os.l T t11) {
        l0.p(t10, "<this>");
        l0.p(t11, "maximumValue");
        return t10.compareTo(t11) > 0 ? t11 : t10;
    }

    @in.i(name = "floatRangeContains")
    public static final boolean D0(@os.l g<Float> gVar, double d10) {
        l0.p(gVar, "<this>");
        return gVar.contains(Float.valueOf((float) d10));
    }

    @os.m
    public static final Byte D1(double d10) {
        if (-128.0d > d10 || d10 > 127.0d) {
            return null;
        }
        return Byte.valueOf((byte) d10);
    }

    public static final short E(short s10, short s11) {
        return s10 > s11 ? s11 : s10;
    }

    @lm.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @in.i(name = "floatRangeContains")
    @lm.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean E0(g gVar, int i10) {
        l0.p(gVar, "<this>");
        return gVar.contains(Float.valueOf(i10));
    }

    @os.m
    public static final Byte E1(float f10) {
        if (-128.0f > f10 || f10 > 127.0f) {
            return null;
        }
        return Byte.valueOf((byte) f10);
    }

    public static final byte F(byte b10, byte b11, byte b12) {
        if (b11 <= b12) {
            if (b10 < b11) {
                return b11;
            }
            return b10 > b12 ? b12 : b10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) b12) + " is less than minimum " + ((int) b11) + n1.e.f11183c);
    }

    @lm.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @in.i(name = "floatRangeContains")
    @lm.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean F0(g gVar, long j10) {
        l0.p(gVar, "<this>");
        return gVar.contains(Float.valueOf(j10));
    }

    @os.m
    public static final Byte F1(int i10) {
        if (new l(-128, 127, 1).l(i10)) {
            return Byte.valueOf((byte) i10);
        }
        return null;
    }

    public static final double G(double d10, double d11, double d12) {
        if (d11 <= d12) {
            if (d10 < d11) {
                return d11;
            }
            return d10 > d12 ? d12 : d10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d12 + " is less than minimum " + d11 + n1.e.f11183c);
    }

    @lm.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @in.i(name = "floatRangeContains")
    @lm.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean G0(g gVar, short s10) {
        l0.p(gVar, "<this>");
        return gVar.contains(Float.valueOf(s10));
    }

    @os.m
    public static final Byte G1(long j10) {
        if (new o(-128L, 127L).l(j10)) {
            return Byte.valueOf((byte) j10);
        }
        return null;
    }

    public static final float H(float f10, float f11, float f12) {
        if (f11 <= f12) {
            if (f10 < f11) {
                return f11;
            }
            return f10 > f12 ? f12 : f10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f12 + " is less than minimum " + f11 + n1.e.f11183c);
    }

    @in.i(name = "intRangeContains")
    public static final boolean H0(@os.l g<Integer> gVar, byte b10) {
        l0.p(gVar, "<this>");
        return gVar.contains(Integer.valueOf(b10));
    }

    @os.m
    public static final Byte H1(short s10) {
        if (L0(new l(-128, 127, 1), s10)) {
            return Byte.valueOf((byte) s10);
        }
        return null;
    }

    public static int I(int i10, int i11, int i12) {
        if (i11 <= i12) {
            if (i10 < i11) {
                return i11;
            }
            return i10 > i12 ? i12 : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i12 + " is less than minimum " + i11 + n1.e.f11183c);
    }

    @lm.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @in.i(name = "intRangeContains")
    @lm.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean I0(g gVar, double d10) {
        l0.p(gVar, "<this>");
        Integer numI1 = I1(d10);
        if (numI1 != null) {
            return gVar.contains(numI1);
        }
        return false;
    }

    @os.m
    public static final Integer I1(double d10) {
        if (-2.147483648E9d > d10 || d10 > 2.147483647E9d) {
            return null;
        }
        return Integer.valueOf((int) d10);
    }

    public static final int J(int i10, @os.l g<Integer> gVar) {
        l0.p(gVar, "range");
        if (gVar instanceof f) {
            return ((Number) N(Integer.valueOf(i10), (f) gVar)).intValue();
        }
        if (!gVar.isEmpty()) {
            if (i10 < ((Number) gVar.getStart()).intValue()) {
                return ((Number) gVar.getStart()).intValue();
            }
            return i10 > ((Number) gVar.getEndInclusive()).intValue() ? ((Number) gVar.getEndInclusive()).intValue() : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + gVar + n1.e.f11183c);
    }

    @lm.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @in.i(name = "intRangeContains")
    @lm.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean J0(g gVar, float f10) {
        l0.p(gVar, "<this>");
        Integer numJ1 = J1(f10);
        if (numJ1 != null) {
            return gVar.contains(numJ1);
        }
        return false;
    }

    @os.m
    public static final Integer J1(float f10) {
        if (-2.1474836E9f > f10 || f10 > 2.1474836E9f) {
            return null;
        }
        return Integer.valueOf((int) f10);
    }

    public static long K(long j10, long j11, long j12) {
        if (j11 > j12) {
            throw new IllegalArgumentException(k0.a(j.b.a("Cannot coerce value to an empty range: maximum ", j12, " is less than minimum "), j11, n1.e.f11183c));
        }
        if (j10 < j11) {
            return j11;
        }
        return j10 > j12 ? j12 : j10;
    }

    @in.i(name = "intRangeContains")
    public static boolean K0(@os.l g<Integer> gVar, long j10) {
        l0.p(gVar, "<this>");
        Integer numK1 = K1(j10);
        if (numK1 != null) {
            return gVar.contains(numK1);
        }
        return false;
    }

    @os.m
    public static final Integer K1(long j10) {
        if (new o(-2147483648L, 2147483647L).l(j10)) {
            return Integer.valueOf((int) j10);
        }
        return null;
    }

    public static long L(long j10, @os.l g<Long> gVar) {
        l0.p(gVar, "range");
        if (gVar instanceof f) {
            return ((Number) N(Long.valueOf(j10), (f) gVar)).longValue();
        }
        if (!gVar.isEmpty()) {
            if (j10 < ((Number) gVar.getStart()).longValue()) {
                return ((Number) gVar.getStart()).longValue();
            }
            return j10 > ((Number) gVar.getEndInclusive()).longValue() ? ((Number) gVar.getEndInclusive()).longValue() : j10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + gVar + n1.e.f11183c);
    }

    @in.i(name = "intRangeContains")
    public static final boolean L0(@os.l g<Integer> gVar, short s10) {
        l0.p(gVar, "<this>");
        return gVar.contains(Integer.valueOf(s10));
    }

    @os.m
    public static final Long L1(double d10) {
        if (-9.223372036854776E18d > d10 || d10 > 9.223372036854776E18d) {
            return null;
        }
        return Long.valueOf((long) d10);
    }

    @os.l
    public static final <T extends Comparable<? super T>> T M(@os.l T t10, @os.m T t11, @os.m T t12) {
        l0.p(t10, "<this>");
        if (t11 == null || t12 == null) {
            if (t11 != null && t10.compareTo(t11) < 0) {
                return t11;
            }
            if (t12 != null && t10.compareTo(t12) > 0) {
                return t12;
            }
        } else {
            if (t11.compareTo(t12) > 0) {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t12 + " is less than minimum " + t11 + n1.e.f11183c);
            }
            if (t10.compareTo(t11) < 0) {
                return t11;
            }
            if (t10.compareTo(t12) > 0) {
                return t12;
            }
        }
        return t10;
    }

    @f1(version = "1.9")
    @in.i(name = "intRangeContains")
    @p2(markerClass = {lm.r.class})
    public static final boolean M0(@os.l r<Integer> rVar, byte b10) {
        l0.p(rVar, "<this>");
        return rVar.contains(Integer.valueOf(b10));
    }

    @os.m
    public static final Long M1(float f10) {
        if (-9.223372E18f > f10 || f10 > 9.223372E18f) {
            return null;
        }
        return Long.valueOf((long) f10);
    }

    @f1(version = "1.1")
    @os.l
    public static final <T extends Comparable<? super T>> T N(@os.l T t10, @os.l f<T> fVar) {
        l0.p(t10, "<this>");
        l0.p(fVar, "range");
        if (fVar.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + fVar + n1.e.f11183c);
        }
        if (!fVar.a(t10, fVar.getStart()) || fVar.a(fVar.getStart(), t10)) {
            return (!fVar.a(fVar.getEndInclusive(), t10) || fVar.a(t10, fVar.getEndInclusive())) ? t10 : fVar.getEndInclusive();
        }
        return fVar.getStart();
    }

    @f1(version = "1.9")
    @in.i(name = "intRangeContains")
    @p2(markerClass = {lm.r.class})
    public static final boolean N0(@os.l r<Integer> rVar, long j10) {
        l0.p(rVar, "<this>");
        Integer numK1 = K1(j10);
        if (numK1 != null) {
            return rVar.contains(numK1);
        }
        return false;
    }

    @os.m
    public static final Short N1(double d10) {
        if (-32768.0d > d10 || d10 > 32767.0d) {
            return null;
        }
        return Short.valueOf((short) d10);
    }

    @os.l
    public static final <T extends Comparable<? super T>> T O(@os.l T t10, @os.l g<T> gVar) {
        l0.p(t10, "<this>");
        l0.p(gVar, "range");
        if (gVar instanceof f) {
            return (T) N(t10, (f) gVar);
        }
        if (!gVar.isEmpty()) {
            if (t10.compareTo(gVar.getStart()) < 0) {
                return (T) gVar.getStart();
            }
            return t10.compareTo(gVar.getEndInclusive()) > 0 ? (T) gVar.getEndInclusive() : t10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + gVar + n1.e.f11183c);
    }

    @f1(version = "1.9")
    @in.i(name = "intRangeContains")
    @p2(markerClass = {lm.r.class})
    public static final boolean O0(@os.l r<Integer> rVar, short s10) {
        l0.p(rVar, "<this>");
        return rVar.contains(Integer.valueOf(s10));
    }

    @os.m
    public static final Short O1(float f10) {
        if (-32768.0f > f10 || f10 > 32767.0f) {
            return null;
        }
        return Short.valueOf((short) f10);
    }

    public static final short P(short s10, short s11, short s12) {
        if (s11 <= s12) {
            if (s10 < s11) {
                return s11;
            }
            return s10 > s12 ? s12 : s10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) s12) + " is less than minimum " + ((int) s11) + n1.e.f11183c);
    }

    @f1(version = "1.7")
    public static final char P0(@os.l a aVar) {
        l0.p(aVar, "<this>");
        if (!aVar.isEmpty()) {
            return aVar.f15892b;
        }
        throw new NoSuchElementException("Progression " + aVar + " is empty.");
    }

    @os.m
    public static final Short P1(int i10) {
        if (new l(-32768, 32767, 1).l(i10)) {
            return Short.valueOf((short) i10);
        }
        return null;
    }

    @f1(version = "1.3")
    @an.f
    public static final boolean Q(c cVar, Character ch2) {
        l0.p(cVar, "<this>");
        return ch2 != null && cVar.l(ch2.charValue());
    }

    @f1(version = "1.7")
    public static final int Q0(@os.l j jVar) {
        l0.p(jVar, "<this>");
        if (!jVar.isEmpty()) {
            return jVar.f15912b;
        }
        throw new NoSuchElementException("Progression " + jVar + " is empty.");
    }

    @os.m
    public static final Short Q1(long j10) {
        if (new o(-32768L, 32767L).l(j10)) {
            return Short.valueOf((short) j10);
        }
        return null;
    }

    @an.f
    public static final boolean R(l lVar, byte b10) {
        l0.p(lVar, "<this>");
        return H0(lVar, b10);
    }

    @f1(version = "1.7")
    public static final long R0(@os.l m mVar) {
        l0.p(mVar, "<this>");
        if (!mVar.isEmpty()) {
            return mVar.f15922b;
        }
        throw new NoSuchElementException("Progression " + mVar + " is empty.");
    }

    @os.l
    public static final c R1(char c10, char c11) {
        if (l0.t(c11, 0) > 0) {
            return new c(c10, (char) (c11 - 1), 1);
        }
        c.f15900e.getClass();
        return c.f15901f;
    }

    @an.f
    public static final boolean S(l lVar, long j10) {
        l0.p(lVar, "<this>");
        return K0(lVar, j10);
    }

    @os.m
    @f1(version = "1.7")
    public static final Character S0(@os.l a aVar) {
        l0.p(aVar, "<this>");
        if (aVar.isEmpty()) {
            return null;
        }
        return Character.valueOf(aVar.f15892b);
    }

    @os.l
    public static final l S1(byte b10, byte b11) {
        return new l(b10, b11 - 1, 1);
    }

    @f1(version = "1.3")
    @an.f
    public static final boolean T(l lVar, Integer num) {
        l0.p(lVar, "<this>");
        return num != null && lVar.l(num.intValue());
    }

    @os.m
    @f1(version = "1.7")
    public static final Integer T0(@os.l j jVar) {
        l0.p(jVar, "<this>");
        if (jVar.isEmpty()) {
            return null;
        }
        return Integer.valueOf(jVar.f15912b);
    }

    @os.l
    public static final l T1(byte b10, int i10) {
        if (i10 > Integer.MIN_VALUE) {
            return new l(b10, i10 - 1, 1);
        }
        l.f15918e.getClass();
        return l.f15919f;
    }

    @an.f
    public static final boolean U(l lVar, short s10) {
        l0.p(lVar, "<this>");
        return L0(lVar, s10);
    }

    @os.m
    @f1(version = "1.7")
    public static final Long U0(@os.l m mVar) {
        l0.p(mVar, "<this>");
        if (mVar.isEmpty()) {
            return null;
        }
        return Long.valueOf(mVar.f15922b);
    }

    @os.l
    public static final l U1(byte b10, short s10) {
        return new l(b10, s10 - 1, 1);
    }

    @an.f
    public static final boolean V(o oVar, byte b10) {
        l0.p(oVar, "<this>");
        return V0(oVar, b10);
    }

    @in.i(name = "longRangeContains")
    public static final boolean V0(@os.l g<Long> gVar, byte b10) {
        l0.p(gVar, "<this>");
        return gVar.contains(Long.valueOf(b10));
    }

    @os.l
    public static final l V1(int i10, byte b10) {
        return new l(i10, b10 - 1, 1);
    }

    @an.f
    public static final boolean W(o oVar, int i10) {
        l0.p(oVar, "<this>");
        return Y0(oVar, i10);
    }

    @lm.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @in.i(name = "longRangeContains")
    @lm.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean W0(g gVar, double d10) {
        l0.p(gVar, "<this>");
        Long lL1 = L1(d10);
        if (lL1 != null) {
            return gVar.contains(lL1);
        }
        return false;
    }

    @os.l
    public static l W1(int i10, int i11) {
        if (i11 > Integer.MIN_VALUE) {
            return new l(i10, i11 - 1, 1);
        }
        l.f15918e.getClass();
        return l.f15919f;
    }

    @f1(version = "1.3")
    @an.f
    public static final boolean X(o oVar, Long l10) {
        l0.p(oVar, "<this>");
        return l10 != null && oVar.l(l10.longValue());
    }

    @lm.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @in.i(name = "longRangeContains")
    @lm.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean X0(g gVar, float f10) {
        l0.p(gVar, "<this>");
        Long lM1 = M1(f10);
        if (lM1 != null) {
            return gVar.contains(lM1);
        }
        return false;
    }

    @os.l
    public static final l X1(int i10, short s10) {
        return new l(i10, s10 - 1, 1);
    }

    @an.f
    public static final boolean Y(o oVar, short s10) {
        l0.p(oVar, "<this>");
        return Z0(oVar, s10);
    }

    @in.i(name = "longRangeContains")
    public static final boolean Y0(@os.l g<Long> gVar, int i10) {
        l0.p(gVar, "<this>");
        return gVar.contains(Long.valueOf(i10));
    }

    @os.l
    public static final l Y1(short s10, byte b10) {
        return new l(s10, b10 - 1, 1);
    }

    @lm.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @in.i(name = "doubleRangeContains")
    @lm.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean Z(g gVar, byte b10) {
        l0.p(gVar, "<this>");
        return gVar.contains(Double.valueOf(b10));
    }

    @in.i(name = "longRangeContains")
    public static final boolean Z0(@os.l g<Long> gVar, short s10) {
        l0.p(gVar, "<this>");
        return gVar.contains(Long.valueOf(s10));
    }

    @os.l
    public static final l Z1(short s10, int i10) {
        if (i10 > Integer.MIN_VALUE) {
            return new l(s10, i10 - 1, 1);
        }
        l.f15918e.getClass();
        return l.f15919f;
    }

    @in.i(name = "doubleRangeContains")
    public static final boolean a0(@os.l g<Double> gVar, float f10) {
        l0.p(gVar, "<this>");
        return gVar.contains(Double.valueOf(f10));
    }

    @f1(version = "1.9")
    @in.i(name = "longRangeContains")
    @p2(markerClass = {lm.r.class})
    public static final boolean a1(@os.l r<Long> rVar, byte b10) {
        l0.p(rVar, "<this>");
        return rVar.contains(Long.valueOf(b10));
    }

    @os.l
    public static final l a2(short s10, short s11) {
        return new l(s10, s11 - 1, 1);
    }

    @lm.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @in.i(name = "doubleRangeContains")
    @lm.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean b0(g gVar, int i10) {
        l0.p(gVar, "<this>");
        return gVar.contains(Double.valueOf(i10));
    }

    @f1(version = "1.9")
    @in.i(name = "longRangeContains")
    @p2(markerClass = {lm.r.class})
    public static final boolean b1(@os.l r<Long> rVar, int i10) {
        l0.p(rVar, "<this>");
        return rVar.contains(Long.valueOf(i10));
    }

    @os.l
    public static final o b2(byte b10, long j10) {
        if (j10 > Long.MIN_VALUE) {
            return new o(b10, j10 - 1);
        }
        o.f15928e.getClass();
        return o.f15929f;
    }

    @lm.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @in.i(name = "doubleRangeContains")
    @lm.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean c0(g gVar, long j10) {
        l0.p(gVar, "<this>");
        return gVar.contains(Double.valueOf(j10));
    }

    @f1(version = "1.9")
    @in.i(name = "longRangeContains")
    @p2(markerClass = {lm.r.class})
    public static final boolean c1(@os.l r<Long> rVar, short s10) {
        l0.p(rVar, "<this>");
        return rVar.contains(Long.valueOf(s10));
    }

    @os.l
    public static final o c2(int i10, long j10) {
        if (j10 > Long.MIN_VALUE) {
            return new o(i10, j10 - 1);
        }
        o.f15928e.getClass();
        return o.f15929f;
    }

    @lm.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @in.i(name = "doubleRangeContains")
    @lm.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean d0(g gVar, short s10) {
        l0.p(gVar, "<this>");
        return gVar.contains(Double.valueOf(s10));
    }

    @f1(version = "1.3")
    @an.f
    public static final char d1(c cVar) {
        l0.p(cVar, "<this>");
        return e1(cVar, rn.f.Default);
    }

    @os.l
    public static final o d2(long j10, byte b10) {
        return new o(j10, ((long) b10) - 1);
    }

    @f1(version = "1.9")
    @in.i(name = "doubleRangeContains")
    @p2(markerClass = {lm.r.class})
    public static final boolean e0(@os.l r<Double> rVar, float f10) {
        l0.p(rVar, "<this>");
        return rVar.contains(Double.valueOf(f10));
    }

    @f1(version = "1.3")
    public static final char e1(@os.l c cVar, @os.l rn.f fVar) {
        l0.p(cVar, "<this>");
        l0.p(fVar, "random");
        try {
            return (char) fVar.nextInt(cVar.f15891a, cVar.f15892b + 1);
        } catch (IllegalArgumentException e10) {
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @os.l
    public static final o e2(long j10, int i10) {
        return new o(j10, ((long) i10) - 1);
    }

    @os.l
    public static final a f0(char c10, char c11) {
        a.f15890d.getClass();
        return new a(c10, c11, -1);
    }

    @f1(version = "1.3")
    @an.f
    public static final int f1(l lVar) {
        l0.p(lVar, "<this>");
        return g1(lVar, rn.f.Default);
    }

    @os.l
    public static o f2(long j10, long j11) {
        if (j11 > Long.MIN_VALUE) {
            return new o(j10, j11 - 1);
        }
        o.f15928e.getClass();
        return o.f15929f;
    }

    @os.l
    public static final j g0(byte b10, byte b11) {
        j.f15910d.getClass();
        return new j(b10, b11, -1);
    }

    @f1(version = "1.3")
    public static final int g1(@os.l l lVar, @os.l rn.f fVar) {
        l0.p(lVar, "<this>");
        l0.p(fVar, "random");
        try {
            return rn.g.h(fVar, lVar);
        } catch (IllegalArgumentException e10) {
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @os.l
    public static final o g2(long j10, short s10) {
        return new o(j10, ((long) s10) - 1);
    }

    @os.l
    public static final j h0(byte b10, int i10) {
        j.f15910d.getClass();
        return new j(b10, i10, -1);
    }

    @f1(version = "1.3")
    @an.f
    public static final long h1(o oVar) {
        l0.p(oVar, "<this>");
        return i1(oVar, rn.f.Default);
    }

    @os.l
    public static final o h2(short s10, long j10) {
        if (j10 > Long.MIN_VALUE) {
            return new o(s10, j10 - 1);
        }
        o.f15928e.getClass();
        return o.f15929f;
    }

    @os.l
    public static final j i0(byte b10, short s10) {
        j.f15910d.getClass();
        return new j(b10, s10, -1);
    }

    @f1(version = "1.3")
    public static final long i1(@os.l o oVar, @os.l rn.f fVar) {
        l0.p(oVar, "<this>");
        l0.p(fVar, "random");
        try {
            return rn.g.i(fVar, oVar);
        } catch (IllegalArgumentException e10) {
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @lm.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @in.i(name = "byteRangeContains")
    @lm.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean j(g gVar, double d10) {
        l0.p(gVar, "<this>");
        Byte bD1 = D1(d10);
        if (bD1 != null) {
            return gVar.contains(bD1);
        }
        return false;
    }

    @os.l
    public static final j j0(int i10, byte b10) {
        j.f15910d.getClass();
        return new j(i10, b10, -1);
    }

    @f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final Character j1(c cVar) {
        l0.p(cVar, "<this>");
        return k1(cVar, rn.f.Default);
    }

    @lm.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @in.i(name = "byteRangeContains")
    @lm.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean k(g gVar, float f10) {
        l0.p(gVar, "<this>");
        Byte bE1 = E1(f10);
        if (bE1 != null) {
            return gVar.contains(bE1);
        }
        return false;
    }

    @os.l
    public static j k0(int i10, int i11) {
        j.f15910d.getClass();
        return new j(i10, i11, -1);
    }

    @os.m
    @f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Character k1(@os.l c cVar, @os.l rn.f fVar) {
        l0.p(cVar, "<this>");
        l0.p(fVar, "random");
        if (cVar.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) fVar.nextInt(cVar.f15891a, cVar.f15892b + 1));
    }

    @in.i(name = "byteRangeContains")
    public static final boolean l(@os.l g<Byte> gVar, int i10) {
        l0.p(gVar, "<this>");
        Byte bF1 = F1(i10);
        if (bF1 != null) {
            return gVar.contains(bF1);
        }
        return false;
    }

    @os.l
    public static final j l0(int i10, short s10) {
        j.f15910d.getClass();
        return new j(i10, s10, -1);
    }

    @f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final Integer l1(l lVar) {
        l0.p(lVar, "<this>");
        return m1(lVar, rn.f.Default);
    }

    @in.i(name = "byteRangeContains")
    public static final boolean m(@os.l g<Byte> gVar, long j10) {
        l0.p(gVar, "<this>");
        Byte bG1 = G1(j10);
        if (bG1 != null) {
            return gVar.contains(bG1);
        }
        return false;
    }

    @os.l
    public static final j m0(short s10, byte b10) {
        j.f15910d.getClass();
        return new j(s10, b10, -1);
    }

    @os.m
    @f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Integer m1(@os.l l lVar, @os.l rn.f fVar) {
        l0.p(lVar, "<this>");
        l0.p(fVar, "random");
        if (lVar.isEmpty()) {
            return null;
        }
        return Integer.valueOf(rn.g.h(fVar, lVar));
    }

    @in.i(name = "byteRangeContains")
    public static final boolean n(@os.l g<Byte> gVar, short s10) {
        l0.p(gVar, "<this>");
        Byte bH1 = H1(s10);
        if (bH1 != null) {
            return gVar.contains(bH1);
        }
        return false;
    }

    @os.l
    public static final j n0(short s10, int i10) {
        j.f15910d.getClass();
        return new j(s10, i10, -1);
    }

    @f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final Long n1(o oVar) {
        l0.p(oVar, "<this>");
        return o1(oVar, rn.f.Default);
    }

    @f1(version = "1.9")
    @in.i(name = "byteRangeContains")
    @p2(markerClass = {lm.r.class})
    public static final boolean o(@os.l r<Byte> rVar, int i10) {
        l0.p(rVar, "<this>");
        Byte bF1 = F1(i10);
        if (bF1 != null) {
            return rVar.contains(bF1);
        }
        return false;
    }

    @os.l
    public static final j o0(short s10, short s11) {
        j.f15910d.getClass();
        return new j(s10, s11, -1);
    }

    @os.m
    @f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Long o1(@os.l o oVar, @os.l rn.f fVar) {
        l0.p(oVar, "<this>");
        l0.p(fVar, "random");
        if (oVar.isEmpty()) {
            return null;
        }
        return Long.valueOf(rn.g.i(fVar, oVar));
    }

    @f1(version = "1.9")
    @in.i(name = "byteRangeContains")
    @p2(markerClass = {lm.r.class})
    public static final boolean p(@os.l r<Byte> rVar, long j10) {
        l0.p(rVar, "<this>");
        Byte bG1 = G1(j10);
        if (bG1 != null) {
            return rVar.contains(bG1);
        }
        return false;
    }

    @os.l
    public static final m p0(byte b10, long j10) {
        m.f15920d.getClass();
        return new m(b10, j10, -1L);
    }

    @os.l
    public static final a p1(@os.l a aVar) {
        l0.p(aVar, "<this>");
        a.C0410a c0410a = a.f15890d;
        char c10 = aVar.f15892b;
        char c11 = aVar.f15891a;
        int i10 = -aVar.f15893c;
        c0410a.getClass();
        return new a(c10, c11, i10);
    }

    @f1(version = "1.9")
    @in.i(name = "byteRangeContains")
    @p2(markerClass = {lm.r.class})
    public static final boolean q(@os.l r<Byte> rVar, short s10) {
        l0.p(rVar, "<this>");
        Byte bH1 = H1(s10);
        if (bH1 != null) {
            return rVar.contains(bH1);
        }
        return false;
    }

    @os.l
    public static final m q0(int i10, long j10) {
        m.f15920d.getClass();
        return new m(i10, j10, -1L);
    }

    @os.l
    public static final j q1(@os.l j jVar) {
        l0.p(jVar, "<this>");
        j.a aVar = j.f15910d;
        int i10 = jVar.f15912b;
        int i11 = jVar.f15911a;
        int i12 = -jVar.f15913c;
        aVar.getClass();
        return new j(i10, i11, i12);
    }

    public static final byte r(byte b10, byte b11) {
        return b10 < b11 ? b11 : b10;
    }

    @os.l
    public static final m r0(long j10, byte b10) {
        m.f15920d.getClass();
        return new m(j10, b10, -1L);
    }

    @os.l
    public static final m r1(@os.l m mVar) {
        l0.p(mVar, "<this>");
        m.a aVar = m.f15920d;
        long j10 = mVar.f15922b;
        long j11 = mVar.f15921a;
        long j12 = -mVar.f15923c;
        aVar.getClass();
        return new m(j10, j11, j12);
    }

    public static final double s(double d10, double d11) {
        return d10 < d11 ? d11 : d10;
    }

    @os.l
    public static final m s0(long j10, int i10) {
        m.f15920d.getClass();
        return new m(j10, i10, -1L);
    }

    @in.i(name = "shortRangeContains")
    public static final boolean s1(@os.l g<Short> gVar, byte b10) {
        l0.p(gVar, "<this>");
        return gVar.contains(Short.valueOf(b10));
    }

    public static final float t(float f10, float f11) {
        return f10 < f11 ? f11 : f10;
    }

    @os.l
    public static final m t0(long j10, long j11) {
        m.f15920d.getClass();
        return new m(j10, j11, -1L);
    }

    @lm.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @in.i(name = "shortRangeContains")
    @lm.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean t1(g gVar, double d10) {
        l0.p(gVar, "<this>");
        Short shN1 = N1(d10);
        if (shN1 != null) {
            return gVar.contains(shN1);
        }
        return false;
    }

    public static int u(int i10, int i11) {
        return i10 < i11 ? i11 : i10;
    }

    @os.l
    public static final m u0(long j10, short s10) {
        m.f15920d.getClass();
        return new m(j10, s10, -1L);
    }

    @lm.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @in.i(name = "shortRangeContains")
    @lm.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean u1(g gVar, float f10) {
        l0.p(gVar, "<this>");
        Short shO1 = O1(f10);
        if (shO1 != null) {
            return gVar.contains(shO1);
        }
        return false;
    }

    public static long v(long j10, long j11) {
        return j10 < j11 ? j11 : j10;
    }

    @os.l
    public static final m v0(short s10, long j10) {
        m.f15920d.getClass();
        return new m(s10, j10, -1L);
    }

    @in.i(name = "shortRangeContains")
    public static final boolean v1(@os.l g<Short> gVar, int i10) {
        l0.p(gVar, "<this>");
        Short shP1 = P1(i10);
        if (shP1 != null) {
            return gVar.contains(shP1);
        }
        return false;
    }

    @os.l
    public static final <T extends Comparable<? super T>> T w(@os.l T t10, @os.l T t11) {
        l0.p(t10, "<this>");
        l0.p(t11, "minimumValue");
        return t10.compareTo(t11) < 0 ? t11 : t10;
    }

    @f1(version = "1.7")
    public static final char w0(@os.l a aVar) {
        l0.p(aVar, "<this>");
        if (!aVar.isEmpty()) {
            return aVar.f15891a;
        }
        throw new NoSuchElementException("Progression " + aVar + " is empty.");
    }

    @in.i(name = "shortRangeContains")
    public static final boolean w1(@os.l g<Short> gVar, long j10) {
        l0.p(gVar, "<this>");
        Short shQ1 = Q1(j10);
        if (shQ1 != null) {
            return gVar.contains(shQ1);
        }
        return false;
    }

    public static final short x(short s10, short s11) {
        return s10 < s11 ? s11 : s10;
    }

    @f1(version = "1.7")
    public static final int x0(@os.l j jVar) {
        l0.p(jVar, "<this>");
        if (!jVar.isEmpty()) {
            return jVar.f15911a;
        }
        throw new NoSuchElementException("Progression " + jVar + " is empty.");
    }

    @f1(version = "1.9")
    @in.i(name = "shortRangeContains")
    @p2(markerClass = {lm.r.class})
    public static final boolean x1(@os.l r<Short> rVar, byte b10) {
        l0.p(rVar, "<this>");
        return rVar.contains(Short.valueOf(b10));
    }

    public static final byte y(byte b10, byte b11) {
        return b10 > b11 ? b11 : b10;
    }

    @f1(version = "1.7")
    public static final long y0(@os.l m mVar) {
        l0.p(mVar, "<this>");
        if (!mVar.isEmpty()) {
            return mVar.f15921a;
        }
        throw new NoSuchElementException("Progression " + mVar + " is empty.");
    }

    @f1(version = "1.9")
    @in.i(name = "shortRangeContains")
    @p2(markerClass = {lm.r.class})
    public static final boolean y1(@os.l r<Short> rVar, int i10) {
        l0.p(rVar, "<this>");
        Short shP1 = P1(i10);
        if (shP1 != null) {
            return rVar.contains(shP1);
        }
        return false;
    }

    public static final double z(double d10, double d11) {
        return d10 > d11 ? d11 : d10;
    }

    @os.m
    @f1(version = "1.7")
    public static final Character z0(@os.l a aVar) {
        l0.p(aVar, "<this>");
        if (aVar.isEmpty()) {
            return null;
        }
        return Character.valueOf(aVar.f15891a);
    }

    @f1(version = "1.9")
    @in.i(name = "shortRangeContains")
    @p2(markerClass = {lm.r.class})
    public static final boolean z1(@os.l r<Short> rVar, long j10) {
        l0.p(rVar, "<this>");
        Short shQ1 = Q1(j10);
        if (shQ1 != null) {
            return rVar.contains(shQ1);
        }
        return false;
    }
}
