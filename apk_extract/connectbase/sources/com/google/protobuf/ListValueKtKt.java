package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nListValueKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListValueKt.kt\ncom/google/protobuf/ListValueKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,105:1\n1#2:106\n*E\n"})
public final class ListValueKtKt {
    @i(name = "-initializelistValue")
    @l
    /* JADX INFO: renamed from: -initializelistValue, reason: not valid java name */
    public static final ListValue m31initializelistValue(@l jn.l<? super ListValueKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        ListValueKt.Dsl.Companion companion = ListValueKt.Dsl.Companion;
        ListValue.Builder builderNewBuilder = ListValue.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        ListValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final ListValue copy(@l ListValue listValue, @l jn.l<? super ListValueKt.Dsl, l2> lVar) {
        l0.p(listValue, "<this>");
        l0.p(lVar, "block");
        ListValueKt.Dsl.Companion companion = ListValueKt.Dsl.Companion;
        ListValue.Builder builder = listValue.toBuilder();
        l0.o(builder, "this.toBuilder()");
        ListValueKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
