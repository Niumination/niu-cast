package y6;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import ef.o;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import k3.dd;
import m3.d0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s6.e f11089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a8.a f11090d;

    public e(Handler handler, s6.e eVar, a8.a aVar) {
        super(handler);
        this.f11089c = eVar;
        this.f11090d = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02e2 A[Catch: Exception -> 0x0297, TryCatch #6 {Exception -> 0x0297, blocks: (B:76:0x0248, B:80:0x0271, B:84:0x027c, B:86:0x0284, B:89:0x0299, B:91:0x029f, B:92:0x02a6, B:94:0x02ac, B:95:0x02b2, B:97:0x02b8, B:98:0x02dc, B:100:0x02e2, B:101:0x02e8, B:103:0x02ee, B:104:0x02f4, B:110:0x0303, B:79:0x026f), top: B:130:0x0248 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x02ee A[Catch: Exception -> 0x0297, TryCatch #6 {Exception -> 0x0297, blocks: (B:76:0x0248, B:80:0x0271, B:84:0x027c, B:86:0x0284, B:89:0x0299, B:91:0x029f, B:92:0x02a6, B:94:0x02ac, B:95:0x02b2, B:97:0x02b8, B:98:0x02dc, B:100:0x02e2, B:101:0x02e8, B:103:0x02ee, B:104:0x02f4, B:110:0x0303, B:79:0x026f), top: B:130:0x0248 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:116:0x0336  */
    /* JADX WARN: Code duplicated, block: B:120:0x0345  */
    /* JADX WARN: Code duplicated, block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:67:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:72:0x020a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x020c  */
    /* JADX WARN: Code duplicated, block: B:74:0x0213  */
    /* JADX WARN: Code duplicated, block: B:75:0x022a  */
    /* JADX WARN: Code duplicated, block: B:78:0x026e  */
    /* JADX WARN: Code duplicated, block: B:79:0x026f A[Catch: Exception -> 0x0297, TryCatch #6 {Exception -> 0x0297, blocks: (B:76:0x0248, B:80:0x0271, B:84:0x027c, B:86:0x0284, B:89:0x0299, B:91:0x029f, B:92:0x02a6, B:94:0x02ac, B:95:0x02b2, B:97:0x02b8, B:98:0x02dc, B:100:0x02e2, B:101:0x02e8, B:103:0x02ee, B:104:0x02f4, B:110:0x0303, B:79:0x026f), top: B:130:0x0248 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0279  */
    /* JADX WARN: Code duplicated, block: B:83:0x027b  */
    /* JADX WARN: Code duplicated, block: B:86:0x0284 A[Catch: Exception -> 0x0297, TryCatch #6 {Exception -> 0x0297, blocks: (B:76:0x0248, B:80:0x0271, B:84:0x027c, B:86:0x0284, B:89:0x0299, B:91:0x029f, B:92:0x02a6, B:94:0x02ac, B:95:0x02b2, B:97:0x02b8, B:98:0x02dc, B:100:0x02e2, B:101:0x02e8, B:103:0x02ee, B:104:0x02f4, B:110:0x0303, B:79:0x026f), top: B:130:0x0248 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x029f A[Catch: Exception -> 0x0297, TryCatch #6 {Exception -> 0x0297, blocks: (B:76:0x0248, B:80:0x0271, B:84:0x027c, B:86:0x0284, B:89:0x0299, B:91:0x029f, B:92:0x02a6, B:94:0x02ac, B:95:0x02b2, B:97:0x02b8, B:98:0x02dc, B:100:0x02e2, B:101:0x02e8, B:103:0x02ee, B:104:0x02f4, B:110:0x0303, B:79:0x026f), top: B:130:0x0248 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x02ac A[Catch: Exception -> 0x0297, TryCatch #6 {Exception -> 0x0297, blocks: (B:76:0x0248, B:80:0x0271, B:84:0x027c, B:86:0x0284, B:89:0x0299, B:91:0x029f, B:92:0x02a6, B:94:0x02ac, B:95:0x02b2, B:97:0x02b8, B:98:0x02dc, B:100:0x02e2, B:101:0x02e8, B:103:0x02ee, B:104:0x02f4, B:110:0x0303, B:79:0x026f), top: B:130:0x0248 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x02b8 A[Catch: Exception -> 0x0297, TryCatch #6 {Exception -> 0x0297, blocks: (B:76:0x0248, B:80:0x0271, B:84:0x027c, B:86:0x0284, B:89:0x0299, B:91:0x029f, B:92:0x02a6, B:94:0x02ac, B:95:0x02b2, B:97:0x02b8, B:98:0x02dc, B:100:0x02e2, B:101:0x02e8, B:103:0x02ee, B:104:0x02f4, B:110:0x0303, B:79:0x026f), top: B:130:0x0248 }] */
    @Override // y6.d
    public final void a() throws Throwable {
        HttpURLConnection httpURLConnection;
        o oVar;
        int i8;
        o oVar2;
        HttpURLConnection httpURLConnection2;
        int i9;
        s6.e eVar;
        JSONObject jSONObject;
        long j8;
        boolean z2;
        int i10;
        int iOptInt;
        n6.a aVar;
        o6.a aVar2;
        byte[] bArrDoFinal;
        SSLContext sSLContextA;
        String str = s6.d.f9538a;
        String str2 = s6.d.a(false) + s6.d.f9542g;
        s6.e eVar2 = this.f11089c;
        long j10 = eVar2.f;
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            String strK = dd.k(keyGenerator.generateKey().getEncoded());
            g gVar = new g(strK.getBytes());
            try {
                try {
                    Cipher cipher = (Cipher) gVar.f11095a;
                    if (cipher != null) {
                        try {
                            bArrDoFinal = cipher.doFinal("".getBytes("UTF-8"));
                        } catch (Exception e) {
                            z6.a.c(Log.getStackTraceString(e));
                            bArrDoFinal = null;
                        }
                    } else {
                        bArrDoFinal = null;
                    }
                    byte[] bArrDecode = Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArNrm4jErOdstd1P5L1X/\nCGSS6NKf4glPrFbTM97aE9ZKGUiMALIV8W7FClAgLZdtTZkL5XEQdbX4RB/C6edc\nnN2ifla6sVu23y78FMiL6smp9ayE7Y3gSEfB3md4nvEUpyRUu4wYLIf9nVR36okK\nGCerxYdLtDbJ69Rux4lgE5C9a6qLfV6BzjJYONk/vQhGQYT6qes+TFtXV0hvF8UM\nDG+0GfA3MiQue/Ny8uIPBykDPS1dcIADzVos2fXs/o2aFTrkdVjiX8irwYBze69K\nzFx18H12iZ9gG1VztMbHetvImBoXeCOwjTc5RnGIz+Hya96pxJLK2DcSlAaHEs1H\nOQIDAQAB", 2);
                    byte[] bytes = strK.getBytes(Charset.forName("UTF-8"));
                    PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArrDecode));
                    Cipher cipher2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    cipher2.init(1, publicKeyGeneratePublic);
                    String str3 = Base64.encodeToString(bArrDoFinal, 2) + "," + Base64.encodeToString(cipher2.doFinal(bytes), 2);
                    URL url = new URL(f8.c.a(str2, true));
                    httpURLConnection2 = (HttpURLConnection) url.openConnection();
                    try {
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
                            httpURLConnection2.setRequestProperty("accept", "*/*");
                            httpURLConnection2.setRequestProperty("Content-Length", String.valueOf(str3.length()));
                            httpURLConnection2.setRequestProperty("encrypt-level", ExifInterface.GPS_MEASUREMENT_2D);
                            httpURLConnection2.setRequestProperty("ver", String.valueOf(j10));
                            httpURLConnection2.setRequestProperty("vn", "1");
                            httpURLConnection2.setRequestMethod("POST");
                            httpURLConnection2.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
                            httpURLConnection2.setConnectTimeout(30000);
                            httpURLConnection2.setDoInput(true);
                            httpURLConnection2.setDoOutput(true);
                            PrintWriter printWriter = new PrintWriter(httpURLConnection2.getOutputStream());
                            printWriter.write(str3);
                            printWriter.flush();
                            printWriter.close();
                            int responseCode = httpURLConnection2.getResponseCode();
                            try {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("url", url);
                                jSONObject2.put("params", "");
                                jSONObject2.put("version", j10);
                                jSONObject2.put("code", responseCode);
                                z6.a.f("--> request config:%s", jSONObject2.toString());
                            } catch (Exception e4) {
                                z6.a.d("print request config exception:%s", e4.getMessage());
                            }
                            if (responseCode == 200) {
                                String strA = dd.a(httpURLConnection2.getInputStream());
                                if (TextUtils.equals("{}", strA)) {
                                    oVar2 = new o(1, (Object) null);
                                } else if (TextUtils.isEmpty(strA)) {
                                    oVar2 = new o(-1, (Object) null);
                                } else {
                                    oVar2 = new o(0, str2.contains("secret") ? new String(gVar.d(Base64.decode(strA, 2)), StandardCharsets.UTF_8) : new String(dd.m(gVar.d(Base64.decode(strA, 2))), StandardCharsets.UTF_8));
                                }
                            } else {
                                oVar2 = new o(-1, dd.a(httpURLConnection2.getErrorStream()));
                            }
                            i8 = -1;
                        } catch (Exception e10) {
                            e = e10;
                            httpURLConnection = httpURLConnection2;
                            try {
                                i8 = -1;
                                oVar = new o(-1, e.getMessage());
                                if (httpURLConnection != null) {
                                    oVar2 = oVar;
                                    httpURLConnection2 = httpURLConnection;
                                }
                                i9 = oVar.f4951a;
                                if (i9 == i8) {
                                    String str4 = s6.d.f9538a;
                                }
                                if (i9 == 0) {
                                    String str5 = (String) oVar.f4952b;
                                    z6.a.f("<-- globalConfig:%s", str5);
                                    n6.a aVar3 = m6.a.f().f7948a;
                                    aVar3.getClass();
                                    try {
                                        eVar = (s6.e) ((i1.b) aVar3.f8123c).f5527a;
                                        jSONObject = new JSONObject(str5);
                                        eVar.f9559a = jSONObject.getLong("cv") * 3600000;
                                        j8 = jSONObject.getLong("threshold");
                                        if (j8 > 0) {
                                            eVar.f9560b = j8;
                                        }
                                        if (jSONObject.getInt("once") == 1) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        eVar.f9561c = z2;
                                        if (jSONObject.has("networks")) {
                                            JSONObject jSONObject3 = jSONObject.getJSONObject("networks");
                                            eVar.f9562d = jSONObject3.getString("url");
                                            eVar.e = jSONObject3.getJSONObject("tids");
                                        }
                                        if (jSONObject.has("p")) {
                                            eVar.b(jSONObject.getJSONArray("p"));
                                        }
                                        if (jSONObject.has("ver")) {
                                            eVar.f = jSONObject.getLong("ver");
                                        }
                                        if (jSONObject.has("delays")) {
                                            String[] strArrSplit = jSONObject.getString("delays").split(",");
                                            eVar.f9569m = new Pair(Integer.valueOf(Integer.parseInt(strArrSplit[0])), Integer.valueOf(Integer.parseInt(strArrSplit[1])));
                                        }
                                        if (jSONObject.has("tz")) {
                                            eVar.f9570n = jSONObject.getString("tz");
                                        }
                                        if (jSONObject.has("dlt")) {
                                            eVar.p = jSONObject.getInt("dlt");
                                        }
                                        i10 = 6;
                                        iOptInt = jSONObject.optInt("geo", 6);
                                        if (iOptInt > 0) {
                                            i10 = iOptInt;
                                        }
                                        eVar.f9571o = i10;
                                    } catch (Exception e11) {
                                        z6.a.c(Log.getStackTraceString(e11));
                                        e8.d.a("updateGlobalConfig", e11);
                                    }
                                    eVar2.f9563g = System.currentTimeMillis() + eVar2.f9559a;
                                    eVar2.f9564h = 0;
                                    this.f11087a.postAtFrontOfQueue(new m.c(this, 22));
                                } else if (i9 != 1) {
                                    eVar2.f9564h++;
                                } else {
                                    z6.a.f("<-- globalConfig:%s", "NOT_MODIFIED");
                                    eVar2.f9563g = System.currentTimeMillis() + eVar2.f9559a;
                                    eVar2.f9564h = 0;
                                }
                                aVar = m6.a.f().f7948a;
                                aVar2 = (o6.a) aVar.f8122b;
                                if (aVar2 != null) {
                                    aVar2.h(((i1.b) aVar.f8123c).d());
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    httpURLConnection = null;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e12) {
                e = e12;
                httpURLConnection = null;
                i8 = -1;
                oVar = new o(-1, e.getMessage());
                if (httpURLConnection != null) {
                    oVar2 = oVar;
                    httpURLConnection2 = httpURLConnection;
                    httpURLConnection2.disconnect();
                    oVar = oVar2;
                }
                i9 = oVar.f4951a;
                if (i9 == i8) {
                    String str6 = s6.d.f9538a;
                }
                if (i9 == 0) {
                    String str7 = (String) oVar.f4952b;
                    z6.a.f("<-- globalConfig:%s", str7);
                    n6.a aVar4 = m6.a.f().f7948a;
                    aVar4.getClass();
                    eVar = (s6.e) ((i1.b) aVar4.f8123c).f5527a;
                    jSONObject = new JSONObject(str7);
                    eVar.f9559a = jSONObject.getLong("cv") * 3600000;
                    j8 = jSONObject.getLong("threshold");
                    if (j8 > 0) {
                        eVar.f9560b = j8;
                    }
                    if (jSONObject.getInt("once") == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    eVar.f9561c = z2;
                    if (jSONObject.has("networks")) {
                        JSONObject jSONObject4 = jSONObject.getJSONObject("networks");
                        eVar.f9562d = jSONObject4.getString("url");
                        eVar.e = jSONObject4.getJSONObject("tids");
                    }
                    if (jSONObject.has("p")) {
                        eVar.b(jSONObject.getJSONArray("p"));
                    }
                    if (jSONObject.has("ver")) {
                        eVar.f = jSONObject.getLong("ver");
                    }
                    if (jSONObject.has("delays")) {
                        String[] strArrSplit2 = jSONObject.getString("delays").split(",");
                        eVar.f9569m = new Pair(Integer.valueOf(Integer.parseInt(strArrSplit2[0])), Integer.valueOf(Integer.parseInt(strArrSplit2[1])));
                    }
                    if (jSONObject.has("tz")) {
                        eVar.f9570n = jSONObject.getString("tz");
                    }
                    if (jSONObject.has("dlt")) {
                        eVar.p = jSONObject.getInt("dlt");
                    }
                    i10 = 6;
                    iOptInt = jSONObject.optInt("geo", 6);
                    if (iOptInt > 0) {
                        i10 = iOptInt;
                    }
                    eVar.f9571o = i10;
                    eVar2.f9563g = System.currentTimeMillis() + eVar2.f9559a;
                    eVar2.f9564h = 0;
                    this.f11087a.postAtFrontOfQueue(new m.c(this, 22));
                } else if (i9 != 1) {
                    eVar2.f9564h++;
                } else {
                    z6.a.f("<-- globalConfig:%s", "NOT_MODIFIED");
                    eVar2.f9563g = System.currentTimeMillis() + eVar2.f9559a;
                    eVar2.f9564h = 0;
                }
                aVar = m6.a.f().f7948a;
                aVar2 = (o6.a) aVar.f8122b;
                if (aVar2 != null) {
                    aVar2.h(((i1.b) aVar.f8123c).d());
                }
            }
        } catch (Exception e13) {
            e = e13;
        } catch (Throwable th5) {
            th = th5;
        }
        httpURLConnection2.disconnect();
        oVar = oVar2;
        i9 = oVar.f4951a;
        if (i9 == i8 && dd.g(eVar2.f9568l)) {
            String str8 = s6.d.f9538a;
        }
        if (i9 == 0) {
            String str9 = (String) oVar.f4952b;
            z6.a.f("<-- globalConfig:%s", str9);
            n6.a aVar5 = m6.a.f().f7948a;
            aVar5.getClass();
            eVar = (s6.e) ((i1.b) aVar5.f8123c).f5527a;
            jSONObject = new JSONObject(str9);
            eVar.f9559a = jSONObject.getLong("cv") * 3600000;
            j8 = jSONObject.getLong("threshold");
            if (j8 > 0) {
                eVar.f9560b = j8;
            }
            if (jSONObject.getInt("once") == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            eVar.f9561c = z2;
            if (jSONObject.has("networks")) {
                JSONObject jSONObject5 = jSONObject.getJSONObject("networks");
                eVar.f9562d = jSONObject5.getString("url");
                eVar.e = jSONObject5.getJSONObject("tids");
            }
            if (jSONObject.has("p")) {
                eVar.b(jSONObject.getJSONArray("p"));
            }
            if (jSONObject.has("ver")) {
                eVar.f = jSONObject.getLong("ver");
            }
            if (jSONObject.has("delays")) {
                String[] strArrSplit3 = jSONObject.getString("delays").split(",");
                eVar.f9569m = new Pair(Integer.valueOf(Integer.parseInt(strArrSplit3[0])), Integer.valueOf(Integer.parseInt(strArrSplit3[1])));
            }
            if (jSONObject.has("tz")) {
                eVar.f9570n = jSONObject.getString("tz");
            }
            if (jSONObject.has("dlt")) {
                eVar.p = jSONObject.getInt("dlt");
            }
            i10 = 6;
            iOptInt = jSONObject.optInt("geo", 6);
            if (iOptInt > 0 && iOptInt < 12) {
                i10 = iOptInt;
            }
            eVar.f9571o = i10;
            eVar2.f9563g = System.currentTimeMillis() + eVar2.f9559a;
            eVar2.f9564h = 0;
            this.f11087a.postAtFrontOfQueue(new m.c(this, 22));
        } else if (i9 != 1) {
            eVar2.f9564h++;
        } else {
            z6.a.f("<-- globalConfig:%s", "NOT_MODIFIED");
            eVar2.f9563g = System.currentTimeMillis() + eVar2.f9559a;
            eVar2.f9564h = 0;
        }
        aVar = m6.a.f().f7948a;
        aVar2 = (o6.a) aVar.f8122b;
        if (aVar2 != null) {
            aVar2.h(((i1.b) aVar.f8123c).d());
        }
    }

    @Override // y6.d
    public final String c() {
        return "Retrieve-Global-Config";
    }
}
