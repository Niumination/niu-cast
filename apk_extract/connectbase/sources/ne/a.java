package ne;

import com.transsion.hubsdk.tranthubutils.TranAppProperties;

/* JADX INFO: loaded from: classes2.dex */
public class a implements hh.a {
    @Override // hh.a
    public boolean a(String str, boolean z10) {
        return TranAppProperties.getBoolean(str, z10);
    }

    @Override // hh.a
    public void b(String str) {
        TranAppProperties.initialize(str);
    }

    @Override // hh.a
    public String get(String str) {
        return TranAppProperties.get(str);
    }
}
