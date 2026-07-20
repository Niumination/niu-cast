package kotlin.math;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0006\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\b\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0019\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0018\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0010\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010#\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010$\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010%\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010%\u001a\u00020\u0001*\u00020\u00012\u0006\u0010&\u001a\u00020'H\u0087\b\u001a\u0015\u0010(\u001a\u00020\u0001*\u00020\u00012\u0006\u0010)\u001a\u00020\u0001H\u0087\b\u001a\u0015\u00101\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\u0087\b\u001a\u0015\u00101\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001f\u001a\u00020'H\u0087\b\u001a\r\u00105\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u00106\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\u0015\u00107\u001a\u00020\u0001*\u00020\u00012\u0006\u00108\u001a\u00020\u0001H\u0087\b\u001a\f\u00109\u001a\u00020'*\u00020\u0001H\u0007\u001a\f\u0010:\u001a\u00020;*\u00020\u0001H\u0007\u001a\u0011\u0010\u0000\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u0003\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u0004\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u0005\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u0006\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0019\u0010\b\u001a\u00020<2\u0006\u0010\t\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\n\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u000b\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\f\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\r\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u000e\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u000f\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0019\u0010\u0010\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<2\u0006\u0010\t\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u0011\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u0012\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u0013\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0018\u0010\u0014\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<2\u0006\u0010\u0015\u001a\u00020<H\u0007\u001a\u0011\u0010\u0016\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u0017\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0010\u0010\u0018\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0007\u001a\u0011\u0010\u0019\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u001a\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u001b\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0010\u0010\u001c\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0007\u001a\u0011\u0010\u001d\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u001e\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u001f\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0019\u0010 \u001a\u00020<2\u0006\u0010!\u001a\u00020<2\u0006\u0010\"\u001a\u00020<H\u0087\b\u001a\u0019\u0010#\u001a\u00020<2\u0006\u0010!\u001a\u00020<2\u0006\u0010\"\u001a\u00020<H\u0087\b\u001a\u0011\u0010$\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0015\u0010%\u001a\u00020<*\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0015\u0010%\u001a\u00020<*\u00020<2\u0006\u0010&\u001a\u00020'H\u0087\b\u001a\u0015\u0010(\u001a\u00020<*\u00020<2\u0006\u0010)\u001a\u00020<H\u0087\b\u001a\u0015\u00101\u001a\u00020<*\u00020<2\u0006\u0010\u001f\u001a\u00020<H\u0087\b\u001a\u0015\u00101\u001a\u00020<*\u00020<2\u0006\u0010\u001f\u001a\u00020'H\u0087\b\u001a\r\u00105\u001a\u00020<*\u00020<H\u0087\b\u001a\r\u00106\u001a\u00020<*\u00020<H\u0087\b\u001a\u0015\u00107\u001a\u00020<*\u00020<2\u0006\u00108\u001a\u00020<H\u0087\b\u001a\f\u00109\u001a\u00020'*\u00020<H\u0007\u001a\f\u0010:\u001a\u00020;*\u00020<H\u0007\u001a\u0011\u0010\u001e\u001a\u00020'2\u0006\u0010&\u001a\u00020'H\u0087\b\u001a\u0019\u0010 \u001a\u00020'2\u0006\u0010!\u001a\u00020'2\u0006\u0010\"\u001a\u00020'H\u0087\b\u001a\u0019\u0010#\u001a\u00020'2\u0006\u0010!\u001a\u00020'2\u0006\u0010\"\u001a\u00020'H\u0087\b\u001a\u0011\u0010\u001e\u001a\u00020;2\u0006\u0010&\u001a\u00020;H\u0087\b\u001a\u0019\u0010 \u001a\u00020;2\u0006\u0010!\u001a\u00020;2\u0006\u0010\"\u001a\u00020;H\u0087\b\u001a\u0019\u0010#\u001a\u00020;2\u0006\u0010!\u001a\u00020;2\u0006\u0010\"\u001a\u00020;H\u0087\b\"\u001f\u0010*\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u001f\u0010\u001f\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010,\u001a\u0004\b0\u0010.\"\u001f\u00102\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010,\u001a\u0004\b4\u0010.\"\u001f\u0010*\u001a\u00020<*\u00020<8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010=\u001a\u0004\b-\u0010>\"\u001f\u0010\u001f\u001a\u00020<*\u00020<8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010=\u001a\u0004\b0\u0010>\"\u001f\u00102\u001a\u00020<*\u00020<8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010=\u001a\u0004\b4\u0010>\"\u001f\u0010*\u001a\u00020'*\u00020'8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010?\u001a\u0004\b-\u0010@\"\u001e\u0010\u001f\u001a\u00020'*\u00020'8FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010?\u001a\u0004\b0\u0010@\"\u001f\u0010*\u001a\u00020;*\u00020;8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010A\u001a\u0004\b-\u0010B\"\u001e\u0010\u001f\u001a\u00020'*\u00020;8FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010A\u001a\u0004\b0\u0010C¨\u0006D"}, d2 = {"sin", "", "x", "cos", "tan", "asin", "acos", "atan", "atan2", "y", "sinh", "cosh", "tanh", "asinh", "acosh", "atanh", "hypot", "sqrt", "exp", "expm1", "log", "base", "ln", "log10", "log2", "ln1p", "ceil", "floor", "truncate", "round", "abs", "sign", "min", "a", "b", "max", "cbrt", "pow", "n", "", "IEEErem", "divisor", "absoluteValue", "getAbsoluteValue$annotations", "(D)V", "getAbsoluteValue", "(D)D", "getSign$annotations", "getSign", "withSign", "ulp", "getUlp$annotations", "getUlp", "nextUp", "nextDown", "nextTowards", "to", "roundToInt", "roundToLong", "", "", "(F)V", "(F)F", "(I)V", "(I)I", "(J)V", "(J)J", "(J)I", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, xs = "kotlin/math/MathKt")
public class MathKt__MathJVMKt extends MathKt__MathHKt {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double IEEErem(double d7, double d10) {
        return Math.IEEEremainder(d7, d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double abs(double d7) {
        return Math.abs(d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double acos(double d7) {
        return Math.acos(d7);
    }

    @SinceKotlin(version = "1.2")
    public static final double acosh(double d7) {
        if (d7 < 1.0d) {
            return Double.NaN;
        }
        if (d7 > Constants.upper_taylor_2_bound) {
            return Math.log(d7) + Constants.LN2;
        }
        double d10 = 1;
        double d11 = d7 - d10;
        if (d11 >= Constants.taylor_n_bound) {
            return Math.log(Math.sqrt((d7 * d7) - d10) + d7);
        }
        double dSqrt = Math.sqrt(d11);
        if (dSqrt >= Constants.taylor_2_bound) {
            dSqrt -= ((dSqrt * dSqrt) * dSqrt) / ((double) 12);
        }
        return dSqrt * Math.sqrt(2.0d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double asin(double d7) {
        return Math.asin(d7);
    }

    @SinceKotlin(version = "1.2")
    public static final double asinh(double d7) {
        double d10 = Constants.taylor_n_bound;
        if (d7 < d10) {
            if (d7 <= (-d10)) {
                return -asinh(-d7);
            }
            return Math.abs(d7) >= Constants.taylor_2_bound ? d7 - (((d7 * d7) * d7) / ((double) 6)) : d7;
        }
        if (d7 <= Constants.upper_taylor_n_bound) {
            return Math.log(Math.sqrt((d7 * d7) + ((double) 1)) + d7);
        }
        if (d7 > Constants.upper_taylor_2_bound) {
            return Math.log(d7) + Constants.LN2;
        }
        double d11 = d7 * ((double) 2);
        return Math.log((((double) 1) / d11) + d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double atan(double d7) {
        return Math.atan(d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double atan2(double d7, double d10) {
        return Math.atan2(d7, d10);
    }

    @SinceKotlin(version = "1.2")
    public static final double atanh(double d7) {
        if (Math.abs(d7) < Constants.taylor_n_bound) {
            return Math.abs(d7) > Constants.taylor_2_bound ? d7 + (((d7 * d7) * d7) / ((double) 3)) : d7;
        }
        double d10 = 1;
        return Math.log((d10 + d7) / (d10 - d7)) / ((double) 2);
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final double cbrt(double d7) {
        return Math.cbrt(d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double ceil(double d7) {
        return Math.ceil(d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double cos(double d7) {
        return Math.cos(d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double cosh(double d7) {
        return Math.cosh(d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double exp(double d7) {
        return Math.exp(d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double expm1(double d7) {
        return Math.expm1(d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double floor(double d7) {
        return Math.floor(d7);
    }

    private static final double getAbsoluteValue(double d7) {
        return Math.abs(d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(double d7) {
    }

    private static final double getSign(double d7) {
        return Math.signum(d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getSign$annotations(double d7) {
    }

    private static final double getUlp(double d7) {
        return Math.ulp(d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getUlp$annotations(double d7) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double hypot(double d7, double d10) {
        return Math.hypot(d7, d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double ln(double d7) {
        return Math.log(d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double ln1p(double d7) {
        return Math.log1p(d7);
    }

    @SinceKotlin(version = "1.2")
    public static final double log(double d7, double d10) {
        if (d10 <= 0.0d || d10 == 1.0d) {
            return Double.NaN;
        }
        return Math.log(d7) / Math.log(d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double log10(double d7) {
        return Math.log10(d7);
    }

    @SinceKotlin(version = "1.2")
    public static final double log2(double d7) {
        return Math.log(d7) / Constants.LN2;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double max(double d7, double d10) {
        return Math.max(d7, d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double min(double d7, double d10) {
        return Math.min(d7, d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double nextDown(double d7) {
        return Math.nextAfter(d7, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double nextTowards(double d7, double d10) {
        return Math.nextAfter(d7, d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double nextUp(double d7) {
        return Math.nextUp(d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double pow(double d7, double d10) {
        return Math.pow(d7, d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double round(double d7) {
        return Math.rint(d7);
    }

    @SinceKotlin(version = "1.2")
    public static int roundToInt(double d7) {
        if (Double.isNaN(d7)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d7 > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d7 < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d7);
    }

    @SinceKotlin(version = "1.2")
    public static long roundToLong(double d7) {
        if (Double.isNaN(d7)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sign(double d7) {
        return Math.signum(d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sin(double d7) {
        return Math.sin(d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sinh(double d7) {
        return Math.sinh(d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sqrt(double d7) {
        return Math.sqrt(d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double tan(double d7) {
        return Math.tan(d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double tanh(double d7) {
        return Math.tanh(d7);
    }

    @SinceKotlin(version = "1.2")
    public static final double truncate(double d7) {
        if (Double.isNaN(d7) || Double.isInfinite(d7)) {
            return d7;
        }
        return d7 > 0.0d ? Math.floor(d7) : Math.ceil(d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double withSign(double d7, double d10) {
        return Math.copySign(d7, d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float IEEErem(float f, float f4) {
        return (float) Math.IEEEremainder(f, f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float abs(float f) {
        return Math.abs(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float acos(float f) {
        return (float) Math.acos(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float asin(float f) {
        return (float) Math.asin(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float atan(float f) {
        return (float) Math.atan(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float atan2(float f, float f4) {
        return (float) Math.atan2(f, f4);
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final float cbrt(float f) {
        return (float) Math.cbrt(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float ceil(float f) {
        return (float) Math.ceil(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float cos(float f) {
        return (float) Math.cos(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float cosh(float f) {
        return (float) Math.cosh(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float exp(float f) {
        return (float) Math.exp(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float expm1(float f) {
        return (float) Math.expm1(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float floor(float f) {
        return (float) Math.floor(f);
    }

    private static final float getAbsoluteValue(float f) {
        return Math.abs(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(float f) {
    }

    private static final float getSign(float f) {
        return Math.signum(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getSign$annotations(float f) {
    }

    private static final float getUlp(float f) {
        return Math.ulp(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getUlp$annotations(float f) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float hypot(float f, float f4) {
        return (float) Math.hypot(f, f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float ln(float f) {
        return (float) Math.log(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float ln1p(float f) {
        return (float) Math.log1p(f);
    }

    @SinceKotlin(version = "1.2")
    public static final float log(float f, float f4) {
        if (f4 <= 0.0f || f4 == 1.0f) {
            return Float.NaN;
        }
        return (float) (Math.log(f) / Math.log(f4));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float log10(float f) {
        return (float) Math.log10(f);
    }

    @SinceKotlin(version = "1.2")
    public static final float log2(float f) {
        return (float) (Math.log(f) / Constants.LN2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float max(float f, float f4) {
        return Math.max(f, f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float min(float f, float f4) {
        return Math.min(f, f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float nextDown(float f) {
        return Math.nextAfter(f, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float nextTowards(float f, float f4) {
        return Math.nextAfter(f, f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float nextUp(float f) {
        return Math.nextUp(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double pow(double d7, int i8) {
        return Math.pow(d7, i8);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float round(float f) {
        return (float) Math.rint(f);
    }

    @SinceKotlin(version = "1.2")
    public static final long roundToLong(float f) {
        return roundToLong(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sign(float f) {
        return Math.signum(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sin(float f) {
        return (float) Math.sin(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sinh(float f) {
        return (float) Math.sinh(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sqrt(float f) {
        return (float) Math.sqrt(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float tan(float f) {
        return (float) Math.tan(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float tanh(float f) {
        return (float) Math.tanh(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double withSign(double d7, int i8) {
        return Math.copySign(d7, i8);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int abs(int i8) {
        return Math.abs(i8);
    }

    private static final int getAbsoluteValue(int i8) {
        return Math.abs(i8);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(int i8) {
    }

    public static int getSign(int i8) {
        return Integer.signum(i8);
    }

    @SinceKotlin(version = "1.2")
    public static /* synthetic */ void getSign$annotations(int i8) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int max(int i8, int i9) {
        return Math.max(i8, i9);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int min(int i8, int i9) {
        return Math.min(i8, i9);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float pow(float f, float f4) {
        return (float) Math.pow(f, f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float withSign(float f, float f4) {
        return Math.copySign(f, f4);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long abs(long j8) {
        return Math.abs(j8);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float atanh(float f) {
        return (float) atanh(f);
    }

    private static final long getAbsoluteValue(long j8) {
        return Math.abs(j8);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(long j8) {
    }

    public static int getSign(long j8) {
        return Long.signum(j8);
    }

    @SinceKotlin(version = "1.2")
    public static /* synthetic */ void getSign$annotations(long j8) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long max(long j8, long j10) {
        return Math.max(j8, j10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long min(long j8, long j10) {
        return Math.min(j8, j10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float pow(float f, int i8) {
        return (float) Math.pow(f, i8);
    }

    @SinceKotlin(version = "1.2")
    public static int roundToInt(float f) {
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f);
    }

    @SinceKotlin(version = "1.2")
    public static final float truncate(float f) {
        double dCeil;
        if (Float.isNaN(f) || Float.isInfinite(f)) {
            return f;
        }
        if (f > 0.0f) {
            dCeil = Math.floor(f);
        } else {
            dCeil = Math.ceil(f);
        }
        return (float) dCeil;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float withSign(float f, int i8) {
        return Math.copySign(f, i8);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float acosh(float f) {
        return (float) acosh(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float asinh(float f) {
        return (float) asinh(f);
    }
}
