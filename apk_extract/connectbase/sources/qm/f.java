package qm;

import in.i;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import kn.l0;
import lm.a1;
import lm.a2;
import lm.b2;
import lm.f1;
import lm.g2;
import lm.h2;
import lm.k;
import lm.l;
import lm.o2;
import lm.s0;
import lm.s1;
import lm.t;
import lm.t1;
import lm.w1;
import lm.x1;
import nm.o;
import nm.r;
import nm.v0;

/* JADX INFO: loaded from: classes3.dex */
public class f {

    public static final class a extends nm.c<w1> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f14046b;

        public a(int[] iArr) {
            this.f14046b = iArr;
        }

        public boolean a(int i10) {
            return r.q8(this.f14046b, i10);
        }

        public int c(int i10) {
            return w1.m(this.f14046b[i10]);
        }

        @Override // nm.a, java.util.Collection, java.util.List
        public final boolean contains(Object obj) {
            if (!(obj instanceof w1)) {
                return false;
            }
            return r.q8(this.f14046b, ((w1) obj).f10227a);
        }

        public int e(int i10) {
            return r.Gf(this.f14046b, i10);
        }

        public int f(int i10) {
            return r.Kh(this.f14046b, i10);
        }

        @Override // nm.c, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i10) {
            return w1.b(c(i10));
        }

        @Override // nm.c, nm.a
        public int getSize() {
            return this.f14046b.length;
        }

        @Override // nm.c, java.util.List
        public final int indexOf(Object obj) {
            if (!(obj instanceof w1)) {
                return -1;
            }
            return r.Gf(this.f14046b, ((w1) obj).f10227a);
        }

        @Override // nm.a, java.util.Collection
        public boolean isEmpty() {
            return x1.t(this.f14046b);
        }

        @Override // nm.c, java.util.List
        public final int lastIndexOf(Object obj) {
            if (!(obj instanceof w1)) {
                return -1;
            }
            return r.Kh(this.f14046b, ((w1) obj).f10227a);
        }
    }

    public static final class b extends nm.c<a2> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f14047b;

        public b(long[] jArr) {
            this.f14047b = jArr;
        }

        public boolean a(long j10) {
            return r.r8(this.f14047b, j10);
        }

        public long c(int i10) {
            return a2.m(this.f14047b[i10]);
        }

        @Override // nm.a, java.util.Collection, java.util.List
        public final boolean contains(Object obj) {
            if (!(obj instanceof a2)) {
                return false;
            }
            return r.r8(this.f14047b, ((a2) obj).f10177a);
        }

        public int e(long j10) {
            return r.Hf(this.f14047b, j10);
        }

        public int f(long j10) {
            return r.Lh(this.f14047b, j10);
        }

        @Override // nm.c, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i10) {
            return a2.b(c(i10));
        }

        @Override // nm.c, nm.a
        public int getSize() {
            return this.f14047b.length;
        }

        @Override // nm.c, java.util.List
        public final int indexOf(Object obj) {
            if (!(obj instanceof a2)) {
                return -1;
            }
            return r.Hf(this.f14047b, ((a2) obj).f10177a);
        }

        @Override // nm.a, java.util.Collection
        public boolean isEmpty() {
            return b2.t(this.f14047b);
        }

        @Override // nm.c, java.util.List
        public final int lastIndexOf(Object obj) {
            if (!(obj instanceof a2)) {
                return -1;
            }
            return r.Lh(this.f14047b, ((a2) obj).f10177a);
        }
    }

    public static final class c extends nm.c<s1> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ byte[] f14048b;

        public c(byte[] bArr) {
            this.f14048b = bArr;
        }

        public boolean a(byte b10) {
            return r.m8(this.f14048b, b10);
        }

        public byte c(int i10) {
            return s1.m(this.f14048b[i10]);
        }

        @Override // nm.a, java.util.Collection, java.util.List
        public final boolean contains(Object obj) {
            if (!(obj instanceof s1)) {
                return false;
            }
            return r.m8(this.f14048b, ((s1) obj).f10218a);
        }

        public int e(byte b10) {
            return r.Cf(this.f14048b, b10);
        }

        public int f(byte b10) {
            return r.Gh(this.f14048b, b10);
        }

        @Override // nm.c, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i10) {
            return s1.b(c(i10));
        }

        @Override // nm.c, nm.a
        public int getSize() {
            return this.f14048b.length;
        }

        @Override // nm.c, java.util.List
        public final int indexOf(Object obj) {
            if (!(obj instanceof s1)) {
                return -1;
            }
            return r.Cf(this.f14048b, ((s1) obj).f10218a);
        }

        @Override // nm.a, java.util.Collection
        public boolean isEmpty() {
            return t1.t(this.f14048b);
        }

        @Override // nm.c, java.util.List
        public final int lastIndexOf(Object obj) {
            if (!(obj instanceof s1)) {
                return -1;
            }
            return r.Gh(this.f14048b, ((s1) obj).f10218a);
        }
    }

    public static final class d extends nm.c<g2> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ short[] f14049b;

        public d(short[] sArr) {
            this.f14049b = sArr;
        }

        public boolean a(short s10) {
            return r.t8(this.f14049b, s10);
        }

        public short c(int i10) {
            return g2.m(this.f14049b[i10]);
        }

        @Override // nm.a, java.util.Collection, java.util.List
        public final boolean contains(Object obj) {
            if (!(obj instanceof g2)) {
                return false;
            }
            return r.t8(this.f14049b, ((g2) obj).f10193a);
        }

        public int e(short s10) {
            return r.Jf(this.f14049b, s10);
        }

        public int f(short s10) {
            return r.Nh(this.f14049b, s10);
        }

        @Override // nm.c, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i10) {
            return g2.b(c(i10));
        }

        @Override // nm.c, nm.a
        public int getSize() {
            return this.f14049b.length;
        }

        @Override // nm.c, java.util.List
        public final int indexOf(Object obj) {
            if (!(obj instanceof g2)) {
                return -1;
            }
            return r.Jf(this.f14049b, ((g2) obj).f10193a);
        }

        @Override // nm.a, java.util.Collection
        public boolean isEmpty() {
            return h2.t(this.f14049b);
        }

        @Override // nm.c, java.util.List
        public final int lastIndexOf(Object obj) {
            if (!(obj instanceof g2)) {
                return -1;
            }
            return r.Nh(this.f14049b, ((g2) obj).f10193a);
        }
    }

    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use maxWithOrNull instead.", replaceWith = @a1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ g2 A(short[] sArr, Comparator comparator) {
        l0.p(sArr, "$this$maxWith");
        l0.p(comparator, "comparator");
        return g.A6(sArr, comparator);
    }

    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use maxWithOrNull instead.", replaceWith = @a1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ a2 B(long[] jArr, Comparator comparator) {
        l0.p(jArr, "$this$maxWith");
        l0.p(comparator, "comparator");
        return g.B6(jArr, comparator);
    }

    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use minOrNull instead.", replaceWith = @a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ w1 C(int[] iArr) {
        l0.p(iArr, "$this$min");
        return g.u7(iArr);
    }

    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use minOrNull instead.", replaceWith = @a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ s1 D(byte[] bArr) {
        l0.p(bArr, "$this$min");
        return g.v7(bArr);
    }

    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use minOrNull instead.", replaceWith = @a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ a2 E(long[] jArr) {
        l0.p(jArr, "$this$min");
        return g.w7(jArr);
    }

    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use minOrNull instead.", replaceWith = @a1(expression = "this.minOrNull()", imports = {}))
    public static final /* synthetic */ g2 F(short[] sArr) {
        l0.p(sArr, "$this$min");
        return g.x7(sArr);
    }

    @an.f
    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use minByOrNull instead.", replaceWith = @a1(expression = "this.minByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> s1 G(byte[] bArr, jn.l<? super s1, ? extends R> lVar) {
        l0.p(bArr, "$this$minBy");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            return null;
        }
        byte bM = s1.m(bArr[0]);
        int iQe = r.qe(bArr);
        if (iQe == 0) {
            return new s1(bM);
        }
        Comparable comparable = (Comparable) qm.d.a(bM, lVar);
        v0 v0VarA = o.a(1, iQe, 1);
        while (v0VarA.hasNext()) {
            byte bM2 = s1.m(bArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) qm.d.a(bM2, lVar);
            if (comparable.compareTo(comparable2) > 0) {
                bM = bM2;
                comparable = comparable2;
            }
        }
        return new s1(bM);
    }

    @an.f
    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use minByOrNull instead.", replaceWith = @a1(expression = "this.minByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> a2 H(long[] jArr, jn.l<? super a2, ? extends R> lVar) {
        l0.p(jArr, "$this$minBy");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            return null;
        }
        long jM = a2.m(jArr[0]);
        int iVe = r.ve(jArr);
        if (iVe == 0) {
            return new a2(jM);
        }
        Comparable comparable = (Comparable) qm.c.a(jM, lVar);
        v0 v0VarA = o.a(1, iVe, 1);
        while (v0VarA.hasNext()) {
            long jM2 = a2.m(jArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) qm.c.a(jM2, lVar);
            if (comparable.compareTo(comparable2) > 0) {
                jM = jM2;
                comparable = comparable2;
            }
        }
        return new a2(jM);
    }

    @an.f
    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use minByOrNull instead.", replaceWith = @a1(expression = "this.minByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> w1 I(int[] iArr, jn.l<? super w1, ? extends R> lVar) {
        l0.p(iArr, "$this$minBy");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            return null;
        }
        int iM = w1.m(iArr[0]);
        int iUe = r.ue(iArr);
        if (iUe == 0) {
            return new w1(iM);
        }
        Comparable comparable = (Comparable) e.a(iM, lVar);
        v0 v0VarA = o.a(1, iUe, 1);
        while (v0VarA.hasNext()) {
            int iM2 = w1.m(iArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) e.a(iM2, lVar);
            if (comparable.compareTo(comparable2) > 0) {
                iM = iM2;
                comparable = comparable2;
            }
        }
        return new w1(iM);
    }

    @an.f
    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use minByOrNull instead.", replaceWith = @a1(expression = "this.minByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> g2 J(short[] sArr, jn.l<? super g2, ? extends R> lVar) {
        l0.p(sArr, "$this$minBy");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            return null;
        }
        short sM = g2.m(sArr[0]);
        int iXe = r.xe(sArr);
        if (iXe == 0) {
            return new g2(sM);
        }
        Comparable comparable = (Comparable) qm.b.a(sM, lVar);
        v0 v0VarA = o.a(1, iXe, 1);
        while (v0VarA.hasNext()) {
            short sM2 = g2.m(sArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) qm.b.a(sM2, lVar);
            if (comparable.compareTo(comparable2) > 0) {
                sM = sM2;
                comparable = comparable2;
            }
        }
        return new g2(sM);
    }

    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use minWithOrNull instead.", replaceWith = @a1(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ s1 K(byte[] bArr, Comparator comparator) {
        l0.p(bArr, "$this$minWith");
        l0.p(comparator, "comparator");
        return g.C7(bArr, comparator);
    }

    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use minWithOrNull instead.", replaceWith = @a1(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ w1 L(int[] iArr, Comparator comparator) {
        l0.p(iArr, "$this$minWith");
        l0.p(comparator, "comparator");
        return g.D7(iArr, comparator);
    }

    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use minWithOrNull instead.", replaceWith = @a1(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ g2 M(short[] sArr, Comparator comparator) {
        l0.p(sArr, "$this$minWith");
        l0.p(comparator, "comparator");
        return g.E7(sArr, comparator);
    }

    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use minWithOrNull instead.", replaceWith = @a1(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ a2 N(long[] jArr, Comparator comparator) {
        l0.p(jArr, "$this$minWith");
        l0.p(comparator, "comparator");
        return g.F7(jArr, comparator);
    }

    @s0
    @an.f
    @i(name = "sumOfBigDecimal")
    @f1(version = "1.4")
    @t
    public static final BigDecimal O(byte[] bArr, jn.l<? super s1, ? extends BigDecimal> lVar) {
        l0.p(bArr, "$this$sumOf");
        l0.p(lVar, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        l0.o(bigDecimalValueOf, "valueOf(...)");
        for (byte b10 : bArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) qm.d.a(s1.m(b10), lVar));
            l0.o(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @s0
    @an.f
    @i(name = "sumOfBigDecimal")
    @f1(version = "1.4")
    @t
    public static final BigDecimal P(int[] iArr, jn.l<? super w1, ? extends BigDecimal> lVar) {
        l0.p(iArr, "$this$sumOf");
        l0.p(lVar, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        l0.o(bigDecimalValueOf, "valueOf(...)");
        for (int i10 : iArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) e.a(w1.m(i10), lVar));
            l0.o(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @s0
    @an.f
    @i(name = "sumOfBigDecimal")
    @f1(version = "1.4")
    @t
    public static final BigDecimal Q(long[] jArr, jn.l<? super a2, ? extends BigDecimal> lVar) {
        l0.p(jArr, "$this$sumOf");
        l0.p(lVar, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        l0.o(bigDecimalValueOf, "valueOf(...)");
        for (long j10 : jArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) qm.c.a(a2.m(j10), lVar));
            l0.o(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @s0
    @an.f
    @i(name = "sumOfBigDecimal")
    @f1(version = "1.4")
    @t
    public static final BigDecimal R(short[] sArr, jn.l<? super g2, ? extends BigDecimal> lVar) {
        l0.p(sArr, "$this$sumOf");
        l0.p(lVar, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        l0.o(bigDecimalValueOf, "valueOf(...)");
        for (short s10 : sArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) qm.b.a(g2.m(s10), lVar));
            l0.o(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @s0
    @an.f
    @i(name = "sumOfBigInteger")
    @f1(version = "1.4")
    @t
    public static final BigInteger S(byte[] bArr, jn.l<? super s1, ? extends BigInteger> lVar) {
        l0.p(bArr, "$this$sumOf");
        l0.p(lVar, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        l0.o(bigIntegerValueOf, "valueOf(...)");
        for (byte b10 : bArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) qm.d.a(s1.m(b10), lVar));
            l0.o(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    @s0
    @an.f
    @i(name = "sumOfBigInteger")
    @f1(version = "1.4")
    @t
    public static final BigInteger T(int[] iArr, jn.l<? super w1, ? extends BigInteger> lVar) {
        l0.p(iArr, "$this$sumOf");
        l0.p(lVar, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        l0.o(bigIntegerValueOf, "valueOf(...)");
        for (int i10 : iArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) e.a(w1.m(i10), lVar));
            l0.o(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    @s0
    @an.f
    @i(name = "sumOfBigInteger")
    @f1(version = "1.4")
    @t
    public static final BigInteger U(long[] jArr, jn.l<? super a2, ? extends BigInteger> lVar) {
        l0.p(jArr, "$this$sumOf");
        l0.p(lVar, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        l0.o(bigIntegerValueOf, "valueOf(...)");
        for (long j10 : jArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) qm.c.a(a2.m(j10), lVar));
            l0.o(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    @s0
    @an.f
    @i(name = "sumOfBigInteger")
    @f1(version = "1.4")
    @t
    public static final BigInteger V(short[] sArr, jn.l<? super g2, ? extends BigInteger> lVar) {
        l0.p(sArr, "$this$sumOf");
        l0.p(lVar, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        l0.o(bigIntegerValueOf, "valueOf(...)");
        for (short s10 : sArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) qm.b.a(g2.m(s10), lVar));
            l0.o(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    @f1(version = "1.3")
    @t
    @os.l
    public static final List<w1> a(@os.l int[] iArr) {
        l0.p(iArr, "$this$asList");
        return new a(iArr);
    }

    @f1(version = "1.3")
    @t
    @os.l
    public static final List<s1> b(@os.l byte[] bArr) {
        l0.p(bArr, "$this$asList");
        return new c(bArr);
    }

    @f1(version = "1.3")
    @t
    @os.l
    public static final List<a2> c(@os.l long[] jArr) {
        l0.p(jArr, "$this$asList");
        return new b(jArr);
    }

    @f1(version = "1.3")
    @t
    @os.l
    public static final List<g2> d(@os.l short[] sArr) {
        l0.p(sArr, "$this$asList");
        return new d(sArr);
    }

    @f1(version = "1.3")
    @t
    public static final int e(@os.l int[] iArr, int i10, int i11, int i12) {
        l0.p(iArr, "$this$binarySearch");
        nm.c.Companion.d(i11, i12, iArr.length);
        int i13 = i12 - 1;
        while (i11 <= i13) {
            int i14 = (i11 + i13) >>> 1;
            int iC = o2.c(iArr[i14], i10);
            if (iC < 0) {
                i11 = i14 + 1;
            } else {
                if (iC <= 0) {
                    return i14;
                }
                i13 = i14 - 1;
            }
        }
        return -(i11 + 1);
    }

    public static int f(int[] iArr, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = iArr.length;
        }
        return e(iArr, i10, i11, i12);
    }

    @f1(version = "1.3")
    @t
    public static final int g(@os.l short[] sArr, short s10, int i10, int i11) {
        l0.p(sArr, "$this$binarySearch");
        nm.c.Companion.d(i10, i11, sArr.length);
        int i12 = s10 & g2.f10190d;
        int i13 = i11 - 1;
        while (i10 <= i13) {
            int i14 = (i10 + i13) >>> 1;
            int iC = o2.c(sArr[i14], i12);
            if (iC < 0) {
                i10 = i14 + 1;
            } else {
                if (iC <= 0) {
                    return i14;
                }
                i13 = i14 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static int h(short[] sArr, short s10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length;
        }
        return g(sArr, s10, i10, i11);
    }

    @f1(version = "1.3")
    @t
    public static final int i(@os.l long[] jArr, long j10, int i10, int i11) {
        l0.p(jArr, "$this$binarySearch");
        nm.c.Companion.d(i10, i11, jArr.length);
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) >>> 1;
            int iG = o2.g(jArr[i13], j10);
            if (iG < 0) {
                i10 = i13 + 1;
            } else {
                if (iG <= 0) {
                    return i13;
                }
                i12 = i13 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static int j(long[] jArr, long j10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length;
        }
        return i(jArr, j10, i10, i11);
    }

    @f1(version = "1.3")
    @t
    public static final int k(@os.l byte[] bArr, byte b10, int i10, int i11) {
        l0.p(bArr, "$this$binarySearch");
        nm.c.Companion.d(i10, i11, bArr.length);
        int i12 = b10 & 255;
        int i13 = i11 - 1;
        while (i10 <= i13) {
            int i14 = (i10 + i13) >>> 1;
            int iC = o2.c(bArr[i14], i12);
            if (iC < 0) {
                i10 = i14 + 1;
            } else {
                if (iC <= 0) {
                    return i14;
                }
                i13 = i14 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static int l(byte[] bArr, byte b10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        return k(bArr, b10, i10, i11);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte m(byte[] bArr, int i10) {
        l0.p(bArr, "$this$elementAt");
        return s1.m(bArr[i10]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short n(short[] sArr, int i10) {
        l0.p(sArr, "$this$elementAt");
        return g2.m(sArr[i10]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int o(int[] iArr, int i10) {
        l0.p(iArr, "$this$elementAt");
        return w1.m(iArr[i10]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long p(long[] jArr, int i10) {
        l0.p(jArr, "$this$elementAt");
        return a2.m(jArr[i10]);
    }

    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use maxOrNull instead.", replaceWith = @a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ w1 q(int[] iArr) {
        l0.p(iArr, "$this$max");
        return g.q6(iArr);
    }

    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use maxOrNull instead.", replaceWith = @a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ s1 r(byte[] bArr) {
        l0.p(bArr, "$this$max");
        return g.r6(bArr);
    }

    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use maxOrNull instead.", replaceWith = @a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ a2 s(long[] jArr) {
        l0.p(jArr, "$this$max");
        return g.s6(jArr);
    }

    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use maxOrNull instead.", replaceWith = @a1(expression = "this.maxOrNull()", imports = {}))
    public static final /* synthetic */ g2 t(short[] sArr) {
        l0.p(sArr, "$this$max");
        return g.t6(sArr);
    }

    @an.f
    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use maxByOrNull instead.", replaceWith = @a1(expression = "this.maxByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> s1 u(byte[] bArr, jn.l<? super s1, ? extends R> lVar) {
        l0.p(bArr, "$this$maxBy");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            return null;
        }
        byte bM = s1.m(bArr[0]);
        int iQe = r.qe(bArr);
        if (iQe == 0) {
            return new s1(bM);
        }
        Comparable comparable = (Comparable) qm.d.a(bM, lVar);
        v0 v0VarA = o.a(1, iQe, 1);
        while (v0VarA.hasNext()) {
            byte bM2 = s1.m(bArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) qm.d.a(bM2, lVar);
            if (comparable.compareTo(comparable2) < 0) {
                bM = bM2;
                comparable = comparable2;
            }
        }
        return new s1(bM);
    }

    @an.f
    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use maxByOrNull instead.", replaceWith = @a1(expression = "this.maxByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> a2 v(long[] jArr, jn.l<? super a2, ? extends R> lVar) {
        l0.p(jArr, "$this$maxBy");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            return null;
        }
        long jM = a2.m(jArr[0]);
        int iVe = r.ve(jArr);
        if (iVe == 0) {
            return new a2(jM);
        }
        Comparable comparable = (Comparable) qm.c.a(jM, lVar);
        v0 v0VarA = o.a(1, iVe, 1);
        while (v0VarA.hasNext()) {
            long jM2 = a2.m(jArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) qm.c.a(jM2, lVar);
            if (comparable.compareTo(comparable2) < 0) {
                jM = jM2;
                comparable = comparable2;
            }
        }
        return new a2(jM);
    }

    @an.f
    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use maxByOrNull instead.", replaceWith = @a1(expression = "this.maxByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> w1 w(int[] iArr, jn.l<? super w1, ? extends R> lVar) {
        l0.p(iArr, "$this$maxBy");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            return null;
        }
        int iM = w1.m(iArr[0]);
        int iUe = r.ue(iArr);
        if (iUe == 0) {
            return new w1(iM);
        }
        Comparable comparable = (Comparable) e.a(iM, lVar);
        v0 v0VarA = o.a(1, iUe, 1);
        while (v0VarA.hasNext()) {
            int iM2 = w1.m(iArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) e.a(iM2, lVar);
            if (comparable.compareTo(comparable2) < 0) {
                iM = iM2;
                comparable = comparable2;
            }
        }
        return new w1(iM);
    }

    @an.f
    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use maxByOrNull instead.", replaceWith = @a1(expression = "this.maxByOrNull(selector)", imports = {}))
    public static final <R extends Comparable<? super R>> g2 x(short[] sArr, jn.l<? super g2, ? extends R> lVar) {
        l0.p(sArr, "$this$maxBy");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            return null;
        }
        short sM = g2.m(sArr[0]);
        int iXe = r.xe(sArr);
        if (iXe == 0) {
            return new g2(sM);
        }
        Comparable comparable = (Comparable) qm.b.a(sM, lVar);
        v0 v0VarA = o.a(1, iXe, 1);
        while (v0VarA.hasNext()) {
            short sM2 = g2.m(sArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) qm.b.a(sM2, lVar);
            if (comparable.compareTo(comparable2) < 0) {
                sM = sM2;
                comparable = comparable2;
            }
        }
        return new g2(sM);
    }

    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use maxWithOrNull instead.", replaceWith = @a1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ s1 y(byte[] bArr, Comparator comparator) {
        l0.p(bArr, "$this$maxWith");
        l0.p(comparator, "comparator");
        return g.y6(bArr, comparator);
    }

    @f1(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @t
    @k(message = "Use maxWithOrNull instead.", replaceWith = @a1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ w1 z(int[] iArr, Comparator comparator) {
        l0.p(iArr, "$this$maxWith");
        l0.p(comparator, "comparator");
        return g.z6(iArr, comparator);
    }
}
