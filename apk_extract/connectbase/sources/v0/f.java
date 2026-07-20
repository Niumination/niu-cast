package v0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;
import n0.j;
import u0.n;

/* JADX INFO: loaded from: classes.dex */
public class f extends a {
    public final p0.d D;

    public f(j jVar, d dVar) {
        super(jVar, dVar);
        p0.d dVar2 = new p0.d(jVar, this, new n("__container", dVar.l(), false));
        this.D = dVar2;
        dVar2.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // v0.a
    public void D(s0.f fVar, int i10, List<s0.f> list, s0.f fVar2) {
        this.D.e(fVar, i10, list, fVar2);
    }

    @Override // v0.a, p0.e
    public void c(RectF rectF, Matrix matrix, boolean z10) {
        super.c(rectF, matrix, z10);
        this.D.c(rectF, this.f16423m, z10);
    }

    @Override // v0.a
    public void t(@NonNull Canvas canvas, Matrix matrix, int i10) {
        this.D.g(canvas, matrix, i10);
    }
}
