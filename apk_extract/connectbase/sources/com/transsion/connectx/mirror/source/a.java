package com.transsion.connectx.mirror.source;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.RemoteViews;
import com.transsion.connectx.mirror.source.activity.ExtendScreenActivity;
import com.transsion.connectx.mirror.source.service.SourceService;
import java.util.Random;
import oa.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f1884i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f1885j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f1886k = 120;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f1887l = 121;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NotificationManager f1888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RemoteViews f1889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RemoteViews f1890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Notification f1891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Notification f1892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public EnumC0075a f1895h;

    /* JADX INFO: renamed from: com.transsion.connectx.mirror.source.a$a, reason: collision with other inner class name */
    public enum EnumC0075a {
        CONNECT_MODE_EXTEND,
        CONNECT_MODE_MIRROR
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f1897a = new a();
    }

    public static a e() {
        return b.f1897a;
    }

    public final RemoteViews a(Context context) {
        RemoteViews remoteViews = new RemoteViews(w4.b.f17953b, R.layout.notification_big_view);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 120, new Intent(SourceService.f2176y), e.f12145r);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(context, 121, new Intent(SourceService.f2177z), e.f12145r);
        remoteViews.setOnClickPendingIntent(R.id.btn_exit, broadcast);
        remoteViews.setOnClickPendingIntent(R.id.btn_toggle_audio, broadcast2);
        i(remoteViews);
        return remoteViews;
    }

    public final RemoteViews b(Context context) {
        RemoteViews remoteViews = new RemoteViews(w4.b.f17953b, R.layout.notification_view);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 120, new Intent(SourceService.f2176y), e.f12145r);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(context, 121, new Intent(SourceService.f2177z), e.f12145r);
        remoteViews.setOnClickPendingIntent(R.id.btn_exit, broadcast);
        remoteViews.setOnClickPendingIntent(R.id.btn_toggle_audio, broadcast2);
        i(remoteViews);
        return remoteViews;
    }

    @b.a({"NewApi"})
    public final void c() {
        Application applicationB = SourceApplication.b();
        NotificationChannel notificationChannel = new NotificationChannel("cast_screen_notification", "cast_screen", 5);
        notificationChannel.setSound(null, null);
        notificationChannel.enableVibration(false);
        this.f1888a.createNotificationChannel(notificationChannel);
        Notification.Builder builder = new Notification.Builder(applicationB, notificationChannel.getId());
        Intent intent = new Intent();
        this.f1889b = b(applicationB);
        this.f1890c = a(applicationB);
        builder.setContentIntent(PendingIntent.getActivity(applicationB, 0, intent, e.f12145r)).setSmallIcon(R.drawable.ic_airlink).setOngoing(true).setPriority(2).setCustomContentView(this.f1889b).setCustomBigContentView(this.f1890c).setWhen(System.currentTimeMillis());
        this.f1891d = builder.build();
        int iNextInt = new Random(1000L).nextInt();
        this.f1893f = iNextInt;
        this.f1888a.notify(iNextInt, this.f1891d);
    }

    public void d() {
        this.f1888a.cancelAll();
        this.f1889b = null;
        this.f1890c = null;
        this.f1891d = null;
        this.f1893f = -1;
        this.f1895h = null;
        this.f1892e = null;
        this.f1894g = -1;
    }

    public void f(EnumC0075a enumC0075a) {
        if (this.f1891d != null) {
            j(enumC0075a);
        } else {
            this.f1895h = enumC0075a;
            c();
        }
    }

    public void g() {
        Application applicationB = SourceApplication.b();
        NotificationChannel notificationChannel = new NotificationChannel("extend_screen_notification", "extend_screen", 4);
        notificationChannel.setSound(null, null);
        notificationChannel.enableVibration(false);
        this.f1888a.createNotificationChannel(notificationChannel);
        Notification.Builder builder = new Notification.Builder(applicationB, notificationChannel.getId());
        builder.setContentIntent(PendingIntent.getActivity(applicationB, 0, new Intent(applicationB, (Class<?>) ExtendScreenActivity.class), e.f12145r)).setSmallIcon(R.drawable.ic_airlink).setOngoing(true).setPriority(2).setContentTitle(applicationB.getResources().getString(R.string.module_pc_connect)).setContentText(String.format(applicationB.getResources().getString(R.string.pad_extend_connecting), "PC")).setWhen(System.currentTimeMillis());
        this.f1892e = builder.build();
        int iNextInt = new Random(1000L).nextInt();
        this.f1894g = iNextInt;
        this.f1888a.notify(iNextInt, this.f1892e);
    }

    public void h(int i10) {
        Resources resources = SourceApplication.b().getResources();
        m2.b.a("updateAudioState:", i10, "TAG");
        if (i10 == 1) {
            k(resources.getString(R.string.toggle_audio_phone));
        } else {
            k(resources.getString(R.string.toggle_audio_pc));
        }
    }

    public final void i(RemoteViews remoteViews) {
        if (remoteViews == null) {
            return;
        }
        if (this.f1895h == EnumC0075a.CONNECT_MODE_EXTEND) {
            remoteViews.setViewVisibility(R.id.btn_toggle_audio, 8);
            remoteViews.setViewVisibility(R.id.tv_toggle_audio, 8);
            remoteViews.setTextViewText(R.id.tv_content, String.format(SourceApplication.b().getResources().getString(R.string.pad_extend_connecting), "PC"));
        } else {
            remoteViews.setViewVisibility(R.id.btn_toggle_audio, 0);
            remoteViews.setViewVisibility(R.id.tv_toggle_audio, 0);
            remoteViews.setTextViewText(R.id.tv_content, SourceApplication.b().getResources().getString(R.string.notification_cast_content));
        }
    }

    public void j(EnumC0075a enumC0075a) {
        if (this.f1895h == enumC0075a) {
            return;
        }
        this.f1895h = enumC0075a;
        i(this.f1889b);
        i(this.f1890c);
        this.f1888a.notify(this.f1893f, this.f1891d);
    }

    public final void k(String str) {
        RemoteViews remoteViews = this.f1889b;
        if (remoteViews == null || this.f1891d == null || this.f1893f == -1 || this.f1890c == null) {
            return;
        }
        remoteViews.setTextViewText(R.id.tv_toggle_audio, str);
        this.f1890c.setTextViewText(R.id.tv_toggle_audio, str);
        this.f1888a.notify(this.f1893f, this.f1891d);
    }

    public a() {
        this.f1893f = -1;
        this.f1894g = -1;
        this.f1895h = null;
        this.f1888a = (NotificationManager) SourceApplication.b().getSystemService(NotificationManager.class);
    }
}
