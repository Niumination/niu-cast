package w4;

import android.os.Process;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class f implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f18000a = "MirrorUncaughtExceptionHandler";

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th2) {
        k4.m.c(f18000a, th2.getMessage());
        k4.m.d(f18000a, th2);
        k4.m.c(f18000a, "service crashed because of uncaught error");
        c0.b.f17991a.A0();
        l1.h.f18073a.D1();
        Process.killProcess(Process.myPid());
        System.exit(0);
    }
}
