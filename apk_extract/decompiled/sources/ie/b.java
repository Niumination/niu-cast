package ie;

import androidx.dynamicanimation.animation.FloatPropertyCompat;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends FloatPropertyCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f5761a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar) {
        super("scrollerSpring");
        this.f5761a = cVar;
    }

    @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
    public final float getValue(Object obj) {
        return ((c) obj).f5769i;
    }

    @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
    public final void setValue(Object obj, float f) {
        this.f5761a.f5769i = (int) f;
    }
}
