package f1;

import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public final class o0<T> extends c<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue<T> f5159c;

    public o0(Queue<T> queue) {
        queue.getClass();
        this.f5159c = queue;
    }

    @Override // f1.c
    @gm.a
    public T a() {
        if (!this.f5159c.isEmpty()) {
            return this.f5159c.remove();
        }
        this.f4711a = c.b.DONE;
        return null;
    }
}
