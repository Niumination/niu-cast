package d7;

import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.os.IBinder;
import android.view.Display;
import android.view.SurfaceControl;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class b implements of.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3618a = "TranAospGraphicBuffer";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f3619b = cc.a.a("android.view.SurfaceControl$DisplayCaptureArgs$Builder");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f3620c = cc.a.a("android.view.SurfaceControl$DisplayCaptureArgs");

    @Override // of.b
    public u9.b a(SurfaceControl surfaceControl, Rect rect) {
        u9.b bVar = new u9.b();
        try {
            if (!fc.a.f()) {
                return bVar;
            }
            Object objNewInstance = cc.a.a("android.window.ScreenCapture$LayerCaptureArgs$Builder").getConstructor(SurfaceControl.class).newInstance(surfaceControl);
            Class<?> cls = objNewInstance.getClass();
            Class cls2 = Boolean.TYPE;
            Method methodG = cc.a.g(cls, "setCaptureSecureLayers", cls2);
            Boolean bool = Boolean.TRUE;
            Object objJ = cc.a.j(cc.a.g(cc.a.a("android.window.ScreenCapture"), "captureLayers", cc.a.a("android.window.ScreenCapture$LayerCaptureArgs")), null, cc.a.j(cc.a.g(objNewInstance.getClass(), "build", new Class[0]), cc.a.j(cc.a.g(objNewInstance.getClass(), "setSourceCrop", Rect.class), cc.a.j(cc.a.g(objNewInstance.getClass(), "setAllowProtected", cls2), cc.a.j(methodG, objNewInstance, bool), bool), new Rect(0, 0, rect.width(), rect.height())), new Object[0]));
            return c(cc.a.j(cc.a.g(objJ.getClass(), "getHardwareBuffer", new Class[0]), objJ, new Object[0]));
        } catch (Exception e10) {
            dc.e.a(f3618a, "createFromHardwareBuffer fail:" + e10);
            return bVar;
        }
    }

    @Override // of.b
    public u9.b b(Display display, int i10, int i11) {
        u9.b bVar = new u9.b();
        try {
            if (!fc.a.d() && !fc.a.b()) {
                return bVar;
            }
            Object objJ = cc.a.j(cc.a.g(display.getClass(), "getAddress", new Class[0]), display, new Object[0]);
            Object objNewInstance = f3619b.getConstructor(IBinder.class).newInstance(cc.a.j(cc.a.g(SurfaceControl.class, "getPhysicalDisplayToken", Long.TYPE), null, (Long) cc.a.j(cc.a.g(objJ.getClass(), "getPhysicalDisplayId", new Class[0]), objJ, new Object[0])));
            Object objJ2 = cc.a.j(cc.a.g(objNewInstance.getClass(), "setSourceCrop", Rect.class), objNewInstance, new Rect(0, 0, i10, i11));
            Class<?> cls = objNewInstance.getClass();
            Class cls2 = Integer.TYPE;
            Object objJ3 = cc.a.j(cc.a.g(SurfaceControl.class, "captureDisplay", f3620c), null, cc.a.j(cc.a.g(objNewInstance.getClass(), "build", new Class[0]), cc.a.j(cc.a.g(cls, "setSize", cls2, cls2), objJ2, Integer.valueOf(i10), Integer.valueOf(i11)), new Object[0]));
            return c(cc.a.j(cc.a.g(objJ3.getClass(), "getHardwareBuffer", new Class[0]), objJ3, new Object[0]));
        } catch (Exception e10) {
            dc.e.a(f3618a, "createFromHardwareBuffer fail:" + e10);
            return bVar;
        }
    }

    public final u9.b c(Object obj) {
        Object objJ = cc.a.j(cc.a.g(cc.a.a("android.graphics.GraphicBuffer"), "createFromHardwareBuffer", HardwareBuffer.class), null, obj);
        u9.b bVar = new u9.b();
        if (objJ != null) {
            Method methodG = cc.a.g(objJ.getClass(), "getWidth", new Class[0]);
            Method methodG2 = cc.a.g(objJ.getClass(), "getHeight", new Class[0]);
            int iIntValue = ((Integer) cc.a.j(methodG, objJ, new Object[0])).intValue();
            int iIntValue2 = ((Integer) cc.a.j(methodG2, objJ, new Object[0])).intValue();
            bVar.f16218a = iIntValue;
            bVar.f16219b = iIntValue2;
        }
        return bVar;
    }
}
