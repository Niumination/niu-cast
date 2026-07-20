package af;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class l3 extends WeakReference {
    public static final boolean f = Boolean.parseBoolean(System.getProperty("io.grpc.ManagedChannel.enableAllocationTracking", "true"));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final RuntimeException f432g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReferenceQueue f433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SoftReference f436d;
    public final AtomicBoolean e;

    static {
        RuntimeException runtimeException = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
        runtimeException.setStackTrace(new StackTraceElement[0]);
        f432g = runtimeException;
    }

    public l3(m3 m3Var, j3 j3Var, ReferenceQueue referenceQueue, ConcurrentHashMap concurrentHashMap) {
        super(m3Var, referenceQueue);
        this.e = new AtomicBoolean();
        this.f436d = new SoftReference(f ? new RuntimeException("ManagedChannel allocation site") : f432g);
        this.f435c = j3Var.toString();
        this.f433a = referenceQueue;
        this.f434b = concurrentHashMap;
        concurrentHashMap.put(this, this);
        a(referenceQueue);
    }

    public static void a(ReferenceQueue referenceQueue) {
        while (true) {
            l3 l3Var = (l3) referenceQueue.poll();
            if (l3Var == null) {
                return;
            }
            SoftReference softReference = l3Var.f436d;
            RuntimeException runtimeException = (RuntimeException) softReference.get();
            super.clear();
            l3Var.f434b.remove(l3Var);
            softReference.clear();
            if (!l3Var.e.get()) {
                Level level = Level.SEVERE;
                Logger logger = m3.e;
                if (logger.isLoggable(level)) {
                    LogRecord logRecord = new LogRecord(level, "*~*~*~ Previous channel {0} was not shutdown properly!!! ~*~*~*" + System.getProperty("line.separator") + "    Make sure to call shutdown()/shutdownNow() and wait until awaitTermination() returns true.");
                    logRecord.setLoggerName(logger.getName());
                    logRecord.setParameters(new Object[]{l3Var.f435c});
                    logRecord.setThrown(runtimeException);
                    logger.log(logRecord);
                }
            }
        }
    }

    @Override // java.lang.ref.Reference
    public final void clear() {
        super.clear();
        this.f434b.remove(this);
        this.f436d.clear();
        a(this.f433a);
    }
}
