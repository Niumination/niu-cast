package com.transsion.sdk.oneid.data;

import ad.i;
import android.content.Context;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import e9.c;
import java.io.File;
import java.io.Serializable;
import java.util.UUID;
import org.json.JSONObject;
import sj.a;

/* JADX INFO: loaded from: classes2.dex */
public class GroupFpInfo extends OneBaseInfo implements Serializable {
    public DeviceInfo device;
    public UniqueIdInfo dids;
    public EnvironInfo env;
    public FingerprintInfo fp;
    public PackageInfo pkg;
    public RomInfo rom;
    public UserIdInfo user;
    public String vaid;

    public GroupFpInfo(Context context, Handler.Callback callback) {
        String strD;
        String packageName = context.getPackageName();
        try {
            this.vaid = a.a(context).e("vaid");
        } catch (Exception unused) {
        }
        try {
            if (TextUtils.isEmpty(this.vaid)) {
                try {
                    String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    if (!TextUtils.isEmpty(string)) {
                        this.vaid = UUID.nameUUIDFromBytes((packageName + string).getBytes()).toString();
                    }
                } catch (Exception unused2) {
                }
                if (TextUtils.isEmpty(this.vaid)) {
                    this.vaid = UUID.randomUUID().toString();
                }
                a.a(context).c("vaid", this.vaid);
            }
            try {
                File file = new File(c.a());
                if (context.checkCallingOrSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0 && context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    String strOptString = "";
                    if (file.exists() && (strD = ad.c.d(file)) != null && strD.length() > 0) {
                        ad.c.g("read vaid success");
                        strOptString = new JSONObject(strD).optString(packageName, "");
                    }
                    if (!TextUtils.equals(strOptString, this.vaid)) {
                        i.a(context).d(new IdChangeInfo("vaid", strOptString, this.vaid));
                    }
                }
            } catch (Exception e) {
                ad.c.h(e.getMessage());
            }
        } catch (Exception unused3) {
        }
        this.dids = new UniqueIdInfo(context, callback);
        this.user = new UserIdInfo(context);
        this.pkg = new PackageInfo(context);
        this.env = new EnvironInfo(context);
        this.device = new DeviceInfo(context);
        this.fp = new FingerprintInfo(context);
        this.rom = new RomInfo(context);
    }
}
