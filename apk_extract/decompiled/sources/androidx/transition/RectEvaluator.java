package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
class RectEvaluator implements TypeEvaluator<Rect> {
    private Rect mRect;

    public RectEvaluator() {
    }

    public RectEvaluator(Rect rect) {
        this.mRect = rect;
    }

    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f, Rect rect, Rect rect2) {
        int i8 = rect.left;
        int i9 = i8 + ((int) ((rect2.left - i8) * f));
        int i10 = rect.top;
        int i11 = i10 + ((int) ((rect2.top - i10) * f));
        int i12 = rect.right;
        int i13 = i12 + ((int) ((rect2.right - i12) * f));
        int i14 = rect.bottom;
        int i15 = i14 + ((int) ((rect2.bottom - i14) * f));
        Rect rect3 = this.mRect;
        if (rect3 == null) {
            return new Rect(i9, i11, i13, i15);
        }
        rect3.set(i9, i11, i13, i15);
        return this.mRect;
    }
}
