package yc;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.ArrayMap;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.hardware.display.ITranDisplayManager;
import com.transsion.hubsdk.hardware.display.ITranDisplayManagerCallback;
import com.transsion.hubsdk.hardware.display.ITranFlexButtonCallback;
import com.transsion.hubsdk.hardware.display.ITranPowerStateChangedCallback;
import com.transsion.hubsdk.hardware.display.ITranSmartButtonCallback;
import com.transsion.hubsdk.hardware.display.ITranTentModeCallback;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class j implements rf.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f20793g = "j";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static j f20794h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f20795i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f20796j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f20797k = 4;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f20798l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f20799m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f20800n = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f20803c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20802b = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f20804d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<c> f20805e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayMap<String, h> f20806f = new ArrayMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranDisplayManager f20801a = ITranDisplayManager.Stub.asInterface(TranServiceManager.getServiceIBinder("display"));

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public static final class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x9.b.a f20807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f20808b;

        public c(x9.b.a aVar, @gm.i Looper looper, long j10) {
            super(looper);
            this.f20807a = aVar;
            this.f20808b = j10;
        }

        public void a() {
            removeCallbacksAndMessages(null);
        }

        public void b(int i10, int i11) {
            sendMessage(obtainMessage(i11, i10, 0));
        }

        public synchronized void c(long j10) {
            this.f20808b = j10;
        }

        @Override // android.os.Handler
        public synchronized void handleMessage(Message message) {
            try {
                int i10 = message.what;
                if (i10 != 1) {
                    if (i10 == 3 && (this.f20808b & 2) != 0) {
                        this.f20807a.onDisplayRemoved(message.arg1);
                    }
                } else if ((this.f20808b & 1) != 0) {
                    this.f20807a.onDisplayAdded(message.arg1);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final class d extends ITranDisplayManagerCallback.Stub {
        public d() {
        }

        public void a(int i10, int i11) {
            dc.e.a(j.f20793g, "onDualDisplayEvent: displayId=" + i10 + ", event=" + i11);
            j.this.K(i10, i11);
        }
    }

    public class e extends ITranFlexButtonCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public x9.b.InterfaceC0500b f20810a;

        public e(x9.b.InterfaceC0500b interfaceC0500b) {
            this.f20810a = interfaceC0500b;
        }

        public void a() {
            x9.b.InterfaceC0500b interfaceC0500b = this.f20810a;
            if (interfaceC0500b != null) {
                interfaceC0500b.a();
            }
        }

        public void b() {
            x9.b.InterfaceC0500b interfaceC0500b = this.f20810a;
            if (interfaceC0500b != null) {
                interfaceC0500b.b();
            }
        }
    }

    public class f extends ITranSmartButtonCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public x9.b.c f20812a;

        public f(x9.b.c cVar) {
            this.f20812a = cVar;
        }

        public void a() {
            x9.b.c cVar = this.f20812a;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    public class g extends ITranTentModeCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public x9.b.d f20814a;

        public g(x9.b.d dVar) {
            this.f20814a = dVar;
        }

        public void a(int i10) {
            x9.b.d dVar = this.f20814a;
            if (dVar != null) {
                dVar.a(i10);
            }
        }
    }

    public class h extends ITranPowerStateChangedCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public x9.b.e f20816a;

        public h(x9.b.e eVar) {
            this.f20816a = eVar;
        }

        public void a(int i10) throws RemoteException {
            x9.b.e eVar = this.f20816a;
            if (eVar != null) {
                eVar.a(i10);
            }
        }

        public void b(int i10, float f10) throws RemoteException {
            x9.b.e eVar = this.f20816a;
            if (eVar != null) {
                eVar.b(i10, f10);
            }
        }
    }

    public static /* synthetic */ h B(j jVar, x9.b.e eVar, String str) {
        jVar.getClass();
        return jVar.new h(eVar);
    }

    public static synchronized j I() {
        try {
            if (f20794h == null) {
                f20794h = new j();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f20794h;
    }

    public static Looper J(@gm.j Handler handler) {
        Looper looper = handler != null ? handler.getLooper() : Looper.myLooper();
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        if (looper != null) {
            return looper;
        }
        throw new IllegalArgumentException("Could not get Looper for the UI thread.");
    }

    public final int H(x9.b.a aVar) {
        int size = this.f20805e.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f20805e.get(i10).f20807a == aVar) {
                return i10;
            }
        }
        return -1;
    }

    public void K(int i10, int i11) {
        synchronized (this.f20802b) {
            try {
                int size = this.f20805e.size();
                for (int i12 = 0; i12 < size; i12++) {
                    this.f20805e.get(i12).b(i10, i11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final /* synthetic */ Object L() throws RemoteException {
        ITranDisplayManager iTranDisplayManager = this.f20801a;
        if (iTranDisplayManager == null) {
            return null;
        }
        iTranDisplayManager.closeDualDisplayForSelfie();
        return null;
    }

    public final /* synthetic */ Object M() throws RemoteException {
        ITranDisplayManager iTranDisplayManager = this.f20801a;
        if (iTranDisplayManager != null) {
            return Integer.valueOf(iTranDisplayManager.getCurSelfieDisplayId());
        }
        return 0;
    }

    public final /* synthetic */ Object N() throws RemoteException {
        ITranDisplayManager iTranDisplayManager = this.f20801a;
        if (iTranDisplayManager != null) {
            return Integer.valueOf(iTranDisplayManager.getForcedUsingDisplayMode());
        }
        return 0;
    }

    public final /* synthetic */ Object O() throws RemoteException {
        ITranDisplayManager iTranDisplayManager = this.f20801a;
        if (iTranDisplayManager != null) {
            return Integer.valueOf(iTranDisplayManager.getSourceConnectFlag());
        }
        return 0;
    }

    public final /* synthetic */ Object P() throws RemoteException {
        ITranDisplayManager iTranDisplayManager = this.f20801a;
        return iTranDisplayManager != null ? Boolean.valueOf(iTranDisplayManager.isDualDisplayForSelfie()) : Boolean.FALSE;
    }

    public final /* synthetic */ Object Q(Bundle bundle) throws RemoteException {
        ITranDisplayManager iTranDisplayManager = this.f20801a;
        if (iTranDisplayManager == null) {
            return null;
        }
        iTranDisplayManager.openDualDisplayForSelfie(bundle);
        return null;
    }

    public final /* synthetic */ h R(x9.b.e eVar, String str) {
        return new h(eVar);
    }

    public final /* synthetic */ Object S(int i10, boolean z10, String str) throws RemoteException {
        ITranDisplayManager iTranDisplayManager = this.f20801a;
        if (iTranDisplayManager == null) {
            return null;
        }
        iTranDisplayManager.setTranAutoBrightnessTemporarily(i10, z10, str);
        return null;
    }

    public final void T() {
        if (this.f20803c == null) {
            this.f20803c = new d();
            V();
        }
    }

    @VisibleForTesting
    public void U(ITranDisplayManager iTranDisplayManager) {
        this.f20801a = iTranDisplayManager;
    }

    public final void V() {
        int size = this.f20805e.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = (int) (((long) i10) | this.f20805e.get(i11).f20808b);
        }
        long j10 = i10;
        if (j10 != this.f20804d) {
            try {
                this.f20801a.registerDualCallbackWithEventMask(this.f20803c, j10);
                this.f20804d = j10;
            } catch (RemoteException e10) {
                throw e10.rethrowFromSystemServer();
            }
        }
    }

    @Override // rf.b
    public void a(int i10, x9.b.InterfaceC0500b interfaceC0500b) {
        if (fc.a.f() && this.f20801a != null) {
            try {
                this.f20801a.registerFlexButtonCallback(new e(interfaceC0500b), i10);
            } catch (RemoteException unused) {
                dc.e.a(f20793g, "registerFlexButtonCallback fail");
            }
        }
    }

    @Override // rf.b
    public boolean b() {
        ITranDisplayManager iTranDisplayManager;
        if (!fc.a.f() || (iTranDisplayManager = this.f20801a) == null) {
            return false;
        }
        try {
            return iTranDisplayManager.isTentMode();
        } catch (RemoteException e10) {
            throw e10.rethrowFromSystemServer();
        }
    }

    @Override // rf.b
    public void c() {
        new zb.f().c(new zb.f.b() { // from class: yc.g
            @Override // zb.f.b
            public final Object run() {
                return this.f20789a.L();
            }
        }, "display");
    }

    @Override // rf.b
    public void d(int i10, x9.b.d dVar) {
        if (fc.a.f() && this.f20801a != null) {
            try {
                this.f20801a.registerTentModeCallback(new g(dVar), i10);
            } catch (RemoteException e10) {
                throw e10.rethrowFromSystemServer();
            }
        }
    }

    @Override // rf.b
    public void e(final int i10, final boolean z10, final String str) {
        new zb.f().c(new zb.f.b() { // from class: yc.e
            @Override // zb.f.b
            public final Object run() {
                return this.f20783a.S(i10, z10, str);
            }
        }, "display");
    }

    @Override // rf.b
    public void f(int i10) {
        ITranDisplayManager iTranDisplayManager;
        if (fc.a.f() && (iTranDisplayManager = this.f20801a) != null) {
            try {
                iTranDisplayManager.unregisterFlexButtonCallback(i10);
            } catch (RemoteException unused) {
                dc.e.a(f20793g, "unregisterFlexButtonCallback fail");
            }
        }
    }

    @Override // rf.b
    public void g(int i10, float f10) {
        try {
            this.f20801a.setBrightness(i10, f10);
        } catch (RemoteException e10) {
            j7.b.a("setBrightness : e = ", e10, f20793g);
        }
    }

    @Override // rf.b
    public int h() {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: yc.c
            @Override // zb.f.b
            public final Object run() {
                return this.f20781a.M();
            }
        }, "display")).intValue();
        dc.e.f(f20793g, "getCurSelfieDisplayId");
        return iIntValue;
    }

    @Override // rf.b
    public void i() {
        ITranDisplayManager iTranDisplayManager;
        if (fc.a.d() || (iTranDisplayManager = this.f20801a) == null) {
            return;
        }
        try {
            iTranDisplayManager.closeDualDisplay();
        } catch (RemoteException e10) {
            throw e10.rethrowFromSystemServer();
        }
    }

    @Override // rf.b
    public void j(@gm.i x9.b.a aVar, @gm.j Handler handler) {
        if (fc.a.d() || this.f20801a == null) {
            return;
        }
        if (aVar == null) {
            throw new IllegalArgumentException("listener must not be null");
        }
        synchronized (this.f20802b) {
            try {
                int iH = H(aVar);
                if (iH < 0) {
                    this.f20805e.add(new c(aVar, J(handler), 7L));
                    T();
                } else {
                    this.f20805e.get(iH).c(7L);
                }
                V();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // rf.b
    public int k() {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: yc.d
            @Override // zb.f.b
            public final Object run() {
                return this.f20782a.N();
            }
        }, "display")).intValue();
        dc.e.f(f20793g, "getForcedUsingDisplayMode result:" + iIntValue);
        return iIntValue;
    }

    @Override // rf.b
    public void l(int i10, float f10) {
        try {
            this.f20801a.setTemporaryBrightness(i10, f10);
        } catch (RemoteException e10) {
            j7.b.a("setTemporaryBrightness: e = ", e10, f20793g);
        }
    }

    @Override // rf.b
    public void m(int i10) {
        ITranDisplayManager iTranDisplayManager;
        if (fc.a.f() && (iTranDisplayManager = this.f20801a) != null) {
            try {
                iTranDisplayManager.unregisterTentModeCallback(i10);
            } catch (RemoteException e10) {
                throw e10.rethrowFromSystemServer();
            }
        }
    }

    @Override // rf.b
    public int n() {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: yc.i
            @Override // zb.f.b
            public final Object run() {
                return this.f20792a.O();
            }
        }, "display")).intValue();
        dc.e.f(f20793g, "getSourceConnectFlag result:" + iIntValue);
        return iIntValue;
    }

    @Override // rf.b
    public void o(int i10) {
        ITranDisplayManager iTranDisplayManager;
        if (fc.a.g() && (iTranDisplayManager = this.f20801a) != null) {
            try {
                iTranDisplayManager.unregisterSmartButtonCallback(i10);
            } catch (RemoteException unused) {
                dc.e.a(f20793g, "unregisterSmartButtonCallback fail");
            }
        }
    }

    @Override // rf.b
    public void p(int i10, x9.b.c cVar) {
        if (fc.a.g() && this.f20801a != null) {
            try {
                this.f20801a.registerSmartButtonCallback(new f(cVar), i10);
            } catch (RemoteException unused) {
                dc.e.a(f20793g, "registerSmartButtonCallback fail");
            }
        }
    }

    @Override // rf.b
    public int q() {
        if (fc.a.d()) {
            return -1;
        }
        try {
            return this.f20801a.getSecondaryDisplayId();
        } catch (RemoteException e10) {
            j7.b.a("getSecondaryDisplayId : e = ", e10, f20793g);
            return -1;
        }
    }

    @Override // rf.b
    public boolean r(String str) {
        boolean zUnRegisterPowerStateChangedListener = false;
        try {
            ITranDisplayManager iTranDisplayManager = this.f20801a;
            if (iTranDisplayManager == null) {
                return false;
            }
            zUnRegisterPowerStateChangedListener = iTranDisplayManager.unRegisterPowerStateChangedListener(str);
            this.f20806f.remove(str);
            return zUnRegisterPowerStateChangedListener;
        } catch (RemoteException e10) {
            dc.e.a(f20793g, "unRegisterPowerStateChangedListener fail:" + e10);
            return zUnRegisterPowerStateChangedListener;
        }
    }

    @Override // rf.b
    public void s() {
        if (fc.a.d() || this.f20801a == null) {
            return;
        }
        try {
            dc.e.a(f20793g, "openDualDisplay: 1");
            this.f20801a.openDualDisplay();
        } catch (RemoteException e10) {
            throw e10.rethrowFromSystemServer();
        }
    }

    @Override // rf.b
    public boolean t() {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: yc.b
            @Override // zb.f.b
            public final Object run() {
                return this.f20780a.P();
            }
        }, "display")).booleanValue();
        dc.e.f(f20793g, "isDualDisplayForSelfie");
        return zBooleanValue;
    }

    @Override // rf.b
    public void u(String str, String str2) {
        if (fc.a.d()) {
            return;
        }
        try {
            this.f20801a.addShowInDualDisplay(str, str2);
        } catch (RemoteException e10) {
            throw e10.rethrowFromSystemServer();
        }
    }

    @Override // rf.b
    public void v(final Bundle bundle) {
        new zb.f().c(new zb.f.b() { // from class: yc.f
            @Override // zb.f.b
            public final Object run() {
                return this.f20787a.Q(bundle);
            }
        }, "display");
    }

    @Override // rf.b
    public boolean w(final x9.b.e eVar, String str) {
        h hVarComputeIfAbsent = this.f20806f.computeIfAbsent(str, new Function() { // from class: yc.h
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return j.B(this.f20790a, eVar, (String) obj);
            }
        });
        try {
            ITranDisplayManager iTranDisplayManager = this.f20801a;
            if (iTranDisplayManager != null) {
                return iTranDisplayManager.registerPowerStateChangedCallback(hVarComputeIfAbsent, str);
            }
            return false;
        } catch (RemoteException e10) {
            dc.e.a(f20793g, "registerPowerStateChangedCallback fail:" + e10);
            return false;
        }
    }

    @Override // rf.b
    public void x(x9.b.a aVar) {
        if (fc.a.d() || this.f20801a == null) {
            return;
        }
        if (aVar == null) {
            throw new IllegalArgumentException("listener must not be null");
        }
        synchronized (this.f20802b) {
            try {
                int iH = H(aVar);
                if (iH >= 0) {
                    this.f20805e.get(iH).removeCallbacksAndMessages(null);
                    this.f20805e.remove(iH);
                    V();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
