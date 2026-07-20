package com.transsion.widgetslib.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatButton;
import com.transsion.widgetslib.widget.autoadjust.OSMediumButton;
import k3.kc;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public class OSBigButton extends AppCompatButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3132d;
    public int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3133h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f3134i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f3135j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public be.b f3136k;

    public OSBigButton(Context context) {
        super(context);
        this.f3129a = 15;
        this.f3130b = 13;
        this.f3131c = 72;
        this.f3132d = 44;
        this.e = 2;
        this.f3133h = 8;
        this.f3134i = 0.0f;
        this.f3135j = -0.05f;
        b();
    }

    public final void a() {
        if (getLineCount() == this.e) {
            CharSequence text = getText();
            float f = this.f3129a;
            float f4 = this.f3134i;
            int i8 = this.e;
            int measuredWidth = getMeasuredWidth() - (getPaddingRight() + getPaddingLeft());
            Context context = getContext();
            if (j.z(context) ? kc.a(context, text, f * 3.0f, f4, i8, measuredWidth) : kc.a(context, text, TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics()), f4, i8, measuredWidth)) {
                setLetterSpacing(this.f3134i);
                setTextSize(this.f3129a);
            } else {
                CharSequence text2 = getText();
                float f10 = this.f3129a;
                float f11 = this.f3135j;
                int i9 = this.e;
                int measuredWidth2 = getMeasuredWidth() - (getPaddingRight() + getPaddingLeft());
                Context context2 = getContext();
                if (j.z(context2) ? kc.a(context2, text2, f10 * 3.0f, f11, i9, measuredWidth2) : kc.a(context2, text2, TypedValue.applyDimension(2, f10, context2.getResources().getDisplayMetrics()), f11, i9, measuredWidth2)) {
                    setLetterSpacing(this.f3135j);
                    setTextSize(this.f3129a);
                } else {
                    setLetterSpacing(this.f3134i);
                    setTextSize(this.f3130b);
                }
            }
            setMeasuredDimension(getMeasuredWidth(), hd.a.a(getContext(), this.f3131c));
        } else {
            int measuredWidth3 = getMeasuredWidth();
            Context context3 = getContext();
            int i10 = this.f3132d;
            String[] strArr = j.f8764a;
            setMeasuredDimension(measuredWidth3, hd.a.a(context3, i10));
        }
        setMaxLines(this.e);
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public final void b() {
        setMaxLines(2);
        setTextSize(this.f3129a);
        setLetterSpacing(this.f3134i);
    }

    public int getMaxButtonHeightDp() {
        return this.f3131c;
    }

    public float getMaxLetterSpacing() {
        return this.f3134i;
    }

    public int getMaxTextLine() {
        return this.e;
    }

    public int getMaxTextSizeSp() {
        return this.f3129a;
    }

    public int getMinButtonHeightDp() {
        return this.f3132d;
    }

    public float getMinLetterSpacing() {
        return this.f3135j;
    }

    public int getMinTextSizeSp() {
        return this.f3130b;
    }

    public int getPaddingCorrection() {
        return this.f3133h;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i8, int i9) {
        a();
        super.onMeasure(i8, i9);
        a();
        be.b bVar = this.f3136k;
        if (bVar != null) {
            switch (bVar.f1272a) {
                case 0:
                    OSMediumButton oSMediumButton = bVar.f1273b;
                    OSBigButton oSBigButton = oSMediumButton.f3472a;
                    CharSequence text = oSBigButton.getText();
                    float maxTextSizeSp = oSMediumButton.f3472a.getMaxTextSizeSp();
                    float minLetterSpacing = oSMediumButton.f3472a.getMinLetterSpacing();
                    int measuredWidth = oSBigButton.getMeasuredWidth() - (oSBigButton.getPaddingRight() + oSBigButton.getPaddingLeft());
                    Context context = oSBigButton.getContext();
                    oSMediumButton.e = !(j.z(context) ? kc.a(context, text, maxTextSizeSp * 3.0f, minLetterSpacing, 1, measuredWidth) : kc.a(context, text, TypedValue.applyDimension(2, maxTextSizeSp, context.getResources().getDisplayMetrics()), minLetterSpacing, 1, measuredWidth));
                    oSMediumButton.a();
                    break;
                default:
                    OSMediumButton oSMediumButton2 = bVar.f1273b;
                    OSBigButton oSBigButton2 = oSMediumButton2.f3473b;
                    CharSequence text2 = oSBigButton2.getText();
                    float maxTextSizeSp2 = oSMediumButton2.f3473b.getMaxTextSizeSp();
                    float minLetterSpacing2 = oSMediumButton2.f3473b.getMinLetterSpacing();
                    int measuredWidth2 = oSBigButton2.getMeasuredWidth() - (oSBigButton2.getPaddingRight() + oSBigButton2.getPaddingLeft());
                    Context context2 = oSBigButton2.getContext();
                    oSMediumButton2.f3476h = !(j.z(context2) ? kc.a(context2, text2, maxTextSizeSp2 * 3.0f, minLetterSpacing2, 1, measuredWidth2) : kc.a(context2, text2, TypedValue.applyDimension(2, maxTextSizeSp2, context2.getResources().getDisplayMetrics()), minLetterSpacing2, 1, measuredWidth2));
                    oSMediumButton2.a();
                    break;
            }
        }
    }

    public void setMaxButtonHeightDp(int i8) {
        this.f3131c = i8;
    }

    public void setMaxLetterSpacing(float f) {
        this.f3134i = f;
    }

    public void setMaxTextLine(int i8) {
        this.e = i8;
    }

    public void setMaxTextSizeSp(int i8) {
        this.f3129a = i8;
    }

    public void setMinButtonHeightDp(int i8) {
        this.f3132d = i8;
    }

    public void setMinLetterSpacing(float f) {
        this.f3135j = f;
    }

    public void setMinTextSizeSp(int i8) {
        this.f3130b = i8;
    }

    public void setPaddingCorrection(int i8) {
        this.f3133h = i8;
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        if (j.z(getContext())) {
            setTextSize(0, f * 3.0f);
        } else {
            setTextSize(2, f);
        }
    }

    public OSBigButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3129a = 15;
        this.f3130b = 13;
        this.f3131c = 72;
        this.f3132d = 44;
        this.e = 2;
        this.f3133h = 8;
        this.f3134i = 0.0f;
        this.f3135j = -0.05f;
        b();
    }

    public OSBigButton(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f3129a = 15;
        this.f3130b = 13;
        this.f3131c = 72;
        this.f3132d = 44;
        this.e = 2;
        this.f3133h = 8;
        this.f3134i = 0.0f;
        this.f3135j = -0.05f;
        b();
    }
}
