package com.transsion.airtransfer.filetransfer.protos;

import jn.l;
import kn.h0;
import kn.l0;
import sq.i;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$9 extends h0 implements l<i<? extends CancelReceiveReply>, i<? extends CancelReceiveReply>> {
    public FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$9(Object obj) {
        super(1, obj, FileMessageGrpcKt.FileMessageCoroutineImplBase.class, "cancelReceiveReplyStream", "cancelReceiveReplyStream(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", 0);
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ i<? extends CancelReceiveReply> invoke(i<? extends CancelReceiveReply> iVar) {
        return invoke2((i<CancelReceiveReply>) iVar);
    }

    @os.l
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final i<CancelReceiveReply> invoke2(@os.l i<CancelReceiveReply> iVar) {
        l0.p(iVar, "p0");
        return ((FileMessageGrpcKt.FileMessageCoroutineImplBase) this.receiver).cancelReceiveReplyStream(iVar);
    }
}
