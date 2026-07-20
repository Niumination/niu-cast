package af;

/* JADX INFO: loaded from: classes3.dex */
public final class n5 extends d6 {
    @Override // af.d6
    public final boolean s(o5 o5Var) {
        synchronized (o5Var) {
            try {
                if (o5Var.f489c != 0) {
                    return false;
                }
                o5Var.f489c = -1;
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // af.d6
    public final void t(o5 o5Var) {
        synchronized (o5Var) {
            o5Var.f489c = 0;
        }
    }
}
