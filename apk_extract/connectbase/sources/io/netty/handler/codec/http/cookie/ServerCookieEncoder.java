package io.netty.handler.codec.http.cookie;

import fl.h;
import io.netty.handler.codec.DateFormatter;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class ServerCookieEncoder extends CookieEncoder {
    public static final ServerCookieEncoder STRICT = new ServerCookieEncoder(true);
    public static final ServerCookieEncoder LAX = new ServerCookieEncoder(false);

    private ServerCookieEncoder(boolean z10) {
        super(z10);
    }

    private static List<String> dedup(List<String> list, Map<String, Integer> map) {
        boolean[] zArr = new boolean[list.size()];
        Iterator<Integer> it = map.values().iterator();
        while (it.hasNext()) {
            zArr[it.next().intValue()] = true;
        }
        ArrayList arrayList = new ArrayList(map.size());
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (zArr[i10]) {
                arrayList.add(list.get(i10));
            }
        }
        return arrayList;
    }

    public String encode(String str, String str2) {
        return encode(new DefaultCookie(str, str2));
    }

    public String encode(Cookie cookie) {
        String strName = ((Cookie) ObjectUtil.checkNotNull(cookie, "cookie")).name();
        String strValue = cookie.value() != null ? cookie.value() : "";
        validateCookie(strName, strValue);
        StringBuilder sbStringBuilder = CookieUtil.stringBuilder();
        if (cookie.wrap()) {
            CookieUtil.addQuoted(sbStringBuilder, strName, strValue);
        } else {
            CookieUtil.add(sbStringBuilder, strName, strValue);
        }
        if (cookie.maxAge() != Long.MIN_VALUE) {
            CookieUtil.add(sbStringBuilder, CookieHeaderNames.MAX_AGE, cookie.maxAge());
            Date date = new Date(System.currentTimeMillis() + (cookie.maxAge() * 1000));
            sbStringBuilder.append("Expires");
            sbStringBuilder.append(h.f6043c);
            DateFormatter.append(date, sbStringBuilder);
            sbStringBuilder.append(';');
            sbStringBuilder.append(' ');
        }
        if (cookie.path() != null) {
            CookieUtil.add(sbStringBuilder, CookieHeaderNames.PATH, cookie.path());
        }
        if (cookie.domain() != null) {
            CookieUtil.add(sbStringBuilder, CookieHeaderNames.DOMAIN, cookie.domain());
        }
        if (cookie.isSecure()) {
            CookieUtil.add(sbStringBuilder, CookieHeaderNames.SECURE);
        }
        if (cookie.isHttpOnly()) {
            CookieUtil.add(sbStringBuilder, CookieHeaderNames.HTTPONLY);
        }
        if (cookie instanceof DefaultCookie) {
            DefaultCookie defaultCookie = (DefaultCookie) cookie;
            if (defaultCookie.sameSite() != null) {
                CookieUtil.add(sbStringBuilder, CookieHeaderNames.SAMESITE, defaultCookie.sameSite().name());
            }
        }
        return CookieUtil.stripTrailingSeparator(sbStringBuilder);
    }

    public List<String> encode(Cookie... cookieArr) {
        if (((Cookie[]) ObjectUtil.checkNotNull(cookieArr, "cookies")).length == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(cookieArr.length);
        HashMap map = (!this.strict || cookieArr.length <= 1) ? null : new HashMap();
        boolean z10 = false;
        for (int i10 = 0; i10 < cookieArr.length; i10++) {
            Cookie cookie = cookieArr[i10];
            arrayList.add(encode(cookie));
            if (map != null) {
                z10 |= map.put(cookie.name(), Integer.valueOf(i10)) != null;
            }
        }
        return z10 ? dedup(arrayList, map) : arrayList;
    }

    public List<String> encode(Collection<? extends Cookie> collection) {
        if (((Collection) ObjectUtil.checkNotNull(collection, "cookies")).isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(collection.size());
        HashMap map = (!this.strict || collection.size() <= 1) ? null : new HashMap();
        boolean z10 = false;
        int i10 = 0;
        for (Cookie cookie : collection) {
            arrayList.add(encode(cookie));
            if (map != null) {
                int i11 = i10 + 1;
                z10 |= map.put(cookie.name(), Integer.valueOf(i10)) != null;
                i10 = i11;
            }
        }
        return z10 ? dedup(arrayList, map) : arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0059  */
    /* JADX WARN: Code duplicated, block: B:26:0x0078  */
    /* JADX WARN: Code duplicated, block: B:27:0x007a  */
    /* JADX WARN: Code duplicated, block: B:30:0x0081  */
    /* JADX WARN: Code duplicated, block: B:33:0x0068 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x0053 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:? A[RETURN, SYNTHETIC] */
    public List<String> encode(Iterable<? extends Cookie> iterable) {
        int i10;
        boolean z10;
        Cookie cookie;
        boolean z11;
        Iterator it = ((Iterable) ObjectUtil.checkNotNull(iterable, "cookies")).iterator();
        if (!it.hasNext()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Cookie cookie2 = (Cookie) it.next();
        HashMap map = (this.strict && it.hasNext()) ? new HashMap() : null;
        arrayList.add(encode(cookie2));
        if (map != null) {
            if (map.put(cookie2.name(), 0) != null) {
                i10 = 1;
                z10 = true;
            } else {
                i10 = 1;
            }
            while (it.hasNext()) {
                cookie = (Cookie) it.next();
                arrayList.add(encode(cookie));
                if (map != null) {
                    int i11 = i10 + 1;
                    if (map.put(cookie.name(), Integer.valueOf(i10)) != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    z10 = z11 | z10;
                    i10 = i11;
                }
            }
            if (z10) {
                return dedup(arrayList, map);
            }
            return arrayList;
        }
        i10 = 0;
        z10 = false;
        while (it.hasNext()) {
            cookie = (Cookie) it.next();
            arrayList.add(encode(cookie));
            if (map != null) {
                int i12 = i10 + 1;
                if (map.put(cookie.name(), Integer.valueOf(i10)) != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                z10 = z11 | z10;
                i10 = i12;
            }
        }
        if (z10) {
            return dedup(arrayList, map);
        }
        return arrayList;
    }
}
