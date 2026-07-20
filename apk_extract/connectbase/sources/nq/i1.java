package nq;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nDispatchedTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 4 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,222:1\n200#1,17:240\n1#2:223\n255#3:224\n256#3,2:235\n258#3:239\n107#4,10:225\n118#4,2:237\n61#5,2:257\n*S KotlinDebug\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n*L\n190#1:240,17\n178#1:224\n178#1:235,2\n178#1:239\n178#1:225,10\n178#1:237,2\n220#1:257,2\n*E\n"})
public final class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11863a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f11864b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f11865c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11866d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f11867e = -1;

    public static final <T> void a(@os.l h1<? super T> h1Var, int i10) {
        um.d<? super T> dVarF = h1Var.f();
        boolean z10 = i10 == 4;
        if (z10 || !(dVarF instanceof vq.m) || c(i10) != c(h1Var.f11857c)) {
            e(h1Var, dVarF, z10);
            return;
        }
        n0 n0Var = ((vq.m) dVarF).f17863d;
        um.g context = ((vq.m) dVarF).f17864e.getContext();
        if (n0Var.isDispatchNeeded(context)) {
            n0Var.dispatch(context, h1Var);
        } else {
            f(h1Var);
        }
    }

    @lm.z0
    public static /* synthetic */ void b() {
    }

    public static final boolean c(int i10) {
        return i10 == 1 || i10 == 2;
    }

    public static final boolean d(int i10) {
        return i10 == 2;
    }

    public static final <T> void e(@os.l h1<? super T> h1Var, @os.l um.d<? super T> dVar, boolean z10) {
        Object objI;
        Object objM = h1Var.m();
        Throwable thH = h1Var.h(objM);
        if (thH != null) {
            lm.c1.a aVar = lm.c1.Companion;
            objI = lm.d1.a(thH);
        } else {
            lm.c1.a aVar2 = lm.c1.Companion;
            objI = h1Var.i(objM);
        }
        Object objM59constructorimpl = lm.c1.m59constructorimpl(objI);
        if (!z10) {
            dVar.resumeWith(objM59constructorimpl);
            return;
        }
        kn.l0.n(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        vq.m mVar = (vq.m) dVar;
        um.d<T> dVar2 = mVar.f17864e;
        Object obj = mVar.f17866g;
        um.g context = dVar2.getContext();
        Object objC = vq.a1.c(context, obj);
        z3<?> z3VarG = objC != vq.a1.f17796a ? m0.g(dVar2, context, objC) : null;
        try {
            mVar.f17864e.resumeWith(objM59constructorimpl);
            lm.l2 l2Var = lm.l2.f10208a;
        } finally {
            if (z3VarG == null || z3VarG.V1()) {
                vq.a1.a(context, objC);
            }
        }
    }

    public static final void f(h1<?> h1Var) {
        r1 r1VarB = p3.f11893a.b();
        if (r1VarB.T0()) {
            r1VarB.v0(h1Var);
            return;
        }
        r1VarB.F0(true);
        try {
            e(h1Var, h1Var.f(), true);
            do {
            } while (r1VarB.B1());
        } catch (Throwable th2) {
            try {
                h1Var.k(th2, null);
            } finally {
                r1VarB.f0(true);
            }
        }
    }

    public static final void g(@os.l um.d<?> dVar, @os.l Throwable th2) {
        lm.c1.a aVar = lm.c1.Companion;
        w.a.a(th2, dVar);
    }

    public static final void h(@os.l h1<?> h1Var, @os.l r1 r1Var, @os.l jn.a<lm.l2> aVar) {
        r1Var.F0(true);
        try {
            aVar.invoke();
            do {
            } while (r1Var.B1());
        } catch (Throwable th2) {
            try {
                h1Var.k(th2, null);
            } finally {
                r1Var.f0(true);
            }
        }
    }
}
