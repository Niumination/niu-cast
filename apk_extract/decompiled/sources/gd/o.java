package gd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.transsion.widgetsbottomsheet.R$id;
import com.transsion.widgetsbottomsheet.R$layout;
import com.transsion.widgetsbottomsheet.databinding.OsBottomSheetTitleBinding;
import com.transsion.widgetsliquid.view.OSLiquidButton;
import com.transsion.widgetsliquid.view.OSLiquidTextButton;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends Lambda implements Function0 {
    final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Context context) {
        super(0);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public final OsBottomSheetTitleBinding invoke() {
        View viewInflate = LayoutInflater.from(this.$context).inflate(R$layout.os_bottom_sheet_title, (ViewGroup) null, false);
        int i8 = R$id.button_left;
        OSLiquidTextButton oSLiquidTextButton = (OSLiquidTextButton) ViewBindings.findChildViewById(viewInflate, i8);
        if (oSLiquidTextButton != null) {
            i8 = R$id.button_right;
            OSLiquidTextButton oSLiquidTextButton2 = (OSLiquidTextButton) ViewBindings.findChildViewById(viewInflate, i8);
            if (oSLiquidTextButton2 != null) {
                i8 = R$id.img_left;
                OSLiquidButton oSLiquidButton = (OSLiquidButton) ViewBindings.findChildViewById(viewInflate, i8);
                if (oSLiquidButton != null) {
                    i8 = R$id.img_right;
                    OSLiquidButton oSLiquidButton2 = (OSLiquidButton) ViewBindings.findChildViewById(viewInflate, i8);
                    if (oSLiquidButton2 != null) {
                        i8 = R$id.tv_subtitle;
                        TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, i8);
                        if (textView != null) {
                            i8 = R$id.tv_title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, i8);
                            if (textView2 != null) {
                                OsBottomSheetTitleBinding osBottomSheetTitleBinding = new OsBottomSheetTitleBinding((LinearLayout) viewInflate, oSLiquidTextButton, oSLiquidTextButton2, oSLiquidButton, oSLiquidButton2, textView, textView2);
                                Intrinsics.checkNotNullExpressionValue(osBottomSheetTitleBinding, "inflate(LayoutInflater.from(context))");
                                return osBottomSheetTitleBinding;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i8)));
    }
}
