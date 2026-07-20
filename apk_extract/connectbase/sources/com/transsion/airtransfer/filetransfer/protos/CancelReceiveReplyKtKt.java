package com.transsion.airtransfer.filetransfer.protos;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nCancelReceiveReplyKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancelReceiveReplyKt.kt\ncom/transsion/airtransfer/filetransfer/protos/CancelReceiveReplyKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,85:1\n1#2:86\n*E\n"})
public final class CancelReceiveReplyKtKt {
    @i(name = "-initializecancelReceiveReply")
    @l
    /* JADX INFO: renamed from: -initializecancelReceiveReply, reason: not valid java name */
    public static final CancelReceiveReply m43initializecancelReceiveReply(@l jn.l<? super CancelReceiveReplyKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        CancelReceiveReplyKt.Dsl.Companion companion = CancelReceiveReplyKt.Dsl.Companion;
        CancelReceiveReply.Builder builderNewBuilder = CancelReceiveReply.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        CancelReceiveReplyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final CancelReceiveReply copy(@l CancelReceiveReply cancelReceiveReply, @l jn.l<? super CancelReceiveReplyKt.Dsl, l2> lVar) {
        l0.p(cancelReceiveReply, "<this>");
        l0.p(lVar, "block");
        CancelReceiveReplyKt.Dsl.Companion companion = CancelReceiveReplyKt.Dsl.Companion;
        CancelReceiveReply.Builder builder = cancelReceiveReply.toBuilder();
        l0.o(builder, "toBuilder(...)");
        CancelReceiveReplyKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
