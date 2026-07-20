package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
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

    private static float toTangent(float f) {
        if (f < 0.0f || f > 90.0f) {
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return (float) Math.tan(Math.toRadians(f / 2.0f));
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
    @NonNull
    public Path getPath(float f, float f4, float f10, float f11) {
        float fB;
        float fB2;
        float f12;
        Path path = new Path();
        path.moveTo(f, f4);
        float f13 = f10 - f;
        float f14 = f11 - f4;
        float f15 = (f14 * f14) + (f13 * f13);
        float f16 = (f + f10) / 2.0f;
        float f17 = (f4 + f11) / 2.0f;
        float f18 = 0.25f * f15;
        boolean z2 = f4 > f11;
        if (Math.abs(f13) < Math.abs(f14)) {
            float fAbs = Math.abs(f15 / (f14 * 2.0f));
            if (z2) {
                fB2 = fAbs + f11;
                fB = f10;
            } else {
                fB2 = fAbs + f4;
                fB = f;
            }
            f12 = this.mMinimumVerticalTangent;
        } else {
            float f19 = f15 / (f13 * 2.0f);
            if (z2) {
                fB2 = f4;
                fB = f19 + f;
            } else {
                fB = f10 - f19;
                fB2 = f11;
            }
            f12 = this.mMinimumHorizontalTangent;
        }
        float f20 = f18 * f12 * f12;
        float f21 = f16 - fB;
        float f22 = f17 - fB2;
        float f23 = (f22 * f22) + (f21 * f21);
        float f24 = this.mMaximumTangent;
        float f25 = f18 * f24 * f24;
        if (f23 >= f20) {
            f20 = f23 > f25 ? f25 : 0.0f;
        }
        if (f20 != 0.0f) {
            float fSqrt = (float) Math.sqrt(f20 / f23);
            fB = a1.a.b(fB, f16, fSqrt, f16);
            fB2 = a1.a.b(fB2, f17, fSqrt, f17);
        }
        path.cubicTo((f + fB) / 2.0f, (f4 + fB2) / 2.0f, (fB + f10) / 2.0f, (fB2 + f11) / 2.0f, f10, f11);
        return path;
    }

    public void setMaximumAngle(float f) {
        this.mMaximumAngle = f;
        this.mMaximumTangent = toTangent(f);
    }

    public void setMinimumHorizontalAngle(float f) {
        this.mMinimumHorizontalAngle = f;
        this.mMinimumHorizontalTangent = toTangent(f);
    }

    public void setMinimumVerticalAngle(float f) {
        this.mMinimumVerticalAngle = f;
        this.mMinimumVerticalTangent = toTangent(f);
    }

    public ArcMotion(@NonNull Context context, @NonNull AttributeSet attributeSet) {
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
