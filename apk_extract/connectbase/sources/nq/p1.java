package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class p1 extends s2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final n1 f11892e;

    public p1(@os.l n1 n1Var) {
        this.f11892e = n1Var;
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ lm.l2 invoke(Throwable th2) {
        invoke2(th2);
        return lm.l2.f10208a;
    }

    @Override // nq.f0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(@os.m Throwable th2) {
        this.f11892e.dispose();
    }
}
