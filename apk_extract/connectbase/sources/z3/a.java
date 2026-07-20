package z3;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.webkit.JavascriptInterface;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import s3.g;
import t3.d;
import y3.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21810a;

    public a(Context context) {
        this.f21810a = context;
    }

    @JavascriptInterface
    public String getAccountId() {
        return g.k();
    }

    @JavascriptInterface
    public String getAppIds() {
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = d.a().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            return jSONArray.toString();
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
            return "[]";
        }
    }

    @JavascriptInterface
    public String getGAID() {
        return y3.d.b();
    }

    @JavascriptInterface
    public long getRealTime() {
        try {
            return m3.a.f().a(System.currentTimeMillis(), SystemClock.elapsedRealtime());
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
            return System.currentTimeMillis();
        }
    }

    @JavascriptInterface
    public String getVAID() {
        try {
            return y3.a.a();
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
            return "";
        }
    }

    @JavascriptInterface
    public void track(int i10, String str, String str2) {
        Log.i("Athena", "track appid = " + i10 + ", eventName = " + str);
        try {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject(str2);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                bundle.putString(next, jSONObject.get(next).toString());
            }
            new a4.a(str, i10).m(bundle, null).k();
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
        }
    }
}
