package com.google.protobuf;

import in.i;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nMixinKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MixinKt.kt\ncom/google/protobuf/MixinKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,68:1\n1#2:69\n*E\n"})
public final class MixinKtKt {
    @i(name = "-initializemixin")
    @l
    /* JADX INFO: renamed from: -initializemixin, reason: not valid java name */
    public static final Mixin m33initializemixin(@l jn.l<? super MixinKt.Dsl, l2> lVar) {
        l0.p(lVar, "block");
        MixinKt.Dsl.Companion companion = MixinKt.Dsl.Companion;
        Mixin.Builder builderNewBuilder = Mixin.newBuilder();
        l0.o(builderNewBuilder, "newBuilder()");
        MixinKt.Dsl dsl_create = companion._create(builderNewBuilder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }

    @l
    public static final Mixin copy(@l Mixin mixin, @l jn.l<? super MixinKt.Dsl, l2> lVar) {
        l0.p(mixin, "<this>");
        l0.p(lVar, "block");
        MixinKt.Dsl.Companion companion = MixinKt.Dsl.Companion;
        Mixin.Builder builder = mixin.toBuilder();
        l0.o(builder, "this.toBuilder()");
        MixinKt.Dsl dsl_create = companion._create(builder);
        lVar.invoke(dsl_create);
        return dsl_create._build();
    }
}
