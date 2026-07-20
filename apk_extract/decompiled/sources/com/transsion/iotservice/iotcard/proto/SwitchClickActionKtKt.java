package com.transsion.iotservice.iotcard.proto;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"switchClickAction", "Lcom/transsion/iotservice/iotcard/proto/SwitchClickAction;", "block", "Lkotlin/Function1;", "Lcom/transsion/iotservice/iotcard/proto/SwitchClickActionKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeswitchClickAction", "copy", "iotcardprotoco_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nSwitchClickActionKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SwitchClickActionKt.kt\ncom/transsion/iotservice/iotcard/proto/SwitchClickActionKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,102:1\n1#2:103\n*E\n"})
public final class SwitchClickActionKtKt {
    @JvmName(name = "-initializeswitchClickAction")
    /* JADX INFO: renamed from: -initializeswitchClickAction, reason: not valid java name */
    public static final SwitchClickAction m138initializeswitchClickAction(Function1<? super SwitchClickActionKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SwitchClickActionKt.Dsl.Companion companion = SwitchClickActionKt.Dsl.INSTANCE;
        SwitchClickAction.Builder builderNewBuilder = SwitchClickAction.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        SwitchClickActionKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final SwitchClickAction copy(SwitchClickAction switchClickAction, Function1<? super SwitchClickActionKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(switchClickAction, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        SwitchClickActionKt.Dsl.Companion companion = SwitchClickActionKt.Dsl.INSTANCE;
        SwitchClickAction.Builder builder = switchClickAction.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        SwitchClickActionKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
