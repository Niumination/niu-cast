package mq;

import an.f;
import in.i;
import java.time.Duration;
import kn.l0;
import kn.r1;
import lm.f1;
import lm.p2;
import lq.e;
import lq.g;
import lq.h;
import lq.l;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nDurationConversions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DurationConversions.kt\nkotlin/time/jdk8/DurationConversionsJDK8Kt\n+ 2 Duration.kt\nkotlin/time/Duration\n*L\n1#1,33:1\n731#2,2:34\n*S KotlinDebug\n*F\n+ 1 DurationConversions.kt\nkotlin/time/jdk8/DurationConversionsJDK8Kt\n*L\n33#1:34,2\n*E\n"})
@i(name = "DurationConversionsJDK8Kt")
public final class a {
    @f1(version = "1.6")
    @f
    @p2(markerClass = {l.class})
    public static final Duration a(long j10) {
        Duration durationOfSeconds = Duration.ofSeconds(e.Q(j10), e.U(j10));
        l0.o(durationOfSeconds, "toComponents-impl(...)");
        return durationOfSeconds;
    }

    @f1(version = "1.6")
    @f
    @p2(markerClass = {l.class})
    public static final long b(Duration duration) {
        l0.p(duration, "<this>");
        return e.i0(g.n0(duration.getSeconds(), h.SECONDS), g.m0(duration.getNano(), h.NANOSECONDS));
    }
}
