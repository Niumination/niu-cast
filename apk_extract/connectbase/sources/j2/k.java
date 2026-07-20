package j2;

import java.util.HashMap;
import kn.l0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final HashMap<String, j> f8551a;

    public k(@l JSONObject jSONObject) throws JSONException {
        l0.p(jSONObject, "json");
        this.f8551a = new HashMap<>();
        JSONArray jSONArray = jSONObject.getJSONArray("src");
        int i10 = 0;
        int length = jSONArray == null ? 0 : jSONArray.length();
        if (length <= 0) {
            return;
        }
        while (true) {
            int i11 = i10 + 1;
            JSONObject jSONObject2 = jSONArray == null ? null : jSONArray.getJSONObject(i10);
            if (jSONObject2 != null) {
                j jVar = new j(jSONObject2);
                if (jVar.f8538f != j.d.UNKNOWN) {
                    this.f8551a.put(jVar.f8533a, jVar);
                }
            }
            if (i11 >= length) {
                return;
            } else {
                i10 = i11;
            }
        }
    }

    @l
    public final HashMap<String, j> a() {
        return this.f8551a;
    }
}
