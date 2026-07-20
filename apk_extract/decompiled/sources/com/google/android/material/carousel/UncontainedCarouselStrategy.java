package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class UncontainedCarouselStrategy extends CarouselStrategy {
    private static final float MEDIUM_LARGE_ITEM_PERCENTAGE_THRESHOLD = 0.85f;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UncontainedCarouselStrategy() {
    }

    private float calculateMediumChildSize(float f, float f4, float f10) {
        float fMax = Math.max(1.5f * f10, f);
        float f11 = MEDIUM_LARGE_ITEM_PERCENTAGE_THRESHOLD * f4;
        if (fMax > f11) {
            fMax = Math.max(f11, f10 * 1.2f);
        }
        return Math.min(f4, fMax);
    }

    private KeylineState createCenterAlignedKeylineState(float f, float f4, float f10, int i8, float f11, float f12, float f13) {
        float fMin = Math.min(f12, f10);
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(fMin, f10, f4);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(f11, f10, f4);
        float f14 = f11 / 2.0f;
        float f15 = (f13 + 0.0f) - f14;
        float f16 = f15 + f14;
        float f17 = fMin / 2.0f;
        float f18 = (i8 * f10) + f16;
        KeylineState.Builder builderAddKeylineRange = new KeylineState.Builder(f10, f).addAnchorKeyline((f15 - f14) - f17, childMaskPercentage, fMin).addKeyline(f15, childMaskPercentage2, f11, false).addKeylineRange((f10 / 2.0f) + f16, 0.0f, f10, i8, true);
        builderAddKeylineRange.addKeyline(f14 + f18, childMaskPercentage2, f11, false);
        builderAddKeylineRange.addAnchorKeyline(f18 + f11 + f17, childMaskPercentage, fMin);
        return builderAddKeylineRange.build();
    }

    private KeylineState createLeftAlignedKeylineState(Context context, float f, float f4, float f10, int i8, float f11, int i9, float f12) {
        float fMin = Math.min(f12, f10);
        float fMax = Math.max(fMin, 0.5f * f11);
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(fMax, f10, f);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(fMin, f10, f);
        float childMaskPercentage3 = CarouselStrategy.getChildMaskPercentage(f11, f10, f);
        float f13 = (i8 * f10) + 0.0f;
        KeylineState.Builder builderAddKeylineRange = new KeylineState.Builder(f10, f4).addAnchorKeyline(0.0f - (fMax / 2.0f), childMaskPercentage, fMax).addKeylineRange(f10 / 2.0f, 0.0f, f10, i8, true);
        if (i9 > 0) {
            float f14 = (f11 / 2.0f) + f13;
            f13 += f11;
            builderAddKeylineRange.addKeyline(f14, childMaskPercentage3, f11, false);
        }
        builderAddKeylineRange.addAnchorKeyline((CarouselStrategyHelper.getExtraSmallSize(context) / 2.0f) + f13, childMaskPercentage2, fMin);
        return builderAddKeylineRange.build();
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean isContained() {
        return false;
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        float f;
        float containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            float f10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
            f = f10;
        } else {
            f = f4;
        }
        float f11 = measuredHeight + f;
        float extraSmallSize = CarouselStrategyHelper.getExtraSmallSize(view.getContext()) + f;
        float extraSmallSize2 = CarouselStrategyHelper.getExtraSmallSize(view.getContext()) + f;
        int iMax = Math.max(1, (int) Math.floor(containerWidth / f11));
        float f12 = containerWidth - (iMax * f11);
        if (carousel.getCarouselAlignment() == 1) {
            float f13 = f12 / 2.0f;
            return createCenterAlignedKeylineState(containerWidth, f, f11, iMax, Math.max(Math.min(3.0f * f13, f11), getSmallItemSizeMin() + f), extraSmallSize2, f13);
        }
        return createLeftAlignedKeylineState(view.getContext(), f, containerWidth, f11, iMax, calculateMediumChildSize(extraSmallSize, f11, f12), f12 > 0.0f ? 1 : 0, extraSmallSize2);
    }
}
