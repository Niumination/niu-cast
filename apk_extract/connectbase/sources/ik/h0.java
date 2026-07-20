package ik;

import java.time.ZonedDateTime;
import java.time.temporal.Temporal;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 {
    @in.i(name = "fromHttpDateString")
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ ZonedDateTime a(String str) {
        kn.l0.p(str, "<this>");
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(str, g0.b());
        kn.l0.o(zonedDateTime, "parse(this, httpDateFormat)");
        return zonedDateTime;
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static /* synthetic */ void c() {
    }

    @lm.k(message = "This will be removed in future releases.", replaceWith = @lm.a1(expression = "GMTDate(this).toHttpDate()", imports = {"io.ktor.util.date.GMTDate"}))
    @os.l
    public static final String d(long j10) {
        return r.e(kl.a.b(Long.valueOf(j10)));
    }

    @in.i(name = "toHttpDateString")
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ String e(Temporal temporal) {
        kn.l0.p(temporal, "<this>");
        return g0.c(temporal);
    }
}
