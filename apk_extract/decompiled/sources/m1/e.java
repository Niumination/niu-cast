package m1;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f7576c;
    public x1.c e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f7574a = new ArrayList(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7575b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f7577d = 0.0f;
    public Object f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f7578g = -1.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f7579h = -1.0f;

    public e(List list) {
        b dVar;
        if (list.isEmpty()) {
            dVar = new ph.c();
        } else {
            dVar = list.size() == 1 ? new d(list) : new c(list);
        }
        this.f7576c = dVar;
    }

    public final void a(a aVar) {
        this.f7574a.add(aVar);
    }

    public final x1.a b() {
        j1.a aVar = j1.d.f5945a;
        return this.f7576c.b();
    }

    public float c() {
        if (this.f7579h == -1.0f) {
            this.f7579h = this.f7576c.g();
        }
        return this.f7579h;
    }

    public final float d() {
        Interpolator interpolator;
        x1.a aVarB = b();
        if (aVarB == null || aVarB.c() || (interpolator = aVarB.f10809d) == null) {
            return 0.0f;
        }
        return interpolator.getInterpolation(e());
    }

    public final float e() {
        if (this.f7575b) {
            return 0.0f;
        }
        x1.a aVarB = b();
        if (aVarB.c()) {
            return 0.0f;
        }
        return (this.f7577d - aVarB.b()) / (aVarB.a() - aVarB.b());
    }

    public Object f() {
        Interpolator interpolator;
        float fE = e();
        if (this.e == null && this.f7576c.a(fE)) {
            return this.f;
        }
        x1.a aVarB = b();
        Interpolator interpolator2 = aVarB.e;
        Object objG = (interpolator2 == null || (interpolator = aVarB.f) == null) ? g(aVarB, d()) : h(aVarB, fE, interpolator2.getInterpolation(fE), interpolator.getInterpolation(fE));
        this.f = objG;
        return objG;
    }

    public abstract Object g(x1.a aVar, float f);

    public Object h(x1.a aVar, float f, float f4, float f10) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void i() {
        j1.a aVar = j1.d.f5945a;
        int i8 = 0;
        while (true) {
            ArrayList arrayList = this.f7574a;
            if (i8 >= arrayList.size()) {
                j1.a aVar2 = j1.d.f5945a;
                return;
            } else {
                ((a) arrayList.get(i8)).a();
                i8++;
            }
        }
    }

    public void j(float f) {
        j1.a aVar = j1.d.f5945a;
        b bVar = this.f7576c;
        if (bVar.isEmpty()) {
            return;
        }
        if (this.f7578g == -1.0f) {
            this.f7578g = bVar.e();
        }
        float f4 = this.f7578g;
        if (f < f4) {
            if (f4 == -1.0f) {
                this.f7578g = bVar.e();
            }
            f = this.f7578g;
        } else if (f > c()) {
            f = c();
        }
        if (f == this.f7577d) {
            return;
        }
        this.f7577d = f;
        if (bVar.c(f)) {
            i();
        }
    }

    public final void k(x1.c cVar) {
        x1.c cVar2 = this.e;
        if (cVar2 != null) {
            cVar2.getClass();
        }
        this.e = cVar;
    }
}
