package com.transsion.airtransfer.filetransfer.protos;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nCancelSendRequestKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancelSendRequestKt.kt\ncom/transsion/airtransfer/filetransfer/protos/CancelSendRequestKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,85:1\n1#2:86\n*E\n"})
public final class CancelSendRequestKtKt {
    @i(name = "-initializecancelSendRequest")
    @l
    /* JADX INFO: renamed from: -initializecancelSendRequest, reason: not valid java name */
    public static final CancelSendRequest m46initializecancelSendRequest(@l jn.l<? super CancelSendRequestKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        CancelSendRequestKt.Dsl.Companion companion = CancelSendRequestKt.Dsl.Companion;
        CancelSendRequest.Builder builderNewBuilder = CancelSendRequest.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        CancelSendRequestKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final CancelSendRequest copy(@l CancelSendRequest cancelSendRequest, @l jn.l<? super CancelSendRequestKt.Dsl, l2> lVar) {
        l0.p(cancelSendRequest, "<this>");
        l0.p(lVar, "block");
        CancelSendRequestKt.Dsl.Companion companion = CancelSendRequestKt.Dsl.Companion;
        CancelSendRequest.Builder builder = cancelSendRequest.toBuilder();
        l0.o(builder, "toBuilder(...)");
        CancelSendRequestKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
