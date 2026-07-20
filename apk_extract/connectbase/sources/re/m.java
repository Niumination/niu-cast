package re;

import com.transsion.hubsdk.view.TranViewConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public class m implements lh.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranViewConfiguration f14478a = new TranViewConfiguration();

    @Override // lh.l
    public int a() {
        TranViewConfiguration tranViewConfiguration = this.f14478a;
        if (tranViewConfiguration != null) {
            return tranViewConfiguration.getHoverTapSlop();
        }
        return 20;
    }

    @Override // lh.l
    public int b() {
        TranViewConfiguration tranViewConfiguration = this.f14478a;
        if (tranViewConfiguration != null) {
            return tranViewConfiguration.getHoverTapTimeout();
        }
        return 150;
    }
}
