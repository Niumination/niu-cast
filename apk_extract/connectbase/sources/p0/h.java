package p0;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h implements e, q0.a.b, k {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f12599s = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final String f12600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v0.a f12602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LongSparseArray<LinearGradient> f12603d = new LongSparseArray<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LongSparseArray<RadialGradient> f12604e = new LongSparseArray<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f12605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f12606g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f12607h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<n> f12608i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final u0.f f12609j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final q0.a<u0.c, u0.c> f12610k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final q0.a<Integer, Integer> f12611l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final q0.a<PointF, PointF> f12612m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final q0.a<PointF, PointF> f12613n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public q0.a<ColorFilter, ColorFilter> f12614o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public q0.p f12615p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final n0.j f12616q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f12617r;

    public h(n0.j jVar, v0.a aVar, u0.d dVar) {
        Path path = new Path();
        this.f12605f = path;
        this.f12606g = new o0.a(1);
        this.f12607h = new RectF();
        this.f12608i = new ArrayList();
        this.f12602c = aVar;
        this.f12600a = dVar.h();
        this.f12601b = dVar.k();
        this.f12616q = jVar;
        this.f12609j = dVar.e();
        path.setFillType(dVar.c());
        this.f12617r = (int) (jVar.t().d() / 32.0f);
        q0.a<u0.c, u0.c> aVarL = dVar.d().l();
        this.f12610k = aVarL;
        aVarL.a(this);
        aVar.i(aVarL);
        q0.a<Integer, Integer> aVarL2 = dVar.i().l();
        this.f12611l = aVarL2;
        aVarL2.a(this);
        aVar.i(aVarL2);
        q0.a<PointF, PointF> aVarL3 = dVar.j().l();
        this.f12612m = aVarL3;
        aVarL3.a(this);
        aVar.i(aVarL3);
        q0.a<PointF, PointF> aVarL4 = dVar.b().l();
        this.f12613n = aVarL4;
        aVarL4.a(this);
        aVar.i(aVarL4);
    }

    private int[] d(int[] iArr) {
        q0.p pVar = this.f12615p;
        if (pVar != null) {
            Integer[] numArr = (Integer[]) pVar.h();
            int i10 = 0;
            if (iArr.length == numArr.length) {
                while (i10 < iArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i10 < numArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            }
        }
        return iArr;
    }

    private int h() {
        int iRound = Math.round(this.f12612m.f() * this.f12617r);
        int iRound2 = Math.round(this.f12613n.f() * this.f12617r);
        int iRound3 = Math.round(this.f12610k.f() * this.f12617r);
        int i10 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i10 = i10 * 31 * iRound2;
        }
        return iRound3 != 0 ? i10 * 31 * iRound3 : i10;
    }

    private LinearGradient i() {
        long jH = h();
        LinearGradient linearGradient = this.f12603d.get(jH);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFH = this.f12612m.h();
        PointF pointFH2 = this.f12613n.h();
        u0.c cVarH = this.f12610k.h();
        LinearGradient linearGradient2 = new LinearGradient(pointFH.x, pointFH.y, pointFH2.x, pointFH2.y, d(cVarH.a()), cVarH.b(), Shader.TileMode.CLAMP);
        this.f12603d.put(jH, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient j() {
        long jH = h();
        RadialGradient radialGradient = this.f12604e.get(jH);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFH = this.f12612m.h();
        PointF pointFH2 = this.f12613n.h();
        u0.c cVarH = this.f12610k.h();
        int[] iArrD = d(cVarH.a());
        float[] fArrB = cVarH.b();
        float f10 = pointFH.x;
        float f11 = pointFH.y;
        float fHypot = (float) Math.hypot(pointFH2.x - f10, pointFH2.y - f11);
        if (fHypot <= 0.0f) {
            fHypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f10, f11, fHypot, iArrD, fArrB, Shader.TileMode.CLAMP);
        this.f12604e.put(jH, radialGradient2);
        return radialGradient2;
    }

    @Override // q0.a.b
    public void a() {
        this.f12616q.invalidateSelf();
    }

    @Override // p0.c
    public void b(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list2.size(); i10++) {
            c cVar = list2.get(i10);
            if (cVar instanceof n) {
                this.f12608i.add((n) cVar);
            }
        }
    }

    @Override // p0.e
    public void c(RectF rectF, Matrix matrix, boolean z10) {
        this.f12605f.reset();
        for (int i10 = 0; i10 < this.f12608i.size(); i10++) {
            this.f12605f.addPath(this.f12608i.get(i10).getPath(), matrix);
        }
        this.f12605f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // s0.g
    public void e(s0.f fVar, int i10, List<s0.f> list, s0.f fVar2) {
        z0.g.m(fVar, i10, list, fVar2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s0.g
    public <T> void f(T t10, @Nullable a1.j<T> jVar) {
        if (t10 == n0.o.f11047d) {
            this.f12611l.n(jVar);
            return;
        }
        if (t10 == n0.o.E) {
            q0.a<ColorFilter, ColorFilter> aVar = this.f12614o;
            if (aVar != null) {
                this.f12602c.C(aVar);
            }
            if (jVar == null) {
                this.f12614o = null;
                return;
            }
            q0.p pVar = new q0.p(jVar, null);
            this.f12614o = pVar;
            pVar.a(this);
            this.f12602c.i(this.f12614o);
            return;
        }
        if (t10 == n0.o.F) {
            q0.p pVar2 = this.f12615p;
            if (pVar2 != null) {
                this.f12602c.C(pVar2);
            }
            if (jVar == null) {
                this.f12615p = null;
                return;
            }
            this.f12603d.clear();
            this.f12604e.clear();
            q0.p pVar3 = new q0.p(jVar, null);
            this.f12615p = pVar3;
            pVar3.a(this);
            this.f12602c.i(this.f12615p);
        }
    }

    @Override // p0.e
    public void g(Canvas canvas, Matrix matrix, int i10) {
        if (this.f12601b) {
            return;
        }
        n0.e.a("GradientFillContent#draw");
        this.f12605f.reset();
        for (int i11 = 0; i11 < this.f12608i.size(); i11++) {
            this.f12605f.addPath(this.f12608i.get(i11).getPath(), matrix);
        }
        this.f12605f.computeBounds(this.f12607h, false);
        Shader shaderI = this.f12609j == u0.f.LINEAR ? i() : j();
        shaderI.setLocalMatrix(matrix);
        this.f12606g.setShader(shaderI);
        q0.a<ColorFilter, ColorFilter> aVar = this.f12614o;
        if (aVar != null) {
            this.f12606g.setColorFilter(aVar.h());
        }
        this.f12606g.setAlpha(z0.g.d((int) ((((i10 / 255.0f) * this.f12611l.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f12605f, this.f12606g);
        n0.e.b("GradientFillContent#draw");
    }

    @Override // p0.c
    public String getName() {
        return this.f12600a;
    }
}
