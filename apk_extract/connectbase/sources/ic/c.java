package ic;

import android.app.Activity;
import com.transsion.hubsdk.app.TranActivityClient;

/* JADX INFO: loaded from: classes2.dex */
public class c implements bf.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranActivityClient f7777a = new TranActivityClient();

    @Override // bf.c
    public void a(Activity activity, boolean z10) {
        if (this.f7777a == null) {
            this.f7777a = new TranActivityClient();
        }
        this.f7777a.setBackToDynamicIsland(activity, z10);
    }

    @Override // bf.c
    public void b(Activity activity, boolean z10) {
        if (this.f7777a == null) {
            this.f7777a = new TranActivityClient();
        }
        this.f7777a.setRecoveryWhenError(activity, z10);
    }
}
