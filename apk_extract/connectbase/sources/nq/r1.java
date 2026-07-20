package nq;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoop\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
public abstract class r1 extends n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f11912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public nm.k<h1<?>> f11914c;

    public static /* synthetic */ void J0(r1 r1Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        r1Var.F0(z10);
    }

    public static /* synthetic */ void j0(r1 r1Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        r1Var.f0(z10);
    }

    public final boolean B1() throws IllegalAccessException, InvocationTargetException {
        h1<?> h1VarS;
        nm.k<h1<?>> kVar = this.f11914c;
        if (kVar == null || (h1VarS = kVar.s()) == null) {
            return false;
        }
        h1VarS.run();
        return true;
    }

    public final void F0(boolean z10) {
        this.f11912a = p0(z10) + this.f11912a;
        if (z10) {
            return;
        }
        this.f11913b = true;
    }

    public boolean I1() {
        return false;
    }

    public boolean Q0() {
        return U0();
    }

    public final boolean T0() {
        return this.f11912a >= p0(true);
    }

    public final boolean U0() {
        nm.k<h1<?>> kVar = this.f11914c;
        if (kVar != null) {
            return kVar.isEmpty();
        }
        return true;
    }

    public long c1() {
        return !B1() ? Long.MAX_VALUE : 0L;
    }

    public final void f0(boolean z10) {
        long jP0 = this.f11912a - p0(z10);
        this.f11912a = jP0;
        if (jP0 <= 0 && this.f11913b) {
            shutdown();
        }
    }

    public final boolean isActive() {
        return this.f11912a > 0;
    }

    @Override // nq.n0
    @os.l
    public final n0 limitedParallelism(int i10) {
        vq.v.a(i10);
        return this;
    }

    public final long p0(boolean z10) {
        return z10 ? 4294967296L : 1L;
    }

    public void shutdown() {
    }

    public final void v0(@os.l h1<?> h1Var) {
        nm.k<h1<?>> kVar = this.f11914c;
        if (kVar == null) {
            kVar = new nm.k<>();
            this.f11914c = kVar;
        }
        kVar.addLast(h1Var);
    }

    public long w0() {
        nm.k<h1<?>> kVar = this.f11914c;
        return (kVar == null || kVar.isEmpty()) ? Long.MAX_VALUE : 0L;
    }
}
