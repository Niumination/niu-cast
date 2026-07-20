package pq;

import java.util.concurrent.CancellationException;
import kn.l0;
import lm.a1;
import lm.d1;
import nq.a2;
import nq.f1;
import vq.t0;

/* JADX INFO: loaded from: classes3.dex */
public interface f0<E> {

    public static final class a {

        /* JADX INFO: renamed from: pq.f0$a$a, reason: collision with other inner class name */
        @xm.f(c = "kotlinx.coroutines.channels.ReceiveChannel$DefaultImpls", f = "Channel.kt", i = {}, l = {372}, m = "receiveOrNull", n = {}, s = {})
        public static final class C0330a<E> extends xm.d {
            int label;
            /* synthetic */ Object result;

            public C0330a(um.d<? super C0330a> dVar) {
                super(dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return a.i(null, this);
            }
        }

        public static /* synthetic */ void b(f0 f0Var, CancellationException cancellationException, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                cancellationException = null;
            }
            f0Var.b(cancellationException);
        }

        public static /* synthetic */ boolean c(f0 f0Var, Throwable th2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                th2 = null;
            }
            return f0Var.c(th2);
        }

        @os.l
        public static <E> yq.g<E> d(@os.l f0<? extends E> f0Var) {
            l0.n(f0Var, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel<E of kotlinx.coroutines.channels.ReceiveChannel>");
            return ((j) f0Var).C();
        }

        @lm.k(level = lm.m.ERROR, message = "Deprecated in favor of onReceiveCatching extension", replaceWith = @a1(expression = "onReceiveCatching", imports = {}))
        public static /* synthetic */ void e() {
        }

        @f1
        public static /* synthetic */ void f() {
        }

        @a2
        public static /* synthetic */ void g() {
        }

        @os.m
        @lm.k(level = lm.m.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @a1(expression = "tryReceive().getOrNull()", imports = {}))
        public static <E> E h(@os.l f0<? extends E> f0Var) throws Throwable {
            Object objD = f0Var.D();
            if (p.m(objD)) {
                return (E) p.i(objD);
            }
            Throwable thF = p.f(objD);
            if (thF == null) {
                return null;
            }
            throw t0.o(thF);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @an.h
        @os.m
        @lm.k(level = lm.m.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @a1(expression = "receiveCatching().getOrNull()", imports = {}))
        public static <E> Object i(@os.l f0<? extends E> f0Var, @os.l um.d<? super E> dVar) {
            C0330a c0330a;
            Object objS;
            if (dVar instanceof C0330a) {
                c0330a = (C0330a) dVar;
                int i10 = c0330a.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    c0330a.label = i10 - Integer.MIN_VALUE;
                } else {
                    c0330a = new C0330a(dVar);
                }
            } else {
                c0330a = new C0330a(dVar);
            }
            Object obj = c0330a.result;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i11 = c0330a.label;
            if (i11 == 0) {
                d1.n(obj);
                c0330a.label = 1;
                objS = f0Var.s(c0330a);
                if (objS == aVar) {
                    return aVar;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                objS = ((p) obj).f13310a;
            }
            return p.h(objS);
        }
    }

    @os.l
    yq.g<p<E>> B();

    @os.l
    yq.g<E> C();

    @os.l
    Object D();

    void b(@os.m CancellationException cancellationException);

    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean c(Throwable th2);

    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    boolean isEmpty();

    @os.l
    n<E> iterator();

    @os.m
    Object n(@os.l um.d<? super E> dVar);

    @os.m
    @lm.k(level = lm.m.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @a1(expression = "tryReceive().getOrNull()", imports = {}))
    E poll();

    boolean r();

    @os.m
    Object s(@os.l um.d<? super p<? extends E>> dVar);

    @an.h
    @os.m
    @lm.k(level = lm.m.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @a1(expression = "receiveCatching().getOrNull()", imports = {}))
    Object u(@os.l um.d<? super E> dVar);

    @os.l
    yq.g<E> x();
}
