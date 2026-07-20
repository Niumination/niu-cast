package androidx.work;

import androidx.annotation.RestrictTo;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.InlineMarker;
import m4.l;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087Hø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"R", "Lm4/l;", "await", "(Lm4/l;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "work-runtime-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ListenableFutureKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <R> Object await(l lVar, Continuation<? super R> continuation) throws Throwable {
        if (lVar.isDone()) {
            try {
                return lVar.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    throw e;
                }
                throw cause;
            }
        }
        li.l lVar2 = new li.l(1, IntrinsicsKt.intercepted(continuation));
        lVar2.s();
        lVar.addListener(new ListenableFutureKt$await$2$1(lVar2, lVar), DirectExecutor.INSTANCE);
        lVar2.v(new ListenableFutureKt$await$2$2(lVar));
        Object objR = lVar2.r();
        if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objR;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private static final <R> Object await$$forInline(l lVar, Continuation<? super R> continuation) throws Throwable {
        if (lVar.isDone()) {
            try {
                return lVar.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    throw e;
                }
                throw cause;
            }
        }
        InlineMarker.mark(0);
        li.l lVar2 = new li.l(1, IntrinsicsKt.intercepted(continuation));
        lVar2.s();
        lVar.addListener(new ListenableFutureKt$await$2$1(lVar2, lVar), DirectExecutor.INSTANCE);
        lVar2.v(new ListenableFutureKt$await$2$2(lVar));
        Object objR = lVar2.r();
        if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return objR;
    }
}
