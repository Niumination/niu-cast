package af;

import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w3 f301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f302b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l6 f303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w3 f304d;
    public int e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f305g;

    public h(int i8, h6 h6Var, l6 l6Var) {
        v8.i(h6Var, "statsTraceCtx");
        v8.i(l6Var, "transportTracer");
        this.f303c = l6Var;
        w3 w3Var = new w3(this, i8, h6Var, l6Var);
        this.f304d = w3Var;
        this.f301a = w3Var;
    }

    public final void a(int i8) {
        boolean z2;
        boolean zL;
        synchronized (this.f302b) {
            v8.n(this.f, "onStreamAllocated was not called, but it seems the stream is active");
            int i9 = this.e;
            z2 = false;
            boolean z3 = i9 < 32768;
            int i10 = i9 - i8;
            this.e = i10;
            boolean z5 = i10 < 32768;
            if (!z3 && z5) {
                z2 = true;
            }
        }
        if (z2) {
            synchronized (this.f302b) {
                zL = l();
            }
            if (zL) {
                m().q();
            }
        }
    }

    public abstract void h(int i8);

    public final void i(boolean z2) {
        if (z2) {
            this.f301a.close();
            return;
        }
        w3 w3Var = this.f301a;
        if (w3Var.isClosed()) {
            return;
        }
        if (w3Var.f656n.f322c == 0) {
            w3Var.close();
        } else {
            w3Var.f659s = true;
        }
    }

    public abstract void j(Throwable th2);

    public abstract void k(boolean z2);

    public final boolean l() {
        boolean z2;
        synchronized (this.f302b) {
            try {
                z2 = this.f && this.e < 32768 && !this.f305g;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z2;
    }

    public abstract j6 m();

    public void n() {
        boolean zL;
        v8.m(m() != null);
        synchronized (this.f302b) {
            v8.n(!this.f, "Already allocated");
            this.f = true;
        }
        synchronized (this.f302b) {
            zL = l();
        }
        if (zL) {
            m().q();
        }
    }

    public abstract void o(Runnable runnable);
}
