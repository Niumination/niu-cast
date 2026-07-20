package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class MultiBrowseCarouselStrategy extends CarouselStrategy {
    private int keylineCount = 0;
    private static final int[] SMALL_COUNTS = {1};
    private static final int[] MEDIUM_COUNTS = {1, 0};

    public boolean ensureArrangementFitsItemCount(Arrangement arrangement, int i8) {
        int itemCount = arrangement.getItemCount() - i8;
        boolean z2 = itemCount > 0 && (arrangement.smallCount > 0 || arrangement.mediumCount > 1);
        while (itemCount > 0) {
            int i9 = arrangement.smallCount;
            if (i9 > 0) {
                arrangement.smallCount = i9 - 1;
            } else {
                int i10 = arrangement.mediumCount;
                if (i10 > 1) {
                    arrangement.mediumCount = i10 - 1;
                }
            }
            itemCount--;
        }
        return z2;
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        float containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            f = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float f4 = f;
        float smallItemSizeMin = getSmallItemSizeMin() + f4;
        float fMax = Math.max(getSmallItemSizeMax() + f4, smallItemSizeMin);
        float fMin = Math.min(measuredHeight + f4, containerHeight);
        float fClamp = MathUtils.clamp((measuredHeight / 3.0f) + f4, smallItemSizeMin + f4, fMax + f4);
        float f10 = (fMin + fClamp) / 2.0f;
        int[] iArrDoubleCounts = SMALL_COUNTS;
        if (containerHeight < 2.0f * smallItemSizeMin) {
            iArrDoubleCounts = new int[]{0};
        }
        int[] iArrDoubleCounts2 = MEDIUM_COUNTS;
        if (carousel.getCarouselAlignment() == 1) {
            iArrDoubleCounts = CarouselStrategy.doubleCounts(iArrDoubleCounts);
            iArrDoubleCounts2 = CarouselStrategy.doubleCounts(iArrDoubleCounts2);
        }
        int[] iArr = iArrDoubleCounts;
        int[] iArr2 = iArrDoubleCounts2;
        int iMax = (int) Math.max(1.0d, Math.floor(((containerHeight - (CarouselStrategyHelper.maxValue(iArr2) * f10)) - (CarouselStrategyHelper.maxValue(iArr) * fMax)) / fMin));
        int iCeil = (int) Math.ceil(containerHeight / fMin);
        int i8 = (iCeil - iMax) + 1;
        int[] iArr3 = new int[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            iArr3[i9] = iCeil - i9;
        }
        Arrangement arrangementFindLowestCostArrangement = Arrangement.findLowestCostArrangement(containerHeight, fClamp, smallItemSizeMin, fMax, iArr, f10, iArr2, fMin, iArr3);
        this.keylineCount = arrangementFindLowestCostArrangement.getItemCount();
        if (ensureArrangementFitsItemCount(arrangementFindLowestCostArrangement, carousel.getItemCount())) {
            arrangementFindLowestCostArrangement = Arrangement.findLowestCostArrangement(containerHeight, fClamp, smallItemSizeMin, fMax, new int[]{arrangementFindLowestCostArrangement.smallCount}, f10, new int[]{arrangementFindLowestCostArrangement.mediumCount}, fMin, new int[]{arrangementFindLowestCostArrangement.largeCount});
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f4, containerHeight, arrangementFindLowestCostArrangement, carousel.getCarouselAlignment());
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean shouldRefreshKeylineState(Carousel carousel, int i8) {
        return (i8 < this.keylineCount && carousel.getItemCount() >= this.keylineCount) || (i8 >= this.keylineCount && carousel.getItemCount() < this.keylineCount);
    }
}
