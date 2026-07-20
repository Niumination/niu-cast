package jh;

import k3.ha;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l0 f6300a = new l0();

    public static final void a(j0 j0Var, Throwable th2) {
        Intrinsics.checkNotNullParameter(j0Var, "<this>");
        if (th2 == null) {
            b(new m0(j0Var));
        } else {
            ((k) j0Var).b(th2);
        }
    }

    public static final void b(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        l0 l0Var = f6300a;
        try {
            Continuation continuationIntercepted = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function1, l0Var));
            Result.Companion companion = Result.INSTANCE;
            qi.g.h(Result.m159constructorimpl(Unit.INSTANCE), continuationIntercepted);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            l0Var.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(th2)));
            throw th2;
        }
    }

    public static final Object c(j0 j0Var, byte b9, ContinuationImpl continuationImpl) {
        k kVar = (k) j0Var;
        kVar.k().s(b9);
        Object objB = ha.b(kVar, continuationImpl);
        return objB == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objB : Unit.INSTANCE;
    }

    public static final Object d(j0 j0Var, byte[] bArr, int i8, int i9, ContinuationImpl continuationImpl) {
        k kVar = (k) j0Var;
        kVar.k().o(bArr, i8, i9);
        Object objB = ha.b(kVar, continuationImpl);
        return objB == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objB : Unit.INSTANCE;
    }

    public static final Object e(j0 j0Var, wi.k kVar, ContinuationImpl continuationImpl) {
        k kVar2 = (k) j0Var;
        kVar2.k().k(kVar);
        Object objB = ha.b(kVar2, continuationImpl);
        return objB == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objB : Unit.INSTANCE;
    }

    public static final y0 f(li.g0 g0Var, CoroutineContext coroutineContext, k channel, Function2 block) {
        Intrinsics.checkNotNullParameter(g0Var, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(block, "block");
        g2 g2VarP = li.l0.p(g0Var, coroutineContext, null, new n0(block, channel, null), 2);
        g2VarP.A(new l(channel, 2));
        return new y0(channel, g2VarP);
    }

    public static y0 g(li.g0 g0Var, CoroutineContext coroutineContext, boolean z2, Function2 block, int i8) {
        if ((i8 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(g0Var, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(block, "block");
        return f(g0Var, coroutineContext, new k(false), block);
    }
}
