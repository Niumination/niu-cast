package p001if;

import java.util.concurrent.atomic.AtomicLong;
import ze.n;
import ze.q2;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f5833b;

    public o(p pVar) {
        this.f5833b = pVar;
    }

    @Override // ze.n
    public final void m(q2 q2Var) {
        i iVar = this.f5833b.f5834a;
        boolean zE = q2Var.e();
        m mVar = iVar.f5814a;
        if (mVar.e == null && mVar.f == null) {
            return;
        }
        if (zE) {
            ((AtomicLong) iVar.f5815b.f92a).getAndIncrement();
        } else {
            ((AtomicLong) iVar.f5815b.f93b).getAndIncrement();
        }
    }
}
