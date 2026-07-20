package com.transsion.sdk.oneid.data;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.Serializable;
import ki.d;

/* JADX INFO: loaded from: classes2.dex */
public class RomInfo extends OneBaseInfo implements Serializable {
    public String api;
    public String aver;
    public String build_id;
    public String build_spv;
    public String buildt;
    public String buildv;

    /* JADX INFO: renamed from: fp, reason: collision with root package name */
    public String f2298fp;
    public String gsmv;
    public String osver;

    public RomInfo(Context context) {
        this.aver = "";
        this.api = "";
        this.buildv = "";
        this.buildt = "";
        this.osver = "";
        this.build_id = "";
        this.build_spv = "";
        this.gsmv = "";
        this.f2298fp = "";
        this.aver = Build.VERSION.RELEASE;
        this.api = "" + Build.VERSION.SDK_INT;
        try {
            this.buildv = d.e(context, "ro.product.build.id");
        } catch (Exception unused) {
        }
        try {
            this.buildt = d.e(context, "ro.system.build.date.utc");
        } catch (Exception unused2) {
        }
        try {
            String strE = d.e(context, "ro.tranos.version");
            this.osver = strE;
            if (TextUtils.isEmpty(strE)) {
                this.osver = d.e(context, "ro.os_product.version");
            }
        } catch (Exception unused3) {
        }
        try {
            this.build_id = d.e(context, "ro.system.build.id");
        } catch (Exception unused4) {
        }
        try {
            this.build_spv = d.e(context, "ro.vendor.build.security_patch");
        } catch (Exception unused5) {
        }
        try {
            this.gsmv = d.e(context, "gsm.version.baseband");
        } catch (Exception unused6) {
        }
        try {
            this.f2298fp = d.e(context, "ro.build.fingerprint");
        } catch (Exception unused7) {
        }
    }
}
