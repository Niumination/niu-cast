package l1;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
import j1.b0;
import j1.x;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h implements f, m1.a, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f7112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k1.a f7113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s1.c f7114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f7115d;
    public final boolean e;
    public final ArrayList f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m1.f f7116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m1.f f7117h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public m1.r f7118i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final x f7119j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public m1.e f7120k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f7121l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final m1.h f7122m;

    public h(x xVar, s1.c cVar, r1.r rVar) {
        Path path = new Path();
        this.f7112a = path;
        this.f7113b = new k1.a(1, 0);
        this.f = new ArrayList();
        this.f7114c = cVar;
        this.f7115d = rVar.f9293c;
        this.e = rVar.f;
        this.f7119j = xVar;
        if (cVar.j() != null) {
            m1.i iVarG = ((q1.b) cVar.j().f8405a).g();
            this.f7120k = iVarG;
            iVarG.a(this);
            cVar.f(this.f7120k);
        }
        if (cVar.k() != null) {
            this.f7122m = new m1.h(this, cVar, cVar.k());
        }
        q1.a aVar = rVar.f9294d;
        if (aVar == null) {
            this.f7116g = null;
            this.f7117h = null;
            return;
        }
        q1.a aVar2 = rVar.e;
        path.setFillType(rVar.f9292b);
        m1.e eVarG = aVar.g();
        this.f7116g = (m1.f) eVarG;
        eVarG.a(this);
        cVar.f(eVarG);
        m1.e eVarG2 = aVar2.g();
        this.f7117h = (m1.f) eVarG2;
        eVarG2.a(this);
        cVar.f(eVarG2);
    }

    @Override // m1.a
    public final void a() {
        this.f7119j.invalidateSelf();
    }

    @Override // l1.d
    public final void b(List list, List list2) {
        for (int i8 = 0; i8 < list2.size(); i8++) {
            d dVar = (d) list2.get(i8);
            if (dVar instanceof o) {
                this.f.add((o) dVar);
            }
        }
    }

    @Override // p1.g
    public final void c(p1.f fVar, int i8, ArrayList arrayList, p1.f fVar2) {
        w1.f.f(fVar, i8, arrayList, fVar2, this);
    }

    @Override // l1.f
    public final void d(RectF rectF, Matrix matrix, boolean z2) {
        Path path = this.f7112a;
        path.reset();
        int i8 = 0;
        while (true) {
            ArrayList arrayList = this.f;
            if (i8 >= arrayList.size()) {
                path.computeBounds(rectF, false);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                return;
            } else {
                path.addPath(((o) arrayList.get(i8)).getPath(), matrix);
                i8++;
            }
        }
    }

    @Override // p1.g
    public final void e(ColorFilter colorFilter, x1.c cVar) {
        PointF pointF = b0.f5922a;
        if (colorFilter == 1) {
            this.f7116g.k(cVar);
            return;
        }
        if (colorFilter == 4) {
            this.f7117h.k(cVar);
            return;
        }
        ColorFilter colorFilter2 = b0.F;
        s1.c cVar2 = this.f7114c;
        if (colorFilter == colorFilter2) {
            m1.r rVar = this.f7118i;
            if (rVar != null) {
                cVar2.n(rVar);
            }
            m1.r rVar2 = new m1.r(cVar, null);
            this.f7118i = rVar2;
            rVar2.a(this);
            cVar2.f(this.f7118i);
            return;
        }
        if (colorFilter == b0.e) {
            m1.e eVar = this.f7120k;
            if (eVar != null) {
                eVar.k(cVar);
                return;
            }
            m1.r rVar3 = new m1.r(cVar, null);
            this.f7120k = rVar3;
            rVar3.a(this);
            cVar2.f(this.f7120k);
            return;
        }
        m1.h hVar = this.f7122m;
        if (colorFilter == 5 && hVar != null) {
            hVar.f7584c.k(cVar);
            return;
        }
        if (colorFilter == b0.B && hVar != null) {
            hVar.c(cVar);
            return;
        }
        if (colorFilter == b0.C && hVar != null) {
            hVar.e.k(cVar);
            return;
        }
        if (colorFilter == b0.D && hVar != null) {
            hVar.f.k(cVar);
        } else {
            if (colorFilter != b0.E || hVar == null) {
                return;
            }
            hVar.f7586g.k(cVar);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // l1.f
    public final void g(Canvas canvas, Matrix matrix, int i8) {
        BlurMaskFilter blurMaskFilter;
        if (this.e) {
            return;
        }
        j1.a aVar = j1.d.f5945a;
        m1.f fVar = this.f7116g;
        int iL = fVar.l(fVar.b(), fVar.d());
        float f = i8 / 255.0f;
        int iIntValue = (int) (((((Integer) this.f7117h.f()).intValue() * f) / 100.0f) * 255.0f);
        PointF pointF = w1.f.f10646a;
        int i9 = 0;
        int iMax = (iL & ViewCompat.MEASURED_SIZE_MASK) | (Math.max(0, Math.min(255, iIntValue)) << 24);
        k1.a aVar2 = this.f7113b;
        aVar2.setColor(iMax);
        m1.r rVar = this.f7118i;
        if (rVar != null) {
            aVar2.setColorFilter((ColorFilter) rVar.f());
        }
        m1.e eVar = this.f7120k;
        if (eVar != null) {
            float fFloatValue = ((Float) eVar.f()).floatValue();
            if (fFloatValue == 0.0f) {
                aVar2.setMaskFilter(null);
            } else if (fFloatValue != this.f7121l) {
                s1.c cVar = this.f7114c;
                if (cVar.A == fFloatValue) {
                    blurMaskFilter = cVar.B;
                } else {
                    BlurMaskFilter blurMaskFilter2 = new BlurMaskFilter(fFloatValue / 2.0f, BlurMaskFilter.Blur.NORMAL);
                    cVar.B = blurMaskFilter2;
                    cVar.A = fFloatValue;
                    blurMaskFilter = blurMaskFilter2;
                }
                aVar2.setMaskFilter(blurMaskFilter);
            }
            this.f7121l = fFloatValue;
        }
        m1.h hVar = this.f7122m;
        if (hVar != null) {
            g3.h hVar2 = w1.g.f10647a;
            hVar.b(aVar2, matrix, (int) (((f * iIntValue) / 255.0f) * 255.0f));
        }
        Path path = this.f7112a;
        path.reset();
        while (true) {
            ArrayList arrayList = this.f;
            if (i9 >= arrayList.size()) {
                canvas.drawPath(path, aVar2);
                j1.a aVar3 = j1.d.f5945a;
                return;
            } else {
                path.addPath(((o) arrayList.get(i9)).getPath(), matrix);
                i9++;
            }
        }
    }

    @Override // l1.d
    public final String getName() {
        return this.f7115d;
    }
}
