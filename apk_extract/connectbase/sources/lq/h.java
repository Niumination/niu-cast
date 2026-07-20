package lq;

import java.util.concurrent.TimeUnit;
import lm.f1;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.6")
@p2(markerClass = {l.class})
public enum h {
    NANOSECONDS(TimeUnit.NANOSECONDS),
    MICROSECONDS(TimeUnit.MICROSECONDS),
    MILLISECONDS(TimeUnit.MILLISECONDS),
    SECONDS(TimeUnit.SECONDS),
    MINUTES(TimeUnit.MINUTES),
    HOURS(TimeUnit.HOURS),
    DAYS(TimeUnit.DAYS);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ym.a f10259b = ym.c.c(a());

    @os.l
    private final TimeUnit timeUnit;

    h(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    @os.l
    public static ym.a<h> getEntries() {
        return f10259b;
    }

    @os.l
    public final TimeUnit getTimeUnit$kotlin_stdlib() {
        return this.timeUnit;
    }
}
