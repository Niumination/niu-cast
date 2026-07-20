package l1;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import j1.b0;
import j1.x;

/* JADX INFO: loaded from: classes.dex */
public final class v extends b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final s1.c f7192r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f7193s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f7194t;
    public final m1.f u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public m1.r f7195v;

    public v(x xVar, s1.c cVar, r1.x xVar2) {
        super(xVar, cVar, xVar2.f9308g.toPaintCap(), xVar2.f9309h.toPaintJoin(), xVar2.f9310i, xVar2.e, xVar2.f, xVar2.f9306c, xVar2.f9305b);
        this.f7192r = cVar;
        this.f7193s = xVar2.f9304a;
        this.f7194t = xVar2.f9311j;
        m1.e eVarG = xVar2.f9307d.g();
        this.u = (m1.f) eVarG;
        eVarG.a(this);
        cVar.f(eVarG);
    }

    @Override // l1.b, p1.g
    public final void e(ColorFilter colorFilter, x1.c cVar) {
        super.e(colorFilter, cVar);
        PointF pointF = b0.f5922a;
        m1.f fVar = this.u;
        if (colorFilter == 2) {
            fVar.k(cVar);
            return;
        }
        if (colorFilter == b0.F) {
            m1.r rVar = this.f7195v;
            s1.c cVar2 = this.f7192r;
            if (rVar != null) {
                cVar2.n(rVar);
            }
            m1.r rVar2 = new m1.r(cVar, null);
            this.f7195v = rVar2;
            rVar2.a(this);
            cVar2.f(fVar);
        }
    }

    @Override // l1.b, l1.f
    public final void g(Canvas canvas, Matrix matrix, int i8) {
        if (this.f7194t) {
            return;
        }
        m1.f fVar = this.u;
        int iL = fVar.l(fVar.b(), fVar.d());
        k1.a aVar = this.f7089i;
        aVar.setColor(iL);
        m1.r rVar = this.f7195v;
        if (rVar != null) {
            aVar.setColorFilter((ColorFilter) rVar.f());
        }
        super.g(canvas, matrix, i8);
    }

    @Override // l1.d
    public final String getName() {
        return this.f7193s;
    }
}
