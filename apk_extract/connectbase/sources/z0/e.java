package z0;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: loaded from: classes.dex */
public class e extends a implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public n0.g f21757p;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f21750c = 1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f21751d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f21752e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f21753f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f21754g = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f21755i = -2.1474836E9f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f21756n = 2.1474836E9f;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @VisibleForTesting
    public boolean f21758v = false;

    public void A(int i10) {
        z(i10, (int) this.f21756n);
    }

    public void B(float f10) {
        this.f21750c = f10;
    }

    public final void C() {
        if (this.f21757p == null) {
            return;
        }
        float f10 = this.f21753f;
        if (f10 < this.f21755i || f10 > this.f21756n) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f21755i), Float.valueOf(this.f21756n), Float.valueOf(this.f21753f)));
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        a();
        s();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j10) {
        r();
        if (this.f21757p == null || !isRunning()) {
            return;
        }
        n0.e.a("LottieValueAnimator#doFrame");
        long j11 = this.f21752e;
        float fK = (j11 != 0 ? j10 - j11 : 0L) / k();
        float f10 = this.f21753f;
        if (o()) {
            fK = -fK;
        }
        float f11 = f10 + fK;
        this.f21753f = f11;
        boolean zE = g.e(f11, m(), l());
        this.f21753f = g.c(this.f21753f, m(), l());
        this.f21752e = j10;
        f();
        if (!zE) {
            if (getRepeatCount() == -1 || this.f21754g < getRepeatCount()) {
                d();
                this.f21754g++;
                if (getRepeatMode() == 2) {
                    this.f21751d = !this.f21751d;
                    v();
                } else {
                    this.f21753f = o() ? l() : m();
                }
                this.f21752e = j10;
            } else {
                this.f21753f = this.f21750c < 0.0f ? m() : l();
                s();
                b(o());
            }
        }
        C();
        n0.e.b("LottieValueAnimator#doFrame");
    }

    public void g() {
        this.f21757p = null;
        this.f21755i = -2.1474836E9f;
        this.f21756n = 2.1474836E9f;
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float fM;
        float fL;
        float fM2;
        if (this.f21757p == null) {
            return 0.0f;
        }
        if (o()) {
            fM = l() - this.f21753f;
            fL = l();
            fM2 = m();
        } else {
            fM = this.f21753f - m();
            fL = l();
            fM2 = m();
        }
        return fM / (fL - fM2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(i());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        n0.g gVar = this.f21757p;
        if (gVar == null) {
            return 0L;
        }
        return (long) gVar.d();
    }

    @MainThread
    public void h() {
        s();
        b(o());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float i() {
        n0.g gVar = this.f21757p;
        if (gVar == null) {
            return 0.0f;
        }
        return (this.f21753f - gVar.p()) / (this.f21757p.f() - this.f21757p.p());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f21758v;
    }

    public float j() {
        return this.f21753f;
    }

    public final float k() {
        n0.g gVar = this.f21757p;
        if (gVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / gVar.h()) / Math.abs(this.f21750c);
    }

    public float l() {
        n0.g gVar = this.f21757p;
        if (gVar == null) {
            return 0.0f;
        }
        float f10 = this.f21756n;
        return f10 == 2.1474836E9f ? gVar.f() : f10;
    }

    public float m() {
        n0.g gVar = this.f21757p;
        if (gVar == null) {
            return 0.0f;
        }
        float f10 = this.f21755i;
        return f10 == -2.1474836E9f ? gVar.p() : f10;
    }

    public float n() {
        return this.f21750c;
    }

    public final boolean o() {
        return n() < 0.0f;
    }

    @MainThread
    public void p() {
        s();
    }

    @MainThread
    public void q() {
        this.f21758v = true;
        e(o());
        x((int) (o() ? l() : m()));
        this.f21752e = 0L;
        this.f21754g = 0;
        r();
    }

    public void r() {
        if (isRunning()) {
            t(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    public void s() {
        t(true);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i10) {
        super.setRepeatMode(i10);
        if (i10 == 2 || !this.f21751d) {
            return;
        }
        this.f21751d = false;
        v();
    }

    @MainThread
    public void t(boolean z10) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z10) {
            this.f21758v = false;
        }
    }

    @MainThread
    public void u() {
        this.f21758v = true;
        r();
        this.f21752e = 0L;
        if (o() && j() == m()) {
            this.f21753f = l();
        } else {
            if (o() || j() != l()) {
                return;
            }
            this.f21753f = m();
        }
    }

    public void v() {
        B(-n());
    }

    public void w(n0.g gVar) {
        boolean z10 = this.f21757p == null;
        this.f21757p = gVar;
        if (z10) {
            z((int) Math.max(this.f21755i, gVar.p()), (int) Math.min(this.f21756n, gVar.f()));
        } else {
            z((int) gVar.p(), (int) gVar.f());
        }
        float f10 = this.f21753f;
        this.f21753f = 0.0f;
        x((int) f10);
        f();
    }

    public void x(float f10) {
        if (this.f21753f == f10) {
            return;
        }
        this.f21753f = g.c(f10, m(), l());
        this.f21752e = 0L;
        f();
    }

    public void y(float f10) {
        z(this.f21755i, f10);
    }

    public void z(float f10, float f11) {
        if (f10 > f11) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f10), Float.valueOf(f11)));
        }
        n0.g gVar = this.f21757p;
        float fP = gVar == null ? -3.4028235E38f : gVar.p();
        n0.g gVar2 = this.f21757p;
        float f12 = gVar2 == null ? Float.MAX_VALUE : gVar2.f();
        this.f21755i = g.c(f10, fP, f12);
        this.f21756n = g.c(f11, fP, f12);
        x((int) g.c(this.f21753f, f10, f11));
    }
}
