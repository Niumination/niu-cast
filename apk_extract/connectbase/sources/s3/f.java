package s3;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14957a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f14960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14961e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f14963g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f14964h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14965i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14966j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f14967k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f14958b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14959c = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<a> f14962f = new CopyOnWriteArrayList();

    @Nullable
    public static f b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f fVar = new f();
            fVar.f14958b = jSONObject.getLong("npt");
            fVar.f14959c = jSONObject.getInt("rt");
            fVar.f14960d = jSONObject.getLong("ver");
            fVar.f14961e = jSONObject.optInt("dim");
            fVar.f14964h = jSONObject.optString(RtspHeaders.Values.URL);
            fVar.f14967k = jSONObject.optString("url_config");
            fVar.f14963g = jSONObject.optString("opcode");
            fVar.f14965i = jSONObject.optInt("interval");
            fVar.f14966j = jSONObject.optInt("offline");
            return fVar;
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
            return null;
        }
    }

    public boolean A() {
        return e.j(this.f14962f);
    }

    public String B() {
        try {
            return new JSONObject().put("npt", this.f14958b).put("rt", this.f14959c).put("ver", this.f14960d).put("dim", this.f14961e).put(RtspHeaders.Values.URL, this.f14964h).put("url_config", this.f14967k).put("interval", this.f14965i).put("offline", this.f14966j).put("opcode", this.f14963g).toString();
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
            return null;
        }
    }

    public a a(long j10) {
        for (a aVar : this.f14962f) {
            if (aVar.e() == j10) {
                return aVar;
            }
        }
        return null;
    }

    public void c(int i10) {
        this.f14957a = i10;
    }

    public void d(a aVar) {
        this.f14962f.add(aVar);
    }

    public boolean e() {
        return this.f14966j == 2;
    }

    public boolean f(long j10, int i10) {
        if (this.f14958b == -1 || j10 == -1) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j11 = jCurrentTimeMillis - this.f14958b;
        if (Math.abs(j11) >= j10) {
            j(jCurrentTimeMillis);
            return true;
        }
        if (j11 >= 0) {
            return this.f14959c < i10;
        }
        long j12 = this.f14958b;
        Calendar calendar = Calendar.getInstance();
        calendar.get(1);
        calendar.get(2);
        calendar.get(5);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.add(5, 1);
        return j12 >= timeInMillis && j12 < calendar.getTimeInMillis();
    }

    public int g() {
        return this.f14957a;
    }

    public a h(String str) {
        for (a aVar : this.f14962f) {
            if (TextUtils.equals(aVar.d(), str)) {
                return aVar;
            }
        }
        return null;
    }

    public void i(int i10) {
        this.f14961e = i10;
    }

    public void j(long j10) {
        this.f14958b = j10;
        this.f14959c = 0;
    }

    public String k() {
        String str = this.f14967k;
        return str == null ? "" : str;
    }

    public void l(int i10) {
        this.f14965i = i10;
    }

    public void m(long j10) {
        this.f14960d = j10;
    }

    public void n(String str) {
        this.f14967k = str;
    }

    public int o() {
        return this.f14961e;
    }

    public void p(int i10) {
        this.f14966j = i10;
    }

    public void q(String str) {
        this.f14963g = str;
    }

    public int r() {
        return this.f14965i;
    }

    public void s(int i10) {
        this.f14959c = i10;
    }

    public void t(String str) {
        this.f14964h = str;
    }

    public String u() {
        return this.f14963g;
    }

    public int v() {
        return this.f14959c;
    }

    public String w() {
        return this.f14964h;
    }

    public long x() {
        if (e.j(this.f14962f)) {
            return 0L;
        }
        return this.f14962f.get(0).f().A();
    }

    public List<a> y() {
        return this.f14962f;
    }

    public long z() {
        return this.f14960d;
    }
}
