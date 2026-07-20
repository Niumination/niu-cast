package com.transsion.sdk.oneid.data;

import android.content.Context;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import com.transsion.sdk.oneid.a;
import dr.b;
import java.io.File;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import ki.c;
import ki.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GroupFpInfo extends OneBaseInfo implements Serializable {
    public DeviceInfo device;
    public UniqueIdInfo dids;
    public EnvironInfo env;

    /* JADX INFO: renamed from: fp, reason: collision with root package name */
    public FingerprintInfo f2297fp;
    public PackageInfo pkg;
    public RomInfo rom;
    public UserIdInfo user;
    public String vaid;

    public GroupFpInfo(Context context, Handler.Callback callback) {
        String strF;
        String packageName = context.getPackageName();
        try {
            this.vaid = b.b(context).f("vaid");
        } catch (Exception unused) {
        }
        try {
            String strOptString = "";
            if (TextUtils.isEmpty(this.vaid)) {
                try {
                    String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(packageName)) {
                        this.vaid = UUID.nameUUIDFromBytes((packageName + string).replaceAll("[^a-zA-Z0-9._-]", "").getBytes(StandardCharsets.UTF_8)).toString();
                    }
                } catch (Exception unused2) {
                }
                if (TextUtils.isEmpty(this.vaid)) {
                    this.vaid = UUID.randomUUID().toString();
                }
                b.b(context).d("vaid", this.vaid);
            }
            try {
                File file = new File(c.a());
                if (context.checkCallingOrSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0 && context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    if (file.exists() && (strF = d.f(file)) != null && strF.length() > 0) {
                        d.i("read vaid success");
                        strOptString = new JSONObject(strF).optString(packageName, "");
                    }
                    if (!TextUtils.equals(strOptString, this.vaid)) {
                        a.a(context).f(new IdChangeInfo("vaid", strOptString, this.vaid));
                    }
                }
            } catch (Exception e10) {
                d.m(e10.getMessage());
            }
        } catch (Exception unused3) {
        }
        this.dids = new UniqueIdInfo(context, callback);
        this.user = new UserIdInfo(context);
        this.pkg = new PackageInfo(context);
        this.env = new EnvironInfo(context);
        this.device = new DeviceInfo(context);
        this.f2297fp = new FingerprintInfo(context);
        this.rom = new RomInfo(context);
    }
}
