package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nFloatValueKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatValueKt.kt\ncom/google/protobuf/FloatValueKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class FloatValueKtKt {
    @i(name = "-initializefloatValue")
    @l
    /* JADX INFO: renamed from: -initializefloatValue, reason: not valid java name */
    public static final FloatValue m28initializefloatValue(@l jn.l<? super FloatValueKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        FloatValueKt.Dsl.Companion companion = FloatValueKt.Dsl.Companion;
        FloatValue.Builder builderNewBuilder = FloatValue.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        FloatValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final FloatValue copy(@l FloatValue floatValue, @l jn.l<? super FloatValueKt.Dsl, l2> lVar) {
        l0.p(floatValue, "<this>");
        l0.p(lVar, "block");
        FloatValueKt.Dsl.Companion companion = FloatValueKt.Dsl.Companion;
        FloatValue.Builder builder = floatValue.toBuilder();
        l0.o(builder, "this.toBuilder()");
        FloatValueKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
