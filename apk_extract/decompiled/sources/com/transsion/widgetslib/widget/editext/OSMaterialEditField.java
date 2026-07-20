package com.transsion.widgetslib.widget.editext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$drawable;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.R$string;
import com.transsion.widgetslib.R$styleable;
import hd.a;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public class OSMaterialEditField extends RelativeLayout implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExtendedEditText f3483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f3484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f3485d;
    public final TextView e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f3486h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f3487i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f3488j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f3489k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f3490l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final GradientDrawable f3491m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Drawable f3492n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f3493o;
    public int p;

    public OSMaterialEditField(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
    }

    public int getBackgroundRoundCornerColor() {
        return this.p;
    }

    public ExtendedEditText getEditText() {
        return this.f3483b;
    }

    @Nullable
    public TextView getEditTextLabel() {
        return this.e;
    }

    @Nullable
    public TextView getNumText() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3483b.addTextChangedListener(this);
        this.f3483b.getText();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3483b.removeTextChangedListener(this);
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
    }

    public void setBackgroundRoundCornerColor(int i8) {
        this.p = i8;
    }

    public OSMaterialEditField(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OSMaterialEditField(@NonNull Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f3488j = true;
        this.f3482a = context;
        this.p = ContextCompat.getColor(context, R$color.os_edittext_hios_bg_color);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OSMaterialEditField);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i9 = 0; i9 < indexCount; i9++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i9);
            if (index == R$styleable.OSMaterialEditField_os_ef_field_label) {
                this.f3486h = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R$styleable.OSMaterialEditField_os_ef_show_error) {
                this.f3487i = typedArrayObtainStyledAttributes.getBoolean(index, false);
            } else if (index == R$styleable.OSMaterialEditField_os_ef_field_radius) {
                String[] strArr = j.f8764a;
                this.f3489k = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, a.a(context, 6));
            } else if (index == R$styleable.OSMaterialEditField_os_ef_bg_color) {
                this.p = typedArrayObtainStyledAttributes.getColor(index, ContextCompat.getColor(this.f3482a, R$color.os_seekbar_thumbinside_color));
            } else if (index == R$styleable.OSMaterialEditField_os_ef_show_background_round) {
                this.f3493o = typedArrayObtainStyledAttributes.getBoolean(index, false);
            } else if (index == R$styleable.OSMaterialEditField_os_ef_hios) {
                this.f3488j = typedArrayObtainStyledAttributes.getBoolean(index, true);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        int i10 = R$layout.os_view_materal_edit_field_layout_base;
        Context context2 = this.f3482a;
        RelativeLayout.inflate(context2, i10, this);
        context2.getString(R$string.os_dialog_input_tip_max);
        this.f3483b = (ExtendedEditText) findViewById(R$id.os_ef_edit_field);
        TextView textView = (TextView) findViewById(R$id.os_ef_edit_text_error_hint);
        if (this.f3487i) {
            textView.setVisibility(4);
        }
        this.f3484c = findViewById(R$id.os_ef_second_root_layout);
        this.f3485d = findViewById(R$id.os_ef_edit_field_bg);
        ContextCompat.getColor(context2, R$color.os_red_basic_color);
        int i11 = R$attr.os_fill_weakest;
        int i12 = R$color.os_fill_weakest_hios;
        String[] strArr2 = j.f8764a;
        this.f3490l = j.d(i11, context2.getColor(i12), context2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f3491m = gradientDrawable;
        gradientDrawable.setColor(this.f3490l);
        this.f3491m.setCornerRadius(this.f3489k);
        this.f3485d.setBackground(this.f3491m);
        String str = this.f3486h;
        if (!TextUtils.isEmpty(str)) {
            TextView textView2 = (TextView) findViewById(R$id.os_ef_edit_text_label);
            this.e = textView2;
            textView2.setText(str);
            this.e.setVisibility(0);
        }
        if (!this.f3488j) {
            this.f3484c.setPaddingRelative(getResources().getDimensionPixelSize(R$dimen.os_text_field_big_icon_magin_xos), 0, getResources().getDimensionPixelSize(R$dimen.os_text_field_big_icon_magin_xos), 0);
            TextView textView3 = this.e;
            if (textView3 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView3.getLayoutParams();
                marginLayoutParams.setMarginStart(a.a(context2, 2));
                marginLayoutParams.setMarginEnd(a.a(context2, 2));
                this.e.setLayoutParams(marginLayoutParams);
            }
        }
        if (this.f3493o) {
            Drawable drawable = context2.getDrawable(R$drawable.os_smooth_corner14);
            this.f3492n = drawable;
            drawable.setTint(this.p);
            this.f3484c.setBackground(this.f3492n);
        }
    }
}
