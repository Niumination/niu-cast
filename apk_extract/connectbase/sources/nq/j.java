package nq;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/BuildersKt__BuildersKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,102:1\n1#2:103\n*E\n"})
public final /* synthetic */ class j {
    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    public static final <T> T a(@os.l um.g gVar, @os.l jn.p<? super s0, ? super um.d<? super T>, ? extends Object> pVar) throws InterruptedException {
        r1 r1VarA;
        um.g gVarD;
        Thread threadCurrentThread = Thread.currentThread();
        um.e eVar = (um.e) gVar.get(um.e.G);
        if (eVar == null) {
            r1VarA = p3.f11893a.b();
            gVarD = m0.d(c2.f11831a, gVar.plus(r1VarA));
        } else {
            r1 r1Var = eVar instanceof r1 ? (r1) eVar : null;
            if (r1Var == null) {
                r1VarA = p3.f11893a.a();
            } else {
                r1 r1Var2 = r1Var.I1() ? r1Var : null;
                if (r1Var2 == null) {
                    r1VarA = p3.f11893a.a();
                } else {
                    r1VarA = r1Var2;
                }
            }
            gVarD = m0.d(c2.f11831a, gVar);
        }
        g gVar2 = new g(gVarD, threadCurrentThread, r1VarA);
        u0.DEFAULT.invoke(pVar, gVar2, gVar2);
        return (T) gVar2.V1();
    }

    public static Object b(um.g gVar, jn.p pVar, int i10, Object obj) throws InterruptedException {
        if ((i10 & 1) != 0) {
            gVar = um.i.INSTANCE;
        }
        return a(gVar, pVar);
    }
}
