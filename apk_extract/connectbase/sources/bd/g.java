package bd;

import android.graphics.Region;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.InputEvent;
import android.view.KeyEvent;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.hardware.input.ITranInputManager;
import com.transsion.hubsdk.hardware.input.TranInputManager;
import com.transsion.hubsdk.view.ITranInputMonitor;
import com.transsion.hubsdk.view.ITranTouchEventHandler;
import com.transsion.hubsdk.view.inputmethod.ITranStylusKeyListener;

/* JADX INFO: loaded from: classes2.dex */
public class g implements uf.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f827e = "g";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranInputManager f828a = ITranInputManager.Stub.asInterface(TranServiceManager.getServiceIBinder("input"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ITranInputMonitor f829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public rb.b f830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TranInputManager f831d;

    public class a extends rb.a.b {
        public a() {
        }

        @Override // rb.a
        public void dispose() throws RemoteException {
            if (g.this.f829b != null) {
                g.this.f829b.dispose();
            }
        }

        @Override // rb.a
        public void z() throws RemoteException {
            if (g.this.f829b != null) {
                g.this.f829b.pilferPointers();
            }
        }
    }

    public class b extends ITranStylusKeyListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public sb.b f833a;

        public b(sb.b bVar) {
            this.f833a = bVar;
        }

        public void a(int i10, KeyEvent keyEvent) throws RemoteException {
            sb.b bVar = this.f833a;
            if (bVar != null) {
                bVar.a(i10, keyEvent);
            }
        }
    }

    public class c extends ITranTouchEventHandler.Stub {
        public c() {
        }

        public void a(InputEvent inputEvent) throws RemoteException {
            if (g.this.f830c != null) {
                g.this.f830c.m(inputEvent);
            }
        }
    }

    @Override // uf.a
    public void a(final KeyEvent keyEvent) {
        new zb.f().c(new zb.f.b() { // from class: bd.e
            @Override // zb.f.b
            public final Object run() {
                return this.f823a.u(keyEvent);
            }
        }, "input");
    }

    @Override // uf.a
    public void b(final sb.b bVar) {
        new zb.f().c(new zb.f.b() { // from class: bd.f
            @Override // zb.f.b
            public final Object run() {
                return this.f825a.r(bVar);
            }
        }, "input_method_service");
        dc.e.a(f827e, "registerStylusKeyListener sucess");
    }

    @Override // uf.a
    public boolean c(InputEvent inputEvent, int i10) {
        return q().injectInputEvent(inputEvent, i10);
    }

    @Override // uf.a
    public rb.a d(String str, int i10, rb.b bVar) {
        if (this.f828a != null) {
            try {
                this.f830c = bVar;
                ITranInputMonitor iTranInputMonitorMonitorGestureInput = this.f828a.monitorGestureInput(str, i10, bVar != null ? new c() : null);
                this.f829b = iTranInputMonitorMonitorGestureInput;
                if (iTranInputMonitorMonitorGestureInput != null) {
                    return new a();
                }
            } catch (RemoteException e10) {
                j7.b.a("monitorGestureInput:", e10, f827e);
            }
        }
        return null;
    }

    @Override // uf.a
    public void e(final IBinder iBinder, final Region region) {
        if (fc.a.g()) {
            new zb.f().c(new zb.f.b() { // from class: bd.b
                @Override // zb.f.b
                public final Object run() {
                    return this.f816a.w(iBinder, region);
                }
            }, "input");
        }
    }

    @Override // uf.a
    public void f(final sb.b bVar) {
        new zb.f().c(new zb.f.b() { // from class: bd.c
            @Override // zb.f.b
            public final Object run() {
                return this.f819a.v(bVar);
            }
        }, "input_method_service");
        dc.e.a(f827e, "unregisterStylusKeyListener sucess");
    }

    @Override // uf.a
    public void g(final IBinder iBinder, final boolean z10) {
        if (fc.a.g()) {
            new zb.f().c(new zb.f.b() { // from class: bd.a
                @Override // zb.f.b
                public final Object run() {
                    return this.f813a.t(iBinder, z10);
                }
            }, "input");
        }
    }

    @Override // uf.a
    public void h(final boolean z10) {
        if (fc.a.g()) {
            new zb.f().c(new zb.f.b() { // from class: bd.d
                @Override // zb.f.b
                public final Object run() {
                    return this.f821a.s(z10);
                }
            }, "input");
        }
    }

    public final TranInputManager q() {
        if (this.f831d == null) {
            this.f831d = new TranInputManager();
        }
        return this.f831d;
    }

    public final /* synthetic */ Object r(sb.b bVar) throws RemoteException {
        ITranInputManager iTranInputManager = this.f828a;
        if (iTranInputManager == null) {
            return null;
        }
        iTranInputManager.registerStylusKeyListener(new b(bVar));
        return null;
    }

    public final /* synthetic */ Object s(boolean z10) throws RemoteException {
        ITranInputManager iTranInputManager = this.f828a;
        if (iTranInputManager == null) {
            return null;
        }
        iTranInputManager.setBackGestureMode(z10);
        return null;
    }

    public final /* synthetic */ Object t(IBinder iBinder, boolean z10) throws RemoteException {
        ITranInputManager iTranInputManager = this.f828a;
        if (iTranInputManager == null) {
            return null;
        }
        iTranInputManager.setBackGestureResult(iBinder, z10);
        return null;
    }

    public final /* synthetic */ Object u(KeyEvent keyEvent) throws RemoteException {
        ITranInputManager iTranInputManager = this.f828a;
        if (iTranInputManager == null) {
            return null;
        }
        iTranInputManager.singleKeyPanicBehaviorCheck(keyEvent);
        return null;
    }

    public final /* synthetic */ Object v(sb.b bVar) throws RemoteException {
        ITranInputManager iTranInputManager = this.f828a;
        if (iTranInputManager == null) {
            return null;
        }
        iTranInputManager.unregisterStylusKeyListener(new b(bVar));
        return null;
    }

    public final /* synthetic */ Object w(IBinder iBinder, Region region) throws RemoteException {
        ITranInputManager iTranInputManager = this.f828a;
        if (iTranInputManager == null) {
            return null;
        }
        iTranInputManager.updateBackGestureRegion(iBinder, region);
        return null;
    }

    @VisibleForTesting
    public void x(ITranInputManager iTranInputManager) {
        this.f828a = iTranInputManager;
    }
}
