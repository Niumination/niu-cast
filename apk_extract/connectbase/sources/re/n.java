package re;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.transsion.hubsdk.view.TranViewRootImpl;

/* JADX INFO: loaded from: classes2.dex */
public class n implements lh.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranViewRootImpl f14479a = new TranViewRootImpl();

    @Override // lh.m
    public void a(View view) {
        this.f14479a.notifyInsetsChanged(view);
    }

    @Override // lh.m
    public Drawable b(View view, int i10, int i11, float f10) {
        return this.f14479a.createBackgroundBlurDrawable(view, i10, i11, f10);
    }

    @Override // lh.m
    public Drawable c(View view, int i10) {
        return this.f14479a.createBackgroundBlurDrawable(view, i10);
    }
}
