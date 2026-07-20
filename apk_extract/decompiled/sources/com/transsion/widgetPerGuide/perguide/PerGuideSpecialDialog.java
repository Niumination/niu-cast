package com.transsion.widgetPerGuide.perguide;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetPerGuide.R$color;
import com.transsion.widgetPerGuide.R$layout;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBottomSheetPanel;
import ed.k;
import ed.l;
import ed.m;
import ed.n;
import ed.o;
import hd.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pd.d;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/transsion/widgetPerGuide/perguide/PerGuideSpecialDialog;", "Landroid/view/View$OnClickListener;", "Lcom/transsion/widgetPerGuide/perguide/PerGuideBaseDialog;", "<init>", "()V", "widgetPerGuide_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public class PerGuideSpecialDialog extends PerGuideBaseDialog implements View.OnClickListener {
    public final Lazy p = LazyKt.lazy(new k(this));
    public final Lazy q = LazyKt.lazy(new n(this));

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f2981r = LazyKt.lazy(new o(this));

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f2982s = LazyKt.lazy(new l(this));

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f2983t = LazyKt.lazy(new m(this));

    public final LinearLayout A() {
        Object value = this.f2983t.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mLlBtnContainer>(...)");
        return (LinearLayout) value;
    }

    @Override // com.transsion.widgetPerGuide.perguide.PerGuideBaseDialog, androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        Resources resources = super.getResources();
        d.e(resources, this);
        return resources;
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final int l() {
        return getColor(R$color.os_open_bg_hios);
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final int n() {
        return j.s() ? R$layout.os_ultra_small_dialog_perguide_special_layout : R$layout.os_dialog_perguide_special_layout;
    }

    @Override // com.transsion.widgetPerGuide.perguide.PerGuideBaseDialog, com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final void q() {
        int iA;
        super.q();
        Lazy lazy = this.p;
        Object value = lazy.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mImgSpecialIcon>(...)");
        ((ImageView) value).setVisibility(0);
        if (j.y(getWindow())) {
            Object value2 = lazy.getValue();
            Intrinsics.checkNotNullExpressionValue(value2, "<get-mImgSpecialIcon>(...)");
            ((ImageView) value2).setVisibility(0);
        } else {
            Object value3 = lazy.getValue();
            Intrinsics.checkNotNullExpressionValue(value3, "<get-mImgSpecialIcon>(...)");
            ((ImageView) value3).setVisibility(8);
        }
        boolean zQ = j.q(this);
        boolean zS = j.s();
        if (zQ) {
            iA = a.a(this, 32);
        } else {
            iA = zS ? a.a(this, 0) : a.a(this, 20);
        }
        A().setPadding(A().getPaddingLeft(), A().getPaddingTop(), A().getPaddingRight(), iA);
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final void r() {
        OSBottomSheetPanel oSBottomSheetPanel = o().f3027d;
        Intrinsics.checkNotNullExpressionValue(oSBottomSheetPanel, "mContainerViewBinding.dragPanel");
        oSBottomSheetPanel.setBackgroundFillColor(getColor(R$color.os_open_bg_hios));
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final boolean u() {
        return false;
    }
}
