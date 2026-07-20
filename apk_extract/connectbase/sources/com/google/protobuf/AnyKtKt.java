package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nAnyKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnyKt.kt\ncom/google/protobuf/AnyKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,68:1\n1#2:69\n*E\n"})
public final class AnyKtKt {
    @i(name = "-initializeany")
    @l
    /* JADX INFO: renamed from: -initializeany, reason: not valid java name */
    public static final Any m16initializeany(@l jn.l<? super AnyKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        AnyKt.Dsl.Companion companion = AnyKt.Dsl.Companion;
        Any.Builder builderNewBuilder = Any.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        AnyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final Any copy(@l Any any, @l jn.l<? super AnyKt.Dsl, l2> lVar) {
        l0.p(any, "<this>");
        l0.p(lVar, "block");
        AnyKt.Dsl.Companion companion = AnyKt.Dsl.Companion;
        Any.Builder builder = any.toBuilder();
        l0.o(builder, "this.toBuilder()");
        AnyKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
