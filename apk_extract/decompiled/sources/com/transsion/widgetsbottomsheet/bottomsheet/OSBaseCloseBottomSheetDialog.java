package com.transsion.widgetsbottomsheet.bottomsheet;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import ce.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/widgetsbottomsheet/bottomsheet/OSBaseCloseBottomSheetDialog;", "Lcom/transsion/widgetsbottomsheet/bottomsheet/OSBaseBottomSheetDialog;", "<init>", "()V", "widgetsbottomsheet_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public abstract class OSBaseCloseBottomSheetDialog extends OSBaseBottomSheetDialog {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f2991j = 0;

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final OSPageView j(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        OSPageView oSPageViewJ = super.j(view);
        oSPageViewJ.d(new a(this, 2));
        return oSPageViewJ;
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final boolean m() {
        return false;
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final boolean p() {
        return false;
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final void q() {
        s(false);
        t(false);
    }
}
