package lq;

import jq.h0;
import kn.l0;
import kn.r1;
import kn.w;
import lm.a1;
import lm.f1;
import lm.p2;
import lm.z0;
import nq.v1;
import tn.u;

/* JADX INFO: loaded from: classes3.dex */
@in.g
@r1({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1495:1\n38#1:1496\n38#1:1497\n38#1:1498\n38#1:1499\n38#1:1500\n683#1,2:1501\n700#1,2:1510\n163#2,6:1503\n1#3:1509\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n*L\n39#1:1496\n40#1:1497\n458#1:1498\n478#1:1499\n662#1:1500\n979#1:1501,2\n1070#1:1510,2\n1021#1:1503,6\n*E\n"})
@p2(markerClass = {l.class})
@f1(version = "1.6")
public final class e implements Comparable<e> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f10247b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f10248c = n(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f10249d = g.j(4611686018427387903L);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f10250e = g.j(-4611686018427387903L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f10251a;

    public static final class a {
        public a() {
        }

        @an.f
        public static /* synthetic */ void A(double d10) {
        }

        @an.f
        public static /* synthetic */ void B(int i10) {
        }

        @an.f
        public static /* synthetic */ void C(long j10) {
        }

        @an.f
        public static /* synthetic */ void G(double d10) {
        }

        @an.f
        public static /* synthetic */ void H(int i10) {
        }

        @an.f
        public static /* synthetic */ void I(long j10) {
        }

        @an.f
        public static /* synthetic */ void N(double d10) {
        }

        @an.f
        public static /* synthetic */ void O(int i10) {
        }

        @an.f
        public static /* synthetic */ void P(long j10) {
        }

        @an.f
        public static /* synthetic */ void T(double d10) {
        }

        @an.f
        public static /* synthetic */ void U(int i10) {
        }

        @an.f
        public static /* synthetic */ void V(long j10) {
        }

        @an.f
        public static /* synthetic */ void h(double d10) {
        }

        @an.f
        public static /* synthetic */ void i(int i10) {
        }

        @an.f
        public static /* synthetic */ void j(long j10) {
        }

        @an.f
        public static /* synthetic */ void n(double d10) {
        }

        @an.f
        public static /* synthetic */ void o(int i10) {
        }

        @an.f
        public static /* synthetic */ void p(long j10) {
        }

        @an.f
        public static /* synthetic */ void u(double d10) {
        }

        @an.f
        public static /* synthetic */ void v(int i10) {
        }

        @an.f
        public static /* synthetic */ void w(long j10) {
        }

        public final long D(double d10) {
            return g.l0(d10, h.MINUTES);
        }

        public final long E(int i10) {
            return g.m0(i10, h.MINUTES);
        }

        public final long F(long j10) {
            return g.n0(j10, h.MINUTES);
        }

        public final long J() {
            return e.f10250e;
        }

        public final long K(double d10) {
            return g.l0(d10, h.NANOSECONDS);
        }

        public final long L(int i10) {
            return g.m0(i10, h.NANOSECONDS);
        }

        public final long M(long j10) {
            return g.n0(j10, h.NANOSECONDS);
        }

        public final long Q(double d10) {
            return g.l0(d10, h.SECONDS);
        }

        public final long R(int i10) {
            return g.m0(i10, h.SECONDS);
        }

        public final long S(long j10) {
            return g.n0(j10, h.SECONDS);
        }

        public final long W() {
            return e.f10248c;
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        public final /* synthetic */ long X(double d10) {
            return g.l0(d10, h.HOURS);
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        public final /* synthetic */ long Y(int i10) {
            return g.m0(i10, h.HOURS);
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        public final /* synthetic */ long Z(long j10) {
            return g.n0(j10, h.HOURS);
        }

        @l
        public final double a(double d10, @os.l h hVar, @os.l h hVar2) {
            l0.p(hVar, "sourceUnit");
            l0.p(hVar2, "targetUnit");
            return j.a(d10, hVar, hVar2);
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        public final /* synthetic */ long a0(double d10) {
            return g.l0(d10, h.MICROSECONDS);
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        public final /* synthetic */ long b(double d10) {
            return g.l0(d10, h.DAYS);
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        public final /* synthetic */ long b0(int i10) {
            return g.m0(i10, h.MICROSECONDS);
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        public final /* synthetic */ long c(int i10) {
            return g.m0(i10, h.DAYS);
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        public final /* synthetic */ long c0(long j10) {
            return g.n0(j10, h.MICROSECONDS);
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        public final /* synthetic */ long d(long j10) {
            return g.n0(j10, h.DAYS);
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        public final /* synthetic */ long d0(double d10) {
            return g.l0(d10, h.MILLISECONDS);
        }

        public final long e(double d10) {
            return g.l0(d10, h.DAYS);
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        public final /* synthetic */ long e0(int i10) {
            return g.m0(i10, h.MILLISECONDS);
        }

        public final long f(int i10) {
            return g.m0(i10, h.DAYS);
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        public final /* synthetic */ long f0(long j10) {
            return g.n0(j10, h.MILLISECONDS);
        }

        public final long g(long j10) {
            return g.n0(j10, h.DAYS);
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        public final /* synthetic */ long g0(double d10) {
            return g.l0(d10, h.MINUTES);
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        public final /* synthetic */ long h0(int i10) {
            return g.m0(i10, h.MINUTES);
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        public final /* synthetic */ long i0(long j10) {
            return g.n0(j10, h.MINUTES);
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        public final /* synthetic */ long j0(double d10) {
            return g.l0(d10, h.NANOSECONDS);
        }

        public final long k(double d10) {
            return g.l0(d10, h.HOURS);
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        public final /* synthetic */ long k0(int i10) {
            return g.m0(i10, h.NANOSECONDS);
        }

        public final long l(int i10) {
            return g.m0(i10, h.HOURS);
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        public final /* synthetic */ long l0(long j10) {
            return g.n0(j10, h.NANOSECONDS);
        }

        public final long m(long j10) {
            return g.n0(j10, h.HOURS);
        }

        public final long m0(@os.l String str) {
            l0.p(str, "value");
            try {
                return g.f0(str, false);
            } catch (IllegalArgumentException e10) {
                throw new IllegalArgumentException(n.a.a("Invalid duration string format: '", str, "'."), e10);
            }
        }

        public final long n0(@os.l String str) {
            l0.p(str, "value");
            try {
                return g.f0(str, true);
            } catch (IllegalArgumentException e10) {
                throw new IllegalArgumentException(n.a.a("Invalid ISO duration string format: '", str, "'."), e10);
            }
        }

        @os.m
        public final e o0(@os.l String str) {
            l0.p(str, "value");
            try {
                return e.k(g.f0(str, true));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @os.m
        public final e p0(@os.l String str) {
            l0.p(str, "value");
            try {
                return e.k(g.f0(str, false));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final long q() {
            return e.f10249d;
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        public final /* synthetic */ long q0(double d10) {
            return g.l0(d10, h.SECONDS);
        }

        public final long r(double d10) {
            return g.l0(d10, h.MICROSECONDS);
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        public final /* synthetic */ long r0(int i10) {
            return g.m0(i10, h.SECONDS);
        }

        public final long s(int i10) {
            return g.m0(i10, h.MICROSECONDS);
        }

        @l
        @f1(version = "1.5")
        @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @lm.k(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        public final /* synthetic */ long s0(long j10) {
            return g.n0(j10, h.SECONDS);
        }

        public final long t(long j10) {
            return g.n0(j10, h.MICROSECONDS);
        }

        public final long x(double d10) {
            return g.l0(d10, h.MILLISECONDS);
        }

        public final long y(int i10) {
            return g.m0(i10, h.MILLISECONDS);
        }

        public final long z(long j10) {
            return g.n0(j10, h.MILLISECONDS);
        }

        public a(w wVar) {
        }
    }

    public /* synthetic */ e(long j10) {
        this.f10251a = j10;
    }

    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @a1(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    @l
    public static /* synthetic */ void A() {
    }

    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @a1(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    @l
    public static /* synthetic */ void C() {
    }

    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @a1(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    @l
    public static /* synthetic */ void E() {
    }

    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @a1(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    @l
    public static /* synthetic */ void G() {
    }

    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @a1(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    @l
    public static /* synthetic */ void I() {
    }

    public static final long K(long j10) {
        return s0(j10, h.DAYS);
    }

    public static final long L(long j10) {
        return s0(j10, h.HOURS);
    }

    public static final long M(long j10) {
        return s0(j10, h.MICROSECONDS);
    }

    public static final long N(long j10) {
        return (c0(j10) && b0(j10)) ? j10 >> 1 : s0(j10, h.MILLISECONDS);
    }

    public static final long O(long j10) {
        return s0(j10, h.MINUTES);
    }

    public static final long P(long j10) {
        long j11 = j10 >> 1;
        if (d0(j10)) {
            return j11;
        }
        if (j11 > v1.f11968f) {
            return Long.MAX_VALUE;
        }
        if (j11 < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return j11 * ((long) g.f10254a);
    }

    public static final long Q(long j10) {
        return s0(j10, h.SECONDS);
    }

    @z0
    public static /* synthetic */ void R() {
    }

    public static final int S(long j10) {
        if (e0(j10)) {
            return 0;
        }
        return (int) (s0(j10, h.MINUTES) % ((long) 60));
    }

    @z0
    public static /* synthetic */ void T() {
    }

    public static final int U(long j10) {
        if (e0(j10)) {
            return 0;
        }
        return (int) (c0(j10) ? ((j10 >> 1) % ((long) 1000)) * ((long) g.f10254a) : (j10 >> 1) % ((long) z0.h.f21762a));
    }

    @z0
    public static /* synthetic */ void V() {
    }

    public static final int W(long j10) {
        if (e0(j10)) {
            return 0;
        }
        return (int) (s0(j10, h.SECONDS) % ((long) 60));
    }

    public static final h X(long j10) {
        return d0(j10) ? h.NANOSECONDS : h.MILLISECONDS;
    }

    public static final int Y(long j10) {
        return ((int) j10) & 1;
    }

    public static final long Z(long j10) {
        return j10 >> 1;
    }

    public static int a0(long j10) {
        return Long.hashCode(j10);
    }

    public static final boolean b0(long j10) {
        return !e0(j10);
    }

    public static final boolean c0(long j10) {
        return (((int) j10) & 1) == 1;
    }

    public static final boolean d0(long j10) {
        return (((int) j10) & 1) == 0;
    }

    public static final boolean e0(long j10) {
        return j10 == f10249d || j10 == f10250e;
    }

    public static final long f(long j10, long j11, long j12) {
        long j13 = g.f10254a;
        long j14 = j12 / j13;
        long j15 = j11 + j14;
        if (!new tn.o(-4611686018426L, g.f10257d).l(j15)) {
            return g.j(u.K(j15, -4611686018427387903L, 4611686018427387903L));
        }
        return g.l((j15 * j13) + (j12 - (j14 * j13)));
    }

    public static final boolean f0(long j10) {
        return j10 < 0;
    }

    public static final boolean g0(long j10) {
        return j10 > 0;
    }

    public static final void h(long j10, StringBuilder sb2, int i10, int i11, int i12, String str, boolean z10) {
        sb2.append(i10);
        if (i11 != 0) {
            sb2.append(n1.e.f11183c);
            String strR3 = h0.R3(String.valueOf(i11), i12, '0');
            int i13 = -1;
            int length = strR3.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i14 = length - 1;
                    if (strR3.charAt(length) != '0') {
                        i13 = length;
                        break;
                    } else if (i14 < 0) {
                        break;
                    } else {
                        length = i14;
                    }
                }
            }
            int i15 = i13 + 1;
            if (z10 || i15 >= 3) {
                sb2.append((CharSequence) strR3, 0, ((i13 + 3) / 3) * 3);
                l0.o(sb2, "append(...)");
            } else {
                sb2.append((CharSequence) strR3, 0, i15);
                l0.o(sb2, "append(...)");
            }
        }
        sb2.append(str);
    }

    public static final long h0(long j10, long j11) {
        return i0(j10, z0(j11));
    }

    public static final long i0(long j10, long j11) {
        if (e0(j10)) {
            if (b0(j11) || (j11 ^ j10) >= 0) {
                return j10;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (e0(j11)) {
            return j11;
        }
        if ((((int) j10) & 1) != (((int) j11) & 1)) {
            return c0(j10) ? f(j10, j10 >> 1, j11 >> 1) : f(j10, j11 >> 1, j10 >> 1);
        }
        long j12 = (j10 >> 1) + (j11 >> 1);
        return d0(j10) ? g.m(j12) : g.k(j12);
    }

    public static final long j0(long j10, double d10) {
        int iK0 = pn.d.K0(d10);
        if (iK0 == d10) {
            return k0(j10, iK0);
        }
        h hVarX = X(j10);
        return g.l0(p0(j10, hVarX) * d10, hVarX);
    }

    public static final /* synthetic */ e k(long j10) {
        return new e(j10);
    }

    public static final long k0(long j10, int i10) {
        if (e0(j10)) {
            if (i10 != 0) {
                return i10 > 0 ? j10 : z0(j10);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (i10 == 0) {
            return f10248c;
        }
        long j11 = j10 >> 1;
        long j12 = i10;
        long j13 = j11 * j12;
        if (!d0(j10)) {
            if (j13 / j12 == j11) {
                return g.j(u.L(j13, new tn.o(-4611686018427387903L, 4611686018427387903L)));
            }
            return pn.d.U(i10) * pn.d.V(j11) > 0 ? f10249d : f10250e;
        }
        if (new tn.o(-2147483647L, 2147483647L).l(j11)) {
            return g.l(j13);
        }
        if (j13 / j12 == j11) {
            return g.m(j13);
        }
        long j14 = g.f10254a;
        long j15 = j11 / j14;
        long j16 = j15 * j12;
        long j17 = (((j11 - (j15 * j14)) * j12) / j14) + j16;
        if (j16 / j12 != j15 || (j17 ^ j16) < 0) {
            return pn.d.U(i10) * pn.d.V(j11) > 0 ? f10249d : f10250e;
        }
        return g.j(u.L(j17, new tn.o(-4611686018427387903L, 4611686018427387903L)));
    }

    public static final <T> T l0(long j10, @os.l jn.p<? super Long, ? super Integer, ? extends T> pVar) {
        l0.p(pVar, k4.f.f8937e);
        return pVar.invoke(Long.valueOf(s0(j10, h.SECONDS)), Integer.valueOf(U(j10)));
    }

    public static int m(long j10, long j11) {
        long j12 = j10 ^ j11;
        if (j12 < 0 || (((int) j12) & 1) == 0) {
            return l0.u(j10, j11);
        }
        int i10 = (((int) j10) & 1) - (((int) j11) & 1);
        return f0(j10) ? -i10 : i10;
    }

    public static final <T> T m0(long j10, @os.l jn.q<? super Long, ? super Integer, ? super Integer, ? extends T> qVar) {
        l0.p(qVar, k4.f.f8937e);
        return qVar.invoke(Long.valueOf(s0(j10, h.MINUTES)), Integer.valueOf(W(j10)), Integer.valueOf(U(j10)));
    }

    public static long n(long j10) {
        if (f.d()) {
            if (d0(j10)) {
                long j11 = j10 >> 1;
                if (!new tn.o(-4611686018426999999L, g.f10255b).l(j11)) {
                    throw new AssertionError(j11 + " ns is out of nanoseconds range");
                }
            } else {
                long j12 = j10 >> 1;
                if (!new tn.o(-4611686018427387903L, 4611686018427387903L).l(j12)) {
                    throw new AssertionError(j12 + " ms is out of milliseconds range");
                }
                if (new tn.o(-4611686018426L, g.f10257d).l(j12)) {
                    throw new AssertionError(j12 + " ms is denormalized");
                }
            }
        }
        return j10;
    }

    public static final <T> T n0(long j10, @os.l jn.r<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> rVar) {
        l0.p(rVar, k4.f.f8937e);
        return rVar.invoke(Long.valueOf(s0(j10, h.HOURS)), Integer.valueOf(S(j10)), Integer.valueOf(W(j10)), Integer.valueOf(U(j10)));
    }

    public static final double o(long j10, long j11) {
        h hVar = (h) rm.h.X(X(j10), X(j11));
        return p0(j10, hVar) / p0(j11, hVar);
    }

    public static final <T> T o0(long j10, @os.l jn.s<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> sVar) {
        l0.p(sVar, k4.f.f8937e);
        return sVar.invoke(Long.valueOf(s0(j10, h.DAYS)), Integer.valueOf(v(j10)), Integer.valueOf(S(j10)), Integer.valueOf(W(j10)), Integer.valueOf(U(j10)));
    }

    public static final long p(long j10, double d10) {
        int iK0 = pn.d.K0(d10);
        if (iK0 == d10 && iK0 != 0) {
            return q(j10, iK0);
        }
        h hVarX = X(j10);
        return g.l0(p0(j10, hVarX) / d10, hVarX);
    }

    public static final double p0(long j10, @os.l h hVar) {
        l0.p(hVar, "unit");
        if (j10 == f10249d) {
            return Double.POSITIVE_INFINITY;
        }
        if (j10 == f10250e) {
            return Double.NEGATIVE_INFINITY;
        }
        return j.a(j10 >> 1, X(j10), hVar);
    }

    public static final long q(long j10, int i10) {
        if (i10 == 0) {
            if (g0(j10)) {
                return f10249d;
            }
            if (f0(j10)) {
                return f10250e;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        }
        if (d0(j10)) {
            return g.l((j10 >> 1) / ((long) i10));
        }
        if (e0(j10)) {
            return k0(j10, pn.d.U(i10));
        }
        long j11 = j10 >> 1;
        long j12 = i10;
        long j13 = j11 / j12;
        if (!new tn.o(-4611686018426L, g.f10257d).l(j13)) {
            return g.j(j13);
        }
        long j14 = j11 - (j13 * j12);
        long j15 = g.f10254a;
        return g.l((j13 * j15) + ((j14 * j15) / j12));
    }

    public static final int q0(long j10, @os.l h hVar) {
        l0.p(hVar, "unit");
        return (int) u.K(s0(j10, hVar), -2147483648L, 2147483647L);
    }

    public static boolean r(long j10, Object obj) {
        return (obj instanceof e) && j10 == ((e) obj).f10251a;
    }

    @os.l
    public static final String r0(long j10) {
        StringBuilder sb2 = new StringBuilder();
        if (f0(j10)) {
            sb2.append('-');
        }
        sb2.append("PT");
        long jT = t(j10);
        long jS0 = s0(jT, h.HOURS);
        int iS = S(jT);
        int iW = W(jT);
        int iU = U(jT);
        if (e0(j10)) {
            jS0 = 9999999999999L;
        }
        boolean z10 = false;
        boolean z11 = jS0 != 0;
        boolean z12 = (iW == 0 && iU == 0) ? false : true;
        if (iS != 0 || (z12 && z11)) {
            z10 = true;
        }
        if (z11) {
            sb2.append(jS0);
            sb2.append('H');
        }
        if (z10) {
            sb2.append(iS);
            sb2.append(kl.f.f9274g);
        }
        if (z12 || (!z11 && !z10)) {
            h(j10, sb2, iW, iU, 9, "S", true);
        }
        String string = sb2.toString();
        l0.o(string, "toString(...)");
        return string;
    }

    public static final boolean s(long j10, long j11) {
        return j10 == j11;
    }

    public static final long s0(long j10, @os.l h hVar) {
        l0.p(hVar, "unit");
        if (j10 == f10249d) {
            return Long.MAX_VALUE;
        }
        if (j10 == f10250e) {
            return Long.MIN_VALUE;
        }
        return j.b(j10 >> 1, X(j10), hVar);
    }

    public static final long t(long j10) {
        return f0(j10) ? z0(j10) : j10;
    }

    @z0
    public static /* synthetic */ void u() {
    }

    public static final int v(long j10) {
        if (e0(j10)) {
            return 0;
        }
        return (int) (s0(j10, h.HOURS) % ((long) 24));
    }

    @os.l
    public static String v0(long j10) {
        if (j10 == 0) {
            return "0s";
        }
        if (j10 == f10249d) {
            return "Infinity";
        }
        if (j10 == f10250e) {
            return "-Infinity";
        }
        boolean zF0 = f0(j10);
        StringBuilder sb2 = new StringBuilder();
        if (zF0) {
            sb2.append('-');
        }
        long jT = t(j10);
        long jS0 = s0(jT, h.DAYS);
        int iV = v(jT);
        int iS = S(jT);
        int iW = W(jT);
        int iU = U(jT);
        int i10 = 0;
        boolean z10 = jS0 != 0;
        boolean z11 = iV != 0;
        boolean z12 = iS != 0;
        boolean z13 = (iW == 0 && iU == 0) ? false : true;
        if (z10) {
            sb2.append(jS0);
            sb2.append(kl.f.f9273f);
            i10 = 1;
        }
        if (z11 || (z10 && (z12 || z13))) {
            int i11 = i10 + 1;
            if (i10 > 0) {
                sb2.append(' ');
            }
            sb2.append(iV);
            sb2.append(kl.f.f9272e);
            i10 = i11;
        }
        if (z12 || (z13 && (z11 || z10))) {
            int i12 = i10 + 1;
            if (i10 > 0) {
                sb2.append(' ');
            }
            sb2.append(iS);
            sb2.append(kl.f.f9271d);
            i10 = i12;
        }
        if (z13) {
            int i13 = i10 + 1;
            if (i10 > 0) {
                sb2.append(' ');
            }
            if (iW != 0 || z10 || z11 || z12) {
                h(j10, sb2, iW, iU, 9, p6.s.f13016a, false);
            } else if (iU >= 1000000) {
                h(j10, sb2, iU / g.f10254a, iU % g.f10254a, 6, "ms", false);
            } else if (iU >= 1000) {
                h(j10, sb2, iU / 1000, iU % 1000, 3, "us", false);
            } else {
                sb2.append(iU);
                sb2.append("ns");
            }
            i10 = i13;
        }
        if (zF0 && i10 > 1) {
            sb2.insert(1, '(').append(')');
        }
        String string = sb2.toString();
        l0.o(string, "toString(...)");
        return string;
    }

    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @a1(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    @l
    public static /* synthetic */ void w() {
    }

    @os.l
    public static final String w0(long j10, @os.l h hVar, int i10) {
        l0.p(hVar, "unit");
        if (i10 < 0) {
            throw new IllegalArgumentException(h.a.a("decimals must be not negative, but was ", i10).toString());
        }
        double dP0 = p0(j10, hVar);
        if (Double.isInfinite(dP0)) {
            return String.valueOf(dP0);
        }
        StringBuilder sb2 = new StringBuilder();
        if (i10 > 12) {
            i10 = 12;
        }
        sb2.append(f.b(dP0, i10));
        sb2.append(k.h(hVar));
        return sb2.toString();
    }

    public static /* synthetic */ String x0(long j10, h hVar, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return w0(j10, hVar, i10);
    }

    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @a1(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    @l
    public static /* synthetic */ void y() {
    }

    public static final long y0(long j10, @os.l h hVar) {
        l0.p(hVar, "unit");
        h hVarX = X(j10);
        if (hVar.compareTo(hVarX) <= 0 || e0(j10)) {
            return j10;
        }
        long j11 = j10 >> 1;
        return g.n0(j11 - (j11 % j.b(1L, hVar, hVarX)), hVarX);
    }

    public static final long z0(long j10) {
        return g.i(-(j10 >> 1), ((int) j10) & 1);
    }

    public final /* synthetic */ long A0() {
        return this.f10251a;
    }

    @Override // java.lang.Comparable
    public int compareTo(e eVar) {
        return m(this.f10251a, eVar.f10251a);
    }

    public boolean equals(Object obj) {
        return r(this.f10251a, obj);
    }

    public int hashCode() {
        return Long.hashCode(this.f10251a);
    }

    public int l(long j10) {
        return m(this.f10251a, j10);
    }

    @os.l
    public String toString() {
        return v0(this.f10251a);
    }
}
