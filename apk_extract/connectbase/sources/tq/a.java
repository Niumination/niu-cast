package tq;

import java.util.concurrent.CancellationException;
import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nFlowExceptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowExceptions.kt\nkotlinx/coroutines/flow/internal/AbortFlowException\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,30:1\n26#2:31\n*S KotlinDebug\n*F\n+ 1 FlowExceptions.kt\nkotlinx/coroutines/flow/internal/AbortFlowException\n*L\n17#1:31\n*E\n"})
public final class a extends CancellationException {

    @in.f
    @os.l
    public final transient sq.j<?> owner;

    public a(@os.l sq.j<?> jVar) {
        super("Flow was aborted, no more elements needed");
        this.owner = jVar;
    }

    @Override // java.lang.Throwable
    @os.l
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
