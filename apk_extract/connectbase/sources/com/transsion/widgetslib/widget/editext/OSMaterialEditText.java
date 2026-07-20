package com.transsion.widgetslib.widget.editext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
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
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class OSMaterialEditText extends RelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener, TextWatcher, View.OnFocusChangeListener {
    public TextView H;
    public TextView I;
    public String J;
    public boolean K;
    public View L;
    public TextView M;
    public String N;
    public TextView O;
    public String P;
    public ImageView Q;
    public Drawable R;
    public ImageView S;
    public Drawable T;
    public View U;
    public View V;
    public View W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f2842a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public View f2843a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2844b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public View f2845b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2846c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public TextView f2847c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExtendedEditText f2848d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f2849d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f2850e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f2851e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f2852f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f2853f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f2854g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f2855g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f2856h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2857i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f2858i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public String f2859j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f2860k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public c f2861l0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2862n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2863p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2864v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2865w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2866x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TextView f2867y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f2868z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OSMaterialEditText.this.f2848d.setText("");
        }
    }

    public static class b extends InputFilter.LengthFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<OSMaterialEditText> f2870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2871b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Toast f2872c;

        public b(OSMaterialEditText oSMaterialEditText, int i10) {
            super(i10);
            if (oSMaterialEditText != null) {
                this.f2870a = new WeakReference<>(oSMaterialEditText);
                this.f2871b = i10;
            }
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
            String str;
            CharSequence charSequenceFilter = super.filter(charSequence, i10, i11, spanned, i12, i13);
            if (spanned == null) {
                return charSequenceFilter;
            }
            int length = spanned.length();
            OSMaterialEditText oSMaterialEditText = this.f2870a.get();
            if (oSMaterialEditText != null && length >= this.f2871b && length != 0 && charSequenceFilter != null && (str = oSMaterialEditText.f2859j0) != null && !str.isEmpty()) {
                if (this.f2872c == null) {
                    this.f2872c = Toast.makeText(oSMaterialEditText.f2842a, str, 1);
                }
                this.f2872c.show();
            }
            return charSequenceFilter;
        }
    }

    public interface c {
        void a(Editable editable, TextView textView);
    }

    public OSMaterialEditText(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int length = editable.length();
        boolean z10 = length > 0;
        this.f2860k0 = z10;
        k(z10, this.f2856h0);
        TextView textView = this.f2847c0;
        if (textView != null && textView.getVisibility() == 0) {
            int i10 = this.f2849d0;
            if (length < i10) {
                TextView textView2 = this.f2847c0;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(length)));
                sb2.append("/");
                sb2.append(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(this.f2849d0)));
                textView2.setText(sb2);
            } else if (length == i10) {
                TextView textView3 = this.f2847c0;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(this.f2849d0)));
                sb3.append("/");
                sb3.append(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(this.f2849d0)));
                textView3.setText(sb3);
            }
        }
        c cVar = this.f2861l0;
        if (cVar != null) {
            cVar.a(editable, this.f2847c0);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public final void d() {
        View.inflate(this.f2842a, R.layout.os_view_materal_edit_text_layout_base, this);
        this.f2859j0 = this.f2842a.getString(R.string.os_dialog_input_tip_max);
        this.f2848d = (ExtendedEditText) findViewById(R.id.oet_edit_text);
        this.U = findViewById(R.id.os_et_edit_text_left_layout);
        this.V = findViewById(R.id.os_et_edit_text_right_layout);
        this.W = findViewById(R.id.os_et_second_root_layout);
        this.f2845b0 = findViewById(R.id.os_et_underline_view);
        this.f2843a0 = findViewById(R.id.os_et_edit_text_root);
        this.H = (TextView) findViewById(R.id.os_et_edit_text_error_hint);
        this.f2851e0 = ContextCompat.getColor(this.f2842a, R.color.os_red_basic_color);
        this.f2853f0 = ContextCompat.getColor(this.f2842a, R.color.os_gray_secondary_color);
        this.f2855g0 = ContextCompat.getColor(this.f2842a, R.color.os_fill_primary_color);
        int i10 = this.f2844b;
        if (i10 == this.f2862n || i10 == this.f2863p) {
            this.V.setVisibility(0);
            if (this.f2854g != null) {
                ImageView imageView = (ImageView) findViewById(R.id.os_et_edit_image_button);
                this.f2852f = imageView;
                imageView.setVisibility(0);
                this.f2852f.setImageDrawable(this.f2854g);
            }
            if (this.f2844b == this.f2863p && this.f2854g != null) {
                if (h.L()) {
                    h(getResources().getDimensionPixelSize(R.dimen.os_text_field_padding_xos), 0, getResources().getDimensionPixelSize(R.dimen.os_text_field_big_icon_magin_xos), 0);
                }
                if (this.f2854g != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2852f.getLayoutParams();
                    int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.os_text_field_big_icon_size);
                    marginLayoutParams.height = dimensionPixelSize;
                    marginLayoutParams.width = dimensionPixelSize;
                    marginLayoutParams.setMarginStart(ui.a.d(this.f2842a, 16));
                    this.f2852f.setLayoutParams(marginLayoutParams);
                }
            }
            if (this.K) {
                View viewFindViewById = findViewById(R.id.os_et_edit_text_divider);
                this.L = viewFindViewById;
                viewFindViewById.setVisibility(0);
            }
            if (!TextUtils.isEmpty(this.N)) {
                TextView textView = (TextView) findViewById(R.id.os_et_edit_text_right_text_button);
                this.M = textView;
                textView.setVisibility(0);
                this.M.setText(this.N);
            }
            if (!TextUtils.isEmpty(this.J)) {
                TextView textView2 = (TextView) findViewById(R.id.os_et_edit_text_right_text);
                this.I = textView2;
                textView2.setVisibility(0);
                this.I.setText(this.J);
            }
        } else if (i10 == this.f2864v || i10 == this.f2865w || i10 == this.f2866x) {
            this.U.setVisibility(0);
            if (!TextUtils.isEmpty(this.P)) {
                TextView textView3 = (TextView) findViewById(R.id.os_et_edit_text_left_text);
                this.O = textView3;
                textView3.setVisibility(0);
                this.O.setText(this.P);
            }
            if (this.R != null) {
                ImageView imageView2 = (ImageView) findViewById(R.id.os_et_left_edit_image_first);
                this.Q = imageView2;
                imageView2.setVisibility(0);
                this.Q.setImageDrawable(this.R);
            }
            if (this.T != null) {
                ImageView imageView3 = (ImageView) findViewById(R.id.os_et_left_edit_image_second);
                this.S = imageView3;
                imageView3.setVisibility(0);
                this.S.setImageDrawable(this.T);
            }
            if (this.f2844b != this.f2864v) {
                if (h.L()) {
                    h(getResources().getDimensionPixelSize(R.dimen.os_text_field_big_icon_magin_xos), 0, getResources().getDimensionPixelSize(R.dimen.os_text_field_padding_xos), 0);
                }
                if (this.R != null) {
                    ViewGroup.LayoutParams layoutParams = this.Q.getLayoutParams();
                    int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.os_text_field_big_icon_size);
                    layoutParams.height = dimensionPixelSize2;
                    layoutParams.width = dimensionPixelSize2;
                    this.Q.setLayoutParams(layoutParams);
                }
                if (this.T != null) {
                    ViewGroup.LayoutParams layoutParams2 = this.S.getLayoutParams();
                    int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.os_text_field_big_icon_size);
                    layoutParams2.height = dimensionPixelSize3;
                    layoutParams2.width = dimensionPixelSize3;
                    this.S.setLayoutParams(layoutParams2);
                }
            }
        }
        if (!TextUtils.isEmpty(this.f2868z)) {
            TextView textView4 = (TextView) findViewById(R.id.os_et_edit_text_label);
            this.f2867y = textView4;
            textView4.setText(this.f2868z);
            this.f2867y.setVisibility(0);
        }
        if (this.f2858i0) {
            this.H.setVisibility(4);
        }
        if (this.f2846c) {
            this.V.setVisibility(0);
            ImageView imageView4 = (ImageView) findViewById(R.id.os_et_edit_delete_all);
            this.f2850e = imageView4;
            imageView4.setVisibility(4);
            this.f2850e.setOnClickListener(new a());
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public OSMaterialEditText e(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.H.setText(charSequence);
            this.H.setVisibility(this.f2858i0 ? 4 : 8);
            m(this.f2856h0, false);
        } else {
            this.H.setText(charSequence);
            this.H.setVisibility(0);
            m(this.f2856h0, true);
        }
        return this;
    }

    public OSMaterialEditText f(boolean z10) {
        m(this.f2856h0, z10);
        return this;
    }

    public OSMaterialEditText g(int i10, @Nullable c cVar) {
        TextView textView = (TextView) findViewById(R.id.os_et_edit_text_help_hint);
        this.f2847c0 = textView;
        if (i10 <= 0) {
            this.f2849d0 = -1;
            textView.setVisibility(8);
        } else {
            this.f2849d0 = i10;
            textView.setVisibility(0);
            this.f2848d.setFilters(new InputFilter[]{new b(this, i10)});
        }
        this.f2861l0 = cVar;
        return this;
    }

    @Nullable
    public ImageView getDeleteButton() {
        return this.f2850e;
    }

    public ExtendedEditText getEditText() {
        return this.f2848d;
    }

    @Nullable
    public TextView getEditTextLabel() {
        return this.f2867y;
    }

    @Nullable
    public TextView getErrorText() {
        return this.H;
    }

    @Nullable
    public ImageView getLeftImage() {
        return this.Q;
    }

    @Nullable
    public ImageView getLeftSecondImage() {
        return this.S;
    }

    @Nullable
    public TextView getLeftTextView() {
        return this.O;
    }

    @Nullable
    public View getLeftlayout() {
        return this.U;
    }

    @Nullable
    public TextView getNumTextView() {
        return this.f2847c0;
    }

    @Nullable
    public View getRightDivider() {
        return this.L;
    }

    @Nullable
    public ImageView getRightImage() {
        return this.f2852f;
    }

    @Nullable
    public TextView getRightText() {
        return this.I;
    }

    @Nullable
    public TextView getRightTextButton() {
        return this.M;
    }

    @Nullable
    public View getRightlayout() {
        return this.V;
    }

    @Nullable
    public View getRootEditTextLayout() {
        return this.f2843a0;
    }

    @Nullable
    public View getRootLayout() {
        return this.W;
    }

    @Nullable
    public View getUnderlineView() {
        return this.f2845b0;
    }

    public void h(int i10, int i11, int i12, int i13) {
        this.W.setPaddingRelative(i10, i11, i12, i13);
    }

    public OSMaterialEditText i(@StringRes int i10) {
        return j(this.f2842a.getString(i10));
    }

    public OSMaterialEditText j(String str) {
        this.f2859j0 = str;
        return this;
    }

    public void k(boolean z10, boolean z11) {
        boolean z12 = z11 || this.f2848d.hasFocus();
        this.f2856h0 = z12;
        ImageView imageView = this.f2850e;
        if (imageView == null || !this.f2846c) {
            return;
        }
        if (z10 && z12) {
            imageView.setVisibility(0);
            l();
        } else {
            imageView.setVisibility(4);
            l();
        }
    }

    public void l() {
        if (this.f2844b != this.f2866x) {
            this.f2848d.setPaddingRelative(this.U.getMeasuredWidth(), 0, this.V.getMeasuredWidth(), 0);
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2843a0.getLayoutParams();
        marginLayoutParams.setMarginStart(this.U.getMeasuredWidth());
        this.f2843a0.setLayoutParams(marginLayoutParams);
        this.f2848d.setPaddingRelative(0, 0, this.V.getMeasuredWidth(), 0);
    }

    public void m(boolean z10, boolean z11) {
        if (z11) {
            this.f2845b0.setBackgroundColor(this.f2851e0);
        } else if (z10) {
            this.f2845b0.setBackgroundColor(this.f2855g0);
        } else {
            this.f2845b0.setBackgroundColor(this.f2853f0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2848d.setSelfOnFocusChangeListener(this);
        this.f2848d.addTextChangedListener(this);
        afterTextChanged(this.f2848d.getText());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2848d.setOnFocusChangeListener(null);
        this.f2848d.removeTextChangedListener(this);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        this.f2856h0 = z10;
        TextView textView = this.H;
        if (textView == null || textView.getVisibility() != 0) {
            m(z10, false);
        } else {
            m(z10, true);
        }
        k(this.f2860k0, z10);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        l();
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public OSMaterialEditText(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OSMaterialEditText(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2857i = 0;
        this.f2862n = 1;
        this.f2863p = 2;
        this.f2864v = 3;
        this.f2865w = 4;
        this.f2866x = 5;
        this.f2842a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OSMaterialEditText);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i11);
            if (index == R.styleable.OSMaterialEditText_os_et_layout_type) {
                this.f2844b = typedArrayObtainStyledAttributes.getInt(index, 0);
            } else if (index == R.styleable.OSMaterialEditText_os_et_right_show_delete) {
                this.f2846c = typedArrayObtainStyledAttributes.getBoolean(index, false);
            } else if (index == R.styleable.OSMaterialEditText_os_et_right_image) {
                this.f2854g = typedArrayObtainStyledAttributes.getDrawable(index);
            } else if (index == R.styleable.OSMaterialEditText_os_et_label) {
                this.f2868z = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R.styleable.OSMaterialEditText_os_et_right_text) {
                this.J = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R.styleable.OSMaterialEditText_os_et_right_show_divide_line) {
                this.K = typedArrayObtainStyledAttributes.getBoolean(index, false);
            } else if (index == R.styleable.OSMaterialEditText_os_et_left_image) {
                this.R = typedArrayObtainStyledAttributes.getDrawable(index);
            } else if (index == R.styleable.OSMaterialEditText_os_et_left_image_secord) {
                this.T = typedArrayObtainStyledAttributes.getDrawable(index);
            } else if (index == R.styleable.OSMaterialEditText_os_et_left_text) {
                this.P = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R.styleable.OSMaterialEditText_os_et_right_button_text) {
                this.N = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R.styleable.OSMaterialEditText_os_et_show_error) {
                this.f2858i0 = typedArrayObtainStyledAttributes.getBoolean(index, false);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        d();
    }
}
