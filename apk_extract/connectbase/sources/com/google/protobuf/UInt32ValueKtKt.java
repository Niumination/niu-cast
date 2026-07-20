package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nUInt32ValueKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UInt32ValueKt.kt\ncom/google/protobuf/UInt32ValueKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class UInt32ValueKtKt {
    @i(name = "-initializeuInt32Value")
    @l
    /* JADX INFO: renamed from: -initializeuInt32Value, reason: not valid java name */
    public static final UInt32Value m40initializeuInt32Value(@l jn.l<? super UInt32ValueKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        UInt32ValueKt.Dsl.Companion companion = UInt32ValueKt.Dsl.Companion;
        UInt32Value.Builder builderNewBuilder = UInt32Value.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        UInt32ValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final UInt32Value copy(@l UInt32Value uInt32Value, @l jn.l<? super UInt32ValueKt.Dsl, l2> lVar) {
        l0.p(uInt32Value, "<this>");
        l0.p(lVar, "block");
        UInt32ValueKt.Dsl.Companion companion = UInt32ValueKt.Dsl.Companion;
        UInt32Value.Builder builder = uInt32Value.toBuilder();
        l0.o(builder, "this.toBuilder()");
        UInt32ValueKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
