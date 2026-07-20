package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import g.a;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ArcMotion extends PathMotion {
    private static final float DEFAULT_MAX_ANGLE_DEGREES = 70.0f;
    private static final float DEFAULT_MAX_TANGENT = (float) Math.tan(Math.toRadians(35.0d));
    private static final float DEFAULT_MIN_ANGLE_DEGREES = 0.0f;
    private float mMaximumAngle;
    private float mMaximumTangent;
    private float mMinimumHorizontalAngle;
    private float mMinimumHorizontalTangent;
    private float mMinimumVerticalAngle;
    private float mMinimumVerticalTangent;

    public ArcMotion() {
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
    }

    private static float toTangent(float f10) {
        if (f10 < 0.0f || f10 > 90.0f) {
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return (float) Math.tan(Math.toRadians(f10 / 2.0f));
    }

    public float getMaximumAngle() {
        return this.mMaximumAngle;
    }

    public float getMinimumHorizontalAngle() {
        return this.mMinimumHorizontalAngle;
    }

    public float getMinimumVerticalAngle() {
        return this.mMinimumVerticalAngle;
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float f10, float f11, float f12, float f13) {
        float fA;
        float fA2;
        float f14;
        Path path = new Path();
        path.moveTo(f10, f11);
        float f15 = f12 - f10;
        float f16 = f13 - f11;
        float f17 = (f16 * f16) + (f15 * f15);
        float f18 = (f10 + f12) / 2.0f;
        float f19 = (f11 + f13) / 2.0f;
        float f20 = 0.25f * f17;
        boolean z10 = f11 > f13;
        if (Math.abs(f15) < Math.abs(f16)) {
            float fAbs = Math.abs(f17 / (f16 * 2.0f));
            if (z10) {
                fA2 = fAbs + f13;
                fA = f12;
            } else {
                fA2 = fAbs + f11;
                fA = f10;
            }
            f14 = this.mMinimumVerticalTangent;
        } else {
            float f21 = f17 / (f15 * 2.0f);
            if (z10) {
                fA2 = f11;
                fA = f21 + f10;
            } else {
                fA = f12 - f21;
                fA2 = f13;
            }
            f14 = this.mMinimumHorizontalTangent;
        }
        float f22 = f20 * f14 * f14;
        float f23 = f18 - fA;
        float f24 = f19 - fA2;
        float f25 = (f24 * f24) + (f23 * f23);
        float f26 = this.mMaximumTangent;
        float f27 = f20 * f26 * f26;
        if (f25 >= f22) {
            f22 = f25 > f27 ? f27 : 0.0f;
        }
        if (f22 != 0.0f) {
            float fSqrt = (float) Math.sqrt(f22 / f25);
            fA = a.a(fA, f18, fSqrt, f18);
            fA2 = a.a(fA2, f19, fSqrt, f19);
        }
        path.cubicTo((f10 + fA) / 2.0f, (f11 + fA2) / 2.0f, (fA + f12) / 2.0f, (fA2 + f13) / 2.0f, f12, f13);
        return path;
    }

    public void setMaximumAngle(float f10) {
        this.mMaximumAngle = f10;
        this.mMaximumTangent = toTangent(f10);
    }

    public void setMinimumHorizontalAngle(float f10) {
        this.mMinimumHorizontalAngle = f10;
        this.mMinimumHorizontalTangent = toTangent(f10);
    }

    public void setMinimumVerticalAngle(float f10) {
        this.mMinimumVerticalAngle = f10;
        this.mMinimumVerticalTangent = toTangent(f10);
    }

    @b.a({"RestrictedApi"})
    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.ARC_MOTION);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(typedArrayObtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(typedArrayObtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(typedArrayObtainStyledAttributes, xmlPullParser, "maximumAngle", 2, DEFAULT_MAX_ANGLE_DEGREES));
        typedArrayObtainStyledAttributes.recycle();
    }
}
