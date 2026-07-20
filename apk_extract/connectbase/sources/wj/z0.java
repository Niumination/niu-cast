package wj;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class z0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Logger f19575g = Logger.getLogger(z0.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f19576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c1.o0 f19577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hm.a("this")
    public Map<u.a, Executor> f19578c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hm.a("this")
    public boolean f19579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @hm.a("this")
    public Throwable f19580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @hm.a("this")
    public long f19581f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u.a f19582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f19583b;

        public a(u.a aVar, long j10) {
            this.f19582a = aVar;
            this.f19583b = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f19582a.b(this.f19583b);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u.a f19584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f19585b;

        public b(u.a aVar, Throwable th2) {
            this.f19584a = aVar;
            this.f19585b = th2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f19584a.a(this.f19585b);
        }
    }

    public z0(long j10, c1.o0 o0Var) {
        this.f19576a = j10;
        this.f19577b = o0Var;
    }

    public static Runnable b(u.a aVar, long j10) {
        return new a(aVar, j10);
    }

    public static Runnable c(u.a aVar, Throwable th2) {
        return new b(aVar, th2);
    }

    public static void e(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (Throwable th2) {
            f19575g.log(Level.SEVERE, "Failed to execute PingCallback", th2);
        }
    }

    public static void g(u.a aVar, Executor executor, Throwable th2) {
        e(executor, new b(aVar, th2));
    }

    public void a(u.a aVar, Executor executor) {
        synchronized (this) {
            try {
                if (!this.f19579d) {
                    this.f19578c.put(aVar, executor);
                } else {
                    Throwable th2 = this.f19580e;
                    e(executor, th2 != null ? new b(aVar, th2) : new a(aVar, this.f19581f));
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public boolean d() {
        synchronized (this) {
            try {
                if (this.f19579d) {
                    return false;
                }
                this.f19579d = true;
                long jG = this.f19577b.g(TimeUnit.NANOSECONDS);
                this.f19581f = jG;
                Map<u.a, Executor> map = this.f19578c;
                this.f19578c = null;
                for (Map.Entry<u.a, Executor> entry : map.entrySet()) {
                    e(entry.getValue(), new a(entry.getKey(), jG));
                }
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void f(Throwable th2) {
        synchronized (this) {
            try {
                if (this.f19579d) {
                    return;
                }
                this.f19579d = true;
                this.f19580e = th2;
                Map<u.a, Executor> map = this.f19578c;
                this.f19578c = null;
                for (Map.Entry<u.a, Executor> entry : map.entrySet()) {
                    g(entry.getKey(), entry.getValue(), th2);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public long h() {
        return this.f19576a;
    }
}
