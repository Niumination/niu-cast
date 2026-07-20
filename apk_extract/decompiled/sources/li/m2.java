package li;

/* JADX INFO: loaded from: classes3.dex */
public final class m2 extends qi.v implements Runnable {
    public final long e;

    public m2(long j8, n2 n2Var) {
        super(n2Var, n2Var.get$context());
        this.e = j8;
    }

    @Override // li.x1
    public final String f0() {
        return super.f0() + "(timeMillis=" + this.e + ')';
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0.b(this.f7429c);
        z(new l2("Timed out waiting for " + this.e + " ms", this));
    }
}
