package lc;

import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.appm.ITranAppmManager;

/* JADX INFO: loaded from: classes2.dex */
public class j implements ef.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranAppmManager f9814a;

    public j() {
        new zb.f().c(new zb.f.b() { // from class: lc.f
            @Override // zb.f.b
            public final Object run() {
                return this.f9806a.r();
            }
        }, "appm_service");
    }

    @Override // ef.a
    public void b(final String str, final String str2) {
        new zb.f().c(new zb.f.b() { // from class: lc.i
            @Override // zb.f.b
            public final Object run() {
                return this.f9811a.u(str, str2);
            }
        }, "appm_service");
    }

    @Override // ef.a
    public void e(final String str, final String str2) {
        new zb.f().c(new zb.f.b() { // from class: lc.c
            @Override // zb.f.b
            public final Object run() {
                return this.f9799a.s(str, str2);
            }
        }, "appm_service");
    }

    @Override // ef.a
    public String g(final String str) {
        return (String) new zb.f().c(new zb.f.b() { // from class: lc.e
            @Override // zb.f.b
            public final Object run() {
                return this.f9804a.p(str);
            }
        }, "appm_service");
    }

    @Override // ef.a
    public void h(final k9.a aVar) {
        new zb.f().c(new zb.f.b() { // from class: lc.h
            @Override // zb.f.b
            public final Object run() {
                return this.f9809a.w(aVar);
            }
        }, "appm_service");
    }

    @Override // ef.a
    public boolean i(final int i10, final boolean z10, final String str) {
        return ((Boolean) new zb.f().c(new zb.f.b() { // from class: lc.b
            @Override // zb.f.b
            public final Object run() {
                return this.f9795a.v(i10, z10, str);
            }
        }, "appm_service")).booleanValue();
    }

    @Override // ef.a
    public void j(final k9.a aVar) {
        new zb.f().c(new zb.f.b() { // from class: lc.d
            @Override // zb.f.b
            public final Object run() {
                return this.f9802a.t(aVar);
            }
        }, "appm_service");
    }

    @Override // ef.a
    public float k(final int i10) {
        return ((Float) new zb.f().c(new zb.f.b() { // from class: lc.g
            @Override // zb.f.b
            public final Object run() {
                return this.f9807a.q(i10);
            }
        }, "appm_service")).floatValue();
    }

    public final /* synthetic */ Object p(String str) throws RemoteException {
        ITranAppmManager iTranAppmManager = this.f9814a;
        return iTranAppmManager != null ? iTranAppmManager.getPolicyVersion(str) : "unkown";
    }

    public final /* synthetic */ Object q(int i10) throws RemoteException {
        ITranAppmManager iTranAppmManager = this.f9814a;
        return iTranAppmManager != null ? Float.valueOf(iTranAppmManager.getRecentFpsAvg(i10)) : Float.valueOf(-1.0f);
    }

    public final /* synthetic */ Object r() throws RemoteException {
        this.f9814a = ITranAppmManager.Stub.asInterface(TranServiceManager.getServiceIBinder("appm_service"));
        return null;
    }

    public final /* synthetic */ Object s(String str, String str2) throws RemoteException {
        ITranAppmManager iTranAppmManager = this.f9814a;
        if (iTranAppmManager == null) {
            return null;
        }
        iTranAppmManager.notifyClient(str, str2);
        return null;
    }

    public final /* synthetic */ Object t(k9.a aVar) throws RemoteException {
        ITranAppmManager iTranAppmManager = this.f9814a;
        if (iTranAppmManager == null) {
            return null;
        }
        a.c(iTranAppmManager, aVar);
        return null;
    }

    public final /* synthetic */ Object u(String str, String str2) throws RemoteException {
        ITranAppmManager iTranAppmManager = this.f9814a;
        if (iTranAppmManager == null) {
            return null;
        }
        iTranAppmManager.sendEvent(str, str2);
        return null;
    }

    public final /* synthetic */ Object v(int i10, boolean z10, String str) throws RemoteException {
        ITranAppmManager iTranAppmManager = this.f9814a;
        return iTranAppmManager != null ? Boolean.valueOf(iTranAppmManager.setFpsMonitorSwitch(i10, z10, str)) : Boolean.FALSE;
    }

    public final /* synthetic */ Object w(k9.a aVar) throws RemoteException {
        ITranAppmManager iTranAppmManager = this.f9814a;
        if (iTranAppmManager == null) {
            return null;
        }
        a.d(iTranAppmManager, aVar);
        return null;
    }

    @VisibleForTesting
    public void x(ITranAppmManager iTranAppmManager) {
        this.f9814a = iTranAppmManager;
    }
}
