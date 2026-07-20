package a1;

import android.graphics.PointF;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class i extends j<PointF> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PointF f32d;

    public i() {
        this.f32d = new PointF();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PointF e(b<PointF> bVar) {
        T t10 = this.f35c;
        if (t10 != 0) {
            return (PointF) t10;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    @Override // a1.j
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final PointF a(b<PointF> bVar) {
        this.f32d.set(z0.g.k(bVar.g().x, bVar.b().x, bVar.c()), z0.g.k(bVar.g().y, bVar.b().y, bVar.c()));
        PointF pointFE = e(bVar);
        this.f32d.offset(pointFE.x, pointFE.y);
        return this.f32d;
    }

    public i(@NonNull PointF pointF) {
        super(pointF);
        this.f32d = new PointF();
    }
}
