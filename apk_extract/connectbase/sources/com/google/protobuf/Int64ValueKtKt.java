package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nInt64ValueKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Int64ValueKt.kt\ncom/google/protobuf/Int64ValueKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class Int64ValueKtKt {
    @i(name = "-initializeint64Value")
    @l
    /* JADX INFO: renamed from: -initializeint64Value, reason: not valid java name */
    public static final Int64Value m30initializeint64Value(@l jn.l<? super Int64ValueKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        Int64ValueKt.Dsl.Companion companion = Int64ValueKt.Dsl.Companion;
        Int64Value.Builder builderNewBuilder = Int64Value.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        Int64ValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final Int64Value copy(@l Int64Value int64Value, @l jn.l<? super Int64ValueKt.Dsl, l2> lVar) {
        l0.p(int64Value, "<this>");
        l0.p(lVar, "block");
        Int64ValueKt.Dsl.Companion companion = Int64ValueKt.Dsl.Companion;
        Int64Value.Builder builder = int64Value.toBuilder();
        l0.o(builder, "this.toBuilder()");
        Int64ValueKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
