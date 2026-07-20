package com.transsion.airtransfer.filetransfer.protos;

import jn.p;
import kn.h0;
import os.l;
import os.m;
import um.d;
import xm.n;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$2 extends h0 implements p<CancelSendRequest, d<? super Reply>, Object>, n {
    public FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$2(Object obj) {
        super(2, obj, FileMessageGrpcKt.FileMessageCoroutineImplBase.class, "cancelSend", "cancelSend(Lcom/transsion/airtransfer/filetransfer/protos/CancelSendRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // jn.p
    @m
    public final Object invoke(@l CancelSendRequest cancelSendRequest, @l d<? super Reply> dVar) {
        return ((FileMessageGrpcKt.FileMessageCoroutineImplBase) this.receiver).cancelSend(cancelSendRequest, dVar);
    }
}
