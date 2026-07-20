package dr;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.transsion.infra.gateway.core.bean.GatewaySignKey;
import com.transsion.infra.gateway.core.bean.RequestBean;
import fl.c1;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import wj.v0;

/* JADX INFO: loaded from: classes3.dex */
@b.b(17)
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SSLSocketFactory f3847a;

    static {
        Pattern.compile("\\d+");
        f3847a = null;
    }

    /* JADX WARN: Code duplicated, block: B:80:0x0269  */
    public static i<String> a(String str, String str2, int i10) throws Throwable {
        HttpURLConnection httpURLConnection;
        GatewaySignKey gatewaySignKey;
        i<String> iVar;
        SSLContext sSLContextA;
        ki.d.i("Post url : " + str + "\nBody : " + str2);
        HttpURLConnection httpURLConnection2 = null;
        i<String> iVar2 = new i<>(-1, null);
        try {
            String strA = c.a();
            byte[] bArrA = new d(strA.getBytes()).a(str2);
            String str3 = Base64.encodeToString(bArrA, 2) + ks.g.f9491d + Base64.encodeToString(new li.a("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoj6/eaT17WcI4r6GJxLVIDfQkYLRLGWyObKO1kj1FS+7NvAIIhNxjNpplefKGWSLOyuKdkLlH53q+HQeyo3ngDf3IPp8evvBfWaoCk1H33q35hm+W+XKsL5bMbzZhJDVEqYpebXRqL6Cz+79xyWPEHbp1l2G5FKQ76/tKAqZ+7LNeEBhgoX1duXcAXrSR7dOP6loh2DUwagVta/o2poAVzxKQKDJeJs0+VV741yJSjjVMGWAl0enK4MA0lvtmin6LVQMgNuHL5UXmdrbsEcbiVvE7z9Ol6MGDRzxyUBufklb3Orr9tbLNydKJ0mrdHZMcg8yGpuJMMOOs+CBiqA+MQIDAQAB").g(strA), 2);
            URL url = new URL(str);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            try {
                if (httpURLConnection instanceof HttpsURLConnection) {
                    if (f3847a == null && (sSLContextA = k.a()) != null) {
                        f3847a = sSLContextA.getSocketFactory();
                    }
                    SSLSocketFactory sSLSocketFactory = f3847a;
                    if (sSLSocketFactory != null) {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(k.f3853a);
                    }
                }
                if (i10 > 0) {
                    gatewaySignKey = new GatewaySignKey(l.e().c(), 2, zh.d.HmacMD5);
                    RequestBean requestBeanBuild = new RequestBean.Builder().method(v0.f19370p).accept("*/*").contentType("application/json").url(str).key(gatewaySignKey).body(str3).build();
                    ki.d.i("Gateway requestBean : " + requestBeanBuild.toString());
                    String strA2 = yh.b.a(requestBeanBuild);
                    ki.d.i("Gateway sign : " + strA2);
                    httpURLConnection.setRequestProperty("x-tr-signature", strA2);
                } else {
                    gatewaySignKey = null;
                }
                httpURLConnection.setRequestProperty("accept", "*/*");
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str3.length()));
                httpURLConnection.setRequestProperty("appid", String.valueOf(i10));
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
                ki.d.i("url:" + url + " code:" + responseCode);
                if (responseCode == 200) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb2.append(line);
                    }
                    String string = sb2.toString();
                    if (TextUtils.equals("{}", string)) {
                        iVar = new i<>(1, null);
                    } else {
                        if (TextUtils.isEmpty(string)) {
                            iVar = new i<>(-1, null);
                        } else {
                            iVar2 = new i<>(0, string);
                        }
                        bufferedReader.close();
                        inputStream.close();
                    }
                    iVar2 = iVar;
                    bufferedReader.close();
                    inputStream.close();
                } else if ("429&503&504".contains(String.valueOf(responseCode))) {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream(), StandardCharsets.UTF_8));
                    StringBuilder sb3 = new StringBuilder();
                    while (true) {
                        String line2 = bufferedReader2.readLine();
                        if (line2 == null) {
                            break;
                        }
                        sb3.append(line2);
                    }
                    iVar2 = new i<>(4, sb3.toString());
                } else if (responseCode >= 400 && gatewaySignKey != null) {
                    ki.d.i("result from server : " + httpURLConnection.getResponseMessage());
                    InputStream errorStream = httpURLConnection.getErrorStream();
                    BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(errorStream, StandardCharsets.UTF_8));
                    StringBuilder sb4 = new StringBuilder();
                    while (true) {
                        String line3 = bufferedReader3.readLine();
                        if (line3 == null) {
                            break;
                        }
                        sb4.append(line3);
                    }
                    String string2 = sb4.toString();
                    if (yh.b.c(responseCode, string2, gatewaySignKey)) {
                        iVar2 = new i<>(3, string2);
                    }
                    bufferedReader3.close();
                    errorStream.close();
                }
            } catch (Exception e10) {
                e = e10;
                httpURLConnection2 = httpURLConnection;
                try {
                    if (e instanceof UnknownHostException) {
                        ki.d.m(e.getMessage());
                    } else {
                        ki.d.m(Log.getStackTraceString(e));
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection = httpURLConnection2;
                    }
                    return iVar2;
                } catch (Throwable th2) {
                    th = th2;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
        } catch (Throwable th4) {
            th = th4;
        }
        httpURLConnection.disconnect();
        return iVar2;
    }
}
