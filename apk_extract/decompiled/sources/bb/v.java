package bb;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Handler;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.transsion.iotservice.multiscreen.pc.R$drawable;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.pcconnect.invoke.bridge.Device;
import eb.g0;
import k3.pb;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NotificationManager f1256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Notification.Builder f1257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f1258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f1259d;
    public static boolean e;
    public static boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f1260g;

    static {
        Object systemService = pb.a().getSystemService(NotificationManager.class);
        Intrinsics.checkNotNullExpressionValue(systemService, "getSystemService(...)");
        NotificationManager notificationManager = (NotificationManager) systemService;
        f1256a = notificationManager;
        f1258c = "";
        f1259d = true;
        e = true;
        f = true;
        NotificationChannel notificationChannel = new NotificationChannel("cast_screen_notification", "cast_screen", 3);
        notificationChannel.setSound(null, null);
        notificationChannel.enableVibration(false);
        notificationChannel.setLockscreenVisibility(1);
        notificationManager.createNotificationChannel(notificationChannel);
        f1260g = LazyKt.lazy(new s(0));
    }

    public static void a() {
        ((Handler) f1260g.getValue()).post(new t(1));
    }

    public static void b() {
        Notification.Builder builder = new Notification.Builder(pb.a(), "cast_screen_notification");
        builder.setSmallIcon(R$drawable.notification_logo);
        builder.setOngoing(true);
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle(va.b.d(R$string.pad_pad_connect, new int[0]));
        builder.setContentText(pb.a().getString(R$string.md_connect_tip3, new Object[]{f1258c}));
        builder.setVisibility(1);
        builder.setStyle(new Notification.MediaStyle());
        Intent intent = new Intent("com.transsion.iotcard.tCircle");
        intent.setPackage("com.transsion.iotcard");
        Device device = g0.f;
        if (device != null) {
            intent.putExtra("deviceId", device.f2947a);
            intent.putExtra("deviceName", device.f2948b);
        }
        builder.setContentIntent(PendingIntent.getActivity(pb.a(), 0, intent, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL));
        f1257b = builder;
    }

    public static void c(boolean z2, boolean z3) {
        ((Handler) f1260g.getValue()).post(new u(z2, z3, false));
    }
}
