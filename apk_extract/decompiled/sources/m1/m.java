package m1;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class m extends k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PointF f7595i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f7596j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float[] f7597k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PathMeasure f7598l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public l f7599m;

    public m(ArrayList arrayList) {
        super(arrayList);
        this.f7595i = new PointF();
        this.f7596j = new float[2];
        this.f7597k = new float[2];
        this.f7598l = new PathMeasure();
    }

    @Override // m1.e
    public final Object g(x1.a aVar, float f) {
        l lVar = (l) aVar;
        Path path = lVar.q;
        x1.c cVar = this.e;
        if (cVar != null && aVar.f10811h != null) {
            PointF pointF = (PointF) cVar.b(lVar.f10810g, lVar.f10811h.floatValue(), (PointF) lVar.f10807b, (PointF) lVar.f10808c, e(), f, this.f7577d);
            if (pointF != null) {
                return pointF;
            }
        }
        if (path == null) {
            return (PointF) aVar.f10807b;
        }
        l lVar2 = this.f7599m;
        PathMeasure pathMeasure = this.f7598l;
        if (lVar2 != lVar) {
            pathMeasure.setPath(path, false);
            this.f7599m = lVar;
        }
        float length = pathMeasure.getLength();
        float f4 = f * length;
        float[] fArr = this.f7596j;
        float[] fArr2 = this.f7597k;
        pathMeasure.getPosTan(f4, fArr, fArr2);
        PointF pointF2 = this.f7595i;
        pointF2.set(fArr[0], fArr[1]);
        if (f4 < 0.0f) {
            pointF2.offset(fArr2[0] * f4, fArr2[1] * f4);
            return pointF2;
        }
        if (f4 <= length) {
            return pointF2;
        }
        float f10 = f4 - length;
        pointF2.offset(fArr2[0] * f10, fArr2[1] * f10);
        return pointF2;
    }
}
