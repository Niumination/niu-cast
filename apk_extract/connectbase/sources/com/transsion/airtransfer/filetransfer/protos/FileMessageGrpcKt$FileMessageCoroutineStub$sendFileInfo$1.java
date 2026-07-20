package com.transsion.airtransfer.filetransfer.protos;

import os.l;
import os.m;
import xm.d;
import xm.f;
import y5.a;

/* JADX INFO: loaded from: classes2.dex */
@f(c = "com.transsion.airtransfer.filetransfer.protos.FileMessageGrpcKt$FileMessageCoroutineStub", f = "FileMessageProtoGrpcKt.kt", i = {}, l = {a.f20716e0}, m = "sendFileInfo", n = {}, s = {})
public final class FileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$1 extends d {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileMessageGrpcKt.FileMessageCoroutineStub this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$1(FileMessageGrpcKt.FileMessageCoroutineStub fileMessageCoroutineStub, um.d<? super FileMessageGrpcKt$FileMessageCoroutineStub$sendFileInfo$1> dVar) {
        super(dVar);
        this.this$0 = fileMessageCoroutineStub;
    }

    @Override // xm.a
    @m
    public final Object invokeSuspend(@l Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sendFileInfo(null, null, this);
    }
}
