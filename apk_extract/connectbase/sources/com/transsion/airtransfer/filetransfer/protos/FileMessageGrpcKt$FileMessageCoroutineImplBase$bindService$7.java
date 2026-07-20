package com.transsion.airtransfer.filetransfer.protos;

import jn.l;
import kn.h0;
import kn.l0;
import sq.i;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$7 extends h0 implements l<i<? extends CancelReceiveRequest>, i<? extends CancelReceiveRequest>> {
    public FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$7(Object obj) {
        super(1, obj, FileMessageGrpcKt.FileMessageCoroutineImplBase.class, "cancelReceiveStream", "cancelReceiveStream(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", 0);
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ i<? extends CancelReceiveRequest> invoke(i<? extends CancelReceiveRequest> iVar) {
        return invoke2((i<CancelReceiveRequest>) iVar);
    }

    @os.l
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final i<CancelReceiveRequest> invoke2(@os.l i<CancelReceiveRequest> iVar) {
        l0.p(iVar, "p0");
        return ((FileMessageGrpcKt.FileMessageCoroutineImplBase) this.receiver).cancelReceiveStream(iVar);
    }
}
