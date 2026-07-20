package f9;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.graphics.Region;
import android.hardware.HardwareBuffer;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.IDisplayFoldListener;
import android.view.IScrollCaptureCallbacks;
import android.view.IScrollCaptureConnection;
import android.view.IScrollCaptureResponseListener;
import android.view.ISystemGestureExclusionListener;
import android.view.IWindowManager;
import android.view.ScrollCaptureResponse;
import android.view.Surface;
import android.view.WindowManagerGlobal;
import b9.r;
import com.android.internal.policy.IKeyguardDismissCallback;
import com.transsion.hubsdk.api.window.TranScreenshotHardwareBuffer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ph.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5939d = "TranAospWindowManagerExt";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Class<?> f5940e = cc.a.a("android.view.IWindowManager$Stub");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Class<?> f5941f = cc.a.a("android.os.ServiceManager");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f5942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f5943b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f5944c;

    public class a extends IKeyguardDismissCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vb.d.c f5945a;

        public a(vb.d.c cVar) {
            this.f5945a = cVar;
        }

        public void a() throws RemoteException {
            vb.d.c cVar = this.f5945a;
            if (cVar != null) {
                cVar.b();
            }
        }

        public void b() throws RemoteException {
            vb.d.c cVar = this.f5945a;
            if (cVar != null) {
                cVar.c();
            }
        }

        public void c() throws RemoteException {
            vb.d.c cVar = this.f5945a;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    public class b extends IScrollCaptureResponseListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f5947a;

        public b(d dVar) {
            this.f5947a = dVar;
        }

        public void a(ScrollCaptureResponse scrollCaptureResponse) {
            r rVar = new r();
            rVar.f791a = scrollCaptureResponse.getDescription();
            rVar.f792b = scrollCaptureResponse.getConnection();
            rVar.f793c = scrollCaptureResponse.getWindowBounds();
            rVar.f794d = scrollCaptureResponse.getBoundsInWindow();
            rVar.f795e = scrollCaptureResponse.getWindowTitle();
            rVar.f796f = scrollCaptureResponse.getPackageName();
            rVar.f797g = scrollCaptureResponse.getMessages();
            this.f5947a.a(rVar);
        }
    }

    /* JADX INFO: renamed from: f9.c$c, reason: collision with other inner class name */
    public class C0142c extends IScrollCaptureCallbacks.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vb.d.a f5949a;

        public C0142c(vb.d.a aVar) {
            this.f5949a = aVar;
        }

        public void a() {
            vb.d.a aVar = this.f5949a;
            if (aVar != null) {
                aVar.a();
            }
        }

        public void b() {
            vb.d.a aVar = this.f5949a;
            if (aVar != null) {
                aVar.c();
            }
        }

        public void c(int i10, Rect rect) {
            vb.d.a aVar = this.f5949a;
            if (aVar != null) {
                aVar.b(i10, rect);
            }
        }
    }

    public interface d {
        void a(r rVar);
    }

    public static class e extends IDisplayFoldListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public vb.d.b f5951a;

        public e(vb.d.b bVar) {
            this.f5951a = bVar;
        }

        public void a(int i10, boolean z10) {
            vb.d.b bVar = this.f5951a;
            if (bVar != null) {
                bVar.a(i10, z10);
            }
        }
    }

    public class f extends ISystemGestureExclusionListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public vb.d.InterfaceC0450d f5952a;

        public f(vb.d.InterfaceC0450d interfaceC0450d) {
            this.f5952a = interfaceC0450d;
        }

        public void a(int i10, Region region, Region region2) {
            vb.d.InterfaceC0450d interfaceC0450d = this.f5952a;
            if (interfaceC0450d != null) {
                interfaceC0450d.a(i10, region, region2);
            }
        }
    }

    @Override // ph.c
    public void a(vb.d.InterfaceC0450d interfaceC0450d, int i10) {
        IWindowManager windowManagerService = WindowManagerGlobal.getWindowManagerService();
        try {
            f fVar = new f(interfaceC0450d);
            this.f5942a = fVar;
            windowManagerService.registerSystemGestureExclusionListener(fVar, i10);
        } catch (RemoteException e10) {
            j7.b.a("registerSystemGestureExclusionListener fail ", e10, f5939d);
        }
    }

    @Override // ph.c
    public int b() {
        Method methodG;
        if (n() == null || (methodG = cc.a.g(this.f5944c.getClass(), "getDockedStackSide", new Class[0])) == null) {
            return 0;
        }
        return ((Integer) cc.a.j(methodG, this.f5944c, new Object[0])).intValue();
    }

    @Override // ph.c
    public void c(vb.d.b bVar) {
        IWindowManager windowManagerService = WindowManagerGlobal.getWindowManagerService();
        try {
            e eVar = new e(bVar);
            this.f5943b = eVar;
            windowManagerService.registerDisplayFoldListener(eVar);
        } catch (RemoteException e10) {
            j7.b.a("registerDisplayFoldListener fail ", e10, f5939d);
        }
    }

    @Override // ph.c
    public void d(r rVar) {
        try {
            IScrollCaptureConnection iScrollCaptureConnection = rVar.f792b;
            if (iScrollCaptureConnection != null) {
                iScrollCaptureConnection.endCapture();
            }
        } catch (RemoteException e10) {
            j7.b.a("endCapture fail： ", e10, f5939d);
        }
    }

    @Override // ph.c
    public List<ComponentName> e(int i10) {
        ArrayList arrayList = new ArrayList();
        if (n() != null) {
            Object objJ = cc.a.j(cc.a.g(this.f5944c.getClass(), "notifyScreenshotListeners", Integer.TYPE), this.f5944c, Integer.valueOf(i10));
            if (objJ instanceof List) {
                Iterator it = ((List) objJ).iterator();
                while (it.hasNext()) {
                    arrayList.add((ComponentName) ComponentName.class.cast(it.next()));
                }
            }
        }
        return arrayList;
    }

    @Override // ph.c
    public void f(vb.d.c cVar, CharSequence charSequence) {
        try {
            WindowManagerGlobal.getWindowManagerService().dismissKeyguard(new a(cVar), charSequence);
        } catch (RemoteException e10) {
            j7.b.a("dismissKeyguard fail ", e10, f5939d);
        }
    }

    @Override // ph.c
    public void g(vb.d.InterfaceC0450d interfaceC0450d, int i10) {
        IWindowManager windowManagerService = WindowManagerGlobal.getWindowManagerService();
        f fVar = this.f5942a;
        if (fVar != null) {
            try {
                windowManagerService.unregisterSystemGestureExclusionListener(fVar, i10);
            } catch (RemoteException e10) {
                j7.b.a("unregisterSystemGestureExclusionListener fail ", e10, f5939d);
            }
        }
    }

    @Override // ph.c
    public void h(Context context, int i10, IBinder iBinder, int i11, d dVar) {
        try {
            WindowManagerGlobal.getWindowManagerService().requestScrollCapture(i10, iBinder, i11, new b(dVar));
        } catch (Exception e10) {
            dc.e.n(f5939d, "TranAospWindowManagerExt requestScrollCapture e = " + e10);
        }
    }

    @Override // ph.c
    public void i(r rVar, Surface surface, vb.d.a aVar) {
        IScrollCaptureConnection iScrollCaptureConnection = rVar.f792b;
        if (iScrollCaptureConnection == null) {
            return;
        }
        try {
            iScrollCaptureConnection.startCapture(surface, new C0142c(aVar));
        } catch (RemoteException e10) {
            j7.b.a("startCapture fail： ", e10, f5939d);
        }
    }

    @Override // ph.c
    public void j(vb.d.b bVar) {
        IWindowManager windowManagerService = WindowManagerGlobal.getWindowManagerService();
        e eVar = this.f5943b;
        if (eVar != null) {
            try {
                windowManagerService.unregisterDisplayFoldListener(eVar);
            } catch (RemoteException e10) {
                j7.b.a("unregisterDisplayFoldListener fail ", e10, f5939d);
            }
        }
    }

    @Override // ph.c
    public int k(int i10) {
        Object objJ = cc.a.j(cc.a.g(cc.a.a("android.view.IWindowManager"), "getInitialDisplayDensity", Integer.TYPE), cc.a.j(cc.a.g(cc.a.a("android.view.WindowManagerGlobal"), "getWindowManagerService", new Class[0]), null, new Object[0]), Integer.valueOf(i10));
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return -1;
    }

    @Override // ph.c
    public void l(r rVar, Rect rect) {
        try {
            IScrollCaptureConnection iScrollCaptureConnection = rVar.f792b;
            if (iScrollCaptureConnection != null) {
                iScrollCaptureConnection.requestImage(rect);
            }
        } catch (RemoteException e10) {
            j7.b.a("requestImage fail： ", e10, f5939d);
        }
    }

    @Override // ph.c
    public TranScreenshotHardwareBuffer m(int i10, Rect rect) {
        Object objJ;
        TranScreenshotHardwareBuffer tranScreenshotHardwareBuffer = new TranScreenshotHardwareBuffer();
        if (fc.a.b() || fc.a.a()) {
            dc.e.n(f5939d, "This interface is not supported.");
            return tranScreenshotHardwareBuffer;
        }
        try {
            Constructor declaredConstructor = cc.a.a("android.window.ScreenCapture$CaptureArgs$Builder").getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            Object objNewInstance = declaredConstructor.newInstance(null);
            cc.a.j(cc.a.g(objNewInstance.getClass(), "setSourceCrop", Rect.class), objNewInstance, rect);
            objJ = cc.a.j(cc.a.g(objNewInstance.getClass(), "build", new Class[0]), objNewInstance, new Object[0]);
        } catch (Exception e10) {
            p6.b.a("newInstance fail:", e10, f5939d);
            objJ = null;
        }
        Object objJ2 = cc.a.j(cc.a.g(cc.a.a("android.window.ScreenCapture"), "createSyncCaptureListener", new Class[0]), null, new Object[0]);
        Object objJ3 = cc.a.j(cc.a.g(cc.a.a("android.view.WindowManagerGlobal"), "getWindowManagerService", new Class[0]), null, new Object[0]);
        if (objJ3 != null) {
            cc.a.j(cc.a.g(objJ3.getClass(), "captureDisplay", Integer.TYPE, cc.a.a("android.window.ScreenCapture$CaptureArgs"), cc.a.a("android.window.ScreenCapture$ScreenCaptureListener")), objJ3, Integer.valueOf(i10), objJ, objJ2);
        }
        Object objJ4 = objJ2 != null ? cc.a.j(cc.a.g(objJ2.getClass(), "getBuffer", new Class[0]), objJ2, new Object[0]) : null;
        if (objJ4 != null) {
            Method methodG = cc.a.g(objJ4.getClass(), "getHardwareBuffer", new Class[0]);
            Method methodG2 = cc.a.g(objJ4.getClass(), "getColorSpace", new Class[0]);
            Method methodG3 = cc.a.g(objJ4.getClass(), "containsSecureLayers", new Class[0]);
            Method methodG4 = cc.a.g(objJ4.getClass(), "containsHdrLayers", new Class[0]);
            Method methodG5 = cc.a.g(objJ4.getClass(), "asBitmap", new Class[0]);
            Object objJ5 = cc.a.j(methodG, objJ4, new Object[0]);
            Object objJ6 = cc.a.j(methodG2, objJ4, new Object[0]);
            Object objJ7 = cc.a.j(methodG3, objJ4, new Object[0]);
            Object objJ8 = cc.a.j(methodG4, objJ4, new Object[0]);
            Object objJ9 = cc.a.j(methodG5, objJ4, new Object[0]);
            HardwareBuffer hardwareBuffer = objJ5 instanceof HardwareBuffer ? (HardwareBuffer) objJ5 : null;
            ColorSpace colorSpace = objJ6 instanceof ColorSpace ? (ColorSpace) objJ6 : null;
            boolean zBooleanValue = objJ7 instanceof Boolean ? ((Boolean) objJ7).booleanValue() : false;
            boolean zBooleanValue2 = objJ8 instanceof Boolean ? ((Boolean) objJ8).booleanValue() : false;
            Bitmap bitmap = objJ9 instanceof Bitmap ? (Bitmap) objJ9 : null;
            tranScreenshotHardwareBuffer.f2268a = hardwareBuffer;
            tranScreenshotHardwareBuffer.f2269b = colorSpace;
            tranScreenshotHardwareBuffer.f2270c = zBooleanValue;
            tranScreenshotHardwareBuffer.f2271d = zBooleanValue2;
            tranScreenshotHardwareBuffer.f2272e = bitmap;
        }
        return tranScreenshotHardwareBuffer;
    }

    public final Object n() {
        if (this.f5944c == null) {
            this.f5944c = cc.a.j(cc.a.g(f5940e, "asInterface", IBinder.class), f5940e, cc.a.j(cc.a.g(f5941f, "getService", String.class), f5941f, "window"));
        }
        return this.f5944c;
    }
}
