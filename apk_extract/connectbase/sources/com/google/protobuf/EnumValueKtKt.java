package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nEnumValueKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EnumValueKt.kt\ncom/google/protobuf/EnumValueKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,139:1\n1#2:140\n*E\n"})
public final class EnumValueKtKt {
    @i(name = "-initializeenumValue")
    @l
    /* JADX INFO: renamed from: -initializeenumValue, reason: not valid java name */
    public static final EnumValue m24initializeenumValue(@l jn.l<? super EnumValueKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        EnumValueKt.Dsl.Companion companion = EnumValueKt.Dsl.Companion;
        EnumValue.Builder builderNewBuilder = EnumValue.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        EnumValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final EnumValue copy(@l EnumValue enumValue, @l jn.l<? super EnumValueKt.Dsl, l2> lVar) {
        l0.p(enumValue, "<this>");
        l0.p(lVar, "block");
        EnumValueKt.Dsl.Companion companion = EnumValueKt.Dsl.Companion;
        EnumValue.Builder builder = enumValue.toBuilder();
        l0.o(builder, "this.toBuilder()");
        EnumValueKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
