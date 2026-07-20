package nq;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nCancellableContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n*L\n1#1,386:1\n1#2:387\n19#3:388\n*S KotlinDebug\n*F\n+ 1 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n380#1:388\n*E\n"})
public final class s {
    @g2
    public static final void a(@os.l p<?> pVar, @os.l n1 n1Var) {
        pVar.H(new o1(n1Var));
    }

    @os.l
    public static final <T> q<T> b(@os.l um.d<? super T> dVar) {
        if (!(dVar instanceof vq.m)) {
            return new q<>(dVar, 1);
        }
        q<T> qVarO = ((vq.m) dVar).o();
        if (qVarO != null) {
            if (!qVarO.R()) {
                qVarO = null;
            }
            if (qVarO != null) {
                return qVarO;
            }
        }
        return new q<>(dVar, 2);
    }

    @os.m
    public static final <T> Object c(@os.l jn.l<? super p<? super T>, lm.l2> lVar, @os.l um.d<? super T> dVar) {
        q qVar = new q(wm.c.e(dVar), 1);
        qVar.F();
        lVar.invoke(qVar);
        Object objZ = qVar.z();
        if (objZ == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return objZ;
    }

    public static final <T> Object d(jn.l<? super p<? super T>, lm.l2> lVar, um.d<? super T> dVar) {
        q qVar = new q(wm.c.e(dVar), 1);
        qVar.F();
        lVar.invoke(qVar);
        Object objZ = qVar.z();
        if (objZ == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return objZ;
    }

    @os.m
    public static final <T> Object e(@os.l jn.l<? super q<? super T>, lm.l2> lVar, @os.l um.d<? super T> dVar) {
        q qVarB = b(wm.c.e(dVar));
        try {
            lVar.invoke(qVarB);
            Object objZ = qVarB.z();
            if (objZ == wm.a.COROUTINE_SUSPENDED) {
                xm.h.c(dVar);
            }
            return objZ;
        } catch (Throwable th2) {
            qVarB.Q();
            throw th2;
        }
    }

    public static final <T> Object f(jn.l<? super q<? super T>, lm.l2> lVar, um.d<? super T> dVar) {
        q qVarB = b(wm.c.e(dVar));
        try {
            lVar.invoke(qVarB);
            Object objZ = qVarB.z();
            if (objZ == wm.a.COROUTINE_SUSPENDED) {
                xm.h.c(dVar);
            }
            return objZ;
        } catch (Throwable th2) {
            qVarB.Q();
            throw th2;
        }
    }
}
