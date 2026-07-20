package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialSideContainerBackHelper extends MaterialBackAnimationHelper<View> {
    private final float maxScaleXDistanceGrow;
    private final float maxScaleXDistanceShrink;
    private final float maxScaleYDistance;

    public MaterialSideContainerBackHelper(@NonNull View view) {
        super(view);
        Resources resources = view.getResources();
        this.maxScaleXDistanceShrink = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.maxScaleXDistanceGrow = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.maxScaleYDistance = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
    }

    private boolean checkAbsoluteGravity(@GravityInt int i8, @GravityInt int i9) {
        return (GravityCompat.getAbsoluteGravity(i8, ViewCompat.getLayoutDirection(this.view)) & i9) == i9;
    }

    private int getEdgeMargin(boolean z2) {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return z2 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
    }

    public void cancelBackProgress() {
        if (super.onCancelBackProgress() == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.view, (Property<V, Float>) View.SCALE_Y, 1.0f));
        V v3 = this.view;
        if (v3 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v3;
            for (int i8 = 0; i8 < viewGroup.getChildCount(); i8++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i8), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(this.cancelDuration);
        animatorSet.start();
    }

    public void finishBackProgress(@NonNull BackEventCompat backEventCompat, @GravityInt final int i8, @Nullable Animator.AnimatorListener animatorListener, @Nullable ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        final boolean z2 = backEventCompat.getSwipeEdge() == 0;
        boolean zCheckAbsoluteGravity = checkAbsoluteGravity(i8, 3);
        float scaleX = (this.view.getScaleX() * this.view.getWidth()) + getEdgeMargin(zCheckAbsoluteGravity);
        V v3 = this.view;
        Property property = View.TRANSLATION_X;
        if (zCheckAbsoluteGravity) {
            scaleX = -scaleX;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(v3, (Property<V, Float>) property, scaleX);
        if (animatorUpdateListener != null) {
            objectAnimatorOfFloat.addUpdateListener(animatorUpdateListener);
        }
        objectAnimatorOfFloat.setInterpolator(new FastOutSlowInInterpolator());
        objectAnimatorOfFloat.setDuration(AnimationUtils.lerp(this.hideDurationMax, this.hideDurationMin, backEventCompat.getProgress()));
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.motion.MaterialSideContainerBackHelper.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                MaterialSideContainerBackHelper.this.view.setTranslationX(0.0f);
                MaterialSideContainerBackHelper.this.updateBackProgress(0.0f, z2, i8);
            }
        });
        if (animatorListener != null) {
            objectAnimatorOfFloat.addListener(animatorListener);
        }
        objectAnimatorOfFloat.start();
    }

    public void startBackProgress(@NonNull BackEventCompat backEventCompat) {
        super.onStartBackProgress(backEventCompat);
    }

    public void updateBackProgress(@NonNull BackEventCompat backEventCompat, @GravityInt int i8) {
        if (super.onUpdateBackProgress(backEventCompat) == null) {
            return;
        }
        updateBackProgress(backEventCompat.getProgress(), backEventCompat.getSwipeEdge() == 0, i8);
    }

    @VisibleForTesting
    public void updateBackProgress(float f, boolean z2, @GravityInt int i8) {
        float width;
        float fInterpolateProgress = interpolateProgress(f);
        boolean zCheckAbsoluteGravity = checkAbsoluteGravity(i8, 3);
        boolean z3 = z2 == zCheckAbsoluteGravity;
        int width2 = this.view.getWidth();
        int height = this.view.getHeight();
        float f4 = width2;
        if (f4 > 0.0f) {
            float f10 = height;
            if (f10 <= 0.0f) {
                return;
            }
            float f11 = this.maxScaleXDistanceShrink / f4;
            float f12 = this.maxScaleXDistanceGrow / f4;
            float f13 = this.maxScaleYDistance / f10;
            V v3 = this.view;
            if (zCheckAbsoluteGravity) {
                f4 = 0.0f;
            }
            v3.setPivotX(f4);
            if (!z3) {
                f12 = -f11;
            }
            float fLerp = AnimationUtils.lerp(0.0f, f12, fInterpolateProgress);
            float f14 = fLerp + 1.0f;
            this.view.setScaleX(f14);
            float fLerp2 = 1.0f - AnimationUtils.lerp(0.0f, f13, fInterpolateProgress);
            this.view.setScaleY(fLerp2);
            V v8 = this.view;
            if (v8 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) v8;
                for (int i9 = 0; i9 < viewGroup.getChildCount(); i9++) {
                    View childAt = viewGroup.getChildAt(i9);
                    if (zCheckAbsoluteGravity) {
                        width = childAt.getWidth() + (width2 - childAt.getRight());
                    } else {
                        width = -childAt.getLeft();
                    }
                    childAt.setPivotX(width);
                    childAt.setPivotY(-childAt.getTop());
                    float f15 = z3 ? 1.0f - fLerp : 1.0f;
                    float f16 = fLerp2 != 0.0f ? (f14 / fLerp2) * f15 : 1.0f;
                    childAt.setScaleX(f15);
                    childAt.setScaleY(f16);
                }
            }
        }
    }
}
