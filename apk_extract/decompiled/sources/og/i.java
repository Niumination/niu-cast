package og;

import ag.o0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import li.g0;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends SuspendLambda implements Function2 {
    final /* synthetic */ c $connection;
    final /* synthetic */ Function3<k, o0, Continuation<? super Unit>, Object> $handler;
    final /* synthetic */ long $timeout;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public i(c cVar, long j8, Function3<? super k, ? super o0, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super i> continuation) {
        super(2, continuation);
        this.$connection = cVar;
        this.$timeout = j8;
        this.$handler = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        i iVar = new i(this.$connection, this.$timeout, this.$handler, continuation);
        iVar.L$0 = obj;
        return iVar;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x03f3: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:176:0x03f3 */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x03f4: MOVE (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:176:0x03f3 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:159:0x0388 -> B:272:0x0390). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:184:0x0413 -> B:264:0x0416). Please report as a decompilation issue!!! */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 13001. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r33) {
        /*
            Method dump skipped, instruction units count: 1300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: og.i.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((i) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
