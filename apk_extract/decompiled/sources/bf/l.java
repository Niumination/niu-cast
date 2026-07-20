package bf;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import ze.p1;
import ze.r1;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends SuspendLambda implements Function2 {
    final /* synthetic */ oi.i $$this$flow;
    final /* synthetic */ ze.f $callOptions;
    final /* synthetic */ ze.g $channel;
    final /* synthetic */ p1 $headers;
    final /* synthetic */ r1 $method;
    final /* synthetic */ g $request;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(ze.g gVar, r1 r1Var, ze.f fVar, p1 p1Var, oi.i iVar, g gVar2, Continuation<? super l> continuation) {
        super(2, continuation);
        this.$channel = gVar;
        this.$method = r1Var;
        this.$callOptions = fVar;
        this.$headers = p1Var;
        this.$$this$flow = iVar;
        this.$request = gVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        l lVar = new l(this.$channel, this.$method, this.$callOptions, this.$headers, this.$$this$flow, this.$request, continuation);
        lVar.L$0 = obj;
        return lVar;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00b7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:26:0x00c3 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:11:0x002f, B:29:0x00d8, B:20:0x00a9, B:24:0x00bb, B:26:0x00c3, B:16:0x0044, B:19:0x00a1), top: B:41:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:28:0x00d7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:33:0x00e2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00d5 -> B:12:0x0032). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bf.l.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((l) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
