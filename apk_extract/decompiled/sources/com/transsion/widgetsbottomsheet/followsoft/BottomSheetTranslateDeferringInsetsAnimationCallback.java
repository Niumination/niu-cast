package com.transsion.widgetsbottomsheet.followsoft;

import android.content.res.Resources;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBottomSheetPanel;
import com.transsion.widgetslib.R$dimen;
import java.util.List;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetTranslateDeferringInsetsAnimationCallback extends WindowInsetsAnimationCompat.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f3037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OSBottomSheetPanel f3038d;
    public int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3039h;

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List list) {
        OSBottomSheetPanel oSBottomSheetPanel;
        Insets insets = windowInsetsCompat.getInsets(this.f3036b);
        Insets insets2 = windowInsetsCompat.getInsets(this.f3035a);
        Insets insetsOf = Insets.of(insets.left - insets2.left, insets.top - insets2.top, insets.right - insets2.right, insets.bottom - insets2.bottom);
        int i8 = insetsOf.left;
        Insets insets3 = Insets.NONE;
        Insets insetsOf2 = Insets.of(Math.max(i8, insets3.left), Math.max(insetsOf.top, insets3.top), Math.max(insetsOf.right, insets3.right), Math.max(insetsOf.bottom, insets3.bottom));
        float f = insetsOf2.left - insetsOf2.right;
        View view = this.f3037c;
        view.setTranslationX(f);
        int i9 = insetsOf2.top - insetsOf2.bottom;
        float fAbs = Math.abs(i9) > 300 ? 1.0f : Math.abs(i9) / 300.0f;
        if (j.t(view.getContext())) {
            Resources resources = view.getContext().getResources();
            int dimensionPixelSize = i9 != 0 ? (int) (i9 - ((resources.getDimensionPixelSize(R$dimen.os_bottom_sheet_large_screen_bottom_padding) + resources.getDimensionPixelSize(R$dimen.os_bottom_sheet_large_screen_soft_input)) * fAbs)) : 0;
            view.getContext();
            if (!j.f8768g || (oSBottomSheetPanel = this.f3038d) == null) {
                view.setTranslationY(dimensionPixelSize);
            } else {
                int[] iArr = new int[2];
                oSBottomSheetPanel.getLocationOnScreen(iArr);
                int iL = iArr[1] - j.l(view.getContext());
                if (!this.f3039h) {
                    this.e = iL;
                    this.f3039h = true;
                }
                if (((j.i(view.getContext()) - iArr[1]) - oSBottomSheetPanel.getHeight()) - Math.abs(dimensionPixelSize) <= 0 || view.getTranslationY() != 0.0f) {
                    int iAbs = Math.abs(dimensionPixelSize);
                    int i10 = this.e;
                    if (iAbs < i10) {
                        view.setTranslationY(dimensionPixelSize);
                    } else if (iL != 0) {
                        view.setTranslationY(-i10);
                    }
                }
            }
            OSBottomSheetPanel oSBottomSheetPanel2 = this.f3038d;
            if (oSBottomSheetPanel2 != null && oSBottomSheetPanel2.getSoftKeyboardHeight() != Math.abs(dimensionPixelSize)) {
                oSBottomSheetPanel2.setSoftKeyboardHeight(Math.abs(dimensionPixelSize));
                oSBottomSheetPanel2.requestLayout();
            }
        } else {
            view.setTranslationY(i9);
            OSBottomSheetPanel oSBottomSheetPanel3 = this.f3038d;
            if (oSBottomSheetPanel3 != null && oSBottomSheetPanel3.getSoftKeyboardHeight() != Math.abs(i9)) {
                oSBottomSheetPanel3.setSoftKeyboardHeight(Math.abs(i9));
                oSBottomSheetPanel3.requestLayout();
            }
        }
        return windowInsetsCompat;
    }
}
