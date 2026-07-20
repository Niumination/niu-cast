package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class w extends n2 implements v {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @in.f
    @os.l
    public final x f11972e;

    public w(@os.l x xVar) {
        this.f11972e = xVar;
    }

    @Override // nq.v
    @os.l
    public l2 getParent() {
        return C();
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ lm.l2 invoke(Throwable th2) {
        invoke2(th2);
        return lm.l2.f10208a;
    }

    @Override // nq.v
    public boolean k(@os.l Throwable th2) {
        return C().n0(th2);
    }

    @Override // nq.f0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(@os.m Throwable th2) {
        this.f11972e.P0(C());
    }
}
