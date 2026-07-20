package com.transsion.airtransfer.filetransfer.protos;

import jn.p;
import kn.h0;
import os.l;
import os.m;
import um.d;
import xm.n;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$3 extends h0 implements p<CancelReceiveRequest, d<? super CancelReceiveReply>, Object>, n {
    public FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$3(Object obj) {
        super(2, obj, FileMessageGrpcKt.FileMessageCoroutineImplBase.class, "cancelReceive", "cancelReceive(Lcom/transsion/airtransfer/filetransfer/protos/CancelReceiveRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // jn.p
    @m
    public final Object invoke(@l CancelReceiveRequest cancelReceiveRequest, @l d<? super CancelReceiveReply> dVar) {
        return ((FileMessageGrpcKt.FileMessageCoroutineImplBase) this.receiver).cancelReceive(cancelReceiveRequest, dVar);
    }
}
