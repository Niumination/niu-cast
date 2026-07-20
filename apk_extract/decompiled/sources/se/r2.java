package se;

import com.welink.protocol.nfbd.NearDevice;
import java.net.Socket;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class r2 extends SuspendLambda implements Function2 {
    final /* synthetic */ NearDevice $device;
    final /* synthetic */ Socket $socket;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ t2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r2(Socket socket, t2 t2Var, NearDevice nearDevice, Continuation<? super r2> continuation) {
        super(2, continuation);
        this.$socket = socket;
        this.this$0 = t2Var;
        this.$device = nearDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new r2(this.$socket, this.this$0, this.$device, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0069 A[Catch: all -> 0x002e, IOException -> 0x0031, Merged into TryCatch #1 {all -> 0x002e, IOException -> 0x0031, blocks: (B:6:0x0029, B:29:0x010d, B:17:0x0069, B:20:0x0090, B:23:0x00b8, B:26:0x00e8, B:31:0x011e, B:32:0x0128, B:34:0x012e, B:36:0x0134, B:38:0x013a, B:39:0x013e, B:41:0x0167, B:44:0x0183, B:46:0x0197, B:15:0x003f), top: B:52:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x008e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0090 A[Catch: all -> 0x002e, IOException -> 0x0031, Merged into TryCatch #1 {all -> 0x002e, IOException -> 0x0031, blocks: (B:6:0x0029, B:29:0x010d, B:17:0x0069, B:20:0x0090, B:23:0x00b8, B:26:0x00e8, B:31:0x011e, B:32:0x0128, B:34:0x012e, B:36:0x0134, B:38:0x013a, B:39:0x013e, B:41:0x0167, B:44:0x0183, B:46:0x0197, B:15:0x003f), top: B:52:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:22:0x00b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x00b8 A[Catch: all -> 0x002e, IOException -> 0x0031, Merged into TryCatch #1 {all -> 0x002e, IOException -> 0x0031, blocks: (B:6:0x0029, B:29:0x010d, B:17:0x0069, B:20:0x0090, B:23:0x00b8, B:26:0x00e8, B:31:0x011e, B:32:0x0128, B:34:0x012e, B:36:0x0134, B:38:0x013a, B:39:0x013e, B:41:0x0167, B:44:0x0183, B:46:0x0197, B:15:0x003f), top: B:52:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x00e7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x00e8 A[Catch: all -> 0x002e, IOException -> 0x0031, Merged into TryCatch #1 {all -> 0x002e, IOException -> 0x0031, blocks: (B:6:0x0029, B:29:0x010d, B:17:0x0069, B:20:0x0090, B:23:0x00b8, B:26:0x00e8, B:31:0x011e, B:32:0x0128, B:34:0x012e, B:36:0x0134, B:38:0x013a, B:39:0x013e, B:41:0x0167, B:44:0x0183, B:46:0x0197, B:15:0x003f), top: B:52:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x010b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:39:0x013e A[Catch: all -> 0x002e, IOException -> 0x0031, Merged into TryCatch #1 {all -> 0x002e, IOException -> 0x0031, blocks: (B:6:0x0029, B:29:0x010d, B:17:0x0069, B:20:0x0090, B:23:0x00b8, B:26:0x00e8, B:31:0x011e, B:32:0x0128, B:34:0x012e, B:36:0x0134, B:38:0x013a, B:39:0x013e, B:41:0x0167, B:44:0x0183, B:46:0x0197, B:15:0x003f), top: B:52:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0167 A[Catch: all -> 0x002e, IOException -> 0x0031, Merged into TryCatch #1 {all -> 0x002e, IOException -> 0x0031, blocks: (B:6:0x0029, B:29:0x010d, B:17:0x0069, B:20:0x0090, B:23:0x00b8, B:26:0x00e8, B:31:0x011e, B:32:0x0128, B:34:0x012e, B:36:0x0134, B:38:0x013a, B:39:0x013e, B:41:0x0167, B:44:0x0183, B:46:0x0197, B:15:0x003f), top: B:52:0x0011 }, TRY_LEAVE] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00e5 -> B:27:0x0109). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00e8 -> B:27:0x0109). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: se.r2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((r2) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
