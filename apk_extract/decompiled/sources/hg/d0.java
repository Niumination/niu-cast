package hg;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends SuspendLambda implements Function2 {
    final /* synthetic */ jh.o $rawInput;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ l0 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(jh.o oVar, l0 l0Var, Continuation<? super d0> continuation) {
        super(2, continuation);
        this.$rawInput = oVar;
        this.this$0 = l0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        d0 d0Var = new d0(this.$rawInput, this.this$0, continuation);
        d0Var.L$0 = obj;
        return d0Var;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0045 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x004a A[Catch: all -> 0x0019, w -> 0x014b, TryCatch #3 {w -> 0x014b, all -> 0x0019, blocks: (B:7:0x0015, B:17:0x0037, B:20:0x0046, B:22:0x004a, B:23:0x0058, B:25:0x005c, B:28:0x0068, B:32:0x0084, B:35:0x008c, B:36:0x00a7, B:37:0x00a8, B:38:0x00af, B:39:0x00b0, B:43:0x00bf, B:46:0x00c9, B:50:0x00d8, B:53:0x00e2, B:55:0x00e6, B:58:0x00f0, B:61:0x0121, B:62:0x012c, B:63:0x012d, B:64:0x0138, B:14:0x002a), top: B:78:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0066  */
    /* JADX WARN: Code duplicated, block: B:28:0x0068 A[Catch: all -> 0x0019, w -> 0x014b, TryCatch #3 {w -> 0x014b, all -> 0x0019, blocks: (B:7:0x0015, B:17:0x0037, B:20:0x0046, B:22:0x004a, B:23:0x0058, B:25:0x005c, B:28:0x0068, B:32:0x0084, B:35:0x008c, B:36:0x00a7, B:37:0x00a8, B:38:0x00af, B:39:0x00b0, B:43:0x00bf, B:46:0x00c9, B:50:0x00d8, B:53:0x00e2, B:55:0x00e6, B:58:0x00f0, B:61:0x0121, B:62:0x012c, B:63:0x012d, B:64:0x0138, B:14:0x002a), top: B:78:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0081 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x0082  */
    /* JADX WARN: Code duplicated, block: B:32:0x0084 A[Catch: all -> 0x0019, w -> 0x014b, TryCatch #3 {w -> 0x014b, all -> 0x0019, blocks: (B:7:0x0015, B:17:0x0037, B:20:0x0046, B:22:0x004a, B:23:0x0058, B:25:0x005c, B:28:0x0068, B:32:0x0084, B:35:0x008c, B:36:0x00a7, B:37:0x00a8, B:38:0x00af, B:39:0x00b0, B:43:0x00bf, B:46:0x00c9, B:50:0x00d8, B:53:0x00e2, B:55:0x00e6, B:58:0x00f0, B:61:0x0121, B:62:0x012c, B:63:0x012d, B:64:0x0138, B:14:0x002a), top: B:78:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x008a  */
    /* JADX WARN: Code duplicated, block: B:35:0x008c A[Catch: all -> 0x0019, w -> 0x014b, TryCatch #3 {w -> 0x014b, all -> 0x0019, blocks: (B:7:0x0015, B:17:0x0037, B:20:0x0046, B:22:0x004a, B:23:0x0058, B:25:0x005c, B:28:0x0068, B:32:0x0084, B:35:0x008c, B:36:0x00a7, B:37:0x00a8, B:38:0x00af, B:39:0x00b0, B:43:0x00bf, B:46:0x00c9, B:50:0x00d8, B:53:0x00e2, B:55:0x00e6, B:58:0x00f0, B:61:0x0121, B:62:0x012c, B:63:0x012d, B:64:0x0138, B:14:0x002a), top: B:78:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00a8 A[Catch: all -> 0x0019, w -> 0x014b, TryCatch #3 {w -> 0x014b, all -> 0x0019, blocks: (B:7:0x0015, B:17:0x0037, B:20:0x0046, B:22:0x004a, B:23:0x0058, B:25:0x005c, B:28:0x0068, B:32:0x0084, B:35:0x008c, B:36:0x00a7, B:37:0x00a8, B:38:0x00af, B:39:0x00b0, B:43:0x00bf, B:46:0x00c9, B:50:0x00d8, B:53:0x00e2, B:55:0x00e6, B:58:0x00f0, B:61:0x0121, B:62:0x012c, B:63:0x012d, B:64:0x0138, B:14:0x002a), top: B:78:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00b0 A[Catch: all -> 0x0019, w -> 0x014b, TryCatch #3 {w -> 0x014b, all -> 0x0019, blocks: (B:7:0x0015, B:17:0x0037, B:20:0x0046, B:22:0x004a, B:23:0x0058, B:25:0x005c, B:28:0x0068, B:32:0x0084, B:35:0x008c, B:36:0x00a7, B:37:0x00a8, B:38:0x00af, B:39:0x00b0, B:43:0x00bf, B:46:0x00c9, B:50:0x00d8, B:53:0x00e2, B:55:0x00e6, B:58:0x00f0, B:61:0x0121, B:62:0x012c, B:63:0x012d, B:64:0x0138, B:14:0x002a), top: B:78:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c9 A[Catch: all -> 0x0019, w -> 0x014b, TryCatch #3 {w -> 0x014b, all -> 0x0019, blocks: (B:7:0x0015, B:17:0x0037, B:20:0x0046, B:22:0x004a, B:23:0x0058, B:25:0x005c, B:28:0x0068, B:32:0x0084, B:35:0x008c, B:36:0x00a7, B:37:0x00a8, B:38:0x00af, B:39:0x00b0, B:43:0x00bf, B:46:0x00c9, B:50:0x00d8, B:53:0x00e2, B:55:0x00e6, B:58:0x00f0, B:61:0x0121, B:62:0x012c, B:63:0x012d, B:64:0x0138, B:14:0x002a), top: B:78:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:51:0x00df  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e2 A[Catch: all -> 0x0019, w -> 0x014b, TryCatch #3 {w -> 0x014b, all -> 0x0019, blocks: (B:7:0x0015, B:17:0x0037, B:20:0x0046, B:22:0x004a, B:23:0x0058, B:25:0x005c, B:28:0x0068, B:32:0x0084, B:35:0x008c, B:36:0x00a7, B:37:0x00a8, B:38:0x00af, B:39:0x00b0, B:43:0x00bf, B:46:0x00c9, B:50:0x00d8, B:53:0x00e2, B:55:0x00e6, B:58:0x00f0, B:61:0x0121, B:62:0x012c, B:63:0x012d, B:64:0x0138, B:14:0x002a), top: B:78:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00e6 A[Catch: all -> 0x0019, w -> 0x014b, TRY_LEAVE, TryCatch #3 {w -> 0x014b, all -> 0x0019, blocks: (B:7:0x0015, B:17:0x0037, B:20:0x0046, B:22:0x004a, B:23:0x0058, B:25:0x005c, B:28:0x0068, B:32:0x0084, B:35:0x008c, B:36:0x00a7, B:37:0x00a8, B:38:0x00af, B:39:0x00b0, B:43:0x00bf, B:46:0x00c9, B:50:0x00d8, B:53:0x00e2, B:55:0x00e6, B:58:0x00f0, B:61:0x0121, B:62:0x012c, B:63:0x012d, B:64:0x0138, B:14:0x002a), top: B:78:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00f0 A[Catch: all -> 0x0019, w -> 0x014b, TRY_ENTER, TRY_LEAVE, TryCatch #3 {w -> 0x014b, all -> 0x0019, blocks: (B:7:0x0015, B:17:0x0037, B:20:0x0046, B:22:0x004a, B:23:0x0058, B:25:0x005c, B:28:0x0068, B:32:0x0084, B:35:0x008c, B:36:0x00a7, B:37:0x00a8, B:38:0x00af, B:39:0x00b0, B:43:0x00bf, B:46:0x00c9, B:50:0x00d8, B:53:0x00e2, B:55:0x00e6, B:58:0x00f0, B:61:0x0121, B:62:0x012c, B:63:0x012d, B:64:0x0138, B:14:0x002a), top: B:78:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0121 A[Catch: all -> 0x0019, w -> 0x014b, TRY_ENTER, TryCatch #3 {w -> 0x014b, all -> 0x0019, blocks: (B:7:0x0015, B:17:0x0037, B:20:0x0046, B:22:0x004a, B:23:0x0058, B:25:0x005c, B:28:0x0068, B:32:0x0084, B:35:0x008c, B:36:0x00a7, B:37:0x00a8, B:38:0x00af, B:39:0x00b0, B:43:0x00bf, B:46:0x00c9, B:50:0x00d8, B:53:0x00e2, B:55:0x00e6, B:58:0x00f0, B:61:0x0121, B:62:0x012c, B:63:0x012d, B:64:0x0138, B:14:0x002a), top: B:78:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x012d A[Catch: all -> 0x0019, w -> 0x014b, TryCatch #3 {w -> 0x014b, all -> 0x0019, blocks: (B:7:0x0015, B:17:0x0037, B:20:0x0046, B:22:0x004a, B:23:0x0058, B:25:0x005c, B:28:0x0068, B:32:0x0084, B:35:0x008c, B:36:0x00a7, B:37:0x00a8, B:38:0x00af, B:39:0x00b0, B:43:0x00bf, B:46:0x00c9, B:50:0x00d8, B:53:0x00e2, B:55:0x00e6, B:58:0x00f0, B:61:0x0121, B:62:0x012c, B:63:0x012d, B:64:0x0138, B:14:0x002a), top: B:78:0x0009 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0139: CHECK_CAST (r5 I:ni.c0) = (ni.c0) (r5 I:??[OBJECT, ARRAY]), block:B:65:0x0139 */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x014b: CHECK_CAST (r5 I:ni.c0) = (ni.c0) (r5 I:??[OBJECT, ARRAY]), block:B:70:0x014b */
    /* JADX WARN: Type inference failed for: r9v3, types: [ni.a, ni.g0] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007f -> B:17:0x0037). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x008a -> B:17:0x0037). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:48:0x00d4
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hg.d0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ni.d0 d0Var, Continuation<? super Unit> continuation) {
        return ((d0) create(d0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
