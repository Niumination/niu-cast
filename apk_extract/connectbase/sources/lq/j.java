package lq;

import java.util.concurrent.TimeUnit;
import kn.l0;
import lm.f1;
import lm.i0;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
public class j {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10260a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f10260a = iArr;
        }
    }

    @f1(version = "1.3")
    public static final double a(double d10, @os.l h hVar, @os.l h hVar2) {
        l0.p(hVar, "sourceUnit");
        l0.p(hVar2, "targetUnit");
        long jConvert = hVar2.getTimeUnit$kotlin_stdlib().convert(1L, hVar.getTimeUnit$kotlin_stdlib());
        return jConvert > 0 ? d10 * jConvert : d10 / hVar.getTimeUnit$kotlin_stdlib().convert(1L, hVar2.getTimeUnit$kotlin_stdlib());
    }

    @f1(version = "1.5")
    public static final long b(long j10, @os.l h hVar, @os.l h hVar2) {
        l0.p(hVar, "sourceUnit");
        l0.p(hVar2, "targetUnit");
        return hVar2.getTimeUnit$kotlin_stdlib().convert(j10, hVar.getTimeUnit$kotlin_stdlib());
    }

    @f1(version = "1.5")
    public static final long c(long j10, @os.l h hVar, @os.l h hVar2) {
        l0.p(hVar, "sourceUnit");
        l0.p(hVar2, "targetUnit");
        return hVar2.getTimeUnit$kotlin_stdlib().convert(j10, hVar.getTimeUnit$kotlin_stdlib());
    }

    @f1(version = "1.8")
    @p2(markerClass = {l.class})
    @os.l
    public static final h d(@os.l TimeUnit timeUnit) {
        l0.p(timeUnit, "<this>");
        switch (a.f10260a[timeUnit.ordinal()]) {
            case 1:
                return h.NANOSECONDS;
            case 2:
                return h.MICROSECONDS;
            case 3:
                return h.MILLISECONDS;
            case 4:
                return h.SECONDS;
            case 5:
                return h.MINUTES;
            case 6:
                return h.HOURS;
            case 7:
                return h.DAYS;
            default:
                throw new i0();
        }
    }

    @f1(version = "1.8")
    @p2(markerClass = {l.class})
    @os.l
    public static final TimeUnit e(@os.l h hVar) {
        l0.p(hVar, "<this>");
        return hVar.getTimeUnit$kotlin_stdlib();
    }
}
