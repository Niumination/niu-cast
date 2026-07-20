package bf;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import ze.c2;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends SuspendLambda implements Function2 {
    final /* synthetic */ c2 $call;
    final /* synthetic */ ni.q $requestsChannel;
    final /* synthetic */ AtomicBoolean $requestsStarted;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(AtomicBoolean atomicBoolean, c2 c2Var, ni.q qVar, Continuation<? super x> continuation) {
        super(2, continuation);
        this.$requestsStarted = atomicBoolean;
        this.$call = c2Var;
        this.$requestsChannel = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        x xVar = new x(this.$requestsStarted, this.$call, this.$requestsChannel, continuation);
        xVar.L$0 = obj;
        return xVar;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0058 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0059  */
    /* JADX WARN: Code duplicated, block: B:26:0x0064 A[Catch: Exception -> 0x001b, TryCatch #0 {Exception -> 0x001b, blocks: (B:7:0x0016, B:29:0x0075, B:20:0x004c, B:24:0x005c, B:26:0x0064, B:14:0x002d, B:19:0x0046), top: B:37:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0074 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x007b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0072 -> B:8:0x0019). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L31
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            java.lang.Object r1 = r6.L$1
            ni.f r1 = (ni.f) r1
            java.lang.Object r4 = r6.L$0
            oi.i r4 = (oi.i) r4
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L1b
        L19:
            r7 = r4
            goto L75
        L1b:
            r7 = move-exception
            goto L7e
        L1d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L25:
            java.lang.Object r1 = r6.L$1
            ni.f r1 = (ni.f) r1
            java.lang.Object r4 = r6.L$0
            oi.i r4 = (oi.i) r4
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L1b
            goto L5c
        L31:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            oi.i r7 = (oi.i) r7
            java.util.concurrent.atomic.AtomicBoolean r1 = r6.$requestsStarted
            r4 = 0
            boolean r1 = r1.compareAndSet(r4, r3)
            if (r1 == 0) goto L8f
            ze.c2 r1 = r6.$call
            r1.b(r3)
            ni.q r1 = r6.$requestsChannel     // Catch: java.lang.Exception -> L1b
            ni.f r1 = r1.iterator()     // Catch: java.lang.Exception -> L1b
        L4c:
            r6.L$0 = r7     // Catch: java.lang.Exception -> L1b
            r6.L$1 = r1     // Catch: java.lang.Exception -> L1b
            r6.label = r3     // Catch: java.lang.Exception -> L1b
            java.lang.Object r4 = r1.b(r6)     // Catch: java.lang.Exception -> L1b
            if (r4 != r0) goto L59
            return r0
        L59:
            r5 = r4
            r4 = r7
            r7 = r5
        L5c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Exception -> L1b
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Exception -> L1b
            if (r7 == 0) goto L7b
            java.lang.Object r7 = r1.d()     // Catch: java.lang.Exception -> L1b
            r6.L$0 = r4     // Catch: java.lang.Exception -> L1b
            r6.L$1 = r1     // Catch: java.lang.Exception -> L1b
            r6.label = r2     // Catch: java.lang.Exception -> L1b
            java.lang.Object r7 = r4.emit(r7, r6)     // Catch: java.lang.Exception -> L1b
            if (r7 != r0) goto L19
            return r0
        L75:
            ze.c2 r4 = r6.$call     // Catch: java.lang.Exception -> L1b
            r4.b(r3)     // Catch: java.lang.Exception -> L1b
            goto L4c
        L7b:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L7e:
            ni.q r0 = r6.$requestsChannel
            java.lang.String r1 = "Exception thrown while collecting requests"
            java.util.concurrent.CancellationException r1 = li.l0.a(r1, r7)
            r0.h(r1)
            ze.c2 r6 = r6.$call
            r6.b(r3)
            throw r7
        L8f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "requests flow can only be collected once"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: bf.x.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(oi.i iVar, Continuation<? super Unit> continuation) {
        return ((x) create(iVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
