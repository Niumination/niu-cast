package hc;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ComponentName;
import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.accessibilityservice.ITranAccessibilityServiceInfoManager;
import dc.e;
import java.util.List;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
public class b implements af.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7104b = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranAccessibilityServiceInfoManager f7105a = ITranAccessibilityServiceInfoManager.Stub.asInterface(TranServiceManager.getServiceIBinder("accessibility_service_info"));

    @Override // af.a
    public boolean a(ComponentName componentName, int i10) {
        ITranAccessibilityServiceInfoManager iTranAccessibilityServiceInfoManager = this.f7105a;
        if (iTranAccessibilityServiceInfoManager == null) {
            return false;
        }
        try {
            return iTranAccessibilityServiceInfoManager.removeAccessibilityService(componentName, i10);
        } catch (RemoteException e10) {
            j7.b.a("removeAccessibilityService:", e10, f7104b);
            return false;
        }
    }

    @Override // af.a
    public List<AccessibilityServiceInfo> b() {
        List<AccessibilityServiceInfo> list = (List) new f().c(new f.b() { // from class: hc.a
            @Override // zb.f.b
            public final Object run() {
                return this.f7103a.f();
            }
        }, "accessibility_service_info");
        e.f(f7104b, "getInstalledAccessibilityServiceList mAccessibilityServiceInfos:" + list);
        return list;
    }

    @Override // af.a
    public boolean c(ComponentName componentName, int i10) {
        ITranAccessibilityServiceInfoManager iTranAccessibilityServiceInfoManager = this.f7105a;
        if (iTranAccessibilityServiceInfoManager == null) {
            return false;
        }
        try {
            return iTranAccessibilityServiceInfoManager.addAccessibilityService(componentName, i10);
        } catch (RemoteException e10) {
            j7.b.a("addAccessibilityService:", e10, f7104b);
            return false;
        }
    }

    @Override // af.a
    public boolean d(AccessibilityServiceInfo accessibilityServiceInfo) {
        ITranAccessibilityServiceInfoManager iTranAccessibilityServiceInfoManager = this.f7105a;
        if (iTranAccessibilityServiceInfoManager == null) {
            return false;
        }
        try {
            return iTranAccessibilityServiceInfoManager.getCrashed(accessibilityServiceInfo);
        } catch (RemoteException e10) {
            j7.b.a("getCrashed:", e10, f7104b);
            return false;
        }
    }

    public final /* synthetic */ Object f() throws RemoteException {
        ITranAccessibilityServiceInfoManager iTranAccessibilityServiceInfoManager = this.f7105a;
        if (iTranAccessibilityServiceInfoManager != null) {
            return iTranAccessibilityServiceInfoManager.getInstalledAccessibilityServiceList();
        }
        return null;
    }

    @VisibleForTesting
    public void g(ITranAccessibilityServiceInfoManager iTranAccessibilityServiceInfoManager) {
        this.f7105a = iTranAccessibilityServiceInfoManager;
    }
}
