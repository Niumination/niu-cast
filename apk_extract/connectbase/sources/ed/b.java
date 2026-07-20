package ed;

import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.internal.app.ITranAppOpsActiveCallback;
import com.transsion.hubsdk.internal.app.ITranAppOpsService;
import com.transsion.hubsdk.internal.app.TranOpEntry;
import com.transsion.hubsdk.internal.app.TranPackageOps;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b implements xf.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f4250b = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranAppOpsService f4251a = ITranAppOpsService.Stub.asInterface(TranServiceManager.getServiceIBinder("appops"));

    public static class a extends ITranAppOpsActiveCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m7.c.a f4252a;

        public a(m7.c.a aVar) {
            this.f4252a = aVar;
        }

        public void a(int i10, int i11, String str, String str2, boolean z10, int i12, int i13) throws RemoteException {
            m7.c.a aVar = this.f4252a;
            if (aVar != null) {
                aVar.a(i10, i11, str, str2, z10, i12, i13);
            }
        }
    }

    @Override // xf.a
    public List<da.h> a(da.i iVar) {
        if (iVar == null) {
            return null;
        }
        try {
            return iVar.a();
        } catch (Exception e10) {
            p6.b.a("getOps:", e10, f4250b);
            return null;
        }
    }

    @Override // xf.a
    public void b(final int[] iArr, final m7.c.a aVar) {
        new zb.f().c(new zb.f.b() { // from class: ed.a
            @Override // zb.f.b
            public final Object run() {
                return this.f4247a.j(iArr, aVar);
            }
        }, "appops");
        dc.e.f(f4250b, "startWatchingActive success!");
    }

    @Override // xf.a
    public void c(int i10, int i11, String str, int i12) {
        try {
            this.f4251a.setMode(i10, i11, str, i12);
        } catch (RemoteException e10) {
            j7.b.a("setMode: e = ", e10, f4250b);
        }
    }

    @Override // xf.a
    public List<da.i> d(int i10, String str, int[] iArr) {
        List<TranPackageOps> opsForPackage;
        ITranAppOpsService iTranAppOpsService = this.f4251a;
        if (iTranAppOpsService == null) {
            return null;
        }
        try {
            opsForPackage = iTranAppOpsService.getOpsForPackage(i10, str, iArr);
        } catch (RemoteException e10) {
            j7.b.a("getOpsForPackage:", e10, f4250b);
            opsForPackage = null;
        }
        if (opsForPackage == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (TranPackageOps tranPackageOps : opsForPackage) {
            da.i iVar = null;
            for (TranOpEntry tranOpEntry : tranPackageOps.getOps()) {
                if (tranOpEntry != null) {
                    arrayList2.add(new da.h(tranOpEntry.getMode()));
                }
                iVar = new da.i(tranPackageOps.mPackageName, tranPackageOps.mUid, arrayList2);
            }
            arrayList.add(iVar);
        }
        return arrayList;
    }

    @Override // xf.a
    public int e(da.h hVar) {
        if (hVar == null) {
            return 0;
        }
        return hVar.a();
    }

    @Override // xf.a
    public int f(int i10, int i11, String str) {
        try {
            return this.f4251a.checkOp(i10, i11, str);
        } catch (RemoteException e10) {
            j7.b.a("checkOp: e = ", e10, f4250b);
            return -1;
        }
    }

    @Override // xf.a
    public void g(int i10, int i11, String str, int i12) {
        try {
            ITranAppOpsService iTranAppOpsService = this.f4251a;
            if (iTranAppOpsService != null) {
                iTranAppOpsService.setPackageMode(i10, i11, str, i12);
            }
        } catch (RemoteException e10) {
            j7.b.a("setPackageMode: e = ", e10, f4250b);
        }
    }

    @Override // xf.a
    public int h(int i10, int i11, String str) {
        try {
            ITranAppOpsService iTranAppOpsService = this.f4251a;
            if (iTranAppOpsService != null) {
                return iTranAppOpsService.getPackageMode(i10, i11, str);
            }
            return -1;
        } catch (RemoteException e10) {
            j7.b.a("getPackageMode: e = ", e10, f4250b);
            return -1;
        }
    }

    public final /* synthetic */ Object j(int[] iArr, m7.c.a aVar) throws RemoteException {
        ITranAppOpsService iTranAppOpsService = this.f4251a;
        if (iTranAppOpsService == null) {
            return null;
        }
        iTranAppOpsService.startWatchingActive(iArr, new a(aVar));
        return null;
    }

    @VisibleForTesting
    public void k(ITranAppOpsService iTranAppOpsService) {
        this.f4251a = iTranAppOpsService;
    }
}
