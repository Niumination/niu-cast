package com.transsion.widgetslib.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.R$styleable;
import ke.c;
import pd.j;
import zd.a0;
import zd.b0;
import zd.i;
import zd.u;
import zd.v;
import zd.x;
import zd.y;

/* JADX INFO: loaded from: classes2.dex */
public class SearchBar extends FrameLayout implements i {
    public static final /* synthetic */ int H = 0;
    public final Drawable A;
    public String B;
    public CharSequence C;
    public final kd.a D;
    public int E;
    public final View F;
    public final View G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3435d;
    public int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3437i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f3438j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f3439k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f3440l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f3441m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final OSIconTextView f3442n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final OSIconTextView f3443o;
    public final TextView p;
    public final AutoCompleteTextView q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final OSIconTextView f3444r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final OSIconTextView f3445s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final OSIconTextView f3446t;
    public final LinearLayout u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TextWatcher f3447v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View.OnClickListener f3448w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View.OnClickListener f3449x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View.OnClickListener f3450y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final b0 f3451z;

    public SearchBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3447v = new a0(this);
        this.f3448w = new u(this, 5);
        this.C = "";
        this.D = new kd.a(this, 4);
        LayoutInflater.from(context).inflate(R$layout.os_search_bar_layout, this);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.os_search_bar_delete_margin);
        this.f3435d = dimensionPixelSize;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OSSearchBar);
        this.f3439k = typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSSearchBar_isBackMode, true);
        this.A = typedArrayObtainStyledAttributes.getDrawable(R$styleable.OSSearchBar_osSearchBarIconInEdittext);
        this.f3441m = typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSSearchBar_isSearStatusOnInitial, false);
        this.f3433b = context.getResources().getDimensionPixelOffset(R$dimen.os_search_bar_text_padding_end_with_del_icon);
        this.f3434c = context.getResources().getDimensionPixelOffset(R$dimen.os_search_bar_text_padding_end);
        typedArrayObtainStyledAttributes.recycle();
        this.f3438j = context.getResources().getDimensionPixelOffset(R$dimen.os_icon_margin) + context.getResources().getDimensionPixelOffset(R$dimen.os_dimen_search_back_view_padding_end) + context.getResources().getDimensionPixelOffset(R$dimen.os_dimen_icon_common_size);
        this.p = (TextView) findViewById(R$id.text_click);
        this.F = findViewById(R$id.relative_root);
        this.G = findViewById(R$id.linear_root);
        this.q = (AutoCompleteTextView) findViewById(R$id.text_search);
        this.f3442n = (OSIconTextView) findViewById(R$id.img_btn_back);
        this.f3443o = (OSIconTextView) findViewById(R$id.img_search_icon);
        this.f3444r = (OSIconTextView) findViewById(R$id.img_delete_all);
        this.f3445s = (OSIconTextView) findViewById(R$id.img_custom);
        this.u = (LinearLayout) findViewById(R$id.ll_del_custom_container);
        this.f3446t = (OSIconTextView) findViewById(R$id.img_custom_in_edittext);
        if (!TextUtils.isEmpty(this.B)) {
            this.f3446t.setVisibility(0);
            this.f3446t.setText(this.B);
        }
        if (!getIsBackMode()) {
            this.p.setVisibility(8);
            this.q.setVisibility(0);
            AutoCompleteTextView autoCompleteTextView = this.q;
            if (autoCompleteTextView != null) {
                autoCompleteTextView.requestFocus();
                InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(InputMethodManager.class);
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.q, 0);
                }
            }
        }
        this.f3443o.setTextColor(j.e(getContext(), R$attr.os_icon_disable, R$color.os_icon_disable_hios));
        this.f3442n.setTextColor(getContext().getColorStateList(R$color.os_icon_color));
        this.p.setOnClickListener(new u(this, 0));
        this.f3443o.setOnClickListener(new u(this, 1));
        this.f3442n.setOnClickListener(this.f3448w);
        this.q.setOnItemClickListener(new zd.j(this, 1));
        this.q.setOnEditorActionListener(new v(this));
        this.f3444r.setOnClickListener(new u(this, 2));
        this.f3445s.setOnClickListener(new u(this, 3));
        this.f3446t.setOnClickListener(new u(this, 4));
        getViewTreeObserver().addOnPreDrawListener(new c(this, 3));
        TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(new int[]{R$attr.osSearchBarMargin});
        this.f3432a = typedArrayObtainStyledAttributes2.getDimensionPixelSize(0, getContext().getResources().getDimensionPixelSize(R$dimen.os_search_bar_margin_hios));
        typedArrayObtainStyledAttributes2.recycle();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.u.getLayoutParams();
        if (getIsBackMode()) {
            layoutParams.setMarginEnd(getContext().getResources().getDimensionPixelSize(R$dimen.os_search_bar_margin_xos) + dimensionPixelSize);
        } else {
            layoutParams.setMarginEnd(this.f3432a + dimensionPixelSize);
        }
        this.u.setLayoutParams(layoutParams);
        d();
        TextView textView = this.p;
        b0 b0Var = new b0();
        b0Var.f11279a = textView;
        this.f3451z = b0Var;
    }

    private void setSearchViewLeftMargin(int i8) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.q.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f3443o.getLayoutParams();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R$dimen.os_space200);
        layoutParams.setMarginStart(i8);
        layoutParams2.setMarginStart(dimensionPixelSize + i8);
        this.f3443o.setLayoutParams(layoutParams2);
        this.q.setLayoutParams(layoutParams);
    }

    public final void a(TextView textView, float f) {
        TextPaint paint;
        if (textView == null || (paint = textView.getPaint()) == null) {
            return;
        }
        Rect rect = new Rect();
        String string = this.C.toString();
        paint.getTextBounds(string, 0, string.length(), rect);
        if (rect.height() > f) {
            textView.setTextSize(1, 16.0f);
        }
    }

    public final void b() {
        if (this.f3446t.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3446t.getLayoutParams();
            if (this.f3444r.getVisibility() == 0) {
                layoutParams.setMarginStart(getResources().getDimensionPixelSize(R$dimen.os_element_common_margin));
            } else {
                layoutParams.setMarginStart(0);
            }
            this.f3446t.setLayoutParams(layoutParams);
        }
    }

    public final void c() {
        boolean zIsEmpty = TextUtils.isEmpty(this.q.getText());
        Drawable drawable = this.A;
        if (zIsEmpty || this.q.getText().toString().length() <= 0 || this.q.getVisibility() != 0 || this.p.getVisibility() == 0 || !this.q.isEnabled()) {
            if (this.f3444r.getVisibility() != 8) {
                this.f3444r.setVisibility(8);
                if (drawable != null) {
                    this.f3446t.setVisibility(0);
                }
            }
        } else if (this.f3444r.getVisibility() != 0) {
            this.f3444r.setVisibility(0);
            if (drawable != null) {
                this.f3446t.setVisibility(8);
            }
        }
        b();
    }

    public final void d() {
        Editable text = this.q.getText();
        int dimensionPixelSize = this.f3433b;
        if (text == null || TextUtils.isEmpty(this.q.getText().toString()) || !this.q.isEnabled()) {
            if (this.f3446t.getVisibility() != 0) {
                dimensionPixelSize = this.f3434c;
            }
        } else if (this.f3446t.getVisibility() == 0) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.os_search_cus_icon_in_edittext_size) + getResources().getDimensionPixelSize(R$dimen.os_element_common_margin) + dimensionPixelSize;
        }
        AutoCompleteTextView autoCompleteTextView = this.q;
        autoCompleteTextView.setPaddingRelative(autoCompleteTextView.getPaddingStart(), this.q.getPaddingTop(), dimensionPixelSize, this.q.getPaddingBottom());
        int dimensionPixelSize2 = this.f3446t.getVisibility() == 0 ? getResources().getDimensionPixelSize(R$dimen.os_search_bar_text_padding_end_with_del_icon) : getResources().getDimensionPixelSize(R$dimen.os_search_bar_text_padding_end);
        TextView textView = this.p;
        textView.setPaddingRelative(textView.getPaddingStart(), this.p.getPaddingTop(), dimensionPixelSize2, this.p.getPaddingBottom());
        b();
    }

    public final void e() {
        if (this.f3445s.getVisibility() == 8) {
            this.f3436h = (this.e - this.f3437i) - getContext().getResources().getDimensionPixelSize(R$dimen.os_search_bar_back_mode_margin);
        }
    }

    public final float f() {
        float measuredWidth = ((getMeasuredWidth() * 1.0f) - (this.f3432a * 2)) - (getBackViewStaticWidth() - this.f3432a);
        if (j.f8764a[0].equalsIgnoreCase(j.getOsType()) && this.f3445s.getVisibility() == 8) {
            measuredWidth -= getContext().getResources().getDimensionPixelSize(R$dimen.os_search_bar_back_mode_margin);
        }
        return (measuredWidth * 1.0f) / this.f3436h;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005b  */
    public final void g() {
        float fMax;
        if (this.p == null || this.q == null || TextUtils.isEmpty(this.C)) {
            return;
        }
        float fApplyDimension = TypedValue.applyDimension(1, 8.0f, getContext().getResources().getDisplayMetrics());
        View viewFindViewById = findViewById(R$id.relative_root);
        if (viewFindViewById == null || viewFindViewById.getHeight() <= 0) {
            fMax = Math.max(((getContext().getResources().getDimension(R$dimen.os_action_bar_height) - getContext().getResources().getDimension(R$dimen.os_auto_complete_textview_margin)) - getContext().getResources().getDimension(R$dimen.os_auto_complete_textview_margin)) - fApplyDimension, 0.0f);
        } else {
            fMax = ((viewFindViewById.getHeight() - getContext().getResources().getDimension(R$dimen.os_auto_complete_textview_margin)) - getContext().getResources().getDimension(R$dimen.os_auto_complete_textview_margin)) - fApplyDimension;
            if (fMax <= 0.0f) {
                fMax = Math.max(((getContext().getResources().getDimension(R$dimen.os_action_bar_height) - getContext().getResources().getDimension(R$dimen.os_auto_complete_textview_margin)) - getContext().getResources().getDimension(R$dimen.os_auto_complete_textview_margin)) - fApplyDimension, 0.0f);
            }
        }
        a(this.p, fMax);
        a(this.q, fMax);
    }

    public View getBackView() {
        return this.f3442n;
    }

    public int getBackViewStaticWidth() {
        return this.f3438j;
    }

    public TextView getClickTextView() {
        TextView textView = this.p;
        if (textView != null) {
            return textView;
        }
        return null;
    }

    public View getDeleteAllIconView() {
        return this.f3444r;
    }

    public View getDeleteButton() {
        return this.f3444r;
    }

    @Override // zd.i
    public EditText getEditText() {
        return this.q;
    }

    public View getImgCustomInEdittext() {
        return this.f3446t;
    }

    public View getImgCustomView() {
        return this.f3445s;
    }

    public boolean getIsBackMode() {
        return this.f3439k;
    }

    public View getLinearRootView() {
        return this.G;
    }

    public boolean getRightIconVisibility() {
        return this.f3445s.getVisibility() == 0;
    }

    @Override // zd.i
    @NonNull
    public View getSearchBarView() {
        return this;
    }

    public View getSearchIconView() {
        return this.f3443o;
    }

    public AutoCompleteTextView getSearchTextView() {
        AutoCompleteTextView autoCompleteTextView = this.q;
        if (autoCompleteTextView != null) {
            return autoCompleteTextView;
        }
        return null;
    }

    @Override // zd.i
    public int getType() {
        return 0;
    }

    public final void h(boolean z2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.q.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.p.getLayoutParams();
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.u.getLayoutParams();
        layoutParams.setMarginEnd(z2 ? 0 : this.f3432a);
        layoutParams2.setMarginEnd(z2 ? 0 : this.f3432a);
        int i8 = this.f3435d;
        if (!z2) {
            i8 += this.f3432a;
        }
        layoutParams3.setMarginEnd(i8);
        this.q.setLayoutParams(layoutParams);
        this.p.setLayoutParams(layoutParams2);
        this.u.setLayoutParams(layoutParams3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.q.addTextChangedListener(this.f3447v);
        getViewTreeObserver().addOnGlobalLayoutListener(this.D);
        d();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        g();
        super.onConfigurationChanged(configuration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.D);
        this.q.removeTextChangedListener(this.f3447v);
    }

    public <T extends ListAdapter & Filterable> void setAdapter(T t3) {
        this.q.setAdapter(t3);
    }

    public void setBackClickListener(View.OnClickListener onClickListener) {
        this.f3448w = onClickListener;
        this.f3442n.setOnClickListener(onClickListener);
    }

    public void setCustomIconInEdittextClickListener(View.OnClickListener onClickListener) {
        this.f3450y = onClickListener;
    }

    public void setCustomSearchIcon(String str) {
        OSIconTextView oSIconTextView = this.f3443o;
        if (oSIconTextView != null) {
            oSIconTextView.setText(str);
        }
    }

    public void setDeleteButtonVisibility(int i8) {
        this.f3444r.setVisibility(i8);
    }

    public void setHint(CharSequence charSequence) {
        this.C = charSequence;
        this.p.setText(charSequence);
        this.q.setHint(charSequence);
        g();
    }

    public void setIsIDLE(boolean z2) {
        this.f3440l = z2;
    }

    public void setOnItemClickListener(x xVar) {
    }

    public void setOnStateChangeListener(y yVar) {
    }

    public void setRightIcon(String str) {
        this.f3445s.setVisibility(0);
        this.f3445s.setText(str);
        h(true);
        setSearchViewLeftMargin(getContext().getResources().getDimensionPixelSize(R$dimen.os_space250));
    }

    public void setRightIconVisibility(boolean z2) {
        this.f3445s.setVisibility(z2 ? 0 : 8);
        h(z2);
        setSearchViewLeftMargin(z2 ? getContext().getResources().getDimensionPixelSize(R$dimen.os_space250) : getContext().getResources().getDimensionPixelSize(R$dimen.os_search_bar_margin_hios));
    }

    public void setRootWidth(int i8) {
        this.e = i8;
    }

    public void setSearchBarClickListener(View.OnClickListener onClickListener) {
        this.f3449x = onClickListener;
    }

    public void setSearchBarEnabled(boolean z2) {
        AutoCompleteTextView autoCompleteTextView = this.q;
        if (autoCompleteTextView == null || this.f3443o == null || this.p == null) {
            return;
        }
        autoCompleteTextView.setEnabled(z2);
        this.p.setEnabled(z2);
        if (z2) {
            this.q.requestFocus();
            this.q.setAlpha(1.0f);
            this.f3443o.setAlpha(1.0f);
            this.p.setAlpha(1.0f);
        } else {
            this.q.setAlpha(0.65f);
            this.f3443o.setAlpha(0.65f);
            this.p.setAlpha(0.65f);
        }
        c();
        d();
    }

    public void setSearchBarIconInEdittext(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.B = str;
            this.f3446t.setVisibility(0);
            this.f3446t.setText(str);
        } else if (this.f3446t.getVisibility() == 0) {
            this.f3446t.setVisibility(8);
        }
        d();
    }

    public void setTextHeightElegant(boolean z2) {
        TextView textView = this.p;
        if (textView != null) {
            textView.setElegantTextHeight(z2);
        }
        AutoCompleteTextView autoCompleteTextView = this.q;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setElegantTextHeight(z2);
        }
    }

    @Deprecated
    public void setTextWatcher(TextWatcher textWatcher) {
        if (textWatcher == null) {
            return;
        }
        this.q.removeTextChangedListener(this.f3447v);
        this.f3447v = textWatcher;
        this.q.addTextChangedListener(textWatcher);
    }

    public void setHint(int i8) {
        setHint(getResources().getString(i8));
    }
}
