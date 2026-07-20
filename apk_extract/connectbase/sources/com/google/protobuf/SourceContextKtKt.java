package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nSourceContextKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SourceContextKt.kt\ncom/google/protobuf/SourceContextKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class SourceContextKtKt {
    @i(name = "-initializesourceContext")
    @l
    /* JADX INFO: renamed from: -initializesourceContext, reason: not valid java name */
    public static final SourceContext m35initializesourceContext(@l jn.l<? super SourceContextKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        SourceContextKt.Dsl.Companion companion = SourceContextKt.Dsl.Companion;
        SourceContext.Builder builderNewBuilder = SourceContext.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        SourceContextKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final SourceContext copy(@l SourceContext sourceContext, @l jn.l<? super SourceContextKt.Dsl, l2> lVar) {
        l0.p(sourceContext, "<this>");
        l0.p(lVar, "block");
        SourceContextKt.Dsl.Companion companion = SourceContextKt.Dsl.Companion;
        SourceContext.Builder builder = sourceContext.toBuilder();
        l0.o(builder, "this.toBuilder()");
        SourceContextKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
