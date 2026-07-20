package dc;

import android.util.Log;
import java.util.concurrent.ConcurrentLinkedQueue;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;
import li.h0;
import li.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f4411a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentLinkedQueue f4412b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f4413c = true;

    static {
        v0 v0Var = v0.f7498a;
        h0.a(si.e.f10118a);
    }

    public final synchronized void a(Runnable event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String log = "addEvent：isRunning:" + f4413c;
        Intrinsics.checkNotNullParameter("MultiEventQuene", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("MultiEventQuene"), log);
        }
        if (f4413c) {
            f4412b.offer(event);
        } else {
            event.run();
        }
    }
}
