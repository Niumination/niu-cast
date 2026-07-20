package s0;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f14885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f14886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f14887c;

    public a() {
        this.f14885a = new PointF();
        this.f14886b = new PointF();
        this.f14887c = new PointF();
    }

    public PointF a() {
        return this.f14885a;
    }

    public PointF b() {
        return this.f14886b;
    }

    public PointF c() {
        return this.f14887c;
    }

    public void d(float f10, float f11) {
        this.f14885a.set(f10, f11);
    }

    public void e(float f10, float f11) {
        this.f14886b.set(f10, f11);
    }

    public void f(float f10, float f11) {
        this.f14887c.set(f10, f11);
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f14885a = pointF;
        this.f14886b = pointF2;
        this.f14887c = pointF3;
    }
}
