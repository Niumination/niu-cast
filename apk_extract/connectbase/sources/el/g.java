package el;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    @os.m
    public static final TemporalAmount a(@os.l a aVar) {
        l0.p(aVar, "<this>");
        return Duration.ofSeconds(aVar.f4492a);
    }

    @lm.k(message = "Use maxAgeInSeconds or maxAgeDuration instead.")
    public static /* synthetic */ void b(a aVar) {
    }

    public static final void c(@os.l a aVar, @os.m TemporalAmount temporalAmount) {
        long millis;
        l0.p(aVar, "<this>");
        if (temporalAmount == null) {
            millis = 0;
        } else {
            millis = temporalAmount instanceof Duration ? ((Duration) temporalAmount).toMillis() / 1000 : temporalAmount.get(ChronoUnit.SECONDS);
        }
        aVar.n(millis);
    }
}
