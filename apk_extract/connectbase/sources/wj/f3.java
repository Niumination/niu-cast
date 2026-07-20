package wj;

import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
public final class f3 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f18670d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f3 f18671e = new f3(new a());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IdentityHashMap<d<?>, c> f18672a = new IdentityHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f18673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScheduledExecutorService f18674c;

    public class a implements e {
        @Override // wj.f3.e
        public ScheduledExecutorService a() {
            return Executors.newSingleThreadScheduledExecutor(v0.m("grpc-shared-destroyer-%d", true));
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f18675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f18676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f18677c;

        public b(c cVar, d dVar, Object obj) {
            this.f18675a = cVar;
            this.f18676b = dVar;
            this.f18677c = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (f3.this) {
                try {
                    if (this.f18675a.f18680b == 0) {
                        try {
                            this.f18676b.close(this.f18677c);
                            f3.this.f18672a.remove(this.f18676b);
                            if (f3.this.f18672a.isEmpty()) {
                                f3.this.f18674c.shutdown();
                                f3.this.f18674c = null;
                            }
                        } catch (Throwable th2) {
                            f3.this.f18672a.remove(this.f18676b);
                            if (f3.this.f18672a.isEmpty()) {
                                f3.this.f18674c.shutdown();
                                f3.this.f18674c = null;
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f18679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f18680b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ScheduledFuture<?> f18681c;

        public c(Object obj) {
            this.f18679a = obj;
        }
    }

    public interface d<T> {
        T a();

        void close(T t10);
    }

    public interface e {
        ScheduledExecutorService a();
    }

    public f3(e eVar) {
        this.f18673b = eVar;
    }

    public static <T> T d(d<T> dVar) {
        return (T) f18671e.e(dVar);
    }

    public static <T> T f(d<T> dVar, T t10) {
        return (T) f18671e.g(dVar, t10);
    }

    public synchronized <T> T e(d<T> dVar) {
        c cVar;
        try {
            cVar = this.f18672a.get(dVar);
            if (cVar == null) {
                cVar = new c(dVar.a());
                this.f18672a.put(dVar, cVar);
            }
            ScheduledFuture<?> scheduledFuture = cVar.f18681c;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                cVar.f18681c = null;
            }
            cVar.f18680b++;
        } catch (Throwable th2) {
            throw th2;
        }
        return (T) cVar.f18679a;
    }

    public synchronized <T> T g(d<T> dVar, T t10) {
        try {
            c cVar = this.f18672a.get(dVar);
            if (cVar == null) {
                throw new IllegalArgumentException("No cached instance found for " + dVar);
            }
            c1.h0.e(t10 == cVar.f18679a, "Releasing the wrong instance");
            c1.h0.h0(cVar.f18680b > 0, "Refcount has already reached zero");
            int i10 = cVar.f18680b - 1;
            cVar.f18680b = i10;
            if (i10 == 0) {
                c1.h0.h0(cVar.f18681c == null, "Destroy task already scheduled");
                if (this.f18674c == null) {
                    this.f18674c = this.f18673b.a();
                }
                cVar.f18681c = this.f18674c.schedule(new k1(new b(cVar, dVar, t10)), 1L, TimeUnit.SECONDS);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return null;
    }
}
