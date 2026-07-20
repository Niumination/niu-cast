package gk;

import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    @xm.f(c = "io.ktor.features.CallLoggingKt$withMDC$2", f = "CallLogging.kt", i = {}, l = {234}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends xm.o implements jn.p<nq.s0, um.d<? super l2>, Object> {
        final /* synthetic */ jn.l<um.d<? super l2>, Object> $block;
        final /* synthetic */ i $feature;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(jn.l<? super um.d<? super l2>, ? extends Object> lVar, i iVar, um.d<? super a> dVar) {
            super(2, dVar);
            this.$block = lVar;
            this.$feature = iVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new a(this.$block, this.$feature, dVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, lm.l2] */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    lm.d1.n(obj);
                    jn.l<um.d<? super l2>, Object> lVar = this.$block;
                    this.label = 1;
                    if (lVar.invoke(this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lm.d1.n(obj);
                }
                this.$feature.j();
                this = l2.f10208a;
                return this;
            } catch (Throwable th2) {
                this.$feature.j();
                throw th2;
            }
        }

        @os.m
        public final Object invokeSuspend$$forInline(@os.l Object obj) {
            try {
                this.$block.invoke(this);
                return l2.f10208a;
            } finally {
                this.$feature.j();
            }
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l nq.s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @os.l
    public static final String a(@os.l uk.d dVar) {
        kn.l0.p(dVar, "<this>");
        return uk.e.n(dVar).f8144a + " - " + uk.e.v(dVar);
    }

    public static final Object b(dk.b bVar, jn.l<? super um.d<? super l2>, ? extends Object> lVar, um.d<? super l2> dVar) throws Throwable {
        i iVar = (i) dk.i.b(bVar.a(), i.f6621k);
        if (iVar == null) {
            lVar.invoke(dVar);
            return l2.f10208a;
        }
        nq.k.g(new n0(iVar.m(bVar)), new a(lVar, iVar, null), dVar);
        return l2.f10208a;
    }
}
