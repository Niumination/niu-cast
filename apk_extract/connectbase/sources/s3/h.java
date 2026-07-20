package s3;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f14998e;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f15003j;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f15007n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f14994a = 86400000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f14995b = 150000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14996c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f14997d = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f14999f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f15000g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f15001h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f15002i = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<String> f15004k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<byte[]> f15005l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Pair<Integer, Integer> f15006m = new Pair<>(3, 6);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f15008o = 6;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f15009p = 10;

    @Nullable
    public static h c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                h hVar = new h();
                hVar.f14994a = jSONObject.getLong("pd");
                hVar.f14995b = jSONObject.getLong("th");
                hVar.f14996c = jSONObject.getBoolean("once");
                if (jSONObject.has(RtspHeaders.Values.URL)) {
                    hVar.f14997d = jSONObject.getString(RtspHeaders.Values.URL);
                }
                if (jSONObject.has("tidUrls")) {
                    hVar.f14998e = jSONObject.getJSONObject("tidUrls");
                }
                hVar.f14999f = jSONObject.getLong(lb.f.f9782f);
                hVar.f15000g = jSONObject.getLong("npt");
                hVar.f15001h = jSONObject.getInt("rt");
                hVar.f15002i = jSONObject.getBoolean("dd");
                hVar.f15003j = jSONObject.optString("ddv", null);
                if (jSONObject.has("p")) {
                    hVar.f(jSONObject.getJSONArray("p"));
                }
                if (jSONObject.has("delays")) {
                    String[] strArrSplit = jSONObject.getString("delays").split(ks.g.f9491d);
                    hVar.f15006m = new Pair<>(Integer.valueOf(Integer.parseInt(strArrSplit[0])), Integer.valueOf(Integer.parseInt(strArrSplit[1])));
                }
                if (jSONObject.has("tz")) {
                    hVar.f15007n = jSONObject.getString("tz");
                }
                int i10 = 6;
                int iOptInt = jSONObject.optInt("geo", 6);
                if (iOptInt > 0 && iOptInt < 12) {
                    i10 = iOptInt;
                }
                hVar.f15008o = i10;
                if (jSONObject.has("dlt")) {
                    hVar.f15009p = jSONObject.getInt("dlt");
                }
                return hVar;
            } catch (Exception e10) {
                y3.b.d(Log.getStackTraceString(e10));
            }
        }
        return null;
    }

    public long A() {
        return this.f14999f;
    }

    public JSONObject B() {
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.f15004k.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            return new JSONObject().put("pd", this.f14994a).put("dlt", this.f15009p).put("th", this.f14995b).put("once", this.f14996c).put(RtspHeaders.Values.URL, this.f14997d).put("tidUrls", this.f14998e).put(lb.f.f9782f, this.f14999f).put("npt", this.f15000g).put("rt", this.f15001h).put("dd", this.f15002i).put("ddv", this.f15003j).put("p", jSONArray).put("tz", this.f15007n).put("geo", this.f15008o).put("delays", this.f15006m.first + ks.g.f9491d + this.f15006m.second);
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
            return null;
        }
    }

    public String a(long j10) {
        String string;
        String strValueOf = String.valueOf(j10);
        JSONObject jSONObject = this.f14998e;
        if (jSONObject == null || !jSONObject.has(strValueOf)) {
            string = null;
        } else {
            try {
                string = this.f14998e.getString(strValueOf);
            } catch (Exception e10) {
                y3.b.d(Log.getStackTraceString(e10));
                string = null;
            }
        }
        return TextUtils.isEmpty(string) ? this.f14997d : string;
    }

    public List<byte[]> b() {
        return this.f15005l;
    }

    public void d(int i10, int i11) {
        this.f15006m = new Pair<>(Integer.valueOf(i10), Integer.valueOf(i11));
    }

    public void e(String str) {
        this.f15003j = str;
    }

    public void f(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        this.f15004k.clear();
        this.f15005l.clear();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            this.f15004k.add(jSONArray.getString(i10));
            this.f15005l.add(jSONArray.getString(i10).getBytes());
        }
    }

    public void g(boolean z10) {
        this.f15002i = z10;
    }

    public boolean h(int i10) {
        if (this.f15000g == -1 || this.f14994a == -1) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = jCurrentTimeMillis - this.f15000g;
        if (Math.abs(j10) < this.f14994a) {
            return j10 >= 0 && this.f15001h < i10;
        }
        k(jCurrentTimeMillis);
        return true;
    }

    public long i() {
        return this.f14994a;
    }

    public void j(int i10) {
        if (i10 <= 0 || i10 >= 12) {
            i10 = 6;
        }
        this.f15008o = i10;
    }

    public void k(long j10) {
        this.f15000g = j10;
        this.f15001h = 0;
    }

    public void l(String str) {
        this.f15007n = str;
    }

    public void m(JSONObject jSONObject) {
        this.f14998e = jSONObject;
    }

    public void n(boolean z10) {
        this.f14996c = z10;
    }

    public int o() {
        return this.f15001h;
    }

    public void p(int i10) {
        this.f15001h = i10;
    }

    public void q(long j10) {
        this.f15000g = j10;
    }

    public void r(String str) {
        this.f14997d = str;
    }

    public int s() {
        try {
            int iIntValue = ((Integer) this.f15006m.first).intValue();
            int iIntValue2 = ((Integer) this.f15006m.second).intValue();
            int i10 = y3.d.f20693e;
            return new Random().nextInt((iIntValue2 - iIntValue) + 1) + iIntValue;
        } catch (Exception e10) {
            e10.printStackTrace();
            return 6;
        }
    }

    public void t(int i10) {
        this.f15009p = i10;
    }

    public void u(long j10) {
        this.f14994a = j10;
    }

    public long v() {
        return this.f14995b;
    }

    public void w(long j10) {
        if (j10 <= 0) {
            return;
        }
        this.f14995b = j10;
    }

    public String x() {
        return TextUtils.isEmpty(this.f15007n) ? "Asia/Shanghai" : this.f15007n;
    }

    public void y(long j10) {
        this.f14999f = j10;
    }

    public int z() {
        return this.f15009p;
    }
}
