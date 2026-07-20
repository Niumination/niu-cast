package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class o1 extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final n1 f11889a;

    public o1(@os.l n1 n1Var) {
        this.f11889a = n1Var;
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ lm.l2 invoke(Throwable th2) {
        invoke2(th2);
        return lm.l2.f10208a;
    }

    @os.l
    public String toString() {
        return "DisposeOnCancel[" + this.f11889a + ']';
    }

    @Override // nq.o
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(@os.m Throwable th2) {
        this.f11889a.dispose();
    }
}
