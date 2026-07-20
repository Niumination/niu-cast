package cg;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends SuspendLambda implements Function2 {
    final /* synthetic */ b $this_asFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, Continuation<? super c> continuation) {
        super(2, continuation);
        this.$this_asFlow = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        c cVar = new c(this.$this_asFlow, continuation);
        cVar.L$0 = obj;
        return cVar;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x003d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0044  */
    /* JADX WARN: Code duplicated, block: B:20:0x0047  */
    /* JADX WARN: Code duplicated, block: B:22:0x0051 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x004f -> B:7:0x0015). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L27
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r1 = r5.L$0
            oi.i r1 = (oi.i) r1
            kotlin.ResultKt.throwOnFailure(r6)
        L15:
            r6 = r1
            goto L2e
        L17:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L1f:
            java.lang.Object r1 = r5.L$0
            oi.i r1 = (oi.i) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L40
        L27:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.Object r6 = r5.L$0
            oi.i r6 = (oi.i) r6
        L2e:
            cg.b r1 = r5.$this_asFlow
            r5.L$0 = r6
            r5.label = r3
            ag.j r1 = (ag.j) r1
            java.lang.Object r1 = r1.d(r5)
            if (r1 != r0) goto L3d
            return r0
        L3d:
            r4 = r1
            r1 = r6
            r6 = r4
        L40:
            cg.n r6 = (cg.n) r6
            if (r6 != 0) goto L47
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L47:
            r5.L$0 = r1
            r5.label = r2
            java.lang.Object r6 = r1.emit(r6, r5)
            if (r6 != r0) goto L15
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cg.c.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(oi.i iVar, Continuation<? super Unit> continuation) {
        return ((c) create(iVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
