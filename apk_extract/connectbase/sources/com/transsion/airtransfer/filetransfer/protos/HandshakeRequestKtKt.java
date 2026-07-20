package com.transsion.airtransfer.filetransfer.protos;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nHandshakeRequestKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HandshakeRequestKt.kt\ncom/transsion/airtransfer/filetransfer/protos/HandshakeRequestKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class HandshakeRequestKtKt {
    @i(name = "-initializehandshakeRequest")
    @l
    /* JADX INFO: renamed from: -initializehandshakeRequest, reason: not valid java name */
    public static final HandshakeRequest m47initializehandshakeRequest(@l jn.l<? super HandshakeRequestKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        HandshakeRequestKt.Dsl.Companion companion = HandshakeRequestKt.Dsl.Companion;
        HandshakeRequest.Builder builderNewBuilder = HandshakeRequest.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        HandshakeRequestKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final HandshakeRequest copy(@l HandshakeRequest handshakeRequest, @l jn.l<? super HandshakeRequestKt.Dsl, l2> lVar) {
        l0.p(handshakeRequest, "<this>");
        l0.p(lVar, "block");
        HandshakeRequestKt.Dsl.Companion companion = HandshakeRequestKt.Dsl.Companion;
        HandshakeRequest.Builder builder = handshakeRequest.toBuilder();
        l0.o(builder, "toBuilder(...)");
        HandshakeRequestKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
