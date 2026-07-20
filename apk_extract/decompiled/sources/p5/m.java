package p5;

import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f8690b;

    public /* synthetic */ m(Runnable runnable, int i8) {
        this.f8689a = i8;
        this.f8690b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8689a) {
            case 0:
                g.f8678b.set(new ArrayDeque());
                this.f8690b.run();
                break;
            default:
                Deque deque = (Deque) g.f8678b.get();
                u2.l.e(deque);
                Runnable runnable = this.f8690b;
                deque.add(runnable);
                if (deque.size() <= 1) {
                    do {
                        runnable.run();
                        deque.removeFirst();
                        runnable = (Runnable) deque.peekFirst();
                    } while (runnable != null);
                }
                break;
        }
    }
}
