package tq;

import androidx.constraintlayout.widget.ConstraintLayout;
import kn.r1;
import lm.d1;
import lm.l2;
import nq.s0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nFlowCoroutine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowCoroutine.kt\nkotlinx/coroutines/flow/internal/FlowCoroutineKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,63:1\n107#2:64\n*S KotlinDebug\n*F\n+ 1 FlowCoroutine.kt\nkotlinx/coroutines/flow/internal/FlowCoroutineKt\n*L\n50#1:64\n*E\n"})
public final class p {

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 FlowCoroutine.kt\nkotlinx/coroutines/flow/internal/FlowCoroutineKt\n*L\n1#1,113:1\n51#2,2:114\n*E\n"})
    public static final class a<R> implements sq.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.q f16058a;

        public a(jn.q qVar) {
            this.f16058a = qVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super R> jVar, @os.l um.d<? super l2> dVar) {
            Object objA = p.a(new b(this.f16058a, jVar, null), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.internal.FlowCoroutineKt$scopedFlow$1$1", f = "FlowCoroutine.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ jn.q<s0, sq.j<? super R>, um.d<? super l2>, Object> $block;
        final /* synthetic */ sq.j<R> $this_unsafeFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(jn.q<? super s0, ? super sq.j<? super R>, ? super um.d<? super l2>, ? extends Object> qVar, sq.j<? super R> jVar, um.d<? super b> dVar) {
            super(2, dVar);
            this.$block = qVar;
            this.$this_unsafeFlow = jVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            b bVar = new b(this.$block, this.$this_unsafeFlow, dVar);
            bVar.L$0 = obj;
            return bVar;
        }

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
            Object obj2 = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                s0 s0Var = (s0) this.L$0;
                jn.q<s0, sq.j<? super R>, um.d<? super l2>, Object> qVar = this.$block;
                Object obj3 = this.$this_unsafeFlow;
                this.label = 1;
                if (qVar.invoke(s0Var, obj3, this) == obj2) {
                    return obj2;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @os.m
    public static final <R> Object a(@lm.b @os.l jn.p<? super s0, ? super um.d<? super R>, ? extends Object> pVar, @os.l um.d<? super R> dVar) {
        o oVar = new o(dVar.getContext(), dVar);
        Object objE = wq.b.e(oVar, oVar, pVar);
        if (objE == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return objE;
    }

    @os.l
    public static final <R> sq.i<R> b(@lm.b @os.l jn.q<? super s0, ? super sq.j<? super R>, ? super um.d<? super l2>, ? extends Object> qVar) {
        return new a(qVar);
    }
}
