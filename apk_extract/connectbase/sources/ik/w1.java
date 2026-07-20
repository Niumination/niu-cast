package ik;

import androidx.core.app.FrameMetricsAggregator;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class w1 {
    @os.l
    public static final n1 a(@os.l n1 n1Var) {
        kn.l0.p(n1Var, "builder");
        return j(new n1(null, null, 0, null, null, null, null, null, false, FrameMetricsAggregator.EVERY_DURATION, null), n1Var);
    }

    @os.l
    public static final n1 b(@os.l y1 y1Var) {
        kn.l0.p(y1Var, RtspHeaders.Values.URL);
        return k(new n1(null, null, 0, null, null, null, null, null, false, FrameMetricsAggregator.EVERY_DURATION, null), y1Var);
    }

    @os.l
    public static final n1 c(@os.l String str) {
        kn.l0.p(str, "urlString");
        return s1.j(new n1(null, null, 0, null, null, null, null, null, false, FrameMetricsAggregator.EVERY_DURATION, null), str);
    }

    @os.l
    public static final y1 d(@os.l n1 n1Var) {
        kn.l0.p(n1Var, "builder");
        return j(new n1(null, null, 0, null, null, null, null, null, false, FrameMetricsAggregator.EVERY_DURATION, null), n1Var).b();
    }

    @os.l
    public static final y1 e(@os.l String str) {
        kn.l0.p(str, "urlString");
        return c(str).b();
    }

    public static final void f(@os.l Appendable appendable, @os.l String str, @os.l b1 b1Var, boolean z10) throws IOException {
        kn.l0.p(appendable, "<this>");
        kn.l0.p(str, "encodedPath");
        kn.l0.p(b1Var, "queryParameters");
        if (!jq.e0.S1(str) && !jq.e0.s2(str, "/", false, 2, null)) {
            appendable.append(el.b0.f4502a);
        }
        appendable.append(str);
        if (!b1Var.isEmpty() || z10) {
            appendable.append("?");
        }
        t0.e(b1Var, appendable);
    }

    public static final void g(@os.l Appendable appendable, @os.l String str, @os.l c1 c1Var, boolean z10) throws IOException {
        kn.l0.p(appendable, "<this>");
        kn.l0.p(str, "encodedPath");
        kn.l0.p(c1Var, "queryParameters");
        if (!jq.e0.S1(str) && !jq.e0.s2(str, "/", false, 2, null)) {
            appendable.append(el.b0.f4502a);
        }
        appendable.append(str);
        if (!c1Var.f6088b.isEmpty() || z10) {
            appendable.append("?");
        }
        t0.f(c1Var, appendable);
    }

    @os.l
    public static final String h(@os.l y1 y1Var) throws IOException {
        kn.l0.p(y1Var, "<this>");
        StringBuilder sb2 = new StringBuilder();
        f(sb2, y1Var.f8228d, y1Var.f8229e, y1Var.f8233i);
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @os.l
    public static final String i(@os.l y1 y1Var) {
        kn.l0.p(y1Var, "<this>");
        return y1Var.f8226b + n1.e.f11184d + y1Var.q();
    }

    @os.l
    public static final n1 j(@os.l n1 n1Var, @os.l n1 n1Var2) {
        kn.l0.p(n1Var, "<this>");
        kn.l0.p(n1Var2, RtspHeaders.Values.URL);
        n1Var.t(n1Var2.f8121a);
        n1Var.q(n1Var2.f8122b);
        n1Var.f8123c = n1Var2.f8123c;
        n1Var.o(n1Var2.f8126f);
        n1Var.f8124d = n1Var2.f8124d;
        n1Var.f8125e = n1Var2.f8125e;
        fl.r1.c(n1Var.f8127g, n1Var2.f8127g);
        n1Var.f8127g.B(n1Var2.f8127g.f7945d);
        n1Var.p(n1Var2.f8128h);
        n1Var.f8129i = n1Var2.f8129i;
        return n1Var;
    }

    @os.l
    public static final n1 k(@os.l n1 n1Var, @os.l y1 y1Var) {
        kn.l0.p(n1Var, "<this>");
        kn.l0.p(y1Var, RtspHeaders.Values.URL);
        n1Var.t(y1Var.f8225a);
        n1Var.q(y1Var.f8226b);
        n1Var.f8123c = y1Var.f8227c;
        n1Var.o(y1Var.f8228d);
        n1Var.f8124d = y1Var.f8231g;
        n1Var.f8125e = y1Var.f8232h;
        n1Var.f8127g.b(y1Var.f8229e);
        n1Var.f8127g.B(y1Var.f8229e.c());
        n1Var.p(y1Var.f8230f);
        n1Var.f8129i = y1Var.f8233i;
        return n1Var;
    }
}
