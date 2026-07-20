package qi;

import androidx.core.internal.view.SupportMenu;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import li.e2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class w extends b implements e2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f9169d = AtomicIntegerFieldUpdater.newUpdater(w.class, "cleanedAndPointers$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f9170c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public w(long j8, w wVar, int i8) {
        super(wVar);
        this.f9170c = j8;
        this.cleanedAndPointers$volatile = i8 << 16;
    }

    @Override // qi.b
    public final boolean d() {
        return f9169d.get(this) == g() && c() != null;
    }

    public final boolean f() {
        return f9169d.addAndGet(this, SupportMenu.CATEGORY_MASK) == g() && c() != null;
    }

    public abstract int g();

    public abstract void h(int i8, CoroutineContext coroutineContext);

    public final void i() {
        if (f9169d.incrementAndGet(this) == g()) {
            e();
        }
    }

    public final boolean j() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i8;
        do {
            atomicIntegerFieldUpdater = f9169d;
            i8 = atomicIntegerFieldUpdater.get(this);
            if (i8 == g() && c() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i8, 65536 + i8));
        return true;
    }
}
