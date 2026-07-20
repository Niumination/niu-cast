package oh;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends SuspendLambda implements Function2 {
    final /* synthetic */ ni.q $channel;
    final /* synthetic */ ni.g0 $outgoing;
    final /* synthetic */ String $pingMessage;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(ni.g0 g0Var, String str, ni.q qVar, Continuation<? super b0> continuation) {
        super(2, continuation);
        this.$outgoing = g0Var;
        this.$pingMessage = str;
        this.$channel = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new b0(this.$outgoing, this.$pingMessage, this.$channel, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x004a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:18:0x005c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0072  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0048 -> B:16:0x004b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:15:0x004a
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
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4b
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1a:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L40
        L1e:
            kotlin.ResultKt.throwOnFailure(r7)
            vj.b r7 = oh.l.f8508a
            java.lang.String r1 = "WebSocket Pinger: sending ping frame"
            r7.trace(r1)
            ni.g0 r7 = r6.$outgoing
            oh.p r1 = new oh.p
            java.lang.String r4 = r6.$pingMessage
            java.nio.charset.Charset r5 = kotlin.text.Charsets.ISO_8859_1
            byte[] r4 = lh.a.i(r4, r5)
            r1.<init>(r4)
            r6.label = r3
            java.lang.Object r7 = r7.r(r1, r6)
            if (r7 != r0) goto L40
            return r0
        L40:
            ni.q r7 = r6.$channel
            r6.label = r2
            java.lang.Object r7 = r7.j(r6)
            if (r7 != r0) goto L4b
            return r0
        L4b:
            oh.q r7 = (oh.q) r7
            byte[] r1 = r7.f8520c
            int r3 = r1.length
            java.lang.String r1 = kotlin.text.StringsKt.t(r3, r1)
            java.lang.String r3 = r6.$pingMessage
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 == 0) goto L72
            vj.b r6 = oh.l.f8508a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "WebSocket Pinger: received valid pong frame "
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r6.trace(r7)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L72:
            vj.b r1 = oh.l.f8508a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "WebSocket Pinger: received invalid pong frame "
            r3.<init>(r4)
            r3.append(r7)
            java.lang.String r7 = ", continue waiting"
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            r1.trace(r7)
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: oh.b0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((b0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
