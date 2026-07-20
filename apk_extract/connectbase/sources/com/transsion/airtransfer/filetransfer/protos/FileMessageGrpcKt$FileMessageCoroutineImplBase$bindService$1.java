package com.transsion.airtransfer.filetransfer.protos;

import jn.p;
import kn.h0;
import os.l;
import os.m;
import um.d;
import xm.n;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$1 extends h0 implements p<SendFileInfoRequest, d<? super SendFileReply>, Object>, n {
    public FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$1(Object obj) {
        super(2, obj, FileMessageGrpcKt.FileMessageCoroutineImplBase.class, "sendFileInfo", "sendFileInfo(Lcom/transsion/airtransfer/filetransfer/protos/SendFileInfoRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // jn.p
    @m
    public final Object invoke(@l SendFileInfoRequest sendFileInfoRequest, @l d<? super SendFileReply> dVar) {
        return ((FileMessageGrpcKt.FileMessageCoroutineImplBase) this.receiver).sendFileInfo(sendFileInfoRequest, dVar);
    }
}
