package na;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends SuspendLambda implements Function2 {
    int I$0;
    int label;

    public l(Continuation<? super l> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new l(continuation);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0021  */
    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    /* JADX WARN: Code duplicated, block: B:15:0x002e  */
    /* JADX WARN: Code duplicated, block: B:17:0x003a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x003d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0038 -> B:18:0x003b). Please report as a decompilation issue!!! */
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
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L1a
            if (r1 != r3) goto L12
            int r1 = r6.I$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L3b
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1a:
            kotlin.ResultKt.throwOnFailure(r7)
            r1 = r2
        L1e:
            r7 = 6
            if (r1 >= r7) goto L3d
            com.transsion.tranradionet.TranRadioNetManager r7 = na.m.f8146c
            boolean r7 = r7.isServiceConnected()
            if (r7 == 0) goto L2e
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        L2e:
            r6.I$0 = r1
            r6.label = r3
            r4 = 200(0xc8, double:9.9E-322)
            java.lang.Object r7 = li.r0.a(r4, r6)
            if (r7 != r0) goto L3b
            return r0
        L3b:
            int r1 = r1 + r3
            goto L1e
        L3d:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: na.l.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Boolean> continuation) {
        return ((l) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
