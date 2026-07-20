package li;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c1 implements Runnable, Comparable, x0 {
    private volatile Object _heap;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f7438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7439b = -1;

    public c1(long j8) {
        this.f7438a = j8;
    }

    public final int a(long j8, d1 d1Var, e1 e1Var) {
        synchronized (this) {
            if (this._heap == l0.f7469b) {
                return 2;
            }
            synchronized (d1Var) {
                try {
                    c1[] c1VarArr = d1Var.f9130a;
                    c1 c1Var = c1VarArr != null ? c1VarArr[0] : null;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e1.e;
                    e1Var.getClass();
                    if (e1.f7447i.get(e1Var) != 0) {
                        return 1;
                    }
                    if (c1Var == null) {
                        d1Var.f7442c = j8;
                    } else {
                        long j10 = c1Var.f7438a;
                        if (j10 - j8 < 0) {
                            j8 = j10;
                        }
                        if (j8 - d1Var.f7442c > 0) {
                            d1Var.f7442c = j8;
                        }
                    }
                    long j11 = this.f7438a;
                    long j12 = d1Var.f7442c;
                    if (j11 - j12 < 0) {
                        this.f7438a = j12;
                    }
                    d1Var.a(this);
                    return 0;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final void b(d1 d1Var) {
        if (this._heap == l0.f7469b) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this._heap = d1Var;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j8 = this.f7438a - ((c1) obj).f7438a;
        if (j8 > 0) {
            return 1;
        }
        return j8 < 0 ? -1 : 0;
    }

    @Override // li.x0
    public final void dispose() {
        synchronized (this) {
            try {
                Object obj = this._heap;
                a8.a aVar = l0.f7469b;
                if (obj == aVar) {
                    return;
                }
                d1 d1Var = obj instanceof d1 ? (d1) obj : null;
                if (d1Var != null) {
                    synchronized (d1Var) {
                        Object obj2 = this._heap;
                        if ((obj2 instanceof qi.a0 ? (qi.a0) obj2 : null) != null) {
                            d1Var.b(this.f7439b);
                        }
                    }
                }
                this._heap = aVar;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public String toString() {
        return "Delayed[nanos=" + this.f7438a + ']';
    }
}
