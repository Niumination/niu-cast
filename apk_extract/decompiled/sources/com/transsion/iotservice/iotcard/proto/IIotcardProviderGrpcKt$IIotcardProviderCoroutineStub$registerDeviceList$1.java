package com.transsion.iotservice.iotcard.proto;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.transsion.iotservice.iotcard.proto.IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub", f = "IotcardProtoGrpcKt.kt", i = {}, l = {123}, m = "registerDeviceList", n = {}, s = {})
public final class IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDeviceList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IIotcardProviderGrpcKt.IIotcardProviderCoroutineStub this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDeviceList$1(IIotcardProviderGrpcKt.IIotcardProviderCoroutineStub iIotcardProviderCoroutineStub, Continuation<? super IIotcardProviderGrpcKt$IIotcardProviderCoroutineStub$registerDeviceList$1> continuation) {
        super(continuation);
        this.this$0 = iIotcardProviderCoroutineStub;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.registerDeviceList(null, null, this);
    }
}
