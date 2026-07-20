package yk;

import fl.t0;
import kn.l0;
import lm.d1;
import lm.l2;
import nq.c2;
import nq.k1;
import nq.o2;
import nq.r2;
import nq.s0;
import nq.u0;

/* JADX INFO: loaded from: classes2.dex */
public final class z {

    @xm.f(c = "io.ktor.server.engine.EngineContextCancellationHelperKt$launchOnCancellation$1", f = "EngineContextCancellationHelper.kt", i = {0}, l = {32, 38}, m = "invokeSuspend", n = {"cancelled"}, s = {"I$0"})
    public static final class a extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ jn.l<um.d<? super l2>, Object> $block;
        final /* synthetic */ nq.b0 $deferred;
        int I$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(nq.b0 b0Var, jn.l<? super um.d<? super l2>, ? extends Object> lVar, um.d<? super a> dVar) {
            super(2, dVar);
            this.$deferred = b0Var;
            this.$block = lVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new a(this.$deferred, this.$block, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            int i10;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i11 = this.label;
            int i12 = 1;
            try {
                if (i11 != 0) {
                    if (i11 == 1) {
                        i10 = this.I$0;
                        d1.n(obj);
                    } else {
                        if (i11 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d1.n(obj);
                    }
                    return l2.f10208a;
                }
                d1.n(obj);
                nq.b0 b0Var = this.$deferred;
                i10 = 0;
                this.I$0 = 0;
                this.label = 1;
                if (b0Var.t(this) == aVar) {
                    return aVar;
                }
                i12 = i10;
            } catch (Throwable unused) {
            }
            if (i12 != 0 || this.$deferred.isCancelled()) {
                jn.l<um.d<? super l2>, Object> lVar = this.$block;
                this.label = 2;
                if (lVar.invoke(this) == aVar) {
                    return aVar;
                }
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.server.engine.EngineContextCancellationHelperKt$stopServerOnCancellation$1", f = "EngineContextCancellationHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends xm.o implements jn.l<um.d<? super l2>, Object> {
        final /* synthetic */ yk.a $this_stopServerOnCancellation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(yk.a aVar, um.d<? super b> dVar) {
            super(1, dVar);
            this.$this_stopServerOnCancellation = aVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.l um.d<?> dVar) {
            return new b(this.$this_stopServerOnCancellation, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            this.$this_stopServerOnCancellation.d(1000L, 5000L);
            return l2.f10208a;
        }

        @Override // jn.l
        @os.m
        public final Object invoke(@os.m um.d<? super l2> dVar) {
            return ((b) create(dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @t0
    @os.l
    public static final nq.b0 a(@os.l nq.l2 l2Var, @os.l jn.l<? super um.d<? super l2>, ? extends Object> lVar) {
        l0.p(l2Var, "<this>");
        l0.p(lVar, "block");
        o2 o2Var = new o2(l2Var);
        nq.k.e(c2.f11831a, l2Var.plus(k1.c()), u0.UNDISPATCHED, new a(o2Var, lVar, null));
        return o2Var;
    }

    @v
    @os.l
    public static final nq.b0 b(@os.l yk.a aVar) {
        l0.p(aVar, "<this>");
        nq.l2 l2Var = (nq.l2) aVar.c().g().get(nq.l2.f11882k);
        nq.b0 b0VarA = l2Var == null ? null : a(l2Var, new b(aVar, null));
        return b0VarA == null ? r2.c(null, 1, null) : b0VarA;
    }
}
