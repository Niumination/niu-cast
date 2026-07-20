package l1;

import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.PointF;
import j1.b0;
import j1.x;
import java.util.ArrayList;
import java.util.List;
import r1.y;

/* JADX INFO: loaded from: classes.dex */
public final class g implements o, m1.a, l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f7108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m1.j f7109d;
    public final m1.e e;
    public final r1.a f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7111h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f7106a = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f7110g = new c(0);

    public g(x xVar, s1.c cVar, r1.a aVar) {
        this.f7107b = aVar.f9244a;
        this.f7108c = xVar;
        m1.e eVarG = aVar.f9246c.g();
        this.f7109d = (m1.j) eVarG;
        m1.e eVarG2 = aVar.f9245b.g();
        this.e = eVarG2;
        this.f = aVar;
        cVar.f(eVarG);
        cVar.f(eVarG2);
        eVarG.a(this);
        eVarG2.a(this);
    }

    @Override // m1.a
    public final void a() {
        this.f7111h = false;
        this.f7108c.invalidateSelf();
    }

    @Override // l1.d
    public final void b(List list, List list2) {
        int i8 = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) list;
            if (i8 >= arrayList.size()) {
                return;
            }
            d dVar = (d) arrayList.get(i8);
            if (dVar instanceof w) {
                w wVar = (w) dVar;
                if (wVar.f7198c == y.SIMULTANEOUSLY) {
                    this.f7110g.f7096a.add(wVar);
                    wVar.c(this);
                }
            }
            i8++;
        }
    }

    @Override // p1.g
    public final void c(p1.f fVar, int i8, ArrayList arrayList, p1.f fVar2) {
        w1.f.f(fVar, i8, arrayList, fVar2, this);
    }

    @Override // p1.g
    public final void e(ColorFilter colorFilter, x1.c cVar) {
        if (colorFilter == b0.f) {
            this.f7109d.k(cVar);
        } else if (colorFilter == b0.f5928i) {
            this.e.k(cVar);
        }
    }

    @Override // l1.d
    public final String getName() {
        return this.f7107b;
    }

    @Override // l1.o
    public final Path getPath() {
        boolean z2 = this.f7111h;
        Path path = this.f7106a;
        if (z2) {
            return path;
        }
        path.reset();
        r1.a aVar = this.f;
        if (aVar.e) {
            this.f7111h = true;
            return path;
        }
        PointF pointF = (PointF) this.f7109d.f();
        float f = pointF.x / 2.0f;
        float f4 = pointF.y / 2.0f;
        float f10 = f * 0.55228f;
        float f11 = f4 * 0.55228f;
        path.reset();
        if (aVar.f9247d) {
            float f12 = -f4;
            path.moveTo(0.0f, f12);
            float f13 = 0.0f - f10;
            float f14 = -f;
            float f15 = 0.0f - f11;
            path.cubicTo(f13, f12, f14, f15, f14, 0.0f);
            float f16 = f11 + 0.0f;
            path.cubicTo(f14, f16, f13, f4, 0.0f, f4);
            float f17 = f10 + 0.0f;
            path.cubicTo(f17, f4, f, f16, f, 0.0f);
            path.cubicTo(f, f15, f17, f12, 0.0f, f12);
        } else {
            float f18 = -f4;
            path.moveTo(0.0f, f18);
            float f19 = f10 + 0.0f;
            float f20 = 0.0f - f11;
            path.cubicTo(f19, f18, f, f20, f, 0.0f);
            float f21 = f11 + 0.0f;
            path.cubicTo(f, f21, f19, f4, 0.0f, f4);
            float f22 = 0.0f - f10;
            float f23 = -f;
            path.cubicTo(f22, f4, f23, f21, f23, 0.0f);
            path.cubicTo(f23, f20, f22, f18, 0.0f, f18);
        }
        PointF pointF2 = (PointF) this.e.f();
        path.offset(pointF2.x, pointF2.y);
        path.close();
        this.f7110g.a(path);
        this.f7111h = true;
        return path;
    }
}
