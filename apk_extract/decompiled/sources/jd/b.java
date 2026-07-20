package jd;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements DynamicAnimation.OnAnimationEndListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f6151a;

    public b(i iVar) {
        this.f6151a = iVar;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z2, float f, float f4) {
        i iVar = this.f6151a;
        if (z2) {
            iVar.f6165b = f;
        } else {
            iVar.f6165b = iVar.f6164a;
        }
        iVar.getClass();
        iVar.f6166c = 1.0f;
        f fVar = iVar.f6175o;
        if (fVar != null) {
            fVar.a(true, dynamicAnimation, z2, iVar.q, f, f4);
        }
    }
}
