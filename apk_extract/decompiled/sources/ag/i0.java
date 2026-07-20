package ag;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 extends SuspendLambda implements Function2 {
    final /* synthetic */ xi.a $boundaryPrefixed;
    final /* synthetic */ jh.o $input;
    final /* synthetic */ long $maxPartSize;
    final /* synthetic */ Long $totalLength;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(jh.o oVar, xi.a aVar, long j8, Long l4, Continuation<? super i0> continuation) {
        super(2, continuation);
        this.$input = oVar;
        this.$boundaryPrefixed = aVar;
        this.$maxPartSize = j8;
        this.$totalLength = l4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        i0 i0Var = new i0(this.$input, this.$boundaryPrefixed, this.$maxPartSize, this.$totalLength, continuation);
        i0Var.L$0 = obj;
        return i0Var;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x017d  */
    /* JADX WARN: Code duplicated, block: B:45:0x0193 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x019c  */
    /* JADX WARN: Code duplicated, block: B:50:0x01ad A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x01d4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x01e8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:61:0x01ff A[Catch: all -> 0x0241, TRY_LEAVE, TryCatch #0 {all -> 0x0241, blocks: (B:59:0x01f6, B:61:0x01ff), top: B:121:0x01f6 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0227 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x0228  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x0228 -> B:125:0x022f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            Method dump skipped, instruction units count: 832
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ag.i0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ni.d0 d0Var, Continuation<? super Unit> continuation) {
        return ((i0) create(d0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
