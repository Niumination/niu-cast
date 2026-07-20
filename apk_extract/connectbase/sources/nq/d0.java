package nq;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public class d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final AtomicIntegerFieldUpdater f11835b = AtomicIntegerFieldUpdater.newUpdater(d0.class, "_handled");

    @in.x
    private volatile int _handled;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @in.f
    @os.l
    public final Throwable f11836a;

    public d0(@os.l Throwable th2, boolean z10) {
        this.f11836a = th2;
        this._handled = z10 ? 1 : 0;
    }

    public final boolean a() {
        return f11835b.get(this) != 0;
    }

    public final boolean b() {
        return f11835b.compareAndSet(this, 0, 1);
    }

    @os.l
    public String toString() {
        return x0.a(this) + ks.a.f9445d + this.f11836a + ']';
    }

    public /* synthetic */ d0(Throwable th2, boolean z10, int i10, kn.w wVar) {
        this(th2, (i10 & 2) != 0 ? false : z10);
    }
}
