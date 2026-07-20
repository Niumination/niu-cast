package l1;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import j1.b0;
import j1.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public final class s implements f, o, k, m1.a, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f7176a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f7177b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f7178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s1.c f7179d;
    public final String e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m1.i f7180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m1.i f7181h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final m1.q f7182i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f7183j;

    public s(x xVar, s1.c cVar, r1.o oVar) {
        this.f7178c = xVar;
        this.f7179d = cVar;
        this.e = (String) oVar.f9284b;
        this.f = oVar.f9286d;
        m1.i iVarG = oVar.f9285c.g();
        this.f7180g = iVarG;
        cVar.f(iVarG);
        iVarG.a(this);
        m1.i iVarG2 = ((q1.b) oVar.e).g();
        this.f7181h = iVarG2;
        cVar.f(iVarG2);
        iVarG2.a(this);
        q1.d dVar = (q1.d) oVar.f;
        dVar.getClass();
        m1.q qVar = new m1.q(dVar);
        this.f7182i = qVar;
        qVar.a(cVar);
        qVar.b(this);
    }

    @Override // m1.a
    public final void a() {
        this.f7178c.invalidateSelf();
    }

    @Override // l1.d
    public final void b(List list, List list2) {
        this.f7183j.b(list, list2);
    }

    @Override // p1.g
    public final void c(p1.f fVar, int i8, ArrayList arrayList, p1.f fVar2) {
        w1.f.f(fVar, i8, arrayList, fVar2, this);
        for (int i9 = 0; i9 < this.f7183j.f7102h.size(); i9++) {
            d dVar = (d) this.f7183j.f7102h.get(i9);
            if (dVar instanceof l) {
                w1.f.f(fVar, i8, arrayList, fVar2, (l) dVar);
            }
        }
    }

    @Override // l1.f
    public final void d(RectF rectF, Matrix matrix, boolean z2) {
        this.f7183j.d(rectF, matrix, z2);
    }

    @Override // p1.g
    public final void e(ColorFilter colorFilter, x1.c cVar) {
        if (this.f7182i.c(colorFilter, cVar)) {
            return;
        }
        if (colorFilter == b0.p) {
            this.f7180g.k(cVar);
        } else if (colorFilter == b0.q) {
            this.f7181h.k(cVar);
        }
    }

    @Override // l1.k
    public final void f(ListIterator listIterator) {
        if (this.f7183j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add((d) listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f7183j = new e(this.f7178c, this.f7179d, "Repeater", this.f, arrayList, null);
    }

    @Override // l1.f
    public final void g(Canvas canvas, Matrix matrix, int i8) {
        float fFloatValue = ((Float) this.f7180g.f()).floatValue();
        float fFloatValue2 = ((Float) this.f7181h.f()).floatValue();
        m1.q qVar = this.f7182i;
        float fFloatValue3 = ((Float) qVar.f7623m.f()).floatValue() / 100.0f;
        float fFloatValue4 = ((Float) qVar.f7624n.f()).floatValue() / 100.0f;
        for (int i9 = ((int) fFloatValue) - 1; i9 >= 0; i9--) {
            Matrix matrix2 = this.f7176a;
            matrix2.set(matrix);
            float f = i9;
            matrix2.preConcat(qVar.f(f + fFloatValue2));
            this.f7183j.g(canvas, matrix2, (int) (w1.f.e(fFloatValue3, fFloatValue4, f / fFloatValue) * i8));
        }
    }

    @Override // l1.d
    public final String getName() {
        return this.e;
    }

    @Override // l1.o
    public final Path getPath() {
        Path path = this.f7183j.getPath();
        Path path2 = this.f7177b;
        path2.reset();
        float fFloatValue = ((Float) this.f7180g.f()).floatValue();
        float fFloatValue2 = ((Float) this.f7181h.f()).floatValue();
        for (int i8 = ((int) fFloatValue) - 1; i8 >= 0; i8--) {
            Matrix matrix = this.f7176a;
            matrix.set(this.f7182i.f(i8 + fFloatValue2));
            path2.addPath(path, matrix);
        }
        return path2;
    }
}
