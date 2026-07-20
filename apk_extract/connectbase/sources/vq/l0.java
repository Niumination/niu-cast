package vq;

import java.lang.reflect.InvocationTargetException;
import kn.r1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nOnUndeliveredElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnUndeliveredElement.kt\nkotlinx/coroutines/internal/OnUndeliveredElementKt\n+ 2 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,44:1\n75#2:45\n*S KotlinDebug\n*F\n+ 1 OnUndeliveredElement.kt\nkotlinx/coroutines/internal/OnUndeliveredElementKt\n*L\n22#1:45\n*E\n"})
public final class l0 {

    public static final class a extends kn.n0 implements jn.l<Throwable, l2> {
        final /* synthetic */ um.g $context;
        final /* synthetic */ E $element;
        final /* synthetic */ jn.l<E, l2> $this_bindCancellationFun;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(jn.l<? super E, l2> lVar, E e10, um.g gVar) {
            super(1);
            this.$this_bindCancellationFun = lVar;
            this.$element = e10;
            this.$context = gVar;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) throws IllegalAccessException, InvocationTargetException {
            invoke2(th2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l Throwable th2) throws IllegalAccessException, InvocationTargetException {
            l0.b(this.$this_bindCancellationFun, this.$element, this.$context);
        }
    }

    @os.l
    public static final <E> jn.l<Throwable, l2> a(@os.l jn.l<? super E, l2> lVar, E e10, @os.l um.g gVar) {
        return new a(lVar, e10, gVar);
    }

    public static final <E> void b(@os.l jn.l<? super E, l2> lVar, E e10, @os.l um.g gVar) throws IllegalAccessException, InvocationTargetException {
        h1 h1VarC = c(lVar, e10, null);
        if (h1VarC != null) {
            nq.p0.b(gVar, h1VarC);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.m
    public static final <E> h1 c(@os.l jn.l<? super E, l2> lVar, E e10, @os.m h1 h1Var) throws IllegalAccessException, InvocationTargetException {
        try {
            lVar.invoke(e10);
        } catch (Throwable th2) {
            if (h1Var == null || h1Var.getCause() == th2) {
                return new h1(c0.a.a("Exception in undelivered element handler for ", e10), th2);
            }
            lm.p.a(h1Var, th2);
        }
        return h1Var;
    }

    public static /* synthetic */ h1 d(jn.l lVar, Object obj, h1 h1Var, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            h1Var = null;
        }
        return c(lVar, obj, h1Var);
    }
}
