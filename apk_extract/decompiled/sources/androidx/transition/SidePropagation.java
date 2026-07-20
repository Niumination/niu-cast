package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class SidePropagation extends VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;
    private int mSide = 80;

    /* JADX WARN: Code duplicated, block: B:6:0x0010  */
    /* JADX WARN: Code duplicated, block: B:7:0x0012  */
    private int distance(View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        int i16 = this.mSide;
        if (i16 == 8388611) {
            if (view.getLayoutDirection() == 1) {
                i16 = 5;
            } else {
                i16 = 3;
            }
        } else if (i16 == 8388613) {
            if (view.getLayoutDirection() == 1) {
                i16 = 3;
            } else {
                i16 = 5;
            }
        }
        if (i16 == 3) {
            return Math.abs(i11 - i9) + (i14 - i8);
        }
        if (i16 == 5) {
            return Math.abs(i11 - i9) + (i8 - i12);
        }
        if (i16 == 48) {
            return Math.abs(i10 - i8) + (i15 - i9);
        }
        if (i16 != 80) {
            return 0;
        }
        return Math.abs(i10 - i8) + (i9 - i13);
    }

    private int getMaxDistance(ViewGroup viewGroup) {
        int i8 = this.mSide;
        return (i8 == 3 || i8 == 5 || i8 == 8388611 || i8 == 8388613) ? viewGroup.getWidth() : viewGroup.getHeight();
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(@NonNull ViewGroup viewGroup, @NonNull Transition transition, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        int i8;
        int iCenterX;
        int iCenterY;
        TransitionValues transitionValues3 = transitionValues;
        if (transitionValues3 == null && transitionValues2 == null) {
            return 0L;
        }
        Rect epicenter = transition.getEpicenter();
        if (transitionValues2 == null || getViewVisibility(transitionValues3) == 0) {
            i8 = -1;
        } else {
            transitionValues3 = transitionValues2;
            i8 = 1;
        }
        int viewX = getViewX(transitionValues3);
        int viewY = getViewY(transitionValues3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int iRound = iArr[0] + Math.round(viewGroup.getTranslationX());
        int iRound2 = Math.round(viewGroup.getTranslationY()) + iArr[1];
        int width = viewGroup.getWidth() + iRound;
        int height = viewGroup.getHeight() + iRound2;
        if (epicenter != null) {
            iCenterX = epicenter.centerX();
            iCenterY = epicenter.centerY();
        } else {
            iCenterX = (iRound + width) / 2;
            iCenterY = (iRound2 + height) / 2;
        }
        float fDistance = distance(viewGroup, viewX, viewY, iCenterX, iCenterY, iRound, iRound2, width, height) / getMaxDistance(viewGroup);
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return Math.round(((duration * ((long) i8)) / this.mPropagationSpeed) * fDistance);
    }

    public void setPropagationSpeed(float f) {
        if (f == 0.0f) {
            throw new IllegalArgumentException("propagationSpeed may not be 0");
        }
        this.mPropagationSpeed = f;
    }

    public void setSide(int i8) {
        this.mSide = i8;
    }
}
