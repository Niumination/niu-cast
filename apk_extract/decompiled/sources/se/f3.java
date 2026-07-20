package se;

import java.net.Socket;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class f3 extends SuspendLambda implements Function2 {
    final /* synthetic */ Socket $clientSocket;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ i3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f3(Socket socket, i3 i3Var, Continuation<? super f3> continuation) {
        super(2, continuation);
        this.$clientSocket = socket;
        this.this$0 = i3Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new f3(this.$clientSocket, this.this$0, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0075 A[Catch: all -> 0x0032, Exception -> 0x0036, NullPointerException -> 0x0039, IOException -> 0x003c, TRY_ENTER, TryCatch #2 {Exception -> 0x0036, blocks: (B:6:0x002d, B:34:0x00f1, B:22:0x0075, B:25:0x007e, B:28:0x009c, B:31:0x00ce, B:36:0x0101, B:37:0x0109, B:39:0x0133), top: B:55:0x002d, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x007c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x007e A[Catch: all -> 0x0032, Exception -> 0x0036, NullPointerException -> 0x0039, IOException -> 0x003c, TryCatch #2 {Exception -> 0x0036, blocks: (B:6:0x002d, B:34:0x00f1, B:22:0x0075, B:25:0x007e, B:28:0x009c, B:31:0x00ce, B:36:0x0101, B:37:0x0109, B:39:0x0133), top: B:55:0x002d, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0098  */
    /* JADX WARN: Code duplicated, block: B:27:0x009a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x009c A[Catch: all -> 0x0032, Exception -> 0x0036, NullPointerException -> 0x0039, IOException -> 0x003c, TryCatch #2 {Exception -> 0x0036, blocks: (B:6:0x002d, B:34:0x00f1, B:22:0x0075, B:25:0x007e, B:28:0x009c, B:31:0x00ce, B:36:0x0101, B:37:0x0109, B:39:0x0133), top: B:55:0x002d, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x00cd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x00ce A[Catch: all -> 0x0032, Exception -> 0x0036, NullPointerException -> 0x0039, IOException -> 0x003c, TryCatch #2 {Exception -> 0x0036, blocks: (B:6:0x002d, B:34:0x00f1, B:22:0x0075, B:25:0x007e, B:28:0x009c, B:31:0x00ce, B:36:0x0101, B:37:0x0109, B:39:0x0133), top: B:55:0x002d, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00ef A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:39:0x0133 A[Catch: all -> 0x0032, Exception -> 0x0036, NullPointerException -> 0x0039, IOException -> 0x003c, TRY_LEAVE, TryCatch #2 {Exception -> 0x0036, blocks: (B:6:0x002d, B:34:0x00f1, B:22:0x0075, B:25:0x007e, B:28:0x009c, B:31:0x00ce, B:36:0x0101, B:37:0x0109, B:39:0x0133), top: B:55:0x002d, outer: #0 }] */
    /* JADX WARN: Path cross not found for [B:33:0x00ef, B:37:0x0109], limit reached: 53 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00cb -> B:32:0x00ed). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00ce -> B:32:0x00ed). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: se.f3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((f3) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
