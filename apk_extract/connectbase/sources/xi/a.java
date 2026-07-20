package xi;

import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet<SpringAnimation> f20160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f20161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f20162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f20163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f20164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f20165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f20166g;

    /* JADX INFO: renamed from: xi.a$a, reason: collision with other inner class name */
    public class C0501a implements DynamicAnimation.OnAnimationEndListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f20167a;

        public C0501a(int[] iArr) {
            this.f20167a = iArr;
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
        public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z10, float f10, float f11) {
            int[] iArr = this.f20167a;
            int i10 = iArr[0] - 1;
            iArr[0] = i10;
            if (i10 == 0) {
                a.this.f20166g.a(false, f10);
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f20170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f20171c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f20172d = 790.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f20173e = 1.2f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f20169a = 1.0f;

        public a f() {
            if (this.f20171c == null) {
                throw new IllegalStateException("view == null");
            }
            if (this.f20170b != 0.0f) {
                return new a(this);
            }
            throw new IllegalStateException("finalValue == null");
        }

        public b g(float f10) {
            this.f20173e = f10;
            return this;
        }

        public b h(float f10) {
            this.f20170b = f10;
            return this;
        }

        public b i(float f10) {
            this.f20169a = f10;
            return this;
        }

        public b j(float f10) {
            this.f20172d = f10;
            return this;
        }

        public b k(View view) {
            this.f20171c = view;
            return this;
        }
    }

    public interface c {
        void a(boolean z10, float f10);
    }

    public /* synthetic */ a(b bVar, C0501a c0501a) {
        this(bVar);
    }

    public void b(c cVar) {
        this.f20166g = cVar;
    }

    public void c() {
        if (this.f20160a.size() > 0) {
            Iterator<SpringAnimation> it = this.f20160a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }
    }

    public final void d() {
        this.f20160a = new HashSet<>();
        SpringForce dampingRatio = new SpringForce().setStiffness(this.f20164e).setDampingRatio(this.f20165f);
        dampingRatio.setFinalPosition(this.f20162c);
        this.f20160a.add(e(dampingRatio, true));
        this.f20160a.add(e(dampingRatio, false));
    }

    public final SpringAnimation e(SpringForce springForce, boolean z10) {
        SpringAnimation springAnimation = z10 ? new SpringAnimation(this.f20163d, DynamicAnimation.SCALE_X) : new SpringAnimation(this.f20163d, DynamicAnimation.SCALE_Y);
        springAnimation.setSpring(springForce);
        springAnimation.setStartValue(this.f20161b);
        springAnimation.setMinimumVisibleChange(0.002f);
        return springAnimation;
    }

    public boolean f() {
        if (this.f20160a.size() <= 0) {
            return false;
        }
        Iterator<SpringAnimation> it = this.f20160a.iterator();
        while (it.hasNext()) {
            if (it.next().isRunning()) {
                return true;
            }
        }
        return false;
    }

    public void g() {
        int[] iArr = {this.f20160a.size()};
        if (this.f20160a.size() > 0) {
            for (SpringAnimation springAnimation : this.f20160a) {
                springAnimation.start();
                if (this.f20166g != null) {
                    springAnimation.addEndListener(new C0501a(iArr));
                }
            }
        }
    }

    public a(b bVar) {
        this.f20161b = bVar.f20169a;
        this.f20162c = bVar.f20170b;
        this.f20163d = bVar.f20171c;
        this.f20164e = bVar.f20172d;
        this.f20165f = bVar.f20173e;
        d();
    }
}
