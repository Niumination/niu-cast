package s9;

import com.transsion.hubsdk.os.TranSystemProperties;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements da.a {
    @Override // da.a
    public final boolean a(String str) {
        return TranSystemProperties.getBoolean(str, false);
    }

    @Override // da.a
    public final String b(String str, String str2) {
        return TranSystemProperties.get(str, str2);
    }
}
