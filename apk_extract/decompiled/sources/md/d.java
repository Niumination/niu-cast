package md;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.Path;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f8001d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ e f8002g;

    public d(e eVar, int i8, int i9, int i10, int i11, int i12, int i13) {
        this.f8002g = eVar;
        this.f7998a = i8;
        this.f7999b = i9;
        this.f8000c = i10;
        this.f8001d = i11;
        this.e = i12;
        this.f = i13;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        e eVar = this.f8002g;
        eVar.p = animatedFraction;
        Object animatedValue = valueAnimator.getAnimatedValue("pvh_stroke_color");
        if (animatedValue instanceof Float) {
            float fFloatValue = ((Float) animatedValue).floatValue();
            eVar.f8008i = Color.argb(255, (int) ((this.f7999b * fFloatValue) + this.f7998a), (int) ((this.f8001d * fFloatValue) + this.f8000c), (int) ((this.f * fFloatValue) + this.e));
        }
        Object animatedValue2 = valueAnimator.getAnimatedValue("pvh_outer_radius");
        if (animatedValue2 instanceof Float) {
            eVar.f8010k = ((Float) animatedValue2).floatValue();
        }
        Object animatedValue3 = valueAnimator.getAnimatedValue("pvh_inner_radius");
        if (animatedValue3 instanceof Float) {
            eVar.f8012m = ((Float) animatedValue3).floatValue();
        }
        eVar.e.reset();
        Path path = eVar.e;
        float f = eVar.f8010k;
        Path.Direction direction = Path.Direction.CCW;
        path.addCircle(0.0f, 0.0f, f, direction);
        eVar.f8007h.reset();
        eVar.f8007h.addCircle(0.0f, 0.0f, eVar.f8012m, direction);
        eVar.invalidateSelf();
    }
}
