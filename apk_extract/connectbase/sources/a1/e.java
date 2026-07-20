package a1;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public class e extends f<PointF> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PointF f28g;

    public e(PointF pointF, PointF pointF2) {
        super(pointF, pointF2);
        this.f28g = new PointF();
    }

    @Override // a1.f, a1.j
    public /* bridge */ /* synthetic */ Object a(b bVar) {
        return super.a(bVar);
    }

    @Override // a1.f
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public PointF e(PointF pointF, PointF pointF2, float f10) {
        this.f28g.set(z0.g.k(pointF.x, pointF2.x, f10), z0.g.k(pointF.y, pointF2.y, f10));
        return this.f28g;
    }

    public e(PointF pointF, PointF pointF2, Interpolator interpolator) {
        super(pointF, pointF2, interpolator);
        this.f28g = new PointF();
    }
}
