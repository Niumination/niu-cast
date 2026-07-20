package com.transsion.widgetslib.widget.actionbar;

import ae.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.transsion.widgetslib.R$anim;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.R$style;
import com.transsion.widgetslib.R$styleable;

/* JADX INFO: loaded from: classes2.dex */
public class FootActionBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OverflowMenu f3452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageButton f3453b;

    static {
        new a(0);
    }

    public FootActionBar(Context context) {
        this(context, null);
    }

    public ImageButton getCenterBtn() {
        return this.f3453b;
    }

    public OverflowMenu getOverflowMenu() {
        return this.f3452a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("os_menu", "ActionBar, onAttachedToWindow()");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3452a = null;
        Log.d("os_menu", "ActionBar, onDetachedFromWindow()");
    }

    public void setOverMenuColor(int i8) {
        this.f3452a.setOverMenuColor(i8);
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
        super(context, attributeSet, i8, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FooterMenuView, i8, 0);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R$layout.os_footer_menu_2, (ViewGroup) this, true);
        setMinimumHeight((int) typedArrayObtainStyledAttributes.getDimension(R$styleable.FooterMenuView_minHeight, 64.0f));
        this.f3452a = (OverflowMenu) findViewById(R$id.os_menu_btn);
        ImageButton imageButton = (ImageButton) findViewById(R$id.os_menu_center);
        this.f3453b = imageButton;
        typedArrayObtainStyledAttributes.getDrawable(R$styleable.FooterMenuView_menuContentBg);
        int i9 = typedArrayObtainStyledAttributes.getInt(R$styleable.FooterMenuView_overflowMenuGravity, -1);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3452a.getLayoutParams();
        if (i9 != -1) {
            layoutParams.gravity = i9;
            this.f3452a.setLayoutParams(layoutParams);
        }
        Log.d("os_menu", "ActionBar, lp = " + layoutParams + ", overflowMenuGravity = " + i9);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FooterMenuView_overflowMenuBgColor);
        if (drawable != null) {
            this.f3452a.setBackground(drawable);
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FooterMenuView_overflowMenuColor);
        if (drawable2 != null && ColorDrawable.class.isInstance(drawable2)) {
            this.f3452a.setOverMenuColor(((ColorDrawable) drawable2).getColor());
        }
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FooterMenuView_centerBtnBgColor);
        if (drawable3 != null) {
            imageButton.setBackground(drawable3);
        }
        Drawable drawable4 = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FooterMenuView_centerBtnColor);
        if (drawable4 != null) {
            imageButton.setImageDrawable(drawable4);
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
