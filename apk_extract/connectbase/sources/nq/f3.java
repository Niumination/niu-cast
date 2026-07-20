package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class f3 extends s2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final um.d<lm.l2> f11850e;

    /* JADX WARN: Multi-variable type inference failed */
    public f3(@os.l um.d<? super lm.l2> dVar) {
        this.f11850e = dVar;
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ lm.l2 invoke(Throwable th2) {
        invoke2(th2);
        return lm.l2.f10208a;
    }

    @Override // nq.f0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(@os.m Throwable th2) {
        um.d<lm.l2> dVar = this.f11850e;
        lm.c1.a aVar = lm.c1.Companion;
        dVar.resumeWith(lm.c1.m59constructorimpl(lm.l2.f10208a));
    }
}
