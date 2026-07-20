package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nFieldMaskKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FieldMaskKt.kt\ncom/google/protobuf/FieldMaskKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,104:1\n1#2:105\n*E\n"})
public final class FieldMaskKtKt {
    @i(name = "-initializefieldMask")
    @l
    /* JADX INFO: renamed from: -initializefieldMask, reason: not valid java name */
    public static final FieldMask m26initializefieldMask(@l jn.l<? super FieldMaskKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        FieldMaskKt.Dsl.Companion companion = FieldMaskKt.Dsl.Companion;
        FieldMask.Builder builderNewBuilder = FieldMask.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        FieldMaskKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final FieldMask copy(@l FieldMask fieldMask, @l jn.l<? super FieldMaskKt.Dsl, l2> lVar) {
        l0.p(fieldMask, "<this>");
        l0.p(lVar, "block");
        FieldMaskKt.Dsl.Companion companion = FieldMaskKt.Dsl.Companion;
        FieldMask.Builder builder = fieldMask.toBuilder();
        l0.o(builder, "this.toBuilder()");
        FieldMaskKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
