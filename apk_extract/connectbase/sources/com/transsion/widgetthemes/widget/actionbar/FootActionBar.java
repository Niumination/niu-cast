package com.transsion.widgetthemes.widget.actionbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.transsion.widgetsThemes.R;

/* JADX INFO: loaded from: classes2.dex */
public class FootActionBar extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f3321d = "ActionBar";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ViewOutlineProvider f3322e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f3323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OverflowMenu f3324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageButton f3325c;

    public class a extends ViewOutlineProvider {
        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setOval(0, 0, view.getWidth(), view.getHeight());
        }
    }

    public FootActionBar(Context context) {
        this(context, null);
    }

    public static void a(View view, Resources resources) {
        view.setOutlineProvider(f3322e);
        view.setTranslationZ(resources.getDimensionPixelSize(R.dimen.floating_action_button_translation_z));
    }

    public final void b(int i10) {
    }

    public ImageButton getCenterBtn() {
        return this.f3325c;
    }

    public OverflowMenu getOverflowMenu() {
        return this.f3324b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("os_menu", "ActionBar, onAttachedToWindow()");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3324b = null;
        Log.d("os_menu", "ActionBar, onDetachedFromWindow()");
    }

    public void setOverMenuColor(int i10) {
        this.f3324b.setOverMenuColor(i10);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        if (i10 == 0) {
            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.os_footer_menu_enter));
        }
        if (i10 == 8) {
            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.os_footer_menu_exit));
        }
    }

    public FootActionBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.OS_FooterMenuViewStyle, 0);
    }

    public FootActionBar(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public FootActionBar(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FooterMenuView, i10, i11);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.os_footer_menu_2, (ViewGroup) this, true);
        setMinimumHeight((int) typedArrayObtainStyledAttributes.getDimension(R.styleable.FooterMenuView_minHeight, 64.0f));
        this.f3324b = (OverflowMenu) findViewById(R.id.os_menu_btn);
        this.f3325c = (ImageButton) findViewById(R.id.os_menu_center);
        typedArrayObtainStyledAttributes.getDrawable(R.styleable.FooterMenuView_menuContentBg);
        int i12 = typedArrayObtainStyledAttributes.getInt(R.styleable.FooterMenuView_overflowMenuGravity, -1);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3324b.getLayoutParams();
        if (i12 != -1) {
            layoutParams.gravity = i12;
            this.f3324b.setLayoutParams(layoutParams);
        }
        Log.d("os_menu", "ActionBar, lp = " + layoutParams + ", overflowMenuGravity = " + i12);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.FooterMenuView_overflowMenuBgColor);
        if (drawable != null) {
            this.f3324b.setBackground(drawable);
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.FooterMenuView_overflowMenuColor);
        if (drawable2 != null && ColorDrawable.class.isInstance(drawable2)) {
            this.f3324b.setOverMenuColor(((ColorDrawable) drawable2).getColor());
        }
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.FooterMenuView_centerBtnBgColor);
        if (drawable3 != null) {
            this.f3325c.setBackground(drawable3);
        }
        Drawable drawable4 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.FooterMenuView_centerBtnColor);
        if (drawable4 != null) {
            this.f3325c.setImageDrawable(drawable4);
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
