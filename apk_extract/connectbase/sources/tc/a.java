package tc;

import android.content.Context;
import com.transsion.hubsdk.factorymode.TranFactoryModeManager;

/* JADX INFO: loaded from: classes2.dex */
public class a implements mf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranFactoryModeManager f15554a;

    public a() {
        if (this.f15554a == null) {
            this.f15554a = new TranFactoryModeManager();
        }
    }

    @Override // mf.a
    public boolean a(String str, Context context) {
        TranFactoryModeManager tranFactoryModeManager = this.f15554a;
        if (tranFactoryModeManager != null) {
            return tranFactoryModeManager.isFactoryCode(str, context);
        }
        return false;
    }
}
