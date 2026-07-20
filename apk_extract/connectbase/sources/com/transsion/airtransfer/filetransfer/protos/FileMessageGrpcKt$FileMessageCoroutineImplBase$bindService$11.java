package com.transsion.airtransfer.filetransfer.protos;

import jn.l;
import kn.h0;
import kn.l0;
import sq.i;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$11 extends h0 implements l<i<? extends ReceiveFinish>, i<? extends ReceiveFinish>> {
    public FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$11(Object obj) {
        super(1, obj, FileMessageGrpcKt.FileMessageCoroutineImplBase.class, "receiveFinishStream", "receiveFinishStream(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", 0);
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ i<? extends ReceiveFinish> invoke(i<? extends ReceiveFinish> iVar) {
        return invoke2((i<ReceiveFinish>) iVar);
    }

    @os.l
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final i<ReceiveFinish> invoke2(@os.l i<ReceiveFinish> iVar) {
        l0.p(iVar, "p0");
        return ((FileMessageGrpcKt.FileMessageCoroutineImplBase) this.receiver).receiveFinishStream(iVar);
    }
}
