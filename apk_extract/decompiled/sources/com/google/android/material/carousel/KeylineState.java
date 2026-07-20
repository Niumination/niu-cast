package com.google.android.material.carousel;

import a1.a;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.utilities.Contrast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class KeylineState {
    private final int firstFocalKeylineIndex;
    private final float itemSize;
    private final List<Keyline> keylines;
    private final int lastFocalKeylineIndex;

    public static final class Builder {
        private static final int NO_INDEX = -1;
        private static final float UNKNOWN_LOC = Float.MIN_VALUE;
        private final float availableSpace;
        private final float itemSize;
        private Keyline tmpFirstFocalKeyline;
        private Keyline tmpLastFocalKeyline;
        private final List<Keyline> tmpKeylines = new ArrayList();
        private int firstFocalKeylineIndex = -1;
        private int lastFocalKeylineIndex = -1;
        private float lastKeylineMaskedSize = 0.0f;
        private int latestAnchorKeylineIndex = -1;

        public Builder(float f, float f4) {
            this.itemSize = f;
            this.availableSpace = f4;
        }

        private static float calculateKeylineLocationForItemPosition(float f, float f4, int i8, int i9) {
            return (i9 * f4) + (f - (i8 * f4));
        }

        @NonNull
        public Builder addAnchorKeyline(float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f4, float f10) {
            return addKeyline(f, f4, f10, false, true);
        }

        @NonNull
        public Builder addKeyline(float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f4, float f10, boolean z2) {
            return addKeyline(f, f4, f10, z2, false);
        }

        @NonNull
        public Builder addKeylineRange(float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f4, float f10, int i8) {
            return addKeylineRange(f, f4, f10, i8, false);
        }

        @NonNull
        public KeylineState build() {
            if (this.tmpFirstFocalKeyline == null) {
                throw new IllegalStateException("There must be a keyline marked as focal.");
            }
            ArrayList arrayList = new ArrayList();
            for (int i8 = 0; i8 < this.tmpKeylines.size(); i8++) {
                Keyline keyline = this.tmpKeylines.get(i8);
                arrayList.add(new Keyline(calculateKeylineLocationForItemPosition(this.tmpFirstFocalKeyline.locOffset, this.itemSize, this.firstFocalKeylineIndex, i8), keyline.locOffset, keyline.mask, keyline.maskedItemSize, keyline.isAnchor, keyline.cutoff, keyline.leftOrTopPaddingShift, keyline.rightOrBottomPaddingShift));
            }
            return new KeylineState(this.itemSize, arrayList, this.firstFocalKeylineIndex, this.lastFocalKeylineIndex);
        }

        @NonNull
        public Builder addKeyline(float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f4, float f10) {
            return addKeyline(f, f4, f10, false);
        }

        @NonNull
        public Builder addKeylineRange(float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f4, float f10, int i8, boolean z2) {
            if (i8 > 0 && f10 > 0.0f) {
                for (int i9 = 0; i9 < i8; i9++) {
                    addKeyline((i9 * f10) + f, f4, f10, z2);
                }
            }
            return this;
        }

        @NonNull
        public Builder addKeyline(float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f4, float f10, boolean z2, boolean z3, float f11, float f12, float f13) {
            if (f10 <= 0.0f) {
                return this;
            }
            if (z3) {
                if (!z2) {
                    int i8 = this.latestAnchorKeylineIndex;
                    if (i8 != -1 && i8 != 0) {
                        throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                    }
                    this.latestAnchorKeylineIndex = this.tmpKeylines.size();
                } else {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
            }
            Keyline keyline = new Keyline(Float.MIN_VALUE, f, f4, f10, z3, f11, f12, f13);
            if (z2) {
                if (this.tmpFirstFocalKeyline == null) {
                    this.tmpFirstFocalKeyline = keyline;
                    this.firstFocalKeylineIndex = this.tmpKeylines.size();
                }
                if (this.lastFocalKeylineIndex != -1 && this.tmpKeylines.size() - this.lastFocalKeylineIndex > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f10 == this.tmpFirstFocalKeyline.maskedItemSize) {
                    this.tmpLastFocalKeyline = keyline;
                    this.lastFocalKeylineIndex = this.tmpKeylines.size();
                } else {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
            } else {
                if (this.tmpFirstFocalKeyline == null && keyline.maskedItemSize < this.lastKeylineMaskedSize) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.tmpLastFocalKeyline != null && keyline.maskedItemSize > this.lastKeylineMaskedSize) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.lastKeylineMaskedSize = keyline.maskedItemSize;
            this.tmpKeylines.add(keyline);
            return this;
        }

        @NonNull
        public Builder addKeyline(float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f4, float f10, boolean z2, boolean z3, float f11) {
            return addKeyline(f, f4, f10, z2, z3, f11, 0.0f, 0.0f);
        }

        @NonNull
        public Builder addKeyline(float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f4, float f10, boolean z2, boolean z3) {
            float fAbs;
            float f11 = f10 / 2.0f;
            float f12 = f - f11;
            float f13 = f11 + f;
            float f14 = this.availableSpace;
            if (f13 > f14) {
                fAbs = Math.abs(f13 - Math.max(f13 - f10, f14));
            } else {
                fAbs = 0.0f;
                if (f12 < 0.0f) {
                    fAbs = Math.abs(f12 - Math.min(f12 + f10, 0.0f));
                }
            }
            return addKeyline(f, f4, f10, z2, z3, fAbs);
        }
    }

    public static final class Keyline {
        final float cutoff;
        final boolean isAnchor;
        final float leftOrTopPaddingShift;
        final float loc;
        final float locOffset;
        final float mask;
        final float maskedItemSize;
        final float rightOrBottomPaddingShift;

        public Keyline(float f, float f4, float f10, float f11) {
            this(f, f4, f10, f11, false, 0.0f, 0.0f, 0.0f);
        }

        public static Keyline lerp(Keyline keyline, Keyline keyline2, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f) {
            return new Keyline(AnimationUtils.lerp(keyline.loc, keyline2.loc, f), AnimationUtils.lerp(keyline.locOffset, keyline2.locOffset, f), AnimationUtils.lerp(keyline.mask, keyline2.mask, f), AnimationUtils.lerp(keyline.maskedItemSize, keyline2.maskedItemSize, f));
        }

        public Keyline(float f, float f4, float f10, float f11, boolean z2, float f12, float f13, float f14) {
            this.loc = f;
            this.locOffset = f4;
            this.mask = f10;
            this.maskedItemSize = f11;
            this.isAnchor = z2;
            this.cutoff = f12;
            this.leftOrTopPaddingShift = f13;
            this.rightOrBottomPaddingShift = f14;
        }
    }

    public static KeylineState lerp(KeylineState keylineState, KeylineState keylineState2, float f) {
        if (keylineState.getItemSize() != keylineState2.getItemSize()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
        }
        List<Keyline> keylines = keylineState.getKeylines();
        List<Keyline> keylines2 = keylineState2.getKeylines();
        if (keylines.size() != keylines2.size()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i8 = 0; i8 < keylineState.getKeylines().size(); i8++) {
            arrayList.add(Keyline.lerp(keylines.get(i8), keylines2.get(i8), f));
        }
        return new KeylineState(keylineState.getItemSize(), arrayList, AnimationUtils.lerp(keylineState.getFirstFocalKeylineIndex(), keylineState2.getFirstFocalKeylineIndex(), f), AnimationUtils.lerp(keylineState.getLastFocalKeylineIndex(), keylineState2.getLastFocalKeylineIndex(), f));
    }

    public static KeylineState reverse(KeylineState keylineState, float f) {
        Builder builder = new Builder(keylineState.getItemSize(), f);
        float f4 = (f - keylineState.getLastKeyline().locOffset) - (keylineState.getLastKeyline().maskedItemSize / 2.0f);
        int size = keylineState.getKeylines().size() - 1;
        while (size >= 0) {
            Keyline keyline = keylineState.getKeylines().get(size);
            builder.addKeyline((keyline.maskedItemSize / 2.0f) + f4, keyline.mask, keyline.maskedItemSize, size >= keylineState.getFirstFocalKeylineIndex() && size <= keylineState.getLastFocalKeylineIndex(), keyline.isAnchor);
            f4 += keyline.maskedItemSize;
            size--;
        }
        return builder.build();
    }

    public Keyline getFirstFocalKeyline() {
        return this.keylines.get(this.firstFocalKeylineIndex);
    }

    public int getFirstFocalKeylineIndex() {
        return this.firstFocalKeylineIndex;
    }

    public Keyline getFirstKeyline() {
        return this.keylines.get(0);
    }

    @Nullable
    public Keyline getFirstNonAnchorKeyline() {
        for (int i8 = 0; i8 < this.keylines.size(); i8++) {
            Keyline keyline = this.keylines.get(i8);
            if (!keyline.isAnchor) {
                return keyline;
            }
        }
        return null;
    }

    public List<Keyline> getFocalKeylines() {
        return this.keylines.subList(this.firstFocalKeylineIndex, this.lastFocalKeylineIndex + 1);
    }

    public float getItemSize() {
        return this.itemSize;
    }

    public List<Keyline> getKeylines() {
        return this.keylines;
    }

    public Keyline getLastFocalKeyline() {
        return this.keylines.get(this.lastFocalKeylineIndex);
    }

    public int getLastFocalKeylineIndex() {
        return this.lastFocalKeylineIndex;
    }

    public Keyline getLastKeyline() {
        return (Keyline) a.j(1, this.keylines);
    }

    @Nullable
    public Keyline getLastNonAnchorKeyline() {
        for (int size = this.keylines.size() - 1; size >= 0; size--) {
            Keyline keyline = this.keylines.get(size);
            if (!keyline.isAnchor) {
                return keyline;
            }
        }
        return null;
    }

    public int getNumberOfNonAnchorKeylines() {
        Iterator<Keyline> it = this.keylines.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            if (it.next().isAnchor) {
                i8++;
            }
        }
        return this.keylines.size() - i8;
    }

    private KeylineState(float f, List<Keyline> list, int i8, int i9) {
        this.itemSize = f;
        this.keylines = Collections.unmodifiableList(list);
        this.firstFocalKeylineIndex = i8;
        this.lastFocalKeylineIndex = i9;
    }
}
