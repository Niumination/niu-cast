package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a'\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\b\u001a\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a%\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0001H\u0080\b¨\u0006\u001d"}, d2 = {"saturatingAdd", "", "value", "unit", "Lkotlin/time/DurationUnit;", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "saturatingAdd-NuflL3o", "(JLkotlin/time/DurationUnit;J)J", "checkInfiniteSumDefined", "durationInUnit", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "saturatingAddInHalves", "saturatingAddInHalves-NuflL3o", "infinityOfSign", "(J)J", "saturatingDiff", "valueNs", "origin", "(JJLkotlin/time/DurationUnit;)J", "saturatingOriginsDiff", "origin1", "origin2", "saturatingFiniteDiff", "value1", "value2", "isSaturated", "", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nlongSaturatedMath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,81:1\n80#1:82\n80#1:83\n80#1:84\n80#1:85\n80#1:86\n80#1:87\n*S KotlinDebug\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n14#1:82\n17#1:83\n36#1:84\n46#1:85\n53#1:86\n57#1:87\n*E\n"})
public final class LongSaturatedMathKt {
    /* JADX INFO: renamed from: checkInfiniteSumDefined-PjuGub4, reason: not valid java name */
    private static final long m1596checkInfiniteSumDefinedPjuGub4(long j8, long j10, long j11) {
        if (!Duration.m1523isInfiniteimpl(j10) || (j8 ^ j11) >= 0) {
            return j8;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    private static final long infinityOfSign(long j8) {
        return j8 < 0 ? Duration.INSTANCE.m1588getNEG_INFINITEUwyO8pc$kotlin_stdlib() : Duration.INSTANCE.m1587getINFINITEUwyO8pc();
    }

    public static final boolean isSaturated(long j8) {
        return ((j8 - 1) | 1) == Long.MAX_VALUE;
    }

    /* JADX INFO: renamed from: saturatingAdd-NuflL3o, reason: not valid java name */
    public static final long m1597saturatingAddNuflL3o(long j8, DurationUnit unit, long j10) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        long jM1537toLongimpl = Duration.m1537toLongimpl(j10, unit);
        if (((j8 - 1) | 1) == Long.MAX_VALUE) {
            return m1596checkInfiniteSumDefinedPjuGub4(j8, j10, jM1537toLongimpl);
        }
        if ((1 | (jM1537toLongimpl - 1)) == Long.MAX_VALUE) {
            return m1598saturatingAddInHalvesNuflL3o(j8, unit, j10);
        }
        long j11 = j8 + jM1537toLongimpl;
        if (((j8 ^ j11) & (jM1537toLongimpl ^ j11)) < 0) {
            return j8 < 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        return j11;
    }

    /* JADX INFO: renamed from: saturatingAddInHalves-NuflL3o, reason: not valid java name */
    private static final long m1598saturatingAddInHalvesNuflL3o(long j8, DurationUnit durationUnit, long j10) {
        long jM1501divUwyO8pc = Duration.m1501divUwyO8pc(j10, 2);
        long jM1537toLongimpl = Duration.m1537toLongimpl(jM1501divUwyO8pc, durationUnit);
        return (1 | (jM1537toLongimpl - 1)) == Long.MAX_VALUE ? jM1537toLongimpl : m1597saturatingAddNuflL3o(m1597saturatingAddNuflL3o(j8, durationUnit, jM1501divUwyO8pc), durationUnit, Duration.m1526minusLRDsOJo(j10, jM1501divUwyO8pc));
    }

    public static final long saturatingDiff(long j8, long j10, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (1 | (j10 - 1)) == Long.MAX_VALUE ? Duration.m1542unaryMinusUwyO8pc(infinityOfSign(j10)) : saturatingFiniteDiff(j8, j10, unit);
    }

    private static final long saturatingFiniteDiff(long j8, long j10, DurationUnit durationUnit) {
        long j11 = j8 - j10;
        if (((j11 ^ j8) & (~(j11 ^ j10))) >= 0) {
            return DurationKt.toDuration(j11, durationUnit);
        }
        DurationUnit durationUnit2 = DurationUnit.MILLISECONDS;
        if (durationUnit.compareTo(durationUnit2) >= 0) {
            return Duration.m1542unaryMinusUwyO8pc(infinityOfSign(j11));
        }
        long jConvertDurationUnit = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(1L, durationUnit2, durationUnit);
        long j12 = (j8 / jConvertDurationUnit) - (j10 / jConvertDurationUnit);
        long j13 = (j8 % jConvertDurationUnit) - (j10 % jConvertDurationUnit);
        Duration.Companion companion = Duration.INSTANCE;
        return Duration.m1527plusLRDsOJo(DurationKt.toDuration(j12, durationUnit2), DurationKt.toDuration(j13, durationUnit));
    }

    public static final long saturatingOriginsDiff(long j8, long j10, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (((j10 - 1) | 1) == Long.MAX_VALUE) {
            return j8 == j10 ? Duration.INSTANCE.m1589getZEROUwyO8pc() : Duration.m1542unaryMinusUwyO8pc(infinityOfSign(j10));
        }
        return (1 | (j8 - 1)) == Long.MAX_VALUE ? infinityOfSign(j8) : saturatingFiniteDiff(j8, j10, unit);
    }
}
