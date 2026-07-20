package com.transsion.iotservice.iotcard.proto;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public /* synthetic */ class IIotcardProviderGrpcKt$IIotcardProviderCoroutineImplBase$bindService$3 extends FunctionReferenceImpl implements Function2<IotcardBean, Continuation<? super Empty>, Object>, SuspendFunction {
    public IIotcardProviderGrpcKt$IIotcardProviderCoroutineImplBase$bindService$3(Object obj) {
        super(2, obj, IIotcardProviderGrpcKt.IIotcardProviderCoroutineImplBase.class, "unregisterDevice", "unregisterDevice(Lcom/transsion/iotservice/iotcard/proto/IotcardBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(IotcardBean iotcardBean, Continuation<? super Empty> continuation) {
        return ((IIotcardProviderGrpcKt.IIotcardProviderCoroutineImplBase) this.receiver).unregisterDevice(iotcardBean, continuation);
    }
}
