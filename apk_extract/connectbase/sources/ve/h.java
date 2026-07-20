package ve;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.Surface;
import b9.r;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.api.window.TranScreenshotHardwareBuffer;
import com.transsion.hubsdk.internal.policy.ITranKeyguardDismissCallback;
import com.transsion.hubsdk.view.ITranDisplayFoldListener;
import com.transsion.hubsdk.view.ITranSystemGestureExclusionListener;
import com.transsion.hubsdk.view.ITranWindowManager;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h implements ph.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f17028d = "h";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f17030b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f17031c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranWindowManager f17029a = ITranWindowManager.Stub.asInterface(TranServiceManager.getServiceIBinder("window"));

    public static class a extends ITranDisplayFoldListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vb.d.b f17032a;

        public a(vb.d.b bVar) {
            this.f17032a = bVar;
        }

        public void a(int i10, boolean z10) {
            vb.d.b bVar = this.f17032a;
            if (bVar != null) {
                bVar.a(i10, z10);
            }
        }
    }

    public static class b extends ITranSystemGestureExclusionListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vb.d.InterfaceC0450d f17033a;

        public b(vb.d.InterfaceC0450d interfaceC0450d) {
            this.f17033a = interfaceC0450d;
        }

        public void a(int i10, Region region, Region region2) {
            vb.d.InterfaceC0450d interfaceC0450d = this.f17033a;
            if (interfaceC0450d != null) {
                interfaceC0450d.a(i10, region, region2);
            }
        }
    }

    public static class c extends ITranKeyguardDismissCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vb.d.c f17034a;

        public c(vb.d.c cVar) {
            this.f17034a = cVar;
        }

        public void a() {
            vb.d.c cVar = this.f17034a;
            if (cVar != null) {
                cVar.b();
            }
        }

        public void b() {
            vb.d.c cVar = this.f17034a;
            if (cVar != null) {
                cVar.c();
            }
        }

        public void c() {
            vb.d.c cVar = this.f17034a;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    @Override // ph.c
    public void a(vb.d.InterfaceC0450d interfaceC0450d, int i10) {
        if (this.f17029a != null) {
            try {
                b bVar = new b(interfaceC0450d);
                this.f17030b = bVar;
                this.f17029a.registerSystemGestureExclusionListener(bVar, i10);
            } catch (RemoteException e10) {
                j7.b.a("registerSystemGestureExclusionListener fail:", e10, f17028d);
            }
        }
    }

    @Override // ph.c
    public int b() {
        return ((Integer) new zb.f().c(new zb.f.b() { // from class: ve.f
            @Override // zb.f.b
            public final Object run() {
                return this.f17025a.s();
            }
        }, "window")).intValue();
    }

    @Override // ph.c
    public void c(vb.d.b bVar) {
        if (this.f17029a != null) {
            a aVar = new a(bVar);
            this.f17031c = aVar;
            try {
                this.f17029a.registerDisplayFoldListener(aVar);
            } catch (RemoteException e10) {
                j7.b.a("registerDisplayFoldListener fail", e10, f17028d);
            }
        }
    }

    @Override // ph.c
    public void d(r rVar) {
    }

    @Override // ph.c
    public List<ComponentName> e(final int i10) {
        return (List) new zb.f().c(new zb.f.b() { // from class: ve.g
            @Override // zb.f.b
            public final Object run() {
                return this.f17026a.u(i10);
            }
        }, "window");
    }

    @Override // ph.c
    public void f(vb.d.c cVar, CharSequence charSequence) {
        if (this.f17029a != null) {
            try {
                this.f17029a.dismissKeyguard(new c(cVar), charSequence);
            } catch (RemoteException e10) {
                j7.b.a("dismissKeyguard fail", e10, f17028d);
            }
        }
    }

    @Override // ph.c
    public void g(vb.d.InterfaceC0450d interfaceC0450d, int i10) {
        b bVar;
        ITranWindowManager iTranWindowManager = this.f17029a;
        if (iTranWindowManager == null || (bVar = this.f17030b) == null) {
            return;
        }
        try {
            iTranWindowManager.unregisterSystemGestureExclusionListener(bVar, i10);
        } catch (RemoteException e10) {
            j7.b.a("registerSystemGestureExclusionListener fail:", e10, f17028d);
        }
    }

    @Override // ph.c
    public void h(Context context, int i10, IBinder iBinder, int i11, f9.c.d dVar) {
    }

    @Override // ph.c
    public void i(r rVar, Surface surface, vb.d.a aVar) {
    }

    @Override // ph.c
    public void j(vb.d.b bVar) {
        a aVar;
        ITranWindowManager iTranWindowManager = this.f17029a;
        if (iTranWindowManager == null || (aVar = this.f17031c) == null) {
            return;
        }
        try {
            iTranWindowManager.unregisterDisplayFoldListener(aVar);
        } catch (RemoteException e10) {
            j7.b.a("unregisterDisplayFoldListener fail", e10, f17028d);
        }
    }

    @Override // ph.c
    public int k(final int i10) {
        return ((Integer) new zb.f().c(new zb.f.b() { // from class: ve.e
            @Override // zb.f.b
            public final Object run() {
                return this.f17023a.t(i10);
            }
        }, "window")).intValue();
    }

    @Override // ph.c
    public void l(r rVar, Rect rect) {
    }

    @Override // ph.c
    public TranScreenshotHardwareBuffer m(final int i10, final Rect rect) {
        com.transsion.hubsdk.window.TranScreenshotHardwareBuffer tranScreenshotHardwareBuffer = (com.transsion.hubsdk.window.TranScreenshotHardwareBuffer) new zb.f().c(new zb.f.b() { // from class: ve.d
            @Override // zb.f.b
            public final Object run() {
                return this.f17020a.r(i10, rect);
            }
        }, "window");
        TranScreenshotHardwareBuffer tranScreenshotHardwareBuffer2 = new TranScreenshotHardwareBuffer();
        if (tranScreenshotHardwareBuffer == null) {
            dc.e.n(f17028d, "TranScreenshotHardwareBuffer is null");
            return tranScreenshotHardwareBuffer2;
        }
        tranScreenshotHardwareBuffer2.j(tranScreenshotHardwareBuffer.getHardwareBuffer());
        tranScreenshotHardwareBuffer2.g(tranScreenshotHardwareBuffer.getColorSpace());
        tranScreenshotHardwareBuffer2.i(tranScreenshotHardwareBuffer.containsSecureLayers());
        tranScreenshotHardwareBuffer2.h(tranScreenshotHardwareBuffer.containsHdrLayers());
        tranScreenshotHardwareBuffer2.f(tranScreenshotHardwareBuffer.asBitmap());
        dc.e.a(f17028d, "getBuffer mTranScreenshotHardwareBuffer:" + tranScreenshotHardwareBuffer2);
        return tranScreenshotHardwareBuffer2;
    }

    public final /* synthetic */ Object r(int i10, Rect rect) throws RemoteException {
        ITranWindowManager iTranWindowManager = this.f17029a;
        if (iTranWindowManager != null) {
            return iTranWindowManager.getBuffer(i10, rect);
        }
        return null;
    }

    public final /* synthetic */ Object s() throws RemoteException {
        ITranWindowManager iTranWindowManager = this.f17029a;
        if (iTranWindowManager != null) {
            return Integer.valueOf(iTranWindowManager.getDockedStackSide());
        }
        return 0;
    }

    public final /* synthetic */ Object t(int i10) throws RemoteException {
        ITranWindowManager iTranWindowManager = this.f17029a;
        if (iTranWindowManager != null) {
            return Integer.valueOf(iTranWindowManager.getInitialDisplayDensity(i10));
        }
        return -1;
    }

    public final /* synthetic */ Object u(int i10) throws RemoteException {
        ITranWindowManager iTranWindowManager = this.f17029a;
        if (iTranWindowManager != null) {
            return iTranWindowManager.notifyScreenshotListeners(i10);
        }
        return null;
    }
}
