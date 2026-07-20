package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nDurationKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DurationKt.kt\ncom/google/protobuf/DurationKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,68:1\n1#2:69\n*E\n"})
public final class DurationKtKt {
    @i(name = "-initializeduration")
    @l
    /* JADX INFO: renamed from: -initializeduration, reason: not valid java name */
    public static final Duration m21initializeduration(@l jn.l<? super DurationKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        DurationKt.Dsl.Companion companion = DurationKt.Dsl.Companion;
        Duration.Builder builderNewBuilder = Duration.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        DurationKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final Duration copy(@l Duration duration, @l jn.l<? super DurationKt.Dsl, l2> lVar) {
        l0.p(duration, "<this>");
        l0.p(lVar, "block");
        DurationKt.Dsl.Companion companion = DurationKt.Dsl.Companion;
        Duration.Builder builder = duration.toBuilder();
        l0.o(builder, "this.toBuilder()");
        DurationKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
