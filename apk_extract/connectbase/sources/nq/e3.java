package nq;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/ResumeAwaitOnCompletion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1454:1\n1#2:1455\n*E\n"})
public final class e3<T> extends s2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final q<T> f11848e;

    /* JADX WARN: Multi-variable type inference failed */
    public e3(@os.l q<? super T> qVar) {
        this.f11848e = qVar;
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ lm.l2 invoke(Throwable th2) {
        invoke2(th2);
        return lm.l2.f10208a;
    }

    @Override // nq.f0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(@os.m Throwable th2) {
        Object objV0 = C().V0();
        if (objV0 instanceof d0) {
            q<T> qVar = this.f11848e;
            lm.c1.a aVar = lm.c1.Companion;
            qVar.resumeWith(lm.c1.m59constructorimpl(lm.d1.a(((d0) objV0).f11836a)));
        } else {
            q<T> qVar2 = this.f11848e;
            lm.c1.a aVar2 = lm.c1.Companion;
            qVar2.resumeWith(lm.c1.m59constructorimpl(u2.h(objV0)));
        }
    }
}
