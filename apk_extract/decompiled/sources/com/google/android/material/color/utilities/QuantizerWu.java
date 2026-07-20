package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import o.d;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerWu implements Quantizer {
    private static final int INDEX_BITS = 5;
    private static final int INDEX_COUNT = 33;
    private static final int TOTAL_SIZE = 35937;
    Box[] cubes;
    double[] moments;
    int[] momentsB;
    int[] momentsG;
    int[] momentsR;
    int[] weights;

    /* JADX INFO: renamed from: com.google.android.material.color.utilities.QuantizerWu$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction;

        static {
            int[] iArr = new int[Direction.values().length];
            $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction = iArr;
            try {
                iArr[Direction.RED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[Direction.GREEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[Direction.BLUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class CreateBoxesResult {
        int resultCount;

        public CreateBoxesResult(int i8, int i9) {
            this.resultCount = i9;
        }
    }

    public enum Direction {
        RED,
        GREEN,
        BLUE
    }

    public static final class MaximizeResult {
        int cutLocation;
        double maximum;

        public MaximizeResult(int i8, double d7) {
            this.cutLocation = i8;
            this.maximum = d7;
        }
    }

    public static int bottom(Box box, Direction direction, int[] iArr) {
        int i8;
        int i9;
        int i10 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[direction.ordinal()];
        if (i10 == 1) {
            i8 = (-iArr[getIndex(box.f2225r0, box.g1, box.b1)]) + iArr[getIndex(box.f2225r0, box.g1, box.f2224b0)] + iArr[getIndex(box.f2225r0, box.g0, box.b1)];
            i9 = iArr[getIndex(box.f2225r0, box.g0, box.f2224b0)];
        } else if (i10 == 2) {
            i8 = (-iArr[getIndex(box.f2226r1, box.g0, box.b1)]) + iArr[getIndex(box.f2226r1, box.g0, box.f2224b0)] + iArr[getIndex(box.f2225r0, box.g0, box.b1)];
            i9 = iArr[getIndex(box.f2225r0, box.g0, box.f2224b0)];
        } else {
            if (i10 != 3) {
                throw new IllegalArgumentException("unexpected direction " + direction);
            }
            i8 = (-iArr[getIndex(box.f2226r1, box.g1, box.f2224b0)]) + iArr[getIndex(box.f2226r1, box.g0, box.f2224b0)] + iArr[getIndex(box.f2225r0, box.g1, box.f2224b0)];
            i9 = iArr[getIndex(box.f2225r0, box.g0, box.f2224b0)];
        }
        return i8 - i9;
    }

    public static int getIndex(int i8, int i9, int i10) {
        return (i8 << 10) + (i8 << 6) + i8 + (i9 << 5) + i9 + i10;
    }

    public static int top(Box box, Direction direction, int i8, int[] iArr) {
        int i9;
        int i10;
        int i11 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[direction.ordinal()];
        if (i11 == 1) {
            i9 = (iArr[getIndex(i8, box.g1, box.b1)] - iArr[getIndex(i8, box.g1, box.f2224b0)]) - iArr[getIndex(i8, box.g0, box.b1)];
            i10 = iArr[getIndex(i8, box.g0, box.f2224b0)];
        } else if (i11 == 2) {
            i9 = (iArr[getIndex(box.f2226r1, i8, box.b1)] - iArr[getIndex(box.f2226r1, i8, box.f2224b0)]) - iArr[getIndex(box.f2225r0, i8, box.b1)];
            i10 = iArr[getIndex(box.f2225r0, i8, box.f2224b0)];
        } else {
            if (i11 != 3) {
                throw new IllegalArgumentException("unexpected direction " + direction);
            }
            i9 = (iArr[getIndex(box.f2226r1, box.g1, i8)] - iArr[getIndex(box.f2226r1, box.g0, i8)]) - iArr[getIndex(box.f2225r0, box.g1, i8)];
            i10 = iArr[getIndex(box.f2225r0, box.g0, i8)];
        }
        return i9 + i10;
    }

    public static int volume(Box box, int[] iArr) {
        return ((((((iArr[getIndex(box.f2226r1, box.g1, box.b1)] - iArr[getIndex(box.f2226r1, box.g1, box.f2224b0)]) - iArr[getIndex(box.f2226r1, box.g0, box.b1)]) + iArr[getIndex(box.f2226r1, box.g0, box.f2224b0)]) - iArr[getIndex(box.f2225r0, box.g1, box.b1)]) + iArr[getIndex(box.f2225r0, box.g1, box.f2224b0)]) + iArr[getIndex(box.f2225r0, box.g0, box.b1)]) - iArr[getIndex(box.f2225r0, box.g0, box.f2224b0)];
    }

    public void constructHistogram(Map<Integer, Integer> map) {
        this.weights = new int[TOTAL_SIZE];
        this.momentsR = new int[TOTAL_SIZE];
        this.momentsG = new int[TOTAL_SIZE];
        this.momentsB = new int[TOTAL_SIZE];
        this.moments = new double[TOTAL_SIZE];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            int iRedFromArgb = ColorUtils.redFromArgb(iIntValue);
            int iGreenFromArgb = ColorUtils.greenFromArgb(iIntValue);
            int iBlueFromArgb = ColorUtils.blueFromArgb(iIntValue);
            int index = getIndex((iRedFromArgb >> 3) + 1, (iGreenFromArgb >> 3) + 1, (iBlueFromArgb >> 3) + 1);
            int[] iArr = this.weights;
            iArr[index] = iArr[index] + iIntValue2;
            int[] iArr2 = this.momentsR;
            iArr2[index] = (iRedFromArgb * iIntValue2) + iArr2[index];
            int[] iArr3 = this.momentsG;
            iArr3[index] = (iGreenFromArgb * iIntValue2) + iArr3[index];
            int[] iArr4 = this.momentsB;
            iArr4[index] = (iBlueFromArgb * iIntValue2) + iArr4[index];
            double[] dArr = this.moments;
            dArr[index] = dArr[index] + ((double) d.a(iBlueFromArgb, iBlueFromArgb, (iGreenFromArgb * iGreenFromArgb) + (iRedFromArgb * iRedFromArgb), iIntValue2));
        }
    }

    public CreateBoxesResult createBoxes(int i8) {
        int i9;
        this.cubes = new Box[i8];
        for (int i10 = 0; i10 < i8; i10++) {
            this.cubes[i10] = new Box(null);
        }
        double[] dArr = new double[i8];
        Box box = this.cubes[0];
        box.f2226r1 = 32;
        box.g1 = 32;
        box.b1 = 32;
        int i11 = 0;
        int i12 = 1;
        while (i12 < i8) {
            Box[] boxArr = this.cubes;
            if (cut(boxArr[i11], boxArr[i12]).booleanValue()) {
                Box box2 = this.cubes[i11];
                dArr[i11] = box2.vol > 1 ? variance(box2) : 0.0d;
                Box box3 = this.cubes[i12];
                dArr[i12] = box3.vol > 1 ? variance(box3) : 0.0d;
            } else {
                dArr[i11] = 0.0d;
                i12--;
            }
            double d7 = dArr[0];
            int i13 = 0;
            for (int i14 = 1; i14 <= i12; i14++) {
                double d10 = dArr[i14];
                if (d10 > d7) {
                    i13 = i14;
                    d7 = d10;
                }
            }
            if (d7 <= 0.0d) {
                i9 = i12 + 1;
                return new CreateBoxesResult(i8, i9);
            }
            i12++;
            i11 = i13;
        }
        i9 = i8;
        return new CreateBoxesResult(i8, i9);
    }

    public void createMoments() {
        int i8 = 1;
        while (true) {
            int i9 = 33;
            if (i8 >= 33) {
                return;
            }
            int[] iArr = new int[33];
            int[] iArr2 = new int[33];
            int[] iArr3 = new int[33];
            int[] iArr4 = new int[33];
            double[] dArr = new double[33];
            int i10 = 1;
            while (i10 < i9) {
                int i11 = 0;
                int i12 = 0;
                double d7 = 0.0d;
                int i13 = 1;
                int i14 = 0;
                int i15 = 0;
                while (i13 < i9) {
                    int index = getIndex(i8, i10, i13);
                    int i16 = i11 + this.weights[index];
                    i14 += this.momentsR[index];
                    i15 += this.momentsG[index];
                    i12 += this.momentsB[index];
                    d7 += this.moments[index];
                    iArr[i13] = iArr[i13] + i16;
                    iArr2[i13] = iArr2[i13] + i14;
                    iArr3[i13] = iArr3[i13] + i15;
                    iArr4[i13] = iArr4[i13] + i12;
                    dArr[i13] = dArr[i13] + d7;
                    int index2 = getIndex(i8 - 1, i10, i13);
                    int[] iArr5 = this.weights;
                    iArr5[index] = iArr5[index2] + iArr[i13];
                    int[] iArr6 = this.momentsR;
                    iArr6[index] = iArr6[index2] + iArr2[i13];
                    int[] iArr7 = this.momentsG;
                    iArr7[index] = iArr7[index2] + iArr3[i13];
                    int[] iArr8 = this.momentsB;
                    iArr8[index] = iArr8[index2] + iArr4[i13];
                    double[] dArr2 = this.moments;
                    dArr2[index] = dArr2[index2] + dArr[i13];
                    i13++;
                    i11 = i16;
                    i9 = 33;
                }
                i10++;
                i9 = 33;
            }
            i8++;
        }
    }

    public List<Integer> createResult(int i8) {
        ArrayList arrayList = new ArrayList();
        for (int i9 = 0; i9 < i8; i9++) {
            Box box = this.cubes[i9];
            int iVolume = volume(box, this.weights);
            if (iVolume > 0) {
                int iVolume2 = volume(box, this.momentsR) / iVolume;
                int iVolume3 = volume(box, this.momentsG) / iVolume;
                arrayList.add(Integer.valueOf(((volume(box, this.momentsB) / iVolume) & 255) | ((iVolume2 & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((iVolume3 & 255) << 8)));
            }
        }
        return arrayList;
    }

    public Boolean cut(Box box, Box box2) {
        int iVolume = volume(box, this.momentsR);
        int iVolume2 = volume(box, this.momentsG);
        int iVolume3 = volume(box, this.momentsB);
        int iVolume4 = volume(box, this.weights);
        Direction direction = Direction.RED;
        MaximizeResult maximizeResultMaximize = maximize(box, direction, box.f2225r0 + 1, box.f2226r1, iVolume, iVolume2, iVolume3, iVolume4);
        Direction direction2 = Direction.GREEN;
        MaximizeResult maximizeResultMaximize2 = maximize(box, direction2, box.g0 + 1, box.g1, iVolume, iVolume2, iVolume3, iVolume4);
        Direction direction3 = Direction.BLUE;
        MaximizeResult maximizeResultMaximize3 = maximize(box, direction3, box.f2224b0 + 1, box.b1, iVolume, iVolume2, iVolume3, iVolume4);
        double d7 = maximizeResultMaximize.maximum;
        double d10 = maximizeResultMaximize2.maximum;
        double d11 = maximizeResultMaximize3.maximum;
        if (d7 < d10 || d7 < d11) {
            direction = (d10 < d7 || d10 < d11) ? direction3 : direction2;
        } else if (maximizeResultMaximize.cutLocation < 0) {
            return Boolean.FALSE;
        }
        box2.f2226r1 = box.f2226r1;
        box2.g1 = box.g1;
        box2.b1 = box.b1;
        int i8 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[direction.ordinal()];
        if (i8 == 1) {
            int i9 = maximizeResultMaximize.cutLocation;
            box.f2226r1 = i9;
            box2.f2225r0 = i9;
            box2.g0 = box.g0;
            box2.f2224b0 = box.f2224b0;
        } else if (i8 == 2) {
            int i10 = maximizeResultMaximize2.cutLocation;
            box.g1 = i10;
            box2.f2225r0 = box.f2225r0;
            box2.g0 = i10;
            box2.f2224b0 = box.f2224b0;
        } else if (i8 == 3) {
            int i11 = maximizeResultMaximize3.cutLocation;
            box.b1 = i11;
            box2.f2225r0 = box.f2225r0;
            box2.g0 = box.g0;
            box2.f2224b0 = i11;
        }
        box.vol = (box.b1 - box.f2224b0) * (box.g1 - box.g0) * (box.f2226r1 - box.f2225r0);
        box2.vol = (box2.b1 - box2.f2224b0) * (box2.g1 - box2.g0) * (box2.f2226r1 - box2.f2225r0);
        return Boolean.TRUE;
    }

    public MaximizeResult maximize(Box box, Direction direction, int i8, int i9, int i10, int i11, int i12, int i13) {
        int i14;
        QuantizerWu quantizerWu = this;
        Box box2 = box;
        Direction direction2 = direction;
        int iBottom = bottom(box2, direction2, quantizerWu.momentsR);
        int iBottom2 = bottom(box2, direction2, quantizerWu.momentsG);
        int iBottom3 = bottom(box2, direction2, quantizerWu.momentsB);
        int iBottom4 = bottom(box2, direction2, quantizerWu.weights);
        int i15 = -1;
        double d7 = 0.0d;
        int i16 = i8;
        while (i16 < i9) {
            int pVar = top(box2, direction2, i16, quantizerWu.momentsR) + iBottom;
            int pVar2 = top(box2, direction2, i16, quantizerWu.momentsG) + iBottom2;
            int pVar3 = top(box2, direction2, i16, quantizerWu.momentsB) + iBottom3;
            int pVar4 = top(box2, direction2, i16, quantizerWu.weights) + iBottom4;
            if (pVar4 == 0) {
                i14 = iBottom;
            } else {
                i14 = iBottom;
                double d10 = ((double) ((pVar3 * pVar3) + ((pVar2 * pVar2) + (pVar * pVar)))) / ((double) pVar4);
                int i17 = i10 - pVar;
                int i18 = i11 - pVar2;
                int i19 = i12 - pVar3;
                int i20 = i13 - pVar4;
                if (i20 != 0) {
                    double d11 = (((double) ((i19 * i19) + ((i18 * i18) + (i17 * i17)))) / ((double) i20)) + d10;
                    if (d11 > d7) {
                        d7 = d11;
                        i15 = i16;
                    }
                }
            }
            i16++;
            quantizerWu = this;
            box2 = box;
            direction2 = direction;
            iBottom = i14;
        }
        return new MaximizeResult(i15, d7);
    }

    @Override // com.google.android.material.color.utilities.Quantizer
    public QuantizerResult quantize(int[] iArr, int i8) {
        constructHistogram(new QuantizerMap().quantize(iArr, i8).colorToCount);
        createMoments();
        List<Integer> listCreateResult = createResult(createBoxes(i8).resultCount);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Integer num : listCreateResult) {
            num.intValue();
            linkedHashMap.put(num, 0);
        }
        return new QuantizerResult(linkedHashMap);
    }

    public double variance(Box box) {
        int iVolume = volume(box, this.momentsR);
        int iVolume2 = volume(box, this.momentsG);
        int iVolume3 = volume(box, this.momentsB);
        return (((((((this.moments[getIndex(box.f2226r1, box.g1, box.b1)] - this.moments[getIndex(box.f2226r1, box.g1, box.f2224b0)]) - this.moments[getIndex(box.f2226r1, box.g0, box.b1)]) + this.moments[getIndex(box.f2226r1, box.g0, box.f2224b0)]) - this.moments[getIndex(box.f2225r0, box.g1, box.b1)]) + this.moments[getIndex(box.f2225r0, box.g1, box.f2224b0)]) + this.moments[getIndex(box.f2225r0, box.g0, box.b1)]) - this.moments[getIndex(box.f2225r0, box.g0, box.f2224b0)]) - (((double) ((iVolume3 * iVolume3) + ((iVolume2 * iVolume2) + (iVolume * iVolume)))) / ((double) volume(box, this.weights)));
    }

    public static final class Box {

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        int f2224b0;
        int b1;
        int g0;
        int g1;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        int f2225r0;

        /* JADX INFO: renamed from: r1, reason: collision with root package name */
        int f2226r1;
        int vol;

        private Box() {
            this.f2225r0 = 0;
            this.f2226r1 = 0;
            this.g0 = 0;
            this.g1 = 0;
            this.f2224b0 = 0;
            this.b1 = 0;
            this.vol = 0;
        }

        public /* synthetic */ Box(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
