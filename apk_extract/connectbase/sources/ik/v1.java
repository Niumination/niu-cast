package ik;

import androidx.core.app.FrameMetricsAggregator;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import wj.h2;

/* JADX INFO: loaded from: classes2.dex */
public final class v1 {
    @os.l
    public static final y1 a(@os.l URI uri) {
        kn.l0.p(uri, "uri");
        return b(new n1(null, null, 0, null, null, null, null, null, false, FrameMetricsAggregator.EVERY_DURATION, null), uri).b();
    }

    @os.l
    public static final n1 b(@os.l n1 n1Var, @os.l URI uri) {
        kn.l0.p(n1Var, "<this>");
        kn.l0.p(uri, "uri");
        String scheme = uri.getScheme();
        if (scheme != null) {
            n1Var.t(t1.f8189c.a(scheme));
            n1Var.f8123c = n1Var.f8121a.f8197b;
        }
        if (uri.getPort() > 0) {
            n1Var.f8123c = uri.getPort();
        } else {
            String scheme2 = uri.getScheme();
            if (kn.l0.g(scheme2, "http")) {
                n1Var.f8123c = 80;
            } else if (kn.l0.g(scheme2, h2.f18719h)) {
                n1Var.f8123c = wj.v0.f19368n;
            }
        }
        if (uri.getUserInfo() != null) {
            String userInfo = uri.getUserInfo();
            kn.l0.o(userInfo, "uri.userInfo");
            if (userInfo.length() > 0) {
                String userInfo2 = uri.getUserInfo();
                kn.l0.o(userInfo2, "uri.userInfo");
                List listR4 = jq.h0.R4(userInfo2, new String[]{":"}, false, 0, 6, null);
                n1Var.f8124d = (String) nm.h0.B2(listR4);
                n1Var.f8125e = (String) nm.h0.W2(listR4, 1);
            }
        }
        String host = uri.getHost();
        if (host != null) {
            n1Var.q(host);
        }
        String rawPath = uri.getRawPath();
        kn.l0.o(rawPath, "uri.rawPath");
        n1Var.o(rawPath);
        n1Var.f8127g.B(z1.NO_ENCODING);
        String query = uri.getQuery();
        if (query != null) {
            h1.f(n1Var.f8127g, query, 0, 0, 12, null);
        }
        String query2 = uri.getQuery();
        if (query2 != null && query2.length() == 0) {
            n1Var.f8129i = true;
        }
        String fragment = uri.getFragment();
        if (fragment != null) {
            n1Var.p(fragment);
        }
        return n1Var;
    }

    @os.l
    public static final n1 c(@os.l n1 n1Var, @os.l URL url) throws URISyntaxException {
        kn.l0.p(n1Var, "<this>");
        kn.l0.p(url, RtspHeaders.Values.URL);
        URI uri = url.toURI();
        kn.l0.o(uri, "url.toURI()");
        return b(n1Var, uri);
    }

    @os.l
    public static final URI d(@os.l y1 y1Var) {
        kn.l0.p(y1Var, "<this>");
        return new URI(y1Var.toString());
    }
}
