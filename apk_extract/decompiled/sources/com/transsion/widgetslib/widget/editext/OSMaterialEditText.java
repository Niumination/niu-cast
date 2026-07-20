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
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import ce.b;
import ce.c;
import ce.d;
import ce.e;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.R$string;
import com.transsion.widgetslib.R$styleable;
import hd.a;
import md.f;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public class OSMaterialEditText extends RelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener, TextWatcher, View.OnFocusChangeListener {
    public static final /* synthetic */ int j0 = 0;
    public final TextView A;
    public final String B;
    public final TextView C;
    public final String D;
    public final ImageView E;
    public final Drawable F;
    public final ImageView G;
    public final Drawable H;
    public final View I;
    public final View J;
    public final View K;
    public final View L;
    public final View M;
    public final int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public final TextView S;
    public final int T;
    public final int U;
    public final int V;
    public final int W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3494a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final int f3495a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3496b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f3497b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3498c;
    public final boolean c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3499d;
    public boolean d0;
    public final ExtendedEditText e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f3500e0;
    public boolean f0;
    public f g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f3501h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public GradientDrawable f3502h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f3503i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final boolean f3504i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Drawable f3505j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f3506k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f3507l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f3508m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f3509n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f3510o;
    public final TextView p;
    public final String q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final TextView f3511r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final TextView f3512s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f3513t;
    public final String u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f3514v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final TextView f3515w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f3516x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f3517y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final View f3518z;

    public OSMaterialEditText(@NonNull Context context) {
        this(context, null);
    }

    public final void a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f3512s.setText(charSequence);
            this.f3512s.setVisibility(this.d0 ? 4 : 8);
        } else {
            this.d0 = true;
            this.f3512s.setText(charSequence);
            this.f3512s.setVisibility(0);
            this.S.setVisibility(8);
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        int length = editable.length();
        boolean z2 = length > 0;
        this.f3500e0 = z2;
        b(z2, this.f3497b0);
        if (TextUtils.isEmpty(this.f3511r.getText())) {
            a(this.u);
        } else {
            a("");
        }
        if (this.S != null) {
            if (!TextUtils.isEmpty(this.f3511r.getText()) || !TextUtils.isEmpty(this.f3512s.getText())) {
                this.S.setText("");
                return;
            }
            int i8 = this.T;
            if (i8 <= 0) {
                this.S.setVisibility(8);
                return;
            }
            this.S.setVisibility(0);
            TextView textView = this.S;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(length);
            sb2.append("/");
            sb2.append(i8);
            textView.setText(sb2);
        }
    }

    public final void b(boolean z2, boolean z3) {
        boolean z5 = z3 || this.e.hasFocus();
        this.f3497b0 = z5;
        ImageView imageView = this.f3501h;
        if (imageView == null || !this.f3499d) {
            return;
        }
        if (z2 && z5) {
            imageView.setVisibility(0);
            post(new b(this, 1));
        } else {
            imageView.setVisibility(8);
            post(new b(this, 1));
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
    }

    public final void c() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.L.getLayoutParams();
        if (this.f3496b == this.f3510o) {
            marginLayoutParams.setMarginStart(this.I.getMeasuredWidth() + this.Q);
            this.L.setLayoutParams(marginLayoutParams);
            this.e.setPaddingRelative(0, 0, this.J.getMeasuredWidth(), 0);
        } else {
            marginLayoutParams.setMarginStart(0);
            this.L.setLayoutParams(marginLayoutParams);
            this.e.setPaddingRelative(this.I.getMeasuredWidth() + this.Q, 0, this.J.getMeasuredWidth(), 0);
        }
        if (this.f3504i0) {
            int i8 = this.O;
            int i9 = this.P;
            this.O = i8;
            this.P = i9;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.M.getLayoutParams();
            marginLayoutParams2.setMargins(this.O, 0, this.P, 0);
            this.M.setLayoutParams(marginLayoutParams2);
        }
    }

    public final void d() {
        int i8 = this.f3496b;
        int i9 = this.f3506k;
        int i10 = this.f3507l;
        if (i8 == i9 || i8 == i10) {
            this.J.setVisibility(0);
            Drawable drawable = this.f3505j;
            if (drawable != null) {
                this.f3503i.setVisibility(0);
                this.f3503i.setImageDrawable(drawable);
            }
            if (this.f3496b == i10 && drawable != null) {
                if (TextUtils.equals(j.f8764a[1], j.f) || j.f8766c) {
                    this.K.setPaddingRelative(this.K.getPaddingStart(), this.K.getPaddingTop(), getResources().getDimensionPixelSize(R$dimen.os_space250), this.K.getPaddingBottom());
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f3503i.getLayoutParams();
                int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.os_text_field_big_icon_size);
                marginLayoutParams.height = dimensionPixelSize;
                marginLayoutParams.width = dimensionPixelSize;
                marginLayoutParams.setMarginStart(a.a(this.f3494a, 16));
                this.f3503i.setLayoutParams(marginLayoutParams);
            }
            if (this.f3517y) {
                this.f3518z.setVisibility(0);
            }
            String str = this.B;
            if (!TextUtils.isEmpty(str)) {
                this.A.setVisibility(0);
                this.A.setText(str);
            }
            String str2 = this.f3516x;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f3515w.setVisibility(0);
            this.f3515w.setText(str2);
            return;
        }
        int i11 = this.f3508m;
        if (i8 == i11 || i8 == this.f3509n || i8 == this.f3510o) {
            this.I.setVisibility(0);
            String str3 = this.D;
            if (!TextUtils.isEmpty(str3)) {
                this.C.setVisibility(0);
                this.C.setText(str3);
            }
            Drawable drawable2 = this.F;
            if (drawable2 != null) {
                this.E.setVisibility(0);
                this.E.setImageDrawable(drawable2);
            }
            Drawable drawable3 = this.H;
            if (drawable3 != null) {
                this.G.setVisibility(0);
                this.G.setImageDrawable(drawable3);
            }
            if (this.f3496b != i11) {
                if (TextUtils.equals(j.f8764a[1], j.f) || j.f8766c) {
                    this.K.setPaddingRelative(getResources().getDimensionPixelSize(R$dimen.os_space250), this.K.getPaddingTop(), this.K.getPaddingEnd(), this.K.getPaddingBottom());
                }
                if (drawable2 != null) {
                    ViewGroup.LayoutParams layoutParams = this.E.getLayoutParams();
                    int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.os_text_field_big_icon_size);
                    layoutParams.height = dimensionPixelSize2;
                    layoutParams.width = dimensionPixelSize2;
                    this.E.setLayoutParams(layoutParams);
                }
                if (drawable3 != null) {
                    ViewGroup.LayoutParams layoutParams2 = this.G.getLayoutParams();
                    int dimensionPixelSize3 = getResources().getDimensionPixelSize(R$dimen.os_text_field_big_icon_size);
                    layoutParams2.height = dimensionPixelSize3;
                    layoutParams2.width = dimensionPixelSize3;
                    this.G.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public final void e(boolean z2, boolean z3) {
        boolean z5 = this.f3504i0;
        if (z3) {
            if (z5 && this.c0) {
                this.K.setForeground(this.g0);
            }
            this.M.setBackgroundColor(this.U);
            return;
        }
        if (z5 && this.c0) {
            this.K.setForeground(null);
        }
        if (z2) {
            this.M.setBackgroundColor(this.W);
        } else {
            this.M.setBackgroundColor(this.V);
        }
    }

    @Nullable
    public ImageView getDeleteButton() {
        return this.f3501h;
    }

    public boolean getDialogMode() {
        return this.f0;
    }

    public ExtendedEditText getEditText() {
        return this.e;
    }

    @Nullable
    public TextView getEditTextLabel() {
        return this.p;
    }

    public int getEditTextPaddingStart() {
        return this.Q;
    }

    @Nullable
    public TextView getErrorText() {
        return this.f3511r;
    }

    @Nullable
    public ImageView getLeftImage() {
        return this.E;
    }

    @Nullable
    public ImageView getLeftSecondImage() {
        return this.G;
    }

    @Nullable
    public TextView getLeftTextView() {
        return this.C;
    }

    @Nullable
    public View getLeftlayout() {
        return this.I;
    }

    @Nullable
    public TextView getNumTextView() {
        return this.S;
    }

    @Nullable
    public View getRightDivider() {
        return this.f3518z;
    }

    @Nullable
    public ImageView getRightImage() {
        return this.f3503i;
    }

    @Nullable
    public TextView getRightText() {
        return this.f3515w;
    }

    @Nullable
    public TextView getRightTextButton() {
        return this.A;
    }

    @Nullable
    public View getRightlayout() {
        return this.J;
    }

    @Nullable
    public View getRootEditTextLayout() {
        return this.L;
    }

    @Nullable
    public View getRootLayout() {
        return this.K;
    }

    public int getType() {
        return this.f3496b;
    }

    public int getUnderLineMarginLeft() {
        return this.O;
    }

    public int getUnderLineMarginRight() {
        return this.P;
    }

    public int getUnderLinePadding() {
        return this.N;
    }

    @Nullable
    public View getUnderlineView() {
        if (this.f3504i0) {
            return null;
        }
        return this.M;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.e.setSelfOnFocusChangeListener(this);
        this.e.addTextChangedListener(this);
        afterTextChanged(this.e.getText());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e.setOnFocusChangeListener(null);
        this.e.removeTextChangedListener(this);
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        this.f3497b0 = z2;
        if (z2) {
            TextView textView = this.f3511r;
            if (textView != null && textView.getVisibility() == 0) {
                e(true, true);
            }
        } else {
            e(false, false);
            String str = this.u;
            a(str);
            this.f3511r.setVisibility(8);
            if (TextUtils.isEmpty(str)) {
                this.S.setTextColor(ContextCompat.getColor(this.f3494a, R$color.os_text_tertiary_color));
            } else {
                this.S.setVisibility(8);
            }
        }
        b(this.f3500e0, z2);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        c();
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        this.f3498c = i8;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        if (TextUtils.isEmpty(this.f3511r.getText())) {
            return;
        }
        this.f3511r.setVisibility(0);
        this.f3511r.setText(this.f3513t);
        this.S.setVisibility(8);
        e(true, true);
    }

    public void setBackgroundMultiModeOnlyHiOS(d dVar) {
        setBackgroundMultiModeOnlyHiOS(dVar.ordinal());
    }

    public void setDialogMode(boolean z2) {
        this.f0 = z2;
    }

    public void setEditTextPaddingStart(int i8) {
        this.Q = i8;
    }

    public void setHint(CharSequence charSequence) {
        ExtendedEditText extendedEditText = this.e;
        if (extendedEditText != null) {
            extendedEditText.setHint(charSequence);
        }
    }

    public void setRootLayoutPaddingOnlyHiOS(int i8) {
        if (this.f3504i0) {
            View view = this.K;
            view.setPadding(view.getPaddingLeft(), i8, this.K.getPaddingRight(), i8);
        }
    }

    public void setShowDelete(boolean z2) {
        this.f3499d = z2;
        if (z2) {
            this.J.setVisibility(0);
            this.f3501h.setVisibility(this.e.hasFocus() ? 0 : 8);
            this.f3501h.setOnClickListener(new c(this, 0));
        } else {
            this.f3501h.setVisibility(8);
            this.f3501h.setOnClickListener(null);
        }
        c();
    }

    public void setType(int i8) {
        this.f3496b = i8;
        d();
    }

    public OSMaterialEditText(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setBackgroundMultiModeOnlyHiOS(int i8) {
        if (this.f3504i0) {
            this.R = i8;
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.f3502h0 = gradientDrawable;
            int i9 = this.f3495a0;
            gradientDrawable.setColor(i9);
            if (this.c0) {
                GradientDrawable gradientDrawable2 = this.f3502h0;
                Context context = getContext();
                String[] strArr = j.f8764a;
                gradientDrawable2.setStroke(a.a(context, 1), i9 & ViewCompat.MEASURED_SIZE_MASK);
            }
            float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            Context context2 = this.f3494a;
            float dimension = context2.getResources().getDimension(R$dimen.os_edit_corner);
            if (this.f0) {
                dimension = context2.getResources().getDimension(R$dimen.os_edit_corner_dialog_mode);
            }
            int i10 = this.R;
            d dVar = d.TOP;
            if (i10 == dVar.ordinal() || this.R == d.NORMAL.ordinal()) {
                fArr[3] = dimension;
                fArr[2] = dimension;
                fArr[1] = dimension;
                fArr[0] = dimension;
            }
            if (this.R == d.BOTTOM.ordinal() || this.R == d.NORMAL.ordinal()) {
                fArr[7] = dimension;
                fArr[6] = dimension;
                fArr[5] = dimension;
                fArr[4] = dimension;
            }
            this.f3502h0.setCornerRadii(fArr);
            this.K.setBackground(this.f3502h0);
            if (this.R == dVar.ordinal() || this.R == d.MIDDLE.ordinal()) {
                this.M.setVisibility(0);
            }
        }
    }

    public OSMaterialEditText(@NonNull Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f3506k = 1;
        this.f3507l = 2;
        this.f3508m = 3;
        this.f3509n = 4;
        this.f3510o = 5;
        this.f3513t = "";
        Context context2 = getContext();
        String[] strArr = j.f8764a;
        this.N = a.a(context2, 16);
        this.T = -1;
        this.f3504i0 = true;
        this.f3494a = context;
        this.f3495a0 = ContextCompat.getColor(context, R$color.os_edittext_hios_bg_color);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OSMaterialEditText);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i9 = 0; i9 < indexCount; i9++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i9);
            if (index == R$styleable.OSMaterialEditText_os_et_layout_type) {
                this.f3496b = typedArrayObtainStyledAttributes.getInt(index, 0);
            } else if (index == R$styleable.OSMaterialEditText_os_et_right_show_delete) {
                this.f3499d = typedArrayObtainStyledAttributes.getBoolean(index, false);
            } else if (index == R$styleable.OSMaterialEditText_os_et_right_image) {
                this.f3505j = typedArrayObtainStyledAttributes.getDrawable(index);
            } else if (index == R$styleable.OSMaterialEditText_os_et_label) {
                this.q = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R$styleable.OSMaterialEditText_os_et_right_text) {
                this.f3516x = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R$styleable.OSMaterialEditText_os_et_right_show_divide_line) {
                this.f3517y = typedArrayObtainStyledAttributes.getBoolean(index, false);
            } else if (index == R$styleable.OSMaterialEditText_os_et_left_image) {
                this.F = typedArrayObtainStyledAttributes.getDrawable(index);
            } else if (index == R$styleable.OSMaterialEditText_os_et_left_image_secord) {
                this.H = typedArrayObtainStyledAttributes.getDrawable(index);
            } else if (index == R$styleable.OSMaterialEditText_os_et_left_text) {
                this.D = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R$styleable.OSMaterialEditText_os_et_right_button_text) {
                this.B = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R$styleable.OSMaterialEditText_os_et_show_error) {
                this.c0 = typedArrayObtainStyledAttributes.getBoolean(index, false);
            } else if (index == R$styleable.OSMaterialEditText_os_et_show_help) {
                this.d0 = typedArrayObtainStyledAttributes.getBoolean(index, false);
            } else if (index == R$styleable.OSMaterialEditText_os_et_show_error_text) {
                this.f3513t = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R$styleable.OSMaterialEditText_os_et_show_help_text) {
                this.u = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R$styleable.OSMaterialEditText_os_et_bg_color) {
                this.f3495a0 = typedArrayObtainStyledAttributes.getColor(index, ContextCompat.getColor(this.f3494a, R$color.os_seekbar_thumbinside_color));
            } else if (index == R$styleable.OSMaterialEditText_os_et_hint) {
                this.f3514v = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R$styleable.OSMaterialEditText_os_et_left_right_padding) {
                this.N = (int) typedArrayObtainStyledAttributes.getDimension(index, this.N);
            } else if (index == R$styleable.OSMaterialEditText_os_et_hios_background_multi_mode) {
                this.R = typedArrayObtainStyledAttributes.getInt(index, 0);
            } else if (index == R$styleable.OSMaterialEditText_os_et_dialog_mode) {
                this.f0 = typedArrayObtainStyledAttributes.getBoolean(index, false);
            } else if (index == R$styleable.OSMaterialEditText_os_et_hios) {
                this.f3504i0 = typedArrayObtainStyledAttributes.getBoolean(index, true);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        boolean z2 = this.f3504i0;
        int i10 = z2 ? R$layout.os_view_materal_edit_text_layout_hios : R$layout.os_view_materal_edit_text_layout_base;
        Context context3 = this.f3494a;
        RelativeLayout.inflate(context3, i10, this);
        context3.getString(R$string.os_dialog_input_tip_max);
        this.e = (ExtendedEditText) findViewById(R$id.oet_edit_text);
        this.I = findViewById(R$id.os_et_edit_text_left_layout);
        this.J = findViewById(R$id.os_et_edit_text_right_layout);
        this.K = findViewById(R$id.os_et_second_root_layout);
        this.M = findViewById(R$id.os_et_underline_view);
        this.L = findViewById(R$id.os_et_edit_text_root);
        this.f3511r = (TextView) findViewById(R$id.os_et_edit_text_error_hint);
        this.f3512s = (TextView) findViewById(R$id.os_et_edit_text_help_hint);
        this.S = (TextView) findViewById(R$id.os_et_edit_text_limit_hint);
        this.f3501h = (ImageView) findViewById(R$id.os_et_edit_delete_all);
        this.C = (TextView) findViewById(R$id.os_et_edit_text_left_text);
        this.E = (ImageView) findViewById(R$id.os_et_left_edit_image_first);
        this.G = (ImageView) findViewById(R$id.os_et_left_edit_image_second);
        this.f3503i = (ImageView) findViewById(R$id.os_et_edit_image_button);
        this.f3518z = findViewById(R$id.os_et_edit_text_divider);
        this.A = (TextView) findViewById(R$id.os_et_edit_text_right_text_button);
        this.f3515w = (TextView) findViewById(R$id.os_et_edit_text_right_text);
        this.U = ContextCompat.getColor(context3, R$color.os_red_basic_color);
        this.V = j.d(R$attr.os_border_default, context3.getColor(R$color.os_border_default_hios), context3);
        this.W = j.d(R$attr.os_border_focus, context3.getColor(R$color.os_border_focus_hios), context3);
        if (j.s()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3511r.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, a.a(context3, 7), layoutParams.rightMargin, layoutParams.bottomMargin);
            this.f3511r.setLayoutParams(layoutParams);
        }
        if (z2) {
            setBackgroundMultiModeOnlyHiOS(this.R);
            this.K.setOnClickListener(new ce.a(this, 0));
            post(new b(this, 0));
        }
        setHint(this.f3514v);
        d();
        String str = this.q;
        if (!TextUtils.isEmpty(str)) {
            TextView textView = (TextView) findViewById(R$id.os_et_edit_text_label);
            this.p = textView;
            textView.setText(str);
            this.p.setVisibility(0);
        }
        boolean z3 = this.c0;
        String str2 = this.u;
        if (z3) {
            this.f3511r.setVisibility(4);
            String str3 = this.f3513t;
            this.f3513t = str3;
            if (!TextUtils.isEmpty(str3)) {
                this.c0 = true;
                this.S.setVisibility(8);
                this.f3511r.setText(str3);
                this.f3511r.setVisibility(0);
                this.f3512s.setText("");
                e(this.f3497b0, true);
            } else {
                this.f3512s.setText(str2);
                this.f3511r.setText(str3);
                this.f3511r.setVisibility(this.c0 ? 4 : 8);
                e(this.f3497b0, false);
            }
        }
        if (this.d0 && z2) {
            this.f3512s.setVisibility(4);
            a(str2);
        }
        setShowDelete(this.f3499d);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        if (this.f0) {
            setRootLayoutPaddingOnlyHiOS((int) context3.getResources().getDimension(R$dimen.os_edit_text_padding_dialog_top));
            View view = this.K;
            if (view == null || z2) {
                return;
            }
            this.K.setPaddingRelative(0, view.getPaddingTop(), 0, this.K.getPaddingBottom());
        }
    }

    public void setType(e eVar) {
        setType(eVar.ordinal());
    }
}
