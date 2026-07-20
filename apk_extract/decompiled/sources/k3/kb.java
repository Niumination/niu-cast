package k3;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class kb {
    public static void a(JSONObject jSONObject, String str, k7.d dVar) throws JSONException {
        if (dVar != null) {
            jSONObject.put(str, dVar.a());
        }
    }
}
