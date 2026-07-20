package nq;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nThreadContextElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadContextElement.kt\nkotlinx/coroutines/ThreadContextElementKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,288:1\n266#1:289\n1#2:290\n*S KotlinDebug\n*F\n+ 1 ThreadContextElement.kt\nkotlinx/coroutines/ThreadContextElementKt\n*L\n287#1:289\n*E\n"})
public final class o3 {
    @os.l
    public static final <T> n3<T> a(@os.l ThreadLocal<T> threadLocal, T t10) {
        return new vq.b1(t10, threadLocal);
    }

    public static n3 b(ThreadLocal threadLocal, Object obj, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = threadLocal.get();
        }
        return new vq.b1(obj, threadLocal);
    }

    @os.m
    public static final Object c(@os.l ThreadLocal<?> threadLocal, @os.l um.d<? super lm.l2> dVar) {
        if (dVar.getContext().get(new vq.c1(threadLocal)) != null) {
            return lm.l2.f10208a;
        }
        throw new IllegalStateException(("ThreadLocal " + threadLocal + " is missing from context " + dVar.getContext()).toString());
    }

    public static final Object d(ThreadLocal<?> threadLocal, um.d<? super lm.l2> dVar) {
        throw null;
    }

    @os.m
    public static final Object e(@os.l ThreadLocal<?> threadLocal, @os.l um.d<? super Boolean> dVar) {
        return Boolean.valueOf(dVar.getContext().get(new vq.c1(threadLocal)) != null);
    }

    public static final Object f(ThreadLocal<?> threadLocal, um.d<? super Boolean> dVar) {
        throw null;
    }
}
