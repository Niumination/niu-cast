package qj;

import java.util.concurrent.locks.ReentrantLock;
import k3.rc;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                ReentrantLock reentrantLock = e.f9188h;
                reentrantLock.lock();
                try {
                    e eVarA = rc.a();
                    if (eVarA == e.f9192l) {
                        e.f9192l = null;
                        reentrantLock.unlock();
                        return;
                    } else {
                        Unit unit = Unit.INSTANCE;
                        reentrantLock.unlock();
                        if (eVarA != null) {
                            eVarA.j();
                        }
                    }
                } catch (Throwable th2) {
                    reentrantLock.unlock();
                    throw th2;
                }
            } catch (InterruptedException unused) {
            }
        }
    }
}
