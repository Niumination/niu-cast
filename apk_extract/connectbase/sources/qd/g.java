package qd;

import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.net.TranInterfaceConfiguration;
import com.transsion.hubsdk.os.ITranNetworkManagementService;

/* JADX INFO: loaded from: classes2.dex */
public class g implements kg.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13978b = "g";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranNetworkManagementService f13979a = ITranNetworkManagementService.Stub.asInterface(TranServiceManager.getServiceIBinder("network_managerment"));

    @Override // kg.b
    public qa.b a(String str) {
        TranInterfaceConfiguration interfaceConfig;
        try {
            interfaceConfig = this.f13979a.getInterfaceConfig(str);
        } catch (RemoteException e10) {
            dc.e.f(f13978b, "getInterfaceConfig fail " + e10);
            interfaceConfig = null;
        }
        if (interfaceConfig != null) {
            return new qa.b(interfaceConfig.getLinkAddress());
        }
        return null;
    }

    @Override // kg.b
    public boolean b() {
        ITranNetworkManagementService iTranNetworkManagementService = this.f13979a;
        if (iTranNetworkManagementService == null) {
            return false;
        }
        try {
            return iTranNetworkManagementService.isTetheringStarted();
        } catch (RemoteException e10) {
            dc.e.f(f13978b, "isTetheringStarted fail " + e10);
            return false;
        }
    }

    @Override // kg.b
    public String[] c() {
        ITranNetworkManagementService iTranNetworkManagementService = this.f13979a;
        if (iTranNetworkManagementService != null) {
            try {
                return iTranNetworkManagementService.listInterfaces();
            } catch (RemoteException e10) {
                dc.e.f(f13978b, "listInterfaces fail " + e10);
            }
        }
        return new String[0];
    }

    @Override // kg.b
    public boolean d(String str) {
        ITranNetworkManagementService iTranNetworkManagementService = this.f13979a;
        if (iTranNetworkManagementService == null) {
            return false;
        }
        try {
            return iTranNetworkManagementService.isActive(str);
        } catch (RemoteException e10) {
            dc.e.f(f13978b, "isActive fail " + e10);
            return false;
        }
    }

    @Override // kg.b
    public void e(String str, String str2) {
        ITranNetworkManagementService iTranNetworkManagementService = this.f13979a;
        if (iTranNetworkManagementService != null) {
            try {
                iTranNetworkManagementService.stopInterfaceForwarding(str, str2);
            } catch (RemoteException e10) {
                dc.e.f(f13978b, "stopInterfaceForwarding fail " + e10);
            }
        }
    }

    @Override // kg.b
    public boolean f() {
        ITranNetworkManagementService iTranNetworkManagementService = this.f13979a;
        if (iTranNetworkManagementService == null) {
            return false;
        }
        try {
            return iTranNetworkManagementService.isBandwidthControlEnabled();
        } catch (RemoteException e10) {
            j7.b.a("isBandwidthControlEnabled fail ", e10, f13978b);
            return false;
        }
    }

    @Override // kg.b
    public void g(String str, String str2) {
        ITranNetworkManagementService iTranNetworkManagementService = this.f13979a;
        if (iTranNetworkManagementService != null) {
            try {
                iTranNetworkManagementService.startInterfaceForwarding(str, str2);
            } catch (RemoteException e10) {
                dc.e.f(f13978b, "startInterfaceForwarding fail " + e10);
            }
        }
    }

    @Override // kg.b
    public String[] h() {
        ITranNetworkManagementService iTranNetworkManagementService = this.f13979a;
        if (iTranNetworkManagementService != null) {
            try {
                return iTranNetworkManagementService.listTetheredInterfaces();
            } catch (RemoteException e10) {
                dc.e.f(f13978b, "listTetheredInterfaces fail " + e10);
            }
        }
        return new String[0];
    }

    @VisibleForTesting
    public void i(ITranNetworkManagementService iTranNetworkManagementService) {
        this.f13979a = iTranNetworkManagementService;
    }
}
