package com.transsion.widgetslib.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.transsion.widgetslib.R;
import com.transsion.widgetslib.view.BadgeView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FootOperationBar extends RelativeLayout {

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f2672f0 = 5;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f2673g0 = 3;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int f2674h0 = 150;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public int L;
    public int M;
    public List<View> N;
    public Context O;
    public int P;
    public int Q;
    public final o R;
    public int S;
    public float T;
    public int U;
    public final int V;
    public final int W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2675a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f2676a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f2677b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f2678b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f2679c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public yi.b f2680c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f2681d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public ViewTreeObserver.OnDrawListener f2682d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ListPopupWindow f2683e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public View f2684e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f2685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2686g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2687i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2688n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean[] f2689p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2690v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2691w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2692x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2693y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2694z;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FootOperationBar.this.setVisibility(8);
            FootOperationBar.this.f2687i = false;
            View view = FootOperationBar.this.f2685f;
            if (view != null) {
                view.setEnabled(true);
            }
            FootOperationBar.this.getViewTreeObserver().removeOnPreDrawListener(FootOperationBar.this.R);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Paint f2696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2697b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ShapeDrawable f2698c;

        public b(Paint paint, int i10, ShapeDrawable shapeDrawable) {
            this.f2696a = paint;
            this.f2697b = i10;
            this.f2698c = shapeDrawable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2696a.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, FootOperationBar.this.getMeasuredHeight(), this.f2697b, FootOperationBar.this.U, Shader.TileMode.CLAMP));
            FootOperationBar.this.f2677b.setBackground(this.f2698c);
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2700a;

        public c(View view) {
            this.f2700a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f2700a.setVisibility(8);
            this.f2700a.setScaleX(1.0f);
            this.f2700a.setScaleY(1.0f);
            this.f2700a.setAlpha(1.0f);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f2703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f2704c;

        public d(View view, View view2, boolean z10) {
            this.f2702a = view;
            this.f2703b = view2;
            this.f2704c = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Rect rect = new Rect();
            this.f2702a.getHitRect(rect);
            Rect rect2 = new Rect();
            this.f2703b.getHitRect(rect2);
            rect.top = 0;
            rect.bottom = rect2.height();
            if (this.f2704c) {
                rect.left = FootOperationBar.this.V;
                rect.right = rect2.width() - FootOperationBar.this.V;
            } else {
                rect.left -= FootOperationBar.this.W;
                rect.right += FootOperationBar.this.W;
                this.f2702a.setTag(rect);
            }
            this.f2703b.setTouchDelegate(new TouchDelegate(rect, this.f2702a));
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FootOperationBar.this.f2685f.setSelected(true);
            FootOperationBar.this.f2683e.show();
        }
    }

    public class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2707a;

        public f(int i10) {
            this.f2707a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FootOperationBar.this.f2679c != null) {
                FootOperationBar.this.f2679c.a(this.f2707a);
                FootOperationBar footOperationBar = FootOperationBar.this;
                if (footOperationBar.J) {
                    footOperationBar.setItemSelectState(this.f2707a);
                } else {
                    footOperationBar.e0(this.f2707a, true);
                }
            }
        }
    }

    public class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2709a;

        public g(int i10) {
            this.f2709a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FootOperationBar.this.f2679c != null) {
                FootOperationBar.this.f2679c.a(this.f2709a);
                FootOperationBar footOperationBar = FootOperationBar.this;
                if (footOperationBar.J) {
                    footOperationBar.setItemSelectState(this.f2709a);
                } else {
                    footOperationBar.e0(this.f2709a, true);
                }
            }
        }
    }

    public class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f2711a;

        public h(TextView textView) {
            this.f2711a = textView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f2711a.setTextColor(FootOperationBar.this.f2692x);
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LinearLayout f2714b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ImageView f2715c;

        public i(View view, LinearLayout linearLayout, ImageView imageView) {
            this.f2713a = view;
            this.f2714b = linearLayout;
            this.f2715c = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Space space = (Space) this.f2713a.findViewById(R.id.os_foot_opt_space);
            if (space == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = space.getLayoutParams();
            int measuredWidth = FootOperationBar.this.f2676a0 ? this.f2714b.getMeasuredWidth() : this.f2715c.getMeasuredWidth();
            if (measuredWidth > 0) {
                layoutParams.width = measuredWidth;
            }
            int measuredHeight = this.f2714b.getMeasuredHeight();
            if (measuredHeight > 0) {
                layoutParams.height = measuredHeight;
            }
            space.setLayoutParams(layoutParams);
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FootOperationBar.this.f2685f.setSelected(true);
            ListPopupWindow listPopupWindow = FootOperationBar.this.f2683e;
            if (listPopupWindow == null || listPopupWindow.isShowing()) {
                return;
            }
            FootOperationBar.this.f2683e.show();
        }
    }

    public class k implements PopupWindow.OnDismissListener {
        public k() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            FootOperationBar.this.f2685f.setSelected(false);
        }
    }

    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Display display = FootOperationBar.this.getDisplay();
            if (display == null || display.getCutout() == null) {
                return;
            }
            FootOperationBar.this.f2683e.setHorizontalOffset(-display.getCutout().getSafeInsetRight());
        }
    }

    public class m extends AnimatorListenerAdapter {
        public m() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            FootOperationBar.this.f2687i = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            FootOperationBar.this.setVisibility(0);
        }
    }

    public class n extends BaseAdapter {

        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f2722a;

            public a(int i10) {
                this.f2722a = i10;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FootOperationBar.this.f2679c != null) {
                    FootOperationBar.this.f2679c.a(this.f2722a);
                }
                FootOperationBar.this.f2683e.dismiss();
            }
        }

        public class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public TextView f2724a;

            public b() {
            }

            public /* synthetic */ b(n nVar, e eVar) {
                this();
            }
        }

        public n() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return FootOperationBar.this.f2681d.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            return FootOperationBar.this.f2681d.get(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(FootOperationBar.this.getContext()).inflate(R.layout.os_foot_opt_bar_popup_item, viewGroup, false);
                bVar = new b();
                bVar.f2724a = (TextView) view.findViewById(R.id.os_foot_opt_bar_popup_item_text);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.f2724a.setText((CharSequence) FootOperationBar.this.f2681d.get(i10));
            FootOperationBar footOperationBar = FootOperationBar.this;
            footOperationBar.l0(view, footOperationBar.f2689p[i10]);
            view.setOnClickListener(new a(i10 + FootOperationBar.this.M));
            return view;
        }

        public /* synthetic */ n(FootOperationBar footOperationBar, e eVar) {
            this();
        }
    }

    public static class o implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<FootOperationBar> f2726a;

        public o(FootOperationBar footOperationBar) {
            this.f2726a = new WeakReference<>(footOperationBar);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            FootOperationBar footOperationBar = this.f2726a.get();
            if (footOperationBar == null) {
                return true;
            }
            footOperationBar.getViewTreeObserver().removeOnPreDrawListener(this);
            footOperationBar.setVisibility(8);
            if (!footOperationBar.f2688n && !footOperationBar.f2686g) {
                return true;
            }
            footOperationBar.setVisibility(0);
            footOperationBar.W();
            return true;
        }
    }

    public interface p {
        void a(int i10);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface q {
    }

    public FootOperationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2686g = false;
        this.f2687i = false;
        this.f2688n = false;
        this.K = true;
        this.N = new ArrayList();
        this.S = -1;
        this.T = 0.9f;
        this.O = context;
        this.f2675a = getResources().getDisplayMetrics().widthPixels;
        LayoutInflater.from(context).inflate(R.layout.os_foot_opt_bar_root, this);
        this.f2677b = (LinearLayout) findViewById(R.id.os_foot_opt_bar_container);
        this.f2681d = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FootOperationBar);
        this.J = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FootOperationBar_isFootActionBar, false);
        this.K = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FootOperationBar_foot_need_change_img_color, false);
        this.Q = typedArrayObtainStyledAttributes.getResourceId(R.styleable.FootOperationBar_foot_item_background, R.drawable.os_foot_option_bar_item_bg);
        this.S = typedArrayObtainStyledAttributes.getColor(R.styleable.FootOperationBar_foot_item_icon_tint, ContextCompat.getColor(this.O, R.color.os_fill_icon_primary_color));
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(new int[]{R.attr.os_platform_basic_color, R.attr.os_foot_more});
        int color = typedArrayObtainStyledAttributes2.getColor(0, getResources().getColor(R.color.os_platform_basic_color_hios));
        this.P = typedArrayObtainStyledAttributes2.getResourceId(1, R.drawable.os_ic_foot_more_hios);
        typedArrayObtainStyledAttributes2.recycle();
        if (this.J) {
            int color2 = ContextCompat.getColor(this.O, R.color.os_fill_icon_primary_color);
            this.f2694z = color2;
            this.f2693y = Color.argb(51, Color.red(color2), Color.green(this.f2694z), Color.blue(this.f2694z));
            int color3 = ContextCompat.getColor(this.O, R.color.os_text_primary_color);
            this.f2690v = color3;
            this.f2692x = Color.argb(51, Color.red(color3), Color.green(this.f2690v), Color.blue(this.f2690v));
        } else {
            this.f2694z = ContextCompat.getColor(this.O, R.color.os_fill_icon_secondary_color);
            this.f2693y = hj.h.n(this.O);
            this.f2690v = ContextCompat.getColor(this.O, R.color.os_text_tertiary_color);
            this.f2692x = this.f2693y;
        }
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R.styleable.FootOperationBar_foot_click_image_color);
        this.I = zHasValue;
        if (zHasValue) {
            this.f2693y = typedArrayObtainStyledAttributes.getColor(R.styleable.FootOperationBar_foot_click_image_color, -1);
        }
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(R.styleable.FootOperationBar_foot_normal_image_color);
        this.H = zHasValue2;
        if (zHasValue2) {
            this.f2694z = typedArrayObtainStyledAttributes.getColor(R.styleable.FootOperationBar_foot_normal_image_color, -65536);
        }
        boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(R.styleable.FootOperationBar_foot_text_color);
        this.f2691w = zHasValue3;
        if (zHasValue3) {
            this.f2690v = typedArrayObtainStyledAttributes.getColor(R.styleable.FootOperationBar_foot_text_color, getResources().getColor(R.color.os_text_secondary_color));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.FootOperationBar_foot_click_text_color)) {
            this.f2692x = typedArrayObtainStyledAttributes.getColor(R.styleable.FootOperationBar_foot_click_text_color, color);
        }
        int i10 = typedArrayObtainStyledAttributes.getInt(R.styleable.FootOperationBar_foot_max_visible_tab_count, 5);
        this.L = i10;
        if (i10 < 3) {
            this.L = 3;
        }
        S(context);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.FootOperationBar_foot_opt_menu)) {
            R(typedArrayObtainStyledAttributes.getResourceId(R.styleable.FootOperationBar_foot_opt_menu, 0));
        }
        this.f2688n = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FootOperationBar_foot_init_show, false);
        typedArrayObtainStyledAttributes.recycle();
        o oVar = new o(this);
        this.R = oVar;
        getViewTreeObserver().addOnPreDrawListener(oVar);
        setClickable(true);
        this.V = (int) TypedValue.applyDimension(1, 12.0f, getResources().getDisplayMetrics());
        this.W = (int) TypedValue.applyDimension(1, 6.0f, getResources().getDisplayMetrics());
        this.f2678b0 = getResources().getConfiguration().orientation;
    }

    private void setContainerWidth(int i10) {
        float fApplyDimension;
        int dimensionPixelSize;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    fApplyDimension = TypedValue.applyDimension(1, this.f2676a0 ? 16.66f : 18.0f, displayMetrics);
                } else {
                    if (i10 != 4) {
                        if (i10 != 5) {
                            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.os_foot_bar_padding);
                            if (hj.h.K(this.O)) {
                                dimensionPixelSize += this.O.getResources().getDimensionPixelSize(R.dimen.os_curve_land);
                            }
                        } else {
                            fApplyDimension = TypedValue.applyDimension(1, this.f2676a0 ? 17.66f : 10.0f, displayMetrics);
                        }
                        ViewGroup.LayoutParams layoutParams = this.f2677b.getLayoutParams();
                        layoutParams.width = -1;
                        this.f2677b.setLayoutParams(layoutParams);
                        LinearLayout linearLayout = this.f2677b;
                        linearLayout.setPadding(dimensionPixelSize, linearLayout.getPaddingTop(), dimensionPixelSize, this.f2677b.getPaddingBottom());
                    }
                    fApplyDimension = TypedValue.applyDimension(1, this.f2676a0 ? 16.66f : 16.0f, displayMetrics);
                }
            } else {
                fApplyDimension = TypedValue.applyDimension(1, this.f2676a0 ? 48.66f : 18.0f, displayMetrics);
            }
        } else {
            fApplyDimension = TypedValue.applyDimension(1, this.f2676a0 ? 210.0f : 99.0f, displayMetrics);
        }
        dimensionPixelSize = (int) fApplyDimension;
        ViewGroup.LayoutParams layoutParams2 = this.f2677b.getLayoutParams();
        layoutParams2.width = -1;
        this.f2677b.setLayoutParams(layoutParams2);
        LinearLayout linearLayout2 = this.f2677b;
        linearLayout2.setPadding(dimensionPixelSize, linearLayout2.getPaddingTop(), dimensionPixelSize, this.f2677b.getPaddingBottom());
    }

    private void setImageColorStateList(ImageView imageView) {
        int[][] iArr = new int[2][];
        if (this.J) {
            iArr[0] = new int[]{android.R.attr.state_pressed};
        } else {
            iArr[0] = new int[]{android.R.attr.state_selected};
        }
        iArr[1] = new int[0];
        imageView.setImageTintList(new ColorStateList(iArr, new int[]{this.f2693y, this.f2694z}));
    }

    @b.a({"RestrictedApi"})
    private void setMenu(MenuBuilder menuBuilder) {
        this.f2677b.removeAllViews();
        this.f2681d.clear();
        this.f2683e = null;
        int size = menuBuilder.size();
        setContainerWidth(size);
        if (this.J) {
            int i10 = this.L;
            if (size > i10 - 1) {
                int i11 = i10 > 5 ? 4 : i10 - 1;
                this.M = i11;
                u(menuBuilder, i11);
                View viewO = O(this.P, this.O.getResources().getString(R.string.os_foot_opt_bar_more));
                View viewFindViewById = viewO.findViewById(R.id.os_fob_layout);
                this.f2685f = viewFindViewById;
                viewFindViewById.setOnClickListener(new e());
                this.f2677b.addView(viewO);
                f0(menuBuilder, size);
                return;
            }
        }
        u(menuBuilder, size);
    }

    public void A(int i10, Drawable drawable, String str) {
        View childAt = this.f2677b.getChildAt(i10);
        if (childAt == null) {
            return;
        }
        ImageView imageView = (ImageView) childAt.findViewById(R.id.os_foot_opt_bar_item_icon);
        if (drawable != null) {
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(drawable);
        }
        if (str != null) {
            ((TextView) childAt.findViewById(R.id.os_foot_opt_bar_item_text)).setText(str);
        }
    }

    public void B(int i10, String str) {
        A(i10, null, str);
    }

    public void C(int i10, boolean z10) {
        if (this.f2683e == null) {
            l0(this.f2677b.getChildAt(i10), z10);
            return;
        }
        int i11 = this.M;
        if (i10 < i11) {
            l0(this.f2677b.getChildAt(i10), z10);
        } else {
            this.f2689p[i10 - i11] = z10;
        }
    }

    public void D(int[] iArr, int[] iArr2) {
        String[] strArr = new String[iArr2.length];
        for (int i10 = 0; i10 < iArr2.length; i10++) {
            strArr[i10] = this.O.getResources().getString(iArr2[i10]);
        }
        E(iArr, strArr);
    }

    public void E(int[] iArr, String[] strArr) {
        ListPopupWindow listPopupWindow = this.f2683e;
        if (listPopupWindow != null && listPopupWindow.isShowing()) {
            this.f2683e.dismiss();
        }
        this.f2677b.removeAllViews();
        this.f2681d.clear();
        this.N.clear();
        this.f2683e = null;
        int length = iArr.length;
        setContainerWidth(length);
        if (this.J) {
            int i10 = this.L;
            if (length > i10 - 1) {
                int i11 = i10 > 5 ? 4 : i10 - 1;
                this.M = i11;
                v(iArr, strArr, i11);
                View viewO = O(this.P, this.O.getResources().getString(R.string.os_foot_opt_bar_more));
                View viewFindViewById = viewO.findViewById(R.id.os_fob_layout);
                this.f2685f = viewFindViewById;
                viewFindViewById.setOnClickListener(new j());
                this.f2677b.addView(viewO);
                g0(strArr, length);
                return;
            }
        }
        v(iArr, strArr, length);
    }

    public void F(boolean[] zArr) {
        ListPopupWindow listPopupWindow = this.f2683e;
        if (listPopupWindow != null && listPopupWindow.isShowing()) {
            this.f2683e.dismiss();
        }
        int iMin = Math.min(zArr.length, getItemCount());
        for (int i10 = 0; i10 < iMin; i10++) {
            C(i10, zArr[i10]);
        }
    }

    public final void G() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(new pj.c(0.33f, 0.0f, 0.66f, 1.0f));
        objectAnimatorOfFloat.setDuration(150L);
        objectAnimatorOfFloat.addListener(new a());
        objectAnimatorOfFloat.start();
    }

    public void H() {
    }

    public void I() {
    }

    public void J() {
        if (this.f2687i || !this.f2686g) {
            return;
        }
        ListPopupWindow listPopupWindow = this.f2683e;
        if (listPopupWindow != null && listPopupWindow.isShowing()) {
            this.f2683e.dismiss();
        }
        View view = this.f2685f;
        if (view != null) {
            view.setEnabled(false);
        }
        this.f2687i = true;
        this.f2686g = false;
        G();
    }

    public void K(boolean z10) {
        ListPopupWindow listPopupWindow;
        View view = this.f2685f;
        if (view != null) {
            l0(view, z10);
            if (z10 || (listPopupWindow = this.f2683e) == null || !listPopupWindow.isShowing()) {
                return;
            }
            this.f2683e.dismiss();
        }
    }

    public void L() {
        for (View view : this.N) {
            M(view.findViewById(R.id.os_fob_layout), view, true);
        }
    }

    public final void M(View view, View view2, boolean z10) {
        view2.post(new d(view, view2, z10));
    }

    @Nullable
    public BadgeView N(int i10) {
        List<View> list = this.N;
        if (list == null || this.J) {
            return null;
        }
        int size = list.size();
        if (i10 < 0 || i10 > size - 1) {
            return null;
        }
        TextView textView = (TextView) this.N.get(i10).findViewById(R.id.os_foot_opt_bar_item_text);
        if (textView.getTag() == null) {
            BadgeView badgeView = (BadgeView) ((ViewStub) this.N.get(i10).findViewById(R.id.os_stub_fpb_red_point)).inflate();
            textView.setTag(badgeView);
            return badgeView;
        }
        Object tag = textView.getTag();
        if (tag instanceof BadgeView) {
            return (BadgeView) tag;
        }
        return null;
    }

    public final View O(int i10, String str) {
        return P(this.O.getDrawable(i10), str);
    }

    public final View P(Drawable drawable, String str) {
        View viewInflate = this.J ? LayoutInflater.from(getContext()).inflate(R.layout.os_foot_action_bar_item, (ViewGroup) this.f2677b, false) : LayoutInflater.from(getContext()).inflate(R.layout.os_foot_opt_bar_item, (ViewGroup) this.f2677b, false);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.os_fob_layout);
        linearLayout.setOrientation(!this.f2676a0 ? 1 : 0);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.os_foot_opt_bar_item_icon);
        TextView textView = (TextView) viewInflate.findViewById(R.id.os_foot_opt_bar_item_text);
        if (drawable != null) {
            drawable.mutate();
            imageView.setImageDrawable(drawable);
            setImageColorStateList(imageView);
        }
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
            if (this.J) {
                textView.setTextColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{this.f2692x, this.f2690v}));
            } else {
                textView.setTextColor(this.f2690v);
            }
        }
        if (!this.J) {
            linearLayout.post(new i(viewInflate, linearLayout, imageView));
        }
        return viewInflate;
    }

    public boolean Q(int i10) {
        List<View> list = this.N;
        if (list == null || this.J) {
            return false;
        }
        int size = list.size();
        if (i10 < 0 || i10 > size - 1) {
            return false;
        }
        Object tag = ((TextView) this.N.get(i10).findViewById(R.id.os_foot_opt_bar_item_text)).getTag();
        return (tag instanceof BadgeView) && ((BadgeView) tag).getVisibility() == 0;
    }

    @b.a({"RestrictedApi"})
    public void R(int i10) {
        MenuInflater menuInflater = new MenuInflater(getContext());
        MenuBuilder menuBuilder = new MenuBuilder(getContext());
        menuInflater.inflate(i10, menuBuilder);
        setMenu(menuBuilder);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00ae  */
    public final void S(Context context) {
        int dimensionPixelSize;
        ViewStub viewStub;
        if (context == null) {
            return;
        }
        int dimensionPixelSize2 = 0;
        if (getBackground() == null) {
            if (hj.h.f7214g[0].equalsIgnoreCase(hj.h.o())) {
                this.U = ContextCompat.getColor(context, R.color.os_altitude_quaternary_color);
                if (!this.J && (viewStub = (ViewStub) findViewById(R.id.os_fob_top_line_stub)) != null) {
                    viewStub.inflate();
                }
            } else {
                this.U = ContextCompat.getColor(context, R.color.os_altitude_primary_color);
            }
            setBackgroundColor(this.U);
        }
        if (hj.h.K(this.O)) {
            int rotation = this.O.getDisplay().getRotation();
            int paddingLeft = this.f2677b.getPaddingLeft();
            int paddingTop = this.f2677b.getPaddingTop();
            int paddingRight = this.f2677b.getPaddingRight();
            int paddingBottom = this.f2677b.getPaddingBottom();
            if (rotation == 0) {
                dimensionPixelSize2 = this.O.getResources().getDimensionPixelSize(R.dimen.os_curve_land) + getResources().getDimensionPixelSize(R.dimen.os_foot_bar_padding);
                dimensionPixelSize = dimensionPixelSize2;
            } else if (rotation == 1) {
                int dimensionPixelSize3 = this.O.getResources().getDimensionPixelSize(R.dimen.os_curve_land);
                setMinimumHeight(getResources().getDimensionPixelSize(R.dimen.os_foot_bar_min_height_curve_land));
                dimensionPixelSize2 = dimensionPixelSize3;
                dimensionPixelSize = 0;
            } else if (rotation == 2) {
                dimensionPixelSize2 = this.O.getResources().getDimensionPixelSize(R.dimen.os_curve_land) + getResources().getDimensionPixelSize(R.dimen.os_foot_bar_padding);
                dimensionPixelSize = dimensionPixelSize2;
            } else if (rotation != 3) {
                dimensionPixelSize2 = paddingLeft;
                dimensionPixelSize = paddingRight;
            } else {
                dimensionPixelSize = this.O.getResources().getDimensionPixelSize(R.dimen.os_curve_land);
                setMinimumHeight(getResources().getDimensionPixelSize(R.dimen.os_foot_bar_min_height_curve_land));
            }
            this.f2677b.setPadding(dimensionPixelSize2, paddingTop, dimensionPixelSize, paddingBottom);
        }
        this.f2677b.setMinimumHeight(getMinimumHeight());
    }

    public void T(boolean z10) {
        this.f2688n = z10;
    }

    public final int U(ListAdapter listAdapter, int i10) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i11 = 0;
        int i12 = 0;
        View view = null;
        for (int i13 = 0; i13 < count; i13++) {
            int itemViewType = listAdapter.getItemViewType(i13);
            if (itemViewType != i12) {
                view = null;
                i12 = itemViewType;
            }
            view = listAdapter.getView(i13, view, null);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i10) {
                return i10;
            }
            if (measuredWidth > i11) {
                i11 = measuredWidth;
            }
        }
        return i11;
    }

    public final void V() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new pj.c(0.33f, 0.0f, 0.66f, 1.0f));
        objectAnimatorOfFloat.setDuration(150L);
        objectAnimatorOfFloat.addListener(new m());
        objectAnimatorOfFloat.start();
    }

    public void W() {
        if (this.f2687i || this.f2686g) {
            return;
        }
        this.f2687i = true;
        this.f2686g = true;
        V();
    }

    public final void X(View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        view.animate().alpha(0.0f).scaleX(0.5f).scaleY(0.5f).setInterpolator(new pj.c(0.4f, 0.0f, 1.0f, 1.0f)).setDuration(150L).setListener(new c(view)).start();
    }

    public void Y(int i10) {
        List<View> list = this.N;
        if (list == null || list.size() <= i10) {
            return;
        }
        List<View> list2 = this.N;
        list2.remove(list2.get(i10));
        this.f2677b.removeViewAt(i10);
        Z();
        requestLayout();
        invalidate();
    }

    public void Z() {
        for (int i10 = 0; i10 < this.N.size(); i10++) {
            View view = this.N.get(i10);
            View viewFindViewById = view.findViewById(R.id.os_fob_layout);
            M(viewFindViewById, view, false);
            viewFindViewById.setOnClickListener(new g(i10));
        }
    }

    public void a0() {
        for (View view : this.N) {
            View viewFindViewById = view.findViewById(R.id.os_fob_layout);
            Object tag = viewFindViewById.getTag();
            if (tag instanceof Rect) {
                view.setTouchDelegate(new TouchDelegate((Rect) tag, viewFindViewById));
            }
        }
    }

    public final void b0() {
        int iArgb = Color.argb((int) (this.T * Color.alpha(this.U)), Color.red(this.U), Color.green(this.U), Color.blue(this.U));
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        post(new b(shapeDrawable.getPaint(), iArgb, shapeDrawable));
    }

    public final void c0() {
        Drawable drawable;
        int dimensionPixelSize;
        n nVar = new n();
        ListPopupWindow listPopupWindow = new ListPopupWindow(getContext(), null, 0, R.style.OsFootOptPopupEdgeStyle);
        this.f2683e = listPopupWindow;
        listPopupWindow.setAdapter(nVar);
        int iU = U(nVar, this.f2675a / 2);
        this.f2683e.setContentWidth(iU);
        this.f2683e.setModal(true);
        this.f2683e.setOnDismissListener(new k());
        this.f2683e.setAnchorView(this.f2677b);
        this.f2683e.setDropDownGravity(GravityCompat.END);
        if (getResources().getConfiguration().orientation == 2) {
            post(new l());
        }
        if (hj.h.K(this.O)) {
            int rotation = this.O.getDisplay().getRotation();
            if (rotation == 1) {
                drawable = ContextCompat.getDrawable(this.O, R.drawable.os_foot_opt_popup_background_curse_90);
                dimensionPixelSize = this.O.getResources().getDimensionPixelSize(R.dimen.os_curse_offset_land);
            } else if (rotation != 3) {
                drawable = ContextCompat.getDrawable(this.O, R.drawable.os_foot_opt_popup_background_curse_0_180);
                dimensionPixelSize = this.O.getResources().getDimensionPixelSize(R.dimen.os_curse_offset_portrait);
            } else {
                drawable = ContextCompat.getDrawable(this.O, R.drawable.os_foot_opt_popup_background_curse_270);
                dimensionPixelSize = this.O.getResources().getDimensionPixelSize(R.dimen.os_curse_offset_land);
            }
            this.f2683e.setContentWidth(iU + dimensionPixelSize);
            this.f2683e.setBackgroundDrawable(drawable);
        }
    }

    public void d0(int i10, boolean z10, int i11, int i12) {
        BadgeView badgeViewN = N(i10);
        if (badgeViewN == null) {
            return;
        }
        if (badgeViewN.getRedPointType() != i11) {
            badgeViewN.setRedPointType(i11);
        }
        badgeViewN.setVisibility((i12 <= 0 || !z10) ? 8 : 0);
        if (badgeViewN.getVisibility() == 0) {
            badgeViewN.d(i12);
        }
    }

    public final void e0(int i10, boolean z10) {
        if (this.N != null) {
            for (int i11 = 0; i11 < this.N.size(); i11++) {
                TextView textView = (TextView) this.N.get(i11).findViewById(R.id.os_foot_opt_bar_item_text);
                OSMaskImageView oSMaskImageView = (OSMaskImageView) this.N.get(i11).findViewById(R.id.os_foot_opt_bar_item_icon);
                if (i11 == i10) {
                    if (oSMaskImageView.isSelected() || oSMaskImageView.n()) {
                        return;
                    }
                    if (z10) {
                        oSMaskImageView.o(true, new h(textView));
                    } else {
                        if (this.J) {
                            return;
                        }
                        oSMaskImageView.setSelected(true);
                        textView.setTextColor(this.f2692x);
                    }
                } else {
                    if (this.J) {
                        return;
                    }
                    if (oSMaskImageView.n()) {
                        oSMaskImageView.i();
                    }
                    textView.setTextColor(this.f2690v);
                    if (!z10) {
                        oSMaskImageView.setSelected(false);
                    } else if (oSMaskImageView.isSelected()) {
                        oSMaskImageView.setSelectedAnim(false);
                    }
                }
            }
        }
    }

    @b.a({"RestrictedApi"})
    public final void f0(MenuBuilder menuBuilder, int i10) {
        this.f2689p = new boolean[i10];
        int i11 = this.L;
        int i12 = i11 > 5 ? 4 : i11 - 1;
        this.M = i12;
        while (i12 < i10) {
            this.f2681d.add(menuBuilder.getItem(i12).getTitle().toString());
            this.f2689p[i12 - this.M] = true;
            i12++;
        }
        c0();
    }

    public final void g0(String[] strArr, int i10) {
        int i11 = this.M;
        this.f2689p = new boolean[i10 - i11];
        while (i11 < i10) {
            this.f2681d.add(strArr[i11]);
            this.f2689p[i11 - this.M] = true;
            i11++;
        }
        c0();
    }

    public int getItemCount() {
        if (this.f2681d.size() <= 0) {
            return this.f2677b.getChildCount();
        }
        return (this.f2681d.size() + this.f2677b.getChildCount()) - 1;
    }

    public void h0(View view) {
    }

    public void i0() {
        if (this.f2686g) {
            J();
        } else {
            W();
        }
    }

    public void j0() {
        this.f2675a = getResources().getDisplayMetrics().widthPixels;
        setContainerWidth(this.f2677b.getChildCount());
        ListPopupWindow listPopupWindow = this.f2683e;
        if (listPopupWindow == null || !listPopupWindow.isShowing()) {
            return;
        }
        this.f2683e.dismiss();
    }

    public void k0(int i10, int i11) {
        BadgeView badgeViewN = N(i10);
        if (badgeViewN == null) {
            return;
        }
        if (i11 <= 0) {
            X(badgeViewN);
            return;
        }
        if (badgeViewN.getVisibility() != 0) {
            badgeViewN.setVisibility(0);
        }
        badgeViewN.d(i11);
    }

    public final void l0(View view, boolean z10) {
        if (view != null) {
            View viewFindViewById = view.findViewById(R.id.os_fob_layout);
            if (viewFindViewById == null) {
                view.setEnabled(z10);
                view.setAlpha(z10 ? 1.0f : 0.4f);
            } else {
                viewFindViewById.setEnabled(z10);
                viewFindViewById.setAlpha(z10 ? 1.0f : 0.4f);
            }
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j0();
        if (this.f2686g) {
            int i10 = getResources().getConfiguration().orientation;
            if (this.f2678b0 != i10) {
                getViewTreeObserver().addOnPreDrawListener(this.R);
            }
            this.f2678b0 = i10;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        H();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        S(getContext());
    }

    public void setBlurAlp(@IntRange(from = 0, to = 255) int i10) {
        if (i10 < 0 || i10 > 255) {
            return;
        }
        this.T = (i10 * 1.0f) / 255.0f;
    }

    public void setContainerBackground(@ColorRes int i10) {
        setContainerBackgroundNoOverlay(i10);
    }

    public void setContainerBackgroundColor(@ColorInt int i10) {
        this.U = i10;
        setBackgroundColor(i10);
        if (this.f2684e0 == null || this.f2682d0 == null) {
            return;
        }
        b0();
    }

    public void setContainerBackgroundNoOverlay(@ColorRes int i10) {
        setContainerBackgroundColor(this.O.getResources().getColor(i10));
    }

    public void setFootOptBarClickTextColor(@ColorInt int i10) {
        this.f2692x = i10;
    }

    public void setFootOptBarTextColor(@ColorInt int i10) {
        this.f2690v = i10;
    }

    public void setItemSelectState(int i10) {
        e0(i10, false);
    }

    public void setLandscape(boolean z10) {
        this.f2676a0 = z10;
    }

    public void setOnFootOptBarClickListener(p pVar) {
        this.f2679c = pVar;
    }

    public final void t(View view, int i10) {
        this.N.add(view);
        View viewFindViewById = view.findViewById(R.id.os_fob_layout);
        M(viewFindViewById, view, false);
        viewFindViewById.setOnClickListener(new f(i10));
        this.f2677b.addView(view);
    }

    @b.a({"RestrictedApi"})
    public final void u(MenuBuilder menuBuilder, int i10) {
        this.N.clear();
        for (int i11 = 0; i11 < i10; i11++) {
            MenuItem item = menuBuilder.getItem(i11);
            t(P(item.getIcon(), item.getTitle().toString()), i11);
        }
    }

    public final void v(int[] iArr, String[] strArr, int i10) {
        this.N.clear();
        for (int i11 = 0; i11 < i10; i11++) {
            t(O(iArr[i11], strArr[i11]), i11);
        }
    }

    public void w(int i10, int i11, int i12) {
        View viewO = O(i10, this.O.getResources().getString(i11));
        this.N.add(viewO);
        Z();
        if (i12 < this.N.size()) {
            this.f2677b.addView(viewO, i12);
        } else {
            this.f2677b.addView(viewO);
        }
    }

    public void x(int i10, int i11, int i12) {
        y(i10, i11, getResources().getString(i12));
    }

    public void y(int i10, int i11, String str) {
        A(i10, ContextCompat.getDrawable(this.O, i11), str);
    }

    public void z(int i10, Drawable drawable) {
        A(i10, drawable, null);
    }
}
