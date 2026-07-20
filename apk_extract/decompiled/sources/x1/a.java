package x1;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import j1.j;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f10806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f10807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f10808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Interpolator f10809d;
    public final Interpolator e;
    public final Interpolator f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f10810g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Float f10811h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f10812i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f10813j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10814k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10815l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f10816m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f10817n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PointF f10818o;
    public PointF p;

    public a(j jVar, Object obj, Object obj2, Interpolator interpolator, float f, Float f4) {
        this.f10812i = -3987645.8f;
        this.f10813j = -3987645.8f;
        this.f10814k = 784923401;
        this.f10815l = 784923401;
        this.f10816m = Float.MIN_VALUE;
        this.f10817n = Float.MIN_VALUE;
        this.f10818o = null;
        this.p = null;
        this.f10806a = jVar;
        this.f10807b = obj;
        this.f10808c = obj2;
        this.f10809d = interpolator;
        this.e = null;
        this.f = null;
        this.f10810g = f;
        this.f10811h = f4;
    }

    public final float a() {
        j jVar = this.f10806a;
        if (jVar == null) {
            return 1.0f;
        }
        if (this.f10817n == Float.MIN_VALUE) {
            if (this.f10811h == null) {
                this.f10817n = 1.0f;
            } else {
                this.f10817n = ((this.f10811h.floatValue() - this.f10810g) / (jVar.f5974m - jVar.f5973l)) + b();
            }
        }
        return this.f10817n;
    }

    public final float b() {
        j jVar = this.f10806a;
        if (jVar == null) {
            return 0.0f;
        }
        if (this.f10816m == Float.MIN_VALUE) {
            float f = jVar.f5973l;
            this.f10816m = (this.f10810g - f) / (jVar.f5974m - f);
        }
        return this.f10816m;
    }

    public final boolean c() {
        return this.f10809d == null && this.e == null && this.f == null;
    }

    public final String toString() {
        return "Keyframe{startValue=" + this.f10807b + ", endValue=" + this.f10808c + ", startFrame=" + this.f10810g + ", endFrame=" + this.f10811h + ", interpolator=" + this.f10809d + '}';
    }

    public a(j jVar, Object obj, Object obj2, Interpolator interpolator, Interpolator interpolator2, float f) {
        this.f10812i = -3987645.8f;
        this.f10813j = -3987645.8f;
        this.f10814k = 784923401;
        this.f10815l = 784923401;
        this.f10816m = Float.MIN_VALUE;
        this.f10817n = Float.MIN_VALUE;
        this.f10818o = null;
        this.p = null;
        this.f10806a = jVar;
        this.f10807b = obj;
        this.f10808c = obj2;
        this.f10809d = null;
        this.e = interpolator;
        this.f = interpolator2;
        this.f10810g = f;
        this.f10811h = null;
    }

    public a(j jVar, Object obj, Object obj2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float f4) {
        this.f10812i = -3987645.8f;
        this.f10813j = -3987645.8f;
        this.f10814k = 784923401;
        this.f10815l = 784923401;
        this.f10816m = Float.MIN_VALUE;
        this.f10817n = Float.MIN_VALUE;
        this.f10818o = null;
        this.p = null;
        this.f10806a = jVar;
        this.f10807b = obj;
        this.f10808c = obj2;
        this.f10809d = interpolator;
        this.e = interpolator2;
        this.f = interpolator3;
        this.f10810g = f;
        this.f10811h = f4;
    }

    public a(Object obj) {
        this.f10812i = -3987645.8f;
        this.f10813j = -3987645.8f;
        this.f10814k = 784923401;
        this.f10815l = 784923401;
        this.f10816m = Float.MIN_VALUE;
        this.f10817n = Float.MIN_VALUE;
        this.f10818o = null;
        this.p = null;
        this.f10806a = null;
        this.f10807b = obj;
        this.f10808c = obj;
        this.f10809d = null;
        this.e = null;
        this.f = null;
        this.f10810g = Float.MIN_VALUE;
        this.f10811h = Float.valueOf(Float.MAX_VALUE);
    }

    public a(r1.c cVar, r1.c cVar2) {
        this.f10812i = -3987645.8f;
        this.f10813j = -3987645.8f;
        this.f10814k = 784923401;
        this.f10815l = 784923401;
        this.f10816m = Float.MIN_VALUE;
        this.f10817n = Float.MIN_VALUE;
        this.f10818o = null;
        this.p = null;
        this.f10806a = null;
        this.f10807b = cVar;
        this.f10808c = cVar2;
        this.f10809d = null;
        this.e = null;
        this.f = null;
        this.f10810g = Float.MIN_VALUE;
        this.f10811h = Float.valueOf(Float.MAX_VALUE);
    }
}
