package p9;

import android.os.RemoteException;
import android.os.UserHandle;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.location.ITranLocationManager;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements aa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ITranLocationManager f8702a = ITranLocationManager.Stub.asInterface(TranServiceManager.getServiceIBinder("location"));

    @Override // aa.a
    public final void a() {
        UserHandle userHandle = z8.a.f11265a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            b();
        } catch (RemoteException e) {
            g9.a.d("location", e);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jCurrentTimeMillis2 >= 200) {
            g9.a.e("location", jCurrentTimeMillis2);
        }
        j9.a.a("a", "setLocationEnabledForUser sucess");
    }

    public final /* synthetic */ void b() {
        UserHandle userHandle = z8.a.f11265a;
        ITranLocationManager iTranLocationManager = this.f8702a;
        if (iTranLocationManager != null) {
            iTranLocationManager.setLocationEnabledForUser(true, userHandle);
        }
    }
}
