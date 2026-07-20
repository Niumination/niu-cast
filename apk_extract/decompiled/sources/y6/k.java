package y6;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import ef.o;
import java.io.DataOutputStream;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import k3.dd;
import m3.d0;
import m3.g0;
import org.json.JSONObject;
import tj.w;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f11107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f11108d;
    public final a7.a e;

    public k(long j8, File file, a7.a aVar) {
        this.f11107c = j8;
        this.f11108d = file;
        this.e = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:97:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:99:0x02c7  */
    @Override // y6.d
    public final void a() throws Throwable {
        String strM;
        int length;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        o oVar;
        SSLContext sSLContextA;
        long j8 = this.f11107c;
        File file = this.f11108d;
        if (file.exists() && file.isFile() && file.getName().contains("upload")) {
            try {
                strM = !file.exists() ? "" : new w(file.getPath(), 15).m();
            } catch (Exception unused) {
            }
            length = strM.split("\n").length;
        } else {
            strM = null;
            length = 0;
        }
        if (TextUtils.isEmpty(strM) || length <= 0) {
            return;
        }
        byte[] bytes = strM.getBytes();
        a7.a aVar = this.e;
        b bVar = new b("sdk_error");
        o oVar2 = new o(2, bVar);
        try {
            try {
                URL url = new URL(f8.c.a(aVar.f40a, true));
                httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    if (httpURLConnection2 instanceof HttpsURLConnection) {
                        if (d0.f7650a == null && (sSLContextA = v6.a.a()) != null) {
                            d0.f7650a = sSLContextA.getSocketFactory();
                        }
                        SSLSocketFactory sSLSocketFactory = d0.f7650a;
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
                    if (aVar.f41b * 1024 <= bytes.length) {
                        httpURLConnection2.setRequestProperty("Accept-Encoding", "gzip, deflate");
                        httpURLConnection2.setRequestProperty("zip", "1");
                        bytes = dd.j(bytes);
                    } else {
                        httpURLConnection2.setRequestProperty("Accept-Encoding", "text/example");
                        httpURLConnection2.setRequestProperty("zip", "0");
                    }
                    httpURLConnection2.setRequestProperty("fixed", "1");
                    httpURLConnection2.setRequestProperty("record-id", j8 + "");
                    httpURLConnection2.setRequestProperty("count", length + "");
                    httpURLConnection2.setRequestProperty("ver", "3.1.1.0");
                    s6.a aVarE = m6.a.f().e(j8);
                    if (aVarE == null) {
                        z6.a.a("requestByPost TidConfigBean " + j8 + " is missing, maybe cancelled");
                        bVar.f11085d = "tid not found";
                        httpURLConnection2.disconnect();
                    } else {
                        aVarE.f9515c.getClass();
                        byte[] bArr = (byte[]) ((Pair) aVar.f42c).second;
                        g gVar = bArr == null ? null : new g(bArr);
                        if (gVar != null) {
                            byte[] bytes2 = Base64.encodeToString(gVar.f(bytes), 2).getBytes();
                            if (bytes2 == null) {
                                z6.a.c("requestByPost buffer is null");
                                bVar.f11085d = "base64 error";
                                httpURLConnection2.disconnect();
                            } else {
                                String strC = dd.c(bytes2);
                                if (TextUtils.isEmpty(strC)) {
                                    httpURLConnection2.setRequestProperty("md5", "error");
                                } else {
                                    httpURLConnection2.setRequestProperty("md5", strC);
                                }
                                httpURLConnection2.setRequestProperty("encrypt-level", String.valueOf(3));
                                httpURLConnection2.setRequestProperty("encrypt-index", String.valueOf(((Integer) ((Pair) aVar.f42c).first).intValue() + 1));
                                z6.a.e(url + " tid = " + j8 + " count = " + length);
                                httpURLConnection2.connect();
                                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                                dataOutputStream.write(bytes2);
                                dataOutputStream.flush();
                                dataOutputStream.close();
                                if (httpURLConnection2.getResponseCode() == 200) {
                                    String strA = dd.a(httpURLConnection2.getInputStream());
                                    Locale locale = Locale.ENGLISH;
                                    z6.a.e("post tid: " + j8 + " response: " + strA);
                                    if (TextUtils.isEmpty(strA)) {
                                        oVar = new o(-1, new b("rc_" + length));
                                        httpURLConnection2.disconnect();
                                    } else {
                                        int iOptInt = new JSONObject(strA).optInt("code");
                                        if (iOptInt == 0) {
                                            oVar = new o(0, new b());
                                            httpURLConnection2.disconnect();
                                        } else {
                                            oVar = new o(-1, new b("rc_" + iOptInt));
                                            httpURLConnection2.disconnect();
                                        }
                                    }
                                } else {
                                    oVar = new o(-1, new b("rc_" + dd.a(httpURLConnection2.getErrorStream())));
                                    httpURLConnection2.disconnect();
                                }
                            }
                            if (oVar.f4951a != 0) {
                                z6.a.c("PostEventFileTask requestByPost error");
                            } else {
                                z6.a.f("PostEventFileTask lines : %d, deleteFile : %s", Long.valueOf(j8), Integer.valueOf(length), Boolean.valueOf(g0.j(e8.b.f4712i, file)));
                            }
                        }
                        bVar.f11085d = "encrypt error";
                        httpURLConnection2.disconnect();
                    }
                    oVar = oVar2;
                } catch (Exception e) {
                    e = e;
                    if (e instanceof UnknownHostException) {
                        z6.a.c(e.getMessage());
                    } else {
                        z6.a.c(Log.getStackTraceString(e));
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    oVar = new o(-1, new b());
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            httpURLConnection2 = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
        if (oVar.f4951a != 0) {
            z6.a.c("PostEventFileTask requestByPost error");
        } else {
            z6.a.f("PostEventFileTask lines : %d, deleteFile : %s", Long.valueOf(j8), Integer.valueOf(length), Boolean.valueOf(g0.j(e8.b.f4712i, file)));
        }
    }

    @Override // y6.d
    public final String c() {
        return "Upload-File";
    }
}
