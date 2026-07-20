package com.transsion.iotservice.iotcard.proto;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"iotcardList", "Lcom/transsion/iotservice/iotcard/proto/IotcardList;", "block", "Lkotlin/Function1;", "Lcom/transsion/iotservice/iotcard/proto/IotcardListKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeiotcardList", "copy", "iotcardprotoco_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nIotcardListKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IotcardListKt.kt\ncom/transsion/iotservice/iotcard/proto/IotcardListKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,105:1\n1#2:106\n*E\n"})
public final class IotcardListKtKt {
    @JvmName(name = "-initializeiotcardList")
    /* JADX INFO: renamed from: -initializeiotcardList, reason: not valid java name */
    public static final IotcardList m134initializeiotcardList(Function1<? super IotcardListKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        IotcardListKt.Dsl.Companion companion = IotcardListKt.Dsl.INSTANCE;
        IotcardList.Builder builderNewBuilder = IotcardList.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        IotcardListKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final IotcardList copy(IotcardList iotcardList, Function1<? super IotcardListKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(iotcardList, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        IotcardListKt.Dsl.Companion companion = IotcardListKt.Dsl.INSTANCE;
        IotcardList.Builder builder = iotcardList.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        IotcardListKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
