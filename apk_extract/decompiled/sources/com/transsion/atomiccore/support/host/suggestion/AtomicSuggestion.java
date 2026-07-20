package com.transsion.atomiccore.support.host.suggestion;

import androidx.annotation.Keep;
import k3.k1;
import l7.a;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class AtomicSuggestion {
    private static final String TAG = "AtomicSuggestion";
    private final AtomicSuggestionDefaultData defaultData;

    public AtomicSuggestion(a aVar) {
        throw null;
    }

    public AtomicSuggestionDefaultData getDefaultData() {
        return this.defaultData;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        AtomicSuggestionDefaultData atomicSuggestionDefaultData = this.defaultData;
        if (atomicSuggestionDefaultData == null) {
            return jSONObject;
        }
        try {
            jSONObject.put("data", atomicSuggestionDefaultData.dataJSONObject());
            jSONObject.put("actions", this.defaultData.actionJSONObject());
        } catch (JSONException e) {
            k1.b(TAG, "toJSONObject: " + e.getMessage());
        }
        return jSONObject;
    }
}
