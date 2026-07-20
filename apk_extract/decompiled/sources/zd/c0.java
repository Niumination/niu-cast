package zd;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.widget.OSIconTextView;
import com.transsion.widgetslib.widget.OSMaskImageView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c0 {
    public static final LinearLayout a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(R$id.os_fob_layout);
        linearLayout.setGravity(17);
        int dimensionPixelOffset = linearLayout.getResources().getDimensionPixelOffset(R$dimen.os_foot_bar_item_text_start_end_padding);
        linearLayout.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        AttributeSet attributeSet = null;
        OSMaskImageView oSMaskImageView = new OSMaskImageView(context, attributeSet, 6, 0);
        oSMaskImageView.setId(R$id.os_foot_opt_bar_item_icon);
        int dimensionPixelOffset2 = oSMaskImageView.getResources().getDimensionPixelOffset(R$dimen.os_foot_bar_item_icon_size);
        oSMaskImageView.setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelOffset2, dimensionPixelOffset2));
        linearLayout.addView(oSMaskImageView);
        TextView textView = new TextView(context);
        textView.setId(R$id.os_foot_opt_bar_item_text);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int dimensionPixelOffset3 = textView.getResources().getDimensionPixelOffset(R$dimen.os_foot_bar_item_text_paddingTop);
        layoutParams.setMargins(dimensionPixelOffset3, dimensionPixelOffset3, dimensionPixelOffset3, dimensionPixelOffset3);
        textView.setLayoutParams(layoutParams);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTypeface(Typeface.create("sans-serif", 0));
        textView.setMaxLines(1);
        textView.setMinHeight(textView.getResources().getDimensionPixelOffset(R$dimen.os_foot_bar_item_text_height));
        textView.setTextColor(ContextCompat.getColor(context, R$color.os_foot_action_bar_text_color));
        textView.setTextSize(0, textView.getResources().getDimension(R$dimen.os_foot_bar_item_text_size));
        linearLayout.addView(textView);
        return linearLayout;
    }

    public static final LinearLayout b(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        linearLayout.setLayoutParams(layoutParams);
        OSIconTextView oSIconTextView = new OSIconTextView(context, null, 0, 14);
        oSIconTextView.setId(R$id.os_foot_opt_bar_item_text);
        oSIconTextView.getResources().getDimensionPixelOffset(R$dimen.os_foot_bar_item_text_paddingTop);
        oSIconTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        oSIconTextView.setClickable(false);
        oSIconTextView.setGravity(17);
        oSIconTextView.setMinHeight(oSIconTextView.getResources().getDimensionPixelOffset(R$dimen.os_foot_bar_item_text_height));
        oSIconTextView.setTextColor(pd.j.d(R$attr.os_icon_secondary, context.getColor(R$color.os_icon_secondary_hios), context));
        oSIconTextView.setTextSize(0, oSIconTextView.getResources().getDimensionPixelOffset(R$dimen.os_liquid_button_text_size));
        linearLayout.addView(oSIconTextView);
        return linearLayout;
    }
}
