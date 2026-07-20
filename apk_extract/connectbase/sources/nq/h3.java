package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class h3 {

    @kn.r1({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n*L\n1#1,18:1\n*E\n"})
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.a<lm.l2> f11862a;

        public a(jn.a<lm.l2> aVar) {
            this.f11862a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f11862a.invoke();
        }
    }

    @os.l
    public static final Runnable a(@os.l jn.a<lm.l2> aVar) {
        return new a(aVar);
    }
}
