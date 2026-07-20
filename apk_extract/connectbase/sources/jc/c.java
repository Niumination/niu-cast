package jc;

import android.os.Bundle;
import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.app.role.ITranRemoteCallback;
import com.transsion.hubsdk.app.role.ITranRoleManager;
import com.transsion.hubsdk.app.role.TranRoleControllerManager;
import dc.e;
import e8.m;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
public class c implements cf.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8670c = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranRoleManager f8671a = ITranRoleManager.Stub.asInterface(TranServiceManager.getServiceIBinder("role"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TranRoleControllerManager f8672b;

    public static class a extends ITranRemoteCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m.a f8673a;

        public a(m.a aVar) {
            this.f8673a = aVar;
        }

        public void a(Bundle bundle) throws RemoteException {
            m.a aVar = this.f8673a;
            if (aVar != null) {
                aVar.a(bundle);
            }
        }
    }

    @Override // cf.a
    public List<String> a(String str) {
        ITranRoleManager iTranRoleManager = this.f8671a;
        if (iTranRoleManager == null) {
            return null;
        }
        try {
            return iTranRoleManager.getRoleHolders(str);
        } catch (RemoteException e10) {
            j7.b.a("getRoleHolders fail", e10, f8670c);
            return null;
        }
    }

    @Override // cf.a
    public boolean b(String str, String str2) {
        ITranRoleManager iTranRoleManager = this.f8671a;
        if (iTranRoleManager == null) {
            return false;
        }
        try {
            return iTranRoleManager.removeRoleHolderFromController(str, str2);
        } catch (RemoteException e10) {
            j7.b.a("removeRoleHolderFromController fail", e10, f8670c);
            return false;
        }
    }

    @Override // cf.a
    public boolean c(String str, String str2) {
        ITranRoleManager iTranRoleManager = this.f8671a;
        if (iTranRoleManager == null) {
            return false;
        }
        try {
            return iTranRoleManager.addRoleHolderFromController(str, str2);
        } catch (RemoteException e10) {
            j7.b.a("addRoleHolderFromController fail", e10, f8670c);
            return false;
        }
    }

    @Override // cf.a
    public void d(String str, String str2, Executor executor, Consumer<Boolean> consumer) {
        i().isApplicationVisibleForRole(str, str2, executor, consumer);
    }

    @Override // cf.a
    public void e(final String str, final String str2, final int i10, final int i11, final m.a aVar) {
        new f().c(new f.b() { // from class: jc.b
            @Override // zb.f.b
            public final Object run() {
                return this.f8664a.k(str, str2, i10, i11, aVar);
            }
        }, "role");
        e.f(f8670c, "addRoleHolderAsUserExt success!");
    }

    @Override // cf.a
    public void f(final String str, final String str2, final int i10, final int i11) {
        new f().c(new f.b() { // from class: jc.a
            @Override // zb.f.b
            public final Object run() {
                return this.f8659a.j(str, str2, i10, i11);
            }
        }, "role");
        e.f(f8670c, "addRoleHolderAsUser success!");
    }

    public final TranRoleControllerManager i() {
        if (this.f8672b == null) {
            this.f8672b = new TranRoleControllerManager(bc.a.a());
        }
        return this.f8672b;
    }

    public final /* synthetic */ Object j(String str, String str2, int i10, int i11) throws RemoteException {
        ITranRoleManager iTranRoleManager = this.f8671a;
        if (iTranRoleManager != null) {
            iTranRoleManager.addRoleHolderAsUser(str, str2, i10, i11);
        }
        return 0;
    }

    public final /* synthetic */ Object k(String str, String str2, int i10, int i11, m.a aVar) throws RemoteException {
        ITranRoleManager iTranRoleManager = this.f8671a;
        if (iTranRoleManager == null) {
            return null;
        }
        iTranRoleManager.addRoleHolderAsUserExt(str, str2, i10, i11, new a(aVar));
        return null;
    }

    @VisibleForTesting
    public void l(ITranRoleManager iTranRoleManager) {
        this.f8671a = iTranRoleManager;
    }
}
