package bb;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.pcconnect.invoke.bridge.Device;
import eb.g0;
import k3.gc;
import k3.pb;
import k3.sb;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f1253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f1254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f1255c;

    public /* synthetic */ u(boolean z2, boolean z3, boolean z5) {
        this.f1253a = z2;
        this.f1254b = z3;
        this.f1255c = z5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        Intent intent;
        StringBuilder sb2 = new StringBuilder("setCastNotification: isCast:");
        boolean z2 = this.f1253a;
        sb2.append(z2);
        sb2.append(", isMirror:");
        boolean z3 = this.f1254b;
        sb2.append(z3);
        sb2.append(", isJumpExtend:");
        boolean z5 = this.f1255c;
        sb2.append(z5);
        String log = sb2.toString();
        Intrinsics.checkNotNullParameter("CastStatusNotificationManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("CastStatusNotificationManager"), log);
        }
        String string = pb.a().getString(R$string.pad_connect_device, new Object[]{v.f1258c});
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (z2) {
            string = pb.a().getString(R$string.md_connect_tip3, new Object[]{v.f1258c});
        }
        Notification.Builder builder = v.f1257b;
        if (builder != null) {
            builder.setContentText(string);
            if (!sb.b()) {
                if (z5) {
                    str = "com.transsion.connectx.EXTEND_SCREEN";
                } else {
                    str = !z2 ? "com.transsion.iotservice.CAST_CONTROL_DIALOG" : "";
                }
                if (Intrinsics.areEqual(str, "com.transsion.iotservice.CAST_CONTROL_DIALOG")) {
                    intent = new Intent("com.transsion.iotcard.tCircle");
                    intent.setPackage("com.transsion.iotcard");
                    Device device = g0.f;
                    if (device != null) {
                        intent.putExtra("deviceId", device.f2947a);
                        intent.putExtra("deviceName", device.f2948b);
                    }
                } else {
                    intent = new Intent(str);
                }
                builder.setContentIntent(PendingIntent.getActivity(pb.a(), 0, intent, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL));
            }
            v.f1256a.notify(144, builder.build());
            v.f1259d = z2;
            v.e = z3;
            v.f = z5;
        }
    }
}
