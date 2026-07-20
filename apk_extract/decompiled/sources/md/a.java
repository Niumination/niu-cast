package md;

import android.animation.ValueAnimator;
import android.graphics.PathMeasure;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7973d;
    public final /* synthetic */ float e;
    public final /* synthetic */ float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c f7974g;

    public a(c cVar, int i8, int i9, int i10, int i11, float f, float f4) {
        this.f7974g = cVar;
        this.f7970a = i8;
        this.f7971b = i9;
        this.f7972c = i10;
        this.f7973d = i11;
        this.e = f;
        this.f = f4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        c cVar = this.f7974g;
        cVar.D = animatedFraction;
        Object animatedValue = valueAnimator.getAnimatedValue("pvh_border_scale");
        Object animatedValue2 = valueAnimator.getAnimatedValue("pvh_frame_scale");
        if (animatedValue instanceof Float) {
            float fFloatValue = ((Float) animatedValue).floatValue();
            cVar.f7984j = (int) ((this.f7971b * fFloatValue) + this.f7970a);
            cVar.f7985k = (int) ((this.f7973d * fFloatValue) + this.f7972c);
            cVar.f7986l = 255;
            cVar.p = (int) ((this.f * fFloatValue) + this.e);
            cVar.f7987m = fFloatValue;
        }
        if (animatedValue2 instanceof Float) {
            cVar.f7988n = ((Float) animatedValue2).floatValue();
        }
        cVar.u.reset();
        PathMeasure pathMeasure = cVar.f7993v;
        pathMeasure.getSegment(cVar.f7990r, pathMeasure.getLength() - cVar.f7990r, cVar.u, true);
        cVar.f7992t.reset();
        cVar.invalidateSelf();
    }
}
