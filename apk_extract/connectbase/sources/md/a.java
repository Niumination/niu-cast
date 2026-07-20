package md;

import android.app.admin.DevicePolicyManager;
import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.internal.widget.ITranLockPatternUtils;
import com.transsion.hubsdk.internal.widget.TranLockPatternUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a implements gg.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10632c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranLockPatternUtils f10633a = ITranLockPatternUtils.Stub.asInterface(TranServiceManager.getServiceIBinder("lockpatten_utils"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TranLockPatternUtils f10634b;

    @Override // gg.c
    public void a(boolean z10, int i10) {
        if (fc.a.f()) {
            j().setAutoPinConfirm(z10, i10);
        }
    }

    @Override // gg.c
    public String b(String str, int i10) {
        ITranLockPatternUtils iTranLockPatternUtils = this.f10633a;
        if (iTranLockPatternUtils == null) {
            return null;
        }
        try {
            return iTranLockPatternUtils.getString(str, i10);
        } catch (RemoteException e10) {
            j7.b.a("getString fail:", e10, f10632c);
            return null;
        }
    }

    @Override // gg.c
    public DevicePolicyManager c() {
        return j().getDevicePolicyManager();
    }

    @Override // gg.c
    public void d(String str, String str2, int i10) {
        ITranLockPatternUtils iTranLockPatternUtils = this.f10633a;
        if (iTranLockPatternUtils == null) {
            return;
        }
        try {
            iTranLockPatternUtils.setString(str, str2, i10);
        } catch (RemoteException e10) {
            j7.b.a("setString fail:", e10, f10632c);
        }
    }

    @Override // gg.c
    @yb.a(level = 1)
    public boolean e(int i10) {
        ITranLockPatternUtils iTranLockPatternUtils = this.f10633a;
        if (iTranLockPatternUtils == null) {
            return false;
        }
        try {
            return iTranLockPatternUtils.isSecure(i10);
        } catch (RemoteException e10) {
            j7.b.a("isSecure fail:", e10, f10632c);
            return false;
        }
    }

    @Override // gg.c
    public long f(long j10, int i10) {
        return j().getPasswordLength(j10, i10);
    }

    @Override // gg.c
    @yb.a(level = 1)
    public int g(int i10) {
        ITranLockPatternUtils iTranLockPatternUtils = this.f10633a;
        if (iTranLockPatternUtils == null) {
            return 0;
        }
        try {
            return iTranLockPatternUtils.getActivePasswordQuality(i10);
        } catch (RemoteException e10) {
            j7.b.a("getActivePasswordQuality fail:", e10, f10632c);
            return 0;
        }
    }

    @Override // gg.c
    public boolean h(int i10) {
        try {
            return this.f10633a.getPowerButtonInstantlyLocks(i10);
        } catch (RemoteException e10) {
            j7.b.a("isSecure fail:", e10, f10632c);
            return false;
        }
    }

    @Override // gg.c
    public long i(int i10) {
        try {
            return this.f10633a.getLockoutAttemptDeadline(i10);
        } catch (RemoteException e10) {
            j7.b.a("getLockoutAttemptDeadline fail:", e10, f10632c);
            return 0L;
        }
    }

    public final TranLockPatternUtils j() {
        if (this.f10634b == null) {
            this.f10634b = new TranLockPatternUtils(bc.a.a());
        }
        return this.f10634b;
    }

    @VisibleForTesting
    public void k(ITranLockPatternUtils iTranLockPatternUtils) {
        this.f10633a = iTranLockPatternUtils;
    }
}
