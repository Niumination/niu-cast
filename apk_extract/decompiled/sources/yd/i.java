package yd;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements DynamicAnimation.OnAnimationEndListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f11136a;

    public i(j jVar) {
        this.f11136a = jVar;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z2, float f, float f4) {
        j jVar = this.f11136a;
        jVar.b();
        jVar.f11150n = 0;
        jVar.f11140b = (int) f;
    }
}
