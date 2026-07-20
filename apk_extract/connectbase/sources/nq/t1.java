package nq;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes3.dex */
public abstract class t1 extends r1 {
    @os.l
    public abstract Thread b2();

    public void f2(long j10, @os.l s1.c cVar) {
        y0.f11985g.p2(j10, cVar);
    }

    public final void g2() {
        lm.l2 l2Var;
        Thread threadB2 = b2();
        if (Thread.currentThread() != threadB2) {
            b bVarB = c.b();
            if (bVarB != null) {
                bVarB.g(threadB2);
                l2Var = lm.l2.f10208a;
            } else {
                l2Var = null;
            }
            if (l2Var == null) {
                LockSupport.unpark(threadB2);
            }
        }
    }
}
