package com.transsion.widgetslib.widget.editext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.google.android.material.timepicker.TimeModel;
import com.transsion.widgetslib.R;
import hj.h;

/* JADX INFO: loaded from: classes2.dex */
public class OSMaterialEditField extends RelativeLayout implements TextWatcher {
    public GradientDrawable H;
    public Toast I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f2827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ExtendedEditText f2828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f2829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f2830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f2831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f2832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f2833g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2834i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f2835n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2836p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2837v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public TextView f2838w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a f2839x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2840y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2841z;

    public interface a {
        void a(Editable editable, TextView textView);
    }

    public OSMaterialEditField(@NonNull Context context) {
        this(context, null, 0);
    }

    public final void a() {
        View.inflate(this.f2827a, R.layout.os_view_materal_edit_field_layout_base, this);
        this.f2835n = this.f2827a.getString(R.string.os_dialog_input_tip_max);
        this.f2828b = (ExtendedEditText) findViewById(R.id.os_ef_edit_field);
        TextView textView = (TextView) findViewById(R.id.os_ef_edit_text_error_hint);
        this.f2833g = textView;
        if (this.f2834i) {
            textView.setVisibility(4);
        }
        this.f2829c = findViewById(R.id.os_ef_second_root_layout);
        this.f2830d = findViewById(R.id.os_ef_edit_field_bg);
        this.f2840y = ContextCompat.getColor(this.f2827a, R.color.os_red_basic_color);
        this.f2841z = ContextCompat.getColor(this.f2827a, R.color.os_gray_quaternary_color);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.H = gradientDrawable;
        gradientDrawable.setColor(this.f2841z);
        this.H.setCornerRadius(this.f2836p);
        this.f2830d.setBackground(this.H);
        if (!TextUtils.isEmpty(this.f2832f)) {
            TextView textView2 = (TextView) findViewById(R.id.os_ef_edit_text_label);
            this.f2831e = textView2;
            textView2.setText(this.f2832f);
            this.f2831e.setVisibility(0);
        }
        if (h.L()) {
            d(getResources().getDimensionPixelSize(R.dimen.os_text_field_big_icon_magin_xos), 0, getResources().getDimensionPixelSize(R.dimen.os_text_field_big_icon_magin_xos), 0);
            TextView textView3 = this.f2831e;
            if (textView3 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView3.getLayoutParams();
                marginLayoutParams.setMarginStart(ui.a.d(this.f2827a, 2));
                marginLayoutParams.setMarginEnd(ui.a.d(this.f2827a, 2));
                this.f2831e.setLayoutParams(marginLayoutParams);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextView textView = this.f2838w;
        if (textView != null && textView.getVisibility() == 0) {
            int length = editable.length();
            int i10 = this.f2837v;
            if (length < i10) {
                TextView textView2 = this.f2838w;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(length)));
                sb2.append("/");
                sb2.append(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(this.f2837v)));
                textView2.setText(sb2);
            } else if (length == i10) {
                TextView textView3 = this.f2838w;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(this.f2837v)));
                sb3.append("/");
                sb3.append(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(this.f2837v)));
                textView3.setText(sb3);
                if (!TextUtils.isEmpty(this.f2835n)) {
                    if (this.I == null) {
                        this.I = Toast.makeText(this.f2827a, this.f2835n, 1);
                    }
                    this.I.show();
                }
            }
            if (length > 0) {
                this.f2838w.setTextColor(this.f2827a.getColor(R.color.os_text_secondary_color));
            } else if (length == 0) {
                this.f2838w.setTextColor(this.f2827a.getColor(R.color.os_text_quaternary_color));
            }
        }
        a aVar = this.f2839x;
        if (aVar != null) {
            aVar.a(editable, this.f2838w);
        }
    }

    public OSMaterialEditField b(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f2833g.setText(charSequence);
            this.f2833g.setVisibility(this.f2834i ? 4 : 8);
            g(false);
        } else {
            this.f2833g.setText(charSequence);
            this.f2833g.setVisibility(0);
            g(true);
        }
        return this;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public OSMaterialEditField c(int i10, a aVar) {
        TextView textView = (TextView) findViewById(R.id.os_ef_num_text);
        this.f2838w = textView;
        if (i10 <= 0) {
            this.f2837v = -1;
            textView.setVisibility(8);
        } else {
            this.f2837v = i10;
            textView.setVisibility(0);
            this.f2828b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i10)});
            TextView textView2 = this.f2838w;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(this.f2828b.getText().length())));
            sb2.append("/");
            sb2.append(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i10)));
            textView2.setText(sb2);
        }
        this.f2839x = aVar;
        return this;
    }

    public void d(int i10, int i11, int i12, int i13) {
        this.f2829c.setPaddingRelative(i10, i11, i12, i13);
    }

    public OSMaterialEditField e(@StringRes int i10) {
        return f(this.f2827a.getString(i10));
    }

    public OSMaterialEditField f(String str) {
        this.f2835n = str;
        return this;
    }

    public void g(boolean z10) {
        if (z10) {
            this.H.setStroke(2, this.f2840y);
        } else {
            this.H.setStroke(0, 0);
        }
    }

    public ExtendedEditText getEditText() {
        return this.f2828b;
    }

    @Nullable
    public TextView getEditTextLabel() {
        return this.f2831e;
    }

    @Nullable
    public TextView getNumText() {
        return this.f2838w;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2828b.addTextChangedListener(this);
        afterTextChanged(this.f2828b.getText());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2828b.removeTextChangedListener(this);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public OSMaterialEditField(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OSMaterialEditField(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2827a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OSMaterialEditField);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i11);
            if (index == R.styleable.OSMaterialEditField_os_ef_field_label) {
                this.f2832f = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R.styleable.OSMaterialEditField_os_ef_show_error) {
                this.f2834i = typedArrayObtainStyledAttributes.getBoolean(index, false);
            } else if (index == R.styleable.OSMaterialEditField_os_ef_field_radius) {
                this.f2836p = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, h.e(context, 6));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        a();
    }
}
