package xi;

import android.view.View;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SpringAnimation f20174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f20175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f20176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f20177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f20178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f20179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FloatPropertyCompat<View> f20180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f20181h;

    /* JADX INFO: renamed from: xi.b$b, reason: collision with other inner class name */
    public static class C0502b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f20183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f20184c;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public FloatPropertyCompat<View> f20187f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f20185d = 350.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f20186e = 1.2f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f20182a = 1.0f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f20188g = 0.0f;

        public SpringAnimation h() {
            if (this.f20184c == null) {
                throw new IllegalStateException("view == null");
            }
            if (this.f20187f != null) {
                return new b(this).f20174a;
            }
            throw new IllegalStateException("property == null");
        }

        public C0502b i(float f10) {
            this.f20186e = f10;
            return this;
        }

        public C0502b j(float f10) {
            this.f20183b = f10;
            return this;
        }

        public C0502b k(FloatPropertyCompat<View> floatPropertyCompat) {
            this.f20187f = floatPropertyCompat;
            return this;
        }

        public C0502b l(float f10) {
            this.f20182a = f10;
            return this;
        }

        public C0502b m(float f10) {
            this.f20185d = f10;
            return this;
        }

        public C0502b n(float f10) {
            this.f20188g = f10;
            return this;
        }

        public C0502b o(View view) {
            this.f20184c = view;
            return this;
        }
    }

    public static SpringAnimation a(b bVar) {
        return bVar.f20174a;
    }

    public final b b() {
        SpringForce dampingRatio = new SpringForce().setStiffness(this.f20178e).setDampingRatio(this.f20179f);
        dampingRatio.setFinalPosition(this.f20176c);
        SpringAnimation springAnimation = new SpringAnimation(this.f20177d, this.f20180g);
        this.f20174a = springAnimation;
        springAnimation.setSpring(dampingRatio);
        this.f20174a.setStartValue(this.f20175b);
        this.f20174a.setStartVelocity(this.f20181h);
        this.f20174a.setMinimumVisibleChange(0.002f);
        return this;
    }

    public final SpringAnimation c() {
        return this.f20174a;
    }

    public b(C0502b c0502b) {
        this.f20175b = c0502b.f20182a;
        this.f20176c = c0502b.f20183b;
        this.f20177d = c0502b.f20184c;
        this.f20178e = c0502b.f20185d;
        this.f20179f = c0502b.f20186e;
        this.f20180g = c0502b.f20187f;
        this.f20181h = c0502b.f20188g;
        b();
    }
}
