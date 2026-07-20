package oe;

import android.os.RemoteException;
import com.transsion.hubsdk.TranBootstrapServiceManager;
import com.transsion.hubsdk.tranusf.ITranUsfManager;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ih.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12276b = "a";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12277c = "Usf Service not found!!!";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f12278d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f12279e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ITranUsfManager f12280a = ITranUsfManager.Stub.asInterface(TranBootstrapServiceManager.getServiceIBinder("tran_usf"));

    @Override // ih.a
    public boolean a(boolean z10) {
        ITranUsfManager iTranUsfManager = this.f12280a;
        if (iTranUsfManager == null) {
            e.n(f12276b, f12277c);
            return false;
        }
        try {
            return iTranUsfManager.enableFastFreezer(z10);
        } catch (RemoteException unused) {
            e.n(f12276b, "enableFastFreezer remote exception");
            return false;
        }
    }

    @Override // ih.a
    public boolean b(String str) {
        ITranUsfManager iTranUsfManager = this.f12280a;
        if (iTranUsfManager == null) {
            e.n(f12276b, f12277c);
            return false;
        }
        try {
            return iTranUsfManager.isWhiteApp(str);
        } catch (RemoteException unused) {
            e.n(f12276b, "isWhiteApp remote exception");
            return false;
        }
    }

    @Override // ih.a
    public void c(int i10, int i11) {
        ITranUsfManager iTranUsfManager = this.f12280a;
        if (iTranUsfManager == null) {
            e.n(f12276b, f12277c);
            return;
        }
        try {
            iTranUsfManager.setAppMode(i10, i11);
        } catch (RemoteException unused) {
            e.n(f12276b, "setAppMode remote exception");
        }
    }

    @Override // ih.a
    public int[] d(int i10) {
        ITranUsfManager iTranUsfManager = this.f12280a;
        if (iTranUsfManager != null) {
            try {
                return iTranUsfManager.getAppListMode(i10);
            } catch (RemoteException unused) {
                e.n(f12276b, "getAppListMode remote exception");
            }
        } else {
            e.n(f12276b, f12277c);
        }
        return new int[0];
    }

    @Override // ih.a
    public void e(boolean z10) {
        ITranUsfManager iTranUsfManager = this.f12280a;
        if (iTranUsfManager == null) {
            e.n(f12276b, f12277c);
            return;
        }
        try {
            iTranUsfManager.enableHiber(z10);
        } catch (RemoteException unused) {
            e.n(f12276b, "enableHiber remote exception");
        }
    }

    @Override // ih.a
    public boolean f() {
        ITranUsfManager iTranUsfManager = this.f12280a;
        if (iTranUsfManager == null) {
            e.n(f12276b, f12277c);
            return false;
        }
        try {
            return iTranUsfManager.isEnabledHiber();
        } catch (RemoteException unused) {
            e.n(f12276b, "isEnabledHiber remote exception");
            return false;
        }
    }

    @Override // ih.a
    public String g(int i10, String str) {
        ITranUsfManager iTranUsfManager = this.f12280a;
        if (iTranUsfManager == null) {
            e.n(f12276b, f12277c);
            return "";
        }
        try {
            return iTranUsfManager.getUnfreezeReason(i10, str);
        } catch (RemoteException unused) {
            e.n(f12276b, "getUnfreezeReason remote exception");
            return "";
        }
    }

    @Override // ih.a
    public int h(int i10) {
        ITranUsfManager iTranUsfManager = this.f12280a;
        if (iTranUsfManager == null) {
            e.n(f12276b, f12277c);
            return -1;
        }
        try {
            return iTranUsfManager.getAppMode(i10);
        } catch (RemoteException unused) {
            e.n(f12276b, "getAppMode remote exception");
            return -1;
        }
    }

    @Override // ih.a
    public boolean i(int i10) {
        ITranUsfManager iTranUsfManager = this.f12280a;
        if (iTranUsfManager == null) {
            e.n(f12276b, f12277c);
            return false;
        }
        try {
            return iTranUsfManager.isRuntimeWhiteApp(i10);
        } catch (RemoteException unused) {
            e.n(f12276b, "isRuntimeWhiteApp remote exception");
            return false;
        }
    }

    @Override // ih.a
    public boolean j() {
        ITranUsfManager iTranUsfManager = this.f12280a;
        if (iTranUsfManager == null) {
            e.n(f12276b, f12277c);
            return false;
        }
        try {
            return iTranUsfManager.isEnableNightNetwork();
        } catch (RemoteException unused) {
            e.n(f12276b, "isEnableNightNetwork remote exception");
            return false;
        }
    }

    @Override // ih.a
    public void k(boolean z10) {
        ITranUsfManager iTranUsfManager = this.f12280a;
        if (iTranUsfManager == null) {
            e.n(f12276b, f12277c);
            return;
        }
        try {
            iTranUsfManager.enableNightNetwork(z10);
        } catch (RemoteException unused) {
            e.n(f12276b, "enableNightNetwork remote exception");
        }
    }

    @Override // ih.a
    public int l(int i10, String str) {
        ITranUsfManager iTranUsfManager = this.f12280a;
        if (iTranUsfManager == null) {
            e.n(f12276b, f12277c);
            return 0;
        }
        try {
            return iTranUsfManager.freeze(i10, str);
        } catch (RemoteException unused) {
            e.n(f12276b, "freeze remote exception");
            return 0;
        }
    }

    @Override // ih.a
    public void m(String str, long j10) {
        ITranUsfManager iTranUsfManager = this.f12280a;
        if (iTranUsfManager == null) {
            e.n(f12276b, f12277c);
            return;
        }
        try {
            iTranUsfManager.fastFreezeTemporarily(str, j10);
        } catch (RemoteException unused) {
            e.n(f12276b, "fastFreezeTemporarily remote exception");
        }
    }

    @Override // ih.a
    public boolean n(int i10, boolean z10) {
        ITranUsfManager iTranUsfManager = this.f12280a;
        if (iTranUsfManager == null) {
            e.n(f12276b, f12277c);
            return false;
        }
        try {
            return iTranUsfManager.addRuntimeWhiteApp(i10, z10);
        } catch (RemoteException unused) {
            e.n(f12276b, "addRuntimeWhiteApp remote exception");
            return false;
        }
    }

    @Override // ih.a
    public void o(String str) {
        ITranUsfManager iTranUsfManager = this.f12280a;
        if (iTranUsfManager == null) {
            e.n(f12276b, f12277c);
            return;
        }
        try {
            iTranUsfManager.fastFreeze(str);
        } catch (RemoteException unused) {
            e.n(f12276b, "fastFreeze remote exception");
        }
    }

    @Override // ih.a
    public void p(int i10, String str, String str2) {
        ITranUsfManager iTranUsfManager = this.f12280a;
        if (iTranUsfManager == null) {
            e.n(f12276b, f12277c);
            return;
        }
        try {
            iTranUsfManager.unfreeze(i10, str, str2);
        } catch (RemoteException unused) {
            e.n(f12276b, "unfreeze remote exception");
        }
    }

    @Override // ih.a
    public boolean q() {
        ITranUsfManager iTranUsfManager = this.f12280a;
        if (iTranUsfManager == null) {
            e.n(f12276b, f12277c);
            return false;
        }
        try {
            return iTranUsfManager.isFastFreezerEnable();
        } catch (RemoteException unused) {
            e.n(f12276b, "isFastFreezerEnable remote exception");
            return false;
        }
    }

    @Override // ih.a
    public void r(String str) {
        ITranUsfManager iTranUsfManager = this.f12280a;
        if (iTranUsfManager == null) {
            e.n(f12276b, f12277c);
            return;
        }
        try {
            iTranUsfManager.fastUnfreeze(str);
        } catch (RemoteException unused) {
            e.n(f12276b, "fastUnfreeze remote exception");
        }
    }
}
