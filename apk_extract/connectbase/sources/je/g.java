package je;

import android.telephony.ServiceState;
import com.transsion.hubsdk.telephony.TranServiceStateExt;

/* JADX INFO: loaded from: classes2.dex */
public class g implements dh.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranServiceStateExt f8684a = new TranServiceStateExt();

    @Override // dh.d
    public int a(ServiceState serviceState) {
        TranServiceStateExt tranServiceStateExt = this.f8684a;
        if (tranServiceStateExt != null) {
            return tranServiceStateExt.getDataNetworkType(serviceState);
        }
        return 0;
    }

    @Override // dh.d
    public int b(ServiceState serviceState) {
        TranServiceStateExt tranServiceStateExt = this.f8684a;
        if (tranServiceStateExt != null) {
            return tranServiceStateExt.getVoiceRegState(serviceState);
        }
        return 0;
    }
}
