package m1;

import android.graphics.Path;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public final class l extends x1.a {
    public Path q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final x1.a f7594r;

    public l(j1.j jVar, x1.a aVar) {
        super(jVar, (PointF) aVar.f10807b, (PointF) aVar.f10808c, aVar.f10809d, aVar.e, aVar.f, aVar.f10810g, aVar.f10811h);
        this.f7594r = aVar;
        d();
    }

    public final void d() {
        Object obj;
        Object obj2 = this.f10808c;
        Object obj3 = this.f10807b;
        boolean z2 = (obj2 == null || obj3 == null || !((PointF) obj3).equals(((PointF) obj2).x, ((PointF) obj2).y)) ? false : true;
        if (obj3 == null || (obj = this.f10808c) == null || z2) {
            return;
        }
        PointF pointF = (PointF) obj3;
        PointF pointF2 = (PointF) obj;
        x1.a aVar = this.f7594r;
        PointF pointF3 = aVar.f10818o;
        PointF pointF4 = aVar.p;
        g3.h hVar = w1.g.f10647a;
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f = pointF3.x + pointF.x;
            float f4 = pointF.y + pointF3.y;
            float f10 = pointF2.x;
            float f11 = f10 + pointF4.x;
            float f12 = pointF2.y;
            path.cubicTo(f, f4, f11, f12 + pointF4.y, f10, f12);
        }
        this.q = path;
    }
}
