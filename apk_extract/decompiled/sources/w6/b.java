package w6;

import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f10671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10672c;

    public b(long j8, long j10, String str) {
        this.f10670a = j8;
        this.f10671b = j10;
        this.f10672c = str;
    }

    public b(String str) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        this.f10670a = jSONObject.getLong("serverTime");
        this.f10671b = jSONObject.getLong("elapsedRealtime");
        this.f10672c = jSONObject.getString("bootId");
    }
}
