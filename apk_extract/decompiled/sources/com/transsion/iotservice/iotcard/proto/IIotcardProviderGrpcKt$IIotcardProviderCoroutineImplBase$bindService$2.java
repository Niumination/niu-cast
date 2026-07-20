package com.transsion.iotservice.iotcard.proto;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public /* synthetic */ class IIotcardProviderGrpcKt$IIotcardProviderCoroutineImplBase$bindService$2 extends FunctionReferenceImpl implements Function2<IotcardList, Continuation<? super Empty>, Object>, SuspendFunction {
    public IIotcardProviderGrpcKt$IIotcardProviderCoroutineImplBase$bindService$2(Object obj) {
        super(2, obj, IIotcardProviderGrpcKt.IIotcardProviderCoroutineImplBase.class, "registerDeviceList", "registerDeviceList(Lcom/transsion/iotservice/iotcard/proto/IotcardList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(IotcardList iotcardList, Continuation<? super Empty> continuation) {
        return ((IIotcardProviderGrpcKt.IIotcardProviderCoroutineImplBase) this.receiver).registerDeviceList(iotcardList, continuation);
    }
}
