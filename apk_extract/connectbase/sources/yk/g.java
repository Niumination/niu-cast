package yk;

import java.util.concurrent.TimeUnit;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final void a(@os.l a aVar, long j10, long j11, @os.l TimeUnit timeUnit) {
        l0.p(aVar, "<this>");
        l0.p(timeUnit, "timeUnit");
        aVar.d(timeUnit.toMillis(j10), timeUnit.toMillis(j11));
    }
}
