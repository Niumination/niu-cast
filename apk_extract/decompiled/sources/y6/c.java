package y6;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import ef.o;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Locale;
import k3.dd;
import m3.d0;
import m3.f0;
import m3.g0;
import m3.h0;
import m3.i0;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11086c;

    public c(Handler handler, String str) {
        super(handler);
        this.f11086c = str;
    }

    @Override // y6.d
    public final void a() throws Throwable {
        byte[] bytes;
        JSONObject jSONObject;
        Context context = e8.b.f4712i;
        boolean zH = z6.b.h(context);
        Charset charset = StandardCharsets.UTF_8;
        String str = this.f11086c;
        String strC = dd.c(str.getBytes(charset));
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObjectPut = new JSONObject().put("appid", 9999).put("hostid", 9999).put("pkg", "").put("vn", "").put("vc", "").put("ins", "").put("sdkv", "3.1.1.0").put("isfl", zH).put("cnt", 1).put("events", new JSONArray().put(new JSONObject(str)));
            try {
                PackageManager packageManager = context.getPackageManager();
                String packageName = context.getPackageName();
                JSONObject jSONObjectPut2 = jSONObjectPut.put("pkg", packageName == null ? "" : packageName);
                String installerPackageName = packageManager.getInstallerPackageName(packageName);
                if (installerPackageName == null) {
                    installerPackageName = "";
                }
                jSONObjectPut2.put("ins", installerPackageName);
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                if (packageInfo != null) {
                    String str2 = packageInfo.versionName;
                    if (str2 == null) {
                        str2 = "";
                    }
                    JSONObject jSONObjectPut3 = jSONObjectPut.put("vn", str2);
                    String strValueOf = String.valueOf(packageInfo.versionCode);
                    if (strValueOf == null) {
                        strValueOf = "";
                    }
                    jSONObjectPut3.put("vc", strValueOf);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObjectPut);
        } catch (Exception e4) {
            z6.a.c(Log.getStackTraceString(e4));
        }
        String strC2 = g0.c(context, 0);
        try {
            JSONObject jSONObject2 = new JSONObject();
            String str3 = s6.d.f9538a;
            JSONObject jSONObjectPut4 = jSONObject2.put("channel", "");
            String strG = z6.b.g(context, "opid");
            if (strG == null) {
                strG = "";
            }
            JSONObject jSONObjectPut5 = jSONObjectPut4.put("opid", strG);
            String strG2 = z6.b.g(context, "oneid");
            if (strG2 == null) {
                strG2 = "";
            }
            JSONObject jSONObjectPut6 = jSONObjectPut5.put("tsid", strG2);
            String strA = h0.a();
            if (strA == null) {
                strA = "";
            }
            JSONObject jSONObjectPut7 = jSONObjectPut6.put("vaid", strA);
            JSONObject jSONObject3 = new JSONObject();
            String strG3 = g0.g();
            if (strG3 == null) {
                strG3 = "";
            }
            JSONObject jSONObjectPut8 = jSONObject3.put("tz", strG3);
            String strB = z6.b.b();
            if (strB == null) {
                strB = "";
            }
            JSONObject jSONObjectPut9 = jSONObjectPut8.put("gaid", strB).put("tuid", "").put("actype", 0);
            String strA2 = i0.a();
            if (strA2 == null) {
                strA2 = "";
            }
            JSONObject jSONObjectPut10 = jSONObjectPut9.put("osver", strA2);
            String str4 = Build.VERSION.RELEASE;
            if (str4 == null) {
                str4 = "";
            }
            JSONObject jSONObjectPut11 = jSONObjectPut10.put("aver", str4);
            String str5 = Build.DISPLAY;
            if (str5 == null) {
                str5 = "";
            }
            JSONObject jSONObjectPut12 = jSONObjectPut11.put("build", str5);
            String language = Locale.getDefault().getLanguage();
            if (language == null) {
                language = "";
            }
            JSONObject jSONObjectPut13 = jSONObjectPut12.put("lang", language);
            String str6 = Build.BRAND;
            if (str6 == null) {
                str6 = "";
            }
            JSONObject jSONObjectPut14 = jSONObjectPut13.put("brand", str6);
            String str7 = Build.MODEL;
            if (str7 == null) {
                str7 = "";
            }
            JSONObject jSONObjectPut15 = jSONObjectPut14.put("model", str7).put("net", f0.b(context)).put("uts", System.currentTimeMillis()).put("try", 0);
            String strM = g0.m(context);
            if (strM == null) {
                strM = "";
            }
            JSONObject jSONObjectPut16 = jSONObjectPut15.put("mcc", strM);
            String strN = g0.n(context);
            if (strN == null) {
                strN = "";
            }
            JSONObject jSONObjectPut17 = jSONObjectPut16.put("mnc", strN).put("ekey", jSONObjectPut7.toString()).put("appids", jSONArray);
            synchronized (s6.d.class) {
                jSONObject = s6.d.f9554v;
            }
            if (jSONObject != null && jSONObject.length() > 0) {
                int length = jSONObject.toString().getBytes(StandardCharsets.UTF_8).length;
                if (length > 2000) {
                    String str8 = String.format(Locale.getDefault(), "custom param is too long,limit is 2000 bytes(now is %d bytes)", Integer.valueOf(length));
                    z6.a.c(str8);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("errorMsg", str8);
                    jSONObjectPut7.put("cparam", jSONObject4.toString());
                } else {
                    jSONObjectPut7.put("cparam", jSONObject.toString());
                }
            }
            bytes = jSONObjectPut17.toString().getBytes(StandardCharsets.UTF_8);
        } catch (Exception e10) {
            z6.a.c(Log.getStackTraceString(e10));
            bytes = null;
        }
        if (TextUtils.isEmpty(strC2)) {
            strC2 = z6.b.b();
        }
        if (TextUtils.isEmpty(strC2)) {
            strC2 = g0.h(e8.b.f4712i);
        }
        StringBuilder sbT = o.d.t(strC2, "_");
        sbT.append(t6.d.f10184a);
        o oVarA = d0.a(TextUtils.isEmpty(null) ? f8.c.a(s6.d.d(), true) : f8.c.a(s6.d.b(null), true), bytes, 1, Collections.singletonList(9999), strC, sbT.toString());
        if (oVarA.f4951a == 0) {
            i1.a.a(context).g("gdpr_close", "");
        } else {
            z6.a.d("PostGdprEventTask requestByPost error : %s", ((b) oVarA.f4952b).f11085d);
        }
        if (zH) {
            i1.a.a(context).g("first_launch", "false");
        }
    }

    @Override // y6.d
    public final String c() {
        return "GDPR";
    }
}
