package com.transsion.airtransfer.filetransfer.protos;

import jn.p;
import kn.h0;
import os.l;
import os.m;
import um.d;
import xm.n;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$4 extends h0 implements p<Heartbeat, d<? super Heartbeat>, Object>, n {
    public FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$4(Object obj) {
        super(2, obj, FileMessageGrpcKt.FileMessageCoroutineImplBase.class, "sendHeartbeat", "sendHeartbeat(Lcom/transsion/airtransfer/filetransfer/protos/Heartbeat;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // jn.p
    @m
    public final Object invoke(@l Heartbeat heartbeat, @l d<? super Heartbeat> dVar) {
        return ((FileMessageGrpcKt.FileMessageCoroutineImplBase) this.receiver).sendHeartbeat(heartbeat, dVar);
    }
}
