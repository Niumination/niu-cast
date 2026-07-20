package ic;

import android.app.NotificationChannel;
import androidx.core.app.NotificationManagerCompat;
import com.transsion.hubsdk.app.TranNotificationChannel;

/* JADX INFO: loaded from: classes2.dex */
public class k1 implements bf.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranNotificationChannel f7823a;

    public k1() {
        this.f7823a = null;
        this.f7823a = new TranNotificationChannel();
    }

    @Override // bf.m
    public int a(NotificationChannel notificationChannel) {
        TranNotificationChannel tranNotificationChannel = this.f7823a;
        return tranNotificationChannel != null ? tranNotificationChannel.getOriginalImportance(notificationChannel) : NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
    }

    @Override // bf.m
    public void b(NotificationChannel notificationChannel, int i10) {
        this.f7823a.lockFields(notificationChannel, i10);
    }
}
