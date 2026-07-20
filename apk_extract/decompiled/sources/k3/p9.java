package k3;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.transsion.infra.gateway.core.bean.GatewayResponse;
import com.transsion.infra.gateway.core.bean.GatewaySignKey;
import com.transsion.infra.gateway.core.bean.RequestBean;
import com.transsion.infra.gateway.core.bean.TimeBean;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public abstract class p9 {
    public static String a(RequestBean requestBean) {
        String str;
        long length;
        String strA;
        long j8;
        String string;
        String string2;
        SharedPreferences sharedPreferences;
        ka.c cVar = ka.a.f6807a;
        cVar.a("requestBean" + requestBean.toString());
        if (requestBean.getMethod() == null) {
            cVar.a("request method is null");
        } else if (TextUtils.isEmpty(requestBean.getUrl())) {
            cVar.a("request url is null");
        } else {
            if (requestBean.getKey() != null && requestBean.getKey().getKey() != null) {
                ka.d dVarD = ka.d.d(ya.a());
                Context context = (Context) dVarD.f6817b;
                long j10 = -1;
                if (context != null) {
                    if (((SharedPreferences) dVarD.f6816a) == null) {
                        try {
                            sharedPreferences = context.getSharedPreferences("gateway_core", 0);
                            dVarD.f6816a = sharedPreferences;
                        } catch (Exception unused) {
                            sharedPreferences = null;
                        }
                        dVarD.f6816a = sharedPreferences;
                    }
                    SharedPreferences sharedPreferences2 = (SharedPreferences) dVarD.f6816a;
                    if (sharedPreferences2 != null) {
                        try {
                            j10 = sharedPreferences2.getLong("time_offset", 0L);
                        } catch (Exception unused2) {
                        }
                    }
                }
                long jCurrentTimeMillis = j10 + System.currentTimeMillis();
                String key = requestBean.getKey().getKey();
                String method = requestBean.getMethod();
                String accept = requestBean.getAccept();
                String contentType = requestBean.getContentType();
                String url = requestBean.getUrl();
                String body = requestBean.getBody();
                ja.a algorithm = requestBean.getKey().getAlgorithm();
                StringBuilder sb2 = new StringBuilder();
                String strEncodeToString = "";
                if (TextUtils.isEmpty(body)) {
                    str = method;
                    ka.a.f6807a.a("request body is null");
                    strA = "";
                    j8 = 0;
                } else {
                    try {
                        str = method;
                        length = body.length();
                        try {
                            System.currentTimeMillis();
                            try {
                                strA = body.length() > 102400 ? za.a(body.substring(0, 102400)) : za.a(body);
                                j8 = length;
                            } catch (Exception e) {
                                e = e;
                                length = length;
                                ka.c cVar2 = ka.a.f6807a;
                                cVar2.b(6, cVar2.f6814a.f6808a, "generateContent exception" + e.toString());
                                strA = "";
                                j8 = length;
                            }
                        } catch (Exception e4) {
                            e = e4;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        str = method;
                        length = 0;
                    }
                }
                sb2.append(str.toUpperCase());
                sb2.append("\n");
                if (accept == null) {
                    accept = "";
                }
                sb2.append(accept);
                sb2.append("\n");
                if (contentType == null) {
                    contentType = "";
                }
                sb2.append(contentType);
                sb2.append("\n");
                sb2.append(j8 == 0 ? "" : Long.valueOf(j8));
                sb2.append("\n");
                sb2.append(jCurrentTimeMillis);
                sb2.append("\n");
                if (TextUtils.isEmpty(strA)) {
                    strA = "";
                }
                sb2.append(strA);
                sb2.append("\n");
                StringBuilder sb3 = new StringBuilder();
                try {
                    URI uri = new URI(url);
                    sb3.append(uri.getPath());
                    if (!TextUtils.isEmpty(uri.getQuery())) {
                        String query = uri.getQuery();
                        HashMap map = new HashMap();
                        String[] strArrSplit = query.split("&");
                        int length2 = strArrSplit.length;
                        int i8 = 0;
                        while (i8 < length2) {
                            String str2 = strArrSplit[i8];
                            int iIndexOf = str2.indexOf("=");
                            String[] strArr = strArrSplit;
                            try {
                                map.put(URLDecoder.decode(str2.substring(0, iIndexOf), "UTF-8"), URLDecoder.decode(str2.substring(iIndexOf + 1), "UTF-8"));
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                            i8++;
                            strArrSplit = strArr;
                        }
                        try {
                            ArrayList<Map.Entry> arrayList = new ArrayList(map.entrySet());
                            Collections.sort(arrayList, new bb.o(1));
                            StringBuilder sb4 = new StringBuilder();
                            for (Map.Entry entry : arrayList) {
                                if (!"".equals(entry.getKey())) {
                                    String str3 = (String) entry.getKey();
                                    String str4 = (String) entry.getValue();
                                    sb4.append(str3);
                                    sb4.append("=");
                                    sb4.append(str4);
                                    sb4.append("&");
                                }
                            }
                            if (sb4.length() > 0) {
                                sb4.deleteCharAt(sb4.length() - 1);
                            }
                            string2 = sb4.toString();
                        } catch (Exception unused3) {
                            string2 = null;
                        }
                        if (!TextUtils.isEmpty(string2)) {
                            sb3.append("?");
                            sb3.append(string2);
                        }
                    }
                    string = sb3.toString();
                } catch (URISyntaxException e12) {
                    e12.printStackTrace();
                    string = "";
                }
                sb2.append(string);
                ka.a.f6807a.a(sb2.toString());
                String string3 = sb2.toString();
                try {
                    Mac mac = Mac.getInstance(algorithm.name());
                    mac.init(new SecretKeySpec(Base64.decode(key, 2), algorithm.name()));
                    strEncodeToString = Base64.encodeToString(mac.doFinal(string3.getBytes(Charset.forName("UTF-8"))), 2);
                } catch (Exception e13) {
                    e13.printStackTrace();
                    ka.c cVar3 = ka.a.f6807a;
                    cVar3.b(6, cVar3.f6814a.f6808a, e13);
                }
                String str5 = jCurrentTimeMillis + "|" + requestBean.getKey().getKeyVersion() + "|" + strEncodeToString;
                ka.a.f6807a.a("x-tr-signature: " + str5);
                return str5;
            }
            cVar.a("request key is null");
        }
        return null;
    }

    public static boolean b(int i8, String str, GatewaySignKey gatewaySignKey) {
        SharedPreferences sharedPreferences;
        if (i8 != 200 && !TextUtils.isEmpty(str)) {
            try {
                ka.c cVar = ka.a.f6807a;
                cVar.a("response" + str);
                GatewayResponse gatewayResponse = (GatewayResponse) yb.a(str, GatewayResponse.class);
                if ("GW.4410".equals(gatewayResponse.errorCode)) {
                    cVar.a("verify sign failed, retrying update time");
                    TimeBean timeBean = (TimeBean) yb.a(ea.a(gatewayResponse.errorMsg, gatewaySignKey.getKey()), TimeBean.class);
                    if (timeBean.time > 0) {
                        ka.d dVarD = ka.d.d(ya.a());
                        long jCurrentTimeMillis = timeBean.time - System.currentTimeMillis();
                        Context context = (Context) dVarD.f6817b;
                        if (context == null) {
                            return true;
                        }
                        if (((SharedPreferences) dVarD.f6816a) == null) {
                            try {
                                sharedPreferences = context.getSharedPreferences("gateway_core", 0);
                                dVarD.f6816a = sharedPreferences;
                            } catch (Exception unused) {
                                sharedPreferences = null;
                            }
                            dVarD.f6816a = sharedPreferences;
                        }
                        SharedPreferences sharedPreferences2 = (SharedPreferences) dVarD.f6816a;
                        if (sharedPreferences2 == null) {
                            return true;
                        }
                        try {
                            sharedPreferences2.edit().putLong("time_offset", jCurrentTimeMillis).apply();
                            return true;
                        } catch (Exception unused2) {
                            return true;
                        }
                    }
                }
            } catch (Exception e) {
                ka.c cVar2 = ka.a.f6807a;
                cVar2.b(6, cVar2.f6814a.f6808a, e);
            }
        }
        return false;
    }
}
