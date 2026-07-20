package zh;

import android.text.TextUtils;
import com.transsion.infra.gateway.core.bean.RequestBean;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f21928a;

    public class a implements Comparator<Map.Entry<String, String>> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, String> o10, Map.Entry<String, String> o11) {
            return o10.getKey().compareTo(o11.getKey());
        }
    }

    public c(e signer) {
        this.f21928a = signer;
    }

    public static String b(RequestBean requestBean) {
        if (requestBean == null) {
            ai.c.f217a.k("request bean is null");
            return null;
        }
        if (requestBean.getMethod() == null) {
            ai.c.f217a.k("request method is null");
            return null;
        }
        if (TextUtils.isEmpty(requestBean.getUrl())) {
            ai.c.f217a.k("request url is null");
            return null;
        }
        if (requestBean.getKey() == null) {
            ai.c.f217a.k("request key is null");
            return null;
        }
        if (requestBean.getKey().getKey() == null) {
            ai.c.f217a.k("request key is null");
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() + ai.e.a(ai.a.a()).c("time_offset");
        String str = jCurrentTimeMillis + "|" + requestBean.getKey().getKeyVersion() + "|" + new c(new zh.a(requestBean.getKey().getKey())).e(requestBean.getMethod(), requestBean.getAccept(), requestBean.getContentType(), requestBean.getUrl(), requestBean.getBody(), jCurrentTimeMillis, requestBean.getKey().getAlgorithm());
        ai.c.f217a.k("x-tr-signature: " + str);
        return str;
    }

    public final String a(String url) {
        StringBuilder sb2 = new StringBuilder();
        try {
            URI uri = new URI(url);
            sb2.append(uri.getPath());
            if (!TextUtils.isEmpty(uri.getQuery())) {
                String strF = f(uri.getQuery());
                if (!TextUtils.isEmpty(strF)) {
                    sb2.append("?");
                    sb2.append(strF);
                }
            }
            return sb2.toString();
        } catch (URISyntaxException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public final String c(Map<String, String> paraMap) {
        try {
            ArrayList<Map.Entry> arrayList = new ArrayList(paraMap.entrySet());
            Collections.sort(arrayList, new a());
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry entry : arrayList) {
                if (!"".equals(entry.getKey())) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    sb2.append(str);
                    sb2.append("=");
                    sb2.append(str2);
                    sb2.append("&");
                }
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            return sb2.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public final String d(String method, String accept, String contentType, String url, String body, long timeStamp) {
        long length;
        String strD;
        StringBuilder sb2 = new StringBuilder();
        if (TextUtils.isEmpty(body)) {
            ai.c.f217a.k("request body is null");
            strD = "";
            length = 0;
        } else {
            try {
                length = body.length();
                try {
                    System.currentTimeMillis();
                    strD = body.length() > 102400 ? ai.b.d(body.substring(0, 102400)) : ai.b.d(body);
                } catch (Exception e10) {
                    e = e10;
                    ai.c.f217a.m("generateContent exception" + e.toString());
                    strD = "";
                }
            } catch (Exception e11) {
                e = e11;
                length = 0;
            }
        }
        sb2.append(method.toUpperCase());
        sb2.append("\n");
        sb2.append(accept == null ? "" : accept);
        sb2.append("\n");
        sb2.append(contentType == null ? "" : contentType);
        sb2.append("\n");
        sb2.append(length == 0 ? "" : Long.valueOf(length));
        sb2.append("\n");
        sb2.append(timeStamp);
        sb2.append("\n");
        sb2.append(TextUtils.isEmpty(strD) ? "" : strD);
        sb2.append("\n");
        sb2.append(a(url));
        ai.c.f217a.k(sb2.toString());
        return sb2.toString();
    }

    public String e(String method, String accept, String contentType, String url, String body, long timeStamp, d algorithm) {
        return this.f21928a.a(algorithm, d(method, accept, contentType, url, body, timeStamp));
    }

    public final String f(String queryString) {
        HashMap map = new HashMap();
        for (String str : queryString.split("&")) {
            int iIndexOf = str.indexOf("=");
            try {
                map.put(URLDecoder.decode(str.substring(0, iIndexOf), "UTF-8"), URLDecoder.decode(str.substring(iIndexOf + 1), "UTF-8"));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return c(map);
    }
}
