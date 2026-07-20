package q9;

import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.net.ITranConnectivityManager;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ba.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ITranConnectivityManager f8965a = ITranConnectivityManager.Stub.asInterface(TranServiceManager.getServiceIBinder("connectivity"));

    public final /* synthetic */ Object a() {
        ITranConnectivityManager iTranConnectivityManager = this.f8965a;
        if (iTranConnectivityManager != null) {
            return iTranConnectivityManager.getTetherableUsbRegexs();
        }
        return null;
    }

    @Override // ba.a
    public final String[] getTetherableUsbRegexs() {
        Object objA;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            objA = a();
        } catch (RemoteException e) {
            g9.a.d("connectivity", e);
            objA = null;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jCurrentTimeMillis2 >= 200) {
            g9.a.e("connectivity", jCurrentTimeMillis2);
        }
        String[] strArr = (String[]) objA;
        j9.a.c("a", "getTetherableUsbRegexs result:" + Arrays.toString(strArr));
        return strArr;
    }

    @Override // ba.a
    public final void k(boolean z2) {
        try {
            this.f8965a.setUsbTethering(z2);
        } catch (RemoteException e) {
            j9.a.b("a", "setUsbTethering fail " + e);
        }
    }
}
