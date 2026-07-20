package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nStructKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StructKt.kt\ncom/google/protobuf/StructKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,95:1\n1#2:96\n*E\n"})
public final class StructKtKt {
    @i(name = "-initializestruct")
    @l
    /* JADX INFO: renamed from: -initializestruct, reason: not valid java name */
    public static final Struct m37initializestruct(@l jn.l<? super StructKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        StructKt.Dsl.Companion companion = StructKt.Dsl.Companion;
        Struct.Builder builderNewBuilder = Struct.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        StructKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final Struct copy(@l Struct struct, @l jn.l<? super StructKt.Dsl, l2> lVar) {
        l0.p(struct, "<this>");
        l0.p(lVar, "block");
        StructKt.Dsl.Companion companion = StructKt.Dsl.Companion;
        Struct.Builder builder = struct.toBuilder();
        l0.o(builder, "this.toBuilder()");
        StructKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
