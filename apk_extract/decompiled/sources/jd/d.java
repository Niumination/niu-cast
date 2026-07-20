package jd;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements DynamicAnimation.OnAnimationEndListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f6153a;

    public d(i iVar) {
        this.f6153a = iVar;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z2, float f, float f4) {
        i iVar = this.f6153a;
        if (z2) {
            iVar.f6165b = f;
        } else {
            iVar.getClass();
            iVar.f6165b = 1.0f;
        }
        iVar.f6166c = iVar.f6164a;
        f fVar = iVar.f6175o;
        if (fVar != null) {
            fVar.a(false, dynamicAnimation, z2, iVar.q, f, f4);
        }
    }
}
