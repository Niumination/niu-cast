package oh;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends SuspendLambda implements Function2 {
    final /* synthetic */ ni.q $channel;
    final /* synthetic */ ni.g0 $outgoing;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(ni.q qVar, ni.g0 g0Var, Continuation<? super d0> continuation) {
        super(2, continuation);
        this.$channel = qVar;
        this.$outgoing = g0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new d0(this.$channel, this.$outgoing, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0052 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0053  */
    /* JADX WARN: Code duplicated, block: B:25:0x005e A[Catch: all -> 0x001f, TryCatch #2 {all -> 0x001f, blocks: (B:7:0x001a, B:19:0x0044, B:23:0x0056, B:25:0x005e, B:28:0x0083, B:14:0x0035, B:18:0x0040), top: B:39:0x0008, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0082 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0083 A[Catch: all -> 0x001f, TRY_LEAVE, TryCatch #2 {all -> 0x001f, blocks: (B:7:0x001a, B:19:0x0044, B:23:0x0056, B:25:0x005e, B:28:0x0083, B:14:0x0035, B:18:0x0040), top: B:39:0x0008, outer: #0 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0080 -> B:8:0x001d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L39
            if (r1 == r3) goto L29
            if (r1 != r2) goto L21
            java.lang.Object r1 = r9.L$2
            ni.f r1 = (ni.f) r1
            java.lang.Object r4 = r9.L$1
            ni.f0 r4 = (ni.f0) r4
            java.lang.Object r5 = r9.L$0
            ni.g0 r5 = (ni.g0) r5
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L1f
        L1d:
            r10 = r5
            goto L44
        L1f:
            r9 = move-exception
            goto L8a
        L21:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L29:
            java.lang.Object r1 = r9.L$2
            ni.f r1 = (ni.f) r1
            java.lang.Object r4 = r9.L$1
            ni.f0 r4 = (ni.f0) r4
            java.lang.Object r5 = r9.L$0
            ni.g0 r5 = (ni.g0) r5
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L1f
            goto L56
        L39:
            kotlin.ResultKt.throwOnFailure(r10)
            ni.q r4 = r9.$channel     // Catch: ni.x -> L90
            ni.g0 r10 = r9.$outgoing     // Catch: ni.x -> L90
            ni.f r1 = r4.iterator()     // Catch: java.lang.Throwable -> L1f
        L44:
            r9.L$0 = r10     // Catch: java.lang.Throwable -> L1f
            r9.L$1 = r4     // Catch: java.lang.Throwable -> L1f
            r9.L$2 = r1     // Catch: java.lang.Throwable -> L1f
            r9.label = r3     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r5 = r1.b(r9)     // Catch: java.lang.Throwable -> L1f
            if (r5 != r0) goto L53
            return r0
        L53:
            r8 = r5
            r5 = r10
            r10 = r8
        L56:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L1f
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L1f
            if (r10 == 0) goto L83
            java.lang.Object r10 = r1.d()     // Catch: java.lang.Throwable -> L1f
            oh.p r10 = (oh.p) r10     // Catch: java.lang.Throwable -> L1f
            vj.b r6 = oh.l.f8508a     // Catch: java.lang.Throwable -> L1f
            java.lang.String r7 = "Received ping message, sending pong message"
            r6.trace(r7)     // Catch: java.lang.Throwable -> L1f
            oh.q r6 = new oh.q     // Catch: java.lang.Throwable -> L1f
            byte[] r10 = r10.f8520c     // Catch: java.lang.Throwable -> L1f
            oh.z r7 = oh.z.f8533a     // Catch: java.lang.Throwable -> L1f
            r6.<init>(r10, r7)     // Catch: java.lang.Throwable -> L1f
            r9.L$0 = r5     // Catch: java.lang.Throwable -> L1f
            r9.L$1 = r4     // Catch: java.lang.Throwable -> L1f
            r9.L$2 = r1     // Catch: java.lang.Throwable -> L1f
            r9.label = r2     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r10 = r5.r(r6, r9)     // Catch: java.lang.Throwable -> L1f
            if (r10 != r0) goto L1d
            return r0
        L83:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L1f
            r9 = 0
            r4.h(r9)     // Catch: ni.x -> L90
            goto L90
        L8a:
            throw r9     // Catch: java.lang.Throwable -> L8b
        L8b:
            r10 = move-exception
            k3.cc.a(r4, r9)     // Catch: ni.x -> L90
            throw r10     // Catch: ni.x -> L90
        L90:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: oh.d0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((d0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
