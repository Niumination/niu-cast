package ce;

import com.transsion.hubsdk.provider.TranDeviceConfig;

/* JADX INFO: loaded from: classes2.dex */
public class a implements wg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1450a = "a";

    @Override // wg.a
    public int a(String str, String str2, int i10) {
        return TranDeviceConfig.getInt(str, str2, i10);
    }

    @Override // wg.a
    public boolean b(String str, String str2, boolean z10) {
        return TranDeviceConfig.getBoolean(str, str2, z10);
    }
}
