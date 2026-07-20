package com.transsion.airtransfer.filetransfer.protos;

import jn.l;
import kn.h0;
import kn.l0;
import sq.i;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$8 extends h0 implements l<i<? extends SendFileReply>, i<? extends SendFileReply>> {
    public FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$8(Object obj) {
        super(1, obj, FileMessageGrpcKt.FileMessageCoroutineImplBase.class, "sendFileInfoReplyStream", "sendFileInfoReplyStream(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", 0);
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ i<? extends SendFileReply> invoke(i<? extends SendFileReply> iVar) {
        return invoke2((i<SendFileReply>) iVar);
    }

    @os.l
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final i<SendFileReply> invoke2(@os.l i<SendFileReply> iVar) {
        l0.p(iVar, "p0");
        return ((FileMessageGrpcKt.FileMessageCoroutineImplBase) this.receiver).sendFileInfoReplyStream(iVar);
    }
}
