package com.transsion.iotservice.iotcard.proto;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import oi.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public /* synthetic */ class IIotcardProviderGrpcKt$IIotcardProviderCoroutineImplBase$bindService$7 extends FunctionReferenceImpl implements Function1<h, h> {
    public IIotcardProviderGrpcKt$IIotcardProviderCoroutineImplBase$bindService$7(Object obj) {
        super(1, obj, IIotcardProviderGrpcKt.IIotcardProviderCoroutineImplBase.class, "initAppDevices", "initAppDevices(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final h invoke(h p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((IIotcardProviderGrpcKt.IIotcardProviderCoroutineImplBase) this.receiver).initAppDevices(p0);
    }
}
