package com.transsion.sdk.oneid.data;

import ad.c;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.transsion.widgetsliquid.utils.Utils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class RomInfo extends OneBaseInfo implements Serializable {
    public String api;
    public String aver;
    public String build_id;
    public String build_spv;
    public String buildt;
    public String buildv;
    public String fp;
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
        this.fp = "";
        this.aver = Build.VERSION.RELEASE;
        this.api = "" + Build.VERSION.SDK_INT;
        try {
            this.buildv = c.c(context, "ro.product.build.id");
        } catch (Exception unused) {
        }
        try {
            this.buildt = c.c(context, "ro.system.build.date.utc");
        } catch (Exception unused2) {
        }
        try {
            String strC = c.c(context, Utils.OS_TRANS_VERSION);
            this.osver = strC;
            if (TextUtils.isEmpty(strC)) {
                this.osver = c.c(context, "ro.os_product.version");
            }
        } catch (Exception unused3) {
        }
        try {
            this.build_id = c.c(context, "ro.system.build.id");
        } catch (Exception unused4) {
        }
        try {
            this.build_spv = c.c(context, "ro.vendor.build.security_patch");
        } catch (Exception unused5) {
        }
        try {
            this.gsmv = c.c(context, "gsm.version.baseband");
        } catch (Exception unused6) {
        }
        try {
            this.fp = c.c(context, "ro.build.fingerprint");
        } catch (Exception unused7) {
        }
    }
}
