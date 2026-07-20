package v4;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f16507j = "HeartbeatManager";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f16508k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f16509l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16510a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f16512c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.m
    public final Runnable f16515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.m
    public final Runnable f16516g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16511b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16513d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i6.a f16514e = i6.a.b.f7724a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f16517h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Runnable f16518i = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (c.this.f16517h) {
                try {
                    k4.m.b(c.f16507j, "heartbeat check:lost-" + c.this.f16511b + ",maxLost-" + c.this.f16510a);
                    c cVar = c.this;
                    int i10 = cVar.f16511b;
                    if (i10 < cVar.f16510a) {
                        cVar.f16511b = i10 + 1;
                        return;
                    }
                    Runnable runnable = cVar.f16516g;
                    if (runnable != null) {
                        runnable.run();
                    }
                    c.this.f();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public c(int i10, int i11, @os.m Runnable runnable, @os.m Runnable runnable2) {
        this.f16512c = i10;
        this.f16510a = i11;
        this.f16515f = runnable;
        this.f16516g = runnable2;
    }

    public void f() {
        k4.m.e(f16507j, "cancel heart beat");
        this.f16514e.e().e(this.f16518i);
        if (this.f16515f != null) {
            this.f16514e.e().e(this.f16515f);
        }
        g();
        this.f16513d = 0;
    }

    public final void g() {
        synchronized (this.f16517h) {
            this.f16511b = 0;
        }
    }

    public void h() {
        k4.m.e(f16507j, "start heartbeat check and send");
        if (this.f16513d == 1) {
            k4.m.c(f16507j, "start:already running");
            return;
        }
        this.f16513d = 1;
        if (this.f16515f == null) {
            k4.m.c(f16507j, "start:heartbeatRunnable is null");
        } else {
            this.f16514e.e().g(this.f16515f, 0L, this.f16512c);
            this.f16514e.e().g(this.f16518i, 0L, this.f16512c);
        }
    }

    public void i() {
        if (this.f16513d == 0) {
            k4.m.c(f16507j, "update heartbeat when idle");
        } else {
            g();
        }
    }
}
