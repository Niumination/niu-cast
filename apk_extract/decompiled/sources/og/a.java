package og;

import ag.o0;
import fg.u;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import li.g0;
import li.p1;
import li.q;
import ng.c0;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends SuspendLambda implements Function2 {
    final /* synthetic */ Function3<k, o0, Continuation<? super Unit>, Object> $handler;
    final /* synthetic */ vj.b $logger;
    final /* synthetic */ u $selector;
    final /* synthetic */ p1 $serverJob;
    final /* synthetic */ c0 $settings;
    final /* synthetic */ q $socket;
    final /* synthetic */ long $timeout;
    int I$0;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a(u uVar, c0 c0Var, q qVar, vj.b bVar, p1 p1Var, long j8, Function3<? super k, ? super o0, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super a> continuation) {
        super(2, continuation);
        this.$selector = uVar;
        this.$settings = c0Var;
        this.$socket = qVar;
        this.$logger = bVar;
        this.$serverJob = p1Var;
        this.$timeout = j8;
        this.$handler = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        a aVar = new a(this.$selector, this.$settings, this.$socket, this.$logger, this.$serverJob, this.$timeout, this.$handler, continuation);
        aVar.L$0 = obj;
        return aVar;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0190 A[Catch: all -> 0x0065, IOException -> 0x027b, TryCatch #1 {all -> 0x0065, blocks: (B:20:0x005e, B:51:0x019c, B:45:0x0178, B:47:0x0190, B:48:0x0195), top: B:126:0x005e }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0195 A[Catch: all -> 0x0065, IOException -> 0x027b, TryCatch #1 {all -> 0x0065, blocks: (B:20:0x005e, B:51:0x019c, B:45:0x0178, B:47:0x0190, B:48:0x0195), top: B:126:0x005e }] */
    /* JADX WARN: Code duplicated, block: B:50:0x019b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:0x01ca A[Catch: all -> 0x01ce, ClosedChannelException -> 0x0232, TRY_LEAVE, TryCatch #17 {ClosedChannelException -> 0x0232, all -> 0x01ce, blocks: (B:57:0x01c6, B:59:0x01ca), top: B:142:0x01c6 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:66:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:69:0x01eb A[Catch: all -> 0x0214, ClosedChannelException -> 0x0239, TryCatch #16 {ClosedChannelException -> 0x0239, all -> 0x0214, blocks: (B:67:0x01d7, B:69:0x01eb, B:72:0x01f2, B:78:0x0216, B:79:0x021b, B:80:0x021c, B:81:0x0223), top: B:144:0x01d7 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:72:0x01f2 A[Catch: all -> 0x0214, ClosedChannelException -> 0x0239, TryCatch #16 {ClosedChannelException -> 0x0239, all -> 0x0214, blocks: (B:67:0x01d7, B:69:0x01eb, B:72:0x01f2, B:78:0x0216, B:79:0x021b, B:80:0x021c, B:81:0x0223), top: B:144:0x01d7 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v3, types: [gg.r] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instruction units count: 696
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: og.a.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((a) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
