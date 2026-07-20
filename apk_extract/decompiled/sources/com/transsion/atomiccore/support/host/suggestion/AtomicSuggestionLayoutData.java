package com.transsion.atomiccore.support.host.suggestion;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.transsion.atomiccore.support.host.AtomicLayoutData;
import k7.f;
import l7.c;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Deprecated
public class AtomicSuggestionLayoutData {
    private final String constraintBottom;
    private final Integer layoutHeight;
    private final Integer layoutMarginBottom;
    private final Integer layoutMarginEnd;
    private final Integer layoutMarginStart;
    private final Integer layoutMarginTop;
    private final Integer layoutWidth;
    private final Integer maxLines;
    private final Integer paddingBottom;
    private final Integer paddingEnd;
    private final Integer paddingStart;
    private final Integer paddingTop;
    private final Integer radius;
    private final String textColor;
    private final Integer textSize;

    private AtomicSuggestionLayoutData(c cVar) {
        throw null;
    }

    public String getConstraintBottom() {
        return this.constraintBottom;
    }

    public Integer getLayoutHeight() {
        return this.layoutHeight;
    }

    public Integer getLayoutMarginBottom() {
        return this.layoutMarginBottom;
    }

    public Integer getLayoutMarginEnd() {
        return this.layoutMarginEnd;
    }

    public Integer getLayoutMarginStart() {
        return this.layoutMarginStart;
    }

    public Integer getLayoutMarginTop() {
        return this.layoutMarginTop;
    }

    public Integer getLayoutWidth() {
        return this.layoutWidth;
    }

    public Integer getMaxLines() {
        return this.maxLines;
    }

    public Integer getPaddingBottom() {
        return this.paddingBottom;
    }

    public Integer getPaddingEnd() {
        return this.paddingEnd;
    }

    public Integer getPaddingStart() {
        return this.paddingStart;
    }

    public Integer getPaddingTop() {
        return this.paddingTop;
    }

    public Integer getRadius() {
        return this.radius;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public Integer getTextSize() {
        return this.textSize;
    }

    public AtomicLayoutData toAtomicLayoutData() {
        f fVar = new f();
        fVar.f6792a = this.textSize;
        fVar.f6793b = this.textColor;
        fVar.f6794c = this.maxLines;
        fVar.f6795d = this.layoutWidth;
        fVar.e = this.layoutHeight;
        fVar.f = this.paddingStart;
        fVar.f6796g = this.paddingEnd;
        fVar.f6797h = this.paddingTop;
        fVar.f6798i = this.paddingBottom;
        fVar.f6799j = this.layoutMarginTop;
        fVar.f6800k = this.layoutMarginStart;
        fVar.f6801l = this.layoutMarginEnd;
        fVar.f6802m = this.layoutMarginBottom;
        fVar.f6803n = this.radius;
        fVar.f6804o = this.constraintBottom;
        return new AtomicLayoutData(fVar);
    }

    @NonNull
    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            Integer num = this.textSize;
            if (num != null) {
                jSONObject.put("textSize", num);
            }
            String str = this.textColor;
            if (str != null) {
                jSONObject.put("textColor", str);
            }
            Integer num2 = this.maxLines;
            if (num2 != null) {
                jSONObject.put("maxLines", num2);
            }
            Integer num3 = this.layoutWidth;
            if (num3 != null) {
                jSONObject.put("layout_width", num3);
            }
            Integer num4 = this.layoutHeight;
            if (num4 != null) {
                jSONObject.put("layout_height", num4);
            }
            Integer num5 = this.paddingStart;
            if (num5 != null) {
                jSONObject.put("paddingStart", num5);
            }
            Integer num6 = this.paddingEnd;
            if (num6 != null) {
                jSONObject.put("paddingEnd", num6);
            }
            Integer num7 = this.paddingTop;
            if (num7 != null) {
                jSONObject.put("paddingTop", num7);
            }
            Integer num8 = this.paddingBottom;
            if (num8 != null) {
                jSONObject.put("paddingBottom", num8);
            }
            Integer num9 = this.layoutMarginTop;
            if (num9 != null) {
                jSONObject.put("layout_marginTop", num9);
            }
            Integer num10 = this.layoutMarginStart;
            if (num10 != null) {
                jSONObject.put("layout_marginStart", num10);
            }
            Integer num11 = this.layoutMarginEnd;
            if (num11 != null) {
                jSONObject.put("layout_marginEnd", num11);
            }
            Integer num12 = this.layoutMarginBottom;
            if (num12 != null) {
                jSONObject.put("layout_marginBottom", num12);
            }
            Integer num13 = this.radius;
            if (num13 != null) {
                jSONObject.put("radius", num13);
            }
            String str2 = this.constraintBottom;
            if (str2 != null) {
                jSONObject.put("constraint_bottom", str2);
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
