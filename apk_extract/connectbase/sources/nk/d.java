package nk;

import java.time.ZonedDateTime;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    @os.l
    public static final c a(@os.m ik.d dVar, @os.l ZonedDateTime zonedDateTime) {
        l0.p(zonedDateTime, "expires");
        return new c(dVar, kl.c.b(zonedDateTime));
    }

    public static /* synthetic */ c b(ik.d dVar, ZonedDateTime zonedDateTime, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dVar = null;
        }
        return a(dVar, zonedDateTime);
    }
}
