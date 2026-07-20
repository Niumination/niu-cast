package b9;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.IBinder;
import android.view.Display;
import android.view.SurfaceControl;
import android.view.SurfaceView;
import android.view.View;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class g implements lh.h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f765d = "g";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Class<?> f766e = cc.a.a("android.view.SurfaceControl$Transaction");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SurfaceView f768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DisplayManager f769c;

    public g() {
        Context contextA = bc.a.a();
        this.f767a = contextA;
        if (this.f769c == null) {
            this.f769c = (DisplayManager) contextA.getSystemService("display");
        }
    }

    @Override // lh.h
    public boolean a() {
        return false;
    }

    @Override // lh.h
    public void b(String str, String str2) {
        if (this.f768b == null) {
            this.f768b = new SurfaceView(this.f767a);
        }
        cc.a.j(cc.a.g(this.f768b.getClass(), "isRequestChangeScale", String.class, String.class), this.f768b, str, str2);
    }

    @Override // lh.h
    public void c(View view, float f10, float f11) {
        dc.e.a(f765d, "setTranSmoothCorner: " + view + " " + f10 + " " + f11);
    }

    @Override // lh.h
    public Bitmap d(Rect rect) {
        try {
            Display display = this.f769c.getDisplay(0);
            Object objJ = cc.a.j(cc.a.g(display.getClass(), "getAddress", new Class[0]), display, new Object[0]);
            Long l10 = (Long) cc.a.j(cc.a.g(objJ.getClass(), "getPhysicalDisplayId", new Class[0]), objJ, new Object[0]);
            l10.longValue();
            IBinder iBinder = (IBinder) cc.a.j(cc.a.g(SurfaceControl.class, "getPhysicalDisplayToken", Long.TYPE), null, l10);
            int iWidth = rect.width();
            int iHeight = rect.height();
            Object objNewInstance = Class.forName("android.view.SurfaceControl$DisplayCaptureArgs$Builder").getConstructor(IBinder.class).newInstance(iBinder);
            Object objJ2 = cc.a.j(cc.a.g(objNewInstance.getClass(), "setSourceCrop", Rect.class), objNewInstance, rect);
            Class<?> cls = objJ2.getClass();
            Class cls2 = Integer.TYPE;
            Object objJ3 = cc.a.j(cc.a.g(cls, "setSize", cls2, cls2), objJ2, Integer.valueOf(iWidth), Integer.valueOf(iHeight));
            Object objJ4 = cc.a.j(cc.a.g(SurfaceControl.class, "captureDisplay", Class.forName("android.view.SurfaceControl$DisplayCaptureArgs")), null, cc.a.j(cc.a.g(objJ3.getClass(), "build", new Class[0]), objJ3, new Object[0]));
            if (((Boolean) cc.a.j(cc.a.g(objJ4.getClass(), "containsSecureLayers", new Class[0]), objJ4, new Object[0])).booleanValue()) {
                return null;
            }
            return (Bitmap) cc.a.j(cc.a.g(objJ4.getClass(), "asBitmap", new Class[0]), objJ4, new Object[0]);
        } catch (Throwable th2) {
            dc.e.f(f765d, "captureDisplayAsBitmap failed: " + th2.getMessage());
            return null;
        }
    }

    @Override // lh.h
    public void e(SurfaceControl.Transaction transaction, IBinder iBinder) {
        Method methodG = cc.a.g(transaction.getClass(), "setDefaultApplyToken", IBinder.class);
        if (methodG != null) {
            cc.a.j(methodG, transaction, iBinder);
        }
    }

    @Override // lh.h
    public void f(SurfaceControl.Transaction transaction, boolean z10) {
        try {
            Method methodG = cc.a.g(f766e, "apply", Boolean.TYPE);
            methodG.setAccessible(true);
            methodG.invoke(transaction, Boolean.valueOf(z10));
        } catch (Throwable th2) {
            m7.a.a("apply fail ", th2, f765d);
        }
    }

    @Override // lh.h
    public SurfaceControl.Transaction g(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, SurfaceControl surfaceControl2, int i10) {
        try {
            Method methodG = cc.a.g(f766e, "setRelativeLayer", SurfaceControl.class, SurfaceControl.class, Integer.TYPE);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(transaction, surfaceControl, surfaceControl2, Integer.valueOf(i10));
            if (objInvoke == null || !(objInvoke instanceof SurfaceControl.Transaction)) {
                return null;
            }
            return (SurfaceControl.Transaction) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("setRelativeLayer fail ", th2, f765d);
            return null;
        }
    }

    @Override // lh.h
    public IBinder h(SurfaceControl.Transaction transaction) {
        Method methodG = cc.a.g(transaction.getClass(), "getDefaultApplyToken", new Class[0]);
        if (methodG != null) {
            return (IBinder) cc.a.j(methodG, transaction, new Object[0]);
        }
        return null;
    }

    @Override // lh.h
    public SurfaceControl.Transaction i(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, boolean z10) {
        try {
            Method methodG = cc.a.g(f766e, "setMultiWindowLayer", SurfaceControl.class, Boolean.TYPE);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(transaction, surfaceControl, Boolean.valueOf(z10));
            if (objInvoke == null || !(objInvoke instanceof SurfaceControl.Transaction)) {
                return null;
            }
            return (SurfaceControl.Transaction) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("setMultiWindowLayer fail ", th2, f765d);
            return null;
        }
    }

    @Override // lh.h
    public SurfaceControl.Transaction j(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, float f10) {
        try {
            Method methodG = cc.a.g(f766e, "setShadowRadius", SurfaceControl.class, Float.TYPE);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(transaction, surfaceControl, Float.valueOf(f10));
            if (objInvoke == null || !(objInvoke instanceof SurfaceControl.Transaction)) {
                return null;
            }
            return (SurfaceControl.Transaction) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("setWindowCrop fail ", th2, f765d);
            return null;
        }
    }

    @Override // lh.h
    public SurfaceControl.Transaction k(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, Matrix matrix, float[] fArr) {
        try {
            Method methodG = cc.a.g(f766e, "setMatrix", SurfaceControl.class, Matrix.class, float[].class);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(transaction, surfaceControl, matrix, fArr);
            if (objInvoke == null || !(objInvoke instanceof SurfaceControl.Transaction)) {
                return null;
            }
            return (SurfaceControl.Transaction) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("setMatrix fail ", th2, f765d);
            return null;
        }
    }

    @Override // lh.h
    public IBinder l(long j10) {
        try {
            Method methodG = cc.a.g(SurfaceControl.class, "getPhysicalDisplayToken", Long.TYPE);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, Long.valueOf(j10));
            if (objInvoke == null || !(objInvoke instanceof IBinder)) {
                return null;
            }
            return (IBinder) objInvoke;
        } catch (Throwable th2) {
            dc.e.f(f765d, "getPhysicalDisplayToken failed: " + th2.getMessage());
            return null;
        }
    }

    @Override // lh.h
    public boolean m(SurfaceControl surfaceControl) {
        Method methodG = cc.a.g(surfaceControl.getClass(), "checkProtectedContent", new Class[0]);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, surfaceControl, new Object[0])).booleanValue();
        }
        return false;
    }

    @Override // lh.h
    public SurfaceControl n(String str, boolean z10, SurfaceControl surfaceControl, String str2) {
        try {
            Class clsA = cc.a.a("android.view.SurfaceSession");
            Class clsA2 = cc.a.a("android.view.SurfaceControl$Builder");
            return (SurfaceControl) cc.a.j(cc.a.g(clsA2, "build", new Class[0]), cc.a.j(cc.a.g(clsA2, "setCallsite", String.class), cc.a.j(cc.a.g(clsA2, "setParent", SurfaceControl.class), cc.a.j(cc.a.g(clsA2, "setHidden", Boolean.TYPE), cc.a.j(cc.a.g(clsA2, "setName", String.class), cc.a.j(cc.a.g(clsA2, "setContainerLayer", new Class[0]), cc.a.c(clsA2, clsA.getClasses()).newInstance(null), new Object[0]), str), Boolean.valueOf(z10)), surfaceControl), str2), new Object[0]);
        } catch (Exception e10) {
            p6.b.a("getSurfaceControl fail:", e10, f765d);
            return null;
        }
    }

    @Override // lh.h
    public SurfaceControl.Transaction o(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, Rect rect) {
        try {
            Method methodG = cc.a.g(f766e, "setWindowCrop", SurfaceControl.class, Rect.class);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(transaction, surfaceControl, rect);
            if (objInvoke == null || !(objInvoke instanceof SurfaceControl.Transaction)) {
                return null;
            }
            return (SurfaceControl.Transaction) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("setWindowCrop fail ", th2, f765d);
            return null;
        }
    }

    @Override // lh.h
    public SurfaceControl.Transaction p(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl) {
        try {
            Method methodG = cc.a.g(f766e, "remove", SurfaceControl.class);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(transaction, surfaceControl);
            if (objInvoke == null || !(objInvoke instanceof SurfaceControl.Transaction)) {
                return null;
            }
            return (SurfaceControl.Transaction) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("remove fail ", th2, f765d);
            return null;
        }
    }

    @Override // lh.h
    public void q(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, float f10) {
        dc.e.a(f765d, "setSmoothCornerRadius: " + f10);
    }

    @Override // lh.h
    public SurfaceControl r(String str, SurfaceControl surfaceControl, String str2) {
        try {
            Class clsA = cc.a.a("android.view.SurfaceSession");
            Class clsA2 = cc.a.a("android.view.SurfaceControl$Builder");
            Object objJ = cc.a.j(cc.a.g(clsA2, "setCallsite", String.class), cc.a.j(cc.a.g(clsA2, "setName", String.class), cc.a.j(cc.a.g(clsA2, "setEffectLayer", new Class[0]), cc.a.c(clsA2, clsA.getClasses()).newInstance(null), new Object[0]), str), str2);
            Method methodG = cc.a.g(clsA2, "build", new Class[0]);
            return surfaceControl != null ? (SurfaceControl) cc.a.j(methodG, cc.a.j(cc.a.g(clsA2, "setParent", SurfaceControl.class), objJ, surfaceControl), new Object[0]) : (SurfaceControl) cc.a.j(methodG, objJ, new Object[0]);
        } catch (Exception e10) {
            p6.b.a("getSurfaceControl fail:", e10, f765d);
            return null;
        }
    }

    @Override // lh.h
    public SurfaceControl.Transaction s(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, boolean z10) {
        try {
            Method methodG = cc.a.g(f766e, "setTrustedOverlay", SurfaceControl.class, Boolean.TYPE);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(transaction, surfaceControl, Boolean.valueOf(z10));
            if (objInvoke == null || !(objInvoke instanceof SurfaceControl.Transaction)) {
                return null;
            }
            return (SurfaceControl.Transaction) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("setTrustedOverlay fail ", th2, f765d);
            return null;
        }
    }

    @Override // lh.h
    public void t(View view, int i10, float f10, float[] fArr, float f11, float f12) {
        dc.e.a(f765d, "startVfxAnimation: " + view + " " + i10);
    }
}
