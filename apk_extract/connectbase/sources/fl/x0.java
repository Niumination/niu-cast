package fl;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final ReentrantLock f6107a = new ReentrantLock();

    public final void a() {
    }

    public final void b() {
        this.f6107a.lock();
    }

    public final void c() {
        this.f6107a.unlock();
    }
}
