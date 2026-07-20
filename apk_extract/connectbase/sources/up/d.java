package up;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kn.l0;
import kn.w;

/* JADX INFO: loaded from: classes3.dex */
public class d implements k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final Lock f16361b;

    /* JADX WARN: Multi-variable type inference failed */
    public d() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @os.l
    public final Lock a() {
        return this.f16361b;
    }

    @Override // up.k
    public void lock() {
        this.f16361b.lock();
    }

    @Override // up.k
    public void unlock() {
        this.f16361b.unlock();
    }

    public d(@os.l Lock lock) {
        l0.p(lock, "lock");
        this.f16361b = lock;
    }

    public /* synthetic */ d(Lock lock, int i10, w wVar) {
        this((i10 & 1) != 0 ? new ReentrantLock() : lock);
    }
}
