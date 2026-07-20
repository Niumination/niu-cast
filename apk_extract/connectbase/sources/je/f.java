package je;

import android.telephony.NetworkRegistrationInfo;
import com.transsion.hubsdk.telephony.TranNetworkRegistrationInfo;

/* JADX INFO: loaded from: classes2.dex */
public class f implements dh.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranNetworkRegistrationInfo f8683a = new TranNetworkRegistrationInfo();

    @Override // dh.c
    public boolean a(NetworkRegistrationInfo networkRegistrationInfo) {
        TranNetworkRegistrationInfo tranNetworkRegistrationInfo = this.f8683a;
        if (tranNetworkRegistrationInfo != null) {
            return tranNetworkRegistrationInfo.isInService(networkRegistrationInfo);
        }
        return false;
    }
}
