package com.transsion.widgetslib.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.transsion.widgetslib.R$drawable;
import com.transsion.widgetslib.R$styleable;
import k3.z8;
import md.c;
import md.g;
import md.h;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public class OSCheckBox extends CheckBox {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f3137i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f3138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f3139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f3140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f3141d;
    public StateListDrawable e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3142h;

    public OSCheckBox(Context context) {
        super(context);
        b(null);
    }

    public static g a(Context context) {
        g gVar = new g();
        StateListDrawable stateListDrawable = new StateListDrawable();
        c cVar = new c(context, true);
        stateListDrawable.addState(new int[]{R.attr.state_checked, R.attr.state_enabled}, cVar);
        stateListDrawable.addState(new int[]{R.attr.state_checked, -16842910}, ContextCompat.getDrawable(context, R$drawable.os_check_drawable_end_checked));
        c cVar2 = new c(context, false);
        cVar2.c(false, false);
        stateListDrawable.addState(new int[]{-16842912, -16842910}, cVar2);
        c cVar3 = new c(context, false);
        stateListDrawable.addState(new int[0], cVar3);
        gVar.setStateListDrawable(stateListDrawable);
        gVar.setCheckedDrawable(cVar);
        gVar.setNormalDrawable(cVar3);
        gVar.setDisabledDrawable(cVar2);
        return gVar;
    }

    public final void b(AttributeSet attributeSet) {
        if ((attributeSet == null ? -1 : attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "button", -1)) == -1) {
            setBackground(null);
            if (!j.f8769h) {
                g gVarA = a(getContext());
                if (gVarA.getStateListDrawable() != null) {
                    StateListDrawable stateListDrawable = gVarA.getStateListDrawable();
                    this.e = stateListDrawable;
                    setButtonDrawable(stateListDrawable);
                }
                if (gVarA.getCheckedDrawable() instanceof c) {
                    this.f3139b = gVarA.getCheckedDrawable();
                }
                if (gVarA.getNormalDrawable() instanceof c) {
                    this.f3140c = gVarA.getNormalDrawable();
                }
                if (gVarA.getDisabledDrawable() instanceof c) {
                    this.f3141d = gVarA.getDisabledDrawable();
                }
            }
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.OSCheckBox);
            setPictureMode(typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSCheckBox_picture_mode, false));
            if (isChecked()) {
                this.f3138a = this.f3139b;
            } else {
                this.f3138a = this.f3140c;
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Nullable
    public c getCheckedDrawable() {
        h hVar = this.f3139b;
        if (hVar instanceof c) {
            return (c) hVar;
        }
        return null;
    }

    @Nullable
    public c getDisabledDrawable() {
        h hVar = this.f3141d;
        if (hVar instanceof c) {
            return (c) hVar;
        }
        return null;
    }

    @Nullable
    public c getNormalDrawable() {
        h hVar = this.f3140c;
        if (hVar instanceof c) {
            return (c) hVar;
        }
        return null;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h hVar = this.f3138a;
        if (hVar != null) {
            hVar.stop();
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(@Nullable Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (drawable != this.e) {
            this.f3139b = null;
            this.f3140c = null;
            this.f3141d = null;
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        h hVar;
        h hVar2;
        super.setChecked(z2);
        z8.b("OSCheckBox", "setChecked, checked: " + z2 + ", getParent: " + getParent() + ", obj: " + this);
        h hVar3 = this.f3138a;
        if (hVar3 == null || (hVar = this.f3139b) == null || (hVar2 = this.f3140c) == null) {
            return;
        }
        if (z2 && hVar3 == hVar) {
            z8.b("OSCheckBox", "setChecked, 111111: mCurrentDrawable: " + this.f3139b);
        } else {
            if (!z2 && hVar3 == hVar2) {
                z8.b("OSCheckBox", "setChecked, 222222: mCurrentDrawable: " + this.f3140c);
                return;
            }
            if (!z2) {
                hVar = hVar2;
            }
            this.f3138a = hVar;
            if (!isAttachedToWindow() || this.f3142h) {
                return;
            }
            this.f3138a.a(hVar3);
        }
    }

    public void setCheckedFillColor(@ColorInt int i8) {
        c normalDrawable = getNormalDrawable();
        if (normalDrawable != null) {
            normalDrawable.setCheckedFillColor(i8);
        }
        c checkedDrawable = getCheckedDrawable();
        if (checkedDrawable != null) {
            checkedDrawable.setCheckedFillColor(i8);
        }
    }

    public void setPictureMode(boolean z2) {
        c normalDrawable = getNormalDrawable();
        if (normalDrawable != null) {
            normalDrawable.c(z2, isEnabled());
        }
        c checkedDrawable = getCheckedDrawable();
        if (checkedDrawable != null) {
            checkedDrawable.c(z2, isEnabled());
        }
        c disabledDrawable = getDisabledDrawable();
        if (disabledDrawable != null) {
            disabledDrawable.c(z2, isEnabled());
        }
    }

    public void setStopAnimation(boolean z2) {
        this.f3142h = z2;
    }

    public void setTickColor(@ColorInt int i8) {
        c normalDrawable = getNormalDrawable();
        if (normalDrawable != null) {
            normalDrawable.setTickColor(i8);
        }
        c checkedDrawable = getCheckedDrawable();
        if (checkedDrawable != null) {
            checkedDrawable.setTickColor(i8);
        }
    }

    public void setUncheckedBorderColor(@ColorInt int i8) {
        c normalDrawable = getNormalDrawable();
        if (normalDrawable != null) {
            normalDrawable.setUncheckedBorderColor(i8);
        }
        c checkedDrawable = getCheckedDrawable();
        if (checkedDrawable != null) {
            checkedDrawable.setUncheckedBorderColor(i8);
        }
    }

    public void setUncheckedFillColor(@ColorInt int i8) {
        c normalDrawable = getNormalDrawable();
        if (normalDrawable != null) {
            normalDrawable.setUncheckedFillColor(i8);
        }
        c checkedDrawable = getCheckedDrawable();
        if (checkedDrawable != null) {
            checkedDrawable.setUncheckedFillColor(i8);
        }
    }

    public OSCheckBox(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet);
    }

    public OSCheckBox(Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        b(attributeSet);
    }
}
