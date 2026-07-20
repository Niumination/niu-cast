package uq;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import jn.l;
import jn.p;
import kn.n0;
import kn.r1;
import lm.l2;
import nq.a0;
import nq.a1;
import nq.m0;
import nq.p0;
import nq.q;
import nq.q2;
import nq.s0;
import nq.u0;
import nq.w1;
import nq.y;
import os.m;
import um.g;
import um.i;
import xm.h;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nFuture.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Future.kt\nkotlinx/coroutines/future/FutureKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,197:1\n1#2:198\n314#3,11:199\n*S KotlinDebug\n*F\n+ 1 Future.kt\nkotlinx/coroutines/future/FutureKt\n*L\n172#1:199,11\n*E\n"})
public final class e {

    public static final class a extends n0 implements l<Throwable, l2> {
        final /* synthetic */ CompletableFuture<T> $future;
        final /* synthetic */ a1<T> $this_asCompletableFuture;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(CompletableFuture<T> completableFuture, a1<? extends T> a1Var) {
            super(1);
            this.$future = completableFuture;
            this.$this_asCompletableFuture = a1Var;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
            invoke2(th2);
            return l2.f10208a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@m Throwable th2) {
            try {
                this.$future.complete((T) this.$this_asCompletableFuture.p());
            } catch (Throwable th3) {
                this.$future.completeExceptionally(th3);
            }
        }
    }

    public static final class b extends n0 implements l<Throwable, l2> {
        final /* synthetic */ CompletableFuture<l2> $future;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CompletableFuture<l2> completableFuture) {
            super(1);
            this.$future = completableFuture;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
            invoke2(th2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@m Throwable th2) {
            if (th2 == null) {
                this.$future.complete(l2.f10208a);
            } else {
                this.$future.completeExceptionally(th2);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class c<T> extends n0 implements p<T, Throwable, Object> {
        final /* synthetic */ y<T> $result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(y<T> yVar) {
            super(2);
            this.$result = yVar;
        }

        @Override // jn.p
        public final Object invoke(T t10, Throwable th2) {
            boolean zK;
            Throwable cause;
            try {
                if (th2 == null) {
                    zK = this.$result.l0(t10);
                } else {
                    y<T> yVar = this.$result;
                    CompletionException completionException = th2 instanceof CompletionException ? (CompletionException) th2 : null;
                    if (completionException != null && (cause = completionException.getCause()) != null) {
                        th2 = cause;
                    }
                    zK = yVar.k(th2);
                }
                return Boolean.valueOf(zK);
            } catch (Throwable th3) {
                p0.b(i.INSTANCE, th3);
                return l2.f10208a;
            }
        }
    }

    public static final class d extends n0 implements l<Throwable, l2> {
        final /* synthetic */ uq.b<T> $consumer;
        final /* synthetic */ CompletableFuture<T> $future;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(CompletableFuture<T> completableFuture, uq.b<T> bVar) {
            super(1);
            this.$future = completableFuture;
            this.$consumer = bVar;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
            invoke2(th2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@m Throwable th2) {
            this.$future.cancel(false);
            this.$consumer.cont = null;
        }
    }

    public static Object a(p pVar, Object obj, Throwable th2) {
        return pVar.invoke(obj, th2);
    }

    @os.l
    public static final <T> CompletableFuture<T> c(@os.l a1<? extends T> a1Var) {
        CompletableFuture<T> completableFuture = new CompletableFuture<>();
        j(a1Var, completableFuture);
        a1Var.k0(new a(completableFuture, a1Var));
        return completableFuture;
    }

    @os.l
    public static final CompletableFuture<l2> d(@os.l nq.l2 l2Var) {
        CompletableFuture<l2> completableFuture = new CompletableFuture<>();
        j(l2Var, completableFuture);
        l2Var.k0(new b(completableFuture));
        return completableFuture;
    }

    @os.l
    public static final <T> a1<T> e(@os.l CompletionStage<T> completionStage) {
        Throwable cause;
        CompletableFuture<T> completableFuture = completionStage.toCompletableFuture();
        if (!completableFuture.isDone()) {
            y yVarC = a0.c(null, 1, null);
            final c cVar = new c(yVarC);
            completionStage.handle(new BiFunction() { // from class: uq.c
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return cVar.invoke(obj, (Throwable) obj2);
                }
            });
            q2.b(yVarC, completableFuture);
            return yVarC;
        }
        try {
            return a0.a(completableFuture.get());
        } catch (Throwable th2) {
            th = th2;
            ExecutionException executionException = th instanceof ExecutionException ? (ExecutionException) th : null;
            if (executionException != null && (cause = executionException.getCause()) != null) {
                th = cause;
            }
            y yVarC2 = a0.c(null, 1, null);
            yVarC2.k(th);
            return yVarC2;
        }
    }

    public static final Object f(p pVar, Object obj, Throwable th2) {
        return pVar.invoke(obj, th2);
    }

    @m
    public static final <T> Object g(@os.l CompletionStage<T> completionStage, @os.l um.d<? super T> dVar) throws Throwable {
        CompletableFuture<T> completableFuture = completionStage.toCompletableFuture();
        if (completableFuture.isDone()) {
            try {
                return completableFuture.get();
            } catch (ExecutionException e10) {
                Throwable cause = e10.getCause();
                if (cause == null) {
                    throw e10;
                }
                throw cause;
            }
        }
        q qVar = new q(wm.c.e(dVar), 1);
        qVar.F();
        uq.b bVar = new uq.b(qVar);
        completionStage.handle(bVar);
        qVar.H(new d(completableFuture, bVar));
        Object objZ = qVar.z();
        if (objZ == wm.a.COROUTINE_SUSPENDED) {
            h.c(dVar);
        }
        return objZ;
    }

    @os.l
    public static final <T> CompletableFuture<T> h(@os.l s0 s0Var, @os.l g gVar, @os.l u0 u0Var, @os.l p<? super s0, ? super um.d<? super T>, ? extends Object> pVar) {
        if (u0Var.isLazy()) {
            throw new IllegalArgumentException((u0Var + " start is not supported").toString());
        }
        g gVarD = m0.d(s0Var, gVar);
        CompletableFuture<T> completableFuture = new CompletableFuture<>();
        uq.a aVar = new uq.a(gVarD, completableFuture);
        completableFuture.handle((BiFunction) aVar);
        u0Var.invoke(pVar, aVar, aVar);
        return completableFuture;
    }

    public static /* synthetic */ CompletableFuture i(s0 s0Var, g gVar, u0 u0Var, p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = i.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            u0Var = u0.DEFAULT;
        }
        return h(s0Var, gVar, u0Var, pVar);
    }

    public static final void j(final nq.l2 l2Var, CompletableFuture<?> completableFuture) {
        completableFuture.handle(new BiFunction() { // from class: uq.d
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return e.k(l2Var, obj, (Throwable) obj2);
            }
        });
    }

    public static final l2 k(nq.l2 l2Var, Object obj, Throwable th2) {
        CancellationException cancellationExceptionA = null;
        if (th2 != null) {
            cancellationExceptionA = th2 instanceof CancellationException ? (CancellationException) th2 : null;
            if (cancellationExceptionA == null) {
                cancellationExceptionA = w1.a("CompletableFuture was completed exceptionally", th2);
            }
        }
        l2Var.b(cancellationExceptionA);
        return l2.f10208a;
    }
}
