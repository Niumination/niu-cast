package lh;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.IBinder;
import android.view.SurfaceControl;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public interface h {
    boolean a();

    void b(String str, String str2);

    void c(View view, float f10, float f11);

    Bitmap d(Rect rect);

    void e(SurfaceControl.Transaction transaction, IBinder iBinder);

    void f(SurfaceControl.Transaction transaction, boolean z10);

    SurfaceControl.Transaction g(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, SurfaceControl surfaceControl2, int i10);

    IBinder h(SurfaceControl.Transaction transaction);

    SurfaceControl.Transaction i(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, boolean z10);

    SurfaceControl.Transaction j(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, float f10);

    SurfaceControl.Transaction k(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, Matrix matrix, float[] fArr);

    IBinder l(long j10);

    boolean m(SurfaceControl surfaceControl);

    SurfaceControl n(String str, boolean z10, SurfaceControl surfaceControl, String str2);

    SurfaceControl.Transaction o(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, Rect rect);

    SurfaceControl.Transaction p(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl);

    void q(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, float f10);

    SurfaceControl r(String str, SurfaceControl surfaceControl, String str2);

    SurfaceControl.Transaction s(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, boolean z10);

    void t(View view, int i10, float f10, float[] fArr, float f11, float f12);
}
