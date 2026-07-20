package u7;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import li.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends SuspendLambda implements Function2 {
    final /* synthetic */ Ref.BooleanRef $result;
    int I$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Ref.BooleanRef booleanRef, Continuation<? super d> continuation) {
        super(2, continuation);
        this.$result = booleanRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new d(this.$result, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0025  */
    /* JADX WARN: Code duplicated, block: B:16:0x003a  */
    /* JADX WARN: Code duplicated, block: B:18:0x0057  */
    /* JADX WARN: Code duplicated, block: B:20:0x0065  */
    /* JADX WARN: Code duplicated, block: B:22:0x006f  */
    /* JADX WARN: Code duplicated, block: B:25:0x0084 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0082 -> B:6:0x0011). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 1
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r8.label
            r3 = 0
            if (r2 == 0) goto L1b
            if (r2 != r0) goto L13
            int r2 = r8.I$0
            kotlin.ResultKt.throwOnFailure(r9)
        L11:
            r9 = r2
            goto L1f
        L13:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L1b:
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r3
        L1f:
            kotlin.jvm.internal.Ref$BooleanRef r2 = r8.$result
            boolean r2 = r2.element
            if (r2 != 0) goto L85
            r2 = 30
            if (r9 >= r2) goto L85
            int r2 = r9 + 1
            u7.e r9 = u7.e.f10405a
            boolean r9 = u7.e.f(r0)
            java.lang.String r4 = "NetworkSharingManager"
            r5 = 3
            java.lang.String r6 = "log"
            java.lang.String r7 = "tag"
            if (r9 == 0) goto L65
            java.util.concurrent.atomic.AtomicBoolean r9 = u7.e.f10409g
            r9.compareAndSet(r3, r0)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r1 = "usbHotpotSetup success:"
            r9.<init>(r1)
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r6)
            int r1 = k3.gc.f6462a
            if (r1 > r5) goto L60
            java.lang.String r1 = k3.gc.f6463b
            java.lang.String r1 = r1.concat(r4)
            android.util.Log.d(r1, r9)
        L60:
            kotlin.jvm.internal.Ref$BooleanRef r8 = r8.$result
            r8.element = r0
            goto L85
        L65:
            java.lang.String r9 = "usbHotpotSetup fail:"
            java.lang.String r9 = o.d.m(r9, r4, r7, r6, r2)
            int r6 = k3.gc.f6462a
            if (r6 > r5) goto L78
            java.lang.String r5 = k3.gc.f6463b
            java.lang.String r4 = r5.concat(r4)
            android.util.Log.d(r4, r9)
        L78:
            r8.I$0 = r2
            r8.label = r0
            r4 = 100
            java.lang.Object r9 = li.r0.a(r4, r8)
            if (r9 != r1) goto L11
            return r1
        L85:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.d.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((d) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
