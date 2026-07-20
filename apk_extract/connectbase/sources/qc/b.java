package qc;

import android.content.pm.ApplicationInfo;
import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.content.pm.ITranApplicationInfoManager;
import com.transsion.hubsdk.content.pm.TranApplicationInfo;
import ic.n0;

/* JADX INFO: loaded from: classes2.dex */
public class b implements jf.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13901c = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranApplicationInfoManager f13902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TranApplicationInfo f13903b;

    public b() {
        this.f13902a = null;
        this.f13902a = ITranApplicationInfoManager.Stub.asInterface(TranServiceManager.getServiceIBinder("application_info"));
    }

    @Override // jf.b
    public boolean a(ApplicationInfo applicationInfo) {
        return j().isDirectBootAware(applicationInfo);
    }

    @Override // jf.b
    public boolean b(ApplicationInfo applicationInfo) {
        boolean zIsSystemApp = false;
        try {
            ITranApplicationInfoManager iTranApplicationInfoManager = this.f13902a;
            if (iTranApplicationInfoManager != null) {
                zIsSystemApp = iTranApplicationInfoManager.isSystemApp(applicationInfo);
            }
        } catch (RemoteException e10) {
            dc.e.f(f13901c, "isSystemApp exception:" + e10);
        }
        n0.a("isSystemApp res:", zIsSystemApp, f13901c);
        return zIsSystemApp;
    }

    @Override // jf.b
    public boolean c(ApplicationInfo applicationInfo) {
        boolean zIsProduct = false;
        try {
            ITranApplicationInfoManager iTranApplicationInfoManager = this.f13902a;
            if (iTranApplicationInfoManager != null) {
                zIsProduct = iTranApplicationInfoManager.isProduct(applicationInfo);
            }
        } catch (RemoteException e10) {
            dc.e.f(f13901c, "isProduct exception:" + e10);
        }
        n0.a("isProduct res:", zIsProduct, f13901c);
        return zIsProduct;
    }

    @Override // jf.b
    public boolean d(ApplicationInfo applicationInfo) {
        boolean zIsSignedWithPlatformKey = false;
        try {
            ITranApplicationInfoManager iTranApplicationInfoManager = this.f13902a;
            if (iTranApplicationInfoManager != null) {
                zIsSignedWithPlatformKey = iTranApplicationInfoManager.isSignedWithPlatformKey(applicationInfo);
            }
        } catch (RemoteException e10) {
            dc.e.f(f13901c, "isSignedWithPlatformKey exception:" + e10);
        }
        n0.a("isSignedWithPlatformKey res:", zIsSignedWithPlatformKey, f13901c);
        return zIsSignedWithPlatformKey;
    }

    @Override // jf.b
    public boolean e(ApplicationInfo applicationInfo) {
        boolean zIsSystemExt = false;
        try {
            ITranApplicationInfoManager iTranApplicationInfoManager = this.f13902a;
            if (iTranApplicationInfoManager != null) {
                zIsSystemExt = iTranApplicationInfoManager.isSystemExt(applicationInfo);
            }
        } catch (RemoteException e10) {
            dc.e.f(f13901c, "isSystemExt exception:" + e10);
        }
        n0.a("isSystemExt res:", zIsSystemExt, f13901c);
        return zIsSystemExt;
    }

    @Override // jf.b
    public boolean f(ApplicationInfo applicationInfo) {
        return j().isPrivilegedApp(applicationInfo);
    }

    @Override // jf.b
    public boolean g(ApplicationInfo applicationInfo) {
        return j().isInstantApp(applicationInfo);
    }

    @Override // jf.b
    public int h(ApplicationInfo applicationInfo) {
        return j().getIconRes(applicationInfo);
    }

    @Override // jf.b
    public boolean i(ApplicationInfo applicationInfo) {
        return j().isPartiallyDirectBootAware(applicationInfo);
    }

    public final TranApplicationInfo j() {
        if (this.f13903b == null) {
            this.f13903b = new TranApplicationInfo(bc.a.a());
        }
        return this.f13903b;
    }

    @VisibleForTesting
    public void k(ITranApplicationInfoManager iTranApplicationInfoManager) {
        this.f13902a = iTranApplicationInfoManager;
    }
}
