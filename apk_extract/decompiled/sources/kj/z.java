package kj;

import java.net.SocketTimeoutException;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class z extends qj.e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ a0 f6980m;

    public z(a0 a0Var) {
        this.f6980m = a0Var;
    }

    @Override // qj.e
    public final void j() {
        this.f6980m.e(c.CANCEL);
        s sVar = this.f6980m.f6886n;
        synchronized (sVar) {
            long j8 = sVar.p;
            long j10 = sVar.f6947o;
            if (j8 < j10) {
                return;
            }
            sVar.f6947o = j10 + 1;
            sVar.q = System.nanoTime() + ((long) 1000000000);
            Unit unit = Unit.INSTANCE;
            sVar.f6942j.c(new gj.b(h0.a.n(new StringBuilder(), sVar.f6938c, " ping"), sVar), 0L);
        }
    }

    public final void k() {
        if (i()) {
            throw new SocketTimeoutException("timeout");
        }
    }
}
