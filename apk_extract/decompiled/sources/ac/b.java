package ac;

import com.transsion.iotservice.multiscreen.pc.ui.setting.PcTransferSettingViewModel;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends SuspendLambda implements Function2 {
    final /* synthetic */ int $count;
    int label;
    final /* synthetic */ PcTransferSettingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(PcTransferSettingViewModel pcTransferSettingViewModel, int i8, Continuation<? super b> continuation) {
        super(2, continuation);
        this.this$0 = pcTransferSettingViewModel;
        this.$count = i8;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new b(this.this$0, this.$count, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0024 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:15:0x0036  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:12:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:14:0x0031
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
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.ResultKt.throwOnFailure(r6)
            goto L25
        Lf:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L17:
            kotlin.ResultKt.throwOnFailure(r6)
        L1a:
            r5.label = r2
            r3 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r6 = li.r0.a(r3, r5)
            if (r6 != r0) goto L25
            return r0
        L25:
            com.transsion.iotservice.multiscreen.pc.ui.setting.PcTransferSettingViewModel r6 = r5.this$0
            androidx.lifecycle.MutableLiveData r6 = r6.f2882d
            java.lang.Object r1 = r6.getValue()
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 == 0) goto L36
            int r1 = r1.intValue()
            goto L37
        L36:
            r1 = 0
        L37:
            int r1 = r1 + r2
            int r3 = r5.$count
            int r1 = r1 % r3
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r6.postValue(r1)
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: ac.b.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((b) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
