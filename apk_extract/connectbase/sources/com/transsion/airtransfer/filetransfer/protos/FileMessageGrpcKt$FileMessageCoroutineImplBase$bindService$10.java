package com.transsion.airtransfer.filetransfer.protos;

import jn.l;
import kn.h0;
import kn.l0;
import sq.i;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$10 extends h0 implements l<i<? extends CancelSendReply>, i<? extends CancelSendReply>> {
    public FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$10(Object obj) {
        super(1, obj, FileMessageGrpcKt.FileMessageCoroutineImplBase.class, "cancelSendReplyStream", "cancelSendReplyStream(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", 0);
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ i<? extends CancelSendReply> invoke(i<? extends CancelSendReply> iVar) {
        return invoke2((i<CancelSendReply>) iVar);
    }

    @os.l
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final i<CancelSendReply> invoke2(@os.l i<CancelSendReply> iVar) {
        l0.p(iVar, "p0");
        return ((FileMessageGrpcKt.FileMessageCoroutineImplBase) this.receiver).cancelSendReplyStream(iVar);
    }
}
