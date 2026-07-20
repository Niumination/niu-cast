package oh;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 extends SuspendLambda implements Function2 {
    final /* synthetic */ ni.q $channel;
    final /* synthetic */ Function2<c, Continuation<? super Unit>, Object> $onTimeout;
    final /* synthetic */ ni.g0 $outgoing;
    final /* synthetic */ long $periodMillis;
    final /* synthetic */ long $timeoutMillis;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c0(long j8, long j10, Function2<? super c, ? super Continuation<? super Unit>, ? extends Object> function2, ni.q qVar, ni.g0 g0Var, Continuation<? super c0> continuation) {
        super(2, continuation);
        this.$periodMillis = j8;
        this.$timeoutMillis = j10;
        this.$onTimeout = function2;
        this.$channel = qVar;
        this.$outgoing = g0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new c0(this.$periodMillis, this.$timeoutMillis, this.$onTimeout, this.$channel, this.$outgoing, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0082 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0083  */
    /* JADX WARN: Code duplicated, block: B:24:0x00b8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x00bd A[Catch: CancellationException | w | x -> 0x00de, CancellationException | w | x -> 0x00de, CancellationException | w | x -> 0x00de, TRY_LEAVE, TryCatch #0 {CancellationException | w | x -> 0x00de, blocks: (B:7:0x0012, B:12:0x0027, B:12:0x0027, B:12:0x0027, B:25:0x00b9, B:25:0x00b9, B:25:0x00b9, B:27:0x00bd, B:27:0x00bd, B:27:0x00bd, B:18:0x006d, B:18:0x006d, B:18:0x006d, B:22:0x0084, B:22:0x0084, B:22:0x0084, B:15:0x0034, B:15:0x0034, B:15:0x0034), top: B:34:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00db A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x00dc  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00b6 -> B:25:0x00b9). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: oh.c0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((c0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
