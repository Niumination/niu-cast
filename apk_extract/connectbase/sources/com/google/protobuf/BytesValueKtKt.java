package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nBytesValueKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BytesValueKt.kt\ncom/google/protobuf/BytesValueKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class BytesValueKtKt {
    @i(name = "-initializebytesValue")
    @l
    /* JADX INFO: renamed from: -initializebytesValue, reason: not valid java name */
    public static final BytesValue m19initializebytesValue(@l jn.l<? super BytesValueKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        BytesValueKt.Dsl.Companion companion = BytesValueKt.Dsl.Companion;
        BytesValue.Builder builderNewBuilder = BytesValue.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        BytesValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final BytesValue copy(@l BytesValue bytesValue, @l jn.l<? super BytesValueKt.Dsl, l2> lVar) {
        l0.p(bytesValue, "<this>");
        l0.p(lVar, "block");
        BytesValueKt.Dsl.Companion companion = BytesValueKt.Dsl.Companion;
        BytesValue.Builder builder = bytesValue.toBuilder();
        l0.o(builder, "this.toBuilder()");
        BytesValueKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
