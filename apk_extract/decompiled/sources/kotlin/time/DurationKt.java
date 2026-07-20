package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.IntIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import vj.e;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0015\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\t\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001d\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010\u0015\u001a\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a)\u0010\u0017\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00022\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00140\u001aH\u0082\b\u001a)\u0010\u001c\u001a\u00020\u0002*\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00022\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00140\u001aH\u0082\b\u001a\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0002\u001a\u0010\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002\u001a\u0015\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\u001a\u0015\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\u001a\u001d\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010-\u001a\u0015\u0010.\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\u001a\u0015\u0010/\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\"\u000e\u0010\u001d\u001a\u00020\u0002X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"toDuration", "Lkotlin/time/Duration;", "", "unit", "Lkotlin/time/DurationUnit;", "(ILkotlin/time/DurationUnit;)J", "", "(JLkotlin/time/DurationUnit;)J", "", "(DLkotlin/time/DurationUnit;)J", "times", TypedValues.TransitionType.S_DURATION, "times-mvk6XK0", "(IJ)J", "times-kIfJnKk", "(DJ)J", "parseDuration", "value", "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "substringWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "skipWhile", "NANOS_IN_MILLIS", "MAX_NANOS", "MAX_MILLIS", "MAX_NANOS_IN_MILLIS", "nanosToMillis", "nanos", "millisToNanos", "millis", "durationOfNanos", "normalNanos", "(J)J", "durationOfMillis", "normalMillis", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfNanosNormalized", "durationOfMillisNormalized", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1059:1\n1012#1,6:1061\n1015#1,3:1067\n1012#1,6:1070\n1012#1,6:1076\n1015#1,3:1085\n1#2:1060\n1734#3,3:1082\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n*L\n936#1:1061,6\n970#1:1067,3\n973#1:1070,6\n976#1:1076,6\n1012#1:1085,3\n1001#1:1082,3\n*E\n"})
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOf(long j8, int i8) {
        return Duration.m1498constructorimpl((j8 << 1) + ((long) i8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfMillis(long j8) {
        return Duration.m1498constructorimpl((j8 << 1) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfMillisNormalized(long j8) {
        return (-4611686018426L > j8 || j8 >= 4611686018427L) ? durationOfMillis(RangesKt.coerceIn(j8, -4611686018427387903L, MAX_MILLIS)) : durationOfNanos(millisToNanos(j8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfNanos(long j8) {
        return Duration.m1498constructorimpl(j8 << 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfNanosNormalized(long j8) {
        return (-4611686018426999999L > j8 || j8 >= 4611686018427000000L) ? durationOfMillis(nanosToMillis(j8)) : durationOfNanos(j8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long millisToNanos(long j8) {
        return j8 * ((long) NANOS_IN_MILLIS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long nanosToMillis(long j8) {
        return j8 / ((long) NANOS_IN_MILLIS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:134:0x0251  */
    /* JADX WARN: Code duplicated, block: B:174:? A[RETURN, SYNTHETIC] */
    public static final long parseDuration(String str, boolean z2) {
        DurationUnit durationUnit;
        boolean z3;
        int i8;
        boolean z5;
        long jM1527plusLRDsOJo;
        boolean z10;
        char cCharAt;
        char cCharAt2;
        char cCharAt3;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        Duration.Companion companion = Duration.INSTANCE;
        long jM1589getZEROUwyO8pc = companion.m1589getZEROUwyO8pc();
        char cCharAt4 = str.charAt(0);
        boolean z11 = true;
        int i9 = (cCharAt4 == '+' || cCharAt4 == '-') ? 1 : 0;
        boolean z12 = i9 > 0;
        boolean z13 = z12 && StringsKt__StringsKt.startsWith$default((CharSequence) str, '-', false, 2, (Object) null);
        if (length <= i9) {
            throw new IllegalArgumentException("No components");
        }
        char c9 = '0';
        if (str.charAt(i9) != 'P') {
            if (z2) {
                throw new IllegalArgumentException();
            }
            if (StringsKt__StringsJVMKt.regionMatches(str, i9, "Infinity", 0, Math.max(length - i9, 8), true)) {
                jM1589getZEROUwyO8pc = companion.m1587getINFINITEUwyO8pc();
            } else {
                boolean z14 = !z12;
                if (z12 && str.charAt(i9) == '(' && StringsKt.last(str) == ')') {
                    int i10 = i9 + 1;
                    length--;
                    if (i10 == length) {
                        throw new IllegalArgumentException("No components");
                    }
                    z5 = false;
                    durationUnit = null;
                    i8 = i10;
                    jM1527plusLRDsOJo = jM1589getZEROUwyO8pc;
                    z3 = true;
                } else {
                    durationUnit = null;
                    z3 = z14;
                    i8 = i9;
                    z5 = false;
                    jM1527plusLRDsOJo = jM1589getZEROUwyO8pc;
                }
                while (i8 < length) {
                    if (z5 && z3) {
                        while (i8 < str.length() && str.charAt(i8) == ' ') {
                            i8++;
                        }
                    }
                    int i11 = i8;
                    while (i11 < str.length() && (('0' <= (cCharAt2 = str.charAt(i11)) && cCharAt2 < ':') || cCharAt2 == '.')) {
                        i11++;
                    }
                    Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring = str.substring(i8, i11);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    if (strSubstring.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length2 = strSubstring.length() + i8;
                    int i12 = length2;
                    while (i12 < str.length() && 'a' <= (cCharAt = str.charAt(i12)) && cCharAt < '{') {
                        i12++;
                    }
                    Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring2 = str.substring(length2, i12);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    int length3 = length2 + strSubstring2.length();
                    DurationUnit durationUnitDurationUnitByShortName = DurationUnitKt__DurationUnitKt.durationUnitByShortName(strSubstring2);
                    if (durationUnit != null && durationUnit.compareTo(durationUnitDurationUnitByShortName) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) strSubstring, '.', 0, false, 6, (Object) null);
                    if (iIndexOf$default > 0) {
                        Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring3 = strSubstring.substring(0, iIndexOf$default);
                        Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                        long jM1527plusLRDsOJo2 = Duration.m1527plusLRDsOJo(jM1527plusLRDsOJo, toDuration(Long.parseLong(strSubstring3), durationUnitDurationUnitByShortName));
                        Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring4 = strSubstring.substring(iIndexOf$default);
                        Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
                        jM1527plusLRDsOJo = Duration.m1527plusLRDsOJo(jM1527plusLRDsOJo2, toDuration(Double.parseDouble(strSubstring4), durationUnitDurationUnitByShortName));
                        if (length3 < length) {
                            throw new IllegalArgumentException("Fractional component must be last");
                        }
                    } else {
                        jM1527plusLRDsOJo = Duration.m1527plusLRDsOJo(jM1527plusLRDsOJo, toDuration(Long.parseLong(strSubstring), durationUnitDurationUnitByShortName));
                    }
                    durationUnit = durationUnitDurationUnitByShortName;
                    i8 = length3;
                    z13 = z13;
                    z5 = true;
                }
                z10 = z13;
                jM1589getZEROUwyO8pc = jM1527plusLRDsOJo;
            }
            if (z10) {
                return Duration.m1542unaryMinusUwyO8pc(jM1589getZEROUwyO8pc);
            }
            return jM1589getZEROUwyO8pc;
        }
        int i13 = i9 + 1;
        if (i13 == length) {
            throw new IllegalArgumentException();
        }
        DurationUnit durationUnit2 = null;
        boolean z15 = false;
        while (i13 < length) {
            if (str.charAt(i13) != 'T') {
                int i14 = i13;
                while (i14 < str.length() && ((c9 <= (cCharAt3 = str.charAt(i14)) && cCharAt3 < ':') || StringsKt__StringsKt.contains$default("+-.", cCharAt3, false, 2, (Object) null))) {
                    i14++;
                }
                Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                String strSubstring5 = str.substring(i13, i14);
                Intrinsics.checkNotNullExpressionValue(strSubstring5, "substring(...)");
                if (strSubstring5.length() == 0) {
                    throw new IllegalArgumentException();
                }
                int length4 = strSubstring5.length() + i13;
                if (length4 < 0 || length4 >= str.length()) {
                    throw new IllegalArgumentException("Missing unit for value ".concat(strSubstring5));
                }
                char cCharAt5 = str.charAt(length4);
                int i15 = length4 + 1;
                DurationUnit durationUnitDurationUnitByIsoChar = DurationUnitKt__DurationUnitKt.durationUnitByIsoChar(cCharAt5, z15);
                if (durationUnit2 != null && durationUnit2.compareTo(durationUnitDurationUnitByIsoChar) <= 0) {
                    throw new IllegalArgumentException("Unexpected order of duration components");
                }
                int iIndexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) strSubstring5, '.', 0, false, 6, (Object) null);
                if (durationUnitDurationUnitByIsoChar != DurationUnit.SECONDS || iIndexOf$default2 <= 0) {
                    jM1589getZEROUwyO8pc = Duration.m1527plusLRDsOJo(jM1589getZEROUwyO8pc, toDuration(parseOverLongIsoComponent(strSubstring5), durationUnitDurationUnitByIsoChar));
                } else {
                    Intrinsics.checkNotNull(strSubstring5, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring6 = strSubstring5.substring(0, iIndexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring6, "substring(...)");
                    long jM1527plusLRDsOJo3 = Duration.m1527plusLRDsOJo(jM1589getZEROUwyO8pc, toDuration(parseOverLongIsoComponent(strSubstring6), durationUnitDurationUnitByIsoChar));
                    Intrinsics.checkNotNull(strSubstring5, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring7 = strSubstring5.substring(iIndexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring7, "substring(...)");
                    jM1589getZEROUwyO8pc = Duration.m1527plusLRDsOJo(jM1527plusLRDsOJo3, toDuration(Double.parseDouble(strSubstring7), durationUnitDurationUnitByIsoChar));
                }
                z15 = z15;
                durationUnit2 = durationUnitDurationUnitByIsoChar;
                i13 = i15;
                z11 = true;
                c9 = '0';
            } else {
                if (z15 || (i13 = i13 + 1) == length) {
                    throw new IllegalArgumentException();
                }
                z15 = z11;
            }
        }
        z10 = z13;
        if (z10) {
            return Duration.m1542unaryMinusUwyO8pc(jM1589getZEROUwyO8pc);
        }
        return jM1589getZEROUwyO8pc;
    }

    private static final long parseOverLongIsoComponent(String str) {
        int length = str.length();
        int i8 = (length <= 0 || !StringsKt__StringsKt.contains$default("+-", str.charAt(0), false, 2, (Object) null)) ? 0 : 1;
        if (length - i8 > 16) {
            Iterable intRange = new IntRange(i8, StringsKt.getLastIndex(str));
            if (!(intRange instanceof Collection) || !((Collection) intRange).isEmpty()) {
                Iterator it = intRange.iterator();
                while (true) {
                    if (it.hasNext()) {
                        char cCharAt = str.charAt(((IntIterator) it).nextInt());
                        if ('0' > cCharAt || cCharAt >= ':') {
                        }
                    }
                }
            }
            return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        if (StringsKt__StringsJVMKt.startsWith$default(str, e.ANY_NON_NULL_MARKER, false, 2, null)) {
            str = StringsKt.drop(str, 1);
        }
        return Long.parseLong(str);
    }

    private static final int skipWhile(String str, int i8, Function1<? super Character, Boolean> function1) {
        while (i8 < str.length() && function1.invoke(Character.valueOf(str.charAt(i8))).booleanValue()) {
            i8++;
        }
        return i8;
    }

    private static final String substringWhile(String str, int i8, Function1<? super Character, Boolean> function1) {
        int i9 = i8;
        while (i9 < str.length() && function1.invoke(Character.valueOf(str.charAt(i9))).booleanValue()) {
            i9++;
        }
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i8, i9);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @InlineOnly
    /* JADX INFO: renamed from: times-kIfJnKk, reason: not valid java name */
    private static final long m1594timeskIfJnKk(double d7, long j8) {
        return Duration.m1528timesUwyO8pc(j8, d7);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @InlineOnly
    /* JADX INFO: renamed from: times-mvk6XK0, reason: not valid java name */
    private static final long m1595timesmvk6XK0(int i8, long j8) {
        return Duration.m1529timesUwyO8pc(j8, i8);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(int i8, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return unit.compareTo(DurationUnit.SECONDS) <= 0 ? durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(i8, unit, DurationUnit.NANOSECONDS)) : toDuration(i8, unit);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(long j8, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        DurationUnit durationUnit = DurationUnit.NANOSECONDS;
        long jConvertDurationUnitOverflow = DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(MAX_NANOS, durationUnit, unit);
        if ((-jConvertDurationUnitOverflow) <= j8 && j8 <= jConvertDurationUnitOverflow) {
            return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(j8, unit, durationUnit));
        }
        return durationOfMillis(RangesKt.coerceIn(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(j8, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, MAX_MILLIS));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(double d7, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        double dConvertDurationUnit = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d7, unit, DurationUnit.NANOSECONDS);
        if (!Double.isNaN(dConvertDurationUnit)) {
            long jRoundToLong = MathKt.roundToLong(dConvertDurationUnit);
            if (-4611686018426999999L <= jRoundToLong && jRoundToLong < 4611686018427000000L) {
                return durationOfNanos(jRoundToLong);
            }
            return durationOfMillisNormalized(MathKt.roundToLong(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d7, unit, DurationUnit.MILLISECONDS)));
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.");
    }
}
