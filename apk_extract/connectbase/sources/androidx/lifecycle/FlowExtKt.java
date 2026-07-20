package androidx.lifecycle;

import jn.p;
import kn.l0;
import lm.d1;
import lm.l2;
import ms.a;
import nq.s0;
import os.l;
import os.m;
import pq.d0;
import pq.g0;
import sq.i;
import sq.j;
import um.d;
import xm.f;
import xm.o;

/* JADX INFO: loaded from: classes.dex */
public final class FlowExtKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1, reason: invalid class name */
    @f(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1", f = "FlowExt.kt", i = {0}, l = {a.T}, m = "invokeSuspend", n = {"$this$callbackFlow"}, s = {"L$0"})
    public static final class AnonymousClass1<T> extends o implements p<d0<? super T>, d<? super l2>, Object> {
        final /* synthetic */ Lifecycle $lifecycle;
        final /* synthetic */ Lifecycle.State $minActiveState;
        final /* synthetic */ i<T> $this_flowWithLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1, reason: invalid class name and collision with other inner class name */
        @f(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1", f = "FlowExt.kt", i = {}, l = {a.W}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00111 extends o implements p<s0, d<? super l2>, Object> {
            final /* synthetic */ d0<T> $$this$callbackFlow;
            final /* synthetic */ i<T> $this_flowWithLifecycle;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C00111(i<? extends T> iVar, d0<? super T> d0Var, d<? super C00111> dVar) {
                super(2, dVar);
                this.$this_flowWithLifecycle = iVar;
                this.$$this$callbackFlow = d0Var;
            }

            @Override // xm.a
            @l
            public final d<l2> create(@m Object obj, @l d<?> dVar) {
                return new C00111(this.$this_flowWithLifecycle, this.$$this$callbackFlow, dVar);
            }

            @Override // xm.a
            @m
            public final Object invokeSuspend(@l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    i<T> iVar = this.$this_flowWithLifecycle;
                    final d0<T> d0Var = this.$$this$callbackFlow;
                    j<? super T> jVar = new j() { // from class: androidx.lifecycle.FlowExtKt.flowWithLifecycle.1.1.1
                        @Override // sq.j
                        @m
                        public final Object emit(T t10, @l d<? super l2> dVar) {
                            Object objL = d0Var.L(t10, dVar);
                            return objL == wm.a.COROUTINE_SUSPENDED ? objL : l2.f10208a;
                        }
                    };
                    this.label = 1;
                    if (iVar.a(jVar, this) == aVar) {
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
            @m
            public final Object invoke(@l s0 s0Var, @m d<? super l2> dVar) {
                return ((C00111) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, i<? extends T> iVar, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$lifecycle = lifecycle;
            this.$minActiveState = state;
            this.$this_flowWithLifecycle = iVar;
        }

        @Override // xm.a
        @l
        public final d<l2> create(@m Object obj, @l d<?> dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$lifecycle, this.$minActiveState, this.$this_flowWithLifecycle, dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            d0 d0Var;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                d0 d0Var2 = (d0) this.L$0;
                Lifecycle lifecycle = this.$lifecycle;
                Lifecycle.State state = this.$minActiveState;
                C00111 c00111 = new C00111(this.$this_flowWithLifecycle, d0Var2, null);
                this.L$0 = d0Var2;
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, state, c00111, this) == aVar) {
                    return aVar;
                }
                d0Var = d0Var2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d0Var = (d0) this.L$0;
                d1.n(obj);
            }
            g0.a.a(d0Var, null, 1, null);
            return l2.f10208a;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l d0<? super T> d0Var, @m d<? super l2> dVar) {
            return ((AnonymousClass1) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @l
    public static final <T> i<T> flowWithLifecycle(@l i<? extends T> iVar, @l Lifecycle lifecycle, @l Lifecycle.State state) {
        l0.p(iVar, "<this>");
        l0.p(lifecycle, "lifecycle");
        l0.p(state, "minActiveState");
        return sq.l.k(new AnonymousClass1(lifecycle, state, iVar, null));
    }

    public static /* synthetic */ i flowWithLifecycle$default(i iVar, Lifecycle lifecycle, Lifecycle.State state, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        return flowWithLifecycle(iVar, lifecycle, state);
    }
}
