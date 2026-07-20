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
import com.transsion.widgetsThemes.R$anim;
import com.transsion.widgetsThemes.R$dimen;
import com.transsion.widgetsThemes.R$id;
import com.transsion.widgetsThemes.R$layout;
import com.transsion.widgetsThemes.R$style;
import com.transsion.widgetsThemes.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public class FootActionBar extends FrameLayout {
    private static final ViewOutlineProvider OVAL_OUTLINE_PROVIDER = new ViewOutlineProvider() { // from class: com.transsion.widgetthemes.widget.actionbar.FootActionBar.1
        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setOval(0, 0, view.getWidth(), view.getHeight());
        }
    };
    private static final String TAG = "ActionBar";
    private ImageButton mCenterBtn;
    private LinearLayout mMenuContent;
    private OverflowMenu mOverflowMenu;

    public FootActionBar(Context context) {
        this(context, null);
    }

    public static void setupViewFab(View view, Resources resources) {
        view.setOutlineProvider(OVAL_OUTLINE_PROVIDER);
        view.setTranslationZ(resources.getDimensionPixelSize(R$dimen.floating_action_button_translation_z));
    }

    private void updateAnim(int i8) {
    }

    public ImageButton getCenterBtn() {
        return this.mCenterBtn;
    }

    public OverflowMenu getOverflowMenu() {
        return this.mOverflowMenu;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("os_menu", "ActionBar, onAttachedToWindow()");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mOverflowMenu = null;
        Log.d("os_menu", "ActionBar, onDetachedFromWindow()");
    }

    public void setOverMenuColor(int i8) {
        this.mOverflowMenu.setOverMenuColor(i8);
    }

    @Override // android.view.View
    public void setVisibility(int i8) {
        super.setVisibility(i8);
        if (i8 == 0) {
            startAnimation(AnimationUtils.loadAnimation(getContext(), R$anim.os_footer_menu_enter));
        }
        if (i8 == 8) {
            startAnimation(AnimationUtils.loadAnimation(getContext(), R$anim.os_footer_menu_exit));
        }
    }

    public FootActionBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$style.OS_FooterMenuViewStyle);
    }

    public FootActionBar(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 0);
    }

    public FootActionBar(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FooterMenuView, i8, i9);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R$layout.os_footer_menu_2, (ViewGroup) this, true);
        setMinimumHeight((int) typedArrayObtainStyledAttributes.getDimension(R$styleable.FooterMenuView_minHeight, 64.0f));
        this.mOverflowMenu = (OverflowMenu) findViewById(R$id.os_menu_btn);
        this.mCenterBtn = (ImageButton) findViewById(R$id.os_menu_center);
        typedArrayObtainStyledAttributes.getDrawable(R$styleable.FooterMenuView_menuContentBg);
        int i10 = typedArrayObtainStyledAttributes.getInt(R$styleable.FooterMenuView_overflowMenuGravity, -1);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mOverflowMenu.getLayoutParams();
        if (i10 != -1) {
            layoutParams.gravity = i10;
            this.mOverflowMenu.setLayoutParams(layoutParams);
            updateAnim(layoutParams.gravity);
        }
        Log.d("os_menu", "ActionBar, lp = " + layoutParams + ", overflowMenuGravity = " + i10);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FooterMenuView_overflowMenuBgColor);
        if (drawable != null) {
            this.mOverflowMenu.setBackground(drawable);
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FooterMenuView_overflowMenuColor);
        if (drawable2 != null && ColorDrawable.class.isInstance(drawable2)) {
            this.mOverflowMenu.setOverMenuColor(((ColorDrawable) drawable2).getColor());
        }
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FooterMenuView_centerBtnBgColor);
        if (drawable3 != null) {
            this.mCenterBtn.setBackground(drawable3);
        }
        Drawable drawable4 = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FooterMenuView_centerBtnColor);
        if (drawable4 != null) {
            this.mCenterBtn.setImageDrawable(drawable4);
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
