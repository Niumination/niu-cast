package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nUInt64ValueKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UInt64ValueKt.kt\ncom/google/protobuf/UInt64ValueKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class UInt64ValueKtKt {
    @i(name = "-initializeuInt64Value")
    @l
    /* JADX INFO: renamed from: -initializeuInt64Value, reason: not valid java name */
    public static final UInt64Value m41initializeuInt64Value(@l jn.l<? super UInt64ValueKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        UInt64ValueKt.Dsl.Companion companion = UInt64ValueKt.Dsl.Companion;
        UInt64Value.Builder builderNewBuilder = UInt64Value.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        UInt64ValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final UInt64Value copy(@l UInt64Value uInt64Value, @l jn.l<? super UInt64ValueKt.Dsl, l2> lVar) {
        l0.p(uInt64Value, "<this>");
        l0.p(lVar, "block");
        UInt64ValueKt.Dsl.Companion companion = UInt64ValueKt.Dsl.Companion;
        UInt64Value.Builder builder = uInt64Value.toBuilder();
        l0.o(builder, "this.toBuilder()");
        UInt64ValueKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
