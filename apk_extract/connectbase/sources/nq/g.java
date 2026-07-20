package nq;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/BlockingCoroutine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,102:1\n1#2:103\n*E\n"})
public final class g<T> extends a<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final Thread f11851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.m
    public final r1 f11852e;

    public g(@os.l um.g gVar, @os.l Thread thread, @os.m r1 r1Var) {
        super(gVar, true, true);
        this.f11851d = thread;
        this.f11852e = r1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T V1() throws Throwable {
        lm.l2 l2Var;
        b bVarB = c.b();
        if (bVarB != null) {
            bVarB.d();
        }
        try {
            r1 r1Var = this.f11852e;
            if (r1Var != null) {
                r1.J0(r1Var, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    r1 r1Var2 = this.f11852e;
                    long jC1 = r1Var2 != null ? r1Var2.c1() : Long.MAX_VALUE;
                    if (isCompleted()) {
                        r1 r1Var3 = this.f11852e;
                        if (r1Var3 != null) {
                            r1.j0(r1Var3, false, 1, null);
                        }
                        b bVar = c.f11825a;
                        if (bVar != null) {
                            bVar.h();
                        }
                        T t10 = (T) u2.h(V0());
                        d0 d0Var = t10 instanceof d0 ? (d0) t10 : null;
                        if (d0Var == null) {
                            return t10;
                        }
                        throw d0Var.f11836a;
                    }
                    b bVar2 = c.f11825a;
                    if (bVar2 != null) {
                        bVar2.c(this, jC1);
                        l2Var = lm.l2.f10208a;
                    } else {
                        l2Var = null;
                    }
                    if (l2Var == null) {
                        LockSupport.parkNanos(this, jC1);
                    }
                } catch (Throwable th2) {
                    r1 r1Var4 = this.f11852e;
                    if (r1Var4 != null) {
                        r1.j0(r1Var4, false, 1, null);
                    }
                    throw th2;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            c0(interruptedException);
            throw interruptedException;
        } catch (Throwable th3) {
            b bVar3 = c.f11825a;
            if (bVar3 != null) {
                bVar3.h();
            }
            throw th3;
        }
    }

    @Override // nq.t2
    public void X(@os.m Object obj) {
        lm.l2 l2Var;
        if (kn.l0.g(Thread.currentThread(), this.f11851d)) {
            return;
        }
        Thread thread = this.f11851d;
        b bVarB = c.b();
        if (bVarB != null) {
            bVarB.g(thread);
            l2Var = lm.l2.f10208a;
        } else {
            l2Var = null;
        }
        if (l2Var == null) {
            LockSupport.unpark(thread);
        }
    }

    @Override // nq.t2
    public boolean b1() {
        return true;
    }
}
