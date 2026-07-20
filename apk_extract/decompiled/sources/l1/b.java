package l1;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import j1.b0;
import j1.x;
import java.util.ArrayList;
import java.util.List;
import r1.y;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements m1.a, l, f {
    public final x e;
    public final s1.c f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f7088h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k1.a f7089i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final m1.i f7090j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final m1.f f7091k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f7092l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final m1.i f7093m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public m1.r f7094n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public m1.e f7095o;
    public float p;
    public final m1.h q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PathMeasure f7083a = new PathMeasure();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f7084b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f7085c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f7086d = new RectF();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f7087g = new ArrayList();

    public b(x xVar, s1.c cVar, Paint.Cap cap, Paint.Join join, float f, q1.a aVar, q1.b bVar, ArrayList arrayList, q1.b bVar2) {
        k1.a aVar2 = new k1.a(1, 0);
        this.f7089i = aVar2;
        this.p = 0.0f;
        this.e = xVar;
        this.f = cVar;
        aVar2.setStyle(Paint.Style.STROKE);
        aVar2.setStrokeCap(cap);
        aVar2.setStrokeJoin(join);
        aVar2.setStrokeMiter(f);
        this.f7091k = (m1.f) aVar.g();
        this.f7090j = bVar.g();
        if (bVar2 == null) {
            this.f7093m = null;
        } else {
            this.f7093m = bVar2.g();
        }
        this.f7092l = new ArrayList(arrayList.size());
        this.f7088h = new float[arrayList.size()];
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            this.f7092l.add(((q1.b) arrayList.get(i8)).g());
        }
        cVar.f(this.f7091k);
        cVar.f(this.f7090j);
        for (int i9 = 0; i9 < this.f7092l.size(); i9++) {
            cVar.f((m1.e) this.f7092l.get(i9));
        }
        m1.i iVar = this.f7093m;
        if (iVar != null) {
            cVar.f(iVar);
        }
        this.f7091k.a(this);
        this.f7090j.a(this);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            ((m1.e) this.f7092l.get(i10)).a(this);
        }
        m1.i iVar2 = this.f7093m;
        if (iVar2 != null) {
            iVar2.a(this);
        }
        if (cVar.j() != null) {
            m1.i iVarG = ((q1.b) cVar.j().f8405a).g();
            this.f7095o = iVarG;
            iVarG.a(this);
            cVar.f(this.f7095o);
        }
        if (cVar.k() != null) {
            this.q = new m1.h(this, cVar, cVar.k());
        }
    }

    @Override // m1.a
    public final void a() {
        this.e.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0053  */
    /* JADX WARN: Code duplicated, block: B:24:0x0057 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0059  */
    /* JADX WARN: Code duplicated, block: B:38:0x0065 A[SYNTHETIC] */
    @Override // l1.d
    public final void b(List list, List list2) {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) list;
        a aVar = null;
        w wVar = null;
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            d dVar = (d) arrayList2.get(size);
            if (dVar instanceof w) {
                w wVar2 = (w) dVar;
                if (wVar2.f7198c == y.INDIVIDUALLY) {
                    wVar = wVar2;
                }
            }
        }
        if (wVar != null) {
            wVar.c(this);
        }
        int size2 = list2.size();
        while (true) {
            size2--;
            arrayList = this.f7087g;
            if (size2 < 0) {
                break;
            }
            d dVar2 = (d) list2.get(size2);
            if (dVar2 instanceof w) {
                w wVar3 = (w) dVar2;
                if (wVar3.f7198c == y.INDIVIDUALLY) {
                    if (aVar != null) {
                        arrayList.add(aVar);
                    }
                    a aVar2 = new a(wVar3);
                    wVar3.c(this);
                    aVar = aVar2;
                } else if (!(dVar2 instanceof o)) {
                    if (aVar == null) {
                        aVar = new a(wVar);
                    }
                    aVar.f7081a.add((o) dVar2);
                }
            } else if (!(dVar2 instanceof o)) {
                if (aVar == null) {
                    aVar = new a(wVar);
                }
                aVar.f7081a.add((o) dVar2);
            }
        }
        if (aVar != null) {
            arrayList.add(aVar);
        }
    }

    @Override // p1.g
    public final void c(p1.f fVar, int i8, ArrayList arrayList, p1.f fVar2) {
        w1.f.f(fVar, i8, arrayList, fVar2, this);
    }

    @Override // l1.f
    public final void d(RectF rectF, Matrix matrix, boolean z2) {
        j1.a aVar = j1.d.f5945a;
        Path path = this.f7084b;
        path.reset();
        int i8 = 0;
        while (true) {
            ArrayList arrayList = this.f7087g;
            if (i8 >= arrayList.size()) {
                RectF rectF2 = this.f7086d;
                path.computeBounds(rectF2, false);
                float fL = this.f7090j.l() / 2.0f;
                rectF2.set(rectF2.left - fL, rectF2.top - fL, rectF2.right + fL, rectF2.bottom + fL);
                rectF.set(rectF2);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                j1.a aVar2 = j1.d.f5945a;
                return;
            }
            a aVar3 = (a) arrayList.get(i8);
            for (int i9 = 0; i9 < aVar3.f7081a.size(); i9++) {
                path.addPath(((o) aVar3.f7081a.get(i9)).getPath(), matrix);
            }
            i8++;
        }
    }

    @Override // p1.g
    public void e(ColorFilter colorFilter, x1.c cVar) {
        PointF pointF = b0.f5922a;
        if (colorFilter == 4) {
            this.f7091k.k(cVar);
            return;
        }
        if (colorFilter == b0.f5933n) {
            this.f7090j.k(cVar);
            return;
        }
        ColorFilter colorFilter2 = b0.F;
        s1.c cVar2 = this.f;
        if (colorFilter == colorFilter2) {
            m1.r rVar = this.f7094n;
            if (rVar != null) {
                cVar2.n(rVar);
            }
            m1.r rVar2 = new m1.r(cVar, null);
            this.f7094n = rVar2;
            rVar2.a(this);
            cVar2.f(this.f7094n);
            return;
        }
        if (colorFilter == b0.e) {
            m1.e eVar = this.f7095o;
            if (eVar != null) {
                eVar.k(cVar);
                return;
            }
            m1.r rVar3 = new m1.r(cVar, null);
            this.f7095o = rVar3;
            rVar3.a(this);
            cVar2.f(this.f7095o);
            return;
        }
        m1.h hVar = this.q;
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

    /* JADX WARN: Code duplicated, block: B:79:0x0206  */
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
    public void g(Canvas canvas, Matrix matrix, int i8) {
        float f;
        BlurMaskFilter blurMaskFilter;
        float[] fArr;
        int i9 = 1;
        j1.a aVar = j1.d.f5945a;
        float[] fArr2 = (float[]) w1.g.f10650d.get();
        fArr2[0] = 0.0f;
        fArr2[1] = 0.0f;
        fArr2[2] = 37394.73f;
        fArr2[3] = 39575.234f;
        matrix.mapPoints(fArr2);
        if (fArr2[0] == fArr2[2] || fArr2[1] == fArr2[3]) {
            return;
        }
        float f4 = i8 / 255.0f;
        m1.f fVar = this.f7091k;
        float f10 = 100.0f;
        int iL = (int) (((fVar.l(fVar.b(), fVar.d()) * f4) / 100.0f) * 255.0f);
        PointF pointF = w1.f.f10646a;
        int iMax = Math.max(0, Math.min(255, iL));
        k1.a aVar2 = this.f7089i;
        aVar2.setAlpha(iMax);
        aVar2.setStrokeWidth(this.f7090j.l());
        if (aVar2.getStrokeWidth() <= 0.0f) {
            return;
        }
        ArrayList arrayList = this.f7092l;
        if (!arrayList.isEmpty()) {
            int i10 = 0;
            while (true) {
                int size = arrayList.size();
                fArr = this.f7088h;
                if (i10 >= size) {
                    break;
                }
                float fFloatValue = ((Float) ((m1.e) arrayList.get(i10)).f()).floatValue();
                fArr[i10] = fFloatValue;
                if (i10 % 2 == 0) {
                    if (fFloatValue < 1.0f) {
                        fArr[i10] = 1.0f;
                    }
                } else if (fFloatValue < 0.1f) {
                    fArr[i10] = 0.1f;
                }
                i10++;
            }
            m1.i iVar = this.f7093m;
            aVar2.setPathEffect(new DashPathEffect(fArr, iVar == null ? 0.0f : ((Float) iVar.f()).floatValue()));
            j1.a aVar3 = j1.d.f5945a;
        }
        m1.r rVar = this.f7094n;
        if (rVar != null) {
            aVar2.setColorFilter((ColorFilter) rVar.f());
        }
        m1.e eVar = this.f7095o;
        if (eVar != null) {
            float fFloatValue2 = ((Float) eVar.f()).floatValue();
            if (fFloatValue2 == 0.0f) {
                aVar2.setMaskFilter(null);
            } else if (fFloatValue2 != this.p) {
                s1.c cVar = this.f;
                if (cVar.A == fFloatValue2) {
                    blurMaskFilter = cVar.B;
                } else {
                    BlurMaskFilter blurMaskFilter2 = new BlurMaskFilter(fFloatValue2 / 2.0f, BlurMaskFilter.Blur.NORMAL);
                    cVar.B = blurMaskFilter2;
                    cVar.A = fFloatValue2;
                    blurMaskFilter = blurMaskFilter2;
                }
                aVar2.setMaskFilter(blurMaskFilter);
            }
            this.p = fFloatValue2;
        }
        m1.h hVar = this.q;
        if (hVar != null) {
            hVar.b(aVar2, matrix, (int) (((f4 * iL) / 255.0f) * 255.0f));
        }
        canvas.save();
        canvas.concat(matrix);
        int i11 = 0;
        while (true) {
            ArrayList arrayList2 = this.f7087g;
            if (i11 >= arrayList2.size()) {
                canvas.restore();
                j1.a aVar4 = j1.d.f5945a;
                return;
            }
            a aVar5 = (a) arrayList2.get(i11);
            w wVar = aVar5.f7082b;
            Path path = this.f7084b;
            ArrayList arrayList3 = aVar5.f7081a;
            if (wVar != null) {
                j1.a aVar6 = j1.d.f5945a;
                path.reset();
                for (int size2 = arrayList3.size() - i9; size2 >= 0; size2--) {
                    path.addPath(((o) arrayList3.get(size2)).getPath());
                }
                w wVar2 = aVar5.f7082b;
                float fFloatValue3 = ((Float) wVar2.f7199d.f()).floatValue() / f10;
                float fFloatValue4 = ((Float) wVar2.e.f()).floatValue() / f10;
                float fFloatValue5 = ((Float) wVar2.f.f()).floatValue() / 360.0f;
                if (fFloatValue3 >= 0.01f || fFloatValue4 <= 0.99f) {
                    PathMeasure pathMeasure = this.f7083a;
                    pathMeasure.setPath(path, false);
                    float length = pathMeasure.getLength();
                    while (pathMeasure.nextContour()) {
                        length += pathMeasure.getLength();
                    }
                    float f11 = fFloatValue5 * length;
                    float f12 = (fFloatValue3 * length) + f11;
                    float fMin = Math.min((fFloatValue4 * length) + f11, (f12 + length) - 1.0f);
                    float f13 = 0.0f;
                    for (int size3 = arrayList3.size() - i9; size3 >= 0; size3--) {
                        Path path2 = this.f7085c;
                        path2.set(((o) arrayList3.get(size3)).getPath());
                        pathMeasure.setPath(path2, false);
                        float length2 = pathMeasure.getLength();
                        if (fMin > length) {
                            float f14 = fMin - length;
                            if (f14 >= f13 + length2 || f13 >= f14) {
                                f = f13 + length2;
                                if (f < f12 && f13 <= fMin) {
                                    if (f > fMin || f12 >= f13) {
                                        w1.g.a(path2, f12 < f13 ? 0.0f : (f12 - f13) / length2, fMin > f ? 1.0f : (fMin - f13) / length2, 0.0f);
                                        canvas.drawPath(path2, aVar2);
                                    } else {
                                        canvas.drawPath(path2, aVar2);
                                    }
                                }
                            } else {
                                w1.g.a(path2, f12 > length ? (f12 - length) / length2 : 0.0f, Math.min(f14 / length2, 1.0f), 0.0f);
                                canvas.drawPath(path2, aVar2);
                            }
                        } else {
                            f = f13 + length2;
                            if (f < f12) {
                            }
                        }
                        f13 += length2;
                    }
                    j1.a aVar7 = j1.d.f5945a;
                } else {
                    canvas.drawPath(path, aVar2);
                    j1.a aVar8 = j1.d.f5945a;
                }
            } else {
                j1.a aVar9 = j1.d.f5945a;
                path.reset();
                for (int size4 = arrayList3.size() - 1; size4 >= 0; size4--) {
                    path.addPath(((o) arrayList3.get(size4)).getPath());
                }
                j1.a aVar10 = j1.d.f5945a;
                canvas.drawPath(path, aVar2);
            }
            i11++;
            i9 = 1;
            f10 = 100.0f;
        }
    }
}
