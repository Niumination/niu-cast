package al;

import io.netty.handler.codec.http.cookie.Cookie;
import io.netty.handler.codec.http.cookie.ServerCookieDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kn.l0;
import nm.d1;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends uk.h {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@os.l uk.d dVar) {
        super(dVar);
        l0.p(dVar, "request");
    }

    @Override // uk.h
    @os.l
    public Map<String, String> a() {
        List<String> listB = this.f16298a.b().b("Cookie");
        if (listB == null) {
            return d1.z();
        }
        HashMap map = new HashMap(listB.size());
        Iterator<String> it = listB.iterator();
        while (it.hasNext()) {
            Set<Cookie> setDecode = ServerCookieDecoder.LAX.decode(it.next());
            l0.o(setDecode, "LAX.decode(cookieHeader)");
            for (Cookie cookie : setDecode) {
                map.put(cookie.name(), cookie.value());
            }
        }
        return map;
    }
}
