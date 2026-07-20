package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nEmptyKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EmptyKt.kt\ncom/google/protobuf/EmptyKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,34:1\n1#2:35\n*E\n"})
public final class EmptyKtKt {
    @i(name = "-initializeempty")
    @l
    /* JADX INFO: renamed from: -initializeempty, reason: not valid java name */
    public static final Empty m22initializeempty(@l jn.l<? super EmptyKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        EmptyKt.Dsl.Companion companion = EmptyKt.Dsl.Companion;
        Empty.Builder builderNewBuilder = Empty.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        EmptyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final Empty copy(@l Empty empty, @l jn.l<? super EmptyKt.Dsl, l2> lVar) {
        l0.p(empty, "<this>");
        l0.p(lVar, "block");
        EmptyKt.Dsl.Companion companion = EmptyKt.Dsl.Companion;
        Empty.Builder builder = empty.toBuilder();
        l0.o(builder, "this.toBuilder()");
        EmptyKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
