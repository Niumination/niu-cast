package vh;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends AtomicInteger implements uj.b {
    static final int CANCELLED = 2;
    static final int NO_REQUEST = 0;
    static final int REQUESTED = 1;
    private static final long serialVersionUID = -3830916580126663321L;
    final uj.a subscriber;
    final Object value;

    public a(uj.a aVar, Object obj) {
        this.subscriber = aVar;
        this.value = obj;
    }

    @Override // uj.b
    public void cancel() {
        lazySet(2);
    }

    public void clear() {
        lazySet(1);
    }

    public boolean isCancelled() {
        return get() == 2;
    }

    public boolean isEmpty() {
        return get() != 0;
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public Object poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.value;
    }

    @Override // uj.b
    public void request(long j8) {
        if (b.validate(j8) && compareAndSet(0, 1)) {
            uj.a aVar = this.subscriber;
            aVar.onNext(this.value);
            if (get() != 2) {
                aVar.onComplete();
            }
        }
    }

    public int requestFusion(int i8) {
        return i8 & 1;
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
