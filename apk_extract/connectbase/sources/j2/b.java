package j2;

import android.util.SparseArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kn.l0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final SparseArray<c> f8479a;

    public b(@l JSONObject jSONObject) throws JSONException {
        l0.p(jSONObject, "json");
        this.f8479a = new SparseArray<>();
        JSONArray jSONArray = jSONObject.getJSONArray(TypedValues.AttributesType.S_FRAME);
        int i10 = 0;
        int length = jSONArray == null ? 0 : jSONArray.length();
        if (length <= 0) {
            return;
        }
        while (true) {
            int i11 = i10 + 1;
            JSONObject jSONObject2 = jSONArray == null ? null : jSONArray.getJSONObject(i10);
            if (jSONObject2 != null) {
                c cVar = new c(jSONObject2);
                this.f8479a.put(cVar.f8480a, cVar);
            }
            if (i11 >= length) {
                return;
            } else {
                i10 = i11;
            }
        }
    }

    @l
    public final SparseArray<c> a() {
        return this.f8479a;
    }
}
