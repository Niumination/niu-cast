package pl;

import lm.d1;
import lm.l2;
import nq.c2;
import nq.k1;
import nq.s0;
import nq.t0;

/* JADX INFO: loaded from: classes2.dex */
public final class v {

    public static final class a extends kn.n0 implements jn.l<Throwable, l2> {
        final /* synthetic */ c $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar) {
            super(1);
            this.$channel = cVar;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
            invoke2(th2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.m Throwable th2) {
            this.$channel.f(th2);
        }
    }

    @xm.f(c = "io.ktor.utils.io.CoroutinesKt$launchChannel$job$1", f = "Coroutines.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ boolean $attachJob;
        final /* synthetic */ jn.p<S, um.d<? super l2>, Object> $block;
        final /* synthetic */ c $channel;
        final /* synthetic */ nq.n0 $dispatcher;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(boolean z10, c cVar, jn.p<? super S, ? super um.d<? super l2>, ? extends Object> pVar, nq.n0 n0Var, um.d<? super b> dVar) {
            super(2, dVar);
            this.$attachJob = z10;
            this.$channel = cVar;
            this.$block = pVar;
            this.$dispatcher = n0Var;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            b bVar = new b(this.$attachJob, this.$channel, this.$block, this.$dispatcher, dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v8 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    d1.n(obj);
                    s0 s0Var = (s0) this.L$0;
                    if (this.$attachJob) {
                        c cVar = this.$channel;
                        um.g.b bVar = s0Var.getCoroutineContext().get(nq.l2.f11882k);
                        kn.l0.m(bVar);
                        cVar.j((nq.l2) bVar);
                    }
                    i0 rVar = new r(s0Var, this.$channel);
                    jn.p<S, um.d<? super l2>, Object> pVar = this.$block;
                    this.label = 1;
                    Object objInvoke = pVar.invoke((S) rVar, this);
                    this = objInvoke;
                    if (objInvoke == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                    this = this;
                }
            } catch (Throwable th2) {
                if (!kn.l0.g(this.$dispatcher, k1.g()) && this.$dispatcher != null) {
                    throw th2;
                }
                this.$channel.c(th2);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public static final <S extends s0> p a(s0 s0Var, um.g gVar, c cVar, boolean z10, jn.p<? super S, ? super um.d<? super l2>, ? extends Object> pVar) {
        nq.l2 l2VarF = nq.k.f(s0Var, gVar, null, new b(z10, cVar, pVar, (nq.n0) s0Var.getCoroutineContext().get(nq.n0.Key), null), 2, null);
        l2VarF.k0(new a(cVar));
        return new p(l2VarF, cVar);
    }

    @os.l
    public static final h0 b(@os.l s0 s0Var, @os.l um.g gVar, @os.l c cVar, @os.l jn.p<? super i0, ? super um.d<? super l2>, ? extends Object> pVar) {
        kn.l0.p(s0Var, "<this>");
        kn.l0.p(gVar, "coroutineContext");
        kn.l0.p(cVar, "channel");
        kn.l0.p(pVar, "block");
        return a(s0Var, gVar, cVar, false, pVar);
    }

    @os.l
    public static final h0 c(@os.l s0 s0Var, @os.l um.g gVar, boolean z10, @os.l jn.p<? super i0, ? super um.d<? super l2>, ? extends Object> pVar) {
        kn.l0.p(s0Var, "<this>");
        kn.l0.p(gVar, "coroutineContext");
        kn.l0.p(pVar, "block");
        return a(s0Var, gVar, e.a(z10), true, pVar);
    }

    @lm.k(message = "Use scope.reader instead")
    @os.l
    public static final h0 d(@os.l um.g gVar, @os.l c cVar, @os.m nq.l2 l2Var, @os.l jn.p<? super i0, ? super um.d<? super l2>, ? extends Object> pVar) {
        kn.l0.p(gVar, "coroutineContext");
        kn.l0.p(cVar, "channel");
        kn.l0.p(pVar, "block");
        return b(t0.a(l2Var != null ? nq.m0.d(c2.f11831a, gVar.plus(l2Var)) : nq.m0.d(c2.f11831a, gVar)), um.i.INSTANCE, cVar, pVar);
    }

    @lm.k(message = "Use scope.reader instead")
    @os.l
    public static final h0 e(@os.l um.g gVar, boolean z10, @os.m nq.l2 l2Var, @os.l jn.p<? super i0, ? super um.d<? super l2>, ? extends Object> pVar) {
        kn.l0.p(gVar, "coroutineContext");
        kn.l0.p(pVar, "block");
        c cVarA = e.a(z10);
        h0 h0VarD = d(gVar, cVarA, l2Var, pVar);
        cVarA.j(h0VarD);
        return h0VarD;
    }

    public static /* synthetic */ h0 f(s0 s0Var, um.g gVar, c cVar, jn.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = um.i.INSTANCE;
        }
        return b(s0Var, gVar, cVar, pVar);
    }

    public static /* synthetic */ h0 g(s0 s0Var, um.g gVar, boolean z10, jn.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = um.i.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return c(s0Var, gVar, z10, pVar);
    }

    public static /* synthetic */ h0 h(um.g gVar, c cVar, nq.l2 l2Var, jn.p pVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            l2Var = null;
        }
        return d(gVar, cVar, l2Var, pVar);
    }

    public static /* synthetic */ h0 i(um.g gVar, boolean z10, nq.l2 l2Var, jn.p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            l2Var = null;
        }
        return e(gVar, z10, l2Var, pVar);
    }

