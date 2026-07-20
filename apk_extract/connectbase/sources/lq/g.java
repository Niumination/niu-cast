package lq;

import java.util.Collection;
import java.util.Iterator;
import jq.e0;
import jq.h0;
import jq.j0;
import kn.l0;
import kn.r1;
import lm.a1;
import lm.f1;
import lm.p2;
import nm.v0;
import tn.u;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1495:1\n1447#1,6:1497\n1450#1,3:1503\n1447#1,6:1506\n1447#1,6:1512\n1450#1,3:1521\n1#2:1496\n1726#3,3:1518\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n*L\n1371#1:1497,6\n1405#1:1503,3\n1408#1:1506,6\n1411#1:1512,6\n1447#1:1521,3\n1436#1:1518,3\n*E\n"})
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f10254a = 1000000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f10255b = 4611686018426999999L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f10256c = 4611686018427387903L;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f10257d = 4611686018426L;

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    public static /* synthetic */ void C(double d10) {
    }

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    public static /* synthetic */ void D(int i10) {
    }

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    public static /* synthetic */ void E(long j10) {
    }

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    public static /* synthetic */ void I(double d10) {
    }

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    public static /* synthetic */ void J(int i10) {
    }

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    public static /* synthetic */ void K(long j10) {
    }

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    public static /* synthetic */ void O(double d10) {
    }

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    public static /* synthetic */ void P(int i10) {
    }

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    public static /* synthetic */ void Q(long j10) {
    }

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    public static /* synthetic */ void U(double d10) {
    }

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    public static /* synthetic */ void V(int i10) {
    }

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    public static /* synthetic */ void W(long j10) {
    }

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    public static /* synthetic */ void a0(double d10) {
    }

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    public static /* synthetic */ void b0(int i10) {
    }

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    public static /* synthetic */ void c0(long j10) {
    }

    public static final long d0(long j10) {
        return j10 * ((long) f10254a);
    }

    public static final long e0(long j10) {
        return j10 / ((long) f10254a);
    }

    public static final long f(long j10) {
        return j10 * ((long) f10254a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final long f0(String str, boolean z10) {
        boolean z11;
        Object obj;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        e.a aVar = e.f10247b;
        aVar.getClass();
        long jI0 = e.f10248c;
        char cCharAt = str.charAt(0);
        int i10 = 1;
        int length2 = (cCharAt == '+' || cCharAt == '-') ? 1 : 0;
        boolean z12 = length2 > 0;
        Object obj2 = null;
        boolean z13 = z12 && h0.b5(str, '-', false, 2, null);
        if (length <= length2) {
            throw new IllegalArgumentException("No components");
        }
        char c10 = '9';
        char c11 = '0';
        if (str.charAt(length2) == 'P') {
            int i11 = length2 + 1;
            if (i11 == length) {
                throw new IllegalArgumentException();
            }
            h hVar = null;
            boolean z14 = 0;
            while (i11 < length) {
                if (str.charAt(i11) != 'T') {
                    int i12 = i11;
                    while (true) {
                        if (i12 >= str.length()) {
                            obj = obj2;
                            break;
                        }
                        char cCharAt2 = str.charAt(i12);
                        if (!new tn.c(c11, c10, i10).l(cCharAt2)) {
                            obj = null;
                            if (!h0.S2("+-.", cCharAt2, false, 2, null)) {
                                break;
                            }
                        } else {
                            obj = null;
                        }
                        i12++;
                        obj2 = obj;
                        c10 = '9';
                        c11 = '0';
                        i10 = 1;
                    }
                    l0.n(str, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring = str.substring(i11, i12);
                    l0.o(strSubstring, "substring(...)");
                    if (strSubstring.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length3 = strSubstring.length() + i11;
                    if (length3 < 0 || length3 > h0.g3(str)) {
                        throw new IllegalArgumentException("Missing unit for value ".concat(strSubstring));
                    }
                    char cCharAt3 = str.charAt(length3);
                    int i13 = length3 + 1;
                    h hVarF = k.f(cCharAt3, z14);
                    if (hVar != null && hVar.compareTo(hVarF) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    int iO3 = h0.o3(strSubstring, n1.e.f11183c, 0, false, 6, null);
                    if (hVarF != h.SECONDS || iO3 <= 0) {
                        jI0 = e.i0(jI0, n0(g0(strSubstring), hVarF));
                    } else {
                        l0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring2 = strSubstring.substring(0, iO3);
                        l0.o(strSubstring2, "substring(...)");
                        long jI1 = e.i0(jI0, n0(g0(strSubstring2), hVarF));
                        l0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring3 = strSubstring.substring(iO3);
                        l0.o(strSubstring3, "substring(...)");
                        jI0 = e.i0(jI1, l0(Double.parseDouble(strSubstring3), hVarF));
                    }
                    obj2 = obj;
                    hVar = hVarF;
                    c10 = '9';
                    c11 = '0';
                    i10 = 1;
                    i11 = i13;
                } else {
                    if (z14 != 0 || (i11 = i11 + 1) == length) {
                        throw new IllegalArgumentException();
                    }
                    z14 = i10;
                }
            }
        } else {
            if (z10) {
                throw new IllegalArgumentException();
            }
            String str2 = "Unexpected order of duration components";
            long jI2 = jI0;
            char c12 = '0';
            if (e0.b2(str, length2, "Infinity", 0, Math.max(length - length2, 8), true)) {
                aVar.getClass();
                jI0 = e.f10249d;
            } else {
                boolean z15 = !z12;
                if (z12 && str.charAt(length2) == '(' && j0.r7(str) == ')') {
                    length2++;
                    length--;
                    if (length2 == length) {
                        throw new IllegalArgumentException("No components");
                    }
                    z15 = true;
                }
                boolean z16 = false;
                h hVar2 = null;
                while (length2 < length) {
                    if (z16 && z15) {
                        while (length2 < str.length() && str.charAt(length2) == ' ') {
                            length2++;
                        }
                    }
                    int i14 = length2;
                    while (i14 < str.length()) {
                        char cCharAt4 = str.charAt(i14);
                        if (!new tn.c(c12, '9', 1).l(cCharAt4) && cCharAt4 != '.') {
                            break;
                        }
                        i14++;
                    }
                    l0.n(str, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring4 = str.substring(length2, i14);
                    l0.o(strSubstring4, "substring(...)");
                    if (strSubstring4.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length4 = strSubstring4.length() + length2;
                    int i15 = length4;
                    while (true) {
                        if (i15 >= str.length()) {
                            z11 = true;
                            break;
                        }
                        z11 = true;
                        if (!new tn.c(y5.a.H, 'z', 1).l(str.charAt(i15))) {
                            break;
                        }
                        i15++;
                    }
                    l0.n(str, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring5 = str.substring(length4, i15);
                    l0.o(strSubstring5, "substring(...)");
                    length2 = strSubstring5.length() + length4;
                    h hVarG = k.g(strSubstring5);
                    if (hVar2 != null && hVar2.compareTo(hVarG) <= 0) {
                        throw new IllegalArgumentException(str2);
                    }
                    String str3 = str2;
                    int iO4 = h0.o3(strSubstring4, n1.e.f11183c, 0, false, 6, null);
                    if (iO4 > 0) {
                        l0.n(strSubstring4, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring6 = strSubstring4.substring(0, iO4);
                        l0.o(strSubstring6, "substring(...)");
                        long jI3 = e.i0(jI2, n0(Long.parseLong(strSubstring6), hVarG));
                        l0.n(strSubstring4, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring7 = strSubstring4.substring(iO4);
                        l0.o(strSubstring7, "substring(...)");
                        jI2 = e.i0(jI3, l0(Double.parseDouble(strSubstring7), hVarG));
                        if (length2 < length) {
                            throw new IllegalArgumentException("Fractional component must be last");
                        }
                    } else {
                        jI2 = e.i0(jI2, n0(Long.parseLong(strSubstring4), hVarG));
                    }
                    hVar2 = hVarG;
                    str2 = str3;
                    z16 = z11;
                    c12 = '0';
                }
                jI0 = jI2;
            }
        }
        return z13 ? e.z0(jI0) : jI0;
    }

    public static final long g(long j10) {
        return j10 / ((long) f10254a);
    }

    public static final long g0(String str) {
        int length = str.length();
        int i10 = (length <= 0 || !h0.S2("+-", str.charAt(0), false, 2, null)) ? 0 : 1;
        if (length - i10 > 16) {
            Iterable lVar = new tn.l(i10, h0.g3(str), 1);
            if (!(lVar instanceof Collection) || !((Collection) lVar).isEmpty()) {
                Iterator it = lVar.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!new tn.c('0', '9', 1).l(str.charAt(((v0) it).nextInt()))) {
                        }
                    }
                }
            }
            return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        if (e0.s2(str, ps.d.ANY_NON_NULL_MARKER, false, 2, null)) {
            str = j0.y6(str, 1);
        }
        return Long.parseLong(str);
    }

    public static final int h0(String str, int i10, jn.l<? super Character, Boolean> lVar) {
        while (i10 < str.length() && lVar.invoke(Character.valueOf(str.charAt(i10))).booleanValue()) {
            i10++;
        }
        return i10;
    }

    public static final long i(long j10, int i10) {
        return e.n((j10 << 1) + ((long) i10));
    }

    public static final String i0(String str, int i10, jn.l<? super Character, Boolean> lVar) {
        int i11 = i10;
        while (i11 < str.length() && lVar.invoke(Character.valueOf(str.charAt(i11))).booleanValue()) {
            i11++;
        }
        l0.n(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i10, i11);
        l0.o(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final long j(long j10) {
        return e.n((j10 << 1) + 1);
    }

    @f1(version = "1.6")
    @an.f
    @p2(markerClass = {l.class})
    public static final long j0(double d10, long j10) {
        return e.j0(j10, d10);
    }

    public static final long k(long j10) {
        return new tn.o(-4611686018426L, f10257d).l(j10) ? l(j10 * ((long) f10254a)) : j(u.K(j10, -4611686018427387903L, 4611686018427387903L));
    }

    @f1(version = "1.6")
    @an.f
    @p2(markerClass = {l.class})
    public static final long k0(int i10, long j10) {
        return e.k0(j10, i10);
    }

    public static final long l(long j10) {
        return e.n(j10 << 1);
    }

    @f1(version = "1.6")
    @p2(markerClass = {l.class})
    public static final long l0(double d10, @os.l h hVar) {
        l0.p(hVar, "unit");
        double dA = j.a(d10, hVar, h.NANOSECONDS);
        if (Double.isNaN(dA)) {
            throw new IllegalArgumentException("Duration value cannot be NaN.");
        }
        long jM0 = pn.d.M0(dA);
        return new tn.o(-4611686018426999999L, f10255b).l(jM0) ? l(jM0) : k(pn.d.M0(j.a(d10, hVar, h.MILLISECONDS)));
    }

    public static final long m(long j10) {
        return new tn.o(-4611686018426999999L, f10255b).l(j10) ? l(j10) : j(j10 / ((long) f10254a));
    }

    @f1(version = "1.6")
    @p2(markerClass = {l.class})
    public static final long m0(int i10, @os.l h hVar) {
        l0.p(hVar, "unit");
        return hVar.compareTo(h.SECONDS) <= 0 ? l(j.c(i10, hVar, h.NANOSECONDS)) : n0(i10, hVar);
    }

    @f1(version = "1.6")
    @p2(markerClass = {l.class})
    public static final long n0(long j10, @os.l h hVar) {
        l0.p(hVar, "unit");
        h hVar2 = h.NANOSECONDS;
        long jC = j.c(f10255b, hVar2, hVar);
        return new tn.o(-jC, jC).l(j10) ? l(j.c(j10, hVar, hVar2)) : j(u.K(j.b(j10, hVar, h.MILLISECONDS), -4611686018427387903L, 4611686018427387903L));
    }

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    public static /* synthetic */ void q(double d10) {
    }

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    public static /* synthetic */ void r(int i10) {
    }

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    public static /* synthetic */ void s(long j10) {
    }

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    public static /* synthetic */ void w(double d10) {
    }

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    public static /* synthetic */ void x(int i10) {
    }

    @l
    @f1(version = "1.3")
    @lm.l(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @lm.k(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @a1(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    public static /* synthetic */ void y(long j10) {
    }
}
