package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nTimestampKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimestampKt.kt\ncom/google/protobuf/TimestampKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,68:1\n1#2:69\n*E\n"})
public final class TimestampKtKt {
    @i(name = "-initializetimestamp")
    @l
    /* JADX INFO: renamed from: -initializetimestamp, reason: not valid java name */
    public static final Timestamp m38initializetimestamp(@l jn.l<? super TimestampKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        TimestampKt.Dsl.Companion companion = TimestampKt.Dsl.Companion;
        Timestamp.Builder builderNewBuilder = Timestamp.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        TimestampKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final Timestamp copy(@l Timestamp timestamp, @l jn.l<? super TimestampKt.Dsl, l2> lVar) {
        l0.p(timestamp, "<this>");
        l0.p(lVar, "block");
        TimestampKt.Dsl.Companion companion = TimestampKt.Dsl.Companion;
        Timestamp.Builder builder = timestamp.toBuilder();
        l0.o(builder, "this.toBuilder()");
        TimestampKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
