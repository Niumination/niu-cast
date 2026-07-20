package kotlin.time;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import h0.a;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.comparisons.ComparisonsKt___ComparisonsJvmKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import o.d;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.6")
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 \u0089\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0089\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0010\u0010\u0016\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010!\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\"\u0010\u001bJ\u0018\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b%\u0010&J\u0018\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020'H\u0086\u0002¢\u0006\u0004\b%\u0010(J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b*\u0010&J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010$\u001a\u00020'H\u0086\u0002¢\u0006\u0004\b*\u0010(J\u0018\u0010)\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0013H\u0000¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\r¢\u0006\u0004\b2\u0010\u000fJ\r\u00103\u001a\u00020\r¢\u0006\u0004\b4\u0010\u000fJ\r\u00105\u001a\u00020\r¢\u0006\u0004\b6\u0010\u000fJ\r\u00107\u001a\u00020\r¢\u0006\u0004\b8\u0010\u000fJ\u0018\u0010;\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b<\u0010=J\u009d\u0001\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?2u\u0010@\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(E\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0AH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010JJ\u0088\u0001\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?2`\u0010@\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(E\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0KH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010LJs\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?2K\u0010@\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0MH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010NJ^\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?26\u0010@\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0OH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010PJ\u0015\u0010^\u001a\u00020'2\u0006\u0010.\u001a\u00020\u0013¢\u0006\u0004\b_\u0010`J\u0015\u0010a\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0013¢\u0006\u0004\bb\u00100J\u0015\u0010c\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0013¢\u0006\u0004\bd\u0010eJ\u000f\u0010t\u001a\u00020uH\u0016¢\u0006\u0004\bv\u0010wJA\u0010x\u001a\u00020y*\u00060zj\u0002`{2\u0006\u0010|\u001a\u00020\t2\u0006\u0010}\u001a\u00020\t2\u0006\u0010~\u001a\u00020\t2\u0006\u0010.\u001a\u00020u2\u0006\u0010\u007f\u001a\u00020\rH\u0002¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J!\u0010t\u001a\u00020u2\u0006\u0010.\u001a\u00020\u00132\t\b\u0002\u0010\u0082\u0001\u001a\u00020\t¢\u0006\u0005\bv\u0010\u0083\u0001J\u000f\u0010\u0084\u0001\u001a\u00020u¢\u0006\u0005\b\u0085\u0001\u0010wJ\u0015\u0010\u0086\u0001\u001a\u00020\r2\t\u0010\u0019\u001a\u0005\u0018\u00010\u0087\u0001HÖ\u0003J\n\u0010\u0088\u0001\u001a\u00020\tHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0015\u0010\b\u001a\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u00109\u001a\u00020\u00008F¢\u0006\u0006\u001a\u0004\b:\u0010\u0005R\u001a\u0010Q\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\bR\u0010S\u001a\u0004\bT\u0010\u000bR\u001a\u0010U\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\bV\u0010S\u001a\u0004\bW\u0010\u000bR\u001a\u0010X\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\bY\u0010S\u001a\u0004\bZ\u0010\u000bR\u001a\u0010[\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\\\u0010S\u001a\u0004\b]\u0010\u000bR\u0011\u0010f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bg\u0010\u0005R\u0011\u0010h\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bi\u0010\u0005R\u0011\u0010j\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bk\u0010\u0005R\u0011\u0010l\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bm\u0010\u0005R\u0011\u0010n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bo\u0010\u0005R\u0011\u0010p\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bq\u0010\u0005R\u0011\u0010r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bs\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u008a\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "value", "getValue-impl", "unitDiscriminator", "", "getUnitDiscriminator-impl", "(J)I", "isInNanos", "", "isInNanos-impl", "(J)Z", "isInMillis", "isInMillis-impl", "storageUnit", "Lkotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unaryMinus", "unaryMinus-UwyO8pc", "plus", "other", "plus-LRDsOJo", "(JJ)J", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "minus", "minus-LRDsOJo", "times", "scale", "times-UwyO8pc", "(JI)J", "", "(JD)J", "div", "div-UwyO8pc", "div-LRDsOJo", "(JJ)D", "truncateTo", "unit", "truncateTo-UwyO8pc$kotlin_stdlib", "(JLkotlin/time/DurationUnit;)J", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "isInfinite", "isInfinite-impl", "isFinite", "isFinite-impl", "absoluteValue", "getAbsoluteValue-UwyO8pc", "compareTo", "compareTo-LRDsOJo", "(JJ)I", "toComponents", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "hoursComponent", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "toDouble", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toLong", "toLong-impl", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeSeconds", "getInWholeSeconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "toIsoString", "toIsoString-impl", "equals", "", "hashCode", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
@WasExperimental(markerClass = {ExperimentalTime.class})
@SourceDebugExtension({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1059:1\n38#1:1060\n38#1:1061\n38#1:1062\n38#1:1063\n38#1:1064\n501#1:1065\n518#1:1073\n170#2,6:1066\n1#3:1072\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n*L\n39#1:1060\n40#1:1061\n275#1:1062\n295#1:1063\n479#1:1064\n728#1:1065\n819#1:1073\n770#1:1066,6\n*E\n"})
public final class Duration implements Comparable<Duration> {
    private final long rawValue;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long ZERO = m1498constructorimpl(0);
    private static final long INFINITE = DurationKt.durationOfMillis(DurationKt.MAX_MILLIS);
    private static final long NEG_INFINITE = DurationKt.durationOfMillis(-4611686018427387903L);

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0007J\u0015\u00100\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u000201¢\u0006\u0004\b2\u00103J\u0015\u00104\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u000201¢\u0006\u0004\b5\u00103J\u0015\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u000201¢\u0006\u0002\b7J\u0015\u00108\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u000201¢\u0006\u0002\b9R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u001f\u0010\u0013\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0013\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u0017\u0010\u001bR\u001f\u0010\u0013\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u001c\u001a\u0004\b\u0017\u0010\u001dR\u001f\u0010\u001e\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\u001f\u0010\u001e\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001bR\u001f\u0010\u001e\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001dR\u001f\u0010!\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0018R\u001f\u0010!\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001bR\u001f\u0010!\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001dR\u001f\u0010$\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0018R\u001f\u0010$\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001bR\u001f\u0010$\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010\u001dR\u001f\u0010'\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018R\u001f\u0010'\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u001a\u001a\u0004\b)\u0010\u001bR\u001f\u0010'\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010\u001dR\u001f\u0010*\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u0018R\u001f\u0010*\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u001a\u001a\u0004\b,\u0010\u001bR\u001f\u0010*\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u001c\u001a\u0004\b,\u0010\u001dR\u001f\u0010-\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0016\u001a\u0004\b/\u0010\u0018R\u001f\u0010-\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010\u001bR\u001f\u0010-\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u001c\u001a\u0004\b/\u0010\u001d¨\u0006:"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "<init>", "()V", "ZERO", "Lkotlin/time/Duration;", "getZERO-UwyO8pc", "()J", "J", "INFINITE", "getINFINITE-UwyO8pc", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "convert", "", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "nanoseconds", "", "getNanoseconds-UwyO8pc$annotations", "(I)V", "getNanoseconds-UwyO8pc", "(I)J", "", "(J)V", "(J)J", "(D)V", "(D)J", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "minutes", "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "days", "getDays-UwyO8pc$annotations", "getDays-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseOrNull", "parseOrNull-FghU774", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m1546getDaysUwyO8pc(int i8) {
            return DurationKt.toDuration(i8, DurationUnit.DAYS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1548getDaysUwyO8pc$annotations(double d7) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m1552getHoursUwyO8pc(int i8) {
            return DurationKt.toDuration(i8, DurationUnit.HOURS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1554getHoursUwyO8pc$annotations(double d7) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m1558getMicrosecondsUwyO8pc(int i8) {
            return DurationKt.toDuration(i8, DurationUnit.MICROSECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1560getMicrosecondsUwyO8pc$annotations(double d7) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m1564getMillisecondsUwyO8pc(int i8) {
            return DurationKt.toDuration(i8, DurationUnit.MILLISECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1566getMillisecondsUwyO8pc$annotations(double d7) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m1570getMinutesUwyO8pc(int i8) {
            return DurationKt.toDuration(i8, DurationUnit.MINUTES);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1572getMinutesUwyO8pc$annotations(double d7) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m1576getNanosecondsUwyO8pc(int i8) {
            return DurationKt.toDuration(i8, DurationUnit.NANOSECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1578getNanosecondsUwyO8pc$annotations(double d7) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m1582getSecondsUwyO8pc(int i8) {
            return DurationKt.toDuration(i8, DurationUnit.SECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1584getSecondsUwyO8pc$annotations(double d7) {
        }

        @ExperimentalTime
        public final double convert(double value, DurationUnit sourceUnit, DurationUnit targetUnit) {
            Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
            return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(value, sourceUnit, targetUnit);
        }

        /* JADX INFO: renamed from: getINFINITE-UwyO8pc, reason: not valid java name */
        public final long m1587getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        /* JADX INFO: renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m1588getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.NEG_INFINITE;
        }

        /* JADX INFO: renamed from: getZERO-UwyO8pc, reason: not valid java name */
        public final long m1589getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        /* JADX INFO: renamed from: parse-UwyO8pc, reason: not valid java name */
        public final long m1590parseUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.parseDuration(value, false);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(a.j("Invalid duration string format: '", value, "'."), e);
            }
        }

        /* JADX INFO: renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
        public final long m1591parseIsoStringUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.parseDuration(value, true);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(a.j("Invalid ISO duration string format: '", value, "'."), e);
            }
        }

        /* JADX INFO: renamed from: parseIsoStringOrNull-FghU774, reason: not valid java name */
        public final Duration m1592parseIsoStringOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return Duration.m1496boximpl(DurationKt.parseDuration(value, true));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        /* JADX INFO: renamed from: parseOrNull-FghU774, reason: not valid java name */
        public final Duration m1593parseOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return Duration.m1496boximpl(DurationKt.parseDuration(value, false));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m1547getDaysUwyO8pc(long j8) {
            return DurationKt.toDuration(j8, DurationUnit.DAYS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1549getDaysUwyO8pc$annotations(int i8) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m1553getHoursUwyO8pc(long j8) {
            return DurationKt.toDuration(j8, DurationUnit.HOURS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1555getHoursUwyO8pc$annotations(int i8) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m1559getMicrosecondsUwyO8pc(long j8) {
            return DurationKt.toDuration(j8, DurationUnit.MICROSECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1561getMicrosecondsUwyO8pc$annotations(int i8) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m1565getMillisecondsUwyO8pc(long j8) {
            return DurationKt.toDuration(j8, DurationUnit.MILLISECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1567getMillisecondsUwyO8pc$annotations(int i8) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m1571getMinutesUwyO8pc(long j8) {
            return DurationKt.toDuration(j8, DurationUnit.MINUTES);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1573getMinutesUwyO8pc$annotations(int i8) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m1577getNanosecondsUwyO8pc(long j8) {
            return DurationKt.toDuration(j8, DurationUnit.NANOSECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1579getNanosecondsUwyO8pc$annotations(int i8) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m1583getSecondsUwyO8pc(long j8) {
            return DurationKt.toDuration(j8, DurationUnit.SECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1585getSecondsUwyO8pc$annotations(int i8) {
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m1545getDaysUwyO8pc(double d7) {
            return DurationKt.toDuration(d7, DurationUnit.DAYS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1550getDaysUwyO8pc$annotations(long j8) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m1551getHoursUwyO8pc(double d7) {
            return DurationKt.toDuration(d7, DurationUnit.HOURS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1556getHoursUwyO8pc$annotations(long j8) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m1557getMicrosecondsUwyO8pc(double d7) {
            return DurationKt.toDuration(d7, DurationUnit.MICROSECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1562getMicrosecondsUwyO8pc$annotations(long j8) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m1563getMillisecondsUwyO8pc(double d7) {
            return DurationKt.toDuration(d7, DurationUnit.MILLISECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1568getMillisecondsUwyO8pc$annotations(long j8) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m1569getMinutesUwyO8pc(double d7) {
            return DurationKt.toDuration(d7, DurationUnit.MINUTES);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1574getMinutesUwyO8pc$annotations(long j8) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m1575getNanosecondsUwyO8pc(double d7) {
            return DurationKt.toDuration(d7, DurationUnit.NANOSECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1580getNanosecondsUwyO8pc$annotations(long j8) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m1581getSecondsUwyO8pc(double d7) {
            return DurationKt.toDuration(d7, DurationUnit.SECONDS);
        }

        @InlineOnly
        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1586getSecondsUwyO8pc$annotations(long j8) {
        }
    }

    private /* synthetic */ Duration(long j8) {
        this.rawValue = j8;
    }

    /* JADX INFO: renamed from: addValuesMixedRanges-UwyO8pc, reason: not valid java name */
    private static final long m1494addValuesMixedRangesUwyO8pc(long j8, long j10, long j11) {
        long jNanosToMillis = DurationKt.nanosToMillis(j11);
        long j12 = j10 + jNanosToMillis;
        if (-4611686018426L > j12 || j12 >= 4611686018427L) {
            return DurationKt.durationOfMillis(RangesKt.coerceIn(j12, -4611686018427387903L, DurationKt.MAX_MILLIS));
        }
        return DurationKt.durationOfNanos(DurationKt.millisToNanos(j12) + (j11 - DurationKt.millisToNanos(jNanosToMillis)));
    }

    /* JADX INFO: renamed from: appendFractional-impl, reason: not valid java name */
    private static final void m1495appendFractionalimpl(long j8, StringBuilder sb2, int i8, int i9, int i10, String str, boolean z2) {
        sb2.append(i8);
        if (i9 != 0) {
            sb2.append('.');
            String strPadStart = StringsKt__StringsKt.padStart(String.valueOf(i9), i10, '0');
            int i11 = -1;
            int length = strPadStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i12 = length - 1;
                    if (strPadStart.charAt(length) != '0') {
                        i11 = length;
                        break;
                    } else if (i12 < 0) {
                        break;
                    } else {
                        length = i12;
                    }
                }
            }
            int i13 = i11 + 1;
            if (z2 || i13 >= 3) {
                sb2.append((CharSequence) strPadStart, 0, ((i11 + 3) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb2, "append(...)");
            } else {
                sb2.append((CharSequence) strPadStart, 0, i13);
                Intrinsics.checkNotNullExpressionValue(sb2, "append(...)");
            }
        }
        sb2.append(str);
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Duration m1496boximpl(long j8) {
        return new Duration(j8);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1498constructorimpl(long j8) {
        if (DurationJvmKt.getDurationAssertionsEnabled()) {
            if (m1522isInNanosimpl(j8)) {
                long jM1518getValueimpl = m1518getValueimpl(j8);
                if (-4611686018426999999L > jM1518getValueimpl || jM1518getValueimpl >= 4611686018427000000L) {
                    throw new AssertionError(d.p(new StringBuilder(), m1518getValueimpl(j8), " ns is out of nanoseconds range"));
                }
            } else {
                long jM1518getValueimpl2 = m1518getValueimpl(j8);
                if (-4611686018427387903L > jM1518getValueimpl2 || jM1518getValueimpl2 >= 4611686018427387904L) {
                    throw new AssertionError(d.p(new StringBuilder(), m1518getValueimpl(j8), " ms is out of milliseconds range"));
                }
                long jM1518getValueimpl3 = m1518getValueimpl(j8);
                if (-4611686018426L <= jM1518getValueimpl3 && jM1518getValueimpl3 < 4611686018427L) {
                    throw new AssertionError(d.p(new StringBuilder(), m1518getValueimpl(j8), " ms is denormalized"));
                }
            }
        }
        return j8;
    }

    /* JADX INFO: renamed from: div-LRDsOJo, reason: not valid java name */
    public static final double m1499divLRDsOJo(long j8, long j10) {
        DurationUnit durationUnit = (DurationUnit) ComparisonsKt___ComparisonsJvmKt.maxOf(m1516getStorageUnitimpl(j8), m1516getStorageUnitimpl(j10));
        return m1534toDoubleimpl(j8, durationUnit) / m1534toDoubleimpl(j10, durationUnit);
    }

    /* JADX INFO: renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m1501divUwyO8pc(long j8, int i8) {
        if (i8 == 0) {
            if (m1525isPositiveimpl(j8)) {
                return INFINITE;
            }
            if (m1524isNegativeimpl(j8)) {
                return NEG_INFINITE;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        }
        if (m1522isInNanosimpl(j8)) {
            return DurationKt.durationOfNanos(m1518getValueimpl(j8) / ((long) i8));
        }
        if (m1523isInfiniteimpl(j8)) {
            return m1529timesUwyO8pc(j8, MathKt.getSign(i8));
        }
        long j10 = i8;
        long jM1518getValueimpl = m1518getValueimpl(j8) / j10;
        if (-4611686018426L > jM1518getValueimpl || jM1518getValueimpl >= 4611686018427L) {
            return DurationKt.durationOfMillis(jM1518getValueimpl);
        }
        return DurationKt.durationOfNanos(DurationKt.millisToNanos(jM1518getValueimpl) + (DurationKt.millisToNanos(m1518getValueimpl(j8) - (jM1518getValueimpl * j10)) / j10));
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1502equalsimpl(long j8, Object obj) {
        return (obj instanceof Duration) && j8 == ((Duration) obj).getRawValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1503equalsimpl0(long j8, long j10) {
        return j8 == j10;
    }

    /* JADX INFO: renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m1504getAbsoluteValueUwyO8pc(long j8) {
        return m1524isNegativeimpl(j8) ? m1542unaryMinusUwyO8pc(j8) : j8;
    }

    @PublishedApi
    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    /* JADX INFO: renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m1505getHoursComponentimpl(long j8) {
        if (m1523isInfiniteimpl(j8)) {
            return 0;
        }
        return (int) (m1507getInWholeHoursimpl(j8) % ((long) 24));
    }

    /* JADX INFO: renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m1506getInWholeDaysimpl(long j8) {
        return m1537toLongimpl(j8, DurationUnit.DAYS);
    }

    /* JADX INFO: renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m1507getInWholeHoursimpl(long j8) {
        return m1537toLongimpl(j8, DurationUnit.HOURS);
    }

    /* JADX INFO: renamed from: getInWholeMicroseconds-impl, reason: not valid java name */
    public static final long m1508getInWholeMicrosecondsimpl(long j8) {
        return m1537toLongimpl(j8, DurationUnit.MICROSECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m1509getInWholeMillisecondsimpl(long j8) {
        return (m1521isInMillisimpl(j8) && m1520isFiniteimpl(j8)) ? m1518getValueimpl(j8) : m1537toLongimpl(j8, DurationUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m1510getInWholeMinutesimpl(long j8) {
        return m1537toLongimpl(j8, DurationUnit.MINUTES);
    }

    /* JADX INFO: renamed from: getInWholeNanoseconds-impl, reason: not valid java name */
    public static final long m1511getInWholeNanosecondsimpl(long j8) {
        long jM1518getValueimpl = m1518getValueimpl(j8);
        if (m1522isInNanosimpl(j8)) {
            return jM1518getValueimpl;
        }
        if (jM1518getValueimpl > 9223372036854L) {
            return Long.MAX_VALUE;
        }
        if (jM1518getValueimpl < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return DurationKt.millisToNanos(jM1518getValueimpl);
    }

    /* JADX INFO: renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m1512getInWholeSecondsimpl(long j8) {
        return m1537toLongimpl(j8, DurationUnit.SECONDS);
    }

    @PublishedApi
    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    /* JADX INFO: renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m1513getMinutesComponentimpl(long j8) {
        if (m1523isInfiniteimpl(j8)) {
            return 0;
        }
        return (int) (m1510getInWholeMinutesimpl(j8) % ((long) 60));
    }

    @PublishedApi
    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    /* JADX INFO: renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m1514getNanosecondsComponentimpl(long j8) {
        if (m1523isInfiniteimpl(j8)) {
            return 0;
        }
        return (int) (m1521isInMillisimpl(j8) ? DurationKt.millisToNanos(m1518getValueimpl(j8) % ((long) 1000)) : m1518getValueimpl(j8) % ((long) 1000000000));
    }

    @PublishedApi
    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* JADX INFO: renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m1515getSecondsComponentimpl(long j8) {
        if (m1523isInfiniteimpl(j8)) {
            return 0;
        }
        return (int) (m1512getInWholeSecondsimpl(j8) % ((long) 60));
    }

    /* JADX INFO: renamed from: getStorageUnit-impl, reason: not valid java name */
    private static final DurationUnit m1516getStorageUnitimpl(long j8) {
        return m1522isInNanosimpl(j8) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    /* JADX INFO: renamed from: getUnitDiscriminator-impl, reason: not valid java name */
    private static final int m1517getUnitDiscriminatorimpl(long j8) {
        return ((int) j8) & 1;
    }

    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    private static final long m1518getValueimpl(long j8) {
        return j8 >> 1;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1519hashCodeimpl(long j8) {
        return Long.hashCode(j8);
    }

    /* JADX INFO: renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m1520isFiniteimpl(long j8) {
        return !m1523isInfiniteimpl(j8);
    }

    /* JADX INFO: renamed from: isInMillis-impl, reason: not valid java name */
    private static final boolean m1521isInMillisimpl(long j8) {
        return (((int) j8) & 1) == 1;
    }

    /* JADX INFO: renamed from: isInNanos-impl, reason: not valid java name */
    private static final boolean m1522isInNanosimpl(long j8) {
        return (((int) j8) & 1) == 0;
    }

    /* JADX INFO: renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m1523isInfiniteimpl(long j8) {
        return j8 == INFINITE || j8 == NEG_INFINITE;
    }

    /* JADX INFO: renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m1524isNegativeimpl(long j8) {
        return j8 < 0;
    }

    /* JADX INFO: renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m1525isPositiveimpl(long j8) {
        return j8 > 0;
    }

    /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
    public static final long m1526minusLRDsOJo(long j8, long j10) {
        return m1527plusLRDsOJo(j8, m1542unaryMinusUwyO8pc(j10));
    }

    /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m1527plusLRDsOJo(long j8, long j10) {
        if (m1523isInfiniteimpl(j8)) {
            if (m1520isFiniteimpl(j10) || (j10 ^ j8) >= 0) {
                return j8;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (m1523isInfiniteimpl(j10)) {
            return j10;
        }
        if ((((int) j8) & 1) != (((int) j10) & 1)) {
            return m1521isInMillisimpl(j8) ? m1494addValuesMixedRangesUwyO8pc(j8, m1518getValueimpl(j8), m1518getValueimpl(j10)) : m1494addValuesMixedRangesUwyO8pc(j8, m1518getValueimpl(j10), m1518getValueimpl(j8));
        }
        long jM1518getValueimpl = m1518getValueimpl(j8) + m1518getValueimpl(j10);
        return m1522isInNanosimpl(j8) ? DurationKt.durationOfNanosNormalized(jM1518getValueimpl) : DurationKt.durationOfMillisNormalized(jM1518getValueimpl);
    }

    /* JADX INFO: renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m1529timesUwyO8pc(long j8, int i8) {
        if (m1523isInfiniteimpl(j8)) {
            if (i8 != 0) {
                return i8 > 0 ? j8 : m1542unaryMinusUwyO8pc(j8);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (i8 == 0) {
            return ZERO;
        }
        long jM1518getValueimpl = m1518getValueimpl(j8);
        long j10 = i8;
        long j11 = jM1518getValueimpl * j10;
        if (!m1522isInNanosimpl(j8)) {
            if (j11 / j10 == jM1518getValueimpl) {
                return DurationKt.durationOfMillis(RangesKt___RangesKt.coerceIn(j11, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
            }
            return MathKt.getSign(i8) * MathKt.getSign(jM1518getValueimpl) > 0 ? INFINITE : NEG_INFINITE;
        }
        if (-2147483647L <= jM1518getValueimpl && jM1518getValueimpl < 2147483648L) {
            return DurationKt.durationOfNanos(j11);
        }
        if (j11 / j10 == jM1518getValueimpl) {
            return DurationKt.durationOfNanosNormalized(j11);
        }
        long jNanosToMillis = DurationKt.nanosToMillis(jM1518getValueimpl);
        long j12 = jNanosToMillis * j10;
        long jNanosToMillis2 = DurationKt.nanosToMillis((jM1518getValueimpl - DurationKt.millisToNanos(jNanosToMillis)) * j10) + j12;
        if (j12 / j10 != jNanosToMillis || (jNanosToMillis2 ^ j12) < 0) {
            return MathKt.getSign(i8) * MathKt.getSign(jM1518getValueimpl) > 0 ? INFINITE : NEG_INFINITE;
        }
        return DurationKt.durationOfMillis(RangesKt___RangesKt.coerceIn(jNanosToMillis2, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1533toComponentsimpl(long j8, Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m1506getInWholeDaysimpl(j8)), Integer.valueOf(m1505getHoursComponentimpl(j8)), Integer.valueOf(m1513getMinutesComponentimpl(j8)), Integer.valueOf(m1515getSecondsComponentimpl(j8)), Integer.valueOf(m1514getNanosecondsComponentimpl(j8)));
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    public static final double m1534toDoubleimpl(long j8, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j8 == INFINITE) {
            return Double.POSITIVE_INFINITY;
        }
        if (j8 == NEG_INFINITE) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m1518getValueimpl(j8), m1516getStorageUnitimpl(j8), unit);
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    public static final int m1535toIntimpl(long j8, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (int) RangesKt.coerceIn(m1537toLongimpl(j8, unit), -2147483648L, 2147483647L);
    }

    /* JADX INFO: renamed from: toIsoString-impl, reason: not valid java name */
    public static final String m1536toIsoStringimpl(long j8) {
        StringBuilder sb2 = new StringBuilder();
        if (m1524isNegativeimpl(j8)) {
            sb2.append('-');
        }
        sb2.append("PT");
        long jM1504getAbsoluteValueUwyO8pc = m1504getAbsoluteValueUwyO8pc(j8);
        long jM1507getInWholeHoursimpl = m1507getInWholeHoursimpl(jM1504getAbsoluteValueUwyO8pc);
        int iM1513getMinutesComponentimpl = m1513getMinutesComponentimpl(jM1504getAbsoluteValueUwyO8pc);
        int iM1515getSecondsComponentimpl = m1515getSecondsComponentimpl(jM1504getAbsoluteValueUwyO8pc);
        int iM1514getNanosecondsComponentimpl = m1514getNanosecondsComponentimpl(jM1504getAbsoluteValueUwyO8pc);
        if (m1523isInfiniteimpl(j8)) {
            jM1507getInWholeHoursimpl = 9999999999999L;
        }
        boolean z2 = false;
        boolean z3 = jM1507getInWholeHoursimpl != 0;
        boolean z5 = (iM1515getSecondsComponentimpl == 0 && iM1514getNanosecondsComponentimpl == 0) ? false : true;
        if (iM1513getMinutesComponentimpl != 0 || (z5 && z3)) {
            z2 = true;
        }
        if (z3) {
            sb2.append(jM1507getInWholeHoursimpl);
            sb2.append('H');
        }
        if (z2) {
            sb2.append(iM1513getMinutesComponentimpl);
            sb2.append('M');
        }
        if (z5 || (!z3 && !z2)) {
            m1495appendFractionalimpl(j8, sb2, iM1515getSecondsComponentimpl, iM1514getNanosecondsComponentimpl, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        return sb2.toString();
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    public static final long m1537toLongimpl(long j8, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j8 == INFINITE) {
            return Long.MAX_VALUE;
        }
        if (j8 == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m1518getValueimpl(j8), m1516getStorageUnitimpl(j8), unit);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1538toStringimpl(long j8) {
        if (j8 == 0) {
            return "0s";
        }
        if (j8 == INFINITE) {
            return "Infinity";
        }
        if (j8 == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean zM1524isNegativeimpl = m1524isNegativeimpl(j8);
        StringBuilder sb2 = new StringBuilder();
        if (zM1524isNegativeimpl) {
            sb2.append('-');
        }
        long jM1504getAbsoluteValueUwyO8pc = m1504getAbsoluteValueUwyO8pc(j8);
        long jM1506getInWholeDaysimpl = m1506getInWholeDaysimpl(jM1504getAbsoluteValueUwyO8pc);
        int iM1505getHoursComponentimpl = m1505getHoursComponentimpl(jM1504getAbsoluteValueUwyO8pc);
        int iM1513getMinutesComponentimpl = m1513getMinutesComponentimpl(jM1504getAbsoluteValueUwyO8pc);
        int iM1515getSecondsComponentimpl = m1515getSecondsComponentimpl(jM1504getAbsoluteValueUwyO8pc);
        int iM1514getNanosecondsComponentimpl = m1514getNanosecondsComponentimpl(jM1504getAbsoluteValueUwyO8pc);
        int i8 = 0;
        boolean z2 = jM1506getInWholeDaysimpl != 0;
        boolean z3 = iM1505getHoursComponentimpl != 0;
        boolean z5 = iM1513getMinutesComponentimpl != 0;
        boolean z10 = (iM1515getSecondsComponentimpl == 0 && iM1514getNanosecondsComponentimpl == 0) ? false : true;
        if (z2) {
            sb2.append(jM1506getInWholeDaysimpl);
            sb2.append('d');
            i8 = 1;
        }
        if (z3 || (z2 && (z5 || z10))) {
            int i9 = i8 + 1;
            if (i8 > 0) {
                sb2.append(' ');
            }
            sb2.append(iM1505getHoursComponentimpl);
            sb2.append('h');
            i8 = i9;
        }
        if (z5 || (z10 && (z3 || z2))) {
            int i10 = i8 + 1;
            if (i8 > 0) {
                sb2.append(' ');
            }
            sb2.append(iM1513getMinutesComponentimpl);
            sb2.append('m');
            i8 = i10;
        }
        if (z10) {
            int i11 = i8 + 1;
            if (i8 > 0) {
                sb2.append(' ');
            }
            if (iM1515getSecondsComponentimpl != 0 || z2 || z3 || z5) {
                m1495appendFractionalimpl(j8, sb2, iM1515getSecondsComponentimpl, iM1514getNanosecondsComponentimpl, 9, "s", false);
            } else if (iM1514getNanosecondsComponentimpl >= 1000000) {
                m1495appendFractionalimpl(j8, sb2, iM1514getNanosecondsComponentimpl / DurationKt.NANOS_IN_MILLIS, iM1514getNanosecondsComponentimpl % DurationKt.NANOS_IN_MILLIS, 6, "ms", false);
            } else if (iM1514getNanosecondsComponentimpl >= 1000) {
                m1495appendFractionalimpl(j8, sb2, iM1514getNanosecondsComponentimpl / 1000, iM1514getNanosecondsComponentimpl % 1000, 3, "us", false);
            } else {
                sb2.append(iM1514getNanosecondsComponentimpl);
                sb2.append("ns");
            }
            i8 = i11;
        }
        if (zM1524isNegativeimpl && i8 > 1) {
            sb2.insert(1, '(').append(')');
        }
        return sb2.toString();
    }

    /* JADX INFO: renamed from: toString-impl$default, reason: not valid java name */
    public static /* synthetic */ String m1540toStringimpl$default(long j8, DurationUnit durationUnit, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 0;
        }
        return m1539toStringimpl(j8, durationUnit, i8);
    }

    /* JADX INFO: renamed from: truncateTo-UwyO8pc$kotlin_stdlib, reason: not valid java name */
    public static final long m1541truncateToUwyO8pc$kotlin_stdlib(long j8, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        DurationUnit durationUnitM1516getStorageUnitimpl = m1516getStorageUnitimpl(j8);
        if (unit.compareTo(durationUnitM1516getStorageUnitimpl) <= 0 || m1523isInfiniteimpl(j8)) {
            return j8;
        }
        return DurationKt.toDuration(m1518getValueimpl(j8) - (m1518getValueimpl(j8) % DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(1L, unit, durationUnitM1516getStorageUnitimpl)), durationUnitM1516getStorageUnitimpl);
    }

    /* JADX INFO: renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m1542unaryMinusUwyO8pc(long j8) {
        return DurationKt.durationOf(-m1518getValueimpl(j8), ((int) j8) & 1);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m1543compareToLRDsOJo(duration.getRawValue());
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m1543compareToLRDsOJo(long j8) {
        return m1497compareToLRDsOJo(this.rawValue, j8);
    }

    public boolean equals(Object other) {
        return m1502equalsimpl(this.rawValue, other);
    }

    public int hashCode() {
        return m1519hashCodeimpl(this.rawValue);
    }

    public String toString() {
        return m1538toStringimpl(this.rawValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getRawValue() {
        return this.rawValue;
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m1497compareToLRDsOJo(long j8, long j10) {
        long j11 = j8 ^ j10;
        if (j11 < 0 || (((int) j11) & 1) == 0) {
            return Intrinsics.compare(j8, j10);
        }
        int i8 = (((int) j8) & 1) - (((int) j10) & 1);
        return m1524isNegativeimpl(j8) ? -i8 : i8;
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1532toComponentsimpl(long j8, Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m1507getInWholeHoursimpl(j8)), Integer.valueOf(m1513getMinutesComponentimpl(j8)), Integer.valueOf(m1515getSecondsComponentimpl(j8)), Integer.valueOf(m1514getNanosecondsComponentimpl(j8)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1531toComponentsimpl(long j8, Function3<? super Long, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m1510getInWholeMinutesimpl(j8)), Integer.valueOf(m1515getSecondsComponentimpl(j8)), Integer.valueOf(m1514getNanosecondsComponentimpl(j8)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1530toComponentsimpl(long j8, Function2<? super Long, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m1512getInWholeSecondsimpl(j8)), Integer.valueOf(m1514getNanosecondsComponentimpl(j8)));
    }

    /* JADX INFO: renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m1500divUwyO8pc(long j8, double d7) {
        int iRoundToInt = MathKt.roundToInt(d7);
        if (iRoundToInt == d7 && iRoundToInt != 0) {
            return m1501divUwyO8pc(j8, iRoundToInt);
        }
        DurationUnit durationUnitM1516getStorageUnitimpl = m1516getStorageUnitimpl(j8);
        return DurationKt.toDuration(m1534toDoubleimpl(j8, durationUnitM1516getStorageUnitimpl) / d7, durationUnitM1516getStorageUnitimpl);
    }

    /* JADX INFO: renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m1528timesUwyO8pc(long j8, double d7) {
        int iRoundToInt = MathKt.roundToInt(d7);
        if (iRoundToInt == d7) {
            return m1529timesUwyO8pc(j8, iRoundToInt);
        }
        DurationUnit durationUnitM1516getStorageUnitimpl = m1516getStorageUnitimpl(j8);
        return DurationKt.toDuration(m1534toDoubleimpl(j8, durationUnitM1516getStorageUnitimpl) * d7, durationUnitM1516getStorageUnitimpl);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static final String m1539toStringimpl(long j8, DurationUnit unit, int i8) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (i8 >= 0) {
            double dM1534toDoubleimpl = m1534toDoubleimpl(j8, unit);
            if (Double.isInfinite(dM1534toDoubleimpl)) {
                return String.valueOf(dM1534toDoubleimpl);
            }
            return DurationJvmKt.formatToExactDecimals(dM1534toDoubleimpl, RangesKt.coerceAtMost(i8, 12)) + DurationUnitKt__DurationUnitKt.shortName(unit);
        }
        throw new IllegalArgumentException(a1.a.o(i8, "decimals must be not negative, but was ").toString());
    }
}
