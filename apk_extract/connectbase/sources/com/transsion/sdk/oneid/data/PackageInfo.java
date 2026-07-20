package com.transsion.sdk.oneid.data;

import android.content.Context;
import android.provider.Settings;
import b.a;
import java.io.Serializable;
import ki.d;

/* JADX INFO: loaded from: classes2.dex */
public class PackageInfo extends OneBaseInfo implements Serializable {
    public String pkg;
    public String signatures;
    public String ssaid;

    @a({"PackageManagerGetSignatures"})
    public PackageInfo(Context context) {
        this.pkg = "";
        this.signatures = "";
        this.ssaid = "";
        this.pkg = context.getPackageName();
        this.signatures = d.l(context, "SHA-256");
        try {
            this.ssaid = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
        }
        if (this.ssaid == null) {
            this.ssaid = "";
        }
    }
}
