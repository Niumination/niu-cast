package com.transsion.iotservice.iotcard.proto;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"iotcardListMap", "Lcom/transsion/iotservice/iotcard/proto/IotcardListMap;", "block", "Lkotlin/Function1;", "Lcom/transsion/iotservice/iotcard/proto/IotcardListMapKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeiotcardListMap", "copy", "iotcardprotoco_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nIotcardListMapKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IotcardListMapKt.kt\ncom/transsion/iotservice/iotcard/proto/IotcardListMapKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,95:1\n1#2:96\n*E\n"})
public final class IotcardListMapKtKt {
    @JvmName(name = "-initializeiotcardListMap")
    /* JADX INFO: renamed from: -initializeiotcardListMap, reason: not valid java name */
    public static final IotcardListMap m135initializeiotcardListMap(Function1<? super IotcardListMapKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        IotcardListMapKt.Dsl.Companion companion = IotcardListMapKt.Dsl.INSTANCE;
        IotcardListMap.Builder builderNewBuilder = IotcardListMap.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        IotcardListMapKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final IotcardListMap copy(IotcardListMap iotcardListMap, Function1<? super IotcardListMapKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(iotcardListMap, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        IotcardListMapKt.Dsl.Companion companion = IotcardListMapKt.Dsl.INSTANCE;
        IotcardListMap.Builder builder = iotcardListMap.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        IotcardListMapKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
