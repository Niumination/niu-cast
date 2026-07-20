package re;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.SurfaceControl;
import android.view.View;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.view.ITranSurfaceControl;
import com.transsion.hubsdk.view.TranSurfaceControl;

/* JADX INFO: loaded from: classes2.dex */
public class h implements lh.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14471c = "h";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranSurfaceControl f14472a = ITranSurfaceControl.Stub.asInterface(TranServiceManager.getServiceIBinder("surface"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TranSurfaceControl f14473b;

    @Override // lh.h
    public boolean a() {
        return u().smoothcornerCubicEdgeEnabled();
    }

    @Override // lh.h
    public void b(String str, String str2) {
        ITranSurfaceControl iTranSurfaceControl = this.f14472a;
        if (iTranSurfaceControl != null) {
            try {
                iTranSurfaceControl.isRequestChangeScale(str, str2);
            } catch (RemoteException e10) {
                j7.b.a("isRequestChangeScale: e = ", e10, f14471c);
            }
        }
    }

    @Override // lh.h
    public void c(View view, float f10, float f11) {
        u().setTranSmoothCorner(view, f10, f11);
    }

    @Override // lh.h
    public Bitmap d(Rect rect) {
        ITranSurfaceControl iTranSurfaceControl = this.f14472a;
        if (iTranSurfaceControl == null) {
            return null;
        }
        try {
            return iTranSurfaceControl.captureDisplayAsBitmap(rect);
        } catch (RemoteException e10) {
            j7.b.a("captureDisplayAsBitmap: e = ", e10, f14471c);
            return null;
        }
    }

    @Override // lh.h
    public void e(SurfaceControl.Transaction transaction, IBinder iBinder) {
        u().setDefaultApplyToken(transaction, iBinder);
    }

    @Override // lh.h
    public void f(SurfaceControl.Transaction transaction, boolean z10) {
        u().apply(transaction, z10);
    }

    @Override // lh.h
    public SurfaceControl.Transaction g(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, SurfaceControl surfaceControl2, int i10) {
        return u().setRelativeLayer(transaction, surfaceControl, surfaceControl2, i10);
    }

    @Override // lh.h
    public IBinder h(SurfaceControl.Transaction transaction) {
        return u().getDefaultApplyToken(transaction);
    }

    @Override // lh.h
    public SurfaceControl.Transaction i(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, boolean z10) {
        return u().setMultiWindowLayer(transaction, surfaceControl, z10);
    }

    @Override // lh.h
    public SurfaceControl.Transaction j(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, float f10) {
        return u().setShadowRadius(transaction, surfaceControl, f10);
    }

    @Override // lh.h
    public SurfaceControl.Transaction k(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, Matrix matrix, float[] fArr) {
        return u().setMatrix(transaction, surfaceControl, matrix, fArr);
    }

    @Override // lh.h
    public IBinder l(long j10) {
        return null;
    }

    @Override // lh.h
    public boolean m(SurfaceControl surfaceControl) {
        return u().checkProtectedContent(surfaceControl);
    }

    @Override // lh.h
    public SurfaceControl n(String str, boolean z10, SurfaceControl surfaceControl, String str2) {
        return u().createSfWithContainerLayer(str, z10, surfaceControl, str2);
    }

    @Override // lh.h
    public SurfaceControl.Transaction o(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, Rect rect) {
        return u().setWindowCrop(transaction, surfaceControl, rect);
    }

    @Override // lh.h
    public SurfaceControl.Transaction p(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl) {
        return u().remove(transaction, surfaceControl);
    }

    @Override // lh.h
    public void q(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, float f10) {
        u().setSmoothCornerRadius(transaction, surfaceControl, f10);
    }

    @Override // lh.h
    public SurfaceControl r(String str, SurfaceControl surfaceControl, String str2) {
        return u().createSfWithEffectLayer(str, surfaceControl, str2);
    }

    @Override // lh.h
    public SurfaceControl.Transaction s(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, boolean z10) {
        return u().setTrustedOverlay(transaction, surfaceControl, z10);
    }

    @Override // lh.h
    public void t(View view, int i10, float f10, float[] fArr, float f11, float f12) {
        u().startVfxAnimation(view, i10, f10, fArr, f11, f12);
    }

    public final TranSurfaceControl u() {
        if (this.f14473b == null) {
            this.f14473b = new TranSurfaceControl();
        }
        return this.f14473b;
    }

    @VisibleForTesting
    public void v(ITranSurfaceControl iTranSurfaceControl) {
        this.f14472a = iTranSurfaceControl;
    }
}
