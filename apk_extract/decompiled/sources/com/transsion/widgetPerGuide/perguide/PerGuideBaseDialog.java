package com.transsion.widgetPerGuide.perguide;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.transsion.widgetPerGuide.R$color;
import com.transsion.widgetPerGuide.R$dimen;
import com.transsion.widgetPerGuide.R$id;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog;
import com.transsion.widgetslib.view.OSBigButton;
import com.transsion.widgetsliquid.view.OSLiquidBigButton;
import ed.b;
import ed.c;
import ed.d;
import hd.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/widgetPerGuide/perguide/PerGuideBaseDialog;", "Lcom/transsion/widgetsbottomsheet/bottomsheet/OSBaseBottomSheetDialog;", "Landroid/view/View$OnClickListener;", "", "<init>", "()V", "Landroid/view/View;", "v", "", "onClick", "(Landroid/view/View;)V", "widgetPerGuide_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nPerGuideBaseDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PerGuideBaseDialog.kt\ncom/transsion/widgetPerGuide/perguide/PerGuideBaseDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,290:1\n1#2:291\n*E\n"})
public abstract class PerGuideBaseDialog extends OSBaseBottomSheetDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OSBigButton f2970l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OSBigButton f2972n;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f2968j = LazyKt.lazy(new c(this));

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f2969k = LazyKt.lazy(new d(this));

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f2971m = LazyKt.lazy(new b(this));

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f2973o = true;

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "super.getResources()");
        pd.d.e(resources, this);
        return resources;
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final boolean m() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        int id2 = v3.getId();
        OSBigButton oSBigButton = this.f2970l;
        if (oSBigButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnNegative");
            oSBigButton = null;
        }
        int id3 = oSBigButton.getId();
        boolean z2 = this.f2973o;
        if (id2 == id3) {
            if (z2) {
                k();
            }
        } else if (id2 == y().getId() && z2) {
            k();
        }
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final boolean p() {
        return false;
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public void q() {
        int iA;
        s(false);
        t(false);
        View viewFindViewById = findViewById(R$id.btn_positive);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.btn_positive)");
        View viewFindViewById2 = findViewById(R$id.btn_negative);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.btn_negative)");
        OSBigButton osBigButton = ((OSLiquidBigButton) viewFindViewById2).getOsBigButton();
        Intrinsics.checkNotNullExpressionValue(osBigButton, "negativeBtn.getOsBigButton()");
        this.f2970l = osBigButton;
        OSBigButton osBigButton2 = ((OSLiquidBigButton) viewFindViewById).getOsBigButton();
        Intrinsics.checkNotNullExpressionValue(osBigButton2, "positiveBtn.getOsBigButton()");
        Intrinsics.checkNotNullParameter(osBigButton2, "<set-?>");
        this.f2972n = osBigButton2;
        OSBigButton oSBigButton = this.f2970l;
        OSBigButton oSBigButton2 = null;
        if (oSBigButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnNegative");
            oSBigButton = null;
        }
        oSBigButton.setOnClickListener(this);
        y().setOnClickListener(this);
        float dimension = getResources().getDimension(R$dimen.os_text_size_small);
        OSBigButton oSBigButton3 = this.f2970l;
        if (oSBigButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnNegative");
            oSBigButton3 = null;
        }
        oSBigButton3.setTextColor(ContextCompat.getColorStateList(this, R$color.os_platform_basic_color_selector));
        OSBigButton oSBigButton4 = this.f2970l;
        if (oSBigButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnNegative");
            oSBigButton4 = null;
        }
        oSBigButton4.setTextSize(0, dimension);
        y().setTextColor(ContextCompat.getColorStateList(this, R$color.os_button_on_color_selector));
        y().setTextSize(0, dimension);
        OSBigButton oSBigButton5 = this.f2970l;
        if (oSBigButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnNegative");
            oSBigButton5 = null;
        }
        ViewGroup.LayoutParams layoutParams = oSBigButton5.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = -1;
        }
        ViewGroup.LayoutParams layoutParams2 = y().getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = -1;
        }
        OSBigButton oSBigButton6 = this.f2970l;
        if (oSBigButton6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnNegative");
            oSBigButton6 = null;
        }
        if (oSBigButton6.getText() != null) {
            OSBigButton oSBigButton7 = this.f2970l;
            if (oSBigButton7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBtnNegative");
                oSBigButton7 = null;
            }
            OSBigButton oSBigButton8 = this.f2970l;
            if (oSBigButton8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBtnNegative");
                oSBigButton8 = null;
            }
            oSBigButton7.setText(j.E(oSBigButton8.getText().toString()));
        }
        if (y().getText() != null) {
            y().setText(j.E(y().getText().toString()));
        }
        if (j.z(this)) {
            LinearLayout linearLayoutZ = z();
            linearLayoutZ.setOrientation(1);
            if (linearLayoutZ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.LayoutParams layoutParams3 = linearLayoutZ.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams.topMargin = linearLayoutZ.getResources().getDimensionPixelSize(R$dimen.os_per_btn_layout_margin_ver_sh);
                marginLayoutParams.bottomMargin = linearLayoutZ.getResources().getDimensionPixelSize(R$dimen.os_per_btn_layout_margin_ver_sh);
                marginLayoutParams.setMarginStart(linearLayoutZ.getResources().getDimensionPixelSize(R$dimen.os_per_btn_layout_margin_hor_sh));
                marginLayoutParams.setMarginEnd(linearLayoutZ.getResources().getDimensionPixelSize(R$dimen.os_per_btn_layout_margin_hor_sh));
            }
            if (y().getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.LayoutParams layoutParams4 = y().getLayoutParams();
                Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams2.topMargin = getResources().getDimensionPixelSize(R$dimen.os_per_btn_space_sh);
                marginLayoutParams2.setMarginStart(0);
            }
            y().getLayoutParams().width = -1;
            OSBigButton oSBigButton9 = this.f2970l;
            if (oSBigButton9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBtnNegative");
            } else {
                oSBigButton2 = oSBigButton9;
            }
            oSBigButton2.getLayoutParams().width = -1;
        }
        boolean zQ = j.q(this);
        boolean zS = j.s();
        if (zQ) {
            iA = a.a(this, 32);
        } else {
            iA = zS ? a.a(this, 0) : a.a(this, 20);
        }
        z().setPadding(z().getPaddingLeft(), z().getPaddingTop(), z().getPaddingRight(), iA);
    }

    public final OSBigButton y() {
        OSBigButton oSBigButton = this.f2972n;
        if (oSBigButton != null) {
            return oSBigButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBtnPositive");
        return null;
    }

    public final LinearLayout z() {
        Object value = this.f2971m.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mLlBtnContainer>(...)");
        return (LinearLayout) value;
    }
}
