package pq;

import java.util.concurrent.CancellationException;
import nq.l2;
import nq.p0;
import nq.w1;
import nq.x0;

/* JADX INFO: loaded from: classes3.dex */
public class a<E> extends m<E> implements c<E> {
    public a(@os.l um.g gVar, @os.l l<E> lVar, boolean z10) {
        super(gVar, lVar, false, z10);
        Y0((l2) gVar.get(l2.f11882k));
    }

    @Override // nq.t2
    public boolean W0(@os.l Throwable th2) {
        p0.b(this.f11822c, th2);
        return true;
    }

    @Override // nq.t2
    public void s1(@os.m Throwable th2) {
        l<E> lVar = this.f13307d;
        CancellationException cancellationExceptionA = null;
        if (th2 != null) {
            cancellationExceptionA = th2 instanceof CancellationException ? (CancellationException) th2 : null;
            if (cancellationExceptionA == null) {
                cancellationExceptionA = w1.a(x0.a(this) + " was cancelled", th2);
            }
        }
        lVar.b(cancellationExceptionA);
    }
}
