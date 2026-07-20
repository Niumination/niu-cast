package com.transsion.widgetsbottomsheet.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBSContainerFrameLayout;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBottomSheetContainer;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBottomSheetPanel;
import com.transsion.widgetsbottomsheet.bottomsheet.OSSmoothCornerLinearLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class OsBottomSheetContainerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OSBottomSheetContainer f3024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelativeLayout f3025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OSSmoothCornerLinearLayout f3026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OSBottomSheetPanel f3027d;
    public final OSBSContainerFrameLayout e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f3028h;

    public OsBottomSheetContainerBinding(OSBottomSheetContainer oSBottomSheetContainer, RelativeLayout relativeLayout, OSSmoothCornerLinearLayout oSSmoothCornerLinearLayout, OSBottomSheetPanel oSBottomSheetPanel, OSBSContainerFrameLayout oSBSContainerFrameLayout, View view) {
        this.f3024a = oSBottomSheetContainer;
        this.f3025b = relativeLayout;
        this.f3026c = oSSmoothCornerLinearLayout;
        this.f3027d = oSBottomSheetPanel;
        this.e = oSBSContainerFrameLayout;
        this.f3028h = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f3024a;
    }
}
