package com.transsion.sdk.oneid.data;

import android.content.Context;
import android.text.TextUtils;
import dr.b;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class UserIdInfo extends OneBaseInfo implements Serializable {
    public String account_id;
    public String account_type;
    public String tripartite_id;
    public String tripartite_type;

    public UserIdInfo(Context context) {
        this.account_id = "";
        this.account_type = "";
        this.tripartite_id = "";
        this.tripartite_type = "";
        try {
            String strF = b.b(context).f(cb.b.c.f1409p);
            if (TextUtils.isEmpty(strF)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strF);
            this.account_type = jSONObject.optString("account_type");
            this.account_id = jSONObject.optString("account_id");
            this.tripartite_type = jSONObject.optString("tripartite_type");
            this.tripartite_id = jSONObject.optString("tripartite_id");
        } catch (Exception unused) {
        }
    }

    public void setAccount(String str, String str2) {
        this.account_type = str;
        this.account_id = str2;
    }

    public void setAccount_id(String str) {
        this.account_id = str;
    }

    public void setAccount_type(String str) {
        this.account_type = str;
    }

    public void setTripartite(String str, String str2) {
        this.tripartite_type = str;
        this.tripartite_id = str2;
    }

    public void setTripartite_id(String str) {
        this.tripartite_id = str;
    }

    public void setTripartite_type(String str) {
        this.tripartite_type = str;
    }
}
