package l1;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import j1.b0;
import j1.x;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class i implements f, m1.a, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s1.c f7125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LongSparseArray f7126d = new LongSparseArray();
    public final LongSparseArray e = new LongSparseArray();
    public final Path f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k1.a f7127g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f7128h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f7129i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final r1.f f7130j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final m1.j f7131k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final m1.f f7132l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final m1.j f7133m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final m1.j f7134n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public m1.r f7135o;
    public m1.r p;
    public final x q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f7136r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public m1.e f7137s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f7138t;
    public final m1.h u;

    public i(x xVar, j1.j jVar, s1.c cVar, r1.d dVar) {
        Path path = new Path();
        this.f = path;
        this.f7127g = new k1.a(1, 0);
        this.f7128h = new RectF();
        this.f7129i = new ArrayList();
        this.f7138t = 0.0f;
        this.f7125c = cVar;
        this.f7123a = dVar.f9254g;
        this.f7124b = dVar.f9255h;
        this.q = xVar;
        this.f7130j = dVar.f9250a;
        path.setFillType(dVar.f9251b);
        this.f7136r = (int) (jVar.b() / 32.0f);
        m1.e eVarG = dVar.f9252c.g();
        this.f7131k = (m1.j) eVarG;
        eVarG.a(this);
        cVar.f(eVarG);
        m1.e eVarG2 = dVar.f9253d.g();
        this.f7132l = (m1.f) eVarG2;
        eVarG2.a(this);
        cVar.f(eVarG2);
        m1.e eVarG3 = dVar.e.g();
        this.f7133m = (m1.j) eVarG3;
        eVarG3.a(this);
        cVar.f(eVarG3);
        m1.e eVarG4 = dVar.f.g();
        this.f7134n = (m1.j) eVarG4;
        eVarG4.a(this);
        cVar.f(eVarG4);
        if (cVar.j() != null) {
            m1.i iVarG = ((q1.b) cVar.j().f8405a).g();
            this.f7137s = iVarG;
            iVarG.a(this);
            cVar.f(this.f7137s);
        }
        if (cVar.k() != null) {
            this.u = new m1.h(this, cVar, cVar.k());
        }
    }

    @Override // m1.a
    public final void a() {
        this.q.invalidateSelf();
    }

    @Override // l1.d
    public final void b(List list, List list2) {
        for (int i8 = 0; i8 < list2.size(); i8++) {
            d dVar = (d) list2.get(i8);
            if (dVar instanceof o) {
                this.f7129i.add((o) dVar);
            }
        }
    }

    @Override // p1.g
    public final void c(p1.f fVar, int i8, ArrayList arrayList, p1.f fVar2) {
        w1.f.f(fVar, i8, arrayList, fVar2, this);
    }

    @Override // l1.f
    public final void d(RectF rectF, Matrix matrix, boolean z2) {
        Path path = this.f;
        path.reset();
        int i8 = 0;
        while (true) {
            ArrayList arrayList = this.f7129i;
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p1.g
    public final void e(ColorFilter colorFilter, x1.c cVar) {
        PointF pointF = b0.f5922a;
        if (colorFilter == 4) {
            this.f7132l.k(cVar);
            return;
        }
        ColorFilter colorFilter2 = b0.F;
        s1.c cVar2 = this.f7125c;
        if (colorFilter == colorFilter2) {
            m1.r rVar = this.f7135o;
            if (rVar != null) {
                cVar2.n(rVar);
            }
            m1.r rVar2 = new m1.r(cVar, null);
            this.f7135o = rVar2;
            rVar2.a(this);
            cVar2.f(this.f7135o);
            return;
        }
        if (colorFilter == b0.G) {
            m1.r rVar3 = this.p;
            if (rVar3 != null) {
                cVar2.n(rVar3);
            }
            this.f7126d.clear();
            this.e.clear();
            m1.r rVar4 = new m1.r(cVar, null);
            this.p = rVar4;
            rVar4.a(this);
            cVar2.f(this.p);
            return;
        }
        if (colorFilter == b0.e) {
            m1.e eVar = this.f7137s;
            if (eVar != null) {
                eVar.k(cVar);
                return;
            }
            m1.r rVar5 = new m1.r(cVar, null);
            this.f7137s = rVar5;
            rVar5.a(this);
            cVar2.f(this.f7137s);
            return;
        }
        m1.h hVar = this.u;
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

    public final int[] f(int[] iArr) {
        m1.r rVar = this.p;
        if (rVar != null) {
            Integer[] numArr = (Integer[]) rVar.f();
            int i8 = 0;
            if (iArr.length == numArr.length) {
                while (i8 < iArr.length) {
                    iArr[i8] = numArr[i8].intValue();
                    i8++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i8 < numArr.length) {
                    iArr[i8] = numArr[i8].intValue();
                    i8++;
                }
            }
        }
        return iArr;
    }

    @Override // l1.f
    public final void g(Canvas canvas, Matrix matrix, int i8) {
        Shader linearGradient;
        if (this.f7124b) {
            return;
        }
        j1.a aVar = j1.d.f5945a;
        Path path = this.f;
        path.reset();
        int i9 = 0;
        while (true) {
            ArrayList arrayList = this.f7129i;
            if (i9 >= arrayList.size()) {
                break;
            }
            path.addPath(((o) arrayList.get(i9)).getPath(), matrix);
            i9++;
        }
        path.computeBounds(this.f7128h, false);
        r1.f fVar = r1.f.LINEAR;
        r1.f fVar2 = this.f7130j;
        m1.j jVar = this.f7131k;
        m1.j jVar2 = this.f7134n;
        m1.j jVar3 = this.f7133m;
        if (fVar2 == fVar) {
            long jH = h();
            LongSparseArray longSparseArray = this.f7126d;
            linearGradient = (LinearGradient) longSparseArray.get(jH);
            if (linearGradient == null) {
                PointF pointF = (PointF) jVar3.f();
                PointF pointF2 = (PointF) jVar2.f();
                r1.c cVar = (r1.c) jVar.f();
                linearGradient = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, f(cVar.f9249b), cVar.f9248a, Shader.TileMode.CLAMP);
                longSparseArray.put(jH, linearGradient);
            }
        } else {
            long jH2 = h();
            LongSparseArray longSparseArray2 = this.e;
            linearGradient = (RadialGradient) longSparseArray2.get(jH2);
            if (linearGradient == null) {
                PointF pointF3 = (PointF) jVar3.f();
                PointF pointF4 = (PointF) jVar2.f();
                r1.c cVar2 = (r1.c) jVar.f();
                int[] iArrF = f(cVar2.f9249b);
                float f = pointF3.x;
                float f4 = pointF3.y;
                float fHypot = (float) Math.hypot(pointF4.x - f, pointF4.y - f4);
                if (fHypot <= 0.0f) {
                    fHypot = 0.001f;
                }
                RadialGradient radialGradient = new RadialGradient(f, f4, fHypot, iArrF, cVar2.f9248a, Shader.TileMode.CLAMP);
                longSparseArray2.put(jH2, radialGradient);
                linearGradient = radialGradient;
            }
        }
        linearGradient.setLocalMatrix(matrix);
        k1.a aVar2 = this.f7127g;
        aVar2.setShader(linearGradient);
        m1.r rVar = this.f7135o;
        if (rVar != null) {
            aVar2.setColorFilter((ColorFilter) rVar.f());
        }
        m1.e eVar = this.f7137s;
        if (eVar != null) {
            float fFloatValue = ((Float) eVar.f()).floatValue();
            if (fFloatValue == 0.0f) {
                aVar2.setMaskFilter(null);
            } else if (fFloatValue != this.f7138t) {
                aVar2.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.f7138t = fFloatValue;
        }
        float f10 = i8 / 255.0f;
        int iIntValue = (int) (((((Integer) this.f7132l.f()).intValue() * f10) / 100.0f) * 255.0f);
        PointF pointF5 = w1.f.f10646a;
        aVar2.setAlpha(Math.max(0, Math.min(255, iIntValue)));
        m1.h hVar = this.u;
        if (hVar != null) {
            g3.h hVar2 = w1.g.f10647a;
            hVar.b(aVar2, matrix, (int) (((f10 * iIntValue) / 255.0f) * 255.0f));
        }
        canvas.drawPath(path, aVar2);
        j1.a aVar3 = j1.d.f5945a;
    }

    @Override // l1.d
    public final String getName() {
        return this.f7123a;
    }

    public final int h() {
        float f = this.f7133m.f7577d;
        float f4 = this.f7136r;
        int iRound = Math.round(f * f4);
        int iRound2 = Math.round(this.f7134n.f7577d * f4);
        int iRound3 = Math.round(this.f7131k.f7577d * f4);
        int i8 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i8 = i8 * 31 * iRound2;
        }
        return iRound3 != 0 ? i8 * 31 * iRound3 : i8;
    }
}
