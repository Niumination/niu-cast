package yd;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.animation.AnimationUtils;
import androidx.dynamicanimation.animation.SpringAnimation;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f11153d = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f11155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TimeInterpolator f11156c = f11153d;

    public k(Context context) {
        this.f11155b = new j(context);
    }

    public final void a(int i8, int i9, int i10) {
        double dExp;
        j jVar = this.f11155b;
        if (!jVar.f11147k) {
            float f = jVar.e;
            float f4 = i9;
            if (Math.signum(f4) == Math.signum(f)) {
                i9 = (int) (f4 + f);
            }
        }
        this.f11154a = 1;
        jVar.f11148l = i10;
        jVar.f11147k = false;
        if (Math.abs(i9) < jVar.q * 1500.0f) {
            i9 = i9 < 0 ? -1500 : 1500;
        }
        jVar.f11142d = i9;
        float f10 = i9;
        jVar.e = f10;
        jVar.f11145i = 0;
        jVar.f11144h = 0;
        jVar.f11143g = AnimationUtils.currentAnimationTimeMillis();
        jVar.f11139a = i8;
        jVar.f11140b = i8;
        if (i8 > 0 || i8 < 0) {
            jVar.c(i8, 0, 0);
            return;
        }
        jVar.f11150n = 0;
        if (i9 != 0) {
            double dLog = Math.log((Math.abs(i9) * 0.35f) / (jVar.f11149m * jVar.p));
            double d7 = j.f11137s;
            double d10 = d7 - 1.0d;
            int iExp = (int) (Math.exp(dLog / d10) * 1000.0d);
            jVar.f11145i = iExp;
            jVar.f11144h = iExp;
            dExp = Math.exp((d7 / d10) * Math.log((Math.abs(i9) * 0.35f) / (jVar.f11149m * jVar.p))) * ((double) (jVar.f11149m * jVar.p));
        } else {
            dExp = 0.0d;
        }
        int iSignum = (int) (dExp * ((double) Math.signum(f10)));
        jVar.f11146j = iSignum;
        int i11 = i8 + iSignum;
        jVar.f11141c = i11;
        if (i11 < 0) {
            jVar.a(jVar.f11139a, i11);
            jVar.f11141c = 0;
        }
        int i12 = jVar.f11141c;
        if (i12 > 0) {
            jVar.a(jVar.f11139a, i12);
            jVar.f11141c = 0;
        }
    }

    public final void b(int i8) {
        this.f11154a = 1;
        j jVar = this.f11155b;
        jVar.f11141c = i8;
        jVar.f11139a = i8;
        jVar.f11140b = i8;
        jVar.f11142d = 0;
        jVar.f11143g = AnimationUtils.currentAnimationTimeMillis();
        jVar.f11144h = 0;
        if (i8 < 0) {
            jVar.c(i8, 0, 0);
        } else if (i8 > 0) {
            jVar.c(i8, 0, 0);
        }
    }

    public final void c(int i8, int i9, int i10) {
        this.f11154a = 0;
        j jVar = this.f11155b;
        jVar.f11147k = false;
        jVar.f11139a = i8;
        jVar.f11140b = i8;
        jVar.f11141c = i8 + i9;
        jVar.f11143g = AnimationUtils.currentAnimationTimeMillis();
        jVar.f11144h = i10;
        jVar.f = 0.0f;
        jVar.f11142d = 0;
    }

    public final int getCurrPos() {
        float f = j.f11137s;
        j jVar = this.f11155b;
        jVar.getClass();
        return jVar.f11140b;
    }

    public float getCurrVelocity() {
        return this.f11155b.e;
    }

    public final int getDuration() {
        return this.f11155b.f11144h;
    }

    public final int getFinalPos() {
        return this.f11155b.f11141c;
    }

    public j getScroller() {
        return this.f11155b;
    }

    public final int getStartPos() {
        return this.f11155b.f11139a;
    }

    public void setFinalPos(int i8) {
        SpringAnimation springAnimation;
        j jVar = this.f11155b;
        jVar.f11141c = i8;
        if (jVar.f11150n == 3 && (springAnimation = jVar.f11151o) != null) {
            springAnimation.animateToFinalPosition(i8);
        }
        jVar.f11146j = jVar.f11141c - jVar.f11139a;
        jVar.f11147k = false;
    }

    public final void setFriction(float f) {
        this.f11155b.f11149m = f;
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        if (timeInterpolator == null) {
            this.f11156c = f11153d;
        } else {
            this.f11156c = timeInterpolator;
        }
    }
}
