package com.google.protobuf;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0002\b\f\u001a)\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a)\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"featuresOrNull", "Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "Lcom/google/protobuf/DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefaultOrBuilder;", "getFeaturesOrNull", "(Lcom/google/protobuf/DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefaultOrBuilder;)Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "featureSetDefaults", "Lcom/google/protobuf/DescriptorProtos$FeatureSetDefaults;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/FeatureSetDefaultsKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializefeatureSetDefaults", "copy", "Lcom/google/protobuf/DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault;", "Lcom/google/protobuf/FeatureSetDefaultsKt$FeatureSetEditionDefaultKt$Dsl;", "java_kotlin-well_known_protos_kotlin"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nFeatureSetDefaultsKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeatureSetDefaultsKt.kt\ncom/google/protobuf/FeatureSetDefaultsKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,235:1\n1#2:236\n*E\n"})
public final class FeatureSetDefaultsKtKt {
    @JvmName(name = "-initializefeatureSetDefaults")
    /* JADX INFO: renamed from: -initializefeatureSetDefaults, reason: not valid java name */
    public static final DescriptorProtos.FeatureSetDefaults m80initializefeatureSetDefaults(Function1<? super FeatureSetDefaultsKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FeatureSetDefaultsKt.Dsl.Companion companion = FeatureSetDefaultsKt.Dsl.INSTANCE;
        DescriptorProtos.FeatureSetDefaults.Builder builderNewBuilder = DescriptorProtos.FeatureSetDefaults.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        FeatureSetDefaultsKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.FeatureSetDefaults copy(DescriptorProtos.FeatureSetDefaults featureSetDefaults, Function1<? super FeatureSetDefaultsKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(featureSetDefaults, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        FeatureSetDefaultsKt.Dsl.Companion companion = FeatureSetDefaultsKt.Dsl.INSTANCE;
        DescriptorProtos.FeatureSetDefaults.Builder builder = featureSetDefaults.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        FeatureSetDefaultsKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final DescriptorProtos.FeatureSet getFeaturesOrNull(DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefaultOrBuilder featureSetEditionDefaultOrBuilder) {
        Intrinsics.checkNotNullParameter(featureSetEditionDefaultOrBuilder, "<this>");
        if (featureSetEditionDefaultOrBuilder.hasFeatures()) {
            return featureSetEditionDefaultOrBuilder.getFeatures();
        }
        return null;
    }

    public static final /* synthetic */ DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault copy(DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault featureSetEditionDefault, Function1<? super FeatureSetDefaultsKt.FeatureSetEditionDefaultKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(featureSetEditionDefault, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        FeatureSetDefaultsKt.FeatureSetEditionDefaultKt.Dsl.Companion companion = FeatureSetDefaultsKt.FeatureSetEditionDefaultKt.Dsl.INSTANCE;
        DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault.Builder builder = featureSetEditionDefault.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        FeatureSetDefaultsKt.FeatureSetEditionDefaultKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
