package ik;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final ZoneId f7979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final DateTimeFormatter f7980b;

    static {
        ZoneId zoneIdOf = ZoneId.of("GMT");
        kn.l0.o(zoneIdOf, "of(\"GMT\")");
        f7979a = zoneIdOf;
        DateTimeFormatter dateTimeFormatterWithZone = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z").withLocale(Locale.US).withZone(zoneIdOf);
        kn.l0.m(dateTimeFormatterWithZone);
        f7980b = dateTimeFormatterWithZone;
    }

    @lm.k(message = "This will be removed in future releases. Using it in 2.0.0 will be an error.", replaceWith = @lm.a1(expression = "ZonedDateTime.parse(this, httpDateFormat)", imports = {"java.time.ZonedDateTime"}))
    @os.l
    public static final ZonedDateTime a(@os.l String str) {
        kn.l0.p(str, "<this>");
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(str, f7980b);
        kn.l0.o(zonedDateTime, "parse(this, httpDateFormat)");
        return zonedDateTime;
    }

    @os.l
    public static final DateTimeFormatter b() {
        return f7980b;
    }

    @os.l
    public static final String c(@os.l Temporal temporal) {
        kn.l0.p(temporal, "<this>");
        String str = f7980b.format(temporal);
        kn.l0.o(str, "httpDateFormat.format(this)");
        return str;
    }
}
