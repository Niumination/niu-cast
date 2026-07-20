package w1;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.Choreographer;
import j1.j;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class d extends ValueAnimator implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public j f10643n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet f10633a = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArraySet f10634b = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArraySet f10635c = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f10636d = 1.0f;
    public boolean e = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f10637h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f10638i = 0.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f10639j = 0.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10640k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f10641l = -2.1474836E9f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f10642m = 2.1474836E9f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f10644o = false;
    public boolean p = false;

    public final float a() {
        j jVar = this.f10643n;
        if (jVar == null) {
            return 0.0f;
        }
        float f = this.f10639j;
        float f4 = jVar.f5973l;
        return (f - f4) / (jVar.f5974m - f4);
    }

    @Override // android.animation.Animator
    public final void addListener(Animator.AnimatorListener animatorListener) {
        this.f10634b.add(animatorListener);
    }

    @Override // android.animation.Animator
    public final void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f10635c.add(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public final void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f10633a.add(animatorUpdateListener);
    }

    public final float b() {
        j jVar = this.f10643n;
        if (jVar == null) {
            return 0.0f;
        }
        float f = this.f10642m;
        return f == 2.1474836E9f ? jVar.f5974m : f;
    }

    public final float c() {
        j jVar = this.f10643n;
        if (jVar == null) {
            return 0.0f;
        }
        float f = this.f10641l;
        return f == -2.1474836E9f ? jVar.f5973l : f;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void cancel() {
        Iterator it = this.f10634b.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorListener) it.next()).onAnimationCancel(this);
        }
        e(d());
        h(true);
    }

    public final boolean d() {
        return this.f10636d < 0.0f;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j8) {
        boolean z2 = false;
        if (this.f10644o) {
            h(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
        j jVar = this.f10643n;
        if (jVar == null || !this.f10644o) {
            return;
        }
        j1.a aVar = j1.d.f5945a;
        long j10 = this.f10637h;
        float fAbs = (j10 != 0 ? j8 - j10 : 0L) / ((1.0E9f / jVar.f5975n) / Math.abs(this.f10636d));
        float f = this.f10638i;
        if (d()) {
            fAbs = -fAbs;
        }
        float f4 = f + fAbs;
        float fC = c();
        float fB = b();
        PointF pointF = f.f10646a;
        if (f4 >= fC && f4 <= fB) {
            z2 = true;
        }
        float f10 = this.f10638i;
        float fB2 = f.b(f4, c(), b());
        this.f10638i = fB2;
        if (this.p) {
            fB2 = (float) Math.floor(fB2);
        }
        this.f10639j = fB2;
        this.f10637h = j8;
        if (!this.p || this.f10638i != f10) {
            f();
        }
        if (!z2) {
            if (getRepeatCount() == -1 || this.f10640k < getRepeatCount()) {
                Iterator it = this.f10634b.iterator();
                while (it.hasNext()) {
                    ((Animator.AnimatorListener) it.next()).onAnimationRepeat(this);
                }
                this.f10640k++;
                if (getRepeatMode() == 2) {
                    this.e = !this.e;
                    this.f10636d = -this.f10636d;
                } else {
                    float fB3 = d() ? b() : c();
                    this.f10638i = fB3;
                    this.f10639j = fB3;
                }
                this.f10637h = j8;
            } else {
                float fC2 = this.f10636d < 0.0f ? c() : b();
                this.f10638i = fC2;
                this.f10639j = fC2;
                h(true);
                e(d());
            }
        }
        if (this.f10643n != null) {
            float f11 = this.f10639j;
            if (f11 < this.f10641l || f11 > this.f10642m) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f10641l), Float.valueOf(this.f10642m), Float.valueOf(this.f10639j)));
            }
        }
        j1.a aVar2 = j1.d.f5945a;
    }

    public final void e(boolean z2) {
        Iterator it = this.f10634b.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorListener) it.next()).onAnimationEnd(this, z2);
        }
    }

    public final void f() {
        Iterator it = this.f10633a.iterator();
        while (it.hasNext()) {
            ((ValueAnimator.AnimatorUpdateListener) it.next()).onAnimationUpdate(this);
        }
    }

    @Override // android.animation.ValueAnimator
    public final float getAnimatedFraction() {
        float fC;
        float fB;
        float fC2;
        if (this.f10643n == null) {
            return 0.0f;
        }
        if (d()) {
            fC = b() - this.f10639j;
            fB = b();
            fC2 = c();
        } else {
            fC = this.f10639j - c();
            fB = b();
            fC2 = c();
        }
        return fC / (fB - fC2);
    }

    @Override // android.animation.ValueAnimator
    public final Object getAnimatedValue() {
        return Float.valueOf(a());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final long getDuration() {
        j jVar = this.f10643n;
        if (jVar == null) {
            return 0L;
        }
        return (long) jVar.b();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public final void h(boolean z2) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z2) {
            this.f10644o = false;
        }
    }

    public final void i(float f) {
        if (this.f10638i == f) {
            return;
        }
        float fB = f.b(f, c(), b());
        this.f10638i = fB;
        if (this.p) {
            fB = (float) Math.floor(fB);
        }
        this.f10639j = fB;
        this.f10637h = 0L;
        f();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final boolean isRunning() {
        return this.f10644o;
    }

    public final void j(float f, float f4) {
        if (f > f4) {
            throw new IllegalArgumentException("minFrame (" + f + ") must be <= maxFrame (" + f4 + ")");
        }
        j jVar = this.f10643n;
        float f10 = jVar == null ? -3.4028235E38f : jVar.f5973l;
        float f11 = jVar == null ? Float.MAX_VALUE : jVar.f5974m;
        float fB = f.b(f, f10, f11);
        float fB2 = f.b(f4, f10, f11);
        if (fB == this.f10641l && fB2 == this.f10642m) {
            return;
        }
        this.f10641l = fB;
        this.f10642m = fB2;
        i((int) f.b(this.f10639j, fB, fB2));
    }

    @Override // android.animation.Animator
    public final void removeAllListeners() {
        this.f10634b.clear();
    }

    @Override // android.animation.ValueAnimator
    public final void removeAllUpdateListeners() {
        this.f10633a.clear();
    }

    @Override // android.animation.Animator
    public final void removeListener(Animator.AnimatorListener animatorListener) {
        this.f10634b.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public final void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f10635c.remove(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public final void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f10633a.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final /* bridge */ /* synthetic */ Animator setDuration(long j8) {
        setDuration(j8);
        throw null;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator
    public final void setRepeatMode(int i8) {
        super.setRepeatMode(i8);
        if (i8 == 2 || !this.e) {
            return;
        }
        this.e = false;
        this.f10636d = -this.f10636d;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void setStartDelay(long j8) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final ValueAnimator setDuration(long j8) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }
}
