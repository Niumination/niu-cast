package ik;

import androidx.core.app.FrameMetricsAggregator;
import java.net.URI;

/* JADX INFO: loaded from: classes2.dex */
public final class o1 {
    @os.m
    public static final String a(@os.l n1.a aVar) {
        kn.l0.p(aVar, "<this>");
        return null;
    }

    @os.l
    public static final y1 b(@os.l y1.a aVar, @os.l String str) {
        kn.l0.p(aVar, "<this>");
        kn.l0.p(str, "fullUrl");
        n1 n1Var = new n1(null, null, 0, null, null, null, null, null, false, FrameMetricsAggregator.EVERY_DURATION, null);
        v1.b(n1Var, new URI(str));
        return n1Var.b();
    }
}
