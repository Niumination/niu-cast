package com.google.protobuf;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u000f\u001a)\u0010\u0010\u001a\u00020\t*\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0086\bø\u0001\u0000\u001a)\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0086\bø\u0001\u0000\u001a)\u0010\u0010\u001a\u00020\u0013*\u00020\u00132\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0005*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"optionsOrNull", "Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions;", "Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder;", "getOptionsOrNull", "(Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder;)Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions;", "Lcom/google/protobuf/DescriptorProtos$MessageOptions;", "Lcom/google/protobuf/DescriptorProtos$DescriptorProtoOrBuilder;", "(Lcom/google/protobuf/DescriptorProtos$DescriptorProtoOrBuilder;)Lcom/google/protobuf/DescriptorProtos$MessageOptions;", "descriptorProto", "Lcom/google/protobuf/DescriptorProtos$DescriptorProto;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/DescriptorProtoKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializedescriptorProto", "copy", "Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange;", "Lcom/google/protobuf/DescriptorProtoKt$ExtensionRangeKt$Dsl;", "Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ReservedRange;", "Lcom/google/protobuf/DescriptorProtoKt$ReservedRangeKt$Dsl;", "java_kotlin-well_known_protos_kotlin"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nDescriptorProtoKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DescriptorProtoKt.kt\ncom/google/protobuf/DescriptorProtoKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,841:1\n1#2:842\n*E\n"})
public final class DescriptorProtoKtKt {
    @JvmName(name = "-initializedescriptorProto")
    /* JADX INFO: renamed from: -initializedescriptorProto, reason: not valid java name */
    public static final DescriptorProtos.DescriptorProto m63initializedescriptorProto(Function1<? super DescriptorProtoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        DescriptorProtoKt.Dsl.Companion companion = DescriptorProtoKt.Dsl.INSTANCE;
        DescriptorProtos.DescriptorProto.Builder builderNewBuilder = DescriptorProtos.DescriptorProto.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        DescriptorProtoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.DescriptorProto copy(DescriptorProtos.DescriptorProto descriptorProto, Function1<? super DescriptorProtoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(descriptorProto, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        DescriptorProtoKt.Dsl.Companion companion = DescriptorProtoKt.Dsl.INSTANCE;
        DescriptorProtos.DescriptorProto.Builder builder = descriptorProto.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        DescriptorProtoKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final DescriptorProtos.ExtensionRangeOptions getOptionsOrNull(DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder extensionRangeOrBuilder) {
        Intrinsics.checkNotNullParameter(extensionRangeOrBuilder, "<this>");
        if (extensionRangeOrBuilder.hasOptions()) {
            return extensionRangeOrBuilder.getOptions();
        }
        return null;
    }

    public static final /* synthetic */ DescriptorProtos.DescriptorProto.ExtensionRange copy(DescriptorProtos.DescriptorProto.ExtensionRange extensionRange, Function1<? super DescriptorProtoKt.ExtensionRangeKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(extensionRange, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        DescriptorProtoKt.ExtensionRangeKt.Dsl.Companion companion = DescriptorProtoKt.ExtensionRangeKt.Dsl.INSTANCE;
        DescriptorProtos.DescriptorProto.ExtensionRange.Builder builder = extensionRange.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        DescriptorProtoKt.ExtensionRangeKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final DescriptorProtos.MessageOptions getOptionsOrNull(DescriptorProtos.DescriptorProtoOrBuilder descriptorProtoOrBuilder) {
        Intrinsics.checkNotNullParameter(descriptorProtoOrBuilder, "<this>");
        if (descriptorProtoOrBuilder.hasOptions()) {
            return descriptorProtoOrBuilder.getOptions();
        }
        return null;
    }

    public static final /* synthetic */ DescriptorProtos.DescriptorProto.ReservedRange copy(DescriptorProtos.DescriptorProto.ReservedRange reservedRange, Function1<? super DescriptorProtoKt.ReservedRangeKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(reservedRange, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        DescriptorProtoKt.ReservedRangeKt.Dsl.Companion companion = DescriptorProtoKt.ReservedRangeKt.Dsl.INSTANCE;
        DescriptorProtos.DescriptorProto.ReservedRange.Builder builder = reservedRange.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        DescriptorProtoKt.ReservedRangeKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
