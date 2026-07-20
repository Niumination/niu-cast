package com.transsion.airtransfer.filetransfer.protos;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nReceiveFinishKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReceiveFinishKt.kt\ncom/transsion/airtransfer/filetransfer/protos/ReceiveFinishKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class ReceiveFinishKtKt {
    @i(name = "-initializereceiveFinish")
    @l
    /* JADX INFO: renamed from: -initializereceiveFinish, reason: not valid java name */
    public static final ReceiveFinish m49initializereceiveFinish(@l jn.l<? super ReceiveFinishKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        ReceiveFinishKt.Dsl.Companion companion = ReceiveFinishKt.Dsl.Companion;
        ReceiveFinish.Builder builderNewBuilder = ReceiveFinish.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        ReceiveFinishKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final ReceiveFinish copy(@l ReceiveFinish receiveFinish, @l jn.l<? super ReceiveFinishKt.Dsl, l2> lVar) {
        l0.p(receiveFinish, "<this>");
        l0.p(lVar, "block");
        ReceiveFinishKt.Dsl.Companion companion = ReceiveFinishKt.Dsl.Companion;
        ReceiveFinish.Builder builder = receiveFinish.toBuilder();
        l0.o(builder, "toBuilder(...)");
        ReceiveFinishKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
