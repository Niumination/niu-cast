package d7;

import android.graphics.Canvas;
import android.graphics.Paint;
import ks.g;

/* JADX INFO: loaded from: classes2.dex */
public class a implements of.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3617a = "a";

    @Override // of.a
    public boolean a() {
        return false;
    }

    @Override // of.a
    public boolean b(Canvas canvas, float f10, float f11, float f12, float f13, float f14, int i10) {
        return false;
    }

    @Override // of.a
    public void c(Canvas canvas, float f10, float f11, float f12, float f13, float f14, Paint paint) {
        dc.e.n(f3617a, "aosp not support drawSmoothRoundRect [" + f10 + g.f9491d + f11 + ", " + f12 + ", " + f13 + "], radius=" + f14);
    }

    @Override // of.a
    public void d(Canvas canvas, float f10, float f11, float f12, float f13, float f14, int i10, Paint paint) {
        dc.e.n(f3617a, "aosp not support drawSmoothRoundRect [" + f10 + g.f9491d + f11 + ", " + f12 + ", " + f13 + "], cornerFlags=" + i10 + ", radius=" + f14);
    }
}
