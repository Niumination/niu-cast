package l1;

import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import j1.b0;
import j1.x;
import java.util.ArrayList;
import java.util.List;
import r1.y;

/* JADX INFO: loaded from: classes.dex */
public final class r implements m1.a, l, o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f7170d;
    public final x e;
    public final m1.e f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m1.e f7171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m1.i f7172h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f7175k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f7167a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f7168b = new RectF();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f7173i = new c(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m1.e f7174j = null;

    public r(x xVar, s1.c cVar, r1.o oVar) {
        this.f7169c = (String) oVar.f9284b;
        this.f7170d = oVar.f9286d;
        this.e = xVar;
        m1.e eVarG = oVar.e.g();
        this.f = eVarG;
        m1.e eVarG2 = ((q1.a) oVar.f).g();
        this.f7171g = eVarG2;
        m1.i iVarG = oVar.f9285c.g();
        this.f7172h = iVarG;
        cVar.f(eVarG);
        cVar.f(eVarG2);
        cVar.f(iVarG);
        eVarG.a(this);
        eVarG2.a(this);
        iVarG.a(this);
    }

    @Override // m1.a
    public final void a() {
        this.f7175k = false;
        this.e.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:12:0x002c  */
    /* JADX WARN: Code duplicated, block: B:18:0x0032 A[SYNTHETIC] */
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
                    this.f7173i.f7096a.add(wVar);
                    wVar.c(this);
                } else if (dVar instanceof t) {
                    this.f7174j = ((t) dVar).f7185b;
                }
            } else if (dVar instanceof t) {
                this.f7174j = ((t) dVar).f7185b;
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
        if (colorFilter == b0.f5926g) {
            this.f7171g.k(cVar);
        } else if (colorFilter == b0.f5928i) {
            this.f.k(cVar);
        } else if (colorFilter == b0.f5927h) {
            this.f7172h.k(cVar);
        }
    }

    @Override // l1.d
    public final String getName() {
        return this.f7169c;
    }

    @Override // l1.o
    public final Path getPath() {
        m1.e eVar;
        boolean z2 = this.f7175k;
        Path path = this.f7167a;
        if (z2) {
            return path;
        }
        path.reset();
        if (this.f7170d) {
            this.f7175k = true;
            return path;
        }
        PointF pointF = (PointF) this.f7171g.f();
        float f = pointF.x / 2.0f;
        float f4 = pointF.y / 2.0f;
        m1.i iVar = this.f7172h;
        float fL = iVar == null ? 0.0f : iVar.l();
        if (fL == 0.0f && (eVar = this.f7174j) != null) {
            fL = Math.min(((Float) eVar.f()).floatValue(), Math.min(f, f4));
        }
        float fMin = Math.min(f, f4);
        if (fL > fMin) {
            fL = fMin;
        }
        PointF pointF2 = (PointF) this.f.f();
        path.moveTo(pointF2.x + f, (pointF2.y - f4) + fL);
        path.lineTo(pointF2.x + f, (pointF2.y + f4) - fL);
        RectF rectF = this.f7168b;
        if (fL > 0.0f) {
            float f10 = pointF2.x + f;
            float f11 = fL * 2.0f;
            float f12 = pointF2.y + f4;
            rectF.set(f10 - f11, f12 - f11, f10, f12);
            path.arcTo(rectF, 0.0f, 90.0f, false);
        }
        path.lineTo((pointF2.x - f) + fL, pointF2.y + f4);
        if (fL > 0.0f) {
            float f13 = pointF2.x - f;
            float f14 = pointF2.y + f4;
            float f15 = fL * 2.0f;
            rectF.set(f13, f14 - f15, f15 + f13, f14);
            path.arcTo(rectF, 90.0f, 90.0f, false);
        }
        path.lineTo(pointF2.x - f, (pointF2.y - f4) + fL);
        if (fL > 0.0f) {
            float f16 = pointF2.x - f;
            float f17 = pointF2.y - f4;
            float f18 = fL * 2.0f;
            rectF.set(f16, f17, f16 + f18, f18 + f17);
            path.arcTo(rectF, 180.0f, 90.0f, false);
        }
        path.lineTo((pointF2.x + f) - fL, pointF2.y - f4);
        if (fL > 0.0f) {
            float f19 = pointF2.x + f;
            float f20 = fL * 2.0f;
            float f21 = pointF2.y - f4;
            rectF.set(f19 - f20, f21, f19, f20 + f21);
            path.arcTo(rectF, 270.0f, 90.0f, false);
        }
        path.close();
        this.f7173i.a(path);
        this.f7175k = true;
        return path;
    }
}
