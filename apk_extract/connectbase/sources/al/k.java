package al;

import ik.j0;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;
import java.util.List;
import jq.h0;
import kn.l0;
import nm.y;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final String f347a = "chunked";

    public static final boolean a(@os.l List<String> list) {
        int i10;
        l0.p(list, "<this>");
        int i11 = 0;
        for (Object obj : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                y.Z();
            }
            String str = (String) obj;
            int iP3 = h0.p3(str, "chunked", 0, false, 6, null);
            if (iP3 != -1 && ((iP3 <= 0 || b(str.charAt(iP3 - 1))) && (((i10 = iP3 + 7) >= str.length() || b(str.charAt(i10))) && (i11 != y.J(list) || i10 < str.length())))) {
                return false;
            }
            i11 = i12;
        }
        return true;
    }

    public static final boolean b(char c10) {
        return c10 == ' ' || c10 == ',';
    }

    public static final boolean c(@os.l HttpRequest httpRequest) {
        l0.p(httpRequest, "<this>");
        if (httpRequest.decoderResult().isFailure()) {
            return false;
        }
        HttpHeaders httpHeadersHeaders = httpRequest.headers();
        j0.f8048a.getClass();
        List<String> all = httpHeadersHeaders.getAll(j0.f8095x0);
        return all == null || a(all);
    }
}
