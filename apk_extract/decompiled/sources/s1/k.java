package s1;

import af.r5;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import j1.x;
import java.util.ArrayList;
import java.util.Collections;
import r1.s;

/* JADX INFO: loaded from: classes.dex */
public final class k extends c {
    public final l1.e D;
    public final e E;

    public k(x xVar, i iVar, e eVar, j1.j jVar) {
        super(xVar, iVar);
        this.E = eVar;
        l1.e eVar2 = new l1.e(xVar, this, new s("__container", false, iVar.f9472a), jVar);
        this.D = eVar2;
        eVar2.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // s1.c, l1.f
    public final void d(RectF rectF, Matrix matrix, boolean z2) {
        super.d(rectF, matrix, z2);
        this.D.d(rectF, this.f9461n, z2);
    }

    @Override // s1.c
    public final void i(Canvas canvas, Matrix matrix, int i8) {
        this.D.g(canvas, matrix, i8);
    }

    @Override // s1.c
    public final o5.c j() {
        o5.c cVar = this.p.f9489w;
        return cVar != null ? cVar : this.E.p.f9489w;
    }

    @Override // s1.c
    public final r5 k() {
        r5 r5Var = this.p.f9490x;
        return r5Var != null ? r5Var : this.E.p.f9490x;
    }

    @Override // s1.c
    public final void o(p1.f fVar, int i8, ArrayList arrayList, p1.f fVar2) {
        this.D.c(fVar, i8, arrayList, fVar2);
    }
}
