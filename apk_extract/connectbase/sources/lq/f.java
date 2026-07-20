package lq;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import kn.l0;
import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nDurationJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DurationJvm.kt\nkotlin/time/DurationJvmKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,33:1\n1#2:34\n*E\n"})
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f10252a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final ThreadLocal<DecimalFormat>[] f10253b;

    static {
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i10 = 0; i10 < 4; i10++) {
            threadLocalArr[i10] = new ThreadLocal<>();
        }
        f10253b = threadLocalArr;
    }

    public static final DecimalFormat a(int i10) {
        DecimalFormat decimalFormat = new DecimalFormat(hi.b.f7118g);
        if (i10 > 0) {
            decimalFormat.setMinimumFractionDigits(i10);
        }
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }

    @os.l
    public static final String b(double d10, int i10) {
        DecimalFormat decimalFormatA;
        ThreadLocal<DecimalFormat>[] threadLocalArr = f10253b;
        if (i10 < threadLocalArr.length) {
            ThreadLocal<DecimalFormat> threadLocal = threadLocalArr[i10];
            DecimalFormat decimalFormatA2 = threadLocal.get();
            if (decimalFormatA2 == null) {
                decimalFormatA2 = a(i10);
                threadLocal.set(decimalFormatA2);
            } else {
                l0.m(decimalFormatA2);
            }
            decimalFormatA = decimalFormatA2;
        } else {
            decimalFormatA = a(i10);
        }
        String str = decimalFormatA.format(d10);
        l0.o(str, "format(...)");
        return str;
    }

    @os.l
    public static final String c(double d10, int i10) {
        DecimalFormat decimalFormatA = a(0);
        decimalFormatA.setMaximumFractionDigits(i10);
        String str = decimalFormatA.format(d10);
        l0.o(str, "format(...)");
        return str;
    }

    public static final boolean d() {
        return f10252a;
    }
}
