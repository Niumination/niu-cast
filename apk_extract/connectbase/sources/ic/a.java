package ic;

import android.app.ActionBar;
import com.transsion.hubsdk.app.TranActionBar;

/* JADX INFO: loaded from: classes2.dex */
public class a implements bf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranActionBar f7767a;

    @Override // bf.a
    public void a(ActionBar actionBar, boolean z10) {
        b().setShowHideAnimationEnabled(actionBar, z10);
    }

    public final TranActionBar b() {
        if (this.f7767a == null) {
            this.f7767a = new TranActionBar();
        }
        return this.f7767a;
    }
}
