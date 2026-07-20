package p0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d implements e, n, q0.a.b, s0.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f12569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f12570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f12571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Path f12572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f12573e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f12574f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f12575g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<c> f12576h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n0.j f12577i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public List<n> f12578j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public q0.o f12579k;

    public d(n0.j jVar, v0.a aVar, u0.n nVar) {
        this(jVar, aVar, nVar.c(), nVar.d(), d(jVar, aVar, nVar.b()), h(nVar.b()));
    }

    public static List<c> d(n0.j jVar, v0.a aVar, List<u0.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVarA = list.get(i10).a(jVar, aVar);
            if (cVarA != null) {
                arrayList.add(cVarA);
            }
        }
        return arrayList;
    }

    @Nullable
    public static t0.l h(List<u0.b> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            u0.b bVar = list.get(i10);
            if (bVar instanceof t0.l) {
                return (t0.l) bVar;
            }
        }
        return null;
    }

    @Override // q0.a.b
    public void a() {
        this.f12577i.invalidateSelf();
    }

    @Override // p0.c
    public void b(List<c> list, List<c> list2) {
        ArrayList arrayList = new ArrayList(this.f12576h.size() + list.size());
        arrayList.addAll(list);
        for (int size = this.f12576h.size() - 1; size >= 0; size--) {
            c cVar = this.f12576h.get(size);
            cVar.b(arrayList, this.f12576h.subList(0, size));
            arrayList.add(cVar);
        }
    }

    @Override // p0.e
    public void c(RectF rectF, Matrix matrix, boolean z10) {
        this.f12571c.set(matrix);
        q0.o oVar = this.f12579k;
        if (oVar != null) {
            this.f12571c.preConcat(oVar.f());
        }
        this.f12573e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f12576h.size() - 1; size >= 0; size--) {
            c cVar = this.f12576h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).c(this.f12573e, this.f12571c, z10);
                rectF.union(this.f12573e);
            }
        }
    }

    @Override // s0.g
    public void e(s0.f fVar, int i10, List<s0.f> list, s0.f fVar2) {
        if (fVar.h(getName(), i10) || "__container".equals(getName())) {
            if (!"__container".equals(getName())) {
                fVar2 = fVar2.a(getName());
                if (fVar.c(getName(), i10)) {
                    list.add(fVar2.j(this));
                }
            }
            if (fVar.i(getName(), i10)) {
                int iE = fVar.e(getName(), i10) + i10;
                for (int i11 = 0; i11 < this.f12576h.size(); i11++) {
                    c cVar = this.f12576h.get(i11);
                    if (cVar instanceof s0.g) {
                        ((s0.g) cVar).e(fVar, iE, list, fVar2);
                    }
                }
            }
        }
    }

    @Override // s0.g
    public <T> void f(T t10, @Nullable a1.j<T> jVar) {
        q0.o oVar = this.f12579k;
        if (oVar != null) {
            oVar.c(t10, jVar);
        }
    }

    @Override // p0.e
    public void g(Canvas canvas, Matrix matrix, int i10) {
        if (this.f12575g) {
            return;
        }
        this.f12571c.set(matrix);
        q0.o oVar = this.f12579k;
        if (oVar != null) {
            this.f12571c.preConcat(oVar.f());
            i10 = (int) (((((this.f12579k.h() == null ? 100 : this.f12579k.h().h().intValue()) / 100.0f) * i10) / 255.0f) * 255.0f);
        }
        boolean z10 = this.f12577i.O() && k() && i10 != 255;
        if (z10) {
            this.f12570b.set(0.0f, 0.0f, 0.0f, 0.0f);
            c(this.f12570b, this.f12571c, true);
            this.f12569a.setAlpha(i10);
            z0.h.n(canvas, this.f12570b, this.f12569a);
        }
        if (z10) {
            i10 = 255;
        }
        for (int size = this.f12576h.size() - 1; size >= 0; size--) {
            c cVar = this.f12576h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).g(canvas, this.f12571c, i10);
            }
        }
        if (z10) {
            canvas.restore();
        }
    }

    @Override // p0.c
    public String getName() {
        return this.f12574f;
    }

    @Override // p0.n
    public Path getPath() {
        this.f12571c.reset();
        q0.o oVar = this.f12579k;
        if (oVar != null) {
            this.f12571c.set(oVar.f());
        }
        this.f12572d.reset();
        if (this.f12575g) {
            return this.f12572d;
        }
        for (int size = this.f12576h.size() - 1; size >= 0; size--) {
            c cVar = this.f12576h.get(size);
            if (cVar instanceof n) {
                this.f12572d.addPath(((n) cVar).getPath(), this.f12571c);
            }
        }
        return this.f12572d;
    }

    public List<n> i() {
        if (this.f12578j == null) {
            this.f12578j = new ArrayList();
            for (int i10 = 0; i10 < this.f12576h.size(); i10++) {
                c cVar = this.f12576h.get(i10);
                if (cVar instanceof n) {
                    this.f12578j.add((n) cVar);
                }
            }
        }
        return this.f12578j;
    }

    public Matrix j() {
        q0.o oVar = this.f12579k;
        if (oVar != null) {
            return oVar.f();
        }
        this.f12571c.reset();
        return this.f12571c;
    }

    public final boolean k() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f12576h.size(); i11++) {
            if ((this.f12576h.get(i11) instanceof e) && (i10 = i10 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    public d(n0.j jVar, v0.a aVar, String str, boolean z10, List<c> list, @Nullable t0.l lVar) {
        this.f12569a = new o0.a();
        this.f12570b = new RectF();
        this.f12571c = new Matrix();
        this.f12572d = new Path();
        this.f12573e = new RectF();
        this.f12574f = str;
        this.f12577i = jVar;
        this.f12575g = z10;
        this.f12576h = list;
        if (lVar != null) {
            q0.o oVarB = lVar.b();
            this.f12579k = oVarB;
            oVarB.a(aVar);
            this.f12579k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).d(list.listIterator(list.size()));
        }
    }
}
