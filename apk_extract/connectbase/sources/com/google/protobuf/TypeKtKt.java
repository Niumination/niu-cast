package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nTypeKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeKt.kt\ncom/google/protobuf/TypeKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,333:1\n1#2:334\n*E\n"})
public final class TypeKtKt {
    @i(name = "-initializetype")
    @l
    /* JADX INFO: renamed from: -initializetype, reason: not valid java name */
    public static final Type m39initializetype(@l jn.l<? super TypeKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        TypeKt.Dsl.Companion companion = TypeKt.Dsl.Companion;
        Type.Builder builderNewBuilder = Type.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        TypeKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final Type copy(@l Type type, @l jn.l<? super TypeKt.Dsl, l2> lVar) {
        l0.p(type, "<this>");
        l0.p(lVar, "block");
        TypeKt.Dsl.Companion companion = TypeKt.Dsl.Companion;
        Type.Builder builder = type.toBuilder();
        l0.o(builder, "this.toBuilder()");
        TypeKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @m
    public static final SourceContext getSourceContextOrNull(@l TypeOrBuilder typeOrBuilder) {
        l0.p(typeOrBuilder, "<this>");
        if (typeOrBuilder.hasSourceContext()) {
            return typeOrBuilder.getSourceContext();
        }
        return null;
    }
}
