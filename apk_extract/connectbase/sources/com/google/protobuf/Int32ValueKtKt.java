package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nInt32ValueKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Int32ValueKt.kt\ncom/google/protobuf/Int32ValueKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class Int32ValueKtKt {
    @i(name = "-initializeint32Value")
    @l
    /* JADX INFO: renamed from: -initializeint32Value, reason: not valid java name */
    public static final Int32Value m29initializeint32Value(@l jn.l<? super Int32ValueKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        Int32ValueKt.Dsl.Companion companion = Int32ValueKt.Dsl.Companion;
        Int32Value.Builder builderNewBuilder = Int32Value.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        Int32ValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final Int32Value copy(@l Int32Value int32Value, @l jn.l<? super Int32ValueKt.Dsl, l2> lVar) {
        l0.p(int32Value, "<this>");
        l0.p(lVar, "block");
        Int32ValueKt.Dsl.Companion companion = Int32ValueKt.Dsl.Companion;
        Int32Value.Builder builder = int32Value.toBuilder();
        l0.o(builder, "this.toBuilder()");
        Int32ValueKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