    @os.l
    public static final l0 j(@os.l s0 s0Var, @os.l um.g gVar, @os.l c cVar, @os.l jn.p<? super m0, ? super um.d<? super l2>, ? extends Object> pVar) {
        kn.l0.p(s0Var, "<this>");
        kn.l0.p(gVar, "coroutineContext");
        kn.l0.p(cVar, "channel");
        kn.l0.p(pVar, "block");
        return a(s0Var, gVar, cVar, false, pVar);
    }

    @os.l
    public static final l0 k(@os.l s0 s0Var, @os.l um.g gVar, boolean z10, @os.l jn.p<? super m0, ? super um.d<? super l2>, ? extends Object> pVar) {
        kn.l0.p(s0Var, "<this>");
        kn.l0.p(gVar, "coroutineContext");
        kn.l0.p(pVar, "block");
        return a(s0Var, gVar, e.a(z10), true, pVar);
    }

    @lm.k(message = "Use scope.writer instead")
    @os.l
    public static final l0 l(@os.l um.g gVar, @os.l c cVar, @os.m nq.l2 l2Var, @os.l jn.p<? super m0, ? super um.d<? super l2>, ? extends Object> pVar) {
        kn.l0.p(gVar, "coroutineContext");
        kn.l0.p(cVar, "channel");
        kn.l0.p(pVar, "block");
        return j(t0.a(l2Var != null ? nq.m0.d(c2.f11831a, gVar.plus(l2Var)) : nq.m0.d(c2.f11831a, gVar)), um.i.INSTANCE, cVar, pVar);
    }

    @lm.k(message = "Use scope.writer instead")
    @os.l
    public static final l0 m(@os.l um.g gVar, boolean z10, @os.m nq.l2 l2Var, @os.l jn.p<? super m0, ? super um.d<? super l2>, ? extends Object> pVar) {
        kn.l0.p(gVar, "coroutineContext");
        kn.l0.p(pVar, "block");
        c cVarA = e.a(z10);
        l0 l0VarL = l(gVar, cVarA, l2Var, pVar);
        cVarA.j(l0VarL);
        return l0VarL;
    }

    public static /* synthetic */ l0 n(s0 s0Var, um.g gVar, c cVar, jn.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = um.i.INSTANCE;
        }
        return j(s0Var, gVar, cVar, pVar);
    }

    public static /* synthetic */ l0 o(s0 s0Var, um.g gVar, boolean z10, jn.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = um.i.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return k(s0Var, gVar, z10, pVar);
    }

    public static /* synthetic */ l0 p(um.g gVar, c cVar, nq.l2 l2Var, jn.p pVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            l2Var = null;
        }
        return l(gVar, cVar, l2Var, pVar);
    }

    public static /* synthetic */ l0 q(um.g gVar, boolean z10, nq.l2 l2Var, jn.p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            l2Var = null;
        }
        return m(gVar, z10, l2Var, pVar);
    }
}
