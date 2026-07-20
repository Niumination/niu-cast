package u0;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<s0.a> f16133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PointF f16134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16135c;

    public l(PointF pointF, boolean z10, List<s0.a> list) {
        this.f16134b = pointF;
        this.f16135c = z10;
        this.f16133a = new ArrayList(list);
    }

    public List<s0.a> a() {
        return this.f16133a;
    }

    public PointF b() {
        return this.f16134b;
    }

    public void c(l lVar, l lVar2, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        if (this.f16134b == null) {
            this.f16134b = new PointF();
        }
        this.f16135c = lVar.d() || lVar2.d();
        if (lVar.a().size() != lVar2.a().size()) {
            z0.d.e("Curves must have the same number of control points. Shape 1: " + lVar.a().size() + "\tShape 2: " + lVar2.a().size());
        }
        int iMin = Math.min(lVar.a().size(), lVar2.a().size());
        if (this.f16133a.size() < iMin) {
            for (int size = this.f16133a.size(); size < iMin; size++) {
                this.f16133a.add(new s0.a());
            }
        } else if (this.f16133a.size() > iMin) {
            for (int size2 = this.f16133a.size() - 1; size2 >= iMin; size2--) {
                List<s0.a> list = this.f16133a;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFB = lVar.b();
        PointF pointFB2 = lVar2.b();
        e(z0.g.k(pointFB.x, pointFB2.x, f10), z0.g.k(pointFB.y, pointFB2.y, f10));
        for (int size3 = this.f16133a.size() - 1; size3 >= 0; size3--) {
            s0.a aVar = lVar.a().get(size3);
            s0.a aVar2 = lVar2.a().get(size3);
            PointF pointFA = aVar.a();
            PointF pointFB3 = aVar.b();
            PointF pointFC = aVar.c();
            PointF pointFA2 = aVar2.a();
            PointF pointFB4 = aVar2.b();
            PointF pointFC2 = aVar2.c();
            this.f16133a.get(size3).d(z0.g.k(pointFA.x, pointFA2.x, f10), z0.g.k(pointFA.y, pointFA2.y, f10));
            this.f16133a.get(size3).e(z0.g.k(pointFB3.x, pointFB4.x, f10), z0.g.k(pointFB3.y, pointFB4.y, f10));
            this.f16133a.get(size3).f(z0.g.k(pointFC.x, pointFC2.x, f10), z0.g.k(pointFC.y, pointFC2.y, f10));
        }
    }

    public boolean d() {
        return this.f16135c;
    }

    public final void e(float f10, float f11) {
        if (this.f16134b == null) {
            this.f16134b = new PointF();
        }
        this.f16134b.set(f10, f11);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f16133a.size() + "closed=" + this.f16135c + rs.f.f14860b;
    }

    public l() {
        this.f16133a = new ArrayList();
    }
}
