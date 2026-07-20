package com.transsion.widgetslib.widget;

import af.m0;
import android.R;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.IntRange;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.collection.ScatterMapKt;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.GravityCompat;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$drawable;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.R$string;
import com.transsion.widgetslib.R$style;
import com.transsion.widgetslib.R$styleable;
import java.util.ArrayList;
import k3.kc;
import k3.yd;
import kd.d;
import ke.c;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import o.e;
import pd.j;
import r2.w;
import zd.b;
import zd.c0;
import zd.g;
import zd.h;

/* JADX INFO: loaded from: classes2.dex */
public class FootOperationBar extends RelativeLayout {
    public static final /* synthetic */ int H = 0;
    public int A;
    public d B;
    public final MenuBuilder C;
    public g D;
    public int E;
    public int F;
    public int G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f3369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f3370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ListPopupWindow f3371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f3372d;
    public boolean e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3373h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f3374i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean[] f3375j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3376k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3377l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3378m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3379n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f3380o;
    public final boolean p;
    public final int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f3381r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ArrayList f3382s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Context f3383t;
    public final int u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c f3384v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f3385w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3386x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f3387y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f3388z;

    public FootOperationBar(Context context, AttributeSet attributeSet) {
        ViewStub viewStub;
        super(context, attributeSet);
        this.e = false;
        this.f3373h = false;
        this.f3374i = false;
        this.p = true;
        this.f3382s = new ArrayList();
        this.f3385w = 0.8f;
        this.E = -1;
        this.f3383t = context;
        LayoutInflater.from(context).inflate(R$layout.os_foot_opt_bar_root, this);
        this.f3369a = (LinearLayout) findViewById(R$id.os_foot_opt_bar_container);
        this.f3370b = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FootOperationBar);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FootOperationBar_isFootActionBar, false);
        this.f3380o = z2;
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FootOperationBar_isFootBarOnlyPortrait, false);
        this.p = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FootOperationBar_foot_need_change_img_color, true);
        typedArrayObtainStyledAttributes.getResourceId(R$styleable.FootOperationBar_foot_item_background, R$drawable.os_foot_option_bar_item_bg);
        int i8 = R$styleable.FootOperationBar_foot_item_icon_tint;
        int i9 = R$attr.os_icon_secondary;
        int i10 = R$color.os_icon_secondary_hios;
        String[] strArr = j.f8764a;
        typedArrayObtainStyledAttributes.getColor(i8, j.d(i9, context.getColor(i10), context));
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(new int[]{R$attr.os_platform_basic_color, R$attr.os_foot_more});
        int color = typedArrayObtainStyledAttributes2.getColor(0, getResources().getColor(R$color.os_platform_basic_color_hios));
        this.u = typedArrayObtainStyledAttributes2.getResourceId(1, R$drawable.os_ic_foot_more_hios);
        typedArrayObtainStyledAttributes2.recycle();
        if (z2) {
            int iD = j.d(R$attr.os_icon_secondary, context.getColor(R$color.os_icon_secondary_hios), context);
            this.f3379n = iD;
            this.f3378m = Color.argb(51, Color.red(iD), Color.green(this.f3379n), Color.blue(this.f3379n));
            int iD2 = j.d(R$attr.os_text_primary, context.getColor(R$color.os_text_primary_hios), context);
            this.f3376k = iD2;
            this.f3377l = Color.argb(51, Color.red(iD2), Color.green(this.f3376k), Color.blue(this.f3376k));
        } else {
            this.f3379n = j.d(R$attr.os_comp_color_tab_icon, context.getColor(R$color.os_comp_color_tab_icon_hios), context);
            this.f3378m = j.e(context, R$attr.os_platform_basic_color, R$color.os_platform_basic_color_hios);
            this.f3376k = j.d(R$attr.os_text_info, context.getColor(R$color.os_text_info_hios), context);
            this.f3377l = this.f3378m;
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.FootOperationBar_foot_click_image_color)) {
            this.f3378m = typedArrayObtainStyledAttributes.getColor(R$styleable.FootOperationBar_foot_click_image_color, -1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.FootOperationBar_foot_normal_image_color)) {
            this.f3379n = typedArrayObtainStyledAttributes.getColor(R$styleable.FootOperationBar_foot_normal_image_color, SupportMenu.CATEGORY_MASK);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.FootOperationBar_foot_text_color)) {
            this.f3376k = typedArrayObtainStyledAttributes.getColor(R$styleable.FootOperationBar_foot_text_color, this.f3376k);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.FootOperationBar_foot_click_text_color)) {
            this.f3377l = typedArrayObtainStyledAttributes.getColor(R$styleable.FootOperationBar_foot_click_text_color, color);
        }
        int i11 = typedArrayObtainStyledAttributes.getInt(R$styleable.FootOperationBar_foot_max_visible_tab_count, 5);
        this.q = i11;
        if (i11 < 3) {
            this.q = 3;
        }
        this.f3388z = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FootOperationBar_foot_landscape, false);
        d(context);
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.FootOperationBar_foot_opt_menu)) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.FootOperationBar_foot_opt_menu, 0);
            MenuInflater menuInflater = new MenuInflater(getContext());
            MenuBuilder menuBuilder = new MenuBuilder(getContext());
            this.C = menuBuilder;
            menuInflater.inflate(resourceId, menuBuilder);
            setMenu(this.C);
        }
        this.f3374i = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FootOperationBar_foot_init_show, false);
        boolean z5 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FootOperationBar_foot_immersive, false);
        typedArrayObtainStyledAttributes.recycle();
        boolean zQ = j.q(context);
        Log.d("FootOperationBar", "FootOperationBar: isGestureNavigationBarOn ==" + zQ + ", mImmersive==" + z5);
        if (z5 && zQ && (viewStub = (ViewStub) findViewById(R$id.os_fob_immersive)) != null) {
            viewStub.setOnInflateListener(new b(this));
            viewStub.inflate();
        }
        c cVar = new c(this);
        this.f3384v = cVar;
        if (!z3) {
            getViewTreeObserver().addOnPreDrawListener(cVar);
        }
        setClickable(true);
        TypedValue.applyDimension(1, 12.0f, getResources().getDisplayMetrics());
        this.f3387y = (int) TypedValue.applyDimension(1, 6.0f, getResources().getDisplayMetrics());
        this.A = getResources().getConfiguration().orientation;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(new float[0]);
        valueAnimatorOfFloat.setValues(PropertyValuesHolder.ofKeyframe("PRESS_TIME", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(1.0f, 1.0f)));
        valueAnimatorOfFloat.setDuration(100L);
    }

    public static void g(View view, float f) {
        if (view == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", view.getAlpha(), f);
        objectAnimatorOfFloat.setDuration(100L);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat.start();
    }

    private int getPopupHeight() {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.os_popup_menu_bg_margin);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R$dimen.os_foot_bar_popup_item_height);
        int i8 = dimensionPixelOffset * 2;
        boolean[] zArr = this.f3375j;
        return zArr != null ? i8 + (zArr.length * dimensionPixelOffset2) : i8;
    }

    private void setContainerWidth(int i8) {
        float fApplyDimension;
        int dimensionPixelSize;
        this.F = i8;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (i8 != 1) {
            Context context = this.f3383t;
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        if (i8 != 5) {
                            dimensionPixelSize = (int) TypedValue.applyDimension(1, this.f3388z ? 17.0f : 10.0f, displayMetrics);
                            if (j.B(context)) {
                                dimensionPixelSize += context.getResources().getDimensionPixelSize(R$dimen.os_curve_land);
                            }
                        } else {
                            fApplyDimension = TypedValue.applyDimension(1, this.f3388z ? 17.0f : 10.0f, displayMetrics);
                        }
                    } else {
                        fApplyDimension = TypedValue.applyDimension(1, 14.0f, displayMetrics);
                    }
                } else if (this.f3388z) {
                    fApplyDimension = TypedValue.applyDimension(1, 16.0f, displayMetrics);
                } else {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.os_foot_bar_padding_3);
                }
            } else if (this.f3388z) {
                fApplyDimension = TypedValue.applyDimension(1, 48.0f, displayMetrics);
            } else {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.os_foot_bar_padding_2);
            }
            LinearLayout linearLayout = this.f3369a;
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.width = -1;
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setPadding(dimensionPixelSize, linearLayout.getPaddingTop(), dimensionPixelSize, linearLayout.getPaddingBottom());
        }
        fApplyDimension = TypedValue.applyDimension(1, this.f3388z ? 210.0f : 99.0f, displayMetrics);
        dimensionPixelSize = (int) fApplyDimension;
        LinearLayout linearLayout2 = this.f3369a;
        ViewGroup.LayoutParams layoutParams2 = linearLayout2.getLayoutParams();
        layoutParams2.width = -1;
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setPadding(dimensionPixelSize, linearLayout2.getPaddingTop(), dimensionPixelSize, linearLayout2.getPaddingBottom());
    }

    private void setImageColorStateList(ImageView imageView) {
        if (this.p) {
            int[][] iArr = new int[2][];
            if (this.f3380o) {
                iArr[0] = new int[]{R.attr.state_pressed};
            } else {
                iArr[0] = new int[]{R.attr.state_selected};
            }
            iArr[1] = new int[0];
            imageView.setImageTintList(new ColorStateList(iArr, new int[]{this.f3378m, this.f3379n}));
        }
    }

    private void setMenu(MenuBuilder menuBuilder) {
        LinearLayout linearLayout = this.f3369a;
        linearLayout.removeAllViews();
        ArrayList arrayList = this.f3370b;
        arrayList.clear();
        this.f3371c = null;
        this.E = -1;
        int size = menuBuilder.size();
        setContainerWidth(size);
        if (!this.f3380o) {
            b(menuBuilder, size);
            return;
        }
        int i8 = this.q;
        if (size <= Math.min(i8, 5)) {
            b(menuBuilder, size);
            return;
        }
        int i9 = i8 > 5 ? 4 : i8 - 1;
        this.f3381r = i9;
        b(menuBuilder, i9);
        Context context = this.f3383t;
        ViewGroup viewGroupC = c(context.getResources().getString(R$string.os_foot_opt_bar_more), context.getDrawable(this.u));
        View viewFindViewById = viewGroupC.findViewById(R$id.os_fob_layout);
        this.f3372d = viewFindViewById;
        viewFindViewById.setOnClickListener(new zd.c(this));
        linearLayout.addView(viewGroupC);
        this.f3375j = new boolean[size];
        int i10 = i8 <= 5 ? i8 - 1 : 4;
        this.f3381r = i10;
        while (i10 < size) {
            arrayList.add(menuBuilder.getItem(i10).getTitle().toString());
            this.f3375j[i10 - this.f3381r] = true;
            i10++;
        }
        e();
    }

    private void setTextColorStateList(TextView textView) {
        if (this.p) {
            int[][] iArr = new int[2][];
            if (this.f3380o) {
                iArr[0] = new int[]{R.attr.state_pressed};
            } else {
                iArr[0] = new int[]{R.attr.state_selected};
            }
            iArr[1] = new int[0];
            int[] iArr2 = {this.f3377l, this.f3376k};
            Intrinsics.checkNotNullParameter(textView, "<this>");
            Object tag = textView.getTag(R$id.os_foot_opt_bar_item_text);
            if (tag instanceof zd.a) {
                zd.a aVar = (zd.a) tag;
                if (aVar.f11275a.isRunning()) {
                    aVar.f11275a.cancel();
                }
                textView.setTag(R$id.os_foot_opt_bar_item_text, null);
            }
            textView.setTextColor(new ColorStateList(iArr, iArr2));
        }
    }

    public final void a(View view) {
        if (!j.z(getContext()) || view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            int dimensionPixelOffset = this.f3383t.getResources().getDimensionPixelOffset(R$dimen.os_foot_bar_item_safe_inset);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (this.F == 2) {
                dimensionPixelOffset <<= 1;
            }
            marginLayoutParams.setMarginStart(dimensionPixelOffset);
            marginLayoutParams.setMarginEnd(marginLayoutParams.getMarginStart());
        }
    }

    public final void b(MenuBuilder menuBuilder, int i8) {
        ArrayList arrayList = this.f3382s;
        arrayList.clear();
        for (int i9 = 0; i9 < i8; i9++) {
            MenuItem item = menuBuilder.getItem(i9);
            ViewGroup viewGroupC = c(item.getTitle().toString(), item.getIcon());
            arrayList.add(viewGroupC);
            View viewFindViewById = viewGroupC.findViewById(R$id.os_fob_layout);
            viewGroupC.post(new m0(this, 10, viewFindViewById, viewGroupC));
            viewFindViewById.setOnClickListener(new zd.c(this, i9));
            if (!this.f3380o) {
                View viewFindViewById2 = viewGroupC.findViewById(R$id.os_foot_opt_press);
                viewFindViewById.setOnTouchListener(new zd.d(this, new e(this, viewFindViewById2, i9, 28), viewFindViewById2));
            }
            this.f3369a.addView(viewGroupC);
        }
    }

    public final ViewGroup c(String str, Drawable drawable) {
        ViewGroup viewGroup;
        boolean z2 = this.f3380o;
        if (z2) {
            Context context = getContext();
            Intrinsics.checkNotNullParameter(context, "context");
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
            linearLayout.setGravity(17);
            linearLayout.setOrientation(1);
            linearLayout.addView(c0.a(context), new LinearLayout.LayoutParams(-2, -2));
            a(linearLayout);
            viewGroup = linearLayout;
        } else {
            Context context2 = getContext();
            Intrinsics.checkNotNullParameter(context2, "context");
            RelativeLayout relativeLayout = new RelativeLayout(context2);
            relativeLayout.setId(R$id.os_foot_opt_bar_item_root_layout);
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
            Resources resources = relativeLayout.getResources();
            Space space = new Space(context2);
            space.setId(R$id.os_foot_opt_space);
            int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.os_foot_bar_item_icon_size);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelOffset, dimensionPixelOffset);
            layoutParams.addRule(13);
            relativeLayout.addView(space, layoutParams);
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            View view = new View(context2);
            view.setId(R$id.os_foot_opt_press);
            view.setAlpha(0.0f);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.setMarginStart(resources.getDimensionPixelSize(R$dimen.os_foot_bar_item_safe_inset));
            layoutParams2.setMarginEnd(layoutParams2.getMarginStart());
            Unit unit = Unit.INSTANCE;
            relativeLayout.addView(view, layoutParams2);
            LinearLayout linearLayoutA = c0.a(context2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            relativeLayout.addView(linearLayoutA, layoutParams3);
            ViewStub viewStub = new ViewStub(context2);
            viewStub.setId(R$id.os_stub_fpb_red_point);
            viewStub.setLayoutResource(R$layout.os_foot_opt_bar_item_red_point);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.setMarginStart((int) TypedValue.applyDimension(1, -2.0f, displayMetrics));
            layoutParams4.topMargin = layoutParams4.getMarginStart();
            layoutParams4.addRule(6, R$id.os_foot_opt_space);
            layoutParams4.addRule(17, R$id.os_foot_opt_space);
            relativeLayout.addView(viewStub, layoutParams4);
            a(relativeLayout.findViewById(R$id.os_foot_opt_press));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(ContextCompat.getColor(getContext(), R$color.os_gray_fifth_color));
            gradientDrawable.setCornerRadius(hd.a.a(getContext(), 8));
            relativeLayout.findViewById(R$id.os_foot_opt_press).setBackground(gradientDrawable);
            viewGroup = relativeLayout;
        }
        LinearLayout linearLayout2 = (LinearLayout) viewGroup.findViewById(R$id.os_fob_layout);
        linearLayout2.setOrientation(!this.f3388z ? 1 : 0);
        ImageView imageView = (ImageView) viewGroup.findViewById(R$id.os_foot_opt_bar_item_icon);
        TextView textView = (TextView) viewGroup.findViewById(R$id.os_foot_opt_bar_item_text);
        if (!this.f3388z) {
            textView.setTextSize(0, this.f3383t.getResources().getDimensionPixelSize(R$dimen.os_foot_bar_item_text_size_portrait));
        }
        if (drawable != null) {
            drawable.mutate();
            imageView.setImageDrawable(drawable);
            setImageColorStateList(imageView);
        }
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
            setTextColorStateList(textView);
        }
        if (!z2) {
            linearLayout2.post(new yd(this, viewGroup, linearLayout2, imageView));
        }
        if (this.f3388z) {
            textView.setPadding((int) TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics()), 0, 0, 0);
        } else {
            textView.setPadding(getResources().getDimensionPixelOffset(R$dimen.os_foot_bar_item_text_paddingTop), 0, 0, 0);
        }
        return viewGroup;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a8  */
    public final void d(Context context) {
        int dimensionPixelSize;
        ViewStub viewStub;
        if (context == null) {
            return;
        }
        Drawable background = getBackground();
        Context context2 = this.f3383t;
        int dimensionPixelSize2 = 0;
        if (background == null) {
            boolean z2 = this.f3380o;
            if (z2) {
                this.f3386x = j.e(context2, R$attr.os_comp_color_actionbar_bg, R$color.os_comp_color_actionbar_bg_hios);
            } else {
                this.f3386x = j.e(context2, R$attr.os_comp_color_tab_bg, R$color.os_comp_color_tab_bg_hios);
            }
            if (j.f8764a[0].equalsIgnoreCase(j.getOsType()) && !z2 && (viewStub = (ViewStub) findViewById(R$id.os_fob_top_line_stub)) != null) {
                viewStub.inflate();
            }
            setBackgroundColor(this.f3386x);
        }
        boolean zB = j.B(context2);
        LinearLayout linearLayout = this.f3369a;
        if (zB) {
            int rotation = context2.getDisplay().getRotation();
            int paddingLeft = linearLayout.getPaddingLeft();
            int paddingTop = linearLayout.getPaddingTop();
            int paddingRight = linearLayout.getPaddingRight();
            int paddingBottom = linearLayout.getPaddingBottom();
            if (rotation == 0) {
                dimensionPixelSize2 = context2.getResources().getDimensionPixelSize(R$dimen.os_curve_land) + getResources().getDimensionPixelSize(R$dimen.os_foot_bar_padding);
                dimensionPixelSize = dimensionPixelSize2;
            } else if (rotation == 1) {
                int dimensionPixelSize3 = context2.getResources().getDimensionPixelSize(R$dimen.os_curve_land);
                setMinimumHeight(getResources().getDimensionPixelSize(R$dimen.os_foot_bar_min_height_curve_land));
                dimensionPixelSize2 = dimensionPixelSize3;
                dimensionPixelSize = 0;
            } else if (rotation == 2) {
                dimensionPixelSize2 = context2.getResources().getDimensionPixelSize(R$dimen.os_curve_land) + getResources().getDimensionPixelSize(R$dimen.os_foot_bar_padding);
                dimensionPixelSize = dimensionPixelSize2;
            } else if (rotation != 3) {
                dimensionPixelSize2 = paddingLeft;
                dimensionPixelSize = paddingRight;
            } else {
                dimensionPixelSize = context2.getResources().getDimensionPixelSize(R$dimen.os_curve_land);
                setMinimumHeight(getResources().getDimensionPixelSize(R$dimen.os_foot_bar_min_height_curve_land));
            }
            linearLayout.setPadding(dimensionPixelSize2, paddingTop, dimensionPixelSize, paddingBottom);
        }
        linearLayout.setMinimumHeight(getMinimumHeight());
    }

    public final void e() {
        ListPopupWindow listPopupWindow;
        Drawable drawable;
        int dimensionPixelSize;
        this.D = new g(this);
        ListPopupWindow listPopupWindow2 = new ListPopupWindow(getContext(), null, 0, R$style.OsFootOptPopupEdgeStyle);
        this.f3371c = listPopupWindow2;
        listPopupWindow2.setAdapter(this.D);
        g gVar = this.D;
        Context context = this.f3383t;
        int iC = j.C(context, gVar);
        this.f3371c.setContentWidth(iC);
        this.f3371c.setModal(true);
        this.f3371c.setOnDismissListener(new zd.e(this, 0));
        this.f3371c.setAnchorView(this.f3369a);
        this.f3371c.setDropDownGravity(GravityCompat.END);
        if (getResources().getConfiguration().orientation == 2) {
            post(new w(this, 5));
        }
        if (j.B(context)) {
            int rotation = context.getDisplay().getRotation();
            if (rotation == 1) {
                drawable = ContextCompat.getDrawable(context, R$drawable.os_foot_opt_popup_background_curse_90);
                dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.os_curse_offset_land);
            } else if (rotation != 3) {
                drawable = ContextCompat.getDrawable(context, R$drawable.os_foot_opt_popup_background_curse_0_180);
                dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.os_curse_offset_portrait);
            } else {
                drawable = ContextCompat.getDrawable(context, R$drawable.os_foot_opt_popup_background_curse_270);
                dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.os_curse_offset_land);
            }
            this.f3371c.setContentWidth(iC + dimensionPixelSize);
            this.f3371c.setBackgroundDrawable(drawable);
        }
        int popupHeight = getPopupHeight();
        int i8 = this.G;
        if (i8 <= 0 || popupHeight <= i8 || (listPopupWindow = this.f3371c) == null) {
            return;
        }
        listPopupWindow.setHeight(i8);
    }

    public final void f(int i8, int i9) {
        this.f3379n = i8;
        this.f3378m = i9;
        LinearLayout linearLayout = this.f3369a;
        int childCount = linearLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = linearLayout.getChildAt(i10);
            setImageColorStateList(childAt == null ? null : (ImageView) childAt.findViewById(R$id.os_foot_opt_bar_item_icon));
        }
    }

    public d getDynamicBlur() {
        if (this.B == null) {
            Context context = this.f3383t;
            d dVar = new d(context);
            this.B = dVar;
            String[] strArr = j.f8764a;
            TypedValue typedValue = new TypedValue();
            dVar.setEraseColor(context.getTheme().resolveAttribute(R$attr.OsBgPrimary, typedValue, true) ? context.getColor(typedValue.resourceId) : -1);
            this.B.setBlurView(this);
        }
        return this.B;
    }

    public int getItemCount() {
        ArrayList arrayList = this.f3370b;
        int size = arrayList.size();
        LinearLayout linearLayout = this.f3369a;
        if (size <= 0) {
            return linearLayout.getChildCount();
        }
        return (arrayList.size() + linearLayout.getChildCount()) - 1;
    }

    public int getPopupMaxHeight() {
        return this.G;
    }

    public ListPopupWindow getPopupMenuWindow() {
        return this.f3371c;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setContainerWidth(this.f3369a.getChildCount());
        ListPopupWindow listPopupWindow = this.f3371c;
        if (listPopupWindow != null && listPopupWindow.isShowing()) {
            this.f3371c.dismiss();
        }
        if (this.e) {
            int i8 = getResources().getConfiguration().orientation;
            if (this.A != i8) {
                getViewTreeObserver().addOnPreDrawListener(this.f3384v);
            }
            this.A = i8;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.B;
        if (dVar != null) {
            dVar.e();
            this.B = null;
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        d(getContext());
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f3382s;
            if (i10 >= arrayList.size()) {
                return;
            }
            TextView textView = (TextView) ((View) arrayList.get(i10)).findViewById(R$id.os_foot_opt_bar_item_text);
            RelativeLayout relativeLayout = (RelativeLayout) ((View) arrayList.get(i10)).findViewById(R$id.os_foot_opt_bar_item_root_layout);
            if (textView != null && relativeLayout != null) {
                if (kc.b(getContext(), textView.getText(), textView.getTextSize(), 0.0f, relativeLayout.getWidth())) {
                    textView.setLetterSpacing(0.0f);
                } else if (kc.b(getContext(), textView.getText(), textView.getTextSize(), -0.05f, relativeLayout.getWidth())) {
                    textView.setLetterSpacing(-0.05f);
                } else {
                    textView.setLetterSpacing(0.0f);
                }
            }
            i10++;
        }
    }

    public void setAnim(boolean z2) {
        this.f3373h = z2;
    }

    public void setBlurAlp(@IntRange(from = 0, to = ScatterMapKt.Sentinel) int i8) {
        if (i8 < 0 || i8 > 255) {
            return;
        }
        this.f3385w = (i8 * 1.0f) / 255.0f;
    }

    public void setClickImageTintColor(@ColorInt int i8) {
        f(this.f3379n, i8);
    }

    public void setClickInterval(long j8) {
    }

    public void setContainerBackground(@ColorRes int i8) {
        setContainerBackgroundNoOverlay(i8);
    }

    public void setContainerBackgroundColor(@ColorInt int i8) {
        this.f3386x = i8;
        setBackgroundColor(i8);
        if (this.B != null) {
            int iArgb = Color.argb((int) (this.f3385w * Color.alpha(this.f3386x)), Color.red(this.f3386x), Color.green(this.f3386x), Color.blue(this.f3386x));
            if (j.q(this.f3383t)) {
                this.f3369a.setBackgroundColor(iArgb);
            } else {
                ShapeDrawable shapeDrawable = new ShapeDrawable();
                post(new i2.g(this, shapeDrawable.getPaint(), iArgb, shapeDrawable));
            }
        }
    }

    public void setContainerBackgroundNoOverlay(@ColorRes int i8) {
        setContainerBackgroundColor(this.f3383t.getResources().getColor(i8));
    }

    public void setFootOptBarClickTextColor(@ColorInt int i8) {
        this.f3376k = this.f3376k;
        this.f3377l = i8;
        int childCount = this.f3369a.getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = this.f3369a.getChildAt(i9);
            setTextColorStateList(childAt == null ? null : (TextView) childAt.findViewById(R$id.os_foot_opt_bar_item_text));
        }
    }

    public void setFootOptBarTextColor(@ColorInt int i8) {
        int i9 = this.f3377l;
        this.f3376k = i8;
        this.f3377l = i9;
        int childCount = this.f3369a.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.f3369a.getChildAt(i10);
            setTextColorStateList(childAt == null ? null : (TextView) childAt.findViewById(R$id.os_foot_opt_bar_item_text));
        }
    }

    public void setFootTextSize(float f) {
        int childCount = this.f3369a.getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = this.f3369a.getChildAt(i8);
            (childAt == null ? null : (TextView) childAt.findViewById(R$id.os_foot_opt_bar_item_text)).setTextSize(f);
        }
    }

    public void setItemSelectState(int i8) {
        ArrayList arrayList = this.f3382s;
        if (arrayList == null || this.E == i8) {
            return;
        }
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            TextView textView = (TextView) ((View) arrayList.get(i9)).findViewById(R$id.os_foot_opt_bar_item_text);
            OSMaskImageView oSMaskImageView = (OSMaskImageView) ((View) arrayList.get(i9)).findViewById(R$id.os_foot_opt_bar_item_icon);
            boolean z2 = this.f3380o;
            if (i9 == i8) {
                if (z2) {
                    return;
                }
                oSMaskImageView.setSelected(true);
                textView.setSelected(true);
            } else {
                if (z2) {
                    return;
                }
                textView.setSelected(false);
                oSMaskImageView.setSelected(false);
            }
        }
        this.E = i8;
    }

    public void setLandscape(boolean z2) {
        if (this.f3388z == z2) {
            return;
        }
        this.f3388z = z2;
        MenuBuilder menuBuilder = this.C;
        if (menuBuilder != null) {
            setMenu(menuBuilder);
        }
    }

    public void setNormalImageTintColor(@ColorInt int i8) {
        f(i8, this.f3378m);
    }

    public void setOnFootOptBarClickListener(h hVar) {
    }

    public void setPopupFullScreenMaxHeight(int i8) {
        if (i8 > 0) {
            setPopupMaxHeight(i8 - getResources().getDimensionPixelOffset(R$dimen.os_foot_bar_min_height));
            return;
        }
        this.G = 0;
        if (this.f3371c != null) {
            e();
        }
    }

    public void setPopupMaxHeight(int i8) {
        this.G = i8;
        if (this.f3371c != null) {
            e();
        }
    }

    public void setTopLineVisible(int i8) {
        View viewFindViewById = findViewById(R$id.os_fob_top_line);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(i8);
        }
    }
}
