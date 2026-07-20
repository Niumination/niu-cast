package p0;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g implements e, q0.a.b, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f12589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f12590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v0.a f12591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f12592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f12593e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<n> f12594f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q0.a<Integer, Integer> f12595g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q0.a<Integer, Integer> f12596h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public q0.a<ColorFilter, ColorFilter> f12597i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final n0.j f12598j;

    public g(n0.j jVar, v0.a aVar, u0.m mVar) {
        Path path = new Path();
        this.f12589a = path;
        this.f12590b = new o0.a(1);
        this.f12594f = new ArrayList();
        this.f12591c = aVar;
        this.f12592d = mVar.d();
        this.f12593e = mVar.f();
        this.f12598j = jVar;
        if (mVar.b() == null || mVar.e() == null) {
            this.f12595g = null;
            this.f12596h = null;
            return;
        }
        path.setFillType(mVar.c());
        q0.a<Integer, Integer> aVarL = mVar.b().l();
        this.f12595g = aVarL;
        aVarL.a(this);
        aVar.i(aVarL);
        q0.a<Integer, Integer> aVarL2 = mVar.e().l();
        this.f12596h = aVarL2;
        aVarL2.a(this);
        aVar.i(aVarL2);
    }

    @Override // q0.a.b
    public void a() {
        this.f12598j.invalidateSelf();
    }

    @Override // p0.c
    public void b(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list2.size(); i10++) {
            c cVar = list2.get(i10);
            if (cVar instanceof n) {
                this.f12594f.add((n) cVar);
            }
        }
    }

    @Override // p0.e
    public void c(RectF rectF, Matrix matrix, boolean z10) {
        this.f12589a.reset();
        for (int i10 = 0; i10 < this.f12594f.size(); i10++) {
            this.f12589a.addPath(this.f12594f.get(i10).getPath(), matrix);
        }
        this.f12589a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // s0.g
    public void e(s0.f fVar, int i10, List<s0.f> list, s0.f fVar2) {
        z0.g.m(fVar, i10, list, fVar2, this);
    }

    @Override // s0.g
    public <T> void f(T t10, @Nullable a1.j<T> jVar) {
        if (t10 == n0.o.f11044a) {
            this.f12595g.n(jVar);
            return;
        }
        if (t10 == n0.o.f11047d) {
            this.f12596h.n(jVar);
            return;
        }
        if (t10 == n0.o.E) {
            q0.a<ColorFilter, ColorFilter> aVar = this.f12597i;
            if (aVar != null) {
                this.f12591c.C(aVar);
            }
            if (jVar == null) {
                this.f12597i = null;
                return;
            }
            q0.p pVar = new q0.p(jVar, null);
            this.f12597i = pVar;
            pVar.a(this);
            this.f12591c.i(this.f12597i);
        }
    }

    @Override // p0.e
    public void g(Canvas canvas, Matrix matrix, int i10) {
        if (this.f12593e) {
            return;
        }
        n0.e.a("FillContent#draw");
        this.f12590b.setColor(((q0.b) this.f12595g).p());
        this.f12590b.setAlpha(z0.g.d((int) ((((i10 / 255.0f) * this.f12596h.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        q0.a<ColorFilter, ColorFilter> aVar = this.f12597i;
        if (aVar != null) {
            this.f12590b.setColorFilter(aVar.h());
        }
        this.f12589a.reset();
        for (int i11 = 0; i11 < this.f12594f.size(); i11++) {
            this.f12589a.addPath(this.f12594f.get(i11).getPath(), matrix);
        }
        canvas.drawPath(this.f12589a, this.f12590b);
        n0.e.b("FillContent#draw");
    }

    @Override // p0.c
    public String getName() {
        return this.f12592d;
    }
}
