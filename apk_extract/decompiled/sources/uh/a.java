package uh;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m3.a0;
import o.d;
import qh.b;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends AtomicInteger implements b, uj.b {
    private static final long serialVersionUID = -4945028590049415624L;
    final uj.a actual;
    volatile boolean done;
    final wh.a error = new wh.a();
    final AtomicLong requested = new AtomicLong();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final AtomicReference<uj.b> f10441s = new AtomicReference<>();
    final AtomicBoolean once = new AtomicBoolean();

    public a(uj.a aVar) {
        this.actual = aVar;
    }

    @Override // uj.b
    public void cancel() {
        if (this.done) {
            return;
        }
        vh.b.cancel(this.f10441s);
    }

    @Override // uj.a
    public void onComplete() {
        this.done = true;
        uj.a aVar = this.actual;
        wh.a aVar2 = this.error;
        if (getAndIncrement() == 0) {
            Throwable thTerminate = aVar2.terminate();
            if (thTerminate != null) {
                aVar.onError(thTerminate);
            } else {
                aVar.onComplete();
            }
        }
    }

    @Override // uj.a
    public void onError(Throwable th2) {
        this.done = true;
        uj.a aVar = this.actual;
        wh.a aVar2 = this.error;
        if (!aVar2.addThrowable(th2)) {
            a0.a(th2);
        } else if (getAndIncrement() == 0) {
            aVar.onError(aVar2.terminate());
        }
    }

    @Override // uj.a
    public void onNext(Object obj) {
        uj.a aVar = this.actual;
        wh.a aVar2 = this.error;
        if (get() == 0 && compareAndSet(0, 1)) {
            aVar.onNext(obj);
            if (decrementAndGet() != 0) {
                Throwable thTerminate = aVar2.terminate();
                if (thTerminate != null) {
                    aVar.onError(thTerminate);
                } else {
                    aVar.onComplete();
                }
            }
        }
    }

    @Override // uj.a
    public void onSubscribe(uj.b bVar) {
        if (this.once.compareAndSet(false, true)) {
            this.actual.onSubscribe(this);
            vh.b.deferredSetOnce(this.f10441s, this.requested, bVar);
        } else {
            bVar.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // uj.b
    public void request(long j8) {
        if (j8 > 0) {
            vh.b.deferredRequest(this.f10441s, this.requested, j8);
        } else {
            cancel();
            onError(new IllegalArgumentException(d.j("§3.9 violated: positive request amount required but it was ", j8)));
        }
    }
}
