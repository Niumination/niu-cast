package nk;

import java.nio.file.attribute.FileTime;
import java.time.ZonedDateTime;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    @os.l
    public static final m a(@os.l FileTime fileTime) {
        l0.p(fileTime, "lastModified");
        return new m(kl.a.b(Long.valueOf(fileTime.toMillis())));
    }

    @os.l
    public static final m b(@os.l ZonedDateTime zonedDateTime) {
        l0.p(zonedDateTime, "lastModified");
        return new m(kl.c.b(zonedDateTime));
    }
}
