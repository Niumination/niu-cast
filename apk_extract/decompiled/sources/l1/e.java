package l1;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import j1.x;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e implements f, o, m1.a, p1.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k1.a f7097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f7098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f7099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Path f7100d;
    public final RectF e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f7101g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f7102h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final x f7103i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f7104j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final m1.q f7105k;

    public e(x xVar, s1.c cVar, r1.s sVar, j1.j jVar) {
        q1.d dVar;
        String str = sVar.f9295a;
        List list = sVar.f9296b;
        ArrayList arrayList = new ArrayList(list.size());
        int i8 = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            d dVarA = ((r1.b) list.get(i9)).a(xVar, jVar, cVar);
            if (dVarA != null) {
                arrayList.add(dVarA);
            }
        }
        while (true) {
            if (i8 >= list.size()) {
                dVar = null;
                break;
            }
            r1.b bVar = (r1.b) list.get(i8);
            if (bVar instanceof q1.d) {
                dVar = (q1.d) bVar;
                break;
            }
            i8++;
        }
        this(xVar, cVar, str, sVar.f9297c, arrayList, dVar);
    }

    @Override // m1.a
    public final void a() {
        this.f7103i.invalidateSelf();
    }

    @Override // l1.d
    public final void b(List list, List list2) {
        int size = list.size();
        ArrayList arrayList = this.f7102h;
        ArrayList arrayList2 = new ArrayList(arrayList.size() + size);
        arrayList2.addAll(list);
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            d dVar = (d) arrayList.get(size2);
            dVar.b(arrayList2, arrayList.subList(0, size2));
            arrayList2.add(dVar);
        }
    }

    @Override // p1.g
    public final void c(p1.f fVar, int i8, ArrayList arrayList, p1.f fVar2) {
        String str = this.f;
        if (!fVar.c(i8, str) && !"__container".equals(str)) {
            return;
        }
        if (!"__container".equals(str)) {
            fVar2.getClass();
            p1.f fVar3 = new p1.f(fVar2);
            fVar3.f8638a.add(str);
            if (fVar.a(i8, str)) {
                p1.f fVar4 = new p1.f(fVar3);
                fVar4.f8639b = this;
                arrayList.add(fVar4);
            }
            fVar2 = fVar3;
        }
        if (!fVar.d(i8, str)) {
            return;
        }
        int iB = fVar.b(i8, str) + i8;
        int i9 = 0;
        while (true) {
            ArrayList arrayList2 = this.f7102h;
            if (i9 >= arrayList2.size()) {
                return;
            }
            d dVar = (d) arrayList2.get(i9);
            if (dVar instanceof p1.g) {
                ((p1.g) dVar).c(fVar, iB, arrayList, fVar2);
            }
            i9++;
        }
    }

    @Override // l1.f
    public final void d(RectF rectF, Matrix matrix, boolean z2) {
        Matrix matrix2 = this.f7099c;
        matrix2.set(matrix);
        m1.q qVar = this.f7105k;
        if (qVar != null) {
            matrix2.preConcat(qVar.e());
        }
        RectF rectF2 = this.e;
        rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
        ArrayList arrayList = this.f7102h;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            d dVar = (d) arrayList.get(size);
            if (dVar instanceof f) {
                ((f) dVar).d(rectF2, matrix2, z2);
                rectF.union(rectF2);
            }
        }
    }

    @Override // p1.g
    public final void e(ColorFilter colorFilter, x1.c cVar) {
        m1.q qVar = this.f7105k;
        if (qVar != null) {
            qVar.c(colorFilter, cVar);
        }
    }

    public final List f() {
        if (this.f7104j == null) {
            this.f7104j = new ArrayList();
            int i8 = 0;
            while (true) {
                ArrayList arrayList = this.f7102h;
                if (i8 >= arrayList.size()) {
                    break;
                }
                d dVar = (d) arrayList.get(i8);
                if (dVar instanceof o) {
                    this.f7104j.add((o) dVar);
                }
                i8++;
            }
        }
        return this.f7104j;
    }

    @Override // l1.f
    public final void g(Canvas canvas, Matrix matrix, int i8) {
        if (this.f7101g) {
            return;
        }
        Matrix matrix2 = this.f7099c;
        matrix2.set(matrix);
        m1.q qVar = this.f7105k;
        if (qVar != null) {
            matrix2.preConcat(qVar.e());
            m1.e eVar = qVar.f7620j;
            i8 = (int) (((((eVar == null ? 100 : ((Integer) eVar.f()).intValue()) / 100.0f) * i8) / 255.0f) * 255.0f);
        }
        boolean z2 = this.f7103i.f6026v;
        ArrayList arrayList = this.f7102h;
        boolean z3 = false;
        if (z2) {
            int i9 = 0;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                if ((arrayList.get(i10) instanceof f) && (i9 = i9 + 1) >= 2) {
                    if (i8 == 255) {
                        break;
                    }
                    z3 = true;
                    break;
                }
            }
        }
        if (z3) {
            RectF rectF = this.f7098b;
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            d(rectF, matrix2, true);
            k1.a aVar = this.f7097a;
            aVar.setAlpha(i8);
            w1.g.e(canvas, rectF, aVar);
        }
        if (z3) {
            i8 = 255;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Object obj = arrayList.get(size);
            if (obj instanceof f) {
                ((f) obj).g(canvas, matrix2, i8);
            }
        }
        if (z3) {
            canvas.restore();
        }
    }

    @Override // l1.d
    public final String getName() {
        throw null;
    }

    @Override // l1.o
    public final Path getPath() {
        Matrix matrix = this.f7099c;
        matrix.reset();
        m1.q qVar = this.f7105k;
        if (qVar != null) {
            matrix.set(qVar.e());
        }
        Path path = this.f7100d;
        path.reset();
        if (this.f7101g) {
            return path;
        }
        ArrayList arrayList = this.f7102h;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            d dVar = (d) arrayList.get(size);
            if (dVar instanceof o) {
                path.addPath(((o) dVar).getPath(), matrix);
            }
        }
        return path;
    }

    public e(x xVar, s1.c cVar, String str, boolean z2, ArrayList arrayList, q1.d dVar) {
        this.f7097a = new k1.a();
        this.f7098b = new RectF();
        this.f7099c = new Matrix();
        this.f7100d = new Path();
        this.e = new RectF();
        this.f = str;
        this.f7103i = xVar;
        this.f7101g = z2;
        this.f7102h = arrayList;
        if (dVar != null) {
            m1.q qVar = new m1.q(dVar);
            this.f7105k = qVar;
            qVar.a(cVar);
            qVar.b(this);
        }
        ArrayList arrayList2 = new ArrayList();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            d dVar2 = (d) arrayList.get(size);
            if (dVar2 instanceof k) {
                arrayList2.add((k) dVar2);
            }
        }
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            ((k) arrayList2.get(size2)).f(arrayList.listIterator(arrayList.size()));
        }
    }
}
