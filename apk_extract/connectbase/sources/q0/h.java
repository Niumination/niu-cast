package q0;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class h extends a1.a<PointF> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public Path f13368s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a1.a<PointF> f13369t;

    public h(n0.g gVar, a1.a<PointF> aVar) {
        super(gVar, aVar.f6b, aVar.f7c, aVar.f8d, aVar.f9e, aVar.f10f, aVar.f11g, aVar.f12h);
        this.f13369t = aVar;
        i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i() {
        T t10;
        T t11;
        T t12 = this.f7c;
        boolean z10 = (t12 == 0 || (t11 = this.f6b) == 0 || !((PointF) t11).equals(((PointF) t12).x, ((PointF) t12).y)) ? false : true;
        T t13 = this.f6b;
        if (t13 == 0 || (t10 = this.f7c) == 0 || z10) {
            return;
        }
        a1.a<PointF> aVar = this.f13369t;
        this.f13368s = z0.h.d((PointF) t13, (PointF) t10, aVar.f19o, aVar.f20p);
    }

    @Nullable
    public Path j() {
        return this.f13368s;
    }
}
