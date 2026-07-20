package tq;

import kn.l0;
import kn.n0;
import kn.r1;
import lm.z0;
import nq.l2;
import vq.q0;

/* JADX INFO: loaded from: classes3.dex */
public final class x {

    public static final class a extends n0 implements jn.p<Integer, um.g.b, Integer> {
        final /* synthetic */ v<?> $this_checkContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(v<?> vVar) {
            super(2);
            this.$this_checkContext = vVar;
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, um.g.b bVar) {
            return invoke(num.intValue(), bVar);
        }

        @os.l
        public final Integer invoke(int i10, @os.l um.g.b bVar) {
            um.g.c<?> key = bVar.getKey();
            um.g.b bVar2 = this.$this_checkContext.collectContext.get(key);
            if (key != l2.f11882k) {
                return Integer.valueOf(bVar != bVar2 ? Integer.MIN_VALUE : i10 + 1);
            }
            l2 l2Var = (l2) bVar2;
            l0.n(bVar, "null cannot be cast to non-null type kotlinx.coroutines.Job");
            l2 l2VarB = x.b((l2) bVar, l2Var);
            if (l2VarB == l2Var) {
                if (l2Var != null) {
                    i10++;
                }
                return Integer.valueOf(i10);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + l2VarB + ", expected child of " + l2Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n*L\n1#1,113:1\n*E\n"})
    public static final class b<T> implements sq.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.p<sq.j<? super T>, um.d<? super lm.l2>, Object> f16066a;

        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        public static final class a extends xm.d {
            int label;
            /* synthetic */ Object result;

            public a(um.d<? super a> dVar) {
                super(dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return b.this.a(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(jn.p<? super sq.j<? super T>, ? super um.d<? super lm.l2>, ? extends Object> pVar) {
            this.f16066a = pVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super T> jVar, @os.l um.d<? super lm.l2> dVar) {
            Object objInvoke = this.f16066a.invoke(jVar, dVar);
            return objInvoke == wm.a.COROUTINE_SUSPENDED ? objInvoke : lm.l2.f10208a;
        }

        @os.m
        public Object g(@os.l sq.j<? super T> jVar, @os.l um.d<? super lm.l2> dVar) {
            new a(dVar);
            this.f16066a.invoke(jVar, dVar);
            return lm.l2.f10208a;
        }
    }

    @in.i(name = "checkContext")
    public static final void a(@os.l v<?> vVar, @os.l um.g gVar) {
        if (((Number) gVar.fold(0, new a(vVar))).intValue() == vVar.collectContextSize) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + vVar.collectContext + ",\n\t\tbut emission happened in " + gVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    @os.m
    public static final l2 b(@os.m l2 l2Var, @os.m l2 l2Var2) {
        while (l2Var != null) {
            if (l2Var == l2Var2 || !(l2Var instanceof q0)) {
                return l2Var;
            }
            l2Var = l2Var.getParent();
        }
        return null;
    }

    @z0
    @os.l
    public static final <T> sq.i<T> c(@lm.b @os.l jn.p<? super sq.j<? super T>, ? super um.d<? super lm.l2>, ? extends Object> pVar) {
        return new b(pVar);
    }
}
