package fl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final ZoneId f6028a;

    static {
        ZoneId zoneIdOf = ZoneId.of("GMT");
        kn.l0.o(zoneIdOf, "of(\"GMT\")");
        f6028a = zoneIdOf;
    }

    @os.l
    public static final ZoneId a() {
        return f6028a;
    }

    @t0
    public static /* synthetic */ void b() {
    }

    @t0
    @os.l
    public static final LocalDateTime c(@os.l Date date) {
        kn.l0.p(date, "<this>");
        LocalDateTime localDateTimeOfInstant = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        kn.l0.o(localDateTimeOfInstant, "ofInstant(toInstant(), ZoneId.systemDefault())");
        return localDateTimeOfInstant;
    }

    @t0
    @os.l
    public static final ZonedDateTime d(@os.l Date date) {
        kn.l0.p(date, "<this>");
        ZonedDateTime zonedDateTimeOfInstant = ZonedDateTime.ofInstant(date.toInstant(), f6028a);
        kn.l0.o(zonedDateTimeOfInstant, "ofInstant(toInstant(), GreenwichMeanTime)");
        return zonedDateTimeOfInstant;
    }
}
