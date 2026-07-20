package s1;

import af.r5;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import androidx.core.graphics.PaintCompat;
import androidx.core.view.ViewCompat;
import j1.f0;
import j1.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import m1.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements l1.f, m1.a, p1.g {
    public float A;
    public BlurMaskFilter B;
    public k1.a C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f9450a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f9451b = new Matrix();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f9452c = new Matrix();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k1.a f9453d = new k1.a(1, 0);
    public final k1.a e;
    public final k1.a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k1.a f9454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final k1.a f9455h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f9456i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RectF f9457j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f9458k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RectF f9459l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RectF f9460m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Matrix f9461n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final x f9462o;
    public final i p;
    public final qf.c q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final m1.i f9463r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public c f9464s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public c f9465t;
    public List u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f9466v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final q f9467w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f9468x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f9469y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public k1.a f9470z;

    public c(x xVar, i iVar) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.e = new k1.a(mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.f = new k1.a(mode2);
        k1.a aVar = new k1.a(1, 0);
        this.f9454g = aVar;
        PorterDuff.Mode mode3 = PorterDuff.Mode.CLEAR;
        k1.a aVar2 = new k1.a();
        aVar2.setXfermode(new PorterDuffXfermode(mode3));
        this.f9455h = aVar2;
        this.f9456i = new RectF();
        this.f9457j = new RectF();
        this.f9458k = new RectF();
        this.f9459l = new RectF();
        this.f9460m = new RectF();
        this.f9461n = new Matrix();
        this.f9466v = new ArrayList();
        this.f9468x = true;
        this.A = 0.0f;
        this.f9462o = xVar;
        this.p = iVar;
        if (iVar.u == h.INVERT) {
            aVar.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            aVar.setXfermode(new PorterDuffXfermode(mode));
        }
        q1.d dVar = iVar.f9478i;
        dVar.getClass();
        q qVar = new q(dVar);
        this.f9467w = qVar;
        qVar.b(this);
        List list = iVar.f9477h;
        if (list != null && !list.isEmpty()) {
            qf.c cVar = new qf.c(list);
            this.q = cVar;
            Iterator it = ((ArrayList) cVar.f9047b).iterator();
            while (it.hasNext()) {
                ((m1.e) it.next()).a(this);
            }
            for (m1.e eVar : (ArrayList) this.q.f9048c) {
                f(eVar);
                eVar.a(this);
            }
        }
        i iVar2 = this.p;
        if (iVar2.f9487t.isEmpty()) {
            if (true != this.f9468x) {
                this.f9468x = true;
                this.f9462o.invalidateSelf();
                return;
            }
            return;
        }
        m1.i iVar3 = new m1.i(iVar2.f9487t);
        this.f9463r = iVar3;
        iVar3.f7575b = true;
        iVar3.a(new m1.a() { // from class: s1.a
            @Override // m1.a
            public final void a() {
                c cVar2 = this.f9447a;
                boolean z2 = cVar2.f9463r.l() == 1.0f;
                if (z2 != cVar2.f9468x) {
                    cVar2.f9468x = z2;
                    cVar2.f9462o.invalidateSelf();
                }
            }
        });
        boolean z2 = ((Float) this.f9463r.f()).floatValue() == 1.0f;
        if (z2 != this.f9468x) {
            this.f9468x = z2;
            this.f9462o.invalidateSelf();
        }
        f(this.f9463r);
    }

    @Override // m1.a
    public final void a() {
        this.f9462o.invalidateSelf();
    }

    @Override // l1.d
    public final void b(List list, List list2) {
    }

    @Override // p1.g
    public final void c(p1.f fVar, int i8, ArrayList arrayList, p1.f fVar2) {
        c cVar = this.f9464s;
        i iVar = this.p;
        if (cVar != null) {
            String str = cVar.p.f9474c;
            fVar2.getClass();
            p1.f fVar3 = new p1.f(fVar2);
            fVar3.f8638a.add(str);
            if (fVar.a(i8, this.f9464s.p.f9474c)) {
                c cVar2 = this.f9464s;
                p1.f fVar4 = new p1.f(fVar3);
                fVar4.f8639b = cVar2;
                arrayList.add(fVar4);
            }
            if (fVar.d(i8, iVar.f9474c)) {
                this.f9464s.o(fVar, fVar.b(i8, this.f9464s.p.f9474c) + i8, arrayList, fVar3);
            }
        }
        if (fVar.c(i8, iVar.f9474c)) {
            String str2 = iVar.f9474c;
            if (!"__container".equals(str2)) {
                fVar2.getClass();
                p1.f fVar5 = new p1.f(fVar2);
                fVar5.f8638a.add(str2);
                if (fVar.a(i8, str2)) {
                    p1.f fVar6 = new p1.f(fVar5);
                    fVar6.f8639b = this;
                    arrayList.add(fVar6);
                }
                fVar2 = fVar5;
            }
            if (fVar.d(i8, str2)) {
                o(fVar, fVar.b(i8, str2) + i8, arrayList, fVar2);
            }
        }
    }

    @Override // l1.f
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        this.f9456i.set(0.0f, 0.0f, 0.0f, 0.0f);
        h();
        Matrix matrix2 = this.f9461n;
        matrix2.set(matrix);
        if (z2) {
            List list = this.u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    matrix2.preConcat(((c) this.u.get(size)).f9467w.e());
                }
            } else {
                c cVar = this.f9465t;
                if (cVar != null) {
                    matrix2.preConcat(cVar.f9467w.e());
                }
            }
        }
        matrix2.preConcat(this.f9467w.e());
    }

    @Override // p1.g
    public void e(ColorFilter colorFilter, x1.c cVar) {
        this.f9467w.c(colorFilter, cVar);
    }

    public final void f(m1.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f9466v.add(eVar);
    }

    @Override // l1.f
    public final void g(Canvas canvas, Matrix matrix, int i8) {
        float f;
        int i9;
        k1.a aVar;
        int i10;
        int i11;
        Integer num;
        int i12 = 1;
        j1.a aVar2 = j1.d.f5945a;
        if (this.f9468x) {
            i iVar = this.p;
            if (iVar.f9488v) {
                return;
            }
            h();
            Matrix matrix2 = this.f9451b;
            matrix2.reset();
            matrix2.set(matrix);
            for (int size = this.u.size() - 1; size >= 0; size--) {
                matrix2.preConcat(((c) this.u.get(size)).f9467w.e());
            }
            j1.a aVar3 = j1.d.f5945a;
            q qVar = this.f9467w;
            m1.e eVar = qVar.f7620j;
            int iIntValue = (int) ((((i8 / 255.0f) * ((eVar == null || (num = (Integer) eVar.f()) == null) ? 100 : num.intValue())) / 100.0f) * 255.0f);
            boolean z2 = this.f9464s != null;
            r1.h hVar = iVar.f9491y;
            if (!z2 && !l() && hVar == r1.h.NORMAL) {
                matrix2.preConcat(qVar.e());
                i(canvas, matrix2, iIntValue);
                m();
                return;
            }
            RectF rectF = this.f9456i;
            d(rectF, matrix2, false);
            if (this.f9464s != null) {
                if (iVar.u != h.INVERT) {
                    RectF rectF2 = this.f9459l;
                    rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
                    this.f9464s.d(rectF2, matrix, true);
                    if (!rectF.intersect(rectF2)) {
                        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
                    }
                }
            }
            matrix2.preConcat(qVar.e());
            RectF rectF3 = this.f9458k;
            rectF3.set(0.0f, 0.0f, 0.0f, 0.0f);
            boolean zL = l();
            Path path = this.f9450a;
            qf.c cVar = this.q;
            if (!zL) {
                f = 0.0f;
                break;
            }
            int size2 = ((List) cVar.f9049d).size();
            int i13 = 0;
            while (true) {
                if (i13 < size2) {
                    r1.j jVar = (r1.j) ((List) cVar.f9049d).get(i13);
                    Path path2 = (Path) ((m1.e) ((ArrayList) cVar.f9047b).get(i13)).f();
                    if (path2 == null) {
                        i9 = i12;
                    } else {
                        path.set(path2);
                        path.transform(matrix2);
                        int i14 = b.f9449b[jVar.f9268a.ordinal()];
                        if (i14 != i12 && i14 != 2) {
                            if (i14 == 3 || i14 == 4) {
                                if (jVar.f9271d) {
                                }
                            }
                            RectF rectF4 = this.f9460m;
                            path.computeBounds(rectF4, false);
                            if (i13 == 0) {
                                rectF3.set(rectF4);
                                i9 = i12;
                            } else {
                                rectF3.set(Math.min(rectF3.left, rectF4.left), Math.min(rectF3.top, rectF4.top), Math.max(rectF3.right, rectF4.right), Math.max(rectF3.bottom, rectF4.bottom));
                                i9 = 1;
                            }
                        }
                    }
                    i13 += i9;
                    i12 = i9;
                    size2 = size2;
                } else if (!rectF.intersect(rectF3)) {
                    f = 0.0f;
                    rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
                    break;
                }
                f = 0.0f;
                break;
            }
            RectF rectF5 = this.f9457j;
            rectF5.set(f, f, canvas.getWidth(), canvas.getHeight());
            Matrix matrix3 = this.f9452c;
            canvas.getMatrix(matrix3);
            if (!matrix3.isIdentity()) {
                matrix3.invert(matrix3);
                matrix3.mapRect(rectF5);
            }
            if (!rectF.intersect(rectF5)) {
                rectF.set(f, f, f, f);
            }
            j1.a aVar4 = j1.d.f5945a;
            if (rectF.width() >= 1.0f && rectF.height() >= 1.0f) {
                k1.a aVar5 = this.f9453d;
                aVar5.setAlpha(255);
                PaintCompat.setBlendMode(aVar5, hVar.toNativeBlendMode());
                w1.g.e(canvas, rectF, aVar5);
                if (hVar != r1.h.MULTIPLY) {
                    i10 = 0;
                    canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f9455h);
                } else {
                    i10 = 0;
                    if (this.C == null) {
                        k1.a aVar6 = new k1.a();
                        this.C = aVar6;
                        aVar6.setColor(-1);
                    }
                    canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.C);
                }
                i(canvas, matrix2, iIntValue);
                if (l()) {
                    k1.a aVar7 = this.e;
                    canvas.saveLayer(rectF, aVar7);
                    int i15 = i10;
                    while (i15 < ((List) cVar.f9049d).size()) {
                        List list = (List) cVar.f9049d;
                        r1.j jVar2 = (r1.j) list.get(i15);
                        ArrayList arrayList = (ArrayList) cVar.f9047b;
                        m1.e eVar2 = (m1.e) arrayList.get(i15);
                        m1.e eVar3 = (m1.e) ((ArrayList) cVar.f9048c).get(i15);
                        qf.c cVar2 = cVar;
                        int i16 = b.f9449b[jVar2.f9268a.ordinal()];
                        if (i16 != 1) {
                            k1.a aVar8 = this.f;
                            boolean z3 = jVar2.f9271d;
                            if (i16 == 2) {
                                if (i15 == 0) {
                                    aVar5.setColor(ViewCompat.MEASURED_STATE_MASK);
                                    aVar5.setAlpha(255);
                                    canvas.drawRect(rectF, aVar5);
                                }
                                if (z3) {
                                    w1.g.e(canvas, rectF, aVar8);
                                    canvas.drawRect(rectF, aVar5);
                                    aVar8.setAlpha((int) (((Integer) eVar3.f()).intValue() * 2.55f));
                                    path.set((Path) eVar2.f());
                                    path.transform(matrix2);
                                    canvas.drawPath(path, aVar8);
                                    canvas.restore();
                                } else {
                                    path.set((Path) eVar2.f());
                                    path.transform(matrix2);
                                    canvas.drawPath(path, aVar8);
                                }
                                i11 = 1;
                                break;
                            }
                            if (i16 != 3) {
                                if (i16 == 4) {
                                    if (z3) {
                                        w1.g.e(canvas, rectF, aVar5);
                                        canvas.drawRect(rectF, aVar5);
                                        path.set((Path) eVar2.f());
                                        path.transform(matrix2);
                                        aVar5.setAlpha((int) (((Integer) eVar3.f()).intValue() * 2.55f));
                                        canvas.drawPath(path, aVar8);
                                        canvas.restore();
                                    } else {
                                        path.set((Path) eVar2.f());
                                        path.transform(matrix2);
                                        aVar5.setAlpha((int) (((Integer) eVar3.f()).intValue() * 2.55f));
                                        canvas.drawPath(path, aVar5);
                                    }
                                }
                            } else if (z3) {
                                w1.g.e(canvas, rectF, aVar7);
                                canvas.drawRect(rectF, aVar5);
                                aVar8.setAlpha((int) (((Integer) eVar3.f()).intValue() * 2.55f));
                                path.set((Path) eVar2.f());
                                path.transform(matrix2);
                                canvas.drawPath(path, aVar8);
                                canvas.restore();
                            } else {
                                w1.g.e(canvas, rectF, aVar7);
                                path.set((Path) eVar2.f());
                                path.transform(matrix2);
                                aVar5.setAlpha((int) (((Integer) eVar3.f()).intValue() * 2.55f));
                                canvas.drawPath(path, aVar5);
                                canvas.restore();
                            }
                            i11 = 1;
                        } else {
                            if (arrayList.isEmpty()) {
                                i11 = 1;
                                break;
                                break;
                            }
                            int i17 = i10;
                            while (true) {
                                if (i17 >= list.size()) {
                                    i11 = 1;
                                    aVar5.setAlpha(255);
                                    canvas.drawRect(rectF, aVar5);
                                    break;
                                } else {
                                    if (((r1.j) list.get(i17)).f9268a != r1.i.MASK_MODE_NONE) {
                                        i11 = 1;
                                        break;
                                        break;
                                    }
                                    i17++;
                                }
                            }
                        }
                        i15 += i11;
                        cVar = cVar2;
                    }
                    j1.a aVar9 = j1.d.f5945a;
                    canvas.restore();
                }
                if (this.f9464s != null) {
                    canvas.saveLayer(rectF, this.f9454g);
                    canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f9455h);
                    this.f9464s.g(canvas, matrix, iIntValue);
                    canvas.restore();
                }
                canvas.restore();
            }
            if (this.f9469y && (aVar = this.f9470z) != null) {
                aVar.setStyle(Paint.Style.STROKE);
                this.f9470z.setColor(-251901);
                this.f9470z.setStrokeWidth(4.0f);
                canvas.drawRect(rectF, this.f9470z);
                this.f9470z.setStyle(Paint.Style.FILL);
                this.f9470z.setColor(1357638635);
                canvas.drawRect(rectF, this.f9470z);
            }
            m();
        }
    }

    public final void h() {
        if (this.u != null) {
            return;
        }
        if (this.f9465t == null) {
            this.u = Collections.emptyList();
            return;
        }
        this.u = new ArrayList();
        for (c cVar = this.f9465t; cVar != null; cVar = cVar.f9465t) {
            this.u.add(cVar);
        }
    }

    public abstract void i(Canvas canvas, Matrix matrix, int i8);

    public o5.c j() {
        return this.p.f9489w;
    }

    public r5 k() {
        return this.p.f9490x;
    }

    public final boolean l() {
        qf.c cVar = this.q;
        return (cVar == null || ((ArrayList) cVar.f9047b).isEmpty()) ? false : true;
    }

    public final void m() {
        f0 f0Var = this.f9462o.f6011a.f5964a;
        String str = this.p.f9474c;
        if (f0Var.f5956a) {
            HashMap map = f0Var.f5958c;
            w1.e eVar = (w1.e) map.get(str);
            if (eVar == null) {
                eVar = new w1.e();
                map.put(str, eVar);
            }
            int i8 = eVar.f10645a + 1;
            eVar.f10645a = i8;
            if (i8 == Integer.MAX_VALUE) {
                eVar.f10645a = i8 / 2;
            }
            if (str.equals("__container")) {
                Iterator<E> it = f0Var.f5957b.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    throw new ClassCastException();
                }
            }
        }
    }

    public final void n(m1.e eVar) {
        this.f9466v.remove(eVar);
    }

    public void o(p1.f fVar, int i8, ArrayList arrayList, p1.f fVar2) {
    }

    public void p(boolean z2) {
        if (z2 && this.f9470z == null) {
            this.f9470z = new k1.a();
        }
        this.f9469y = z2;
    }

    public void q(float f) {
        j1.a aVar = j1.d.f5945a;
        q qVar = this.f9467w;
        m1.e eVar = qVar.f7620j;
        if (eVar != null) {
            eVar.j(f);
        }
        m1.e eVar2 = qVar.f7623m;
        if (eVar2 != null) {
            eVar2.j(f);
        }
        m1.e eVar3 = qVar.f7624n;
        if (eVar3 != null) {
            eVar3.j(f);
        }
        m1.e eVar4 = qVar.f;
        if (eVar4 != null) {
            eVar4.j(f);
        }
        m1.e eVar5 = qVar.f7617g;
        if (eVar5 != null) {
            eVar5.j(f);
        }
        m1.e eVar6 = qVar.f7618h;
        if (eVar6 != null) {
            eVar6.j(f);
        }
        m1.e eVar7 = qVar.f7619i;
        if (eVar7 != null) {
            eVar7.j(f);
        }
        m1.i iVar = qVar.f7621k;
        if (iVar != null) {
            iVar.j(f);
        }
        m1.i iVar2 = qVar.f7622l;
        if (iVar2 != null) {
            iVar2.j(f);
        }
        qf.c cVar = this.q;
        int i8 = 0;
        if (cVar != null) {
            int i9 = 0;
            while (true) {
                ArrayList arrayList = (ArrayList) cVar.f9047b;
                if (i9 >= arrayList.size()) {
                    break;
                }
                ((m1.e) arrayList.get(i9)).j(f);
                i9++;
            }
            j1.a aVar2 = j1.d.f5945a;
        }
        m1.i iVar3 = this.f9463r;
        if (iVar3 != null) {
            iVar3.j(f);
        }
        c cVar2 = this.f9464s;
        if (cVar2 != null) {
            cVar2.q(f);
        }
        while (true) {
            ArrayList arrayList2 = this.f9466v;
            if (i8 >= arrayList2.size()) {
                j1.a aVar3 = j1.d.f5945a;
                return;
            } else {
                ((m1.e) arrayList2.get(i8)).j(f);
                i8++;
            }
        }
    }
}
