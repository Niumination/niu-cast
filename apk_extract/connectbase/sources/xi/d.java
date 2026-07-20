package xi;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SpringAnimation f20222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f20223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f20224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f20225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f20226e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FloatValueHolder f20227f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f20228g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DynamicAnimation.OnAnimationUpdateListener f20229h;

    public static class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f20231b;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public FloatValueHolder f20234e;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public DynamicAnimation.OnAnimationUpdateListener f20236g;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f20232c = 350.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f20233d = 1.2f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f20230a = 1.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f20235f = 0.0f;

        public b h(DynamicAnimation.OnAnimationUpdateListener onAnimationUpdateListener) {
            this.f20236g = onAnimationUpdateListener;
            return this;
        }

        public SpringAnimation i() {
            if (this.f20234e != null) {
                return new d(this).f20222a;
            }
            throw new IllegalStateException("property == null");
        }

        public b j(float f10) {
            this.f20233d = f10;
            return this;
        }

        public b k(float f10) {
            this.f20231b = f10;
            return this;
        }

        public b l(FloatValueHolder floatValueHolder) {
            this.f20234e = floatValueHolder;
            return this;
        }

        public b m(float f10) {
            this.f20230a = f10;
            return this;
        }

        public b n(float f10) {
            this.f20232c = f10;
            return this;
        }

        public b o(float f10) {
            this.f20235f = f10;
            return this;
        }
    }

    public static SpringAnimation a(d dVar) {
        return dVar.f20222a;
    }

    public final d b() {
        SpringForce dampingRatio = new SpringForce().setStiffness(this.f20225d).setDampingRatio(this.f20226e);
        dampingRatio.setFinalPosition(this.f20224c);
        SpringAnimation springAnimation = new SpringAnimation(this.f20227f);
        this.f20222a = springAnimation;
        springAnimation.setSpring(dampingRatio);
        this.f20222a.setStartValue(this.f20223b);
        this.f20222a.setStartVelocity(this.f20228g);
        this.f20222a.setMinimumVisibleChange(0.002f);
        DynamicAnimation.OnAnimationUpdateListener onAnimationUpdateListener = this.f20229h;
        if (onAnimationUpdateListener != null) {
            this.f20222a.addUpdateListener(onAnimationUpdateListener);
        }
        return this;
    }

    public final SpringAnimation c() {
        return this.f20222a;
    }

    public d(b bVar) {
        this.f20223b = bVar.f20230a;
        this.f20224c = bVar.f20231b;
        this.f20225d = bVar.f20232c;
        this.f20226e = bVar.f20233d;
        this.f20227f = bVar.f20234e;
        this.f20228g = bVar.f20235f;
        this.f20229h = bVar.f20236g;
        b();
    }
}
