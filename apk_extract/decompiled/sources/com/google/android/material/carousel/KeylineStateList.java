package com.google.android.material.carousel;

import a1.a;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class KeylineStateList {
    private static final int NO_INDEX = -1;
    private final KeylineState defaultState;
    private final float endShiftRange;
    private final List<KeylineState> endStateSteps;
    private final float[] endStateStepsInterpolationPoints;
    private final float startShiftRange;
    private final List<KeylineState> startStateSteps;
    private final float[] startStateStepsInterpolationPoints;

    private KeylineStateList(@NonNull KeylineState keylineState, List<KeylineState> list, List<KeylineState> list2) {
        this.defaultState = keylineState;
        this.startStateSteps = Collections.unmodifiableList(list);
        this.endStateSteps = Collections.unmodifiableList(list2);
        float f = ((KeylineState) a.j(1, list)).getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
        this.startShiftRange = f;
        float f4 = keylineState.getLastKeyline().loc - ((KeylineState) a.j(1, list2)).getLastKeyline().loc;
        this.endShiftRange = f4;
        this.startStateStepsInterpolationPoints = getStateStepInterpolationPoints(f, list, true);
        this.endStateStepsInterpolationPoints = getStateStepInterpolationPoints(f4, list2, false);
    }

    private KeylineState closestStateStepFromInterpolation(List<KeylineState> list, float f, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f, fArr);
        return stateStepsRange[0] >= 0.5f ? list.get((int) stateStepsRange[2]) : list.get((int) stateStepsRange[1]);
    }

    private static int findFirstIndexAfterLastFocalKeylineWithMask(KeylineState keylineState, float f) {
        for (int lastFocalKeylineIndex = keylineState.getLastFocalKeylineIndex(); lastFocalKeylineIndex < keylineState.getKeylines().size(); lastFocalKeylineIndex++) {
            if (f == keylineState.getKeylines().get(lastFocalKeylineIndex).mask) {
                return lastFocalKeylineIndex;
            }
        }
        return keylineState.getKeylines().size() - 1;
    }

    private static int findFirstNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int i8 = 0; i8 < keylineState.getKeylines().size(); i8++) {
            if (!keylineState.getKeylines().get(i8).isAnchor) {
                return i8;
            }
        }
        return -1;
    }

    private static int findLastIndexBeforeFirstFocalKeylineWithMask(KeylineState keylineState, float f) {
        for (int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - 1; firstFocalKeylineIndex >= 0; firstFocalKeylineIndex--) {
            if (f == keylineState.getKeylines().get(firstFocalKeylineIndex).mask) {
                return firstFocalKeylineIndex;
            }
        }
        return 0;
    }

    private static int findLastNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int size = keylineState.getKeylines().size() - 1; size >= 0; size--) {
            if (!keylineState.getKeylines().get(size).isAnchor) {
                return size;
            }
        }
        return -1;
    }

    public static KeylineStateList from(Carousel carousel, KeylineState keylineState, float f, float f4, float f10) {
        return new KeylineStateList(keylineState, getStateStepsStart(carousel, keylineState, f, f4), getStateStepsEnd(carousel, keylineState, f, f10));
    }

    private static float[] getStateStepInterpolationPoints(float f, List<KeylineState> list, boolean z2) {
        int size = list.size();
        float[] fArr = new float[size];
        int i8 = 1;
        while (i8 < size) {
            int i9 = i8 - 1;
            KeylineState keylineState = list.get(i9);
            KeylineState keylineState2 = list.get(i8);
            fArr[i8] = i8 == size + (-1) ? 1.0f : fArr[i9] + ((z2 ? keylineState2.getFirstKeyline().loc - keylineState.getFirstKeyline().loc : keylineState.getLastKeyline().loc - keylineState2.getLastKeyline().loc) / f);
            i8++;
        }
        return fArr;
    }

    private static List<KeylineState> getStateStepsEnd(Carousel carousel, KeylineState keylineState, float f, float f4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int iFindLastNonAnchorKeylineIndex = findLastNonAnchorKeylineIndex(keylineState);
        float containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        if (isLastFocalItemVisibleAtRightOfContainer(carousel, keylineState) || iFindLastNonAnchorKeylineIndex == -1) {
            if (f4 > 0.0f) {
                arrayList.add(shiftKeylineStateForPadding(keylineState, f4, containerWidth, false, f));
            }
            return arrayList;
        }
        int lastFocalKeylineIndex = iFindLastNonAnchorKeylineIndex - keylineState.getLastFocalKeylineIndex();
        float f10 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
        if (lastFocalKeylineIndex <= 0 && keylineState.getLastFocalKeyline().cutoff > 0.0f) {
            arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState, f10 - keylineState.getLastFocalKeyline().cutoff, containerWidth));
            return arrayList;
        }
        float f11 = 0.0f;
        int i8 = 0;
        while (i8 < lastFocalKeylineIndex) {
            KeylineState keylineState2 = (KeylineState) a.i(1, arrayList);
            int i9 = iFindLastNonAnchorKeylineIndex - i8;
            float f12 = f11 + keylineState.getKeylines().get(i9).cutoff;
            int i10 = i9 + 1;
            int i11 = i8;
            KeylineState keylineStateMoveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState2, iFindLastNonAnchorKeylineIndex, i10 < keylineState.getKeylines().size() ? findLastIndexBeforeFirstFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i10).mask) + 1 : 0, f10 - f12, keylineState.getFirstFocalKeylineIndex() + i8 + 1, keylineState.getLastFocalKeylineIndex() + i8 + 1, containerWidth);
            if (i11 == lastFocalKeylineIndex - 1 && f4 > 0.0f) {
                keylineStateMoveKeylineAndCreateKeylineState = shiftKeylineStateForPadding(keylineStateMoveKeylineAndCreateKeylineState, f4, containerWidth, false, f);
            }
            arrayList.add(keylineStateMoveKeylineAndCreateKeylineState);
            i8 = i11 + 1;
            f11 = f12;
        }
        return arrayList;
    }

    private static float[] getStateStepsRange(List<KeylineState> list, float f, float[] fArr) {
        int size = list.size();
        float f4 = fArr[0];
        int i8 = 1;
        while (i8 < size) {
            float f10 = fArr[i8];
            if (f <= f10) {
                return new float[]{AnimationUtils.lerp(0.0f, 1.0f, f4, f10, f), i8 - 1, i8};
            }
            i8++;
            f4 = f10;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private static List<KeylineState> getStateStepsStart(Carousel carousel, KeylineState keylineState, float f, float f4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int iFindFirstNonAnchorKeylineIndex = findFirstNonAnchorKeylineIndex(keylineState);
        float containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        int i8 = 1;
        if (isFirstFocalItemAtLeftOfContainer(keylineState) || iFindFirstNonAnchorKeylineIndex == -1) {
            if (f4 > 0.0f) {
                arrayList.add(shiftKeylineStateForPadding(keylineState, f4, containerWidth, true, f));
            }
            return arrayList;
        }
        int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - iFindFirstNonAnchorKeylineIndex;
        float f10 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
        if (firstFocalKeylineIndex <= 0 && keylineState.getFirstFocalKeyline().cutoff > 0.0f) {
            arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState, f10 + keylineState.getFirstFocalKeyline().cutoff, containerWidth));
            return arrayList;
        }
        int i9 = 0;
        float f11 = 0.0f;
        while (i9 < firstFocalKeylineIndex) {
            KeylineState keylineState2 = (KeylineState) a.i(i8, arrayList);
            int i10 = iFindFirstNonAnchorKeylineIndex + i9;
            int size = keylineState.getKeylines().size() - i8;
            float f12 = f11 + keylineState.getKeylines().get(i10).cutoff;
            int i11 = i10 - i8;
            int iFindFirstIndexAfterLastFocalKeylineWithMask = i11 >= 0 ? findFirstIndexAfterLastFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i11).mask) - i8 : size;
            int i12 = i9;
            KeylineState keylineStateMoveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState2, iFindFirstNonAnchorKeylineIndex, iFindFirstIndexAfterLastFocalKeylineWithMask, f10 + f12, (keylineState.getFirstFocalKeylineIndex() - i9) - 1, (keylineState.getLastFocalKeylineIndex() - i9) - 1, containerWidth);
            if (i12 == firstFocalKeylineIndex - 1 && f4 > 0.0f) {
                keylineStateMoveKeylineAndCreateKeylineState = shiftKeylineStateForPadding(keylineStateMoveKeylineAndCreateKeylineState, f4, containerWidth, true, f);
            }
            arrayList.add(keylineStateMoveKeylineAndCreateKeylineState);
            i9 = i12 + 1;
            f11 = f12;
            i8 = 1;
        }
        return arrayList;
    }

    private static boolean isFirstFocalItemAtLeftOfContainer(KeylineState keylineState) {
        return keylineState.getFirstFocalKeyline().locOffset - (keylineState.getFirstFocalKeyline().maskedItemSize / 2.0f) >= 0.0f && keylineState.getFirstFocalKeyline() == keylineState.getFirstNonAnchorKeyline();
    }

    private static boolean isLastFocalItemVisibleAtRightOfContainer(Carousel carousel, KeylineState keylineState) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        return (keylineState.getLastFocalKeyline().maskedItemSize / 2.0f) + keylineState.getLastFocalKeyline().locOffset <= ((float) containerHeight) && keylineState.getLastFocalKeyline() == keylineState.getLastNonAnchorKeyline();
    }

    private static KeylineState lerp(List<KeylineState> list, float f, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f, fArr);
        return KeylineState.lerp(list.get((int) stateStepsRange[1]), list.get((int) stateStepsRange[2]), stateStepsRange[0]);
    }

    private static KeylineState moveKeylineAndCreateKeylineState(KeylineState keylineState, int i8, int i9, float f, int i10, int i11, float f4) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        arrayList.add(i9, (KeylineState.Keyline) arrayList.remove(i8));
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), f4);
        int i12 = 0;
        while (i12 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i12);
            float f10 = keyline.maskedItemSize;
            builder.addKeyline((f10 / 2.0f) + f, keyline.mask, f10, i12 >= i10 && i12 <= i11, keyline.isAnchor, keyline.cutoff);
            f += keyline.maskedItemSize;
            i12++;
        }
        return builder.build();
    }

    private static KeylineState shiftKeylineStateForPadding(KeylineState keylineState, float f, float f4, boolean z2, float f10) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), f4);
        float numberOfNonAnchorKeylines = f / keylineState.getNumberOfNonAnchorKeylines();
        float f11 = z2 ? f : 0.0f;
        int i8 = 0;
        while (i8 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i8);
            if (keyline.isAnchor) {
                builder.addKeyline(keyline.locOffset, keyline.mask, keyline.maskedItemSize, false, true, keyline.cutoff);
            } else {
                boolean z3 = i8 >= keylineState.getFirstFocalKeylineIndex() && i8 <= keylineState.getLastFocalKeylineIndex();
                float f12 = keyline.maskedItemSize - numberOfNonAnchorKeylines;
                float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(f12, keylineState.getItemSize(), f10);
                float f13 = (f12 / 2.0f) + f11;
                float f14 = f13 - keyline.locOffset;
                builder.addKeyline(f13, childMaskPercentage, f12, z3, false, keyline.cutoff, z2 ? f14 : 0.0f, z2 ? 0.0f : f14);
                f11 += f12;
            }
            i8++;
        }
        return builder.build();
    }

    private static KeylineState shiftKeylinesAndCreateKeylineState(KeylineState keylineState, float f, float f4) {
        return moveKeylineAndCreateKeylineState(keylineState, 0, 0, f, keylineState.getFirstFocalKeylineIndex(), keylineState.getLastFocalKeylineIndex(), f4);
    }

    public KeylineState getDefaultState() {
        return this.defaultState;
    }

    public KeylineState getEndState() {
        return (KeylineState) a.j(1, this.endStateSteps);
    }

    public Map<Integer, KeylineState> getKeylineStateForPositionMap(int i8, int i9, int i10, boolean z2) {
        float itemSize = this.defaultState.getItemSize();
        HashMap map = new HashMap();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= i8) {
                break;
            }
            int i13 = z2 ? (i8 - i11) - 1 : i11;
            if (i13 * itemSize * (z2 ? -1 : 1) > i10 - this.endShiftRange || i11 >= i8 - this.endStateSteps.size()) {
                Integer numValueOf = Integer.valueOf(i13);
                List<KeylineState> list = this.endStateSteps;
                map.put(numValueOf, list.get(MathUtils.clamp(i12, 0, list.size() - 1)));
                i12++;
            }
            i11++;
        }
        int i14 = 0;
        for (int i15 = i8 - 1; i15 >= 0; i15--) {
            int i16 = z2 ? (i8 - i15) - 1 : i15;
            if (i16 * itemSize * (z2 ? -1 : 1) < i9 + this.startShiftRange || i15 < this.startStateSteps.size()) {
                Integer numValueOf2 = Integer.valueOf(i16);
                List<KeylineState> list2 = this.startStateSteps;
                map.put(numValueOf2, list2.get(MathUtils.clamp(i14, 0, list2.size() - 1)));
                i14++;
            }
        }
        return map;
    }

    public KeylineState getShiftedState(float f, float f4, float f10) {
        return getShiftedState(f, f4, f10, false);
    }

    public KeylineState getStartState() {
        return (KeylineState) a.j(1, this.startStateSteps);
    }

    public KeylineState getShiftedState(float f, float f4, float f10, boolean z2) {
        float fLerp;
        List<KeylineState> list;
        float[] fArr;
        float f11 = this.startShiftRange + f4;
        float f12 = f10 - this.endShiftRange;
        float f13 = getStartState().getFirstFocalKeyline().leftOrTopPaddingShift;
        float f14 = getEndState().getLastFocalKeyline().rightOrBottomPaddingShift;
        if (this.startShiftRange == f13) {
            f11 += f13;
        }
        if (this.endShiftRange == f14) {
            f12 -= f14;
        }
        if (f < f11) {
            fLerp = AnimationUtils.lerp(1.0f, 0.0f, f4, f11, f);
            list = this.startStateSteps;
            fArr = this.startStateStepsInterpolationPoints;
        } else {
            if (f <= f12) {
                return this.defaultState;
            }
            fLerp = AnimationUtils.lerp(0.0f, 1.0f, f12, f10, f);
            list = this.endStateSteps;
            fArr = this.endStateStepsInterpolationPoints;
        }
        return z2 ? closestStateStepFromInterpolation(list, fLerp, fArr) : lerp(list, fLerp, fArr);
    }
}
