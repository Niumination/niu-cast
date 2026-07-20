package k3;

import java.util.Arrays;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class i2 {
    public static final void a(gj.a aVar, gj.c cVar, String str) {
        Logger logger = gj.d.f5220i;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cVar.f);
        sb2.append(' ');
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "java.lang.String.format(format, *args)");
        sb2.append(str2);
        sb2.append(": ");
        sb2.append(aVar.f5213c);
        logger.fine(sb2.toString());
    }

    public static final String b(long j8) {
        String strP;
        if (j8 <= -999500000) {
            strP = o.d.p(new StringBuilder(), (j8 - ((long) 500000000)) / ((long) 1000000000), " s ");
        } else if (j8 <= -999500) {
            strP = o.d.p(new StringBuilder(), (j8 - ((long) 500000)) / ((long) DurationKt.NANOS_IN_MILLIS), " ms");
        } else if (j8 <= 0) {
            strP = o.d.p(new StringBuilder(), (j8 - ((long) 500)) / ((long) 1000), " µs");
        } else if (j8 < 999500) {
            strP = o.d.p(new StringBuilder(), (j8 + ((long) 500)) / ((long) 1000), " µs");
        } else {
            strP = j8 < ((long) 999500000) ? o.d.p(new StringBuilder(), (j8 + ((long) 500000)) / ((long) DurationKt.NANOS_IN_MILLIS), " ms") : o.d.p(new StringBuilder(), (j8 + ((long) 500000000)) / ((long) 1000000000), " s ");
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        return o.d.q(new Object[]{strP}, 1, "%6s", "java.lang.String.format(format, *args)");
    }
}
