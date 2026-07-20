package v0;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import n0.j;
import n0.o;
import q0.p;

/* JADX INFO: loaded from: classes.dex */
public class g extends a {
    public final RectF D;
    public final Paint E;
    public final float[] F;
    public final Path G;
    public final d H;

    @Nullable
    public q0.a<ColorFilter, ColorFilter> I;

    public g(j jVar, d dVar) {
        super(jVar, dVar);
        this.D = new RectF();
        o0.a aVar = new o0.a();
        this.E = aVar;
        this.F = new float[8];
        this.G = new Path();
        this.H = dVar;
        aVar.setAlpha(0);
        aVar.setStyle(Paint.Style.FILL);
        aVar.setColor(dVar.m());
    }

    @Override // v0.a, p0.e
    public void c(RectF rectF, Matrix matrix, boolean z10) {
        super.c(rectF, matrix, z10);
        this.D.set(0.0f, 0.0f, this.H.o(), this.H.n());
        this.f16423m.mapRect(this.D);
        rectF.set(this.D);
    }

    @Override // v0.a, s0.g
    public <T> void f(T t10, @Nullable a1.j<T> jVar) {
        super.f(t10, jVar);
        if (t10 == o.E) {
            if (jVar == null) {
                this.I = null;
            } else {
                this.I = new p(jVar, null);
            }
        }
    }

    @Override // v0.a
    public void t(Canvas canvas, Matrix matrix, int i10) {
        int iAlpha = Color.alpha(this.H.m());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((((iAlpha / 255.0f) * (this.f16432v.h() == null ? 100 : this.f16432v.h().h().intValue())) / 100.0f) * (i10 / 255.0f) * 255.0f);
        this.E.setAlpha(iIntValue);
        q0.a<ColorFilter, ColorFilter> aVar = this.I;
        if (aVar != null) {
            this.E.setColorFilter(aVar.h());
        }
        if (iIntValue > 0) {
            float[] fArr = this.F;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.H.o();
            float[] fArr2 = this.F;
            fArr2[3] = 0.0f;
            fArr2[4] = this.H.o();
            this.F[5] = this.H.n();
            float[] fArr3 = this.F;
            fArr3[6] = 0.0f;
            fArr3[7] = this.H.n();
            matrix.mapPoints(this.F);
            this.G.reset();
            Path path = this.G;
            float[] fArr4 = this.F;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.G;
            float[] fArr5 = this.F;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.G;
            float[] fArr6 = this.F;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.G;
            float[] fArr7 = this.F;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.G;
            float[] fArr8 = this.F;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.G.close();
            canvas.drawPath(this.G, this.E);
        }
    }
}
