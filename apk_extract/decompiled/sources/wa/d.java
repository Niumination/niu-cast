package wa;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.transsion.connectx.sdk.BackupFileStatusListener;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.DialogUtilActivity;
import java.util.LinkedHashSet;
import k3.fd;
import k3.gc;
import k3.pb;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import m3.m;
import na.k;
import tj.w;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends BackupFileStatusListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Integer f10698c;
    public static int e;
    public static long f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f10697b = new d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LinkedHashSet f10699d = new LinkedHashSet();

    @Override // com.transsion.connectx.sdk.BackupFileListener
    public final void onCancel(long j8, boolean z2) {
        String log = "onCancel: " + j8 + " isRemoteCancel: " + z2;
        Intrinsics.checkNotNullParameter("BackupNotificationManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("BackupNotificationManager"), log);
        }
        c.a();
        if (z2) {
            Application applicationA = pb.a();
            Intrinsics.checkNotNullParameter("BackupNotificationManager", "tag");
            Intrinsics.checkNotNullParameter("backup toastCancel", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("BackupNotificationManager"), "backup toastCancel");
            }
            String string = applicationA.getResources().getString(R$string.bkp_gallery_backup_cancel);
            k kVar = k.f8141a;
            Intrinsics.checkNotNull(string);
            kVar.d(applicationA, string);
            ob.b.f8417b.a("pc");
        }
        f10699d.clear();
    }

    @Override // com.transsion.connectx.sdk.BackupFileListener
    public final void onFail(long j8, int i8) {
        String log = "onFail: " + j8 + " reason: " + i8;
        Intrinsics.checkNotNullParameter("BackupNotificationManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("BackupNotificationManager"), log);
        }
        if (i8 == 1) {
            Integer num = f10698c;
            if (num != null && num.intValue() == 0) {
                boolean z2 = DialogUtilActivity.f2733j;
                fd.a(pb.a());
            }
        } else {
            Application applicationA = pb.a();
            Intrinsics.checkNotNullParameter("BackupNotificationManager", "tag");
            Intrinsics.checkNotNullParameter("backup toastFail", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("BackupNotificationManager"), "backup toastFail");
            }
            String string = applicationA.getResources().getString(R$string.bkp_gallery_backup_fail);
            k kVar = k.f8141a;
            Intrinsics.checkNotNull(string);
            kVar.d(applicationA, string);
        }
        Integer num2 = f10698c;
        if (num2 != null && num2.intValue() == 0) {
            ob.b bVar = ob.b.f8417b;
            int i9 = ob.b.G;
            int i10 = i9 - ob.b.H;
            bVar.f8437a.getClass();
            Bundle bundleA = w.A();
            bundleA.putInt("selected_files_num", i9);
            bundleA.putInt("failed_files_num", i10);
            w.X("iot_pc_con_backup_manual_fail", bundleA);
        }
        c.a();
        f10699d.clear();
    }

    @Override // com.transsion.connectx.sdk.BackupFileListener
    public final void onFinish(long j8) {
        String log = "onFinish: " + j8;
        Intrinsics.checkNotNullParameter("BackupNotificationManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("BackupNotificationManager"), log);
        }
        c.a();
        Integer num = f10698c;
        if (num == null || num.intValue() != 0) {
            ob.b bVar = ob.b.f8417b;
            int i8 = ob.b.G;
            bVar.f8437a.getClass();
            Bundle bundleA = w.A();
            bundleA.putInt("selected_files_num", i8);
            w.X("iot_pc_con_backup_auto_finish", bundleA);
        }
        LinkedHashSet linkedHashSet = f10699d;
        if (linkedHashSet.size() == e) {
            long jCurrentTimeMillis = (System.currentTimeMillis() - f) / ((long) 1000);
            ob.b bVar2 = ob.b.f8417b;
            int i9 = ob.b.G;
            bVar2.f8437a.getClass();
            Bundle bundleA2 = w.A();
            bundleA2.putInt("selected_files_num", i9);
            bundleA2.putLong("backup_time", jCurrentTimeMillis);
            w.X("iot_pc_con_backup_manual_success", bundleA2);
            Application applicationA = pb.a();
            Intrinsics.checkNotNullParameter("BackupNotificationManager", "tag");
            Intrinsics.checkNotNullParameter("backup toastSuccess", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("BackupNotificationManager"), "backup toastSuccess");
            }
            String string = applicationA.getResources().getString(R$string.bkp_gallery_backup_success);
            k kVar = k.f8141a;
            Intrinsics.checkNotNull(string);
            kVar.d(applicationA, string);
        } else {
            Application applicationA2 = pb.a();
            Intrinsics.checkNotNullParameter("BackupNotificationManager", "tag");
            Intrinsics.checkNotNullParameter("backup toastFinish", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("BackupNotificationManager"), "backup toastFinish");
            }
            String string2 = applicationA2.getResources().getString(R$string.bkp_gallery_backup_finish);
            k kVar2 = k.f8141a;
            Intrinsics.checkNotNull(string2);
            kVar2.d(applicationA2, string2);
        }
        linkedHashSet.clear();
    }

    @Override // com.transsion.connectx.sdk.BackupFileListener
    public final void onProgress(long j8, double d7, int i8, final int i9) {
        int iIntValue;
        gc.a("BackupNotificationManager", "onProgress：" + j8 + " progress: " + d7 + " currentFileIndex: " + i8 + " totalFileCount: " + i9);
        e = i9;
        LinkedHashSet linkedHashSet = f10699d;
        if (d7 == 1.0d) {
            linkedHashSet.add(Integer.valueOf(i8));
        }
        final int i10 = (int) (d7 * ((double) 100));
        Integer num = f10698c;
        if (num != null) {
            iIntValue = num.intValue();
        } else {
            gc.d("BackupNotificationManager", "Backup type not set");
            iIntValue = 0;
        }
        final int i11 = iIntValue;
        NotificationManager notificationManager = c.f10693a;
        final Application context = pb.a();
        final int i12 = i8 + 1;
        linkedHashSet.size();
        Intrinsics.checkNotNullParameter(context, "context");
        Function0 event = new Function0() { // from class: wa.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Handler handler = (Handler) c.f.getValue();
                final int i13 = i12;
                final int i14 = i9;
                final Application application = context;
                final int i15 = i10;
                final int i16 = i11;
                handler.post(new Runnable() { // from class: wa.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        NotificationManager notificationManager2 = c.f10693a;
                        int i17 = i16;
                        Application application2 = application;
                        int i18 = i15;
                        c.b(application2, i18, i17);
                        String string = application2.getString(R$string.bkp_backuping, String.valueOf(i13), String.valueOf(i14));
                        Intrinsics.checkNotNull(string);
                        RemoteViews remoteViews = c.f10694b;
                        if (remoteViews != null) {
                            remoteViews.setTextViewText(R$id.backup_progress_number, string);
                            remoteViews.setTextViewText(R$id.backup_notification_title, pb.a().getString(R$string.bkp_gallery_backup));
                            remoteViews.setProgressBar(R$id.backup_notification_pBar, 100, i18, false);
                        }
                        RemoteViews remoteViews2 = c.f10695c;
                        if (remoteViews2 != null) {
                            remoteViews2.setTextViewText(R$id.backup_progress_number, string);
                            remoteViews2.setTextViewText(R$id.backup_notification_title, pb.a().getString(R$string.bkp_gallery_backup));
                            remoteViews2.setProgressBar(R$id.backup_notification_pBar, 100, i18, false);
                        }
                        NotificationManager notificationManager3 = c.f10693a;
                        if (notificationManager3 != null) {
                            notificationManager3.notify(2, c.f10696d);
                        }
                        m.f7774a = true;
                    }
                });
                return Unit.INSTANCE;
            }
        };
        e eVar = c.e;
        eVar.getClass();
        Intrinsics.checkNotNullParameter(event, "event");
        if (i10 != eVar.f10703d || i12 != eVar.f10700a) {
            eVar.f10703d = i10;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j10 = jElapsedRealtime - eVar.f10702c;
            if (j10 > CoroutineLiveDataKt.DEFAULT_TIMEOUT) {
                eVar.f10702c = jElapsedRealtime;
            } else if (i10 - eVar.f10701b >= 4 || i12 != eVar.f10700a) {
                if (eVar.f10700a != i12) {
                    eVar.f10700a = i12;
                }
                eVar.f10701b = i10;
                if (j10 >= 1500) {
                    eVar.f10702c = jElapsedRealtime;
                }
            }
            event.invoke();
        }
        ob.b bVar = ob.b.f8417b;
        int i13 = e;
        int size = linkedHashSet.size();
        bVar.getClass();
        ob.b.G = i13;
        ob.b.H = size;
    }

    @Override // com.transsion.connectx.sdk.BackupFileListener
    public final void onStart(long j8, int i8) {
        String log = "onStart taskId: " + j8 + " backupType: " + i8;
        Intrinsics.checkNotNullParameter("BackupNotificationManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("BackupNotificationManager"), log);
        }
        f10698c = Integer.valueOf(i8);
        f10699d.clear();
        f = System.currentTimeMillis();
        NotificationManager notificationManager = c.f10693a;
        Object systemService = pb.a().getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        c.f10693a = (NotificationManager) systemService;
        NotificationChannel notificationChannel = new NotificationChannel("Backup_ChannelId_High", "Backup_ChannelName_High", 4);
        NotificationManager notificationManager2 = c.f10693a;
        if (notificationManager2 != null) {
            notificationManager2.createNotificationChannel(notificationChannel);
        }
        NotificationChannel notificationChannel2 = new NotificationChannel("Backup_ChannelId_Low", "Backup_ChannelName_Low", 2);
        NotificationManager notificationManager3 = c.f10693a;
        if (notificationManager3 != null) {
            notificationManager3.createNotificationChannel(notificationChannel2);
        }
        c.b(pb.a(), 0, i8);
        if (i8 != 0) {
            ob.b.f8417b.f8437a.getClass();
            w.X("iot_pc_con_auto_backup_task_start", w.A());
        }
    }
}
