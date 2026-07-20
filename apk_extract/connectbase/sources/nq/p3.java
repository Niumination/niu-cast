package nq;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/ThreadLocalEventLoop\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
public final class p3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final p3 f11893a = new p3();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final ThreadLocal<r1> f11894b;

    static {
        new vq.u0("ThreadLocalEventLoop");
        f11894b = new ThreadLocal<>();
    }

    @os.m
    public final r1 a() {
        return f11894b.get();
    }

    @os.l
    public final r1 b() {
        ThreadLocal<r1> threadLocal = f11894b;
        r1 r1Var = threadLocal.get();
        if (r1Var != null) {
            return r1Var;
        }
        r1 r1VarA = u1.a();
        threadLocal.set(r1VarA);
        return r1VarA;
    }

    public final void c() {
        f11894b.set(null);
    }

    public final void d(@os.l r1 r1Var) {
        f11894b.set(r1Var);
    }
}
