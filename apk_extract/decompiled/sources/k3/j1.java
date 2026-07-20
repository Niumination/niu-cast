package k3;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.core.app.NotificationCompat;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class j1 {
    public static boolean a(d6.o handlerHolder, String name) {
        Intrinsics.checkNotNullParameter(handlerHolder, "handlerHolder");
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            HandlerThread handlerThread = handlerHolder.f4334a;
            if (handlerThread != null && handlerThread.isAlive()) {
                return true;
            }
            HandlerThread handlerThread2 = new HandlerThread(name);
            handlerThread2.start();
            handlerHolder.f4335b = new Handler(handlerThread2.getLooper());
            Unit unit = Unit.INSTANCE;
            handlerHolder.f4334a = handlerThread2;
            return true;
        } catch (OutOfMemoryError tr) {
            Intrinsics.checkNotNullParameter("AnimPlayer.Decoder", "tag");
            Intrinsics.checkNotNullParameter("createThread OOM", NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(tr, "tr");
            return false;
        }
    }
}
