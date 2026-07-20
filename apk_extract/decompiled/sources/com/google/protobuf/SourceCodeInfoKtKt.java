package com.google.protobuf;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001a)\u0010\b\u001a\u00020\t*\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"sourceCodeInfo", "Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/SourceCodeInfoKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializesourceCodeInfo", "copy", "Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo$Location;", "Lcom/google/protobuf/SourceCodeInfoKt$LocationKt$Dsl;", "java_kotlin-well_known_protos_kotlin"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nSourceCodeInfoKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SourceCodeInfoKt.kt\ncom/google/protobuf/SourceCodeInfoKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,382:1\n1#2:383\n*E\n"})
public final class SourceCodeInfoKtKt {
    @JvmName(name = "-initializesourceCodeInfo")
    /* JADX INFO: renamed from: -initializesourceCodeInfo, reason: not valid java name */
    public static final DescriptorProtos.SourceCodeInfo m115initializesourceCodeInfo(Function1<? super SourceCodeInfoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SourceCodeInfoKt.Dsl.Companion companion = SourceCodeInfoKt.Dsl.INSTANCE;
        DescriptorProtos.SourceCodeInfo.Builder builderNewBuilder = DescriptorProtos.SourceCodeInfo.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        SourceCodeInfoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.SourceCodeInfo copy(DescriptorProtos.SourceCodeInfo sourceCodeInfo, Function1<? super SourceCodeInfoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(sourceCodeInfo, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        SourceCodeInfoKt.Dsl.Companion companion = SourceCodeInfoKt.Dsl.INSTANCE;
        DescriptorProtos.SourceCodeInfo.Builder builder = sourceCodeInfo.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        SourceCodeInfoKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.SourceCodeInfo.Location copy(DescriptorProtos.SourceCodeInfo.Location location, Function1<? super SourceCodeInfoKt.LocationKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(location, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        SourceCodeInfoKt.LocationKt.Dsl.Companion companion = SourceCodeInfoKt.LocationKt.Dsl.INSTANCE;
        DescriptorProtos.SourceCodeInfo.Location.Builder builder = location.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        SourceCodeInfoKt.LocationKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
