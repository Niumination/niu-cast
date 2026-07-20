package p0;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements q0.a.b, k, e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n0.j f12556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final v0.a f12557f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f12559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f12560i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final q0.a<?, Float> f12561j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final q0.a<?, Integer> f12562k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<q0.a<?, Float>> f12563l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public final q0.a<?, Float> f12564m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public q0.a<ColorFilter, ColorFilter> f12565n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PathMeasure f12552a = new PathMeasure();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f12553b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f12554c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f12555d = new RectF();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<b> f12558g = new ArrayList();

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<n> f12566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final t f12567b;

        public b(@Nullable t tVar) {
            this.f12566a = new ArrayList();
            this.f12567b = tVar;
        }
    }

    public a(n0.j jVar, v0.a aVar, Paint.Cap cap, Paint.Join join, float f10, t0.d dVar, t0.b bVar, List<t0.b> list, t0.b bVar2) {
        o0.a aVar2 = new o0.a(1);
        this.f12560i = aVar2;
        this.f12556e = jVar;
        this.f12557f = aVar;
        aVar2.setStyle(Paint.Style.STROKE);
        aVar2.setStrokeCap(cap);
        aVar2.setStrokeJoin(join);
        aVar2.setStrokeMiter(f10);
        this.f12562k = dVar.l();
        this.f12561j = bVar.l();
        if (bVar2 == null) {
            this.f12564m = null;
        } else {
            this.f12564m = bVar2.l();
        }
        this.f12563l = new ArrayList(list.size());
        this.f12559h = new float[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            this.f12563l.add(list.get(i10).l());
        }
        aVar.i(this.f12562k);
        aVar.i(this.f12561j);
        for (int i11 = 0; i11 < this.f12563l.size(); i11++) {
            aVar.i(this.f12563l.get(i11));
        }
        q0.a<?, Float> aVar3 = this.f12564m;
        if (aVar3 != null) {
            aVar.i(aVar3);
        }
        this.f12562k.a(this);
        this.f12561j.a(this);
        for (int i12 = 0; i12 < list.size(); i12++) {
            this.f12563l.get(i12).a(this);
        }
        q0.a<?, Float> aVar4 = this.f12564m;
        if (aVar4 != null) {
            aVar4.a(this);
        }
    }

    @Override // q0.a.b
    public void a() {
        this.f12556e.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0055  */
    /* JADX WARN: Code duplicated, block: B:23:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067 A[SYNTHETIC] */
    @Override // p0.c
    public void b(List<c> list, List<c> list2) {
        b bVar = null;
        t tVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof t) {
                t tVar2 = (t) cVar;
                if (tVar2.i() == u0.q.a.INDIVIDUALLY) {
                    tVar = tVar2;
                }
            }
        }
        if (tVar != null) {
            tVar.d(this);
        }
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = list2.get(size2);
            if (cVar2 instanceof t) {
                t tVar3 = (t) cVar2;
                if (tVar3.i() == u0.q.a.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.f12558g.add(bVar);
                    }
                    b bVar2 = new b(tVar3);
                    tVar3.d(this);
                    bVar = bVar2;
                } else if (!(cVar2 instanceof n)) {
                    if (bVar == null) {
                        bVar = new b(tVar);
                    }
                    bVar.f12566a.add((n) cVar2);
                }
            } else if (!(cVar2 instanceof n)) {
                if (bVar == null) {
                    bVar = new b(tVar);
                }
                bVar.f12566a.add((n) cVar2);
            }
        }
        if (bVar != null) {
            this.f12558g.add(bVar);
        }
    }

    @Override // p0.e
    public void c(RectF rectF, Matrix matrix, boolean z10) {
        n0.e.a("StrokeContent#getBounds");
        this.f12553b.reset();
        for (int i10 = 0; i10 < this.f12558g.size(); i10++) {
            b bVar = this.f12558g.get(i10);
            for (int i11 = 0; i11 < bVar.f12566a.size(); i11++) {
                this.f12553b.addPath(bVar.f12566a.get(i11).getPath(), matrix);
            }
        }
        this.f12553b.computeBounds(this.f12555d, false);
        float fP = ((q0.c) this.f12561j).p();
        RectF rectF2 = this.f12555d;
        float f10 = fP / 2.0f;
        rectF2.set(rectF2.left - f10, rectF2.top - f10, rectF2.right + f10, rectF2.bottom + f10);
        rectF.set(this.f12555d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        n0.e.b("StrokeContent#getBounds");
    }

    public final void d(Matrix matrix) {
        n0.e.a("StrokeContent#applyDashPattern");
        if (this.f12563l.isEmpty()) {
            n0.e.b("StrokeContent#applyDashPattern");
            return;
        }
        float fG = z0.h.g(matrix);
        for (int i10 = 0; i10 < this.f12563l.size(); i10++) {
            this.f12559h[i10] = this.f12563l.get(i10).h().floatValue();
            if (i10 % 2 == 0) {
                float[] fArr = this.f12559h;
                if (fArr[i10] < 1.0f) {
                    fArr[i10] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f12559h;
                if (fArr2[i10] < 0.1f) {
                    fArr2[i10] = 0.1f;
                }
            }
            float[] fArr3 = this.f12559h;
            fArr3[i10] = fArr3[i10] * fG;
        }
        q0.a<?, Float> aVar = this.f12564m;
        this.f12560i.setPathEffect(new DashPathEffect(this.f12559h, aVar == null ? 0.0f : fG * aVar.h().floatValue()));
        n0.e.b("StrokeContent#applyDashPattern");
    }

    @Override // s0.g
    public void e(s0.f fVar, int i10, List<s0.f> list, s0.f fVar2) {
        z0.g.m(fVar, i10, list, fVar2, this);
    }

    @Override // s0.g
    @CallSuper
    public <T> void f(T t10, @Nullable a1.j<T> jVar) {
        if (t10 == n0.o.f11047d) {
            this.f12562k.n(jVar);
            return;
        }
        if (t10 == n0.o.f11060q) {
            this.f12561j.n(jVar);
            return;
        }
        if (t10 == n0.o.E) {
            q0.a<ColorFilter, ColorFilter> aVar = this.f12565n;
            if (aVar != null) {
                this.f12557f.C(aVar);
            }
            if (jVar == null) {
                this.f12565n = null;
                return;
            }
            q0.p pVar = new q0.p(jVar, null);
            this.f12565n = pVar;
            pVar.a(this);
            this.f12557f.i(this.f12565n);
        }
    }

    @Override // p0.e
    public void g(Canvas canvas, Matrix matrix, int i10) {
        n0.e.a("StrokeContent#draw");
        if (z0.h.h(matrix)) {
            n0.e.b("StrokeContent#draw");
            return;
        }
        this.f12560i.setAlpha(z0.g.d((int) ((((i10 / 255.0f) * ((q0.e) this.f12562k).p()) / 100.0f) * 255.0f), 0, 255));
        this.f12560i.setStrokeWidth(z0.h.g(matrix) * ((q0.c) this.f12561j).p());
        if (this.f12560i.getStrokeWidth() <= 0.0f) {
            n0.e.b("StrokeContent#draw");
            return;
        }
        d(matrix);
        q0.a<ColorFilter, ColorFilter> aVar = this.f12565n;
        if (aVar != null) {
            this.f12560i.setColorFilter(aVar.h());
        }
        for (int i11 = 0; i11 < this.f12558g.size(); i11++) {
            b bVar = this.f12558g.get(i11);
            if (bVar.f12567b != null) {
                h(canvas, bVar, matrix);
            } else {
                n0.e.a("StrokeContent#buildPath");
                this.f12553b.reset();
                for (int size = bVar.f12566a.size() - 1; size >= 0; size--) {
                    this.f12553b.addPath(bVar.f12566a.get(size).getPath(), matrix);
                }
                n0.e.b("StrokeContent#buildPath");
                n0.e.a("StrokeContent#drawPath");
                canvas.drawPath(this.f12553b, this.f12560i);
                n0.e.b("StrokeContent#drawPath");
            }
        }
        n0.e.b("StrokeContent#draw");
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00e6  */
    public final void h(Canvas canvas, b bVar, Matrix matrix) {
        float f10;
        n0.e.a("StrokeContent#applyTrimPath");
        if (bVar.f12567b == null) {
            n0.e.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f12553b.reset();
        for (int size = bVar.f12566a.size() - 1; size >= 0; size--) {
            this.f12553b.addPath(bVar.f12566a.get(size).getPath(), matrix);
        }
        this.f12552a.setPath(this.f12553b, false);
        float length = this.f12552a.getLength();
        while (this.f12552a.nextContour()) {
            length += this.f12552a.getLength();
        }
        float fFloatValue = (bVar.f12567b.f().h().floatValue() * length) / 360.0f;
        float fFloatValue2 = ((bVar.f12567b.h().h().floatValue() * length) / 100.0f) + fFloatValue;
        float fFloatValue3 = ((bVar.f12567b.e().h().floatValue() * length) / 100.0f) + fFloatValue;
        float f11 = 0.0f;
        for (int size2 = bVar.f12566a.size() - 1; size2 >= 0; size2--) {
            this.f12554c.set(bVar.f12566a.get(size2).getPath());
            this.f12554c.transform(matrix);
            this.f12552a.setPath(this.f12554c, false);
            float length2 = this.f12552a.getLength();
            if (fFloatValue3 > length) {
                float f12 = fFloatValue3 - length;
                if (f12 >= f11 + length2 || f11 >= f12) {
                    f10 = f11 + length2;
                    if (f10 < fFloatValue2 && f11 <= fFloatValue3) {
                        if (f10 > fFloatValue3 || fFloatValue2 >= f11) {
                            z0.h.a(this.f12554c, fFloatValue2 < f11 ? 0.0f : (fFloatValue2 - f11) / length2, fFloatValue3 <= f10 ? (fFloatValue3 - f11) / length2 : 1.0f, 0.0f);
                            canvas.drawPath(this.f12554c, this.f12560i);
                        } else {
                            canvas.drawPath(this.f12554c, this.f12560i);
                        }
                    }
                } else {
                    z0.h.a(this.f12554c, fFloatValue2 > length ? (fFloatValue2 - length) / length2 : 0.0f, Math.min(f12 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f12554c, this.f12560i);
                }
            } else {
                f10 = f11 + length2;
                if (f10 < fFloatValue2) {
                }
            }
            f11 += length2;
        }
        n0.e.b("StrokeContent#applyTrimPath");
    }
}
