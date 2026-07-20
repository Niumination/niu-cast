package ic;

import android.os.RemoteException;
import androidx.core.app.NotificationCompat;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.app.ITranAlarmManager;

/* JADX INFO: loaded from: classes2.dex */
public class h1 implements bf.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7811b = "h1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranAlarmManager f7812a = ITranAlarmManager.Stub.asInterface(TranServiceManager.getServiceIBinder(NotificationCompat.CATEGORY_ALARM));

    @Override // bf.i
    public void a(String str) {
        ITranAlarmManager iTranAlarmManager = this.f7812a;
        if (iTranAlarmManager == null) {
            return;
        }
        try {
            iTranAlarmManager.cancelPoweroffAlarm(str);
        } catch (RemoteException e10) {
            j7.b.a("cancelPoweroffAlarm fail ", e10, f7811b);
        }
    }
}
