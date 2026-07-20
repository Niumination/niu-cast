package nq;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nCompletionState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompletionState.kt\nkotlinx/coroutines/CompletionStateKt\n+ 2 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,67:1\n61#2,2:68\n61#2,2:70\n*S KotlinDebug\n*F\n+ 1 CompletionState.kt\nkotlinx/coroutines/CompletionStateKt\n*L\n21#1:68,2\n27#1:70,2\n*E\n"})
public final class j0 {
    @os.l
    public static final <T> Object a(@os.m Object obj, @os.l um.d<? super T> dVar) {
        if (obj instanceof d0) {
            lm.c1.a aVar = lm.c1.Companion;
            return lm.c1.m59constructorimpl(lm.d1.a(((d0) obj).f11836a));
        }
        lm.c1.a aVar2 = lm.c1.Companion;
        return lm.c1.m59constructorimpl(obj);
    }

    @os.m
    public static final <T> Object b(@os.l Object obj, @os.m jn.l<? super Throwable, lm.l2> lVar) {
        Throwable thM62exceptionOrNullimpl = lm.c1.m62exceptionOrNullimpl(obj);
        if (thM62exceptionOrNullimpl == null) {
            return lVar != null ? new e0(obj, lVar) : obj;
        }
        return new d0(thM62exceptionOrNullimpl, false, 2, null);
    }

    @os.m
    public static final <T> Object c(@os.l Object obj, @os.l p<?> pVar) {
        Throwable thM62exceptionOrNullimpl = lm.c1.m62exceptionOrNullimpl(obj);
        if (thM62exceptionOrNullimpl == null) {
            return obj;
        }
        return new d0(thM62exceptionOrNullimpl, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, jn.l lVar, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            lVar = null;
        }
        return b(obj, lVar);
    }
}
