package li;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes3.dex */
public enum j0 {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<j0> getEntries() {
        return $ENTRIES;
    }

    public static /* synthetic */ void isLazy$annotations() {
    }

    public final <R, T> void invoke(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r7, Continuation<? super T> continuation) {
        int i8 = i0.$EnumSwitchMapping$0[ordinal()];
        if (i8 == 1) {
            ri.a.b(function2, r7, continuation);
            return;
        }
        if (i8 == 2) {
            ContinuationKt.startCoroutine(function2, r7, continuation);
            return;
        }
        if (i8 != 3) {
            if (i8 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            return;
        }
        Continuation continuationProbeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            CoroutineContext coroutineContext = continuationProbeCoroutineCreated.get$context();
            Object objC = qi.z.c(coroutineContext, null);
            try {
                DebugProbesKt.probeCoroutineResumed(continuationProbeCoroutineCreated);
                Object objWrapWithContinuationImpl = !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(function2, r7, continuationProbeCoroutineCreated) : ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r7, continuationProbeCoroutineCreated);
                qi.z.a(coroutineContext, objC);
                if (objWrapWithContinuationImpl != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    continuationProbeCoroutineCreated.resumeWith(Result.m159constructorimpl(objWrapWithContinuationImpl));
                }
            } catch (Throwable th2) {
                qi.z.a(coroutineContext, objC);
                throw th2;
            }
        } catch (Throwable th3) {
            Result.Companion companion = Result.INSTANCE;
            continuationProbeCoroutineCreated.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(th3)));
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }
}
