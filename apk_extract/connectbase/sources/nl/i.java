package nl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import jn.q;
import kn.l0;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: Add missing generic type declarations: [TContext] */
    @xm.f(c = "io.ktor.util.pipeline.PipelineKt$intercept$1", f = "Pipeline.kt", i = {}, l = {447}, m = "invokeSuspend", n = {}, s = {})
    public static final class a<TContext> extends xm.o implements q<f<? extends Object, TContext>, Object, um.d<? super l2>, Object> {
        final /* synthetic */ q<f<TSubject, TContext>, TSubject, um.d<? super l2>, Object> $block;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(q<? super f<TSubject, TContext>, ? super TSubject, ? super um.d<? super l2>, ? extends Object> qVar, um.d<? super a> dVar) {
            super(3, dVar);
            this.$block = qVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to nl.i$a<TContext> for r5v5 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r6) {
            /*
                r5 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r5.label
                r2 = 1
                if (r1 == 0) goto L15
                if (r1 != r2) goto Ld
                lm.d1.n(r6)
                goto L3b
            Ld:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L15:
                lm.d1.n(r6)
                java.lang.Object r6 = r5.L$0
                nl.f r6 = (nl.f) r6
                java.lang.Object r1 = r5.L$1
                kn.l0.P()
                if (r1 != 0) goto L26
                lm.l2 r5 = lm.l2.f10208a
                return r5
            L26:
                r3 = 0
                if (r6 == 0) goto L2a
                goto L2b
            L2a:
                r6 = r3
            L2b:
                if (r6 != 0) goto L2e
                goto L3b
            L2e:
                jn.q<nl.f<TSubject, TContext>, TSubject, um.d<? super lm.l2>, java.lang.Object> r4 = r5.$block
                r5.L$0 = r3
                r5.label = r2
                java.lang.Object r5 = r4.invoke(r6, r1, r5)
                if (r5 != r0) goto L3b
                return r0
            L3b:
                lm.l2 r5 = lm.l2.f10208a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: nl.i.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l f<? extends Object, TContext> fVar, @os.l Object obj, @os.m um.d<? super l2> dVar) {
            a aVar = new a(this.$block, dVar);
            aVar.L$0 = fVar;
            aVar.L$1 = obj;
            return aVar.invokeSuspend(l2.f10208a);
        }
    }

    @os.m
    public static final <TContext> Object a(@os.l e<l2, TContext> eVar, @os.l TContext tcontext, @os.l um.d<? super l2> dVar) {
        l2 l2Var = l2.f10208a;
        Object objG = eVar.g(tcontext, l2Var, dVar);
        return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2Var;
    }

    public static final <TContext> Object b(e<l2, TContext> eVar, TContext tcontext, um.d<? super l2> dVar) {
        l2 l2Var = l2.f10208a;
        eVar.g(tcontext, l2Var, dVar);
        return l2Var;
    }

    public static final <TSubject, TContext> void c(e<?, TContext> eVar, j jVar, q<? super f<TSubject, TContext>, ? super TSubject, ? super um.d<? super l2>, ? extends Object> qVar) throws c {
        l0.p(eVar, "<this>");
        l0.p(jVar, TypedValues.CycleType.S_WAVE_PHASE);
        l0.p(qVar, "block");
        l0.P();
        eVar.x(jVar, new a(qVar, null));
    }
}
