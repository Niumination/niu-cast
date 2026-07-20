package m3;

import android.text.TextUtils;
import com.transsion.sdk.oneid.data.GroupFpInfo;

/* JADX INFO: loaded from: classes.dex */
public abstract class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f7693a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f7694b = false;

    public static String a() {
        if (!TextUtils.isEmpty(f7693a)) {
            return f7693a;
        }
        z6.a.a("OneID isEnable = true");
        String str = "";
        if (f7694b) {
            if (ad.b.f91c == null) {
                throw new IllegalStateException("You should call OneID.init first!");
            }
            ad.i iVar = (ad.i) ad.b.f91c.f92a;
            if (iVar != null) {
                try {
                    GroupFpInfo groupFpInfo = iVar.f105c;
                    if (groupFpInfo != null) {
                        str = groupFpInfo.vaid;
                    }
                } catch (Exception unused) {
                }
            }
        }
        f7693a = str;
        return str;
    }
}
