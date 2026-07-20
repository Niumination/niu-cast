package com.transsion.atomiccore.support.host;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import k7.f;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class AtomicLayoutData {
    private final String mConstraintBottom;
    private final Integer mFontWeight = null;
    private final Integer mLayoutHeight;
    private final Integer mLayoutMarginBottom;
    private final Integer mLayoutMarginEnd;
    private final Integer mLayoutMarginStart;
    private final Integer mLayoutMarginTop;
    private final Integer mLayoutWidth;
    private final Integer mMaxLines;
    private final Integer mPaddingBottom;
    private final Integer mPaddingEnd;
    private final Integer mPaddingStart;
    private final Integer mPaddingTop;
    private final Integer mRadius;
    private final String mTextColor;
    private final Integer mTextSize;

    public AtomicLayoutData(f fVar) {
        this.mTextSize = fVar.f6792a;
        this.mTextColor = fVar.f6793b;
        this.mMaxLines = fVar.f6794c;
        this.mLayoutWidth = fVar.f6795d;
        this.mLayoutHeight = fVar.e;
        this.mPaddingStart = fVar.f;
        this.mPaddingEnd = fVar.f6796g;
        this.mPaddingTop = fVar.f6797h;
        this.mPaddingBottom = fVar.f6798i;
        this.mLayoutMarginTop = fVar.f6799j;
        this.mLayoutMarginStart = fVar.f6800k;
        this.mLayoutMarginEnd = fVar.f6801l;
        this.mLayoutMarginBottom = fVar.f6802m;
        this.mRadius = fVar.f6803n;
        this.mConstraintBottom = fVar.f6804o;
    }

    public String getConstraintBottom() {
        return this.mConstraintBottom;
    }

    public Integer getFontWeight() {
        return this.mFontWeight;
    }

    public Integer getLayoutHeight() {
        return this.mLayoutHeight;
    }

    public Integer getLayoutMarginBottom() {
        return this.mLayoutMarginBottom;
    }

    public Integer getLayoutMarginEnd() {
        return this.mLayoutMarginEnd;
    }

    public Integer getLayoutMarginStart() {
        return this.mLayoutMarginStart;
    }

    public Integer getLayoutMarginTop() {
        return this.mLayoutMarginTop;
    }

    public Integer getLayoutWidth() {
        return this.mLayoutWidth;
    }

    public Integer getMaxLines() {
        return this.mMaxLines;
    }

    public Integer getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public Integer getPaddingEnd() {
        return this.mPaddingEnd;
    }

    public Integer getPaddingStart() {
        return this.mPaddingStart;
    }

    public Integer getPaddingTop() {
        return this.mPaddingTop;
    }

    public Integer getRadius() {
        return this.mRadius;
    }

    public String getTextColor() {
        return this.mTextColor;
    }

    public Integer getTextSize() {
        return this.mTextSize;
    }

    @NonNull
    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            Integer num = this.mTextSize;
            if (num != null) {
                jSONObject.put("textSize", num);
            }
            String str = this.mTextColor;
            if (str != null) {
                jSONObject.put("textColor", str);
            }
            Integer num2 = this.mMaxLines;
            if (num2 != null) {
                jSONObject.put("maxLines", num2);
            }
            Integer num3 = this.mLayoutWidth;
            if (num3 != null) {
                jSONObject.put("layout_width", num3);
            }
            Integer num4 = this.mLayoutHeight;
            if (num4 != null) {
                jSONObject.put("layout_height", num4);
            }
            Integer num5 = this.mPaddingStart;
            if (num5 != null) {
                jSONObject.put("paddingStart", num5);
            }
            Integer num6 = this.mPaddingEnd;
            if (num6 != null) {
                jSONObject.put("paddingEnd", num6);
            }
            Integer num7 = this.mPaddingTop;
            if (num7 != null) {
                jSONObject.put("paddingTop", num7);
            }
            Integer num8 = this.mPaddingBottom;
            if (num8 != null) {
                jSONObject.put("paddingBottom", num8);
            }
            Integer num9 = this.mLayoutMarginTop;
            if (num9 != null) {
                jSONObject.put("layout_marginTop", num9);
            }
            Integer num10 = this.mLayoutMarginStart;
            if (num10 != null) {
                jSONObject.put("layout_marginStart", num10);
            }
            Integer num11 = this.mLayoutMarginEnd;
            if (num11 != null) {
                jSONObject.put("layout_marginEnd", num11);
            }
            Integer num12 = this.mLayoutMarginBottom;
            if (num12 != null) {
                jSONObject.put("layout_marginBottom", num12);
            }
            Integer num13 = this.mRadius;
            if (num13 != null) {
                jSONObject.put("radius", num13);
            }
            String str2 = this.mConstraintBottom;
            if (str2 != null) {
                jSONObject.put("constraint_bottom", str2);
            }
            Integer num14 = this.mFontWeight;
            if (num14 != null) {
                jSONObject.put("textFontWeight", num14);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        return toJSONObject().toString();
    }
}
