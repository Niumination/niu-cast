package f9;

import android.graphics.Rect;
import android.view.SurfaceControl;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class b implements ph.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5938a = "TranAospScreenCapture";

    @Override // ph.b
    public boolean a(Object obj) {
        Boolean bool;
        Method methodG = cc.a.g(obj.getClass(), "containsSecureLayers", new Class[0]);
        if (methodG == null || (bool = (Boolean) cc.a.j(methodG, obj, new Object[0])) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // ph.b
    public Object b(SurfaceControl surfaceControl, Rect rect) {
        try {
            Class clsA = cc.a.a("android.window.ScreenCapture$LayerCaptureArgs$Builder");
            Object objNewInstance = clsA.getConstructor(SurfaceControl.class).newInstance(surfaceControl);
            Class cls = Boolean.TYPE;
            Method methodG = cc.a.g(clsA, "setCaptureSecureLayers", cls);
            Method methodG2 = cc.a.g(clsA, "setAllowProtected", cls);
            Method methodG3 = cc.a.g(clsA, "setSourceCrop", Rect.class);
            Method methodG4 = cc.a.g(clsA, "build", new Class[0]);
            Boolean bool = Boolean.TRUE;
            cc.a.j(methodG, objNewInstance, bool);
            cc.a.j(methodG2, objNewInstance, bool);
            cc.a.j(methodG3, objNewInstance, rect);
            Object objJ = cc.a.j(methodG4, objNewInstance, new Object[0]);
            return cc.a.j(cc.a.g(cc.a.a("android.window.ScreenCapture"), "captureLayers", objJ.getClass()), null, objJ);
        } catch (Exception e10) {
            p6.b.a("getCaptureArgs error: ", e10, f5938a);
            return null;
        }
    }
}
