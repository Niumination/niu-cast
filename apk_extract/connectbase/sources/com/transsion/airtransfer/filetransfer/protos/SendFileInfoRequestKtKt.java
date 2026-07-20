package com.transsion.airtransfer.filetransfer.protos;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nSendFileInfoRequestKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SendFileInfoRequestKt.kt\ncom/transsion/airtransfer/filetransfer/protos/SendFileInfoRequestKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,233:1\n1#2:234\n*E\n"})
public final class SendFileInfoRequestKtKt {
    @i(name = "-initializesendFileInfoRequest")
    @l
    /* JADX INFO: renamed from: -initializesendFileInfoRequest, reason: not valid java name */
    public static final SendFileInfoRequest m52initializesendFileInfoRequest(@l jn.l<? super SendFileInfoRequestKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        SendFileInfoRequestKt.Dsl.Companion companion = SendFileInfoRequestKt.Dsl.Companion;
        SendFileInfoRequest.Builder builderNewBuilder = SendFileInfoRequest.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        SendFileInfoRequestKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final SendFileInfoRequest copy(@l SendFileInfoRequest sendFileInfoRequest, @l jn.l<? super SendFileInfoRequestKt.Dsl, l2> lVar) {
        l0.p(sendFileInfoRequest, "<this>");
        l0.p(lVar, "block");
        SendFileInfoRequestKt.Dsl.Companion companion = SendFileInfoRequestKt.Dsl.Companion;
        SendFileInfoRequest.Builder builder = sendFileInfoRequest.toBuilder();
        l0.o(builder, "toBuilder(...)");
        SendFileInfoRequestKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final SendFileInfoRequest.FileInfo copy(@l SendFileInfoRequest.FileInfo fileInfo, @l jn.l<? super SendFileInfoRequestKt.FileInfoKt.Dsl, l2> lVar) {
        l0.p(fileInfo, "<this>");
        l0.p(lVar, "block");
        SendFileInfoRequestKt.FileInfoKt.Dsl.Companion companion = SendFileInfoRequestKt.FileInfoKt.Dsl.Companion;
        SendFileInfoRequest.FileInfo.Builder builder = fileInfo.toBuilder();
        l0.o(builder, "toBuilder(...)");
        SendFileInfoRequestKt.FileInfoKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
