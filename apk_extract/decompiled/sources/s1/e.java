package s1;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import j1.b0;
import j1.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m1.r;

/* JADX INFO: loaded from: classes.dex */
public final class e extends c {
    public m1.e D;
    public final ArrayList E;
    public final RectF F;
    public final RectF G;
    public final Paint H;
    public float I;
    public boolean J;

    public e(x xVar, i iVar, List list, j1.j jVar) {
        c cVar;
        c kVar;
        super(xVar, iVar);
        this.E = new ArrayList();
        this.F = new RectF();
        this.G = new RectF();
        this.H = new Paint();
        this.J = true;
        q1.b bVar = iVar.f9486s;
        if (bVar != null) {
            m1.i iVarG = bVar.g();
            this.D = iVarG;
            f(iVarG);
            this.D.a(this);
        } else {
            this.D = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(jVar.f5971j.size());
        int size = list.size() - 1;
        c cVar2 = null;
        while (true) {
            if (size < 0) {
                for (int i8 = 0; i8 < longSparseArray.size(); i8++) {
                    c cVar3 = (c) longSparseArray.get(longSparseArray.keyAt(i8));
                    if (cVar3 != null && (cVar = (c) longSparseArray.get(cVar3.p.f)) != null) {
                        cVar3.f9465t = cVar;
                    }
                }
                return;
            }
            i iVar2 = (i) list.get(size);
            switch (b.f9448a[iVar2.e.ordinal()]) {
                case 1:
                    kVar = new k(xVar, iVar2, this, jVar);
                    break;
                case 2:
                    kVar = new e(xVar, iVar2, (List) jVar.f5966c.get(iVar2.f9476g), jVar);
                    break;
                case 3:
                    kVar = new f(xVar, iVar2, 1);
                    break;
                case 4:
                    kVar = new f(xVar, iVar2, 0);
                    break;
                case 5:
                    kVar = new j(xVar, iVar2);
                    break;
                case 6:
                    kVar = new n(xVar, iVar2);
                    break;
                default:
                    w1.b.b("Unknown layer type " + iVar2.e);
                    kVar = null;
                    break;
            }
            if (kVar != null) {
                longSparseArray.put(kVar.p.f9475d, kVar);
                if (cVar2 != null) {
                    cVar2.f9464s = kVar;
                    cVar2 = null;
                } else {
                    this.E.add(0, kVar);
                    int i9 = d.f9471a[iVar2.u.ordinal()];
                    if (i9 == 1 || i9 == 2) {
                        cVar2 = kVar;
                    }
                }
            }
            size--;
        }
    }

    @Override // s1.c, l1.f
    public final void d(RectF rectF, Matrix matrix, boolean z2) {
        super.d(rectF, matrix, z2);
        ArrayList arrayList = this.E;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            RectF rectF2 = this.F;
            rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
            ((c) arrayList.get(size)).d(rectF2, this.f9461n, true);
            rectF.union(rectF2);
        }
    }

    @Override // s1.c, p1.g
    public final void e(ColorFilter colorFilter, x1.c cVar) {
        super.e(colorFilter, cVar);
        if (colorFilter == b0.f5942z) {
            r rVar = new r(cVar, null);
            this.D = rVar;
            rVar.a(this);
            f(this.D);
        }
    }

    @Override // s1.c
    public final void i(Canvas canvas, Matrix matrix, int i8) {
        j1.a aVar = j1.d.f5945a;
        RectF rectF = this.G;
        i iVar = this.p;
        rectF.set(0.0f, 0.0f, iVar.f9484o, iVar.p);
        matrix.mapRect(rectF);
        boolean z2 = this.f9462o.f6026v;
        ArrayList arrayList = this.E;
        boolean z3 = z2 && arrayList.size() > 1 && i8 != 255;
        if (z3) {
            Paint paint = this.H;
            paint.setAlpha(i8);
            w1.g.e(canvas, rectF, paint);
        } else {
            canvas.save();
        }
        if (z3) {
            i8 = 255;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((this.J || !"__container".equals(iVar.f9474c)) && !rectF.isEmpty()) ? canvas.clipRect(rectF) : true) {
                ((c) arrayList.get(size)).g(canvas, matrix, i8);
            }
        }
        canvas.restore();
        j1.a aVar2 = j1.d.f5945a;
    }

    @Override // s1.c
    public final void o(p1.f fVar, int i8, ArrayList arrayList, p1.f fVar2) {
        int i9 = 0;
        while (true) {
            ArrayList arrayList2 = this.E;
            if (i9 >= arrayList2.size()) {
                return;
            }
            ((c) arrayList2.get(i9)).c(fVar, i8, arrayList, fVar2);
            i9++;
        }
    }

    @Override // s1.c
    public final void p(boolean z2) {
        super.p(z2);
        Iterator it = this.E.iterator();
        while (it.hasNext()) {
            ((c) it.next()).p(z2);
        }
    }

    @Override // s1.c
    public final void q(float f) {
        j1.a aVar = j1.d.f5945a;
        this.I = f;
        super.q(f);
        m1.e eVar = this.D;
        i iVar = this.p;
        if (eVar != null) {
            j1.j jVar = this.f9462o.f6011a;
            f = ((((Float) eVar.f()).floatValue() * iVar.f9473b.f5975n) - iVar.f9473b.f5973l) / ((jVar.f5974m - jVar.f5973l) + 0.01f);
        }
        if (this.D == null) {
            j1.j jVar2 = iVar.f9473b;
            f -= iVar.f9483n / (jVar2.f5974m - jVar2.f5973l);
        }
        if (iVar.f9482m != 0.0f && !"__container".equals(iVar.f9474c)) {
            f /= iVar.f9482m;
        }
        ArrayList arrayList = this.E;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((c) arrayList.get(size)).q(f);
        }
        j1.a aVar2 = j1.d.f5945a;
    }
}
