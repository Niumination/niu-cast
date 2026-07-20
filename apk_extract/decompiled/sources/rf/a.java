package rf;

import jh.z0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends SuspendLambda implements Function2 {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ d this$0;
    final /* synthetic */ b this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d dVar, b bVar, Continuation<? super a> continuation) {
        super(2, continuation);
        this.this$0 = dVar;
        this.this$1 = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        a aVar = new a(this.this$0, this.this$1, continuation);
        aVar.L$0 = obj;
        return aVar;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0075 A[Catch: all -> 0x0026, TryCatch #1 {all -> 0x0026, blocks: (B:9:0x0021, B:44:0x00de, B:25:0x006b, B:27:0x0075, B:29:0x007f, B:32:0x0092, B:35:0x00a9, B:36:0x00ac, B:38:0x00b6, B:41:0x00cb, B:45:0x00e3, B:47:0x00ed, B:50:0x0107, B:16:0x003d, B:19:0x004b, B:22:0x0059), top: B:54:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:29:0x007f A[Catch: all -> 0x0026, TryCatch #1 {all -> 0x0026, blocks: (B:9:0x0021, B:44:0x00de, B:25:0x006b, B:27:0x0075, B:29:0x007f, B:32:0x0092, B:35:0x00a9, B:36:0x00ac, B:38:0x00b6, B:41:0x00cb, B:45:0x00e3, B:47:0x00ed, B:50:0x0107, B:16:0x003d, B:19:0x004b, B:22:0x0059), top: B:54:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0091 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x00a8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x00b6 A[Catch: all -> 0x0026, Exception -> 0x00de, TryCatch #0 {Exception -> 0x00de, blocks: (B:9:0x0021, B:36:0x00ac, B:38:0x00b6, B:41:0x00cb, B:16:0x003d), top: B:54:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00ca A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x00dd A[RETURN] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0108: INVOKE (r7 I:java.lang.Object) VIRTUAL call: java.lang.Object.getClass():java.lang.Class A[MD:():java.lang.Class<?> (c)], block:B:51:0x0108 */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v22, types: [wi.k] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, wi.k] */
    /* JADX WARN: Type inference failed for: r1v9, types: [wi.k] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00b4 -> B:44:0x00de). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00db -> B:44:0x00de). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:43:0x00dd
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rf.a.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(z0 z0Var, Continuation<? super Unit> continuation) {
        return ((a) create(z0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
