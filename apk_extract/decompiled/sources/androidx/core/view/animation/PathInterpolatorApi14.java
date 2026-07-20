package androidx.core.view.animation;

import a1.a;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
class PathInterpolatorApi14 implements Interpolator {
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;

    public PathInterpolatorApi14(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i8 = (int) (length / 0.002f);
        int i9 = i8 + 1;
        this.mX = new float[i9];
        this.mY = new float[i9];
        float[] fArr = new float[2];
        for (int i10 = 0; i10 < i9; i10++) {
            pathMeasure.getPosTan((i10 * length) / i8, fArr, null);
            this.mX[i10] = fArr[0];
            this.mY[i10] = fArr[1];
        }
    }

    private static Path createCubic(float f, float f4, float f10, float f11) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f4, f10, f11, 1.0f, 1.0f);
        return path;
    }

    private static Path createQuad(float f, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f4, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.mX.length - 1;
        int i8 = 0;
        while (length - i8 > 1) {
            int i9 = (i8 + length) / 2;
            if (f < this.mX[i9]) {
                length = i9;
            } else {
                i8 = i9;
            }
        }
        float[] fArr = this.mX;
        float f4 = fArr[length];
        float f10 = fArr[i8];
        float f11 = f4 - f10;
        if (f11 == 0.0f) {
            return this.mY[i8];
        }
        float[] fArr2 = this.mY;
        float f12 = fArr2[i8];
        return a.b(fArr2[length], f12, (f - f10) / f11, f12);
    }

    public PathInterpolatorApi14(float f, float f4) {
        this(createQuad(f, f4));
    }

    public PathInterpolatorApi14(float f, float f4, float f10, float f11) {
        this(createCubic(f, f4, f10, f11));
    }
}
