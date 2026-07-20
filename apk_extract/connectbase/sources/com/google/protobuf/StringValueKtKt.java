package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nStringValueKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringValueKt.kt\ncom/google/protobuf/StringValueKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class StringValueKtKt {
    @i(name = "-initializestringValue")
    @l
    /* JADX INFO: renamed from: -initializestringValue, reason: not valid java name */
    public static final StringValue m36initializestringValue(@l jn.l<? super StringValueKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        StringValueKt.Dsl.Companion companion = StringValueKt.Dsl.Companion;
        StringValue.Builder builderNewBuilder = StringValue.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        StringValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final StringValue copy(@l StringValue stringValue, @l jn.l<? super StringValueKt.Dsl, l2> lVar) {
        l0.p(stringValue, "<this>");
        l0.p(lVar, "block");
        StringValueKt.Dsl.Companion companion = StringValueKt.Dsl.Companion;
        StringValue.Builder builder = stringValue.toBuilder();
        l0.o(builder, "this.toBuilder()");
        StringValueKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
