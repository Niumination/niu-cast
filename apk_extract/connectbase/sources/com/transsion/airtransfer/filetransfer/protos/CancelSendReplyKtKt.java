package com.transsion.airtransfer.filetransfer.protos;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nCancelSendReplyKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancelSendReplyKt.kt\ncom/transsion/airtransfer/filetransfer/protos/CancelSendReplyKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,75:1\n1#2:76\n*E\n"})
public final class CancelSendReplyKtKt {
    @i(name = "-initializecancelSendReply")
    @l
    /* JADX INFO: renamed from: -initializecancelSendReply, reason: not valid java name */
    public static final CancelSendReply m45initializecancelSendReply(@l jn.l<? super CancelSendReplyKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        CancelSendReplyKt.Dsl.Companion companion = CancelSendReplyKt.Dsl.Companion;
        CancelSendReply.Builder builderNewBuilder = CancelSendReply.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        CancelSendReplyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final CancelSendReply copy(@l CancelSendReply cancelSendReply, @l jn.l<? super CancelSendReplyKt.Dsl, l2> lVar) {
        l0.p(cancelSendReply, "<this>");
        l0.p(lVar, "block");
        CancelSendReplyKt.Dsl.Companion companion = CancelSendReplyKt.Dsl.Companion;
        CancelSendReply.Builder builder = cancelSendReply.toBuilder();
        l0.o(builder, "toBuilder(...)");
        CancelSendReplyKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
