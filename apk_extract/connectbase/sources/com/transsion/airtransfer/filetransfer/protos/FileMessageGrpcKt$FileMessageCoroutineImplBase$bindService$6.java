package com.transsion.airtransfer.filetransfer.protos;

import jn.l;
import kn.h0;
import kn.l0;
import sq.i;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$6 extends h0 implements l<i<? extends CancelSendRequest>, i<? extends CancelSendRequest>> {
    public FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$6(Object obj) {
        super(1, obj, FileMessageGrpcKt.FileMessageCoroutineImplBase.class, "cancelSendStream", "cancelSendStream(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", 0);
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ i<? extends CancelSendRequest> invoke(i<? extends CancelSendRequest> iVar) {
        return invoke2((i<CancelSendRequest>) iVar);
    }

    @os.l
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final i<CancelSendRequest> invoke2(@os.l i<CancelSendRequest> iVar) {
        l0.p(iVar, "p0");
        return ((FileMessageGrpcKt.FileMessageCoroutineImplBase) this.receiver).cancelSendStream(iVar);
    }
}
