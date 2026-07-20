package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nOptionKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OptionKt.kt\ncom/google/protobuf/OptionKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,80:1\n1#2:81\n*E\n"})
public final class OptionKtKt {
    @i(name = "-initializeoption")
    @l
    /* JADX INFO: renamed from: -initializeoption, reason: not valid java name */
    public static final Option m34initializeoption(@l jn.l<? super OptionKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        OptionKt.Dsl.Companion companion = OptionKt.Dsl.Companion;
        Option.Builder builderNewBuilder = Option.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        OptionKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final Option copy(@l Option option, @l jn.l<? super OptionKt.Dsl, l2> lVar) {
        l0.p(option, "<this>");
        l0.p(lVar, "block");
        OptionKt.Dsl.Companion companion = OptionKt.Dsl.Companion;
        Option.Builder builder = option.toBuilder();
        l0.o(builder, "this.toBuilder()");
        OptionKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @m
    public static final Any getValueOrNull(@l OptionOrBuilder optionOrBuilder) {
        l0.p(optionOrBuilder, "<this>");
        if (optionOrBuilder.hasValue()) {
            return optionOrBuilder.getValue();
        }
        return null;
    }
}
