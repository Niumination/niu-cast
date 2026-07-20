package re;

import android.graphics.Insets;
import android.view.WindowInsetsAnimationController;
import com.transsion.hubsdk.view.TranWindowInsetsAnimationController;

/* JADX INFO: loaded from: classes2.dex */
public class o implements lh.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranWindowInsetsAnimationController f14480a;

    @Override // lh.o
    public void a(WindowInsetsAnimationController windowInsetsAnimationController, Insets insets, float f10, float f11, boolean z10, boolean z11) {
        b().setInsetsAndAlpha(windowInsetsAnimationController, insets, f10, f11, z10, z11);
    }

    public final TranWindowInsetsAnimationController b() {
        if (this.f14480a == null) {
            this.f14480a = new TranWindowInsetsAnimationController();
        }
        return this.f14480a;
    }
}
