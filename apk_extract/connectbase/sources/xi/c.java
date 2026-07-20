package xi;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class c implements View.OnTouchListener {
    public static final String M = "OSSpringPressSealAnimat";
    public boolean H;
    public float I;
    public float J;
    public SpringAnimation K;
    public SpringAnimation L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f20189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f20190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f20191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f20192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f20193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f20194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f20195g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FloatValueHolder f20196i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f20197n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public WeakReference<View> f20198p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f20199v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public h f20200w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View.OnTouchListener f20201x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public f f20202y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public g f20203z;

    public class a implements DynamicAnimation.OnAnimationUpdateListener {
        public a() {
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
        public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f10, float f11) {
            WeakReference<View> weakReference = c.this.f20198p;
            if (weakReference == null || weakReference.get() == null) {
                if (dynamicAnimation == null || !dynamicAnimation.isRunning()) {
                    return;
                }
                dynamicAnimation.cancel();
                return;
            }
            View view = c.this.f20198p.get();
            view.setScaleX(f10);
            view.setScaleY(f10);
            g gVar = c.this.f20203z;
            if (gVar != null) {
                gVar.a(true, dynamicAnimation, f10, f11);
            }
        }
    }

    public class b implements DynamicAnimation.OnAnimationEndListener {
        public b() {
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
        public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z10, float f10, float f11) {
            if (z10) {
                c.this.f20191c = f10;
            } else {
                c cVar = c.this;
                cVar.f20191c = cVar.f20190b;
            }
            c cVar2 = c.this;
            cVar2.f20192d = cVar2.f20189a;
            f fVar = cVar2.f20202y;
            if (fVar != null) {
                fVar.a(true, dynamicAnimation, z10, cVar2.H, f10, f11);
            }
        }
    }

    /* JADX INFO: renamed from: xi.c$c, reason: collision with other inner class name */
    public class C0503c implements DynamicAnimation.OnAnimationUpdateListener {
        public C0503c() {
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
        public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f10, float f11) {
            WeakReference<View> weakReference = c.this.f20198p;
            if (weakReference == null || weakReference.get() == null) {
                if (dynamicAnimation == null || !dynamicAnimation.isRunning()) {
                    return;
                }
                dynamicAnimation.cancel();
                return;
            }
            View view = c.this.f20198p.get();
            view.setScaleX(f10);
            view.setScaleY(f10);
            g gVar = c.this.f20203z;
            if (gVar != null) {
                gVar.a(false, dynamicAnimation, f10, f11);
            }
        }
    }

    public class d implements DynamicAnimation.OnAnimationEndListener {
        public d() {
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
        public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z10, float f10, float f11) {
            if (z10) {
                c.this.f20191c = f10;
            } else {
                c cVar = c.this;
                cVar.f20191c = cVar.f20189a;
            }
            c cVar2 = c.this;
            cVar2.f20192d = cVar2.f20190b;
            f fVar = cVar2.f20202y;
            if (fVar != null) {
                fVar.a(false, dynamicAnimation, z10, cVar2.H, f10, f11);
            }
        }
    }

    public static class e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f20209b;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public FloatValueHolder f20213f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ViewParent f20215h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public g f20216i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public f f20217j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public View.OnTouchListener f20218k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public WeakReference f20219l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public h f20220m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f20221n;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f20210c = 350.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f20211d = 350.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f20212e = 1.2f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f20208a = 1.0f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f20214g = 0.0f;

        public e A(float f10) {
            this.f20214g = f10;
            return this;
        }

        public e B(View view) {
            this.f20219l = new WeakReference(view);
            return this;
        }

        public e n(f fVar) {
            this.f20217j = fVar;
            return this;
        }

        public e o(g gVar) {
            this.f20216i = gVar;
            return this;
        }

        public c p() {
            if (this.f20213f != null) {
                return new c(this);
            }
            throw new IllegalStateException("property == null");
        }

        public e q(float f10) {
            this.f20212e = f10;
            return this;
        }

        public e r(float f10) {
            this.f20211d = f10;
            return this;
        }

        public e s(float f10) {
            this.f20209b = f10;
            return this;
        }

        public e t(FloatValueHolder floatValueHolder) {
            this.f20213f = floatValueHolder;
            return this;
        }

        public e u(h hVar) {
            this.f20220m = hVar;
            return this;
        }

        public e v(View.OnTouchListener onTouchListener) {
            this.f20218k = onTouchListener;
            return this;
        }

        public e w(float f10) {
            this.f20221n = f10;
            return this;
        }

        public e x(ViewParent viewParent) {
            this.f20215h = viewParent;
            return this;
        }

        public e y(float f10) {
            this.f20210c = f10;
            return this;
        }

        public e z(float f10) {
            this.f20208a = f10;
            return this;
        }
    }

    public interface f {
        void a(boolean z10, DynamicAnimation dynamicAnimation, boolean z11, boolean z12, float f10, float f11);
    }

    public interface g {
        void a(boolean z10, DynamicAnimation dynamicAnimation, float f10, float f11);
    }

    public interface h {
        void a(View view, boolean z10);
    }

    public /* synthetic */ c(e eVar, a aVar) {
        this(eVar);
    }

    public static int j(int i10) {
        return (int) TypedValue.applyDimension(1, i10, Resources.getSystem().getDisplayMetrics());
    }

    public final SpringAnimation h(float f10, float f11) {
        SpringForce dampingRatio = new SpringForce().setStiffness(this.f20194f).setDampingRatio(this.f20195g);
        dampingRatio.setFinalPosition(f11);
        SpringAnimation springAnimation = new SpringAnimation(this.f20196i);
        springAnimation.setSpring(dampingRatio);
        springAnimation.setStartValue(f10);
        springAnimation.setStartVelocity(this.f20197n);
        springAnimation.setMinimumVisibleChange(0.002f);
        springAnimation.addUpdateListener(new C0503c());
        springAnimation.addEndListener(new d());
        return springAnimation;
    }

    public final SpringAnimation i(float f10, float f11) {
        SpringForce dampingRatio = new SpringForce().setStiffness(this.f20193e).setDampingRatio(this.f20195g);
        dampingRatio.setFinalPosition(f11);
        SpringAnimation springAnimation = new SpringAnimation(this.f20196i);
        springAnimation.setSpring(dampingRatio);
        springAnimation.setStartValue(f10);
        springAnimation.setStartVelocity(this.f20197n);
        springAnimation.setMinimumVisibleChange(0.002f);
        springAnimation.addUpdateListener(new a());
        springAnimation.addEndListener(new b());
        return springAnimation;
    }

    public final boolean k(MotionEvent motionEvent) {
        return Math.sqrt(Math.pow((double) (motionEvent.getY() - this.J), 2.0d) + Math.pow((double) (motionEvent.getX() - this.I), 2.0d)) > ((double) this.f20199v);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        h hVar;
        View.OnTouchListener onTouchListener = this.f20201x;
        if (onTouchListener != null) {
            onTouchListener.onTouch(view, motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            this.I = motionEvent.getX();
            this.J = motionEvent.getY();
            SpringAnimation springAnimation = this.L;
            if (springAnimation != null && springAnimation.isRunning()) {
                this.L.cancel();
            }
            SpringAnimation springAnimationI = i(this.f20191c, this.f20192d);
            this.K = springAnimationI;
            springAnimationI.start();
            h hVar2 = this.f20200w;
            if (hVar2 != null && view != null) {
                hVar2.a(view, true);
            }
            this.H = false;
            return true;
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (!this.H) {
                if (motionEvent.getAction() == 3) {
                    this.H = true;
                }
                SpringAnimation springAnimation2 = this.K;
                if (springAnimation2 != null && springAnimation2.isRunning()) {
                    this.K.cancel();
                }
                SpringAnimation springAnimationH = h(this.f20191c, this.f20192d);
                this.L = springAnimationH;
                springAnimationH.start();
            }
            if (motionEvent.getAction() == 1 && (hVar = this.f20200w) != null && view != null && !this.H) {
                hVar.a(view, false);
            }
            return true;
        }
        if (motionEvent.getAction() == 2 && ((motionEvent.getX() < 0.0f || motionEvent.getY() < 0.0f || motionEvent.getX() > view.getWidth() || motionEvent.getY() > view.getHeight() || k(motionEvent)) && !this.H)) {
            this.H = true;
            SpringAnimation springAnimation3 = this.K;
            if (springAnimation3 != null && springAnimation3.isRunning()) {
                this.K.cancel();
            }
            SpringAnimation springAnimationH2 = h(this.f20191c, this.f20192d);
            this.L = springAnimationH2;
            springAnimationH2.start();
        }
        return false;
    }

    public c(e eVar) {
        this.H = false;
        float f10 = eVar.f20208a;
        this.f20189a = f10;
        float f11 = eVar.f20209b;
        this.f20190b = f11;
        this.f20194f = eVar.f20211d;
        this.f20193e = eVar.f20210c;
        this.f20195g = eVar.f20212e;
        this.f20196i = eVar.f20213f;
        this.f20197n = eVar.f20214g;
        WeakReference<View> weakReference = eVar.f20219l;
        this.f20198p = weakReference;
        this.f20200w = eVar.f20220m;
        this.f20201x = eVar.f20218k;
        this.f20202y = eVar.f20217j;
        this.f20203z = eVar.f20216i;
        if (weakReference != null) {
            float f12 = eVar.f20221n;
            this.f20199v = j(f12 > 0.0f ? (int) f12 : 20);
        }
        this.f20191c = f10;
        this.f20192d = f11;
        WeakReference<View> weakReference2 = this.f20198p;
        if (weakReference2 == null || weakReference2.get() == null) {
            return;
        }
        this.f20198p.get().setOnTouchListener(this);
    }
}
