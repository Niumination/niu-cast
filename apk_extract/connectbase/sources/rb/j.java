package rb;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.IBinder;
import android.view.SurfaceControl;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14397c = "j";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f14398d = 1.4f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public re.h f14399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b9.g f14400b;

    public void a(SurfaceControl.Transaction transaction, boolean z10) {
        if (transaction == null) {
            throw new IllegalArgumentException("Illegal parameter, transaction cannot be null");
        }
        h(fc.b.a.f5989i).f(transaction, z10);
    }

    public Bitmap b(Rect rect) {
        return h(fc.b.a.f5984d).d(rect);
    }

    public boolean c(SurfaceControl surfaceControl) {
        if (surfaceControl == null) {
            throw new IllegalArgumentException("surfaceControl should not be null");
        }
        if (fc.a.f()) {
            return h(fc.b.a.f6001u).m(surfaceControl);
        }
        return false;
    }

    public SurfaceControl d(String str, boolean z10, SurfaceControl surfaceControl, String str2) {
        if (str == null || surfaceControl == null) {
            throw new IllegalArgumentException("name or parent should not be null");
        }
        return h(fc.b.a.f5989i).n(str, z10, surfaceControl, str2);
    }

    public SurfaceControl e(String str, SurfaceControl surfaceControl, String str2) {
        if (str != null) {
            return h(fc.b.a.f5989i).r(str, surfaceControl, str2);
        }
        throw new IllegalArgumentException("name cannot be null");
    }

    public IBinder f(SurfaceControl.Transaction transaction) {
        if (!fc.a.f()) {
            return null;
        }
        if (transaction != null) {
            return h(fc.b.a.H).h(transaction);
        }
        throw new IllegalArgumentException("transaction should not be null");
    }

    public IBinder g(long j10) {
        return h(fc.b.a.f5988h).l(j10);
    }

    public lh.h h(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f14397c, "TranThubSurfaceControl");
            re.h hVar = this.f14399a;
            if (hVar != null) {
                return hVar;
            }
            re.h hVar2 = new re.h();
            this.f14399a = hVar2;
            return hVar2;
        }
        dc.e.f(f14397c, "TranAospSurfaceControl");
        b9.g gVar = this.f14400b;
        if (gVar != null) {
            return gVar;
        }
        b9.g gVar2 = new b9.g();
        this.f14400b = gVar2;
        return gVar2;
    }

    public void i(String str, String str2) {
        h(fc.b.a.f5985e).b(str, str2);
    }

    public SurfaceControl.Transaction j(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl) {
        if (transaction == null || surfaceControl == null) {
            throw new IllegalArgumentException("Illegal parameters with remove");
        }
        return h(fc.b.a.H).p(transaction, surfaceControl);
    }

    public void k(SurfaceControl.Transaction transaction, IBinder iBinder) {
        if (fc.a.f()) {
            if (transaction == null || iBinder == null) {
                throw new IllegalArgumentException("transaction or token should not be null");
            }
            h(fc.b.a.A).e(transaction, iBinder);
        }
    }

    public SurfaceControl.Transaction l(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, Matrix matrix, float[] fArr) {
        if (transaction == null || surfaceControl == null || matrix == null || fArr == null) {
            throw new IllegalArgumentException("Illegal parameters with setMatrix");
        }
        return h(fc.b.a.f5989i).k(transaction, surfaceControl, matrix, fArr);
    }

    public SurfaceControl.Transaction m(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, boolean z10) {
        if (transaction == null || surfaceControl == null) {
            throw new IllegalArgumentException("Illegal parameters with setMultiWindowLayer, params cannot be null");
        }
        return h(fc.b.a.f5988h).i(transaction, surfaceControl, z10);
    }

    public SurfaceControl.Transaction n(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, SurfaceControl surfaceControl2, int i10) {
        if (transaction == null || surfaceControl == null || surfaceControl2 == null) {
            throw new IllegalArgumentException("Illegal parameters, params should not be null");
        }
        return h(fc.b.a.f5988h).g(transaction, surfaceControl, surfaceControl2, i10);
    }

    public SurfaceControl.Transaction o(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, float f10) {
        if (transaction == null || surfaceControl == null) {
            throw new IllegalArgumentException("illegal setShadowRadius parameters, params cannot be null");
        }
        return h(fc.b.a.f5989i).j(transaction, surfaceControl, f10);
    }

    public void p(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, float f10) {
        if (surfaceControl == null) {
            throw new IllegalArgumentException("Illegal parameters with setSmoothCornerRadius surfaceControl == null");
        }
        h(fc.b.a.F).q(transaction, surfaceControl, f10 * 1.4f);
    }

    public void q(View view, float f10, float f11) {
        if (view == null) {
            throw new IllegalArgumentException("Illegal parameters with setTranSmoothCorner view == null");
        }
        h(fc.b.a.C).c(view, f10, f11);
    }

    public SurfaceControl.Transaction r(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, boolean z10) {
        if (transaction == null || surfaceControl == null) {
            throw new IllegalArgumentException("Illegal setTrustedOverlay parameters");
        }
        return h(fc.b.a.f5988h).s(transaction, surfaceControl, z10);
    }

    public SurfaceControl.Transaction s(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, Rect rect) {
        if (transaction == null || surfaceControl == null || rect == null) {
            throw new IllegalArgumentException("illegal parameters with setWindowCrop");
        }
        return h(fc.b.a.f5989i).o(transaction, surfaceControl, rect);
    }

    public boolean t() {
        return h(fc.b.a.G).a();
    }

    public void u(View view, int i10, float f10, float[] fArr, float f11, float f12) {
        if (view == null || fArr.length < 2) {
            throw new IllegalArgumentException("Illegal parameters with startVfxAnimation view == null");
        }
        h(fc.b.a.C).t(view, i10, f10, fArr, f11, f12);
    }
}
