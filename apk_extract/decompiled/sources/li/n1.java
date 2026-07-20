package li;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class n1 extends t1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f7482h = AtomicIntegerFieldUpdater.newUpdater(n1.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile = 0;
    public final Function1 e;

    public n1(Function1 function1) {
        this.e = function1;
    }

    @Override // li.t1
    public final boolean j() {
        return true;
    }

    @Override // li.t1
    public final void k(Throwable th2) {
        if (f7482h.compareAndSet(this, 0, 1)) {
            this.e.invoke(th2);
        }
    }
}
