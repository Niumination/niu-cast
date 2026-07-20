package hj;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f7160i = "os_list";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f7161j = "ListScaleHelper";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f7162k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f7163l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f7164m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f7165n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f7166o = 150;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f7167p = 150;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f7168q = 150;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final float f7169r = 0.001f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f7171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f7172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f7173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f7174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f7175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f7176g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7170a = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Interpolator f7177h = new DecelerateInterpolator();

    public d(Context context) {
    }

    public void a() {
        this.f7170a = 0;
    }

    public boolean b() {
        return this.f7170a == 0;
    }

    public void c(View view, float f10, float f11) {
        this.f7171b = view;
        this.f7174e = 1.0f;
        this.f7175f = f10;
        this.f7176g = f11;
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f7170a = 2;
        this.f7172c = jCurrentAnimationTimeMillis;
        this.f7173d = 150.0f;
        if (f7162k) {
            Log.i(f7160i, "ListScaleHelper onRebound() now = " + jCurrentAnimationTimeMillis + ", scaleY = " + f10 + ", pviotY = " + f11);
        }
    }

    public void d(View view, float f10, float f11) {
        this.f7171b = view;
        this.f7174e = f10;
        this.f7175f = 1.0f;
        this.f7176g = f11;
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f7170a = 1;
        this.f7172c = jCurrentAnimationTimeMillis;
        this.f7173d = 150.0f;
        if (f7162k) {
            Log.i(f7160i, "ListScaleHelper onRelease() now = " + jCurrentAnimationTimeMillis + ", scaleY = " + f10 + ", pviotY = " + f11);
        }
    }

    public final void e(float f10) {
        this.f7176g = f10;
    }

    public final void f(float f10, float f11) {
        this.f7174e = f10;
        this.f7175f = f11;
    }

    public boolean g() {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        float interpolation = this.f7177h.getInterpolation(Math.min((jCurrentAnimationTimeMillis - this.f7172c) / this.f7173d, 1.0f));
        float f10 = this.f7174e;
        float fA = g.a.a(this.f7175f, f10, interpolation, f10);
        int i10 = this.f7170a;
        if (i10 == 1) {
            if (f7162k) {
                Log.i(f7160i, "ListScaleHelper update() 1 duration = " + (jCurrentAnimationTimeMillis - this.f7172c) + ", scale = " + fA + ", mPviotY = " + this.f7176g);
            }
            this.f7171b.setPivotY(this.f7176g);
            this.f7171b.setScaleY(fA);
            if (jCurrentAnimationTimeMillis - this.f7172c > this.f7173d) {
                this.f7170a = 0;
            }
        } else if (i10 == 2) {
            if (f7162k) {
                Log.i(f7160i, "ListScaleHelper update() 2 duration = " + (jCurrentAnimationTimeMillis - this.f7172c) + ", scale = " + fA + ", mPviotY = " + this.f7176g);
            }
            this.f7171b.setPivotY(this.f7176g);
            this.f7171b.setScaleY(fA);
            if (jCurrentAnimationTimeMillis - this.f7172c > this.f7173d) {
                this.f7170a = 1;
                this.f7174e = fA;
                this.f7175f = 1.0f;
                this.f7172c = AnimationUtils.currentAnimationTimeMillis();
                this.f7173d = 150.0f;
            }
        }
        return this.f7170a != 0;
    }
}
