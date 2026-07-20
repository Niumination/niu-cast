package ad;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.api.hardware.fingerprint.TranFingerprintInfo;
import com.transsion.hubsdk.hardware.fingerprint.ITranFingerprintService;
import com.transsion.hubsdk.hardware.fingerprint.TranFingerprint;
import com.transsion.hubsdk.hardware.fingerprint.TranFingerprintManager;
import dc.e;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements tf.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f197d = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranFingerprintService f198a = ITranFingerprintService.Stub.asInterface(TranServiceManager.getServiceIBinder("fingerprint"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TranFingerprintManager f199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f200c;

    @Override // tf.a
    public boolean a() {
        try {
            return this.f198a.isAuthenticating();
        } catch (RemoteException e10) {
            e.o(f197d, "isAuthenticating: ", e10);
            return false;
        }
    }

    @Override // tf.a
    public void b(boolean z10) {
        ITranFingerprintService iTranFingerprintService = this.f198a;
        if (iTranFingerprintService != null) {
            try {
                iTranFingerprintService.enterFingerNavigationMode(z10);
            } catch (RemoteException e10) {
                e.d(f197d, "enterFingerNavigationMode: ", e10);
            }
        }
    }

    @Override // tf.a
    public List<TranFingerprintInfo> c(int i10) {
        ArrayList arrayList = new ArrayList();
        List<TranFingerprint> enrolledFingerprints = p().getEnrolledFingerprints(i10);
        if (enrolledFingerprints == null) {
            return arrayList;
        }
        for (TranFingerprint tranFingerprint : enrolledFingerprints) {
            TranFingerprintInfo tranFingerprintInfo = new TranFingerprintInfo();
            tranFingerprintInfo.k(tranFingerprintInfo.e());
            tranFingerprintInfo.j(tranFingerprint.getName());
            tranFingerprintInfo.f(tranFingerprint.getAppPkgName());
            tranFingerprintInfo.h(tranFingerprint.getDeviceId());
            tranFingerprintInfo.i(tranFingerprint.getGroupId());
            tranFingerprintInfo.g(tranFingerprint.getBiometricId());
            arrayList.add(tranFingerprintInfo);
        }
        return arrayList;
    }

    @Override // tf.a
    public void d(int i10, String str) {
        p().setAppBiometrics(i10, str);
    }

    @Override // tf.a
    public void e(int i10) {
        p().startAppForFp(i10);
    }

    @Override // tf.a
    public void f(int i10) {
        ITranFingerprintService iTranFingerprintService = this.f198a;
        if (iTranFingerprintService != null) {
            try {
                iTranFingerprintService.setUdfpColor(i10);
            } catch (RemoteException e10) {
                e.d(f197d, "setUdfpColor: ", e10);
            }
        }
    }

    @Override // tf.a
    public void g(boolean z10) {
        try {
            this.f198a.notifyActivateFingerprint(z10);
        } catch (RemoteException e10) {
            e.o(f197d, "notifyActivateFingerprint: ", e10);
        }
    }

    @Override // tf.a
    public String h(int i10) {
        return p().getAppPackagename(i10);
    }

    @Override // tf.a
    public void i(String str, boolean z10) {
        try {
            this.f198a.setMyClientVisible(str, z10);
        } catch (RemoteException e10) {
            e.d(f197d, "setMyClientVisible: ", e10);
        }
    }

    @Override // tf.a
    public int j(FingerprintManager.AuthenticationResult authenticationResult) {
        return new i7.a().j(authenticationResult);
    }

    @Override // tf.a
    public void k(boolean z10) {
        p().setKeyguardClientVisible(z10);
    }

    @Override // tf.a
    public TranFingerprintInfo l(int i10) {
        TranFingerprint addFingerprint = p().getAddFingerprint(i10);
        if (addFingerprint == null) {
            return null;
        }
        TranFingerprintInfo tranFingerprintInfo = new TranFingerprintInfo();
        tranFingerprintInfo.k(tranFingerprintInfo.e());
        tranFingerprintInfo.j(addFingerprint.getName());
        tranFingerprintInfo.f(addFingerprint.getAppPkgName());
        tranFingerprintInfo.h(addFingerprint.getDeviceId());
        tranFingerprintInfo.i(addFingerprint.getGroupId());
        tranFingerprintInfo.g(addFingerprint.getBiometricId());
        return tranFingerprintInfo;
    }

    @Override // tf.a
    public void m(int i10, String str, int i11) {
        p().setAppAndUserIdForBiometrics(i10, str, i11);
    }

    @Override // tf.a
    public boolean n() {
        return p().isClientActive();
    }

    @Override // tf.a
    public int o(int i10) {
        return p().getAppUserId(i10);
    }

    public final TranFingerprintManager p() {
        this.f200c = bc.a.a();
        if (this.f199b == null) {
            this.f199b = new TranFingerprintManager(this.f200c);
        }
        return this.f199b;
    }

    @VisibleForTesting
    public void q(ITranFingerprintService iTranFingerprintService) {
        this.f198a = iTranFingerprintService;
    }
}
