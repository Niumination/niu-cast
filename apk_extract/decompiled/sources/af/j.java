package af;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f338c = Logger.getLogger(j.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f340b;

    public j(long j8) {
        AtomicLong atomicLong = new AtomicLong();
        this.f340b = atomicLong;
        v8.c("value must be positive", j8 > 0);
        this.f339a = "keepalive time nanos";
        atomicLong.set(j8);
    }
}
