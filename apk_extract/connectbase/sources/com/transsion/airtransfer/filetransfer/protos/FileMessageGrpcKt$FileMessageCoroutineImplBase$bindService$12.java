package com.transsion.airtransfer.filetransfer.protos;

import jn.l;
import kn.h0;
import kn.l0;
import sq.i;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$12 extends h0 implements l<i<? extends HandshakeRequest>, i<? extends HandshakeRequest>> {
    public FileMessageGrpcKt$FileMessageCoroutineImplBase$bindService$12(Object obj) {
        super(1, obj, FileMessageGrpcKt.FileMessageCoroutineImplBase.class, "handshakeStream", "handshakeStream(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", 0);
    }

    @Override // jn.l
    public /* bridge */ /* synthetic */ i<? extends HandshakeRequest> invoke(i<? extends HandshakeRequest> iVar) {
        return invoke2((i<HandshakeRequest>) iVar);
    }

    @os.l
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final i<HandshakeRequest> invoke2(@os.l i<HandshakeRequest> iVar) {
        l0.p(iVar, "p0");
        return ((FileMessageGrpcKt.FileMessageCoroutineImplBase) this.receiver).handshakeStream(iVar);
    }
}
