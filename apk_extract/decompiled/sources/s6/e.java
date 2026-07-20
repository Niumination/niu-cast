package s6;

import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public JSONObject e;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f9566j;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f9570n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f9559a = 86400000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f9560b = 150000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9561c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f9562d = "";
    public long f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f9563g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9564h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f9565i = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f9567k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f9568l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Pair f9569m = new Pair(3, 6);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f9571o = 6;
    public int p = 10;

    public static e a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                e eVar = new e();
                eVar.f9559a = jSONObject.getLong("pd");
                eVar.f9560b = jSONObject.getLong("th");
                eVar.f9561c = jSONObject.getBoolean("once");
                if (jSONObject.has("url")) {
                    eVar.f9562d = jSONObject.getString("url");
                }
                if (jSONObject.has("tidUrls")) {
                    eVar.e = jSONObject.getJSONObject("tidUrls");
                }
                eVar.f = jSONObject.getLong("version");
                eVar.f9563g = jSONObject.getLong("npt");
                eVar.f9564h = jSONObject.getInt("rt");
                eVar.f9565i = jSONObject.getBoolean("dd");
                eVar.f9566j = jSONObject.optString("ddv", null);
                if (jSONObject.has("p")) {
                    eVar.b(jSONObject.getJSONArray("p"));
                }
                if (jSONObject.has("delays")) {
                    String[] strArrSplit = jSONObject.getString("delays").split(",");
                    eVar.f9569m = new Pair(Integer.valueOf(Integer.parseInt(strArrSplit[0])), Integer.valueOf(Integer.parseInt(strArrSplit[1])));
                }
                if (jSONObject.has("tz")) {
                    eVar.f9570n = jSONObject.getString("tz");
                }
                int i8 = 6;
                int iOptInt = jSONObject.optInt("geo", 6);
                if (iOptInt > 0 && iOptInt < 12) {
                    i8 = iOptInt;
                }
                eVar.f9571o = i8;
                if (jSONObject.has("dlt")) {
                    eVar.p = jSONObject.getInt("dlt");
                }
                return eVar;
            } catch (Exception e) {
                z6.a.c(Log.getStackTraceString(e));
            }
        }
        return null;
    }

    public final void b(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        ArrayList arrayList = this.f9567k;
        arrayList.clear();
        ArrayList arrayList2 = this.f9568l;
        arrayList2.clear();
        for (int i8 = 0; i8 < jSONArray.length(); i8++) {
            arrayList.add(jSONArray.getString(i8));
            arrayList2.add(jSONArray.getString(i8).getBytes());
        }
    }

    public final JSONObject c() {
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.f9567k.iterator();
            while (it.hasNext()) {
                jSONArray.put((String) it.next());
            }
            return new JSONObject().put("pd", this.f9559a).put("dlt", this.p).put("th", this.f9560b).put("once", this.f9561c).put("url", this.f9562d).put("tidUrls", this.e).put("version", this.f).put("npt", this.f9563g).put("rt", this.f9564h).put("dd", this.f9565i).put("ddv", this.f9566j).put("p", jSONArray).put("tz", this.f9570n).put("geo", this.f9571o).put("delays", this.f9569m.first + "," + this.f9569m.second);
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
            return null;
        }
    }
}
