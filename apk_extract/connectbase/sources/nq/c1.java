package nq;

/* JADX INFO: loaded from: classes3.dex */
@g2
public interface c1 {

    @kn.r1({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/Delay$DefaultImpls\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,162:1\n314#2,11:163\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/Delay$DefaultImpls\n*L\n30#1:163,11\n*E\n"})
    public static final class a {
        @os.m
        @lm.k(level = lm.m.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
        public static Object a(@os.l c1 c1Var, long j10, @os.l um.d<? super lm.l2> dVar) {
            if (j10 <= 0) {
                return lm.l2.f10208a;
            }
            q qVar = new q(wm.c.e(dVar), 1);
            qVar.F();
            c1Var.b0(j10, qVar);
            Object objZ = qVar.z();
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (objZ == aVar) {
                xm.h.c(dVar);
            }
            return objZ == aVar ? objZ : lm.l2.f10208a;
        }

        @os.l
        public static n1 b(@os.l c1 c1Var, long j10, @os.l Runnable runnable, @os.l um.g gVar) {
            return z0.a().E(j10, runnable, gVar);
        }
    }

    @os.l
    n1 E(long j10, @os.l Runnable runnable, @os.l um.g gVar);

    void b0(long j10, @os.l p<? super lm.l2> pVar);

    @os.m
    @lm.k(level = lm.m.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    Object n(long j10, @os.l um.d<? super lm.l2> dVar);
}
