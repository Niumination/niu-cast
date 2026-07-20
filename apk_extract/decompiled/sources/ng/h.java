package ng;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends SuspendLambda implements Function2 {
    final /* synthetic */ li.q $cioConnectors;
    final /* synthetic */ mg.d $environment;
    final /* synthetic */ li.q $startupJob;
    final /* synthetic */ li.s $stopRequest;
    final /* synthetic */ li.a0 $userDispatcher;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ p this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(p pVar, li.q qVar, li.s sVar, li.q qVar2, li.a0 a0Var, mg.d dVar, Continuation<? super h> continuation) {
        super(2, continuation);
        this.this$0 = pVar;
        this.$cioConnectors = qVar;
        this.$stopRequest = sVar;
        this.$startupJob = qVar2;
        this.$userDispatcher = a0Var;
        this.$environment = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        h hVar = new h(this.this$0, this.$cioConnectors, this.$stopRequest, this.$startupJob, this.$userDispatcher, this.$environment, continuation);
        hVar.L$0 = obj;
        return hVar;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00f5 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:12:0x003e, B:40:0x011d, B:34:0x00ef, B:36:0x00f5, B:41:0x0126, B:42:0x0137, B:44:0x013d, B:46:0x015a, B:49:0x0160, B:50:0x0172, B:51:0x0179, B:52:0x017a, B:17:0x005c, B:18:0x0066, B:20:0x006c, B:23:0x007f, B:24:0x0086, B:25:0x0087, B:26:0x009a, B:28:0x00a0, B:29:0x00ba, B:30:0x00c7, B:32:0x00cd, B:33:0x00dd), top: B:72:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:38:0x011b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x011c  */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x01d6: INVOKE (r0 I:java.util.Iterator) = (r10 I:java.lang.Iterable) INTERFACE call: java.lang.Iterable.iterator():java.util.Iterator A[MD:():java.util.Iterator<T> (c)], block:B:66:0x01d6 */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Iterable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x011c -> B:40:0x011d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 507
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ng.h.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((h) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
