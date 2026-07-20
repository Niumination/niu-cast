package p0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public class q implements e, n, j, q0.a.b, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f12664a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f12665b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n0.j f12666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v0.a f12667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f12668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f12669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q0.a<Float, Float> f12670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q0.a<Float, Float> f12671h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final q0.o f12672i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f12673j;

    public q(n0.j jVar, v0.a aVar, u0.k kVar) {
        this.f12666c = jVar;
        this.f12667d = aVar;
        this.f12668e = kVar.c();
        this.f12669f = kVar.f();
        q0.a<Float, Float> aVarL = kVar.b().l();
        this.f12670g = aVarL;
        aVar.i(aVarL);
        aVarL.a(this);
        q0.a<Float, Float> aVarL2 = kVar.d().l();
        this.f12671h = aVarL2;
        aVar.i(aVarL2);
        aVarL2.a(this);
        q0.o oVarB = kVar.e().b();
        this.f12672i = oVarB;
        oVarB.a(aVar);
        oVarB.b(this);
    }

    @Override // q0.a.b
    public void a() {
        this.f12666c.invalidateSelf();
    }

    @Override // p0.c
    public void b(List<c> list, List<c> list2) {
        this.f12673j.b(list, list2);
    }

    @Override // p0.e
    public void c(RectF rectF, Matrix matrix, boolean z10) {
        this.f12673j.c(rectF, matrix, z10);
    }

    @Override // p0.j
    public void d(ListIterator<c> listIterator) {
        if (this.f12673j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f12673j = new d(this.f12666c, this.f12667d, "Repeater", this.f12669f, arrayList, null);
    }

    @Override // s0.g
    public void e(s0.f fVar, int i10, List<s0.f> list, s0.f fVar2) {
        z0.g.m(fVar, i10, list, fVar2, this);
    }

    @Override // s0.g
    public <T> void f(T t10, @Nullable a1.j<T> jVar) {
        if (this.f12672i.c(t10, jVar)) {
            return;
        }
        if (t10 == n0.o.f11062s) {
            this.f12670g.n(jVar);
        } else if (t10 == n0.o.f11063t) {
            this.f12671h.n(jVar);
        }
    }

    @Override // p0.e
    public void g(Canvas canvas, Matrix matrix, int i10) {
        float fFloatValue = this.f12670g.h().floatValue();
        float fFloatValue2 = this.f12671h.h().floatValue();
        float fFloatValue3 = this.f12672i.i().h().floatValue() / 100.0f;
        float fFloatValue4 = this.f12672i.e().h().floatValue() / 100.0f;
        for (int i11 = ((int) fFloatValue) - 1; i11 >= 0; i11--) {
            this.f12664a.set(matrix);
            float f10 = i11;
            this.f12664a.preConcat(this.f12672i.g(f10 + fFloatValue2));
            this.f12673j.g(canvas, this.f12664a, (int) (z0.g.k(fFloatValue3, fFloatValue4, f10 / fFloatValue) * i10));
        }
    }

    @Override // p0.c
    public String getName() {
        return this.f12668e;
    }

    @Override // p0.n
    public Path getPath() {
        Path path = this.f12673j.getPath();
        this.f12665b.reset();
        float fFloatValue = this.f12670g.h().floatValue();
        float fFloatValue2 = this.f12671h.h().floatValue();
        for (int i10 = ((int) fFloatValue) - 1; i10 >= 0; i10--) {
            this.f12664a.set(this.f12672i.g(i10 + fFloatValue2));
            this.f12665b.addPath(path, this.f12664a);
        }
        return this.f12665b;
    }
}
