package com.transsion.widgetslib.widget.autoadjust;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import be.a;
import be.b;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$drawable;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.R$styleable;
import com.transsion.widgetslib.view.OSBigButton;
import k3.kc;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public class OSMediumButton extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OSBigButton f3472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OSBigButton f3473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f3474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f3475d;
    public boolean e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3476h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3477i;

    public OSMediumButton(Context context) {
        this(context, null);
    }

    public final void a() {
        if (this.e || this.f3476h) {
            if (this.f3477i) {
                return;
            }
            post(new a(this, 1));
            this.e = false;
            this.f3476h = false;
            return;
        }
        if (this.f3477i) {
            int width = this.f3475d.getWidth() + this.f3472a.getPaddingRight() + this.f3472a.getPaddingLeft();
            OSBigButton oSBigButton = this.f3472a;
            CharSequence text = oSBigButton.getText();
            float maxTextSizeSp = this.f3472a.getMaxTextSizeSp();
            float minLetterSpacing = this.f3472a.getMinLetterSpacing();
            int width2 = (((this.f3472a.getWidth() - width) - this.f3475d.getWidth()) / 2) - (oSBigButton.getPaddingRight() + oSBigButton.getPaddingLeft());
            Context context = oSBigButton.getContext();
            if (j.z(context) ? kc.a(context, text, maxTextSizeSp * 3.0f, minLetterSpacing, 1, width2) : kc.a(context, text, TypedValue.applyDimension(2, maxTextSizeSp, context.getResources().getDisplayMetrics()), minLetterSpacing, 1, width2)) {
                post(new a(this, 0));
            }
        }
    }

    public OSBigButton getFirstButton() {
        return this.f3472a;
    }

    public OSBigButton getSecondButton() {
        return this.f3473b;
    }

    public OSMediumButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OSMediumButton(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        LinearLayout.inflate(getContext(), R$layout.os_view_auto_adjust_double_botton_layout_base, this);
        setGravity(17);
        this.f3472a = (OSBigButton) findViewById(R$id.os_auto_aj_left_btn);
        this.f3473b = (OSBigButton) findViewById(R$id.os_auto_aj_right_btn);
        this.f3474c = (LinearLayout) findViewById(R$id.os_auto_aj_linear_layout);
        this.f3475d = findViewById(R$id.os_auto_aj_occupation);
        post(new a(this, 0));
        this.f3472a.setMaxTextLine(1);
        this.f3473b.setMaxTextLine(1);
        OSBigButton oSBigButton = this.f3472a;
        oSBigButton.setMaxButtonHeightDp(oSBigButton.getMinButtonHeightDp());
        OSBigButton oSBigButton2 = this.f3473b;
        oSBigButton2.setMaxButtonHeightDp(oSBigButton2.getMinButtonHeightDp());
        OSBigButton oSBigButton3 = this.f3472a;
        oSBigButton3.setMinTextSizeSp(oSBigButton3.getMaxTextSizeSp());
        OSBigButton oSBigButton4 = this.f3473b;
        oSBigButton4.setMinTextSizeSp(oSBigButton4.getMaxTextSizeSp());
        this.f3472a.f3136k = new b(this, 0);
        this.f3473b.f3136k = new b(this, 1);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MediumButton);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i9 = 0; i9 < indexCount; i9++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i9);
            if (index == R$styleable.MediumButton_first_text) {
                this.f3472a.setText(typedArrayObtainStyledAttributes.getString(index));
            } else if (index == R$styleable.MediumButton_second_text) {
                this.f3473b.setText(typedArrayObtainStyledAttributes.getString(index));
            } else if (index == R$styleable.MediumButton_style_mod) {
                int i10 = typedArrayObtainStyledAttributes.getInt(index, 0);
                if (i10 == 1) {
                    this.f3472a.setTextColor(ContextCompat.getColorStateList(context, R$color.os_platform_basic_color_selector));
                    this.f3472a.setBackgroundResource(R$drawable.os_btn_big_gray);
                    this.f3473b.setTextColor(ContextCompat.getColorStateList(context, R$color.os_platform_basic_color_selector));
                    this.f3473b.setBackgroundResource(R$drawable.os_btn_big_gray);
                } else if (i10 == 2) {
                    this.f3472a.setTextColor(ContextCompat.getColorStateList(context, R$color.os_platform_red_color_selector));
                    this.f3472a.setBackgroundResource(R$drawable.os_btn_big_gray);
                    this.f3473b.setTextColor(ContextCompat.getColorStateList(context, R$color.os_platform_red_color_selector));
                    this.f3473b.setBackgroundResource(R$drawable.os_btn_big_gray);
                } else if (i10 == 3) {
                    this.f3472a.setTextColor(ContextCompat.getColorStateList(context, R$color.os_button_on_color_outline_selector));
                    this.f3472a.setBackgroundResource(R$drawable.os_btn_big_outline_white);
                    this.f3473b.setTextColor(ContextCompat.getColorStateList(context, R$color.os_button_on_color_outline_selector));
                    this.f3473b.setBackgroundResource(R$drawable.os_btn_big_outline_white);
                }
            } else if (index == R$styleable.MediumButton_first_enable) {
                this.f3472a.setEnabled(typedArrayObtainStyledAttributes.getBoolean(index, true));
            } else if (index == R$styleable.MediumButton_second_enable) {
                this.f3473b.setEnabled(typedArrayObtainStyledAttributes.getBoolean(index, true));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
