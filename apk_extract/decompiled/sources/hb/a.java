package hb;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.transsion.iotservice.multiscreen.pc.R$drawable;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.notification.CancelTransferReceiver;
import k3.gc;
import k3.pb;
import kotlin.jvm.internal.Intrinsics;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NotificationManager f5276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RemoteViews f5277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Notification f5278c;

    public final void a(Application application, int i8) {
        Bundle bundle;
        if (this.f5278c != null) {
            Intrinsics.checkNotNullParameter("TransferNotification", "tag");
            Intrinsics.checkNotNullParameter("initNotification: already init", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("TransferNotification"), "initNotification: already init");
                return;
            }
            return;
        }
        Intrinsics.checkNotNullParameter("TransferNotification", "tag");
        Intrinsics.checkNotNullParameter("initNotification", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("TransferNotification"), "initNotification");
        }
        RemoteViews remoteViews = new RemoteViews(pb.a().getPackageName(), R$layout.module_air_transfer_notification);
        this.f5277b = remoteViews;
        remoteViews.setTextColor(R$id.tv_notification_close, j.h(application));
        Notification notificationBuild = new NotificationCompat.Builder(application, "WelinkService_ChannelId").setSmallIcon(R$drawable.notification_logo).setContentTitle(application.getResources().getString(R$string.module_pc_connect)).setWhen(System.currentTimeMillis()).setOnlyAlertOnce(true).setAutoCancel(true).setCustomContentView(this.f5277b).setCustomBigContentView(this.f5277b).setProgress(100, i8, false).build();
        this.f5278c = notificationBuild;
        if (notificationBuild != null && (bundle = notificationBuild.extras) != null) {
            bundle.putString("welink_notification_title", application.getResources().getString(R$string.module_pc_connect));
        }
        Intent intent = new Intent(application, (Class<?>) CancelTransferReceiver.class);
        Intrinsics.checkNotNullParameter("TransferNotification", "tag");
        Intrinsics.checkNotNullParameter("addClick cancel notification", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("TransferNotification"), "addClick cancel notification");
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(application, 0, intent, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        RemoteViews remoteViews2 = this.f5277b;
        if (remoteViews2 != null) {
            remoteViews2.setOnClickPendingIntent(R$id.tv_notification_close, broadcast);
        }
    }

    public final void b(Application application, int i8) {
        RemoteViews remoteViews;
        if (i8 != 3) {
            if (i8 == 5 && (remoteViews = this.f5277b) != null) {
                remoteViews.setTextViewText(R$id.notification_title, application.getResources().getString(R$string.module_pc_swift_copy));
                return;
            }
            return;
        }
        RemoteViews remoteViews2 = this.f5277b;
        if (remoteViews2 != null) {
            remoteViews2.setTextViewText(R$id.notification_title, application.getResources().getString(R$string.module_pc_swift_send));
        }
    }
}
