package hk;

import java.util.Iterator;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import k3.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        try {
            Iterator it = m.f5505h.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    it.remove();
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        } catch (Throwable th2) {
            x1.b(th2);
            nk.c.f8331d.a().getClass();
        }
    }
}
