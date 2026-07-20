package s3;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14938a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14939b = 100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14940c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f14941d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14942e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14943f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14944g = 100;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14945h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f14946i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14947j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14948k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f14949l = 30000;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f14950m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f14951n;

    @Nullable
    public static b b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            b bVar = new b();
            bVar.f14948k = jSONObject.getInt("ci");
            bVar.f14944g = jSONObject.getInt("gmax");
            bVar.f14943f = jSONObject.getInt("gmin");
            bVar.f14947j = jSONObject.getInt("mi");
            bVar.f14942e = jSONObject.getInt("nf");
            bVar.f14941d = jSONObject.getLong("pd");
            bVar.f14946i = jSONObject.getLong("pt");
            bVar.f14949l = jSONObject.getLong("se");
            bVar.f14939b = jSONObject.getInt("urhash");
            bVar.f14951n = jSONObject.optInt("pr");
            bVar.f14940c = jSONObject.optInt("upct");
            bVar.f14945h = jSONObject.optInt("gpct");
            return bVar;
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
            return null;
        }
    }

    public long A() {
        return this.f14949l;
    }

    public int B() {
        return this.f14940c;
    }

    public int C() {
        return this.f14939b;
    }

    public JSONObject D() {
        try {
            return new JSONObject().put("ci", this.f14948k).put("gmax", this.f14944g).put("gmin", this.f14943f).put("mi", this.f14947j).put("nf", this.f14942e).put("pd", w()).put("pt", this.f14946i).put("se", this.f14949l).put("urhash", this.f14939b).put("frq", this.f14950m).put("ct", this.f14938a).put("pr", this.f14951n).put("upct", this.f14940c).put("gpct", this.f14945h);
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
            return null;
        }
    }

    public String E() {
        try {
            return new JSONObject().put("gmax", this.f14944g).put("gmin", this.f14943f).put("mi", this.f14947j).put("nf", this.f14942e).put("pd", w()).put("se", this.f14949l).put("urhash", this.f14939b).put("frq", this.f14950m).put("ct", this.f14938a).put("pr", this.f14951n).put("upct", this.f14940c).put("gpct", this.f14945h).toString();
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
            return null;
        }
    }

    public int a() {
        return this.f14948k;
    }

    public void c(int i10) {
        this.f14948k = i10;
    }

    public void d(long j10) {
        this.f14950m = j10;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f14944g = jSONObject.getInt("gmax");
            this.f14943f = jSONObject.getInt("gmin");
            this.f14947j = jSONObject.getInt("mi");
            this.f14942e = jSONObject.getInt("nf");
            this.f14941d = jSONObject.getLong("pd");
            this.f14949l = jSONObject.getLong("se");
            this.f14939b = jSONObject.getInt("urhash");
            this.f14950m = jSONObject.getInt("frq");
            this.f14938a = jSONObject.optInt("ct", 0);
            this.f14951n = jSONObject.optInt("pr", 0);
            this.f14940c = jSONObject.optInt("upct", 1);
            this.f14945h = jSONObject.optInt("gpct", 1);
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
        }
    }

    public long f() {
        return this.f14950m;
    }

    public void g(int i10) {
        this.f14944g = i10;
    }

    public void h(long j10) {
        this.f14941d = j10;
    }

    public int i() {
        return this.f14944g;
    }

    public void j(int i10) {
        this.f14943f = i10;
    }

    public void k(long j10) {
        this.f14946i = j10;
    }

    public int l() {
        return this.f14943f;
    }

    public void m(int i10) {
        this.f14945h = i10;
    }

    public void n(long j10) {
        this.f14949l = j10;
    }

    public int o() {
        return this.f14945h;
    }

    public void p(int i10) {
        this.f14947j = i10;
    }

    public int q() {
        return this.f14947j;
    }

    public void r(int i10) {
        this.f14942e = i10;
    }

    public int s() {
        return this.f14942e;
    }

    public void t(int i10) {
        this.f14951n = i10;
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder("TidConfig { pushTime=");
        sb2.append(this.f14946i);
        sb2.append(", pushDuration=");
        sb2.append(this.f14941d);
        sb2.append(", maxCachedItems=");
        sb2.append(this.f14947j);
        sb2.append(", cachedItems=");
        sb2.append(this.f14948k);
        sb2.append(", netWorkFlag=");
        return u.a.a(sb2, this.f14942e, rs.f.f14860b);
    }

    public int u() {
        return this.f14951n;
    }

    public void v(int i10) {
        this.f14938a = i10;
    }

    public long w() {
        long j10 = this.f14941d;
        try {
            if (!g.S()) {
                return j10;
            }
            return e.c(k6.g.h0(), "debug.athena.push_during", this.f14941d).longValue();
        } catch (Exception e10) {
            y3.b.d("SystemPropertiesProxy.getLong " + e10.getMessage());
            return j10;
        }
    }

    public void x(int i10) {
        this.f14940c = i10;
    }

    public long y() {
        return this.f14946i;
    }

    public void z(int i10) {
        this.f14939b = i10;
    }
}
