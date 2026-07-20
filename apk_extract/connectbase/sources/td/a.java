package td;

import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteException;
import android.service.notification.NotificationListenerService;
import com.transsion.hubsdk.notification.TranNotificationListenerService;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ng.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f15555b = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranNotificationListenerService f15556a;

    public a(NotificationListenerService notificationListenerService) {
        this.f15556a = null;
        this.f15556a = new TranNotificationListenerService(notificationListenerService);
    }

    @Override // ng.a
    public void a(Context context, ComponentName componentName, int i10) {
        try {
            this.f15556a.registerAsSystemService(context, componentName, i10);
        } catch (RemoteException e10) {
            j7.b.a("registerAsSystemService fail", e10, f15555b);
        }
    }

    @Override // ng.a
    public void b() {
        try {
            this.f15556a.unregisterAsSystemService();
        } catch (RemoteException e10) {
            j7.b.a("unregisterAsSystemService fail", e10, f15555b);
        }
    }
}
