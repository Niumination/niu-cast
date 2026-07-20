package com.transsion.widgetslib.view;

import af.f;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.annotation.Nullable;
import k3.z8;

/* JADX INFO: loaded from: classes2.dex */
public class OSRadioButton extends RadioButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3185a = 0;

    public OSRadioButton(Context context) {
        super(context);
        a(null);
    }

    public final void a(AttributeSet attributeSet) {
        if ((attributeSet == null ? -1 : attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "button", -1)) == -1) {
            setBackground(null);
            isChecked();
            postDelayed(new f(this, 26), 150L);
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(@Nullable Drawable drawable) {
        super.setButtonDrawable(drawable);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        super.setChecked(z2);
        z8.b("OSRadioButton", "setChecked, checked: " + z2 + ", getParent: " + getParent() + ", obj: " + this);
    }

    public OSRadioButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public OSRadioButton(Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        a(attributeSet);
    }
}
