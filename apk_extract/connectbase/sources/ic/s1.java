package ic;

import android.content.res.Configuration;
import android.graphics.Rect;
import com.transsion.hubsdk.app.TranWindowConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public class s1 implements bf.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranWindowConfiguration f7892a = new TranWindowConfiguration();

    @Override // bf.s
    public boolean a(int i10) {
        return TranWindowConfiguration.inMultiWindowMode(i10);
    }

    @Override // bf.s
    public Rect b(Configuration configuration) {
        return this.f7892a.getBounds(configuration);
    }

    @Override // bf.s
    public boolean c(Configuration configuration) {
        return this.f7892a.isThunderbackWindow(configuration);
    }
}
