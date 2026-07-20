package k3;

import android.app.Application;
import android.os.PowerManager;
import android.util.Log;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PowerManager.WakeLock f6571a;

    public static void a(Application context) {
        PowerManager.WakeLock wakeLockNewWakeLock;
        Intrinsics.checkNotNullParameter(context, "context");
        PowerManager.WakeLock wakeLock = f6571a;
        if (wakeLock != null && wakeLock.isHeld()) {
            Intrinsics.checkNotNullParameter("WakeLockHelper", "tag");
            Intrinsics.checkNotNullParameter("release power wake lock", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("WakeLockHelper"), "release power wake lock");
            }
            wakeLock.release();
        }
        f6571a = null;
        PowerManager powerManager = (PowerManager) ContextCompat.getSystemService(context, PowerManager.class);
        if (powerManager == null || (wakeLockNewWakeLock = powerManager.newWakeLock(1, "PCConnect::WakeLock")) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter("WakeLockHelper", "tag");
        Intrinsics.checkNotNullParameter("run power wake lock acquire", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("WakeLockHelper"), "run power wake lock acquire");
        }
        f6571a = wakeLockNewWakeLock;
        wakeLockNewWakeLock.acquire();
    }
}
