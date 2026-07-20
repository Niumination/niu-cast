package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nEnumKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EnumKt.kt\ncom/google/protobuf/EnumKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,263:1\n1#2:264\n*E\n"})
public final class EnumKtKt {
    @i(name = "-initializeenum")
    @l
    /* JADX INFO: renamed from: -initializeenum, reason: not valid java name */
    public static final Enum m23initializeenum(@l jn.l<? super EnumKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        EnumKt.Dsl.Companion companion = EnumKt.Dsl.Companion;
        Enum.Builder builderNewBuilder = Enum.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        EnumKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final Enum copy(@l Enum r10, @l jn.l<? super EnumKt.Dsl, l2> lVar) {
        l0.p(r10, "<this>");
        l0.p(lVar, "block");
        EnumKt.Dsl.Companion companion = EnumKt.Dsl.Companion;
        Enum.Builder builder = r10.toBuilder();
        l0.o(builder, "this.toBuilder()");
        EnumKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @m
    public static final SourceContext getSourceContextOrNull(@l EnumOrBuilder enumOrBuilder) {
        l0.p(enumOrBuilder, "<this>");
        if (enumOrBuilder.hasSourceContext()) {
            return enumOrBuilder.getSourceContext();
        }
        return null;
    }
}
