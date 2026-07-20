package com.transsion.airtransfer.filetransfer.protos;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nSendFileReplyKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SendFileReplyKt.kt\ncom/transsion/airtransfer/filetransfer/protos/SendFileReplyKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,85:1\n1#2:86\n*E\n"})
public final class SendFileReplyKtKt {
    @i(name = "-initializesendFileReply")
    @l
    /* JADX INFO: renamed from: -initializesendFileReply, reason: not valid java name */
    public static final SendFileReply m53initializesendFileReply(@l jn.l<? super SendFileReplyKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        SendFileReplyKt.Dsl.Companion companion = SendFileReplyKt.Dsl.Companion;
        SendFileReply.Builder builderNewBuilder = SendFileReply.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        SendFileReplyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final SendFileReply copy(@l SendFileReply sendFileReply, @l jn.l<? super SendFileReplyKt.Dsl, l2> lVar) {
        l0.p(sendFileReply, "<this>");
        l0.p(lVar, "block");
        SendFileReplyKt.Dsl.Companion companion = SendFileReplyKt.Dsl.Companion;
        SendFileReply.Builder builder = sendFileReply.toBuilder();
        l0.o(builder, "toBuilder(...)");
        SendFileReplyKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
