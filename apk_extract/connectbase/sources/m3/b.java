package m3;

import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f10370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10371c;

    public b(long j10, long j11, String str) {
        this.f10369a = j10;
        this.f10370b = j11;
        this.f10371c = str;
    }

    public b(String str) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        this.f10369a = jSONObject.getLong("serverTime");
        this.f10370b = jSONObject.getLong("elapsedRealtime");
        this.f10371c = jSONObject.getString("bootId");
    }
}
