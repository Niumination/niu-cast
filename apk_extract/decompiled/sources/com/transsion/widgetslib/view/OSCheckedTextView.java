package com.transsion.widgetslib.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.CheckedTextView;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.transsion.widgetslib.R$drawable;
import com.transsion.widgetslib.R$styleable;
import k3.z8;
import md.c;
import md.e;
import md.g;
import md.h;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public class OSCheckedTextView extends CheckedTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f3144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f3145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f3146d;
    public StateListDrawable e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h f3147h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h f3148i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h f3149j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public StateListDrawable f3150k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public h f3151l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public h f3152m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public h f3153n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public StateListDrawable f3154o;
    public h p;
    public h q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public h f3155r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public StateListDrawable f3156s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public h f3157t;
    public h u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public h f3158v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public StateListDrawable f3159w;

    public OSCheckedTextView(Context context) {
        super(context);
        this.f3143a = 0;
        a(null);
    }

    private Drawable getDefaultCheckDrawable() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R.attr.listChoiceIndicatorMultiple, typedValue, true)) {
            return null;
        }
        getContext();
        return j.s() ? AppCompatResources.getDrawable(getContext(), R$drawable.os_ultra_small_btn_check_material_anim) : ContextCompat.getDrawable(getContext(), typedValue.resourceId);
    }

    private Drawable getDefaultSingleDrawable() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R.attr.listChoiceIndicatorSingle, typedValue, true)) {
            return null;
        }
        getContext();
        return j.s() ? AppCompatResources.getDrawable(getContext(), R$drawable.os_ultra_small_btn_radio_material_anim) : ContextCompat.getDrawable(getContext(), typedValue.resourceId);
    }

    private g getReverseDrawableBean() {
        if (!j.f8769h && this.f3143a == 2) {
            return OSCheckBox.a(getContext());
        }
        return null;
    }

    public final void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.OSCheckedTextView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                if (index == R$styleable.OSCheckedTextView_check_mark_style) {
                    this.f3143a = typedArrayObtainStyledAttributes.getInt(index, 0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        if (getCheckMarkDrawable() == null) {
            g reverseDrawableBean = getReverseDrawableBean();
            if (reverseDrawableBean == null) {
                if (this.f3143a == 1) {
                    setCheckMarkDrawable(getDefaultSingleDrawable());
                }
                if (this.f3143a == 2) {
                    setCheckMarkDrawable(getDefaultCheckDrawable());
                    return;
                }
                return;
            }
            if (reverseDrawableBean.getStateListDrawable() != null) {
                StateListDrawable stateListDrawable = reverseDrawableBean.getStateListDrawable();
                this.e = stateListDrawable;
                setCheckMarkDrawable(stateListDrawable);
            }
            if (reverseDrawableBean.getCheckedDrawable() != null) {
                this.f3145c = reverseDrawableBean.getCheckedDrawable();
            }
            if (reverseDrawableBean.getNormalDrawable() != null) {
                this.f3146d = reverseDrawableBean.getNormalDrawable();
            }
            boolean zIsChecked = isChecked();
            h hVar = this.f3145c;
            h hVar2 = this.f3146d;
            if (!zIsChecked) {
                hVar = hVar2;
            }
            this.f3144b = hVar;
        }
    }

    public final Drawable b(Drawable drawable) {
        if (!(drawable instanceof c)) {
            return drawable instanceof e ? getDefaultSingleDrawable() : drawable;
        }
        if (j.f8769h) {
            return getDefaultCheckDrawable();
        }
        this.f3143a = 2;
        g reverseDrawableBean = getReverseDrawableBean();
        if (reverseDrawableBean != null) {
            if (reverseDrawableBean.getStateListDrawable() != null) {
                this.f3159w = reverseDrawableBean.getStateListDrawable();
            }
            if (reverseDrawableBean.getCheckedDrawable() != null) {
                this.u = reverseDrawableBean.getCheckedDrawable();
            }
            if (reverseDrawableBean.getNormalDrawable() != null) {
                this.f3158v = reverseDrawableBean.getNormalDrawable();
            }
            boolean zIsChecked = isChecked();
            h hVar = this.u;
            h hVar2 = this.f3158v;
            if (!zIsChecked) {
                hVar = hVar2;
            }
            this.f3157t = hVar;
        }
        return this.f3159w;
    }

    public final Drawable c(Drawable drawable) {
        if (!(drawable instanceof c)) {
            return drawable instanceof e ? getDefaultSingleDrawable() : drawable;
        }
        if (j.f8769h) {
            return getDefaultCheckDrawable();
        }
        this.f3143a = 2;
        g reverseDrawableBean = getReverseDrawableBean();
        if (reverseDrawableBean != null) {
            if (reverseDrawableBean.getStateListDrawable() != null) {
                this.f3154o = reverseDrawableBean.getStateListDrawable();
            }
            if (reverseDrawableBean.getCheckedDrawable() != null) {
                this.f3152m = reverseDrawableBean.getCheckedDrawable();
            }
            if (reverseDrawableBean.getNormalDrawable() != null) {
                this.f3153n = reverseDrawableBean.getNormalDrawable();
            }
            boolean zIsChecked = isChecked();
            h hVar = this.f3152m;
            h hVar2 = this.f3153n;
            if (!zIsChecked) {
                hVar = hVar2;
            }
            this.f3151l = hVar;
        }
        return this.f3154o;
    }

    public final Drawable d(Drawable drawable) {
        if (!(drawable instanceof c)) {
            return drawable instanceof e ? getDefaultSingleDrawable() : drawable;
        }
        if (j.f8769h) {
            return getDefaultCheckDrawable();
        }
        this.f3143a = 2;
        g reverseDrawableBean = getReverseDrawableBean();
        if (reverseDrawableBean != null) {
            if (reverseDrawableBean.getStateListDrawable() != null) {
                this.f3150k = reverseDrawableBean.getStateListDrawable();
            }
            if (reverseDrawableBean.getCheckedDrawable() != null) {
                this.f3148i = reverseDrawableBean.getCheckedDrawable();
            }
            if (reverseDrawableBean.getNormalDrawable() != null) {
                this.f3149j = reverseDrawableBean.getNormalDrawable();
            }
            boolean zIsChecked = isChecked();
            h hVar = this.f3148i;
            h hVar2 = this.f3149j;
            if (!zIsChecked) {
                hVar = hVar2;
            }
            this.f3147h = hVar;
        }
        return this.f3150k;
    }

    public final Drawable e(Drawable drawable) {
        if (!(drawable instanceof c)) {
            return drawable instanceof e ? getDefaultSingleDrawable() : drawable;
        }
        if (j.f8769h) {
            return getDefaultCheckDrawable();
        }
        this.f3143a = 2;
        g reverseDrawableBean = getReverseDrawableBean();
        if (reverseDrawableBean != null) {
            if (reverseDrawableBean.getStateListDrawable() != null) {
                this.f3156s = reverseDrawableBean.getStateListDrawable();
            }
            if (reverseDrawableBean.getCheckedDrawable() != null) {
                this.q = reverseDrawableBean.getCheckedDrawable();
            }
            if (reverseDrawableBean.getNormalDrawable() != null) {
                this.f3155r = reverseDrawableBean.getNormalDrawable();
            }
            boolean zIsChecked = isChecked();
            h hVar = this.q;
            h hVar2 = this.f3155r;
            if (!zIsChecked) {
                hVar = hVar2;
            }
            this.p = hVar;
        }
        return this.f3156s;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h hVar = this.f3144b;
        if (hVar != null) {
            hVar.stop();
        }
        h hVar2 = this.f3147h;
        if (hVar2 != null) {
            hVar2.stop();
        }
        h hVar3 = this.f3151l;
        if (hVar3 != null) {
            hVar3.stop();
        }
        h hVar4 = this.p;
        if (hVar4 != null) {
            hVar4.stop();
        }
        h hVar5 = this.f3157t;
        if (hVar5 != null) {
            hVar5.stop();
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(@Nullable Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        if (drawable != this.e) {
            this.f3145c = null;
            this.f3146d = null;
        }
    }

    @Override // android.widget.CheckedTextView, android.widget.Checkable
    public void setChecked(boolean z2) {
        h hVar;
        h hVar2;
        h hVar3;
        h hVar4;
        h hVar5;
        h hVar6;
        h hVar7;
        h hVar8;
        h hVar9;
        h hVar10;
        super.setChecked(z2);
        z8.b("OSCheckedTextView", "setChecked, checked: " + z2 + ", getParent: " + getParent() + ", obj: " + this);
        h hVar11 = this.f3144b;
        if (hVar11 != null && (hVar9 = this.f3145c) != null && (hVar10 = this.f3146d) != null) {
            if (z2 && hVar11 == hVar9) {
                z8.b("OSCheckedTextView", "setChecked, 111111: mCurrentDrawableCheckMark: " + this.f3145c);
                return;
            } else if (!z2 && hVar11 == hVar10) {
                z8.b("OSCheckedTextView", "setChecked, 222222: mCurrentDrawableCheckMark: " + this.f3146d);
                return;
            } else {
                if (!z2) {
                    hVar9 = hVar10;
                }
                this.f3144b = hVar9;
                if (isAttachedToWindow()) {
                    this.f3144b.a(hVar11);
                }
            }
        }
        h hVar12 = this.f3147h;
        if (hVar12 != null && (hVar7 = this.f3148i) != null && (hVar8 = this.f3149j) != null) {
            if (z2 && hVar12 == hVar7) {
                z8.b("OSCheckedTextView", "setChecked, 111111: mCurrentDrawableStart: " + this.f3148i);
                return;
            } else if (!z2 && hVar12 == hVar8) {
                z8.b("OSCheckedTextView", "setChecked, 222222: mCurrentDrawableStart: " + this.f3149j);
                return;
            } else {
                if (!z2) {
                    hVar7 = hVar8;
                }
                this.f3147h = hVar7;
                if (isAttachedToWindow()) {
                    this.f3147h.a(hVar12);
                }
            }
        }
        h hVar13 = this.f3151l;
        if (hVar13 != null && (hVar5 = this.f3152m) != null && (hVar6 = this.f3153n) != null) {
            if (z2 && hVar13 == hVar5) {
                z8.b("OSCheckedTextView", "setChecked, 111111: mCurrentDrawableEnd: " + this.f3152m);
                return;
            } else if (!z2 && hVar13 == hVar6) {
                z8.b("OSCheckedTextView", "setChecked, 222222: mCurrentDrawableEnd: " + this.f3153n);
                return;
            } else {
                if (!z2) {
                    hVar5 = hVar6;
                }
                this.f3151l = hVar5;
                if (isAttachedToWindow()) {
                    this.f3151l.a(hVar13);
                }
            }
        }
        h hVar14 = this.p;
        if (hVar14 != null && (hVar3 = this.q) != null && (hVar4 = this.f3155r) != null) {
            if (z2 && hVar14 == hVar3) {
                z8.b("OSCheckedTextView", "setChecked, 111111: mCurrentDrawableTop: " + this.q);
                return;
            } else if (!z2 && hVar14 == hVar4) {
                z8.b("OSCheckedTextView", "setChecked, 222222: mCurrentDrawableTop: " + this.f3155r);
                return;
            } else {
                if (!z2) {
                    hVar3 = hVar4;
                }
                this.p = hVar3;
                if (isAttachedToWindow()) {
                    this.p.a(hVar14);
                }
            }
        }
        h hVar15 = this.f3157t;
        if (hVar15 == null || (hVar = this.u) == null || (hVar2 = this.f3158v) == null) {
            return;
        }
        if (z2 && hVar15 == hVar) {
            z8.b("OSCheckedTextView", "setChecked, 111111: mCurrentDrawableBottom: " + this.u);
        } else if (!z2 && hVar15 == hVar2) {
            z8.b("OSCheckedTextView", "setChecked, 222222: mCurrentDrawableBottom: " + this.f3158v);
        } else {
            if (!z2) {
                hVar = hVar2;
            }
            this.f3157t = hVar;
            if (isAttachedToWindow()) {
                this.f3157t.a(hVar15);
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(d(drawable), e(drawable2), c(drawable3), b(drawable4));
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(d(drawable), e(drawable2), c(drawable3), b(drawable4));
    }

    public OSCheckedTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3143a = 0;
        a(attributeSet);
    }

    public OSCheckedTextView(Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f3143a = 0;
        a(attributeSet);
    }
}
