package li;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f7463a = new ThreadLocal();

    public static f1 a() {
        ThreadLocal threadLocal = f7463a;
        f1 f1Var = (f1) threadLocal.get();
        if (f1Var != null) {
            return f1Var;
        }
        g gVar = new g(Thread.currentThread());
        threadLocal.set(gVar);
        return gVar;
    }
}
