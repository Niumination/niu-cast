package com.google.protobuf;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0002\b\f\u001a)\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"featuresOrNull", "Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "Lcom/google/protobuf/DescriptorProtos$EnumValueOptionsOrBuilder;", "getFeaturesOrNull", "(Lcom/google/protobuf/DescriptorProtos$EnumValueOptionsOrBuilder;)Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "enumValueOptions", "Lcom/google/protobuf/DescriptorProtos$EnumValueOptions;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/EnumValueOptionsKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeenumValueOptions", "copy", "java_kotlin-well_known_protos_kotlin"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nEnumValueOptionsKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EnumValueOptionsKt.kt\ncom/google/protobuf/EnumValueOptionsKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,280:1\n1#2:281\n*E\n"})
public final class EnumValueOptionsKtKt {
    @JvmName(name = "-initializeenumValueOptions")
    /* JADX INFO: renamed from: -initializeenumValueOptions, reason: not valid java name */
    public static final DescriptorProtos.EnumValueOptions m75initializeenumValueOptions(Function1<? super EnumValueOptionsKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        EnumValueOptionsKt.Dsl.Companion companion = EnumValueOptionsKt.Dsl.INSTANCE;
        DescriptorProtos.EnumValueOptions.Builder builderNewBuilder = DescriptorProtos.EnumValueOptions.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        EnumValueOptionsKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.EnumValueOptions copy(DescriptorProtos.EnumValueOptions enumValueOptions, Function1<? super EnumValueOptionsKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(enumValueOptions, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        EnumValueOptionsKt.Dsl.Companion companion = EnumValueOptionsKt.Dsl.INSTANCE;
        DescriptorProtos.EnumValueOptions.Builder builder = enumValueOptions.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        EnumValueOptionsKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final DescriptorProtos.FeatureSet getFeaturesOrNull(DescriptorProtos.EnumValueOptionsOrBuilder enumValueOptionsOrBuilder) {
        Intrinsics.checkNotNullParameter(enumValueOptionsOrBuilder, "<this>");
        if (enumValueOptionsOrBuilder.hasFeatures()) {
            return enumValueOptionsOrBuilder.getFeatures();
        }
        return null;
    }
}
