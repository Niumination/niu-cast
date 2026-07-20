package nq;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
public final class h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11858a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f11859b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f11860c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11861d = 3;

    /* JADX INFO: Add missing generic type declarations: [T] */
    @xm.f(c = "kotlinx.coroutines.InterruptibleKt$runInterruptible$2", f = "Interruptible.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a<T> extends xm.o implements jn.p<s0, um.d<? super T>, Object> {
        final /* synthetic */ jn.a<T> $block;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(jn.a<? extends T> aVar, um.d<? super a> dVar) {
            super(2, dVar);
            this.$block = aVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<lm.l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            a aVar = new a(this.$block, dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lm.d1.n(obj);
            return h2.d(((s0) this.L$0).getCoroutineContext(), this.$block);
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super T> dVar) {
            return ((a) create(s0Var, dVar)).invokeSuspend(lm.l2.f10208a);
        }
    }

    @os.m
    public static final <T> Object b(@os.l um.g gVar, @os.l jn.a<? extends T> aVar, @os.l um.d<? super T> dVar) {
        return k.g(gVar, new a(aVar, null), dVar);
    }

    public static /* synthetic */ Object c(um.g gVar, jn.a aVar, um.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = um.i.INSTANCE;
        }
        return b(gVar, aVar, dVar);
    }

    public static final <T> T d(um.g gVar, jn.a<? extends T> aVar) throws Throwable {
        try {
            u3 u3Var = new u3(r2.z(gVar));
            u3Var.d();
            try {
                return aVar.invoke();
            } finally {
                u3Var.a();
            }
        } catch (InterruptedException e10) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e10);
        }
    }
}
