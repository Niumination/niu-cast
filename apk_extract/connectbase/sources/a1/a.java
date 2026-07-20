package a1;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class a<T> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final float f3q = -3987645.8f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f4r = 784923401;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final n0.g f5a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final T f6b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public T f7c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final Interpolator f8d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final Interpolator f9e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final Interpolator f10f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f11g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public Float f12h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f13i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f14j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f15k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f16l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f17m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f18n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PointF f19o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public PointF f20p;

    public a(n0.g gVar, @Nullable T t10, @Nullable T t11, @Nullable Interpolator interpolator, float f10, @Nullable Float f11) {
        this.f13i = -3987645.8f;
        this.f14j = -3987645.8f;
        this.f15k = f4r;
        this.f16l = f4r;
        this.f17m = Float.MIN_VALUE;
        this.f18n = Float.MIN_VALUE;
        this.f19o = null;
        this.f20p = null;
        this.f5a = gVar;
        this.f6b = t10;
        this.f7c = t11;
        this.f8d = interpolator;
        this.f9e = null;
        this.f10f = null;
        this.f11g = f10;
        this.f12h = f11;
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return f10 >= e() && f10 < b();
    }

    public float b() {
        if (this.f5a == null) {
            return 1.0f;
        }
        if (this.f18n == Float.MIN_VALUE) {
            if (this.f12h == null) {
                this.f18n = 1.0f;
            } else {
                this.f18n = ((this.f12h.floatValue() - this.f11g) / this.f5a.e()) + e();
            }
        }
        return this.f18n;
    }

    public float c() {
        if (this.f14j == -3987645.8f) {
            this.f14j = ((Float) this.f7c).floatValue();
        }
        return this.f14j;
    }

    public int d() {
        if (this.f16l == 784923401) {
            this.f16l = ((Integer) this.f7c).intValue();
        }
        return this.f16l;
    }

    public float e() {
        n0.g gVar = this.f5a;
        if (gVar == null) {
            return 0.0f;
        }
        if (this.f17m == Float.MIN_VALUE) {
            this.f17m = (this.f11g - gVar.p()) / this.f5a.e();
        }
        return this.f17m;
    }

    public float f() {
        if (this.f13i == -3987645.8f) {
            this.f13i = ((Float) this.f6b).floatValue();
        }
        return this.f13i;
    }

    public int g() {
        if (this.f15k == 784923401) {
            this.f15k = ((Integer) this.f6b).intValue();
        }
        return this.f15k;
    }

    public boolean h() {
        return this.f8d == null && this.f9e == null && this.f10f == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f6b + ", endValue=" + this.f7c + ", startFrame=" + this.f11g + ", endFrame=" + this.f12h + ", interpolator=" + this.f8d + rs.f.f14860b;
    }

    public a(n0.g gVar, @Nullable T t10, @Nullable T t11, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, float f10, @Nullable Float f11) {
        this.f13i = -3987645.8f;
        this.f14j = -3987645.8f;
        this.f15k = f4r;
        this.f16l = f4r;
        this.f17m = Float.MIN_VALUE;
        this.f18n = Float.MIN_VALUE;
        this.f19o = null;
        this.f20p = null;
        this.f5a = gVar;
        this.f6b = t10;
        this.f7c = t11;
        this.f8d = null;
        this.f9e = interpolator;
        this.f10f = interpolator2;
        this.f11g = f10;
        this.f12h = f11;
    }

    public a(n0.g gVar, @Nullable T t10, @Nullable T t11, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, @Nullable Interpolator interpolator3, float f10, @Nullable Float f11) {
        this.f13i = -3987645.8f;
        this.f14j = -3987645.8f;
        this.f15k = f4r;
        this.f16l = f4r;
        this.f17m = Float.MIN_VALUE;
        this.f18n = Float.MIN_VALUE;
        this.f19o = null;
        this.f20p = null;
        this.f5a = gVar;
        this.f6b = t10;
        this.f7c = t11;
        this.f8d = interpolator;
        this.f9e = interpolator2;
        this.f10f = interpolator3;
        this.f11g = f10;
        this.f12h = f11;
    }

    public a(T t10) {
        this.f13i = -3987645.8f;
        this.f14j = -3987645.8f;
        this.f15k = f4r;
        this.f16l = f4r;
        this.f17m = Float.MIN_VALUE;
        this.f18n = Float.MIN_VALUE;
        this.f19o = null;
        this.f20p = null;
        this.f5a = null;
        this.f6b = t10;
        this.f7c = t10;
        this.f8d = null;
        this.f9e = null;
        this.f10f = null;
        this.f11g = Float.MIN_VALUE;
        this.f12h = Float.valueOf(Float.MAX_VALUE);
    }
}
