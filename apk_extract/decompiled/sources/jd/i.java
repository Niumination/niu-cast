package jd;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f6164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f6165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f6166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f6167d;
    public final float e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f6168h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f6169i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FloatValueHolder f6170j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final WeakReference f6171k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f6172l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public h f6173m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final View.OnTouchListener f6174n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final f f6175o;
    public final g p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f6176r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f6177s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SpringAnimation f6178t;
    public SpringAnimation u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f6179v;
    public boolean q = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6180w = false;

    /* JADX WARN: Code duplicated, block: B:16:0x0086  */
    public i(e eVar) {
        this.f6179v = true;
        eVar.getClass();
        this.f6164a = eVar.f6154a;
        this.e = eVar.f6156c;
        this.f6167d = eVar.f6155b;
        this.f6168h = eVar.f6157d;
        this.f6169i = eVar.e;
        this.f6170j = eVar.f;
        WeakReference weakReference = eVar.f6161j;
        this.f6171k = weakReference;
        this.f6173m = eVar.f6162k;
        this.f6174n = eVar.f6160i;
        this.f6175o = eVar.f6159h;
        this.p = eVar.f6158g;
        this.f6179v = false;
        boolean z2 = eVar.f6163l;
        if (weakReference != null) {
            this.f6172l = (int) TypedValue.applyDimension(1, 20, Resources.getSystem().getDisplayMetrics());
        }
        this.f6165b = 1.0f;
        this.f6166c = this.f6164a;
        if (weakReference != null && weakReference.get() != null) {
            View view = (View) weakReference.get();
            if (pd.j.f8769h) {
                view.setOnClickListener(new ce.a(this, 4));
            } else {
                AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
                if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                    view.setOnClickListener(new ce.a(this, 4));
                } else {
                    view.setOnTouchListener(this);
                }
            }
            new Handler(Looper.getMainLooper());
            b8.c cVar = new b8.c();
            new WeakReference(view);
            cVar.f1219b = new WeakReference(this);
        }
        if (z2) {
            this.f6168h = 0.99f;
            this.f6169i = 0.4f;
            this.f6167d = 250.0f;
            this.e = 250.0f;
        }
    }

    public final SpringAnimation a(float f, float f4) {
        SpringForce dampingRatio = new SpringForce().setStiffness(this.e).setDampingRatio(this.f6169i);
        dampingRatio.setFinalPosition(f4);
        SpringAnimation springAnimation = new SpringAnimation(this.f6170j);
        springAnimation.setSpring(dampingRatio);
        springAnimation.setStartValue(f);
        springAnimation.setStartVelocity(0.0f);
        springAnimation.setMinimumVisibleChange(0.002f);
        springAnimation.addUpdateListener(new c(this));
        springAnimation.addEndListener(new d(this));
        return springAnimation;
    }

    public final SpringAnimation b(float f, float f4) {
        SpringForce dampingRatio = new SpringForce().setStiffness(this.f6167d).setDampingRatio(this.f6168h);
        dampingRatio.setFinalPosition(f4);
        SpringAnimation springAnimation = new SpringAnimation(this.f6170j);
        springAnimation.setSpring(dampingRatio);
        springAnimation.setStartValue(f);
        springAnimation.setStartVelocity(0.0f);
        springAnimation.setMinimumVisibleChange(0.002f);
        springAnimation.addUpdateListener(new a(this));
        springAnimation.addEndListener(new b(this));
        return springAnimation;
    }

    public float getEndValue() {
        return this.f6164a;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:51:0x00da  */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        h hVar;
        SpringAnimation springAnimation;
        float f;
        View.OnTouchListener onTouchListener = this.f6174n;
        if (onTouchListener != null) {
            onTouchListener.onTouch(view, motionEvent);
        }
        if (this.f6180w) {
            return view.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            this.f6176r = motionEvent.getX();
            this.f6177s = motionEvent.getY();
            SpringAnimation springAnimation2 = this.u;
            if (springAnimation2 != null && springAnimation2.isRunning()) {
                this.u.cancel();
            }
            SpringAnimation springAnimationB = b(this.f6165b, this.f6166c);
            this.f6178t = springAnimationB;
            springAnimationB.start();
            h hVar2 = this.f6173m;
            if (hVar2 != null && view != null) {
                hVar2.b(view, true);
            }
            this.q = false;
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (!this.q) {
                if (motionEvent.getAction() == 3) {
                    this.q = true;
                }
                SpringAnimation springAnimation3 = this.f6178t;
                if (springAnimation3 != null && springAnimation3.isRunning()) {
                    this.f6178t.cancel();
                }
                float f4 = this.f6165b;
                if (f4 != 1.0f) {
                    SpringAnimation springAnimationA = a(f4, this.f6166c);
                    this.u = springAnimationA;
                    springAnimationA.start();
                }
            }
            if (motionEvent.getAction() == 1 && (hVar = this.f6173m) != null && view != null && !this.q) {
                hVar.b(view, false);
            }
        } else if (motionEvent.getAction() == 2) {
            if (!this.f6179v) {
                return view.onTouchEvent(motionEvent);
            }
            if (motionEvent.getX() < 0.0f || motionEvent.getY() < 0.0f || motionEvent.getX() > view.getWidth() || motionEvent.getY() > view.getHeight()) {
                if (!this.q) {
                    this.q = true;
                    springAnimation = this.f6178t;
                    if (springAnimation != null && springAnimation.isRunning()) {
                        this.f6178t.cancel();
                    }
                    f = this.f6165b;
                    if (f != 1.0f) {
                        SpringAnimation springAnimationA2 = a(f, this.f6166c);
                        this.u = springAnimationA2;
                        springAnimationA2.start();
                    }
                }
            } else if (Math.sqrt(Math.pow(motionEvent.getY() - this.f6177s, 2.0d) + Math.pow(motionEvent.getX() - this.f6176r, 2.0d)) > this.f6172l) {
                if (!this.q) {
                    this.q = true;
                    springAnimation = this.f6178t;
                    if (springAnimation != null) {
                        this.f6178t.cancel();
                    }
                    f = this.f6165b;
                    if (f != 1.0f) {
                        SpringAnimation springAnimationA3 = a(f, this.f6166c);
                        this.u = springAnimationA3;
                        springAnimationA3.start();
                    }
                }
            }
        }
        return view.onTouchEvent(motionEvent);
    }

    public void setEndValue(float f) {
        this.f6164a = f;
        this.f6166c = f;
    }

    public void setOnSpringClickListener(h hVar) {
        this.f6173m = hVar;
    }
}
