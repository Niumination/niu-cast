package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nFieldKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FieldKt.kt\ncom/google/protobuf/FieldKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,272:1\n1#2:273\n*E\n"})
public final class FieldKtKt {
    @i(name = "-initializefield")
    @l
    /* JADX INFO: renamed from: -initializefield, reason: not valid java name */
    public static final Field m25initializefield(@l jn.l<? super FieldKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        FieldKt.Dsl.Companion companion = FieldKt.Dsl.Companion;
        Field.Builder builderNewBuilder = Field.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        FieldKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final Field copy(@l Field field, @l jn.l<? super FieldKt.Dsl, l2> lVar) {
        l0.p(field, "<this>");
        l0.p(lVar, "block");
        FieldKt.Dsl.Companion companion = FieldKt.Dsl.Companion;
        Field.Builder builder = field.toBuilder();
        l0.o(builder, "this.toBuilder()");
        FieldKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
