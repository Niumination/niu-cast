package com.google.protobuf;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0002\b\f\u001a)\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a)\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"featuresOrNull", "Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "Lcom/google/protobuf/DescriptorProtos$FieldOptionsOrBuilder;", "getFeaturesOrNull", "(Lcom/google/protobuf/DescriptorProtos$FieldOptionsOrBuilder;)Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "fieldOptions", "Lcom/google/protobuf/DescriptorProtos$FieldOptions;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/FieldOptionsKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializefieldOptions", "copy", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$EditionDefault;", "Lcom/google/protobuf/FieldOptionsKt$EditionDefaultKt$Dsl;", "java_kotlin-well_known_protos_kotlin"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nFieldOptionsKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FieldOptionsKt.kt\ncom/google/protobuf/FieldOptionsKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,660:1\n1#2:661\n*E\n"})
public final class FieldOptionsKtKt {
    @JvmName(name = "-initializefieldOptions")
    /* JADX INFO: renamed from: -initializefieldOptions, reason: not valid java name */
    public static final DescriptorProtos.FieldOptions m88initializefieldOptions(Function1<? super FieldOptionsKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FieldOptionsKt.Dsl.Companion companion = FieldOptionsKt.Dsl.INSTANCE;
        DescriptorProtos.FieldOptions.Builder builderNewBuilder = DescriptorProtos.FieldOptions.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        FieldOptionsKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.FieldOptions copy(DescriptorProtos.FieldOptions fieldOptions, Function1<? super FieldOptionsKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(fieldOptions, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        FieldOptionsKt.Dsl.Companion companion = FieldOptionsKt.Dsl.INSTANCE;
        DescriptorProtos.FieldOptions.Builder builder = fieldOptions.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        FieldOptionsKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final DescriptorProtos.FeatureSet getFeaturesOrNull(DescriptorProtos.FieldOptionsOrBuilder fieldOptionsOrBuilder) {
        Intrinsics.checkNotNullParameter(fieldOptionsOrBuilder, "<this>");
        if (fieldOptionsOrBuilder.hasFeatures()) {
            return fieldOptionsOrBuilder.getFeatures();
        }
        return null;
    }

    public static final /* synthetic */ DescriptorProtos.FieldOptions.EditionDefault copy(DescriptorProtos.FieldOptions.EditionDefault editionDefault, Function1<? super FieldOptionsKt.EditionDefaultKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(editionDefault, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        FieldOptionsKt.EditionDefaultKt.Dsl.Companion companion = FieldOptionsKt.EditionDefaultKt.Dsl.INSTANCE;
        DescriptorProtos.FieldOptions.EditionDefault.Builder builder = editionDefault.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        FieldOptionsKt.EditionDefaultKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
