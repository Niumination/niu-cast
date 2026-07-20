package nq;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public static b f11825a;

    @an.f
    public static final long a() {
        b bVar = f11825a;
        return bVar != null ? bVar.a() : System.currentTimeMillis();
    }

    @os.m
    public static final b b() {
        return f11825a;
    }

    @an.f
    public static final long c() {
        b bVar = f11825a;
        return bVar != null ? bVar.b() : System.nanoTime();
    }

    @an.f
    public static final void d(Object obj, long j10) {
        lm.l2 l2Var;
        b bVar = f11825a;
        if (bVar != null) {
            bVar.c(obj, j10);
            l2Var = lm.l2.f10208a;
        } else {
            l2Var = null;
        }
        if (l2Var == null) {
            LockSupport.parkNanos(obj, j10);
        }
    }

    @an.f
    public static final void e() {
        b bVar = f11825a;
        if (bVar != null) {
            bVar.d();
        }
    }

    public static final void f(@os.m b bVar) {
        f11825a = bVar;
    }

    @an.f
    public static final void g() {
        b bVar = f11825a;
        if (bVar != null) {
            bVar.e();
        }
    }

    @an.f
    public static final void h() {
        b bVar = f11825a;
        if (bVar != null) {
            bVar.f();
        }
    }

    @an.f
    public static final void i(Thread thread) {
        lm.l2 l2Var;
        b bVar = f11825a;
        if (bVar != null) {
            bVar.g(thread);
            l2Var = lm.l2.f10208a;
        } else {
            l2Var = null;
        }
        if (l2Var == null) {
            LockSupport.unpark(thread);
        }
    }

    @an.f
    public static final void j() {
        b bVar = f11825a;
        if (bVar != null) {
            bVar.h();
        }
    }

    @an.f
    public static final Runnable k(Runnable runnable) {
        Runnable runnableI;
        b bVar = f11825a;
        return (bVar == null || (runnableI = bVar.i(runnable)) == null) ? runnable : runnableI;
    }
}
