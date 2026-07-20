package hg;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends SuspendLambda implements Function2 {
    final /* synthetic */ jh.j0 $rawOutput;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ l0 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(l0 l0Var, jh.j0 j0Var, Continuation<? super f0> continuation) {
        super(2, continuation);
        this.this$0 = l0Var;
        this.$rawOutput = j0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        f0 f0Var = new f0(this.this$0, this.$rawOutput, continuation);
        f0Var.L$0 = obj;
        return f0Var;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0079 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x007a  */
    /* JADX WARN: Code duplicated, block: B:28:0x0085 A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:22:0x006b, B:26:0x007d, B:28:0x0085, B:38:0x00b6, B:16:0x004c, B:21:0x005a, B:11:0x003a, B:30:0x008d, B:32:0x009d, B:35:0x00a4), top: B:56:0x0008, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x008d A[Catch: all -> 0x003f, TRY_ENTER, TryCatch #1 {all -> 0x003f, blocks: (B:11:0x003a, B:30:0x008d, B:32:0x009d, B:35:0x00a4), top: B:58:0x003a, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x009c  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b5 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00b3 -> B:39:0x00c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00b6 -> B:39:0x00c3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hg.f0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ni.b bVar, Continuation<? super Unit> continuation) {
        return ((f0) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
