package p0;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class s extends a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final v0.a f12681o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f12682p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f12683q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final q0.a<Integer, Integer> f12684r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public q0.a<ColorFilter, ColorFilter> f12685s;

    public s(n0.j jVar, v0.a aVar, u0.p pVar) {
        super(jVar, aVar, pVar.b().toPaintCap(), pVar.e().toPaintJoin(), pVar.g(), pVar.i(), pVar.j(), pVar.f(), pVar.d());
        this.f12681o = aVar;
        this.f12682p = pVar.h();
        this.f12683q = pVar.k();
        q0.a<Integer, Integer> aVarL = pVar.c().l();
        this.f12684r = aVarL;
        aVarL.a(this);
        aVar.i(aVarL);
    }

    @Override // p0.a, s0.g
    public <T> void f(T t10, @Nullable a1.j<T> jVar) {
        super.f(t10, jVar);
        if (t10 == n0.o.f11045b) {
            this.f12684r.n(jVar);
            return;
        }
        if (t10 == n0.o.E) {
            q0.a<ColorFilter, ColorFilter> aVar = this.f12685s;
            if (aVar != null) {
                this.f12681o.C(aVar);
            }
            if (jVar == null) {
                this.f12685s = null;
                return;
            }
            q0.p pVar = new q0.p(jVar, null);
            this.f12685s = pVar;
            pVar.a(this);
            this.f12681o.i(this.f12684r);
        }
    }

    @Override // p0.a, p0.e
    public void g(Canvas canvas, Matrix matrix, int i10) {
        if (this.f12683q) {
            return;
        }
        this.f12560i.setColor(((q0.b) this.f12684r).p());
        q0.a<ColorFilter, ColorFilter> aVar = this.f12685s;
        if (aVar != null) {
            this.f12560i.setColorFilter(aVar.h());
        }
        super.g(canvas, matrix, i10);
    }

    @Override // p0.c
    public String getName() {
        return this.f12682p;
    }
}
