package p5;

import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f8672b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static e f8673c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h3.e f8674a;

    public e(Looper looper) {
        h3.e eVar = new h3.e(looper, 2);
        Looper.getMainLooper();
        this.f8674a = eVar;
    }

    public static e a() {
        e eVar;
        synchronized (f8672b) {
            try {
                if (f8673c == null) {
                    HandlerThread handlerThread = new HandlerThread("MLHandler", 9);
                    handlerThread.start();
                    f8673c = new e(handlerThread.getLooper());
                }
                eVar = f8673c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return eVar;
    }

    public static q3.k b(Callable callable) {
        q3.g gVar = new q3.g();
        l.INSTANCE.execute(new i2.e(6, callable, gVar));
        return gVar.f8950a;
    }
}
