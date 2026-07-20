package com.transsion.airtransfer.filetransfer.protos;

import jn.l;
import kn.h0;
import kn.l0;
import sq.i;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$5 extends h0 implements l<i<? extends SendFileInfoRequest>, i<? extends SendFileInfoRequest>> {
    public FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$5(Object obj) {
        super(1, obj, FileMessageGrpcKt.FileMessageCoroutineImplBase.class, "sendFileInfoStream", "sendFileInfoStream(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", 0);
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ i<? extends SendFileInfoRequest> invoke(i<? extends SendFileInfoRequest> iVar) {
        return invoke2((i<SendFileInfoRequest>) iVar);
    }

    @os.l
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final i<SendFileInfoRequest> invoke2(@os.l i<SendFileInfoRequest> iVar) {
        l0.p(iVar, "p0");
        return ((FileMessageGrpcKt.FileMessageCoroutineImplBase) this.receiver).sendFileInfoStream(iVar);
    }
}
