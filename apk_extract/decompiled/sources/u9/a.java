package u9;

import com.transsion.hubsdk.tranthubutils.TranAppProperties;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements fa.a {
    @Override // fa.a
    public final void a(String str) {
        TranAppProperties.initialize(str);
    }

    @Override // fa.a
    public final String get(String str) {
        return TranAppProperties.get(str);
    }
}
