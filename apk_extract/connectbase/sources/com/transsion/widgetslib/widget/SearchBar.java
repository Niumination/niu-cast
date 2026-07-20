package com.transsion.widgetslib.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.CallSuper;
import androidx.annotation.DrawableRes;
import com.transsion.widgetslib.R;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SearchBar extends FrameLayout {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f2751a0 = 250;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f2752b0 = 250;
    public TextWatcher H;
    public boolean I;
    public View.OnClickListener J;
    public View.OnClickListener K;
    public View.OnClickListener L;
    public View.OnClickListener M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public r R;
    public r S;
    public int T;
    public int U;
    public Drawable V;
    public String W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f2754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f2755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f2756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AutoCompleteTextView f2757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2758f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2759g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2760i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public o f2761n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public p f2762p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ImageView f2763v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ImageView f2764w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ImageView f2765x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public LinearLayout f2766y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f2767z;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SearchBar.this.f2754b.setVisibility(8);
            SearchBar.this.f2757e.setVisibility(8);
            SearchBar.this.f2756d.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            InputMethodManager inputMethodManager = (InputMethodManager) SearchBar.this.getContext().getSystemService(InputMethodManager.class);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(SearchBar.this.getWindowToken(), 0);
            }
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SearchBar.this.f2754b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SearchBar.this.f2754b.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!SearchBar.this.P) {
                SearchBar.this.W();
                return;
            }
            View.OnClickListener onClickListener = SearchBar.this.L;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public class e implements AdapterView.OnItemClickListener {
        public e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (SearchBar.this.f2761n != null) {
                SearchBar.this.f2761n.onItemClick(adapterView, view, i10, j10);
            }
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(SearchBar.this.f2757e.getText()) || SearchBar.this.f2757e.length() > 0) {
                SearchBar.this.f2757e.setText((CharSequence) null);
            }
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SearchBar.this.K != null) {
                SearchBar.this.K.onClick(view);
            }
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SearchBar.this.M != null) {
                SearchBar.this.M.onClick(view);
            }
        }
    }

    public class i implements ViewTreeObserver.OnPreDrawListener {
        public i() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            SearchBar.this.getViewTreeObserver().removeOnPreDrawListener(this);
            SearchBar.this.f2754b.offsetLeftAndRight(-SearchBar.this.f2754b.getMeasuredWidth());
            SearchBar.this.f2754b.setVisibility(8);
            SearchBar searchBar = SearchBar.this;
            searchBar.f2758f = searchBar.f2756d.getMeasuredWidth();
            SearchBar searchBar2 = SearchBar.this;
            searchBar2.f2760i = searchBar2.f2754b.getMeasuredWidth() - searchBar2.f2753a;
            SearchBar searchBar3 = SearchBar.this;
            searchBar3.f2759g = searchBar3.f2758f - searchBar3.f2760i;
            if (searchBar3.O && searchBar3.Q) {
                searchBar3.f2756d.setVisibility(8);
                SearchBar.this.f2754b.setVisibility(0);
                SearchBar.this.f2757e.setVisibility(0);
                SearchBar.this.G();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SearchBar.this.f2757e.getLayoutParams();
                SearchBar searchBar4 = SearchBar.this;
                layoutParams.width = searchBar4.f2759g;
                searchBar4.f2757e.setLayoutParams(layoutParams);
                float f10 = hj.h.I() ? -SearchBar.this.f2760i : SearchBar.this.f2760i;
                SearchBar.this.f2757e.setTranslationX(f10);
                SearchBar.this.f2755c.setTranslationX(f10);
            }
            SearchBar.this.D();
            return true;
        }
    }

    public class j extends AnimatorListenerAdapter {
        public j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SearchBar.this.f2754b.setClickable(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SearchBar.this.f2754b.setVisibility(0);
        }
    }

    public class k implements ValueAnimator.AnimatorUpdateListener {
        public k() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SearchBar.this.f2754b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public class l extends AnimatorListenerAdapter {
        public l() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SearchBar.this.f2754b.setClickable(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SearchBar.this.f2754b.setVisibility(0);
        }
    }

    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchBar.this.H();
        }
    }

    public static class n extends InputFilter.LengthFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<Context> f2781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Toast f2783c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f2784d;

        public n(Context context, int i10, String str) {
            super(i10);
            if (context != null) {
                this.f2781a = new WeakReference<>(context);
                this.f2782b = i10;
                this.f2784d = str;
            }
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
            CharSequence charSequenceFilter = super.filter(charSequence, i10, i11, spanned, i12, i13);
            if (spanned == null) {
                return charSequenceFilter;
            }
            int length = spanned.length();
            Context context = this.f2781a.get();
            if (context == null || length < this.f2782b || length == 0 || charSequenceFilter == null || TextUtils.isEmpty(this.f2784d)) {
                return charSequenceFilter;
            }
            if (this.f2783c == null) {
                this.f2783c = Toast.makeText(context, this.f2784d, 1);
            }
            this.f2783c.show();
            return charSequenceFilter;
        }
    }

    public interface o {
        void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10);
    }

    public interface p {
        void a();

        void b();
    }

    public class q implements TextWatcher {
        public q() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean unused = SearchBar.this.I;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            boolean unused = SearchBar.this.I;
        }

        @Override // android.text.TextWatcher
        @CallSuper
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            SearchBar.this.D();
            SearchBar.this.F();
            boolean z10 = SearchBar.this.I;
        }
    }

    public class r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f2786a;

        public r(View view) {
            this.f2786a = view;
        }

        public int a() {
            return this.f2786a.getLayoutParams().width;
        }

        public void b(int i10) {
            this.f2786a.getLayoutParams().width = i10;
            this.f2786a.requestLayout();
        }
    }

    public SearchBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.H = new q();
        this.J = new m();
        LayoutInflater.from(context).inflate(R.layout.os_search_bar_layout, this);
        this.N = context.getResources().getDimensionPixelSize(R.dimen.os_search_bar_delete_margin);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OSSearchBar);
        this.O = typedArrayObtainStyledAttributes.getBoolean(R.styleable.OSSearchBar_isBackMode, true);
        this.V = typedArrayObtainStyledAttributes.getDrawable(R.styleable.OSSearchBar_osSearchBarIconInEdittext);
        this.Q = typedArrayObtainStyledAttributes.getBoolean(R.styleable.OSSearchBar_isSearStatusOnInitial, false);
        this.T = context.getResources().getDimensionPixelOffset(R.dimen.os_search_bar_text_padding_end_with_del_icon);
        this.U = context.getResources().getDimensionPixelOffset(R.dimen.os_search_bar_text_padding_end);
        typedArrayObtainStyledAttributes.recycle();
        K();
        J();
        N();
        E();
        F();
        this.R = new r(this.f2757e);
        this.S = new r(this.f2756d);
    }

    public final void A() {
        boolean z10 = getLayoutDirection() == 1;
        int width = this.f2754b.getWidth();
        if (!z10) {
            width = -width;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f2754b, "translationX", 0.0f, width);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.R, "width", this.f2759g, this.f2758f);
        float f10 = z10 ? -this.f2760i : this.f2760i;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f2757e, "translationX", f10, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f2755c, "translationX", f10, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.setInterpolator(new pj.c(0.4f, 0.0f, 0.2f, 1.0f));
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfInt, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        animatorSet.addListener(new a());
        animatorSet.start();
    }

    public final AnimatorSet B() {
        boolean z10 = getLayoutDirection() == 1;
        int width = this.f2754b.getWidth();
        if (!z10) {
            width = -width;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f2754b, "translationX", 0.0f, width);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.S, "width", this.f2759g, this.f2758f);
        float f10 = z10 ? -this.f2760i : this.f2760i;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f2756d, "translationX", f10, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f2755c, "translationX", f10, 0.0f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(100L);
        valueAnimatorOfFloat.setInterpolator(new pj.c(0.33f, 0.0f, 0.66f, 1.0f));
        valueAnimatorOfFloat.addUpdateListener(new b());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.setInterpolator(new pj.c(0.25f, 0.0f, 0.0f, 1.0f));
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfInt, objectAnimatorOfFloat2, objectAnimatorOfFloat3, valueAnimatorOfFloat);
        animatorSet.addListener(new c());
        return animatorSet;
    }

    public final void C() {
        if (this.f2765x.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2765x.getLayoutParams();
            if (this.f2763v.getVisibility() == 0) {
                layoutParams.setMarginStart(getResources().getDimensionPixelSize(R.dimen.os_element_common_margin));
            } else {
                layoutParams.setMarginStart(0);
            }
            this.f2765x.setLayoutParams(layoutParams);
        }
    }

    public final void D() {
        if (TextUtils.isEmpty(this.f2757e.getText()) || this.f2757e.getText().toString().length() <= 0 || this.f2757e.getVisibility() != 0 || this.f2756d.getVisibility() == 0 || !M()) {
            if (this.f2763v.getVisibility() != 8) {
                this.f2763v.setVisibility(8);
            }
        } else if (this.f2763v.getVisibility() != 0) {
            this.f2763v.setVisibility(0);
        }
        C();
    }

    public final void E() {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.osSearchBarMargin});
        this.f2753a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.os_search_bar_margin_hios));
        typedArrayObtainStyledAttributes.recycle();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f2766y.getLayoutParams();
        if (this.O) {
            layoutParams.setMarginEnd(getContext().getResources().getDimensionPixelSize(R.dimen.os_search_bar_margin_xos) + this.N);
        } else {
            layoutParams.setMarginEnd(this.f2753a + this.N);
        }
        this.f2766y.setLayoutParams(layoutParams);
    }

    public final void F() {
        int dimensionPixelSize;
        if (this.f2757e.getText() == null || TextUtils.isEmpty(this.f2757e.getText().toString()) || !M()) {
            dimensionPixelSize = this.U;
            if (this.f2765x.getVisibility() == 0) {
                dimensionPixelSize = this.T;
            }
        } else {
            dimensionPixelSize = this.T;
            if (this.f2765x.getVisibility() == 0) {
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.os_search_cus_icon_in_edittext_size) + getResources().getDimensionPixelSize(R.dimen.os_element_common_margin) + this.T;
            }
        }
        AutoCompleteTextView autoCompleteTextView = this.f2757e;
        autoCompleteTextView.setPaddingRelative(autoCompleteTextView.getPaddingStart(), this.f2757e.getPaddingTop(), dimensionPixelSize, this.f2757e.getPaddingBottom());
        int dimensionPixelSize2 = this.f2765x.getVisibility() == 0 ? getResources().getDimensionPixelSize(R.dimen.os_search_bar_text_padding_end_with_del_icon) : getResources().getDimensionPixelSize(R.dimen.os_search_bar_text_padding_end);
        TextView textView = this.f2756d;
        textView.setPaddingRelative(textView.getPaddingStart(), this.f2756d.getPaddingTop(), dimensionPixelSize2, this.f2756d.getPaddingBottom());
        C();
    }

    public final void G() {
        if (hj.h.f7214g[0].equalsIgnoreCase(hj.h.o()) && this.f2764w.getVisibility() == 8) {
            this.f2759g = (this.f2758f - this.f2760i) - ui.a.d(getContext(), 6);
        }
    }

    public void H() {
        this.f2767z = false;
        D();
        F();
        this.f2757e.setText((CharSequence) null);
        this.f2754b.setClickable(false);
        A();
        p pVar = this.f2762p;
        if (pVar != null) {
            pVar.a();
        }
    }

    public AnimatorSet I() {
        return B();
    }

    public final void J() {
        this.f2756d.setOnClickListener(new d());
        this.f2754b.setOnClickListener(this.J);
        this.f2757e.setOnItemClickListener(new e());
        this.f2763v.setOnClickListener(new f());
        this.f2764w.setOnClickListener(new g());
        this.f2765x.setOnClickListener(new h());
    }

    public final void K() {
        this.f2756d = (TextView) findViewById(R.id.text_click);
        this.f2757e = (AutoCompleteTextView) findViewById(R.id.text_search);
        this.f2754b = (ImageView) findViewById(R.id.img_btn_back);
        this.f2755c = (ImageView) findViewById(R.id.img_search_icon);
        this.f2763v = (ImageView) findViewById(R.id.img_delete_all);
        this.f2764w = (ImageView) findViewById(R.id.img_custom);
        this.f2766y = (LinearLayout) findViewById(R.id.ll_del_custom_container);
        ImageView imageView = (ImageView) findViewById(R.id.img_custom_in_edittext);
        this.f2765x = imageView;
        if (this.V != null) {
            imageView.setVisibility(0);
            this.f2765x.setImageDrawable(this.V);
        }
        if (this.O) {
            return;
        }
        this.f2756d.setVisibility(8);
        this.f2757e.setVisibility(0);
        V();
    }

    public boolean L() {
        return this.f2767z;
    }

    public boolean M() {
        return this.f2757e.isEnabled();
    }

    public final void N() {
        getViewTreeObserver().addOnPreDrawListener(new i());
    }

    public void O(TextWatcher textWatcher) {
        this.f2757e.removeTextChangedListener(textWatcher);
    }

    public void P(TextWatcher textWatcher) {
        this.f2757e.removeTextChangedListener(textWatcher);
    }

    public void Q(int i10, int i11) {
        R(i10, getResources().getString(i11));
    }

    public void R(int i10, String str) {
        this.f2757e.setFilters(new InputFilter[]{new n(getContext(), i10, str)});
    }

    public void S(int i10, View.OnClickListener onClickListener) {
        this.K = onClickListener;
        this.f2764w.setVisibility(0);
        this.f2764w.setImageResource(i10);
        Y(true);
    }

    public void T(Context context, List<String> list) {
        this.f2757e.setAdapter(new ArrayAdapter(context, R.layout.os_search_source_item_layout, R.id.search_item_text, list));
    }

    public void U(CharSequence charSequence, boolean z10) {
        this.I = true;
        this.f2757e.setText(charSequence);
        this.I = false;
        if (z10) {
            W();
        }
    }

    public final void V() {
        AutoCompleteTextView autoCompleteTextView = this.f2757e;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(InputMethodManager.class);
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.f2757e, 0);
            }
        }
    }

    public void W() {
        this.f2767z = true;
        this.f2756d.setVisibility(8);
        this.f2757e.setVisibility(0);
        y();
        V();
        D();
        F();
        p pVar = this.f2762p;
        if (pVar != null) {
            pVar.b();
        }
    }

    public AnimatorSet X() {
        return z();
    }

    public final void Y(boolean z10) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f2757e.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f2756d.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f2766y.getLayoutParams();
        layoutParams.setMarginEnd(z10 ? 0 : this.f2753a);
        layoutParams2.setMarginEnd(z10 ? 0 : this.f2753a);
        layoutParams3.setMarginEnd(z10 ? this.N : this.N + this.f2753a);
        this.f2757e.setLayoutParams(layoutParams);
        this.f2756d.setLayoutParams(layoutParams2);
        this.f2766y.setLayoutParams(layoutParams3);
    }

    public void Z() {
        ImageView imageView = this.f2755c;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        ImageView imageView2 = this.f2754b;
        if (imageView2 != null) {
            imageView2.setVisibility(4);
        }
    }

    public void a0() {
        ImageView imageView = this.f2755c;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = this.f2754b;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
    }

    public EditText getEditText() {
        return this.f2757e;
    }

    public boolean getRightIconVisibility() {
        return this.f2764w.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2757e.addTextChangedListener(this.H);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2757e.removeTextChangedListener(this.H);
    }

    public <T extends ListAdapter & Filterable> void setAdapter(T t10) {
        this.f2757e.setAdapter(t10);
    }

    public void setBackClickListener(View.OnClickListener onClickListener) {
        this.J = onClickListener;
        this.f2754b.setOnClickListener(onClickListener);
    }

    public void setCustomIconInEdittextClickListener(View.OnClickListener onClickListener) {
        this.M = onClickListener;
    }

    public void setCustomSearchIcon(@DrawableRes int i10) {
        ImageView imageView = this.f2755c;
        if (imageView != null) {
            imageView.setImageResource(i10);
        }
    }

    public void setDeleteButtonVisibility(int i10) {
        this.f2763v.setVisibility(0);
    }

    public void setHint(CharSequence charSequence) {
        this.f2756d.setText(charSequence);
        this.f2757e.setHint(charSequence);
    }

    public void setIsIDLE(boolean z10) {
        this.P = z10;
    }

    public void setOnItemClickListener(o oVar) {
        this.f2761n = oVar;
    }

    public void setOnStateChangeListener(p pVar) {
        this.f2762p = pVar;
    }

    public void setRightIcon(int i10) {
        S(i10, null);
    }

    public void setRightIconVisibility(boolean z10) {
        this.f2764w.setVisibility(z10 ? 0 : 8);
        Y(z10);
    }

    public void setSearchBarClickListener(View.OnClickListener onClickListener) {
        this.L = onClickListener;
    }

    public void setSearchBarEnabled(boolean z10) {
        AutoCompleteTextView autoCompleteTextView = this.f2757e;
        if (autoCompleteTextView == null || this.f2755c == null || this.f2756d == null) {
            return;
        }
        autoCompleteTextView.setEnabled(z10);
        this.f2756d.setEnabled(z10);
        if (z10) {
            this.f2757e.requestFocus();
            this.f2757e.setAlpha(1.0f);
            this.f2755c.setAlpha(1.0f);
            this.f2756d.setAlpha(1.0f);
        } else {
            this.f2757e.setAlpha(0.65f);
            this.f2755c.setAlpha(0.65f);
            this.f2756d.setAlpha(0.65f);
        }
        D();
        F();
    }

    public void setSearchBarIconInEdittext(Drawable drawable) {
        if (drawable != null) {
            this.V = drawable;
            this.f2765x.setVisibility(0);
            this.f2765x.setImageDrawable(drawable);
        } else if (this.f2765x.getVisibility() == 0) {
            this.f2765x.setVisibility(8);
        }
        F();
    }

    @Deprecated
    public void setTextWatcher(TextWatcher textWatcher) {
        if (textWatcher == null) {
            return;
        }
        this.f2757e.removeTextChangedListener(this.H);
        this.H = textWatcher;
        this.f2757e.addTextChangedListener(textWatcher);
    }

    public void w(TextWatcher textWatcher) {
        if (textWatcher == null) {
            return;
        }
        this.f2757e.addTextChangedListener(textWatcher);
    }

    public final int x(int i10) {
        return (int) TypedValue.applyDimension(1, i10, getResources().getDisplayMetrics());
    }

    public final void y() {
        G();
        boolean z10 = getLayoutDirection() == 1;
        int width = this.f2754b.getWidth();
        if (!z10) {
            width = -width;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f2754b, "translationX", width, 0.0f);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.R, "width", this.f2758f, this.f2759g);
        float f10 = z10 ? -this.f2760i : this.f2760i;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f2757e, "translationX", 0.0f, f10);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f2755c, "translationX", 0.0f, f10);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.setInterpolator(new pj.c(0.4f, 0.0f, 0.2f, 1.0f));
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfInt, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        animatorSet.addListener(new j());
        animatorSet.start();
    }

    public final AnimatorSet z() {
        G();
        boolean z10 = getLayoutDirection() == 1;
        int width = this.f2754b.getWidth();
        if (!z10) {
            width = -width;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f2754b, "translationX", width, 0.0f);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.S, "width", this.f2758f, this.f2759g);
        float f10 = z10 ? -this.f2760i : this.f2760i;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f2756d, "translationX", 0.0f, f10);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f2755c, "translationX", 0.0f, f10);
        this.f2754b.setAlpha(0.0f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setStartDelay(67L);
        valueAnimatorOfFloat.setDuration(183L);
        valueAnimatorOfFloat.setInterpolator(new pj.c(0.33f, 0.0f, 0.66f, 1.0f));
        valueAnimatorOfFloat.addUpdateListener(new k());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.setInterpolator(new pj.c(0.25f, 0.0f, 0.0f, 1.0f));
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfInt, objectAnimatorOfFloat2, objectAnimatorOfFloat3, valueAnimatorOfFloat);
        animatorSet.addListener(new l());
        return animatorSet;
    }

    public void setHint(int i10) {
        setHint(getResources().getString(i10));
    }

    public void setSearchBarIconInEdittext(int i10) {
        setSearchBarIconInEdittext(getResources().getDrawable(i10));
    }
}
