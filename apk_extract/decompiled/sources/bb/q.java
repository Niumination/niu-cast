package bb;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends SuspendLambda implements Function2 {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    final /* synthetic */ r this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(r rVar, Continuation<? super q> continuation) {
        super(2, continuation);
        this.this$0 = rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new q(this.this$0, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002e  */
    /* JADX WARN: Code duplicated, block: B:12:0x003e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x0043  */
    /* JADX WARN: Code duplicated, block: B:17:0x0056  */
    /* JADX WARN: Code duplicated, block: B:20:0x0087  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003c -> B:13:0x003f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:17:0x0056
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
            r2 = 1
            if (r1 == 0) goto L1f
            if (r1 != r2) goto L17
            int r1 = r9.I$1
            int r3 = r9.I$0
            java.lang.Object r4 = r9.L$0
            bb.r r4 = (bb.r) r4
            kotlin.ResultKt.throwOnFailure(r10)
            goto L3f
        L17:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L1f:
            kotlin.ResultKt.throwOnFailure(r10)
            bb.r r10 = r9.this$0
            r1 = 2147483647(0x7fffffff, float:NaN)
            r3 = 0
            r4 = r10
            r8 = r3
            r3 = r1
            r1 = r8
        L2c:
            if (r1 >= r3) goto L8c
            r9.L$0 = r4
            r9.I$0 = r3
            r9.I$1 = r1
            r9.label = r2
            r5 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r10 = li.r0.a(r5, r9)
            if (r10 != r0) goto L3f
            return r0
        L3f:
            boolean r10 = r4.f1246h
            if (r10 == 0) goto L8a
            java.lang.String r10 = "tag"
            java.lang.String r5 = "BleScanDataFilterHelper"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r10)
            java.lang.String r10 = "<scheduleRefresh>"
            java.lang.String r6 = "log"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r6)
            int r6 = k3.gc.f6462a
            r7 = 3
            if (r6 > r7) goto L5f
            java.lang.String r6 = k3.gc.f6463b
            java.lang.String r5 = r6.concat(r5)
            android.util.Log.d(r5, r10)
        L5f:
            java.util.concurrent.ConcurrentHashMap r10 = r4.f1244d
            java.util.Collection r10 = r10.values()
            java.lang.String r5 = "<get-values>(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r5)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            bb.o r5 = r4.f1250l
            java.util.List r10 = kotlin.collections.CollectionsKt.sortedWith(r10, r5)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r10 = (java.util.Collection) r10
            r5.addAll(r10)
            boolean r10 = r5.isEmpty()
            r10 = r10 ^ r2
            r4.f1242b = r10
            zb.b r10 = r4.f1247i
            if (r10 == 0) goto L8a
            r10.invoke(r5)
        L8a:
            int r1 = r1 + r2
            goto L2c
        L8c:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: bb.q.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((q) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
