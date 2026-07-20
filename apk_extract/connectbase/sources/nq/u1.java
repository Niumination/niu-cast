package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class u1 {
    @os.l
    public static final r1 a() {
        return new h(Thread.currentThread());
    }

    @f1
    @g2
    @lm.z0
    public static final boolean b(@os.l Thread thread) {
        if (thread instanceof xq.a.c) {
            return ((xq.a.c) thread).p();
        }
        return false;
    }

    public static final void c(@os.l jn.a<lm.l2> aVar) {
        aVar.invoke();
    }

    @g2
    public static final long d() {
        r1 r1VarA = p3.f11893a.a();
        if (r1VarA != null) {
            return r1VarA.c1();
        }
        return Long.MAX_VALUE;
    }

    @f1
    @g2
    @lm.z0
    public static final long e() {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof xq.a.c) {
            return ((xq.a.c) threadCurrentThread).t();
        }
        throw new IllegalStateException("Expected CoroutineScheduler.Worker, but got " + threadCurrentThread);
    }
}
