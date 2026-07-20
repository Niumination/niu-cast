package y6;

import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f11087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Thread f11088b;

    public d(Handler handler) {
        this.f11087a = handler;
    }

    public abstract void a();

    public final String b() {
        return "Task-Athena-" + c();
    }

    public abstract String c();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Thread threadCurrentThread = Thread.currentThread();
        this.f11088b = threadCurrentThread;
        String name = threadCurrentThread.getName();
        this.f11088b.setName(b());
        try {
            a();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            g.a().e(this);
            this.f11088b.setName(name);
        }
    }
}
