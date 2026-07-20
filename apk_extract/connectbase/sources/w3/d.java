package w3;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import fl.c1;
import ik.y0;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.crypto.KeyGenerator;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;
import w4.o1;
import wj.v0;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SSLSocketFactory f17914a;

    public static q3.c a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new q3.c(bArr);
    }

    public static l<a> b(long j10, byte[] bArr, int i10, s3.c cVar) throws Throwable {
        SSLContext sSLContextA;
        l<a> lVar = new l<>(2, new a("sdk_error"));
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                URL url = new URL(l6.c.d(cVar.f14952a, true));
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    if (httpURLConnection2 instanceof HttpsURLConnection) {
                        if (f17914a == null && (sSLContextA = v3.a.a()) != null) {
                            f17914a = sSLContextA.getSocketFactory();
                        }
                        SSLSocketFactory sSLSocketFactory = f17914a;
                        if (sSLSocketFactory != null) {
                            ((HttpsURLConnection) httpURLConnection2).setSSLSocketFactory(sSLSocketFactory);
                            ((HttpsURLConnection) httpURLConnection2).setHostnameVerifier(v3.a.f16502a);
                        }
                    }
                    httpURLConnection2.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
                    httpURLConnection2.setConnectTimeout(c1.f6021c);
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setRequestMethod(v0.f19370p);
                    httpURLConnection2.setInstanceFollowRedirects(true);
                    byte[] bArrN = bArr;
                    if (cVar.f14954c * va.q.f16820o <= bArrN.length) {
                        httpURLConnection2.setRequestProperty("Accept-Encoding", "gzip, deflate");
                        httpURLConnection2.setRequestProperty("zip", "1");
                        bArrN = s3.e.n(bArr);
                    } else {
                        httpURLConnection2.setRequestProperty("Accept-Encoding", "text/example");
                        httpURLConnection2.setRequestProperty("zip", hi.b.f7118g);
                    }
                    httpURLConnection2.setRequestProperty("fixed", "1");
                    httpURLConnection2.setRequestProperty("record-id", j10 + "");
                    httpURLConnection2.setRequestProperty("count", i10 + "");
                    httpURLConnection2.setRequestProperty("ver", "3.1.1.1-sys");
                    s3.a aVarM = n3.b.l().m(j10);
                    if (aVarM == null) {
                        y3.b.b("requestByPost TidConfigBean " + j10 + " is missing, maybe cancelled");
                        lVar.f17929b.f17907d = "tid not found";
                        httpURLConnection2.disconnect();
                        return lVar;
                    }
                    aVarM.f().getClass();
                    q3.c cVarA = a((byte[]) cVar.f14953b.second);
                    if (cVarA == null) {
                        lVar.f17929b.f17907d = "encrypt error";
                        httpURLConnection2.disconnect();
                        return lVar;
                    }
                    byte[] bytes = Base64.encodeToString(cVarA.c(bArrN), 2).getBytes();
                    if (bytes == null) {
                        y3.b.d("requestByPost buffer is null");
                        lVar.f17929b.f17907d = "base64 error";
                        httpURLConnection2.disconnect();
                        return lVar;
                    }
                    String strF = s3.e.f(bytes);
                    if (TextUtils.isEmpty(strF)) {
                        httpURLConnection2.setRequestProperty("md5", "error");
                    } else {
                        httpURLConnection2.setRequestProperty("md5", strF);
                    }
                    httpURLConnection2.setRequestProperty("encrypt-level", String.valueOf(3));
                    httpURLConnection2.setRequestProperty("encrypt-index", String.valueOf(((Integer) cVar.f14953b.first).intValue() + 1));
                    y3.b.f(url + " tid = " + j10 + " count = " + i10);
                    httpURLConnection2.connect();
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                    dataOutputStream.write(bytes);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    if (httpURLConnection2.getResponseCode() != 200) {
                        l<a> lVar2 = new l<>(-1, new a("rc_" + s3.e.d(httpURLConnection2.getErrorStream())));
                        httpURLConnection2.disconnect();
                        return lVar2;
                    }
                    String strD = s3.e.d(httpURLConnection2.getInputStream());
                    y3.b.f(String.format(Locale.ENGLISH, "post tid: %s response: %s", Long.valueOf(j10), strD));
                    if (TextUtils.isEmpty(strD)) {
                        l<a> lVar3 = new l<>(-1, new a("rc_" + i10));
                        httpURLConnection2.disconnect();
                        return lVar3;
                    }
                    int iOptInt = new JSONObject(strD).optInt("code");
                    if (iOptInt == 0) {
                        l<a> lVar4 = new l<>(0, new a());
                        httpURLConnection2.disconnect();
                        return lVar4;
                    }
                    l<a> lVar5 = new l<>(-1, new a("rc_" + iOptInt));
                    httpURLConnection2.disconnect();
                    return lVar5;
                } catch (Exception e10) {
                    e = e10;
                    httpURLConnection = httpURLConnection2;
                    if (e instanceof UnknownHostException) {
                        y3.b.d(e.getMessage());
                    } else {
                        y3.b.d(Log.getStackTraceString(e));
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return new l<>(-1, new a());
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x008e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.net.HttpURLConnection] */
    public static l<Long> c(String str) throws Throwable {
        Throwable th2;
        ?? r10;
        Exception e10;
        HttpURLConnection httpURLConnection;
        SSLContext sSLContextA;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    if (httpURLConnection instanceof HttpsURLConnection) {
                        if (f17914a == null && (sSLContextA = v3.a.a()) != null) {
                            f17914a = sSLContextA.getSocketFactory();
                        }
                        SSLSocketFactory sSLSocketFactory = f17914a;
                        if (sSLSocketFactory != null) {
                            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(v3.a.f16502a);
                        }
                    }
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setConnectTimeout(10000);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode >= 200 && responseCode < 400) {
                        l<Long> lVar = new l<>(0, Long.valueOf(httpURLConnection.getDate()));
                        httpURLConnection.disconnect();
                        return lVar;
                    }
                } catch (Exception e11) {
                    e10 = e11;
                    if (e10 instanceof UnknownHostException) {
                        y3.b.d(e10.getMessage());
                    } else {
                        y3.b.d(Log.getStackTraceString(e10));
                    }
                    if (httpURLConnection != null) {
                    }
                    return new l<>(-1, 0L);
                }
            } catch (Throwable th3) {
                th2 = th3;
                r10 = str;
                if (r10 != 0) {
                    r10.disconnect();
                }
                throw th2;
            }
        } catch (Exception e12) {
            e10 = e12;
            httpURLConnection = null;
        } catch (Throwable th4) {
            th2 = th4;
            r10 = 0;
            if (r10 != 0) {
                r10.disconnect();
            }
            throw th2;
        }
        httpURLConnection.disconnect();
        return new l<>(-1, 0L);
    }

    public static l<String> d(String str, String str2, long j10) throws Throwable {
        l<String> lVar;
        HttpURLConnection httpURLConnection;
        SSLContext sSLContextA;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(128);
                String strO = s3.e.o(keyGenerator.generateKey().getEncoded());
                q3.c cVar = new q3.c(strO.getBytes());
                byte[] bArrA = cVar.a(str2);
                String str3 = Base64.encodeToString(bArrA, 2) + ks.g.f9491d + Base64.encodeToString(new li.a("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArNrm4jErOdstd1P5L1X/\nCGSS6NKf4glPrFbTM97aE9ZKGUiMALIV8W7FClAgLZdtTZkL5XEQdbX4RB/C6edc\nnN2ifla6sVu23y78FMiL6smp9ayE7Y3gSEfB3md4nvEUpyRUu4wYLIf9nVR36okK\nGCerxYdLtDbJ69Rux4lgE5C9a6qLfV6BzjJYONk/vQhGQYT6qes+TFtXV0hvF8UM\nDG+0GfA3MiQue/Ny8uIPBykDPS1dcIADzVos2fXs/o2aFTrkdVjiX8irwYBze69K\nzFx18H12iZ9gG1VztMbHetvImBoXeCOwjTc5RnGIz+Hya96pxJLK2DcSlAaHEs1H\nOQIDAQAB").g(strO), 2);
                URL url = new URL(l6.c.d(str, true));
                httpURLConnection = (HttpURLConnection) url.openConnection();
                try {
                    try {
                        if (httpURLConnection instanceof HttpsURLConnection) {
                            if (f17914a == null && (sSLContextA = v3.a.a()) != null) {
                                f17914a = sSLContextA.getSocketFactory();
                            }
                            SSLSocketFactory sSLSocketFactory = f17914a;
                            if (sSLSocketFactory != null) {
                                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(v3.a.f16502a);
                            }
                        }
                        httpURLConnection.setRequestProperty("accept", "*/*");
                        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str3.length()));
                        httpURLConnection.setRequestProperty("encrypt-level", o1.H);
                        httpURLConnection.setRequestProperty("ver", String.valueOf(j10));
                        httpURLConnection.setRequestProperty("vn", "1");
                        httpURLConnection.setRequestMethod(v0.f19370p);
                        httpURLConnection.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
                        httpURLConnection.setConnectTimeout(c1.f6021c);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);
                        PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
                        printWriter.write(str3);
                        printWriter.flush();
                        printWriter.close();
                        int responseCode = httpURLConnection.getResponseCode();
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(RtspHeaders.Values.URL, url);
                            jSONObject.put("params", str2);
                            jSONObject.put(lb.f.f9782f, j10);
                            jSONObject.put("code", responseCode);
                            y3.b.g("--> request config:%s", jSONObject.toString());
                        } catch (Exception e10) {
                            y3.b.e("print request config exception:%s", e10.getMessage());
                        }
                        if (responseCode == 200) {
                            String strD = s3.e.d(httpURLConnection.getInputStream());
                            if (TextUtils.equals("{}", strD)) {
                                lVar = new l<>(1, null);
                            } else if (TextUtils.isEmpty(strD)) {
                                lVar = new l<>(-1, null);
                            } else {
                                lVar = new l<>(0, str.contains("secret") ? new String(cVar.b(Base64.decode(strD, 2)), StandardCharsets.UTF_8) : new String(s3.e.q(cVar.b(Base64.decode(strD, 2))), StandardCharsets.UTF_8));
                            }
                        } else {
                            lVar = new l<>(-1, s3.e.d(httpURLConnection.getErrorStream()));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection2 = httpURLConnection;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                    httpURLConnection2 = httpURLConnection;
                    l<String> lVar2 = new l<>(-1, e.getMessage());
                    if (httpURLConnection2 == null) {
                        return lVar2;
                    }
                    lVar = lVar2;
                    httpURLConnection = httpURLConnection2;
                }
            } catch (Exception e12) {
                e = e12;
            }
            httpURLConnection.disconnect();
            return lVar;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static l<String> e(String str, String str2, long j10, int i10) throws Throwable {
        l<String> lVar;
        SSLContext sSLContextA;
        HttpURLConnection httpURLConnection = null;
        l<String> lVar2 = new l<>(-1, null);
        try {
            try {
                URL url = new URL(l6.c.d(str, true));
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    try {
                        if (httpURLConnection2 instanceof HttpsURLConnection) {
                            if (f17914a == null && (sSLContextA = v3.a.a()) != null) {
                                f17914a = sSLContextA.getSocketFactory();
                            }
                            SSLSocketFactory sSLSocketFactory = f17914a;
                            if (sSLSocketFactory != null) {
                                ((HttpsURLConnection) httpURLConnection2).setSSLSocketFactory(sSLSocketFactory);
                                ((HttpsURLConnection) httpURLConnection2).setHostnameVerifier(v3.a.f16502a);
                            }
                        }
                        byte[] bytes = str2.getBytes();
                        Pair<Integer, byte[]> pairU = n3.b.l().u();
                        q3.c cVarA = a((byte[]) pairU.second);
                        if (cVarA == null) {
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            return lVar2;
                        }
                        byte[] bytes2 = Base64.encodeToString(cVarA.c(bytes), 2).getBytes();
                        httpURLConnection2.setRequestProperty("index", String.valueOf(((Integer) pairU.first).intValue() + 1));
                        httpURLConnection2.setRequestProperty("accept", "*/*");
                        httpURLConnection2.setRequestProperty("Content-Length", String.valueOf(bytes2.length));
                        httpURLConnection2.setRequestProperty("ver", String.valueOf(j10));
                        httpURLConnection2.setRequestProperty("vn", "1");
                        httpURLConnection2.setRequestProperty("app", String.valueOf(i10));
                        httpURLConnection2.setRequestProperty("model", Build.MODEL);
                        httpURLConnection2.setRequestMethod(v0.f19370p);
                        httpURLConnection2.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
                        httpURLConnection2.setConnectTimeout(c1.f6021c);
                        httpURLConnection2.setDoInput(true);
                        httpURLConnection2.setDoOutput(true);
                        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                        dataOutputStream.write(bytes2);
                        dataOutputStream.flush();
                        dataOutputStream.close();
                        int responseCode = httpURLConnection2.getResponseCode();
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(RtspHeaders.Values.URL, url);
                            jSONObject.put("params", str2);
                            jSONObject.put(lb.f.f9782f, j10);
                            jSONObject.put("code", responseCode);
                            y3.b.g("--> request config:%s", jSONObject.toString());
                        } catch (Exception e10) {
                            y3.b.e("print request config exception:%s", e10.getMessage());
                        }
                        if (responseCode == 200) {
                            String strD = s3.e.d(httpURLConnection2.getInputStream());
                            if (TextUtils.equals("{}", strD)) {
                                lVar = new l<>(1, null);
                            } else {
                                lVar = TextUtils.isEmpty(strD) ? new l<>(-1, null) : new l<>(0, new String(s3.e.q(Base64.decode(strD, 2)), StandardCharsets.UTF_8));
                            }
                        } else {
                            lVar = new l<>(-1, s3.e.d(httpURLConnection2.getErrorStream()));
                        }
                        httpURLConnection2.disconnect();
                        return lVar;
                    } catch (Exception e11) {
                        e = e11;
                        httpURLConnection = httpURLConnection2;
                        l<String> lVar3 = new l<>(-1, e.getMessage());
                        if (httpURLConnection == null) {
                            return lVar3;
                        }
                        lVar = lVar3;
                        httpURLConnection2 = httpURLConnection;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e12) {
                e = e12;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static l<a> f(String str, byte[] bArr, int i10, List<Integer> list, String str2, String str3) throws Throwable {
        SSLContext sSLContextA;
        l<a> lVar = new l<>(2, new a("sdk_error"));
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    if (httpURLConnection2 instanceof HttpsURLConnection) {
                        if (f17914a == null && (sSLContextA = v3.a.a()) != null) {
                            f17914a = sSLContextA.getSocketFactory();
                        }
                        SSLSocketFactory sSLSocketFactory = f17914a;
                        if (sSLSocketFactory != null) {
                            ((HttpsURLConnection) httpURLConnection2).setSSLSocketFactory(sSLSocketFactory);
                            ((HttpsURLConnection) httpURLConnection2).setHostnameVerifier(v3.a.f16502a);
                        }
                    }
                    httpURLConnection2.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
                    httpURLConnection2.setConnectTimeout(c1.f6021c);
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setRequestMethod(v0.f19370p);
                    httpURLConnection2.setInstanceFollowRedirects(true);
                    byte[] bArrN = bArr;
                    if (bArrN.length > 2048) {
                        httpURLConnection2.setRequestProperty("Accept-Encoding", "gzip, deflate");
                        httpURLConnection2.setRequestProperty("zip", "1");
                        bArrN = s3.e.n(bArr);
                    } else {
                        httpURLConnection2.setRequestProperty("Accept-Encoding", "text/example");
                        httpURLConnection2.setRequestProperty("zip", hi.b.f7118g);
                    }
                    httpURLConnection2.setRequestProperty("fixed", "1");
                    httpURLConnection2.setRequestProperty("count", String.valueOf(list.size()));
                    httpURLConnection2.setRequestProperty("appids", s3.e.e(list, "_"));
                    httpURLConnection2.setRequestProperty("ver", "3.1.1.1-sys");
                    httpURLConnection2.setRequestProperty("uuid", str2);
                    httpURLConnection2.setRequestProperty("dupid", str3);
                    Pair<Integer, byte[]> pairU = n3.b.l().u();
                    q3.c cVarA = a((byte[]) pairU.second);
                    if (cVarA == null) {
                        lVar.f17929b.f17907d = "encrypt error";
                        httpURLConnection2.disconnect();
                        return lVar;
                    }
                    byte[] bytes = Base64.encodeToString(cVarA.c(bArrN), 2).getBytes();
                    if (bytes == null) {
                        y3.b.d("requestByPost buffer is null");
                        lVar.f17929b.f17907d = "base64 error";
                        httpURLConnection2.disconnect();
                        return lVar;
                    }
                    httpURLConnection2.setRequestProperty("encrypt-level", o1.I);
                    httpURLConnection2.setRequestProperty("encrypt-index", String.valueOf(((Integer) pairU.first).intValue() + 1));
                    httpURLConnection2.connect();
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                    dataOutputStream.write(bytes);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    if (httpURLConnection2.getResponseCode() != 200) {
                        l<a> lVar2 = new l<>(-1, new a("rc_" + s3.e.d(httpURLConnection2.getErrorStream())));
                        httpURLConnection2.disconnect();
                        return lVar2;
                    }
                    String strD = s3.e.d(httpURLConnection2.getInputStream());
                    if (TextUtils.isEmpty(strD)) {
                        l<a> lVar3 = new l<>(-1, new a("rc_" + i10));
                        httpURLConnection2.disconnect();
                        return lVar3;
                    }
                    JSONObject jSONObject = new JSONObject(strD);
                    int iOptInt = jSONObject.optInt("code");
                    String strOptString = jSONObject.optString("message", "");
                    a aVar = new a();
                    aVar.f17904a = iOptInt;
                    aVar.f17905b = strOptString;
                    if (iOptInt != 0) {
                        aVar.f17907d = "rc_" + iOptInt;
                        l<a> lVar4 = new l<>(-1, aVar);
                        httpURLConnection2.disconnect();
                        return lVar4;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app");
                    if (jSONObjectOptJSONObject != null) {
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            long j10 = jSONObjectOptJSONObject.getJSONObject(next).getLong("ver");
                            int i11 = jSONObjectOptJSONObject.getJSONObject(next).getInt(y0.a.f8215h);
                            if (i11 != 0) {
                                a.C0466a c0466a = new a.C0466a(Integer.parseInt(next), i11, j10);
                                if (aVar.f17906c == null) {
                                    aVar.f17906c = new ArrayList();
                                }
                                aVar.f17906c.add(c0466a);
                            }
                        }
                    }
                    l<a> lVar5 = new l<>(0, aVar);
                    httpURLConnection2.disconnect();
                    return lVar5;
                } catch (Exception e10) {
                    e = e10;
                    httpURLConnection = httpURLConnection2;
                    y3.b.d(e.getMessage());
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return new l<>(-1, new a());
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
