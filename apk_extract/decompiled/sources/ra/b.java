package ra;

import android.util.Log;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;
import li.j1;
import li.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Thread.UncaughtExceptionHandler {
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread t3, Throwable e) {
        Intrinsics.checkNotNullParameter(t3, "t");
        Intrinsics.checkNotNullParameter(e, "e");
        Intrinsics.checkNotNullParameter("CrashHandler", "tag");
        Intrinsics.checkNotNullParameter(e, "e");
        Log.e(gc.f6463b.concat("CrashHandler"), e.getMessage(), e);
        l0.p(j1.f7459a, null, null, new a(null), 3);
    }
}
