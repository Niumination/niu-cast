package v0;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import n0.j;
import n0.o;
import q0.p;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    public final Paint D;
    public final Rect E;
    public final Rect F;

    @Nullable
    public q0.a<ColorFilter, ColorFilter> G;

    public c(j jVar, d dVar) {
        super(jVar, dVar);
        this.D = new o0.a(3);
        this.E = new Rect();
        this.F = new Rect();
    }

    @Nullable
    public final Bitmap K() {
        return this.f16424n.x(this.f16425o.k());
    }

    @Override // v0.a, p0.e
    public void c(RectF rectF, Matrix matrix, boolean z10) {
        super.c(rectF, matrix, z10);
        Bitmap bitmapK = K();
        if (bitmapK != null) {
            rectF.set(0.0f, 0.0f, z0.h.e() * bitmapK.getWidth(), z0.h.e() * bitmapK.getHeight());
            this.f16423m.mapRect(rectF);
        }
    }

    @Override // v0.a, s0.g
    public <T> void f(T t10, @Nullable a1.j<T> jVar) {
        super.f(t10, jVar);
        if (t10 == o.E) {
            if (jVar == null) {
                this.G = null;
            } else {
                this.G = new p(jVar, null);
            }
        }
    }

    @Override // v0.a
    public void t(@NonNull Canvas canvas, Matrix matrix, int i10) {
        Bitmap bitmapK = K();
        if (bitmapK == null || bitmapK.isRecycled()) {
            return;
        }
        float fE = z0.h.e();
        this.D.setAlpha(i10);
        q0.a<ColorFilter, ColorFilter> aVar = this.G;
        if (aVar != null) {
            this.D.setColorFilter(aVar.h());
        }
        canvas.save();
        canvas.concat(matrix);
        this.E.set(0, 0, bitmapK.getWidth(), bitmapK.getHeight());
        this.F.set(0, 0, (int) (bitmapK.getWidth() * fE), (int) (bitmapK.getHeight() * fE));
        canvas.drawBitmap(bitmapK, this.E, this.F, this.D);
        canvas.restore();
    }
}
