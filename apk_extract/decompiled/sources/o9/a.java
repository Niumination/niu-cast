package o9;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.transsion.hubsdk.graphics.TranCanvas;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements z9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TranCanvas f8415a = new TranCanvas();

    @Override // z9.a
    public final boolean a(Canvas canvas, float f, float f4, float f10, int i8) {
        TranCanvas tranCanvas = this.f8415a;
        if (tranCanvas != null) {
            return tranCanvas.clipRRect(canvas, 0.0f, 0.0f, f, f4, f10, i8);
        }
        j9.a.b("a", "cannot get core");
        return false;
    }

    @Override // z9.a
    public final boolean c() {
        TranCanvas tranCanvas = this.f8415a;
        if (tranCanvas != null) {
            return tranCanvas.smoothcornerCubicEdgeEnabled();
        }
        return false;
    }

    @Override // z9.a
    public final void g(Canvas canvas, float f, float f4, float f10, float f11, float f12, Paint paint) {
        TranCanvas tranCanvas = this.f8415a;
        if (tranCanvas != null) {
            tranCanvas.drawSmoothRoundRect(canvas, f, f4, f10, f11, f12, paint);
        } else {
            j9.a.b("a", "cannot get core");
        }
    }
}
