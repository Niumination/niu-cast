package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
abstract class KeyPositionBase extends Key {
    protected static final float SELECTION_SLOPE = 20.0f;
    int mCurveFit = Key.UNSET;

    public abstract void calcPosition(int i8, int i9, float f, float f4, float f10, float f11);

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
    }

    public abstract float getPositionX();

    public abstract float getPositionY();

    public abstract boolean intersects(int i8, int i9, RectF rectF, RectF rectF2, float f, float f4);

    public abstract void positionAttributes(View view, RectF rectF, RectF rectF2, float f, float f4, String[] strArr, float[] fArr);
}
