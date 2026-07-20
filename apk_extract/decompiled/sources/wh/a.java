package wh;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends AtomicReference {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean addThrowable(Throwable th2) {
        Throwable th3;
        b bVar = c.f10761a;
        do {
            th3 = (Throwable) get();
            if (th3 == c.f10761a) {
                return false;
            }
        } while (!compareAndSet(th3, th3 == null ? th2 : new rh.c(th3, th2)));
        return true;
    }

    public boolean isTerminated() {
        return get() == c.f10761a;
    }

    public Throwable terminate() {
        b bVar = c.f10761a;
        Throwable th2 = (Throwable) get();
        b bVar2 = c.f10761a;
        return th2 != bVar2 ? (Throwable) getAndSet(bVar2) : th2;
    }
}
