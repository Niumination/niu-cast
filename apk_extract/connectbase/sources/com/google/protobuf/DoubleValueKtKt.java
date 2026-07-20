package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nDoubleValueKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DoubleValueKt.kt\ncom/google/protobuf/DoubleValueKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class DoubleValueKtKt {
    @i(name = "-initializedoubleValue")
    @l
    /* JADX INFO: renamed from: -initializedoubleValue, reason: not valid java name */
    public static final DoubleValue m20initializedoubleValue(@l jn.l<? super DoubleValueKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        DoubleValueKt.Dsl.Companion companion = DoubleValueKt.Dsl.Companion;
        DoubleValue.Builder builderNewBuilder = DoubleValue.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        DoubleValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final DoubleValue copy(@l DoubleValue doubleValue, @l jn.l<? super DoubleValueKt.Dsl, l2> lVar) {
        l0.p(doubleValue, "<this>");
        l0.p(lVar, "block");
        DoubleValueKt.Dsl.Companion companion = DoubleValueKt.Dsl.Companion;
        DoubleValue.Builder builder = doubleValue.toBuilder();
        l0.o(builder, "this.toBuilder()");
        DoubleValueKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
