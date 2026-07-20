package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nValueKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValueKt.kt\ncom/google/protobuf/ValueKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,198:1\n1#2:199\n*E\n"})
public final class ValueKtKt {
    @i(name = "-initializevalue")
    @l
    /* JADX INFO: renamed from: -initializevalue, reason: not valid java name */
    public static final Value m42initializevalue(@l jn.l<? super ValueKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        ValueKt.Dsl.Companion companion = ValueKt.Dsl.Companion;
        Value.Builder builderNewBuilder = Value.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        ValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final Value copy(@l Value value, @l jn.l<? super ValueKt.Dsl, l2> lVar) {
        l0.p(value, "<this>");
        l0.p(lVar, "block");
        ValueKt.Dsl.Companion companion = ValueKt.Dsl.Companion;
        Value.Builder builder = value.toBuilder();
        l0.o(builder, "this.toBuilder()");
        ValueKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @m
    public static final ListValue getListValueOrNull(@l ValueOrBuilder valueOrBuilder) {
        l0.p(valueOrBuilder, "<this>");
        if (valueOrBuilder.hasListValue()) {
            return valueOrBuilder.getListValue();
        }
        return null;
    }

    @m
    public static final Struct getStructValueOrNull(@l ValueOrBuilder valueOrBuilder) {
        l0.p(valueOrBuilder, "<this>");
        if (valueOrBuilder.hasStructValue()) {
            return valueOrBuilder.getStructValue();
        }
        return null;
    }
}
