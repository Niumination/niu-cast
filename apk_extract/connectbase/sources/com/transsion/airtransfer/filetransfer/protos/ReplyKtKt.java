package com.transsion.airtransfer.filetransfer.protos;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nReplyKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReplyKt.kt\ncom/transsion/airtransfer/filetransfer/protos/ReplyKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,58:1\n1#2:59\n*E\n"})
public final class ReplyKtKt {
    @i(name = "-initializereply")
    @l
    /* JADX INFO: renamed from: -initializereply, reason: not valid java name */
    public static final Reply m50initializereply(@l jn.l<? super ReplyKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        ReplyKt.Dsl.Companion companion = ReplyKt.Dsl.Companion;
        Reply.Builder builderNewBuilder = Reply.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        ReplyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final Reply copy(@l Reply reply, @l jn.l<? super ReplyKt.Dsl, l2> lVar) {
        l0.p(reply, "<this>");
        l0.p(lVar, "block");
        ReplyKt.Dsl.Companion companion = ReplyKt.Dsl.Companion;
        Reply.Builder builder = reply.toBuilder();
        l0.o(builder, "toBuilder(...)");
        ReplyKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
