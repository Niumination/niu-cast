package sq;

import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,428:1\n1#2:429\n*E\n"})
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final vq.u0 f15391a = new vq.u0("NONE");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final vq.u0 f15392b = new vq.u0("PENDING");

    @os.l
    public static final <T> f0<T> a(T t10) {
        if (t10 == null) {
            t10 = (T) tq.u.f16062a;
        }
        return new v0(t10);
    }

    @os.l
    public static final <T> i<T> d(@os.l u0<? extends T> u0Var, @os.l um.g gVar, int i10, @os.l pq.i iVar) {
        return (((i10 < 0 || i10 >= 2) && i10 != -2) || iVar != pq.i.DROP_OLDEST) ? l0.e(u0Var, gVar, i10, iVar) : u0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Object] */
    public static final <T> T e(@os.l f0<T> f0Var, @os.l jn.l<? super T, ? extends T> lVar) {
        ?? r10;
        do {
            r10 = (Object) f0Var.getValue();
        } while (!f0Var.compareAndSet(r10, lVar.invoke(r10)));
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void f(@os.l f0<T> f0Var, @os.l jn.l<? super T, ? extends T> lVar) {
        a1.e eVar;
        do {
            eVar = (Object) f0Var.getValue();
        } while (!f0Var.compareAndSet(eVar, lVar.invoke(eVar)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T g(@os.l f0<T> f0Var, @os.l jn.l<? super T, ? extends T> lVar) {
        a1.e eVar;
        T tInvoke;
        do {
            eVar = (Object) f0Var.getValue();
            tInvoke = lVar.invoke(eVar);
        } while (!f0Var.compareAndSet(eVar, tInvoke));
        return tInvoke;
    }
}
