package vq;

/* JADX INFO: loaded from: classes3.dex */
@lm.z0
public final class c1 implements um.g.c<b1<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final ThreadLocal<?> f17829a;

    public c1(@os.l ThreadLocal<?> threadLocal) {
        this.f17829a = threadLocal;
    }

    public static c1 c(c1 c1Var, ThreadLocal threadLocal, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            threadLocal = c1Var.f17829a;
        }
        c1Var.getClass();
        return new c1(threadLocal);
    }

    public final ThreadLocal<?> a() {
        return this.f17829a;
    }

    @os.l
    public final c1 b(@os.l ThreadLocal<?> threadLocal) {
        return new c1(threadLocal);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c1) && kn.l0.g(this.f17829a, ((c1) obj).f17829a);
    }

    public int hashCode() {
        return this.f17829a.hashCode();
    }

    @os.l
    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f17829a + ')';
    }
}
