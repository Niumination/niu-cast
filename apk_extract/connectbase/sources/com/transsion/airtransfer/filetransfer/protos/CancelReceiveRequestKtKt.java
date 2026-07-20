package com.transsion.airtransfer.filetransfer.protos;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nCancelReceiveRequestKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancelReceiveRequestKt.kt\ncom/transsion/airtransfer/filetransfer/protos/CancelReceiveRequestKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class CancelReceiveRequestKtKt {
    @i(name = "-initializecancelReceiveRequest")
    @l
    /* JADX INFO: renamed from: -initializecancelReceiveRequest, reason: not valid java name */
    public static final CancelReceiveRequest m44initializecancelReceiveRequest(@l jn.l<? super CancelReceiveRequestKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        CancelReceiveRequestKt.Dsl.Companion companion = CancelReceiveRequestKt.Dsl.Companion;
        CancelReceiveRequest.Builder builderNewBuilder = CancelReceiveRequest.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        CancelReceiveRequestKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final CancelReceiveRequest copy(@l CancelReceiveRequest cancelReceiveRequest, @l jn.l<? super CancelReceiveRequestKt.Dsl, l2> lVar) {
        l0.p(cancelReceiveRequest, "<this>");
        l0.p(lVar, "block");
        CancelReceiveRequestKt.Dsl.Companion companion = CancelReceiveRequestKt.Dsl.Companion;
        CancelReceiveRequest.Builder builder = cancelReceiveRequest.toBuilder();
        l0.o(builder, "toBuilder(...)");
        CancelReceiveRequestKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
