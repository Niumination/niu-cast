package p0;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f implements n, q0.a.b, k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float f12580i = 0.55228f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n0.j f12583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q0.a<?, PointF> f12584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q0.a<?, PointF> f12585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u0.a f12586f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f12588h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f12581a = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f12587g = new b();

    public f(n0.j jVar, v0.a aVar, u0.a aVar2) {
        this.f12582b = aVar2.b();
        this.f12583c = jVar;
        q0.a<PointF, PointF> aVarL = aVar2.d().l();
        this.f12584d = aVarL;
        q0.a<PointF, PointF> aVarL2 = aVar2.c().l();
        this.f12585e = aVarL2;
        this.f12586f = aVar2;
        aVar.i(aVarL);
        aVar.i(aVarL2);
        aVarL.a(this);
        aVarL2.a(this);
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
                    this.f12587g.a(tVar);
                    tVar.d(this);
                }
            }
        }
    }

    public final void d() {
        this.f12588h = false;
        this.f12583c.invalidateSelf();
    }

    @Override // s0.g
    public void e(s0.f fVar, int i10, List<s0.f> list, s0.f fVar2) {
        z0.g.m(fVar, i10, list, fVar2, this);
    }

    @Override // s0.g
    public <T> void f(T t10, @Nullable a1.j<T> jVar) {
        if (t10 == n0.o.f11052i) {
            this.f12584d.n(jVar);
        } else if (t10 == n0.o.f11055l) {
            this.f12585e.n(jVar);
        }
    }

    @Override // p0.c
    public String getName() {
        return this.f12582b;
    }

    @Override // p0.n
    public Path getPath() {
        if (this.f12588h) {
            return this.f12581a;
        }
        this.f12581a.reset();
        if (this.f12586f.e()) {
            this.f12588h = true;
            return this.f12581a;
        }
        PointF pointFH = this.f12584d.h();
        float f10 = pointFH.x / 2.0f;
        float f11 = pointFH.y / 2.0f;
        float f12 = f10 * 0.55228f;
        float f13 = 0.55228f * f11;
        this.f12581a.reset();
        if (this.f12586f.f()) {
            float f14 = -f11;
            this.f12581a.moveTo(0.0f, f14);
            float f15 = 0.0f - f12;
            float f16 = -f10;
            float f17 = 0.0f - f13;
            this.f12581a.cubicTo(f15, f14, f16, f17, f16, 0.0f);
            float f18 = f13 + 0.0f;
            this.f12581a.cubicTo(f16, f18, f15, f11, 0.0f, f11);
            float f19 = f12 + 0.0f;
            this.f12581a.cubicTo(f19, f11, f10, f18, f10, 0.0f);
            this.f12581a.cubicTo(f10, f17, f19, f14, 0.0f, f14);
        } else {
            float f20 = -f11;
            this.f12581a.moveTo(0.0f, f20);
            float f21 = f12 + 0.0f;
            float f22 = 0.0f - f13;
            this.f12581a.cubicTo(f21, f20, f10, f22, f10, 0.0f);
            float f23 = f13 + 0.0f;
            this.f12581a.cubicTo(f10, f23, f21, f11, 0.0f, f11);
            float f24 = 0.0f - f12;
            float f25 = -f10;
            this.f12581a.cubicTo(f24, f11, f25, f23, f25, 0.0f);
            this.f12581a.cubicTo(f25, f22, f24, f20, 0.0f, f20);
        }
        PointF pointFH2 = this.f12585e.h();
        this.f12581a.offset(pointFH2.x, pointFH2.y);
        this.f12581a.close();
        this.f12587g.b(this.f12581a);
        this.f12588h = true;
        return this.f12581a;
    }
}
