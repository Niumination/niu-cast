package yd;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements DynamicAnimation.OnAnimationUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f11135a;

    public h(j jVar) {
        this.f11135a = jVar;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
    public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
        DynamicAnimation.OnAnimationUpdateListener onAnimationUpdateListener = this.f11135a.f11152r;
        if (onAnimationUpdateListener != null) {
            onAnimationUpdateListener.onAnimationUpdate(dynamicAnimation, f, f4);
        }
    }
}
