package com.transsion.iotservice.multiscreen.pc.ui.qr;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QrConnectViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(QrConnectViewModel qrConnectViewModel, Continuation<? super b> continuation) {
        super(continuation);
        this.this$0 = qrConnectViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
