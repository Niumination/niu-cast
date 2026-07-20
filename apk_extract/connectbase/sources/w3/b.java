package w3;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17911c;

    public b(Handler handler, String str) {
        super(handler);
        this.f17911c = str;
    }

    @Override // w3.c
    public void a() throws Throwable {
        byte[] bytes;
        Context contextH0 = k6.g.h0();
        boolean zI = y3.d.i(contextH0);
        String strF = s3.e.f(this.f17911c.getBytes(StandardCharsets.UTF_8));
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObjectPut = new JSONObject().put("appid", 9999).put("hostid", 9999).put("pkg", "").put("vn", "").put("vc", "").put("ins", "").put("sdkv", "3.1.1.1-sys").put("isfl", zI).put("cnt", 1).put("events", new JSONArray().put(new JSONObject(this.f17911c)));
            try {
                PackageManager packageManager = contextH0.getPackageManager();
                String packageName = contextH0.getPackageName();
                JSONObject jSONObjectPut2 = jSONObjectPut.put("pkg", packageName == null ? "" : packageName);
                String installerPackageName = packageManager.getInstallerPackageName(packageName);
                if (installerPackageName == null) {
                    installerPackageName = "";
                }
                jSONObjectPut2.put("ins", installerPackageName);
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                if (packageInfo != null) {
                    String str = packageInfo.versionName;
                    if (str == null) {
                        str = "";
                    }
                    JSONObject jSONObjectPut3 = jSONObjectPut.put("vn", str);
                    String strValueOf = String.valueOf(packageInfo.versionCode);
                    if (strValueOf == null) {
                        strValueOf = "";
                    }
                    jSONObjectPut3.put("vc", strValueOf);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            jSONArray.put(jSONObjectPut);
        } catch (Exception e11) {
            y3.b.d(Log.getStackTraceString(e11));
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String strD = s3.g.D();
            if (strD == null) {
                strD = "";
            }
            JSONObject jSONObjectPut4 = jSONObject.put("channel", strD);
            String strD2 = y3.d.d(contextH0, "opid");
            if (strD2 == null) {
                strD2 = "";
            }
            JSONObject jSONObjectPut5 = jSONObjectPut4.put("opid", strD2);
            String strD3 = y3.d.d(contextH0, "oneid");
            if (strD3 == null) {
                strD3 = "";
            }
            JSONObject jSONObjectPut6 = jSONObjectPut5.put("tsid", strD3);
            String strA = y3.a.a();
            if (strA == null) {
                strA = "";
            }
            JSONObject jSONObjectPut7 = jSONObjectPut6.put("vaid", strA);
            JSONObject jSONObject2 = new JSONObject();
            String strJ = y3.e.j();
            if (strJ == null) {
                strJ = "";
            }
            JSONObject jSONObjectPut8 = jSONObject2.put("tz", strJ);
            String strB = y3.d.b();
            if (strB == null) {
                strB = "";
            }
            JSONObject jSONObjectPut9 = jSONObjectPut8.put("gaid", strB);
            String str2 = s3.g.A;
            if (str2 == null) {
                str2 = "";
            }
            JSONObject jSONObjectPut10 = jSONObjectPut9.put("tuid", str2).put("actype", (int) s3.g.f14993z);
            String strA2 = y3.g.a();
            if (strA2 == null) {
                strA2 = "";
            }
            JSONObject jSONObjectPut11 = jSONObjectPut10.put("osver", strA2);
            String str3 = Build.VERSION.RELEASE;
            if (str3 == null) {
                str3 = "";
            }
            JSONObject jSONObjectPut12 = jSONObjectPut11.put("aver", str3);
            String str4 = Build.DISPLAY;
            if (str4 == null) {
                str4 = "";
            }
            JSONObject jSONObjectPut13 = jSONObjectPut12.put("build", str4);
            String language = Locale.getDefault().getLanguage();
            if (language == null) {
                language = "";
            }
            JSONObject jSONObjectPut14 = jSONObjectPut13.put("lang", language);
            String str5 = Build.BRAND;
            if (str5 == null) {
                str5 = "";
            }
            JSONObject jSONObjectPut15 = jSONObjectPut14.put("brand", str5);
            String str6 = Build.MODEL;
            if (str6 == null) {
                str6 = "";
            }
            JSONObject jSONObjectPut16 = jSONObjectPut15.put("model", str6).put("net", y3.f.a(contextH0)).put("uts", System.currentTimeMillis()).put("try", 0);
            String strR = y3.e.r(contextH0);
            if (strR == null) {
                strR = "";
            }
            JSONObject jSONObjectPut17 = jSONObjectPut16.put("mcc", strR);
            String strS = y3.e.s(contextH0);
            if (strS == null) {
                strS = "";
            }
            JSONObject jSONObjectPut18 = jSONObjectPut17.put("mnc", strS).put("ekey", jSONObjectPut7.toString()).put("appids", jSONArray);
            JSONObject jSONObjectE = s3.g.E();
            if (jSONObjectE != null && jSONObjectE.length() > 0) {
                int length = jSONObjectE.toString().getBytes(StandardCharsets.UTF_8).length;
                if (length > 2000) {
                    String str7 = String.format(Locale.getDefault(), "custom param is too long,limit is 2000 bytes(now is %d bytes)", Integer.valueOf(length));
                    y3.b.d(str7);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("errorMsg", str7);
                    jSONObjectPut7.put("cparam", jSONObject3.toString());
                } else {
                    jSONObjectPut7.put("cparam", jSONObjectE.toString());
                }
            }
            if (s3.g.C) {
                jSONObjectPut18.put("iid", "");
            }
            bytes = jSONObjectPut18.toString().getBytes(StandardCharsets.UTF_8);
        } catch (Exception e12) {
            y3.b.d(Log.getStackTraceString(e12));
            bytes = null;
        }
        String strB2 = TextUtils.isEmpty("") ? y3.d.b() : "";
        if (TextUtils.isEmpty(strB2)) {
            strB2 = y3.e.k(k6.g.f9114q);
        }
        StringBuilder sbA = k.c.a(strB2, "_");
        sbA.append(t3.d.d());
        l<a> lVarF = d.f(TextUtils.isEmpty(null) ? l6.c.d(s3.g.L(), true) : l6.c.d(s3.g.l(null), true), bytes, 1, Collections.singletonList(9999), strF, sbA.toString());
        if (lVarF.f17928a == 0) {
            m0.a.a(contextH0).g("gdpr_close", "");
        } else {
            y3.b.e("PostGdprEventTask requestByPost error : %s", lVarF.f17929b.f17907d);
        }
        if (zI) {
            m0.a.a(contextH0).g("first_launch", "false");
        }
    }

    @Override // w3.c
    public String c() {
        return "GDPR";
    }
}
