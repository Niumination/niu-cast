package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class i2 extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final jn.l<Throwable, lm.l2> f11868a;

    /* JADX WARN: Multi-variable type inference failed */
    public i2(@os.l jn.l<? super Throwable, lm.l2> lVar) {
        this.f11868a = lVar;
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ lm.l2 invoke(Throwable th2) {
        invoke2(th2);
        return lm.l2.f10208a;
    }

    @os.l
    public String toString() {
        return "InvokeOnCancel[" + x0.a(this.f11868a) + '@' + x0.b(this) + ']';
    }

    @Override // nq.o
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(@os.m Throwable th2) {
        this.f11868a.invoke(th2);
    }
}
