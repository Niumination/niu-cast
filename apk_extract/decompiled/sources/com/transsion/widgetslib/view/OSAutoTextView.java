package com.transsion.widgetslib.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import k3.kc;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public class OSAutoTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3126d;
    public int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3127h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f3128i;

    public OSAutoTextView(@NonNull Context context) {
        super(context);
        this.f3124b = 14;
        this.f3125c = 12;
        this.f3126d = 2;
        this.e = 8;
        this.f3127h = 0.0f;
        this.f3128i = 0.0f;
        setMaxLines(2);
        setTextSize(this.f3124b);
        setLetterSpacing(this.f3127h);
    }

    public final void a() {
        if (getLineCount() == this.f3126d) {
            CharSequence text = getText();
            float f = this.f3124b;
            float f4 = this.f3127h;
            int i8 = this.f3126d;
            int measuredWidth = getMeasuredWidth() - (getPaddingRight() + getPaddingLeft());
            Context context = getContext();
            if (j.z(context) ? kc.a(context, text, f * 3.0f, f4, i8, measuredWidth) : kc.a(context, text, TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics()), f4, i8, measuredWidth)) {
                setLetterSpacing(this.f3127h);
                setTextSize(this.f3124b);
            } else {
                String str = ((Object) getText()) + "a";
                float f10 = this.f3124b;
                float f11 = this.f3128i;
                int i9 = this.f3126d;
                int measuredWidth2 = getMeasuredWidth() - (getPaddingRight() + getPaddingLeft());
                Context context2 = getContext();
                if (j.z(context2) ? kc.a(context2, str, f10 * 3.0f, f11, i9, measuredWidth2) : kc.a(context2, str, TypedValue.applyDimension(2, f10, context2.getResources().getDisplayMetrics()), f11, i9, measuredWidth2)) {
                    setLetterSpacing(this.f3128i);
                    setTextSize(this.f3124b);
                } else {
                    setLetterSpacing(this.f3127h);
                    setTextSize(this.f3125c);
                }
            }
        }
        setMaxLines(this.f3126d);
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public float getMaxLetterSpacing() {
        return this.f3127h;
    }

    public int getMaxTextLine() {
        return this.f3126d;
    }

    public int getMaxTextSizeSp() {
        return this.f3124b;
    }

    public float getMinLetterSpacing() {
        return this.f3128i;
    }

    public int getMinTextSizeSp() {
        return this.f3125c;
    }

    public int getPaddingCorrection() {
        return this.e;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int i8, int i9) {
        a();
        super.onMeasure(i8, i9);
        a();
    }

    public void setMaxLetterSpacing(float f) {
        this.f3127h = f;
    }

    public void setMaxTextLine(int i8) {
        this.f3126d = i8;
    }

    public void setMaxTextSizeSp(int i8) {
        this.f3124b = i8;
    }

    public void setMinLetterSpacing(float f) {
        this.f3128i = f;
    }

    public void setMinTextSizeSp(int i8) {
        this.f3125c = i8;
    }

    public void setPaddingCorrection(int i8) {
        this.e = i8;
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        if (j.z(getContext())) {
            setTextSize(0, f * 3.0f);
        } else {
            setTextSize(2, f);
        }
    }

    public OSAutoTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3124b = 14;
        this.f3125c = 12;
        this.f3126d = 2;
        this.e = 8;
        this.f3127h = 0.0f;
        this.f3128i = 0.0f;
        setMaxLines(2);
        setTextSize(this.f3124b);
        setLetterSpacing(this.f3127h);
    }

    public OSAutoTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f3124b = 14;
        this.f3125c = 12;
        this.f3126d = 2;
        this.e = 8;
        this.f3127h = 0.0f;
        this.f3128i = 0.0f;
        setMaxLines(2);
        setTextSize(this.f3124b);
        setLetterSpacing(this.f3127h);
    }
}
