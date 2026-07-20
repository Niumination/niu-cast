package af;

import java.util.Locale;
import java.util.concurrent.TimeUnit;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class z4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f751c;

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(this.f750b ? System.nanoTime() - this.f751c : 0L, TimeUnit.NANOSECONDS);
    }

    public void b() {
        v8.n(!this.f750b, "This stopwatch is already running.");
        this.f750b = true;
        this.f751c = System.nanoTime();
    }

    public String toString() {
        String str;
        switch (this.f749a) {
            case 1:
                long jNanoTime = this.f750b ? System.nanoTime() - this.f751c : 0L;
                TimeUnit timeUnit = TimeUnit.DAYS;
                TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
                if (timeUnit.convert(jNanoTime, timeUnit2) <= 0) {
                    timeUnit = TimeUnit.HOURS;
                    if (timeUnit.convert(jNanoTime, timeUnit2) <= 0) {
                        timeUnit = TimeUnit.MINUTES;
                        if (timeUnit.convert(jNanoTime, timeUnit2) <= 0) {
                            timeUnit = TimeUnit.SECONDS;
                            if (timeUnit.convert(jNanoTime, timeUnit2) <= 0) {
                                timeUnit = TimeUnit.MILLISECONDS;
                                if (timeUnit.convert(jNanoTime, timeUnit2) <= 0) {
                                    timeUnit = TimeUnit.MICROSECONDS;
                                    if (timeUnit.convert(jNanoTime, timeUnit2) <= 0) {
                                        timeUnit = timeUnit2;
                                    }
                                }
                            }
                        }
                    }
                }
                double dConvert = jNanoTime / timeUnit2.convert(1L, timeUnit);
                StringBuilder sb2 = new StringBuilder();
                int i8 = h4.q.f5249a;
                sb2.append(String.format(Locale.ROOT, "%.4g", Double.valueOf(dConvert)));
                sb2.append(" ");
                switch (h4.u.f5258a[timeUnit.ordinal()]) {
                    case 1:
                        str = "ns";
                        break;
                    case 2:
                        str = "μs";
                        break;
                    case 3:
                        str = "ms";
                        break;
                    case 4:
                        str = "s";
                        break;
                    case 5:
                        str = "min";
                        break;
                    case 6:
                        str = "h";
                        break;
                    case 7:
                        str = "d";
                        break;
                    default:
                        throw new AssertionError();
                }
                sb2.append(str);
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public z4(long j8, boolean z2) {
        this.f749a = 0;
        this.f750b = z2;
        this.f751c = j8;
    }
}
