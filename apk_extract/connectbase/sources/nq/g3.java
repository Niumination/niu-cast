package nq;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nExecutors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Executors.kt\nkotlinx/coroutines/ResumeUndispatchedRunnable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,207:1\n1#2:208\n*E\n"})
public final class g3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final n0 f11854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final p<lm.l2> f11855b;

    /* JADX WARN: Multi-variable type inference failed */
    public g3(@os.l n0 n0Var, @os.l p<? super lm.l2> pVar) {
        this.f11854a = n0Var;
        this.f11855b = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f11855b.G(this.f11854a, lm.l2.f10208a);
    }
}
