package p0;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class p implements q0.a.b, k, n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f12657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n0.j f12658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q0.a<?, PointF> f12659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q0.a<?, PointF> f12660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q0.a<?, Float> f12661h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f12663j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f12654a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f12655b = new RectF();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f12662i = new b();

    public p(n0.j jVar, v0.a aVar, u0.j jVar2) {
        this.f12656c = jVar2.c();
        this.f12657d = jVar2.f();
        this.f12658e = jVar;
        q0.a<PointF, PointF> aVarL = jVar2.d().l();
        this.f12659f = aVarL;
        q0.a<PointF, PointF> aVarL2 = jVar2.e().l();
        this.f12660g = aVarL2;
        q0.a<Float, Float> aVarL3 = jVar2.b().l();
        this.f12661h = aVarL3;
        aVar.i(aVarL);
        aVar.i(aVarL2);
        aVar.i(aVarL3);
        aVarL.a(this);
        aVarL2.a(this);
        aVarL3.a(this);
    }

    private void d() {
        this.f12663j = false;
        this.f12658e.invalidateSelf();
    }

    @Override // q0.a.b
    public void a() {
        d();
    }

    @Override // p0.c
    public void b(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = list.get(i10);
            if (cVar instanceof t) {
                t tVar = (t) cVar;
                if (tVar.i() == u0.q.a.SIMULTANEOUSLY) {
                    this.f12662i.a(tVar);
                    tVar.d(this);
                }
            }
        }
    }

    @Override // s0.g
    public void e(s0.f fVar, int i10, List<s0.f> list, s0.f fVar2) {
        z0.g.m(fVar, i10, list, fVar2, this);
    }

    @Override // s0.g
    public <T> void f(T t10, @Nullable a1.j<T> jVar) {
        if (t10 == n0.o.f11053j) {
            this.f12660g.n(jVar);
        } else if (t10 == n0.o.f11055l) {
            this.f12659f.n(jVar);
        } else if (t10 == n0.o.f11054k) {
            this.f12661h.n(jVar);
        }
    }

    @Override // p0.c
    public String getName() {
        return this.f12656c;
    }

    @Override // p0.n
    public Path getPath() {
        if (this.f12663j) {
            return this.f12654a;
        }
        this.f12654a.reset();
        if (this.f12657d) {
            this.f12663j = true;
            return this.f12654a;
        }
        PointF pointFH = this.f12660g.h();
        float f10 = pointFH.x / 2.0f;
        float f11 = pointFH.y / 2.0f;
        q0.a<?, Float> aVar = this.f12661h;
        float fP = aVar == null ? 0.0f : ((q0.c) aVar).p();
        float fMin = Math.min(f10, f11);
        if (fP > fMin) {
            fP = fMin;
        }
        PointF pointFH2 = this.f12659f.h();
        this.f12654a.moveTo(pointFH2.x + f10, (pointFH2.y - f11) + fP);
        this.f12654a.lineTo(pointFH2.x + f10, (pointFH2.y + f11) - fP);
        if (fP > 0.0f) {
            RectF rectF = this.f12655b;
            float f12 = pointFH2.x;
            float f13 = fP * 2.0f;
            float f14 = pointFH2.y;
            rectF.set((f12 + f10) - f13, (f14 + f11) - f13, f12 + f10, f14 + f11);
            this.f12654a.arcTo(this.f12655b, 0.0f, 90.0f, false);
        }
        this.f12654a.lineTo((pointFH2.x - f10) + fP, pointFH2.y + f11);
        if (fP > 0.0f) {
            RectF rectF2 = this.f12655b;
            float f15 = pointFH2.x;
            float f16 = pointFH2.y;
            float f17 = fP * 2.0f;
            rectF2.set(f15 - f10, (f16 + f11) - f17, (f15 - f10) + f17, f16 + f11);
            this.f12654a.arcTo(this.f12655b, 90.0f, 90.0f, false);
        }
        this.f12654a.lineTo(pointFH2.x - f10, (pointFH2.y - f11) + fP);
        if (fP > 0.0f) {
            RectF rectF3 = this.f12655b;
            float f18 = pointFH2.x;
            float f19 = pointFH2.y;
            float f20 = fP * 2.0f;
            rectF3.set(f18 - f10, f19 - f11, (f18 - f10) + f20, (f19 - f11) + f20);
            this.f12654a.arcTo(this.f12655b, 180.0f, 90.0f, false);
        }
        this.f12654a.lineTo((pointFH2.x + f10) - fP, pointFH2.y - f11);
        if (fP > 0.0f) {
            RectF rectF4 = this.f12655b;
            float f21 = pointFH2.x;
            float f22 = fP * 2.0f;
            float f23 = pointFH2.y;
            rectF4.set((f21 + f10) - f22, f23 - f11, f21 + f10, (f23 - f11) + f22);
            this.f12654a.arcTo(this.f12655b, 270.0f, 90.0f, false);
        }
        this.f12654a.close();
        this.f12662i.b(this.f12654a);
        this.f12663j = true;
        return this.f12654a;
    }
}
