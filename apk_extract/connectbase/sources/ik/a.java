package ik;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final void a(@os.l c0 c0Var, @os.l LocalDateTime localDateTime) {
        kn.l0.p(c0Var, "<this>");
        kn.l0.p(localDateTime, "expires");
        j0.f8048a.getClass();
        c0Var.v(j0.C, g0.c(localDateTime));
    }

    public static final void b(@os.l c0 c0Var, @os.l ZonedDateTime zonedDateTime) {
        kn.l0.p(c0Var, "<this>");
        kn.l0.p(zonedDateTime, "dateTime");
        j0.f8048a.getClass();
        c0Var.v(j0.O, g0.c(zonedDateTime));
    }
}
