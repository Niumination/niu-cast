package s6;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9529a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f9532d;
    public int e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f9533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f9534h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f9535i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f9536j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f9537k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f9530b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9531c = 0;
    public final CopyOnWriteArrayList f = new CopyOnWriteArrayList();

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            c cVar = new c();
            cVar.f9530b = jSONObject.getLong("npt");
            cVar.f9531c = jSONObject.getInt("rt");
            cVar.f9532d = jSONObject.getLong("ver");
            cVar.e = jSONObject.optInt("dim");
            cVar.f9534h = jSONObject.optString("url");
            cVar.f9537k = jSONObject.optString("url_config");
            cVar.f9533g = jSONObject.optString("opcode");
            cVar.f9535i = jSONObject.optInt("interval");
            cVar.f9536j = jSONObject.optInt("offline");
            return cVar;
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
            return null;
        }
    }

    public final boolean b() {
        return this.f9536j == 2;
    }

    public final void c(long j8) {
        this.f9530b = j8;
        this.f9531c = 0;
    }

    public final String d() {
        try {
            return new JSONObject().put("npt", this.f9530b).put("rt", this.f9531c).put("ver", this.f9532d).put("dim", this.e).put("url", this.f9534h).put("url_config", this.f9537k).put("interval", this.f9535i).put("offline", this.f9536j).put("opcode", this.f9533g).toString();
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
            return null;
        }
    }
}
