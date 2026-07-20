package f6;

import java.net.URLDecoder;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f5902a = "UrlEncodeUtil";

    public static String a(String str) {
        if (str != null && !str.equals("")) {
            try {
                return URLDecoder.decode(new String(str.getBytes(), "UTF-8"), "UTF-8");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return "";
    }

    public static String b(String str) {
        if (str != null && !str.equals("")) {
            try {
                return URLEncoder.encode(new String(str.getBytes(), "UTF-8"), "UTF-8");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return "";
    }
}
