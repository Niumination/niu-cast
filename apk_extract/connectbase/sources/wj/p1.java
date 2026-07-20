package wj;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class p1 extends q0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReferenceQueue<p1> f19147c = new ReferenceQueue<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentMap<a, a> f19148d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f19149e = Logger.getLogger(p1.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f19150b;

    @b1.e
    public static final class a extends WeakReference<p1> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f19151f = "io.grpc.ManagedChannel.enableAllocationTracking";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final boolean f19152g = Boolean.parseBoolean(System.getProperty(f19151f, "true"));

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final RuntimeException f19153h = e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReferenceQueue<p1> f19154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentMap<a, a> f19155b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f19156c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Reference<RuntimeException> f19157d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicBoolean f19158e;

        public a(p1 p1Var, vj.r1 r1Var, ReferenceQueue<p1> referenceQueue, ConcurrentMap<a, a> concurrentMap) {
            super(p1Var, referenceQueue);
            this.f19158e = new AtomicBoolean();
            this.f19157d = new SoftReference(f19152g ? new RuntimeException("ManagedChannel allocation site") : f19153h);
            this.f19156c = r1Var.toString();
            this.f19154a = referenceQueue;
            this.f19155b = concurrentMap;
            concurrentMap.put(this, this);
            b(referenceQueue);
        }

        @b1.e
        public static int b(ReferenceQueue<p1> referenceQueue) {
            int i10 = 0;
            while (true) {
                a aVar = (a) referenceQueue.poll();
                if (aVar == null) {
                    return i10;
                }
                RuntimeException runtimeException = aVar.f19157d.get();
                aVar.c();
                if (!aVar.f19158e.get()) {
                    i10++;
                    Level level = Level.SEVERE;
                    if (p1.f19149e.isLoggable(level)) {
                        LogRecord logRecord = new LogRecord(level, "*~*~*~ Previous channel {0} was garbage collected without being shut down! ~*~*~*" + System.getProperty("line.separator") + "    Make sure to call shutdown()/shutdownNow()");
                        Logger logger = p1.f19149e;
                        logRecord.setLoggerName(logger.getName());
                        logRecord.setParameters(new Object[]{aVar.f19156c});
                        logRecord.setThrown(runtimeException);
                        logger.log(logRecord);
                    }
                }
            }
        }

        public static RuntimeException e() {
            RuntimeException runtimeException = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
            runtimeException.setStackTrace(new StackTraceElement[0]);
            return runtimeException;
        }

        public final void c() {
            super.clear();
            this.f19155b.remove(this);
            this.f19157d.clear();
        }

        @Override // java.lang.ref.Reference
        public void clear() {
            c();
            b(this.f19154a);
        }

        public final void d() {
            if (this.f19158e.getAndSet(true)) {
                return;
            }
            clear();
        }
    }

    public p1(vj.r1 r1Var) {
        this(r1Var, f19147c, f19148d);
    }

    @Override // wj.q0, vj.r1
    public vj.r1 s() {
        this.f19150b.d();
        return super.s();
    }

    @Override // wj.q0, vj.r1
    public vj.r1 t() {
        this.f19150b.d();
        return super.t();
    }

    @b1.e
    public p1(vj.r1 r1Var, ReferenceQueue<p1> referenceQueue, ConcurrentMap<a, a> concurrentMap) {
        super(r1Var);
        this.f19150b = new a(this, r1Var, referenceQueue, concurrentMap);
    }
}
