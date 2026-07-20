package com.transsion.atomiccore.support.host;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.transsion.message.bank.MessageBank;
import k3.k1;
import k7.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class AtomicAction {
    private final String action;
    private final String category;
    private final String componentName;
    private final int flags;
    private final int mActionFlags;
    private final JSONObject mOptions;
    private final int mRequestCode;
    private final String packageName;
    private final JSONObject params;
    private final String type;
    private final String uri;

    public /* synthetic */ AtomicAction(a aVar, int i8) {
        this(aVar);
    }

    public String getAction() {
        return this.action;
    }

    public String getCategory() {
        return this.category;
    }

    public String getComponentName() {
        return this.componentName;
    }

    public int getFlags() {
        return this.flags;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public JSONObject getParams() {
        return this.params;
    }

    public String getType() {
        return this.type;
    }

    public String getUri() {
        return this.uri;
    }

    @NonNull
    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MessageBank.KEY_TYPE, this.type);
            jSONObject.put("packageName", this.packageName);
            jSONObject.put("action", this.action);
            jSONObject.put("category", this.category);
            jSONObject.put("componentName", this.componentName);
            jSONObject.put("flags", this.flags);
            JSONObject jSONObject2 = this.params;
            if (jSONObject2 != null) {
                jSONObject.put("params", jSONObject2);
            }
            String str = this.uri;
            if (str != null) {
                jSONObject.put("uri", str);
            }
            int i8 = this.mActionFlags;
            if (i8 != 0) {
                jSONObject.put("actionFlags", i8);
            }
            int i9 = this.mRequestCode;
            if (i9 != 0) {
                jSONObject.put("requestCode", i9);
            }
            JSONObject jSONObject3 = this.mOptions;
            if (jSONObject3 != null) {
                jSONObject.put("options", jSONObject3);
            }
        } catch (Exception e) {
            k1.b("Error converting AtomicAction to JSONObject", e.toString());
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        return toJSONObject().toString();
    }

    private AtomicAction(a aVar) {
        this.type = aVar.f6780a;
        this.packageName = aVar.f6781b;
        this.action = aVar.f6783d;
        this.category = null;
        this.params = aVar.e;
        this.componentName = aVar.f6782c;
        this.flags = 0;
        this.mActionFlags = 0;
        this.mRequestCode = 0;
        this.uri = null;
        this.mOptions = null;
    }
}
