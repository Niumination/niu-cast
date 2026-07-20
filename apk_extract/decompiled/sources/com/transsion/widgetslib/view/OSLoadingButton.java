package com.transsion.widgetslib.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$layout;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public class OSLoadingButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OSBigButton f3160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OSLoadingView f3161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3163d;
    public String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View.OnClickListener f3164h;

    public OSLoadingButton(@NonNull Context context) {
        this(context, null);
    }

    public OSBigButton getButton() {
        return this.f3160a;
    }

    public OSLoadingView getLoadingView() {
        return this.f3161b;
    }

    public String getText() {
        return this.f3163d;
    }

    public void setButtonHeight(int i8) {
        OSBigButton oSBigButton = this.f3160a;
        if (oSBigButton != null) {
            oSBigButton.setMinButtonHeightDp(i8);
        }
    }

    public void setButtonTextSize(int i8) {
        OSBigButton oSBigButton = this.f3160a;
        if (oSBigButton != null) {
            oSBigButton.setMinTextSizeSp(i8);
        }
    }

    public void setLoading(boolean z2) {
        if (this.f3162c == z2) {
            return;
        }
        this.f3162c = z2;
        this.f3160a.setEnabled(!z2);
        if (!z2) {
            this.f3161b.setVisibility(8);
            this.f3160a.setText(this.f3163d);
            this.f3160a.setPadding(getContext().getResources().getDimensionPixelSize(R$dimen.os_space200), 0, getContext().getResources().getDimensionPixelSize(R$dimen.os_space200), 0);
        } else {
            this.f3160a.setText(this.e);
            this.f3160a.getViewTreeObserver().addOnGlobalLayoutListener(new kd.a(this, 1));
            this.f3161b.setVisibility(0);
            this.f3161b.h();
        }
    }

    public void setLoadingText(String str) {
        this.e = str;
        OSBigButton oSBigButton = this.f3160a;
        if (oSBigButton == null || this.f3161b == null) {
            return;
        }
        int iMax = Math.max(oSBigButton.getMeasuredWidth(), this.f3160a.getMinimumWidth());
        float fMeasureText = this.f3160a.getPaint().measureText(this.e);
        float f = iMax;
        float paddingLeft = this.f3160a.getPaddingLeft();
        float paddingRight = ((((f - fMeasureText) - paddingLeft) - this.f3160a.getPaddingRight()) / 2.0f) + paddingLeft;
        float f4 = fMeasureText + paddingRight;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3161b.getLayoutParams();
        if (layoutParams != null) {
            if (TextUtils.isEmpty(this.e)) {
                layoutParams.removeRule(18);
                layoutParams.addRule(14);
                this.f3161b.setLayoutParams(layoutParams);
            } else {
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R$dimen.os_space200);
                int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R$dimen.os_space150);
                if (j.v()) {
                    int iMax2 = Math.max(0, (int) (((f - f4) - dimensionPixelSize2) - dimensionPixelSize));
                    layoutParams.leftMargin = 0;
                    layoutParams.setMarginStart(iMax2);
                    this.f3161b.setLayoutParams(layoutParams);
                } else {
                    layoutParams.setMarginStart(Math.max(0, (int) ((paddingRight - dimensionPixelSize) - dimensionPixelSize2)));
                    layoutParams.rightMargin = 0;
                    this.f3161b.setLayoutParams(layoutParams);
                }
            }
            this.f3161b.invalidate();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f3164h = onClickListener;
    }

    public void setText(String str) {
        this.f3163d = str;
        this.f3160a.setText(str);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f3160a.setTextColor(colorStateList);
    }

    public OSLoadingButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OSLoadingButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f3162c = false;
        this.e = "";
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.os_loading_button_layout, (ViewGroup) this, true);
        this.f3160a = (OSBigButton) viewInflate.findViewById(R$id.os_loading_button);
        this.f3161b = (OSLoadingView) viewInflate.findViewById(R$id.os_loading_view);
        String string = this.f3160a.getText().toString();
        this.f3163d = string;
        this.e = string;
        this.f3161b.setVisibility(8);
        this.f3160a.setOnClickListener(new ce.a(this, 7));
    }
}
