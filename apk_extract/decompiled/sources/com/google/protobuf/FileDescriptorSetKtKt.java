package com.google.protobuf;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"fileDescriptorSet", "Lcom/google/protobuf/DescriptorProtos$FileDescriptorSet;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/FileDescriptorSetKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializefileDescriptorSet", "copy", "java_kotlin-well_known_protos_kotlin"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nFileDescriptorSetKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileDescriptorSetKt.kt\ncom/google/protobuf/FileDescriptorSetKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,107:1\n1#2:108\n*E\n"})
public final class FileDescriptorSetKtKt {
    @JvmName(name = "-initializefileDescriptorSet")
    /* JADX INFO: renamed from: -initializefileDescriptorSet, reason: not valid java name */
    public static final DescriptorProtos.FileDescriptorSet m91initializefileDescriptorSet(Function1<? super FileDescriptorSetKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FileDescriptorSetKt.Dsl.Companion companion = FileDescriptorSetKt.Dsl.INSTANCE;
        DescriptorProtos.FileDescriptorSet.Builder builderNewBuilder = DescriptorProtos.FileDescriptorSet.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        FileDescriptorSetKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final /* synthetic */ DescriptorProtos.FileDescriptorSet copy(DescriptorProtos.FileDescriptorSet fileDescriptorSet, Function1<? super FileDescriptorSetKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(fileDescriptorSet, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        FileDescriptorSetKt.Dsl.Companion companion = FileDescriptorSetKt.Dsl.INSTANCE;
        DescriptorProtos.FileDescriptorSet.Builder builder = fileDescriptorSet.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        FileDescriptorSetKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
