package kl;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    @l
    public static final d a(@l Instant instant) {
        l0.p(instant, "<this>");
        return a.b(Long.valueOf(TimeUnit.SECONDS.toMillis(instant.atZone(ZoneOffset.UTC).toEpochSecond())));
    }

    @l
    public static final d b(@l ZonedDateTime zonedDateTime) {
        l0.p(zonedDateTime, "<this>");
        Instant instant = zonedDateTime.toInstant();
        l0.o(instant, "toInstant()");
        return a(instant);
    }
}
