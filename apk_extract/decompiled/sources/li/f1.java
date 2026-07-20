package li;

import kotlin.collections.ArrayDeque;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f1 extends a0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f7451d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f7452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayDeque f7454c;

    public abstract long B();

    public final boolean E() {
        t0 t0Var;
        ArrayDeque arrayDeque = this.f7454c;
        if (arrayDeque == null || (t0Var = (t0) arrayDeque.removeFirstOrNull()) == null) {
            return false;
        }
        t0Var.run();
        return true;
    }

    public void I(long j8, c1 c1Var) {
        m0.f7477j.n0(j8, c1Var);
    }

    public abstract void N();

    public final void i(boolean z2) {
        long j8 = this.f7452a - (z2 ? 4294967296L : 1L);
        this.f7452a = j8;
        if (j8 <= 0 && this.f7453b) {
            N();
        }
    }

    public final void k(t0 t0Var) {
        ArrayDeque arrayDeque = this.f7454c;
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque();
            this.f7454c = arrayDeque;
        }
        arrayDeque.addLast(t0Var);
    }

    public abstract Thread l();

    @Override // li.a0
    public final a0 limitedParallelism(int i8, String str) {
        qi.g.c(i8);
        return str != null ? new qi.s(this, str) : this;
    }

    public final void o(boolean z2) {
        this.f7452a = (z2 ? 4294967296L : 1L) + this.f7452a;
        if (z2) {
            return;
        }
        this.f7453b = true;
    }

    public final boolean w() {
        return this.f7452a >= 4294967296L;
    }
}
