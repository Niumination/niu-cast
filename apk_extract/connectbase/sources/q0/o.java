package q0;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f13384a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f13385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f13386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Matrix f13387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f13388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public a<PointF, PointF> f13389f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public a<?, PointF> f13390g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public a<a1.k, a1.k> f13391h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public a<Float, Float> f13392i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public a<Integer, Integer> f13393j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public c f13394k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public c f13395l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public a<?, Float> f13396m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public a<?, Float> f13397n;

    public o(t0.l lVar) {
        this.f13389f = lVar.c() == null ? null : lVar.c().l();
        this.f13390g = lVar.f() == null ? null : lVar.f().l();
        this.f13391h = lVar.h() == null ? null : lVar.h().l();
        this.f13392i = lVar.g() == null ? null : lVar.g().l();
        c cVar = lVar.i() == null ? null : (c) lVar.i().l();
        this.f13394k = cVar;
        if (cVar != null) {
            this.f13385b = new Matrix();
            this.f13386c = new Matrix();
            this.f13387d = new Matrix();
            this.f13388e = new float[9];
        } else {
            this.f13385b = null;
            this.f13386c = null;
            this.f13387d = null;
            this.f13388e = null;
        }
        this.f13395l = lVar.j() == null ? null : (c) lVar.j().l();
        if (lVar.e() != null) {
            this.f13393j = lVar.e().l();
        }
        if (lVar.k() != null) {
            this.f13396m = lVar.k().l();
        } else {
            this.f13396m = null;
        }
        if (lVar.d() != null) {
            this.f13397n = lVar.d().l();
        } else {
            this.f13397n = null;
        }
    }

    public void a(v0.a aVar) {
        aVar.i(this.f13393j);
        aVar.i(this.f13396m);
        aVar.i(this.f13397n);
        aVar.i(this.f13389f);
        aVar.i(this.f13390g);
        aVar.i(this.f13391h);
        aVar.i(this.f13392i);
        aVar.i(this.f13394k);
        aVar.i(this.f13395l);
    }

    public void b(a.b bVar) {
        a<Integer, Integer> aVar = this.f13393j;
        if (aVar != null) {
            aVar.a(bVar);
        }
        a<?, Float> aVar2 = this.f13396m;
        if (aVar2 != null) {
            aVar2.a(bVar);
        }
        a<?, Float> aVar3 = this.f13397n;
        if (aVar3 != null) {
            aVar3.a(bVar);
        }
        a<PointF, PointF> aVar4 = this.f13389f;
        if (aVar4 != null) {
            aVar4.a(bVar);
        }
        a<?, PointF> aVar5 = this.f13390g;
        if (aVar5 != null) {
            aVar5.a(bVar);
        }
        a<a1.k, a1.k> aVar6 = this.f13391h;
        if (aVar6 != null) {
            aVar6.a(bVar);
        }
        a<Float, Float> aVar7 = this.f13392i;
        if (aVar7 != null) {
            aVar7.a(bVar);
        }
        c cVar = this.f13394k;
        if (cVar != null) {
            cVar.a(bVar);
        }
        c cVar2 = this.f13395l;
        if (cVar2 != null) {
            cVar2.a(bVar);
        }
    }

    public <T> boolean c(T t10, @Nullable a1.j<T> jVar) {
        c cVar;
        c cVar2;
        a<?, Float> aVar;
        a<?, Float> aVar2;
        if (t10 == n0.o.f11048e) {
            a<PointF, PointF> aVar3 = this.f13389f;
            if (aVar3 == null) {
                this.f13389f = new p(jVar, new PointF());
                return true;
            }
            aVar3.n(jVar);
            return true;
        }
        if (t10 == n0.o.f11049f) {
            a<?, PointF> aVar4 = this.f13390g;
            if (aVar4 == null) {
                this.f13390g = new p(jVar, new PointF());
                return true;
            }
            aVar4.n(jVar);
            return true;
        }
        if (t10 == n0.o.f11050g) {
            a<?, PointF> aVar5 = this.f13390g;
            if (aVar5 instanceof m) {
                ((m) aVar5).r(jVar);
                return true;
            }
        }
        if (t10 == n0.o.f11051h) {
            a<?, PointF> aVar6 = this.f13390g;
            if (aVar6 instanceof m) {
                ((m) aVar6).s(jVar);
                return true;
            }
        }
        if (t10 == n0.o.f11056m) {
            a<a1.k, a1.k> aVar7 = this.f13391h;
            if (aVar7 == null) {
                this.f13391h = new p(jVar, new a1.k());
                return true;
            }
            aVar7.n(jVar);
            return true;
        }
        if (t10 == n0.o.f11057n) {
            a<Float, Float> aVar8 = this.f13392i;
            if (aVar8 == null) {
                this.f13392i = new p(jVar, Float.valueOf(0.0f));
                return true;
            }
            aVar8.n(jVar);
            return true;
        }
        if (t10 == n0.o.f11046c) {
            a<Integer, Integer> aVar9 = this.f13393j;
            if (aVar9 == null) {
                this.f13393j = new p(jVar, 100);
                return true;
            }
            aVar9.n(jVar);
            return true;
        }
        if (t10 == n0.o.A && (aVar2 = this.f13396m) != null) {
            if (aVar2 == null) {
                this.f13396m = new p(jVar, 100);
                return true;
            }
            aVar2.n(jVar);
            return true;
        }
        if (t10 == n0.o.B && (aVar = this.f13397n) != null) {
            if (aVar == null) {
                this.f13397n = new p(jVar, 100);
                return true;
            }
            aVar.n(jVar);
            return true;
        }
        if (t10 == n0.o.f11058o && (cVar2 = this.f13394k) != null) {
            if (cVar2 == null) {
                this.f13394k = new c(Collections.singletonList(new a1.a(Float.valueOf(0.0f))));
            }
            this.f13394k.n(jVar);
            return true;
        }
        if (t10 != n0.o.f11059p || (cVar = this.f13395l) == null) {
            return false;
        }
        if (cVar == null) {
            this.f13395l = new c(Collections.singletonList(new a1.a(Float.valueOf(0.0f))));
        }
        this.f13395l.n(jVar);
        return true;
    }

    public final void d() {
        for (int i10 = 0; i10 < 9; i10++) {
            this.f13388e[i10] = 0.0f;
        }
    }

    @Nullable
    public a<?, Float> e() {
        return this.f13397n;
    }

    public Matrix f() {
        this.f13384a.reset();
        a<?, PointF> aVar = this.f13390g;
        if (aVar != null) {
            PointF pointFH = aVar.h();
            float f10 = pointFH.x;
            if (f10 != 0.0f || pointFH.y != 0.0f) {
                this.f13384a.preTranslate(f10, pointFH.y);
            }
        }
        a<Float, Float> aVar2 = this.f13392i;
        if (aVar2 != null) {
            float fFloatValue = aVar2 instanceof p ? aVar2.h().floatValue() : ((c) aVar2).p();
            if (fFloatValue != 0.0f) {
                this.f13384a.preRotate(fFloatValue);
            }
        }
        if (this.f13394k != null) {
            c cVar = this.f13395l;
            float fCos = cVar == null ? 0.0f : (float) Math.cos(Math.toRadians((-cVar.p()) + 90.0f));
            c cVar2 = this.f13395l;
            float fSin = cVar2 == null ? 1.0f : (float) Math.sin(Math.toRadians((-cVar2.p()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(this.f13394k.p()));
            d();
            float[] fArr = this.f13388e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f11 = -fSin;
            fArr[3] = f11;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.f13385b.setValues(fArr);
            d();
            float[] fArr2 = this.f13388e;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f13386c.setValues(fArr2);
            d();
            float[] fArr3 = this.f13388e;
            fArr3[0] = fCos;
            fArr3[1] = f11;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.f13387d.setValues(fArr3);
            this.f13386c.preConcat(this.f13385b);
            this.f13387d.preConcat(this.f13386c);
            this.f13384a.preConcat(this.f13387d);
        }
        a<a1.k, a1.k> aVar3 = this.f13391h;
        if (aVar3 != null) {
            a1.k kVarH = aVar3.h();
            if (kVarH.b() != 1.0f || kVarH.c() != 1.0f) {
                this.f13384a.preScale(kVarH.b(), kVarH.c());
            }
        }
        a<PointF, PointF> aVar4 = this.f13389f;
        if (aVar4 != null) {
            PointF pointFH2 = aVar4.h();
            float f12 = pointFH2.x;
            if (f12 != 0.0f || pointFH2.y != 0.0f) {
                this.f13384a.preTranslate(-f12, -pointFH2.y);
            }
        }
        return this.f13384a;
    }

    public Matrix g(float f10) {
        a<?, PointF> aVar = this.f13390g;
        PointF pointFH = aVar == null ? null : aVar.h();
        a<a1.k, a1.k> aVar2 = this.f13391h;
        a1.k kVarH = aVar2 == null ? null : aVar2.h();
        this.f13384a.reset();
        if (pointFH != null) {
            this.f13384a.preTranslate(pointFH.x * f10, pointFH.y * f10);
        }
        if (kVarH != null) {
            double d10 = f10;
            this.f13384a.preScale((float) Math.pow(kVarH.b(), d10), (float) Math.pow(kVarH.c(), d10));
        }
        a<Float, Float> aVar3 = this.f13392i;
        if (aVar3 != null) {
            float fFloatValue = aVar3.h().floatValue();
            a<PointF, PointF> aVar4 = this.f13389f;
            PointF pointFH2 = aVar4 != null ? aVar4.h() : null;
            this.f13384a.preRotate(fFloatValue * f10, pointFH2 == null ? 0.0f : pointFH2.x, pointFH2 != null ? pointFH2.y : 0.0f);
        }
        return this.f13384a;
    }

    @Nullable
    public a<?, Integer> h() {
        return this.f13393j;
    }

    @Nullable
    public a<?, Float> i() {
        return this.f13396m;
    }

    public void j(float f10) {
        a<Integer, Integer> aVar = this.f13393j;
        if (aVar != null) {
            aVar.m(f10);
        }
        a<?, Float> aVar2 = this.f13396m;
        if (aVar2 != null) {
            aVar2.m(f10);
        }
        a<?, Float> aVar3 = this.f13397n;
        if (aVar3 != null) {
            aVar3.m(f10);
        }
        a<PointF, PointF> aVar4 = this.f13389f;
        if (aVar4 != null) {
            aVar4.m(f10);
        }
        a<?, PointF> aVar5 = this.f13390g;
        if (aVar5 != null) {
            aVar5.m(f10);
        }
        a<a1.k, a1.k> aVar6 = this.f13391h;
        if (aVar6 != null) {
            aVar6.m(f10);
        }
        a<Float, Float> aVar7 = this.f13392i;
        if (aVar7 != null) {
            aVar7.m(f10);
        }
        c cVar = this.f13394k;
        if (cVar != null) {
            cVar.m(f10);
        }
        c cVar2 = this.f13395l;
        if (cVar2 != null) {
            cVar2.m(f10);
        }
    }
}
