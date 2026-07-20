package com.transsion.core.utils;

import java.net.URLDecoder;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes2.dex */
public class UrlEncodeUtil {
    private static String TAG = "UrlEncodeUtil";

    public static String toURLDecoded(String str) {
        if (str != null && !str.equals("")) {
            try {
                return URLDecoder.decode(new String(str.getBytes(), "UTF-8"), "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String toURLEncoded(String str) {
        if (str != null && !str.equals("")) {
            try {
                return URLEncoder.encode(new String(str.getBytes(), "UTF-8"), "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
