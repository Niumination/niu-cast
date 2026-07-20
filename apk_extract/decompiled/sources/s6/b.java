package s6;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.work.WorkRequest;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9517a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9518b = 100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9519c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f9520d = 0;
    public int e = 0;
    public int f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9521g = 100;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9522h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f9523i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f9524j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f9525k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f9526l = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f9527m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f9528n;

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f9521g = jSONObject.getInt("gmax");
            this.f = jSONObject.getInt("gmin");
            this.f9524j = jSONObject.getInt("mi");
            this.e = jSONObject.getInt("nf");
            this.f9520d = jSONObject.getLong("pd");
            this.f9526l = jSONObject.getLong("se");
            this.f9518b = jSONObject.getInt("urhash");
            this.f9527m = jSONObject.getInt("frq");
            this.f9517a = jSONObject.optInt("ct", 0);
            this.f9528n = jSONObject.optInt("pr", 0);
            this.f9519c = jSONObject.optInt("upct", 1);
            this.f9522h = jSONObject.optInt("gpct", 1);
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
        }
    }

    public final long b() {
        Long lValueOf;
        long j8 = this.f9520d;
        try {
            if (!TextUtils.equals(d.q, "test")) {
                return j8;
            }
            Context context = e8.b.f4712i;
            long j10 = this.f9520d;
            try {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
                lValueOf = (Long) clsLoadClass.getMethod("getLong", String.class, Long.TYPE).invoke(clsLoadClass, "debug.athena.push_during", Long.valueOf(j10));
            } catch (IllegalArgumentException e) {
                throw e;
            } catch (Exception unused) {
                lValueOf = Long.valueOf(j10);
            }
            return lValueOf.longValue();
        } catch (Exception e4) {
            z6.a.c("SystemPropertiesProxy.getLong " + e4.getMessage());
            return j8;
        }
    }

    public final String c() {
        try {
            return new JSONObject().put("gmax", this.f9521g).put("gmin", this.f).put("mi", this.f9524j).put("nf", this.e).put("pd", b()).put("se", this.f9526l).put("urhash", this.f9518b).put("frq", this.f9527m).put("ct", this.f9517a).put("pr", this.f9528n).put("upct", this.f9519c).put("gpct", this.f9522h).toString();
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
            return null;
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("TidConfig { pushTime=");
        sb2.append(this.f9523i);
        sb2.append(", pushDuration=");
        sb2.append(this.f9520d);
        sb2.append(", maxCachedItems=");
        sb2.append(this.f9524j);
        sb2.append(", cachedItems=");
        sb2.append(this.f9525k);
        sb2.append(", netWorkFlag=");
        return a1.a.r(sb2, this.e, '}');
    }
}
