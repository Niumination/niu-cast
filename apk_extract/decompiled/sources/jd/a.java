package jd;

import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements DynamicAnimation.OnAnimationUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f6150a;

    public a(i iVar) {
        this.f6150a = iVar;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
    public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
        i iVar = this.f6150a;
        WeakReference weakReference = iVar.f6171k;
        if (weakReference == null || weakReference.get() == null) {
            if (dynamicAnimation == null || !dynamicAnimation.isRunning()) {
                return;
            }
            dynamicAnimation.cancel();
            return;
        }
        View view = (View) iVar.f6171k.get();
        view.setScaleX(f);
        view.setScaleY(f);
        g gVar = iVar.p;
        if (gVar != null) {
            gVar.c(dynamicAnimation, true, f, f4);
        }
    }
}
