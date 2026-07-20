package gk;

import java.time.Duration;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 {
    @os.l
    public static final Duration a(@os.l d.a aVar) {
        kn.l0.p(aVar, "<this>");
        Duration durationOfSeconds = Duration.ofSeconds(aVar.f6572h);
        kn.l0.o(durationOfSeconds, "ofSeconds(maxAgeInSeconds)");
        return durationOfSeconds;
    }

    @os.l
    public static final Duration b(@os.l i0.a aVar) {
        kn.l0.p(aVar, "<this>");
        Duration durationOfSeconds = Duration.ofSeconds(aVar.f6649c);
        kn.l0.o(durationOfSeconds, "ofSeconds(maxAgeInSeconds)");
        return durationOfSeconds;
    }

    @lm.k(message = "Use maxAgeInSeconds or maxAgeDuration instead.")
    public static /* synthetic */ void c(d.a aVar) {
    }

    @lm.k(message = "Use maxAgeInSeconds or maxAgeDuration instead.")
    public static /* synthetic */ void d(i0.a aVar) {
    }

    public static final void e(@os.l d.a aVar, @os.l Duration duration) {
        kn.l0.p(aVar, "<this>");
        kn.l0.p(duration, "newMaxAge");
        aVar.F(duration.toMillis() / ((long) 1000));
    }

    public static final void f(@os.l i0.a aVar, @os.l Duration duration) {
        kn.l0.p(aVar, "<this>");
        kn.l0.p(duration, "newMaxAge");
        aVar.i(duration.toMillis() / ((long) 1000));
    }
}
