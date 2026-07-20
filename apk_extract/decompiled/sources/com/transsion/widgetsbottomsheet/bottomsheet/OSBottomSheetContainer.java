package com.transsion.widgetsbottomsheet.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import ce.a;
import com.transsion.widgetsbottomsheet.R$dimen;
import gd.d;
import gd.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/transsion/widgetsbottomsheet/bottomsheet/OSBottomSheetContainer;", "Landroid/widget/FrameLayout;", "", "canceledOnTouchOutside", "", "setCanceledOnTouchOutside", "(Z)V", "Lcom/transsion/widgetsbottomsheet/bottomsheet/OSBottomSheetPanel;", "b", "Lkotlin/Lazy;", "getMDragPanel", "()Lcom/transsion/widgetsbottomsheet/bottomsheet/OSBottomSheetPanel;", "mDragPanel", "Landroid/view/View;", "c", "getMOutsidePanel", "()Landroid/view/View;", "mOutsidePanel", "widgetsbottomsheet_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class OSBottomSheetContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Lazy mDragPanel;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Lazy mOutsidePanel;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSBottomSheetContainer(Context context) {
        this(context, null, 0, 14);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static void a(OSBottomSheetContainer this$0) {
        OSBaseBottomSheetDialog oSBaseBottomSheetDialog;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.f2992a || (oSBaseBottomSheetDialog = this$0.getMDragPanel().f2999h) == null) {
            return;
        }
        oSBaseBottomSheetDialog.k();
    }

    private final OSBottomSheetPanel getMDragPanel() {
        Object value = this.mDragPanel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mDragPanel>(...)");
        return (OSBottomSheetPanel) value;
    }

    private final View getMOutsidePanel() {
        Object value = this.mOutsidePanel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mOutsidePanel>(...)");
        return (View) value;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        getMDragPanel().setOutsideView(getMOutsidePanel());
        getMOutsidePanel().setOnClickListener(new a(this, 3));
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i8, int i9) {
        super.onMeasure(i8, View.MeasureSpec.makeMeasureSpec(getResources().getDimensionPixelSize(R$dimen.os_bottom_sheet_pull_rect) + View.MeasureSpec.getSize(i9), View.MeasureSpec.getMode(i9)));
    }

    public final void setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
        this.f2992a = canceledOnTouchOutside;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSBottomSheetContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 12);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSBottomSheetContainer(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 8);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public OSBottomSheetContainer(Context context, AttributeSet attributeSet, int i8, int i9) {
        attributeSet = (i9 & 2) != 0 ? null : attributeSet;
        i8 = (i9 & 4) != 0 ? 0 : i8;
        Intrinsics.checkNotNullParameter(context, "context");
        super(context, attributeSet, i8, 0);
        this.f2992a = true;
        this.mDragPanel = LazyKt.lazy(new d(this));
        this.mOutsidePanel = LazyKt.lazy(new e(this));
    }
}
