package hk;

import ik.u;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public class m extends ck.g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f5504d;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile Object f5507j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f5508k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f5509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nk.d f5510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f5511c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConcurrentHashMap f5505h = new ConcurrentHashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicReference f5506i = new AtomicReference();
    public static final int e = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();

    static {
        boolean z2 = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int i8 = ik.q.f5902a;
        f5504d = !z2 && (i8 == 0 || i8 >= 21);
        f5508k = new Object();
    }

    public m(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!e(scheduledExecutorServiceNewScheduledThreadPool) && (scheduledExecutorServiceNewScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) scheduledExecutorServiceNewScheduledThreadPool;
            while (true) {
                AtomicReference atomicReference = f5506i;
                if (((ScheduledExecutorService) atomicReference.get()) != null) {
                    break;
                }
                ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool2 = Executors.newScheduledThreadPool(1, new u("RxSchedulerPurge-"));
                if (atomicReference.compareAndSet(null, scheduledExecutorServiceNewScheduledThreadPool2)) {
                    l lVar = new l();
                    long j8 = e;
                    scheduledExecutorServiceNewScheduledThreadPool2.scheduleAtFixedRate(lVar, j8, j8, TimeUnit.MILLISECONDS);
                    break;
                }
                scheduledExecutorServiceNewScheduledThreadPool2.shutdownNow();
            }
            f5505h.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
        }
        this.f5510b = nk.c.f8331d.d();
        this.f5509a = scheduledExecutorServiceNewScheduledThreadPool;
    }

    public static Method c(ScheduledExecutorService scheduledExecutorService) {
        for (Method method : scheduledExecutorService.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    public static boolean e(ScheduledExecutorService scheduledExecutorService) {
        Method methodC;
        if (f5504d) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = f5507j;
                Object obj2 = f5508k;
                if (obj == obj2) {
                    return false;
                }
                if (obj == null) {
                    methodC = c(scheduledExecutorService);
                    if (methodC != null) {
                        obj2 = methodC;
                    }
                    f5507j = obj2;
                } else {
                    methodC = (Method) obj;
                }
            } else {
                methodC = c(scheduledExecutorService);
            }
            if (methodC != null) {
                try {
                    methodC.invoke(scheduledExecutorService, Boolean.TRUE);
                    return true;
                } catch (Exception unused) {
                    nk.c.f8331d.a().getClass();
                }
            }
        }
        return false;
    }

    @Override // ck.g
    public final ck.j a(ek.a aVar, long j8, TimeUnit timeUnit) {
        return this.f5511c ? qk.e.f9242a : d(aVar, j8, timeUnit);
    }

    @Override // ck.g
    public final ck.j b(fk.h hVar) {
        return a(hVar, 0L, null);
    }

    public final q d(ek.a aVar, long j8, TimeUnit timeUnit) {
        this.f5510b.getClass();
        q qVar = new q(aVar);
        ScheduledExecutorService scheduledExecutorService = this.f5509a;
        qVar.add(j8 <= 0 ? scheduledExecutorService.submit(qVar) : scheduledExecutorService.schedule(qVar, j8, timeUnit));
        return qVar;
    }

    @Override // ck.j
    public final boolean isUnsubscribed() {
        return this.f5511c;
    }

    @Override // ck.j
    public final void unsubscribe() {
        this.f5511c = true;
        this.f5509a.shutdownNow();
        f5505h.remove(this.f5509a);
    }
}
