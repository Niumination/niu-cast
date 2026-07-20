package sq;

import kn.r1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3\n*L\n1#1,118:1\n*E\n"})
    public static final class a<T> implements j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.p<T, um.d<? super l2>, Object> f15312a;

        /* JADX INFO: renamed from: sq.n$a$a, reason: collision with other inner class name */
        @r1({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1\n*L\n1#1,118:1\n*E\n"})
        public static final class C0389a extends xm.d {
            int label;
            /* synthetic */ Object result;

            public C0389a(um.d<? super C0389a> dVar) {
                super(dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return a.this.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(jn.p<? super T, ? super um.d<? super l2>, ? extends Object> pVar) {
            this.f15312a = pVar;
        }

        @os.m
        public Object a(T t10, @os.l um.d<? super l2> dVar) {
            new C0389a(dVar);
            this.f15312a.invoke(t10, dVar);
            return l2.f10208a;
        }

        @Override // sq.j
        @os.m
        public Object emit(T t10, @os.l um.d<? super l2> dVar) {
            Object objInvoke = this.f15312a.invoke(t10, dVar);
            return objInvoke == wm.a.COROUTINE_SUSPENDED ? objInvoke : l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2\n+ 2 FlowExceptions.common.kt\nkotlinx/coroutines/flow/internal/FlowExceptions_commonKt\n*L\n1#1,118:1\n32#2,4:119\n*S KotlinDebug\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2\n*L\n62#1:119,4\n*E\n"})
    public static final class b<T> implements j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.q<Integer, T, um.d<? super l2>, Object> f15314b;

        @r1({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2$emit$1\n*L\n1#1,118:1\n*E\n"})
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
                return b.this.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(jn.q<? super Integer, ? super T, ? super um.d<? super l2>, ? extends Object> qVar) {
            this.f15314b = qVar;
        }

        @os.m
        public Object a(T t10, @os.l um.d<? super l2> dVar) {
            new a(dVar);
            jn.q<Integer, T, um.d<? super l2>, Object> qVar = this.f15314b;
            int i10 = this.f15313a;
            this.f15313a = i10 + 1;
            if (i10 < 0) {
                throw new ArithmeticException("Index overflow has happened");
            }
            qVar.invoke(Integer.valueOf(i10), t10, dVar);
            return l2.f10208a;
        }

        @Override // sq.j
        @os.m
        public Object emit(T t10, @os.l um.d<? super l2> dVar) {
            jn.q<Integer, T, um.d<? super l2>, Object> qVar = this.f15314b;
            int i10 = this.f15313a;
            this.f15313a = i10 + 1;
            if (i10 < 0) {
                throw new ArithmeticException("Index overflow has happened");
            }
            Object objInvoke = qVar.invoke(new Integer(i10), t10, dVar);
            return objInvoke == wm.a.COROUTINE_SUSPENDED ? objInvoke : l2.f10208a;
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__CollectKt$launchIn$1", f = "Collect.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends xm.o implements jn.p<nq.s0, um.d<? super l2>, Object> {
        final /* synthetic */ i<T> $this_launchIn;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(i<? extends T> iVar, um.d<? super c> dVar) {
            super(2, dVar);
            this.$this_launchIn = iVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new c(this.$this_launchIn, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                i<T> iVar = this.$this_launchIn;
                this.label = 1;
                if (n.b(iVar, this) == aVar) {
                    return aVar;
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
        public final Object invoke(@os.l nq.s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((c) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @lm.k(level = lm.m.HIDDEN, message = "Backwards compatibility with JS and K/N")
    public static final <T> Object a(i<? extends T> iVar, jn.p<? super T, ? super um.d<? super l2>, ? extends Object> pVar, um.d<? super l2> dVar) {
        Object objA = iVar.a(new a(pVar), dVar);
        return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
    }

    @os.m
    public static final Object b(@os.l i<?> iVar, @os.l um.d<? super l2> dVar) {
        Object objA = iVar.a(tq.t.f16061a, dVar);
        return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
    }

    @lm.k(level = lm.m.HIDDEN, message = "Backwards compatibility with JS and K/N")
    public static final <T> Object c(i<? extends T> iVar, jn.p<? super T, ? super um.d<? super l2>, ? extends Object> pVar, um.d<? super l2> dVar) {
        iVar.a(new a(pVar), dVar);
        return l2.f10208a;
    }

    @os.m
    public static final <T> Object d(@os.l i<? extends T> iVar, @os.l jn.q<? super Integer, ? super T, ? super um.d<? super l2>, ? extends Object> qVar, @os.l um.d<? super l2> dVar) {
        Object objA = iVar.a(new b(qVar), dVar);
        return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
    }

    public static final <T> Object e(i<? extends T> iVar, jn.q<? super Integer, ? super T, ? super um.d<? super l2>, ? extends Object> qVar, um.d<? super l2> dVar) {
        iVar.a(new b(qVar), dVar);
        return l2.f10208a;
    }

    @os.m
    public static final <T> Object f(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super l2>, ? extends Object> pVar, @os.l um.d<? super l2> dVar) {
        Object objB = b(p.d(w.k(iVar, pVar), 0, null, 2, null), dVar);
        return objB == wm.a.COROUTINE_SUSPENDED ? objB : l2.f10208a;
    }

    @os.m
    public static final <T> Object g(@os.l j<? super T> jVar, @os.l i<? extends T> iVar, @os.l um.d<? super l2> dVar) {
        t.b(jVar);
        Object objA = iVar.a(jVar, dVar);
        return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
    }

    @os.l
    public static final <T> nq.l2 h(@os.l i<? extends T> iVar, @os.l nq.s0 s0Var) {
        return nq.k.f(s0Var, null, null, new c(iVar, null), 3, null);
    }
}
