package vc;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.transsion.hubsdk.graphics.TranCanvas;

/* JADX INFO: loaded from: classes2.dex */
public class a implements of.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16888b = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranCanvas f16889a = new TranCanvas();

    @Override // of.a
    public boolean a() {
        TranCanvas tranCanvas = this.f16889a;
        if (tranCanvas != null) {
            return tranCanvas.smoothcornerCubicEdgeEnabled();
        }
        return false;
    }

    @Override // of.a
    public boolean b(Canvas canvas, float f10, float f11, float f12, float f13, float f14, int i10) {
        TranCanvas tranCanvas = this.f16889a;
        if (tranCanvas != null) {
            return tranCanvas.clipRRect(canvas, f10, f11, f12, f13, f14, i10);
        }
        dc.e.c(f16888b, "cannot get core");
        return false;
    }

    @Override // of.a
    public void c(Canvas canvas, float f10, float f11, float f12, float f13, float f14, Paint paint) {
        TranCanvas tranCanvas = this.f16889a;
        if (tranCanvas != null) {
            tranCanvas.drawSmoothRoundRect(canvas, f10, f11, f12, f13, f14, paint);
        } else {
            dc.e.c(f16888b, "cannot get core");
        }
    }

    @Override // of.a
    public void d(Canvas canvas, float f10, float f11, float f12, float f13, float f14, int i10, Paint paint) {
        TranCanvas tranCanvas = this.f16889a;
        if (tranCanvas != null) {
            tranCanvas.drawSmoothRoundRect(canvas, f10, f11, f12, f13, f14, i10, paint);
        } else {
            dc.e.c(f16888b, "cannot get core");
        }
    }
}
