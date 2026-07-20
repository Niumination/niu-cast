package gd;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBindings;
import com.transsion.widgetsbottomsheet.R$id;
import com.transsion.widgetsbottomsheet.R$layout;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBSContainerFrameLayout;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBottomSheetContainer;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBottomSheetPanel;
import com.transsion.widgetsbottomsheet.bottomsheet.OSSmoothCornerLinearLayout;
import com.transsion.widgetsbottomsheet.databinding.OsBottomSheetContainerBinding;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Lambda implements Function0 {
    final /* synthetic */ OSBaseBottomSheetDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(OSBaseBottomSheetDialog oSBaseBottomSheetDialog) {
        super(0);
        this.this$0 = oSBaseBottomSheetDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public final OsBottomSheetContainerBinding invoke() {
        View viewFindChildViewById;
        View viewInflate = this.this$0.getLayoutInflater().inflate(R$layout.os_bottom_sheet_container, (ViewGroup) null, false);
        OSBottomSheetContainer oSBottomSheetContainer = (OSBottomSheetContainer) viewInflate;
        int i8 = R$id.content_bg_drawable;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, i8);
        if (relativeLayout != null) {
            i8 = R$id.content_visible;
            OSSmoothCornerLinearLayout oSSmoothCornerLinearLayout = (OSSmoothCornerLinearLayout) ViewBindings.findChildViewById(viewInflate, i8);
            if (oSSmoothCornerLinearLayout != null) {
                i8 = R$id.drag_handler;
                if (((ImageView) ViewBindings.findChildViewById(viewInflate, i8)) != null) {
                    i8 = R$id.drag_panel;
                    OSBottomSheetPanel oSBottomSheetPanel = (OSBottomSheetPanel) ViewBindings.findChildViewById(viewInflate, i8);
                    if (oSBottomSheetPanel != null) {
                        i8 = R$id.drag_rect;
                        if (((FrameLayout) ViewBindings.findChildViewById(viewInflate, i8)) != null) {
                            i8 = R$id.panel_content;
                            OSBSContainerFrameLayout oSBSContainerFrameLayout = (OSBSContainerFrameLayout) ViewBindings.findChildViewById(viewInflate, i8);
                            if (oSBSContainerFrameLayout != null && (viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, (i8 = R$id.pull_rect))) != null) {
                                i8 = R$id.touch_outside;
                                if (ViewBindings.findChildViewById(viewInflate, i8) != null) {
                                    OsBottomSheetContainerBinding osBottomSheetContainerBinding = new OsBottomSheetContainerBinding(oSBottomSheetContainer, relativeLayout, oSSmoothCornerLinearLayout, oSBottomSheetPanel, oSBSContainerFrameLayout, viewFindChildViewById);
                                    Intrinsics.checkNotNullExpressionValue(osBottomSheetContainerBinding, "inflate(\n               …          false\n        )");
                                    return osBottomSheetContainerBinding;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i8)));
    }
}
