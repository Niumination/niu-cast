package sj;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.transsion.infra.gateway.core.bean.GatewaySignKey;
import com.transsion.infra.gateway.core.bean.RequestBean;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import k3.ld;
import k3.p9;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SSLSocketFactory f10139a;

    static {
        Pattern.compile("\\d+");
        f10139a = null;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02a3 A[Catch: all -> 0x02ab, TryCatch #7 {all -> 0x02ab, blocks: (B:98:0x029f, B:100:0x02a3, B:103:0x02ad), top: B:118:0x029f }] */
    /* JADX WARN: Code duplicated, block: B:103:0x02ad A[Catch: all -> 0x02ab, TRY_LEAVE, TryCatch #7 {all -> 0x02ab, blocks: (B:98:0x029f, B:100:0x02a3, B:103:0x02ad), top: B:118:0x029f }] */
    /* JADX WARN: Code duplicated, block: B:105:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:109:0x02bd  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [eg.a] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static eg.a a(int i8, String str, String str2) {
        eg.a aVar;
        ?? aVar2;
        HttpURLConnection httpURLConnection;
        byte[] bArrDoFinal;
        eg.a aVar3;
        eg.a aVar4;
        GatewaySignKey gatewaySignKey;
        eg.a aVar5;
        eg.a aVar6;
        SSLContext sSLContextA;
        ad.c.g("Post url : " + str + "\nBody : " + str2);
        HttpURLConnection httpURLConnection2 = null;
        eg.a aVar7 = new eg.a(-1, null);
        try {
            String strA = ld.a();
            try {
                try {
                    Cipher cipher = (Cipher) new o5.c(strA.getBytes()).f8405a;
                    if (cipher != null) {
                        try {
                            bArrDoFinal = cipher.doFinal(str2.getBytes("UTF-8"));
                        } catch (Exception e) {
                            ad.c.h(Log.getStackTraceString(e));
                            bArrDoFinal = null;
                        }
                    } else {
                        bArrDoFinal = null;
                    }
                    try {
                        byte[] bArrDecode = Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoj6/eaT17WcI4r6GJxLVIDfQkYLRLGWyObKO1kj1FS+7NvAIIhNxjNpplefKGWSLOyuKdkLlH53q+HQeyo3ngDf3IPp8evvBfWaoCk1H33q35hm+W+XKsL5bMbzZhJDVEqYpebXRqL6Cz+79xyWPEHbp1l2G5FKQ76/tKAqZ+7LNeEBhgoX1duXcAXrSR7dOP6loh2DUwagVta/o2poAVzxKQKDJeJs0+VV741yJSjjVMGWAl0enK4MA0lvtmin6LVQMgNuHL5UXmdrbsEcbiVvE7z9Ol6MGDRzxyUBufklb3Orr9tbLNydKJ0mrdHZMcg8yGpuJMMOOs+CBiqA+MQIDAQAB", 2);
                        byte[] bytes = strA.getBytes(Charset.forName("UTF-8"));
                        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArrDecode));
                        Cipher cipher2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                        cipher2.init(1, publicKeyGeneratePublic);
                        String str3 = Base64.encodeToString(bArrDoFinal, 2) + "," + Base64.encodeToString(cipher2.doFinal(bytes), 2);
                        URL url = new URL(str);
                        httpURLConnection = (HttpURLConnection) url.openConnection();
                        try {
                            try {
                                if (httpURLConnection instanceof HttpsURLConnection) {
                                    if (f10139a == null && (sSLContextA = e.a()) != null) {
                                        f10139a = sSLContextA.getSocketFactory();
                                    }
                                    SSLSocketFactory sSLSocketFactory = f10139a;
                                    if (sSLSocketFactory != null) {
                                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(e.f10143a);
                                    }
                                }
                                if (i8 > 0) {
                                    eg.a aVar8 = aVar7;
                                    try {
                                        gatewaySignKey = new GatewaySignKey("76iRl07s0xSN9jqmEWAt79EBJZulIQIsV64FZr2O", 2, ja.a.HmacMD5);
                                        RequestBean requestBeanBuild = new RequestBean.Builder().method("POST").accept("*/*").contentType("application/json").url(str).key(gatewaySignKey).body(str3).build();
                                        StringBuilder sb2 = new StringBuilder("Gateway requestBean : ");
                                        sb2.append(requestBeanBuild.toString());
                                        ad.c.g(sb2.toString());
                                        String strA2 = p9.a(requestBeanBuild);
                                        ad.c.g("Gateway sign : " + strA2);
                                        httpURLConnection.setRequestProperty("x-tr-signature", strA2);
                                        aVar2 = sb2;
                                        aVar4 = aVar8;
                                    } catch (Exception e4) {
                                        e = e4;
                                        aVar3 = aVar8;
                                        httpURLConnection2 = httpURLConnection;
                                        aVar = aVar3;
                                        aVar2 = aVar;
                                        try {
                                            if (e instanceof UnknownHostException) {
                                                ad.c.h(e.getMessage());
                                            } else {
                                                ad.c.h(Log.getStackTraceString(e));
                                            }
                                            if (httpURLConnection2 != null) {
                                                httpURLConnection = httpURLConnection2;
                                                httpURLConnection.disconnect();
                                            }
                                            return aVar2;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (httpURLConnection2 != null) {
                                                httpURLConnection2.disconnect();
                                            }
                                            throw th;
                                        }
                                    }
                                } else {
                                    aVar4 = aVar7;
                                    gatewaySignKey = null;
                                    aVar2 = aVar7;
                                }
                                httpURLConnection.setRequestProperty("accept", "*/*");
                                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str3.length()));
                                httpURLConnection.setRequestProperty("appid", String.valueOf(i8));
                                httpURLConnection.setRequestMethod("POST");
                                httpURLConnection.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
                                httpURLConnection.setConnectTimeout(30000);
                                httpURLConnection.setDoInput(true);
                                httpURLConnection.setDoOutput(true);
                                PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
                                printWriter.write(str3);
                                printWriter.flush();
                                printWriter.close();
                                int responseCode = httpURLConnection.getResponseCode();
                                ad.c.g("url:" + url + " code:" + responseCode);
                                try {
                                    if (responseCode != 200) {
                                        if ("429&503&504".contains(String.valueOf(responseCode))) {
                                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream(), StandardCharsets.UTF_8));
                                            StringBuilder sb3 = new StringBuilder();
                                            while (true) {
                                                String line = bufferedReader.readLine();
                                                if (line == null) {
                                                    break;
                                                }
                                                sb3.append(line);
                                            }
                                            aVar2 = new eg.a(4, sb3.toString());
                                        } else if (responseCode < 400 || gatewaySignKey == null) {
                                            aVar2 = aVar4;
                                        } else {
                                            ad.c.g("result from server : " + httpURLConnection.getResponseMessage());
                                            InputStream errorStream = httpURLConnection.getErrorStream();
                                            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(errorStream, StandardCharsets.UTF_8));
                                            StringBuilder sb4 = new StringBuilder();
                                            while (true) {
                                                String line2 = bufferedReader2.readLine();
                                                if (line2 == null) {
                                                    break;
                                                }
                                                sb4.append(line2);
                                            }
                                            String string = sb4.toString();
                                            eg.a aVar9 = p9.b(responseCode, string, gatewaySignKey) ? new eg.a(3, string) : aVar4;
                                            bufferedReader2.close();
                                            errorStream.close();
                                            aVar2 = aVar9;
                                        }
                                        httpURLConnection.disconnect();
                                        return aVar2;
                                    }
                                    InputStream inputStream = httpURLConnection.getInputStream();
                                    BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
                                    StringBuilder sb5 = new StringBuilder();
                                    while (true) {
                                        String line3 = bufferedReader3.readLine();
                                        if (line3 == null) {
                                            break;
                                        }
                                        sb5.append(line3);
                                    }
                                    String string2 = sb5.toString();
                                    if (TextUtils.equals("{}", string2)) {
                                        aVar6 = new eg.a(1, null);
                                    } else {
                                        if (TextUtils.isEmpty(string2)) {
                                            aVar6 = new eg.a(-1, null);
                                        } else {
                                            aVar5 = new eg.a(0, string2);
                                        }
                                        bufferedReader3.close();
                                        inputStream.close();
                                        aVar2 = aVar5;
                                    }
                                    aVar5 = aVar6;
                                    bufferedReader3.close();
                                    inputStream.close();
                                    aVar2 = aVar5;
                                } catch (Exception e10) {
                                    e = e10;
                                    httpURLConnection2 = httpURLConnection;
                                    aVar2 = aVar2;
                                    if (e instanceof UnknownHostException) {
                                        ad.c.h(e.getMessage());
                                    } else {
                                        ad.c.h(Log.getStackTraceString(e));
                                    }
                                    if (httpURLConnection2 != null) {
                                        httpURLConnection = httpURLConnection2;
                                    }
                                    return aVar2;
                                }
                            } catch (Exception e11) {
                                e = e11;
                                aVar3 = aVar7;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            httpURLConnection2 = httpURLConnection;
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            throw th;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        aVar = aVar7;
                        httpURLConnection2 = null;
                        aVar2 = aVar;
                        if (e instanceof UnknownHostException) {
                            ad.c.h(e.getMessage());
                        } else {
                            ad.c.h(Log.getStackTraceString(e));
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection = httpURLConnection2;
                            httpURLConnection.disconnect();
                        }
                        return aVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        httpURLConnection2 = null;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e13) {
                    e = e13;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Exception e14) {
            e = e14;
            aVar = aVar7;
        } catch (Throwable th6) {
            th = th6;
        }
        httpURLConnection.disconnect();
        return aVar2;
    }
}
