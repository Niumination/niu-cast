package nq;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nBuilders.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.common.kt\nkotlinx/coroutines/BuildersKt__Builders_commonKt\n+ 2 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,273:1\n95#2,5:274\n*S KotlinDebug\n*F\n+ 1 Builders.common.kt\nkotlinx/coroutines/BuildersKt__Builders_commonKt\n*L\n166#1:274,5\n*E\n"})
public final /* synthetic */ class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11872a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f11873b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f11874c = 2;

    @os.l
    public static final <T> a1<T> a(@os.l s0 s0Var, @os.l um.g gVar, @os.l u0 u0Var, @os.l jn.p<? super s0, ? super um.d<? super T>, ? extends Object> pVar) {
        um.g gVarD = m0.d(s0Var, gVar);
        a1<T> v2Var = u0Var.isLazy() ? new v2<>(gVarD, pVar) : new b1<>(gVarD, true, true);
        u0Var.invoke(pVar, v2Var, v2Var);
        return v2Var;
    }

    public static a1 b(s0 s0Var, um.g gVar, u0 u0Var, jn.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = um.i.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            u0Var = u0.DEFAULT;
        }
        return a(s0Var, gVar, u0Var, pVar);
    }

    @os.m
    public static final <T> Object c(@os.l n0 n0Var, @os.l jn.p<? super s0, ? super um.d<? super T>, ? extends Object> pVar, @os.l um.d<? super T> dVar) {
        return g(n0Var, pVar, dVar);
    }

    public static final <T> Object d(n0 n0Var, jn.p<? super s0, ? super um.d<? super T>, ? extends Object> pVar, um.d<? super T> dVar) {
        return g(n0Var, pVar, dVar);
    }

    @os.l
    public static final l2 e(@os.l s0 s0Var, @os.l um.g gVar, @os.l u0 u0Var, @os.l jn.p<? super s0, ? super um.d<? super lm.l2>, ? extends Object> pVar) {
        um.g gVarD = m0.d(s0Var, gVar);
        l2 w2Var = u0Var.isLazy() ? new w2(gVarD, pVar) : new j3(gVarD, true, true);
        u0Var.invoke(pVar, w2Var, w2Var);
        return w2Var;
    }

    public static l2 f(s0 s0Var, um.g gVar, u0 u0Var, jn.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = um.i.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            u0Var = u0.DEFAULT;
        }
        return e(s0Var, gVar, u0Var, pVar);
    }

    @os.m
    public static final <T> Object g(@os.l um.g gVar, @os.l jn.p<? super s0, ? super um.d<? super T>, ? extends Object> pVar, @os.l um.d<? super T> dVar) throws Throwable {
        Object objV1;
        um.g context = dVar.getContext();
        um.g gVarE = m0.e(context, gVar);
        r2.y(gVarE);
        if (gVarE == context) {
            vq.q0 q0Var = new vq.q0(gVarE, dVar);
            objV1 = wq.b.e(q0Var, q0Var, pVar);
        } else {
            um.e.b bVar = um.e.G;
            if (kn.l0.g(gVarE.get(bVar), context.get(bVar))) {
                z3 z3Var = new z3(gVarE, dVar);
                um.g gVar2 = z3Var.f11822c;
                Object objC = vq.a1.c(gVar2, null);
                try {
                    Object objE = wq.b.e(z3Var, z3Var, pVar);
                    vq.a1.a(gVar2, objC);
                    objV1 = objE;
                } catch (Throwable th2) {
                    vq.a1.a(gVar2, objC);
                    throw th2;
                }
            } else {
                g1 g1Var = new g1(gVarE, dVar);
                wq.a.f(pVar, g1Var, g1Var, null, 4, null);
                objV1 = g1Var.V1();
            }
        }
        if (objV1 == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return objV1;
    }
}
