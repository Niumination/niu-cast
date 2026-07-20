package com.transsion.airtransfer.filetransfer.protos;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nHeartbeatKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HeartbeatKt.kt\ncom/transsion/airtransfer/filetransfer/protos/HeartbeatKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class HeartbeatKtKt {
    @i(name = "-initializeheartbeat")
    @l
    /* JADX INFO: renamed from: -initializeheartbeat, reason: not valid java name */
    public static final Heartbeat m48initializeheartbeat(@l jn.l<? super HeartbeatKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        HeartbeatKt.Dsl.Companion companion = HeartbeatKt.Dsl.Companion;
        Heartbeat.Builder builderNewBuilder = Heartbeat.newBuilder();
        l0.o(builderNewBuilder, "newBuilder(...)");
        HeartbeatKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final Heartbeat copy(@l Heartbeat heartbeat, @l jn.l<? super HeartbeatKt.Dsl, l2> lVar) {
        l0.p(heartbeat, "<this>");
        l0.p(lVar, "block");
        HeartbeatKt.Dsl.Companion companion = HeartbeatKt.Dsl.Companion;
        Heartbeat.Builder builder = heartbeat.toBuilder();
        l0.o(builder, "toBuilder(...)");
        HeartbeatKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
