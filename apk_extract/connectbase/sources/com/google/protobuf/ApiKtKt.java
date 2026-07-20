package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nApiKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ApiKt.kt\ncom/google/protobuf/ApiKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,334:1\n1#2:335\n*E\n"})
public final class ApiKtKt {
    @i(name = "-initializeapi")
    @l
    /* JADX INFO: renamed from: -initializeapi, reason: not valid java name */
    public static final Api m17initializeapi(@l jn.l<? super ApiKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        ApiKt.Dsl.Companion companion = ApiKt.Dsl.Companion;
        Api.Builder builderNewBuilder = Api.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        ApiKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final Api copy(@l Api api, @l jn.l<? super ApiKt.Dsl, l2> lVar) {
        l0.p(api, "<this>");
        l0.p(lVar, "block");
        ApiKt.Dsl.Companion companion = ApiKt.Dsl.Companion;
        Api.Builder builder = api.toBuilder();
        l0.o(builder, "this.toBuilder()");
        ApiKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @m
    public static final SourceContext getSourceContextOrNull(@l ApiOrBuilder apiOrBuilder) {
        l0.p(apiOrBuilder, "<this>");
        if (apiOrBuilder.hasSourceContext()) {
            return apiOrBuilder.getSourceContext();
        }
        return null;
    }
}
