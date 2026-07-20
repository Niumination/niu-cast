package wa;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import bb.t;
import com.transsion.iotservice.multiscreen.pc.R$drawable;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.file_backup.CancelBackupReceiver;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import k3.gc;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import m3.m;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static NotificationManager f10693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static RemoteViews f10694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static RemoteViews f10695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Notification f10696d;
    public static final e e;
    public static final Lazy f;

    static {
        e eVar = new e();
        eVar.f10702c = SystemClock.elapsedRealtime();
        e = eVar;
        f = LazyKt.lazy(new ob.c(18));
    }

    public static void a() {
        ((Handler) f.getValue()).post(new t(11));
    }

    public static void b(Application context, int i8, int i9) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (f10696d != null) {
            Intrinsics.checkNotNullParameter("BackupNotification", "tag");
            Intrinsics.checkNotNullParameter("initBackupNotification: already init", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("BackupNotification"), "initBackupNotification: already init");
                return;
            }
            return;
        }
        gc.a("BackupNotification", "initBackupNotification");
        Pair pair = na.c.a() ? TuplesKt.to(Integer.valueOf(R$layout.module_backup_notification_xos_layout), Integer.valueOf(R$layout.module_backup_notification_xos_big_layout)) : TuplesKt.to(Integer.valueOf(R$layout.module_backup_notification_hios_layout), Integer.valueOf(R$layout.module_backup_notification_hios_big_layout));
        int iIntValue = ((Number) pair.component1()).intValue();
        int iIntValue2 = ((Number) pair.component2()).intValue();
        f10694b = new RemoteViews(context.getPackageName(), iIntValue);
        f10695c = new RemoteViews(context.getPackageName(), iIntValue2);
        RemoteViews remoteViews = f10694b;
        if (remoteViews != null) {
            int i10 = R$id.backup_notification_close;
            int i11 = R$attr.os_platform_basic_color;
            int i12 = R$color.os_platform_basic_color_hios;
            String[] strArr = j.f8764a;
            remoteViews.setTextColor(i10, j.d(i11, context.getColor(i12), context));
        }
        RemoteViews remoteViews2 = f10695c;
        if (remoteViews2 != null) {
            int i13 = R$id.backup_notification_close;
            int i14 = R$attr.os_platform_basic_color;
            int i15 = R$color.os_platform_basic_color_hios;
            String[] strArr2 = j.f8764a;
            remoteViews2.setTextColor(i13, j.d(i14, context.getColor(i15), context));
        }
        String str = i9 == 0 ? "Backup_ChannelId_High" : "Backup_ChannelId_Low";
        gc.a("BackupNotification", "initNotification: channelId = ".concat(str));
        f10696d = new NotificationCompat.Builder(context, str).setSmallIcon(R$drawable.notification_logo).setContentTitle(context.getResources().getString(R$string.module_pc_connect)).setWhen(System.currentTimeMillis()).setOnlyAlertOnce(true).setCustomContentView(f10694b).setCustomBigContentView(f10695c).setProgress(100, i8, false).build();
        Intent intent = new Intent(context, (Class<?>) CancelBackupReceiver.class);
        Intrinsics.checkNotNullParameter("BackupNotification", "tag");
        Intrinsics.checkNotNullParameter("addClick cancel backup_notification", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("BackupNotification"), "addClick cancel backup_notification");
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 1, intent, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        RemoteViews remoteViews3 = f10695c;
        if (remoteViews3 != null) {
            remoteViews3.setOnClickPendingIntent(R$id.backup_notification_close, broadcast);
        }
        m.f7774a = true;
    }
}
