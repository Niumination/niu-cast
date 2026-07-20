package m3;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import com.transsion.message.bank.MessageBank;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import k3.dd;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SSLSocketFactory f7650a;

    public static ef.o a(String str, byte[] bArr, int i8, List list, String str2, String str3) throws Throwable {
        SSLContext sSLContextA;
        y6.b bVar = new y6.b("sdk_error");
        ef.o oVar = new ef.o(2, bVar);
        HttpURLConnection httpURLConnection = null;
        y6.g gVar = null;
        httpURLConnection = null;
        try {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    if (httpURLConnection2 instanceof HttpsURLConnection) {
                        if (f7650a == null && (sSLContextA = v6.a.a()) != null) {
                            f7650a = sSLContextA.getSocketFactory();
                        }
                        SSLSocketFactory sSLSocketFactory = f7650a;
                        if (sSLSocketFactory != null) {
                            ((HttpsURLConnection) httpURLConnection2).setSSLSocketFactory(sSLSocketFactory);
                            ((HttpsURLConnection) httpURLConnection2).setHostnameVerifier(v6.a.f10526a);
                        }
                    }
                    httpURLConnection2.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
                    httpURLConnection2.setConnectTimeout(30000);
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setInstanceFollowRedirects(true);
                    byte[] bArrJ = bArr;
                    if (bArrJ.length > 2048) {
                        httpURLConnection2.setRequestProperty("Accept-Encoding", "gzip, deflate");
                        httpURLConnection2.setRequestProperty("zip", "1");
                        bArrJ = dd.j(bArr);
                    } else {
                        httpURLConnection2.setRequestProperty("Accept-Encoding", "text/example");
                        httpURLConnection2.setRequestProperty("zip", "0");
                    }
                    httpURLConnection2.setRequestProperty("fixed", "1");
                    httpURLConnection2.setRequestProperty("count", String.valueOf(list.size()));
                    httpURLConnection2.setRequestProperty("appids", dd.b("_", list));
                    httpURLConnection2.setRequestProperty("ver", "3.1.1.0");
                    httpURLConnection2.setRequestProperty("uuid", str2);
                    httpURLConnection2.setRequestProperty("dupid", str3);
                    Pair pairI = m6.a.f().f7948a.i();
                    byte[] bArr2 = (byte[]) pairI.second;
                    if (bArr2 != null) {
                        gVar = new y6.g(bArr2);
                    }
                    if (gVar == null) {
                        bVar.f11085d = "encrypt error";
                        httpURLConnection2.disconnect();
                        return oVar;
                    }
                    byte[] bytes = Base64.encodeToString(gVar.f(bArrJ), 2).getBytes();
                    if (bytes == null) {
                        z6.a.c("requestByPost buffer is null");
                        bVar.f11085d = "base64 error";
                        httpURLConnection2.disconnect();
                        return oVar;
                    }
                    httpURLConnection2.setRequestProperty("encrypt-level", ExifInterface.GPS_MEASUREMENT_3D);
                    httpURLConnection2.setRequestProperty("encrypt-index", String.valueOf(((Integer) pairI.first).intValue() + 1));
                    httpURLConnection2.connect();
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                    dataOutputStream.write(bytes);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    if (httpURLConnection2.getResponseCode() != 200) {
                        ef.o oVar2 = new ef.o(-1, new y6.b("rc_" + dd.a(httpURLConnection2.getErrorStream())));
                        httpURLConnection2.disconnect();
                        return oVar2;
                    }
                    String strA = dd.a(httpURLConnection2.getInputStream());
                    if (TextUtils.isEmpty(strA)) {
                        ef.o oVar3 = new ef.o(-1, new y6.b("rc_" + i8));
                        httpURLConnection2.disconnect();
                        return oVar3;
                    }
                    JSONObject jSONObject = new JSONObject(strA);
                    int iOptInt = jSONObject.optInt("code");
                    String strOptString = jSONObject.optString(MessageBank.KEY_MESSAGE, "");
                    y6.b bVar2 = new y6.b();
                    bVar2.f11082a = iOptInt;
                    bVar2.f11083b = strOptString;
                    if (iOptInt != 0) {
                        bVar2.f11085d = "rc_" + iOptInt;
                        ef.o oVar4 = new ef.o(-1, bVar2);
                        httpURLConnection2.disconnect();
                        return oVar4;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app");
                    if (jSONObjectOptJSONObject != null) {
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            long j8 = jSONObjectOptJSONObject.getJSONObject(next).getLong("ver");
                            int i9 = jSONObjectOptJSONObject.getJSONObject(next).getInt(MessageBank.KEY_TYPE);
                            if (i9 != 0) {
                                int i10 = Integer.parseInt(next);
                                y6.a aVar = new y6.a();
                                aVar.f11079a = i10;
                                aVar.f11080b = i9;
                                aVar.f11081c = j8;
                                if (bVar2.f11084c == null) {
                                    bVar2.f11084c = new ArrayList();
                                }
                                bVar2.f11084c.add(aVar);
                            }
                        }
                    }
                    ef.o oVar5 = new ef.o(0, bVar2);
                    httpURLConnection2.disconnect();
                    return oVar5;
                } catch (Exception e) {
                    e = e;
                    httpURLConnection = httpURLConnection2;
                    z6.a.c(e.getMessage());
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return new ef.o(-1, new y6.b());
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
