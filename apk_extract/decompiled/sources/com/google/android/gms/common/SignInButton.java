package com.google.android.gms.common;

import a1.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.gms.base.R$color;
import com.google.android.gms.base.R$drawable;
import com.google.android.gms.base.R$styleable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zaaa;
import f3.c;
import k3.f1;
import u2.e;
import u2.l;

/* JADX INFO: loaded from: classes.dex */
public final class SignInButton extends FrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f1809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View.OnClickListener f1810d;

    public SignInButton(@NonNull Context context) {
        this(context, null);
    }

    public final void a(int i8, int i9) {
        this.f1807a = i8;
        this.f1808b = i9;
        Context context = getContext();
        View view = this.f1809c;
        if (view != null) {
            removeView(view);
        }
        try {
            this.f1809c = e.e(this.f1807a, this.f1808b, context);
        } catch (c unused) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i10 = this.f1807a;
            int i11 = this.f1808b;
            zaaa zaaaVar = new zaaa(context, null);
            Resources resources = context.getResources();
            zaaaVar.setTypeface(Typeface.DEFAULT_BOLD);
            zaaaVar.setTextSize(14.0f);
            int i12 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
            zaaaVar.setMinHeight(i12);
            zaaaVar.setMinWidth(i12);
            int i13 = R$drawable.common_google_signin_btn_icon_dark;
            int i14 = R$drawable.common_google_signin_btn_icon_light;
            int iA = zaaa.a(i11, i13, i14, i14);
            int i15 = R$drawable.common_google_signin_btn_text_dark;
            int i16 = R$drawable.common_google_signin_btn_text_light;
            int iA2 = zaaa.a(i11, i15, i16, i16);
            if (i10 == 0 || i10 == 1) {
                iA = iA2;
            } else if (i10 != 2) {
                throw new IllegalStateException(a.o(i10, "Unknown button size: "));
            }
            Drawable drawableWrap = DrawableCompat.wrap(resources.getDrawable(iA));
            DrawableCompat.setTintList(drawableWrap, resources.getColorStateList(R$color.common_google_signin_btn_tint));
            DrawableCompat.setTintMode(drawableWrap, PorterDuff.Mode.SRC_ATOP);
            zaaaVar.setBackgroundDrawable(drawableWrap);
            int i17 = R$color.common_google_signin_btn_text_dark;
            int i18 = R$color.common_google_signin_btn_text_light;
            ColorStateList colorStateList = resources.getColorStateList(zaaa.a(i11, i17, i18, i18));
            l.e(colorStateList);
            zaaaVar.setTextColor(colorStateList);
            if (i10 == 0) {
                zaaaVar.setText(resources.getString(com.google.android.gms.base.R$string.common_signin_button_text));
            } else if (i10 == 1) {
                zaaaVar.setText(resources.getString(com.google.android.gms.base.R$string.common_signin_button_text_long));
            } else {
                if (i10 != 2) {
                    throw new IllegalStateException(a.o(i10, "Unknown button size: "));
                }
                zaaaVar.setText((CharSequence) null);
            }
            zaaaVar.setTransformationMethod(null);
            if (f1.a(zaaaVar.getContext())) {
                zaaaVar.setGravity(19);
            }
            this.f1809c = zaaaVar;
        }
        addView(this.f1809c);
        this.f1809c.setEnabled(isEnabled());
        this.f1809c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View.OnClickListener onClickListener = this.f1810d;
        if (onClickListener == null || view != this.f1809c) {
            return;
        }
        onClickListener.onClick(this);
    }

    public void setColorScheme(int i8) {
        a(this.f1807a, i8);
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        this.f1809c.setEnabled(z2);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f1810d = onClickListener;
        View view = this.f1809c;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public void setScopes(@NonNull Scope[] scopeArr) {
        a(this.f1807a, this.f1808b);
    }

    public void setSize(int i8) {
        a(i8, this.f1808b);
    }

    public SignInButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f1810d = null;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.SignInButton, 0, 0);
        try {
            this.f1807a = typedArrayObtainStyledAttributes.getInt(R$styleable.SignInButton_buttonSize, 0);
            this.f1808b = typedArrayObtainStyledAttributes.getInt(R$styleable.SignInButton_colorScheme, 2);
            typedArrayObtainStyledAttributes.recycle();
            a(this.f1807a, this.f1808b);
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }
}
