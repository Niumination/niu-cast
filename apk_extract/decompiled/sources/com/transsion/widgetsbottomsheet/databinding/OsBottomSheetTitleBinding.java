package com.transsion.widgetsbottomsheet.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.transsion.widgetsliquid.view.OSLiquidButton;
import com.transsion.widgetsliquid.view.OSLiquidTextButton;

/* JADX INFO: loaded from: classes2.dex */
public final class OsBottomSheetTitleBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f3029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OSLiquidTextButton f3030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OSLiquidTextButton f3031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OSLiquidButton f3032d;
    public final OSLiquidButton e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f3033h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f3034i;

    public OsBottomSheetTitleBinding(LinearLayout linearLayout, OSLiquidTextButton oSLiquidTextButton, OSLiquidTextButton oSLiquidTextButton2, OSLiquidButton oSLiquidButton, OSLiquidButton oSLiquidButton2, TextView textView, TextView textView2) {
        this.f3029a = linearLayout;
        this.f3030b = oSLiquidTextButton;
        this.f3031c = oSLiquidTextButton2;
        this.f3032d = oSLiquidButton;
        this.e = oSLiquidButton2;
        this.f3033h = textView;
        this.f3034i = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f3029a;
    }
}
