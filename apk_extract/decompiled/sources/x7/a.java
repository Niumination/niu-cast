package x7;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends SuspendLambda implements Function2 {
    int I$0;
    int label;

    public a(Continuation<? super a> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new a(continuation);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0028  */
    /* JADX WARN: Code duplicated, block: B:13:0x0040  */
    /* JADX WARN: Code duplicated, block: B:16:0x005c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x006b  */
    /* JADX WARN: Code duplicated, block: B:21:0x0070  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x005a -> B:17:0x005d). Please report as a decompilation issue!!! */
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
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L1a
            if (r1 != r3) goto L12
            int r1 = r8.I$0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5d
        L12:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L1a:
            kotlin.ResultKt.throwOnFailure(r9)
            r1 = r2
        L1e:
            java.lang.String r9 = "ConnectSdkProxy"
            r4 = 61
            java.lang.String r5 = "log"
            java.lang.String r6 = "tag"
            if (r1 >= r4) goto L72
            com.transsion.connectx.sdk.TCCPSourceApi r4 = x7.f.f10882a
            android.app.Application r4 = k3.pb.a()
            java.lang.String r7 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r6)
            java.lang.String r6 = "connectService"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r5)
            int r5 = k3.gc.f6462a
            r7 = 4
            if (r5 > r7) goto L49
            java.lang.String r5 = k3.gc.f6463b
            java.lang.String r9 = r5.concat(r9)
            android.util.Log.i(r9, r6)
        L49:
            ra.h r9 = x7.f.f
            com.transsion.connectx.sdk.TCCPSourceApi r5 = x7.f.f10882a
            r5.connectService(r4, r9)
            r8.I$0 = r1
            r8.label = r3
            r4 = 50
            java.lang.Object r9 = li.r0.a(r4, r8)
            if (r9 != r0) goto L5d
            return r0
        L5d:
            android.app.Application r9 = k3.pb.a()
            com.transsion.connectx.sdk.TCCPSourceApi r9 = com.transsion.connectx.sdk.TCCPSourceApi.getInstance(r9)
            boolean r9 = r9.isServiceAvailable()
            if (r9 == 0) goto L70
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r8
        L70:
            int r1 = r1 + r3
            goto L1e
        L72:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r6)
            java.lang.String r8 = "tccp start error"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r5)
            int r0 = k3.gc.f6462a
            r1 = 6
            if (r0 > r1) goto L88
            java.lang.String r0 = k3.gc.f6463b
            java.lang.String r9 = r0.concat(r9)
            android.util.Log.e(r9, r8)
        L88:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: x7.a.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Boolean> continuation) {
        return ((a) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
